package com.google.android.exoplayer2.h;

import android.net.Uri;
import com.google.android.exoplayer2.i.x;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.InputStream;

public final class v<T>
  implements t.c
{
  private final g aWG;
  public final j bml;
  private final a<? extends T> bxC;
  public volatile long bxD;
  private volatile boolean isCanceled;
  public volatile T result;
  public final int type;
  
  public v(g paramg, Uri paramUri, int paramInt, a<? extends T> parama)
  {
    AppMethodBeat.i(93100);
    this.aWG = paramg;
    this.bml = new j(paramUri);
    this.type = paramInt;
    this.bxC = parama;
    AppMethodBeat.o(93100);
  }
  
  public final void tN()
  {
    this.isCanceled = true;
  }
  
  public final boolean tO()
  {
    return this.isCanceled;
  }
  
  public final void tP()
  {
    AppMethodBeat.i(93101);
    i locali = new i(this.aWG, this.bml);
    try
    {
      locali.vj();
      this.result = this.bxC.a(this.aWG.getUri(), locali);
      return;
    }
    finally
    {
      this.bxD = locali.bwx;
      x.closeQuietly(locali);
      AppMethodBeat.o(93101);
    }
  }
  
  public static abstract interface a<T>
  {
    public abstract T a(Uri paramUri, InputStream paramInputStream);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.exoplayer2.h.v
 * JD-Core Version:    0.7.0.1
 */