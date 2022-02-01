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
import com.tencent.mm.plugin.appbrand.page.aa;
import com.tencent.mm.plugin.appbrand.page.am;
import com.tencent.mm.plugin.appbrand.utils.ab;
import com.tencent.mm.sdk.platformtools.ac;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Objects;
import org.apache.commons.b.a;

public final class b
{
  public final aa mMl;
  a mMm;
  public f mMn;
  
  public b(aa paramaa)
  {
    this.mMl = paramaa;
  }
  
  private a bBu()
  {
    AppMethodBeat.i(135500);
    if ((this.mMm != null) && (!a.a(this.mMm)))
    {
      localObject = this.mMm;
      AppMethodBeat.o(135500);
      return localObject;
    }
    this.mMm = null;
    Object localObject = this.mMl.lCv.brg();
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
  
  public static void bBy()
  {
    AppMethodBeat.i(135504);
    if (!ab.AI())
    {
      RuntimeException localRuntimeException = new RuntimeException("Should be called on main-thread");
      AppMethodBeat.o(135504);
      throw localRuntimeException;
    }
    AppMethodBeat.o(135504);
  }
  
  public final a bBv()
  {
    AppMethodBeat.i(135501);
    ViewGroup localViewGroup = this.mMl.lCv.brg();
    a locala2 = bBu();
    a locala1 = locala2;
    if (locala2 == null)
    {
      locala1 = new a(this.mMl.getContext());
      locala1.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener()
      {
        public final void onViewAttachedToWindow(View paramAnonymousView) {}
        
        public final void onViewDetachedFromWindow(View paramAnonymousView)
        {
          if (paramAnonymousView == b.this.mMm) {
            b.this.mMm = null;
          }
        }
      });
      localViewGroup.addView(locala1, -1, -1);
    }
    locala1.bringToFront();
    this.mMm = locala1;
    AppMethodBeat.o(135501);
    return locala1;
  }
  
  public final void bBw()
  {
    AppMethodBeat.i(135502);
    com.tencent.mm.plugin.appbrand.widget.actionbar.b localb = this.mMl.bqy();
    if (localb == null)
    {
      AppMethodBeat.o(135502);
      return;
    }
    int i = localb.getTop();
    wj(localb.getMeasuredHeight() + i);
    AppMethodBeat.o(135502);
  }
  
  public final boolean bBx()
  {
    boolean bool3 = false;
    boolean bool1 = false;
    AppMethodBeat.i(135503);
    if (!this.mMl.isRunning())
    {
      AppMethodBeat.o(135503);
      return false;
    }
    bBy();
    a locala = this.mMm;
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
    if ((bool2) && (this.mMl.getRuntime() != null)) {
      b.a(b.at(this.mMl.getRuntime())).remove(this.mMl);
    }
    AppMethodBeat.o(135503);
    return bool2;
  }
  
  public final void dr(View paramView)
  {
    AppMethodBeat.i(193551);
    if ((!this.mMl.isRunning()) || (this.mMl.getRuntime() == null))
    {
      AppMethodBeat.o(193551);
      return;
    }
    bBy();
    a locala = bBv();
    bBw();
    paramView.setTag(2131296836, Boolean.TRUE);
    locala.addView(paramView);
    b.a(b.at(this.mMl.getRuntime())).add(this.mMl);
    AppMethodBeat.o(193551);
  }
  
  public final void wj(int paramInt)
  {
    AppMethodBeat.i(135499);
    a locala = bBu();
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
    private final Rect kK;
    private final int[] mMp;
    private boolean mMq;
    
    public a(Context paramContext)
    {
      super();
      AppMethodBeat.i(135493);
      this.kK = new Rect();
      this.mMp = new int[2];
      this.mMq = false;
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
      AppMethodBeat.i(193549);
      super.onAttachedToWindow();
      this.mMq = false;
      AppMethodBeat.o(193549);
    }
    
    protected final void onDetachedFromWindow()
    {
      AppMethodBeat.i(193550);
      super.onDetachedFromWindow();
      this.mMq = true;
      AppMethodBeat.o(193550);
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
      getWindowVisibleDisplayFrame(this.kK);
      getLocationInWindow(this.mMp);
      if (ac.getLogLevel() <= 1) {
        ac.d("MicroMsg.PagePromptViewContainerLayout[keyboard]", "onLayout, WindowVisibleDisplayFrame=%s, location=%s", new Object[] { this.kK, a.toString(this.mMp) });
      }
      paramInt1 = 0;
      while (paramInt1 < getChildCount())
      {
        View localView = getChildAt(paramInt1);
        paramInt2 = this.mMp[1] + localView.getTop() + localView.getHeight() - this.kK.bottom;
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
    public final LinkedList<aa> mMr;
    
    private b()
    {
      AppMethodBeat.i(164055);
      this.mMr = new LinkedList();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.e.b
 * JD-Core Version:    0.7.0.1
 */