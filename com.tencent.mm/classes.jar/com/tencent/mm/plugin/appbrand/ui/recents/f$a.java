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
  private final String mOL;
  private final String mOM;
  private final f.a.a mON;
  byte[] mOO;
  
  public f$a(String paramString1, String paramString2, f.a.a parama)
  {
    AppMethodBeat.i(180397);
    this.counter = new AtomicInteger();
    this.imageBitmap = null;
    this.mOO = null;
    this.mOL = paramString1;
    this.mOM = paramString2;
    this.mON = parama;
    if (!TextUtils.isEmpty(paramString1)) {
      bBv();
    }
    if (!TextUtils.isEmpty(paramString2)) {
      bBv();
    }
    if (this.counter.get() == 0) {
      parama.b(null, null);
    }
    AppMethodBeat.o(180397);
  }
  
  private void VA(String paramString)
  {
    AppMethodBeat.i(180401);
    b.aEl().a(new b.k()
    {
      public final String BN()
      {
        return "LoadShowcaseImageTask";
      }
      
      public final void F(Bitmap paramAnonymousBitmap)
      {
        AppMethodBeat.i(180394);
        f.a.this.imageBitmap = paramAnonymousBitmap;
        f.a.this.bBu();
        AppMethodBeat.o(180394);
      }
      
      public final void aEt() {}
      
      public final void ox()
      {
        AppMethodBeat.i(180395);
        f.a.this.bBu();
        AppMethodBeat.o(180395);
      }
    }, paramString, null);
    AppMethodBeat.o(180401);
  }
  
  private void VB(String paramString)
  {
    AppMethodBeat.i(180402);
    b.aEl().a(paramString, new b.j()
    {
      public final void V(byte[] paramAnonymousArrayOfByte)
      {
        AppMethodBeat.i(180396);
        f.a.this.mOO = paramAnonymousArrayOfByte;
        f.a.this.bBu();
        AppMethodBeat.o(180396);
      }
    });
    AppMethodBeat.o(180402);
  }
  
  private void bBv()
  {
    AppMethodBeat.i(180399);
    this.counter.incrementAndGet();
    AppMethodBeat.o(180399);
  }
  
  final void bBu()
  {
    AppMethodBeat.i(180398);
    if ((this.counter.decrementAndGet() == 0) && (this.mON != null)) {
      this.mON.b(this.imageBitmap, this.mOO);
    }
    AppMethodBeat.o(180398);
  }
  
  public final void start()
  {
    AppMethodBeat.i(180400);
    if (!TextUtils.isEmpty(this.mOL)) {
      VA(this.mOL);
    }
    if (!TextUtils.isEmpty(this.mOM)) {
      VB(this.mOM);
    }
    AppMethodBeat.o(180400);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.recents.f.a
 * JD-Core Version:    0.7.0.1
 */