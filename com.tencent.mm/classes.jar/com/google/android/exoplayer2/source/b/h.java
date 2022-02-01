package com.google.android.exoplayer2.source.b;

import android.net.Uri;
import android.os.Handler;
import com.google.android.exoplayer2.f;
import com.google.android.exoplayer2.h.g.a;
import com.google.android.exoplayer2.h.t;
import com.google.android.exoplayer2.h.t.d;
import com.google.android.exoplayer2.h.u;
import com.google.android.exoplayer2.h.u.a;
import com.google.android.exoplayer2.i.a;
import com.google.android.exoplayer2.source.b.a.c;
import com.google.android.exoplayer2.source.b.a.e.a;
import com.google.android.exoplayer2.source.b.a.e.e;
import com.google.android.exoplayer2.source.k;
import com.google.android.exoplayer2.source.k.a;
import com.google.android.exoplayer2.source.k.b;
import com.google.android.exoplayer2.source.m;
import com.google.android.exoplayer2.source.p;
import com.google.android.exoplayer2.w;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collection;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.List;

public final class h
  implements e.e, k
{
  private k.a bvB;
  private final int bvE;
  private com.google.android.exoplayer2.source.b.a.e bxz;
  private final d byk;
  private final com.google.android.exoplayer2.source.b.a byl;
  private final Uri bys;
  private final u.a<c> byt;
  
  static
  {
    AppMethodBeat.i(62860);
    com.google.android.exoplayer2.j.bb("goog.exo.hls");
    AppMethodBeat.o(62860);
  }
  
  public h(Uri paramUri, g.a parama, Handler paramHandler, com.google.android.exoplayer2.source.b paramb)
  {
    this(paramUri, parama, paramHandler, paramb, (byte)0);
  }
  
  private h(Uri paramUri, g.a parama, Handler paramHandler, com.google.android.exoplayer2.source.b paramb, byte paramByte)
  {
    this(paramUri, new b(parama), paramHandler, paramb);
    AppMethodBeat.i(62851);
    AppMethodBeat.o(62851);
  }
  
  private h(Uri paramUri, d paramd, int paramInt, Handler paramHandler, com.google.android.exoplayer2.source.b paramb, u.a<c> parama)
  {
    AppMethodBeat.i(193637);
    this.bys = paramUri;
    this.byk = paramd;
    this.bvE = 3;
    this.byt = parama;
    this.byl = new com.google.android.exoplayer2.source.b.a(paramHandler, paramb);
    AppMethodBeat.o(193637);
  }
  
  private h(Uri paramUri, d paramd, Handler paramHandler, com.google.android.exoplayer2.source.b paramb)
  {
    this(paramUri, paramd, 3, paramHandler, paramb, new com.google.android.exoplayer2.source.b.a.d());
    AppMethodBeat.i(62852);
    AppMethodBeat.o(62852);
  }
  
  public final com.google.android.exoplayer2.source.j a(k.b paramb, com.google.android.exoplayer2.h.b paramb1)
  {
    AppMethodBeat.i(62856);
    if (paramb.bwx == 0) {}
    for (boolean bool = true;; bool = false)
    {
      a.checkArgument(bool);
      paramb = new g(this.bxz, this.byk, this.bvE, this.byl, paramb1);
      AppMethodBeat.o(62856);
      return paramb;
    }
  }
  
  public final void a(f paramf, k.a parama)
  {
    AppMethodBeat.i(62854);
    if (this.bxz == null) {}
    for (boolean bool = true;; bool = false)
    {
      a.checkState(bool);
      this.bxz = new com.google.android.exoplayer2.source.b.a.e(this.bys, this.byk, this.byl, this.bvE, this, this.byt);
      this.bvB = parama;
      paramf = this.bxz;
      parama = new u(paramf.byk.vO(), paramf.bzH, paramf.byt);
      paramf.bzM.a(parama, paramf, paramf.bzI);
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
    if (paramb.byY)
    {
      l2 = 0L;
      if (!paramb.byY) {
        break label184;
      }
      l3 = com.google.android.exoplayer2.b.v(paramb.bxn);
      l1 = paramb.byR;
      if (!this.bxz.bzP) {
        break label236;
      }
      if (!paramb.byX) {
        break label192;
      }
      l4 = paramb.bxn;
      l4 = paramb.bdJ + l4;
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
      l1 = paramb.bdJ;
      l6 = paramb.bxn;
      if (paramb.byX) {
        break label230;
      }
      bool = true;
    }
    label121:
    for (Object localObject = new p(l2, l3, l4, l1, l6, l5, true, bool);; localObject = new p(l2, l3, paramb.bxn + paramb.bdJ, paramb.bdJ, paramb.bxn, l4, true, false))
    {
      this.bvB.a((w)localObject, new e(this.bxz.bxQ, paramb));
      AppMethodBeat.o(62859);
      return;
      l2 = -9223372036854775807L;
      break;
      l3 = -9223372036854775807L;
      break label31;
      l4 = -9223372036854775807L;
      break label68;
      l1 = ((com.google.android.exoplayer2.source.b.a.b.a)((List)localObject).get(Math.max(0, ((List)localObject).size() - 3))).bzb;
      break label97;
      bool = false;
      break label121;
      l4 = l1;
      if (l1 == -9223372036854775807L) {
        l4 = 0L;
      }
    }
  }
  
  public final void b(com.google.android.exoplayer2.source.j paramj)
  {
    AppMethodBeat.i(62857);
    paramj = (g)paramj;
    paramj.bxz.listeners.remove(paramj);
    paramj.byn.removeCallbacksAndMessages(null);
    paramj = paramj.byp;
    int k = paramj.length;
    int i = 0;
    while (i < k)
    {
      t.d locald = paramj[i];
      boolean bool = locald.bvK.a(locald);
      if ((locald.bcY) && (!bool))
      {
        m[] arrayOfm = locald.bvQ;
        int m = arrayOfm.length;
        int j = 0;
        while (j < m)
        {
          arrayOfm[j].vL();
          j += 1;
        }
      }
      locald.handler.removeCallbacksAndMessages(null);
      locald.released = true;
      i += 1;
    }
    AppMethodBeat.o(62857);
  }
  
  public final void vt()
  {
    AppMethodBeat.i(62855);
    com.google.android.exoplayer2.source.b.a.e locale = this.bxz;
    if (locale.bzN != null) {
      locale.d(locale.bzN);
    }
    AppMethodBeat.o(62855);
  }
  
  public final void vu()
  {
    AppMethodBeat.i(62858);
    if (this.bxz != null)
    {
      com.google.android.exoplayer2.source.b.a.e locale = this.bxz;
      locale.bzM.a(null);
      Iterator localIterator = locale.bzJ.values().iterator();
      while (localIterator.hasNext()) {
        ((e.a)localIterator.next()).bzR.a(null);
      }
      locale.bzK.removeCallbacksAndMessages(null);
      locale.bzJ.clear();
      this.bxz = null;
    }
    this.bvB = null;
    AppMethodBeat.o(62858);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.google.android.exoplayer2.source.b.h
 * JD-Core Version:    0.7.0.1
 */