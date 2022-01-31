package com.google.android.exoplayer2.source.b;

import android.net.Uri;
import android.os.Handler;
import com.google.android.exoplayer2.h.r;
import com.google.android.exoplayer2.h.r.d;
import com.google.android.exoplayer2.h.s;
import com.google.android.exoplayer2.h.s.a;
import com.google.android.exoplayer2.source.a.a;
import com.google.android.exoplayer2.source.b.a.b.a;
import com.google.android.exoplayer2.source.b.a.c;
import com.google.android.exoplayer2.source.b.a.e.a;
import com.google.android.exoplayer2.source.b.a.e.e;
import com.google.android.exoplayer2.source.f;
import com.google.android.exoplayer2.source.f.b;
import com.google.android.exoplayer2.source.k;
import com.google.android.exoplayer2.w;
import java.util.Collection;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.List;

public final class h
  implements e.e, f
{
  private com.google.android.exoplayer2.source.b.a.e aJs;
  private final d aKd;
  private final int aKe;
  private final a.a aKf;
  private final Uri aKm;
  private final s.a<c> aKn;
  private com.google.android.exoplayer2.source.f.a aKo;
  
  static
  {
    com.google.android.exoplayer2.j.ag("goog.exo.hls");
  }
  
  public h(Uri paramUri, com.google.android.exoplayer2.h.f.a parama, Handler paramHandler, com.google.android.exoplayer2.source.a parama1)
  {
    this(paramUri, parama, paramHandler, parama1, (byte)0);
  }
  
  private h(Uri paramUri, com.google.android.exoplayer2.h.f.a parama, Handler paramHandler, com.google.android.exoplayer2.source.a parama1, byte paramByte)
  {
    this(paramUri, new b(parama), paramHandler, parama1);
  }
  
  private h(Uri paramUri, d paramd, Handler paramHandler, com.google.android.exoplayer2.source.a parama)
  {
    this(paramUri, paramd, paramHandler, parama, new com.google.android.exoplayer2.source.b.a.d());
  }
  
  private h(Uri paramUri, d paramd, Handler paramHandler, com.google.android.exoplayer2.source.a parama, s.a<c> parama1)
  {
    this.aKm = paramUri;
    this.aKd = paramd;
    this.aKe = 3;
    this.aKn = parama1;
    this.aKf = new a.a(paramHandler, parama);
  }
  
  public final com.google.android.exoplayer2.source.e a(f.b paramb, com.google.android.exoplayer2.h.b paramb1)
  {
    if (paramb.aIm == 0) {}
    for (boolean bool = true;; bool = false)
    {
      com.google.android.exoplayer2.i.a.aB(bool);
      return new g(this.aJs, this.aKd, this.aKe, this.aKf, paramb1);
    }
  }
  
  public final void a(com.google.android.exoplayer2.source.b.a.b paramb)
  {
    long l2;
    long l3;
    label26:
    long l1;
    long l4;
    label63:
    long l5;
    label92:
    long l6;
    boolean bool;
    if (paramb.aLd)
    {
      l2 = 0L;
      if (!paramb.aLd) {
        break label173;
      }
      l3 = com.google.android.exoplayer2.b.q(paramb.aJe);
      l1 = paramb.aKW;
      if (!this.aJs.aLW) {
        break label225;
      }
      if (!paramb.aLc) {
        break label181;
      }
      l4 = paramb.aJe;
      l4 = paramb.auP + l4;
      localObject = paramb.aLf;
      l5 = l1;
      if (l1 == -9223372036854775807L)
      {
        if (!((List)localObject).isEmpty()) {
          break label189;
        }
        l1 = 0L;
        l5 = l1;
      }
      l1 = paramb.auP;
      l6 = paramb.aJe;
      if (paramb.aLc) {
        break label219;
      }
      bool = true;
    }
    label116:
    for (Object localObject = new k(l2, l3, l4, l1, l6, l5, bool);; localObject = new k(l2, l3, paramb.aJe + paramb.auP, paramb.auP, paramb.aJe, l4, false))
    {
      this.aKo.a((w)localObject, new e(this.aJs.aJI, paramb));
      return;
      l2 = -9223372036854775807L;
      break;
      l3 = -9223372036854775807L;
      break label26;
      l4 = -9223372036854775807L;
      break label63;
      l1 = ((b.a)((List)localObject).get(Math.max(0, ((List)localObject).size() - 3))).aLh;
      break label92;
      bool = false;
      break label116;
      l4 = l1;
      if (l1 == -9223372036854775807L) {
        l4 = 0L;
      }
    }
  }
  
  public final void a(com.google.android.exoplayer2.source.f.a parama)
  {
    if (this.aJs == null) {}
    for (boolean bool = true;; bool = false)
    {
      com.google.android.exoplayer2.i.a.aC(bool);
      this.aJs = new com.google.android.exoplayer2.source.b.a.e(this.aKm, this.aKd, this.aKf, this.aKe, this, this.aKn);
      this.aKo = parama;
      parama = this.aJs;
      s locals = new s(parama.aKd.mU(), parama.aLN, parama.aKn);
      parama.aLT.a(locals, parama, parama.aLO);
      return;
    }
  }
  
  public final void b(com.google.android.exoplayer2.source.e parame)
  {
    parame = (g)parame;
    parame.aJs.aLS.remove(parame);
    parame.aKh.removeCallbacksAndMessages(null);
    parame = parame.aKj;
    int k = parame.length;
    int i = 0;
    while (i < k)
    {
      r.d locald = parame[i];
      boolean bool = locald.aKt.a(locald);
      if ((locald.prepared) && (!bool))
      {
        com.google.android.exoplayer2.source.h[] arrayOfh = locald.aKx;
        int m = arrayOfh.length;
        int j = 0;
        while (j < m)
        {
          arrayOfh[j].mN();
          j += 1;
        }
      }
      locald.handler.removeCallbacksAndMessages(null);
      locald.released = true;
      i += 1;
    }
  }
  
  public final void mE()
  {
    com.google.android.exoplayer2.source.b.a.e locale = this.aJs;
    locale.aLT.mD();
    if (locale.aLU != null) {
      locale.d(locale.aLU);
    }
  }
  
  public final void mF()
  {
    if (this.aJs != null)
    {
      com.google.android.exoplayer2.source.b.a.e locale = this.aJs;
      locale.aLT.a(null);
      Iterator localIterator = locale.aLP.values().iterator();
      while (localIterator.hasNext()) {
        ((e.a)localIterator.next()).aLY.a(null);
      }
      locale.aLQ.removeCallbacksAndMessages(null);
      locale.aLP.clear();
      this.aJs = null;
    }
    this.aKo = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.google.android.exoplayer2.source.b.h
 * JD-Core Version:    0.7.0.1
 */