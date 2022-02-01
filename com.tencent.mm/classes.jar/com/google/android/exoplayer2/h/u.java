package com.google.android.exoplayer2.h;

import android.net.Uri;
import com.google.android.exoplayer2.i.x;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.InputStream;

public final class u<T>
  implements t.c
{
  private final g aRo;
  public final j bgL;
  private final a<? extends T> bpu;
  public volatile long bpv;
  private volatile boolean isCanceled;
  public volatile T result;
  public final int type;
  
  public u(g paramg, Uri paramUri, a<? extends T> parama)
  {
    AppMethodBeat.i(199988);
    this.aRo = paramg;
    this.bgL = new j(paramUri, 1);
    this.type = 4;
    this.bpu = parama;
    AppMethodBeat.o(199988);
  }
  
  public final void tA()
  {
    AppMethodBeat.i(93101);
    i locali = new i(this.aRo, this.bgL);
    try
    {
      locali.uI();
      this.result = this.bpu.b(this.aRo.getUri(), locali);
      return;
    }
    finally
    {
      this.bpv = locali.boq;
      x.closeQuietly(locali);
      AppMethodBeat.o(93101);
    }
  }
  
  public final void ty()
  {
    this.isCanceled = true;
  }
  
  public final boolean tz()
  {
    return this.isCanceled;
  }
  
  public static abstract interface a<T>
  {
    public abstract T b(Uri paramUri, InputStream paramInputStream);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.google.android.exoplayer2.h.u
 * JD-Core Version:    0.7.0.1
 */