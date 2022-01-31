package com.google.android.exoplayer2.source;

import android.net.Uri;
import android.os.Handler;
import com.google.android.exoplayer2.c.e;
import com.google.android.exoplayer2.c.m;
import com.google.android.exoplayer2.h.b;
import com.google.android.exoplayer2.h.t;
import com.google.android.exoplayer2.h.t.a;
import com.google.android.exoplayer2.h.t.d;
import com.google.android.exoplayer2.i.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Arrays;

final class f
  implements com.google.android.exoplayer2.c.g, t.a<f.a>, t.d, h, k.b
{
  private final com.google.android.exoplayer2.h.g aBo;
  h.a aOX;
  private int aPA;
  p aPB;
  boolean[] aPC;
  boolean[] aPD;
  boolean aPE;
  private long aPF;
  long aPG;
  private long aPH;
  private int aPI;
  boolean aPJ;
  private final int aPj;
  final g.a aPk;
  final f.c aPl;
  private final b aPm;
  final String aPn;
  final long aPo;
  final t aPp;
  private final f.b aPq;
  final com.google.android.exoplayer2.i.f aPr;
  private final Runnable aPs;
  final Runnable aPt;
  com.google.android.exoplayer2.c.l aPu;
  k[] aPv;
  private int[] aPw;
  boolean aPx;
  private boolean aPy;
  boolean aPz;
  long axh;
  private final Handler eventHandler;
  final Handler handler;
  boolean prepared;
  boolean released;
  private final Uri uri;
  
  public f(Uri paramUri, com.google.android.exoplayer2.h.g paramg, e[] paramArrayOfe, int paramInt1, Handler paramHandler, g.a parama, f.c paramc, b paramb, String paramString, int paramInt2)
  {
    AppMethodBeat.i(95486);
    this.uri = paramUri;
    this.aBo = paramg;
    this.aPj = paramInt1;
    this.eventHandler = paramHandler;
    this.aPk = parama;
    this.aPl = paramc;
    this.aPm = paramb;
    this.aPn = paramString;
    this.aPo = paramInt2;
    this.aPp = new t("Loader:ExtractorMediaPeriod");
    this.aPq = new f.b(paramArrayOfe, this);
    this.aPr = new com.google.android.exoplayer2.i.f();
    this.aPs = new f.1(this);
    this.aPt = new f.2(this);
    this.handler = new Handler();
    this.aPw = new int[0];
    this.aPv = new k[0];
    this.aPH = -9223372036854775807L;
    this.aPF = -1L;
    AppMethodBeat.o(95486);
  }
  
  private boolean S(long paramLong)
  {
    AppMethodBeat.i(95500);
    int j = this.aPv.length;
    int i = 0;
    while (i < j)
    {
      k localk = this.aPv[i];
      localk.rewind();
      if ((!localk.g(paramLong, false)) && ((this.aPD[i] != 0) || (!this.aPE)))
      {
        AppMethodBeat.o(95500);
        return false;
      }
      localk.pq();
      i += 1;
    }
    AppMethodBeat.o(95500);
    return true;
  }
  
  private void a(f.a parama)
  {
    if (this.aPF == -1L) {
      this.aPF = parama.aPF;
    }
  }
  
  private int pc()
  {
    AppMethodBeat.i(95501);
    k[] arrayOfk = this.aPv;
    int k = arrayOfk.length;
    int j = 0;
    int m;
    for (int i = 0; j < k; i = m + i)
    {
      m = arrayOfk[j].aQn.pj();
      j += 1;
    }
    AppMethodBeat.o(95501);
    return i;
  }
  
  private long pd()
  {
    AppMethodBeat.i(95502);
    long l = -9223372036854775808L;
    k[] arrayOfk = this.aPv;
    int j = arrayOfk.length;
    int i = 0;
    while (i < j)
    {
      l = Math.max(l, arrayOfk[i].aQn.pd());
      i += 1;
    }
    AppMethodBeat.o(95502);
    return l;
  }
  
  private void startLoading()
  {
    AppMethodBeat.i(95499);
    f.a locala = new f.a(this, this.uri, this.aBo, this.aPq, this.aPr);
    if (this.prepared)
    {
      a.checkState(pe());
      if ((this.axh != -9223372036854775807L) && (this.aPH >= this.axh))
      {
        this.aPJ = true;
        this.aPH = -9223372036854775807L;
        AppMethodBeat.o(95499);
        return;
      }
      locala.j(this.aPu.E(this.aPH), this.aPH);
      this.aPH = -9223372036854775807L;
    }
    this.aPI = pc();
    int j = this.aPj;
    int i = j;
    if (j == -1) {
      if ((this.prepared) && (this.aPF == -1L) && ((this.aPu == null) || (this.aPu.getDurationUs() == -9223372036854775807L))) {
        break label193;
      }
    }
    label193:
    for (i = 3;; i = 6)
    {
      this.aPp.a(locala, this, i);
      AppMethodBeat.o(95499);
      return;
    }
  }
  
  public final void O(long paramLong)
  {
    AppMethodBeat.i(95490);
    int j = this.aPv.length;
    int i = 0;
    while (i < j)
    {
      this.aPv[i].i(paramLong, this.aPC[i]);
      i += 1;
    }
    AppMethodBeat.o(95490);
  }
  
  public final long P(long paramLong)
  {
    AppMethodBeat.i(95494);
    if (this.aPu.nV()) {}
    for (;;)
    {
      this.aPG = paramLong;
      this.aPz = false;
      if ((pe()) || (!S(paramLong))) {
        break;
      }
      AppMethodBeat.o(95494);
      return paramLong;
      paramLong = 0L;
    }
    this.aPH = paramLong;
    this.aPJ = false;
    if (this.aPp.isLoading()) {
      this.aPp.cancelLoading();
    }
    for (;;)
    {
      AppMethodBeat.o(95494);
      return paramLong;
      k[] arrayOfk = this.aPv;
      int j = arrayOfk.length;
      int i = 0;
      while (i < j)
      {
        arrayOfk[i].reset(false);
        i += 1;
      }
    }
  }
  
  public final boolean Q(long paramLong)
  {
    AppMethodBeat.i(95491);
    if ((this.aPJ) || ((this.prepared) && (this.aPA == 0)))
    {
      AppMethodBeat.o(95491);
      return false;
    }
    boolean bool = this.aPr.open();
    if (!this.aPp.isLoading())
    {
      startLoading();
      bool = true;
    }
    AppMethodBeat.o(95491);
    return bool;
  }
  
  public final long a(com.google.android.exoplayer2.g.f[] paramArrayOff, boolean[] paramArrayOfBoolean1, l[] paramArrayOfl, boolean[] paramArrayOfBoolean2, long paramLong)
  {
    int m = 0;
    int k = 0;
    AppMethodBeat.i(95489);
    a.checkState(this.prepared);
    int j = this.aPA;
    int i = 0;
    int n;
    while (i < paramArrayOff.length)
    {
      if ((paramArrayOfl[i] != null) && ((paramArrayOff[i] == null) || (paramArrayOfBoolean1[i] == 0)))
      {
        n = ((f.d)paramArrayOfl[i]).track;
        a.checkState(this.aPC[n]);
        this.aPA -= 1;
        this.aPC[n] = false;
        paramArrayOfl[i] = null;
      }
      i += 1;
    }
    label128:
    boolean bool;
    if (this.aPy) {
      if (j == 0)
      {
        i = 1;
        j = 0;
        if (j >= paramArrayOff.length) {
          break label359;
        }
        if ((paramArrayOfl[j] != null) || (paramArrayOff[j] == null)) {
          break label536;
        }
        paramArrayOfBoolean1 = paramArrayOff[j];
        if (paramArrayOfBoolean1.length() != 1) {
          break label335;
        }
        bool = true;
        label167:
        a.checkState(bool);
        if (paramArrayOfBoolean1.eh(0) != 0) {
          break label341;
        }
        bool = true;
        label185:
        a.checkState(bool);
        n = this.aPB.a(paramArrayOfBoolean1.qg());
        if (this.aPC[n] != 0) {
          break label347;
        }
        bool = true;
        label218:
        a.checkState(bool);
        this.aPA += 1;
        this.aPC[n] = true;
        paramArrayOfl[j] = new f.d(this, n);
        paramArrayOfBoolean2[j] = true;
        if (i != 0) {
          break label536;
        }
        paramArrayOfBoolean1 = this.aPv[n];
        paramArrayOfBoolean1.rewind();
        if ((paramArrayOfBoolean1.g(paramLong, true)) || (paramArrayOfBoolean1.aQn.pk() == 0)) {
          break label353;
        }
        i = 1;
      }
    }
    label536:
    for (;;)
    {
      j += 1;
      break label128;
      i = 0;
      break;
      if (paramLong != 0L)
      {
        i = 1;
        break;
      }
      i = 0;
      break;
      label335:
      bool = false;
      break label167;
      label341:
      bool = false;
      break label185;
      label347:
      bool = false;
      break label218;
      label353:
      i = 0;
      continue;
      label359:
      long l;
      if (this.aPA == 0)
      {
        this.aPz = false;
        if (this.aPp.isLoading())
        {
          paramArrayOff = this.aPv;
          j = paramArrayOff.length;
          i = k;
          while (i < j)
          {
            paramArrayOff[i].pr();
            i += 1;
          }
          this.aPp.cancelLoading();
          l = paramLong;
        }
      }
      do
      {
        this.aPy = true;
        AppMethodBeat.o(95489);
        return l;
        paramArrayOff = this.aPv;
        j = paramArrayOff.length;
        i = 0;
        for (;;)
        {
          l = paramLong;
          if (i >= j) {
            break;
          }
          paramArrayOff[i].reset(false);
          i += 1;
        }
        l = paramLong;
      } while (i == 0);
      paramLong = P(paramLong);
      i = m;
      for (;;)
      {
        l = paramLong;
        if (i >= paramArrayOfl.length) {
          break;
        }
        if (paramArrayOfl[i] != null) {
          paramArrayOfBoolean2[i] = true;
        }
        i += 1;
      }
    }
  }
  
  public final void a(com.google.android.exoplayer2.c.l paraml)
  {
    AppMethodBeat.i(95497);
    this.aPu = paraml;
    this.handler.post(this.aPs);
    AppMethodBeat.o(95497);
  }
  
  public final void a(h.a parama, long paramLong)
  {
    AppMethodBeat.i(95488);
    this.aOX = parama;
    this.aPr.open();
    startLoading();
    AppMethodBeat.o(95488);
  }
  
  public final m dm(int paramInt)
  {
    AppMethodBeat.i(95495);
    int j = this.aPv.length;
    int i = 0;
    while (i < j)
    {
      if (this.aPw[i] == paramInt)
      {
        localk = this.aPv[i];
        AppMethodBeat.o(95495);
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
    AppMethodBeat.o(95495);
    return localk;
  }
  
  public final void nZ()
  {
    AppMethodBeat.i(95496);
    this.aPx = true;
    this.handler.post(this.aPs);
    AppMethodBeat.o(95496);
  }
  
  public final void oS() {}
  
  public final p oT()
  {
    return this.aPB;
  }
  
  public final long oU()
  {
    if (this.aPz)
    {
      this.aPz = false;
      return this.aPG;
    }
    return -9223372036854775807L;
  }
  
  public final long oV()
  {
    AppMethodBeat.i(95493);
    if (this.aPJ)
    {
      AppMethodBeat.o(95493);
      return -9223372036854775808L;
    }
    long l1;
    if (pe())
    {
      l1 = this.aPH;
      AppMethodBeat.o(95493);
      return l1;
    }
    if (this.aPE)
    {
      l1 = 9223372036854775807L;
      int j = this.aPv.length;
      int i = 0;
      for (;;)
      {
        l2 = l1;
        if (i >= j) {
          break;
        }
        l2 = l1;
        if (this.aPD[i] != 0) {
          l2 = Math.min(l1, this.aPv[i].aQn.pd());
        }
        i += 1;
        l1 = l2;
      }
    }
    long l2 = pd();
    if (l2 == -9223372036854775808L)
    {
      l1 = this.aPG;
      AppMethodBeat.o(95493);
      return l1;
    }
    AppMethodBeat.o(95493);
    return l2;
  }
  
  public final long oW()
  {
    AppMethodBeat.i(95492);
    if (this.aPA == 0)
    {
      AppMethodBeat.o(95492);
      return -9223372036854775808L;
    }
    long l = oV();
    AppMethodBeat.o(95492);
    return l;
  }
  
  public final void pa()
  {
    AppMethodBeat.i(95487);
    Object localObject = this.aPq;
    if (((f.b)localObject).aPQ != null) {
      ((f.b)localObject).aPQ = null;
    }
    localObject = this.aPv;
    int j = localObject.length;
    int i = 0;
    while (i < j)
    {
      localObject[i].reset(false);
      i += 1;
    }
    AppMethodBeat.o(95487);
  }
  
  public final void pb()
  {
    AppMethodBeat.i(95498);
    this.handler.post(this.aPs);
    AppMethodBeat.o(95498);
  }
  
  final boolean pe()
  {
    return this.aPH != -9223372036854775807L;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.google.android.exoplayer2.source.f
 * JD-Core Version:    0.7.0.1
 */