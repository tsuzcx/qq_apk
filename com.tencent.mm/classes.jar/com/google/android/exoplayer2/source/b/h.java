package com.google.android.exoplayer2.source.b;

import android.net.Uri;
import android.os.Handler;
import com.google.android.exoplayer2.f;
import com.google.android.exoplayer2.h.g.a;
import com.google.android.exoplayer2.h.t;
import com.google.android.exoplayer2.h.t.d;
import com.google.android.exoplayer2.h.u;
import com.google.android.exoplayer2.h.u.a;
import com.google.android.exoplayer2.source.a.a;
import com.google.android.exoplayer2.source.b.a.b.a;
import com.google.android.exoplayer2.source.b.a.c;
import com.google.android.exoplayer2.source.b.a.e.a;
import com.google.android.exoplayer2.source.b.a.e.e;
import com.google.android.exoplayer2.source.i;
import com.google.android.exoplayer2.source.i.a;
import com.google.android.exoplayer2.source.i.b;
import com.google.android.exoplayer2.source.k;
import com.google.android.exoplayer2.source.n;
import com.google.android.exoplayer2.w;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collection;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.List;

public final class h
  implements e.e, i
{
  private i.a aPg;
  private final int aPj;
  private com.google.android.exoplayer2.source.b.a.e aQY;
  private final d aRI;
  private final a.a aRJ;
  private final Uri aRQ;
  private final u.a<c> aRR;
  
  static
  {
    AppMethodBeat.i(125936);
    com.google.android.exoplayer2.j.ak("goog.exo.hls");
    AppMethodBeat.o(125936);
  }
  
  public h(Uri paramUri, g.a parama, Handler paramHandler, com.google.android.exoplayer2.source.a parama1)
  {
    this(paramUri, parama, paramHandler, parama1, (byte)0);
  }
  
  private h(Uri paramUri, g.a parama, Handler paramHandler, com.google.android.exoplayer2.source.a parama1, byte paramByte)
  {
    this(paramUri, new b(parama), paramHandler, parama1);
    AppMethodBeat.i(125927);
    AppMethodBeat.o(125927);
  }
  
  private h(Uri paramUri, d paramd, Handler paramHandler, com.google.android.exoplayer2.source.a parama)
  {
    this(paramUri, paramd, paramHandler, parama, new com.google.android.exoplayer2.source.b.a.d());
    AppMethodBeat.i(125928);
    AppMethodBeat.o(125928);
  }
  
  private h(Uri paramUri, d paramd, Handler paramHandler, com.google.android.exoplayer2.source.a parama, u.a<c> parama1)
  {
    AppMethodBeat.i(125929);
    this.aRQ = paramUri;
    this.aRI = paramd;
    this.aPj = 3;
    this.aRR = parama1;
    this.aRJ = new a.a(paramHandler, parama);
    AppMethodBeat.o(125929);
  }
  
  public final com.google.android.exoplayer2.source.h a(i.b paramb, com.google.android.exoplayer2.h.b paramb1)
  {
    AppMethodBeat.i(125932);
    if (paramb.aPX == 0) {}
    for (boolean bool = true;; bool = false)
    {
      com.google.android.exoplayer2.i.a.checkArgument(bool);
      paramb = new g(this.aQY, this.aRI, this.aPj, this.aRJ, paramb1);
      AppMethodBeat.o(125932);
      return paramb;
    }
  }
  
  public final void a(f paramf, i.a parama)
  {
    AppMethodBeat.i(125930);
    if (this.aQY == null) {}
    for (boolean bool = true;; bool = false)
    {
      com.google.android.exoplayer2.i.a.checkState(bool);
      this.aQY = new com.google.android.exoplayer2.source.b.a.e(this.aRQ, this.aRI, this.aRJ, this.aPj, this, this.aRR);
      this.aPg = parama;
      paramf = this.aQY;
      parama = new u(paramf.aRI.pu(), paramf.aTh, paramf.aRR);
      paramf.aTn.a(parama, paramf, paramf.aTi);
      AppMethodBeat.o(125930);
      return;
    }
  }
  
  public final void a(com.google.android.exoplayer2.source.b.a.b paramb)
  {
    AppMethodBeat.i(125935);
    long l2;
    long l3;
    label31:
    long l1;
    long l4;
    label68:
    long l5;
    label97:
    long l6;
    boolean bool;
    if (paramb.aSx)
    {
      l2 = 0L;
      if (!paramb.aSx) {
        break label184;
      }
      l3 = com.google.android.exoplayer2.b.o(paramb.aQM);
      l1 = paramb.aSq;
      if (!this.aQY.aTq) {
        break label236;
      }
      if (!paramb.aSw) {
        break label192;
      }
      l4 = paramb.aQM;
      l4 = paramb.axh + l4;
      localObject = paramb.aSz;
      l5 = l1;
      if (l1 == -9223372036854775807L)
      {
        if (!((List)localObject).isEmpty()) {
          break label200;
        }
        l1 = 0L;
        l5 = l1;
      }
      l1 = paramb.axh;
      l6 = paramb.aQM;
      if (paramb.aSw) {
        break label230;
      }
      bool = true;
    }
    label121:
    for (Object localObject = new n(l2, l3, l4, l1, l6, l5, true, bool);; localObject = new n(l2, l3, paramb.aQM + paramb.axh, paramb.axh, paramb.aQM, l4, true, false))
    {
      this.aPg.a((w)localObject, new e(this.aQY.aRo, paramb));
      AppMethodBeat.o(125935);
      return;
      l2 = -9223372036854775807L;
      break;
      l3 = -9223372036854775807L;
      break label31;
      l4 = -9223372036854775807L;
      break label68;
      l1 = ((b.a)((List)localObject).get(Math.max(0, ((List)localObject).size() - 3))).aSB;
      break label97;
      bool = false;
      break label121;
      l4 = l1;
      if (l1 == -9223372036854775807L) {
        l4 = 0L;
      }
    }
  }
  
  public final void b(com.google.android.exoplayer2.source.h paramh)
  {
    AppMethodBeat.i(125933);
    paramh = (g)paramh;
    paramh.aQY.aTm.remove(paramh);
    paramh.aRL.removeCallbacksAndMessages(null);
    paramh = paramh.aRN;
    int k = paramh.length;
    int i = 0;
    while (i < k)
    {
      t.d locald = paramh[i];
      boolean bool = locald.aPp.a(locald);
      if ((locald.prepared) && (!bool))
      {
        k[] arrayOfk = locald.aPv;
        int m = arrayOfk.length;
        int j = 0;
        while (j < m)
        {
          arrayOfk[j].pr();
          j += 1;
        }
      }
      locald.handler.removeCallbacksAndMessages(null);
      locald.released = true;
      i += 1;
    }
    AppMethodBeat.o(125933);
  }
  
  public final void oY()
  {
    AppMethodBeat.i(125931);
    com.google.android.exoplayer2.source.b.a.e locale = this.aQY;
    if (locale.aTo != null) {
      locale.d(locale.aTo);
    }
    AppMethodBeat.o(125931);
  }
  
  public final void oZ()
  {
    AppMethodBeat.i(125934);
    if (this.aQY != null)
    {
      com.google.android.exoplayer2.source.b.a.e locale = this.aQY;
      locale.aTn.a(null);
      Iterator localIterator = locale.aTj.values().iterator();
      while (localIterator.hasNext()) {
        ((e.a)localIterator.next()).aTs.a(null);
      }
      locale.aTk.removeCallbacksAndMessages(null);
      locale.aTj.clear();
      this.aQY = null;
    }
    this.aPg = null;
    AppMethodBeat.o(125934);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.google.android.exoplayer2.source.b.h
 * JD-Core Version:    0.7.0.1
 */