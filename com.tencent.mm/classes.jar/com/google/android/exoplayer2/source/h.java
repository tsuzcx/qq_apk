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

public final class h
  implements g.c, k
{
  private final w.a cFE;
  private k.a cYW;
  private final int cYZ;
  private final g.a cZG;
  private final com.google.android.exoplayer2.c.h cZH;
  private final int cZI;
  private long cZJ;
  private boolean cZK;
  private final h.a cZa;
  private final String cZd;
  private final Handler eventHandler;
  private final Uri uri;
  
  public h(Uri paramUri, g.a parama, com.google.android.exoplayer2.c.h paramh, Handler paramHandler, h.a parama1)
  {
    this(paramUri, parama, paramh, paramHandler, parama1, null);
  }
  
  public h(Uri paramUri, g.a parama, com.google.android.exoplayer2.c.h paramh, Handler paramHandler, h.a parama1, String paramString)
  {
    this(paramUri, parama, paramh, paramHandler, parama1, paramString, (byte)0);
  }
  
  private h(Uri paramUri, g.a parama, com.google.android.exoplayer2.c.h paramh, Handler paramHandler, h.a parama1, String paramString, byte paramByte)
  {
    AppMethodBeat.i(210353);
    this.uri = paramUri;
    this.cZG = parama;
    this.cZH = paramh;
    this.cYZ = -1;
    this.eventHandler = paramHandler;
    this.cZa = parama1;
    this.cZd = paramString;
    this.cZI = 1048576;
    this.cFE = new w.a();
    AppMethodBeat.o(210353);
  }
  
  private void j(long paramLong, boolean paramBoolean)
  {
    AppMethodBeat.i(92677);
    this.cZJ = paramLong;
    this.cZK = paramBoolean;
    this.cYW.a(new p(this.cZJ, this.cZK), null);
    AppMethodBeat.o(92677);
  }
  
  public final void SU() {}
  
  public final void SV()
  {
    this.cYW = null;
  }
  
  public final j a(k.b paramb, b paramb1)
  {
    AppMethodBeat.i(92674);
    if (paramb.cZS == 0) {}
    for (boolean bool = true;; bool = false)
    {
      a.checkArgument(bool);
      paramb = new g(this.uri, this.cZG.createDataSource(), this.cZH.RV(), this.cYZ, this.eventHandler, this.cZa, this, paramb1, this.cZd, this.cZI);
      AppMethodBeat.o(92674);
      return paramb;
    }
  }
  
  public final void a(f paramf, k.a parama)
  {
    AppMethodBeat.i(92673);
    this.cYW = parama;
    j(-9223372036854775807L, false);
    AppMethodBeat.o(92673);
  }
  
  public final void b(j paramj)
  {
    AppMethodBeat.i(92675);
    paramj = (g)paramj;
    boolean bool = paramj.cZf.a(paramj);
    if ((paramj.cGv) && (!bool))
    {
      m[] arrayOfm = paramj.cZl;
      int j = arrayOfm.length;
      int i = 0;
      while (i < j)
      {
        arrayOfm[i].Tm();
        i += 1;
      }
    }
    paramj.handler.removeCallbacksAndMessages(null);
    paramj.released = true;
    AppMethodBeat.o(92675);
  }
  
  public final void i(long paramLong, boolean paramBoolean)
  {
    AppMethodBeat.i(92676);
    long l = paramLong;
    if (paramLong == -9223372036854775807L) {
      l = this.cZJ;
    }
    if (((this.cZJ == l) && (this.cZK == paramBoolean)) || ((this.cZJ != -9223372036854775807L) && (l == -9223372036854775807L)))
    {
      AppMethodBeat.o(92676);
      return;
    }
    j(l, paramBoolean);
    AppMethodBeat.o(92676);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.google.android.exoplayer2.source.h
 * JD-Core Version:    0.7.0.1
 */