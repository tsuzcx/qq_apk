package com.tencent.mm.plugin.appbrand.widget.e;

import android.content.Context;
import android.graphics.Rect;
import android.support.v4.view.t;
import android.view.View;
import android.view.View.OnAttachStateChangeListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.jsapi.k;
import com.tencent.mm.plugin.appbrand.page.ar;
import com.tencent.mm.sdk.platformtools.ad;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Objects;
import org.apache.commons.b.a;

public final class b
{
  public final com.tencent.mm.plugin.appbrand.page.aa mkl;
  a mkm;
  public f mkn;
  
  public b(com.tencent.mm.plugin.appbrand.page.aa paramaa)
  {
    this.mkl = paramaa;
  }
  
  public static void buB()
  {
    AppMethodBeat.i(135504);
    if (!com.tencent.mm.plugin.appbrand.utils.aa.Be())
    {
      RuntimeException localRuntimeException = new RuntimeException("Should be called on main-thread");
      AppMethodBeat.o(135504);
      throw localRuntimeException;
    }
    AppMethodBeat.o(135504);
  }
  
  private a bux()
  {
    AppMethodBeat.i(135500);
    if ((this.mkm != null) && (t.aC(this.mkm)))
    {
      localObject = this.mkm;
      AppMethodBeat.o(135500);
      return localObject;
    }
    this.mkm = null;
    Object localObject = this.mkl.laW.bkr();
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
  
  public final boolean buA()
  {
    boolean bool3 = false;
    boolean bool1 = false;
    AppMethodBeat.i(135503);
    if (!this.mkl.isRunning())
    {
      AppMethodBeat.o(135503);
      return false;
    }
    buB();
    a locala = this.mkm;
    boolean bool2 = bool3;
    if (locala != null)
    {
      bool2 = bool3;
      if (t.aC(locala))
      {
        Object localObject = new LinkedList();
        int i = 0;
        View localView;
        while (i < locala.getChildCount())
        {
          localView = locala.getChildAt(i);
          if ((localView != null) && (Objects.equals(localView.getTag(2131296836), Boolean.TRUE))) {
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
    if ((bool2) && (this.mkl.getRuntime() != null)) {
      b.a(b.at(this.mkl.getRuntime())).remove(this.mkl);
    }
    AppMethodBeat.o(135503);
    return bool2;
  }
  
  public final a buy()
  {
    AppMethodBeat.i(135501);
    ViewGroup localViewGroup = this.mkl.laW.bkr();
    a locala2 = bux();
    a locala1 = locala2;
    if (locala2 == null)
    {
      locala1 = new a(this.mkl.getContext());
      locala1.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener()
      {
        public final void onViewAttachedToWindow(View paramAnonymousView) {}
        
        public final void onViewDetachedFromWindow(View paramAnonymousView)
        {
          if (paramAnonymousView == b.this.mkm) {
            b.this.mkm = null;
          }
        }
      });
      localViewGroup.addView(locala1, -1, -1);
    }
    locala1.bringToFront();
    this.mkm = locala1;
    AppMethodBeat.o(135501);
    return locala1;
  }
  
  public final void buz()
  {
    AppMethodBeat.i(135502);
    com.tencent.mm.plugin.appbrand.widget.actionbar.b localb = this.mkl.bjH();
    if (localb == null)
    {
      AppMethodBeat.o(135502);
      return;
    }
    int i = localb.getTop();
    vs(localb.getMeasuredHeight() + i);
    AppMethodBeat.o(135502);
  }
  
  public final void dp(View paramView)
  {
    AppMethodBeat.i(194547);
    if ((!this.mkl.isRunning()) || (this.mkl.getRuntime() == null))
    {
      AppMethodBeat.o(194547);
      return;
    }
    buB();
    a locala = buy();
    buz();
    paramView.setTag(2131296836, Boolean.TRUE);
    locala.addView(paramView);
    b.a(b.at(this.mkl.getRuntime())).add(this.mkl);
    AppMethodBeat.o(194547);
  }
  
  public final void vs(int paramInt)
  {
    AppMethodBeat.i(135499);
    a locala = bux();
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
  
  static final class a
    extends FrameLayout
  {
    private final Rect jL;
    private final int[] mkp;
    
    public a(Context paramContext)
    {
      super();
      AppMethodBeat.i(135493);
      this.jL = new Rect();
      this.mkp = new int[2];
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
    
    protected final void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    {
      AppMethodBeat.i(135497);
      super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
      if (!t.aC(this))
      {
        AppMethodBeat.o(135497);
        return;
      }
      getWindowVisibleDisplayFrame(this.jL);
      getLocationInWindow(this.mkp);
      if (ad.getLogLevel() <= 1) {
        ad.d("MicroMsg.PagePromptViewContainerLayout[keyboard]", "onLayout, WindowVisibleDisplayFrame=%s, location=%s", new Object[] { this.jL, a.toString(this.mkp) });
      }
      paramInt1 = 0;
      while (paramInt1 < getChildCount())
      {
        View localView = getChildAt(paramInt1);
        paramInt2 = this.mkp[1] + localView.getTop() + localView.getHeight() - this.jL.bottom;
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
    implements k
  {
    public final LinkedList<com.tencent.mm.plugin.appbrand.page.aa> mkq;
    
    private b()
    {
      AppMethodBeat.i(164055);
      this.mkq = new LinkedList();
      AppMethodBeat.o(164055);
    }
    
    public static b at(AppBrandRuntime paramAppBrandRuntime)
    {
      AppMethodBeat.i(164056);
      b localb2 = (b)paramAppBrandRuntime.as(b.class);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.e.b
 * JD-Core Version:    0.7.0.1
 */