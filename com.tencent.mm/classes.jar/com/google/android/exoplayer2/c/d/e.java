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
  public static final com.google.android.exoplayer2.c.h cLL;
  private static final int cQx;
  private static final byte[] cQy;
  private long cHg;
  private com.google.android.exoplayer2.c.g cLR;
  private int cLS;
  private final com.google.android.exoplayer2.i.m cMb;
  private int cNj;
  private int cNk;
  private final SparseArray<b> cQA;
  private final com.google.android.exoplayer2.i.m cQB;
  private final com.google.android.exoplayer2.i.m cQC;
  private final com.google.android.exoplayer2.i.m cQD;
  private final com.google.android.exoplayer2.i.m cQE;
  private final u cQF;
  private final com.google.android.exoplayer2.i.m cQG;
  private final byte[] cQH;
  private final Stack<a.a> cQI;
  private final LinkedList<a> cQJ;
  private int cQK;
  private long cQL;
  private int cQM;
  private com.google.android.exoplayer2.i.m cQN;
  private long cQO;
  private int cQP;
  private long cQQ;
  private b cQR;
  private boolean cQS;
  private com.google.android.exoplayer2.c.m cQT;
  private com.google.android.exoplayer2.c.m[] cQU;
  private boolean cQV;
  private final j cQz;
  private final int flags;
  private int sampleSize;
  
  static
  {
    AppMethodBeat.i(92104);
    cLL = new com.google.android.exoplayer2.c.h()
    {
      public final com.google.android.exoplayer2.c.e[] RV()
      {
        AppMethodBeat.i(92075);
        e locale = new e();
        AppMethodBeat.o(92075);
        return new com.google.android.exoplayer2.c.e[] { locale };
      }
    };
    cQx = x.du("seig");
    cQy = new byte[] { -94, 57, 79, 82, 90, -101, 79, 20, -94, 68, 108, 66, 124, 100, -115, -12 };
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
    AppMethodBeat.i(210308);
    this.flags = (paramInt | 0x0);
    this.cQF = paramu;
    this.cQz = null;
    this.cQG = new com.google.android.exoplayer2.i.m(16);
    this.cMb = new com.google.android.exoplayer2.i.m(com.google.android.exoplayer2.i.k.dkg);
    this.cQB = new com.google.android.exoplayer2.i.m(5);
    this.cQC = new com.google.android.exoplayer2.i.m();
    this.cQD = new com.google.android.exoplayer2.i.m(1);
    this.cQE = new com.google.android.exoplayer2.i.m();
    this.cQH = new byte[16];
    this.cQI = new Stack();
    this.cQJ = new LinkedList();
    this.cQA = new SparseArray();
    this.cHg = -9223372036854775807L;
    this.cQQ = -9223372036854775807L;
    Sd();
    AppMethodBeat.o(210308);
  }
  
  private void Sd()
  {
    this.cLS = 0;
    this.cQM = 0;
  }
  
  private void Se()
  {
    AppMethodBeat.i(92089);
    if (((this.flags & 0x4) != 0) && (this.cQT == null))
    {
      this.cQT = this.cLR.hz(this.cQA.size());
      this.cQT.f(Format.d("application/x-emsg", 9223372036854775807L));
    }
    if (((this.flags & 0x8) != 0) && (this.cQU == null))
    {
      com.google.android.exoplayer2.c.m localm = this.cLR.hz(this.cQA.size() + 1);
      localm.f(Format.cF("application/cea-608"));
      this.cQU = new com.google.android.exoplayer2.c.m[] { localm };
    }
    AppMethodBeat.o(92089);
  }
  
  private static int a(b paramb, int paramInt1, long paramLong, int paramInt2, com.google.android.exoplayer2.i.m paramm, int paramInt3)
  {
    AppMethodBeat.i(92099);
    paramm.setPosition(8);
    int i1 = a.hH(paramm.readInt());
    j localj = paramb.cQY;
    paramb = paramb.cQX;
    c localc = paramb.cRW;
    paramb.cSc[paramInt1] = paramm.UN();
    paramb.cSb[paramInt1] = paramb.cRY;
    Object localObject;
    if ((i1 & 0x1) != 0)
    {
      localObject = paramb.cSb;
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
        i = paramm.UN();
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
      if ((localj.cRP == null) || (localj.cRP.length != 1) || (localj.cRP[0] != 0L)) {
        break label528;
      }
    }
    label258:
    label515:
    label528:
    for (long l1 = x.c(localj.cRQ[0], 1000L, localj.cRM);; l1 = 0L)
    {
      localObject = paramb.cSd;
      int[] arrayOfInt = paramb.cSe;
      long[] arrayOfLong = paramb.cSf;
      boolean[] arrayOfBoolean = paramb.cSg;
      int i4;
      label285:
      int i2;
      label304:
      int i3;
      if ((localj.type == 2) && ((paramInt2 & 0x1) != 0))
      {
        paramInt2 = 1;
        i4 = paramInt3 + paramb.cSc[paramInt1];
        long l2 = localj.cRM;
        if (paramInt1 > 0) {
          paramLong = paramb.cSn;
        }
        if (paramInt3 >= i4) {
          break label515;
        }
        if (k == 0) {
          break label457;
        }
        i2 = paramm.UN();
        if (m == 0) {
          break label467;
        }
        i3 = paramm.UN();
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
        arrayOfLong[paramInt3] = (x.c(paramLong, 1000L, l2) - l1);
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
      paramb.cSn = paramLong;
      AppMethodBeat.o(92099);
      return i4;
    }
  }
  
  private static b a(com.google.android.exoplayer2.i.m paramm, SparseArray<b> paramSparseArray, int paramInt)
  {
    AppMethodBeat.i(92097);
    paramm.setPosition(8);
    int k = a.hH(paramm.readInt());
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
      long l = paramm.UP();
      paramSparseArray.cQX.cRY = l;
      paramSparseArray.cQX.cRZ = l;
    }
    c localc = paramSparseArray.cQZ;
    label125:
    int j;
    if ((k & 0x2) != 0)
    {
      paramInt = paramm.UN() - 1;
      if ((k & 0x8) == 0) {
        break label190;
      }
      i = paramm.UN();
      if ((k & 0x10) == 0) {
        break label199;
      }
      j = paramm.UN();
      label139:
      if ((k & 0x20) == 0) {
        break label209;
      }
    }
    label190:
    label199:
    label209:
    for (k = paramm.UN();; k = localc.flags)
    {
      paramSparseArray.cQX.cRW = new c(paramInt, i, j, k);
      AppMethodBeat.o(92097);
      return paramSparseArray;
      paramInt = localc.cQt;
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
    int j = parama.cPY.size();
    int i = 0;
    while (i < j)
    {
      a.a locala = (a.a)parama.cPY.get(i);
      if (locala.type == a.cOS) {
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
    parama = parama.cPX;
    int i1 = parama.size();
    int j = 0;
    Object localObject;
    int m;
    if (j < i1)
    {
      localObject = (a.b)parama.get(j);
      if (((a.b)localObject).type != a.cOG) {
        break label229;
      }
      localObject = ((a.b)localObject).cPZ;
      ((com.google.android.exoplayer2.i.m)localObject).setPosition(12);
      m = ((com.google.android.exoplayer2.i.m)localObject).UN();
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
      paramb.cRc = 0;
      paramb.cRb = 0;
      paramb.cRa = 0;
      paramb.cQX.ce(k, i);
      j = 0;
      k = 0;
      i = 0;
      while (i < i1)
      {
        localObject = (a.b)parama.get(i);
        int n = j;
        m = k;
        if (((a.b)localObject).type == a.cOG)
        {
          m = a(paramb, j, paramLong, paramInt, ((a.b)localObject).cPZ, k);
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
    int n = paramk.cRU;
    paramm.setPosition(8);
    if ((a.hH(paramm.readInt()) & 0x1) == 1) {
      paramm.iH(8);
    }
    int i = paramm.readUnsignedByte();
    int m = paramm.UN();
    if (m != paraml.sampleCount)
    {
      paramk = new o("Length mismatch: " + m + ", " + paraml.sampleCount);
      AppMethodBeat.o(92095);
      throw paramk;
    }
    int k;
    if (i == 0)
    {
      paramk = paraml.cSi;
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
      Arrays.fill(paraml.cSi, 0, m, bool);
      paraml.hN(k);
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
    paramInt = a.hH(paramm.readInt());
    if ((paramInt & 0x1) != 0)
    {
      paramm = new o("Overriding TrackEncryptionBox parameters is unsupported.");
      AppMethodBeat.o(92101);
      throw paramm;
    }
    if ((paramInt & 0x2) != 0) {}
    for (boolean bool = true;; bool = false)
    {
      paramInt = paramm.UN();
      if (paramInt == paraml.sampleCount) {
        break;
      }
      paramm = new o("Length mismatch: " + paramInt + ", " + paraml.sampleCount);
      AppMethodBeat.o(92101);
      throw paramm;
    }
    Arrays.fill(paraml.cSi, 0, paramInt, bool);
    paraml.hN(paramm.UF());
    paraml.q(paramm);
    AppMethodBeat.o(92101);
  }
  
  private static void a(com.google.android.exoplayer2.i.m paramm, l paraml)
  {
    AppMethodBeat.i(92096);
    paramm.setPosition(8);
    int i = paramm.readInt();
    if ((a.hH(i) & 0x1) == 1) {
      paramm.iH(8);
    }
    int j = paramm.UN();
    if (j != 1)
    {
      paramm = new o("Unexpected saio entry count: ".concat(String.valueOf(j)));
      AppMethodBeat.o(92096);
      throw paramm;
    }
    i = a.hG(i);
    long l2 = paraml.cRZ;
    if (i == 0) {}
    for (long l1 = paramm.FT();; l1 = paramm.UP())
    {
      paraml.cRZ = (l1 + l2);
      AppMethodBeat.o(92096);
      return;
    }
  }
  
  private static void a(com.google.android.exoplayer2.i.m paramm, l paraml, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(92100);
    paramm.setPosition(8);
    paramm.readBytes(paramArrayOfByte, 0, 16);
    if (!Arrays.equals(paramArrayOfByte, cQy))
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
    if (paramm1.readInt() != cQx)
    {
      AppMethodBeat.o(92102);
      return;
    }
    if (a.hG(i) == 1) {
      paramm1.iH(4);
    }
    if (paramm1.readInt() != 1)
    {
      paramm1 = new o("Entry count in sbgp != 1 (unsupported).");
      AppMethodBeat.o(92102);
      throw paramm1;
    }
    paramm2.setPosition(8);
    i = paramm2.readInt();
    if (paramm2.readInt() != cQx)
    {
      AppMethodBeat.o(92102);
      return;
    }
    i = a.hG(i);
    if (i == 1)
    {
      if (paramm2.FT() == 0L)
      {
        paramm1 = new o("Variable length description in sgpd found (unsupported)");
        AppMethodBeat.o(92102);
        throw paramm1;
      }
    }
    else if (i >= 2) {
      paramm2.iH(4);
    }
    if (paramm2.FT() != 1L)
    {
      paramm1 = new o("Entry count in sgpd != 1 (unsupported).");
      AppMethodBeat.o(92102);
      throw paramm1;
    }
    paramm2.iH(1);
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
    paraml.cSh = true;
    paraml.cSj = new k(true, paramString, i, arrayOfByte, (j & 0xF0) >> 4, j & 0xF, paramm1);
    AppMethodBeat.o(92102);
  }
  
  private static DrmInitData ah(List<a.b> paramList)
  {
    AppMethodBeat.i(92103);
    int j = paramList.size();
    int i = 0;
    Object localObject3;
    for (Object localObject2 = null; i < j; localObject2 = localObject3)
    {
      Object localObject4 = (a.b)paramList.get(i);
      localObject3 = localObject2;
      if (((a.b)localObject4).type == a.cPb)
      {
        Object localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = new ArrayList();
        }
        localObject2 = ((a.b)localObject4).cPZ.data;
        localObject4 = h.v((byte[])localObject2);
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
  
  private static void b(a.a parama, SparseArray<b> paramSparseArray, int paramInt, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(92093);
    paramSparseArray = a(parama.hJ(a.cOE).cPZ, paramSparseArray, paramInt);
    if (paramSparseArray == null)
    {
      AppMethodBeat.o(92093);
      return;
    }
    l locall = paramSparseArray.cQX;
    long l2 = locall.cSn;
    paramSparseArray.reset();
    long l1 = l2;
    if (parama.hJ(a.cOD) != null)
    {
      l1 = l2;
      if ((paramInt & 0x2) == 0) {
        l1 = n(parama.hJ(a.cOD).cPZ);
      }
    }
    a(parama, paramSparseArray, l1, paramInt);
    paramSparseArray = paramSparseArray.cQY.hM(locall.cRW.cQt);
    Object localObject1 = parama.hJ(a.cPj);
    if (localObject1 != null) {
      a(paramSparseArray, ((a.b)localObject1).cPZ, locall);
    }
    localObject1 = parama.hJ(a.cPk);
    if (localObject1 != null) {
      a(((a.b)localObject1).cPZ, locall);
    }
    localObject1 = parama.hJ(a.cPo);
    if (localObject1 != null) {
      a(((a.b)localObject1).cPZ, 0, locall);
    }
    localObject1 = parama.hJ(a.cPl);
    Object localObject2 = parama.hJ(a.cPm);
    if ((localObject1 != null) && (localObject2 != null))
    {
      localObject1 = ((a.b)localObject1).cPZ;
      localObject2 = ((a.b)localObject2).cPZ;
      if (paramSparseArray == null) {
        break label308;
      }
    }
    label308:
    for (paramSparseArray = paramSparseArray.cRT;; paramSparseArray = null)
    {
      a((com.google.android.exoplayer2.i.m)localObject1, (com.google.android.exoplayer2.i.m)localObject2, paramSparseArray, locall);
      int i = parama.cPX.size();
      paramInt = 0;
      while (paramInt < i)
      {
        paramSparseArray = (a.b)parama.cPX.get(paramInt);
        if (paramSparseArray.type == a.cPn) {
          a(paramSparseArray.cPZ, locall, paramArrayOfByte);
        }
        paramInt += 1;
      }
    }
    AppMethodBeat.o(92093);
  }
  
  private void c(a.a parama)
  {
    AppMethodBeat.i(92086);
    if (parama.type == a.cOI)
    {
      d(parama);
      AppMethodBeat.o(92086);
      return;
    }
    if (parama.type == a.cOR)
    {
      e(parama);
      AppMethodBeat.o(92086);
      return;
    }
    if (!this.cQI.isEmpty()) {
      ((a.a)this.cQI.peek()).a(parama);
    }
    AppMethodBeat.o(92086);
  }
  
  private void cf(long paramLong)
  {
    AppMethodBeat.i(92085);
    while ((!this.cQI.isEmpty()) && (((a.a)this.cQI.peek()).cPW == paramLong)) {
      c((a.a)this.cQI.pop());
    }
    Sd();
    AppMethodBeat.o(92085);
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
    if (this.cQz == null)
    {
      bool1 = true;
      com.google.android.exoplayer2.i.a.checkState(bool1, "Unexpected moov box.");
      localObject1 = ah(parama.cPX);
      localObject2 = parama.hK(a.cOT);
      localSparseArray = new SparseArray();
      l = -9223372036854775807L;
      m = ((a.a)localObject2).cPX.size();
      i = 0;
      if (i >= m) {
        break label179;
      }
      localObject3 = (a.b)((a.a)localObject2).cPX.get(i);
      if (((a.b)localObject3).type != a.cOF) {
        break label155;
      }
      localObject3 = l(((a.b)localObject3).cPZ);
      localSparseArray.put(((Integer)((Pair)localObject3).first).intValue(), ((Pair)localObject3).second);
    }
    for (;;)
    {
      i += 1;
      break label78;
      bool1 = false;
      break;
      label155:
      if (((a.b)localObject3).type == a.cOU) {
        l = m(((a.b)localObject3).cPZ);
      }
    }
    label179:
    Object localObject2 = new SparseArray();
    int m = parama.cPY.size();
    int i = 0;
    if (i < m)
    {
      localObject3 = (a.a)parama.cPY.get(i);
      a.b localb;
      if (((a.a)localObject3).type == a.cOK)
      {
        localb = parama.hJ(a.cOJ);
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
    if (this.cQA.size() == 0)
    {
      i = j;
      while (i < m)
      {
        parama = (j)((SparseArray)localObject2).valueAt(i);
        localObject1 = new b(this.cLR.hz(i));
        ((b)localObject1).a(parama, (c)localSparseArray.get(parama.id));
        this.cQA.put(parama.id, localObject1);
        this.cHg = Math.max(this.cHg, parama.cHg);
        i += 1;
      }
      Se();
      this.cLR.RW();
      AppMethodBeat.o(92087);
      return;
    }
    if (this.cQA.size() == m) {}
    for (boolean bool1 = bool2;; bool1 = false)
    {
      com.google.android.exoplayer2.i.a.checkState(bool1);
      i = k;
      while (i < m)
      {
        parama = (j)((SparseArray)localObject2).valueAt(i);
        ((b)this.cQA.get(parama.id)).a(parama, (c)localSparseArray.get(parama.id));
        i += 1;
      }
    }
    AppMethodBeat.o(92087);
  }
  
  private void e(a.a parama)
  {
    AppMethodBeat.i(92088);
    a(parama, this.cQA, this.flags, this.cQH);
    parama = ah(parama.cPX);
    if (parama != null)
    {
      int j = this.cQA.size();
      int i = 0;
      while (i < j)
      {
        ((b)this.cQA.valueAt(i)).b(parama);
        i += 1;
      }
    }
    AppMethodBeat.o(92088);
  }
  
  private static Pair<Integer, c> l(com.google.android.exoplayer2.i.m paramm)
  {
    AppMethodBeat.i(92090);
    paramm.setPosition(12);
    paramm = Pair.create(Integer.valueOf(paramm.readInt()), new c(paramm.UN() - 1, paramm.UN(), paramm.UN(), paramm.readInt()));
    AppMethodBeat.o(92090);
    return paramm;
  }
  
  private static long m(com.google.android.exoplayer2.i.m paramm)
  {
    AppMethodBeat.i(92091);
    paramm.setPosition(8);
    if (a.hG(paramm.readInt()) == 0)
    {
      l = paramm.FT();
      AppMethodBeat.o(92091);
      return l;
    }
    long l = paramm.UP();
    AppMethodBeat.o(92091);
    return l;
  }
  
  private static long n(com.google.android.exoplayer2.i.m paramm)
  {
    AppMethodBeat.i(92098);
    paramm.setPosition(8);
    if (a.hG(paramm.readInt()) == 1)
    {
      l = paramm.UP();
      AppMethodBeat.o(92098);
      return l;
    }
    long l = paramm.FT();
    AppMethodBeat.o(92098);
    return l;
  }
  
  public final void C(long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(92083);
    int j = this.cQA.size();
    int i = 0;
    while (i < j)
    {
      ((b)this.cQA.valueAt(i)).reset();
      i += 1;
    }
    this.cQJ.clear();
    this.cQP = 0;
    this.cQI.clear();
    Sd();
    AppMethodBeat.o(92083);
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
      switch (this.cLS)
      {
      default: 
        if (this.cLS != 3) {
          break label2075;
        }
        if (this.cQR != null) {
          break;
        }
        localObject2 = this.cQA;
        paramk = null;
        l1 = 9223372036854775807L;
        j = ((SparseArray)localObject2).size();
        i = 0;
        while (i < j)
        {
          localObject1 = (b)((SparseArray)localObject2).valueAt(i);
          if (((b)localObject1).cRc == ((b)localObject1).cQX.cSa) {
            break label2911;
          }
          l2 = localObject1.cQX.cSb[localObject1.cRc];
          if (l2 >= l1) {
            break label2911;
          }
          l1 = l2;
          paramk = (com.google.android.exoplayer2.c.k)localObject1;
          i += 1;
        }
      case 0: 
        if (this.cQM != 0) {
          break label221;
        }
        if (paramf.a(this.cQG.data, 0, 8, true)) {
          break label185;
        }
        i = 0;
      }
    } while (i != 0);
    AppMethodBeat.o(92084);
    return -1;
    label185:
    this.cQM = 8;
    this.cQG.setPosition(0);
    this.cQL = this.cQG.FT();
    this.cQK = this.cQG.readInt();
    label221:
    if (this.cQL == 1L)
    {
      paramf.readFully(this.cQG.data, 8, 8);
      this.cQM += 8;
      this.cQL = this.cQG.UP();
    }
    while (this.cQL < this.cQM)
    {
      paramf = new o("Atom size less than header length (unsupported).");
      AppMethodBeat.o(92084);
      throw paramf;
      if (this.cQL == 0L)
      {
        l2 = paramf.RU();
        l1 = l2;
        if (l2 == -1L)
        {
          l1 = l2;
          if (!this.cQI.isEmpty()) {
            l1 = ((a.a)this.cQI.peek()).cPW;
          }
        }
        if (l1 != -1L) {
          this.cQL = (l1 - paramf.getPosition() + this.cQM);
        }
      }
    }
    long l1 = paramf.getPosition() - this.cQM;
    if (this.cQK == a.cOR)
    {
      j = this.cQA.size();
      i = 0;
      while (i < j)
      {
        paramk = ((b)this.cQA.valueAt(i)).cQX;
        paramk.cRX = l1;
        paramk.cRZ = l1;
        paramk.cRY = l1;
        i += 1;
      }
    }
    if (this.cQK == a.cOo)
    {
      this.cQR = null;
      this.cQO = (this.cQL + l1);
      if (!this.cQV)
      {
        this.cLR.a(new l.a(this.cHg));
        this.cQV = true;
      }
      this.cLS = 2;
    }
    for (;;)
    {
      i = 1;
      break;
      i = this.cQK;
      if ((i == a.cOI) || (i == a.cOK) || (i == a.cOL) || (i == a.cOM) || (i == a.cON) || (i == a.cOR) || (i == a.cOS) || (i == a.cOT) || (i == a.cOW)) {
        i = 1;
      }
      for (;;)
      {
        if (i != 0)
        {
          l1 = paramf.getPosition() + this.cQL - 8L;
          this.cQI.add(new a.a(this.cQK, l1));
          if (this.cQL == this.cQM)
          {
            cf(l1);
            break;
            i = 0;
            continue;
          }
          Sd();
          break;
        }
      }
      i = this.cQK;
      if ((i == a.cOZ) || (i == a.cOY) || (i == a.cOJ) || (i == a.cOH) || (i == a.cPa) || (i == a.cOD) || (i == a.cOE) || (i == a.cOV) || (i == a.cOF) || (i == a.cOG) || (i == a.cPb) || (i == a.cPj) || (i == a.cPk) || (i == a.cPo) || (i == a.cPn) || (i == a.cPl) || (i == a.cPm) || (i == a.cOX) || (i == a.cOU) || (i == a.cPN)) {
        i = 1;
      }
      for (;;)
      {
        if (i != 0) {
          if (this.cQM != 8)
          {
            paramf = new o("Leaf atom defines extended atom size (unsupported).");
            AppMethodBeat.o(92084);
            throw paramf;
            i = 0;
          }
          else
          {
            if (this.cQL > 2147483647L)
            {
              paramf = new o("Leaf atom with length > 2147483647 (unsupported).");
              AppMethodBeat.o(92084);
              throw paramf;
            }
            this.cQN = new com.google.android.exoplayer2.i.m((int)this.cQL);
            System.arraycopy(this.cQG.data, 0, this.cQN.data, 0, 8);
            this.cLS = 1;
            break;
          }
        }
      }
      if (this.cQL > 2147483647L)
      {
        paramf = new o("Skipping atom with length > 2147483647 (unsupported).");
        AppMethodBeat.o(92084);
        throw paramf;
      }
      this.cQN = null;
      this.cLS = 1;
    }
    int i = (int)this.cQL - this.cQM;
    if (this.cQN != null)
    {
      paramf.readFully(this.cQN.data, 8, i);
      paramk = new a.b(this.cQK, this.cQN);
      l2 = paramf.getPosition();
      if (!this.cQI.isEmpty()) {
        ((a.a)this.cQI.peek()).a(paramk);
      }
    }
    Object localObject3;
    Object localObject4;
    int k;
    for (;;)
    {
      cf(paramf.getPosition());
      break;
      if (paramk.type == a.cOH)
      {
        paramk = paramk.cPZ;
        paramk.setPosition(8);
        i = a.hG(paramk.readInt());
        paramk.iH(4);
        long l5 = paramk.FT();
        long l4;
        long l3;
        if (i == 0)
        {
          l1 = paramk.FT();
          l2 += paramk.FT();
          l4 = x.c(l1, 1000000L, l5);
          paramk.iH(2);
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
            l1 = paramk.UP();
            l2 += paramk.UP();
            break;
          }
          long l6 = paramk.FT();
          localObject1[i] = (k & 0x7FFFFFFF);
          localObject2[i] = l2;
          localObject4[i] = l3;
          l1 += l6;
          l3 = x.c(l1, 1000000L, l5);
          localObject3[i] = (l3 - localObject4[i]);
          paramk.iH(4);
          l2 += localObject1[i];
          i += 1;
        }
        label1333:
        paramk = Pair.create(Long.valueOf(l4), new com.google.android.exoplayer2.c.a((int[])localObject1, (long[])localObject2, (long[])localObject3, (long[])localObject4));
        this.cQQ = ((Long)paramk.first).longValue();
        this.cLR.a((com.google.android.exoplayer2.c.l)paramk.second);
        this.cQV = true;
      }
      else if (paramk.type == a.cPN)
      {
        paramk = paramk.cPZ;
        if (this.cQT != null)
        {
          paramk.setPosition(12);
          paramk.UQ();
          paramk.UQ();
          l1 = paramk.FT();
          l1 = x.c(paramk.FT(), 1000000L, l1);
          paramk.setPosition(12);
          i = paramk.UF();
          this.cQT.a(paramk, i);
          if (this.cQQ != -9223372036854775807L)
          {
            this.cQT.a(l1 + this.cQQ, 1, i, 0, null);
          }
          else
          {
            this.cQJ.addLast(new a(l1, i));
            this.cQP += i;
            continue;
            paramf.eP(i);
          }
        }
      }
    }
    paramk = null;
    l1 = 9223372036854775807L;
    int j = this.cQA.size();
    i = 0;
    label1567:
    if (i < j)
    {
      localObject1 = ((b)this.cQA.valueAt(i)).cQX;
      if ((!((l)localObject1).cSm) || (((l)localObject1).cRZ >= l1)) {
        break label2914;
      }
      l1 = ((l)localObject1).cRZ;
      paramk = (b)this.cQA.valueAt(i);
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
        this.cLS = 3;
        break;
      }
      i = (int)(l1 - paramf.getPosition());
      if (i < 0)
      {
        paramf = new o("Offset to encryption data was negative.");
        AppMethodBeat.o(92084);
        throw paramf;
      }
      paramf.eP(i);
      paramk = paramk.cQX;
      paramf.readFully(paramk.cSl.data, 0, paramk.cSk);
      paramk.cSl.setPosition(0);
      paramk.cSm = false;
      break;
      if (paramk == null)
      {
        i = (int)(this.cQO - paramf.getPosition());
        if (i < 0)
        {
          paramf = new o("Offset to end of mdat was negative.");
          AppMethodBeat.o(92084);
          throw paramf;
        }
        paramf.eP(i);
        Sd();
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
        j = (int)(paramk.cQX.cSb[paramk.cRc] - paramf.getPosition());
        i = j;
        if (j < 0) {
          i = 0;
        }
        paramf.eP(i);
        this.cQR = paramk;
        this.sampleSize = this.cQR.cQX.cSd[this.cQR.cRa];
        label2032:
        int n;
        if (this.cQR.cQX.cSh)
        {
          localObject3 = this.cQR;
          localObject2 = ((b)localObject3).cQX;
          i = ((l)localObject2).cRW.cQt;
          if (((l)localObject2).cSj != null)
          {
            paramk = ((l)localObject2).cSj;
            if (paramk.cRU == 0) {
              break label2309;
            }
            localObject1 = ((l)localObject2).cSl;
            i = paramk.cRU;
            paramk = (com.google.android.exoplayer2.c.k)localObject1;
            i2 = localObject2.cSi[localObject3.cRa];
            localObject1 = this.cQD.data;
            if (i2 == 0) {
              break label2339;
            }
            j = 128;
            localObject1[0] = ((byte)(j | i));
            this.cQD.setPosition(0);
            localObject1 = ((b)localObject3).cMa;
            ((com.google.android.exoplayer2.c.m)localObject1).a(this.cQD, 1);
            ((com.google.android.exoplayer2.c.m)localObject1).a(paramk, i);
            if (i2 != 0) {
              break label2345;
            }
            i += 1;
            this.cNk = i;
            this.sampleSize += this.cNk;
            if (this.cQR.cQY.cRO == 1)
            {
              this.sampleSize -= 8;
              paramf.eP(8);
            }
            this.cLS = 4;
            this.cNj = 0;
            localObject1 = this.cQR.cQX;
            localObject3 = this.cQR.cQY;
            localObject2 = this.cQR.cMa;
            k = this.cQR.cRa;
            if (((j)localObject3).cMd == 0) {
              break label2592;
            }
            paramk = this.cQB.data;
            paramk[0] = 0;
            paramk[1] = 0;
            paramk[2] = 0;
            int m = ((j)localObject3).cMd;
            n = 4 - ((j)localObject3).cMd;
            label2155:
            if (this.cNk >= this.sampleSize) {
              break label2633;
            }
            if (this.cNj != 0) {
              break label2406;
            }
            paramf.readFully(paramk, n, m + 1);
            this.cQB.setPosition(0);
            this.cNj = (this.cQB.UN() - 1);
            this.cMb.setPosition(0);
            ((com.google.android.exoplayer2.c.m)localObject2).a(this.cMb, 4);
            ((com.google.android.exoplayer2.c.m)localObject2).a(this.cQB, 1);
            if ((this.cQU == null) || (!com.google.android.exoplayer2.i.k.b(((j)localObject3).cHc.cGN, paramk[4]))) {
              break label2400;
            }
          }
        }
        for (int i2 = 1;; i2 = 0)
        {
          this.cQS = i2;
          this.cNk += 5;
          this.sampleSize += n;
          break label2155;
          paramk = ((b)localObject3).cQY.hM(i);
          break;
          localObject1 = paramk.cRV;
          this.cQE.n((byte[])localObject1, localObject1.length);
          paramk = this.cQE;
          i = localObject1.length;
          break label1928;
          j = 0;
          break label1960;
          paramk = ((l)localObject2).cSl;
          j = paramk.readUnsignedShort();
          paramk.iH(-2);
          j = j * 6 + 2;
          ((com.google.android.exoplayer2.c.m)localObject1).a(paramk, j);
          i = i + 1 + j;
          break label2014;
          this.cNk = 0;
          break label2032;
        }
        label2406:
        if (this.cQS)
        {
          this.cQC.iF(this.cNj);
          paramf.readFully(this.cQC.data, 0, this.cNj);
          ((com.google.android.exoplayer2.c.m)localObject2).a(this.cQC, this.cNj);
          j = this.cNj;
          int i1 = com.google.android.exoplayer2.i.k.j(this.cQC.data, this.cQC.limit);
          localObject4 = this.cQC;
          if ("video/hevc".equals(((j)localObject3).cHc.cGN))
          {
            i = 1;
            ((com.google.android.exoplayer2.i.m)localObject4).setPosition(i);
            this.cQC.iG(i1);
            com.google.android.exoplayer2.f.a.g.a(((l)localObject1).hO(k) * 1000L, this.cQC, this.cQU);
          }
        }
        for (i = j;; i = ((com.google.android.exoplayer2.c.m)localObject2).a(paramf, this.cNj, false))
        {
          this.cNk += i;
          this.cNj -= i;
          break;
          i = 0;
          break label2507;
        }
        while (this.cNk < this.sampleSize) {
          this.cNk = (((com.google.android.exoplayer2.c.m)localObject2).a(paramf, this.sampleSize - this.cNk, false) + this.cNk);
        }
        l2 = ((l)localObject1).hO(k) * 1000L;
        l1 = l2;
        if (this.cQF != null) {
          l1 = this.cQF.cH(l2);
        }
        if (localObject1.cSg[k] != 0)
        {
          i = 1;
          paramk = null;
          if (!((l)localObject1).cSh) {
            break label2908;
          }
          i = 0x40000000 | i;
          if (((l)localObject1).cSj == null) {
            break label2800;
          }
          paramk = ((l)localObject1).cSj;
          paramk = paramk.cNs;
        }
      }
      for (;;)
      {
        ((com.google.android.exoplayer2.c.m)localObject2).a(l1, i, this.sampleSize, 0, paramk);
        for (;;)
        {
          if (!this.cQJ.isEmpty())
          {
            paramk = (a)this.cQJ.removeFirst();
            this.cQP -= paramk.size;
            this.cQT.a(paramk.cQW + l1, 1, paramk.size, this.cQP, null);
            continue;
            i = 0;
            break;
            label2800:
            paramk = ((j)localObject3).hM(((l)localObject1).cRW.cQt);
            break label2711;
          }
        }
        paramk = this.cQR;
        paramk.cRa += 1;
        paramk = this.cQR;
        paramk.cRb += 1;
        if (this.cQR.cRb == localObject1.cSc[this.cQR.cRc])
        {
          paramk = this.cQR;
          paramk.cRc += 1;
          this.cQR.cRb = 0;
          this.cQR = null;
        }
        this.cLS = 3;
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
    this.cLR = paramg;
    if (this.cQz != null)
    {
      paramg = new b(paramg.hz(0));
      paramg.a(this.cQz, new c(0, 0, 0, 0));
      this.cQA.put(0, paramg);
      Se();
      this.cLR.RW();
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
  
  static final class a
  {
    public final long cQW;
    public final int size;
    
    public a(long paramLong, int paramInt)
    {
      this.cQW = paramLong;
      this.size = paramInt;
    }
  }
  
  static final class b
  {
    public final com.google.android.exoplayer2.c.m cMa;
    public final l cQX;
    public j cQY;
    public c cQZ;
    public int cRa;
    public int cRb;
    public int cRc;
    
    public b(com.google.android.exoplayer2.c.m paramm)
    {
      AppMethodBeat.i(92076);
      this.cQX = new l();
      this.cMa = paramm;
      AppMethodBeat.o(92076);
    }
    
    public final void a(j paramj, c paramc)
    {
      AppMethodBeat.i(92077);
      this.cQY = ((j)com.google.android.exoplayer2.i.a.checkNotNull(paramj));
      this.cQZ = ((c)com.google.android.exoplayer2.i.a.checkNotNull(paramc));
      this.cMa.f(paramj.cHc);
      reset();
      AppMethodBeat.o(92077);
    }
    
    public final void b(DrmInitData paramDrmInitData)
    {
      AppMethodBeat.i(92079);
      Object localObject = this.cQY.hM(this.cQX.cRW.cQt);
      if (localObject != null) {}
      for (localObject = ((k)localObject).cRT;; localObject = null)
      {
        this.cMa.f(this.cQY.cHc.a(paramDrmInitData.cJ((String)localObject)));
        AppMethodBeat.o(92079);
        return;
      }
    }
    
    public final void reset()
    {
      AppMethodBeat.i(92078);
      this.cQX.reset();
      this.cRa = 0;
      this.cRc = 0;
      this.cRb = 0;
      AppMethodBeat.o(92078);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.google.android.exoplayer2.c.d.e
 * JD-Core Version:    0.7.0.1
 */