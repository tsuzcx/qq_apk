package com.tencent.kinda.framework.widget.base;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup.MarginLayoutParams;
import com.tencent.kinda.framework.widget.tools.KindaContext;
import com.tencent.kinda.framework.widget.tools.MMKViewUtil;
import com.tencent.kinda.gen.KScrollView;
import com.tencent.kinda.gen.KScrollViewOnScrollCallback;
import com.tencent.kinda.gen.KView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.wallet_core.ui.MMScrollView;
import java.util.ArrayList;

public class MMKScrollView
  extends MMKViewLayout<MMScrollView>
  implements KScrollView
{
  public void addView(KView paramKView, int paramInt)
  {
    AppMethodBeat.i(144958);
    if ((paramKView instanceof MMKViewLayout)) {
      ab.a("MMKViewLayout", "%s addView: %s, childCount: %s %s", new Object[] { this, paramKView, Integer.valueOf(((MMKViewLayout)paramKView).childList.size()), Integer.valueOf(this.childList.size()) });
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
        localMarginLayoutParams.topMargin = ((int)MMKViewUtil.dpToPx(KindaContext.get(), f3));
        localMarginLayoutParams.bottomMargin = ((int)MMKViewUtil.dpToPx(KindaContext.get(), f4));
        localMarginLayoutParams.leftMargin = ((int)MMKViewUtil.dpToPx(KindaContext.get(), f1));
        localMarginLayoutParams.rightMargin = ((int)MMKViewUtil.dpToPx(KindaContext.get(), f2));
        ((MMKView)paramKView).getView().setLayoutParams(localMarginLayoutParams);
      }
      AppMethodBeat.o(144958);
      return;
      ab.a("MMKViewLayout", "%s addView: %s, childCount: %s", new Object[] { this, paramKView, Integer.valueOf(this.childList.size()) });
    }
  }
  
  public MMScrollView createView(Context paramContext)
  {
    AppMethodBeat.i(144954);
    paramContext = new MMScrollView(paramContext);
    paramContext.setFillViewport(true);
    AppMethodBeat.o(144954);
    return paramContext;
  }
  
  public boolean getScrollToDimissKeyboardEnabled()
  {
    return false;
  }
  
  public boolean getShowScrollBar()
  {
    AppMethodBeat.i(144956);
    boolean bool = ((MMScrollView)getView()).isVerticalScrollBarEnabled();
    AppMethodBeat.o(144956);
    return bool;
  }
  
  public boolean getVertical()
  {
    return false;
  }
  
  public void removeView(KView paramKView)
  {
    AppMethodBeat.i(144959);
    this.childList.remove(((MMKView)paramKView).getView());
    ((MMScrollView)getView()).removeView(((MMKView)paramKView).getView());
    AppMethodBeat.o(144959);
  }
  
  public void scrollTo(KView paramKView) {}
  
  public void setContent(KView paramKView) {}
  
  public void setContentInsect(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4) {}
  
  public void setOnScrollCallback(KScrollViewOnScrollCallback paramKScrollViewOnScrollCallback)
  {
    AppMethodBeat.i(144957);
    if (paramKScrollViewOnScrollCallback != null) {
      ((MMScrollView)getView()).setOnScrollListener(new MMKScrollView.1(this, paramKScrollViewOnScrollCallback));
    }
    AppMethodBeat.o(144957);
  }
  
  public void setScrollToDimissKeyboardEnabled(boolean paramBoolean) {}
  
  public void setShowScrollBar(boolean paramBoolean)
  {
    AppMethodBeat.i(144955);
    ((MMScrollView)getView()).setVerticalScrollBarEnabled(paramBoolean);
    AppMethodBeat.o(144955);
  }
  
  public void setVertical(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.kinda.framework.widget.base.MMKScrollView
 * JD-Core Version:    0.7.0.1
 */