package com.tencent.mm.plugin.appbrand.widget.f;

import android.content.Context;
import android.graphics.Rect;
import android.support.v4.view.u;
import android.view.View;
import android.view.View.OnAttachStateChangeListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.jsapi.n;
import com.tencent.mm.plugin.appbrand.page.ac;
import com.tencent.mm.plugin.appbrand.page.ao;
import com.tencent.mm.plugin.appbrand.utils.ag;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Objects;
import org.apache.commons.b.a;

public final class b
{
  public final ac nnq;
  a oBx;
  public f oBy;
  
  public b(ac paramac)
  {
    this.nnq = paramac;
  }
  
  private a ccH()
  {
    AppMethodBeat.i(135500);
    if ((this.oBx != null) && (!a.a(this.oBx)))
    {
      localObject = this.oBx;
      AppMethodBeat.o(135500);
      return localObject;
    }
    this.oBx = null;
    Object localObject = this.nnq.nqN.bRX();
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
  
  public static void ccL()
  {
    AppMethodBeat.i(135504);
    if (!ag.LB())
    {
      RuntimeException localRuntimeException = new RuntimeException("Should be called on main-thread");
      AppMethodBeat.o(135504);
      throw localRuntimeException;
    }
    AppMethodBeat.o(135504);
  }
  
  public final void AB(int paramInt)
  {
    AppMethodBeat.i(135499);
    a locala = ccH();
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
  
  public final a ccI()
  {
    AppMethodBeat.i(135501);
    ViewGroup localViewGroup = this.nnq.nqN.bRX();
    a locala2 = ccH();
    a locala1 = locala2;
    if (locala2 == null)
    {
      locala1 = new a(this.nnq.getContext());
      locala1.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener()
      {
        public final void onViewAttachedToWindow(View paramAnonymousView) {}
        
        public final void onViewDetachedFromWindow(View paramAnonymousView)
        {
          if (paramAnonymousView == b.this.oBx) {
            b.this.oBx = null;
          }
        }
      });
      localViewGroup.addView(locala1, -1, -1);
    }
    locala1.bringToFront();
    this.oBx = locala1;
    AppMethodBeat.o(135501);
    return locala1;
  }
  
  public final void ccJ()
  {
    AppMethodBeat.i(135502);
    com.tencent.mm.plugin.appbrand.widget.actionbar.b localb = this.nnq.bRi();
    if (localb == null)
    {
      AppMethodBeat.o(135502);
      return;
    }
    int i = localb.getTop();
    AB(localb.getMeasuredHeight() + i);
    AppMethodBeat.o(135502);
  }
  
  public final boolean ccK()
  {
    boolean bool3 = false;
    boolean bool1 = false;
    AppMethodBeat.i(135503);
    if (!this.nnq.isRunning())
    {
      AppMethodBeat.o(135503);
      return false;
    }
    ccL();
    a locala = this.oBx;
    boolean bool2 = bool3;
    if (locala != null)
    {
      bool2 = bool3;
      if (u.aD(locala))
      {
        Object localObject = new LinkedList();
        int i = 0;
        View localView;
        while (i < locala.getChildCount())
        {
          localView = locala.getChildAt(i);
          if ((localView != null) && (Objects.equals(localView.getTag(2131296928), Boolean.TRUE))) {
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
    if ((bool2) && (this.nnq.getRuntime() != null)) {
      b.a(b.ao(this.nnq.getRuntime())).remove(this.nnq);
    }
    AppMethodBeat.o(135503);
    return bool2;
  }
  
  public final void dk(View paramView)
  {
    AppMethodBeat.i(219634);
    if ((!this.nnq.isRunning()) || (this.nnq.getRuntime() == null))
    {
      AppMethodBeat.o(219634);
      return;
    }
    ccL();
    a locala = ccI();
    ccJ();
    paramView.setTag(2131296928, Boolean.TRUE);
    locala.addView(paramView);
    b.a(b.ao(this.nnq.getRuntime())).add(this.nnq);
    AppMethodBeat.o(219634);
  }
  
  static final class a
    extends FrameLayout
  {
    private final Rect mC;
    private final int[] oBA;
    private boolean oBB;
    
    public a(Context paramContext)
    {
      super();
      AppMethodBeat.i(135493);
      this.mC = new Rect();
      this.oBA = new int[2];
      this.oBB = false;
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
      AppMethodBeat.i(219632);
      super.onAttachedToWindow();
      this.oBB = false;
      AppMethodBeat.o(219632);
    }
    
    protected final void onDetachedFromWindow()
    {
      AppMethodBeat.i(219633);
      super.onDetachedFromWindow();
      this.oBB = true;
      AppMethodBeat.o(219633);
    }
    
    protected final void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    {
      AppMethodBeat.i(135497);
      super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
      if (!u.aD(this))
      {
        AppMethodBeat.o(135497);
        return;
      }
      getWindowVisibleDisplayFrame(this.mC);
      getLocationInWindow(this.oBA);
      if (Log.getLogLevel() <= 1) {
        Log.d("MicroMsg.PagePromptViewContainerLayout[keyboard]", "onLayout, WindowVisibleDisplayFrame=%s, location=%s", new Object[] { this.mC, a.toString(this.oBA) });
      }
      paramInt1 = 0;
      while (paramInt1 < getChildCount())
      {
        View localView = getChildAt(paramInt1);
        paramInt2 = this.oBA[1] + localView.getTop() + localView.getHeight() - this.mC.bottom;
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
    implements n
  {
    public final LinkedList<ac> oBC;
    
    private b()
    {
      AppMethodBeat.i(164055);
      this.oBC = new LinkedList();
      AppMethodBeat.o(164055);
    }
    
    public static b ao(AppBrandRuntime paramAppBrandRuntime)
    {
      AppMethodBeat.i(164056);
      b localb2 = (b)paramAppBrandRuntime.aw(b.class);
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
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.f.b
 * JD-Core Version:    0.7.0.1
 */