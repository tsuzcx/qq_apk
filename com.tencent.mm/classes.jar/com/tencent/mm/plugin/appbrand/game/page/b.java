package com.tencent.mm.plugin.appbrand.game.page;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.tencent.mm.plugin.appbrand.jsapi.coverview.CoverViewContainer;
import com.tencent.mm.plugin.appbrand.page.ad;
import com.tencent.mm.plugin.appbrand.page.af;
import com.tencent.mm.plugin.appbrand.page.ah;

public final class b
  extends FrameLayout
  implements ah
{
  public b(Context paramContext)
  {
    super(paramContext);
  }
  
  public final void a(ad paramad) {}
  
  public final void b(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {}
  
  public final ViewGroup getContainer()
  {
    return this;
  }
  
  public final void kU(int paramInt) {}
  
  public final void onScrollChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4, View paramView) {}
  
  public final void onViewAdded(View paramView)
  {
    super.onViewAdded(paramView);
    if (((paramView instanceof CoverViewContainer)) && (!paramView.hasOnClickListeners())) {
      paramView.setOnTouchListener(new b.a((byte)0));
    }
  }
  
  public final void setupWebViewTouchInterceptor(af paramaf) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.game.page.b
 * JD-Core Version:    0.7.0.1
 */