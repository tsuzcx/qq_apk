package com.google.android.exoplayer2.h;

import android.net.Uri;
import com.google.android.exoplayer2.i.x;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.InputStream;

public final class u<T>
  implements t.c
{
  public volatile long bFA;
  private final a<? extends T> bFz;
  private final g bhN;
  public final j bxi;
  private volatile boolean isCanceled;
  public volatile T result;
  public final int type;
  
  public u(g paramg, Uri paramUri, a<? extends T> parama)
  {
    AppMethodBeat.i(211654);
    this.bhN = paramg;
    this.bxi = new j(paramUri);
    this.type = 4;
    this.bFz = parama;
    AppMethodBeat.o(211654);
  }
  
  public final void vu()
  {
    this.isCanceled = true;
  }
  
  public final boolean vv()
  {
    return this.isCanceled;
  }
  
  public final void vw()
  {
    AppMethodBeat.i(93101);
    i locali = new i(this.bhN, this.bxi);
    try
    {
      locali.checkOpened();
      this.result = this.bFz.b(this.bhN.getUri(), locali);
      return;
    }
    finally
    {
      this.bFA = locali.totalBytesRead;
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