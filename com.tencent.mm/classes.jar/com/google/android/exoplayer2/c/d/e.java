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
  public static final com.google.android.exoplayer2.c.h aBP;
  private static final int aGF;
  private static final byte[] aGG;
  private com.google.android.exoplayer2.c.g aBV;
  private int aBW;
  private final com.google.android.exoplayer2.i.m aCf;
  private int aDn;
  private int aDo;
  private final j aGH;
  private final SparseArray<e.b> aGI;
  private final com.google.android.exoplayer2.i.m aGJ;
  private final com.google.android.exoplayer2.i.m aGK;
  private final com.google.android.exoplayer2.i.m aGL;
  private final com.google.android.exoplayer2.i.m aGM;
  private final u aGN;
  private final com.google.android.exoplayer2.i.m aGO;
  private final byte[] aGP;
  private final Stack<a.a> aGQ;
  private final LinkedList<e.a> aGR;
  private int aGS;
  private long aGT;
  private int aGU;
  private com.google.android.exoplayer2.i.m aGV;
  private long aGW;
  private int aGX;
  private long aGY;
  private e.b aGZ;
  private boolean aHa;
  private com.google.android.exoplayer2.c.m aHb;
  private com.google.android.exoplayer2.c.m[] aHc;
  private boolean aHd;
  private long axh;
  private final int flags;
  private int sampleSize;
  
  static
  {
    AppMethodBeat.i(94989);
    aBP = new e.1();
    aGF = x.aS("seig");
    aGG = new byte[] { -94, 57, 79, 82, 90, -101, 79, 20, -94, 68, 108, 66, 124, 100, -115, -12 };
    AppMethodBeat.o(94989);
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
    AppMethodBeat.i(94965);
    this.flags = (paramInt | 0x0);
    this.aGN = paramu;
    this.aGH = null;
    this.aGO = new com.google.android.exoplayer2.i.m(16);
    this.aCf = new com.google.android.exoplayer2.i.m(com.google.android.exoplayer2.i.k.baF);
    this.aGJ = new com.google.android.exoplayer2.i.m(5);
    this.aGK = new com.google.android.exoplayer2.i.m();
    this.aGL = new com.google.android.exoplayer2.i.m(1);
    this.aGM = new com.google.android.exoplayer2.i.m();
    this.aGP = new byte[16];
    this.aGQ = new Stack();
    this.aGR = new LinkedList();
    this.aGI = new SparseArray();
    this.axh = -9223372036854775807L;
    this.aGY = -9223372036854775807L;
    og();
    AppMethodBeat.o(94965);
  }
  
  private void H(long paramLong)
  {
    AppMethodBeat.i(94970);
    while ((!this.aGQ.isEmpty()) && (((a.a)this.aGQ.peek()).aGe == paramLong)) {
      c((a.a)this.aGQ.pop());
    }
    og();
    AppMethodBeat.o(94970);
  }
  
  private static int a(e.b paramb, int paramInt1, long paramLong, int paramInt2, com.google.android.exoplayer2.i.m paramm, int paramInt3)
  {
    AppMethodBeat.i(94984);
    paramm.setPosition(8);
    int i1 = a.du(paramm.readInt());
    j localj = paramb.aHg;
    paramb = paramb.aHf;
    c localc = paramb.aIe;
    paramb.aIk[paramInt1] = paramm.qT();
    paramb.aIj[paramInt1] = paramb.aIg;
    Object localObject;
    if ((i1 & 0x1) != 0)
    {
      localObject = paramb.aIj;
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
        i = paramm.qT();
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
      if ((localj.aHX == null) || (localj.aHX.length != 1) || (localj.aHX[0] != 0L)) {
        break label528;
      }
    }
    label258:
    label515:
    label528:
    for (long l1 = x.b(localj.aHY[0], 1000L, localj.aHU);; l1 = 0L)
    {
      localObject = paramb.aIl;
      int[] arrayOfInt = paramb.aIm;
      long[] arrayOfLong = paramb.aIn;
      boolean[] arrayOfBoolean = paramb.aIo;
      int i4;
      label285:
      int i2;
      label304:
      int i3;
      if ((localj.type == 2) && ((paramInt2 & 0x1) != 0))
      {
        paramInt2 = 1;
        i4 = paramInt3 + paramb.aIk[paramInt1];
        long l2 = localj.aHU;
        if (paramInt1 > 0) {
          paramLong = paramb.aIv;
        }
        if (paramInt3 >= i4) {
          break label515;
        }
        if (k == 0) {
          break label457;
        }
        i2 = paramm.qT();
        if (m == 0) {
          break label467;
        }
        i3 = paramm.qT();
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
      paramb.aIv = paramLong;
      AppMethodBeat.o(94984);
      return i4;
    }
  }
  
  private static e.b a(com.google.android.exoplayer2.i.m paramm, SparseArray<e.b> paramSparseArray, int paramInt)
  {
    AppMethodBeat.i(94982);
    paramm.setPosition(8);
    int k = a.du(paramm.readInt());
    int i = paramm.readInt();
    if ((paramInt & 0x10) == 0) {}
    for (paramInt = i;; paramInt = 0)
    {
      paramSparseArray = (e.b)paramSparseArray.get(paramInt);
      if (paramSparseArray != null) {
        break;
      }
      AppMethodBeat.o(94982);
      return null;
    }
    if ((k & 0x1) != 0)
    {
      long l = paramm.qV();
      paramSparseArray.aHf.aIg = l;
      paramSparseArray.aHf.aIh = l;
    }
    c localc = paramSparseArray.aHh;
    label125:
    int j;
    if ((k & 0x2) != 0)
    {
      paramInt = paramm.qT() - 1;
      if ((k & 0x8) == 0) {
        break label190;
      }
      i = paramm.qT();
      if ((k & 0x10) == 0) {
        break label199;
      }
      j = paramm.qT();
      label139:
      if ((k & 0x20) == 0) {
        break label209;
      }
    }
    label190:
    label199:
    label209:
    for (k = paramm.qT();; k = localc.flags)
    {
      paramSparseArray.aHf.aIe = new c(paramInt, i, j, k);
      AppMethodBeat.o(94982);
      return paramSparseArray;
      paramInt = localc.aGB;
      break;
      i = localc.duration;
      break label125;
      j = localc.size;
      break label139;
    }
  }
  
  private static void a(a.a parama, SparseArray<e.b> paramSparseArray, int paramInt, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(94977);
    int j = parama.aGg.size();
    int i = 0;
    while (i < j)
    {
      a.a locala = (a.a)parama.aGg.get(i);
      if (locala.type == a.aFa) {
        b(locala, paramSparseArray, paramInt, paramArrayOfByte);
      }
      i += 1;
    }
    AppMethodBeat.o(94977);
  }
  
  private static void a(a.a parama, e.b paramb, long paramLong, int paramInt)
  {
    AppMethodBeat.i(94979);
    int k = 0;
    int i = 0;
    parama = parama.aGf;
    int i1 = parama.size();
    int j = 0;
    Object localObject;
    int m;
    if (j < i1)
    {
      localObject = (a.b)parama.get(j);
      if (((a.b)localObject).type != a.aEO) {
        break label229;
      }
      localObject = ((a.b)localObject).aGh;
      ((com.google.android.exoplayer2.i.m)localObject).setPosition(12);
      m = ((com.google.android.exoplayer2.i.m)localObject).qT();
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
      paramb.aHk = 0;
      paramb.aHj = 0;
      paramb.aHi = 0;
      paramb.aHf.aW(k, i);
      j = 0;
      k = 0;
      i = 0;
      while (i < i1)
      {
        localObject = (a.b)parama.get(i);
        int n = j;
        m = k;
        if (((a.b)localObject).type == a.aEO)
        {
          m = a(paramb, j, paramLong, paramInt, ((a.b)localObject).aGh, k);
          n = j + 1;
        }
        i += 1;
        j = n;
        k = m;
      }
      AppMethodBeat.o(94979);
      return;
    }
  }
  
  private static void a(k paramk, com.google.android.exoplayer2.i.m paramm, l paraml)
  {
    boolean bool = true;
    AppMethodBeat.i(94980);
    int n = paramk.aIc;
    paramm.setPosition(8);
    if ((a.du(paramm.readInt()) & 0x1) == 1) {
      paramm.en(8);
    }
    int i = paramm.readUnsignedByte();
    int m = paramm.qT();
    if (m != paraml.sampleCount)
    {
      paramk = new o("Length mismatch: " + m + ", " + paraml.sampleCount);
      AppMethodBeat.o(94980);
      throw paramk;
    }
    int k;
    if (i == 0)
    {
      paramk = paraml.aIq;
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
      Arrays.fill(paraml.aIq, 0, m, bool);
      paraml.dA(k);
      AppMethodBeat.o(94980);
      return;
      label212:
      bool = false;
    }
  }
  
  private static void a(com.google.android.exoplayer2.i.m paramm, int paramInt, l paraml)
  {
    AppMethodBeat.i(94986);
    paramm.setPosition(paramInt + 8);
    paramInt = a.du(paramm.readInt());
    if ((paramInt & 0x1) != 0)
    {
      paramm = new o("Overriding TrackEncryptionBox parameters is unsupported.");
      AppMethodBeat.o(94986);
      throw paramm;
    }
    if ((paramInt & 0x2) != 0) {}
    for (boolean bool = true;; bool = false)
    {
      paramInt = paramm.qT();
      if (paramInt == paraml.sampleCount) {
        break;
      }
      paramm = new o("Length mismatch: " + paramInt + ", " + paraml.sampleCount);
      AppMethodBeat.o(94986);
      throw paramm;
    }
    Arrays.fill(paraml.aIq, 0, paramInt, bool);
    paraml.dA(paramm.qM());
    paraml.q(paramm);
    AppMethodBeat.o(94986);
  }
  
  private static void a(com.google.android.exoplayer2.i.m paramm, l paraml)
  {
    AppMethodBeat.i(94981);
    paramm.setPosition(8);
    int i = paramm.readInt();
    if ((a.du(i) & 0x1) == 1) {
      paramm.en(8);
    }
    int j = paramm.qT();
    if (j != 1)
    {
      paramm = new o("Unexpected saio entry count: ".concat(String.valueOf(j)));
      AppMethodBeat.o(94981);
      throw paramm;
    }
    i = a.dt(i);
    long l2 = paraml.aIh;
    if (i == 0) {}
    for (long l1 = paramm.cc();; l1 = paramm.qV())
    {
      paraml.aIh = (l1 + l2);
      AppMethodBeat.o(94981);
      return;
    }
  }
  
  private static void a(com.google.android.exoplayer2.i.m paramm, l paraml, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(94985);
    paramm.setPosition(8);
    paramm.readBytes(paramArrayOfByte, 0, 16);
    if (!Arrays.equals(paramArrayOfByte, aGG))
    {
      AppMethodBeat.o(94985);
      return;
    }
    a(paramm, 16, paraml);
    AppMethodBeat.o(94985);
  }
  
  private static void a(com.google.android.exoplayer2.i.m paramm1, com.google.android.exoplayer2.i.m paramm2, String paramString, l paraml)
  {
    AppMethodBeat.i(94987);
    paramm1.setPosition(8);
    int i = paramm1.readInt();
    if (paramm1.readInt() != aGF)
    {
      AppMethodBeat.o(94987);
      return;
    }
    if (a.dt(i) == 1) {
      paramm1.en(4);
    }
    if (paramm1.readInt() != 1)
    {
      paramm1 = new o("Entry count in sbgp != 1 (unsupported).");
      AppMethodBeat.o(94987);
      throw paramm1;
    }
    paramm2.setPosition(8);
    i = paramm2.readInt();
    if (paramm2.readInt() != aGF)
    {
      AppMethodBeat.o(94987);
      return;
    }
    i = a.dt(i);
    if (i == 1)
    {
      if (paramm2.cc() == 0L)
      {
        paramm1 = new o("Variable length description in sgpd found (unsupported)");
        AppMethodBeat.o(94987);
        throw paramm1;
      }
    }
    else if (i >= 2) {
      paramm2.en(4);
    }
    if (paramm2.cc() != 1L)
    {
      paramm1 = new o("Entry count in sgpd != 1 (unsupported).");
      AppMethodBeat.o(94987);
      throw paramm1;
    }
    paramm2.en(1);
    int j = paramm2.readUnsignedByte();
    if (paramm2.readUnsignedByte() == 1) {}
    for (i = 1; i == 0; i = 0)
    {
      AppMethodBeat.o(94987);
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
    paraml.aIp = true;
    paraml.aIr = new k(true, paramString, i, arrayOfByte, (j & 0xF0) >> 4, j & 0xF, paramm1);
    AppMethodBeat.o(94987);
  }
  
  private static void b(a.a parama, SparseArray<e.b> paramSparseArray, int paramInt, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(94978);
    paramSparseArray = a(parama.dw(a.aEM).aGh, paramSparseArray, paramInt);
    if (paramSparseArray == null)
    {
      AppMethodBeat.o(94978);
      return;
    }
    l locall = paramSparseArray.aHf;
    long l2 = locall.aIv;
    paramSparseArray.reset();
    long l1 = l2;
    if (parama.dw(a.aEL) != null)
    {
      l1 = l2;
      if ((paramInt & 0x2) == 0) {
        l1 = n(parama.dw(a.aEL).aGh);
      }
    }
    a(parama, paramSparseArray, l1, paramInt);
    paramSparseArray = paramSparseArray.aHg.dz(locall.aIe.aGB);
    Object localObject1 = parama.dw(a.aFr);
    if (localObject1 != null) {
      a(paramSparseArray, ((a.b)localObject1).aGh, locall);
    }
    localObject1 = parama.dw(a.aFs);
    if (localObject1 != null) {
      a(((a.b)localObject1).aGh, locall);
    }
    localObject1 = parama.dw(a.aFw);
    if (localObject1 != null) {
      a(((a.b)localObject1).aGh, 0, locall);
    }
    localObject1 = parama.dw(a.aFt);
    Object localObject2 = parama.dw(a.aFu);
    if ((localObject1 != null) && (localObject2 != null))
    {
      localObject1 = ((a.b)localObject1).aGh;
      localObject2 = ((a.b)localObject2).aGh;
      if (paramSparseArray == null) {
        break label308;
      }
    }
    label308:
    for (paramSparseArray = paramSparseArray.aIb;; paramSparseArray = null)
    {
      a((com.google.android.exoplayer2.i.m)localObject1, (com.google.android.exoplayer2.i.m)localObject2, paramSparseArray, locall);
      int i = parama.aGf.size();
      paramInt = 0;
      while (paramInt < i)
      {
        paramSparseArray = (a.b)parama.aGf.get(paramInt);
        if (paramSparseArray.type == a.aFv) {
          a(paramSparseArray.aGh, locall, paramArrayOfByte);
        }
        paramInt += 1;
      }
    }
    AppMethodBeat.o(94978);
  }
  
  private void c(a.a parama)
  {
    AppMethodBeat.i(94971);
    if (parama.type == a.aEQ)
    {
      d(parama);
      AppMethodBeat.o(94971);
      return;
    }
    if (parama.type == a.aEZ)
    {
      e(parama);
      AppMethodBeat.o(94971);
      return;
    }
    if (!this.aGQ.isEmpty()) {
      ((a.a)this.aGQ.peek()).a(parama);
    }
    AppMethodBeat.o(94971);
  }
  
  private void d(a.a parama)
  {
    boolean bool2 = true;
    int k = 0;
    int j = 0;
    AppMethodBeat.i(94972);
    Object localObject1;
    SparseArray localSparseArray;
    long l;
    label78:
    Object localObject3;
    if (this.aGH == null)
    {
      bool1 = true;
      com.google.android.exoplayer2.i.a.checkState(bool1, "Unexpected moov box.");
      localObject1 = s(parama.aGf);
      localObject2 = parama.dx(a.aFb);
      localSparseArray = new SparseArray();
      l = -9223372036854775807L;
      m = ((a.a)localObject2).aGf.size();
      i = 0;
      if (i >= m) {
        break label179;
      }
      localObject3 = (a.b)((a.a)localObject2).aGf.get(i);
      if (((a.b)localObject3).type != a.aEN) {
        break label155;
      }
      localObject3 = l(((a.b)localObject3).aGh);
      localSparseArray.put(((Integer)((Pair)localObject3).first).intValue(), ((Pair)localObject3).second);
    }
    for (;;)
    {
      i += 1;
      break label78;
      bool1 = false;
      break;
      label155:
      if (((a.b)localObject3).type == a.aFc) {
        l = m(((a.b)localObject3).aGh);
      }
    }
    label179:
    Object localObject2 = new SparseArray();
    int m = parama.aGg.size();
    int i = 0;
    if (i < m)
    {
      localObject3 = (a.a)parama.aGg.get(i);
      a.b localb;
      if (((a.a)localObject3).type == a.aES)
      {
        localb = parama.dw(a.aER);
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
    if (this.aGI.size() == 0)
    {
      i = j;
      while (i < m)
      {
        parama = (j)((SparseArray)localObject2).valueAt(i);
        localObject1 = new e.b(this.aBV.dm(i));
        ((e.b)localObject1).a(parama, (c)localSparseArray.get(parama.id));
        this.aGI.put(parama.id, localObject1);
        this.axh = Math.max(this.axh, parama.axh);
        i += 1;
      }
      oh();
      this.aBV.nZ();
      AppMethodBeat.o(94972);
      return;
    }
    if (this.aGI.size() == m) {}
    for (boolean bool1 = bool2;; bool1 = false)
    {
      com.google.android.exoplayer2.i.a.checkState(bool1);
      i = k;
      while (i < m)
      {
        parama = (j)((SparseArray)localObject2).valueAt(i);
        ((e.b)this.aGI.get(parama.id)).a(parama, (c)localSparseArray.get(parama.id));
        i += 1;
      }
    }
    AppMethodBeat.o(94972);
  }
  
  private void e(a.a parama)
  {
    AppMethodBeat.i(94973);
    a(parama, this.aGI, this.flags, this.aGP);
    parama = s(parama.aGf);
    if (parama != null)
    {
      int j = this.aGI.size();
      int i = 0;
      while (i < j)
      {
        ((e.b)this.aGI.valueAt(i)).b(parama);
        i += 1;
      }
    }
    AppMethodBeat.o(94973);
  }
  
  private static Pair<Integer, c> l(com.google.android.exoplayer2.i.m paramm)
  {
    AppMethodBeat.i(94975);
    paramm.setPosition(12);
    paramm = Pair.create(Integer.valueOf(paramm.readInt()), new c(paramm.qT() - 1, paramm.qT(), paramm.qT(), paramm.readInt()));
    AppMethodBeat.o(94975);
    return paramm;
  }
  
  private static long m(com.google.android.exoplayer2.i.m paramm)
  {
    AppMethodBeat.i(94976);
    paramm.setPosition(8);
    if (a.dt(paramm.readInt()) == 0)
    {
      l = paramm.cc();
      AppMethodBeat.o(94976);
      return l;
    }
    long l = paramm.qV();
    AppMethodBeat.o(94976);
    return l;
  }
  
  private static long n(com.google.android.exoplayer2.i.m paramm)
  {
    AppMethodBeat.i(94983);
    paramm.setPosition(8);
    if (a.dt(paramm.readInt()) == 1)
    {
      l = paramm.qV();
      AppMethodBeat.o(94983);
      return l;
    }
    long l = paramm.cc();
    AppMethodBeat.o(94983);
    return l;
  }
  
  private void og()
  {
    this.aBW = 0;
    this.aGU = 0;
  }
  
  private void oh()
  {
    AppMethodBeat.i(94974);
    if (((this.flags & 0x4) != 0) && (this.aHb == null))
    {
      this.aHb = this.aBV.dm(this.aGI.size());
      this.aHb.f(Format.c("application/x-emsg", 9223372036854775807L));
    }
    if (((this.flags & 0x8) != 0) && (this.aHc == null))
    {
      com.google.android.exoplayer2.c.m localm = this.aBV.dm(this.aGI.size() + 1);
      localm.f(Format.al("application/cea-608"));
      this.aHc = new com.google.android.exoplayer2.c.m[] { localm };
    }
    AppMethodBeat.o(94974);
  }
  
  private static DrmInitData s(List<a.b> paramList)
  {
    AppMethodBeat.i(94988);
    int j = paramList.size();
    int i = 0;
    Object localObject3;
    for (Object localObject2 = null; i < j; localObject2 = localObject3)
    {
      Object localObject4 = (a.b)paramList.get(i);
      localObject3 = localObject2;
      if (((a.b)localObject4).type == a.aFj)
      {
        Object localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = new ArrayList();
        }
        localObject2 = ((a.b)localObject4).aGh.data;
        localObject4 = h.m((byte[])localObject2);
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
      AppMethodBeat.o(94988);
      return null;
    }
    paramList = new DrmInitData((List)localObject2);
    AppMethodBeat.o(94988);
    return paramList;
  }
  
  public final int a(f paramf, com.google.android.exoplayer2.c.k paramk)
  {
    AppMethodBeat.i(94969);
    Object localObject2;
    Object localObject1;
    long l2;
    label137:
    do
    {
      switch (this.aBW)
      {
      default: 
        if (this.aBW != 3) {
          break label2075;
        }
        if (this.aGZ != null) {
          break;
        }
        localObject2 = this.aGI;
        paramk = null;
        l1 = 9223372036854775807L;
        j = ((SparseArray)localObject2).size();
        i = 0;
        while (i < j)
        {
          localObject1 = (e.b)((SparseArray)localObject2).valueAt(i);
          if (((e.b)localObject1).aHk == ((e.b)localObject1).aHf.aIi) {
            break label2911;
          }
          l2 = localObject1.aHf.aIj[localObject1.aHk];
          if (l2 >= l1) {
            break label2911;
          }
          l1 = l2;
          paramk = (com.google.android.exoplayer2.c.k)localObject1;
          i += 1;
        }
      case 0: 
        if (this.aGU != 0) {
          break label221;
        }
        if (paramf.a(this.aGO.data, 0, 8, true)) {
          break label185;
        }
        i = 0;
      }
    } while (i != 0);
    AppMethodBeat.o(94969);
    return -1;
    label185:
    this.aGU = 8;
    this.aGO.setPosition(0);
    this.aGT = this.aGO.cc();
    this.aGS = this.aGO.readInt();
    label221:
    if (this.aGT == 1L)
    {
      paramf.readFully(this.aGO.data, 8, 8);
      this.aGU += 8;
      this.aGT = this.aGO.qV();
    }
    while (this.aGT < this.aGU)
    {
      paramf = new o("Atom size less than header length (unsupported).");
      AppMethodBeat.o(94969);
      throw paramf;
      if (this.aGT == 0L)
      {
        l2 = paramf.getLength();
        l1 = l2;
        if (l2 == -1L)
        {
          l1 = l2;
          if (!this.aGQ.isEmpty()) {
            l1 = ((a.a)this.aGQ.peek()).aGe;
          }
        }
        if (l1 != -1L) {
          this.aGT = (l1 - paramf.getPosition() + this.aGU);
        }
      }
    }
    long l1 = paramf.getPosition() - this.aGU;
    if (this.aGS == a.aEZ)
    {
      j = this.aGI.size();
      i = 0;
      while (i < j)
      {
        paramk = ((e.b)this.aGI.valueAt(i)).aHf;
        paramk.aIf = l1;
        paramk.aIh = l1;
        paramk.aIg = l1;
        i += 1;
      }
    }
    if (this.aGS == a.aEw)
    {
      this.aGZ = null;
      this.aGW = (this.aGT + l1);
      if (!this.aHd)
      {
        this.aBV.a(new l.a(this.axh));
        this.aHd = true;
      }
      this.aBW = 2;
    }
    for (;;)
    {
      i = 1;
      break;
      i = this.aGS;
      if ((i == a.aEQ) || (i == a.aES) || (i == a.aET) || (i == a.aEU) || (i == a.aEV) || (i == a.aEZ) || (i == a.aFa) || (i == a.aFb) || (i == a.aFe)) {
        i = 1;
      }
      for (;;)
      {
        if (i != 0)
        {
          l1 = paramf.getPosition() + this.aGT - 8L;
          this.aGQ.add(new a.a(this.aGS, l1));
          if (this.aGT == this.aGU)
          {
            H(l1);
            break;
            i = 0;
            continue;
          }
          og();
          break;
        }
      }
      i = this.aGS;
      if ((i == a.aFh) || (i == a.aFg) || (i == a.aER) || (i == a.aEP) || (i == a.aFi) || (i == a.aEL) || (i == a.aEM) || (i == a.aFd) || (i == a.aEN) || (i == a.aEO) || (i == a.aFj) || (i == a.aFr) || (i == a.aFs) || (i == a.aFw) || (i == a.aFv) || (i == a.aFt) || (i == a.aFu) || (i == a.aFf) || (i == a.aFc) || (i == a.aFV)) {
        i = 1;
      }
      for (;;)
      {
        if (i != 0) {
          if (this.aGU != 8)
          {
            paramf = new o("Leaf atom defines extended atom size (unsupported).");
            AppMethodBeat.o(94969);
            throw paramf;
            i = 0;
          }
          else
          {
            if (this.aGT > 2147483647L)
            {
              paramf = new o("Leaf atom with length > 2147483647 (unsupported).");
              AppMethodBeat.o(94969);
              throw paramf;
            }
            this.aGV = new com.google.android.exoplayer2.i.m((int)this.aGT);
            System.arraycopy(this.aGO.data, 0, this.aGV.data, 0, 8);
            this.aBW = 1;
            break;
          }
        }
      }
      if (this.aGT > 2147483647L)
      {
        paramf = new o("Skipping atom with length > 2147483647 (unsupported).");
        AppMethodBeat.o(94969);
        throw paramf;
      }
      this.aGV = null;
      this.aBW = 1;
    }
    int i = (int)this.aGT - this.aGU;
    if (this.aGV != null)
    {
      paramf.readFully(this.aGV.data, 8, i);
      paramk = new a.b(this.aGS, this.aGV);
      l2 = paramf.getPosition();
      if (!this.aGQ.isEmpty()) {
        ((a.a)this.aGQ.peek()).a(paramk);
      }
    }
    Object localObject3;
    Object localObject4;
    int k;
    for (;;)
    {
      H(paramf.getPosition());
      break;
      if (paramk.type == a.aEP)
      {
        paramk = paramk.aGh;
        paramk.setPosition(8);
        i = a.dt(paramk.readInt());
        paramk.en(4);
        long l5 = paramk.cc();
        long l4;
        long l3;
        if (i == 0)
        {
          l1 = paramk.cc();
          l2 += paramk.cc();
          l4 = x.b(l1, 1000000L, l5);
          paramk.en(2);
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
            AppMethodBeat.o(94969);
            throw paramf;
            l1 = paramk.qV();
            l2 += paramk.qV();
            break;
          }
          long l6 = paramk.cc();
          localObject1[i] = (k & 0x7FFFFFFF);
          localObject2[i] = l2;
          localObject4[i] = l3;
          l1 += l6;
          l3 = x.b(l1, 1000000L, l5);
          localObject3[i] = (l3 - localObject4[i]);
          paramk.en(4);
          l2 += localObject1[i];
          i += 1;
        }
        label1333:
        paramk = Pair.create(Long.valueOf(l4), new com.google.android.exoplayer2.c.a((int[])localObject1, (long[])localObject2, (long[])localObject3, (long[])localObject4));
        this.aGY = ((Long)paramk.first).longValue();
        this.aBV.a((com.google.android.exoplayer2.c.l)paramk.second);
        this.aHd = true;
      }
      else if (paramk.type == a.aFV)
      {
        paramk = paramk.aGh;
        if (this.aHb != null)
        {
          paramk.setPosition(12);
          paramk.qW();
          paramk.qW();
          l1 = paramk.cc();
          l1 = x.b(paramk.cc(), 1000000L, l1);
          paramk.setPosition(12);
          i = paramk.qM();
          this.aHb.a(paramk, i);
          if (this.aGY != -9223372036854775807L)
          {
            this.aHb.a(l1 + this.aGY, 1, i, 0, null);
          }
          else
          {
            this.aGR.addLast(new e.a(l1, i));
            this.aGX += i;
            continue;
            paramf.dg(i);
          }
        }
      }
    }
    paramk = null;
    l1 = 9223372036854775807L;
    int j = this.aGI.size();
    i = 0;
    label1567:
    if (i < j)
    {
      localObject1 = ((e.b)this.aGI.valueAt(i)).aHf;
      if ((!((l)localObject1).aIu) || (((l)localObject1).aIh >= l1)) {
        break label2914;
      }
      l1 = ((l)localObject1).aIh;
      paramk = (e.b)this.aGI.valueAt(i);
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
        this.aBW = 3;
        break;
      }
      i = (int)(l1 - paramf.getPosition());
      if (i < 0)
      {
        paramf = new o("Offset to encryption data was negative.");
        AppMethodBeat.o(94969);
        throw paramf;
      }
      paramf.dg(i);
      paramk = paramk.aHf;
      paramf.readFully(paramk.aIt.data, 0, paramk.aIs);
      paramk.aIt.setPosition(0);
      paramk.aIu = false;
      break;
      if (paramk == null)
      {
        i = (int)(this.aGW - paramf.getPosition());
        if (i < 0)
        {
          paramf = new o("Offset to end of mdat was negative.");
          AppMethodBeat.o(94969);
          throw paramf;
        }
        paramf.dg(i);
        og();
        i = 0;
        label1779:
        if (i != 0)
        {
          AppMethodBeat.o(94969);
          return 0;
        }
      }
      else
      {
        j = (int)(paramk.aHf.aIj[paramk.aHk] - paramf.getPosition());
        i = j;
        if (j < 0) {
          i = 0;
        }
        paramf.dg(i);
        this.aGZ = paramk;
        this.sampleSize = this.aGZ.aHf.aIl[this.aGZ.aHi];
        label2032:
        int n;
        if (this.aGZ.aHf.aIp)
        {
          localObject3 = this.aGZ;
          localObject2 = ((e.b)localObject3).aHf;
          i = ((l)localObject2).aIe.aGB;
          if (((l)localObject2).aIr != null)
          {
            paramk = ((l)localObject2).aIr;
            if (paramk.aIc == 0) {
              break label2309;
            }
            localObject1 = ((l)localObject2).aIt;
            i = paramk.aIc;
            paramk = (com.google.android.exoplayer2.c.k)localObject1;
            i2 = localObject2.aIq[localObject3.aHi];
            localObject1 = this.aGL.data;
            if (i2 == 0) {
              break label2339;
            }
            j = 128;
            localObject1[0] = ((byte)(j | i));
            this.aGL.setPosition(0);
            localObject1 = ((e.b)localObject3).aCe;
            ((com.google.android.exoplayer2.c.m)localObject1).a(this.aGL, 1);
            ((com.google.android.exoplayer2.c.m)localObject1).a(paramk, i);
            if (i2 != 0) {
              break label2345;
            }
            i += 1;
            this.aDo = i;
            this.sampleSize += this.aDo;
            if (this.aGZ.aHg.aHW == 1)
            {
              this.sampleSize -= 8;
              paramf.dg(8);
            }
            this.aBW = 4;
            this.aDn = 0;
            localObject1 = this.aGZ.aHf;
            localObject3 = this.aGZ.aHg;
            localObject2 = this.aGZ.aCe;
            k = this.aGZ.aHi;
            if (((j)localObject3).aCh == 0) {
              break label2592;
            }
            paramk = this.aGJ.data;
            paramk[0] = 0;
            paramk[1] = 0;
            paramk[2] = 0;
            int m = ((j)localObject3).aCh;
            n = 4 - ((j)localObject3).aCh;
            label2155:
            if (this.aDo >= this.sampleSize) {
              break label2633;
            }
            if (this.aDn != 0) {
              break label2406;
            }
            paramf.readFully(paramk, n, m + 1);
            this.aGJ.setPosition(0);
            this.aDn = (this.aGJ.qT() - 1);
            this.aCf.setPosition(0);
            ((com.google.android.exoplayer2.c.m)localObject2).a(this.aCf, 4);
            ((com.google.android.exoplayer2.c.m)localObject2).a(this.aGJ, 1);
            if ((this.aHc == null) || (!com.google.android.exoplayer2.i.k.b(((j)localObject3).axd.awK, paramk[4]))) {
              break label2400;
            }
          }
        }
        for (int i2 = 1;; i2 = 0)
        {
          this.aHa = i2;
          this.aDo += 5;
          this.sampleSize += n;
          break label2155;
          paramk = ((e.b)localObject3).aHg.dz(i);
          break;
          localObject1 = paramk.aId;
          this.aGM.l((byte[])localObject1, localObject1.length);
          paramk = this.aGM;
          i = localObject1.length;
          break label1928;
          j = 0;
          break label1960;
          paramk = ((l)localObject2).aIt;
          j = paramk.readUnsignedShort();
          paramk.en(-2);
          j = j * 6 + 2;
          ((com.google.android.exoplayer2.c.m)localObject1).a(paramk, j);
          i = i + 1 + j;
          break label2014;
          this.aDo = 0;
          break label2032;
        }
        label2406:
        if (this.aHa)
        {
          this.aGK.reset(this.aDn);
          paramf.readFully(this.aGK.data, 0, this.aDn);
          ((com.google.android.exoplayer2.c.m)localObject2).a(this.aGK, this.aDn);
          j = this.aDn;
          int i1 = com.google.android.exoplayer2.i.k.h(this.aGK.data, this.aGK.limit);
          localObject4 = this.aGK;
          if ("video/hevc".equals(((j)localObject3).axd.awK))
          {
            i = 1;
            ((com.google.android.exoplayer2.i.m)localObject4).setPosition(i);
            this.aGK.em(i1);
            com.google.android.exoplayer2.f.a.g.a(((l)localObject1).dB(k) * 1000L, this.aGK, this.aHc);
          }
        }
        for (i = j;; i = ((com.google.android.exoplayer2.c.m)localObject2).a(paramf, this.aDn, false))
        {
          this.aDo += i;
          this.aDn -= i;
          break;
          i = 0;
          break label2507;
        }
        while (this.aDo < this.sampleSize) {
          this.aDo = (((com.google.android.exoplayer2.c.m)localObject2).a(paramf, this.sampleSize - this.aDo, false) + this.aDo);
        }
        l2 = ((l)localObject1).dB(k) * 1000L;
        l1 = l2;
        if (this.aGN != null) {
          l1 = this.aGN.ai(l2);
        }
        if (localObject1.aIo[k] != 0)
        {
          i = 1;
          paramk = null;
          if (!((l)localObject1).aIp) {
            break label2908;
          }
          i = 0x40000000 | i;
          if (((l)localObject1).aIr == null) {
            break label2800;
          }
          paramk = ((l)localObject1).aIr;
          paramk = paramk.aDw;
        }
      }
      for (;;)
      {
        ((com.google.android.exoplayer2.c.m)localObject2).a(l1, i, this.sampleSize, 0, paramk);
        for (;;)
        {
          if (!this.aGR.isEmpty())
          {
            paramk = (e.a)this.aGR.removeFirst();
            this.aGX -= paramk.size;
            this.aHb.a(paramk.aHe + l1, 1, paramk.size, this.aGX, null);
            continue;
            i = 0;
            break;
            label2800:
            paramk = ((j)localObject3).dz(((l)localObject1).aIe.aGB);
            break label2711;
          }
        }
        paramk = this.aGZ;
        paramk.aHi += 1;
        paramk = this.aGZ;
        paramk.aHj += 1;
        if (this.aGZ.aHj == localObject1.aIk[this.aGZ.aHk])
        {
          paramk = this.aGZ;
          paramk.aHk += 1;
          this.aGZ.aHj = 0;
          this.aGZ = null;
        }
        this.aBW = 3;
        i = 1;
        break label1779;
        break;
      }
      break label137;
    }
  }
  
  public final void a(com.google.android.exoplayer2.c.g paramg)
  {
    AppMethodBeat.i(94967);
    this.aBV = paramg;
    if (this.aGH != null)
    {
      paramg = new e.b(paramg.dm(0));
      paramg.a(this.aGH, new c(0, 0, 0, 0));
      this.aGI.put(0, paramg);
      oh();
      this.aBV.nZ();
    }
    AppMethodBeat.o(94967);
  }
  
  public final boolean a(f paramf)
  {
    AppMethodBeat.i(94966);
    boolean bool = i.g(paramf);
    AppMethodBeat.o(94966);
    return bool;
  }
  
  public final void g(long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(94968);
    int j = this.aGI.size();
    int i = 0;
    while (i < j)
    {
      ((e.b)this.aGI.valueAt(i)).reset();
      i += 1;
    }
    this.aGR.clear();
    this.aGX = 0;
    this.aGQ.clear();
    og();
    AppMethodBeat.o(94968);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.google.android.exoplayer2.c.d.e
 * JD-Core Version:    0.7.0.1
 */