package com.google.android.exoplayer2.source;

import android.net.Uri;
import android.os.Handler;
import com.google.android.exoplayer2.f;
import com.google.android.exoplayer2.h.b;
import com.google.android.exoplayer2.h.g.a;
import com.google.android.exoplayer2.h.t;
import com.google.android.exoplayer2.i.a;
import com.google.android.exoplayer2.w.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.IOException;

public final class h
  implements g.c, j
{
  private final w.a aQV;
  private j.a bkG;
  private final int bkJ;
  private final a bkK;
  private final String bkN;
  private final g.a blq;
  private final com.google.android.exoplayer2.c.h blr;
  private final int bls;
  private long blt;
  private boolean blu;
  private final Handler eventHandler;
  private final Uri uri;
  
  public h(Uri paramUri, g.a parama, com.google.android.exoplayer2.c.h paramh, Handler paramHandler, a parama1)
  {
    this(paramUri, parama, paramh, paramHandler, parama1, (byte)0);
  }
  
  private h(Uri paramUri, g.a parama, com.google.android.exoplayer2.c.h paramh, Handler paramHandler, a parama1, byte paramByte)
  {
    this(paramUri, parama, paramh, paramHandler, parama1, '\000');
  }
  
  private h(Uri paramUri, g.a parama, com.google.android.exoplayer2.c.h paramh, Handler paramHandler, a parama1, char paramChar)
  {
    AppMethodBeat.i(92672);
    this.uri = paramUri;
    this.blq = parama;
    this.blr = paramh;
    this.bkJ = -1;
    this.eventHandler = paramHandler;
    this.bkK = parama1;
    this.bkN = null;
    this.bls = 1048576;
    this.aQV = new w.a();
    AppMethodBeat.o(92672);
  }
  
  private void e(long paramLong, boolean paramBoolean)
  {
    AppMethodBeat.i(92677);
    this.blt = paramLong;
    this.blu = paramBoolean;
    this.bkG.a(new o(this.blt, this.blu), null);
    AppMethodBeat.o(92677);
  }
  
  public final i a(j.b paramb, b paramb1)
  {
    AppMethodBeat.i(92674);
    if (paramb.blw == 0) {}
    for (boolean bool = true;; bool = false)
    {
      a.checkArgument(bool);
      paramb = new g(this.uri, this.blq.vi(), this.blr.sK(), this.bkJ, this.eventHandler, this.bkK, this, paramb1, this.bkN, this.bls);
      AppMethodBeat.o(92674);
      return paramb;
    }
  }
  
  public final void a(f paramf, j.a parama)
  {
    AppMethodBeat.i(92673);
    this.bkG = parama;
    e(-9223372036854775807L, false);
    AppMethodBeat.o(92673);
  }
  
  public final void b(i parami)
  {
    AppMethodBeat.i(92675);
    parami = (g)parami;
    boolean bool = parami.bkP.a(parami);
    if ((parami.aRL) && (!bool))
    {
      l[] arrayOfl = parami.bkV;
      int j = arrayOfl.length;
      int i = 0;
      while (i < j)
      {
        arrayOfl[i].tZ();
        i += 1;
      }
    }
    parami.handler.removeCallbacksAndMessages(null);
    parami.released = true;
    AppMethodBeat.o(92675);
  }
  
  public final void d(long paramLong, boolean paramBoolean)
  {
    AppMethodBeat.i(92676);
    long l = paramLong;
    if (paramLong == -9223372036854775807L) {
      l = this.blt;
    }
    if (((this.blt == l) && (this.blu == paramBoolean)) || ((this.blt != -9223372036854775807L) && (l == -9223372036854775807L)))
    {
      AppMethodBeat.o(92676);
      return;
    }
    e(l, paramBoolean);
    AppMethodBeat.o(92676);
  }
  
  public final void tG() {}
  
  public final void tH()
  {
    this.bkG = null;
  }
  
  public static abstract interface a
  {
    public abstract void onLoadError(IOException paramIOException);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.exoplayer2.source.h
 * JD-Core Version:    0.7.0.1
 */