package com.tencent.mm.plugin.appbrand.widget.h;

import android.content.Context;
import android.graphics.Rect;
import android.view.View;
import android.view.View.OnAttachStateChangeListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import androidx.core.g.z;
import com.tencent.luggage.wxa.a.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.jsapi.n;
import com.tencent.mm.plugin.appbrand.page.ad;
import com.tencent.mm.plugin.appbrand.page.ap;
import com.tencent.mm.plugin.appbrand.utils.ao;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Objects;
import org.apache.commons.c.a;

public final class b
{
  public final ad ttB;
  a uPx;
  public f uPy;
  
  public b(ad paramad)
  {
    this.ttB = paramad;
  }
  
  private a cSE()
  {
    AppMethodBeat.i(135500);
    if ((this.uPx != null) && (!a.a(this.uPx)))
    {
      localObject = this.uPx;
      AppMethodBeat.o(135500);
      return localObject;
    }
    this.uPx = null;
    Object localObject = this.ttB.txd.cFJ();
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
  
  public static void cSH()
  {
    AppMethodBeat.i(135504);
    if (!ao.aoz())
    {
      RuntimeException localRuntimeException = new RuntimeException("Should be called on main-thread");
      AppMethodBeat.o(135504);
      throw localRuntimeException;
    }
    AppMethodBeat.o(135504);
  }
  
  public final void EI(int paramInt)
  {
    AppMethodBeat.i(135499);
    a locala = cSE();
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
  
  public final void a(View paramView, long paramLong)
  {
    AppMethodBeat.i(324100);
    if ((!this.ttB.isRunning()) || (this.ttB.getRuntime() == null))
    {
      AppMethodBeat.o(324100);
      return;
    }
    cSH();
    a locala = cSF();
    cSG();
    paramView.setTag(a.d.app_brand_toast_view_tag, Boolean.TRUE);
    locala.addView(paramView);
    long l = paramLong;
    if (paramLong < 0L) {
      l = 0L;
    }
    paramView.postDelayed(new b.c(paramView), l);
    b.a((b)Objects.requireNonNull(b.d(this.ttB.getRuntime(), true))).add(this.ttB);
    AppMethodBeat.o(324100);
  }
  
  public final a cSF()
  {
    AppMethodBeat.i(135501);
    ViewGroup localViewGroup = this.ttB.txd.cFJ();
    a locala2 = cSE();
    a locala1 = locala2;
    if (locala2 == null)
    {
      locala1 = new a(this.ttB.getContext());
      locala1.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener()
      {
        public final void onViewAttachedToWindow(View paramAnonymousView) {}
        
        public final void onViewDetachedFromWindow(View paramAnonymousView)
        {
          if (paramAnonymousView == b.this.uPx) {
            b.this.uPx = null;
          }
        }
      });
      localViewGroup.addView(locala1, -1, -1);
    }
    locala1.bringToFront();
    this.uPx = locala1;
    AppMethodBeat.o(135501);
    return locala1;
  }
  
  public final void cSG()
  {
    AppMethodBeat.i(135502);
    com.tencent.mm.plugin.appbrand.widget.actionbar.b localb = this.ttB.cEC();
    if (localb == null)
    {
      AppMethodBeat.o(135502);
      return;
    }
    int i = localb.getTop();
    EI(localb.getMeasuredHeight() + i);
    AppMethodBeat.o(135502);
  }
  
  public final boolean lL(boolean paramBoolean)
  {
    AppMethodBeat.i(324111);
    if (!this.ttB.isRunning())
    {
      if ((paramBoolean) && (this.ttB.getRuntime() != null))
      {
        localObject1 = b.d(this.ttB.getRuntime(), false);
        if (localObject1 != null) {
          b.a((b)localObject1).remove(this.ttB);
        }
      }
      AppMethodBeat.o(324111);
      return false;
    }
    cSH();
    Object localObject1 = this.uPx;
    boolean bool;
    if ((localObject1 != null) && (z.ay((View)localObject1)))
    {
      Object localObject2 = new LinkedList();
      int i = 0;
      View localView;
      while (i < ((a)localObject1).getChildCount())
      {
        localView = ((a)localObject1).getChildAt(i);
        if ((localView != null) && (Objects.equals(localView.getTag(a.d.app_brand_toast_view_tag), Boolean.TRUE))) {
          ((LinkedList)localObject2).add(localView);
        }
        i += 1;
      }
      if (!((LinkedList)localObject2).isEmpty()) {}
      for (bool = true;; bool = false)
      {
        localObject2 = ((LinkedList)localObject2).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localView = (View)((Iterator)localObject2).next();
          localView.setVisibility(8);
          ((a)localObject1).removeView(localView);
        }
      }
    }
    for (;;)
    {
      if ((paramBoolean) && (this.ttB.getRuntime() != null))
      {
        localObject1 = b.d(this.ttB.getRuntime(), false);
        if (localObject1 != null) {
          b.a((b)localObject1).remove(this.ttB);
        }
      }
      AppMethodBeat.o(324111);
      return bool;
      bool = false;
    }
  }
  
  static final class a
    extends FrameLayout
  {
    private final Rect tmpRect;
    private final int[] uPA;
    private boolean uPB;
    
    public a(Context paramContext)
    {
      super();
      AppMethodBeat.i(135493);
      this.tmpRect = new Rect();
      this.uPA = new int[2];
      this.uPB = false;
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
      AppMethodBeat.i(324099);
      super.onAttachedToWindow();
      this.uPB = false;
      AppMethodBeat.o(324099);
    }
    
    protected final void onDetachedFromWindow()
    {
      AppMethodBeat.i(324104);
      super.onDetachedFromWindow();
      this.uPB = true;
      AppMethodBeat.o(324104);
    }
    
    protected final void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    {
      AppMethodBeat.i(135497);
      super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
      if (!z.ay(this))
      {
        AppMethodBeat.o(135497);
        return;
      }
      getWindowVisibleDisplayFrame(this.tmpRect);
      getLocationInWindow(this.uPA);
      if (Log.getLogLevel() <= 1) {
        Log.d("MicroMsg.PagePromptViewContainerLayout[keyboard]", "onLayout, WindowVisibleDisplayFrame=%s, location=%s", new Object[] { this.tmpRect, a.ca(this.uPA) });
      }
      paramInt1 = 0;
      while (paramInt1 < getChildCount())
      {
        View localView = getChildAt(paramInt1);
        paramInt2 = this.uPA[1] + localView.getTop() + localView.getHeight() - this.tmpRect.bottom;
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
    public final LinkedList<ad> uPC;
    
    private b()
    {
      AppMethodBeat.i(164055);
      this.uPC = new LinkedList();
      AppMethodBeat.o(164055);
    }
    
    public static b d(AppBrandRuntime paramAppBrandRuntime, boolean paramBoolean)
    {
      AppMethodBeat.i(324095);
      b localb2 = (b)paramAppBrandRuntime.aO(b.class);
      b localb1 = localb2;
      if (localb2 == null)
      {
        localb1 = localb2;
        if (paramBoolean)
        {
          localb1 = new b();
          paramAppBrandRuntime.a(localb1);
        }
      }
      AppMethodBeat.o(324095);
      return localb1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.h.b
 * JD-Core Version:    0.7.0.1
 */