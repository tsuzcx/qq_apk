package com.tencent.mm.plugin.appbrand.widget.g;

import android.content.Context;
import android.graphics.Rect;
import android.view.View;
import android.view.View.OnAttachStateChangeListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import androidx.core.g.w;
import com.tencent.luggage.wxa.a.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.jsapi.m;
import com.tencent.mm.plugin.appbrand.page.ad;
import com.tencent.mm.plugin.appbrand.page.ap;
import com.tencent.mm.plugin.appbrand.utils.ai;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Objects;
import org.apache.commons.b.a;

public final class b
{
  public final ad qoX;
  a rEg;
  public f rEh;
  
  public b(ad paramad)
  {
    this.qoX = paramad;
  }
  
  private a cpY()
  {
    AppMethodBeat.i(135500);
    if ((this.rEg != null) && (!a.a(this.rEg)))
    {
      localObject = this.rEg;
      AppMethodBeat.o(135500);
      return localObject;
    }
    this.rEg = null;
    Object localObject = this.qoX.qsz.ceU();
    int i = 0;
    while (i < ((ViewGroup)localObject).getChildCount())
    {
      View localView = ((ViewGroup)localObject).getChildAt(i);
      if ((localView instanceof a))
      {
        localObject = (a)localView;
        AppMethodBeat.o(135500);
        return localObject;
      }
      i += 1;
    }
    AppMethodBeat.o(135500);
    return null;
  }
  
  public static void cqc()
  {
    AppMethodBeat.i(135504);
    if (!ai.Or())
    {
      RuntimeException localRuntimeException = new RuntimeException("Should be called on main-thread");
      AppMethodBeat.o(135504);
      throw localRuntimeException;
    }
    AppMethodBeat.o(135504);
  }
  
  public final void Ei(int paramInt)
  {
    AppMethodBeat.i(135499);
    a locala = cpY();
    if ((locala != null) && ((locala.getLayoutParams() instanceof ViewGroup.MarginLayoutParams)))
    {
      ViewGroup.MarginLayoutParams localMarginLayoutParams = (ViewGroup.MarginLayoutParams)locala.getLayoutParams();
      if (paramInt != localMarginLayoutParams.topMargin)
      {
        localMarginLayoutParams.topMargin = paramInt;
        locala.requestLayout();
      }
    }
    AppMethodBeat.o(135499);
  }
  
  public final a cpZ()
  {
    AppMethodBeat.i(135501);
    ViewGroup localViewGroup = this.qoX.qsz.ceU();
    a locala2 = cpY();
    a locala1 = locala2;
    if (locala2 == null)
    {
      locala1 = new a(this.qoX.getContext());
      locala1.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener()
      {
        public final void onViewAttachedToWindow(View paramAnonymousView) {}
        
        public final void onViewDetachedFromWindow(View paramAnonymousView)
        {
          if (paramAnonymousView == b.this.rEg) {
            b.this.rEg = null;
          }
        }
      });
      localViewGroup.addView(locala1, -1, -1);
    }
    locala1.bringToFront();
    this.rEg = locala1;
    AppMethodBeat.o(135501);
    return locala1;
  }
  
  public final void cqa()
  {
    AppMethodBeat.i(135502);
    com.tencent.mm.plugin.appbrand.widget.actionbar.b localb = this.qoX.cdY();
    if (localb == null)
    {
      AppMethodBeat.o(135502);
      return;
    }
    int i = localb.getTop();
    Ei(localb.getMeasuredHeight() + i);
    AppMethodBeat.o(135502);
  }
  
  public final boolean cqb()
  {
    boolean bool3 = false;
    boolean bool1 = false;
    AppMethodBeat.i(135503);
    if (!this.qoX.isRunning())
    {
      AppMethodBeat.o(135503);
      return false;
    }
    cqc();
    a locala = this.rEg;
    boolean bool2 = bool3;
    if (locala != null)
    {
      bool2 = bool3;
      if (w.al(locala))
      {
        Object localObject = new LinkedList();
        int i = 0;
        View localView;
        while (i < locala.getChildCount())
        {
          localView = locala.getChildAt(i);
          if ((localView != null) && (Objects.equals(localView.getTag(a.d.app_brand_toast_view_tag), Boolean.TRUE))) {
            ((LinkedList)localObject).add(localView);
          }
          i += 1;
        }
        if (!((LinkedList)localObject).isEmpty()) {
          bool1 = true;
        }
        localObject = ((LinkedList)localObject).iterator();
        for (;;)
        {
          bool2 = bool1;
          if (!((Iterator)localObject).hasNext()) {
            break;
          }
          localView = (View)((Iterator)localObject).next();
          localView.setVisibility(8);
          locala.removeView(localView);
        }
      }
    }
    if ((bool2) && (this.qoX.getRuntime() != null)) {
      b.a(b.aq(this.qoX.getRuntime())).remove(this.qoX);
    }
    AppMethodBeat.o(135503);
    return bool2;
  }
  
  public final void dF(View paramView)
  {
    AppMethodBeat.i(246462);
    if ((!this.qoX.isRunning()) || (this.qoX.getRuntime() == null))
    {
      AppMethodBeat.o(246462);
      return;
    }
    cqc();
    a locala = cpZ();
    cqa();
    paramView.setTag(a.d.app_brand_toast_view_tag, Boolean.TRUE);
    locala.addView(paramView);
    b.a(b.aq(this.qoX.getRuntime())).add(this.qoX);
    AppMethodBeat.o(246462);
  }
  
  static final class a
    extends FrameLayout
  {
    private final Rect bvn;
    private final int[] rEj;
    private boolean rEk;
    
    public a(Context paramContext)
    {
      super();
      AppMethodBeat.i(135493);
      this.bvn = new Rect();
      this.rEj = new int[2];
      this.rEk = false;
      setWillNotDraw(true);
      AppMethodBeat.o(135493);
    }
    
    protected final ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
    {
      AppMethodBeat.i(135494);
      paramLayoutParams = (FrameLayout.LayoutParams)super.generateLayoutParams(paramLayoutParams);
      if (-1 == paramLayoutParams.gravity) {
        paramLayoutParams.gravity = 17;
      }
      AppMethodBeat.o(135494);
      return paramLayoutParams;
    }
    
    protected final void onAttachedToWindow()
    {
      AppMethodBeat.i(244162);
      super.onAttachedToWindow();
      this.rEk = false;
      AppMethodBeat.o(244162);
    }
    
    protected final void onDetachedFromWindow()
    {
      AppMethodBeat.i(244163);
      super.onDetachedFromWindow();
      this.rEk = true;
      AppMethodBeat.o(244163);
    }
    
    protected final void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    {
      AppMethodBeat.i(135497);
      super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
      if (!w.al(this))
      {
        AppMethodBeat.o(135497);
        return;
      }
      getWindowVisibleDisplayFrame(this.bvn);
      getLocationInWindow(this.rEj);
      if (Log.getLogLevel() <= 1) {
        Log.d("MicroMsg.PagePromptViewContainerLayout[keyboard]", "onLayout, WindowVisibleDisplayFrame=%s, location=%s", new Object[] { this.bvn, a.cG(this.rEj) });
      }
      paramInt1 = 0;
      while (paramInt1 < getChildCount())
      {
        View localView = getChildAt(paramInt1);
        paramInt2 = this.rEj[1] + localView.getTop() + localView.getHeight() - this.bvn.bottom;
        if (paramInt2 > 0)
        {
          paramInt2 = Math.max(0, localView.getTop() - paramInt2);
          localView.layout(localView.getLeft(), paramInt2, localView.getRight(), localView.getHeight() + paramInt2);
        }
        paramInt1 += 1;
      }
      AppMethodBeat.o(135497);
    }
    
    public final void onViewAdded(View paramView)
    {
      AppMethodBeat.i(135495);
      super.onViewAdded(paramView);
      bringToFront();
      bringChildToFront(paramView);
      AppMethodBeat.o(135495);
    }
    
    public final void onViewRemoved(View paramView)
    {
      AppMethodBeat.i(135496);
      super.onViewRemoved(paramView);
      if (getChildCount() == 0)
      {
        setVisibility(8);
        if ((getParent() instanceof ViewGroup)) {
          ((ViewGroup)getParent()).removeView(this);
        }
      }
      AppMethodBeat.o(135496);
    }
  }
  
  public static final class b
    implements m
  {
    public final LinkedList<ad> rEl;
    
    private b()
    {
      AppMethodBeat.i(164055);
      this.rEl = new LinkedList();
      AppMethodBeat.o(164055);
    }
    
    public static b aq(AppBrandRuntime paramAppBrandRuntime)
    {
      AppMethodBeat.i(164056);
      b localb2 = (b)paramAppBrandRuntime.av(b.class);
      b localb1 = localb2;
      if (localb2 == null)
      {
        localb1 = new b();
        paramAppBrandRuntime.a(localb1);
      }
      AppMethodBeat.o(164056);
      return localb1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.g.b
 * JD-Core Version:    0.7.0.1
 */