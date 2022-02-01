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
  public static final com.google.android.exoplayer2.c.h aXh;
  private static final int bbX;
  private static final byte[] bbY;
  private long aSz;
  private com.google.android.exoplayer2.c.g aXn;
  private int aXo;
  private final com.google.android.exoplayer2.i.m aXx;
  private int aYF;
  private int aYG;
  private final j bbZ;
  private final SparseArray<b> bca;
  private final com.google.android.exoplayer2.i.m bcb;
  private final com.google.android.exoplayer2.i.m bcc;
  private final com.google.android.exoplayer2.i.m bcd;
  private final com.google.android.exoplayer2.i.m bce;
  private final u bcf;
  private final com.google.android.exoplayer2.i.m bcg;
  private final byte[] bch;
  private final Stack<a.a> bci;
  private final LinkedList<a> bcj;
  private int bck;
  private long bcl;
  private int bcm;
  private com.google.android.exoplayer2.i.m bcn;
  private long bco;
  private int bcp;
  private long bcq;
  private b bcr;
  private boolean bcs;
  private com.google.android.exoplayer2.c.m bct;
  private com.google.android.exoplayer2.c.m[] bcu;
  private boolean bcv;
  private final int flags;
  private int sampleSize;
  
  static
  {
    AppMethodBeat.i(92104);
    aXh = new com.google.android.exoplayer2.c.h()
    {
      public final com.google.android.exoplayer2.c.e[] sK()
      {
        AppMethodBeat.i(92075);
        e locale = new e();
        AppMethodBeat.o(92075);
        return new com.google.android.exoplayer2.c.e[] { locale };
      }
    };
    bbX = x.aY("seig");
    bbY = new byte[] { -94, 57, 79, 82, 90, -101, 79, 20, -94, 68, 108, 66, 124, 100, -115, -12 };
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
    this(paramInt, paramu, null);
  }
  
  public e(int paramInt, u paramu, j paramj)
  {
    AppMethodBeat.i(92080);
    if (paramj != null) {}
    for (int i = 16;; i = 0)
    {
      this.flags = (i | paramInt);
      this.bcf = paramu;
      this.bbZ = paramj;
      this.bcg = new com.google.android.exoplayer2.i.m(16);
      this.aXx = new com.google.android.exoplayer2.i.m(com.google.android.exoplayer2.i.k.byG);
      this.bcb = new com.google.android.exoplayer2.i.m(5);
      this.bcc = new com.google.android.exoplayer2.i.m();
      this.bcd = new com.google.android.exoplayer2.i.m(1);
      this.bce = new com.google.android.exoplayer2.i.m();
      this.bch = new byte[16];
      this.bci = new Stack();
      this.bcj = new LinkedList();
      this.bca = new SparseArray();
      this.aSz = -9223372036854775807L;
      this.bcq = -9223372036854775807L;
      sS();
      AppMethodBeat.o(92080);
      return;
    }
  }
  
  private void N(long paramLong)
  {
    AppMethodBeat.i(92085);
    while ((!this.bci.isEmpty()) && (((a.a)this.bci.peek()).bbw == paramLong)) {
      c((a.a)this.bci.pop());
    }
    sS();
    AppMethodBeat.o(92085);
  }
  
  private static int a(b paramb, int paramInt1, long paramLong, int paramInt2, com.google.android.exoplayer2.i.m paramm, int paramInt3)
  {
    AppMethodBeat.i(92099);
    paramm.setPosition(8);
    int i1 = a.ef(paramm.readInt());
    j localj = paramb.bcy;
    paramb = paramb.bcx;
    c localc = paramb.bdw;
    paramb.bdC[paramInt1] = paramm.vQ();
    paramb.bdB[paramInt1] = paramb.bdy;
    Object localObject;
    if ((i1 & 0x1) != 0)
    {
      localObject = paramb.bdB;
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
        i = paramm.vQ();
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
      if ((localj.bdp == null) || (localj.bdp.length != 1) || (localj.bdp[0] != 0L)) {
        break label528;
      }
    }
    label258:
    label515:
    label528:
    for (long l1 = x.b(localj.bdq[0], 1000L, localj.bdm);; l1 = 0L)
    {
      localObject = paramb.bdD;
      int[] arrayOfInt = paramb.bdE;
      long[] arrayOfLong = paramb.bdF;
      boolean[] arrayOfBoolean = paramb.bdG;
      int i4;
      label285:
      int i2;
      label304:
      int i3;
      if ((localj.type == 2) && ((paramInt2 & 0x1) != 0))
      {
        paramInt2 = 1;
        i4 = paramInt3 + paramb.bdC[paramInt1];
        long l2 = localj.bdm;
        if (paramInt1 > 0) {
          paramLong = paramb.bdN;
        }
        if (paramInt3 >= i4) {
          break label515;
        }
        if (k == 0) {
          break label457;
        }
        i2 = paramm.vQ();
        if (m == 0) {
          break label467;
        }
        i3 = paramm.vQ();
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
      paramb.bdN = paramLong;
      AppMethodBeat.o(92099);
      return i4;
    }
  }
  
  private static b a(com.google.android.exoplayer2.i.m paramm, SparseArray<b> paramSparseArray, int paramInt)
  {
    AppMethodBeat.i(92097);
    paramm.setPosition(8);
    int k = a.ef(paramm.readInt());
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
      long l = paramm.vS();
      paramSparseArray.bcx.bdy = l;
      paramSparseArray.bcx.bdz = l;
    }
    c localc = paramSparseArray.bcz;
    label125:
    int j;
    if ((k & 0x2) != 0)
    {
      paramInt = paramm.vQ() - 1;
      if ((k & 0x8) == 0) {
        break label190;
      }
      i = paramm.vQ();
      if ((k & 0x10) == 0) {
        break label199;
      }
      j = paramm.vQ();
      label139:
      if ((k & 0x20) == 0) {
        break label209;
      }
    }
    label190:
    label199:
    label209:
    for (k = paramm.vQ();; k = localc.flags)
    {
      paramSparseArray.bcx.bdw = new c(paramInt, i, j, k);
      AppMethodBeat.o(92097);
      return paramSparseArray;
      paramInt = localc.bbT;
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
    int j = parama.bby.size();
    int i = 0;
    while (i < j)
    {
      a.a locala = (a.a)parama.bby.get(i);
      if (locala.type == a.bas) {
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
    parama = parama.bbx;
    int i1 = parama.size();
    int j = 0;
    Object localObject;
    int m;
    if (j < i1)
    {
      localObject = (a.b)parama.get(j);
      if (((a.b)localObject).type != a.bag) {
        break label229;
      }
      localObject = ((a.b)localObject).bbz;
      ((com.google.android.exoplayer2.i.m)localObject).setPosition(12);
      m = ((com.google.android.exoplayer2.i.m)localObject).vQ();
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
      paramb.bcC = 0;
      paramb.bcB = 0;
      paramb.bcA = 0;
      paramb.bcx.bi(k, i);
      j = 0;
      k = 0;
      i = 0;
      while (i < i1)
      {
        localObject = (a.b)parama.get(i);
        int n = j;
        m = k;
        if (((a.b)localObject).type == a.bag)
        {
          m = a(paramb, j, paramLong, paramInt, ((a.b)localObject).bbz, k);
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
    int n = paramk.bdu;
    paramm.setPosition(8);
    if ((a.ef(paramm.readInt()) & 0x1) == 1) {
      paramm.fl(8);
    }
    int i = paramm.readUnsignedByte();
    int m = paramm.vQ();
    if (m != paraml.sampleCount)
    {
      paramk = new o("Length mismatch: " + m + ", " + paraml.sampleCount);
      AppMethodBeat.o(92095);
      throw paramk;
    }
    int k;
    if (i == 0)
    {
      paramk = paraml.bdI;
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
      Arrays.fill(paraml.bdI, 0, m, bool);
      paraml.el(k);
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
    paramInt = a.ef(paramm.readInt());
    if ((paramInt & 0x1) != 0)
    {
      paramm = new o("Overriding TrackEncryptionBox parameters is unsupported.");
      AppMethodBeat.o(92101);
      throw paramm;
    }
    if ((paramInt & 0x2) != 0) {}
    for (boolean bool = true;; bool = false)
    {
      paramInt = paramm.vQ();
      if (paramInt == paraml.sampleCount) {
        break;
      }
      paramm = new o("Length mismatch: " + paramInt + ", " + paraml.sampleCount);
      AppMethodBeat.o(92101);
      throw paramm;
    }
    Arrays.fill(paraml.bdI, 0, paramInt, bool);
    paraml.el(paramm.vJ());
    paraml.q(paramm);
    AppMethodBeat.o(92101);
  }
  
  private static void a(com.google.android.exoplayer2.i.m paramm, l paraml)
  {
    AppMethodBeat.i(92096);
    paramm.setPosition(8);
    int i = paramm.readInt();
    if ((a.ef(i) & 0x1) == 1) {
      paramm.fl(8);
    }
    int j = paramm.vQ();
    if (j != 1)
    {
      paramm = new o("Unexpected saio entry count: ".concat(String.valueOf(j)));
      AppMethodBeat.o(92096);
      throw paramm;
    }
    i = a.ee(i);
    long l2 = paraml.bdz;
    if (i == 0) {}
    for (long l1 = paramm.df();; l1 = paramm.vS())
    {
      paraml.bdz = (l1 + l2);
      AppMethodBeat.o(92096);
      return;
    }
  }
  
  private static void a(com.google.android.exoplayer2.i.m paramm, l paraml, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(92100);
    paramm.setPosition(8);
    paramm.readBytes(paramArrayOfByte, 0, 16);
    if (!Arrays.equals(paramArrayOfByte, bbY))
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
    if (paramm1.readInt() != bbX)
    {
      AppMethodBeat.o(92102);
      return;
    }
    if (a.ee(i) == 1) {
      paramm1.fl(4);
    }
    if (paramm1.readInt() != 1)
    {
      paramm1 = new o("Entry count in sbgp != 1 (unsupported).");
      AppMethodBeat.o(92102);
      throw paramm1;
    }
    paramm2.setPosition(8);
    i = paramm2.readInt();
    if (paramm2.readInt() != bbX)
    {
      AppMethodBeat.o(92102);
      return;
    }
    i = a.ee(i);
    if (i == 1)
    {
      if (paramm2.df() == 0L)
      {
        paramm1 = new o("Variable length description in sgpd found (unsupported)");
        AppMethodBeat.o(92102);
        throw paramm1;
      }
    }
    else if (i >= 2) {
      paramm2.fl(4);
    }
    if (paramm2.df() != 1L)
    {
      paramm1 = new o("Entry count in sgpd != 1 (unsupported).");
      AppMethodBeat.o(92102);
      throw paramm1;
    }
    paramm2.fl(1);
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
    paraml.bdH = true;
    paraml.bdJ = new k(true, paramString, i, arrayOfByte, (j & 0xF0) >> 4, j & 0xF, paramm1);
    AppMethodBeat.o(92102);
  }
  
  private static void b(a.a parama, SparseArray<b> paramSparseArray, int paramInt, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(92093);
    paramSparseArray = a(parama.eh(a.bae).bbz, paramSparseArray, paramInt);
    if (paramSparseArray == null)
    {
      AppMethodBeat.o(92093);
      return;
    }
    l locall = paramSparseArray.bcx;
    long l2 = locall.bdN;
    paramSparseArray.reset();
    long l1 = l2;
    if (parama.eh(a.bad) != null)
    {
      l1 = l2;
      if ((paramInt & 0x2) == 0) {
        l1 = n(parama.eh(a.bad).bbz);
      }
    }
    a(parama, paramSparseArray, l1, paramInt);
    paramSparseArray = paramSparseArray.bcy.ek(locall.bdw.bbT);
    Object localObject1 = parama.eh(a.baJ);
    if (localObject1 != null) {
      a(paramSparseArray, ((a.b)localObject1).bbz, locall);
    }
    localObject1 = parama.eh(a.baK);
    if (localObject1 != null) {
      a(((a.b)localObject1).bbz, locall);
    }
    localObject1 = parama.eh(a.baO);
    if (localObject1 != null) {
      a(((a.b)localObject1).bbz, 0, locall);
    }
    localObject1 = parama.eh(a.baL);
    Object localObject2 = parama.eh(a.baM);
    if ((localObject1 != null) && (localObject2 != null))
    {
      localObject1 = ((a.b)localObject1).bbz;
      localObject2 = ((a.b)localObject2).bbz;
      if (paramSparseArray == null) {
        break label308;
      }
    }
    label308:
    for (paramSparseArray = paramSparseArray.bdt;; paramSparseArray = null)
    {
      a((com.google.android.exoplayer2.i.m)localObject1, (com.google.android.exoplayer2.i.m)localObject2, paramSparseArray, locall);
      int i = parama.bbx.size();
      paramInt = 0;
      while (paramInt < i)
      {
        paramSparseArray = (a.b)parama.bbx.get(paramInt);
        if (paramSparseArray.type == a.baN) {
          a(paramSparseArray.bbz, locall, paramArrayOfByte);
        }
        paramInt += 1;
      }
    }
    AppMethodBeat.o(92093);
  }
  
  private void c(a.a parama)
  {
    AppMethodBeat.i(92086);
    if (parama.type == a.bai)
    {
      d(parama);
      AppMethodBeat.o(92086);
      return;
    }
    if (parama.type == a.bar)
    {
      e(parama);
      AppMethodBeat.o(92086);
      return;
    }
    if (!this.bci.isEmpty()) {
      ((a.a)this.bci.peek()).a(parama);
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
    if (this.bbZ == null)
    {
      bool1 = true;
      com.google.android.exoplayer2.i.a.checkState(bool1, "Unexpected moov box.");
      localObject1 = u(parama.bbx);
      localObject2 = parama.ei(a.bat);
      localSparseArray = new SparseArray();
      l = -9223372036854775807L;
      m = ((a.a)localObject2).bbx.size();
      i = 0;
      if (i >= m) {
        break label179;
      }
      localObject3 = (a.b)((a.a)localObject2).bbx.get(i);
      if (((a.b)localObject3).type != a.baf) {
        break label155;
      }
      localObject3 = l(((a.b)localObject3).bbz);
      localSparseArray.put(((Integer)((Pair)localObject3).first).intValue(), ((Pair)localObject3).second);
    }
    for (;;)
    {
      i += 1;
      break label78;
      bool1 = false;
      break;
      label155:
      if (((a.b)localObject3).type == a.bau) {
        l = m(((a.b)localObject3).bbz);
      }
    }
    label179:
    Object localObject2 = new SparseArray();
    int m = parama.bby.size();
    int i = 0;
    if (i < m)
    {
      localObject3 = (a.a)parama.bby.get(i);
      a.b localb;
      if (((a.a)localObject3).type == a.bak)
      {
        localb = parama.eh(a.baj);
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
    if (this.bca.size() == 0)
    {
      i = j;
      while (i < m)
      {
        parama = (j)((SparseArray)localObject2).valueAt(i);
        localObject1 = new b(this.aXn.bh(i, parama.type));
        ((b)localObject1).a(parama, (c)localSparseArray.get(parama.id));
        this.bca.put(parama.id, localObject1);
        this.aSz = Math.max(this.aSz, parama.aSz);
        i += 1;
      }
      sT();
      this.aXn.sL();
      AppMethodBeat.o(92087);
      return;
    }
    if (this.bca.size() == m) {}
    for (boolean bool1 = bool2;; bool1 = false)
    {
      com.google.android.exoplayer2.i.a.checkState(bool1);
      i = k;
      while (i < m)
      {
        parama = (j)((SparseArray)localObject2).valueAt(i);
        ((b)this.bca.get(parama.id)).a(parama, (c)localSparseArray.get(parama.id));
        i += 1;
      }
    }
    AppMethodBeat.o(92087);
  }
  
  private void e(a.a parama)
  {
    AppMethodBeat.i(92088);
    a(parama, this.bca, this.flags, this.bch);
    parama = u(parama.bbx);
    if (parama != null)
    {
      int j = this.bca.size();
      int i = 0;
      while (i < j)
      {
        ((b)this.bca.valueAt(i)).b(parama);
        i += 1;
      }
    }
    AppMethodBeat.o(92088);
  }
  
  private static Pair<Integer, c> l(com.google.android.exoplayer2.i.m paramm)
  {
    AppMethodBeat.i(92090);
    paramm.setPosition(12);
    paramm = Pair.create(Integer.valueOf(paramm.readInt()), new c(paramm.vQ() - 1, paramm.vQ(), paramm.vQ(), paramm.readInt()));
    AppMethodBeat.o(92090);
    return paramm;
  }
  
  private static long m(com.google.android.exoplayer2.i.m paramm)
  {
    AppMethodBeat.i(92091);
    paramm.setPosition(8);
    if (a.ee(paramm.readInt()) == 0)
    {
      l = paramm.df();
      AppMethodBeat.o(92091);
      return l;
    }
    long l = paramm.vS();
    AppMethodBeat.o(92091);
    return l;
  }
  
  private static long n(com.google.android.exoplayer2.i.m paramm)
  {
    AppMethodBeat.i(92098);
    paramm.setPosition(8);
    if (a.ee(paramm.readInt()) == 1)
    {
      l = paramm.vS();
      AppMethodBeat.o(92098);
      return l;
    }
    long l = paramm.df();
    AppMethodBeat.o(92098);
    return l;
  }
  
  private void sS()
  {
    this.aXo = 0;
    this.bcm = 0;
  }
  
  private void sT()
  {
    AppMethodBeat.i(92089);
    if (((this.flags & 0x4) != 0) && (this.bct == null))
    {
      this.bct = this.aXn.bh(this.bca.size(), 4);
      this.bct.f(Format.c("application/x-emsg", 9223372036854775807L));
    }
    if (((this.flags & 0x8) != 0) && (this.bcu == null))
    {
      com.google.android.exoplayer2.c.m localm = this.aXn.bh(this.bca.size() + 1, 3);
      localm.f(Format.h(null, "application/cea-608"));
      this.bcu = new com.google.android.exoplayer2.c.m[] { localm };
    }
    AppMethodBeat.o(92089);
  }
  
  private static DrmInitData u(List<a.b> paramList)
  {
    AppMethodBeat.i(92103);
    int j = paramList.size();
    int i = 0;
    Object localObject3;
    for (Object localObject2 = null; i < j; localObject2 = localObject3)
    {
      Object localObject4 = (a.b)paramList.get(i);
      localObject3 = localObject2;
      if (((a.b)localObject4).type == a.baB)
      {
        Object localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = new ArrayList();
        }
        localObject2 = ((a.b)localObject4).bbz.data;
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
  
  public final int a(f paramf, com.google.android.exoplayer2.c.k paramk)
  {
    AppMethodBeat.i(92084);
    Object localObject2;
    Object localObject1;
    long l2;
    label137:
    do
    {
      switch (this.aXo)
      {
      default: 
        if (this.aXo != 3) {
          break label2075;
        }
        if (this.bcr != null) {
          break;
        }
        localObject2 = this.bca;
        paramk = null;
        l1 = 9223372036854775807L;
        j = ((SparseArray)localObject2).size();
        i = 0;
        while (i < j)
        {
          localObject1 = (b)((SparseArray)localObject2).valueAt(i);
          if (((b)localObject1).bcC == ((b)localObject1).bcx.bdA) {
            break label2911;
          }
          l2 = localObject1.bcx.bdB[localObject1.bcC];
          if (l2 >= l1) {
            break label2911;
          }
          l1 = l2;
          paramk = (com.google.android.exoplayer2.c.k)localObject1;
          i += 1;
        }
      case 0: 
        if (this.bcm != 0) {
          break label221;
        }
        if (paramf.a(this.bcg.data, 0, 8, true)) {
          break label185;
        }
        i = 0;
      }
    } while (i != 0);
    AppMethodBeat.o(92084);
    return -1;
    label185:
    this.bcm = 8;
    this.bcg.setPosition(0);
    this.bcl = this.bcg.df();
    this.bck = this.bcg.readInt();
    label221:
    if (this.bcl == 1L)
    {
      paramf.readFully(this.bcg.data, 8, 8);
      this.bcm += 8;
      this.bcl = this.bcg.vS();
    }
    while (this.bcl < this.bcm)
    {
      paramf = new o("Atom size less than header length (unsupported).");
      AppMethodBeat.o(92084);
      throw paramf;
      if (this.bcl == 0L)
      {
        l2 = paramf.getLength();
        l1 = l2;
        if (l2 == -1L)
        {
          l1 = l2;
          if (!this.bci.isEmpty()) {
            l1 = ((a.a)this.bci.peek()).bbw;
          }
        }
        if (l1 != -1L) {
          this.bcl = (l1 - paramf.getPosition() + this.bcm);
        }
      }
    }
    long l1 = paramf.getPosition() - this.bcm;
    if (this.bck == a.bar)
    {
      j = this.bca.size();
      i = 0;
      while (i < j)
      {
        paramk = ((b)this.bca.valueAt(i)).bcx;
        paramk.bdx = l1;
        paramk.bdz = l1;
        paramk.bdy = l1;
        i += 1;
      }
    }
    if (this.bck == a.aZO)
    {
      this.bcr = null;
      this.bco = (this.bcl + l1);
      if (!this.bcv)
      {
        this.aXn.a(new l.a(this.aSz));
        this.bcv = true;
      }
      this.aXo = 2;
    }
    for (;;)
    {
      i = 1;
      break;
      i = this.bck;
      if ((i == a.bai) || (i == a.bak) || (i == a.bal) || (i == a.bam) || (i == a.ban) || (i == a.bar) || (i == a.bas) || (i == a.bat) || (i == a.baw)) {
        i = 1;
      }
      for (;;)
      {
        if (i != 0)
        {
          l1 = paramf.getPosition() + this.bcl - 8L;
          this.bci.add(new a.a(this.bck, l1));
          if (this.bcl == this.bcm)
          {
            N(l1);
            break;
            i = 0;
            continue;
          }
          sS();
          break;
        }
      }
      i = this.bck;
      if ((i == a.baz) || (i == a.bay) || (i == a.baj) || (i == a.bah) || (i == a.baA) || (i == a.bad) || (i == a.bae) || (i == a.bav) || (i == a.baf) || (i == a.bag) || (i == a.baB) || (i == a.baJ) || (i == a.baK) || (i == a.baO) || (i == a.baN) || (i == a.baL) || (i == a.baM) || (i == a.bax) || (i == a.bau) || (i == a.bbn)) {
        i = 1;
      }
      for (;;)
      {
        if (i != 0) {
          if (this.bcm != 8)
          {
            paramf = new o("Leaf atom defines extended atom size (unsupported).");
            AppMethodBeat.o(92084);
            throw paramf;
            i = 0;
          }
          else
          {
            if (this.bcl > 2147483647L)
            {
              paramf = new o("Leaf atom with length > 2147483647 (unsupported).");
              AppMethodBeat.o(92084);
              throw paramf;
            }
            this.bcn = new com.google.android.exoplayer2.i.m((int)this.bcl);
            System.arraycopy(this.bcg.data, 0, this.bcn.data, 0, 8);
            this.aXo = 1;
            break;
          }
        }
      }
      if (this.bcl > 2147483647L)
      {
        paramf = new o("Skipping atom with length > 2147483647 (unsupported).");
        AppMethodBeat.o(92084);
        throw paramf;
      }
      this.bcn = null;
      this.aXo = 1;
    }
    int i = (int)this.bcl - this.bcm;
    if (this.bcn != null)
    {
      paramf.readFully(this.bcn.data, 8, i);
      paramk = new a.b(this.bck, this.bcn);
      l2 = paramf.getPosition();
      if (!this.bci.isEmpty()) {
        ((a.a)this.bci.peek()).a(paramk);
      }
    }
    Object localObject3;
    Object localObject4;
    int k;
    for (;;)
    {
      N(paramf.getPosition());
      break;
      if (paramk.type == a.bah)
      {
        paramk = paramk.bbz;
        paramk.setPosition(8);
        i = a.ee(paramk.readInt());
        paramk.fl(4);
        long l5 = paramk.df();
        long l4;
        long l3;
        if (i == 0)
        {
          l1 = paramk.df();
          l2 += paramk.df();
          l4 = x.b(l1, 1000000L, l5);
          paramk.fl(2);
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
            l1 = paramk.vS();
            l2 += paramk.vS();
            break;
          }
          long l6 = paramk.df();
          localObject1[i] = (k & 0x7FFFFFFF);
          localObject2[i] = l2;
          localObject4[i] = l3;
          l1 += l6;
          l3 = x.b(l1, 1000000L, l5);
          localObject3[i] = (l3 - localObject4[i]);
          paramk.fl(4);
          l2 += localObject1[i];
          i += 1;
        }
        label1333:
        paramk = Pair.create(Long.valueOf(l4), new com.google.android.exoplayer2.c.a((int[])localObject1, (long[])localObject2, (long[])localObject3, (long[])localObject4));
        this.bcq = ((Long)paramk.first).longValue();
        this.aXn.a((com.google.android.exoplayer2.c.l)paramk.second);
        this.bcv = true;
      }
      else if (paramk.type == a.bbn)
      {
        paramk = paramk.bbz;
        if (this.bct != null)
        {
          paramk.setPosition(12);
          paramk.vT();
          paramk.vT();
          l1 = paramk.df();
          l1 = x.b(paramk.df(), 1000000L, l1);
          paramk.setPosition(12);
          i = paramk.vJ();
          this.bct.a(paramk, i);
          if (this.bcq != -9223372036854775807L)
          {
            this.bct.a(l1 + this.bcq, 1, i, 0, null);
          }
          else
          {
            this.bcj.addLast(new a(l1, i));
            this.bcp += i;
            continue;
            paramf.dR(i);
          }
        }
      }
    }
    paramk = null;
    l1 = 9223372036854775807L;
    int j = this.bca.size();
    i = 0;
    label1567:
    if (i < j)
    {
      localObject1 = ((b)this.bca.valueAt(i)).bcx;
      if ((!((l)localObject1).bdM) || (((l)localObject1).bdz >= l1)) {
        break label2914;
      }
      l1 = ((l)localObject1).bdz;
      paramk = (b)this.bca.valueAt(i);
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
        this.aXo = 3;
        break;
      }
      i = (int)(l1 - paramf.getPosition());
      if (i < 0)
      {
        paramf = new o("Offset to encryption data was negative.");
        AppMethodBeat.o(92084);
        throw paramf;
      }
      paramf.dR(i);
      paramk = paramk.bcx;
      paramf.readFully(paramk.bdL.data, 0, paramk.bdK);
      paramk.bdL.setPosition(0);
      paramk.bdM = false;
      break;
      if (paramk == null)
      {
        i = (int)(this.bco - paramf.getPosition());
        if (i < 0)
        {
          paramf = new o("Offset to end of mdat was negative.");
          AppMethodBeat.o(92084);
          throw paramf;
        }
        paramf.dR(i);
        sS();
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
        j = (int)(paramk.bcx.bdB[paramk.bcC] - paramf.getPosition());
        i = j;
        if (j < 0) {
          i = 0;
        }
        paramf.dR(i);
        this.bcr = paramk;
        this.sampleSize = this.bcr.bcx.bdD[this.bcr.bcA];
        label2032:
        int n;
        if (this.bcr.bcx.bdH)
        {
          localObject3 = this.bcr;
          localObject2 = ((b)localObject3).bcx;
          i = ((l)localObject2).bdw.bbT;
          if (((l)localObject2).bdJ != null)
          {
            paramk = ((l)localObject2).bdJ;
            if (paramk.bdu == 0) {
              break label2309;
            }
            localObject1 = ((l)localObject2).bdL;
            i = paramk.bdu;
            paramk = (com.google.android.exoplayer2.c.k)localObject1;
            i2 = localObject2.bdI[localObject3.bcA];
            localObject1 = this.bcd.data;
            if (i2 == 0) {
              break label2339;
            }
            j = 128;
            localObject1[0] = ((byte)(j | i));
            this.bcd.setPosition(0);
            localObject1 = ((b)localObject3).aXw;
            ((com.google.android.exoplayer2.c.m)localObject1).a(this.bcd, 1);
            ((com.google.android.exoplayer2.c.m)localObject1).a(paramk, i);
            if (i2 != 0) {
              break label2345;
            }
            i += 1;
            this.aYG = i;
            this.sampleSize += this.aYG;
            if (this.bcr.bcy.bdo == 1)
            {
              this.sampleSize -= 8;
              paramf.dR(8);
            }
            this.aXo = 4;
            this.aYF = 0;
            localObject1 = this.bcr.bcx;
            localObject3 = this.bcr.bcy;
            localObject2 = this.bcr.aXw;
            k = this.bcr.bcA;
            if (((j)localObject3).aXz == 0) {
              break label2592;
            }
            paramk = this.bcb.data;
            paramk[0] = 0;
            paramk[1] = 0;
            paramk[2] = 0;
            int m = ((j)localObject3).aXz;
            n = 4 - ((j)localObject3).aXz;
            label2155:
            if (this.aYG >= this.sampleSize) {
              break label2633;
            }
            if (this.aYF != 0) {
              break label2406;
            }
            paramf.readFully(paramk, n, m + 1);
            this.bcb.setPosition(0);
            this.aYF = (this.bcb.vQ() - 1);
            this.aXx.setPosition(0);
            ((com.google.android.exoplayer2.c.m)localObject2).a(this.aXx, 4);
            ((com.google.android.exoplayer2.c.m)localObject2).a(this.bcb, 1);
            if ((this.bcu == null) || (!com.google.android.exoplayer2.i.k.b(((j)localObject3).aSv.aSd, paramk[4]))) {
              break label2400;
            }
          }
        }
        for (int i2 = 1;; i2 = 0)
        {
          this.bcs = i2;
          this.aYG += 5;
          this.sampleSize += n;
          break label2155;
          paramk = ((b)localObject3).bcy.ek(i);
          break;
          localObject1 = paramk.bdv;
          this.bce.q((byte[])localObject1, localObject1.length);
          paramk = this.bce;
          i = localObject1.length;
          break label1928;
          j = 0;
          break label1960;
          paramk = ((l)localObject2).bdL;
          j = paramk.readUnsignedShort();
          paramk.fl(-2);
          j = j * 6 + 2;
          ((com.google.android.exoplayer2.c.m)localObject1).a(paramk, j);
          i = i + 1 + j;
          break label2014;
          this.aYG = 0;
          break label2032;
        }
        label2406:
        if (this.bcs)
        {
          this.bcc.reset(this.aYF);
          paramf.readFully(this.bcc.data, 0, this.aYF);
          ((com.google.android.exoplayer2.c.m)localObject2).a(this.bcc, this.aYF);
          j = this.aYF;
          int i1 = com.google.android.exoplayer2.i.k.l(this.bcc.data, this.bcc.limit);
          localObject4 = this.bcc;
          if ("video/hevc".equals(((j)localObject3).aSv.aSd))
          {
            i = 1;
            ((com.google.android.exoplayer2.i.m)localObject4).setPosition(i);
            this.bcc.fk(i1);
            com.google.android.exoplayer2.f.a.g.a(((l)localObject1).em(k) * 1000L, this.bcc, this.bcu);
          }
        }
        for (i = j;; i = ((com.google.android.exoplayer2.c.m)localObject2).a(paramf, this.aYF, false))
        {
          this.aYG += i;
          this.aYF -= i;
          break;
          i = 0;
          break label2507;
        }
        while (this.aYG < this.sampleSize) {
          this.aYG = (((com.google.android.exoplayer2.c.m)localObject2).a(paramf, this.sampleSize - this.aYG, false) + this.aYG);
        }
        l2 = ((l)localObject1).em(k) * 1000L;
        l1 = l2;
        if (this.bcf != null) {
          l1 = this.bcf.at(l2);
        }
        if (localObject1.bdG[k] != 0)
        {
          i = 1;
          paramk = null;
          if (!((l)localObject1).bdH) {
            break label2908;
          }
          i = 0x40000000 | i;
          if (((l)localObject1).bdJ == null) {
            break label2800;
          }
          paramk = ((l)localObject1).bdJ;
          paramk = paramk.aYO;
        }
      }
      for (;;)
      {
        ((com.google.android.exoplayer2.c.m)localObject2).a(l1, i, this.sampleSize, 0, paramk);
        for (;;)
        {
          if (!this.bcj.isEmpty())
          {
            paramk = (a)this.bcj.removeFirst();
            this.bcp -= paramk.size;
            this.bct.a(paramk.bcw + l1, 1, paramk.size, this.bcp, null);
            continue;
            i = 0;
            break;
            label2800:
            paramk = ((j)localObject3).ek(((l)localObject1).bdw.bbT);
            break label2711;
          }
        }
        paramk = this.bcr;
        paramk.bcA += 1;
        paramk = this.bcr;
        paramk.bcB += 1;
        if (this.bcr.bcB == localObject1.bdC[this.bcr.bcC])
        {
          paramk = this.bcr;
          paramk.bcC += 1;
          this.bcr.bcB = 0;
          this.bcr = null;
        }
        this.aXo = 3;
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
    this.aXn = paramg;
    if (this.bbZ != null)
    {
      paramg = new b(paramg.bh(0, this.bbZ.type));
      paramg.a(this.bbZ, new c(0, 0, 0, 0));
      this.bca.put(0, paramg);
      sT();
      this.aXn.sL();
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
    int j = this.bca.size();
    int i = 0;
    while (i < j)
    {
      ((b)this.bca.valueAt(i)).reset();
      i += 1;
    }
    this.bcj.clear();
    this.bcp = 0;
    this.bci.clear();
    sS();
    AppMethodBeat.o(92083);
  }
  
  static final class a
  {
    public final long bcw;
    public final int size;
    
    public a(long paramLong, int paramInt)
    {
      this.bcw = paramLong;
      this.size = paramInt;
    }
  }
  
  static final class b
  {
    public final com.google.android.exoplayer2.c.m aXw;
    public int bcA;
    public int bcB;
    public int bcC;
    public final l bcx;
    public j bcy;
    public c bcz;
    
    public b(com.google.android.exoplayer2.c.m paramm)
    {
      AppMethodBeat.i(92076);
      this.bcx = new l();
      this.aXw = paramm;
      AppMethodBeat.o(92076);
    }
    
    public final void a(j paramj, c paramc)
    {
      AppMethodBeat.i(92077);
      this.bcy = ((j)com.google.android.exoplayer2.i.a.checkNotNull(paramj));
      this.bcz = ((c)com.google.android.exoplayer2.i.a.checkNotNull(paramc));
      this.aXw.f(paramj.aSv);
      reset();
      AppMethodBeat.o(92077);
    }
    
    public final void b(DrmInitData paramDrmInitData)
    {
      AppMethodBeat.i(92079);
      Object localObject = this.bcy.ek(this.bcx.bdw.bbT);
      if (localObject != null) {}
      for (localObject = ((k)localObject).bdt;; localObject = null)
      {
        this.aXw.f(this.bcy.aSv.a(paramDrmInitData.al((String)localObject)));
        AppMethodBeat.o(92079);
        return;
      }
    }
    
    public final void reset()
    {
      AppMethodBeat.i(92078);
      this.bcx.reset();
      this.bcA = 0;
      this.bcC = 0;
      this.bcB = 0;
      AppMethodBeat.o(92078);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.exoplayer2.c.d.e
 * JD-Core Version:    0.7.0.1
 */