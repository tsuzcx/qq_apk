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
  private final com.google.android.exoplayer2.h.g.a aPR;
  private final com.google.android.exoplayer2.c.h aPS;
  private final int aPT;
  private long aPU;
  private boolean aPV;
  private i.a aPg;
  private final int aPj;
  private final g.a aPk;
  private final String aPn;
  private final w.a avD;
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
    AppMethodBeat.i(151940);
    this.uri = paramUri;
    this.aPR = parama;
    this.aPS = paramh;
    this.aPj = -1;
    this.eventHandler = paramHandler;
    this.aPk = parama1;
    this.aPn = null;
    this.aPT = 1048576;
    this.avD = new w.a();
    AppMethodBeat.o(151940);
  }
  
  private void f(long paramLong, boolean paramBoolean)
  {
    AppMethodBeat.i(95511);
    this.aPU = paramLong;
    this.aPV = paramBoolean;
    this.aPg.a(new n(this.aPU, this.aPV), null);
    AppMethodBeat.o(95511);
  }
  
  public final h a(i.b paramb, b paramb1)
  {
    AppMethodBeat.i(95508);
    if (paramb.aPX == 0) {}
    for (boolean bool = true;; bool = false)
    {
      a.checkArgument(bool);
      paramb = new f(this.uri, this.aPR.qn(), this.aPS.nY(), this.aPj, this.eventHandler, this.aPk, this, paramb1, this.aPn, this.aPT);
      AppMethodBeat.o(95508);
      return paramb;
    }
  }
  
  public final void a(com.google.android.exoplayer2.f paramf, i.a parama)
  {
    AppMethodBeat.i(95507);
    this.aPg = parama;
    f(-9223372036854775807L, false);
    AppMethodBeat.o(95507);
  }
  
  public final void b(h paramh)
  {
    AppMethodBeat.i(95509);
    paramh = (f)paramh;
    boolean bool = paramh.aPp.a(paramh);
    if ((paramh.prepared) && (!bool))
    {
      k[] arrayOfk = paramh.aPv;
      int j = arrayOfk.length;
      int i = 0;
      while (i < j)
      {
        arrayOfk[i].pr();
        i += 1;
      }
    }
    paramh.handler.removeCallbacksAndMessages(null);
    paramh.released = true;
    AppMethodBeat.o(95509);
  }
  
  public final void e(long paramLong, boolean paramBoolean)
  {
    AppMethodBeat.i(95510);
    long l = paramLong;
    if (paramLong == -9223372036854775807L) {
      l = this.aPU;
    }
    if (((this.aPU == l) && (this.aPV == paramBoolean)) || ((this.aPU != -9223372036854775807L) && (l == -9223372036854775807L)))
    {
      AppMethodBeat.o(95510);
      return;
    }
    f(l, paramBoolean);
    AppMethodBeat.o(95510);
  }
  
  public final void oY() {}
  
  public final void oZ()
  {
    this.aPg = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.google.android.exoplayer2.source.g
 * JD-Core Version:    0.7.0.1
 */