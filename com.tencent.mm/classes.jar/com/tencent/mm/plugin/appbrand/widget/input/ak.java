package com.tencent.mm.plugin.appbrand.widget.input;

import android.view.View;
import android.view.ViewGroup;
import com.tencent.mm.plugin.appbrand.page.ad;
import com.tencent.mm.plugin.appbrand.page.af;
import com.tencent.mm.plugin.appbrand.page.ah;
import com.tencent.mm.plugin.appbrand.page.q;

public final class ak
  implements ah
{
  private final q gSP;
  private final g hwo;
  
  ak(q paramq)
  {
    this.gSP = paramq;
    this.hwo = new g(paramq);
  }
  
  public final void a(ad paramad)
  {
    if ((paramad == ad.gVG) || (paramad == ad.gVH)) {
      n.w(this.gSP);
    }
  }
  
  public final void b(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.hwo.b(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public final ViewGroup getContainer()
  {
    return this.hwo;
  }
  
  public final void kU(int paramInt)
  {
    this.hwo.setTranslationY(paramInt);
  }
  
  public final void onScrollChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4, View paramView)
  {
    this.hwo.onScrollChanged(paramInt1, paramInt2, paramInt3, paramInt4, paramView);
  }
  
  public final void setupWebViewTouchInterceptor(af paramaf)
  {
    paramaf = (ViewGroup)paramaf.getContentView();
    g localg = this.hwo;
    paramaf.setOnTouchListener(new ak.1(this, localg, new ag(localg)));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.input.ak
 * JD-Core Version:    0.7.0.1
 */