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
import com.tencent.mm.plugin.appbrand.page.al;
import com.tencent.mm.plugin.appbrand.page.z;
import com.tencent.mm.plugin.appbrand.utils.ag;
import com.tencent.mm.sdk.platformtools.ae;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Objects;
import org.apache.commons.b.a;

public final class b
{
  public final z nrR;
  a nrS;
  public f nrT;
  
  public b(z paramz)
  {
    this.nrR = paramz;
  }
  
  private a bGr()
  {
    AppMethodBeat.i(135500);
    if ((this.nrS != null) && (!a.a(this.nrS)))
    {
      localObject = this.nrS;
      AppMethodBeat.o(135500);
      return localObject;
    }
    this.nrS = null;
    Object localObject = this.nrR.mgp.bvS();
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
  
  public static void bGv()
  {
    AppMethodBeat.i(135504);
    if (!ag.Ck())
    {
      RuntimeException localRuntimeException = new RuntimeException("Should be called on main-thread");
      AppMethodBeat.o(135504);
      throw localRuntimeException;
    }
    AppMethodBeat.o(135504);
  }
  
  public final a bGs()
  {
    AppMethodBeat.i(135501);
    ViewGroup localViewGroup = this.nrR.mgp.bvS();
    a locala2 = bGr();
    a locala1 = locala2;
    if (locala2 == null)
    {
      locala1 = new a(this.nrR.getContext());
      locala1.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener()
      {
        public final void onViewAttachedToWindow(View paramAnonymousView) {}
        
        public final void onViewDetachedFromWindow(View paramAnonymousView)
        {
          if (paramAnonymousView == b.this.nrS) {
            b.this.nrS = null;
          }
        }
      });
      localViewGroup.addView(locala1, -1, -1);
    }
    locala1.bringToFront();
    this.nrS = locala1;
    AppMethodBeat.o(135501);
    return locala1;
  }
  
  public final void bGt()
  {
    AppMethodBeat.i(135502);
    com.tencent.mm.plugin.appbrand.widget.actionbar.b localb = this.nrR.bvi();
    if (localb == null)
    {
      AppMethodBeat.o(135502);
      return;
    }
    int i = localb.getTop();
    wT(localb.getMeasuredHeight() + i);
    AppMethodBeat.o(135502);
  }
  
  public final boolean bGu()
  {
    boolean bool3 = false;
    boolean bool1 = false;
    AppMethodBeat.i(135503);
    if (!this.nrR.isRunning())
    {
      AppMethodBeat.o(135503);
      return false;
    }
    bGv();
    a locala = this.nrS;
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
    if ((bool2) && (this.nrR.getRuntime() != null)) {
      b.a(b.an(this.nrR.getRuntime())).remove(this.nrR);
    }
    AppMethodBeat.o(135503);
    return bool2;
  }
  
  public final void dt(View paramView)
  {
    AppMethodBeat.i(208027);
    if ((!this.nrR.isRunning()) || (this.nrR.getRuntime() == null))
    {
      AppMethodBeat.o(208027);
      return;
    }
    bGv();
    a locala = bGs();
    bGt();
    paramView.setTag(2131296836, Boolean.TRUE);
    locala.addView(paramView);
    b.a(b.an(this.nrR.getRuntime())).add(this.nrR);
    AppMethodBeat.o(208027);
  }
  
  public final void wT(int paramInt)
  {
    AppMethodBeat.i(135499);
    a locala = bGr();
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
    private final Rect mA;
    private final int[] nrV;
    private boolean nrW;
    
    public a(Context paramContext)
    {
      super();
      AppMethodBeat.i(135493);
      this.mA = new Rect();
      this.nrV = new int[2];
      this.nrW = false;
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
      AppMethodBeat.i(208025);
      super.onAttachedToWindow();
      this.nrW = false;
      AppMethodBeat.o(208025);
    }
    
    protected final void onDetachedFromWindow()
    {
      AppMethodBeat.i(208026);
      super.onDetachedFromWindow();
      this.nrW = true;
      AppMethodBeat.o(208026);
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
      getWindowVisibleDisplayFrame(this.mA);
      getLocationInWindow(this.nrV);
      if (ae.getLogLevel() <= 1) {
        ae.d("MicroMsg.PagePromptViewContainerLayout[keyboard]", "onLayout, WindowVisibleDisplayFrame=%s, location=%s", new Object[] { this.mA, a.toString(this.nrV) });
      }
      paramInt1 = 0;
      while (paramInt1 < getChildCount())
      {
        View localView = getChildAt(paramInt1);
        paramInt2 = this.nrV[1] + localView.getTop() + localView.getHeight() - this.mA.bottom;
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
    public final LinkedList<z> nrX;
    
    private b()
    {
      AppMethodBeat.i(164055);
      this.nrX = new LinkedList();
      AppMethodBeat.o(164055);
    }
    
    public static b an(AppBrandRuntime paramAppBrandRuntime)
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.e.b
 * JD-Core Version:    0.7.0.1
 */