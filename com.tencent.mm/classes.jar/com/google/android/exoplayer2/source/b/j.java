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
import com.google.android.exoplayer2.source.o;
import com.google.android.exoplayer2.source.p;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Arrays;
import java.util.LinkedList;

final class j
  implements g, t.a<com.google.android.exoplayer2.source.a.a>, t.d, k.b, m
{
  int aPA;
  long aPG;
  private long aPH;
  boolean aPJ;
  private final int aPj;
  private final b aPm;
  final t aPp;
  private final Runnable aPs;
  k[] aPv;
  private int[] aPw;
  boolean aPx;
  boolean aPy;
  final com.google.android.exoplayer2.source.a.a aRJ;
  private final j.a aRU;
  final c aRV;
  private final Format aRW;
  private final c.b aRX;
  final LinkedList<f> aRY;
  Format aRZ;
  int aSa;
  int aSb;
  private boolean aSc;
  boolean[] aSd;
  private boolean[] aSe;
  boolean aSf;
  final int auX;
  p avL;
  final Handler handler;
  boolean prepared;
  boolean released;
  
  public j(int paramInt1, j.a parama, c paramc, b paramb, long paramLong, Format paramFormat, int paramInt2, com.google.android.exoplayer2.source.a.a parama1)
  {
    AppMethodBeat.i(125942);
    this.auX = paramInt1;
    this.aRU = parama;
    this.aRV = paramc;
    this.aPm = paramb;
    this.aRW = paramFormat;
    this.aPj = paramInt2;
    this.aRJ = parama1;
    this.aPp = new t("Loader:HlsSampleStreamWrapper");
    this.aRX = new c.b();
    this.aPw = new int[0];
    this.aPv = new k[0];
    this.aRY = new LinkedList();
    this.aPs = new j.1(this);
    this.handler = new Handler();
    this.aPG = paramLong;
    this.aPH = paramLong;
    AppMethodBeat.o(125942);
  }
  
  private boolean S(long paramLong)
  {
    AppMethodBeat.i(125956);
    int j = this.aPv.length;
    int i = 0;
    while (i < j)
    {
      k localk = this.aPv[i];
      localk.rewind();
      if ((!localk.g(paramLong, false)) && ((this.aSe[i] != 0) || (!this.aSc)))
      {
        AppMethodBeat.o(125956);
        return false;
      }
      localk.pq();
      i += 1;
    }
    AppMethodBeat.o(125956);
    return true;
  }
  
  private static Format a(Format paramFormat1, Format paramFormat2)
  {
    AppMethodBeat.i(125955);
    if (paramFormat1 == null)
    {
      AppMethodBeat.o(125955);
      return paramFormat2;
    }
    String str = null;
    int i = com.google.android.exoplayer2.i.j.aK(paramFormat2.awK);
    if (i == 1) {
      str = i(paramFormat1.awH, 1);
    }
    for (;;)
    {
      paramFormat1 = paramFormat2.a(paramFormat1.id, str, paramFormat1.bitrate, paramFormat1.width, paramFormat1.height, paramFormat1.awZ, paramFormat1.axa);
      AppMethodBeat.o(125955);
      return paramFormat1;
      if (i == 2) {
        str = i(paramFormat1.awH, 2);
      }
    }
  }
  
  private static String i(String paramString, int paramInt)
  {
    AppMethodBeat.i(125957);
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(125957);
      return null;
    }
    paramString = paramString.split("(\\s*,\\s*)|(\\s*$)");
    StringBuilder localStringBuilder = new StringBuilder();
    int j = paramString.length;
    int i = 0;
    while (i < j)
    {
      String str = paramString[i];
      if (paramInt == com.google.android.exoplayer2.i.j.aK(com.google.android.exoplayer2.i.j.aJ(str)))
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
      AppMethodBeat.o(125957);
      return paramString;
    }
    AppMethodBeat.o(125957);
    return null;
  }
  
  public final boolean Q(long paramLong)
  {
    AppMethodBeat.i(125948);
    if ((this.aPJ) || (this.aPp.isLoading()))
    {
      AppMethodBeat.o(125948);
      return false;
    }
    Object localObject2 = this.aRV;
    if (this.aRY.isEmpty()) {}
    for (Object localObject1 = null;; localObject1 = (f)this.aRY.getLast())
    {
      if (this.aPH != -9223372036854775807L) {
        paramLong = this.aPH;
      }
      ((c)localObject2).a((f)localObject1, paramLong, this.aRX);
      boolean bool = this.aRX.aRl;
      localObject1 = this.aRX.aRk;
      localObject2 = this.aRX.aRm;
      this.aRX.clear();
      if (!bool) {
        break;
      }
      this.aPH = -9223372036854775807L;
      this.aPJ = true;
      AppMethodBeat.o(125948);
      return true;
    }
    if (localObject1 == null)
    {
      if (localObject2 != null) {
        this.aRU.a((com.google.android.exoplayer2.source.b.a.a.a)localObject2);
      }
      AppMethodBeat.o(125948);
      return false;
    }
    if ((localObject1 instanceof f))
    {
      this.aPH = -9223372036854775807L;
      localObject2 = (f)localObject1;
      ((f)localObject2).a(this);
      this.aRY.add(localObject2);
    }
    paramLong = this.aPp.a((t.c)localObject1, this, this.aPj);
    this.aRJ.a(((com.google.android.exoplayer2.source.a.a)localObject1).aQI, ((com.google.android.exoplayer2.source.a.a)localObject1).type, this.auX, ((com.google.android.exoplayer2.source.a.a)localObject1).aQJ, ((com.google.android.exoplayer2.source.a.a)localObject1).aQK, ((com.google.android.exoplayer2.source.a.a)localObject1).aQL, ((com.google.android.exoplayer2.source.a.a)localObject1).aQM, ((com.google.android.exoplayer2.source.a.a)localObject1).aQN, paramLong);
    AppMethodBeat.o(125948);
    return true;
  }
  
  public final void a(l paraml) {}
  
  public final void aH(boolean paramBoolean)
  {
    this.aRV.aRb = paramBoolean;
  }
  
  public final k dS(int paramInt)
  {
    AppMethodBeat.i(125950);
    int j = this.aPv.length;
    int i = 0;
    while (i < j)
    {
      if (this.aPw[i] == paramInt)
      {
        localk = this.aPv[i];
        AppMethodBeat.o(125950);
        return localk;
      }
      i += 1;
    }
    k localk = new k(this.aPm);
    localk.aQx = this;
    this.aPw = Arrays.copyOf(this.aPw, j + 1);
    this.aPw[j] = paramInt;
    this.aPv = ((k[])Arrays.copyOf(this.aPv, j + 1));
    this.aPv[j] = localk;
    AppMethodBeat.o(125950);
    return localk;
  }
  
  public final boolean j(long paramLong, boolean paramBoolean)
  {
    AppMethodBeat.i(125944);
    this.aPG = paramLong;
    if ((!paramBoolean) && (!pe()) && (S(paramLong)))
    {
      AppMethodBeat.o(125944);
      return false;
    }
    this.aPH = paramLong;
    this.aPJ = false;
    this.aRY.clear();
    if (this.aPp.isLoading()) {
      this.aPp.cancelLoading();
    }
    for (;;)
    {
      AppMethodBeat.o(125944);
      return true;
      pB();
    }
  }
  
  public final void nZ()
  {
    AppMethodBeat.i(125951);
    this.aPx = true;
    this.handler.post(this.aPs);
    AppMethodBeat.o(125951);
  }
  
  final void o(int paramInt, boolean paramBoolean)
  {
    int i = 1;
    AppMethodBeat.i(125954);
    boolean bool;
    int j;
    if (this.aSd[paramInt] != paramBoolean)
    {
      bool = true;
      com.google.android.exoplayer2.i.a.checkState(bool);
      this.aSd[paramInt] = paramBoolean;
      j = this.aPA;
      if (!paramBoolean) {
        break label66;
      }
    }
    label66:
    for (paramInt = i;; paramInt = -1)
    {
      this.aPA = (j + paramInt);
      AppMethodBeat.o(125954);
      return;
      bool = false;
      break;
    }
  }
  
  public final long oV()
  {
    AppMethodBeat.i(125945);
    if (this.aPJ)
    {
      AppMethodBeat.o(125945);
      return -9223372036854775808L;
    }
    if (pe())
    {
      l = this.aPH;
      AppMethodBeat.o(125945);
      return l;
    }
    long l = this.aPG;
    Object localObject = (f)this.aRY.getLast();
    if (((f)localObject).aRH)
    {
      if (localObject == null) {
        break label171;
      }
      l = Math.max(l, ((f)localObject).aQN);
    }
    label171:
    for (;;)
    {
      localObject = this.aPv;
      int j = localObject.length;
      int i = 0;
      for (;;)
      {
        if (i < j)
        {
          l = Math.max(l, localObject[i].aQn.pd());
          i += 1;
          continue;
          if (this.aRY.size() > 1)
          {
            localObject = (f)this.aRY.get(this.aRY.size() - 2);
            break;
          }
          localObject = null;
          break;
        }
      }
      AppMethodBeat.o(125945);
      return l;
    }
  }
  
  public final long oW()
  {
    AppMethodBeat.i(125949);
    if (pe())
    {
      l = this.aPH;
      AppMethodBeat.o(125949);
      return l;
    }
    if (this.aPJ)
    {
      AppMethodBeat.o(125949);
      return -9223372036854775808L;
    }
    long l = ((f)this.aRY.getLast()).aQN;
    AppMethodBeat.o(125949);
    return l;
  }
  
  public final void pA()
  {
    AppMethodBeat.i(125943);
    if (!this.prepared) {
      Q(this.aPG);
    }
    AppMethodBeat.o(125943);
  }
  
  final void pB()
  {
    AppMethodBeat.i(125947);
    k[] arrayOfk = this.aPv;
    int j = arrayOfk.length;
    int i = 0;
    while (i < j)
    {
      arrayOfk[i].reset(this.aSf);
      i += 1;
    }
    this.aSf = false;
    AppMethodBeat.o(125947);
  }
  
  final void pC()
  {
    AppMethodBeat.i(125953);
    if ((this.released) || (this.prepared) || (!this.aPx))
    {
      AppMethodBeat.o(125953);
      return;
    }
    Object localObject = this.aPv;
    int j = localObject.length;
    int i = 0;
    while (i < j)
    {
      if (localObject[i].aQn.pm() == null)
      {
        AppMethodBeat.o(125953);
        return;
      }
      i += 1;
    }
    int n = this.aPv.length;
    int k = 0;
    int m = -1;
    j = 0;
    if (k < n)
    {
      localObject = this.aPv[k].aQn.pm().awK;
      if (com.google.android.exoplayer2.i.j.aH((String)localObject))
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
      if (com.google.android.exoplayer2.i.j.aG((String)localObject))
      {
        i = 2;
        break label125;
      }
      if (com.google.android.exoplayer2.i.j.aI((String)localObject))
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
        o localo = this.aRV.aQZ;
        int i1 = localo.length;
        this.aSb = -1;
        this.aSd = new boolean[n];
        this.aSe = new boolean[n];
        o[] arrayOfo = new o[n];
        i = 0;
        while (i < n)
        {
          Format localFormat = this.aPv[i].aQn.pm();
          localObject = localFormat.awK;
          if ((com.google.android.exoplayer2.i.j.aH((String)localObject)) || (com.google.android.exoplayer2.i.j.aG((String)localObject))) {}
          for (int i2 = 1;; i2 = 0)
          {
            this.aSe[i] = i2;
            this.aSc = (i2 | this.aSc);
            if (i != m) {
              break label383;
            }
            localObject = new Format[i1];
            k = 0;
            while (k < i1)
            {
              localObject[k] = a(localo.aQc[k], localFormat);
              k += 1;
            }
          }
          arrayOfo[i] = new o((Format[])localObject);
          this.aSb = i;
          i += 1;
          continue;
          label383:
          if ((j == 3) && (com.google.android.exoplayer2.i.j.aG(localFormat.awK))) {}
          for (localObject = this.aRW;; localObject = null)
          {
            arrayOfo[i] = new o(new Format[] { a((Format)localObject, localFormat) });
            break;
          }
        }
        this.avL = new p(arrayOfo);
        this.prepared = true;
        this.aRU.mG();
        AppMethodBeat.o(125953);
      }
      else
      {
        i = j;
        j = m;
      }
    }
  }
  
  public final void pa()
  {
    AppMethodBeat.i(125946);
    pB();
    AppMethodBeat.o(125946);
  }
  
  public final void pb()
  {
    AppMethodBeat.i(125952);
    this.handler.post(this.aPs);
    AppMethodBeat.o(125952);
  }
  
  final boolean pe()
  {
    return this.aPH != -9223372036854775807L;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.google.android.exoplayer2.source.b.j
 * JD-Core Version:    0.7.0.1
 */