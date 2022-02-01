package com.google.android.exoplayer2.h;

import android.net.Uri;
import com.google.android.exoplayer2.i.x;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.InputStream;

public final class u<T>
  implements t.c
{
  private final g aXs;
  public final j bmN;
  private final a<? extends T> bvl;
  public volatile long bvm;
  private volatile boolean isCanceled;
  public volatile T result;
  public final int type;
  
  public u(g paramg, Uri paramUri, a<? extends T> parama)
  {
    AppMethodBeat.i(195777);
    this.aXs = paramg;
    this.bmN = new j(paramUri);
    this.type = 4;
    this.bvl = parama;
    AppMethodBeat.o(195777);
  }
  
  public final void tV()
  {
    this.isCanceled = true;
  }
  
  public final boolean tW()
  {
    return this.isCanceled;
  }
  
  public final void tX()
  {
    AppMethodBeat.i(93101);
    i locali = new i(this.aXs, this.bmN);
    try
    {
      locali.checkOpened();
      this.result = this.bvl.b(this.aXs.getUri(), locali);
      return;
    }
    finally
    {
      this.bvm = locali.totalBytesRead;
      x.closeQuietly(locali);
      AppMethodBeat.o(93101);
    }
  }
  
  public static abstract interface a<T>
  {
    public abstract T b(Uri paramUri, InputStream paramInputStream);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.exoplayer2.h.u
 * JD-Core Version:    0.7.0.1
 */