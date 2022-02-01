package com.tencent.luggage.game.page;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.coverview.CoverViewContainer;
import com.tencent.mm.plugin.appbrand.page.av;
import com.tencent.mm.plugin.appbrand.page.ax;
import com.tencent.mm.plugin.appbrand.page.bb;

public final class b
  extends FrameLayout
  implements bb
{
  private b ckO = null;
  
  public b(Context paramContext)
  {
    super(paramContext);
  }
  
  public final void a(av paramav) {}
  
  public final void a(ax paramax) {}
  
  public final void c(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {}
  
  public final ViewGroup getContainer()
  {
    return this;
  }
  
  public final void gw(int paramInt) {}
  
  public final void onScrollChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4, View paramView) {}
  
  public final void onViewAdded(View paramView)
  {
    AppMethodBeat.i(130626);
    super.onViewAdded(paramView);
    if (((paramView instanceof CoverViewContainer)) && (!paramView.hasOnClickListeners())) {
      paramView.setOnTouchListener(new b.a((byte)0));
    }
    if (this.ckO != null) {
      this.ckO.cl(paramView);
    }
    AppMethodBeat.o(130626);
  }
  
  public final void setNativeWidgetAddedCallback(b paramb)
  {
    this.ckO = paramb;
  }
  
  public final void setupWebViewTouchInterceptor(ax paramax) {}
  
  public static abstract interface b
  {
    public abstract void cl(View paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.luggage.game.page.b
 * JD-Core Version:    0.7.0.1
 */