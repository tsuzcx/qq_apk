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
  private i.a bll;
  private final int blo;
  private final d bnN;
  private final a.a bnO;
  private final Uri bnV;
  private final u.a<c> bnW;
  private com.google.android.exoplayer2.source.b.a.e bnd;
  
  static
  {
    AppMethodBeat.i(62860);
    com.google.android.exoplayer2.j.ai("goog.exo.hls");
    AppMethodBeat.o(62860);
  }
  
  public h(Uri paramUri, g.a parama, Handler paramHandler, com.google.android.exoplayer2.source.a parama1)
  {
    this(paramUri, parama, paramHandler, parama1, (byte)0);
  }
  
  private h(Uri paramUri, g.a parama, Handler paramHandler, com.google.android.exoplayer2.source.a parama1, byte paramByte)
  {
    this(paramUri, new b(parama), paramHandler, parama1);
    AppMethodBeat.i(62851);
    AppMethodBeat.o(62851);
  }
  
  private h(Uri paramUri, d paramd, Handler paramHandler, com.google.android.exoplayer2.source.a parama)
  {
    this(paramUri, paramd, paramHandler, parama, new com.google.android.exoplayer2.source.b.a.d());
    AppMethodBeat.i(62852);
    AppMethodBeat.o(62852);
  }
  
  private h(Uri paramUri, d paramd, Handler paramHandler, com.google.android.exoplayer2.source.a parama, u.a<c> parama1)
  {
    AppMethodBeat.i(62853);
    this.bnV = paramUri;
    this.bnN = paramd;
    this.blo = 3;
    this.bnW = parama1;
    this.bnO = new a.a(paramHandler, parama);
    AppMethodBeat.o(62853);
  }
  
  public final com.google.android.exoplayer2.source.h a(i.b paramb, com.google.android.exoplayer2.h.b paramb1)
  {
    AppMethodBeat.i(62856);
    if (paramb.bmb == 0) {}
    for (boolean bool = true;; bool = false)
    {
      com.google.android.exoplayer2.i.a.checkArgument(bool);
      paramb = new g(this.bnd, this.bnN, this.blo, this.bnO, paramb1);
      AppMethodBeat.o(62856);
      return paramb;
    }
  }
  
  public final void a(f paramf, i.a parama)
  {
    AppMethodBeat.i(62854);
    if (this.bnd == null) {}
    for (boolean bool = true;; bool = false)
    {
      com.google.android.exoplayer2.i.a.checkState(bool);
      this.bnd = new com.google.android.exoplayer2.source.b.a.e(this.bnV, this.bnN, this.bnO, this.blo, this, this.bnW);
      this.bll = parama;
      paramf = this.bnd;
      parama = new u(paramf.bnN.uk(), paramf.bpk, paramf.bnW);
      paramf.bpp.a(parama, paramf, paramf.bpl);
      AppMethodBeat.o(62854);
      return;
    }
  }
  
  public final void a(com.google.android.exoplayer2.source.b.a.b paramb)
  {
    AppMethodBeat.i(62859);
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
    if (paramb.boB)
    {
      l2 = 0L;
      if (!paramb.boB) {
        break label184;
      }
      l3 = com.google.android.exoplayer2.b.v(paramb.bmR);
      l1 = paramb.bou;
      if (!this.bnd.bps) {
        break label236;
      }
      if (!paramb.boA) {
        break label192;
      }
      l4 = paramb.bmR;
      l4 = paramb.aTs + l4;
      localObject = paramb.segments;
      l5 = l1;
      if (l1 == -9223372036854775807L)
      {
        if (!((List)localObject).isEmpty()) {
          break label200;
        }
        l1 = 0L;
        l5 = l1;
      }
      l1 = paramb.aTs;
      l6 = paramb.bmR;
      if (paramb.boA) {
        break label230;
      }
      bool = true;
    }
    label121:
    for (Object localObject = new n(l2, l3, l4, l1, l6, l5, true, bool);; localObject = new n(l2, l3, paramb.bmR + paramb.aTs, paramb.aTs, paramb.bmR, l4, true, false))
    {
      this.bll.a((w)localObject, new e(this.bnd.bnt, paramb));
      AppMethodBeat.o(62859);
      return;
      l2 = -9223372036854775807L;
      break;
      l3 = -9223372036854775807L;
      break label31;
      l4 = -9223372036854775807L;
      break label68;
      l1 = ((b.a)((List)localObject).get(Math.max(0, ((List)localObject).size() - 3))).boE;
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
    AppMethodBeat.i(62857);
    paramh = (g)paramh;
    paramh.bnd.listeners.remove(paramh);
    paramh.bnQ.removeCallbacksAndMessages(null);
    paramh = paramh.bnS;
    int k = paramh.length;
    int i = 0;
    while (i < k)
    {
      t.d locald = paramh[i];
      boolean bool = locald.blu.a(locald);
      if ((locald.aSG) && (!bool))
      {
        k[] arrayOfk = locald.blA;
        int m = arrayOfk.length;
        int j = 0;
        while (j < m)
        {
          arrayOfk[j].uh();
          j += 1;
        }
      }
      locald.handler.removeCallbacksAndMessages(null);
      locald.released = true;
      i += 1;
    }
    AppMethodBeat.o(62857);
  }
  
  public final void tO()
  {
    AppMethodBeat.i(62855);
    com.google.android.exoplayer2.source.b.a.e locale = this.bnd;
    if (locale.bpq != null) {
      locale.d(locale.bpq);
    }
    AppMethodBeat.o(62855);
  }
  
  public final void tP()
  {
    AppMethodBeat.i(62858);
    if (this.bnd != null)
    {
      com.google.android.exoplayer2.source.b.a.e locale = this.bnd;
      locale.bpp.a(null);
      Iterator localIterator = locale.bpm.values().iterator();
      while (localIterator.hasNext()) {
        ((e.a)localIterator.next()).bpu.a(null);
      }
      locale.bpn.removeCallbacksAndMessages(null);
      locale.bpm.clear();
      this.bnd = null;
    }
    this.bll = null;
    AppMethodBeat.o(62858);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.exoplayer2.source.b.h
 * JD-Core Version:    0.7.0.1
 */