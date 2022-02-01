package com.tencent.luggage.game.page;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.coverview.CoverViewContainer;
import com.tencent.mm.plugin.appbrand.page.aw;
import com.tencent.mm.plugin.appbrand.page.ay;
import com.tencent.mm.plugin.appbrand.page.bc;

public final class b
  extends FrameLayout
  implements bc
{
  private b cav = null;
  
  public b(Context paramContext)
  {
    super(paramContext);
  }
  
  public final void a(aw paramaw) {}
  
  public final void a(ay paramay) {}
  
  public final void d(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {}
  
  public final ViewGroup getContainer()
  {
    return this;
  }
  
  public final void gt(int paramInt) {}
  
  public final void onScrollChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4, View paramView) {}
  
  public final void onViewAdded(View paramView)
  {
    AppMethodBeat.i(130626);
    super.onViewAdded(paramView);
    if (((paramView instanceof CoverViewContainer)) && (!paramView.hasOnClickListeners())) {
      paramView.setOnTouchListener(new a((byte)0));
    }
    if (this.cav != null) {
      this.cav.cl(paramView);
    }
    AppMethodBeat.o(130626);
  }
  
  public final void setNativeWidgetAddedCallback(b paramb)
  {
    this.cav = paramb;
  }
  
  public final void setupWebViewTouchInterceptor(ay paramay) {}
  
  static final class a
    implements View.OnTouchListener
  {
    @SuppressLint({"ClickableViewAccessibility"})
    public final boolean onTouch(View paramView, MotionEvent paramMotionEvent)
    {
      return true;
    }
  }
  
  public static abstract interface b
  {
    public abstract void cl(View paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.luggage.game.page.b
 * JD-Core Version:    0.7.0.1
 */