package com.google.android.exoplayer2.source.b;

import android.os.Handler;
import android.text.TextUtils;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.c.g;
import com.google.android.exoplayer2.h.b;
import com.google.android.exoplayer2.h.t;
import com.google.android.exoplayer2.h.t.a;
import com.google.android.exoplayer2.h.t.c;
import com.google.android.exoplayer2.h.t.d;
import com.google.android.exoplayer2.source.b.a;
import com.google.android.exoplayer2.source.b.a.a.a;
import com.google.android.exoplayer2.source.m;
import com.google.android.exoplayer2.source.m.b;
import com.google.android.exoplayer2.source.o;
import com.google.android.exoplayer2.source.o.a;
import com.google.android.exoplayer2.source.q;
import com.google.android.exoplayer2.source.r;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Arrays;
import java.util.LinkedList;

final class j
  implements g, t.a<com.google.android.exoplayer2.source.a.a>, t.d, m.b, o
{
  boolean bcY;
  r bcq;
  private final int bvE;
  private final b bvH;
  final t bvK;
  private final Runnable bvN;
  m[] bvQ;
  private int[] bvR;
  boolean bvS;
  boolean bvT;
  int bvV;
  long bwa;
  private long bwb;
  boolean bwd;
  final LinkedList<f> byA;
  Format byB;
  int byC;
  int byD;
  private boolean byE;
  boolean[] byF;
  private boolean[] byG;
  boolean byH;
  final b.a byl;
  private final a byw;
  final c byx;
  private final Format byy;
  private final c.b byz;
  final Handler handler;
  boolean released;
  final int trackType;
  
  public j(int paramInt1, a parama, c paramc, b paramb, long paramLong, Format paramFormat, int paramInt2, b.a parama1)
  {
    AppMethodBeat.i(62866);
    this.trackType = paramInt1;
    this.byw = parama;
    this.byx = paramc;
    this.bvH = paramb;
    this.byy = paramFormat;
    this.bvE = paramInt2;
    this.byl = parama1;
    this.bvK = new t("Loader:HlsSampleStreamWrapper");
    this.byz = new c.b();
    this.bvR = new int[0];
    this.bvQ = new m[0];
    this.byA = new LinkedList();
    this.bvN = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(62865);
        j.this.vV();
        AppMethodBeat.o(62865);
      }
    };
    this.handler = new Handler();
    this.bwa = paramLong;
    this.bwb = paramLong;
    AppMethodBeat.o(62866);
  }
  
  private boolean Z(long paramLong)
  {
    AppMethodBeat.i(62880);
    int j = this.bvQ.length;
    int i = 0;
    while (i < j)
    {
      m localm = this.bvQ[i];
      localm.rewind();
      if ((!localm.f(paramLong, false)) && ((this.byG[i] != 0) || (!this.byE)))
      {
        AppMethodBeat.o(62880);
        return false;
      }
      localm.vK();
      i += 1;
    }
    AppMethodBeat.o(62880);
    return true;
  }
  
  private static Format a(Format paramFormat1, Format paramFormat2)
  {
    AppMethodBeat.i(62879);
    if (paramFormat1 == null)
    {
      AppMethodBeat.o(62879);
      return paramFormat2;
    }
    String str = null;
    int i = com.google.android.exoplayer2.i.j.bB(paramFormat2.bdq);
    if (i == 1) {
      str = j(paramFormat1.bdn, 1);
    }
    for (;;)
    {
      paramFormat1 = paramFormat2.a(paramFormat1.id, str, paramFormat1.bitrate, paramFormat1.width, paramFormat1.height, paramFormat1.bdD, paramFormat1.language);
      AppMethodBeat.o(62879);
      return paramFormat1;
      if (i == 2) {
        str = j(paramFormat1.bdn, 2);
      }
    }
  }
  
  private static String j(String paramString, int paramInt)
  {
    AppMethodBeat.i(62881);
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(62881);
      return null;
    }
    paramString = paramString.split("(\\s*,\\s*)|(\\s*$)");
    StringBuilder localStringBuilder = new StringBuilder();
    int j = paramString.length;
    int i = 0;
    while (i < j)
    {
      String str = paramString[i];
      if (paramInt == com.google.android.exoplayer2.i.j.bB(com.google.android.exoplayer2.i.j.bA(str)))
      {
        if (localStringBuilder.length() > 0) {
          localStringBuilder.append(",");
        }
        localStringBuilder.append(str);
      }
      i += 1;
    }
    if (localStringBuilder.length() > 0)
    {
      paramString = localStringBuilder.toString();
      AppMethodBeat.o(62881);
      return paramString;
    }
    AppMethodBeat.o(62881);
    return null;
  }
  
  public final boolean X(long paramLong)
  {
    AppMethodBeat.i(62872);
    if ((this.bwd) || (this.bvK.isLoading()))
    {
      AppMethodBeat.o(62872);
      return false;
    }
    Object localObject2 = this.byx;
    if (this.byA.isEmpty()) {}
    for (Object localObject1 = null;; localObject1 = (f)this.byA.getLast())
    {
      if (this.bwb != -9223372036854775807L) {
        paramLong = this.bwb;
      }
      ((c)localObject2).a((f)localObject1, paramLong, this.byz);
      boolean bool = this.byz.bxN;
      localObject1 = this.byz.bxM;
      localObject2 = this.byz.bxO;
      this.byz.clear();
      if (!bool) {
        break;
      }
      this.bwb = -9223372036854775807L;
      this.bwd = true;
      AppMethodBeat.o(62872);
      return true;
    }
    if (localObject1 == null)
    {
      if (localObject2 != null) {
        this.byw.a((a.a)localObject2);
      }
      AppMethodBeat.o(62872);
      return false;
    }
    if ((localObject1 instanceof f))
    {
      this.bwb = -9223372036854775807L;
      localObject2 = (f)localObject1;
      ((f)localObject2).a(this);
      this.byA.add(localObject2);
    }
    paramLong = this.bvK.a((t.c)localObject1, this, this.bvE);
    this.byl.a(((com.google.android.exoplayer2.source.a.a)localObject1).bxj, ((com.google.android.exoplayer2.source.a.a)localObject1).type, this.trackType, ((com.google.android.exoplayer2.source.a.a)localObject1).bxk, ((com.google.android.exoplayer2.source.a.a)localObject1).bxl, ((com.google.android.exoplayer2.source.a.a)localObject1).bxm, ((com.google.android.exoplayer2.source.a.a)localObject1).bxn, ((com.google.android.exoplayer2.source.a.a)localObject1).bxo, paramLong);
    AppMethodBeat.o(62872);
    return true;
  }
  
  public final void a(com.google.android.exoplayer2.c.l paraml) {}
  
  public final void aT(boolean paramBoolean)
  {
    this.byx.bxC = paramBoolean;
  }
  
  public final m eG(int paramInt)
  {
    AppMethodBeat.i(62874);
    int j = this.bvQ.length;
    int i = 0;
    while (i < j)
    {
      if (this.bvR[i] == paramInt)
      {
        localm = this.bvQ[i];
        AppMethodBeat.o(62874);
        return localm;
      }
      i += 1;
    }
    m localm = new m(this.bvH);
    localm.bwY = this;
    this.bvR = Arrays.copyOf(this.bvR, j + 1);
    this.bvR[j] = paramInt;
    this.bvQ = ((m[])Arrays.copyOf(this.bvQ, j + 1));
    this.bvQ[j] = localm;
    AppMethodBeat.o(62874);
    return localm;
  }
  
  public final boolean i(long paramLong, boolean paramBoolean)
  {
    AppMethodBeat.i(62868);
    this.bwa = paramLong;
    if ((!paramBoolean) && (!vz()) && (Z(paramLong)))
    {
      AppMethodBeat.o(62868);
      return false;
    }
    this.bwb = paramLong;
    this.bwd = false;
    this.byA.clear();
    if (this.bvK.isLoading()) {
      this.bvK.cancelLoading();
    }
    for (;;)
    {
      AppMethodBeat.o(62868);
      return true;
      vU();
    }
  }
  
  final void p(int paramInt, boolean paramBoolean)
  {
    int i = 1;
    AppMethodBeat.i(62878);
    boolean bool;
    int j;
    if (this.byF[paramInt] != paramBoolean)
    {
      bool = true;
      com.google.android.exoplayer2.i.a.checkState(bool);
      this.byF[paramInt] = paramBoolean;
      j = this.bvV;
      if (!paramBoolean) {
        break label66;
      }
    }
    label66:
    for (paramInt = i;; paramInt = -1)
    {
      this.bvV = (j + paramInt);
      AppMethodBeat.o(62878);
      return;
      bool = false;
      break;
    }
  }
  
  public final void uy()
  {
    AppMethodBeat.i(62875);
    this.bvS = true;
    this.handler.post(this.bvN);
    AppMethodBeat.o(62875);
  }
  
  public final void vT()
  {
    AppMethodBeat.i(62867);
    if (!this.bcY) {
      X(this.bwa);
    }
    AppMethodBeat.o(62867);
  }
  
  final void vU()
  {
    AppMethodBeat.i(62871);
    m[] arrayOfm = this.bvQ;
    int j = arrayOfm.length;
    int i = 0;
    while (i < j)
    {
      arrayOfm[i].reset(this.byH);
      i += 1;
    }
    this.byH = false;
    AppMethodBeat.o(62871);
  }
  
  final void vV()
  {
    AppMethodBeat.i(62877);
    if ((this.released) || (this.bcY) || (!this.bvS))
    {
      AppMethodBeat.o(62877);
      return;
    }
    Object localObject = this.bvQ;
    int j = localObject.length;
    int i = 0;
    while (i < j)
    {
      if (localObject[i].bwO.vG() == null)
      {
        AppMethodBeat.o(62877);
        return;
      }
      i += 1;
    }
    int n = this.bvQ.length;
    int k = 0;
    int m = -1;
    j = 0;
    if (k < n)
    {
      localObject = this.bvQ[k].bwO.vG().bdq;
      if (com.google.android.exoplayer2.i.j.by((String)localObject))
      {
        i = 3;
        label125:
        if (i <= j) {
          break label175;
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
      if (com.google.android.exoplayer2.i.j.bx((String)localObject))
      {
        i = 2;
        break label125;
      }
      if (com.google.android.exoplayer2.i.j.bz((String)localObject))
      {
        i = 1;
        break label125;
      }
      i = 0;
      break label125;
      label175:
      if ((i == j) && (m != -1))
      {
        m = -1;
        i = j;
        j = m;
        continue;
        q localq = this.byx.bxA;
        int i1 = localq.length;
        this.byD = -1;
        this.byF = new boolean[n];
        this.byG = new boolean[n];
        q[] arrayOfq = new q[n];
        i = 0;
        while (i < n)
        {
          Format localFormat = this.bvQ[i].bwO.vG();
          localObject = localFormat.bdq;
          if ((com.google.android.exoplayer2.i.j.by((String)localObject)) || (com.google.android.exoplayer2.i.j.bx((String)localObject))) {}
          for (int i2 = 1;; i2 = 0)
          {
            this.byG[i] = i2;
            this.byE = (i2 | this.byE);
            if (i != m) {
              break label383;
            }
            localObject = new Format[i1];
            k = 0;
            while (k < i1)
            {
              localObject[k] = a(localq.bwD[k], localFormat);
              k += 1;
            }
          }
          arrayOfq[i] = new q((Format[])localObject);
          this.byD = i;
          i += 1;
          continue;
          label383:
          if ((j == 3) && (com.google.android.exoplayer2.i.j.bx(localFormat.bdq))) {}
          for (localObject = this.byy;; localObject = null)
          {
            arrayOfq[i] = new q(new Format[] { a((Format)localObject, localFormat) });
            break;
          }
        }
        this.bcq = new r(arrayOfq);
        this.bcY = true;
        this.byw.tf();
        AppMethodBeat.o(62877);
      }
      else
      {
        i = j;
        j = m;
      }
    }
  }
  
  public final long vq()
  {
    AppMethodBeat.i(62869);
    if (this.bwd)
    {
      AppMethodBeat.o(62869);
      return -9223372036854775808L;
    }
    if (vz())
    {
      l = this.bwb;
      AppMethodBeat.o(62869);
      return l;
    }
    long l = this.bwa;
    Object localObject = (f)this.byA.getLast();
    if (((f)localObject).byj)
    {
      if (localObject == null) {
        break label171;
      }
      l = Math.max(l, ((f)localObject).bxo);
    }
    label171:
    for (;;)
    {
      localObject = this.bvQ;
      int j = localObject.length;
      int i = 0;
      for (;;)
      {
        if (i < j)
        {
          l = Math.max(l, localObject[i].bwO.vy());
          i += 1;
          continue;
          if (this.byA.size() > 1)
          {
            localObject = (f)this.byA.get(this.byA.size() - 2);
            break;
          }
          localObject = null;
          break;
        }
      }
      AppMethodBeat.o(62869);
      return l;
    }
  }
  
  public final long vr()
  {
    AppMethodBeat.i(62873);
    if (vz())
    {
      l = this.bwb;
      AppMethodBeat.o(62873);
      return l;
    }
    if (this.bwd)
    {
      AppMethodBeat.o(62873);
      return -9223372036854775808L;
    }
    long l = ((f)this.byA.getLast()).bxo;
    AppMethodBeat.o(62873);
    return l;
  }
  
  public final void vv()
  {
    AppMethodBeat.i(62870);
    vU();
    AppMethodBeat.o(62870);
  }
  
  public final void vw()
  {
    AppMethodBeat.i(62876);
    this.handler.post(this.bvN);
    AppMethodBeat.o(62876);
  }
  
  final boolean vz()
  {
    return this.bwb != -9223372036854775807L;
  }
  
  public static abstract interface a
    extends o.a<j>
  {
    public abstract void a(a.a parama);
    
    public abstract void tf();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.google.android.exoplayer2.source.b.j
 * JD-Core Version:    0.7.0.1
 */