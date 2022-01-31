package com.google.android.exoplayer2.c.d;

import android.util.Pair;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.c.i;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.i.x;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.metadata.Metadata.Entry;
import com.google.android.exoplayer2.o;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

final class b
{
  private static final int aFQ;
  private static final int aGi;
  private static final int aGj;
  private static final int aGk;
  private static final int aGl;
  private static final int aGm;
  private static final int aGn;
  private static final int aGo;
  
  static
  {
    AppMethodBeat.i(94958);
    aGi = x.aS("vide");
    aGj = x.aS("soun");
    aGk = x.aS("text");
    aGl = x.aS("sbtl");
    aGm = x.aS("subt");
    aGn = x.aS("clcp");
    aGo = x.aS("cenc");
    aFQ = x.aS("meta");
    AppMethodBeat.o(94958);
  }
  
  private static Pair<Integer, k> a(com.google.android.exoplayer2.i.m paramm, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(94954);
    int i = paramm.position;
    while (i - paramInt1 < paramInt2)
    {
      paramm.setPosition(i);
      int j = paramm.readInt();
      if (j > 0) {}
      for (boolean bool = true;; bool = false)
      {
        com.google.android.exoplayer2.i.a.checkArgument(bool, "childAtomSize should be positive");
        if (paramm.readInt() != a.aFk) {
          break;
        }
        Pair localPair = b(paramm, i, j);
        if (localPair == null) {
          break;
        }
        AppMethodBeat.o(94954);
        return localPair;
      }
      i += j;
    }
    AppMethodBeat.o(94954);
    return null;
  }
  
  private static c a(com.google.android.exoplayer2.i.m paramm, int paramInt1, int paramInt2, String paramString, DrmInitData paramDrmInitData, boolean paramBoolean)
  {
    AppMethodBeat.i(94951);
    paramm.setPosition(12);
    int i3 = paramm.readInt();
    c localc = new c(i3);
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
    label235:
    label251:
    Object localObject4;
    if (n < i3)
    {
      i4 = paramm.position;
      i5 = paramm.readInt();
      if (i5 > 0)
      {
        bool = true;
        com.google.android.exoplayer2.i.a.checkArgument(bool, "childAtomSize should be positive");
        i = paramm.readInt();
        if ((i != a.aEq) && (i != a.aEr) && (i != a.aFo) && (i != a.aFA) && (i != a.aEs) && (i != a.aEt) && (i != a.aEu) && (i != a.aFZ) && (i != a.aGa)) {
          break label1301;
        }
        paramm.setPosition(i4 + 8 + 8);
        paramm.en(16);
        i6 = paramm.readUnsignedShort();
        i7 = paramm.readUnsignedShort();
        m = 0;
        f2 = 1.0F;
        paramm.en(50);
        k = paramm.position;
        if (i != a.aFo) {
          break label2762;
        }
        localObject2 = a(paramm, i4, i5);
        if (localObject2 == null) {
          break label2755;
        }
        i = ((Integer)((Pair)localObject2).first).intValue();
        if (paramDrmInitData != null) {
          break label496;
        }
        localObject1 = null;
        localc.aGv[n] = ((k)((Pair)localObject2).second);
        paramm.setPosition(k);
        localObject4 = localObject1;
      }
    }
    for (int j = i;; j = i)
    {
      Object localObject6 = null;
      Object localObject7 = null;
      Object localObject5 = null;
      int i1 = -1;
      label277:
      int i2;
      label330:
      label359:
      Object localObject3;
      if (k - i4 < i5)
      {
        paramm.setPosition(k);
        i2 = paramm.position;
        int i8 = paramm.readInt();
        if ((i8 != 0) || (paramm.position - i4 != i5))
        {
          int i9;
          float f1;
          if (i8 > 0)
          {
            bool = true;
            com.google.android.exoplayer2.i.a.checkArgument(bool, "childAtomSize should be positive");
            i9 = paramm.readInt();
            if (i9 != a.aEW) {
              break label529;
            }
            if (localObject7 != null) {
              break label523;
            }
            bool = true;
            com.google.android.exoplayer2.i.a.checkState(bool);
            localObject6 = "video/avc";
            paramm.setPosition(i2 + 8);
            com.google.android.exoplayer2.video.a locala = com.google.android.exoplayer2.video.a.K(paramm);
            localObject7 = locala.awM;
            localc.aCh = locala.aCh;
            localObject1 = localObject6;
            localObject2 = localObject7;
            i2 = m;
            f1 = f2;
            localObject3 = localObject5;
            i = i1;
            if (m == 0)
            {
              f1 = locala.baX;
              i = i1;
              localObject3 = localObject5;
              i2 = m;
              localObject2 = localObject7;
              localObject1 = localObject6;
            }
          }
          for (;;)
          {
            k += i8;
            localObject7 = localObject1;
            localObject6 = localObject2;
            m = i2;
            f2 = f1;
            localObject5 = localObject3;
            i1 = i;
            break label277;
            bool = false;
            break;
            label496:
            localObject1 = paramDrmInitData.ap(((k)((Pair)localObject2).second).aIb);
            break label235;
            bool = false;
            break label330;
            label523:
            bool = false;
            break label359;
            label529:
            if (i9 == a.aEX)
            {
              if (localObject7 == null) {}
              for (bool = true;; bool = false)
              {
                com.google.android.exoplayer2.i.a.checkState(bool);
                localObject1 = "video/hevc";
                paramm.setPosition(i2 + 8);
                localObject3 = com.google.android.exoplayer2.video.b.M(paramm);
                localObject2 = ((com.google.android.exoplayer2.video.b)localObject3).awM;
                localc.aCh = ((com.google.android.exoplayer2.video.b)localObject3).aCh;
                i2 = m;
                f1 = f2;
                localObject3 = localObject5;
                i = i1;
                break;
              }
            }
            if (i9 == a.aGb)
            {
              if (localObject7 == null) {}
              for (bool = true;; bool = false)
              {
                com.google.android.exoplayer2.i.a.checkState(bool);
                if (j != a.aFZ) {
                  break label673;
                }
                localObject1 = "video/x-vnd.on2.vp8";
                localObject2 = localObject6;
                i2 = m;
                f1 = f2;
                localObject3 = localObject5;
                i = i1;
                break;
              }
              label673:
              localObject1 = "video/x-vnd.on2.vp9";
              localObject2 = localObject6;
              i2 = m;
              f1 = f2;
              localObject3 = localObject5;
              i = i1;
            }
            else
            {
              if (i9 == a.aEv)
              {
                if (localObject7 == null) {}
                for (bool = true;; bool = false)
                {
                  com.google.android.exoplayer2.i.a.checkState(bool);
                  localObject1 = "video/3gpp";
                  localObject2 = localObject6;
                  i2 = m;
                  f1 = f2;
                  localObject3 = localObject5;
                  i = i1;
                  break;
                }
              }
              if (i9 == a.aEY)
              {
                if (localObject7 == null) {}
                for (bool = true;; bool = false)
                {
                  com.google.android.exoplayer2.i.a.checkState(bool);
                  localObject2 = c(paramm, i2);
                  localObject1 = (String)((Pair)localObject2).first;
                  localObject2 = Collections.singletonList(((Pair)localObject2).second);
                  i2 = m;
                  f1 = f2;
                  localObject3 = localObject5;
                  i = i1;
                  break;
                }
              }
              if (i9 == a.aFx)
              {
                paramm.setPosition(i2 + 8);
                i = paramm.qT();
                m = paramm.qT();
                f1 = i / m;
                i2 = 1;
                localObject1 = localObject7;
                localObject2 = localObject6;
                localObject3 = localObject5;
                i = i1;
              }
              else if (i9 == a.aFX)
              {
                i = i2 + 8;
                for (;;)
                {
                  if (i - i2 >= i8) {
                    break label984;
                  }
                  paramm.setPosition(i);
                  i9 = paramm.readInt();
                  if (paramm.readInt() == a.aFY)
                  {
                    localObject3 = Arrays.copyOfRange(paramm.data, i, i9 + i);
                    localObject1 = localObject7;
                    localObject2 = localObject6;
                    i2 = m;
                    f1 = f2;
                    i = i1;
                    break;
                  }
                  i += i9;
                }
                label984:
                localObject3 = null;
                localObject1 = localObject7;
                localObject2 = localObject6;
                i2 = m;
                f1 = f2;
                i = i1;
              }
              else
              {
                localObject1 = localObject7;
                localObject2 = localObject6;
                i2 = m;
                f1 = f2;
                localObject3 = localObject5;
                i = i1;
                if (i9 == a.aFW)
                {
                  i9 = paramm.readUnsignedByte();
                  paramm.en(3);
                  localObject1 = localObject7;
                  localObject2 = localObject6;
                  i2 = m;
                  f1 = f2;
                  localObject3 = localObject5;
                  i = i1;
                  if (i9 == 0) {
                    switch (paramm.readUnsignedByte())
                    {
                    default: 
                      localObject1 = localObject7;
                      localObject2 = localObject6;
                      i2 = m;
                      f1 = f2;
                      localObject3 = localObject5;
                      i = i1;
                      break;
                    case 0: 
                      i = 0;
                      localObject1 = localObject7;
                      localObject2 = localObject6;
                      i2 = m;
                      f1 = f2;
                      localObject3 = localObject5;
                      break;
                    case 1: 
                      i = 1;
                      localObject1 = localObject7;
                      localObject2 = localObject6;
                      i2 = m;
                      f1 = f2;
                      localObject3 = localObject5;
                      break;
                    case 2: 
                      i = 2;
                      localObject1 = localObject7;
                      localObject2 = localObject6;
                      i2 = m;
                      f1 = f2;
                      localObject3 = localObject5;
                      break;
                    case 3: 
                      i = 3;
                      localObject1 = localObject7;
                      localObject2 = localObject6;
                      i2 = m;
                      f1 = f2;
                      localObject3 = localObject5;
                    }
                  }
                }
              }
            }
          }
        }
      }
      if (localObject7 != null) {
        localc.axd = Format.a(Integer.toString(paramInt1), (String)localObject7, -1, i6, i7, (List)localObject6, paramInt2, f2, (byte[])localObject5, i1, null, (DrmInitData)localObject4);
      }
      paramm.setPosition(i4 + i5);
      n += 1;
      break;
      label1301:
      if ((i == a.aEx) || (i == a.aFp) || (i == a.aEC) || (i == a.aEE) || (i == a.aEG) || (i == a.aEJ) || (i == a.aEH) || (i == a.aEI) || (i == a.aFN) || (i == a.aFO) || (i == a.aEA) || (i == a.aEB) || (i == a.aEy) || (i == a.aGd))
      {
        paramm.setPosition(i4 + 8 + 8);
        if (paramBoolean)
        {
          j = paramm.readUnsignedShort();
          paramm.en(6);
          label1442:
          if ((j != 0) && (j != 1)) {
            break label1879;
          }
          m = paramm.readUnsignedShort();
          paramm.en(6);
          localObject1 = paramm.data;
          k = paramm.position;
          paramm.position = (k + 1);
          k = localObject1[k];
          localObject1 = paramm.data;
          i1 = paramm.position;
          paramm.position = (i1 + 1);
          k = (k & 0xFF) << 8 | localObject1[i1] & 0xFF;
          paramm.position += 2;
          if (j != 1) {
            break label2744;
          }
          paramm.en(16);
          j = k;
          k = m;
        }
      }
      for (;;)
      {
        label1563:
        m = paramm.position;
        if (i == a.aFp)
        {
          localObject2 = a(paramm, i4, i5);
          if (localObject2 != null)
          {
            i = ((Integer)((Pair)localObject2).first).intValue();
            if (paramDrmInitData == null)
            {
              localObject1 = null;
              label1613:
              localc.aGv[n] = ((k)((Pair)localObject2).second);
              label1629:
              paramm.setPosition(m);
            }
          }
        }
        for (localObject3 = localObject1;; localObject3 = paramDrmInitData)
        {
          if (i == a.aEC) {
            localObject1 = "audio/ac3";
          }
          for (;;)
          {
            label1652:
            localObject2 = null;
            i = j;
            j = m;
            label1663:
            if (j - i4 < i5)
            {
              paramm.setPosition(j);
              i2 = paramm.readInt();
              if (i2 > 0)
              {
                bool = true;
                com.google.android.exoplayer2.i.a.checkArgument(bool, "childAtomSize should be positive");
                i6 = paramm.readInt();
                if ((i6 != a.aEY) && ((!paramBoolean) || (i6 != a.aEz))) {
                  break label2184;
                }
                if (i6 != a.aEY) {
                  break label2106;
                }
                m = j;
                if (m == -1) {
                  break label2721;
                }
                localObject1 = c(paramm, m);
                localObject4 = (String)((Pair)localObject1).first;
                localObject5 = (byte[])((Pair)localObject1).second;
                localObject1 = localObject4;
                localObject2 = localObject5;
                if ("audio/mp4a-latm".equals(localObject4))
                {
                  localObject1 = com.google.android.exoplayer2.i.d.p((byte[])localObject5);
                  i = ((Integer)((Pair)localObject1).first).intValue();
                  k = ((Integer)((Pair)localObject1).second).intValue();
                  localObject2 = localObject5;
                  localObject1 = localObject4;
                }
              }
            }
            label1693:
            label2721:
            for (;;)
            {
              label1739:
              m = i;
              i1 = k;
              localObject4 = localObject1;
              for (;;)
              {
                j += i2;
                localObject1 = localObject4;
                k = i1;
                i = m;
                break label1663;
                paramm.en(8);
                j = 0;
                break label1442;
                label1879:
                if (j != 2) {
                  break;
                }
                paramm.en(16);
                j = (int)Math.round(Double.longBitsToDouble(paramm.readLong()));
                k = paramm.qT();
                paramm.en(20);
                break label1563;
                localObject1 = paramDrmInitData.ap(((k)((Pair)localObject2).second).aIb);
                break label1613;
                if (i == a.aEE)
                {
                  localObject1 = "audio/eac3";
                  break label1652;
                }
                if (i == a.aEG)
                {
                  localObject1 = "audio/vnd.dts";
                  break label1652;
                }
                if ((i == a.aEH) || (i == a.aEI))
                {
                  localObject1 = "audio/vnd.dts.hd";
                  break label1652;
                }
                if (i == a.aEJ)
                {
                  localObject1 = "audio/vnd.dts.hd;profile=lbr";
                  break label1652;
                }
                if (i == a.aFN)
                {
                  localObject1 = "audio/3gpp";
                  break label1652;
                }
                if (i == a.aFO)
                {
                  localObject1 = "audio/amr-wb";
                  break label1652;
                }
                if ((i == a.aEA) || (i == a.aEB))
                {
                  localObject1 = "audio/raw";
                  break label1652;
                }
                if (i == a.aEy)
                {
                  localObject1 = "audio/mpeg";
                  break label1652;
                }
                if (i != a.aGd) {
                  break label2724;
                }
                localObject1 = "audio/alac";
                break label1652;
                bool = false;
                break label1693;
                label2106:
                m = paramm.position;
                for (;;)
                {
                  if (m - j >= i2) {
                    break label2178;
                  }
                  paramm.setPosition(m);
                  i1 = paramm.readInt();
                  if (i1 > 0) {}
                  for (bool = true;; bool = false)
                  {
                    com.google.android.exoplayer2.i.a.checkArgument(bool, "childAtomSize should be positive");
                    if (paramm.readInt() != a.aEY) {
                      break label2168;
                    }
                    break;
                  }
                  label2168:
                  m += i1;
                }
                m = -1;
                break label1739;
                if (i6 == a.aED)
                {
                  paramm.setPosition(j + 8);
                  localc.axd = com.google.android.exoplayer2.a.a.a(paramm, Integer.toString(paramInt1), paramString, (DrmInitData)localObject3);
                  localObject4 = localObject1;
                  i1 = k;
                  m = i;
                }
                else if (i6 == a.aEF)
                {
                  paramm.setPosition(j + 8);
                  localc.axd = com.google.android.exoplayer2.a.a.b(paramm, Integer.toString(paramInt1), paramString, (DrmInitData)localObject3);
                  localObject4 = localObject1;
                  i1 = k;
                  m = i;
                }
                else if (i6 == a.aEK)
                {
                  localc.axd = Format.a(Integer.toString(paramInt1), (String)localObject1, -1, -1, k, i, null, (DrmInitData)localObject3, paramString);
                  localObject4 = localObject1;
                  i1 = k;
                  m = i;
                }
                else
                {
                  localObject4 = localObject1;
                  i1 = k;
                  m = i;
                  if (i6 == a.aGd)
                  {
                    localObject2 = new byte[i2];
                    paramm.setPosition(j);
                    paramm.readBytes((byte[])localObject2, 0, i2);
                    localObject4 = localObject1;
                    i1 = k;
                    m = i;
                  }
                }
              }
              if ((localc.axd != null) || (localObject1 == null)) {
                break;
              }
              if ("audio/raw".equals(localObject1))
              {
                j = 2;
                label2410:
                localObject4 = Integer.toString(paramInt1);
                if (localObject2 != null) {
                  break label2459;
                }
              }
              for (localObject2 = null;; localObject2 = Collections.singletonList(localObject2))
              {
                localc.axd = Format.a((String)localObject4, (String)localObject1, -1, -1, k, i, j, (List)localObject2, (DrmInitData)localObject3, 0, paramString);
                break;
                j = -1;
                break label2410;
              }
              if ((i == a.aFy) || (i == a.aFJ) || (i == a.aFK) || (i == a.aFL) || (i == a.aFM))
              {
                paramm.setPosition(i4 + 8 + 8);
                localObject2 = null;
                long l = 9223372036854775807L;
                if (i == a.aFy) {
                  localObject1 = "application/ttml+xml";
                }
                for (;;)
                {
                  localc.axd = Format.a(Integer.toString(paramInt1), (String)localObject1, 0, paramString, -1, null, l, (List)localObject2);
                  break;
                  if (i == a.aFJ)
                  {
                    localObject1 = "application/x-quicktime-tx3g";
                    i = i5 - 8 - 8;
                    localObject2 = new byte[i];
                    paramm.readBytes((byte[])localObject2, 0, i);
                    localObject2 = Collections.singletonList(localObject2);
                  }
                  else if (i == a.aFK)
                  {
                    localObject1 = "application/x-mp4-vtt";
                  }
                  else if (i == a.aFL)
                  {
                    localObject1 = "application/ttml+xml";
                    l = 0L;
                  }
                  else
                  {
                    if (i != a.aFM) {
                      break label2672;
                    }
                    localObject1 = "application/x-mp4-cea-608";
                    localc.aGw = 1;
                  }
                }
                label2672:
                paramm = new IllegalStateException();
                AppMethodBeat.o(94951);
                throw paramm;
              }
              if (i != a.aGc) {
                break;
              }
              localc.axd = Format.k(Integer.toString(paramInt1), "application/x-camera-motion");
              break;
              AppMethodBeat.o(94951);
              return localc;
            }
            label2178:
            label2184:
            label2459:
            label2724:
            localObject1 = null;
          }
          localObject1 = paramDrmInitData;
          break label1629;
        }
        label2744:
        j = k;
        k = m;
      }
      label2755:
      localObject1 = paramDrmInitData;
      break label251;
      label2762:
      localObject4 = paramDrmInitData;
    }
  }
  
  public static j a(a.a parama, a.b paramb, long paramLong, DrmInitData paramDrmInitData, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(94948);
    Object localObject2 = parama.dx(a.aET);
    Object localObject1 = ((a.a)localObject2).dw(a.aFh).aGh;
    ((com.google.android.exoplayer2.i.m)localObject1).setPosition(16);
    int i = ((com.google.android.exoplayer2.i.m)localObject1).readInt();
    if (i == aGj) {
      i = 1;
    }
    while (i == -1)
    {
      AppMethodBeat.o(94948);
      return null;
      if (i == aGi) {
        i = 2;
      } else if ((i == aGk) || (i == aGl) || (i == aGm) || (i == aGn)) {
        i = 3;
      } else if (i == aFQ) {
        i = 4;
      } else {
        i = -1;
      }
    }
    localObject1 = parama.dw(a.aFd).aGh;
    ((com.google.android.exoplayer2.i.m)localObject1).setPosition(8);
    int i2 = a.dt(((com.google.android.exoplayer2.i.m)localObject1).readInt());
    int j;
    int n;
    label215:
    int k;
    label218:
    int m;
    long l1;
    if (i2 == 0)
    {
      j = 8;
      ((com.google.android.exoplayer2.i.m)localObject1).en(j);
      int i1 = ((com.google.android.exoplayer2.i.m)localObject1).readInt();
      ((com.google.android.exoplayer2.i.m)localObject1).en(4);
      n = 1;
      int i3 = ((com.google.android.exoplayer2.i.m)localObject1).position;
      if (i2 != 0) {
        break label662;
      }
      j = 4;
      k = 0;
      m = n;
      if (k < j)
      {
        if (localObject1.data[(i3 + k)] == -1) {
          break label669;
        }
        m = 0;
      }
      if (m == 0) {
        break label678;
      }
      ((com.google.android.exoplayer2.i.m)localObject1).en(j);
      l1 = -9223372036854775807L;
      ((com.google.android.exoplayer2.i.m)localObject1).en(16);
      j = ((com.google.android.exoplayer2.i.m)localObject1).readInt();
      k = ((com.google.android.exoplayer2.i.m)localObject1).readInt();
      ((com.google.android.exoplayer2.i.m)localObject1).en(4);
      m = ((com.google.android.exoplayer2.i.m)localObject1).readInt();
      n = ((com.google.android.exoplayer2.i.m)localObject1).readInt();
      if ((j != 0) || (k != 65536) || (m != -65536) || (n != 0)) {
        break label719;
      }
      j = 90;
      label335:
      localObject1 = new f(i1, l1, j);
      if (paramLong != -9223372036854775807L) {
        break label887;
      }
      paramLong = ((f)localObject1).duration;
    }
    label389:
    label413:
    label467:
    label887:
    for (;;)
    {
      paramb = paramb.aGh;
      paramb.setPosition(8);
      long l2;
      if (a.dt(paramb.readInt()) == 0)
      {
        j = 8;
        paramb.en(j);
        l1 = paramb.cc();
        if (paramLong != -9223372036854775807L) {
          break label800;
        }
        paramLong = -9223372036854775807L;
        paramb = ((a.a)localObject2).dx(a.aEU).dx(a.aEV);
        localObject2 = ((a.a)localObject2).dw(a.aFg).aGh;
        ((com.google.android.exoplayer2.i.m)localObject2).setPosition(8);
        k = a.dt(((com.google.android.exoplayer2.i.m)localObject2).readInt());
        if (k != 0) {
          break label813;
        }
        j = 8;
        ((com.google.android.exoplayer2.i.m)localObject2).en(j);
        l2 = ((com.google.android.exoplayer2.i.m)localObject2).cc();
        if (k != 0) {
          break label820;
        }
      }
      c localc;
      for (j = 4;; j = 8)
      {
        ((com.google.android.exoplayer2.i.m)localObject2).en(j);
        j = ((com.google.android.exoplayer2.i.m)localObject2).readUnsignedShort();
        localObject2 = Pair.create(Long.valueOf(l2), (char)((j >> 10 & 0x1F) + 96) + (char)((j >> 5 & 0x1F) + 96) + (char)((j & 0x1F) + 96));
        localc = a(paramb.dw(a.aFi).aGh, ((f)localObject1).id, ((f)localObject1).awP, (String)((Pair)localObject2).second, paramDrmInitData, paramBoolean2);
        paramb = null;
        paramDrmInitData = null;
        if (!paramBoolean1)
        {
          parama = b(parama.dx(a.aFe));
          paramb = (long[])parama.first;
          paramDrmInitData = (long[])parama.second;
        }
        if (localc.axd != null) {
          break label827;
        }
        AppMethodBeat.o(94948);
        return null;
        j = 16;
        break;
        j = 8;
        break label215;
        k += 1;
        break label218;
        if (i2 == 0) {}
        for (l2 = ((com.google.android.exoplayer2.i.m)localObject1).cc();; l2 = ((com.google.android.exoplayer2.i.m)localObject1).qV())
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
          break label335;
        }
        if ((j == -65536) && (k == 0) && (m == 0) && (n == -65536))
        {
          j = 180;
          break label335;
        }
        j = 0;
        break label335;
        j = 16;
        break label389;
        paramLong = x.b(paramLong, 1000000L, l1);
        break label413;
        j = 16;
        break label467;
      }
      parama = new j(((f)localObject1).id, i, ((Long)((Pair)localObject2).first).longValue(), l1, paramLong, localc.axd, localc.aGw, localc.aGv, localc.aCh, paramb, paramDrmInitData);
      AppMethodBeat.o(94948);
      return parama;
    }
  }
  
  private static k a(com.google.android.exoplayer2.i.m paramm, int paramInt1, int paramInt2, String paramString)
  {
    Object localObject2 = null;
    boolean bool = true;
    AppMethodBeat.i(94956);
    int i = paramInt1 + 8;
    while (i - paramInt1 < paramInt2)
    {
      paramm.setPosition(i);
      int j = paramm.readInt();
      if (paramm.readInt() == a.aFn)
      {
        paramInt1 = a.dt(paramm.readInt());
        paramm.en(1);
        if (paramInt1 == 0)
        {
          paramm.en(1);
          paramInt2 = 0;
          paramInt1 = 0;
          if (paramm.readUnsignedByte() != 1) {
            break label190;
          }
        }
        for (;;)
        {
          i = paramm.readUnsignedByte();
          byte[] arrayOfByte = new byte[16];
          paramm.readBytes(arrayOfByte, 0, 16);
          Object localObject1 = localObject2;
          if (bool)
          {
            localObject1 = localObject2;
            if (i == 0)
            {
              j = paramm.readUnsignedByte();
              localObject1 = new byte[j];
              paramm.readBytes((byte[])localObject1, 0, j);
            }
          }
          paramm = new k(bool, paramString, i, arrayOfByte, paramInt1, paramInt2, (byte[])localObject1);
          AppMethodBeat.o(94956);
          return paramm;
          paramInt2 = paramm.readUnsignedByte();
          paramInt1 = (paramInt2 & 0xF0) >> 4;
          paramInt2 &= 0xF;
          break;
          label190:
          bool = false;
        }
      }
      i += j;
    }
    AppMethodBeat.o(94956);
    return null;
  }
  
  public static m a(j paramj, a.a parama, i parami)
  {
    AppMethodBeat.i(94949);
    Object localObject1 = parama.dw(a.aFF);
    if (localObject1 != null) {}
    int i10;
    for (Object localObject2 = new b.d((a.b)localObject1);; localObject2 = new b.e((a.b)localObject1))
    {
      i10 = ((b.b)localObject2).getSampleCount();
      if (i10 != 0) {
        break;
      }
      paramj = new m(new long[0], new int[0], 0, new long[0], new int[0]);
      AppMethodBeat.o(94949);
      return paramj;
      localObject1 = parama.dw(a.aFG);
      if (localObject1 == null)
      {
        paramj = new o("Track has no sample table size information");
        AppMethodBeat.o(94949);
        throw paramj;
      }
    }
    boolean bool = false;
    Object localObject3 = parama.dw(a.aFH);
    localObject1 = localObject3;
    if (localObject3 == null)
    {
      bool = true;
      localObject1 = parama.dw(a.aFI);
    }
    localObject3 = ((a.b)localObject1).aGh;
    Object localObject4 = parama.dw(a.aFE).aGh;
    com.google.android.exoplayer2.i.m localm = parama.dw(a.aFB).aGh;
    localObject1 = parama.dw(a.aFC);
    label223:
    b.a locala;
    int i2;
    int i3;
    int i4;
    int n;
    int i;
    int i5;
    int k;
    int j;
    if (localObject1 != null)
    {
      localObject1 = ((a.b)localObject1).aGh;
      parama = parama.dw(a.aFD);
      if (parama == null) {
        break label492;
      }
      parama = parama.aGh;
      locala = new b.a((com.google.android.exoplayer2.i.m)localObject4, (com.google.android.exoplayer2.i.m)localObject3, bool);
      localm.setPosition(12);
      i2 = localm.qT() - 1;
      i3 = localm.qT();
      i4 = localm.qT();
      n = 0;
      i = 0;
      i5 = 0;
      if (parama != null)
      {
        parama.setPosition(12);
        i = parama.qT();
      }
      m = -1;
      k = 0;
      localObject3 = localObject1;
      j = m;
      if (localObject1 != null)
      {
        ((com.google.android.exoplayer2.i.m)localObject1).setPosition(12);
        k = ((com.google.android.exoplayer2.i.m)localObject1).qT();
        if (k <= 0) {
          break label497;
        }
        j = ((com.google.android.exoplayer2.i.m)localObject1).qT() - 1;
        localObject3 = localObject1;
      }
      label342:
      if ((!((b.b)localObject2).of()) || (!"audio/raw".equals(paramj.axd.awK)) || (i2 != 0) || (i != 0) || (k != 0)) {
        break label507;
      }
    }
    int i8;
    long l1;
    Object localObject5;
    Object localObject6;
    long l2;
    int i1;
    int i6;
    int i7;
    label492:
    label497:
    label507:
    for (int m = 1;; m = 0)
    {
      i8 = 0;
      l1 = 0L;
      if (m != 0) {
        break label959;
      }
      localObject4 = new long[i10];
      localObject1 = new int[i10];
      localObject5 = new long[i10];
      localObject6 = new int[i10];
      l2 = 0L;
      m = 0;
      i1 = 0;
      i6 = j;
      i7 = k;
      k = i8;
      j = i5;
      if (i1 >= i10) {
        break label758;
      }
      for (i5 = m; i5 == 0; i5 = locala.aGp)
      {
        com.google.android.exoplayer2.i.a.checkState(locala.od());
        l2 = locala.offset;
      }
      localObject1 = null;
      break;
      parama = null;
      break label223;
      localObject3 = null;
      j = m;
      break label342;
    }
    if (parama != null)
    {
      while ((n == 0) && (i > 0))
      {
        n = parama.qT();
        j = parama.readInt();
        i -= 1;
      }
      n -= 1;
    }
    label771:
    label808:
    label814:
    label959:
    label1491:
    label1754:
    label2011:
    label2014:
    for (;;)
    {
      localObject4[i1] = l2;
      localObject1[i1] = ((b.b)localObject2).oe();
      i8 = k;
      if (localObject1[i1] > k) {
        i8 = localObject1[i1];
      }
      localObject5[i1] = (j + l1);
      if (localObject3 == null)
      {
        k = 1;
        label610:
        localObject6[i1] = k;
        m = i7;
        i9 = i6;
        if (i1 == i6)
        {
          localObject6[i1] = 1;
          m = i7 - 1;
          if (m <= 0) {
            break label2034;
          }
          k = ((com.google.android.exoplayer2.i.m)localObject3).qT();
        }
      }
      label1898:
      label2034:
      for (int i9 = k - 1;; i9 = i6)
      {
        l1 += i4;
        k = i3 - 1;
        if ((k == 0) && (i2 > 0))
        {
          k = localm.qT();
          i4 = localm.qT();
          i2 -= 1;
        }
        for (;;)
        {
          l2 += localObject1[i1];
          i5 -= 1;
          i1 += 1;
          i3 = k;
          k = i8;
          i7 = m;
          i6 = i9;
          m = i5;
          break;
          k = 0;
          break label610;
          label758:
          if (n == 0)
          {
            bool = true;
            com.google.android.exoplayer2.i.a.checkArgument(bool);
            if (i <= 0) {
              break label814;
            }
            if (parama.qT() != 0) {
              break label808;
            }
          }
          for (bool = true;; bool = false)
          {
            com.google.android.exoplayer2.i.a.checkArgument(bool);
            parama.readInt();
            i -= 1;
            break label771;
            bool = false;
            break;
          }
          if ((i7 != 0) || (i3 != 0) || (m != 0) || (i2 != 0)) {
            new StringBuilder("Inconsistent stbl box for track ").append(paramj.id).append(": remainingSynchronizationSamples ").append(i7).append(", remainingSamplesAtTimestampDelta ").append(i3).append(", remainingSamplesInChunk ").append(m).append(", remainingTimestampDeltaChanges ").append(i2);
          }
          localObject2 = localObject6;
          localObject3 = localObject5;
          j = k;
          parama = (a.a)localObject4;
          while ((paramj.aHX == null) || (parami.oa()))
          {
            x.a((long[])localObject3, paramj.aHU);
            paramj = new m(parama, (int[])localObject1, j, (long[])localObject3, (int[])localObject2);
            AppMethodBeat.o(94949);
            return paramj;
            parama = new long[locala.length];
            localObject1 = new int[locala.length];
            while (locala.od())
            {
              parama[locala.index] = locala.offset;
              localObject1[locala.index] = locala.aGp;
            }
            localObject2 = d.a(((b.b)localObject2).oe(), parama, (int[])localObject1, i4);
            parama = ((d.a)localObject2).offsets;
            localObject1 = ((d.a)localObject2).aBk;
            j = ((d.a)localObject2).aGC;
            localObject3 = ((d.a)localObject2).aGD;
            localObject2 = ((d.a)localObject2).aGE;
          }
          long l3;
          if ((paramj.aHX.length == 1) && (paramj.type == 1) && (localObject3.length >= 2))
          {
            l3 = paramj.aHY[0];
            l2 = x.b(paramj.aHX[0], paramj.aHU, paramj.aHV) + l3;
            if ((localObject3[0] <= l3) && (l3 < localObject3[1]) && (localObject3[(localObject3.length - 1)] < l2) && (l2 <= l1))
            {
              l3 = x.b(l3 - localObject3[0], paramj.axd.sampleRate, paramj.aHU);
              l1 = x.b(l1 - l2, paramj.axd.sampleRate, paramj.aHU);
              if (((l3 != 0L) || (l1 != 0L)) && (l3 <= 2147483647L) && (l1 <= 2147483647L))
              {
                parami.awW = ((int)l3);
                parami.awX = ((int)l1);
                x.a((long[])localObject3, paramj.aHU);
                paramj = new m(parama, (int[])localObject1, j, (long[])localObject3, (int[])localObject2);
                AppMethodBeat.o(94949);
                return paramj;
              }
            }
          }
          if ((paramj.aHX.length == 1) && (paramj.aHX[0] == 0L))
          {
            i = 0;
            while (i < localObject3.length)
            {
              localObject3[i] = x.b(localObject3[i] - paramj.aHY[0], 1000000L, paramj.aHU);
              i += 1;
            }
            paramj = new m(parama, (int[])localObject1, j, (long[])localObject3, (int[])localObject2);
            AppMethodBeat.o(94949);
            return paramj;
          }
          if (paramj.type == 1)
          {
            bool = true;
            n = 0;
            k = 0;
            i = 0;
            m = 0;
            label1397:
            if (n >= paramj.aHX.length) {
              break label1543;
            }
            l1 = paramj.aHY[n];
            if (l1 == -1L) {
              break label2014;
            }
            l2 = x.b(paramj.aHX[n], paramj.aHU, paramj.aHV);
            i3 = x.a((long[])localObject3, l1, true, true);
            i2 = x.a((long[])localObject3, l2 + l1, bool, false);
            i1 = k + (i2 - i3);
            if (m == i3) {
              break label1537;
            }
            k = 1;
            k = i | k;
            i = i2;
            m = i1;
          }
          for (;;)
          {
            n += 1;
            i1 = k;
            i2 = i;
            k = m;
            i = i1;
            m = i2;
            break label1397;
            bool = false;
            break;
            k = 0;
            break label1491;
            if (k != i10)
            {
              m = 1;
              i4 = i | m;
              if (i4 == 0) {
                break label1849;
              }
              parami = new long[k];
              if (i4 == 0) {
                break label1854;
              }
              localObject4 = new int[k];
              if (i4 == 0) {
                break label1861;
              }
              m = 0;
              if (i4 == 0) {
                break label1868;
              }
              localObject5 = new int[k];
              localObject6 = new long[k];
              l1 = 0L;
              i = 0;
              i1 = 0;
              k = m;
              if (i1 >= paramj.aHX.length) {
                break label1898;
              }
              l2 = paramj.aHY[i1];
              l3 = paramj.aHX[i1];
              i3 = k;
              n = i;
              if (l2 == -1L) {
                break label1875;
              }
              long l4 = x.b(l3, paramj.aHU, paramj.aHV);
              i2 = x.a((long[])localObject3, l2, true, true);
              i5 = x.a((long[])localObject3, l2 + l4, bool, false);
              if (i4 != 0)
              {
                m = i5 - i2;
                System.arraycopy(parama, i2, parami, i, m);
                System.arraycopy(localObject1, i2, localObject4, i, m);
                System.arraycopy(localObject2, i2, localObject5, i, m);
              }
              m = i;
              i = k;
              i3 = i;
              n = m;
              if (i2 >= i5) {
                break label1875;
              }
              l4 = x.b(l1, 1000000L, paramj.aHV);
              localObject6[m] = (x.b(localObject3[i2] - l2, 1000000L, paramj.aHU) + l4);
              if ((i4 == 0) || (localObject4[m] <= i)) {
                break label2011;
              }
              i = localObject1[i2];
            }
            for (;;)
            {
              m += 1;
              i2 += 1;
              break label1754;
              m = 0;
              break;
              parami = parama;
              break label1569;
              localObject4 = localObject1;
              break label1580;
              m = j;
              break label1588;
              localObject5 = localObject2;
              break label1599;
              l1 += l3;
              i = n;
              i1 += 1;
              k = i3;
              break label1617;
              m = 0;
              i = 0;
              if ((i < localObject5.length) && (m == 0))
              {
                if ((localObject5[i] & 0x1) != 0) {}
                for (n = 1;; n = 0)
                {
                  m |= n;
                  i += 1;
                  break;
                }
              }
              if (m == 0)
              {
                x.a((long[])localObject3, paramj.aHU);
                paramj = new m(parama, (int[])localObject1, j, (long[])localObject3, (int[])localObject2);
                AppMethodBeat.o(94949);
                return paramj;
              }
              paramj = new m(parami, (int[])localObject4, k, (long[])localObject6, (int[])localObject5);
              AppMethodBeat.o(94949);
              return paramj;
            }
            i1 = m;
            m = k;
            k = i;
            i = i1;
          }
        }
      }
    }
  }
  
  public static Metadata a(a.b paramb, boolean paramBoolean)
  {
    AppMethodBeat.i(94950);
    if (paramBoolean)
    {
      AppMethodBeat.o(94950);
      return null;
    }
    paramb = paramb.aGh;
    paramb.setPosition(8);
    while (paramb.qM() >= 8)
    {
      int i = paramb.position;
      int j = paramb.readInt();
      if (paramb.readInt() == a.aFQ)
      {
        paramb.setPosition(i);
        paramb.en(12);
        while (paramb.position < i + j)
        {
          int k = paramb.position;
          int m = paramb.readInt();
          if (paramb.readInt() == a.aFR)
          {
            paramb.setPosition(k);
            paramb.en(8);
            ArrayList localArrayList = new ArrayList();
            while (paramb.position < k + m)
            {
              Metadata.Entry localEntry = f.o(paramb);
              if (localEntry != null) {
                localArrayList.add(localEntry);
              }
            }
            if (localArrayList.isEmpty()) {
              break;
            }
            paramb = new Metadata(localArrayList);
            AppMethodBeat.o(94950);
            return paramb;
          }
          paramb.en(m - 8);
        }
        AppMethodBeat.o(94950);
        return null;
      }
      paramb.en(j - 8);
    }
    AppMethodBeat.o(94950);
    return null;
  }
  
  private static Pair<long[], long[]> b(a.a parama)
  {
    AppMethodBeat.i(94952);
    if (parama != null)
    {
      parama = parama.dw(a.aFf);
      if (parama != null) {}
    }
    else
    {
      parama = Pair.create(null, null);
      AppMethodBeat.o(94952);
      return parama;
    }
    parama = parama.aGh;
    parama.setPosition(8);
    int j = a.dt(parama.readInt());
    int k = parama.qT();
    long[] arrayOfLong1 = new long[k];
    long[] arrayOfLong2 = new long[k];
    int i = 0;
    while (i < k)
    {
      if (j == 1)
      {
        l = parama.qV();
        arrayOfLong1[i] = l;
        if (j != 1) {
          break label210;
        }
      }
      label210:
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
          break label220;
        }
        parama = new IllegalArgumentException("Unsupported media rate.");
        AppMethodBeat.o(94952);
        throw parama;
        l = parama.cc();
        break;
      }
      label220:
      parama.en(2);
      i += 1;
    }
    parama = Pair.create(arrayOfLong1, arrayOfLong2);
    AppMethodBeat.o(94952);
    return parama;
  }
  
  private static Pair<Integer, k> b(com.google.android.exoplayer2.i.m paramm, int paramInt1, int paramInt2)
  {
    boolean bool2 = true;
    AppMethodBeat.i(94955);
    int i = paramInt1 + 8;
    Object localObject1 = null;
    Object localObject2 = null;
    int k = 0;
    int j = -1;
    if (i - paramInt1 < paramInt2)
    {
      paramm.setPosition(i);
      int m = paramm.readInt();
      int n = paramm.readInt();
      Object localObject3;
      Object localObject4;
      if (n == a.aFq)
      {
        localObject3 = Integer.valueOf(paramm.readInt());
        localObject4 = localObject2;
      }
      for (;;)
      {
        i += m;
        localObject1 = localObject3;
        localObject2 = localObject4;
        break;
        if (n == a.aFl)
        {
          paramm.en(4);
          localObject4 = paramm.readString(4);
          localObject3 = localObject1;
        }
        else
        {
          localObject3 = localObject1;
          localObject4 = localObject2;
          if (n == a.aFm)
          {
            k = m;
            j = i;
            localObject3 = localObject1;
            localObject4 = localObject2;
          }
        }
      }
    }
    if (("cenc".equals(localObject2)) || ("cbc1".equals(localObject2)) || ("cens".equals(localObject2)) || ("cbcs".equals(localObject2)))
    {
      if (localObject1 != null)
      {
        bool1 = true;
        com.google.android.exoplayer2.i.a.checkArgument(bool1, "frma atom is mandatory");
        if (j == -1) {
          break label272;
        }
        bool1 = true;
        label216:
        com.google.android.exoplayer2.i.a.checkArgument(bool1, "schi atom is mandatory");
        paramm = a(paramm, j, k, localObject2);
        if (paramm == null) {
          break label278;
        }
      }
      label272:
      label278:
      for (boolean bool1 = bool2;; bool1 = false)
      {
        com.google.android.exoplayer2.i.a.checkArgument(bool1, "tenc atom is mandatory");
        paramm = Pair.create(localObject1, paramm);
        AppMethodBeat.o(94955);
        return paramm;
        bool1 = false;
        break;
        bool1 = false;
        break label216;
      }
    }
    AppMethodBeat.o(94955);
    return null;
  }
  
  private static Pair<String, byte[]> c(com.google.android.exoplayer2.i.m paramm, int paramInt)
  {
    Object localObject = null;
    AppMethodBeat.i(94953);
    paramm.setPosition(paramInt + 8 + 4);
    paramm.en(1);
    k(paramm);
    paramm.en(2);
    paramInt = paramm.readUnsignedByte();
    if ((paramInt & 0x80) != 0) {
      paramm.en(2);
    }
    if ((paramInt & 0x40) != 0) {
      paramm.en(paramm.readUnsignedShort());
    }
    if ((paramInt & 0x20) != 0) {
      paramm.en(2);
    }
    paramm.en(1);
    k(paramm);
    switch (paramm.readUnsignedByte())
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
        paramm.en(12);
        paramm.en(1);
        paramInt = k(paramm);
        byte[] arrayOfByte = new byte[paramInt];
        paramm.readBytes(arrayOfByte, 0, paramInt);
        paramm = Pair.create(localObject, arrayOfByte);
        AppMethodBeat.o(94953);
        return paramm;
        localObject = "video/mpeg2";
        continue;
        localObject = "video/mp4v-es";
        continue;
        localObject = "video/avc";
        continue;
        localObject = "video/hevc";
        continue;
        paramm = Pair.create("audio/mpeg", null);
        AppMethodBeat.o(94953);
        return paramm;
        localObject = "audio/mp4a-latm";
        continue;
        localObject = "audio/ac3";
        continue;
        localObject = "audio/eac3";
      }
    case 169: 
    case 172: 
      paramm = Pair.create("audio/vnd.dts", null);
      AppMethodBeat.o(94953);
      return paramm;
    }
    paramm = Pair.create("audio/vnd.dts.hd", null);
    AppMethodBeat.o(94953);
    return paramm;
  }
  
  private static int k(com.google.android.exoplayer2.i.m paramm)
  {
    AppMethodBeat.i(94957);
    int j = paramm.readUnsignedByte();
    for (int i = j & 0x7F; (j & 0x80) == 128; i = i << 7 | j & 0x7F) {
      j = paramm.readUnsignedByte();
    }
    AppMethodBeat.o(94957);
    return i;
  }
  
  static final class c
  {
    public int aCh;
    public final k[] aGv;
    public int aGw;
    public Format axd;
    
    public c(int paramInt)
    {
      AppMethodBeat.i(94943);
      this.aGv = new k[paramInt];
      this.aGw = 0;
      AppMethodBeat.o(94943);
    }
  }
  
  static final class f
  {
    final int awP;
    final long duration;
    final int id;
    
    public f(int paramInt1, long paramLong, int paramInt2)
    {
      this.id = paramInt1;
      this.duration = paramLong;
      this.awP = paramInt2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.exoplayer2.c.d.b
 * JD-Core Version:    0.7.0.1
 */