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
  private i.a bvG;
  private final int bvJ;
  private com.google.android.exoplayer2.source.b.a.e bxy;
  private final d byi;
  private final a.a byj;
  private final Uri byq;
  private final u.a<c> byr;
  
  static
  {
    AppMethodBeat.i(62860);
    com.google.android.exoplayer2.j.bb("goog.exo.hls");
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
    this.byq = paramUri;
    this.byi = paramd;
    this.bvJ = 3;
    this.byr = parama1;
    this.byj = new a.a(paramHandler, parama);
    AppMethodBeat.o(62853);
  }
  
  public final com.google.android.exoplayer2.source.h a(i.b paramb, com.google.android.exoplayer2.h.b paramb1)
  {
    AppMethodBeat.i(62856);
    if (paramb.bww == 0) {}
    for (boolean bool = true;; bool = false)
    {
      com.google.android.exoplayer2.i.a.checkArgument(bool);
      paramb = new g(this.bxy, this.byi, this.bvJ, this.byj, paramb1);
      AppMethodBeat.o(62856);
      return paramb;
    }
  }
  
  public final void a(f paramf, i.a parama)
  {
    AppMethodBeat.i(62854);
    if (this.bxy == null) {}
    for (boolean bool = true;; bool = false)
    {
      com.google.android.exoplayer2.i.a.checkState(bool);
      this.bxy = new com.google.android.exoplayer2.source.b.a.e(this.byq, this.byi, this.byj, this.bvJ, this, this.byr);
      this.bvG = parama;
      paramf = this.bxy;
      parama = new u(paramf.byi.vJ(), paramf.bzF, paramf.byr);
      paramf.bzK.a(parama, paramf, paramf.bzG);
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
    if (paramb.byW)
    {
      l2 = 0L;
      if (!paramb.byW) {
        break label184;
      }
      l3 = com.google.android.exoplayer2.b.v(paramb.bxm);
      l1 = paramb.byP;
      if (!this.bxy.bzN) {
        break label236;
      }
      if (!paramb.byV) {
        break label192;
      }
      l4 = paramb.bxm;
      l4 = paramb.bdM + l4;
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
      l1 = paramb.bdM;
      l6 = paramb.bxm;
      if (paramb.byV) {
        break label230;
      }
      bool = true;
    }
    label121:
    for (Object localObject = new n(l2, l3, l4, l1, l6, l5, true, bool);; localObject = new n(l2, l3, paramb.bxm + paramb.bdM, paramb.bdM, paramb.bxm, l4, true, false))
    {
      this.bvG.a((w)localObject, new e(this.bxy.bxO, paramb));
      AppMethodBeat.o(62859);
      return;
      l2 = -9223372036854775807L;
      break;
      l3 = -9223372036854775807L;
      break label31;
      l4 = -9223372036854775807L;
      break label68;
      l1 = ((b.a)((List)localObject).get(Math.max(0, ((List)localObject).size() - 3))).byZ;
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
    paramh.bxy.listeners.remove(paramh);
    paramh.byl.removeCallbacksAndMessages(null);
    paramh = paramh.byn;
    int k = paramh.length;
    int i = 0;
    while (i < k)
    {
      t.d locald = paramh[i];
      boolean bool = locald.bvP.a(locald);
      if ((locald.bdb) && (!bool))
      {
        k[] arrayOfk = locald.bvV;
        int m = arrayOfk.length;
        int j = 0;
        while (j < m)
        {
          arrayOfk[j].vG();
          j += 1;
        }
      }
      locald.handler.removeCallbacksAndMessages(null);
      locald.released = true;
      i += 1;
    }
    AppMethodBeat.o(62857);
  }
  
  public final void vn()
  {
    AppMethodBeat.i(62855);
    com.google.android.exoplayer2.source.b.a.e locale = this.bxy;
    if (locale.bzL != null) {
      locale.d(locale.bzL);
    }
    AppMethodBeat.o(62855);
  }
  
  public final void vo()
  {
    AppMethodBeat.i(62858);
    if (this.bxy != null)
    {
      com.google.android.exoplayer2.source.b.a.e locale = this.bxy;
      locale.bzK.a(null);
      Iterator localIterator = locale.bzH.values().iterator();
      while (localIterator.hasNext()) {
        ((e.a)localIterator.next()).bzP.a(null);
      }
      locale.bzI.removeCallbacksAndMessages(null);
      locale.bzH.clear();
      this.bxy = null;
    }
    this.bvG = null;
    AppMethodBeat.o(62858);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.google.android.exoplayer2.source.b.h
 * JD-Core Version:    0.7.0.1
 */