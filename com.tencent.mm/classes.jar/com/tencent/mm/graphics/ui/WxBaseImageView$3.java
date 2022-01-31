package com.tencent.mm.graphics.ui;

import android.graphics.Bitmap;
import com.davemorrissey.labs.subscaleview.a.c;
import com.tencent.mm.graphics.a.b;
import com.tencent.mm.sdk.platformtools.y;

final class WxBaseImageView$3
  implements b
{
  WxBaseImageView$3(WxBaseImageView paramWxBaseImageView, b paramb) {}
  
  public final void a(c paramc)
  {
    WxBaseImageView.a(this.dEa, paramc);
    if (this.dEb != null) {
      this.dEb.a(paramc);
    }
  }
  
  public final void b(c paramc)
  {
    WxBaseImageView.b(this.dEa, paramc);
    if (this.dEb != null) {
      this.dEb.b(paramc);
    }
  }
  
  public final void c(c paramc)
  {
    WxBaseImageView.b(this.dEa, paramc);
    if (this.dEb != null) {
      this.dEb.c(paramc);
    }
  }
  
  public final void f(Bitmap paramBitmap)
  {
    WxBaseImageView.e(this.dEa);
    if (this.dEb != null) {
      this.dEb.f(paramBitmap);
    }
  }
  
  public final void jL()
  {
    WxBaseImageView.d(this.dEa);
    if (this.dEb != null) {
      this.dEb.jL();
    }
  }
  
  public final void jM()
  {
    y.i("MicroMsg.WxBaseImageView", "alvinluo onPreviewReleased");
    if (this.dEb != null) {
      this.dEb.jM();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.graphics.ui.WxBaseImageView.3
 * JD-Core Version:    0.7.0.1
 */