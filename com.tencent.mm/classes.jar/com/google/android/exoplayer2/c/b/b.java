package com.google.android.exoplayer2.c.b;

import android.util.Pair;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.i.c;
import com.google.android.exoplayer2.i.j;
import com.google.android.exoplayer2.i.t;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

final class b
{
  private static final int aBD = t.aG("vide");
  private static final int aBE = t.aG("soun");
  private static final int aBF = t.aG("text");
  private static final int aBG = t.aG("sbtl");
  private static final int aBH = t.aG("subt");
  private static final int aBI = t.aG("clcp");
  private static final int aBJ = t.aG("cenc");
  private static final int aBl = t.aG("meta");
  
  private static int a(j paramj)
  {
    int j = paramj.readUnsignedByte();
    for (int i = j & 0x7F; (j & 0x80) == 128; i = i << 7 | j & 0x7F) {
      j = paramj.readUnsignedByte();
    }
    return i;
  }
  
  private static Pair<long[], long[]> a(a.a parama)
  {
    if (parama != null)
    {
      parama = parama.cW(a.aAA);
      if (parama != null) {}
    }
    else
    {
      return Pair.create(null, null);
    }
    parama = parama.aBC;
    parama.setPosition(8);
    int j = a.cT(parama.readInt());
    int k = parama.oh();
    long[] arrayOfLong1 = new long[k];
    long[] arrayOfLong2 = new long[k];
    int i = 0;
    while (i < k)
    {
      if (j == 1)
      {
        l = parama.oi();
        arrayOfLong1[i] = l;
        if (j != 1) {
          break label187;
        }
      }
      label187:
      for (long l = parama.readLong();; l = parama.readInt())
      {
        arrayOfLong2[i] = l;
        byte[] arrayOfByte = parama.data;
        int m = parama.position;
        parama.position = (m + 1);
        m = arrayOfByte[m];
        arrayOfByte = parama.data;
        int n = parama.position;
        parama.position = (n + 1);
        if ((short)((m & 0xFF) << 8 | arrayOfByte[n] & 0xFF) == 1) {
          break label197;
        }
        throw new IllegalArgumentException("Unsupported media rate.");
        l = parama.bp();
        break;
      }
      label197:
      parama.dB(2);
      i += 1;
    }
    return Pair.create(arrayOfLong1, arrayOfLong2);
  }
  
  private static Pair<Integer, f> a(j paramj, int paramInt1, int paramInt2)
  {
    int j = paramj.position;
    int i1;
    boolean bool;
    label34:
    int i;
    int k;
    int m;
    Object localObject2;
    Object localObject1;
    label69:
    int n;
    int i2;
    if (j - paramInt1 < paramInt2)
    {
      paramj.setPosition(j);
      i1 = paramj.readInt();
      if (i1 > 0)
      {
        bool = true;
        com.google.android.exoplayer2.i.a.b(bool, "childAtomSize should be positive");
        if (paramj.readInt() != a.aAF) {
          break label500;
        }
        i = j + 8;
        k = -1;
        m = 0;
        localObject2 = null;
        localObject1 = null;
        if (i - j >= i1) {
          break label167;
        }
        paramj.setPosition(i);
        n = paramj.readInt();
        i2 = paramj.readInt();
        if (i2 != a.aAL) {
          break label126;
        }
        localObject1 = Integer.valueOf(paramj.readInt());
      }
    }
    label167:
    label231:
    label244:
    label500:
    for (;;)
    {
      i += n;
      break label69;
      bool = false;
      break label34;
      label126:
      if (i2 == a.aAG)
      {
        paramj.dB(4);
        localObject2 = paramj.readString(4);
      }
      else if (i2 == a.aAH)
      {
        m = n;
        k = i;
        continue;
        if (("cenc".equals(localObject2)) || ("cbc1".equals(localObject2)) || ("cens".equals(localObject2)) || ("cbcs".equals(localObject2))) {
          if (localObject1 != null)
          {
            bool = true;
            com.google.android.exoplayer2.i.a.b(bool, "frma atom is mandatory");
            if (k == -1) {
              break label437;
            }
            bool = true;
            com.google.android.exoplayer2.i.a.b(bool, "schi atom is mandatory");
            i = k + 8;
            if (i - k >= m) {
              break label482;
            }
            paramj.setPosition(i);
            n = paramj.readInt();
            if (paramj.readInt() != a.aAI) {
              break label474;
            }
            m = a.cT(paramj.readInt());
            paramj.dB(1);
            i = 0;
            k = 0;
            if (m != 0) {
              break label443;
            }
            paramj.dB(1);
            if (paramj.readUnsignedByte() != 1) {
              break label468;
            }
            bool = true;
            m = paramj.readUnsignedByte();
            byte[] arrayOfByte = new byte[16];
            paramj.readBytes(arrayOfByte, 0, 16);
            Object localObject4 = null;
            Object localObject3 = localObject4;
            if (bool)
            {
              localObject3 = localObject4;
              if (m == 0)
              {
                n = paramj.readUnsignedByte();
                localObject3 = new byte[n];
                paramj.readBytes((byte[])localObject3, 0, n);
              }
            }
            localObject2 = new f(bool, (String)localObject2, m, arrayOfByte, i, k, (byte[])localObject3);
            if (localObject2 == null) {
              break label488;
            }
            bool = true;
            com.google.android.exoplayer2.i.a.b(bool, "tenc atom is mandatory");
          }
        }
        for (localObject1 = Pair.create(localObject1, localObject2);; localObject1 = null)
        {
          if (localObject1 == null) {
            break label500;
          }
          return localObject1;
          bool = false;
          break;
          bool = false;
          break label231;
          k = paramj.readUnsignedByte();
          i = (k & 0xF0) >> 4;
          k &= 0xF;
          break label303;
          bool = false;
          break label314;
          i += n;
          break label244;
          localObject2 = null;
          break label399;
          bool = false;
          break label407;
        }
        j += i1;
        break;
        return null;
      }
    }
  }
  
  private static b.a a(j paramj, int paramInt1, int paramInt2, String paramString, DrmInitData paramDrmInitData)
  {
    paramj.setPosition(12);
    int i3 = paramj.readInt();
    b.a locala = new b.a(i3);
    int n = 0;
    int i4;
    int i5;
    boolean bool;
    int i;
    int i6;
    int i7;
    int m;
    float f2;
    int k;
    Object localObject2;
    Object localObject1;
    label230:
    label246:
    Object localObject4;
    if (n < i3)
    {
      i4 = paramj.position;
      i5 = paramj.readInt();
      if (i5 > 0)
      {
        bool = true;
        com.google.android.exoplayer2.i.a.b(bool, "childAtomSize should be positive");
        i = paramj.readInt();
        if ((i != a.azL) && (i != a.azM) && (i != a.aAJ) && (i != a.aAV) && (i != a.azN) && (i != a.azO) && (i != a.azP) && (i != a.aBu) && (i != a.aBv)) {
          break label1299;
        }
        paramj.setPosition(i4 + 8 + 8);
        paramj.dB(16);
        i6 = paramj.readUnsignedShort();
        i7 = paramj.readUnsignedShort();
        m = 0;
        f2 = 1.0F;
        paramj.dB(50);
        k = paramj.position;
        if (i != a.aAJ) {
          break label2624;
        }
        localObject2 = a(paramj, i4, i5);
        if (localObject2 == null) {
          break label2617;
        }
        i = ((Integer)((Pair)localObject2).first).intValue();
        if (paramDrmInitData != null) {
          break label491;
        }
        localObject1 = null;
        locala.aBK[n] = ((f)((Pair)localObject2).second);
        paramj.setPosition(k);
        localObject4 = localObject1;
      }
    }
    for (int j = i;; j = i)
    {
      Object localObject6 = null;
      Object localObject7 = null;
      Object localObject5 = null;
      int i1 = -1;
      label272:
      int i2;
      if (k - i4 < i5)
      {
        paramj.setPosition(k);
        i2 = paramj.position;
        int i8 = paramj.readInt();
        if ((i8 != 0) || (paramj.position - i4 != i5))
        {
          label325:
          int i9;
          label354:
          float f1;
          if (i8 > 0)
          {
            bool = true;
            com.google.android.exoplayer2.i.a.b(bool, "childAtomSize should be positive");
            i9 = paramj.readInt();
            if (i9 != a.aAr) {
              break label524;
            }
            if (localObject7 != null) {
              break label518;
            }
            bool = true;
            com.google.android.exoplayer2.i.a.aC(bool);
            localObject6 = "video/avc";
            paramj.setPosition(i2 + 8);
            com.google.android.exoplayer2.video.a locala1 = com.google.android.exoplayer2.video.a.m(paramj);
            localObject7 = locala1.auu;
            locala.aBL = locala1.aBL;
            localObject1 = localObject6;
            localObject2 = localObject7;
            f1 = f2;
            localObject3 = localObject5;
            i = i1;
            i2 = m;
            if (m == 0)
            {
              f1 = locala1.aSt;
              i2 = m;
              i = i1;
              localObject3 = localObject5;
              localObject2 = localObject7;
              localObject1 = localObject6;
            }
          }
          for (;;)
          {
            k += i8;
            localObject7 = localObject1;
            localObject6 = localObject2;
            f2 = f1;
            localObject5 = localObject3;
            i1 = i;
            m = i2;
            break label272;
            bool = false;
            break;
            label491:
            localObject1 = paramDrmInitData.ak(((f)((Pair)localObject2).second).aCG);
            break label230;
            bool = false;
            break label325;
            label518:
            bool = false;
            break label354;
            label524:
            if (i9 == a.aAs)
            {
              if (localObject7 == null) {}
              for (bool = true;; bool = false)
              {
                com.google.android.exoplayer2.i.a.aC(bool);
                localObject1 = "video/hevc";
                paramj.setPosition(i2 + 8);
                localObject3 = com.google.android.exoplayer2.video.b.o(paramj);
                localObject2 = ((com.google.android.exoplayer2.video.b)localObject3).auu;
                locala.aBL = ((com.google.android.exoplayer2.video.b)localObject3).aBL;
                f1 = f2;
                localObject3 = localObject5;
                i = i1;
                i2 = m;
                break;
              }
            }
            if (i9 == a.aBw)
            {
              if (localObject7 == null) {}
              for (bool = true;; bool = false)
              {
                com.google.android.exoplayer2.i.a.aC(bool);
                if (j != a.aBu) {
                  break label670;
                }
                localObject1 = "video/x-vnd.on2.vp8";
                localObject2 = localObject6;
                f1 = f2;
                localObject3 = localObject5;
                i = i1;
                i2 = m;
                break;
              }
              label670:
              localObject1 = "video/x-vnd.on2.vp9";
              localObject2 = localObject6;
              f1 = f2;
              localObject3 = localObject5;
              i = i1;
              i2 = m;
            }
            else
            {
              if (i9 == a.azQ)
              {
                if (localObject7 == null) {}
                for (bool = true;; bool = false)
                {
                  com.google.android.exoplayer2.i.a.aC(bool);
                  localObject1 = "video/3gpp";
                  localObject2 = localObject6;
                  f1 = f2;
                  localObject3 = localObject5;
                  i = i1;
                  i2 = m;
                  break;
                }
              }
              if (i9 == a.aAt)
              {
                if (localObject7 == null) {}
                for (bool = true;; bool = false)
                {
                  com.google.android.exoplayer2.i.a.aC(bool);
                  localObject2 = b(paramj, i2);
                  localObject1 = (String)((Pair)localObject2).first;
                  localObject2 = Collections.singletonList(((Pair)localObject2).second);
                  f1 = f2;
                  localObject3 = localObject5;
                  i = i1;
                  i2 = m;
                  break;
                }
              }
              if (i9 == a.aAS)
              {
                paramj.setPosition(i2 + 8);
                i = paramj.oh();
                m = paramj.oh();
                f1 = i / m;
                i2 = 1;
                localObject1 = localObject7;
                localObject2 = localObject6;
                localObject3 = localObject5;
                i = i1;
              }
              else if (i9 == a.aBs)
              {
                i = i2 + 8;
                for (;;)
                {
                  if (i - i2 >= i8) {
                    break label983;
                  }
                  paramj.setPosition(i);
                  i9 = paramj.readInt();
                  if (paramj.readInt() == a.aBt)
                  {
                    localObject3 = Arrays.copyOfRange(paramj.data, i, i9 + i);
                    localObject1 = localObject7;
                    localObject2 = localObject6;
                    f1 = f2;
                    i = i1;
                    i2 = m;
                    break;
                  }
                  i += i9;
                }
                label983:
                localObject3 = null;
                localObject1 = localObject7;
                localObject2 = localObject6;
                f1 = f2;
                i = i1;
                i2 = m;
              }
              else
              {
                localObject1 = localObject7;
                localObject2 = localObject6;
                f1 = f2;
                localObject3 = localObject5;
                i = i1;
                i2 = m;
                if (i9 == a.aBr)
                {
                  i9 = paramj.readUnsignedByte();
                  paramj.dB(3);
                  localObject1 = localObject7;
                  localObject2 = localObject6;
                  f1 = f2;
                  localObject3 = localObject5;
                  i = i1;
                  i2 = m;
                  if (i9 == 0) {
                    switch (paramj.readUnsignedByte())
                    {
                    default: 
                      localObject1 = localObject7;
                      localObject2 = localObject6;
                      f1 = f2;
                      localObject3 = localObject5;
                      i = i1;
                      i2 = m;
                      break;
                    case 0: 
                      i = 0;
                      localObject1 = localObject7;
                      localObject2 = localObject6;
                      f1 = f2;
                      localObject3 = localObject5;
                      i2 = m;
                      break;
                    case 1: 
                      i = 1;
                      localObject1 = localObject7;
                      localObject2 = localObject6;
                      f1 = f2;
                      localObject3 = localObject5;
                      i2 = m;
                      break;
                    case 2: 
                      i = 2;
                      localObject1 = localObject7;
                      localObject2 = localObject6;
                      f1 = f2;
                      localObject3 = localObject5;
                      i2 = m;
                      break;
                    case 3: 
                      i = 3;
                      localObject1 = localObject7;
                      localObject2 = localObject6;
                      f1 = f2;
                      localObject3 = localObject5;
                      i2 = m;
                    }
                  }
                }
              }
            }
          }
        }
      }
      if (localObject7 != null) {
        locala.auL = Format.a(Integer.toString(paramInt1), (String)localObject7, i6, i7, (List)localObject6, paramInt2, f2, (byte[])localObject5, i1, (DrmInitData)localObject4);
      }
      paramj.setPosition(i4 + i5);
      n += 1;
      break;
      label1299:
      if ((i == a.azS) || (i == a.aAK) || (i == a.azX) || (i == a.azZ) || (i == a.aAb) || (i == a.aAe) || (i == a.aAc) || (i == a.aAd) || (i == a.aBi) || (i == a.aBj) || (i == a.azV) || (i == a.azW) || (i == a.azT) || (i == a.aBy))
      {
        paramj.setPosition(i4 + 8 + 8);
        paramj.dB(8);
        k = paramj.readUnsignedShort();
        paramj.dB(6);
        localObject1 = paramj.data;
        j = paramj.position;
        paramj.position = (j + 1);
        j = localObject1[j];
        localObject1 = paramj.data;
        m = paramj.position;
        paramj.position = (m + 1);
        m = (j & 0xFF) << 8 | localObject1[m] & 0xFF;
        paramj.position += 2;
        j = paramj.position;
        if (i != a.aAK) {
          break label2610;
        }
        localObject2 = a(paramj, i4, i5);
        if (localObject2 == null) {
          break label2603;
        }
        i = ((Integer)((Pair)localObject2).first).intValue();
        if (paramDrmInitData == null)
        {
          localObject1 = null;
          locala.aBK[n] = ((f)((Pair)localObject2).second);
          label1585:
          paramj.setPosition(j);
        }
      }
      label1678:
      label2065:
      label2071:
      label2345:
      label2603:
      label2610:
      for (Object localObject3 = localObject1;; localObject3 = paramDrmInitData)
      {
        if (i == a.azX) {
          localObject1 = "audio/ac3";
        }
        for (;;)
        {
          label1608:
          localObject2 = null;
          i = m;
          label1615:
          if (j - i4 < i5)
          {
            paramj.setPosition(j);
            i2 = paramj.readInt();
            if (i2 > 0)
            {
              bool = true;
              label1645:
              com.google.android.exoplayer2.i.a.b(bool, "childAtomSize should be positive");
              i6 = paramj.readInt();
              if (i6 != a.aAt) {
                break label2071;
              }
              if (i6 != a.aAt) {
                break label1993;
              }
              m = j;
              if (m == -1) {
                break label2594;
              }
              localObject1 = b(paramj, m);
              localObject4 = (String)((Pair)localObject1).first;
              localObject5 = (byte[])((Pair)localObject1).second;
              localObject1 = localObject4;
              localObject2 = localObject5;
              if ("audio/mp4a-latm".equals(localObject4))
              {
                localObject1 = c.i((byte[])localObject5);
                i = ((Integer)((Pair)localObject1).first).intValue();
                k = ((Integer)((Pair)localObject1).second).intValue();
                localObject2 = localObject5;
                localObject1 = localObject4;
              }
            }
          }
          for (;;)
          {
            m = i;
            i1 = k;
            localObject4 = localObject1;
            for (;;)
            {
              j += i2;
              localObject1 = localObject4;
              k = i1;
              i = m;
              break label1615;
              localObject1 = paramDrmInitData.ak(((f)((Pair)localObject2).second).aCG);
              break;
              if (i == a.azZ)
              {
                localObject1 = "audio/eac3";
                break label1608;
              }
              if (i == a.aAb)
              {
                localObject1 = "audio/vnd.dts";
                break label1608;
              }
              if ((i == a.aAc) || (i == a.aAd))
              {
                localObject1 = "audio/vnd.dts.hd";
                break label1608;
              }
              if (i == a.aAe)
              {
                localObject1 = "audio/vnd.dts.hd;profile=lbr";
                break label1608;
              }
              if (i == a.aBi)
              {
                localObject1 = "audio/3gpp";
                break label1608;
              }
              if (i == a.aBj)
              {
                localObject1 = "audio/amr-wb";
                break label1608;
              }
              if ((i == a.azV) || (i == a.azW))
              {
                localObject1 = "audio/raw";
                break label1608;
              }
              if (i == a.azT)
              {
                localObject1 = "audio/mpeg";
                break label1608;
              }
              if (i != a.aBy) {
                break label2597;
              }
              localObject1 = "audio/alac";
              break label1608;
              bool = false;
              break label1645;
              label1993:
              m = paramj.position;
              for (;;)
              {
                if (m - j >= i2) {
                  break label2065;
                }
                paramj.setPosition(m);
                i1 = paramj.readInt();
                if (i1 > 0) {}
                for (bool = true;; bool = false)
                {
                  com.google.android.exoplayer2.i.a.b(bool, "childAtomSize should be positive");
                  if (paramj.readInt() != a.aAt) {
                    break label2055;
                  }
                  break;
                }
                m += i1;
              }
              m = -1;
              break label1678;
              if (i6 == a.azY)
              {
                paramj.setPosition(j + 8);
                locala.auL = com.google.android.exoplayer2.a.a.a(paramj, Integer.toString(paramInt1), paramString, (DrmInitData)localObject3);
                localObject4 = localObject1;
                i1 = k;
                m = i;
              }
              else if (i6 == a.aAa)
              {
                paramj.setPosition(j + 8);
                locala.auL = com.google.android.exoplayer2.a.a.b(paramj, Integer.toString(paramInt1), paramString, (DrmInitData)localObject3);
                localObject4 = localObject1;
                i1 = k;
                m = i;
              }
              else if (i6 == a.aAf)
              {
                locala.auL = Format.a(Integer.toString(paramInt1), (String)localObject1, -1, -1, k, i, null, (DrmInitData)localObject3, paramString);
                localObject4 = localObject1;
                i1 = k;
                m = i;
              }
              else
              {
                localObject4 = localObject1;
                i1 = k;
                m = i;
                if (i6 == a.aBy)
                {
                  localObject2 = new byte[i2];
                  paramj.setPosition(j);
                  paramj.readBytes((byte[])localObject2, 0, i2);
                  localObject4 = localObject1;
                  i1 = k;
                  m = i;
                }
              }
            }
            if ((locala.auL != null) || (localObject1 == null)) {
              break;
            }
            if ("audio/raw".equals(localObject1))
            {
              j = 2;
              label2297:
              localObject4 = Integer.toString(paramInt1);
              if (localObject2 != null) {
                break label2345;
              }
            }
            for (localObject2 = null;; localObject2 = Collections.singletonList(localObject2))
            {
              locala.auL = Format.a((String)localObject4, (String)localObject1, -1, -1, k, i, j, (List)localObject2, (DrmInitData)localObject3, paramString);
              break;
              j = -1;
              break label2297;
            }
            if ((i == a.aAT) || (i == a.aBe) || (i == a.aBf) || (i == a.aBg) || (i == a.aBh))
            {
              paramj.setPosition(i4 + 8 + 8);
              localObject2 = null;
              long l = 9223372036854775807L;
              if (i == a.aAT) {
                localObject1 = "application/ttml+xml";
              }
              for (;;)
              {
                locala.auL = Format.a(Integer.toString(paramInt1), (String)localObject1, 0, paramString, -1, l, (List)localObject2);
                break;
                if (i == a.aBe)
                {
                  localObject1 = "application/x-quicktime-tx3g";
                  i = i5 - 8 - 8;
                  localObject2 = new byte[i];
                  paramj.readBytes((byte[])localObject2, 0, i);
                  localObject2 = Collections.singletonList(localObject2);
                }
                else if (i == a.aBf)
                {
                  localObject1 = "application/x-mp4-vtt";
                }
                else if (i == a.aBg)
                {
                  localObject1 = "application/ttml+xml";
                  l = 0L;
                }
                else
                {
                  if (i != a.aBh) {
                    break label2557;
                  }
                  localObject1 = "application/x-mp4-cea-608";
                  locala.aBM = 1;
                }
              }
              label2557:
              throw new IllegalStateException();
            }
            if (i != a.aBx) {
              break;
            }
            locala.auL = Format.j(Integer.toString(paramInt1), "application/x-camera-motion");
            break;
            return locala;
          }
          localObject1 = null;
        }
        localObject1 = paramDrmInitData;
        break label1585;
      }
      label2055:
      label2594:
      label2597:
      label2617:
      localObject1 = paramDrmInitData;
      break label246;
      label2624:
      localObject4 = paramDrmInitData;
    }
  }
  
  public static e a(a.a parama, a.b paramb, long paramLong, DrmInitData paramDrmInitData, boolean paramBoolean)
  {
    Object localObject2 = parama.cX(a.aAo);
    Object localObject1 = ((a.a)localObject2).cW(a.aAC).aBC;
    ((j)localObject1).setPosition(16);
    int i = ((j)localObject1).readInt();
    if (i == aBE) {
      i = 1;
    }
    while (i == -1)
    {
      return null;
      if (i == aBD) {
        i = 2;
      } else if ((i == aBF) || (i == aBG) || (i == aBH) || (i == aBI)) {
        i = 3;
      } else if (i == aBl) {
        i = 4;
      } else {
        i = -1;
      }
    }
    localObject1 = parama.cW(a.aAy).aBC;
    ((j)localObject1).setPosition(8);
    int i2 = a.cT(((j)localObject1).readInt());
    int j;
    int n;
    label203:
    int k;
    label206:
    int m;
    long l1;
    if (i2 == 0)
    {
      j = 8;
      ((j)localObject1).dB(j);
      int i1 = ((j)localObject1).readInt();
      ((j)localObject1).dB(4);
      n = 1;
      int i3 = ((j)localObject1).position;
      if (i2 != 0) {
        break label642;
      }
      j = 4;
      k = 0;
      m = n;
      if (k < j)
      {
        if (localObject1.data[(i3 + k)] == -1) {
          break label649;
        }
        m = 0;
      }
      if (m == 0) {
        break label658;
      }
      ((j)localObject1).dB(j);
      l1 = -9223372036854775807L;
      ((j)localObject1).dB(16);
      j = ((j)localObject1).readInt();
      k = ((j)localObject1).readInt();
      ((j)localObject1).dB(4);
      m = ((j)localObject1).readInt();
      n = ((j)localObject1).readInt();
      if ((j != 0) || (k != 65536) || (m != -65536) || (n != 0)) {
        break label699;
      }
      j = 90;
      label323:
      localObject1 = new b.b(i1, l1, j);
      if (paramLong != -9223372036854775807L) {
        break label859;
      }
      paramLong = ((b.b)localObject1).duration;
    }
    label401:
    label455:
    label859:
    for (;;)
    {
      paramb = paramb.aBC;
      paramb.setPosition(8);
      label377:
      long l2;
      if (a.cT(paramb.readInt()) == 0)
      {
        j = 8;
        paramb.dB(j);
        l1 = paramb.bp();
        if (paramLong != -9223372036854775807L) {
          break label780;
        }
        paramLong = -9223372036854775807L;
        paramb = ((a.a)localObject2).cX(a.aAp).cX(a.aAq);
        localObject2 = ((a.a)localObject2).cW(a.aAB).aBC;
        ((j)localObject2).setPosition(8);
        k = a.cT(((j)localObject2).readInt());
        if (k != 0) {
          break label793;
        }
        j = 8;
        ((j)localObject2).dB(j);
        l2 = ((j)localObject2).bp();
        if (k != 0) {
          break label800;
        }
      }
      b.a locala;
      for (j = 4;; j = 8)
      {
        ((j)localObject2).dB(j);
        j = ((j)localObject2).readUnsignedShort();
        localObject2 = Pair.create(Long.valueOf(l2), (char)((j >> 10 & 0x1F) + 96) + (char)((j >> 5 & 0x1F) + 96) + (char)((j & 0x1F) + 96));
        locala = a(paramb.cW(a.aAD).aBC, ((b.b)localObject1).id, ((b.b)localObject1).aux, (String)((Pair)localObject2).second, paramDrmInitData);
        paramb = null;
        paramDrmInitData = null;
        if (!paramBoolean)
        {
          parama = a(parama.cX(a.aAz));
          paramb = (long[])parama.first;
          paramDrmInitData = (long[])parama.second;
        }
        if (locala.auL != null) {
          break label807;
        }
        return null;
        j = 16;
        break;
        j = 8;
        break label203;
        k += 1;
        break label206;
        if (i2 == 0) {}
        for (l2 = ((j)localObject1).bp();; l2 = ((j)localObject1).oi())
        {
          l1 = l2;
          if (l2 != 0L) {
            break;
          }
          l1 = -9223372036854775807L;
          break;
        }
        if ((j == 0) && (k == -65536) && (m == 65536) && (n == 0))
        {
          j = 270;
          break label323;
        }
        if ((j == -65536) && (k == 0) && (m == 0) && (n == -65536))
        {
          j = 180;
          break label323;
        }
        j = 0;
        break label323;
        j = 16;
        break label377;
        paramLong = t.b(paramLong, 1000000L, l1);
        break label401;
        j = 16;
        break label455;
      }
      return new e(((b.b)localObject1).id, i, ((Long)((Pair)localObject2).first).longValue(), l1, paramLong, locala.auL, locala.aBM, locala.aBK, locala.aBL, paramb, paramDrmInitData);
    }
  }
  
  private static Pair<String, byte[]> b(j paramj, int paramInt)
  {
    Object localObject = null;
    paramj.setPosition(paramInt + 8 + 4);
    paramj.dB(1);
    a(paramj);
    paramj.dB(2);
    paramInt = paramj.readUnsignedByte();
    if ((paramInt & 0x80) != 0) {
      paramj.dB(2);
    }
    if ((paramInt & 0x40) != 0) {
      paramj.dB(paramj.readUnsignedShort());
    }
    if ((paramInt & 0x20) != 0) {
      paramj.dB(2);
    }
    paramj.dB(1);
    a(paramj);
    switch (paramj.readUnsignedByte())
    {
    default: 
    case 96: 
    case 97: 
    case 32: 
    case 33: 
    case 35: 
    case 107: 
    case 64: 
    case 102: 
    case 103: 
    case 104: 
    case 165: 
    case 166: 
      for (;;)
      {
        paramj.dB(12);
        paramj.dB(1);
        paramInt = a(paramj);
        byte[] arrayOfByte = new byte[paramInt];
        paramj.readBytes(arrayOfByte, 0, paramInt);
        return Pair.create(localObject, arrayOfByte);
        localObject = "video/mpeg2";
        continue;
        localObject = "video/mp4v-es";
        continue;
        localObject = "video/avc";
        continue;
        localObject = "video/hevc";
        continue;
        return Pair.create("audio/mpeg", null);
        localObject = "audio/mp4a-latm";
        continue;
        localObject = "audio/ac3";
        continue;
        localObject = "audio/eac3";
      }
    case 169: 
    case 172: 
      return Pair.create("audio/vnd.dts", null);
    }
    return Pair.create("audio/vnd.dts.hd", null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.google.android.exoplayer2.c.b.b
 * JD-Core Version:    0.7.0.1
 */