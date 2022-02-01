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
  public static final com.google.android.exoplayer2.c.h bil;
  private static final int bmZ;
  private static final byte[] bna;
  private long bdJ;
  private final com.google.android.exoplayer2.i.m biB;
  private com.google.android.exoplayer2.c.g bir;
  private int bis;
  private int bjJ;
  private int bjK;
  private final j bnb;
  private final SparseArray<b> bnc;
  private final com.google.android.exoplayer2.i.m bnd;
  private final com.google.android.exoplayer2.i.m bne;
  private final com.google.android.exoplayer2.i.m bnf;
  private final com.google.android.exoplayer2.i.m bng;
  private final u bnh;
  private final com.google.android.exoplayer2.i.m bni;
  private final byte[] bnj;
  private final Stack<a.a> bnk;
  private final LinkedList<a> bnl;
  private int bnm;
  private long bnn;
  private int bno;
  private com.google.android.exoplayer2.i.m bnp;
  private long bnq;
  private int bnr;
  private long bns;
  private b bnt;
  private boolean bnu;
  private com.google.android.exoplayer2.c.m bnv;
  private com.google.android.exoplayer2.c.m[] bnw;
  private boolean bnx;
  private final int flags;
  private int sampleSize;
  
  static
  {
    AppMethodBeat.i(92104);
    bil = new com.google.android.exoplayer2.c.h()
    {
      public final com.google.android.exoplayer2.c.e[] ux()
      {
        AppMethodBeat.i(92075);
        e locale = new e();
        AppMethodBeat.o(92075);
        return new com.google.android.exoplayer2.c.e[] { locale };
      }
    };
    bmZ = x.bJ("seig");
    bna = new byte[] { -94, 57, 79, 82, 90, -101, 79, 20, -94, 68, 108, 66, 124, 100, -115, -12 };
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
    AppMethodBeat.i(196028);
    this.flags = (paramInt | 0x0);
    this.bnh = paramu;
    this.bnb = null;
    this.bni = new com.google.android.exoplayer2.i.m(16);
    this.biB = new com.google.android.exoplayer2.i.m(com.google.android.exoplayer2.i.k.bGT);
    this.bnd = new com.google.android.exoplayer2.i.m(5);
    this.bne = new com.google.android.exoplayer2.i.m();
    this.bnf = new com.google.android.exoplayer2.i.m(1);
    this.bng = new com.google.android.exoplayer2.i.m();
    this.bnj = new byte[16];
    this.bnk = new Stack();
    this.bnl = new LinkedList();
    this.bnc = new SparseArray();
    this.bdJ = -9223372036854775807L;
    this.bns = -9223372036854775807L;
    uF();
    AppMethodBeat.o(196028);
  }
  
  private void O(long paramLong)
  {
    AppMethodBeat.i(92085);
    while ((!this.bnk.isEmpty()) && (((a.a)this.bnk.peek()).bmy == paramLong)) {
      c((a.a)this.bnk.pop());
    }
    uF();
    AppMethodBeat.o(92085);
  }
  
  private static int a(b paramb, int paramInt1, long paramLong, int paramInt2, com.google.android.exoplayer2.i.m paramm, int paramInt3)
  {
    AppMethodBeat.i(92099);
    paramm.setPosition(8);
    int i1 = a.ed(paramm.readInt());
    j localj = paramb.bnA;
    paramb = paramb.bnz;
    c localc = paramb.boy;
    paramb.boE[paramInt1] = paramm.xk();
    paramb.boD[paramInt1] = paramb.boA;
    Object localObject;
    if ((i1 & 0x1) != 0)
    {
      localObject = paramb.boD;
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
        i = paramm.xk();
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
      if ((localj.bor == null) || (localj.bor.length != 1) || (localj.bor[0] != 0L)) {
        break label528;
      }
    }
    label258:
    label515:
    label528:
    for (long l1 = x.b(localj.bos[0], 1000L, localj.boo);; l1 = 0L)
    {
      localObject = paramb.boF;
      int[] arrayOfInt = paramb.boG;
      long[] arrayOfLong = paramb.boH;
      boolean[] arrayOfBoolean = paramb.boI;
      int i4;
      label285:
      int i2;
      label304:
      int i3;
      if ((localj.type == 2) && ((paramInt2 & 0x1) != 0))
      {
        paramInt2 = 1;
        i4 = paramInt3 + paramb.boE[paramInt1];
        long l2 = localj.boo;
        if (paramInt1 > 0) {
          paramLong = paramb.boP;
        }
        if (paramInt3 >= i4) {
          break label515;
        }
        if (k == 0) {
          break label457;
        }
        i2 = paramm.xk();
        if (m == 0) {
          break label467;
        }
        i3 = paramm.xk();
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
      paramb.boP = paramLong;
      AppMethodBeat.o(92099);
      return i4;
    }
  }
  
  private static b a(com.google.android.exoplayer2.i.m paramm, SparseArray<b> paramSparseArray, int paramInt)
  {
    AppMethodBeat.i(92097);
    paramm.setPosition(8);
    int k = a.ed(paramm.readInt());
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
      long l = paramm.xm();
      paramSparseArray.bnz.boA = l;
      paramSparseArray.bnz.boB = l;
    }
    c localc = paramSparseArray.bnB;
    label125:
    int j;
    if ((k & 0x2) != 0)
    {
      paramInt = paramm.xk() - 1;
      if ((k & 0x8) == 0) {
        break label190;
      }
      i = paramm.xk();
      if ((k & 0x10) == 0) {
        break label199;
      }
      j = paramm.xk();
      label139:
      if ((k & 0x20) == 0) {
        break label209;
      }
    }
    label190:
    label199:
    label209:
    for (k = paramm.xk();; k = localc.flags)
    {
      paramSparseArray.bnz.boy = new c(paramInt, i, j, k);
      AppMethodBeat.o(92097);
      return paramSparseArray;
      paramInt = localc.bmV;
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
    int j = parama.bmA.size();
    int i = 0;
    while (i < j)
    {
      a.a locala = (a.a)parama.bmA.get(i);
      if (locala.type == a.blu) {
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
    parama = parama.bmz;
    int i1 = parama.size();
    int j = 0;
    Object localObject;
    int m;
    if (j < i1)
    {
      localObject = (a.b)parama.get(j);
      if (((a.b)localObject).type != a.bli) {
        break label229;
      }
      localObject = ((a.b)localObject).bmB;
      ((com.google.android.exoplayer2.i.m)localObject).setPosition(12);
      m = ((com.google.android.exoplayer2.i.m)localObject).xk();
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
      paramb.bnE = 0;
      paramb.bnD = 0;
      paramb.bnC = 0;
      paramb.bnz.bd(k, i);
      j = 0;
      k = 0;
      i = 0;
      while (i < i1)
      {
        localObject = (a.b)parama.get(i);
        int n = j;
        m = k;
        if (((a.b)localObject).type == a.bli)
        {
          m = a(paramb, j, paramLong, paramInt, ((a.b)localObject).bmB, k);
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
    int n = paramk.bow;
    paramm.setPosition(8);
    if ((a.ed(paramm.readInt()) & 0x1) == 1) {
      paramm.eZ(8);
    }
    int i = paramm.readUnsignedByte();
    int m = paramm.xk();
    if (m != paraml.sampleCount)
    {
      paramk = new o("Length mismatch: " + m + ", " + paraml.sampleCount);
      AppMethodBeat.o(92095);
      throw paramk;
    }
    int k;
    if (i == 0)
    {
      paramk = paraml.boK;
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
      Arrays.fill(paraml.boK, 0, m, bool);
      paraml.ej(k);
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
    paramInt = a.ed(paramm.readInt());
    if ((paramInt & 0x1) != 0)
    {
      paramm = new o("Overriding TrackEncryptionBox parameters is unsupported.");
      AppMethodBeat.o(92101);
      throw paramm;
    }
    if ((paramInt & 0x2) != 0) {}
    for (boolean bool = true;; bool = false)
    {
      paramInt = paramm.xk();
      if (paramInt == paraml.sampleCount) {
        break;
      }
      paramm = new o("Length mismatch: " + paramInt + ", " + paraml.sampleCount);
      AppMethodBeat.o(92101);
      throw paramm;
    }
    Arrays.fill(paraml.boK, 0, paramInt, bool);
    paraml.ej(paramm.xd());
    paraml.q(paramm);
    AppMethodBeat.o(92101);
  }
  
  private static void a(com.google.android.exoplayer2.i.m paramm, l paraml)
  {
    AppMethodBeat.i(92096);
    paramm.setPosition(8);
    int i = paramm.readInt();
    if ((a.ed(i) & 0x1) == 1) {
      paramm.eZ(8);
    }
    int j = paramm.xk();
    if (j != 1)
    {
      paramm = new o("Unexpected saio entry count: ".concat(String.valueOf(j)));
      AppMethodBeat.o(92096);
      throw paramm;
    }
    i = a.ec(i);
    long l2 = paraml.boB;
    if (i == 0) {}
    for (long l1 = paramm.dE();; l1 = paramm.xm())
    {
      paraml.boB = (l1 + l2);
      AppMethodBeat.o(92096);
      return;
    }
  }
  
  private static void a(com.google.android.exoplayer2.i.m paramm, l paraml, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(92100);
    paramm.setPosition(8);
    paramm.readBytes(paramArrayOfByte, 0, 16);
    if (!Arrays.equals(paramArrayOfByte, bna))
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
    if (paramm1.readInt() != bmZ)
    {
      AppMethodBeat.o(92102);
      return;
    }
    if (a.ec(i) == 1) {
      paramm1.eZ(4);
    }
    if (paramm1.readInt() != 1)
    {
      paramm1 = new o("Entry count in sbgp != 1 (unsupported).");
      AppMethodBeat.o(92102);
      throw paramm1;
    }
    paramm2.setPosition(8);
    i = paramm2.readInt();
    if (paramm2.readInt() != bmZ)
    {
      AppMethodBeat.o(92102);
      return;
    }
    i = a.ec(i);
    if (i == 1)
    {
      if (paramm2.dE() == 0L)
      {
        paramm1 = new o("Variable length description in sgpd found (unsupported)");
        AppMethodBeat.o(92102);
        throw paramm1;
      }
    }
    else if (i >= 2) {
      paramm2.eZ(4);
    }
    if (paramm2.dE() != 1L)
    {
      paramm1 = new o("Entry count in sgpd != 1 (unsupported).");
      AppMethodBeat.o(92102);
      throw paramm1;
    }
    paramm2.eZ(1);
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
    paraml.boJ = true;
    paraml.boL = new k(true, paramString, i, arrayOfByte, (j & 0xF0) >> 4, j & 0xF, paramm1);
    AppMethodBeat.o(92102);
  }
  
  private static void b(a.a parama, SparseArray<b> paramSparseArray, int paramInt, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(92093);
    paramSparseArray = a(parama.ef(a.blg).bmB, paramSparseArray, paramInt);
    if (paramSparseArray == null)
    {
      AppMethodBeat.o(92093);
      return;
    }
    l locall = paramSparseArray.bnz;
    long l2 = locall.boP;
    paramSparseArray.reset();
    long l1 = l2;
    if (parama.ef(a.blf) != null)
    {
      l1 = l2;
      if ((paramInt & 0x2) == 0) {
        l1 = n(parama.ef(a.blf).bmB);
      }
    }
    a(parama, paramSparseArray, l1, paramInt);
    paramSparseArray = paramSparseArray.bnA.ei(locall.boy.bmV);
    Object localObject1 = parama.ef(a.blL);
    if (localObject1 != null) {
      a(paramSparseArray, ((a.b)localObject1).bmB, locall);
    }
    localObject1 = parama.ef(a.blM);
    if (localObject1 != null) {
      a(((a.b)localObject1).bmB, locall);
    }
    localObject1 = parama.ef(a.blQ);
    if (localObject1 != null) {
      a(((a.b)localObject1).bmB, 0, locall);
    }
    localObject1 = parama.ef(a.blN);
    Object localObject2 = parama.ef(a.blO);
    if ((localObject1 != null) && (localObject2 != null))
    {
      localObject1 = ((a.b)localObject1).bmB;
      localObject2 = ((a.b)localObject2).bmB;
      if (paramSparseArray == null) {
        break label308;
      }
    }
    label308:
    for (paramSparseArray = paramSparseArray.bov;; paramSparseArray = null)
    {
      a((com.google.android.exoplayer2.i.m)localObject1, (com.google.android.exoplayer2.i.m)localObject2, paramSparseArray, locall);
      int i = parama.bmz.size();
      paramInt = 0;
      while (paramInt < i)
      {
        paramSparseArray = (a.b)parama.bmz.get(paramInt);
        if (paramSparseArray.type == a.blP) {
          a(paramSparseArray.bmB, locall, paramArrayOfByte);
        }
        paramInt += 1;
      }
    }
    AppMethodBeat.o(92093);
  }
  
  private void c(a.a parama)
  {
    AppMethodBeat.i(92086);
    if (parama.type == a.blk)
    {
      d(parama);
      AppMethodBeat.o(92086);
      return;
    }
    if (parama.type == a.blt)
    {
      e(parama);
      AppMethodBeat.o(92086);
      return;
    }
    if (!this.bnk.isEmpty()) {
      ((a.a)this.bnk.peek()).a(parama);
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
    if (this.bnb == null)
    {
      bool1 = true;
      com.google.android.exoplayer2.i.a.checkState(bool1, "Unexpected moov box.");
      localObject1 = t(parama.bmz);
      localObject2 = parama.eg(a.blv);
      localSparseArray = new SparseArray();
      l = -9223372036854775807L;
      m = ((a.a)localObject2).bmz.size();
      i = 0;
      if (i >= m) {
        break label179;
      }
      localObject3 = (a.b)((a.a)localObject2).bmz.get(i);
      if (((a.b)localObject3).type != a.blh) {
        break label155;
      }
      localObject3 = l(((a.b)localObject3).bmB);
      localSparseArray.put(((Integer)((Pair)localObject3).first).intValue(), ((Pair)localObject3).second);
    }
    for (;;)
    {
      i += 1;
      break label78;
      bool1 = false;
      break;
      label155:
      if (((a.b)localObject3).type == a.blw) {
        l = m(((a.b)localObject3).bmB);
      }
    }
    label179:
    Object localObject2 = new SparseArray();
    int m = parama.bmA.size();
    int i = 0;
    if (i < m)
    {
      localObject3 = (a.a)parama.bmA.get(i);
      a.b localb;
      if (((a.a)localObject3).type == a.blm)
      {
        localb = parama.ef(a.bll);
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
    if (this.bnc.size() == 0)
    {
      i = j;
      while (i < m)
      {
        parama = (j)((SparseArray)localObject2).valueAt(i);
        localObject1 = new b(this.bir.dV(i));
        ((b)localObject1).a(parama, (c)localSparseArray.get(parama.id));
        this.bnc.put(parama.id, localObject1);
        this.bdJ = Math.max(this.bdJ, parama.bdJ);
        i += 1;
      }
      uG();
      this.bir.uy();
      AppMethodBeat.o(92087);
      return;
    }
    if (this.bnc.size() == m) {}
    for (boolean bool1 = bool2;; bool1 = false)
    {
      com.google.android.exoplayer2.i.a.checkState(bool1);
      i = k;
      while (i < m)
      {
        parama = (j)((SparseArray)localObject2).valueAt(i);
        ((b)this.bnc.get(parama.id)).a(parama, (c)localSparseArray.get(parama.id));
        i += 1;
      }
    }
    AppMethodBeat.o(92087);
  }
  
  private void e(a.a parama)
  {
    AppMethodBeat.i(92088);
    a(parama, this.bnc, this.flags, this.bnj);
    parama = t(parama.bmz);
    if (parama != null)
    {
      int j = this.bnc.size();
      int i = 0;
      while (i < j)
      {
        ((b)this.bnc.valueAt(i)).b(parama);
        i += 1;
      }
    }
    AppMethodBeat.o(92088);
  }
  
  private static Pair<Integer, c> l(com.google.android.exoplayer2.i.m paramm)
  {
    AppMethodBeat.i(92090);
    paramm.setPosition(12);
    paramm = Pair.create(Integer.valueOf(paramm.readInt()), new c(paramm.xk() - 1, paramm.xk(), paramm.xk(), paramm.readInt()));
    AppMethodBeat.o(92090);
    return paramm;
  }
  
  private static long m(com.google.android.exoplayer2.i.m paramm)
  {
    AppMethodBeat.i(92091);
    paramm.setPosition(8);
    if (a.ec(paramm.readInt()) == 0)
    {
      l = paramm.dE();
      AppMethodBeat.o(92091);
      return l;
    }
    long l = paramm.xm();
    AppMethodBeat.o(92091);
    return l;
  }
  
  private static long n(com.google.android.exoplayer2.i.m paramm)
  {
    AppMethodBeat.i(92098);
    paramm.setPosition(8);
    if (a.ec(paramm.readInt()) == 1)
    {
      l = paramm.xm();
      AppMethodBeat.o(92098);
      return l;
    }
    long l = paramm.dE();
    AppMethodBeat.o(92098);
    return l;
  }
  
  private static DrmInitData t(List<a.b> paramList)
  {
    AppMethodBeat.i(92103);
    int j = paramList.size();
    int i = 0;
    Object localObject3;
    for (Object localObject2 = null; i < j; localObject2 = localObject3)
    {
      Object localObject4 = (a.b)paramList.get(i);
      localObject3 = localObject2;
      if (((a.b)localObject4).type == a.blD)
      {
        Object localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = new ArrayList();
        }
        localObject2 = ((a.b)localObject4).bmB.data;
        localObject4 = h.r((byte[])localObject2);
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
  
  private void uF()
  {
    this.bis = 0;
    this.bno = 0;
  }
  
  private void uG()
  {
    AppMethodBeat.i(92089);
    if (((this.flags & 0x4) != 0) && (this.bnv == null))
    {
      this.bnv = this.bir.dV(this.bnc.size());
      this.bnv.f(Format.d("application/x-emsg", 9223372036854775807L));
    }
    if (((this.flags & 0x8) != 0) && (this.bnw == null))
    {
      com.google.android.exoplayer2.c.m localm = this.bir.dV(this.bnc.size() + 1);
      localm.f(Format.bc("application/cea-608"));
      this.bnw = new com.google.android.exoplayer2.c.m[] { localm };
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
      switch (this.bis)
      {
      default: 
        if (this.bis != 3) {
          break label2075;
        }
        if (this.bnt != null) {
          break;
        }
        localObject2 = this.bnc;
        paramk = null;
        l1 = 9223372036854775807L;
        j = ((SparseArray)localObject2).size();
        i = 0;
        while (i < j)
        {
          localObject1 = (b)((SparseArray)localObject2).valueAt(i);
          if (((b)localObject1).bnE == ((b)localObject1).bnz.boC) {
            break label2911;
          }
          l2 = localObject1.bnz.boD[localObject1.bnE];
          if (l2 >= l1) {
            break label2911;
          }
          l1 = l2;
          paramk = (com.google.android.exoplayer2.c.k)localObject1;
          i += 1;
        }
      case 0: 
        if (this.bno != 0) {
          break label221;
        }
        if (paramf.a(this.bni.data, 0, 8, true)) {
          break label185;
        }
        i = 0;
      }
    } while (i != 0);
    AppMethodBeat.o(92084);
    return -1;
    label185:
    this.bno = 8;
    this.bni.setPosition(0);
    this.bnn = this.bni.dE();
    this.bnm = this.bni.readInt();
    label221:
    if (this.bnn == 1L)
    {
      paramf.readFully(this.bni.data, 8, 8);
      this.bno += 8;
      this.bnn = this.bni.xm();
    }
    while (this.bnn < this.bno)
    {
      paramf = new o("Atom size less than header length (unsupported).");
      AppMethodBeat.o(92084);
      throw paramf;
      if (this.bnn == 0L)
      {
        l2 = paramf.getLength();
        l1 = l2;
        if (l2 == -1L)
        {
          l1 = l2;
          if (!this.bnk.isEmpty()) {
            l1 = ((a.a)this.bnk.peek()).bmy;
          }
        }
        if (l1 != -1L) {
          this.bnn = (l1 - paramf.getPosition() + this.bno);
        }
      }
    }
    long l1 = paramf.getPosition() - this.bno;
    if (this.bnm == a.blt)
    {
      j = this.bnc.size();
      i = 0;
      while (i < j)
      {
        paramk = ((b)this.bnc.valueAt(i)).bnz;
        paramk.boz = l1;
        paramk.boB = l1;
        paramk.boA = l1;
        i += 1;
      }
    }
    if (this.bnm == a.bkQ)
    {
      this.bnt = null;
      this.bnq = (this.bnn + l1);
      if (!this.bnx)
      {
        this.bir.a(new l.a(this.bdJ));
        this.bnx = true;
      }
      this.bis = 2;
    }
    for (;;)
    {
      i = 1;
      break;
      i = this.bnm;
      if ((i == a.blk) || (i == a.blm) || (i == a.bln) || (i == a.blo) || (i == a.blp) || (i == a.blt) || (i == a.blu) || (i == a.blv) || (i == a.bly)) {
        i = 1;
      }
      for (;;)
      {
        if (i != 0)
        {
          l1 = paramf.getPosition() + this.bnn - 8L;
          this.bnk.add(new a.a(this.bnm, l1));
          if (this.bnn == this.bno)
          {
            O(l1);
            break;
            i = 0;
            continue;
          }
          uF();
          break;
        }
      }
      i = this.bnm;
      if ((i == a.blB) || (i == a.blA) || (i == a.bll) || (i == a.blj) || (i == a.blC) || (i == a.blf) || (i == a.blg) || (i == a.blx) || (i == a.blh) || (i == a.bli) || (i == a.blD) || (i == a.blL) || (i == a.blM) || (i == a.blQ) || (i == a.blP) || (i == a.blN) || (i == a.blO) || (i == a.blz) || (i == a.blw) || (i == a.bmp)) {
        i = 1;
      }
      for (;;)
      {
        if (i != 0) {
          if (this.bno != 8)
          {
            paramf = new o("Leaf atom defines extended atom size (unsupported).");
            AppMethodBeat.o(92084);
            throw paramf;
            i = 0;
          }
          else
          {
            if (this.bnn > 2147483647L)
            {
              paramf = new o("Leaf atom with length > 2147483647 (unsupported).");
              AppMethodBeat.o(92084);
              throw paramf;
            }
            this.bnp = new com.google.android.exoplayer2.i.m((int)this.bnn);
            System.arraycopy(this.bni.data, 0, this.bnp.data, 0, 8);
            this.bis = 1;
            break;
          }
        }
      }
      if (this.bnn > 2147483647L)
      {
        paramf = new o("Skipping atom with length > 2147483647 (unsupported).");
        AppMethodBeat.o(92084);
        throw paramf;
      }
      this.bnp = null;
      this.bis = 1;
    }
    int i = (int)this.bnn - this.bno;
    if (this.bnp != null)
    {
      paramf.readFully(this.bnp.data, 8, i);
      paramk = new a.b(this.bnm, this.bnp);
      l2 = paramf.getPosition();
      if (!this.bnk.isEmpty()) {
        ((a.a)this.bnk.peek()).a(paramk);
      }
    }
    Object localObject3;
    Object localObject4;
    int k;
    for (;;)
    {
      O(paramf.getPosition());
      break;
      if (paramk.type == a.blj)
      {
        paramk = paramk.bmB;
        paramk.setPosition(8);
        i = a.ec(paramk.readInt());
        paramk.eZ(4);
        long l5 = paramk.dE();
        long l4;
        long l3;
        if (i == 0)
        {
          l1 = paramk.dE();
          l2 += paramk.dE();
          l4 = x.b(l1, 1000000L, l5);
          paramk.eZ(2);
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
            l1 = paramk.xm();
            l2 += paramk.xm();
            break;
          }
          long l6 = paramk.dE();
          localObject1[i] = (k & 0x7FFFFFFF);
          localObject2[i] = l2;
          localObject4[i] = l3;
          l1 += l6;
          l3 = x.b(l1, 1000000L, l5);
          localObject3[i] = (l3 - localObject4[i]);
          paramk.eZ(4);
          l2 += localObject1[i];
          i += 1;
        }
        label1333:
        paramk = Pair.create(Long.valueOf(l4), new com.google.android.exoplayer2.c.a((int[])localObject1, (long[])localObject2, (long[])localObject3, (long[])localObject4));
        this.bns = ((Long)paramk.first).longValue();
        this.bir.a((com.google.android.exoplayer2.c.l)paramk.second);
        this.bnx = true;
      }
      else if (paramk.type == a.bmp)
      {
        paramk = paramk.bmB;
        if (this.bnv != null)
        {
          paramk.setPosition(12);
          paramk.xn();
          paramk.xn();
          l1 = paramk.dE();
          l1 = x.b(paramk.dE(), 1000000L, l1);
          paramk.setPosition(12);
          i = paramk.xd();
          this.bnv.a(paramk, i);
          if (this.bns != -9223372036854775807L)
          {
            this.bnv.a(l1 + this.bns, 1, i, 0, null);
          }
          else
          {
            this.bnl.addLast(new a(l1, i));
            this.bnr += i;
            continue;
            paramf.dP(i);
          }
        }
      }
    }
    paramk = null;
    l1 = 9223372036854775807L;
    int j = this.bnc.size();
    i = 0;
    label1567:
    if (i < j)
    {
      localObject1 = ((b)this.bnc.valueAt(i)).bnz;
      if ((!((l)localObject1).boO) || (((l)localObject1).boB >= l1)) {
        break label2914;
      }
      l1 = ((l)localObject1).boB;
      paramk = (b)this.bnc.valueAt(i);
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
        this.bis = 3;
        break;
      }
      i = (int)(l1 - paramf.getPosition());
      if (i < 0)
      {
        paramf = new o("Offset to encryption data was negative.");
        AppMethodBeat.o(92084);
        throw paramf;
      }
      paramf.dP(i);
      paramk = paramk.bnz;
      paramf.readFully(paramk.boN.data, 0, paramk.boM);
      paramk.boN.setPosition(0);
      paramk.boO = false;
      break;
      if (paramk == null)
      {
        i = (int)(this.bnq - paramf.getPosition());
        if (i < 0)
        {
          paramf = new o("Offset to end of mdat was negative.");
          AppMethodBeat.o(92084);
          throw paramf;
        }
        paramf.dP(i);
        uF();
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
        j = (int)(paramk.bnz.boD[paramk.bnE] - paramf.getPosition());
        i = j;
        if (j < 0) {
          i = 0;
        }
        paramf.dP(i);
        this.bnt = paramk;
        this.sampleSize = this.bnt.bnz.boF[this.bnt.bnC];
        label2032:
        int n;
        if (this.bnt.bnz.boJ)
        {
          localObject3 = this.bnt;
          localObject2 = ((b)localObject3).bnz;
          i = ((l)localObject2).boy.bmV;
          if (((l)localObject2).boL != null)
          {
            paramk = ((l)localObject2).boL;
            if (paramk.bow == 0) {
              break label2309;
            }
            localObject1 = ((l)localObject2).boN;
            i = paramk.bow;
            paramk = (com.google.android.exoplayer2.c.k)localObject1;
            i2 = localObject2.boK[localObject3.bnC];
            localObject1 = this.bnf.data;
            if (i2 == 0) {
              break label2339;
            }
            j = 128;
            localObject1[0] = ((byte)(j | i));
            this.bnf.setPosition(0);
            localObject1 = ((b)localObject3).biA;
            ((com.google.android.exoplayer2.c.m)localObject1).a(this.bnf, 1);
            ((com.google.android.exoplayer2.c.m)localObject1).a(paramk, i);
            if (i2 != 0) {
              break label2345;
            }
            i += 1;
            this.bjK = i;
            this.sampleSize += this.bjK;
            if (this.bnt.bnA.boq == 1)
            {
              this.sampleSize -= 8;
              paramf.dP(8);
            }
            this.bis = 4;
            this.bjJ = 0;
            localObject1 = this.bnt.bnz;
            localObject3 = this.bnt.bnA;
            localObject2 = this.bnt.biA;
            k = this.bnt.bnC;
            if (((j)localObject3).biD == 0) {
              break label2592;
            }
            paramk = this.bnd.data;
            paramk[0] = 0;
            paramk[1] = 0;
            paramk[2] = 0;
            int m = ((j)localObject3).biD;
            n = 4 - ((j)localObject3).biD;
            label2155:
            if (this.bjK >= this.sampleSize) {
              break label2633;
            }
            if (this.bjJ != 0) {
              break label2406;
            }
            paramf.readFully(paramk, n, m + 1);
            this.bnd.setPosition(0);
            this.bjJ = (this.bnd.xk() - 1);
            this.biB.setPosition(0);
            ((com.google.android.exoplayer2.c.m)localObject2).a(this.biB, 4);
            ((com.google.android.exoplayer2.c.m)localObject2).a(this.bnd, 1);
            if ((this.bnw == null) || (!com.google.android.exoplayer2.i.k.b(((j)localObject3).bdF.bdq, paramk[4]))) {
              break label2400;
            }
          }
        }
        for (int i2 = 1;; i2 = 0)
        {
          this.bnu = i2;
          this.bjK += 5;
          this.sampleSize += n;
          break label2155;
          paramk = ((b)localObject3).bnA.ei(i);
          break;
          localObject1 = paramk.box;
          this.bng.n((byte[])localObject1, localObject1.length);
          paramk = this.bng;
          i = localObject1.length;
          break label1928;
          j = 0;
          break label1960;
          paramk = ((l)localObject2).boN;
          j = paramk.readUnsignedShort();
          paramk.eZ(-2);
          j = j * 6 + 2;
          ((com.google.android.exoplayer2.c.m)localObject1).a(paramk, j);
          i = i + 1 + j;
          break label2014;
          this.bjK = 0;
          break label2032;
        }
        label2406:
        if (this.bnu)
        {
          this.bne.reset(this.bjJ);
          paramf.readFully(this.bne.data, 0, this.bjJ);
          ((com.google.android.exoplayer2.c.m)localObject2).a(this.bne, this.bjJ);
          j = this.bjJ;
          int i1 = com.google.android.exoplayer2.i.k.j(this.bne.data, this.bne.limit);
          localObject4 = this.bne;
          if ("video/hevc".equals(((j)localObject3).bdF.bdq))
          {
            i = 1;
            ((com.google.android.exoplayer2.i.m)localObject4).setPosition(i);
            this.bne.eY(i1);
            com.google.android.exoplayer2.f.a.g.a(((l)localObject1).ek(k) * 1000L, this.bne, this.bnw);
          }
        }
        for (i = j;; i = ((com.google.android.exoplayer2.c.m)localObject2).a(paramf, this.bjJ, false))
        {
          this.bjK += i;
          this.bjJ -= i;
          break;
          i = 0;
          break label2507;
        }
        while (this.bjK < this.sampleSize) {
          this.bjK = (((com.google.android.exoplayer2.c.m)localObject2).a(paramf, this.sampleSize - this.bjK, false) + this.bjK);
        }
        l2 = ((l)localObject1).ek(k) * 1000L;
        l1 = l2;
        if (this.bnh != null) {
          l1 = this.bnh.ap(l2);
        }
        if (localObject1.boI[k] != 0)
        {
          i = 1;
          paramk = null;
          if (!((l)localObject1).boJ) {
            break label2908;
          }
          i = 0x40000000 | i;
          if (((l)localObject1).boL == null) {
            break label2800;
          }
          paramk = ((l)localObject1).boL;
          paramk = paramk.bjS;
        }
      }
      for (;;)
      {
        ((com.google.android.exoplayer2.c.m)localObject2).a(l1, i, this.sampleSize, 0, paramk);
        for (;;)
        {
          if (!this.bnl.isEmpty())
          {
            paramk = (a)this.bnl.removeFirst();
            this.bnr -= paramk.size;
            this.bnv.a(paramk.bny + l1, 1, paramk.size, this.bnr, null);
            continue;
            i = 0;
            break;
            label2800:
            paramk = ((j)localObject3).ei(((l)localObject1).boy.bmV);
            break label2711;
          }
        }
        paramk = this.bnt;
        paramk.bnC += 1;
        paramk = this.bnt;
        paramk.bnD += 1;
        if (this.bnt.bnD == localObject1.boE[this.bnt.bnE])
        {
          paramk = this.bnt;
          paramk.bnE += 1;
          this.bnt.bnD = 0;
          this.bnt = null;
        }
        this.bis = 3;
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
    this.bir = paramg;
    if (this.bnb != null)
    {
      paramg = new b(paramg.dV(0));
      paramg.a(this.bnb, new c(0, 0, 0, 0));
      this.bnc.put(0, paramg);
      uG();
      this.bir.uy();
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
  
  public final void f(long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(92083);
    int j = this.bnc.size();
    int i = 0;
    while (i < j)
    {
      ((b)this.bnc.valueAt(i)).reset();
      i += 1;
    }
    this.bnl.clear();
    this.bnr = 0;
    this.bnk.clear();
    uF();
    AppMethodBeat.o(92083);
  }
  
  static final class a
  {
    public final long bny;
    public final int size;
    
    public a(long paramLong, int paramInt)
    {
      this.bny = paramLong;
      this.size = paramInt;
    }
  }
  
  static final class b
  {
    public final com.google.android.exoplayer2.c.m biA;
    public j bnA;
    public c bnB;
    public int bnC;
    public int bnD;
    public int bnE;
    public final l bnz;
    
    public b(com.google.android.exoplayer2.c.m paramm)
    {
      AppMethodBeat.i(92076);
      this.bnz = new l();
      this.biA = paramm;
      AppMethodBeat.o(92076);
    }
    
    public final void a(j paramj, c paramc)
    {
      AppMethodBeat.i(92077);
      this.bnA = ((j)com.google.android.exoplayer2.i.a.checkNotNull(paramj));
      this.bnB = ((c)com.google.android.exoplayer2.i.a.checkNotNull(paramc));
      this.biA.f(paramj.bdF);
      reset();
      AppMethodBeat.o(92077);
    }
    
    public final void b(DrmInitData paramDrmInitData)
    {
      AppMethodBeat.i(92079);
      Object localObject = this.bnA.ei(this.bnz.boy.bmV);
      if (localObject != null) {}
      for (localObject = ((k)localObject).bov;; localObject = null)
      {
        this.biA.f(this.bnA.bdF.a(paramDrmInitData.bg((String)localObject)));
        AppMethodBeat.o(92079);
        return;
      }
    }
    
    public final void reset()
    {
      AppMethodBeat.i(92078);
      this.bnz.reset();
      this.bnC = 0;
      this.bnE = 0;
      this.bnD = 0;
      AppMethodBeat.o(92078);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.google.android.exoplayer2.c.d.e
 * JD-Core Version:    0.7.0.1
 */