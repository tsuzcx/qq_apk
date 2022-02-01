package com.tencent.mm.plugin.appbrand.ui.recents;

import android.graphics.Bitmap;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelappbrand.a.b;
import com.tencent.mm.modelappbrand.a.b.j;
import com.tencent.mm.modelappbrand.a.b.k;
import java.util.concurrent.atomic.AtomicInteger;

final class f$a
{
  private final AtomicInteger counter;
  Bitmap imageBitmap;
  private final String rdv;
  private final String rdw;
  private final f.a.a rdx;
  byte[] rdy;
  
  public f$a(String paramString1, String paramString2, f.a.a parama)
  {
    AppMethodBeat.i(180397);
    this.counter = new AtomicInteger();
    this.imageBitmap = null;
    this.rdy = null;
    this.rdv = paramString1;
    this.rdw = paramString2;
    this.rdx = parama;
    if (!TextUtils.isEmpty(paramString1)) {
      clf();
    }
    if (!TextUtils.isEmpty(paramString2)) {
      clf();
    }
    if (this.counter.get() == 0) {
      parama.b(null, null);
    }
    AppMethodBeat.o(180397);
  }
  
  private void amY(String paramString)
  {
    AppMethodBeat.i(180401);
    b.bhh().a(new b.k()
    {
      public final void G(Bitmap paramAnonymousBitmap)
      {
        AppMethodBeat.i(180394);
        f.a.this.imageBitmap = paramAnonymousBitmap;
        f.a.this.cle();
        AppMethodBeat.o(180394);
      }
      
      public final void bhq() {}
      
      public final void bhr()
      {
        AppMethodBeat.i(180395);
        f.a.this.cle();
        AppMethodBeat.o(180395);
      }
      
      public final String key()
      {
        return "LoadShowcaseImageTask";
      }
    }, paramString, null);
    AppMethodBeat.o(180401);
  }
  
  private void amZ(String paramString)
  {
    AppMethodBeat.i(180402);
    b.bhh().a(paramString, new b.j()
    {
      public final void at(byte[] paramAnonymousArrayOfByte)
      {
        AppMethodBeat.i(180396);
        f.a.this.rdy = paramAnonymousArrayOfByte;
        f.a.this.cle();
        AppMethodBeat.o(180396);
      }
    });
    AppMethodBeat.o(180402);
  }
  
  private void clf()
  {
    AppMethodBeat.i(180399);
    this.counter.incrementAndGet();
    AppMethodBeat.o(180399);
  }
  
  final void cle()
  {
    AppMethodBeat.i(180398);
    if ((this.counter.decrementAndGet() == 0) && (this.rdx != null)) {
      this.rdx.b(this.imageBitmap, this.rdy);
    }
    AppMethodBeat.o(180398);
  }
  
  public final void start()
  {
    AppMethodBeat.i(180400);
    if (!TextUtils.isEmpty(this.rdv)) {
      amY(this.rdv);
    }
    if (!TextUtils.isEmpty(this.rdw)) {
      amZ(this.rdw);
    }
    AppMethodBeat.o(180400);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.recents.f.a
 * JD-Core Version:    0.7.0.1
 */