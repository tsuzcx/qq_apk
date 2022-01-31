package com.google.android.exoplayer2.h;

import android.net.Uri;
import com.google.android.exoplayer2.i.x;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class u<T>
  implements t.c
{
  private final g aBo;
  public final j aQI;
  private final u.a<? extends T> aZC;
  public volatile long aZD;
  private volatile boolean isCanceled;
  public volatile T result;
  public final int type;
  
  public u(g paramg, Uri paramUri, u.a<? extends T> parama)
  {
    AppMethodBeat.i(95856);
    this.aBo = paramg;
    this.aQI = new j(paramUri);
    this.type = 4;
    this.aZC = parama;
    AppMethodBeat.o(95856);
  }
  
  public final void pf()
  {
    this.isCanceled = true;
  }
  
  public final boolean pg()
  {
    return this.isCanceled;
  }
  
  public final void ph()
  {
    AppMethodBeat.i(95857);
    i locali = new i(this.aBo, this.aQI);
    try
    {
      locali.qo();
      this.result = this.aZC.b(this.aBo.getUri(), locali);
      return;
    }
    finally
    {
      this.aZD = locali.aYw;
      x.closeQuietly(locali);
      AppMethodBeat.o(95857);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.google.android.exoplayer2.h.u
 * JD-Core Version:    0.7.0.1
 */