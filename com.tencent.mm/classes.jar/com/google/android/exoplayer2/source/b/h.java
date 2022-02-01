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
  private k.a bfd;
  private final int bfg;
  private final d bhM;
  private final com.google.android.exoplayer2.source.b.a bhN;
  private final Uri bhU;
  private final u.a<c> bhV;
  private com.google.android.exoplayer2.source.b.a.e bhb;
  
  static
  {
    AppMethodBeat.i(62860);
    com.google.android.exoplayer2.j.bm("goog.exo.hls");
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
    AppMethodBeat.i(210893);
    this.bhU = paramUri;
    this.bhM = paramd;
    this.bfg = 3;
    this.bhV = parama;
    this.bhN = new com.google.android.exoplayer2.source.b.a(paramHandler, paramb);
    AppMethodBeat.o(210893);
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
    if (paramb.bfZ == 0) {}
    for (boolean bool = true;; bool = false)
    {
      a.checkArgument(bool);
      paramb = new g(this.bhb, this.bhM, this.bfg, this.bhN, paramb1);
      AppMethodBeat.o(62856);
      return paramb;
    }
  }
  
  public final void a(f paramf, k.a parama)
  {
    AppMethodBeat.i(62854);
    if (this.bhb == null) {}
    for (boolean bool = true;; bool = false)
    {
      a.checkState(bool);
      this.bhb = new com.google.android.exoplayer2.source.b.a.e(this.bhU, this.bhM, this.bhN, this.bfg, this, this.bhV);
      this.bfd = parama;
      paramf = this.bhb;
      parama = new u(paramf.bhM.tM(), paramf.bji, paramf.bhV);
      paramf.bjn.a(parama, paramf, paramf.bjj);
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
    if (paramb.biz)
    {
      l2 = 0L;
      if (!paramb.biz) {
        break label184;
      }
      l3 = com.google.android.exoplayer2.b.y(paramb.bgP);
      l1 = paramb.bis;
      if (!this.bhb.bjq) {
        break label236;
      }
      if (!paramb.biy) {
        break label192;
      }
      l4 = paramb.bgP;
      l4 = paramb.aNk + l4;
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
      l1 = paramb.aNk;
      l6 = paramb.bgP;
      if (paramb.biy) {
        break label230;
      }
      bool = true;
    }
    label121:
    for (Object localObject = new p(l2, l3, l4, l1, l6, l5, true, bool);; localObject = new p(l2, l3, paramb.bgP + paramb.aNk, paramb.aNk, paramb.bgP, l4, true, false))
    {
      this.bfd.a((w)localObject, new e(this.bhb.bhs, paramb));
      AppMethodBeat.o(62859);
      return;
      l2 = -9223372036854775807L;
      break;
      l3 = -9223372036854775807L;
      break label31;
      l4 = -9223372036854775807L;
      break label68;
      l1 = ((com.google.android.exoplayer2.source.b.a.b.a)((List)localObject).get(Math.max(0, ((List)localObject).size() - 3))).biC;
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
    paramj.bhb.listeners.remove(paramj);
    paramj.bhP.removeCallbacksAndMessages(null);
    paramj = paramj.bhR;
    int k = paramj.length;
    int i = 0;
    while (i < k)
    {
      t.d locald = paramj[i];
      boolean bool = locald.bfm.a(locald);
      if ((locald.aMy) && (!bool))
      {
        m[] arrayOfm = locald.bfs;
        int m = arrayOfm.length;
        int j = 0;
        while (j < m)
        {
          arrayOfm[j].tJ();
          j += 1;
        }
      }
      locald.handler.removeCallbacksAndMessages(null);
      locald.released = true;
      i += 1;
    }
    AppMethodBeat.o(62857);
  }
  
  public final void tr()
  {
    AppMethodBeat.i(62855);
    com.google.android.exoplayer2.source.b.a.e locale = this.bhb;
    locale.bjn.uO();
    if (locale.bjo != null) {
      locale.d(locale.bjo);
    }
    AppMethodBeat.o(62855);
  }
  
  public final void ts()
  {
    AppMethodBeat.i(62858);
    if (this.bhb != null)
    {
      com.google.android.exoplayer2.source.b.a.e locale = this.bhb;
      locale.bjn.a(null);
      Iterator localIterator = locale.bjk.values().iterator();
      while (localIterator.hasNext()) {
        ((e.a)localIterator.next()).bjs.a(null);
      }
      locale.bjl.removeCallbacksAndMessages(null);
      locale.bjk.clear();
      this.bhb = null;
    }
    this.bfd = null;
    AppMethodBeat.o(62858);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.google.android.exoplayer2.source.b.h
 * JD-Core Version:    0.7.0.1
 */