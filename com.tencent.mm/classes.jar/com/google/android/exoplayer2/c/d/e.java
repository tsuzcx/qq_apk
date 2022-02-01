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
  public static final com.google.android.exoplayer2.c.h bio;
  private static final int bne;
  private static final byte[] bnf;
  private long bdM;
  private final com.google.android.exoplayer2.i.m biE;
  private com.google.android.exoplayer2.c.g biu;
  private int biv;
  private int bjM;
  private int bjN;
  private com.google.android.exoplayer2.c.m bnA;
  private com.google.android.exoplayer2.c.m[] bnB;
  private boolean bnC;
  private final j bng;
  private final SparseArray<b> bnh;
  private final com.google.android.exoplayer2.i.m bni;
  private final com.google.android.exoplayer2.i.m bnj;
  private final com.google.android.exoplayer2.i.m bnk;
  private final com.google.android.exoplayer2.i.m bnl;
  private final u bnm;
  private final com.google.android.exoplayer2.i.m bnn;
  private final byte[] bno;
  private final Stack<a.a> bnp;
  private final LinkedList<a> bnq;
  private int bnr;
  private long bns;
  private int bnt;
  private com.google.android.exoplayer2.i.m bnu;
  private long bnv;
  private int bnw;
  private long bnx;
  private b bny;
  private boolean bnz;
  private final int flags;
  private int sampleSize;
  
  static
  {
    AppMethodBeat.i(92104);
    bio = new com.google.android.exoplayer2.c.h()
    {
      public final com.google.android.exoplayer2.c.e[] us()
      {
        AppMethodBeat.i(92075);
        e locale = new e();
        AppMethodBeat.o(92075);
        return new com.google.android.exoplayer2.c.e[] { locale };
      }
    };
    bne = x.bJ("seig");
    bnf = new byte[] { -94, 57, 79, 82, 90, -101, 79, 20, -94, 68, 108, 66, 124, 100, -115, -12 };
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
    AppMethodBeat.i(217108);
    this.flags = (paramInt | 0x0);
    this.bnm = paramu;
    this.bng = null;
    this.bnn = new com.google.android.exoplayer2.i.m(16);
    this.biE = new com.google.android.exoplayer2.i.m(com.google.android.exoplayer2.i.k.bGC);
    this.bni = new com.google.android.exoplayer2.i.m(5);
    this.bnj = new com.google.android.exoplayer2.i.m();
    this.bnk = new com.google.android.exoplayer2.i.m(1);
    this.bnl = new com.google.android.exoplayer2.i.m();
    this.bno = new byte[16];
    this.bnp = new Stack();
    this.bnq = new LinkedList();
    this.bnh = new SparseArray();
    this.bdM = -9223372036854775807L;
    this.bnx = -9223372036854775807L;
    uA();
    AppMethodBeat.o(217108);
  }
  
  private void O(long paramLong)
  {
    AppMethodBeat.i(92085);
    while ((!this.bnp.isEmpty()) && (((a.a)this.bnp.peek()).bmD == paramLong)) {
      c((a.a)this.bnp.pop());
    }
    uA();
    AppMethodBeat.o(92085);
  }
  
  private static int a(b paramb, int paramInt1, long paramLong, int paramInt2, com.google.android.exoplayer2.i.m paramm, int paramInt3)
  {
    AppMethodBeat.i(92099);
    paramm.setPosition(8);
    int i1 = a.ej(paramm.readInt());
    j localj = paramb.bnF;
    paramb = paramb.bnE;
    c localc = paramb.boD;
    paramb.boJ[paramInt1] = paramm.xc();
    paramb.boI[paramInt1] = paramb.boF;
    Object localObject;
    if ((i1 & 0x1) != 0)
    {
      localObject = paramb.boI;
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
        i = paramm.xc();
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
      if ((localj.bow == null) || (localj.bow.length != 1) || (localj.bow[0] != 0L)) {
        break label528;
      }
    }
    label258:
    label515:
    label528:
    for (long l1 = x.b(localj.box[0], 1000L, localj.bot);; l1 = 0L)
    {
      localObject = paramb.boK;
      int[] arrayOfInt = paramb.boL;
      long[] arrayOfLong = paramb.boM;
      boolean[] arrayOfBoolean = paramb.boN;
      int i4;
      label285:
      int i2;
      label304:
      int i3;
      if ((localj.type == 2) && ((paramInt2 & 0x1) != 0))
      {
        paramInt2 = 1;
        i4 = paramInt3 + paramb.boJ[paramInt1];
        long l2 = localj.bot;
        if (paramInt1 > 0) {
          paramLong = paramb.boU;
        }
        if (paramInt3 >= i4) {
          break label515;
        }
        if (k == 0) {
          break label457;
        }
        i2 = paramm.xc();
        if (m == 0) {
          break label467;
        }
        i3 = paramm.xc();
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
      paramb.boU = paramLong;
      AppMethodBeat.o(92099);
      return i4;
    }
  }
  
  private static b a(com.google.android.exoplayer2.i.m paramm, SparseArray<b> paramSparseArray, int paramInt)
  {
    AppMethodBeat.i(92097);
    paramm.setPosition(8);
    int k = a.ej(paramm.readInt());
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
      long l = paramm.xe();
      paramSparseArray.bnE.boF = l;
      paramSparseArray.bnE.boG = l;
    }
    c localc = paramSparseArray.bnG;
    label125:
    int j;
    if ((k & 0x2) != 0)
    {
      paramInt = paramm.xc() - 1;
      if ((k & 0x8) == 0) {
        break label190;
      }
      i = paramm.xc();
      if ((k & 0x10) == 0) {
        break label199;
      }
      j = paramm.xc();
      label139:
      if ((k & 0x20) == 0) {
        break label209;
      }
    }
    label190:
    label199:
    label209:
    for (k = paramm.xc();; k = localc.flags)
    {
      paramSparseArray.bnE.boD = new c(paramInt, i, j, k);
      AppMethodBeat.o(92097);
      return paramSparseArray;
      paramInt = localc.bna;
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
    int j = parama.bmF.size();
    int i = 0;
    while (i < j)
    {
      a.a locala = (a.a)parama.bmF.get(i);
      if (locala.type == a.blz) {
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
    parama = parama.bmE;
    int i1 = parama.size();
    int j = 0;
    Object localObject;
    int m;
    if (j < i1)
    {
      localObject = (a.b)parama.get(j);
      if (((a.b)localObject).type != a.bln) {
        break label229;
      }
      localObject = ((a.b)localObject).bmG;
      ((com.google.android.exoplayer2.i.m)localObject).setPosition(12);
      m = ((com.google.android.exoplayer2.i.m)localObject).xc();
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
      paramb.bnJ = 0;
      paramb.bnI = 0;
      paramb.bnH = 0;
      paramb.bnE.bj(k, i);
      j = 0;
      k = 0;
      i = 0;
      while (i < i1)
      {
        localObject = (a.b)parama.get(i);
        int n = j;
        m = k;
        if (((a.b)localObject).type == a.bln)
        {
          m = a(paramb, j, paramLong, paramInt, ((a.b)localObject).bmG, k);
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
    int n = paramk.boB;
    paramm.setPosition(8);
    if ((a.ej(paramm.readInt()) & 0x1) == 1) {
      paramm.fa(8);
    }
    int i = paramm.readUnsignedByte();
    int m = paramm.xc();
    if (m != paraml.sampleCount)
    {
      paramk = new o("Length mismatch: " + m + ", " + paraml.sampleCount);
      AppMethodBeat.o(92095);
      throw paramk;
    }
    int k;
    if (i == 0)
    {
      paramk = paraml.boP;
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
      Arrays.fill(paraml.boP, 0, m, bool);
      paraml.ep(k);
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
    paramInt = a.ej(paramm.readInt());
    if ((paramInt & 0x1) != 0)
    {
      paramm = new o("Overriding TrackEncryptionBox parameters is unsupported.");
      AppMethodBeat.o(92101);
      throw paramm;
    }
    if ((paramInt & 0x2) != 0) {}
    for (boolean bool = true;; bool = false)
    {
      paramInt = paramm.xc();
      if (paramInt == paraml.sampleCount) {
        break;
      }
      paramm = new o("Length mismatch: " + paramInt + ", " + paraml.sampleCount);
      AppMethodBeat.o(92101);
      throw paramm;
    }
    Arrays.fill(paraml.boP, 0, paramInt, bool);
    paraml.ep(paramm.wV());
    paraml.q(paramm);
    AppMethodBeat.o(92101);
  }
  
  private static void a(com.google.android.exoplayer2.i.m paramm, l paraml)
  {
    AppMethodBeat.i(92096);
    paramm.setPosition(8);
    int i = paramm.readInt();
    if ((a.ej(i) & 0x1) == 1) {
      paramm.fa(8);
    }
    int j = paramm.xc();
    if (j != 1)
    {
      paramm = new o("Unexpected saio entry count: ".concat(String.valueOf(j)));
      AppMethodBeat.o(92096);
      throw paramm;
    }
    i = a.ei(i);
    long l2 = paraml.boG;
    if (i == 0) {}
    for (long l1 = paramm.dB();; l1 = paramm.xe())
    {
      paraml.boG = (l1 + l2);
      AppMethodBeat.o(92096);
      return;
    }
  }
  
  private static void a(com.google.android.exoplayer2.i.m paramm, l paraml, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(92100);
    paramm.setPosition(8);
    paramm.readBytes(paramArrayOfByte, 0, 16);
    if (!Arrays.equals(paramArrayOfByte, bnf))
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
    if (paramm1.readInt() != bne)
    {
      AppMethodBeat.o(92102);
      return;
    }
    if (a.ei(i) == 1) {
      paramm1.fa(4);
    }
    if (paramm1.readInt() != 1)
    {
      paramm1 = new o("Entry count in sbgp != 1 (unsupported).");
      AppMethodBeat.o(92102);
      throw paramm1;
    }
    paramm2.setPosition(8);
    i = paramm2.readInt();
    if (paramm2.readInt() != bne)
    {
      AppMethodBeat.o(92102);
      return;
    }
    i = a.ei(i);
    if (i == 1)
    {
      if (paramm2.dB() == 0L)
      {
        paramm1 = new o("Variable length description in sgpd found (unsupported)");
        AppMethodBeat.o(92102);
        throw paramm1;
      }
    }
    else if (i >= 2) {
      paramm2.fa(4);
    }
    if (paramm2.dB() != 1L)
    {
      paramm1 = new o("Entry count in sgpd != 1 (unsupported).");
      AppMethodBeat.o(92102);
      throw paramm1;
    }
    paramm2.fa(1);
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
    paraml.boO = true;
    paraml.boQ = new k(true, paramString, i, arrayOfByte, (j & 0xF0) >> 4, j & 0xF, paramm1);
    AppMethodBeat.o(92102);
  }
  
  private static void b(a.a parama, SparseArray<b> paramSparseArray, int paramInt, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(92093);
    paramSparseArray = a(parama.el(a.bll).bmG, paramSparseArray, paramInt);
    if (paramSparseArray == null)
    {
      AppMethodBeat.o(92093);
      return;
    }
    l locall = paramSparseArray.bnE;
    long l2 = locall.boU;
    paramSparseArray.reset();
    long l1 = l2;
    if (parama.el(a.blk) != null)
    {
      l1 = l2;
      if ((paramInt & 0x2) == 0) {
        l1 = n(parama.el(a.blk).bmG);
      }
    }
    a(parama, paramSparseArray, l1, paramInt);
    paramSparseArray = paramSparseArray.bnF.eo(locall.boD.bna);
    Object localObject1 = parama.el(a.blQ);
    if (localObject1 != null) {
      a(paramSparseArray, ((a.b)localObject1).bmG, locall);
    }
    localObject1 = parama.el(a.blR);
    if (localObject1 != null) {
      a(((a.b)localObject1).bmG, locall);
    }
    localObject1 = parama.el(a.blV);
    if (localObject1 != null) {
      a(((a.b)localObject1).bmG, 0, locall);
    }
    localObject1 = parama.el(a.blS);
    Object localObject2 = parama.el(a.blT);
    if ((localObject1 != null) && (localObject2 != null))
    {
      localObject1 = ((a.b)localObject1).bmG;
      localObject2 = ((a.b)localObject2).bmG;
      if (paramSparseArray == null) {
        break label308;
      }
    }
    label308:
    for (paramSparseArray = paramSparseArray.boA;; paramSparseArray = null)
    {
      a((com.google.android.exoplayer2.i.m)localObject1, (com.google.android.exoplayer2.i.m)localObject2, paramSparseArray, locall);
      int i = parama.bmE.size();
      paramInt = 0;
      while (paramInt < i)
      {
        paramSparseArray = (a.b)parama.bmE.get(paramInt);
        if (paramSparseArray.type == a.blU) {
          a(paramSparseArray.bmG, locall, paramArrayOfByte);
        }
        paramInt += 1;
      }
    }
    AppMethodBeat.o(92093);
  }
  
  private void c(a.a parama)
  {
    AppMethodBeat.i(92086);
    if (parama.type == a.blp)
    {
      d(parama);
      AppMethodBeat.o(92086);
      return;
    }
    if (parama.type == a.bly)
    {
      e(parama);
      AppMethodBeat.o(92086);
      return;
    }
    if (!this.bnp.isEmpty()) {
      ((a.a)this.bnp.peek()).a(parama);
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
    if (this.bng == null)
    {
      bool1 = true;
      com.google.android.exoplayer2.i.a.checkState(bool1, "Unexpected moov box.");
      localObject1 = t(parama.bmE);
      localObject2 = parama.em(a.blA);
      localSparseArray = new SparseArray();
      l = -9223372036854775807L;
      m = ((a.a)localObject2).bmE.size();
      i = 0;
      if (i >= m) {
        break label179;
      }
      localObject3 = (a.b)((a.a)localObject2).bmE.get(i);
      if (((a.b)localObject3).type != a.blm) {
        break label155;
      }
      localObject3 = l(((a.b)localObject3).bmG);
      localSparseArray.put(((Integer)((Pair)localObject3).first).intValue(), ((Pair)localObject3).second);
    }
    for (;;)
    {
      i += 1;
      break label78;
      bool1 = false;
      break;
      label155:
      if (((a.b)localObject3).type == a.blB) {
        l = m(((a.b)localObject3).bmG);
      }
    }
    label179:
    Object localObject2 = new SparseArray();
    int m = parama.bmF.size();
    int i = 0;
    if (i < m)
    {
      localObject3 = (a.a)parama.bmF.get(i);
      a.b localb;
      if (((a.a)localObject3).type == a.blr)
      {
        localb = parama.el(a.blq);
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
    if (this.bnh.size() == 0)
    {
      i = j;
      while (i < m)
      {
        parama = (j)((SparseArray)localObject2).valueAt(i);
        localObject1 = new b(this.biu.eb(i));
        ((b)localObject1).a(parama, (c)localSparseArray.get(parama.id));
        this.bnh.put(parama.id, localObject1);
        this.bdM = Math.max(this.bdM, parama.bdM);
        i += 1;
      }
      uB();
      this.biu.ut();
      AppMethodBeat.o(92087);
      return;
    }
    if (this.bnh.size() == m) {}
    for (boolean bool1 = bool2;; bool1 = false)
    {
      com.google.android.exoplayer2.i.a.checkState(bool1);
      i = k;
      while (i < m)
      {
        parama = (j)((SparseArray)localObject2).valueAt(i);
        ((b)this.bnh.get(parama.id)).a(parama, (c)localSparseArray.get(parama.id));
        i += 1;
      }
    }
    AppMethodBeat.o(92087);
  }
  
  private void e(a.a parama)
  {
    AppMethodBeat.i(92088);
    a(parama, this.bnh, this.flags, this.bno);
    parama = t(parama.bmE);
    if (parama != null)
    {
      int j = this.bnh.size();
      int i = 0;
      while (i < j)
      {
        ((b)this.bnh.valueAt(i)).b(parama);
        i += 1;
      }
    }
    AppMethodBeat.o(92088);
  }
  
  private static Pair<Integer, c> l(com.google.android.exoplayer2.i.m paramm)
  {
    AppMethodBeat.i(92090);
    paramm.setPosition(12);
    paramm = Pair.create(Integer.valueOf(paramm.readInt()), new c(paramm.xc() - 1, paramm.xc(), paramm.xc(), paramm.readInt()));
    AppMethodBeat.o(92090);
    return paramm;
  }
  
  private static long m(com.google.android.exoplayer2.i.m paramm)
  {
    AppMethodBeat.i(92091);
    paramm.setPosition(8);
    if (a.ei(paramm.readInt()) == 0)
    {
      l = paramm.dB();
      AppMethodBeat.o(92091);
      return l;
    }
    long l = paramm.xe();
    AppMethodBeat.o(92091);
    return l;
  }
  
  private static long n(com.google.android.exoplayer2.i.m paramm)
  {
    AppMethodBeat.i(92098);
    paramm.setPosition(8);
    if (a.ei(paramm.readInt()) == 1)
    {
      l = paramm.xe();
      AppMethodBeat.o(92098);
      return l;
    }
    long l = paramm.dB();
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
      if (((a.b)localObject4).type == a.blI)
      {
        Object localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = new ArrayList();
        }
        localObject2 = ((a.b)localObject4).bmG.data;
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
  
  private void uA()
  {
    this.biv = 0;
    this.bnt = 0;
  }
  
  private void uB()
  {
    AppMethodBeat.i(92089);
    if (((this.flags & 0x4) != 0) && (this.bnA == null))
    {
      this.bnA = this.biu.eb(this.bnh.size());
      this.bnA.f(Format.c("application/x-emsg", 9223372036854775807L));
    }
    if (((this.flags & 0x8) != 0) && (this.bnB == null))
    {
      com.google.android.exoplayer2.c.m localm = this.biu.eb(this.bnh.size() + 1);
      localm.f(Format.bc("application/cea-608"));
      this.bnB = new com.google.android.exoplayer2.c.m[] { localm };
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
      switch (this.biv)
      {
      default: 
        if (this.biv != 3) {
          break label2075;
        }
        if (this.bny != null) {
          break;
        }
        localObject2 = this.bnh;
        paramk = null;
        l1 = 9223372036854775807L;
        j = ((SparseArray)localObject2).size();
        i = 0;
        while (i < j)
        {
          localObject1 = (b)((SparseArray)localObject2).valueAt(i);
          if (((b)localObject1).bnJ == ((b)localObject1).bnE.boH) {
            break label2911;
          }
          l2 = localObject1.bnE.boI[localObject1.bnJ];
          if (l2 >= l1) {
            break label2911;
          }
          l1 = l2;
          paramk = (com.google.android.exoplayer2.c.k)localObject1;
          i += 1;
        }
      case 0: 
        if (this.bnt != 0) {
          break label221;
        }
        if (paramf.a(this.bnn.data, 0, 8, true)) {
          break label185;
        }
        i = 0;
      }
    } while (i != 0);
    AppMethodBeat.o(92084);
    return -1;
    label185:
    this.bnt = 8;
    this.bnn.setPosition(0);
    this.bns = this.bnn.dB();
    this.bnr = this.bnn.readInt();
    label221:
    if (this.bns == 1L)
    {
      paramf.readFully(this.bnn.data, 8, 8);
      this.bnt += 8;
      this.bns = this.bnn.xe();
    }
    while (this.bns < this.bnt)
    {
      paramf = new o("Atom size less than header length (unsupported).");
      AppMethodBeat.o(92084);
      throw paramf;
      if (this.bns == 0L)
      {
        l2 = paramf.getLength();
        l1 = l2;
        if (l2 == -1L)
        {
          l1 = l2;
          if (!this.bnp.isEmpty()) {
            l1 = ((a.a)this.bnp.peek()).bmD;
          }
        }
        if (l1 != -1L) {
          this.bns = (l1 - paramf.getPosition() + this.bnt);
        }
      }
    }
    long l1 = paramf.getPosition() - this.bnt;
    if (this.bnr == a.bly)
    {
      j = this.bnh.size();
      i = 0;
      while (i < j)
      {
        paramk = ((b)this.bnh.valueAt(i)).bnE;
        paramk.boE = l1;
        paramk.boG = l1;
        paramk.boF = l1;
        i += 1;
      }
    }
    if (this.bnr == a.bkV)
    {
      this.bny = null;
      this.bnv = (this.bns + l1);
      if (!this.bnC)
      {
        this.biu.a(new l.a(this.bdM));
        this.bnC = true;
      }
      this.biv = 2;
    }
    for (;;)
    {
      i = 1;
      break;
      i = this.bnr;
      if ((i == a.blp) || (i == a.blr) || (i == a.bls) || (i == a.blt) || (i == a.blu) || (i == a.bly) || (i == a.blz) || (i == a.blA) || (i == a.blD)) {
        i = 1;
      }
      for (;;)
      {
        if (i != 0)
        {
          l1 = paramf.getPosition() + this.bns - 8L;
          this.bnp.add(new a.a(this.bnr, l1));
          if (this.bns == this.bnt)
          {
            O(l1);
            break;
            i = 0;
            continue;
          }
          uA();
          break;
        }
      }
      i = this.bnr;
      if ((i == a.blG) || (i == a.blF) || (i == a.blq) || (i == a.blo) || (i == a.blH) || (i == a.blk) || (i == a.bll) || (i == a.blC) || (i == a.blm) || (i == a.bln) || (i == a.blI) || (i == a.blQ) || (i == a.blR) || (i == a.blV) || (i == a.blU) || (i == a.blS) || (i == a.blT) || (i == a.blE) || (i == a.blB) || (i == a.bmu)) {
        i = 1;
      }
      for (;;)
      {
        if (i != 0) {
          if (this.bnt != 8)
          {
            paramf = new o("Leaf atom defines extended atom size (unsupported).");
            AppMethodBeat.o(92084);
            throw paramf;
            i = 0;
          }
          else
          {
            if (this.bns > 2147483647L)
            {
              paramf = new o("Leaf atom with length > 2147483647 (unsupported).");
              AppMethodBeat.o(92084);
              throw paramf;
            }
            this.bnu = new com.google.android.exoplayer2.i.m((int)this.bns);
            System.arraycopy(this.bnn.data, 0, this.bnu.data, 0, 8);
            this.biv = 1;
            break;
          }
        }
      }
      if (this.bns > 2147483647L)
      {
        paramf = new o("Skipping atom with length > 2147483647 (unsupported).");
        AppMethodBeat.o(92084);
        throw paramf;
      }
      this.bnu = null;
      this.biv = 1;
    }
    int i = (int)this.bns - this.bnt;
    if (this.bnu != null)
    {
      paramf.readFully(this.bnu.data, 8, i);
      paramk = new a.b(this.bnr, this.bnu);
      l2 = paramf.getPosition();
      if (!this.bnp.isEmpty()) {
        ((a.a)this.bnp.peek()).a(paramk);
      }
    }
    Object localObject3;
    Object localObject4;
    int k;
    for (;;)
    {
      O(paramf.getPosition());
      break;
      if (paramk.type == a.blo)
      {
        paramk = paramk.bmG;
        paramk.setPosition(8);
        i = a.ei(paramk.readInt());
        paramk.fa(4);
        long l5 = paramk.dB();
        long l4;
        long l3;
        if (i == 0)
        {
          l1 = paramk.dB();
          l2 += paramk.dB();
          l4 = x.b(l1, 1000000L, l5);
          paramk.fa(2);
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
            l1 = paramk.xe();
            l2 += paramk.xe();
            break;
          }
          long l6 = paramk.dB();
          localObject1[i] = (k & 0x7FFFFFFF);
          localObject2[i] = l2;
          localObject4[i] = l3;
          l1 += l6;
          l3 = x.b(l1, 1000000L, l5);
          localObject3[i] = (l3 - localObject4[i]);
          paramk.fa(4);
          l2 += localObject1[i];
          i += 1;
        }
        label1333:
        paramk = Pair.create(Long.valueOf(l4), new com.google.android.exoplayer2.c.a((int[])localObject1, (long[])localObject2, (long[])localObject3, (long[])localObject4));
        this.bnx = ((Long)paramk.first).longValue();
        this.biu.a((com.google.android.exoplayer2.c.l)paramk.second);
        this.bnC = true;
      }
      else if (paramk.type == a.bmu)
      {
        paramk = paramk.bmG;
        if (this.bnA != null)
        {
          paramk.setPosition(12);
          paramk.xf();
          paramk.xf();
          l1 = paramk.dB();
          l1 = x.b(paramk.dB(), 1000000L, l1);
          paramk.setPosition(12);
          i = paramk.wV();
          this.bnA.a(paramk, i);
          if (this.bnx != -9223372036854775807L)
          {
            this.bnA.a(l1 + this.bnx, 1, i, 0, null);
          }
          else
          {
            this.bnq.addLast(new a(l1, i));
            this.bnw += i;
            continue;
            paramf.dU(i);
          }
        }
      }
    }
    paramk = null;
    l1 = 9223372036854775807L;
    int j = this.bnh.size();
    i = 0;
    label1567:
    if (i < j)
    {
      localObject1 = ((b)this.bnh.valueAt(i)).bnE;
      if ((!((l)localObject1).boT) || (((l)localObject1).boG >= l1)) {
        break label2914;
      }
      l1 = ((l)localObject1).boG;
      paramk = (b)this.bnh.valueAt(i);
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
        this.biv = 3;
        break;
      }
      i = (int)(l1 - paramf.getPosition());
      if (i < 0)
      {
        paramf = new o("Offset to encryption data was negative.");
        AppMethodBeat.o(92084);
        throw paramf;
      }
      paramf.dU(i);
      paramk = paramk.bnE;
      paramf.readFully(paramk.boS.data, 0, paramk.boR);
      paramk.boS.setPosition(0);
      paramk.boT = false;
      break;
      if (paramk == null)
      {
        i = (int)(this.bnv - paramf.getPosition());
        if (i < 0)
        {
          paramf = new o("Offset to end of mdat was negative.");
          AppMethodBeat.o(92084);
          throw paramf;
        }
        paramf.dU(i);
        uA();
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
        j = (int)(paramk.bnE.boI[paramk.bnJ] - paramf.getPosition());
        i = j;
        if (j < 0) {
          i = 0;
        }
        paramf.dU(i);
        this.bny = paramk;
        this.sampleSize = this.bny.bnE.boK[this.bny.bnH];
        label2032:
        int n;
        if (this.bny.bnE.boO)
        {
          localObject3 = this.bny;
          localObject2 = ((b)localObject3).bnE;
          i = ((l)localObject2).boD.bna;
          if (((l)localObject2).boQ != null)
          {
            paramk = ((l)localObject2).boQ;
            if (paramk.boB == 0) {
              break label2309;
            }
            localObject1 = ((l)localObject2).boS;
            i = paramk.boB;
            paramk = (com.google.android.exoplayer2.c.k)localObject1;
            i2 = localObject2.boP[localObject3.bnH];
            localObject1 = this.bnk.data;
            if (i2 == 0) {
              break label2339;
            }
            j = 128;
            localObject1[0] = ((byte)(j | i));
            this.bnk.setPosition(0);
            localObject1 = ((b)localObject3).biD;
            ((com.google.android.exoplayer2.c.m)localObject1).a(this.bnk, 1);
            ((com.google.android.exoplayer2.c.m)localObject1).a(paramk, i);
            if (i2 != 0) {
              break label2345;
            }
            i += 1;
            this.bjN = i;
            this.sampleSize += this.bjN;
            if (this.bny.bnF.bov == 1)
            {
              this.sampleSize -= 8;
              paramf.dU(8);
            }
            this.biv = 4;
            this.bjM = 0;
            localObject1 = this.bny.bnE;
            localObject3 = this.bny.bnF;
            localObject2 = this.bny.biD;
            k = this.bny.bnH;
            if (((j)localObject3).biG == 0) {
              break label2592;
            }
            paramk = this.bni.data;
            paramk[0] = 0;
            paramk[1] = 0;
            paramk[2] = 0;
            int m = ((j)localObject3).biG;
            n = 4 - ((j)localObject3).biG;
            label2155:
            if (this.bjN >= this.sampleSize) {
              break label2633;
            }
            if (this.bjM != 0) {
              break label2406;
            }
            paramf.readFully(paramk, n, m + 1);
            this.bni.setPosition(0);
            this.bjM = (this.bni.xc() - 1);
            this.biE.setPosition(0);
            ((com.google.android.exoplayer2.c.m)localObject2).a(this.biE, 4);
            ((com.google.android.exoplayer2.c.m)localObject2).a(this.bni, 1);
            if ((this.bnB == null) || (!com.google.android.exoplayer2.i.k.b(((j)localObject3).bdI.bdt, paramk[4]))) {
              break label2400;
            }
          }
        }
        for (int i2 = 1;; i2 = 0)
        {
          this.bnz = i2;
          this.bjN += 5;
          this.sampleSize += n;
          break label2155;
          paramk = ((b)localObject3).bnF.eo(i);
          break;
          localObject1 = paramk.boC;
          this.bnl.n((byte[])localObject1, localObject1.length);
          paramk = this.bnl;
          i = localObject1.length;
          break label1928;
          j = 0;
          break label1960;
          paramk = ((l)localObject2).boS;
          j = paramk.readUnsignedShort();
          paramk.fa(-2);
          j = j * 6 + 2;
          ((com.google.android.exoplayer2.c.m)localObject1).a(paramk, j);
          i = i + 1 + j;
          break label2014;
          this.bjN = 0;
          break label2032;
        }
        label2406:
        if (this.bnz)
        {
          this.bnj.reset(this.bjM);
          paramf.readFully(this.bnj.data, 0, this.bjM);
          ((com.google.android.exoplayer2.c.m)localObject2).a(this.bnj, this.bjM);
          j = this.bjM;
          int i1 = com.google.android.exoplayer2.i.k.j(this.bnj.data, this.bnj.limit);
          localObject4 = this.bnj;
          if ("video/hevc".equals(((j)localObject3).bdI.bdt))
          {
            i = 1;
            ((com.google.android.exoplayer2.i.m)localObject4).setPosition(i);
            this.bnj.eZ(i1);
            com.google.android.exoplayer2.f.a.g.a(((l)localObject1).eq(k) * 1000L, this.bnj, this.bnB);
          }
        }
        for (i = j;; i = ((com.google.android.exoplayer2.c.m)localObject2).a(paramf, this.bjM, false))
        {
          this.bjN += i;
          this.bjM -= i;
          break;
          i = 0;
          break label2507;
        }
        while (this.bjN < this.sampleSize) {
          this.bjN = (((com.google.android.exoplayer2.c.m)localObject2).a(paramf, this.sampleSize - this.bjN, false) + this.bjN);
        }
        l2 = ((l)localObject1).eq(k) * 1000L;
        l1 = l2;
        if (this.bnm != null) {
          l1 = this.bnm.ap(l2);
        }
        if (localObject1.boN[k] != 0)
        {
          i = 1;
          paramk = null;
          if (!((l)localObject1).boO) {
            break label2908;
          }
          i = 0x40000000 | i;
          if (((l)localObject1).boQ == null) {
            break label2800;
          }
          paramk = ((l)localObject1).boQ;
          paramk = paramk.bjV;
        }
      }
      for (;;)
      {
        ((com.google.android.exoplayer2.c.m)localObject2).a(l1, i, this.sampleSize, 0, paramk);
        for (;;)
        {
          if (!this.bnq.isEmpty())
          {
            paramk = (a)this.bnq.removeFirst();
            this.bnw -= paramk.size;
            this.bnA.a(paramk.bnD + l1, 1, paramk.size, this.bnw, null);
            continue;
            i = 0;
            break;
            label2800:
            paramk = ((j)localObject3).eo(((l)localObject1).boD.bna);
            break label2711;
          }
        }
        paramk = this.bny;
        paramk.bnH += 1;
        paramk = this.bny;
        paramk.bnI += 1;
        if (this.bny.bnI == localObject1.boJ[this.bny.bnJ])
        {
          paramk = this.bny;
          paramk.bnJ += 1;
          this.bny.bnI = 0;
          this.bny = null;
        }
        this.biv = 3;
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
    this.biu = paramg;
    if (this.bng != null)
    {
      paramg = new b(paramg.eb(0));
      paramg.a(this.bng, new c(0, 0, 0, 0));
      this.bnh.put(0, paramg);
      uB();
      this.biu.ut();
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
    int j = this.bnh.size();
    int i = 0;
    while (i < j)
    {
      ((b)this.bnh.valueAt(i)).reset();
      i += 1;
    }
    this.bnq.clear();
    this.bnw = 0;
    this.bnp.clear();
    uA();
    AppMethodBeat.o(92083);
  }
  
  static final class a
  {
    public final long bnD;
    public final int size;
    
    public a(long paramLong, int paramInt)
    {
      this.bnD = paramLong;
      this.size = paramInt;
    }
  }
  
  static final class b
  {
    public final com.google.android.exoplayer2.c.m biD;
    public final l bnE;
    public j bnF;
    public c bnG;
    public int bnH;
    public int bnI;
    public int bnJ;
    
    public b(com.google.android.exoplayer2.c.m paramm)
    {
      AppMethodBeat.i(92076);
      this.bnE = new l();
      this.biD = paramm;
      AppMethodBeat.o(92076);
    }
    
    public final void a(j paramj, c paramc)
    {
      AppMethodBeat.i(92077);
      this.bnF = ((j)com.google.android.exoplayer2.i.a.checkNotNull(paramj));
      this.bnG = ((c)com.google.android.exoplayer2.i.a.checkNotNull(paramc));
      this.biD.f(paramj.bdI);
      reset();
      AppMethodBeat.o(92077);
    }
    
    public final void b(DrmInitData paramDrmInitData)
    {
      AppMethodBeat.i(92079);
      Object localObject = this.bnF.eo(this.bnE.boD.bna);
      if (localObject != null) {}
      for (localObject = ((k)localObject).boA;; localObject = null)
      {
        this.biD.f(this.bnF.bdI.a(paramDrmInitData.bg((String)localObject)));
        AppMethodBeat.o(92079);
        return;
      }
    }
    
    public final void reset()
    {
      AppMethodBeat.i(92078);
      this.bnE.reset();
      this.bnH = 0;
      this.bnJ = 0;
      this.bnI = 0;
      AppMethodBeat.o(92078);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.google.android.exoplayer2.c.d.e
 * JD-Core Version:    0.7.0.1
 */