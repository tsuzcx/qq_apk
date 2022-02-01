package com.google.android.exoplayer2.c.d;

import android.util.Pair;
import android.util.SparseArray;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.c.f;
import com.google.android.exoplayer2.c.l.a;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.drm.DrmInitData.SchemeData;
import com.google.android.exoplayer2.i.u;
import com.google.android.exoplayer2.i.x;
import com.google.android.exoplayer2.o;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;
import java.util.UUID;

public final class e
  implements com.google.android.exoplayer2.c.e
{
  public static final com.google.android.exoplayer2.c.h aRP;
  private static final int aWB;
  private static final byte[] aWC;
  private long aNk;
  private com.google.android.exoplayer2.c.g aRV;
  private int aRW;
  private final com.google.android.exoplayer2.i.m aSf;
  private int aTn;
  private int aTo;
  private final j aWD;
  private final SparseArray<b> aWE;
  private final com.google.android.exoplayer2.i.m aWF;
  private final com.google.android.exoplayer2.i.m aWG;
  private final com.google.android.exoplayer2.i.m aWH;
  private final com.google.android.exoplayer2.i.m aWI;
  private final u aWJ;
  private final com.google.android.exoplayer2.i.m aWK;
  private final byte[] aWL;
  private final Stack<a.a> aWM;
  private final LinkedList<a> aWN;
  private int aWO;
  private long aWP;
  private int aWQ;
  private com.google.android.exoplayer2.i.m aWR;
  private long aWS;
  private int aWT;
  private long aWU;
  private b aWV;
  private boolean aWW;
  private com.google.android.exoplayer2.c.m aWX;
  private com.google.android.exoplayer2.c.m[] aWY;
  private boolean aWZ;
  private final int flags;
  private int sampleSize;
  
  static
  {
    AppMethodBeat.i(92104);
    aRP = new com.google.android.exoplayer2.c.h()
    {
      public final com.google.android.exoplayer2.c.e[] ss()
      {
        AppMethodBeat.i(92075);
        e locale = new e();
        AppMethodBeat.o(92075);
        return new com.google.android.exoplayer2.c.e[] { locale };
      }
    };
    aWB = x.bU("seig");
    aWC = new byte[] { -94, 57, 79, 82, 90, -101, 79, 20, -94, 68, 108, 66, 124, 100, -115, -12 };
    AppMethodBeat.o(92104);
  }
  
  public e()
  {
    this(0);
  }
  
  public e(int paramInt)
  {
    this(paramInt, null);
  }
  
  public e(int paramInt, u paramu)
  {
    this(paramInt, paramu, (byte)0);
  }
  
  private e(int paramInt, u paramu, byte paramByte)
  {
    AppMethodBeat.i(194215);
    this.flags = (paramInt | 0x0);
    this.aWJ = paramu;
    this.aWD = null;
    this.aWK = new com.google.android.exoplayer2.i.m(16);
    this.aSf = new com.google.android.exoplayer2.i.m(com.google.android.exoplayer2.i.k.bqC);
    this.aWF = new com.google.android.exoplayer2.i.m(5);
    this.aWG = new com.google.android.exoplayer2.i.m();
    this.aWH = new com.google.android.exoplayer2.i.m(1);
    this.aWI = new com.google.android.exoplayer2.i.m();
    this.aWL = new byte[16];
    this.aWM = new Stack();
    this.aWN = new LinkedList();
    this.aWE = new SparseArray();
    this.aNk = -9223372036854775807L;
    this.aWU = -9223372036854775807L;
    sA();
    AppMethodBeat.o(194215);
  }
  
  private void R(long paramLong)
  {
    AppMethodBeat.i(92085);
    while ((!this.aWM.isEmpty()) && (((a.a)this.aWM.peek()).aWa == paramLong)) {
      c((a.a)this.aWM.pop());
    }
    sA();
    AppMethodBeat.o(92085);
  }
  
  private static int a(b paramb, int paramInt1, long paramLong, int paramInt2, com.google.android.exoplayer2.i.m paramm, int paramInt3)
  {
    AppMethodBeat.i(92099);
    paramm.setPosition(8);
    int i1 = a.er(paramm.readInt());
    j localj = paramb.aXc;
    paramb = paramb.aXb;
    c localc = paramb.aYa;
    paramb.aYg[paramInt1] = paramm.vo();
    paramb.aYf[paramInt1] = paramb.aYc;
    Object localObject;
    if ((i1 & 0x1) != 0)
    {
      localObject = paramb.aYf;
      localObject[paramInt1] += paramm.readInt();
    }
    int j;
    int i;
    int k;
    label129:
    int m;
    label141:
    int n;
    if ((i1 & 0x4) != 0)
    {
      j = 1;
      i = localc.flags;
      if (j != 0) {
        i = paramm.vo();
      }
      if ((i1 & 0x100) == 0) {
        break label427;
      }
      k = 1;
      if ((i1 & 0x200) == 0) {
        break label433;
      }
      m = 1;
      if ((i1 & 0x400) == 0) {
        break label439;
      }
      n = 1;
      label153:
      if ((i1 & 0x800) == 0) {
        break label445;
      }
      i1 = 1;
      label165:
      if ((localj.aXT == null) || (localj.aXT.length != 1) || (localj.aXT[0] != 0L)) {
        break label528;
      }
    }
    label258:
    label515:
    label528:
    for (long l1 = x.b(localj.aXU[0], 1000L, localj.aXQ);; l1 = 0L)
    {
      localObject = paramb.aYh;
      int[] arrayOfInt = paramb.aYi;
      long[] arrayOfLong = paramb.aYj;
      boolean[] arrayOfBoolean = paramb.aYk;
      int i4;
      label285:
      int i2;
      label304:
      int i3;
      if ((localj.type == 2) && ((paramInt2 & 0x1) != 0))
      {
        paramInt2 = 1;
        i4 = paramInt3 + paramb.aYg[paramInt1];
        long l2 = localj.aXQ;
        if (paramInt1 > 0) {
          paramLong = paramb.aYr;
        }
        if (paramInt3 >= i4) {
          break label515;
        }
        if (k == 0) {
          break label457;
        }
        i2 = paramm.vo();
        if (m == 0) {
          break label467;
        }
        i3 = paramm.vo();
        label316:
        if ((paramInt3 != 0) || (j == 0)) {
          break label477;
        }
        paramInt1 = i;
        label329:
        if (i1 == 0) {
          break label500;
        }
        arrayOfInt[paramInt3] = ((int)(paramm.readInt() * 1000L / l2));
        label353:
        arrayOfLong[paramInt3] = (x.b(paramLong, 1000L, l2) - l1);
        localObject[paramInt3] = i3;
        if (((paramInt1 >> 16 & 0x1) != 0) || ((paramInt2 != 0) && (paramInt3 != 0))) {
          break label509;
        }
      }
      label427:
      label433:
      label439:
      label445:
      label457:
      label467:
      label477:
      label500:
      label509:
      for (int i5 = 1;; i5 = 0)
      {
        arrayOfBoolean[paramInt3] = i5;
        paramLong += i2;
        paramInt3 += 1;
        break label285;
        j = 0;
        break;
        k = 0;
        break label129;
        m = 0;
        break label141;
        n = 0;
        break label153;
        i1 = 0;
        break label165;
        paramInt2 = 0;
        break label258;
        i2 = localc.duration;
        break label304;
        i3 = localc.size;
        break label316;
        if (n != 0)
        {
          paramInt1 = paramm.readInt();
          break label329;
        }
        paramInt1 = localc.flags;
        break label329;
        arrayOfInt[paramInt3] = 0;
        break label353;
      }
      paramb.aYr = paramLong;
      AppMethodBeat.o(92099);
      return i4;
    }
  }
  
  private static b a(com.google.android.exoplayer2.i.m paramm, SparseArray<b> paramSparseArray, int paramInt)
  {
    AppMethodBeat.i(92097);
    paramm.setPosition(8);
    int k = a.er(paramm.readInt());
    int i = paramm.readInt();
    if ((paramInt & 0x10) == 0) {}
    for (paramInt = i;; paramInt = 0)
    {
      paramSparseArray = (b)paramSparseArray.get(paramInt);
      if (paramSparseArray != null) {
        break;
      }
      AppMethodBeat.o(92097);
      return null;
    }
    if ((k & 0x1) != 0)
    {
      long l = paramm.vq();
      paramSparseArray.aXb.aYc = l;
      paramSparseArray.aXb.aYd = l;
    }
    c localc = paramSparseArray.aXd;
    label125:
    int j;
    if ((k & 0x2) != 0)
    {
      paramInt = paramm.vo() - 1;
      if ((k & 0x8) == 0) {
        break label190;
      }
      i = paramm.vo();
      if ((k & 0x10) == 0) {
        break label199;
      }
      j = paramm.vo();
      label139:
      if ((k & 0x20) == 0) {
        break label209;
      }
    }
    label190:
    label199:
    label209:
    for (k = paramm.vo();; k = localc.flags)
    {
      paramSparseArray.aXb.aYa = new c(paramInt, i, j, k);
      AppMethodBeat.o(92097);
      return paramSparseArray;
      paramInt = localc.aWx;
      break;
      i = localc.duration;
      break label125;
      j = localc.size;
      break label139;
    }
  }
  
  private static void a(a.a parama, SparseArray<b> paramSparseArray, int paramInt, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(92092);
    int j = parama.aWc.size();
    int i = 0;
    while (i < j)
    {
      a.a locala = (a.a)parama.aWc.get(i);
      if (locala.type == a.aUW) {
        b(locala, paramSparseArray, paramInt, paramArrayOfByte);
      }
      i += 1;
    }
    AppMethodBeat.o(92092);
  }
  
  private static void a(a.a parama, b paramb, long paramLong, int paramInt)
  {
    AppMethodBeat.i(92094);
    int k = 0;
    int i = 0;
    parama = parama.aWb;
    int i1 = parama.size();
    int j = 0;
    Object localObject;
    int m;
    if (j < i1)
    {
      localObject = (a.b)parama.get(j);
      if (((a.b)localObject).type != a.aUK) {
        break label229;
      }
      localObject = ((a.b)localObject).aWd;
      ((com.google.android.exoplayer2.i.m)localObject).setPosition(12);
      m = ((com.google.android.exoplayer2.i.m)localObject).vo();
      if (m <= 0) {
        break label229;
      }
      i = m + i;
      k += 1;
    }
    label229:
    for (;;)
    {
      j += 1;
      break;
      paramb.aXg = 0;
      paramb.aXf = 0;
      paramb.aXe = 0;
      paramb.aXb.bj(k, i);
      j = 0;
      k = 0;
      i = 0;
      while (i < i1)
      {
        localObject = (a.b)parama.get(i);
        int n = j;
        m = k;
        if (((a.b)localObject).type == a.aUK)
        {
          m = a(paramb, j, paramLong, paramInt, ((a.b)localObject).aWd, k);
          n = j + 1;
        }
        i += 1;
        j = n;
        k = m;
      }
      AppMethodBeat.o(92094);
      return;
    }
  }
  
  private static void a(k paramk, com.google.android.exoplayer2.i.m paramm, l paraml)
  {
    boolean bool = true;
    AppMethodBeat.i(92095);
    int n = paramk.aXY;
    paramm.setPosition(8);
    if ((a.er(paramm.readInt()) & 0x1) == 1) {
      paramm.fu(8);
    }
    int i = paramm.readUnsignedByte();
    int m = paramm.vo();
    if (m != paraml.sampleCount)
    {
      paramk = new o("Length mismatch: " + m + ", " + paraml.sampleCount);
      AppMethodBeat.o(92095);
      throw paramk;
    }
    int k;
    if (i == 0)
    {
      paramk = paraml.aYm;
      i = 0;
      int j = 0;
      k = i;
      if (j < m)
      {
        k = paramm.readUnsignedByte();
        if (k > n) {}
        for (bool = true;; bool = false)
        {
          paramk[j] = bool;
          j += 1;
          i += k;
          break;
        }
      }
    }
    else
    {
      if (i <= n) {
        break label212;
      }
    }
    for (;;)
    {
      k = i * m + 0;
      Arrays.fill(paraml.aYm, 0, m, bool);
      paraml.ex(k);
      AppMethodBeat.o(92095);
      return;
      label212:
      bool = false;
    }
  }
  
  private static void a(com.google.android.exoplayer2.i.m paramm, int paramInt, l paraml)
  {
    AppMethodBeat.i(92101);
    paramm.setPosition(paramInt + 8);
    paramInt = a.er(paramm.readInt());
    if ((paramInt & 0x1) != 0)
    {
      paramm = new o("Overriding TrackEncryptionBox parameters is unsupported.");
      AppMethodBeat.o(92101);
      throw paramm;
    }
    if ((paramInt & 0x2) != 0) {}
    for (boolean bool = true;; bool = false)
    {
      paramInt = paramm.vo();
      if (paramInt == paraml.sampleCount) {
        break;
      }
      paramm = new o("Length mismatch: " + paramInt + ", " + paraml.sampleCount);
      AppMethodBeat.o(92101);
      throw paramm;
    }
    Arrays.fill(paraml.aYm, 0, paramInt, bool);
    paraml.ex(paramm.vg());
    paraml.q(paramm);
    AppMethodBeat.o(92101);
  }
  
  private static void a(com.google.android.exoplayer2.i.m paramm, l paraml)
  {
    AppMethodBeat.i(92096);
    paramm.setPosition(8);
    int i = paramm.readInt();
    if ((a.er(i) & 0x1) == 1) {
      paramm.fu(8);
    }
    int j = paramm.vo();
    if (j != 1)
    {
      paramm = new o("Unexpected saio entry count: ".concat(String.valueOf(j)));
      AppMethodBeat.o(92096);
      throw paramm;
    }
    i = a.eq(i);
    long l2 = paraml.aYd;
    if (i == 0) {}
    for (long l1 = paramm.ii();; l1 = paramm.vq())
    {
      paraml.aYd = (l1 + l2);
      AppMethodBeat.o(92096);
      return;
    }
  }
  
  private static void a(com.google.android.exoplayer2.i.m paramm, l paraml, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(92100);
    paramm.setPosition(8);
    paramm.readBytes(paramArrayOfByte, 0, 16);
    if (!Arrays.equals(paramArrayOfByte, aWC))
    {
      AppMethodBeat.o(92100);
      return;
    }
    a(paramm, 16, paraml);
    AppMethodBeat.o(92100);
  }
  
  private static void a(com.google.android.exoplayer2.i.m paramm1, com.google.android.exoplayer2.i.m paramm2, String paramString, l paraml)
  {
    AppMethodBeat.i(92102);
    paramm1.setPosition(8);
    int i = paramm1.readInt();
    if (paramm1.readInt() != aWB)
    {
      AppMethodBeat.o(92102);
      return;
    }
    if (a.eq(i) == 1) {
      paramm1.fu(4);
    }
    if (paramm1.readInt() != 1)
    {
      paramm1 = new o("Entry count in sbgp != 1 (unsupported).");
      AppMethodBeat.o(92102);
      throw paramm1;
    }
    paramm2.setPosition(8);
    i = paramm2.readInt();
    if (paramm2.readInt() != aWB)
    {
      AppMethodBeat.o(92102);
      return;
    }
    i = a.eq(i);
    if (i == 1)
    {
      if (paramm2.ii() == 0L)
      {
        paramm1 = new o("Variable length description in sgpd found (unsupported)");
        AppMethodBeat.o(92102);
        throw paramm1;
      }
    }
    else if (i >= 2) {
      paramm2.fu(4);
    }
    if (paramm2.ii() != 1L)
    {
      paramm1 = new o("Entry count in sgpd != 1 (unsupported).");
      AppMethodBeat.o(92102);
      throw paramm1;
    }
    paramm2.fu(1);
    int j = paramm2.readUnsignedByte();
    if (paramm2.readUnsignedByte() == 1) {}
    for (i = 1; i == 0; i = 0)
    {
      AppMethodBeat.o(92102);
      return;
    }
    i = paramm2.readUnsignedByte();
    byte[] arrayOfByte = new byte[16];
    paramm2.readBytes(arrayOfByte, 0, 16);
    paramm1 = null;
    if (i == 0)
    {
      int k = paramm2.readUnsignedByte();
      paramm1 = new byte[k];
      paramm2.readBytes(paramm1, 0, k);
    }
    paraml.aYl = true;
    paraml.aYn = new k(true, paramString, i, arrayOfByte, (j & 0xF0) >> 4, j & 0xF, paramm1);
    AppMethodBeat.o(92102);
  }
  
  private static void b(a.a parama, SparseArray<b> paramSparseArray, int paramInt, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(92093);
    paramSparseArray = a(parama.et(a.aUI).aWd, paramSparseArray, paramInt);
    if (paramSparseArray == null)
    {
      AppMethodBeat.o(92093);
      return;
    }
    l locall = paramSparseArray.aXb;
    long l2 = locall.aYr;
    paramSparseArray.reset();
    long l1 = l2;
    if (parama.et(a.aUH) != null)
    {
      l1 = l2;
      if ((paramInt & 0x2) == 0) {
        l1 = n(parama.et(a.aUH).aWd);
      }
    }
    a(parama, paramSparseArray, l1, paramInt);
    paramSparseArray = paramSparseArray.aXc.ew(locall.aYa.aWx);
    Object localObject1 = parama.et(a.aVn);
    if (localObject1 != null) {
      a(paramSparseArray, ((a.b)localObject1).aWd, locall);
    }
    localObject1 = parama.et(a.aVo);
    if (localObject1 != null) {
      a(((a.b)localObject1).aWd, locall);
    }
    localObject1 = parama.et(a.aVs);
    if (localObject1 != null) {
      a(((a.b)localObject1).aWd, 0, locall);
    }
    localObject1 = parama.et(a.aVp);
    Object localObject2 = parama.et(a.aVq);
    if ((localObject1 != null) && (localObject2 != null))
    {
      localObject1 = ((a.b)localObject1).aWd;
      localObject2 = ((a.b)localObject2).aWd;
      if (paramSparseArray == null) {
        break label308;
      }
    }
    label308:
    for (paramSparseArray = paramSparseArray.aXX;; paramSparseArray = null)
    {
      a((com.google.android.exoplayer2.i.m)localObject1, (com.google.android.exoplayer2.i.m)localObject2, paramSparseArray, locall);
      int i = parama.aWb.size();
      paramInt = 0;
      while (paramInt < i)
      {
        paramSparseArray = (a.b)parama.aWb.get(paramInt);
        if (paramSparseArray.type == a.aVr) {
          a(paramSparseArray.aWd, locall, paramArrayOfByte);
        }
        paramInt += 1;
      }
    }
    AppMethodBeat.o(92093);
  }
  
  private void c(a.a parama)
  {
    AppMethodBeat.i(92086);
    if (parama.type == a.aUM)
    {
      d(parama);
      AppMethodBeat.o(92086);
      return;
    }
    if (parama.type == a.aUV)
    {
      e(parama);
      AppMethodBeat.o(92086);
      return;
    }
    if (!this.aWM.isEmpty()) {
      ((a.a)this.aWM.peek()).a(parama);
    }
    AppMethodBeat.o(92086);
  }
  
  private void d(a.a parama)
  {
    boolean bool2 = true;
    int k = 0;
    int j = 0;
    AppMethodBeat.i(92087);
    Object localObject1;
    SparseArray localSparseArray;
    long l;
    label78:
    Object localObject3;
    if (this.aWD == null)
    {
      bool1 = true;
      com.google.android.exoplayer2.i.a.checkState(bool1, "Unexpected moov box.");
      localObject1 = o(parama.aWb);
      localObject2 = parama.eu(a.aUX);
      localSparseArray = new SparseArray();
      l = -9223372036854775807L;
      m = ((a.a)localObject2).aWb.size();
      i = 0;
      if (i >= m) {
        break label179;
      }
      localObject3 = (a.b)((a.a)localObject2).aWb.get(i);
      if (((a.b)localObject3).type != a.aUJ) {
        break label155;
      }
      localObject3 = l(((a.b)localObject3).aWd);
      localSparseArray.put(((Integer)((Pair)localObject3).first).intValue(), ((Pair)localObject3).second);
    }
    for (;;)
    {
      i += 1;
      break label78;
      bool1 = false;
      break;
      label155:
      if (((a.b)localObject3).type == a.aUY) {
        l = m(((a.b)localObject3).aWd);
      }
    }
    label179:
    Object localObject2 = new SparseArray();
    int m = parama.aWc.size();
    int i = 0;
    if (i < m)
    {
      localObject3 = (a.a)parama.aWc.get(i);
      a.b localb;
      if (((a.a)localObject3).type == a.aUO)
      {
        localb = parama.et(a.aUN);
        if ((this.flags & 0x20) == 0) {
          break label295;
        }
      }
      label295:
      for (bool1 = true;; bool1 = false)
      {
        localObject3 = b.a((a.a)localObject3, localb, l, (DrmInitData)localObject1, bool1, false);
        if (localObject3 != null) {
          ((SparseArray)localObject2).put(((j)localObject3).id, localObject3);
        }
        i += 1;
        break;
      }
    }
    m = ((SparseArray)localObject2).size();
    if (this.aWE.size() == 0)
    {
      i = j;
      while (i < m)
      {
        parama = (j)((SparseArray)localObject2).valueAt(i);
        localObject1 = new b(this.aRV.ej(i));
        ((b)localObject1).a(parama, (c)localSparseArray.get(parama.id));
        this.aWE.put(parama.id, localObject1);
        this.aNk = Math.max(this.aNk, parama.aNk);
        i += 1;
      }
      sB();
      this.aRV.st();
      AppMethodBeat.o(92087);
      return;
    }
    if (this.aWE.size() == m) {}
    for (boolean bool1 = bool2;; bool1 = false)
    {
      com.google.android.exoplayer2.i.a.checkState(bool1);
      i = k;
      while (i < m)
      {
        parama = (j)((SparseArray)localObject2).valueAt(i);
        ((b)this.aWE.get(parama.id)).a(parama, (c)localSparseArray.get(parama.id));
        i += 1;
      }
    }
    AppMethodBeat.o(92087);
  }
  
  private void e(a.a parama)
  {
    AppMethodBeat.i(92088);
    a(parama, this.aWE, this.flags, this.aWL);
    parama = o(parama.aWb);
    if (parama != null)
    {
      int j = this.aWE.size();
      int i = 0;
      while (i < j)
      {
        ((b)this.aWE.valueAt(i)).b(parama);
        i += 1;
      }
    }
    AppMethodBeat.o(92088);
  }
  
  private static Pair<Integer, c> l(com.google.android.exoplayer2.i.m paramm)
  {
    AppMethodBeat.i(92090);
    paramm.setPosition(12);
    paramm = Pair.create(Integer.valueOf(paramm.readInt()), new c(paramm.vo() - 1, paramm.vo(), paramm.vo(), paramm.readInt()));
    AppMethodBeat.o(92090);
    return paramm;
  }
  
  private static long m(com.google.android.exoplayer2.i.m paramm)
  {
    AppMethodBeat.i(92091);
    paramm.setPosition(8);
    if (a.eq(paramm.readInt()) == 0)
    {
      l = paramm.ii();
      AppMethodBeat.o(92091);
      return l;
    }
    long l = paramm.vq();
    AppMethodBeat.o(92091);
    return l;
  }
  
  private static long n(com.google.android.exoplayer2.i.m paramm)
  {
    AppMethodBeat.i(92098);
    paramm.setPosition(8);
    if (a.eq(paramm.readInt()) == 1)
    {
      l = paramm.vq();
      AppMethodBeat.o(92098);
      return l;
    }
    long l = paramm.ii();
    AppMethodBeat.o(92098);
    return l;
  }
  
  private static DrmInitData o(List<a.b> paramList)
  {
    AppMethodBeat.i(92103);
    int j = paramList.size();
    int i = 0;
    Object localObject3;
    for (Object localObject2 = null; i < j; localObject2 = localObject3)
    {
      Object localObject4 = (a.b)paramList.get(i);
      localObject3 = localObject2;
      if (((a.b)localObject4).type == a.aVf)
      {
        Object localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = new ArrayList();
        }
        localObject2 = ((a.b)localObject4).aWd.data;
        localObject4 = h.p((byte[])localObject2);
        localObject3 = localObject1;
        if (localObject4 != null)
        {
          ((ArrayList)localObject1).add(new DrmInitData.SchemeData((UUID)localObject4, "video/mp4", (byte[])localObject2));
          localObject3 = localObject1;
        }
      }
      i += 1;
    }
    if (localObject2 == null)
    {
      AppMethodBeat.o(92103);
      return null;
    }
    paramList = new DrmInitData((List)localObject2);
    AppMethodBeat.o(92103);
    return paramList;
  }
  
  private void sA()
  {
    this.aRW = 0;
    this.aWQ = 0;
  }
  
  private void sB()
  {
    AppMethodBeat.i(92089);
    if (((this.flags & 0x4) != 0) && (this.aWX == null))
    {
      this.aWX = this.aRV.ej(this.aWE.size());
      this.aWX.f(Format.d("application/x-emsg", 9223372036854775807L));
    }
    if (((this.flags & 0x8) != 0) && (this.aWY == null))
    {
      com.google.android.exoplayer2.c.m localm = this.aRV.ej(this.aWE.size() + 1);
      localm.f(Format.bn("application/cea-608"));
      this.aWY = new com.google.android.exoplayer2.c.m[] { localm };
    }
    AppMethodBeat.o(92089);
  }
  
  public final int a(f paramf, com.google.android.exoplayer2.c.k paramk)
  {
    AppMethodBeat.i(92084);
    Object localObject2;
    Object localObject1;
    long l2;
    label137:
    do
    {
      switch (this.aRW)
      {
      default: 
        if (this.aRW != 3) {
          break label2075;
        }
        if (this.aWV != null) {
          break;
        }
        localObject2 = this.aWE;
        paramk = null;
        l1 = 9223372036854775807L;
        j = ((SparseArray)localObject2).size();
        i = 0;
        while (i < j)
        {
          localObject1 = (b)((SparseArray)localObject2).valueAt(i);
          if (((b)localObject1).aXg == ((b)localObject1).aXb.aYe) {
            break label2911;
          }
          l2 = localObject1.aXb.aYf[localObject1.aXg];
          if (l2 >= l1) {
            break label2911;
          }
          l1 = l2;
          paramk = (com.google.android.exoplayer2.c.k)localObject1;
          i += 1;
        }
      case 0: 
        if (this.aWQ != 0) {
          break label221;
        }
        if (paramf.a(this.aWK.data, 0, 8, true)) {
          break label185;
        }
        i = 0;
      }
    } while (i != 0);
    AppMethodBeat.o(92084);
    return -1;
    label185:
    this.aWQ = 8;
    this.aWK.setPosition(0);
    this.aWP = this.aWK.ii();
    this.aWO = this.aWK.readInt();
    label221:
    if (this.aWP == 1L)
    {
      paramf.readFully(this.aWK.data, 8, 8);
      this.aWQ += 8;
      this.aWP = this.aWK.vq();
    }
    while (this.aWP < this.aWQ)
    {
      paramf = new o("Atom size less than header length (unsupported).");
      AppMethodBeat.o(92084);
      throw paramf;
      if (this.aWP == 0L)
      {
        l2 = paramf.sr();
        l1 = l2;
        if (l2 == -1L)
        {
          l1 = l2;
          if (!this.aWM.isEmpty()) {
            l1 = ((a.a)this.aWM.peek()).aWa;
          }
        }
        if (l1 != -1L) {
          this.aWP = (l1 - paramf.getPosition() + this.aWQ);
        }
      }
    }
    long l1 = paramf.getPosition() - this.aWQ;
    if (this.aWO == a.aUV)
    {
      j = this.aWE.size();
      i = 0;
      while (i < j)
      {
        paramk = ((b)this.aWE.valueAt(i)).aXb;
        paramk.aYb = l1;
        paramk.aYd = l1;
        paramk.aYc = l1;
        i += 1;
      }
    }
    if (this.aWO == a.aUs)
    {
      this.aWV = null;
      this.aWS = (this.aWP + l1);
      if (!this.aWZ)
      {
        this.aRV.a(new l.a(this.aNk));
        this.aWZ = true;
      }
      this.aRW = 2;
    }
    for (;;)
    {
      i = 1;
      break;
      i = this.aWO;
      if ((i == a.aUM) || (i == a.aUO) || (i == a.aUP) || (i == a.aUQ) || (i == a.aUR) || (i == a.aUV) || (i == a.aUW) || (i == a.aUX) || (i == a.aVa)) {
        i = 1;
      }
      for (;;)
      {
        if (i != 0)
        {
          l1 = paramf.getPosition() + this.aWP - 8L;
          this.aWM.add(new a.a(this.aWO, l1));
          if (this.aWP == this.aWQ)
          {
            R(l1);
            break;
            i = 0;
            continue;
          }
          sA();
          break;
        }
      }
      i = this.aWO;
      if ((i == a.aVd) || (i == a.aVc) || (i == a.aUN) || (i == a.aUL) || (i == a.aVe) || (i == a.aUH) || (i == a.aUI) || (i == a.aUZ) || (i == a.aUJ) || (i == a.aUK) || (i == a.aVf) || (i == a.aVn) || (i == a.aVo) || (i == a.aVs) || (i == a.aVr) || (i == a.aVp) || (i == a.aVq) || (i == a.aVb) || (i == a.aUY) || (i == a.aVR)) {
        i = 1;
      }
      for (;;)
      {
        if (i != 0) {
          if (this.aWQ != 8)
          {
            paramf = new o("Leaf atom defines extended atom size (unsupported).");
            AppMethodBeat.o(92084);
            throw paramf;
            i = 0;
          }
          else
          {
            if (this.aWP > 2147483647L)
            {
              paramf = new o("Leaf atom with length > 2147483647 (unsupported).");
              AppMethodBeat.o(92084);
              throw paramf;
            }
            this.aWR = new com.google.android.exoplayer2.i.m((int)this.aWP);
            System.arraycopy(this.aWK.data, 0, this.aWR.data, 0, 8);
            this.aRW = 1;
            break;
          }
        }
      }
      if (this.aWP > 2147483647L)
      {
        paramf = new o("Skipping atom with length > 2147483647 (unsupported).");
        AppMethodBeat.o(92084);
        throw paramf;
      }
      this.aWR = null;
      this.aRW = 1;
    }
    int i = (int)this.aWP - this.aWQ;
    if (this.aWR != null)
    {
      paramf.readFully(this.aWR.data, 8, i);
      paramk = new a.b(this.aWO, this.aWR);
      l2 = paramf.getPosition();
      if (!this.aWM.isEmpty()) {
        ((a.a)this.aWM.peek()).a(paramk);
      }
    }
    Object localObject3;
    Object localObject4;
    int k;
    for (;;)
    {
      R(paramf.getPosition());
      break;
      if (paramk.type == a.aUL)
      {
        paramk = paramk.aWd;
        paramk.setPosition(8);
        i = a.eq(paramk.readInt());
        paramk.fu(4);
        long l5 = paramk.ii();
        long l4;
        long l3;
        if (i == 0)
        {
          l1 = paramk.ii();
          l2 += paramk.ii();
          l4 = x.b(l1, 1000000L, l5);
          paramk.fu(2);
          j = paramk.readUnsignedShort();
          localObject1 = new int[j];
          localObject2 = new long[j];
          localObject3 = new long[j];
          localObject4 = new long[j];
          i = 0;
          l3 = l4;
        }
        for (;;)
        {
          if (i >= j) {
            break label1333;
          }
          k = paramk.readInt();
          if ((0x80000000 & k) != 0)
          {
            paramf = new o("Unhandled indirect reference");
            AppMethodBeat.o(92084);
            throw paramf;
            l1 = paramk.vq();
            l2 += paramk.vq();
            break;
          }
          long l6 = paramk.ii();
          localObject1[i] = (k & 0x7FFFFFFF);
          localObject2[i] = l2;
          localObject4[i] = l3;
          l1 += l6;
          l3 = x.b(l1, 1000000L, l5);
          localObject3[i] = (l3 - localObject4[i]);
          paramk.fu(4);
          l2 += localObject1[i];
          i += 1;
        }
        label1333:
        paramk = Pair.create(Long.valueOf(l4), new com.google.android.exoplayer2.c.a((int[])localObject1, (long[])localObject2, (long[])localObject3, (long[])localObject4));
        this.aWU = ((Long)paramk.first).longValue();
        this.aRV.a((com.google.android.exoplayer2.c.l)paramk.second);
        this.aWZ = true;
      }
      else if (paramk.type == a.aVR)
      {
        paramk = paramk.aWd;
        if (this.aWX != null)
        {
          paramk.setPosition(12);
          paramk.vr();
          paramk.vr();
          l1 = paramk.ii();
          l1 = x.b(paramk.ii(), 1000000L, l1);
          paramk.setPosition(12);
          i = paramk.vg();
          this.aWX.a(paramk, i);
          if (this.aWU != -9223372036854775807L)
          {
            this.aWX.a(l1 + this.aWU, 1, i, 0, null);
          }
          else
          {
            this.aWN.addLast(new a(l1, i));
            this.aWT += i;
            continue;
            paramf.ed(i);
          }
        }
      }
    }
    paramk = null;
    l1 = 9223372036854775807L;
    int j = this.aWE.size();
    i = 0;
    label1567:
    if (i < j)
    {
      localObject1 = ((b)this.aWE.valueAt(i)).aXb;
      if ((!((l)localObject1).aYq) || (((l)localObject1).aYd >= l1)) {
        break label2914;
      }
      l1 = ((l)localObject1).aYd;
      paramk = (b)this.aWE.valueAt(i);
    }
    label1928:
    label1960:
    label2014:
    label2400:
    label2914:
    for (;;)
    {
      i += 1;
      break label1567;
      if (paramk == null)
      {
        this.aRW = 3;
        break;
      }
      i = (int)(l1 - paramf.getPosition());
      if (i < 0)
      {
        paramf = new o("Offset to encryption data was negative.");
        AppMethodBeat.o(92084);
        throw paramf;
      }
      paramf.ed(i);
      paramk = paramk.aXb;
      paramf.readFully(paramk.aYp.data, 0, paramk.aYo);
      paramk.aYp.setPosition(0);
      paramk.aYq = false;
      break;
      if (paramk == null)
      {
        i = (int)(this.aWS - paramf.getPosition());
        if (i < 0)
        {
          paramf = new o("Offset to end of mdat was negative.");
          AppMethodBeat.o(92084);
          throw paramf;
        }
        paramf.ed(i);
        sA();
        i = 0;
        label1779:
        if (i != 0)
        {
          AppMethodBeat.o(92084);
          return 0;
        }
      }
      else
      {
        j = (int)(paramk.aXb.aYf[paramk.aXg] - paramf.getPosition());
        i = j;
        if (j < 0) {
          i = 0;
        }
        paramf.ed(i);
        this.aWV = paramk;
        this.sampleSize = this.aWV.aXb.aYh[this.aWV.aXe];
        label2032:
        int n;
        if (this.aWV.aXb.aYl)
        {
          localObject3 = this.aWV;
          localObject2 = ((b)localObject3).aXb;
          i = ((l)localObject2).aYa.aWx;
          if (((l)localObject2).aYn != null)
          {
            paramk = ((l)localObject2).aYn;
            if (paramk.aXY == 0) {
              break label2309;
            }
            localObject1 = ((l)localObject2).aYp;
            i = paramk.aXY;
            paramk = (com.google.android.exoplayer2.c.k)localObject1;
            i2 = localObject2.aYm[localObject3.aXe];
            localObject1 = this.aWH.data;
            if (i2 == 0) {
              break label2339;
            }
            j = 128;
            localObject1[0] = ((byte)(j | i));
            this.aWH.setPosition(0);
            localObject1 = ((b)localObject3).aSe;
            ((com.google.android.exoplayer2.c.m)localObject1).a(this.aWH, 1);
            ((com.google.android.exoplayer2.c.m)localObject1).a(paramk, i);
            if (i2 != 0) {
              break label2345;
            }
            i += 1;
            this.aTo = i;
            this.sampleSize += this.aTo;
            if (this.aWV.aXc.aXS == 1)
            {
              this.sampleSize -= 8;
              paramf.ed(8);
            }
            this.aRW = 4;
            this.aTn = 0;
            localObject1 = this.aWV.aXb;
            localObject3 = this.aWV.aXc;
            localObject2 = this.aWV.aSe;
            k = this.aWV.aXe;
            if (((j)localObject3).aSh == 0) {
              break label2592;
            }
            paramk = this.aWF.data;
            paramk[0] = 0;
            paramk[1] = 0;
            paramk[2] = 0;
            int m = ((j)localObject3).aSh;
            n = 4 - ((j)localObject3).aSh;
            label2155:
            if (this.aTo >= this.sampleSize) {
              break label2633;
            }
            if (this.aTn != 0) {
              break label2406;
            }
            paramf.readFully(paramk, n, m + 1);
            this.aWF.setPosition(0);
            this.aTn = (this.aWF.vo() - 1);
            this.aSf.setPosition(0);
            ((com.google.android.exoplayer2.c.m)localObject2).a(this.aSf, 4);
            ((com.google.android.exoplayer2.c.m)localObject2).a(this.aWF, 1);
            if ((this.aWY == null) || (!com.google.android.exoplayer2.i.k.b(((j)localObject3).aNg.aMQ, paramk[4]))) {
              break label2400;
            }
          }
        }
        for (int i2 = 1;; i2 = 0)
        {
          this.aWW = i2;
          this.aTo += 5;
          this.sampleSize += n;
          break label2155;
          paramk = ((b)localObject3).aXc.ew(i);
          break;
          localObject1 = paramk.aXZ;
          this.aWI.n((byte[])localObject1, localObject1.length);
          paramk = this.aWI;
          i = localObject1.length;
          break label1928;
          j = 0;
          break label1960;
          paramk = ((l)localObject2).aYp;
          j = paramk.readUnsignedShort();
          paramk.fu(-2);
          j = j * 6 + 2;
          ((com.google.android.exoplayer2.c.m)localObject1).a(paramk, j);
          i = i + 1 + j;
          break label2014;
          this.aTo = 0;
          break label2032;
        }
        label2406:
        if (this.aWW)
        {
          this.aWG.fs(this.aTn);
          paramf.readFully(this.aWG.data, 0, this.aTn);
          ((com.google.android.exoplayer2.c.m)localObject2).a(this.aWG, this.aTn);
          j = this.aTn;
          int i1 = com.google.android.exoplayer2.i.k.j(this.aWG.data, this.aWG.limit);
          localObject4 = this.aWG;
          if ("video/hevc".equals(((j)localObject3).aNg.aMQ))
          {
            i = 1;
            ((com.google.android.exoplayer2.i.m)localObject4).setPosition(i);
            this.aWG.ft(i1);
            com.google.android.exoplayer2.f.a.g.a(((l)localObject1).ey(k) * 1000L, this.aWG, this.aWY);
          }
        }
        for (i = j;; i = ((com.google.android.exoplayer2.c.m)localObject2).a(paramf, this.aTn, false))
        {
          this.aTo += i;
          this.aTn -= i;
          break;
          i = 0;
          break label2507;
        }
        while (this.aTo < this.sampleSize) {
          this.aTo = (((com.google.android.exoplayer2.c.m)localObject2).a(paramf, this.sampleSize - this.aTo, false) + this.aTo);
        }
        l2 = ((l)localObject1).ey(k) * 1000L;
        l1 = l2;
        if (this.aWJ != null) {
          l1 = this.aWJ.at(l2);
        }
        if (localObject1.aYk[k] != 0)
        {
          i = 1;
          paramk = null;
          if (!((l)localObject1).aYl) {
            break label2908;
          }
          i = 0x40000000 | i;
          if (((l)localObject1).aYn == null) {
            break label2800;
          }
          paramk = ((l)localObject1).aYn;
          paramk = paramk.aTw;
        }
      }
      for (;;)
      {
        ((com.google.android.exoplayer2.c.m)localObject2).a(l1, i, this.sampleSize, 0, paramk);
        for (;;)
        {
          if (!this.aWN.isEmpty())
          {
            paramk = (a)this.aWN.removeFirst();
            this.aWT -= paramk.size;
            this.aWX.a(paramk.aXa + l1, 1, paramk.size, this.aWT, null);
            continue;
            i = 0;
            break;
            label2800:
            paramk = ((j)localObject3).ew(((l)localObject1).aYa.aWx);
            break label2711;
          }
        }
        paramk = this.aWV;
        paramk.aXe += 1;
        paramk = this.aWV;
        paramk.aXf += 1;
        if (this.aWV.aXf == localObject1.aYg[this.aWV.aXg])
        {
          paramk = this.aWV;
          paramk.aXg += 1;
          this.aWV.aXf = 0;
          this.aWV = null;
        }
        this.aRW = 3;
        i = 1;
        break label1779;
        break;
      }
      break label137;
    }
  }
  
  public final void a(com.google.android.exoplayer2.c.g paramg)
  {
    AppMethodBeat.i(92082);
    this.aRV = paramg;
    if (this.aWD != null)
    {
      paramg = new b(paramg.ej(0));
      paramg.a(this.aWD, new c(0, 0, 0, 0));
      this.aWE.put(0, paramg);
      sB();
      this.aRV.st();
    }
    AppMethodBeat.o(92082);
  }
  
  public final boolean a(f paramf)
  {
    AppMethodBeat.i(92081);
    boolean bool = i.g(paramf);
    AppMethodBeat.o(92081);
    return bool;
  }
  
  public final void g(long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(92083);
    int j = this.aWE.size();
    int i = 0;
    while (i < j)
    {
      ((b)this.aWE.valueAt(i)).reset();
      i += 1;
    }
    this.aWN.clear();
    this.aWT = 0;
    this.aWM.clear();
    sA();
    AppMethodBeat.o(92083);
  }
  
  static final class a
  {
    public final long aXa;
    public final int size;
    
    public a(long paramLong, int paramInt)
    {
      this.aXa = paramLong;
      this.size = paramInt;
    }
  }
  
  static final class b
  {
    public final com.google.android.exoplayer2.c.m aSe;
    public final l aXb;
    public j aXc;
    public c aXd;
    public int aXe;
    public int aXf;
    public int aXg;
    
    public b(com.google.android.exoplayer2.c.m paramm)
    {
      AppMethodBeat.i(92076);
      this.aXb = new l();
      this.aSe = paramm;
      AppMethodBeat.o(92076);
    }
    
    public final void a(j paramj, c paramc)
    {
      AppMethodBeat.i(92077);
      this.aXc = ((j)com.google.android.exoplayer2.i.a.checkNotNull(paramj));
      this.aXd = ((c)com.google.android.exoplayer2.i.a.checkNotNull(paramc));
      this.aSe.f(paramj.aNg);
      reset();
      AppMethodBeat.o(92077);
    }
    
    public final void b(DrmInitData paramDrmInitData)
    {
      AppMethodBeat.i(92079);
      Object localObject = this.aXc.ew(this.aXb.aYa.aWx);
      if (localObject != null) {}
      for (localObject = ((k)localObject).aXX;; localObject = null)
      {
        this.aSe.f(this.aXc.aNg.a(paramDrmInitData.br((String)localObject)));
        AppMethodBeat.o(92079);
        return;
      }
    }
    
    public final void reset()
    {
      AppMethodBeat.i(92078);
      this.aXb.reset();
      this.aXe = 0;
      this.aXg = 0;
      this.aXf = 0;
      AppMethodBeat.o(92078);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.google.android.exoplayer2.c.d.e
 * JD-Core Version:    0.7.0.1
 */