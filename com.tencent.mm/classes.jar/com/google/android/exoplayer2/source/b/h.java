package com.google.android.exoplayer2.source.b;

import android.net.Uri;
import android.os.Handler;
import com.google.android.exoplayer2.f;
import com.google.android.exoplayer2.h.g.a;
import com.google.android.exoplayer2.h.t;
import com.google.android.exoplayer2.h.t.d;
import com.google.android.exoplayer2.h.v;
import com.google.android.exoplayer2.h.v.a;
import com.google.android.exoplayer2.source.a.a;
import com.google.android.exoplayer2.source.b.a.b.a;
import com.google.android.exoplayer2.source.b.a.c;
import com.google.android.exoplayer2.source.b.a.e.a;
import com.google.android.exoplayer2.source.b.a.e.e;
import com.google.android.exoplayer2.source.i;
import com.google.android.exoplayer2.source.j.a;
import com.google.android.exoplayer2.source.j.b;
import com.google.android.exoplayer2.source.l;
import com.google.android.exoplayer2.source.o;
import com.google.android.exoplayer2.w;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collection;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.List;

public final class h
  implements e.e, com.google.android.exoplayer2.source.j
{
  private j.a bkG;
  private final int bkJ;
  private final a.a bmE;
  private final Uri bnr;
  private com.google.android.exoplayer2.source.b.a.e boL;
  private final d bpq;
  private final v.a<c> bpw;
  
  static
  {
    AppMethodBeat.i(62860);
    com.google.android.exoplayer2.j.ah("goog.exo.hls");
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
  
  private h(Uri paramUri, d paramd, Handler paramHandler, com.google.android.exoplayer2.source.a parama, v.a<c> parama1)
  {
    AppMethodBeat.i(62853);
    this.bnr = paramUri;
    this.bpq = paramd;
    this.bkJ = 3;
    this.bpw = parama1;
    this.bmE = new a.a(paramHandler, parama);
    AppMethodBeat.o(62853);
  }
  
  public final i a(j.b paramb, com.google.android.exoplayer2.h.b paramb1)
  {
    AppMethodBeat.i(62856);
    if (paramb.blw == 0) {}
    for (boolean bool = true;; bool = false)
    {
      com.google.android.exoplayer2.i.a.checkArgument(bool);
      paramb = new g(this.boL, this.bpq, this.bkJ, this.bmE, paramb1);
      AppMethodBeat.o(62856);
      return paramb;
    }
  }
  
  public final void a(f paramf, j.a parama)
  {
    AppMethodBeat.i(62854);
    if (this.boL == null) {}
    for (boolean bool = true;; bool = false)
    {
      com.google.android.exoplayer2.i.a.checkState(bool);
      this.boL = new com.google.android.exoplayer2.source.b.a.e(this.bnr, this.bpq, this.bmE, this.bkJ, this, this.bpw);
      this.bkG = parama;
      paramf = this.boL;
      parama = new v(paramf.bpq.uo(), paramf.bqK, 4, paramf.bpw);
      paramf.bqP.a(parama, paramf, paramf.bqL);
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
    if (paramb.bqa)
    {
      l2 = 0L;
      if (!paramb.bqa) {
        break label184;
      }
      l3 = com.google.android.exoplayer2.b.t(paramb.bmp);
      l1 = paramb.bpT;
      if (!this.boL.bqS) {
        break label236;
      }
      if (!paramb.bpZ) {
        break label192;
      }
      l4 = paramb.bmp;
      l4 = paramb.aSz + l4;
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
      l1 = paramb.aSz;
      l6 = paramb.bmp;
      if (paramb.bpZ) {
        break label230;
      }
      bool = true;
    }
    label121:
    for (Object localObject = new o(l2, l3, l4, l1, l6, l5, true, bool);; localObject = new o(l2, l3, paramb.bmp + paramb.aSz, paramb.aSz, paramb.bmp, l4, true, false))
    {
      this.bkG.a((w)localObject, new e(this.boL.boY, paramb));
      AppMethodBeat.o(62859);
      return;
      l2 = -9223372036854775807L;
      break;
      l3 = -9223372036854775807L;
      break label31;
      l4 = -9223372036854775807L;
      break label68;
      l1 = ((b.a)((List)localObject).get(Math.max(0, ((List)localObject).size() - 3))).bqe;
      break label97;
      bool = false;
      break label121;
      l4 = l1;
      if (l1 == -9223372036854775807L) {
        l4 = 0L;
      }
    }
  }
  
  public final void b(i parami)
  {
    AppMethodBeat.i(62857);
    parami = (g)parami;
    parami.boL.listeners.remove(parami);
    parami.bps.removeCallbacksAndMessages(null);
    parami = parami.bpu;
    int k = parami.length;
    int i = 0;
    while (i < k)
    {
      t.d locald = parami[i];
      boolean bool = locald.bkP.a(locald);
      if ((locald.aRL) && (!bool))
      {
        l[] arrayOfl = locald.bkV;
        int m = arrayOfl.length;
        int j = 0;
        while (j < m)
        {
          arrayOfl[j].tZ();
          j += 1;
        }
      }
      locald.handler.removeCallbacksAndMessages(null);
      locald.released = true;
      i += 1;
    }
    AppMethodBeat.o(62857);
  }
  
  public final void tG()
  {
    AppMethodBeat.i(62855);
    com.google.android.exoplayer2.source.b.a.e locale = this.boL;
    if (locale.bqQ != null) {
      locale.d(locale.bqQ);
    }
    AppMethodBeat.o(62855);
  }
  
  public final void tH()
  {
    AppMethodBeat.i(62858);
    if (this.boL != null)
    {
      com.google.android.exoplayer2.source.b.a.e locale = this.boL;
      locale.bqP.a(null);
      Iterator localIterator = locale.bqM.values().iterator();
      while (localIterator.hasNext()) {
        ((e.a)localIterator.next()).bqU.a(null);
      }
      locale.bqN.removeCallbacksAndMessages(null);
      locale.bqM.clear();
      this.boL = null;
    }
    this.bkG = null;
    AppMethodBeat.o(62858);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.exoplayer2.source.b.h
 * JD-Core Version:    0.7.0.1
 */