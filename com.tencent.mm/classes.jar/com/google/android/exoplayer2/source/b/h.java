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
  private k.a cYW;
  private final int cYZ;
  private com.google.android.exoplayer2.source.b.a.e daV;
  private final d dbG;
  private final com.google.android.exoplayer2.source.b.a dbH;
  private final Uri dbO;
  private final u.a<c> dbP;
  
  static
  {
    AppMethodBeat.i(62860);
    com.google.android.exoplayer2.j.cE("goog.exo.hls");
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
    AppMethodBeat.i(210361);
    this.dbO = paramUri;
    this.dbG = paramd;
    this.cYZ = 3;
    this.dbP = parama;
    this.dbH = new com.google.android.exoplayer2.source.b.a(paramHandler, paramb);
    AppMethodBeat.o(210361);
  }
  
  private h(Uri paramUri, d paramd, Handler paramHandler, com.google.android.exoplayer2.source.b paramb)
  {
    this(paramUri, paramd, 3, paramHandler, paramb, new com.google.android.exoplayer2.source.b.a.d());
    AppMethodBeat.i(62852);
    AppMethodBeat.o(62852);
  }
  
  public final void SU()
  {
    AppMethodBeat.i(62855);
    com.google.android.exoplayer2.source.b.a.e locale = this.daV;
    locale.ddh.Un();
    if (locale.ddi != null) {
      locale.d(locale.ddi);
    }
    AppMethodBeat.o(62855);
  }
  
  public final void SV()
  {
    AppMethodBeat.i(62858);
    if (this.daV != null)
    {
      com.google.android.exoplayer2.source.b.a.e locale = this.daV;
      locale.ddh.a(null);
      Iterator localIterator = locale.dde.values().iterator();
      while (localIterator.hasNext()) {
        ((e.a)localIterator.next()).ddm.a(null);
      }
      locale.ddf.removeCallbacksAndMessages(null);
      locale.dde.clear();
      this.daV = null;
    }
    this.cYW = null;
    AppMethodBeat.o(62858);
  }
  
  public final com.google.android.exoplayer2.source.j a(k.b paramb, com.google.android.exoplayer2.h.b paramb1)
  {
    AppMethodBeat.i(62856);
    if (paramb.cZS == 0) {}
    for (boolean bool = true;; bool = false)
    {
      a.checkArgument(bool);
      paramb = new g(this.daV, this.dbG, this.cYZ, this.dbH, paramb1);
      AppMethodBeat.o(62856);
      return paramb;
    }
  }
  
  public final void a(f paramf, k.a parama)
  {
    AppMethodBeat.i(62854);
    if (this.daV == null) {}
    for (boolean bool = true;; bool = false)
    {
      a.checkState(bool);
      this.daV = new com.google.android.exoplayer2.source.b.a.e(this.dbO, this.dbG, this.dbH, this.cYZ, this, this.dbP);
      this.cYW = parama;
      paramf = this.daV;
      parama = new u(paramf.dbG.Tp(), paramf.ddc, paramf.dbP);
      paramf.ddh.a(parama, paramf, paramf.ddd);
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
    if (paramb.dct)
    {
      l2 = 0L;
      if (!paramb.dct) {
        break label184;
      }
      l3 = com.google.android.exoplayer2.b.bM(paramb.daJ);
      l1 = paramb.dcm;
      if (!this.daV.ddk) {
        break label236;
      }
      if (!paramb.dcs) {
        break label192;
      }
      l4 = paramb.daJ;
      l4 = paramb.cHg + l4;
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
      l1 = paramb.cHg;
      l6 = paramb.daJ;
      if (paramb.dcs) {
        break label230;
      }
      bool = true;
    }
    label121:
    for (Object localObject = new p(l2, l3, l4, l1, l6, l5, true, bool);; localObject = new p(l2, l3, paramb.daJ + paramb.cHg, paramb.cHg, paramb.daJ, l4, true, false))
    {
      this.cYW.a((w)localObject, new e(this.daV.dbl, paramb));
      AppMethodBeat.o(62859);
      return;
      l2 = -9223372036854775807L;
      break;
      l3 = -9223372036854775807L;
      break label31;
      l4 = -9223372036854775807L;
      break label68;
      l1 = ((com.google.android.exoplayer2.source.b.a.b.a)((List)localObject).get(Math.max(0, ((List)localObject).size() - 3))).dcw;
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
    paramj.daV.listeners.remove(paramj);
    paramj.dbJ.removeCallbacksAndMessages(null);
    paramj = paramj.dbL;
    int k = paramj.length;
    int i = 0;
    while (i < k)
    {
      t.d locald = paramj[i];
      boolean bool = locald.cZf.a(locald);
      if ((locald.cGv) && (!bool))
      {
        m[] arrayOfm = locald.cZl;
        int m = arrayOfm.length;
        int j = 0;
        while (j < m)
        {
          arrayOfm[j].Tm();
          j += 1;
        }
      }
      locald.handler.removeCallbacksAndMessages(null);
      locald.released = true;
      i += 1;
    }
    AppMethodBeat.o(62857);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.google.android.exoplayer2.source.b.h
 * JD-Core Version:    0.7.0.1
 */