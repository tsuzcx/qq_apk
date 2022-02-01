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
  public static final com.google.android.exoplayer2.c.h aXT;
  private static final int bcJ;
  private static final byte[] bcK;
  private long aTs;
  private com.google.android.exoplayer2.c.g aXZ;
  private int aYa;
  private final com.google.android.exoplayer2.i.m aYj;
  private int aZr;
  private int aZs;
  private final j bcL;
  private final SparseArray<b> bcM;
  private final com.google.android.exoplayer2.i.m bcN;
  private final com.google.android.exoplayer2.i.m bcO;
  private final com.google.android.exoplayer2.i.m bcP;
  private final com.google.android.exoplayer2.i.m bcQ;
  private final u bcR;
  private final com.google.android.exoplayer2.i.m bcS;
  private final byte[] bcT;
  private final Stack<a.a> bcU;
  private final LinkedList<a> bcV;
  private int bcW;
  private long bcX;
  private int bcY;
  private com.google.android.exoplayer2.i.m bcZ;
  private long bda;
  private int bdb;
  private long bdc;
  private b bdd;
  private boolean bde;
  private com.google.android.exoplayer2.c.m bdf;
  private com.google.android.exoplayer2.c.m[] bdg;
  private boolean bdh;
  private final int flags;
  private int sampleSize;
  
  static
  {
    AppMethodBeat.i(92104);
    aXT = new com.google.android.exoplayer2.c.h()
    {
      public final com.google.android.exoplayer2.c.e[] sT()
      {
        AppMethodBeat.i(92075);
        e locale = new e();
        AppMethodBeat.o(92075);
        return new com.google.android.exoplayer2.c.e[] { locale };
      }
    };
    bcJ = x.aQ("seig");
    bcK = new byte[] { -94, 57, 79, 82, 90, -101, 79, 20, -94, 68, 108, 66, 124, 100, -115, -12 };
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
    AppMethodBeat.i(195760);
    this.flags = (paramInt | 0x0);
    this.bcR = paramu;
    this.bcL = null;
    this.bcS = new com.google.android.exoplayer2.i.m(16);
    this.aYj = new com.google.android.exoplayer2.i.m(com.google.android.exoplayer2.i.k.bwo);
    this.bcN = new com.google.android.exoplayer2.i.m(5);
    this.bcO = new com.google.android.exoplayer2.i.m();
    this.bcP = new com.google.android.exoplayer2.i.m(1);
    this.bcQ = new com.google.android.exoplayer2.i.m();
    this.bcT = new byte[16];
    this.bcU = new Stack();
    this.bcV = new LinkedList();
    this.bcM = new SparseArray();
    this.aTs = -9223372036854775807L;
    this.bdc = -9223372036854775807L;
    tb();
    AppMethodBeat.o(195760);
  }
  
  private void O(long paramLong)
  {
    AppMethodBeat.i(92085);
    while ((!this.bcU.isEmpty()) && (((a.a)this.bcU.peek()).bci == paramLong)) {
      c((a.a)this.bcU.pop());
    }
    tb();
    AppMethodBeat.o(92085);
  }
  
  private static int a(b paramb, int paramInt1, long paramLong, int paramInt2, com.google.android.exoplayer2.i.m paramm, int paramInt3)
  {
    AppMethodBeat.i(92099);
    paramm.setPosition(8);
    int i1 = a.ef(paramm.readInt());
    j localj = paramb.bdk;
    paramb = paramb.bdj;
    c localc = paramb.bei;
    paramb.beo[paramInt1] = paramm.vF();
    paramb.ben[paramInt1] = paramb.bek;
    Object localObject;
    if ((i1 & 0x1) != 0)
    {
      localObject = paramb.ben;
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
        i = paramm.vF();
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
      if ((localj.beb == null) || (localj.beb.length != 1) || (localj.beb[0] != 0L)) {
        break label528;
      }
    }
    label258:
    label515:
    label528:
    for (long l1 = x.b(localj.bec[0], 1000L, localj.bdY);; l1 = 0L)
    {
      localObject = paramb.bep;
      int[] arrayOfInt = paramb.beq;
      long[] arrayOfLong = paramb.ber;
      boolean[] arrayOfBoolean = paramb.bes;
      int i4;
      label285:
      int i2;
      label304:
      int i3;
      if ((localj.type == 2) && ((paramInt2 & 0x1) != 0))
      {
        paramInt2 = 1;
        i4 = paramInt3 + paramb.beo[paramInt1];
        long l2 = localj.bdY;
        if (paramInt1 > 0) {
          paramLong = paramb.bez;
        }
        if (paramInt3 >= i4) {
          break label515;
        }
        if (k == 0) {
          break label457;
        }
        i2 = paramm.vF();
        if (m == 0) {
          break label467;
        }
        i3 = paramm.vF();
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
      paramb.bez = paramLong;
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
      long l = paramm.vH();
      paramSparseArray.bdj.bek = l;
      paramSparseArray.bdj.bel = l;
    }
    c localc = paramSparseArray.bdl;
    label125:
    int j;
    if ((k & 0x2) != 0)
    {
      paramInt = paramm.vF() - 1;
      if ((k & 0x8) == 0) {
        break label190;
      }
      i = paramm.vF();
      if ((k & 0x10) == 0) {
        break label199;
      }
      j = paramm.vF();
      label139:
      if ((k & 0x20) == 0) {
        break label209;
      }
    }
    label190:
    label199:
    label209:
    for (k = paramm.vF();; k = localc.flags)
    {
      paramSparseArray.bdj.bei = new c(paramInt, i, j, k);
      AppMethodBeat.o(92097);
      return paramSparseArray;
      paramInt = localc.bcF;
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
    int j = parama.bck.size();
    int i = 0;
    while (i < j)
    {
      a.a locala = (a.a)parama.bck.get(i);
      if (locala.type == a.bbe) {
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
    parama = parama.bcj;
    int i1 = parama.size();
    int j = 0;
    Object localObject;
    int m;
    if (j < i1)
    {
      localObject = (a.b)parama.get(j);
      if (((a.b)localObject).type != a.baS) {
        break label229;
      }
      localObject = ((a.b)localObject).bcl;
      ((com.google.android.exoplayer2.i.m)localObject).setPosition(12);
      m = ((com.google.android.exoplayer2.i.m)localObject).vF();
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
      paramb.bdo = 0;
      paramb.bdn = 0;
      paramb.bdm = 0;
      paramb.bdj.bh(k, i);
      j = 0;
      k = 0;
      i = 0;
      while (i < i1)
      {
        localObject = (a.b)parama.get(i);
        int n = j;
        m = k;
        if (((a.b)localObject).type == a.baS)
        {
          m = a(paramb, j, paramLong, paramInt, ((a.b)localObject).bcl, k);
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
    int n = paramk.beg;
    paramm.setPosition(8);
    if ((a.ef(paramm.readInt()) & 0x1) == 1) {
      paramm.eX(8);
    }
    int i = paramm.readUnsignedByte();
    int m = paramm.vF();
    if (m != paraml.sampleCount)
    {
      paramk = new o("Length mismatch: " + m + ", " + paraml.sampleCount);
      AppMethodBeat.o(92095);
      throw paramk;
    }
    int k;
    if (i == 0)
    {
      paramk = paraml.beu;
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
      Arrays.fill(paraml.beu, 0, m, bool);
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
      paramInt = paramm.vF();
      if (paramInt == paraml.sampleCount) {
        break;
      }
      paramm = new o("Length mismatch: " + paramInt + ", " + paraml.sampleCount);
      AppMethodBeat.o(92101);
      throw paramm;
    }
    Arrays.fill(paraml.beu, 0, paramInt, bool);
    paraml.el(paramm.vy());
    paraml.q(paramm);
    AppMethodBeat.o(92101);
  }
  
  private static void a(com.google.android.exoplayer2.i.m paramm, l paraml)
  {
    AppMethodBeat.i(92096);
    paramm.setPosition(8);
    int i = paramm.readInt();
    if ((a.ef(i) & 0x1) == 1) {
      paramm.eX(8);
    }
    int j = paramm.vF();
    if (j != 1)
    {
      paramm = new o("Unexpected saio entry count: ".concat(String.valueOf(j)));
      AppMethodBeat.o(92096);
      throw paramm;
    }
    i = a.ee(i);
    long l2 = paraml.bel;
    if (i == 0) {}
    for (long l1 = paramm.dm();; l1 = paramm.vH())
    {
      paraml.bel = (l1 + l2);
      AppMethodBeat.o(92096);
      return;
    }
  }
  
  private static void a(com.google.android.exoplayer2.i.m paramm, l paraml, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(92100);
    paramm.setPosition(8);
    paramm.readBytes(paramArrayOfByte, 0, 16);
    if (!Arrays.equals(paramArrayOfByte, bcK))
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
    if (paramm1.readInt() != bcJ)
    {
      AppMethodBeat.o(92102);
      return;
    }
    if (a.ee(i) == 1) {
      paramm1.eX(4);
    }
    if (paramm1.readInt() != 1)
    {
      paramm1 = new o("Entry count in sbgp != 1 (unsupported).");
      AppMethodBeat.o(92102);
      throw paramm1;
    }
    paramm2.setPosition(8);
    i = paramm2.readInt();
    if (paramm2.readInt() != bcJ)
    {
      AppMethodBeat.o(92102);
      return;
    }
    i = a.ee(i);
    if (i == 1)
    {
      if (paramm2.dm() == 0L)
      {
        paramm1 = new o("Variable length description in sgpd found (unsupported)");
        AppMethodBeat.o(92102);
        throw paramm1;
      }
    }
    else if (i >= 2) {
      paramm2.eX(4);
    }
    if (paramm2.dm() != 1L)
    {
      paramm1 = new o("Entry count in sgpd != 1 (unsupported).");
      AppMethodBeat.o(92102);
      throw paramm1;
    }
    paramm2.eX(1);
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
    paraml.bet = true;
    paraml.bev = new k(true, paramString, i, arrayOfByte, (j & 0xF0) >> 4, j & 0xF, paramm1);
    AppMethodBeat.o(92102);
  }
  
  private static void b(a.a parama, SparseArray<b> paramSparseArray, int paramInt, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(92093);
    paramSparseArray = a(parama.eh(a.baQ).bcl, paramSparseArray, paramInt);
    if (paramSparseArray == null)
    {
      AppMethodBeat.o(92093);
      return;
    }
    l locall = paramSparseArray.bdj;
    long l2 = locall.bez;
    paramSparseArray.reset();
    long l1 = l2;
    if (parama.eh(a.baP) != null)
    {
      l1 = l2;
      if ((paramInt & 0x2) == 0) {
        l1 = n(parama.eh(a.baP).bcl);
      }
    }
    a(parama, paramSparseArray, l1, paramInt);
    paramSparseArray = paramSparseArray.bdk.ek(locall.bei.bcF);
    Object localObject1 = parama.eh(a.bbv);
    if (localObject1 != null) {
      a(paramSparseArray, ((a.b)localObject1).bcl, locall);
    }
    localObject1 = parama.eh(a.bbw);
    if (localObject1 != null) {
      a(((a.b)localObject1).bcl, locall);
    }
    localObject1 = parama.eh(a.bbA);
    if (localObject1 != null) {
      a(((a.b)localObject1).bcl, 0, locall);
    }
    localObject1 = parama.eh(a.bbx);
    Object localObject2 = parama.eh(a.bby);
    if ((localObject1 != null) && (localObject2 != null))
    {
      localObject1 = ((a.b)localObject1).bcl;
      localObject2 = ((a.b)localObject2).bcl;
      if (paramSparseArray == null) {
        break label308;
      }
    }
    label308:
    for (paramSparseArray = paramSparseArray.bef;; paramSparseArray = null)
    {
      a((com.google.android.exoplayer2.i.m)localObject1, (com.google.android.exoplayer2.i.m)localObject2, paramSparseArray, locall);
      int i = parama.bcj.size();
      paramInt = 0;
      while (paramInt < i)
      {
        paramSparseArray = (a.b)parama.bcj.get(paramInt);
        if (paramSparseArray.type == a.bbz) {
          a(paramSparseArray.bcl, locall, paramArrayOfByte);
        }
        paramInt += 1;
      }
    }
    AppMethodBeat.o(92093);
  }
  
  private void c(a.a parama)
  {
    AppMethodBeat.i(92086);
    if (parama.type == a.baU)
    {
      d(parama);
      AppMethodBeat.o(92086);
      return;
    }
    if (parama.type == a.bbd)
    {
      e(parama);
      AppMethodBeat.o(92086);
      return;
    }
    if (!this.bcU.isEmpty()) {
      ((a.a)this.bcU.peek()).a(parama);
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
    if (this.bcL == null)
    {
      bool1 = true;
      com.google.android.exoplayer2.i.a.checkState(bool1, "Unexpected moov box.");
      localObject1 = t(parama.bcj);
      localObject2 = parama.ei(a.bbf);
      localSparseArray = new SparseArray();
      l = -9223372036854775807L;
      m = ((a.a)localObject2).bcj.size();
      i = 0;
      if (i >= m) {
        break label179;
      }
      localObject3 = (a.b)((a.a)localObject2).bcj.get(i);
      if (((a.b)localObject3).type != a.baR) {
        break label155;
      }
      localObject3 = l(((a.b)localObject3).bcl);
      localSparseArray.put(((Integer)((Pair)localObject3).first).intValue(), ((Pair)localObject3).second);
    }
    for (;;)
    {
      i += 1;
      break label78;
      bool1 = false;
      break;
      label155:
      if (((a.b)localObject3).type == a.bbg) {
        l = m(((a.b)localObject3).bcl);
      }
    }
    label179:
    Object localObject2 = new SparseArray();
    int m = parama.bck.size();
    int i = 0;
    if (i < m)
    {
      localObject3 = (a.a)parama.bck.get(i);
      a.b localb;
      if (((a.a)localObject3).type == a.baW)
      {
        localb = parama.eh(a.baV);
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
    if (this.bcM.size() == 0)
    {
      i = j;
      while (i < m)
      {
        parama = (j)((SparseArray)localObject2).valueAt(i);
        localObject1 = new b(this.aXZ.dW(i));
        ((b)localObject1).a(parama, (c)localSparseArray.get(parama.id));
        this.bcM.put(parama.id, localObject1);
        this.aTs = Math.max(this.aTs, parama.aTs);
        i += 1;
      }
      tc();
      this.aXZ.sU();
      AppMethodBeat.o(92087);
      return;
    }
    if (this.bcM.size() == m) {}
    for (boolean bool1 = bool2;; bool1 = false)
    {
      com.google.android.exoplayer2.i.a.checkState(bool1);
      i = k;
      while (i < m)
      {
        parama = (j)((SparseArray)localObject2).valueAt(i);
        ((b)this.bcM.get(parama.id)).a(parama, (c)localSparseArray.get(parama.id));
        i += 1;
      }
    }
    AppMethodBeat.o(92087);
  }
  
  private void e(a.a parama)
  {
    AppMethodBeat.i(92088);
    a(parama, this.bcM, this.flags, this.bcT);
    parama = t(parama.bcj);
    if (parama != null)
    {
      int j = this.bcM.size();
      int i = 0;
      while (i < j)
      {
        ((b)this.bcM.valueAt(i)).b(parama);
        i += 1;
      }
    }
    AppMethodBeat.o(92088);
  }
  
  private static Pair<Integer, c> l(com.google.android.exoplayer2.i.m paramm)
  {
    AppMethodBeat.i(92090);
    paramm.setPosition(12);
    paramm = Pair.create(Integer.valueOf(paramm.readInt()), new c(paramm.vF() - 1, paramm.vF(), paramm.vF(), paramm.readInt()));
    AppMethodBeat.o(92090);
    return paramm;
  }
  
  private static long m(com.google.android.exoplayer2.i.m paramm)
  {
    AppMethodBeat.i(92091);
    paramm.setPosition(8);
    if (a.ee(paramm.readInt()) == 0)
    {
      l = paramm.dm();
      AppMethodBeat.o(92091);
      return l;
    }
    long l = paramm.vH();
    AppMethodBeat.o(92091);
    return l;
  }
  
  private static long n(com.google.android.exoplayer2.i.m paramm)
  {
    AppMethodBeat.i(92098);
    paramm.setPosition(8);
    if (a.ee(paramm.readInt()) == 1)
    {
      l = paramm.vH();
      AppMethodBeat.o(92098);
      return l;
    }
    long l = paramm.dm();
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
      if (((a.b)localObject4).type == a.bbn)
      {
        Object localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = new ArrayList();
        }
        localObject2 = ((a.b)localObject4).bcl.data;
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
  
  private void tb()
  {
    this.aYa = 0;
    this.bcY = 0;
  }
  
  private void tc()
  {
    AppMethodBeat.i(92089);
    if (((this.flags & 0x4) != 0) && (this.bdf == null))
    {
      this.bdf = this.aXZ.dW(this.bcM.size());
      this.bdf.f(Format.c("application/x-emsg", 9223372036854775807L));
    }
    if (((this.flags & 0x8) != 0) && (this.bdg == null))
    {
      com.google.android.exoplayer2.c.m localm = this.aXZ.dW(this.bcM.size() + 1);
      localm.f(Format.aj("application/cea-608"));
      this.bdg = new com.google.android.exoplayer2.c.m[] { localm };
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
      switch (this.aYa)
      {
      default: 
        if (this.aYa != 3) {
          break label2075;
        }
        if (this.bdd != null) {
          break;
        }
        localObject2 = this.bcM;
        paramk = null;
        l1 = 9223372036854775807L;
        j = ((SparseArray)localObject2).size();
        i = 0;
        while (i < j)
        {
          localObject1 = (b)((SparseArray)localObject2).valueAt(i);
          if (((b)localObject1).bdo == ((b)localObject1).bdj.bem) {
            break label2911;
          }
          l2 = localObject1.bdj.ben[localObject1.bdo];
          if (l2 >= l1) {
            break label2911;
          }
          l1 = l2;
          paramk = (com.google.android.exoplayer2.c.k)localObject1;
          i += 1;
        }
      case 0: 
        if (this.bcY != 0) {
          break label221;
        }
        if (paramf.a(this.bcS.data, 0, 8, true)) {
          break label185;
        }
        i = 0;
      }
    } while (i != 0);
    AppMethodBeat.o(92084);
    return -1;
    label185:
    this.bcY = 8;
    this.bcS.setPosition(0);
    this.bcX = this.bcS.dm();
    this.bcW = this.bcS.readInt();
    label221:
    if (this.bcX == 1L)
    {
      paramf.readFully(this.bcS.data, 8, 8);
      this.bcY += 8;
      this.bcX = this.bcS.vH();
    }
    while (this.bcX < this.bcY)
    {
      paramf = new o("Atom size less than header length (unsupported).");
      AppMethodBeat.o(92084);
      throw paramf;
      if (this.bcX == 0L)
      {
        l2 = paramf.getLength();
        l1 = l2;
        if (l2 == -1L)
        {
          l1 = l2;
          if (!this.bcU.isEmpty()) {
            l1 = ((a.a)this.bcU.peek()).bci;
          }
        }
        if (l1 != -1L) {
          this.bcX = (l1 - paramf.getPosition() + this.bcY);
        }
      }
    }
    long l1 = paramf.getPosition() - this.bcY;
    if (this.bcW == a.bbd)
    {
      j = this.bcM.size();
      i = 0;
      while (i < j)
      {
        paramk = ((b)this.bcM.valueAt(i)).bdj;
        paramk.bej = l1;
        paramk.bel = l1;
        paramk.bek = l1;
        i += 1;
      }
    }
    if (this.bcW == a.baA)
    {
      this.bdd = null;
      this.bda = (this.bcX + l1);
      if (!this.bdh)
      {
        this.aXZ.a(new l.a(this.aTs));
        this.bdh = true;
      }
      this.aYa = 2;
    }
    for (;;)
    {
      i = 1;
      break;
      i = this.bcW;
      if ((i == a.baU) || (i == a.baW) || (i == a.baX) || (i == a.baY) || (i == a.baZ) || (i == a.bbd) || (i == a.bbe) || (i == a.bbf) || (i == a.bbi)) {
        i = 1;
      }
      for (;;)
      {
        if (i != 0)
        {
          l1 = paramf.getPosition() + this.bcX - 8L;
          this.bcU.add(new a.a(this.bcW, l1));
          if (this.bcX == this.bcY)
          {
            O(l1);
            break;
            i = 0;
            continue;
          }
          tb();
          break;
        }
      }
      i = this.bcW;
      if ((i == a.bbl) || (i == a.bbk) || (i == a.baV) || (i == a.baT) || (i == a.bbm) || (i == a.baP) || (i == a.baQ) || (i == a.bbh) || (i == a.baR) || (i == a.baS) || (i == a.bbn) || (i == a.bbv) || (i == a.bbw) || (i == a.bbA) || (i == a.bbz) || (i == a.bbx) || (i == a.bby) || (i == a.bbj) || (i == a.bbg) || (i == a.bbZ)) {
        i = 1;
      }
      for (;;)
      {
        if (i != 0) {
          if (this.bcY != 8)
          {
            paramf = new o("Leaf atom defines extended atom size (unsupported).");
            AppMethodBeat.o(92084);
            throw paramf;
            i = 0;
          }
          else
          {
            if (this.bcX > 2147483647L)
            {
              paramf = new o("Leaf atom with length > 2147483647 (unsupported).");
              AppMethodBeat.o(92084);
              throw paramf;
            }
            this.bcZ = new com.google.android.exoplayer2.i.m((int)this.bcX);
            System.arraycopy(this.bcS.data, 0, this.bcZ.data, 0, 8);
            this.aYa = 1;
            break;
          }
        }
      }
      if (this.bcX > 2147483647L)
      {
        paramf = new o("Skipping atom with length > 2147483647 (unsupported).");
        AppMethodBeat.o(92084);
        throw paramf;
      }
      this.bcZ = null;
      this.aYa = 1;
    }
    int i = (int)this.bcX - this.bcY;
    if (this.bcZ != null)
    {
      paramf.readFully(this.bcZ.data, 8, i);
      paramk = new a.b(this.bcW, this.bcZ);
      l2 = paramf.getPosition();
      if (!this.bcU.isEmpty()) {
        ((a.a)this.bcU.peek()).a(paramk);
      }
    }
    Object localObject3;
    Object localObject4;
    int k;
    for (;;)
    {
      O(paramf.getPosition());
      break;
      if (paramk.type == a.baT)
      {
        paramk = paramk.bcl;
        paramk.setPosition(8);
        i = a.ee(paramk.readInt());
        paramk.eX(4);
        long l5 = paramk.dm();
        long l4;
        long l3;
        if (i == 0)
        {
          l1 = paramk.dm();
          l2 += paramk.dm();
          l4 = x.b(l1, 1000000L, l5);
          paramk.eX(2);
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
            l1 = paramk.vH();
            l2 += paramk.vH();
            break;
          }
          long l6 = paramk.dm();
          localObject1[i] = (k & 0x7FFFFFFF);
          localObject2[i] = l2;
          localObject4[i] = l3;
          l1 += l6;
          l3 = x.b(l1, 1000000L, l5);
          localObject3[i] = (l3 - localObject4[i]);
          paramk.eX(4);
          l2 += localObject1[i];
          i += 1;
        }
        label1333:
        paramk = Pair.create(Long.valueOf(l4), new com.google.android.exoplayer2.c.a((int[])localObject1, (long[])localObject2, (long[])localObject3, (long[])localObject4));
        this.bdc = ((Long)paramk.first).longValue();
        this.aXZ.a((com.google.android.exoplayer2.c.l)paramk.second);
        this.bdh = true;
      }
      else if (paramk.type == a.bbZ)
      {
        paramk = paramk.bcl;
        if (this.bdf != null)
        {
          paramk.setPosition(12);
          paramk.vI();
          paramk.vI();
          l1 = paramk.dm();
          l1 = x.b(paramk.dm(), 1000000L, l1);
          paramk.setPosition(12);
          i = paramk.vy();
          this.bdf.a(paramk, i);
          if (this.bdc != -9223372036854775807L)
          {
            this.bdf.a(l1 + this.bdc, 1, i, 0, null);
          }
          else
          {
            this.bcV.addLast(new a(l1, i));
            this.bdb += i;
            continue;
            paramf.dQ(i);
          }
        }
      }
    }
    paramk = null;
    l1 = 9223372036854775807L;
    int j = this.bcM.size();
    i = 0;
    label1567:
    if (i < j)
    {
      localObject1 = ((b)this.bcM.valueAt(i)).bdj;
      if ((!((l)localObject1).bey) || (((l)localObject1).bel >= l1)) {
        break label2914;
      }
      l1 = ((l)localObject1).bel;
      paramk = (b)this.bcM.valueAt(i);
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
        this.aYa = 3;
        break;
      }
      i = (int)(l1 - paramf.getPosition());
      if (i < 0)
      {
        paramf = new o("Offset to encryption data was negative.");
        AppMethodBeat.o(92084);
        throw paramf;
      }
      paramf.dQ(i);
      paramk = paramk.bdj;
      paramf.readFully(paramk.bex.data, 0, paramk.bew);
      paramk.bex.setPosition(0);
      paramk.bey = false;
      break;
      if (paramk == null)
      {
        i = (int)(this.bda - paramf.getPosition());
        if (i < 0)
        {
          paramf = new o("Offset to end of mdat was negative.");
          AppMethodBeat.o(92084);
          throw paramf;
        }
        paramf.dQ(i);
        tb();
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
        j = (int)(paramk.bdj.ben[paramk.bdo] - paramf.getPosition());
        i = j;
        if (j < 0) {
          i = 0;
        }
        paramf.dQ(i);
        this.bdd = paramk;
        this.sampleSize = this.bdd.bdj.bep[this.bdd.bdm];
        label2032:
        int n;
        if (this.bdd.bdj.bet)
        {
          localObject3 = this.bdd;
          localObject2 = ((b)localObject3).bdj;
          i = ((l)localObject2).bei.bcF;
          if (((l)localObject2).bev != null)
          {
            paramk = ((l)localObject2).bev;
            if (paramk.beg == 0) {
              break label2309;
            }
            localObject1 = ((l)localObject2).bex;
            i = paramk.beg;
            paramk = (com.google.android.exoplayer2.c.k)localObject1;
            i2 = localObject2.beu[localObject3.bdm];
            localObject1 = this.bcP.data;
            if (i2 == 0) {
              break label2339;
            }
            j = 128;
            localObject1[0] = ((byte)(j | i));
            this.bcP.setPosition(0);
            localObject1 = ((b)localObject3).aYi;
            ((com.google.android.exoplayer2.c.m)localObject1).a(this.bcP, 1);
            ((com.google.android.exoplayer2.c.m)localObject1).a(paramk, i);
            if (i2 != 0) {
              break label2345;
            }
            i += 1;
            this.aZs = i;
            this.sampleSize += this.aZs;
            if (this.bdd.bdk.bea == 1)
            {
              this.sampleSize -= 8;
              paramf.dQ(8);
            }
            this.aYa = 4;
            this.aZr = 0;
            localObject1 = this.bdd.bdj;
            localObject3 = this.bdd.bdk;
            localObject2 = this.bdd.aYi;
            k = this.bdd.bdm;
            if (((j)localObject3).aYl == 0) {
              break label2592;
            }
            paramk = this.bcN.data;
            paramk[0] = 0;
            paramk[1] = 0;
            paramk[2] = 0;
            int m = ((j)localObject3).aYl;
            n = 4 - ((j)localObject3).aYl;
            label2155:
            if (this.aZs >= this.sampleSize) {
              break label2633;
            }
            if (this.aZr != 0) {
              break label2406;
            }
            paramf.readFully(paramk, n, m + 1);
            this.bcN.setPosition(0);
            this.aZr = (this.bcN.vF() - 1);
            this.aYj.setPosition(0);
            ((com.google.android.exoplayer2.c.m)localObject2).a(this.aYj, 4);
            ((com.google.android.exoplayer2.c.m)localObject2).a(this.bcN, 1);
            if ((this.bdg == null) || (!com.google.android.exoplayer2.i.k.b(((j)localObject3).aTo.aSY, paramk[4]))) {
              break label2400;
            }
          }
        }
        for (int i2 = 1;; i2 = 0)
        {
          this.bde = i2;
          this.aZs += 5;
          this.sampleSize += n;
          break label2155;
          paramk = ((b)localObject3).bdk.ek(i);
          break;
          localObject1 = paramk.beh;
          this.bcQ.n((byte[])localObject1, localObject1.length);
          paramk = this.bcQ;
          i = localObject1.length;
          break label1928;
          j = 0;
          break label1960;
          paramk = ((l)localObject2).bex;
          j = paramk.readUnsignedShort();
          paramk.eX(-2);
          j = j * 6 + 2;
          ((com.google.android.exoplayer2.c.m)localObject1).a(paramk, j);
          i = i + 1 + j;
          break label2014;
          this.aZs = 0;
          break label2032;
        }
        label2406:
        if (this.bde)
        {
          this.bcO.reset(this.aZr);
          paramf.readFully(this.bcO.data, 0, this.aZr);
          ((com.google.android.exoplayer2.c.m)localObject2).a(this.bcO, this.aZr);
          j = this.aZr;
          int i1 = com.google.android.exoplayer2.i.k.j(this.bcO.data, this.bcO.limit);
          localObject4 = this.bcO;
          if ("video/hevc".equals(((j)localObject3).aTo.aSY))
          {
            i = 1;
            ((com.google.android.exoplayer2.i.m)localObject4).setPosition(i);
            this.bcO.eW(i1);
            com.google.android.exoplayer2.f.a.g.a(((l)localObject1).em(k) * 1000L, this.bcO, this.bdg);
          }
        }
        for (i = j;; i = ((com.google.android.exoplayer2.c.m)localObject2).a(paramf, this.aZr, false))
        {
          this.aZs += i;
          this.aZr -= i;
          break;
          i = 0;
          break label2507;
        }
        while (this.aZs < this.sampleSize) {
          this.aZs = (((com.google.android.exoplayer2.c.m)localObject2).a(paramf, this.sampleSize - this.aZs, false) + this.aZs);
        }
        l2 = ((l)localObject1).em(k) * 1000L;
        l1 = l2;
        if (this.bcR != null) {
          l1 = this.bcR.ap(l2);
        }
        if (localObject1.bes[k] != 0)
        {
          i = 1;
          paramk = null;
          if (!((l)localObject1).bet) {
            break label2908;
          }
          i = 0x40000000 | i;
          if (((l)localObject1).bev == null) {
            break label2800;
          }
          paramk = ((l)localObject1).bev;
          paramk = paramk.aZA;
        }
      }
      for (;;)
      {
        ((com.google.android.exoplayer2.c.m)localObject2).a(l1, i, this.sampleSize, 0, paramk);
        for (;;)
        {
          if (!this.bcV.isEmpty())
          {
            paramk = (a)this.bcV.removeFirst();
            this.bdb -= paramk.size;
            this.bdf.a(paramk.bdi + l1, 1, paramk.size, this.bdb, null);
            continue;
            i = 0;
            break;
            label2800:
            paramk = ((j)localObject3).ek(((l)localObject1).bei.bcF);
            break label2711;
          }
        }
        paramk = this.bdd;
        paramk.bdm += 1;
        paramk = this.bdd;
        paramk.bdn += 1;
        if (this.bdd.bdn == localObject1.beo[this.bdd.bdo])
        {
          paramk = this.bdd;
          paramk.bdo += 1;
          this.bdd.bdn = 0;
          this.bdd = null;
        }
        this.aYa = 3;
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
    this.aXZ = paramg;
    if (this.bcL != null)
    {
      paramg = new b(paramg.dW(0));
      paramg.a(this.bcL, new c(0, 0, 0, 0));
      this.bcM.put(0, paramg);
      tc();
      this.aXZ.sU();
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
    int j = this.bcM.size();
    int i = 0;
    while (i < j)
    {
      ((b)this.bcM.valueAt(i)).reset();
      i += 1;
    }
    this.bcV.clear();
    this.bdb = 0;
    this.bcU.clear();
    tb();
    AppMethodBeat.o(92083);
  }
  
  static final class a
  {
    public final long bdi;
    public final int size;
    
    public a(long paramLong, int paramInt)
    {
      this.bdi = paramLong;
      this.size = paramInt;
    }
  }
  
  static final class b
  {
    public final com.google.android.exoplayer2.c.m aYi;
    public final l bdj;
    public j bdk;
    public c bdl;
    public int bdm;
    public int bdn;
    public int bdo;
    
    public b(com.google.android.exoplayer2.c.m paramm)
    {
      AppMethodBeat.i(92076);
      this.bdj = new l();
      this.aYi = paramm;
      AppMethodBeat.o(92076);
    }
    
    public final void a(j paramj, c paramc)
    {
      AppMethodBeat.i(92077);
      this.bdk = ((j)com.google.android.exoplayer2.i.a.checkNotNull(paramj));
      this.bdl = ((c)com.google.android.exoplayer2.i.a.checkNotNull(paramc));
      this.aYi.f(paramj.aTo);
      reset();
      AppMethodBeat.o(92077);
    }
    
    public final void b(DrmInitData paramDrmInitData)
    {
      AppMethodBeat.i(92079);
      Object localObject = this.bdk.ek(this.bdj.bei.bcF);
      if (localObject != null) {}
      for (localObject = ((k)localObject).bef;; localObject = null)
      {
        this.aYi.f(this.bdk.aTo.a(paramDrmInitData.an((String)localObject)));
        AppMethodBeat.o(92079);
        return;
      }
    }
    
    public final void reset()
    {
      AppMethodBeat.i(92078);
      this.bdj.reset();
      this.bdm = 0;
      this.bdo = 0;
      this.bdn = 0;
      AppMethodBeat.o(92078);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.exoplayer2.c.d.e
 * JD-Core Version:    0.7.0.1
 */