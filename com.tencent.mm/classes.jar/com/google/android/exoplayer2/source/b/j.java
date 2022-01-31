package com.google.android.exoplayer2.source.b;

import android.net.Uri;
import android.os.Handler;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.SparseArray;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.h.i;
import com.google.android.exoplayer2.h.r;
import com.google.android.exoplayer2.h.r.a;
import com.google.android.exoplayer2.h.r.c;
import com.google.android.exoplayer2.h.r.d;
import com.google.android.exoplayer2.i.q;
import com.google.android.exoplayer2.i.s;
import com.google.android.exoplayer2.i.t;
import com.google.android.exoplayer2.source.a.a.1;
import com.google.android.exoplayer2.source.a.d;
import com.google.android.exoplayer2.source.b.a.b.a;
import com.google.android.exoplayer2.source.b.a.e.a;
import com.google.android.exoplayer2.source.h;
import com.google.android.exoplayer2.source.h.a;
import com.google.android.exoplayer2.source.h.b;
import com.google.android.exoplayer2.source.l;
import com.google.android.exoplayer2.source.m;
import java.util.Arrays;
import java.util.IdentityHashMap;
import java.util.LinkedList;
import java.util.List;

final class j
  implements com.google.android.exoplayer2.c.f, r.a<com.google.android.exoplayer2.source.a.a>, r.d, h.b, com.google.android.exoplayer2.source.j
{
  private final com.google.android.exoplayer2.h.b aIC;
  int aKA;
  Format aKB;
  int aKC;
  int aKD;
  private boolean aKE;
  boolean[] aKF;
  private boolean[] aKG;
  long aKH;
  private long aKI;
  boolean aKJ;
  boolean aKK;
  boolean aKL;
  private final int aKe;
  final com.google.android.exoplayer2.source.a.a aKf;
  private final j.a aKq;
  final c aKr;
  private final Format aKs;
  final r aKt;
  private final c.b aKu;
  final LinkedList<f> aKv;
  private final Runnable aKw;
  h[] aKx;
  private int[] aKy;
  boolean aKz;
  final int asG;
  m att;
  final Handler handler;
  boolean prepared;
  boolean released;
  
  public j(int paramInt1, j.a parama, c paramc, com.google.android.exoplayer2.h.b paramb, long paramLong, Format paramFormat, int paramInt2, com.google.android.exoplayer2.source.a.a parama1)
  {
    this.asG = paramInt1;
    this.aKq = parama;
    this.aKr = paramc;
    this.aIC = paramb;
    this.aKs = paramFormat;
    this.aKe = paramInt2;
    this.aKf = parama1;
    this.aKt = new r("Loader:HlsSampleStreamWrapper");
    this.aKu = new c.b();
    this.aKy = new int[0];
    this.aKx = new h[0];
    this.aKv = new LinkedList();
    this.aKw = new j.1(this);
    this.handler = new Handler();
    this.aKH = paramLong;
    this.aKI = paramLong;
  }
  
  private static Format a(Format paramFormat1, Format paramFormat2)
  {
    if (paramFormat1 == null) {
      return paramFormat2;
    }
    String str1 = null;
    int i = com.google.android.exoplayer2.i.g.az(paramFormat2.aus);
    if (i == 1) {
      str1 = j(paramFormat1.aup, 1);
    }
    for (;;)
    {
      String str2 = paramFormat1.id;
      i = paramFormat1.bitrate;
      int j = paramFormat1.width;
      int k = paramFormat1.height;
      int m = paramFormat1.auH;
      paramFormat1 = paramFormat1.auI;
      return new Format(str2, paramFormat2.aur, paramFormat2.aus, str1, i, paramFormat2.aut, j, k, paramFormat2.auw, paramFormat2.aux, paramFormat2.auy, paramFormat2.auA, paramFormat2.auz, paramFormat2.auB, paramFormat2.auC, paramFormat2.sampleRate, paramFormat2.auD, paramFormat2.auE, paramFormat2.auF, m, paramFormat1, paramFormat2.auJ, paramFormat2.auG, paramFormat2.auu, paramFormat2.auv, paramFormat2.auq);
      if (i == 2) {
        str1 = j(paramFormat1.aup, 2);
      }
    }
  }
  
  private static String j(String paramString, int paramInt)
  {
    if (TextUtils.isEmpty(paramString)) {}
    StringBuilder localStringBuilder;
    do
    {
      return null;
      paramString = paramString.split("(\\s*,\\s*)|(\\s*$)");
      localStringBuilder = new StringBuilder();
      int j = paramString.length;
      int i = 0;
      while (i < j)
      {
        String str = paramString[i];
        if (paramInt == com.google.android.exoplayer2.i.g.az(com.google.android.exoplayer2.i.g.ay(str)))
        {
          if (localStringBuilder.length() > 0) {
            localStringBuilder.append(",");
          }
          localStringBuilder.append(str);
        }
        i += 1;
      }
    } while (localStringBuilder.length() <= 0);
    return localStringBuilder.toString();
  }
  
  public final boolean J(long paramLong)
  {
    if ((this.aKL) || (this.aKt.isLoading())) {
      return false;
    }
    c localc = this.aKr;
    Object localObject3;
    c.b localb;
    int j;
    label68:
    long l1;
    label94:
    int k;
    label133:
    Object localObject1;
    long l2;
    if (this.aKv.isEmpty())
    {
      localObject3 = null;
      if (this.aKI != -9223372036854775807L) {
        paramLong = this.aKI;
      }
      localb = this.aKu;
      if (localObject3 != null) {
        break label331;
      }
      j = -1;
      localc.aJy = null;
      if (localObject3 != null)
      {
        if (!localc.aJz) {
          break label349;
        }
        l1 = ((f)localObject3).aJf;
        Math.max(0L, l1 - paramLong);
      }
      localc.aJC.mV();
      i = localc.aJC.nJ();
      if (j == i) {
        break label359;
      }
      k = 1;
      localObject1 = localc.aJr[i];
      localObject2 = (e.a)localc.aJs.aLP.get(localObject1);
      if (((e.a)localObject2).aMa == null) {
        break label365;
      }
      l1 = SystemClock.elapsedRealtime();
      l2 = Math.max(30000L, com.google.android.exoplayer2.b.q(((e.a)localObject2).aMa.auP));
      if ((!((e.a)localObject2).aMa.aLc) && (((e.a)localObject2).aMa.aKV != 2) && (((e.a)localObject2).aMa.aKV != 1) && (l2 + ((e.a)localObject2).aMb <= l1)) {
        break label365;
      }
    }
    boolean bool;
    label331:
    label349:
    label359:
    label365:
    for (int m = 1;; m = 0)
    {
      if (m != 0) {
        break label371;
      }
      localb.aJG = ((com.google.android.exoplayer2.source.b.a.a.a)localObject1);
      localc.aJy = ((com.google.android.exoplayer2.source.b.a.a.a)localObject1);
      bool = this.aKu.aJF;
      localObject1 = this.aKu.aJE;
      localObject2 = this.aKu.aJG;
      this.aKu.clear();
      if (!bool) {
        break label1114;
      }
      this.aKI = -9223372036854775807L;
      this.aKL = true;
      return true;
      localObject3 = (f)this.aKv.getLast();
      break;
      j = localc.aJt.j(((f)localObject3).aJb);
      break label68;
      l1 = ((f)localObject3).aJe;
      break label94;
      k = 0;
      break label133;
    }
    label371:
    Object localObject2 = localc.aJs.c((com.google.android.exoplayer2.source.b.a.a.a)localObject1);
    localc.aJz = ((com.google.android.exoplayer2.source.b.a.b)localObject2).aLb;
    label444:
    label495:
    Object localObject4;
    if ((localObject3 == null) || (k != 0))
    {
      if (localObject3 == null) {}
      for (;;)
      {
        if ((((com.google.android.exoplayer2.source.b.a.b)localObject2).aLc) || (paramLong < ((com.google.android.exoplayer2.source.b.a.b)localObject2).ng())) {
          break label495;
        }
        j = ((com.google.android.exoplayer2.source.b.a.b)localObject2).aKZ + ((com.google.android.exoplayer2.source.b.a.b)localObject2).aLf.size();
        if (j >= ((com.google.android.exoplayer2.source.b.a.b)localObject2).aKZ) {
          break label626;
        }
        localc.aJx = new com.google.android.exoplayer2.source.b();
        break;
        if (localc.aJz) {
          paramLong = ((f)localObject3).aJf;
        } else {
          paramLong = ((f)localObject3).aJe;
        }
      }
      localObject4 = ((com.google.android.exoplayer2.source.b.a.b)localObject2).aLf;
      l1 = ((com.google.android.exoplayer2.source.b.a.b)localObject2).aJe;
      if ((!localc.aJs.aLW) || (localObject3 == null))
      {
        bool = true;
        label528:
        k = t.a((List)localObject4, Long.valueOf(paramLong - l1), bool) + ((com.google.android.exoplayer2.source.b.a.b)localObject2).aKZ;
        if ((k >= ((com.google.android.exoplayer2.source.b.a.b)localObject2).aKZ) || (localObject3 == null)) {
          break label1400;
        }
        localObject1 = localc.aJr[j];
        localObject2 = localc.aJs.c((com.google.android.exoplayer2.source.b.a.a.a)localObject1);
      }
    }
    for (int i = ((d)localObject3).aJh + 1;; i = k)
    {
      k = i;
      i = j;
      j = k;
      break label444;
      bool = false;
      break label528;
      j = ((d)localObject3).aJh + 1;
      break label444;
      label626:
      k = j - ((com.google.android.exoplayer2.source.b.a.b)localObject2).aKZ;
      if (k >= ((com.google.android.exoplayer2.source.b.a.b)localObject2).aLf.size())
      {
        if (((com.google.android.exoplayer2.source.b.a.b)localObject2).aLc)
        {
          localb.aJF = true;
          break;
        }
        localb.aJG = ((com.google.android.exoplayer2.source.b.a.a.a)localObject1);
        localc.aJy = ((com.google.android.exoplayer2.source.b.a.a.a)localObject1);
        break;
      }
      b.a locala = (b.a)((com.google.android.exoplayer2.source.b.a.b)localObject2).aLf.get(k);
      if (locala.aCF)
      {
        localObject4 = s.l(((com.google.android.exoplayer2.source.b.a.b)localObject2).aLm, locala.aLi);
        if (!((Uri)localObject4).equals(localc.aJA))
        {
          localObject1 = locala.aLj;
          j = localc.aJC.mX();
          localObject2 = localc.aJC.mY();
          localObject3 = new i((Uri)localObject4, (byte)0);
          localb.aJE = new c.a(localc.aJp, (i)localObject3, localc.aJr[i].auL, j, localObject2, localc.aJw, (String)localObject1);
          break;
        }
        if (!t.e(locala.aLj, localc.aJB)) {
          localc.a((Uri)localObject4, locala.aLj, localc.azp);
        }
        label857:
        localObject4 = ((com.google.android.exoplayer2.source.b.a.b)localObject2).aLe;
        if (localObject4 == null) {
          break label1394;
        }
      }
      label1114:
      label1394:
      for (localObject4 = new i(s.l(((com.google.android.exoplayer2.source.b.a.b)localObject2).aLm, ((b.a)localObject4).url), ((b.a)localObject4).aLk, ((b.a)localObject4).aLl);; localObject4 = null)
      {
        paramLong = ((com.google.android.exoplayer2.source.b.a.b)localObject2).aJe + locala.aLh;
        i = ((com.google.android.exoplayer2.source.b.a.b)localObject2).aKY + locala.aLg;
        k localk = localc.aJq;
        Object localObject5 = (q)localk.aKN.get(i);
        if (localObject5 == null)
        {
          localObject5 = new q(9223372036854775807L);
          localk.aKN.put(i, localObject5);
        }
        for (;;)
        {
          localObject2 = new i(s.l(((com.google.android.exoplayer2.source.b.a.b)localObject2).aLm, locala.url), locala.aLk, locala.aLl);
          localb.aJE = new f(localc.aJo, (i)localObject2, (i)localObject4, (com.google.android.exoplayer2.source.b.a.a.a)localObject1, localc.aJu, localc.aJC.mX(), localc.aJC.mY(), paramLong, paramLong + locala.auP, j, i, localc.aJv, (q)localObject5, (f)localObject3, localc.azp, localc.aJl);
          break;
          localc.aJA = null;
          localc.azp = null;
          localc.aJB = null;
          localc.aJl = null;
          break label857;
          if (localObject1 == null)
          {
            if (localObject2 != null) {
              this.aKq.a((com.google.android.exoplayer2.source.b.a.a.a)localObject2);
            }
            return false;
          }
          if ((localObject1 instanceof f))
          {
            this.aKI = -9223372036854775807L;
            localObject2 = (f)localObject1;
            ((f)localObject2).aKb = this;
            j = ((f)localObject2).uid;
            bool = ((f)localObject2).aJS;
            this.aKC = j;
            localObject3 = this.aKx;
            k = localObject3.length;
            i = 0;
            while (i < k)
            {
              localObject3[i].aIE.aIB = j;
              i += 1;
            }
            if (bool)
            {
              localObject3 = this.aKx;
              j = localObject3.length;
              i = 0;
              while (i < j)
              {
                localObject3[i].aIN = true;
                i += 1;
              }
            }
            this.aKv.add(localObject2);
          }
          paramLong = this.aKt.a((r.c)localObject1, this, this.aKe);
          localObject2 = this.aKf;
          localObject3 = ((com.google.android.exoplayer2.source.a.a)localObject1).aJa;
          i = ((com.google.android.exoplayer2.source.a.a)localObject1).type;
          j = this.asG;
          localObject4 = ((com.google.android.exoplayer2.source.a.a)localObject1).aJb;
          k = ((com.google.android.exoplayer2.source.a.a)localObject1).aJc;
          localObject5 = ((com.google.android.exoplayer2.source.a.a)localObject1).aJd;
          l1 = ((com.google.android.exoplayer2.source.a.a)localObject1).aJe;
          l2 = ((com.google.android.exoplayer2.source.a.a)localObject1).aJf;
          if (((com.google.android.exoplayer2.source.a.a)localObject2).aHM != null) {
            ((com.google.android.exoplayer2.source.a.a)localObject2).handler.post(new a.a.1((com.google.android.exoplayer2.source.a.a)localObject2, (i)localObject3, i, j, (Format)localObject4, k, localObject5, l1, l2, paramLong));
          }
          return true;
        }
      }
      label1400:
      j = i;
    }
  }
  
  public final void ay(boolean paramBoolean)
  {
    this.aKr.aJv = paramBoolean;
  }
  
  public final h dm(int paramInt)
  {
    int j = this.aKx.length;
    int i = 0;
    while (i < j)
    {
      if (this.aKy[i] == paramInt) {
        return this.aKx[i];
      }
      i += 1;
    }
    h localh = new h(this.aIC);
    localh.aIO = this;
    this.aKy = Arrays.copyOf(this.aKy, j + 1);
    this.aKy[j] = paramInt;
    this.aKx = ((h[])Arrays.copyOf(this.aKx, j + 1));
    this.aKx[j] = localh;
    return localh;
  }
  
  public final boolean g(long paramLong, boolean paramBoolean)
  {
    this.aKH = paramLong;
    if ((!paramBoolean) && (!nf()))
    {
      int j = this.aKx.length;
      int i = 0;
      h localh;
      if (i < j)
      {
        localh = this.aKx[i];
        localh.rewind();
        if ((localh.e(paramLong, false)) || ((this.aKG[i] == 0) && (this.aKE))) {}
      }
      for (i = 0;; i = 1)
      {
        if (i == 0) {
          break label112;
        }
        return false;
        localh.O(localh.aIE.mL());
        i += 1;
        break;
      }
    }
    label112:
    this.aKI = paramLong;
    this.aKL = false;
    this.aKv.clear();
    if (this.aKt.isLoading()) {
      this.aKt.cancelLoading();
    }
    for (;;)
    {
      return true;
      nd();
    }
  }
  
  public final void lV()
  {
    this.aKz = true;
    this.handler.post(this.aKw);
  }
  
  public final long mB()
  {
    long l2;
    if (this.aKL)
    {
      l2 = -9223372036854775808L;
      return l2;
    }
    if (nf()) {
      return this.aKI;
    }
    long l1 = this.aKH;
    Object localObject = (f)this.aKv.getLast();
    if (((f)localObject).aKc)
    {
      label52:
      if (localObject == null) {
        break label150;
      }
      l1 = Math.max(l1, ((f)localObject).aJf);
    }
    label150:
    for (;;)
    {
      localObject = this.aKx;
      int j = localObject.length;
      int i = 0;
      for (;;)
      {
        l2 = l1;
        if (i >= j) {
          break;
        }
        l1 = Math.max(l1, localObject[i].aIE.mJ());
        i += 1;
      }
      if (this.aKv.size() > 1)
      {
        localObject = (f)this.aKv.get(this.aKv.size() - 2);
        break label52;
      }
      localObject = null;
      break label52;
    }
  }
  
  public final long mC()
  {
    if (nf()) {
      return this.aKI;
    }
    if (this.aKL) {
      return -9223372036854775808L;
    }
    return ((f)this.aKv.getLast()).aJf;
  }
  
  final void mD()
  {
    this.aKt.mD();
    c localc = this.aKr;
    if (localc.aJx != null) {
      throw localc.aJx;
    }
    if (localc.aJy != null) {
      localc.aJs.d(localc.aJy);
    }
  }
  
  public final void mP()
  {
    this.handler.post(this.aKw);
  }
  
  public final void nb()
  {
    if (!this.prepared) {
      J(this.aKH);
    }
  }
  
  public final void nc()
  {
    nd();
  }
  
  final void nd()
  {
    h[] arrayOfh = this.aKx;
    int k = arrayOfh.length;
    int i = 0;
    while (i < k)
    {
      h localh = arrayOfh[i];
      boolean bool = this.aKJ;
      Object localObject = localh.aIE;
      ((com.google.android.exoplayer2.source.g)localObject).length = 0;
      ((com.google.android.exoplayer2.source.g)localObject).aIt = 0;
      ((com.google.android.exoplayer2.source.g)localObject).aIu = 0;
      ((com.google.android.exoplayer2.source.g)localObject).aIv = 0;
      ((com.google.android.exoplayer2.source.g)localObject).aIy = true;
      ((com.google.android.exoplayer2.source.g)localObject).aIw = -9223372036854775808L;
      ((com.google.android.exoplayer2.source.g)localObject).aIx = -9223372036854775808L;
      if (bool)
      {
        ((com.google.android.exoplayer2.source.g)localObject).aIA = null;
        ((com.google.android.exoplayer2.source.g)localObject).aIz = true;
      }
      localObject = localh.aIG;
      if (((h.a)localObject).aIQ)
      {
        if (localh.aII.aIQ) {}
        com.google.android.exoplayer2.h.a[] arrayOfa;
        for (int j = 1;; j = 0)
        {
          arrayOfa = new com.google.android.exoplayer2.h.a[j + (int)(localh.aII.aIP - ((h.a)localObject).aIP) / localh.aID];
          j = 0;
          while (j < arrayOfa.length)
          {
            arrayOfa[j] = ((h.a)localObject).aIR;
            localObject = ((h.a)localObject).mO();
            j += 1;
          }
        }
        localh.aIC.a(arrayOfa);
      }
      localh.aIG = new h.a(0L, localh.aID);
      localh.aIH = localh.aIG;
      localh.aII = localh.aIG;
      localh.aDL = 0L;
      localh.aIC.nN();
      i += 1;
    }
    this.aKJ = false;
  }
  
  final void ne()
  {
    if ((this.released) || (this.prepared) || (!this.aKz)) {
      return;
    }
    Object localObject = this.aKx;
    int j = localObject.length;
    int i = 0;
    for (;;)
    {
      if (i >= j) {
        break label59;
      }
      if (localObject[i].aIE.mI() == null) {
        break;
      }
      i += 1;
    }
    label59:
    int n = this.aKx.length;
    int k = 0;
    int m = -1;
    j = 0;
    if (k < n)
    {
      localObject = this.aKx[k].aIE.mI().aus;
      if (com.google.android.exoplayer2.i.g.aw((String)localObject))
      {
        i = 3;
        label106:
        if (i <= j) {
          break label156;
        }
        j = k;
      }
    }
    for (;;)
    {
      k += 1;
      m = j;
      j = i;
      break;
      if (com.google.android.exoplayer2.i.g.av((String)localObject))
      {
        i = 2;
        break label106;
      }
      if (com.google.android.exoplayer2.i.g.ax((String)localObject))
      {
        i = 1;
        break label106;
      }
      i = 0;
      break label106;
      label156:
      if ((i == j) && (m != -1))
      {
        m = -1;
        i = j;
        j = m;
        continue;
        l locall = this.aKr.aJt;
        int i1 = locall.length;
        this.aKD = -1;
        this.aKF = new boolean[n];
        this.aKG = new boolean[n];
        l[] arrayOfl = new l[n];
        i = 0;
        while (i < n)
        {
          Format localFormat = this.aKx[i].aIE.mI();
          localObject = localFormat.aus;
          if ((com.google.android.exoplayer2.i.g.aw((String)localObject)) || (com.google.android.exoplayer2.i.g.av((String)localObject))) {}
          for (int i2 = 1;; i2 = 0)
          {
            this.aKG[i] = i2;
            this.aKE = (i2 | this.aKE);
            if (i != m) {
              break label364;
            }
            localObject = new Format[i1];
            k = 0;
            while (k < i1)
            {
              localObject[k] = a(locall.aIs[k], localFormat);
              k += 1;
            }
          }
          arrayOfl[i] = new l((Format[])localObject);
          this.aKD = i;
          i += 1;
          continue;
          label364:
          if ((j == 3) && (com.google.android.exoplayer2.i.g.av(localFormat.aus))) {}
          for (localObject = this.aKs;; localObject = null)
          {
            arrayOfl[i] = new l(new Format[] { a((Format)localObject, localFormat) });
            break;
          }
        }
        this.att = new m(arrayOfl);
        this.prepared = true;
        this.aKq.kA();
      }
      else
      {
        i = j;
        j = m;
      }
    }
  }
  
  final boolean nf()
  {
    return this.aKI != -9223372036854775807L;
  }
  
  final void r(int paramInt, boolean paramBoolean)
  {
    int i = 1;
    boolean bool;
    int j;
    if (this.aKF[paramInt] != paramBoolean)
    {
      bool = true;
      com.google.android.exoplayer2.i.a.aC(bool);
      this.aKF[paramInt] = paramBoolean;
      j = this.aKA;
      if (!paramBoolean) {
        break label54;
      }
    }
    label54:
    for (paramInt = i;; paramInt = -1)
    {
      this.aKA = (j + paramInt);
      return;
      bool = false;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.google.android.exoplayer2.source.b.j
 * JD-Core Version:    0.7.0.1
 */