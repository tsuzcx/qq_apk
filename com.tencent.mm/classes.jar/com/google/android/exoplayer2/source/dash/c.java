package com.google.android.exoplayer2.source.dash;

import android.net.Uri;
import android.os.Handler;
import android.os.SystemClock;
import android.util.SparseArray;
import com.google.android.exoplayer2.h.g.a;
import com.google.android.exoplayer2.h.t;
import com.google.android.exoplayer2.h.t.a;
import com.google.android.exoplayer2.h.u;
import com.google.android.exoplayer2.h.u.a;
import com.google.android.exoplayer2.h.v;
import com.google.android.exoplayer2.h.v.a;
import com.google.android.exoplayer2.source.dash.manifest.e;
import com.google.android.exoplayer2.source.dash.manifest.k;
import com.google.android.exoplayer2.source.i;
import com.google.android.exoplayer2.source.j.a;
import com.google.android.exoplayer2.source.j.b;
import com.google.android.exoplayer2.w;
import com.google.android.exoplayer2.w.a;
import com.google.android.exoplayer2.w.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;

public final class c
  implements com.google.android.exoplayer2.source.j
{
  private com.google.android.exoplayer2.h.g aWG;
  private j.a bkG;
  private final int bkJ;
  private t bkP;
  final com.google.android.exoplayer2.source.a.a bmE;
  private final a.a bmU;
  com.google.android.exoplayer2.source.dash.manifest.b bna;
  private final boolean bnh;
  private final g.a bni;
  private final long bnj;
  private final v.a<? extends com.google.android.exoplayer2.source.dash.manifest.b> bnk;
  private final c bnl;
  final Object bnm;
  private final SparseArray<b> bnn;
  private final Runnable bno;
  private final Runnable bnp;
  private u bnq;
  Uri bnr;
  long bns;
  long bnt;
  private long bnu;
  int bnv;
  private Handler handler;
  
  static
  {
    AppMethodBeat.i(10498);
    com.google.android.exoplayer2.j.ah("goog.exo.dash");
    AppMethodBeat.o(10498);
  }
  
  private c(Uri paramUri, g.a parama, v.a<? extends com.google.android.exoplayer2.source.dash.manifest.b> parama1, a.a parama2, Handler paramHandler, com.google.android.exoplayer2.source.a parama3)
  {
    this(paramUri, parama, parama1, parama2, paramHandler, parama3, (byte)0);
  }
  
  private c(Uri paramUri, g.a parama, v.a<? extends com.google.android.exoplayer2.source.dash.manifest.b> parama1, a.a parama2, Handler paramHandler, com.google.android.exoplayer2.source.a parama3, byte paramByte)
  {
    AppMethodBeat.i(10482);
    this.bna = null;
    this.bnr = paramUri;
    this.bni = parama;
    this.bnk = parama1;
    this.bmU = parama2;
    this.bkJ = 3;
    this.bnj = -1L;
    this.bnh = false;
    this.bmE = new com.google.android.exoplayer2.source.a.a(paramHandler, parama3);
    this.bnm = new Object();
    this.bnn = new SparseArray();
    if (this.bnh) {
      throw new NullPointerException();
    }
    this.bnl = new c((byte)0);
    this.bno = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(10465);
        c.a(c.this);
        AppMethodBeat.o(10465);
      }
    };
    this.bnp = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(10466);
        c.b(c.this);
        AppMethodBeat.o(10466);
      }
    };
    AppMethodBeat.o(10482);
  }
  
  public c(Uri paramUri, g.a parama, a.a parama1, Handler paramHandler, com.google.android.exoplayer2.source.a parama2)
  {
    this(paramUri, parama, parama1, paramHandler, parama2, (byte)0);
  }
  
  private c(Uri paramUri, g.a parama, a.a parama1, Handler paramHandler, com.google.android.exoplayer2.source.a parama2, byte paramByte)
  {
    this(paramUri, parama, new com.google.android.exoplayer2.source.dash.manifest.c(), parama1, paramHandler, parama2);
    AppMethodBeat.i(10481);
    AppMethodBeat.o(10481);
  }
  
  private <T> void a(v<T> paramv, t.a<v<T>> parama, int paramInt)
  {
    AppMethodBeat.i(10494);
    long l = this.bkP.a(paramv, parama, paramInt);
    this.bmE.a(paramv.bml, paramv.type, l);
    AppMethodBeat.o(10494);
  }
  
  private void ue()
  {
    AppMethodBeat.i(10488);
    synchronized (this.bnm)
    {
      Uri localUri = this.bnr;
      a(new v(this.aWG, localUri, 4, this.bnk), this.bnl, this.bkJ);
      AppMethodBeat.o(10488);
      return;
    }
  }
  
  private long uh()
  {
    AppMethodBeat.i(10495);
    if (this.bnu != 0L)
    {
      l = com.google.android.exoplayer2.b.u(SystemClock.elapsedRealtime() + this.bnu);
      AppMethodBeat.o(10495);
      return l;
    }
    long l = com.google.android.exoplayer2.b.u(System.currentTimeMillis());
    AppMethodBeat.o(10495);
    return l;
  }
  
  public final i a(j.b paramb, com.google.android.exoplayer2.h.b paramb1)
  {
    AppMethodBeat.i(10484);
    int i = paramb.blw;
    paramb = this.bmE;
    long l = this.bna.eL(i).bof;
    paramb = new com.google.android.exoplayer2.source.a.a(paramb.handler, paramb.bkg, l);
    paramb = new b(this.bnv + i, this.bna, i, this.bmU, this.bkJ, paramb, this.bnu, this.bnq, paramb1);
    this.bnn.put(paramb.id, paramb);
    AppMethodBeat.o(10484);
    return paramb;
  }
  
  public final void a(com.google.android.exoplayer2.f paramf, j.a parama)
  {
    AppMethodBeat.i(10483);
    this.bkG = parama;
    if (this.bnh)
    {
      this.bnq = new u.a();
      aT(false);
      AppMethodBeat.o(10483);
      return;
    }
    this.aWG = this.bni.vi();
    this.bkP = new t("Loader:DashMediaSource");
    this.bnq = this.bkP;
    this.handler = new Handler();
    ue();
    AppMethodBeat.o(10483);
  }
  
  final void a(v<?> paramv, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(10487);
    this.bmE.b(paramv.bml, paramv.type, paramLong1, paramLong2, paramv.bxD);
    AppMethodBeat.o(10487);
  }
  
  final void a(k paramk, v.a<Long> parama)
  {
    AppMethodBeat.i(10489);
    a(new v(this.aWG, Uri.parse(paramk.value), 5, parama), new e((byte)0), 1);
    AppMethodBeat.o(10489);
  }
  
  final void aT(boolean paramBoolean)
  {
    AppMethodBeat.i(10492);
    int i = 0;
    int j;
    while (i < this.bnn.size())
    {
      j = this.bnn.keyAt(i);
      if (j >= this.bnv) {
        ((b)this.bnn.valueAt(i)).a(this.bna, j - this.bnv);
      }
      i += 1;
    }
    i = this.bna.rQ() - 1;
    Object localObject = d.a(this.bna.eL(0), this.bna.eN(0));
    d locald = d.a(this.bna.eL(i), this.bna.eN(i));
    long l2 = ((d)localObject).bnz;
    long l1 = locald.bnA;
    long l3;
    if ((this.bna.bnP) && (!locald.bny))
    {
      l3 = Math.min(uh() - com.google.android.exoplayer2.b.u(this.bna.bnN) - com.google.android.exoplayer2.b.u(this.bna.eL(i).bof), l1);
      l1 = l2;
      if (this.bna.bnR != -9223372036854775807L)
      {
        for (l1 = l3 - com.google.android.exoplayer2.b.u(this.bna.bnR); (l1 < 0L) && (i > 0); l1 += ((com.google.android.exoplayer2.source.dash.manifest.b)localObject).eN(i))
        {
          localObject = this.bna;
          i -= 1;
        }
        if (i == 0) {
          l1 = Math.max(l2, l1);
        }
      }
      else
      {
        i = 1;
        l2 = l1;
        l1 = l3;
      }
    }
    for (;;)
    {
      l3 = l1 - l2;
      j = 0;
      for (;;)
      {
        if (j < this.bna.rQ() - 1)
        {
          l3 += this.bna.eN(j);
          j += 1;
          continue;
          l1 = this.bna.eN(0);
          break;
        }
      }
      l1 = 0L;
      long l4;
      if (this.bna.bnP)
      {
        l4 = this.bnj;
        l1 = l4;
        if (l4 == -1L) {
          if (this.bna.bnS == -9223372036854775807L) {
            break label560;
          }
        }
      }
      label560:
      for (l1 = this.bna.bnS;; l1 = 30000L)
      {
        l4 = l3 - com.google.android.exoplayer2.b.u(l1);
        l1 = l4;
        if (l4 < 5000000L) {
          l1 = Math.min(5000000L, l3 / 2L);
        }
        l4 = this.bna.bnN;
        long l5 = this.bna.eL(0).bof;
        long l6 = com.google.android.exoplayer2.b.t(l2);
        localObject = new a(this.bna.bnN, l4 + l5 + l6, this.bnv, l2, l3, l1, this.bna);
        this.bkG.a((w)localObject, this.bna);
        if (!this.bnh)
        {
          this.handler.removeCallbacks(this.bnp);
          if (i != 0) {
            this.handler.postDelayed(this.bnp, 5000L);
          }
          if (paramBoolean) {
            ug();
          }
        }
        AppMethodBeat.o(10492);
        return;
      }
      i = 0;
    }
  }
  
  final void ag(long paramLong)
  {
    AppMethodBeat.i(10490);
    this.bnu = paramLong;
    aT(true);
    AppMethodBeat.o(10490);
  }
  
  public final void b(i parami)
  {
    AppMethodBeat.i(10485);
    parami = (b)parami;
    com.google.android.exoplayer2.source.a.f[] arrayOff = parami.bmY;
    int j = arrayOff.length;
    int i = 0;
    while (i < j)
    {
      arrayOff[i].release();
      i += 1;
    }
    this.bnn.remove(parami.id);
    AppMethodBeat.o(10485);
  }
  
  public final void tG() {}
  
  public final void tH()
  {
    AppMethodBeat.i(10486);
    this.aWG = null;
    this.bnq = null;
    if (this.bkP != null)
    {
      this.bkP.a(null);
      this.bkP = null;
    }
    this.bns = 0L;
    this.bnt = 0L;
    this.bna = null;
    if (this.handler != null)
    {
      this.handler.removeCallbacksAndMessages(null);
      this.handler = null;
    }
    this.bnu = 0L;
    this.bnn.clear();
    AppMethodBeat.o(10486);
  }
  
  final void uf()
  {
    AppMethodBeat.i(10491);
    aT(true);
    AppMethodBeat.o(10491);
  }
  
  final void ug()
  {
    AppMethodBeat.i(10493);
    if (!this.bna.bnP)
    {
      AppMethodBeat.o(10493);
      return;
    }
    long l2 = this.bna.bnQ;
    long l1 = l2;
    if (l2 == 0L) {
      l1 = 5000L;
    }
    l1 = Math.max(0L, l1 + this.bns - SystemClock.elapsedRealtime());
    this.handler.postDelayed(this.bno, l1);
    AppMethodBeat.o(10493);
  }
  
  static final class a
    extends w
  {
    private final long aTl;
    private final long aTm;
    private final long bmd;
    private final long bmf;
    private final com.google.android.exoplayer2.source.dash.manifest.b bna;
    private final int bnv;
    private final long bnx;
    
    public a(long paramLong1, long paramLong2, int paramInt, long paramLong3, long paramLong4, long paramLong5, com.google.android.exoplayer2.source.dash.manifest.b paramb)
    {
      this.aTl = paramLong1;
      this.aTm = paramLong2;
      this.bnv = paramInt;
      this.bnx = paramLong3;
      this.bmd = paramLong4;
      this.bmf = paramLong5;
      this.bna = paramb;
    }
    
    public final w.a a(int paramInt, w.a parama, boolean paramBoolean)
    {
      Integer localInteger = null;
      AppMethodBeat.i(10468);
      com.google.android.exoplayer2.i.a.bn(paramInt, this.bna.rQ());
      if (paramBoolean) {}
      for (String str = this.bna.eL(paramInt).id;; str = null)
      {
        if (paramBoolean) {
          localInteger = Integer.valueOf(this.bnv + com.google.android.exoplayer2.i.a.bn(paramInt, this.bna.rQ()));
        }
        parama = parama.a(str, localInteger, this.bna.eN(paramInt), com.google.android.exoplayer2.b.u(this.bna.eL(paramInt).bof - this.bna.eL(0).bof) - this.bnx);
        AppMethodBeat.o(10468);
        return parama;
      }
    }
    
    public final w.b a(int paramInt, w.b paramb, boolean paramBoolean, long paramLong)
    {
      AppMethodBeat.i(10469);
      com.google.android.exoplayer2.i.a.bn(paramInt, 1);
      long l2 = this.bmf;
      if (!this.bna.bnP) {
        paramLong = l2;
      }
      for (;;)
      {
        paramb = paramb.a(null, this.aTl, this.aTm, true, this.bna.bnP, paramLong, this.bmd, this.bna.rQ() - 1, this.bnx);
        AppMethodBeat.o(10469);
        return paramb;
        long l1 = l2;
        if (paramLong > 0L)
        {
          paramLong = l2 + paramLong;
          l1 = paramLong;
          if (paramLong > this.bmd)
          {
            paramLong = -9223372036854775807L;
            continue;
          }
        }
        paramInt = 0;
        l2 = this.bnx + l1;
        for (paramLong = this.bna.eN(0); (paramInt < this.bna.rQ() - 1) && (l2 >= paramLong); paramLong = this.bna.eN(paramInt))
        {
          l2 -= paramLong;
          paramInt += 1;
        }
        Object localObject = this.bna.eL(paramInt);
        int i = ((e)localObject).bnb.size();
        paramInt = 0;
        label211:
        if (paramInt < i) {
          if (((com.google.android.exoplayer2.source.dash.manifest.a)((e)localObject).bnb.get(paramInt)).type != 2) {}
        }
        for (;;)
        {
          if (paramInt != -1) {
            break label262;
          }
          paramLong = l1;
          break;
          paramInt += 1;
          break label211;
          paramInt = -1;
        }
        label262:
        localObject = ((com.google.android.exoplayer2.source.dash.manifest.g)((com.google.android.exoplayer2.source.dash.manifest.a)((e)localObject).bnb.get(paramInt)).bnK.get(0)).un();
        if ((localObject == null) || (((d)localObject).ah(paramLong) == 0)) {
          paramLong = l1;
        } else {
          paramLong = ((d)localObject).eH(((d)localObject).j(l2, paramLong)) + l1 - l2;
        }
      }
    }
    
    public final int aa(Object paramObject)
    {
      AppMethodBeat.i(10470);
      if (!(paramObject instanceof Integer))
      {
        AppMethodBeat.o(10470);
        return -1;
      }
      int i = ((Integer)paramObject).intValue();
      if ((i < this.bnv) || (i >= this.bnv + this.bna.rQ()))
      {
        AppMethodBeat.o(10470);
        return -1;
      }
      int j = this.bnv;
      AppMethodBeat.o(10470);
      return i - j;
    }
    
    public final int rP()
    {
      return 1;
    }
    
    public final int rQ()
    {
      AppMethodBeat.i(10467);
      int i = this.bna.rQ();
      AppMethodBeat.o(10467);
      return i;
    }
  }
  
  final class c
    implements t.a<v<com.google.android.exoplayer2.source.dash.manifest.b>>
  {
    private c() {}
  }
  
  static final class d
  {
    public final long bnA;
    public final boolean bny;
    public final long bnz;
    
    private d(boolean paramBoolean, long paramLong1, long paramLong2)
    {
      this.bny = paramBoolean;
      this.bnz = paramLong1;
      this.bnA = paramLong2;
    }
    
    public static d a(e parame, long paramLong)
    {
      AppMethodBeat.i(10476);
      int k = parame.bnb.size();
      long l1 = 0L;
      long l3 = 9223372036854775807L;
      boolean bool = false;
      int i = 0;
      int j = 0;
      d locald;
      int m;
      long l2;
      if (j < k)
      {
        locald = ((com.google.android.exoplayer2.source.dash.manifest.g)((com.google.android.exoplayer2.source.dash.manifest.a)parame.bnb.get(j)).bnK.get(0)).un();
        if (locald == null)
        {
          parame = new d(true, 0L, paramLong);
          AppMethodBeat.o(10476);
          return parame;
        }
        bool |= locald.uj();
        m = locald.ah(paramLong);
        if (m == 0)
        {
          i = 1;
          l1 = 0L;
          l2 = 0L;
        }
      }
      for (;;)
      {
        j += 1;
        l3 = l2;
        break;
        l2 = l1;
        if (i == 0)
        {
          int n = locald.ui();
          l1 = Math.max(l1, locald.eH(n));
          l2 = l1;
          if (m != -1)
          {
            m = m + n - 1;
            l2 = Math.min(l3, locald.eH(m) + locald.k(m, paramLong));
            continue;
            parame = new d(bool, l1, l3);
            AppMethodBeat.o(10476);
            return parame;
          }
        }
        l1 = l2;
        l2 = l3;
      }
    }
  }
  
  final class e
    implements t.a<v<Long>>
  {
    private e() {}
  }
  
  static final class f
    implements v.a<Long>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.exoplayer2.source.dash.c
 * JD-Core Version:    0.7.0.1
 */