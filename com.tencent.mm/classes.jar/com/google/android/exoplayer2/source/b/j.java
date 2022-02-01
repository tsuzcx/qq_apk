package com.google.android.exoplayer2.source.b;

import android.os.Handler;
import android.text.TextUtils;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.c.g;
import com.google.android.exoplayer2.c.l;
import com.google.android.exoplayer2.h.b;
import com.google.android.exoplayer2.h.t;
import com.google.android.exoplayer2.h.t.a;
import com.google.android.exoplayer2.h.t.c;
import com.google.android.exoplayer2.h.t.d;
import com.google.android.exoplayer2.source.k;
import com.google.android.exoplayer2.source.k.b;
import com.google.android.exoplayer2.source.m;
import com.google.android.exoplayer2.source.m.a;
import com.google.android.exoplayer2.source.o;
import com.google.android.exoplayer2.source.p;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Arrays;
import java.util.LinkedList;

final class j
  implements g, t.a<com.google.android.exoplayer2.source.a.a>, t.d, k.b, m
{
  p bct;
  boolean bdb;
  private final int bvJ;
  private final b bvM;
  final t bvP;
  private final Runnable bvS;
  k[] bvV;
  private int[] bvW;
  boolean bvX;
  boolean bvY;
  int bwa;
  long bwf;
  private long bwg;
  boolean bwi;
  int byA;
  int byB;
  private boolean byC;
  boolean[] byD;
  private boolean[] byE;
  boolean byF;
  final com.google.android.exoplayer2.source.a.a byj;
  private final a byu;
  final c byv;
  private final Format byw;
  private final c.b byx;
  final LinkedList<f> byy;
  Format byz;
  final Handler handler;
  boolean released;
  final int trackType;
  
  public j(int paramInt1, a parama, c paramc, b paramb, long paramLong, Format paramFormat, int paramInt2, com.google.android.exoplayer2.source.a.a parama1)
  {
    AppMethodBeat.i(62866);
    this.trackType = paramInt1;
    this.byu = parama;
    this.byv = paramc;
    this.bvM = paramb;
    this.byw = paramFormat;
    this.bvJ = paramInt2;
    this.byj = parama1;
    this.bvP = new t("Loader:HlsSampleStreamWrapper");
    this.byx = new c.b();
    this.bvW = new int[0];
    this.bvV = new k[0];
    this.byy = new LinkedList();
    this.bvS = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(62865);
        j.this.vQ();
        AppMethodBeat.o(62865);
      }
    };
    this.handler = new Handler();
    this.bwf = paramLong;
    this.bwg = paramLong;
    AppMethodBeat.o(62866);
  }
  
  private boolean Z(long paramLong)
  {
    AppMethodBeat.i(62880);
    int j = this.bvV.length;
    int i = 0;
    while (i < j)
    {
      k localk = this.bvV[i];
      localk.rewind();
      if ((!localk.f(paramLong, false)) && ((this.byE[i] != 0) || (!this.byC)))
      {
        AppMethodBeat.o(62880);
        return false;
      }
      localk.vF();
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
    int i = com.google.android.exoplayer2.i.j.bB(paramFormat2.bdt);
    if (i == 1) {
      str = j(paramFormat1.bdq, 1);
    }
    for (;;)
    {
      paramFormat1 = paramFormat2.a(paramFormat1.id, str, paramFormat1.bitrate, paramFormat1.width, paramFormat1.height, paramFormat1.bdG, paramFormat1.language);
      AppMethodBeat.o(62879);
      return paramFormat1;
      if (i == 2) {
        str = j(paramFormat1.bdq, 2);
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
    if ((this.bwi) || (this.bvP.isLoading()))
    {
      AppMethodBeat.o(62872);
      return false;
    }
    Object localObject2 = this.byv;
    if (this.byy.isEmpty()) {}
    for (Object localObject1 = null;; localObject1 = (f)this.byy.getLast())
    {
      if (this.bwg != -9223372036854775807L) {
        paramLong = this.bwg;
      }
      ((c)localObject2).a((f)localObject1, paramLong, this.byx);
      boolean bool = this.byx.bxL;
      localObject1 = this.byx.bxK;
      localObject2 = this.byx.bxM;
      this.byx.clear();
      if (!bool) {
        break;
      }
      this.bwg = -9223372036854775807L;
      this.bwi = true;
      AppMethodBeat.o(62872);
      return true;
    }
    if (localObject1 == null)
    {
      if (localObject2 != null) {
        this.byu.a((com.google.android.exoplayer2.source.b.a.a.a)localObject2);
      }
      AppMethodBeat.o(62872);
      return false;
    }
    if ((localObject1 instanceof f))
    {
      this.bwg = -9223372036854775807L;
      localObject2 = (f)localObject1;
      ((f)localObject2).a(this);
      this.byy.add(localObject2);
    }
    paramLong = this.bvP.a((t.c)localObject1, this, this.bvJ);
    this.byj.a(((com.google.android.exoplayer2.source.a.a)localObject1).bxi, ((com.google.android.exoplayer2.source.a.a)localObject1).type, this.trackType, ((com.google.android.exoplayer2.source.a.a)localObject1).bxj, ((com.google.android.exoplayer2.source.a.a)localObject1).bxk, ((com.google.android.exoplayer2.source.a.a)localObject1).bxl, ((com.google.android.exoplayer2.source.a.a)localObject1).bxm, ((com.google.android.exoplayer2.source.a.a)localObject1).bxn, paramLong);
    AppMethodBeat.o(62872);
    return true;
  }
  
  public final void a(l paraml) {}
  
  public final void aU(boolean paramBoolean)
  {
    this.byv.bxB = paramBoolean;
  }
  
  public final k eH(int paramInt)
  {
    AppMethodBeat.i(62874);
    int j = this.bvV.length;
    int i = 0;
    while (i < j)
    {
      if (this.bvW[i] == paramInt)
      {
        localk = this.bvV[i];
        AppMethodBeat.o(62874);
        return localk;
      }
      i += 1;
    }
    k localk = new k(this.bvM);
    localk.bwX = this;
    this.bvW = Arrays.copyOf(this.bvW, j + 1);
    this.bvW[j] = paramInt;
    this.bvV = ((k[])Arrays.copyOf(this.bvV, j + 1));
    this.bvV[j] = localk;
    AppMethodBeat.o(62874);
    return localk;
  }
  
  public final boolean i(long paramLong, boolean paramBoolean)
  {
    AppMethodBeat.i(62868);
    this.bwf = paramLong;
    if ((!paramBoolean) && (!vt()) && (Z(paramLong)))
    {
      AppMethodBeat.o(62868);
      return false;
    }
    this.bwg = paramLong;
    this.bwi = false;
    this.byy.clear();
    if (this.bvP.isLoading()) {
      this.bvP.cancelLoading();
    }
    for (;;)
    {
      AppMethodBeat.o(62868);
      return true;
      vP();
    }
  }
  
  final void n(int paramInt, boolean paramBoolean)
  {
    int i = 1;
    AppMethodBeat.i(62878);
    boolean bool;
    int j;
    if (this.byD[paramInt] != paramBoolean)
    {
      bool = true;
      com.google.android.exoplayer2.i.a.checkState(bool);
      this.byD[paramInt] = paramBoolean;
      j = this.bwa;
      if (!paramBoolean) {
        break label66;
      }
    }
    label66:
    for (paramInt = i;; paramInt = -1)
    {
      this.bwa = (j + paramInt);
      AppMethodBeat.o(62878);
      return;
      bool = false;
      break;
    }
  }
  
  public final void ut()
  {
    AppMethodBeat.i(62875);
    this.bvX = true;
    this.handler.post(this.bvS);
    AppMethodBeat.o(62875);
  }
  
  public final void vO()
  {
    AppMethodBeat.i(62867);
    if (!this.bdb) {
      X(this.bwf);
    }
    AppMethodBeat.o(62867);
  }
  
  final void vP()
  {
    AppMethodBeat.i(62871);
    k[] arrayOfk = this.bvV;
    int j = arrayOfk.length;
    int i = 0;
    while (i < j)
    {
      arrayOfk[i].reset(this.byF);
      i += 1;
    }
    this.byF = false;
    AppMethodBeat.o(62871);
  }
  
  final void vQ()
  {
    AppMethodBeat.i(62877);
    if ((this.released) || (this.bdb) || (!this.bvX))
    {
      AppMethodBeat.o(62877);
      return;
    }
    Object localObject = this.bvV;
    int j = localObject.length;
    int i = 0;
    while (i < j)
    {
      if (localObject[i].bwN.vB() == null)
      {
        AppMethodBeat.o(62877);
        return;
      }
      i += 1;
    }
    int n = this.bvV.length;
    int k = 0;
    int m = -1;
    j = 0;
    if (k < n)
    {
      localObject = this.bvV[k].bwN.vB().bdt;
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
        o localo = this.byv.bxz;
        int i1 = localo.length;
        this.byB = -1;
        this.byD = new boolean[n];
        this.byE = new boolean[n];
        o[] arrayOfo = new o[n];
        i = 0;
        while (i < n)
        {
          Format localFormat = this.bvV[i].bwN.vB();
          localObject = localFormat.bdt;
          if ((com.google.android.exoplayer2.i.j.by((String)localObject)) || (com.google.android.exoplayer2.i.j.bx((String)localObject))) {}
          for (int i2 = 1;; i2 = 0)
          {
            this.byE[i] = i2;
            this.byC = (i2 | this.byC);
            if (i != m) {
              break label383;
            }
            localObject = new Format[i1];
            k = 0;
            while (k < i1)
            {
              localObject[k] = a(localo.bwC[k], localFormat);
              k += 1;
            }
          }
          arrayOfo[i] = new o((Format[])localObject);
          this.byB = i;
          i += 1;
          continue;
          label383:
          if ((j == 3) && (com.google.android.exoplayer2.i.j.bx(localFormat.bdt))) {}
          for (localObject = this.byw;; localObject = null)
          {
            arrayOfo[i] = new o(new Format[] { a((Format)localObject, localFormat) });
            break;
          }
        }
        this.bct = new p(arrayOfo);
        this.bdb = true;
        this.byu.ta();
        AppMethodBeat.o(62877);
      }
      else
      {
        i = j;
        j = m;
      }
    }
  }
  
  public final long vk()
  {
    AppMethodBeat.i(62869);
    if (this.bwi)
    {
      AppMethodBeat.o(62869);
      return -9223372036854775808L;
    }
    if (vt())
    {
      l = this.bwg;
      AppMethodBeat.o(62869);
      return l;
    }
    long l = this.bwf;
    Object localObject = (f)this.byy.getLast();
    if (((f)localObject).byh)
    {
      if (localObject == null) {
        break label171;
      }
      l = Math.max(l, ((f)localObject).bxn);
    }
    label171:
    for (;;)
    {
      localObject = this.bvV;
      int j = localObject.length;
      int i = 0;
      for (;;)
      {
        if (i < j)
        {
          l = Math.max(l, localObject[i].bwN.vs());
          i += 1;
          continue;
          if (this.byy.size() > 1)
          {
            localObject = (f)this.byy.get(this.byy.size() - 2);
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
  
  public final long vl()
  {
    AppMethodBeat.i(62873);
    if (vt())
    {
      l = this.bwg;
      AppMethodBeat.o(62873);
      return l;
    }
    if (this.bwi)
    {
      AppMethodBeat.o(62873);
      return -9223372036854775808L;
    }
    long l = ((f)this.byy.getLast()).bxn;
    AppMethodBeat.o(62873);
    return l;
  }
  
  public final void vp()
  {
    AppMethodBeat.i(62870);
    vP();
    AppMethodBeat.o(62870);
  }
  
  public final void vq()
  {
    AppMethodBeat.i(62876);
    this.handler.post(this.bvS);
    AppMethodBeat.o(62876);
  }
  
  final boolean vt()
  {
    return this.bwg != -9223372036854775807L;
  }
  
  public static abstract interface a
    extends m.a<j>
  {
    public abstract void a(com.google.android.exoplayer2.source.b.a.a.a parama);
    
    public abstract void ta();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.google.android.exoplayer2.source.b.j
 * JD-Core Version:    0.7.0.1
 */