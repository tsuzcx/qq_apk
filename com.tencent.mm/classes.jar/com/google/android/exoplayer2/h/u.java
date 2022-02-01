package com.google.android.exoplayer2.h;

import android.net.Uri;
import com.google.android.exoplayer2.i.x;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.InputStream;

public final class u<T>
  implements t.c
{
  private final a<? extends T> bFQ;
  public volatile long bFR;
  private final g bhK;
  public final j bxj;
  private volatile boolean isCanceled;
  public volatile T result;
  public final int type;
  
  public u(g paramg, Uri paramUri, a<? extends T> parama)
  {
    AppMethodBeat.i(196068);
    this.bhK = paramg;
    this.bxj = new j(paramUri, 1);
    this.type = 4;
    this.bFQ = parama;
    AppMethodBeat.o(196068);
  }
  
  public final void vA()
  {
    this.isCanceled = true;
  }
  
  public final boolean vB()
  {
    return this.isCanceled;
  }
  
  public final void vC()
  {
    AppMethodBeat.i(93101);
    i locali = new i(this.bhK, this.bxj);
    try
    {
      locali.wH();
      this.result = this.bFQ.b(this.bhK.getUri(), locali);
      return;
    }
    finally
    {
      this.bFR = locali.bEN;
      x.closeQuietly(locali);
      AppMethodBeat.o(93101);
    }
  }
  
  public static abstract interface a<T>
  {
    public abstract T b(Uri paramUri, InputStream paramInputStream);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.google.android.exoplayer2.h.u
 * JD-Core Version:    0.7.0.1
 */