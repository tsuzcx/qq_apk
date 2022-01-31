package com.tencent.mm.graphics.ui;

import android.graphics.Bitmap;
import com.davemorrissey.labs.subscaleview.a.c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.graphics.a.b;
import com.tencent.mm.sdk.platformtools.ab;

final class WxBaseImageView$3
  implements b
{
  WxBaseImageView$3(WxBaseImageView paramWxBaseImageView, b paramb) {}
  
  public final void a(c paramc)
  {
    AppMethodBeat.i(57106);
    WxBaseImageView.a(this.eBB, paramc);
    if (this.eBC != null) {
      this.eBC.a(paramc);
    }
    AppMethodBeat.o(57106);
  }
  
  public final void b(c paramc)
  {
    AppMethodBeat.i(57107);
    WxBaseImageView.b(this.eBB, paramc);
    if (this.eBC != null) {
      this.eBC.b(paramc);
    }
    AppMethodBeat.o(57107);
  }
  
  public final void c(c paramc)
  {
    AppMethodBeat.i(57108);
    WxBaseImageView.b(this.eBB, paramc);
    if (this.eBC != null) {
      this.eBC.c(paramc);
    }
    AppMethodBeat.o(57108);
  }
  
  public final void g(Bitmap paramBitmap)
  {
    AppMethodBeat.i(57105);
    WxBaseImageView.e(this.eBB);
    if (this.eBC != null) {
      this.eBC.g(paramBitmap);
    }
    AppMethodBeat.o(57105);
  }
  
  public final void lF()
  {
    AppMethodBeat.i(57104);
    WxBaseImageView.d(this.eBB);
    if (this.eBC != null) {
      this.eBC.lF();
    }
    AppMethodBeat.o(57104);
  }
  
  public final void lG()
  {
    AppMethodBeat.i(57109);
    ab.i("MicroMsg.WxBaseImageView", "alvinluo onPreviewReleased");
    if (this.eBC != null) {
      this.eBC.lG();
    }
    AppMethodBeat.o(57109);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.graphics.ui.WxBaseImageView.3
 * JD-Core Version:    0.7.0.1
 */