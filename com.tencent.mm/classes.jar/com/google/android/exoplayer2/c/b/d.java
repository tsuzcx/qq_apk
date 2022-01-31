package com.google.android.exoplayer2.c.b;

import android.util.Pair;
import android.util.SparseArray;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.c.j.a;
import com.google.android.exoplayer2.c.k;
import com.google.android.exoplayer2.c.k.a;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.drm.DrmInitData.SchemeData;
import com.google.android.exoplayer2.i.h;
import com.google.android.exoplayer2.i.j;
import com.google.android.exoplayer2.i.q;
import com.google.android.exoplayer2.i.t;
import com.google.android.exoplayer2.o;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;
import java.util.UUID;

public final class d
  implements com.google.android.exoplayer2.c.d
{
  private static final int aBO = t.aG("seig");
  private static final byte[] aBP = { -94, 57, 79, 82, 90, -101, 79, 20, -94, 68, 108, 66, 124, 100, -115, -12 };
  public static final com.google.android.exoplayer2.c.g azq = new d.1();
  private final e aBQ;
  private final SparseArray<d.b> aBR;
  private final j aBS;
  private final j aBT;
  private final j aBU;
  private final j aBV;
  private final j aBW;
  private final q aBX;
  private final j aBY;
  private final byte[] aBZ;
  private final Stack<a.a> aCa;
  private final LinkedList<a> aCb;
  private int aCc;
  private int aCd;
  private long aCe;
  private int aCf;
  private j aCg;
  private long aCh;
  private int aCi;
  private long aCj;
  private d.b aCk;
  private int aCl;
  private int aCm;
  private boolean aCn;
  private k aCo;
  private k[] aCp;
  private boolean aCq;
  private long auP;
  private com.google.android.exoplayer2.c.f azy;
  private final int flags = 0;
  private int sampleSize;
  
  public d()
  {
    this((byte)0);
  }
  
  private d(byte paramByte)
  {
    this(null);
  }
  
  public d(q paramq)
  {
    this(paramq, (byte)0);
  }
  
  private d(q paramq, byte paramByte)
  {
    this.aBX = paramq;
    this.aBQ = null;
    this.aBY = new j(16);
    this.aBS = new j(h.aSg);
    this.aBT = new j(5);
    this.aBU = new j();
    this.aBV = new j(1);
    this.aBW = new j();
    this.aBZ = new byte[16];
    this.aCa = new Stack();
    this.aCb = new LinkedList();
    this.aBR = new SparseArray();
    this.auP = -9223372036854775807L;
    this.aCj = -9223372036854775807L;
    lW();
  }
  
  private void G(long paramLong)
  {
    while ((!this.aCa.isEmpty()) && (((a.a)this.aCa.peek()).aBz == paramLong))
    {
      Object localObject1 = (a.a)this.aCa.pop();
      if (((a.a)localObject1).type == a.aAl)
      {
        boolean bool;
        Object localObject2;
        SparseArray localSparseArray;
        if (this.aBQ == null)
        {
          bool = true;
          com.google.android.exoplayer2.i.a.c(bool, "Unexpected moov box.");
          localObject2 = q(((a.a)localObject1).aBA);
          localObject3 = ((a.a)localObject1).cX(a.aAw);
          localSparseArray = new SparseArray();
          l = -9223372036854775807L;
          j = ((a.a)localObject3).aBA.size();
          i = 0;
          label116:
          if (i >= j) {
            break label295;
          }
          localObject4 = (a.b)((a.a)localObject3).aBA.get(i);
          if (((a.b)localObject4).type != a.aAi) {
            break label239;
          }
          localObject4 = ((a.b)localObject4).aBC;
          ((j)localObject4).setPosition(12);
          localObject4 = Pair.create(Integer.valueOf(((j)localObject4).readInt()), new c(((j)localObject4).oh() - 1, ((j)localObject4).oh(), ((j)localObject4).oh(), ((j)localObject4).readInt()));
          localSparseArray.put(((Integer)((Pair)localObject4).first).intValue(), ((Pair)localObject4).second);
        }
        label239:
        while (((a.b)localObject4).type != a.aAx)
        {
          i += 1;
          break label116;
          bool = false;
          break;
        }
        Object localObject4 = ((a.b)localObject4).aBC;
        ((j)localObject4).setPosition(8);
        if (a.cT(((j)localObject4).readInt()) == 0) {}
        for (long l = ((j)localObject4).bp();; l = ((j)localObject4).oi()) {
          break;
        }
        label295:
        Object localObject3 = new SparseArray();
        int j = ((a.a)localObject1).aBB.size();
        int i = 0;
        if (i < j)
        {
          localObject4 = (a.a)((a.a)localObject1).aBB.get(i);
          a.b localb;
          if (((a.a)localObject4).type == a.aAn)
          {
            localb = ((a.a)localObject1).cW(a.aAm);
            if ((this.flags & 0x20) == 0) {
              break label413;
            }
          }
          label413:
          for (bool = true;; bool = false)
          {
            localObject4 = b.a((a.a)localObject4, localb, l, (DrmInitData)localObject2, bool);
            if (localObject4 != null) {
              ((SparseArray)localObject3).put(((e)localObject4).id, localObject4);
            }
            i += 1;
            break;
          }
        }
        j = ((SparseArray)localObject3).size();
        if (this.aBR.size() == 0)
        {
          i = 0;
          while (i < j)
          {
            localObject1 = (e)((SparseArray)localObject3).valueAt(i);
            localObject2 = new d.b(this.azy.cQ(i));
            ((d.b)localObject2).a((e)localObject1, (c)localSparseArray.get(((e)localObject1).id));
            this.aBR.put(((e)localObject1).id, localObject2);
            this.auP = Math.max(this.auP, ((e)localObject1).auP);
            i += 1;
          }
          lX();
          this.azy.lV();
        }
        else
        {
          if (this.aBR.size() == j) {}
          for (bool = true;; bool = false)
          {
            com.google.android.exoplayer2.i.a.aC(bool);
            i = 0;
            while (i < j)
            {
              localObject1 = (e)((SparseArray)localObject3).valueAt(i);
              ((d.b)this.aBR.get(((e)localObject1).id)).a((e)localObject1, (c)localSparseArray.get(((e)localObject1).id));
              i += 1;
            }
          }
        }
      }
      else if (((a.a)localObject1).type == a.aAu)
      {
        b((a.a)localObject1);
      }
      else if (!this.aCa.isEmpty())
      {
        ((a.a)this.aCa.peek()).aBB.add(localObject1);
      }
    }
    lW();
  }
  
  private static void a(j paramj, int paramInt, g paramg)
  {
    paramj.setPosition(paramInt + 8);
    paramInt = a.cU(paramj.readInt());
    if ((paramInt & 0x1) != 0) {
      throw new o("Overriding TrackEncryptionBox parameters is unsupported.");
    }
    if ((paramInt & 0x2) != 0) {}
    for (boolean bool = true;; bool = false)
    {
      paramInt = paramj.oh();
      if (paramInt == paramg.sampleCount) {
        break;
      }
      throw new o("Length mismatch: " + paramInt + ", " + paramg.sampleCount);
    }
    Arrays.fill(paramg.aCW, 0, paramInt, bool);
    paramg.cZ(paramj.oe());
    paramj.readBytes(paramg.aCZ.data, 0, paramg.aCY);
    paramg.aCZ.setPosition(0);
    paramg.aDa = false;
  }
  
  private void b(a.a parama)
  {
    Object localObject3 = this.aBR;
    int i11 = this.flags;
    byte[] arrayOfByte = this.aBZ;
    int i12 = parama.aBB.size();
    int m = 0;
    a.a locala;
    Object localObject2;
    int n;
    int i;
    label110:
    Object localObject1;
    Object localObject4;
    long l1;
    if (m < i12)
    {
      locala = (a.a)parama.aBB.get(m);
      if (locala.type == a.aAv)
      {
        localObject2 = locala.cW(a.aAh).aBC;
        ((j)localObject2).setPosition(8);
        n = a.cU(((j)localObject2).readInt());
        i = ((j)localObject2).readInt();
        if ((i11 & 0x10) == 0)
        {
          localObject1 = (d.b)((SparseArray)localObject3).get(i);
          if (localObject1 != null) {
            break label312;
          }
          localObject1 = null;
          if (localObject1 == null) {
            break label2070;
          }
          localObject4 = ((d.b)localObject1).aCs;
          l1 = ((g)localObject4).aDb;
          ((d.b)localObject1).reset();
          if ((locala.cW(a.aAg) == null) || ((i11 & 0x2) != 0)) {
            break label2347;
          }
          localObject2 = locala.cW(a.aAg).aBC;
          ((j)localObject2).setPosition(8);
          if (a.cT(((j)localObject2).readInt()) != 1) {
            break label474;
          }
          l1 = ((j)localObject2).oi();
        }
      }
    }
    label397:
    label803:
    label936:
    label1193:
    label2347:
    for (;;)
    {
      label210:
      int k = 0;
      i = 0;
      localObject2 = locala.aBA;
      int i13 = ((List)localObject2).size();
      int j = 0;
      label233:
      Object localObject5;
      if (j < i13)
      {
        localObject5 = (a.b)((List)localObject2).get(j);
        if (((a.b)localObject5).type != a.aAj) {
          break label2344;
        }
        localObject5 = ((a.b)localObject5).aBC;
        ((j)localObject5).setPosition(12);
        n = ((j)localObject5).oh();
        if (n <= 0) {
          break label2344;
        }
        i = n + i;
        k += 1;
      }
      for (;;)
      {
        j += 1;
        break label233;
        i = 0;
        break label110;
        label312:
        if ((n & 0x1) != 0)
        {
          l1 = ((j)localObject2).oi();
          ((d.b)localObject1).aCs.aCM = l1;
          ((d.b)localObject1).aCs.aCN = l1;
        }
        localObject4 = ((d.b)localObject1).aCv;
        if ((n & 0x2) != 0)
        {
          i = ((j)localObject2).oh() - 1;
          label368:
          if ((n & 0x8) == 0) {
            break label445;
          }
          j = ((j)localObject2).oh();
          label382:
          if ((n & 0x10) == 0) {
            break label454;
          }
          k = ((j)localObject2).oh();
          if ((n & 0x20) == 0) {
            break label464;
          }
        }
        label445:
        label454:
        label464:
        for (n = ((j)localObject2).oh();; n = ((c)localObject4).flags)
        {
          ((d.b)localObject1).aCs.aCK = new c(i, j, k, n);
          break;
          i = ((c)localObject4).aBN;
          break label368;
          j = ((c)localObject4).duration;
          break label382;
          k = ((c)localObject4).size;
          break label397;
        }
        label474:
        l1 = ((j)localObject2).bp();
        break label210;
        ((d.b)localObject1).aCy = 0;
        ((d.b)localObject1).aCx = 0;
        ((d.b)localObject1).aCw = 0;
        localObject5 = ((d.b)localObject1).aCs;
        ((g)localObject5).aCO = k;
        ((g)localObject5).sampleCount = i;
        if ((((g)localObject5).aCQ == null) || (((g)localObject5).aCQ.length < k))
        {
          ((g)localObject5).aCP = new long[k];
          ((g)localObject5).aCQ = new int[k];
        }
        if ((((g)localObject5).aCR == null) || (((g)localObject5).aCR.length < i))
        {
          i = i * 125 / 100;
          ((g)localObject5).aCR = new int[i];
          ((g)localObject5).aCS = new int[i];
          ((g)localObject5).aCT = new long[i];
          ((g)localObject5).aCU = new boolean[i];
          ((g)localObject5).aCW = new boolean[i];
        }
        j = 0;
        i = 0;
        n = 0;
        label632:
        int i5;
        Object localObject6;
        g localg;
        c localc;
        Object localObject7;
        int i1;
        int i2;
        int i3;
        label815:
        int i4;
        if (n < i13)
        {
          localObject5 = (a.b)((List)localObject2).get(n);
          if (((a.b)localObject5).type != a.aAj) {
            break label2327;
          }
          localObject5 = ((a.b)localObject5).aBC;
          ((j)localObject5).setPosition(8);
          i5 = a.cU(((j)localObject5).readInt());
          localObject6 = ((d.b)localObject1).aCu;
          localg = ((d.b)localObject1).aCs;
          localc = localg.aCK;
          localg.aCQ[j] = ((j)localObject5).oh();
          localg.aCP[j] = localg.aCM;
          if ((i5 & 0x1) != 0)
          {
            localObject7 = localg.aCP;
            localObject7[j] += ((j)localObject5).readInt();
          }
          if ((i5 & 0x4) != 0)
          {
            i1 = 1;
            k = localc.flags;
            if (i1 != 0) {
              k = ((j)localObject5).oh();
            }
            if ((i5 & 0x100) == 0) {
              break label1113;
            }
            i2 = 1;
            if ((i5 & 0x200) == 0) {
              break label1119;
            }
            i3 = 1;
            if ((i5 & 0x400) == 0) {
              break label1125;
            }
            i4 = 1;
            label827:
            if ((i5 & 0x800) == 0) {
              break label1131;
            }
            i5 = 1;
            label839:
            if ((((e)localObject6).aCC == null) || (((e)localObject6).aCC.length != 1) || (localObject6.aCC[0] != 0L)) {
              break label2338;
            }
          }
        }
        for (long l3 = t.b(localObject6.aCD[0], 1000L, ((e)localObject6).aCz);; l3 = 0L)
        {
          localObject7 = localg.aCR;
          int[] arrayOfInt = localg.aCS;
          long[] arrayOfLong = localg.aCT;
          boolean[] arrayOfBoolean = localg.aCU;
          int i6;
          int i10;
          long l2;
          label965:
          int i7;
          label968:
          int i8;
          label987:
          int i9;
          if ((((e)localObject6).type == 2) && ((i11 & 0x1) != 0))
          {
            i6 = 1;
            i10 = i + localg.aCQ[j];
            long l4 = ((e)localObject6).aCz;
            if (j <= 0) {
              break label1143;
            }
            l2 = localg.aDb;
            i7 = i;
            if (i7 >= i10) {
              break label1208;
            }
            if (i2 == 0) {
              break label1150;
            }
            i8 = ((j)localObject5).oh();
            if (i3 == 0) {
              break label1160;
            }
            i9 = ((j)localObject5).oh();
            label999:
            if ((i7 != 0) || (i1 == 0)) {
              break label1170;
            }
            i = k;
            label1012:
            if (i5 == 0) {
              break label1193;
            }
            arrayOfInt[i7] = ((int)(((j)localObject5).readInt() * 1000L / l4));
            arrayOfLong[i7] = (t.b(l2, 1000L, l4) - l3);
            localObject7[i7] = i9;
            if (((i >> 16 & 0x1) != 0) || ((i6 != 0) && (i7 != 0))) {
              break label1202;
            }
          }
          label1202:
          for (boolean bool = true;; bool = false)
          {
            arrayOfBoolean[i7] = bool;
            l2 += i8;
            i7 += 1;
            break label968;
            i1 = 0;
            break;
            label1113:
            i2 = 0;
            break label803;
            label1119:
            i3 = 0;
            break label815;
            label1125:
            i4 = 0;
            break label827;
            label1131:
            i5 = 0;
            break label839;
            i6 = 0;
            break label936;
            label1143:
            l2 = l1;
            break label965;
            label1150:
            i8 = localc.duration;
            break label987;
            i9 = localc.size;
            break label999;
            if (i4 != 0)
            {
              i = ((j)localObject5).readInt();
              break label1012;
            }
            i = localc.flags;
            break label1012;
            arrayOfInt[i7] = 0;
            break label1036;
          }
          label1208:
          localg.aDb = l2;
          k = i10;
          i = j + 1;
          j = k;
          for (;;)
          {
            k = i;
            n += 1;
            i = j;
            j = k;
            break label632;
            localObject1 = ((d.b)localObject1).aCu.cY(((g)localObject4).aCK.aBN);
            localObject2 = locala.cW(a.aAM);
            if (localObject2 != null)
            {
              localObject2 = ((a.b)localObject2).aBC;
              n = ((f)localObject1).aCI;
              ((j)localObject2).setPosition(8);
              if ((a.cU(((j)localObject2).readInt()) & 0x1) == 1) {
                ((j)localObject2).dB(8);
              }
              j = ((j)localObject2).readUnsignedByte();
              i1 = ((j)localObject2).oh();
              if (i1 != ((g)localObject4).sampleCount) {
                throw new o("Length mismatch: " + i1 + ", " + ((g)localObject4).sampleCount);
              }
              i = 0;
              if (j == 0)
              {
                localObject5 = ((g)localObject4).aCW;
                j = 0;
                k = i;
                if (j < i1)
                {
                  k = ((j)localObject2).readUnsignedByte();
                  if (k > n) {}
                  for (bool = true;; bool = false)
                  {
                    localObject5[j] = bool;
                    j += 1;
                    i += k;
                    break;
                  }
                }
              }
              else
              {
                if (j <= n) {
                  break label1571;
                }
              }
            }
            for (bool = true;; bool = false)
            {
              Arrays.fill(((g)localObject4).aCW, 0, i1, bool);
              k = j * i1 + 0;
              ((g)localObject4).cZ(k);
              localObject2 = locala.cW(a.aAN);
              if (localObject2 == null) {
                break label1610;
              }
              localObject2 = ((a.b)localObject2).aBC;
              ((j)localObject2).setPosition(8);
              i = ((j)localObject2).readInt();
              if ((a.cU(i) & 0x1) == 1) {
                ((j)localObject2).dB(8);
              }
              j = ((j)localObject2).oh();
              if (j == 1) {
                break;
              }
              throw new o("Unexpected saio entry count: " + j);
            }
            i = a.cT(i);
            l2 = ((g)localObject4).aCN;
            if (i == 0)
            {
              l1 = ((j)localObject2).bp();
              ((g)localObject4).aCN = (l1 + l2);
              label1610:
              localObject2 = locala.cW(a.aAR);
              if (localObject2 != null) {
                a(((a.b)localObject2).aBC, 0, (g)localObject4);
              }
              localObject2 = locala.cW(a.aAO);
              localObject5 = locala.cW(a.aAP);
              if ((localObject2 == null) || (localObject5 == null)) {
                break label1969;
              }
              localObject2 = ((a.b)localObject2).aBC;
              localObject5 = ((a.b)localObject5).aBC;
              if (localObject1 == null) {
                break label1760;
              }
            }
            label1760:
            for (localObject1 = ((f)localObject1).aCG;; localObject1 = null)
            {
              ((j)localObject2).setPosition(8);
              i = ((j)localObject2).readInt();
              if (((j)localObject2).readInt() != aBO) {
                break label1969;
              }
              if (a.cT(i) == 1) {
                ((j)localObject2).dB(4);
              }
              if (((j)localObject2).readInt() == 1) {
                break label1766;
              }
              throw new o("Entry count in sbgp != 1 (unsupported).");
              l1 = ((j)localObject2).oi();
              break;
            }
            label1766:
            ((j)localObject5).setPosition(8);
            i = ((j)localObject5).readInt();
            if (((j)localObject5).readInt() == aBO)
            {
              i = a.cT(i);
              if (i == 1)
              {
                if (((j)localObject5).bp() == 0L) {
                  throw new o("Variable length description in sgpd found (unsupported)");
                }
              }
              else if (i >= 2) {
                ((j)localObject5).dB(4);
              }
              if (((j)localObject5).bp() != 1L) {
                throw new o("Entry count in sgpd != 1 (unsupported).");
              }
              ((j)localObject5).dB(1);
              j = ((j)localObject5).readUnsignedByte();
              if (((j)localObject5).readUnsignedByte() != 1) {
                break label2065;
              }
            }
            for (i = 1;; i = 0)
            {
              if (i != 0)
              {
                i = ((j)localObject5).readUnsignedByte();
                localObject6 = new byte[16];
                ((j)localObject5).readBytes((byte[])localObject6, 0, 16);
                localObject2 = null;
                if (i == 0)
                {
                  k = ((j)localObject5).readUnsignedByte();
                  localObject2 = new byte[k];
                  ((j)localObject5).readBytes((byte[])localObject2, 0, k);
                }
                ((g)localObject4).aCV = true;
                ((g)localObject4).aCX = new f(true, (String)localObject1, i, (byte[])localObject6, (j & 0xF0) >> 4, j & 0xF, (byte[])localObject2);
              }
              label1969:
              j = locala.aBA.size();
              i = 0;
              while (i < j)
              {
                localObject1 = (a.b)locala.aBA.get(i);
                if (((a.b)localObject1).type == a.aAQ)
                {
                  localObject1 = ((a.b)localObject1).aBC;
                  ((j)localObject1).setPosition(8);
                  ((j)localObject1).readBytes(arrayOfByte, 0, 16);
                  if (Arrays.equals(arrayOfByte, aBP)) {
                    a((j)localObject1, 16, (g)localObject4);
                  }
                }
                i += 1;
              }
            }
            m += 1;
            break;
            localObject1 = q(parama.aBA);
            if (localObject1 != null)
            {
              j = this.aBR.size();
              i = 0;
              if (i < j)
              {
                localObject2 = (d.b)this.aBR.valueAt(i);
                parama = ((d.b)localObject2).aCu.cY(((d.b)localObject2).aCs.aCK.aBN);
                if (parama != null) {}
                for (parama = parama.aCG;; parama = null)
                {
                  localObject3 = ((d.b)localObject2).aCt;
                  localObject2 = ((d.b)localObject2).aCu.auL;
                  parama = ((DrmInitData)localObject1).ak(parama);
                  ((k)localObject3).f(new Format(((Format)localObject2).id, ((Format)localObject2).aur, ((Format)localObject2).aus, ((Format)localObject2).aup, ((Format)localObject2).bitrate, ((Format)localObject2).aut, ((Format)localObject2).width, ((Format)localObject2).height, ((Format)localObject2).auw, ((Format)localObject2).aux, ((Format)localObject2).auy, ((Format)localObject2).auA, ((Format)localObject2).auz, ((Format)localObject2).auB, ((Format)localObject2).auC, ((Format)localObject2).sampleRate, ((Format)localObject2).auD, ((Format)localObject2).auE, ((Format)localObject2).auF, ((Format)localObject2).auH, ((Format)localObject2).auI, ((Format)localObject2).auJ, ((Format)localObject2).auG, ((Format)localObject2).auu, parama, ((Format)localObject2).auq));
                  i += 1;
                  break;
                }
              }
            }
            return;
            k = j;
            j = i;
            i = k;
          }
        }
      }
    }
  }
  
  private void lW()
  {
    this.aCc = 0;
    this.aCf = 0;
  }
  
  private void lX()
  {
    if (((this.flags & 0x4) != 0) && (this.aCo == null))
    {
      this.aCo = this.azy.cQ(this.aBR.size());
      this.aCo.f(Format.b("application/x-emsg", 9223372036854775807L));
    }
    if (((this.flags & 0x8) != 0) && (this.aCp == null))
    {
      k localk = this.azy.cQ(this.aBR.size() + 1);
      localk.f(Format.ah("application/cea-608"));
      this.aCp = new k[] { localk };
    }
  }
  
  private static DrmInitData q(List<a.b> paramList)
  {
    int j = paramList.size();
    int i = 0;
    Object localObject1 = null;
    if (i < j)
    {
      Object localObject4 = (a.b)paramList.get(i);
      Object localObject3 = localObject1;
      Object localObject2;
      if (((a.b)localObject4).type == a.aAE)
      {
        localObject2 = localObject1;
        if (localObject1 == null) {
          localObject2 = new ArrayList();
        }
        localObject4 = ((a.b)localObject4).aBC.data;
        localObject1 = new j((byte[])localObject4);
        if (((j)localObject1).limit >= 32) {
          break label148;
        }
        localObject1 = null;
        label96:
        if (localObject1 != null) {
          break label296;
        }
      }
      label148:
      label296:
      for (localObject1 = null;; localObject1 = (UUID)((Pair)localObject1).first)
      {
        localObject3 = localObject2;
        if (localObject1 != null)
        {
          ((ArrayList)localObject2).add(new DrmInitData.SchemeData((UUID)localObject1, "video/mp4", (byte[])localObject4));
          localObject3 = localObject2;
        }
        i += 1;
        localObject1 = localObject3;
        break;
        ((j)localObject1).setPosition(0);
        if (((j)localObject1).readInt() != ((j)localObject1).oe() + 4)
        {
          localObject1 = null;
          break label96;
        }
        if (((j)localObject1).readInt() != a.aAE)
        {
          localObject1 = null;
          break label96;
        }
        int k = a.cT(((j)localObject1).readInt());
        if (k > 1)
        {
          localObject1 = null;
          break label96;
        }
        localObject3 = new UUID(((j)localObject1).readLong(), ((j)localObject1).readLong());
        if (k == 1) {
          ((j)localObject1).dB(((j)localObject1).oh() * 16);
        }
        k = ((j)localObject1).oh();
        if (k != ((j)localObject1).oe())
        {
          localObject1 = null;
          break label96;
        }
        byte[] arrayOfByte = new byte[k];
        ((j)localObject1).readBytes(arrayOfByte, 0, k);
        localObject1 = Pair.create(localObject3, arrayOfByte);
        break label96;
      }
    }
    if (localObject1 == null) {
      return null;
    }
    return new DrmInitData((List)localObject1);
  }
  
  public final int a(com.google.android.exoplayer2.c.e parame)
  {
    Object localObject3;
    Object localObject2;
    long l2;
    label133:
    do
    {
      switch (this.aCc)
      {
      default: 
        if (this.aCc != 3) {
          break label2030;
        }
        if (this.aCk != null) {
          break;
        }
        localObject3 = this.aBR;
        localObject1 = null;
        l1 = 9223372036854775807L;
        j = ((SparseArray)localObject3).size();
        i = 0;
        while (i < j)
        {
          localObject2 = (d.b)((SparseArray)localObject3).valueAt(i);
          if (((d.b)localObject2).aCy == ((d.b)localObject2).aCs.aCO) {
            break label2890;
          }
          l2 = localObject2.aCs.aCP[localObject2.aCy];
          if (l2 >= l1) {
            break label2890;
          }
          l1 = l2;
          localObject1 = localObject2;
          i += 1;
        }
      case 0: 
        if (this.aCf != 0) {
          break label211;
        }
        if (parame.a(this.aBY.data, 0, 8, true)) {
          break label175;
        }
        i = 0;
      }
    } while (i != 0);
    return -1;
    label175:
    this.aCf = 8;
    this.aBY.setPosition(0);
    this.aCe = this.aBY.bp();
    this.aCd = this.aBY.readInt();
    label211:
    if (this.aCe == 1L)
    {
      parame.readFully(this.aBY.data, 8, 8);
      this.aCf += 8;
      this.aCe = this.aBY.oi();
    }
    while (this.aCe < this.aCf)
    {
      throw new o("Atom size less than header length (unsupported).");
      if (this.aCe == 0L)
      {
        l2 = parame.getLength();
        l1 = l2;
        if (l2 == -1L)
        {
          l1 = l2;
          if (!this.aCa.isEmpty()) {
            l1 = ((a.a)this.aCa.peek()).aBz;
          }
        }
        if (l1 != -1L) {
          this.aCe = (l1 - parame.getPosition() + this.aCf);
        }
      }
    }
    long l1 = parame.getPosition() - this.aCf;
    if (this.aCd == a.aAu)
    {
      j = this.aBR.size();
      i = 0;
      while (i < j)
      {
        localObject1 = ((d.b)this.aBR.valueAt(i)).aCs;
        ((g)localObject1).aCL = l1;
        ((g)localObject1).aCN = l1;
        ((g)localObject1).aCM = l1;
        i += 1;
      }
    }
    if (this.aCd == a.azR)
    {
      this.aCk = null;
      this.aCh = (this.aCe + l1);
      if (!this.aCq)
      {
        new j.a(this.auP);
        this.aCq = true;
      }
      this.aCc = 2;
    }
    for (;;)
    {
      i = 1;
      break;
      i = this.aCd;
      if ((i == a.aAl) || (i == a.aAn) || (i == a.aAo) || (i == a.aAp) || (i == a.aAq) || (i == a.aAu) || (i == a.aAv) || (i == a.aAw) || (i == a.aAz)) {
        i = 1;
      }
      for (;;)
      {
        if (i != 0)
        {
          l1 = parame.getPosition() + this.aCe - 8L;
          this.aCa.add(new a.a(this.aCd, l1));
          if (this.aCe == this.aCf)
          {
            G(l1);
            break;
            i = 0;
            continue;
          }
          lW();
          break;
        }
      }
      i = this.aCd;
      if ((i == a.aAC) || (i == a.aAB) || (i == a.aAm) || (i == a.aAk) || (i == a.aAD) || (i == a.aAg) || (i == a.aAh) || (i == a.aAy) || (i == a.aAi) || (i == a.aAj) || (i == a.aAE) || (i == a.aAM) || (i == a.aAN) || (i == a.aAR) || (i == a.aAQ) || (i == a.aAO) || (i == a.aAP) || (i == a.aAA) || (i == a.aAx) || (i == a.aBq)) {
        i = 1;
      }
      for (;;)
      {
        if (i != 0) {
          if (this.aCf != 8)
          {
            throw new o("Leaf atom defines extended atom size (unsupported).");
            i = 0;
          }
          else
          {
            if (this.aCe > 2147483647L) {
              throw new o("Leaf atom with length > 2147483647 (unsupported).");
            }
            this.aCg = new j((int)this.aCe);
            System.arraycopy(this.aBY.data, 0, this.aCg.data, 0, 8);
            this.aCc = 1;
            break;
          }
        }
      }
      if (this.aCe > 2147483647L) {
        throw new o("Skipping atom with length > 2147483647 (unsupported).");
      }
      this.aCg = null;
      this.aCc = 1;
    }
    int i = (int)this.aCe - this.aCf;
    if (this.aCg != null)
    {
      parame.readFully(this.aCg.data, 8, i);
      localObject1 = new a.b(this.aCd, this.aCg);
      l2 = parame.getPosition();
      if (!this.aCa.isEmpty()) {
        ((a.a)this.aCa.peek()).aBA.add(localObject1);
      }
    }
    Object localObject4;
    Object localObject5;
    int k;
    for (;;)
    {
      G(parame.getPosition());
      break;
      if (((a.b)localObject1).type == a.aAk)
      {
        localObject1 = ((a.b)localObject1).aBC;
        ((j)localObject1).setPosition(8);
        i = a.cT(((j)localObject1).readInt());
        ((j)localObject1).dB(4);
        long l5 = ((j)localObject1).bp();
        long l4;
        long l3;
        if (i == 0)
        {
          l1 = ((j)localObject1).bp();
          l2 += ((j)localObject1).bp();
          l4 = t.b(l1, 1000000L, l5);
          ((j)localObject1).dB(2);
          j = ((j)localObject1).readUnsignedShort();
          localObject2 = new int[j];
          localObject3 = new long[j];
          localObject4 = new long[j];
          localObject5 = new long[j];
          i = 0;
          l3 = l4;
        }
        for (;;)
        {
          if (i >= j) {
            break label1295;
          }
          k = ((j)localObject1).readInt();
          if ((0x80000000 & k) != 0)
          {
            throw new o("Unhandled indirect reference");
            l1 = ((j)localObject1).oi();
            l2 += ((j)localObject1).oi();
            break;
          }
          long l6 = ((j)localObject1).bp();
          localObject2[i] = (k & 0x7FFFFFFF);
          localObject3[i] = l2;
          localObject5[i] = l3;
          l1 += l6;
          l3 = t.b(l1, 1000000L, l5);
          localObject4[i] = (l3 - localObject5[i]);
          ((j)localObject1).dB(4);
          l2 += localObject2[i];
          i += 1;
        }
        label1295:
        localObject1 = Pair.create(Long.valueOf(l4), new com.google.android.exoplayer2.c.a((int[])localObject2, (long[])localObject3, (long[])localObject4, (long[])localObject5));
        this.aCj = ((Long)((Pair)localObject1).first).longValue();
        localObject1 = ((Pair)localObject1).second;
        this.aCq = true;
      }
      else if (((a.b)localObject1).type == a.aBq)
      {
        localObject1 = ((a.b)localObject1).aBC;
        if (this.aCo != null)
        {
          ((j)localObject1).setPosition(12);
          ((j)localObject1).oj();
          ((j)localObject1).oj();
          l1 = ((j)localObject1).bp();
          l1 = t.b(((j)localObject1).bp(), 1000000L, l1);
          ((j)localObject1).setPosition(12);
          i = ((j)localObject1).oe();
          this.aCo.a((j)localObject1, i);
          if (this.aCj != -9223372036854775807L)
          {
            this.aCo.a(l1 + this.aCj, 1, i, 0, null);
          }
          else
          {
            this.aCb.addLast(new a(l1, i));
            this.aCi += i;
            continue;
            parame.cL(i);
          }
        }
      }
    }
    Object localObject1 = null;
    l1 = 9223372036854775807L;
    int j = this.aBR.size();
    i = 0;
    label1533:
    if (i < j)
    {
      localObject2 = ((d.b)this.aBR.valueAt(i)).aCs;
      if ((!((g)localObject2).aDa) || (((g)localObject2).aCN >= l1)) {
        break label2893;
      }
      l1 = ((g)localObject2).aCN;
      localObject1 = (d.b)this.aBR.valueAt(i);
    }
    label1969:
    label1987:
    label2887:
    label2890:
    label2893:
    for (;;)
    {
      i += 1;
      break label1533;
      if (localObject1 == null)
      {
        this.aCc = 3;
        break;
      }
      i = (int)(l1 - parame.getPosition());
      if (i < 0) {
        throw new o("Offset to encryption data was negative.");
      }
      parame.cL(i);
      localObject1 = ((d.b)localObject1).aCs;
      parame.readFully(((g)localObject1).aCZ.data, 0, ((g)localObject1).aCY);
      ((g)localObject1).aCZ.setPosition(0);
      ((g)localObject1).aDa = false;
      break;
      if (localObject1 == null)
      {
        i = (int)(this.aCh - parame.getPosition());
        if (i < 0) {
          throw new o("Offset to end of mdat was negative.");
        }
        parame.cL(i);
        lW();
        i = 0;
        if (i == 0) {
          break;
        }
        return 0;
      }
      j = (int)(localObject1.aCs.aCP[localObject1.aCy] - parame.getPosition());
      i = j;
      if (j < 0) {
        i = 0;
      }
      parame.cL(i);
      this.aCk = ((d.b)localObject1);
      this.sampleSize = this.aCk.aCs.aCR[this.aCk.aCw];
      label1884:
      label1915:
      int n;
      if (this.aCk.aCs.aCV)
      {
        localObject4 = this.aCk;
        localObject3 = ((d.b)localObject4).aCs;
        i = ((g)localObject3).aCK.aBN;
        if (((g)localObject3).aCX != null)
        {
          localObject1 = ((g)localObject3).aCX;
          if (((f)localObject1).aCI == 0) {
            break label2271;
          }
          localObject2 = ((g)localObject3).aCZ;
          i = ((f)localObject1).aCI;
          localObject1 = localObject2;
          i2 = localObject3.aCW[localObject4.aCw];
          localObject2 = this.aBV.data;
          if (i2 == 0) {
            break label2303;
          }
          j = 128;
          localObject2[0] = ((byte)(j | i));
          this.aBV.setPosition(0);
          localObject2 = ((d.b)localObject4).aCt;
          ((k)localObject2).a(this.aBV, 1);
          ((k)localObject2).a((j)localObject1, i);
          if (i2 != 0) {
            break label2308;
          }
          i += 1;
          this.aCl = i;
          this.sampleSize += this.aCl;
          if (this.aCk.aCu.aCB == 1)
          {
            this.sampleSize -= 8;
            parame.cL(8);
          }
          this.aCc = 4;
          this.aCm = 0;
          label2030:
          localObject2 = this.aCk.aCs;
          localObject4 = this.aCk.aCu;
          localObject3 = this.aCk.aCt;
          k = this.aCk.aCw;
          if (((e)localObject4).aBL == 0) {
            break label2552;
          }
          localObject1 = this.aBT.data;
          localObject1[0] = 0;
          localObject1[1] = 0;
          localObject1[2] = 0;
          int m = ((e)localObject4).aBL;
          n = 4 - ((e)localObject4).aBL;
          if (this.aCl >= this.sampleSize) {
            break label2593;
          }
          if (this.aCm != 0) {
            break label2368;
          }
          parame.readFully((byte[])localObject1, n, m + 1);
          this.aBT.setPosition(0);
          this.aCm = (this.aBT.oh() - 1);
          this.aBS.setPosition(0);
          ((k)localObject3).a(this.aBS, 4);
          ((k)localObject3).a(this.aBT, 1);
          if ((this.aCp == null) || (!h.b(((e)localObject4).auL.aus, localObject1[4]))) {
            break label2362;
          }
        }
      }
      for (int i2 = 1;; i2 = 0)
      {
        this.aCn = i2;
        this.aCl += 5;
        this.sampleSize += n;
        break label2114;
        localObject1 = ((d.b)localObject4).aCu.cY(i);
        break;
        label2271:
        localObject2 = ((f)localObject1).aCJ;
        this.aBW.m((byte[])localObject2, localObject2.length);
        localObject1 = this.aBW;
        i = localObject2.length;
        break label1884;
        label2303:
        j = 0;
        break label1915;
        localObject1 = ((g)localObject3).aCZ;
        j = ((j)localObject1).readUnsignedShort();
        ((j)localObject1).dB(-2);
        j = j * 6 + 2;
        ((k)localObject2).a((j)localObject1, j);
        i = i + 1 + j;
        break label1969;
        this.aCl = 0;
        break label1987;
      }
      if (this.aCn)
      {
        this.aBU.reset(this.aCm);
        parame.readFully(this.aBU.data, 0, this.aCm);
        ((k)localObject3).a(this.aBU, this.aCm);
        j = this.aCm;
        int i1 = h.i(this.aBU.data, this.aBU.limit);
        localObject5 = this.aBU;
        if ("video/hevc".equals(((e)localObject4).auL.aus))
        {
          i = 1;
          ((j)localObject5).setPosition(i);
          this.aBU.dA(i1);
          com.google.android.exoplayer2.f.a.g.a(((g)localObject2).da(k) * 1000L, this.aBU, this.aCp);
        }
      }
      for (i = j;; i = ((k)localObject3).a(parame, this.aCm, false))
      {
        this.aCl += i;
        this.aCm -= i;
        break;
        i = 0;
        break label2468;
      }
      label2552:
      while (this.aCl < this.sampleSize) {
        this.aCl = (((k)localObject3).a(parame, this.sampleSize - this.aCl, false) + this.aCl);
      }
      l2 = ((g)localObject2).da(k) * 1000L;
      l1 = l2;
      if (this.aBX != null) {
        l1 = this.aBX.X(l2);
      }
      if (localObject2.aCU[k] != 0)
      {
        i = 1;
        localObject1 = null;
        if (!((g)localObject2).aCV) {
          break label2887;
        }
        i = 0x40000000 | i;
        if (((g)localObject2).aCX == null) {
          break label2769;
        }
        localObject1 = ((g)localObject2).aCX;
        label2673:
        localObject1 = ((f)localObject1).aCH;
      }
      for (;;)
      {
        ((k)localObject3).a(l1, i, this.sampleSize, 0, (k.a)localObject1);
        for (;;)
        {
          if (!this.aCb.isEmpty())
          {
            localObject1 = (a)this.aCb.removeFirst();
            this.aCi -= ((a)localObject1).size;
            this.aCo.a(((a)localObject1).aCr + l1, 1, ((a)localObject1).size, this.aCi, null);
            continue;
            i = 0;
            break;
            label2769:
            localObject1 = ((e)localObject4).cY(((g)localObject2).aCK.aBN);
            break label2673;
          }
        }
        localObject1 = this.aCk;
        ((d.b)localObject1).aCw += 1;
        localObject1 = this.aCk;
        ((d.b)localObject1).aCx += 1;
        if (this.aCk.aCx == localObject2.aCQ[this.aCk.aCy])
        {
          localObject1 = this.aCk;
          ((d.b)localObject1).aCy += 1;
          this.aCk.aCx = 0;
          this.aCk = null;
        }
        this.aCc = 3;
        i = 1;
        break;
      }
      break label133;
    }
  }
  
  public final void a(com.google.android.exoplayer2.c.f paramf)
  {
    this.azy = paramf;
    if (this.aBQ != null)
    {
      paramf = new d.b(paramf.cQ(0));
      paramf.a(this.aBQ, new c(0, 0, 0, 0));
      this.aBR.put(0, paramf);
      lX();
      this.azy.lV();
    }
  }
  
  private static final class a
  {
    public final long aCr;
    public final int size;
    
    public a(long paramLong, int paramInt)
    {
      this.aCr = paramLong;
      this.size = paramInt;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.google.android.exoplayer2.c.b.d
 * JD-Core Version:    0.7.0.1
 */