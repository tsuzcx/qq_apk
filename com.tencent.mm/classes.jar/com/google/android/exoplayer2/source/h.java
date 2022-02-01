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
  implements g.c, k
{
  private final w.a aLH;
  private final g.a bfN;
  private final com.google.android.exoplayer2.c.h bfO;
  private final int bfP;
  private long bfQ;
  private boolean bfR;
  private k.a bfd;
  private final int bfg;
  private final a bfh;
  private final String bfk;
  private final Handler eventHandler;
  private final Uri uri;
  
  public h(Uri paramUri, g.a parama, com.google.android.exoplayer2.c.h paramh, Handler paramHandler, a parama1)
  {
    this(paramUri, parama, paramh, paramHandler, parama1, null);
  }
  
  public h(Uri paramUri, g.a parama, com.google.android.exoplayer2.c.h paramh, Handler paramHandler, a parama1, String paramString)
  {
    this(paramUri, parama, paramh, paramHandler, parama1, paramString, (byte)0);
  }
  
  private h(Uri paramUri, g.a parama, com.google.android.exoplayer2.c.h paramh, Handler paramHandler, a parama1, String paramString, byte paramByte)
  {
    AppMethodBeat.i(196279);
    this.uri = paramUri;
    this.bfN = parama;
    this.bfO = paramh;
    this.bfg = -1;
    this.eventHandler = paramHandler;
    this.bfh = parama1;
    this.bfk = paramString;
    this.bfP = 1048576;
    this.aLH = new w.a();
    AppMethodBeat.o(196279);
  }
  
  private void e(long paramLong, boolean paramBoolean)
  {
    AppMethodBeat.i(92677);
    this.bfQ = paramLong;
    this.bfR = paramBoolean;
    this.bfd.a(new p(this.bfQ, this.bfR), null);
    AppMethodBeat.o(92677);
  }
  
  public final j a(k.b paramb, b paramb1)
  {
    AppMethodBeat.i(92674);
    if (paramb.bfZ == 0) {}
    for (boolean bool = true;; bool = false)
    {
      a.checkArgument(bool);
      paramb = new g(this.uri, this.bfN.uH(), this.bfO.ss(), this.bfg, this.eventHandler, this.bfh, this, paramb1, this.bfk, this.bfP);
      AppMethodBeat.o(92674);
      return paramb;
    }
  }
  
  public final void a(f paramf, k.a parama)
  {
    AppMethodBeat.i(92673);
    this.bfd = parama;
    e(-9223372036854775807L, false);
    AppMethodBeat.o(92673);
  }
  
  public final void b(j paramj)
  {
    AppMethodBeat.i(92675);
    paramj = (g)paramj;
    boolean bool = paramj.bfm.a(paramj);
    if ((paramj.aMy) && (!bool))
    {
      m[] arrayOfm = paramj.bfs;
      int j = arrayOfm.length;
      int i = 0;
      while (i < j)
      {
        arrayOfm[i].tJ();
        i += 1;
      }
    }
    paramj.handler.removeCallbacksAndMessages(null);
    paramj.released = true;
    AppMethodBeat.o(92675);
  }
  
  public final void d(long paramLong, boolean paramBoolean)
  {
    AppMethodBeat.i(92676);
    long l = paramLong;
    if (paramLong == -9223372036854775807L) {
      l = this.bfQ;
    }
    if (((this.bfQ == l) && (this.bfR == paramBoolean)) || ((this.bfQ != -9223372036854775807L) && (l == -9223372036854775807L)))
    {
      AppMethodBeat.o(92676);
      return;
    }
    e(l, paramBoolean);
    AppMethodBeat.o(92676);
  }
  
  public final void tr() {}
  
  public final void ts()
  {
    this.bfd = null;
  }
  
  public static abstract interface a
  {
    public abstract void onLoadError(IOException paramIOException);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.google.android.exoplayer2.source.h
 * JD-Core Version:    0.7.0.1
 */