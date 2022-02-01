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
  private final w.a bci;
  private k.a bvB;
  private final int bvE;
  private final a bvF;
  private final String bvI;
  private final g.a bwl;
  private final com.google.android.exoplayer2.c.h bwm;
  private final int bwn;
  private long bwo;
  private boolean bwp;
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
    AppMethodBeat.i(196043);
    this.uri = paramUri;
    this.bwl = parama;
    this.bwm = paramh;
    this.bvE = -1;
    this.eventHandler = paramHandler;
    this.bvF = parama1;
    this.bvI = paramString;
    this.bwn = 1048576;
    this.bci = new w.a();
    AppMethodBeat.o(196043);
  }
  
  private void e(long paramLong, boolean paramBoolean)
  {
    AppMethodBeat.i(92677);
    this.bwo = paramLong;
    this.bwp = paramBoolean;
    this.bvB.a(new p(this.bwo, this.bwp), null);
    AppMethodBeat.o(92677);
  }
  
  public final j a(k.b paramb, b paramb1)
  {
    AppMethodBeat.i(92674);
    if (paramb.bwx == 0) {}
    for (boolean bool = true;; bool = false)
    {
      a.checkArgument(bool);
      paramb = new g(this.uri, this.bwl.wG(), this.bwm.ux(), this.bvE, this.eventHandler, this.bvF, this, paramb1, this.bvI, this.bwn);
      AppMethodBeat.o(92674);
      return paramb;
    }
  }
  
  public final void a(f paramf, k.a parama)
  {
    AppMethodBeat.i(92673);
    this.bvB = parama;
    e(-9223372036854775807L, false);
    AppMethodBeat.o(92673);
  }
  
  public final void b(j paramj)
  {
    AppMethodBeat.i(92675);
    paramj = (g)paramj;
    boolean bool = paramj.bvK.a(paramj);
    if ((paramj.bcY) && (!bool))
    {
      m[] arrayOfm = paramj.bvQ;
      int j = arrayOfm.length;
      int i = 0;
      while (i < j)
      {
        arrayOfm[i].vL();
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
      l = this.bwo;
    }
    if (((this.bwo == l) && (this.bwp == paramBoolean)) || ((this.bwo != -9223372036854775807L) && (l == -9223372036854775807L)))
    {
      AppMethodBeat.o(92676);
      return;
    }
    e(l, paramBoolean);
    AppMethodBeat.o(92676);
  }
  
  public final void vt() {}
  
  public final void vu()
  {
    this.bvB = null;
  }
  
  public static abstract interface a
  {
    public abstract void onLoadError(IOException paramIOException);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.google.android.exoplayer2.source.h
 * JD-Core Version:    0.7.0.1
 */