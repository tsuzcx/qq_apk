package com.google.android.exoplayer2.source;

import android.net.Uri;
import android.os.Handler;
import com.google.android.exoplayer2.h.b;
import com.google.android.exoplayer2.h.t;
import com.google.android.exoplayer2.i.a;
import com.google.android.exoplayer2.w.a;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class g
  implements f.c, i
{
  private final w.a bcl;
  private i.a bvG;
  private final int bvJ;
  private final g.a bvK;
  private final String bvN;
  private final com.google.android.exoplayer2.h.g.a bwq;
  private final com.google.android.exoplayer2.c.h bwr;
  private final int bws;
  private long bwt;
  private boolean bwu;
  private final Handler eventHandler;
  private final Uri uri;
  
  public g(Uri paramUri, com.google.android.exoplayer2.h.g.a parama, com.google.android.exoplayer2.c.h paramh, Handler paramHandler, g.a parama1)
  {
    this(paramUri, parama, paramh, paramHandler, parama1, (byte)0);
  }
  
  private g(Uri paramUri, com.google.android.exoplayer2.h.g.a parama, com.google.android.exoplayer2.c.h paramh, Handler paramHandler, g.a parama1, byte paramByte)
  {
    this(paramUri, parama, paramh, paramHandler, parama1, '\000');
  }
  
  private g(Uri paramUri, com.google.android.exoplayer2.h.g.a parama, com.google.android.exoplayer2.c.h paramh, Handler paramHandler, g.a parama1, char paramChar)
  {
    AppMethodBeat.i(92672);
    this.uri = paramUri;
    this.bwq = parama;
    this.bwr = paramh;
    this.bvJ = -1;
    this.eventHandler = paramHandler;
    this.bvK = parama1;
    this.bvN = null;
    this.bws = 1048576;
    this.bcl = new w.a();
    AppMethodBeat.o(92672);
  }
  
  private void e(long paramLong, boolean paramBoolean)
  {
    AppMethodBeat.i(92677);
    this.bwt = paramLong;
    this.bwu = paramBoolean;
    this.bvG.a(new n(this.bwt, this.bwu), null);
    AppMethodBeat.o(92677);
  }
  
  public final h a(i.b paramb, b paramb1)
  {
    AppMethodBeat.i(92674);
    if (paramb.bww == 0) {}
    for (boolean bool = true;; bool = false)
    {
      a.checkArgument(bool);
      paramb = new f(this.uri, this.bwq.wB(), this.bwr.us(), this.bvJ, this.eventHandler, this.bvK, this, paramb1, this.bvN, this.bws);
      AppMethodBeat.o(92674);
      return paramb;
    }
  }
  
  public final void a(com.google.android.exoplayer2.f paramf, i.a parama)
  {
    AppMethodBeat.i(92673);
    this.bvG = parama;
    e(-9223372036854775807L, false);
    AppMethodBeat.o(92673);
  }
  
  public final void b(h paramh)
  {
    AppMethodBeat.i(92675);
    paramh = (f)paramh;
    boolean bool = paramh.bvP.a(paramh);
    if ((paramh.bdb) && (!bool))
    {
      k[] arrayOfk = paramh.bvV;
      int j = arrayOfk.length;
      int i = 0;
      while (i < j)
      {
        arrayOfk[i].vG();
        i += 1;
      }
    }
    paramh.handler.removeCallbacksAndMessages(null);
    paramh.released = true;
    AppMethodBeat.o(92675);
  }
  
  public final void d(long paramLong, boolean paramBoolean)
  {
    AppMethodBeat.i(92676);
    long l = paramLong;
    if (paramLong == -9223372036854775807L) {
      l = this.bwt;
    }
    if (((this.bwt == l) && (this.bwu == paramBoolean)) || ((this.bwt != -9223372036854775807L) && (l == -9223372036854775807L)))
    {
      AppMethodBeat.o(92676);
      return;
    }
    e(l, paramBoolean);
    AppMethodBeat.o(92676);
  }
  
  public final void vn() {}
  
  public final void vo()
  {
    this.bvG = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.google.android.exoplayer2.source.g
 * JD-Core Version:    0.7.0.1
 */