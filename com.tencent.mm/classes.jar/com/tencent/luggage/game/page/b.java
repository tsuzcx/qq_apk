package com.tencent.luggage.game.page;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.coverview.CoverViewContainer;
import com.tencent.mm.plugin.appbrand.page.az;
import com.tencent.mm.plugin.appbrand.page.bb;
import com.tencent.mm.plugin.appbrand.page.bf;

public final class b
  extends FrameLayout
  implements bf
{
  private b cwJ = null;
  
  public b(Context paramContext)
  {
    super(paramContext);
  }
  
  public final void a(az paramaz) {}
  
  public final void a(bb parambb) {}
  
  public final void c(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {}
  
  public final ViewGroup getContainer()
  {
    return this;
  }
  
  public final void hK(int paramInt) {}
  
  public final void onScrollChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4, View paramView) {}
  
  public final void onViewAdded(View paramView)
  {
    AppMethodBeat.i(130626);
    super.onViewAdded(paramView);
    if (((paramView instanceof CoverViewContainer)) && (!paramView.hasOnClickListeners())) {
      paramView.setOnTouchListener(new b.a((byte)0));
    }
    if (this.cwJ != null) {
      this.cwJ.ca(paramView);
    }
    AppMethodBeat.o(130626);
  }
  
  public final void setNativeWidgetAddedCallback(b paramb)
  {
    this.cwJ = paramb;
  }
  
  public final void setupWebViewTouchInterceptor(bb parambb) {}
  
  public static abstract interface b
  {
    public abstract void ca(View paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.luggage.game.page.b
 * JD-Core Version:    0.7.0.1
 */