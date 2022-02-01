package com.google.android.exoplayer2.h;

import android.net.Uri;
import com.google.android.exoplayer2.i.x;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.InputStream;

public final class u<T>
  implements t.c
{
  private final g cLk;
  public final j daF;
  private final a<? extends T> diX;
  public volatile long diY;
  private volatile boolean isCanceled;
  public volatile T result;
  public final int type;
  
  public u(g paramg, Uri paramUri, a<? extends T> parama)
  {
    AppMethodBeat.i(210318);
    this.cLk = paramg;
    this.daF = new j(paramUri, 1);
    this.type = 4;
    this.diX = parama;
    AppMethodBeat.o(210318);
  }
  
  public final void Tb()
  {
    this.isCanceled = true;
  }
  
  public final boolean Tc()
  {
    return this.isCanceled;
  }
  
  public final void Td()
  {
    AppMethodBeat.i(93101);
    i locali = new i(this.cLk, this.daF);
    try
    {
      locali.checkOpened();
      this.result = this.diX.b(this.cLk.getUri(), locali);
      return;
    }
    finally
    {
      this.diY = locali.totalBytesRead;
      x.closeQuietly(locali);
      AppMethodBeat.o(93101);
    }
  }
  
  public static abstract interface a<T>
  {
    public abstract T b(Uri paramUri, InputStream paramInputStream);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.google.android.exoplayer2.h.u
 * JD-Core Version:    0.7.0.1
 */