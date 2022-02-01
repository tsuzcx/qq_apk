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
import com.tencent.mm.plugin.appbrand.page.aa;
import com.tencent.mm.plugin.appbrand.page.am;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Objects;
import org.apache.commons.b.a;

public final class b
{
  public final aa nmH;
  a nmI;
  public f nmJ;
  
  public b(aa paramaa)
  {
    this.nmH = paramaa;
  }
  
  public static void bFA()
  {
    AppMethodBeat.i(135504);
    if (!com.tencent.mm.plugin.appbrand.utils.ad.Ch())
    {
      RuntimeException localRuntimeException = new RuntimeException("Should be called on main-thread");
      AppMethodBeat.o(135504);
      throw localRuntimeException;
    }
    AppMethodBeat.o(135504);
  }
  
  private a bFw()
  {
    AppMethodBeat.i(135500);
    if ((this.nmI != null) && (!a.a(this.nmI)))
    {
      localObject = this.nmI;
      AppMethodBeat.o(135500);
      return localObject;
    }
    this.nmI = null;
    Object localObject = this.nmH.mbW.bvh();
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
  
  public final a bFx()
  {
    AppMethodBeat.i(135501);
    ViewGroup localViewGroup = this.nmH.mbW.bvh();
    a locala2 = bFw();
    a locala1 = locala2;
    if (locala2 == null)
    {
      locala1 = new a(this.nmH.getContext());
      locala1.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener()
      {
        public final void onViewAttachedToWindow(View paramAnonymousView) {}
        
        public final void onViewDetachedFromWindow(View paramAnonymousView)
        {
          if (paramAnonymousView == b.this.nmI) {
            b.this.nmI = null;
          }
        }
      });
      localViewGroup.addView(locala1, -1, -1);
    }
    locala1.bringToFront();
    this.nmI = locala1;
    AppMethodBeat.o(135501);
    return locala1;
  }
  
  public final void bFy()
  {
    AppMethodBeat.i(135502);
    com.tencent.mm.plugin.appbrand.widget.actionbar.b localb = this.nmH.bux();
    if (localb == null)
    {
      AppMethodBeat.o(135502);
      return;
    }
    int i = localb.getTop();
    wO(localb.getMeasuredHeight() + i);
    AppMethodBeat.o(135502);
  }
  
  public final boolean bFz()
  {
    boolean bool3 = false;
    boolean bool1 = false;
    AppMethodBeat.i(135503);
    if (!this.nmH.isRunning())
    {
      AppMethodBeat.o(135503);
      return false;
    }
    bFA();
    a locala = this.nmI;
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
    if ((bool2) && (this.nmH.getRuntime() != null)) {
      b.b.a(b.b.an(this.nmH.getRuntime())).remove(this.nmH);
    }
    AppMethodBeat.o(135503);
    return bool2;
  }
  
  public final void dt(View paramView)
  {
    AppMethodBeat.i(197472);
    if ((!this.nmH.isRunning()) || (this.nmH.getRuntime() == null))
    {
      AppMethodBeat.o(197472);
      return;
    }
    bFA();
    a locala = bFx();
    bFy();
    paramView.setTag(2131296836, Boolean.TRUE);
    locala.addView(paramView);
    b.b.a(b.b.an(this.nmH.getRuntime())).add(this.nmH);
    AppMethodBeat.o(197472);
  }
  
  public final void wO(int paramInt)
  {
    AppMethodBeat.i(135499);
    a locala = bFw();
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
    private final int[] nmL;
    private boolean nmM;
    
    public a(Context paramContext)
    {
      super();
      AppMethodBeat.i(135493);
      this.mA = new Rect();
      this.nmL = new int[2];
      this.nmM = false;
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
      AppMethodBeat.i(197470);
      super.onAttachedToWindow();
      this.nmM = false;
      AppMethodBeat.o(197470);
    }
    
    protected final void onDetachedFromWindow()
    {
      AppMethodBeat.i(197471);
      super.onDetachedFromWindow();
      this.nmM = true;
      AppMethodBeat.o(197471);
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
      getLocationInWindow(this.nmL);
      if (com.tencent.mm.sdk.platformtools.ad.getLogLevel() <= 1) {
        com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.PagePromptViewContainerLayout[keyboard]", "onLayout, WindowVisibleDisplayFrame=%s, location=%s", new Object[] { this.mA, a.toString(this.nmL) });
      }
      paramInt1 = 0;
      while (paramInt1 < getChildCount())
      {
        View localView = getChildAt(paramInt1);
        paramInt2 = this.nmL[1] + localView.getTop() + localView.getHeight() - this.mA.bottom;
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.e.b
 * JD-Core Version:    0.7.0.1
 */