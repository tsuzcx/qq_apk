package com.google.android.exoplayer2.source.c;

import android.net.Uri;
import android.os.Handler;
import com.google.android.exoplayer2.h.g;
import com.google.android.exoplayer2.h.g.a;
import com.google.android.exoplayer2.h.t;
import com.google.android.exoplayer2.h.t.a;
import com.google.android.exoplayer2.h.u;
import com.google.android.exoplayer2.h.u.a;
import com.google.android.exoplayer2.h.v;
import com.google.android.exoplayer2.h.v.a;
import com.google.android.exoplayer2.i.x;
import com.google.android.exoplayer2.source.a.a;
import com.google.android.exoplayer2.source.c.a.a.b;
import com.google.android.exoplayer2.source.i;
import com.google.android.exoplayer2.source.j.a;
import com.google.android.exoplayer2.source.j.b;
import com.google.android.exoplayer2.source.o;
import com.google.android.exoplayer2.w;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;

public final class d
  implements t.a<v<com.google.android.exoplayer2.source.c.a.a>>, com.google.android.exoplayer2.source.j
{
  private final ArrayList<c> bkF;
  private j.a bkG;
  private final int bkJ;
  private final a.a bmE;
  private u bmW;
  private final g.a bni;
  private final long bnj;
  private final v.a<? extends com.google.android.exoplayer2.source.c.a.a> bnk;
  private final Uri bnr;
  private long bns;
  private com.google.android.exoplayer2.source.c.a.a brg;
  private final b.a bri;
  private g brj;
  private t brk;
  private Handler brl;
  
  static
  {
    AppMethodBeat.i(90029);
    com.google.android.exoplayer2.j.ah("goog.exo.smoothstreaming");
    AppMethodBeat.o(90029);
  }
  
  private d(Uri paramUri, g.a parama, v.a<? extends com.google.android.exoplayer2.source.c.a.a> parama1, b.a parama2, Handler paramHandler, com.google.android.exoplayer2.source.a parama3)
  {
    this(paramUri, parama, parama1, parama2, paramHandler, parama3, (byte)0);
  }
  
  private d(Uri paramUri, g.a parama, v.a<? extends com.google.android.exoplayer2.source.c.a.a> parama1, b.a parama2, Handler paramHandler, com.google.android.exoplayer2.source.a parama3, byte paramByte)
  {
    AppMethodBeat.i(90018);
    com.google.android.exoplayer2.i.a.checkState(true);
    this.brg = null;
    Uri localUri;
    if (paramUri == null) {
      localUri = null;
    }
    for (;;)
    {
      this.bnr = localUri;
      this.bni = parama;
      this.bnk = parama1;
      this.bri = parama2;
      this.bkJ = 3;
      this.bnj = 30000L;
      this.bmE = new a.a(paramHandler, parama3);
      this.bkF = new ArrayList();
      AppMethodBeat.o(90018);
      return;
      localUri = paramUri;
      if (!x.aV(paramUri.getLastPathSegment()).equals("manifest")) {
        localUri = Uri.withAppendedPath(paramUri, "Manifest");
      }
    }
  }
  
  public d(Uri paramUri, g.a parama, b.a parama1, Handler paramHandler, com.google.android.exoplayer2.source.a parama2)
  {
    this(paramUri, parama, parama1, paramHandler, parama2, (byte)0);
  }
  
  private d(Uri paramUri, g.a parama, b.a parama1, Handler paramHandler, com.google.android.exoplayer2.source.a parama2, byte paramByte)
  {
    this(paramUri, parama, new com.google.android.exoplayer2.source.c.a.b(), parama1, paramHandler, parama2);
    AppMethodBeat.i(90017);
    AppMethodBeat.o(90017);
  }
  
  private void uA()
  {
    AppMethodBeat.i(90023);
    int i = 0;
    while (i < this.bkF.size())
    {
      ((c)this.bkF.get(i)).a(this.brg);
      i += 1;
    }
    long l1 = 9223372036854775807L;
    long l2 = -9223372036854775808L;
    Object localObject1 = this.brg.brp;
    int j = localObject1.length;
    i = 0;
    long l4;
    long l3;
    while (i < j)
    {
      Object localObject2 = localObject1[i];
      l4 = l2;
      l3 = l1;
      if (localObject2.bmP > 0)
      {
        l3 = Math.min(l1, localObject2.bru[0]);
        int k = localObject2.bmP;
        l4 = Math.max(l2, localObject2.bru[(k - 1)] + localObject2.eQ(localObject2.bmP - 1));
      }
      i += 1;
      l2 = l4;
      l1 = l3;
    }
    if (l1 == 9223372036854775807L) {
      if (this.brg.bqS) {
        l1 = -9223372036854775807L;
      }
    }
    for (localObject1 = new o(l1, 0L, 0L, 0L, true, this.brg.bqS);; localObject1 = new o(-9223372036854775807L, l4, l3, l1, true, true))
    {
      this.bkG.a((w)localObject1, this.brg);
      AppMethodBeat.o(90023);
      return;
      l1 = 0L;
      break;
      if (!this.brg.bqS) {
        break label362;
      }
      l3 = l1;
      if (this.brg.brq != -9223372036854775807L)
      {
        l3 = l1;
        if (this.brg.brq > 0L) {
          l3 = Math.max(l1, l2 - this.brg.brq);
        }
      }
      l4 = l2 - l3;
      l2 = l4 - com.google.android.exoplayer2.b.u(this.bnj);
      l1 = l2;
      if (l2 < 5000000L) {
        l1 = Math.min(5000000L, l4 / 2L);
      }
    }
    label362:
    if (this.brg.aSz != -9223372036854775807L) {}
    for (l2 = this.brg.aSz;; l2 -= l1)
    {
      localObject1 = new o(l1 + l2, l2, l1, 0L, true, false);
      break;
    }
  }
  
  private void ue()
  {
    AppMethodBeat.i(90024);
    v localv = new v(this.brj, this.bnr, 4, this.bnk);
    long l = this.brk.a(localv, this, this.bkJ);
    this.bmE.a(localv.bml, localv.type, l);
    AppMethodBeat.o(90024);
  }
  
  public final i a(j.b paramb, com.google.android.exoplayer2.h.b paramb1)
  {
    AppMethodBeat.i(90020);
    if (paramb.blw == 0) {}
    for (boolean bool = true;; bool = false)
    {
      com.google.android.exoplayer2.i.a.checkArgument(bool);
      paramb = new c(this.brg, this.bri, this.bkJ, this.bmE, this.bmW, paramb1);
      this.bkF.add(paramb);
      AppMethodBeat.o(90020);
      return paramb;
    }
  }
  
  public final void a(com.google.android.exoplayer2.f paramf, j.a parama)
  {
    AppMethodBeat.i(90019);
    this.bkG = parama;
    if (this.brg != null)
    {
      this.bmW = new u.a();
      uA();
      AppMethodBeat.o(90019);
      return;
    }
    this.brj = this.bni.vi();
    this.brk = new t("Loader:Manifest");
    this.bmW = this.brk;
    this.brl = new Handler();
    ue();
    AppMethodBeat.o(90019);
  }
  
  public final void b(i parami)
  {
    AppMethodBeat.i(90021);
    com.google.android.exoplayer2.source.a.f[] arrayOff = ((c)parami).bmY;
    int j = arrayOff.length;
    int i = 0;
    while (i < j)
    {
      arrayOff[i].release();
      i += 1;
    }
    this.bkF.remove(parami);
    AppMethodBeat.o(90021);
  }
  
  public final void tG() {}
  
  public final void tH()
  {
    AppMethodBeat.i(90022);
    this.bkG = null;
    this.brg = null;
    this.brj = null;
    this.bns = 0L;
    if (this.brk != null)
    {
      this.brk.a(null);
      this.brk = null;
    }
    if (this.brl != null)
    {
      this.brl.removeCallbacksAndMessages(null);
      this.brl = null;
    }
    AppMethodBeat.o(90022);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.exoplayer2.source.c.d
 * JD-Core Version:    0.7.0.1
 */