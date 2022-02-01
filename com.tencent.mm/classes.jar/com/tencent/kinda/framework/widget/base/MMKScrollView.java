package com.tencent.kinda.framework.widget.base;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup.MarginLayoutParams;
import com.tencent.kinda.framework.widget.tools.KindaContext;
import com.tencent.kinda.framework.widget.tools.MMKViewUtil;
import com.tencent.kinda.gen.KPoint;
import com.tencent.kinda.gen.KScrollView;
import com.tencent.kinda.gen.KScrollViewOnScrollCallback;
import com.tencent.kinda.gen.KView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.wallet_core.ui.MMScrollView;
import com.tencent.mm.wallet_core.ui.MMScrollView.a;
import java.util.ArrayList;

public class MMKScrollView
  extends MMKViewLayout<MMScrollView>
  implements KScrollView
{
  public void addView(KView paramKView, int paramInt)
  {
    AppMethodBeat.i(19117);
    if ((paramKView instanceof MMKViewLayout)) {
      ad.l("MMKViewLayout", "%s addView: %s, childCount: %s %s", new Object[] { this, paramKView, Integer.valueOf(((MMKViewLayout)paramKView).childList.size()), Integer.valueOf(this.childList.size()) });
    }
    for (;;)
    {
      this.childList.add((MMKView)paramKView);
      ((MMScrollView)getView()).addView(((MMKView)paramKView).getView());
      float f1 = paramKView.getMarginLeft();
      float f2 = paramKView.getMarginRight();
      float f3 = paramKView.getMarginTop();
      float f4 = paramKView.getMarginBottom();
      if ((((MMKView)paramKView).getView().getLayoutParams() instanceof ViewGroup.MarginLayoutParams))
      {
        ViewGroup.MarginLayoutParams localMarginLayoutParams = (ViewGroup.MarginLayoutParams)((MMKView)paramKView).getView().getLayoutParams();
        localMarginLayoutParams.topMargin = ((int)MMKViewUtil.dpToPx(this.mContext, f3));
        localMarginLayoutParams.bottomMargin = ((int)MMKViewUtil.dpToPx(this.mContext, f4));
        localMarginLayoutParams.leftMargin = ((int)MMKViewUtil.dpToPx(this.mContext, f1));
        localMarginLayoutParams.rightMargin = ((int)MMKViewUtil.dpToPx(this.mContext, f2));
        ((MMKView)paramKView).getView().setLayoutParams(localMarginLayoutParams);
      }
      AppMethodBeat.o(19117);
      return;
      ad.l("MMKViewLayout", "%s addView: %s, childCount: %s", new Object[] { this, paramKView, Integer.valueOf(this.childList.size()) });
    }
  }
  
  public MMScrollView createView(Context paramContext)
  {
    AppMethodBeat.i(19113);
    paramContext = new MMScrollView(paramContext);
    paramContext.setFillViewport(true);
    AppMethodBeat.o(19113);
    return paramContext;
  }
  
  public KPoint getContentOffset()
  {
    AppMethodBeat.i(186445);
    int i = a.ar(((MMScrollView)getView()).getContext(), ((MMScrollView)getView()).getScrollX());
    int j = a.ar(((MMScrollView)getView()).getContext(), ((MMScrollView)getView()).getScrollY());
    KPoint localKPoint = new KPoint(i, j);
    ad.l("MMKViewLayout", "getContentOffset  X: %s, Y: %s", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
    AppMethodBeat.o(186445);
    return localKPoint;
  }
  
  public float getHeight()
  {
    AppMethodBeat.i(186448);
    if (KindaContext.get() != null)
    {
      DisplayMetrics localDisplayMetrics = KindaContext.get().getResources().getDisplayMetrics();
      int i = a.ar(((MMScrollView)getView()).getContext(), ((MMScrollView)getView()).getHeight());
      int j = a.ar(((MMScrollView)getView()).getContext(), localDisplayMetrics.heightPixels);
      ad.l("MMKViewLayout", "getView() - %s scroolviewheight: %s,screenheight: %s", new Object[] { this, Integer.valueOf(i), Integer.valueOf(j) });
      float f = Math.min(i, j);
      AppMethodBeat.o(186448);
      return f;
    }
    AppMethodBeat.o(186448);
    return 0.0F;
  }
  
  public boolean getScrollToDimissKeyboardEnabled()
  {
    return false;
  }
  
  public boolean getShowScrollBar()
  {
    AppMethodBeat.i(19115);
    boolean bool = ((MMScrollView)getView()).isVerticalScrollBarEnabled();
    AppMethodBeat.o(19115);
    return bool;
  }
  
  public boolean getVertical()
  {
    return false;
  }
  
  public void removeView(KView paramKView)
  {
    AppMethodBeat.i(19118);
    this.childList.remove(((MMKView)paramKView).getView());
    ((MMScrollView)getView()).removeView(((MMKView)paramKView).getView());
    AppMethodBeat.o(19118);
  }
  
  public void scrollTo(KView paramKView) {}
  
  public void setContent(KView paramKView) {}
  
  public void setContentInsect(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4) {}
  
  public void setContentOffset(KPoint paramKPoint)
  {
    AppMethodBeat.i(186446);
    int i = a.fromDPToPix(((MMScrollView)getView()).getContext(), (int)paramKPoint.getX());
    int j = a.fromDPToPix(((MMScrollView)getView()).getContext(), (int)paramKPoint.getY());
    ((MMScrollView)getView()).scrollBy(i, j);
    ad.l("MMKViewLayout", "setContentOffset  X: %s, Y: %s", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
    AppMethodBeat.o(186446);
  }
  
  public void setContentOffset(KPoint paramKPoint, boolean paramBoolean)
  {
    AppMethodBeat.i(186447);
    setContentOffset(paramKPoint);
    AppMethodBeat.o(186447);
  }
  
  public void setOnScrollCallback(final KScrollViewOnScrollCallback paramKScrollViewOnScrollCallback)
  {
    AppMethodBeat.i(19116);
    if (paramKScrollViewOnScrollCallback != null) {
      ((MMScrollView)getView()).setOnScrollListener(new MMScrollView.a()
      {
        public void onScrollChange(View paramAnonymousView, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3, int paramAnonymousInt4)
        {
          AppMethodBeat.i(19112);
          paramKScrollViewOnScrollCallback.onScroll(paramAnonymousInt1, paramAnonymousInt2);
          AppMethodBeat.o(19112);
        }
      });
    }
    AppMethodBeat.o(19116);
  }
  
  public void setScrollToDimissKeyboardEnabled(boolean paramBoolean) {}
  
  public void setShowScrollBar(boolean paramBoolean)
  {
    AppMethodBeat.i(19114);
    ((MMScrollView)getView()).setVerticalScrollBarEnabled(paramBoolean);
    AppMethodBeat.o(19114);
  }
  
  public void setVertical(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.kinda.framework.widget.base.MMKScrollView
 * JD-Core Version:    0.7.0.1
 */