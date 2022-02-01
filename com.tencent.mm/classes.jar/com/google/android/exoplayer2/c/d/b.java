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
  private static final int cPI;
  private static final int cQa;
  private static final int cQb;
  private static final int cQc;
  private static final int cQd;
  private static final int cQe;
  private static final int cQf;
  private static final int cQg;
  
  static
  {
    AppMethodBeat.i(92073);
    cQa = x.du("vide");
    cQb = x.du("soun");
    cQc = x.du("text");
    cQd = x.du("sbtl");
    cQe = x.du("subt");
    cQf = x.du("clcp");
    cQg = x.du("cenc");
    cPI = x.du("meta");
    AppMethodBeat.o(92073);
  }
  
  private static Pair<Integer, k> a(com.google.android.exoplayer2.i.m paramm, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(92069);
    int i = paramm.position;
    while (i - paramInt1 < paramInt2)
    {
      paramm.setPosition(i);
      int j = paramm.readInt();
      if (j > 0) {}
      for (boolean bool = true;; bool = false)
      {
        com.google.android.exoplayer2.i.a.checkArgument(bool, "childAtomSize should be positive");
        if (paramm.readInt() != a.cPc) {
          break;
        }
        Pair localPair = b(paramm, i, j);
        if (localPair == null) {
          break;
        }
        AppMethodBeat.o(92069);
        return localPair;
      }
      i += j;
    }
    AppMethodBeat.o(92069);
    return null;
  }
  
  private static c a(com.google.android.exoplayer2.i.m paramm, int paramInt1, int paramInt2, String paramString, DrmInitData paramDrmInitData, boolean paramBoolean)
  {
    AppMethodBeat.i(92066);
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
        if ((i != a.cOi) && (i != a.cOj) && (i != a.cPg) && (i != a.cPs) && (i != a.cOk) && (i != a.cOl) && (i != a.cOm) && (i != a.cPR) && (i != a.cPS)) {
          break label1301;
        }
        paramm.setPosition(i4 + 8 + 8);
        paramm.iH(16);
        i6 = paramm.readUnsignedShort();
        i7 = paramm.readUnsignedShort();
        m = 0;
        f2 = 1.0F;
        paramm.iH(50);
        k = paramm.position;
        if (i != a.cPg) {
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
        localc.cQn[n] = ((k)((Pair)localObject2).second);
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
            if (i9 != a.cOO) {
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
            localObject7 = locala.cGP;
            localc.cMd = locala.cMd;
            localObject1 = localObject6;
            localObject2 = localObject7;
            i2 = m;
            f1 = f2;
            localObject3 = localObject5;
            i = i1;
            if (m == 0)
            {
              f1 = locala.dky;
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
            localObject1 = paramDrmInitData.cJ(((k)((Pair)localObject2).second).cRT);
            break label235;
            bool = false;
            break label330;
            label523:
            bool = false;
            break label359;
            label529:
            if (i9 == a.cOP)
            {
              if (localObject7 == null) {}
              for (bool = true;; bool = false)
              {
                com.google.android.exoplayer2.i.a.checkState(bool);
                localObject1 = "video/hevc";
                paramm.setPosition(i2 + 8);
                localObject3 = com.google.android.exoplayer2.video.b.M(paramm);
                localObject2 = ((com.google.android.exoplayer2.video.b)localObject3).cGP;
                localc.cMd = ((com.google.android.exoplayer2.video.b)localObject3).cMd;
                i2 = m;
                f1 = f2;
                localObject3 = localObject5;
                i = i1;
                break;
              }
            }
            if (i9 == a.cPT)
            {
              if (localObject7 == null) {}
              for (bool = true;; bool = false)
              {
                com.google.android.exoplayer2.i.a.checkState(bool);
                if (j != a.cPR) {
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
              if (i9 == a.cOn)
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
              if (i9 == a.cOQ)
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
              if (i9 == a.cPp)
              {
                paramm.setPosition(i2 + 8);
                i = paramm.UN();
                m = paramm.UN();
                f1 = i / m;
                i2 = 1;
                localObject1 = localObject7;
                localObject2 = localObject6;
                localObject3 = localObject5;
                i = i1;
              }
              else if (i9 == a.cPP)
              {
                i = i2 + 8;
                for (;;)
                {
                  if (i - i2 >= i8) {
                    break label984;
                  }
                  paramm.setPosition(i);
                  i9 = paramm.readInt();
                  if (paramm.readInt() == a.cPQ)
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
                if (i9 == a.cPO)
                {
                  i9 = paramm.readUnsignedByte();
                  paramm.iH(3);
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
        localc.cHc = Format.a(Integer.toString(paramInt1), (String)localObject7, -1, i6, i7, (List)localObject6, paramInt2, f2, (byte[])localObject5, i1, null, (DrmInitData)localObject4);
      }
      paramm.setPosition(i4 + i5);
      n += 1;
      break;
      label1301:
      if ((i == a.cOp) || (i == a.cPh) || (i == a.cOu) || (i == a.cOw) || (i == a.cOy) || (i == a.cOB) || (i == a.cOz) || (i == a.cOA) || (i == a.cPF) || (i == a.cPG) || (i == a.cOs) || (i == a.cOt) || (i == a.cOq) || (i == a.cPV))
      {
        paramm.setPosition(i4 + 8 + 8);
        if (paramBoolean)
        {
          j = paramm.readUnsignedShort();
          paramm.iH(6);
          label1442:
          if ((j != 0) && (j != 1)) {
            break label1879;
          }
          m = paramm.readUnsignedShort();
          paramm.iH(6);
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
          paramm.iH(16);
          j = k;
          k = m;
        }
      }
      for (;;)
      {
        label1563:
        m = paramm.position;
        if (i == a.cPh)
        {
          localObject2 = a(paramm, i4, i5);
          if (localObject2 != null)
          {
            i = ((Integer)((Pair)localObject2).first).intValue();
            if (paramDrmInitData == null)
            {
              localObject1 = null;
              label1613:
              localc.cQn[n] = ((k)((Pair)localObject2).second);
              label1629:
              paramm.setPosition(m);
            }
          }
        }
        for (localObject3 = localObject1;; localObject3 = paramDrmInitData)
        {
          if (i == a.cOu) {
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
                if ((i6 != a.cOQ) && ((!paramBoolean) || (i6 != a.cOr))) {
                  break label2184;
                }
                if (i6 != a.cOQ) {
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
                  localObject1 = com.google.android.exoplayer2.i.d.y((byte[])localObject5);
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
                paramm.iH(8);
                j = 0;
                break label1442;
                label1879:
                if (j != 2) {
                  break;
                }
                paramm.iH(16);
                j = (int)Math.round(Double.longBitsToDouble(paramm.readLong()));
                k = paramm.UN();
                paramm.iH(20);
                break label1563;
                localObject1 = paramDrmInitData.cJ(((k)((Pair)localObject2).second).cRT);
                break label1613;
                if (i == a.cOw)
                {
                  localObject1 = "audio/eac3";
                  break label1652;
                }
                if (i == a.cOy)
                {
                  localObject1 = "audio/vnd.dts";
                  break label1652;
                }
                if ((i == a.cOz) || (i == a.cOA))
                {
                  localObject1 = "audio/vnd.dts.hd";
                  break label1652;
                }
                if (i == a.cOB)
                {
                  localObject1 = "audio/vnd.dts.hd;profile=lbr";
                  break label1652;
                }
                if (i == a.cPF)
                {
                  localObject1 = "audio/3gpp";
                  break label1652;
                }
                if (i == a.cPG)
                {
                  localObject1 = "audio/amr-wb";
                  break label1652;
                }
                if ((i == a.cOs) || (i == a.cOt))
                {
                  localObject1 = "audio/raw";
                  break label1652;
                }
                if (i == a.cOq)
                {
                  localObject1 = "audio/mpeg";
                  break label1652;
                }
                if (i != a.cPV) {
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
                    if (paramm.readInt() != a.cOQ) {
                      break label2168;
                    }
                    break;
                  }
                  label2168:
                  m += i1;
                }
                m = -1;
                break label1739;
                if (i6 == a.cOv)
                {
                  paramm.setPosition(j + 8);
                  localc.cHc = com.google.android.exoplayer2.a.a.a(paramm, Integer.toString(paramInt1), paramString, (DrmInitData)localObject3);
                  localObject4 = localObject1;
                  i1 = k;
                  m = i;
                }
                else if (i6 == a.cOx)
                {
                  paramm.setPosition(j + 8);
                  localc.cHc = com.google.android.exoplayer2.a.a.b(paramm, Integer.toString(paramInt1), paramString, (DrmInitData)localObject3);
                  localObject4 = localObject1;
                  i1 = k;
                  m = i;
                }
                else if (i6 == a.cOC)
                {
                  localc.cHc = Format.a(Integer.toString(paramInt1), (String)localObject1, -1, -1, k, i, null, (DrmInitData)localObject3, paramString);
                  localObject4 = localObject1;
                  i1 = k;
                  m = i;
                }
                else
                {
                  localObject4 = localObject1;
                  i1 = k;
                  m = i;
                  if (i6 == a.cPV)
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
              if ((localc.cHc != null) || (localObject1 == null)) {
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
                localc.cHc = Format.a((String)localObject4, (String)localObject1, -1, -1, k, i, j, (List)localObject2, (DrmInitData)localObject3, 0, paramString);
                break;
                j = -1;
                break label2410;
              }
              if ((i == a.cPq) || (i == a.cPB) || (i == a.cPC) || (i == a.cPD) || (i == a.cPE))
              {
                paramm.setPosition(i4 + 8 + 8);
                localObject2 = null;
                long l = 9223372036854775807L;
                if (i == a.cPq) {
                  localObject1 = "application/ttml+xml";
                }
                for (;;)
                {
                  localc.cHc = Format.a(Integer.toString(paramInt1), (String)localObject1, 0, paramString, -1, null, l, (List)localObject2);
                  break;
                  if (i == a.cPB)
                  {
                    localObject1 = "application/x-quicktime-tx3g";
                    i = i5 - 8 - 8;
                    localObject2 = new byte[i];
                    paramm.readBytes((byte[])localObject2, 0, i);
                    localObject2 = Collections.singletonList(localObject2);
                  }
                  else if (i == a.cPC)
                  {
                    localObject1 = "application/x-mp4-vtt";
                  }
                  else if (i == a.cPD)
                  {
                    localObject1 = "application/ttml+xml";
                    l = 0L;
                  }
                  else
                  {
                    if (i != a.cPE) {
                      break label2672;
                    }
                    localObject1 = "application/x-mp4-cea-608";
                    localc.cQo = 1;
                  }
                }
                label2672:
                paramm = new IllegalStateException();
                AppMethodBeat.o(92066);
                throw paramm;
              }
              if (i != a.cPU) {
                break;
              }
              localc.cHc = Format.t(Integer.toString(paramInt1), "application/x-camera-motion");
              break;
              AppMethodBeat.o(92066);
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
    AppMethodBeat.i(92063);
    Object localObject2 = parama.hK(a.cOL);
    Object localObject1 = ((a.a)localObject2).hJ(a.cOZ).cPZ;
    ((com.google.android.exoplayer2.i.m)localObject1).setPosition(16);
    int i = ((com.google.android.exoplayer2.i.m)localObject1).readInt();
    if (i == cQb) {
      i = 1;
    }
    while (i == -1)
    {
      AppMethodBeat.o(92063);
      return null;
      if (i == cQa) {
        i = 2;
      } else if ((i == cQc) || (i == cQd) || (i == cQe) || (i == cQf)) {
        i = 3;
      } else if (i == cPI) {
        i = 4;
      } else {
        i = -1;
      }
    }
    localObject1 = parama.hJ(a.cOV).cPZ;
    ((com.google.android.exoplayer2.i.m)localObject1).setPosition(8);
    int i2 = a.hG(((com.google.android.exoplayer2.i.m)localObject1).readInt());
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
      ((com.google.android.exoplayer2.i.m)localObject1).iH(j);
      int i1 = ((com.google.android.exoplayer2.i.m)localObject1).readInt();
      ((com.google.android.exoplayer2.i.m)localObject1).iH(4);
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
      ((com.google.android.exoplayer2.i.m)localObject1).iH(j);
      l1 = -9223372036854775807L;
      ((com.google.android.exoplayer2.i.m)localObject1).iH(16);
      j = ((com.google.android.exoplayer2.i.m)localObject1).readInt();
      k = ((com.google.android.exoplayer2.i.m)localObject1).readInt();
      ((com.google.android.exoplayer2.i.m)localObject1).iH(4);
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
      paramb = paramb.cPZ;
      paramb.setPosition(8);
      long l2;
      if (a.hG(paramb.readInt()) == 0)
      {
        j = 8;
        paramb.iH(j);
        l1 = paramb.FT();
        if (paramLong != -9223372036854775807L) {
          break label800;
        }
        paramLong = -9223372036854775807L;
        paramb = ((a.a)localObject2).hK(a.cOM).hK(a.cON);
        localObject2 = ((a.a)localObject2).hJ(a.cOY).cPZ;
        ((com.google.android.exoplayer2.i.m)localObject2).setPosition(8);
        k = a.hG(((com.google.android.exoplayer2.i.m)localObject2).readInt());
        if (k != 0) {
          break label813;
        }
        j = 8;
        ((com.google.android.exoplayer2.i.m)localObject2).iH(j);
        l2 = ((com.google.android.exoplayer2.i.m)localObject2).FT();
        if (k != 0) {
          break label820;
        }
      }
      c localc;
      for (j = 4;; j = 8)
      {
        ((com.google.android.exoplayer2.i.m)localObject2).iH(j);
        j = ((com.google.android.exoplayer2.i.m)localObject2).readUnsignedShort();
        localObject2 = Pair.create(Long.valueOf(l2), (char)((j >> 10 & 0x1F) + 96) + (char)((j >> 5 & 0x1F) + 96) + (char)((j & 0x1F) + 96));
        localc = a(paramb.hJ(a.cPa).cPZ, ((f)localObject1).id, ((f)localObject1).Gj, (String)((Pair)localObject2).second, paramDrmInitData, paramBoolean2);
        paramb = null;
        paramDrmInitData = null;
        if (!paramBoolean1)
        {
          parama = b(parama.hK(a.cOW));
          paramb = (long[])parama.first;
          paramDrmInitData = (long[])parama.second;
        }
        if (localc.cHc != null) {
          break label827;
        }
        AppMethodBeat.o(92063);
        return null;
        j = 16;
        break;
        j = 8;
        break label215;
        k += 1;
        break label218;
        if (i2 == 0) {}
        for (l2 = ((com.google.android.exoplayer2.i.m)localObject1).FT();; l2 = ((com.google.android.exoplayer2.i.m)localObject1).UP())
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
        paramLong = x.c(paramLong, 1000000L, l1);
        break label413;
        j = 16;
        break label467;
      }
      parama = new j(((f)localObject1).id, i, ((Long)((Pair)localObject2).first).longValue(), l1, paramLong, localc.cHc, localc.cQo, localc.cQn, localc.cMd, paramb, paramDrmInitData);
      AppMethodBeat.o(92063);
      return parama;
    }
  }
  
  private static k a(com.google.android.exoplayer2.i.m paramm, int paramInt1, int paramInt2, String paramString)
  {
    Object localObject2 = null;
    boolean bool = true;
    AppMethodBeat.i(92071);
    int i = paramInt1 + 8;
    while (i - paramInt1 < paramInt2)
    {
      paramm.setPosition(i);
      int j = paramm.readInt();
      if (paramm.readInt() == a.cPf)
      {
        paramInt1 = a.hG(paramm.readInt());
        paramm.iH(1);
        if (paramInt1 == 0)
        {
          paramm.iH(1);
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
          AppMethodBeat.o(92071);
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
    AppMethodBeat.o(92071);
    return null;
  }
  
  public static m a(j paramj, a.a parama, i parami)
  {
    AppMethodBeat.i(92064);
    Object localObject1 = parama.hJ(a.cPx);
    if (localObject1 != null) {}
    int i10;
    for (Object localObject2 = new d((a.b)localObject1);; localObject2 = new e((a.b)localObject1))
    {
      i10 = ((b)localObject2).getSampleCount();
      if (i10 != 0) {
        break;
      }
      paramj = new m(new long[0], new int[0], 0, new long[0], new int[0]);
      AppMethodBeat.o(92064);
      return paramj;
      localObject1 = parama.hJ(a.cPy);
      if (localObject1 == null)
      {
        paramj = new o("Track has no sample table size information");
        AppMethodBeat.o(92064);
        throw paramj;
      }
    }
    boolean bool = false;
    Object localObject3 = parama.hJ(a.cPz);
    localObject1 = localObject3;
    if (localObject3 == null)
    {
      bool = true;
      localObject1 = parama.hJ(a.cPA);
    }
    localObject3 = ((a.b)localObject1).cPZ;
    Object localObject4 = parama.hJ(a.cPw).cPZ;
    com.google.android.exoplayer2.i.m localm = parama.hJ(a.cPt).cPZ;
    localObject1 = parama.hJ(a.cPu);
    label223:
    a locala;
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
      localObject1 = ((a.b)localObject1).cPZ;
      parama = parama.hJ(a.cPv);
      if (parama == null) {
        break label492;
      }
      parama = parama.cPZ;
      locala = new a((com.google.android.exoplayer2.i.m)localObject4, (com.google.android.exoplayer2.i.m)localObject3, bool);
      localm.setPosition(12);
      i2 = localm.UN() - 1;
      i3 = localm.UN();
      i4 = localm.UN();
      n = 0;
      i = 0;
      i5 = 0;
      if (parama != null)
      {
        parama.setPosition(12);
        i = parama.UN();
      }
      m = -1;
      k = 0;
      localObject3 = localObject1;
      j = m;
      if (localObject1 != null)
      {
        ((com.google.android.exoplayer2.i.m)localObject1).setPosition(12);
        k = ((com.google.android.exoplayer2.i.m)localObject1).UN();
        if (k <= 0) {
          break label497;
        }
        j = ((com.google.android.exoplayer2.i.m)localObject1).UN() - 1;
        localObject3 = localObject1;
      }
      label342:
      if ((!((b)localObject2).Sc()) || (!"audio/raw".equals(paramj.cHc.cGN)) || (i2 != 0) || (i != 0) || (k != 0)) {
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
      for (i5 = m; i5 == 0; i5 = locala.cQh)
      {
        com.google.android.exoplayer2.i.a.checkState(locala.Sa());
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
        n = parama.UN();
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
      localObject1[i1] = ((b)localObject2).Sb();
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
          k = ((com.google.android.exoplayer2.i.m)localObject3).UN();
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
          k = localm.UN();
          i4 = localm.UN();
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
            if (parama.UN() != 0) {
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
          while ((paramj.cRP == null) || (parami.RX()))
          {
            x.a((long[])localObject3, paramj.cRM);
            paramj = new m(parama, (int[])localObject1, j, (long[])localObject3, (int[])localObject2);
            AppMethodBeat.o(92064);
            return paramj;
            parama = new long[locala.length];
            localObject1 = new int[locala.length];
            while (locala.Sa())
            {
              parama[locala.index] = locala.offset;
              localObject1[locala.index] = locala.cQh;
            }
            localObject2 = d.a(((b)localObject2).Sb(), parama, (int[])localObject1, i4);
            parama = ((d.a)localObject2).offsets;
            localObject1 = ((d.a)localObject2).cLg;
            j = ((d.a)localObject2).cQu;
            localObject3 = ((d.a)localObject2).cQv;
            localObject2 = ((d.a)localObject2).cQw;
          }
          long l3;
          if ((paramj.cRP.length == 1) && (paramj.type == 1) && (localObject3.length >= 2))
          {
            l3 = paramj.cRQ[0];
            l2 = x.c(paramj.cRP[0], paramj.cRM, paramj.cRN) + l3;
            if ((localObject3[0] <= l3) && (l3 < localObject3[1]) && (localObject3[(localObject3.length - 1)] < l2) && (l2 <= l1))
            {
              l3 = x.c(l3 - localObject3[0], paramj.cHc.sampleRate, paramj.cRM);
              l1 = x.c(l1 - l2, paramj.cHc.sampleRate, paramj.cRM);
              if (((l3 != 0L) || (l1 != 0L)) && (l3 <= 2147483647L) && (l1 <= 2147483647L))
              {
                parami.cGW = ((int)l3);
                parami.cGX = ((int)l1);
                x.a((long[])localObject3, paramj.cRM);
                paramj = new m(parama, (int[])localObject1, j, (long[])localObject3, (int[])localObject2);
                AppMethodBeat.o(92064);
                return paramj;
              }
            }
          }
          if ((paramj.cRP.length == 1) && (paramj.cRP[0] == 0L))
          {
            i = 0;
            while (i < localObject3.length)
            {
              localObject3[i] = x.c(localObject3[i] - paramj.cRQ[0], 1000000L, paramj.cRM);
              i += 1;
            }
            paramj = new m(parama, (int[])localObject1, j, (long[])localObject3, (int[])localObject2);
            AppMethodBeat.o(92064);
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
            if (n >= paramj.cRP.length) {
              break label1543;
            }
            l1 = paramj.cRQ[n];
            if (l1 == -1L) {
              break label2014;
            }
            l2 = x.c(paramj.cRP[n], paramj.cRM, paramj.cRN);
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
              if (i1 >= paramj.cRP.length) {
                break label1898;
              }
              l2 = paramj.cRQ[i1];
              l3 = paramj.cRP[i1];
              i3 = k;
              n = i;
              if (l2 == -1L) {
                break label1875;
              }
              long l4 = x.c(l3, paramj.cRM, paramj.cRN);
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
              l4 = x.c(l1, 1000000L, paramj.cRN);
              localObject6[m] = (x.c(localObject3[i2] - l2, 1000000L, paramj.cRM) + l4);
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
                x.a((long[])localObject3, paramj.cRM);
                paramj = new m(parama, (int[])localObject1, j, (long[])localObject3, (int[])localObject2);
                AppMethodBeat.o(92064);
                return paramj;
              }
              paramj = new m(parami, (int[])localObject4, k, (long[])localObject6, (int[])localObject5);
              AppMethodBeat.o(92064);
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
    AppMethodBeat.i(92065);
    if (paramBoolean)
    {
      AppMethodBeat.o(92065);
      return null;
    }
    paramb = paramb.cPZ;
    paramb.setPosition(8);
    while (paramb.UF() >= 8)
    {
      int i = paramb.position;
      int j = paramb.readInt();
      if (paramb.readInt() == a.cPI)
      {
        paramb.setPosition(i);
        paramb.iH(12);
        while (paramb.position < i + j)
        {
          int k = paramb.position;
          int m = paramb.readInt();
          if (paramb.readInt() == a.cPJ)
          {
            paramb.setPosition(k);
            paramb.iH(8);
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
            AppMethodBeat.o(92065);
            return paramb;
          }
          paramb.iH(m - 8);
        }
        AppMethodBeat.o(92065);
        return null;
      }
      paramb.iH(j - 8);
    }
    AppMethodBeat.o(92065);
    return null;
  }
  
  private static Pair<long[], long[]> b(a.a parama)
  {
    AppMethodBeat.i(92067);
    if (parama != null)
    {
      parama = parama.hJ(a.cOX);
      if (parama != null) {}
    }
    else
    {
      parama = Pair.create(null, null);
      AppMethodBeat.o(92067);
      return parama;
    }
    parama = parama.cPZ;
    parama.setPosition(8);
    int j = a.hG(parama.readInt());
    int k = parama.UN();
    long[] arrayOfLong1 = new long[k];
    long[] arrayOfLong2 = new long[k];
    int i = 0;
    while (i < k)
    {
      if (j == 1)
      {
        l = parama.UP();
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
        AppMethodBeat.o(92067);
        throw parama;
        l = parama.FT();
        break;
      }
      label220:
      parama.iH(2);
      i += 1;
    }
    parama = Pair.create(arrayOfLong1, arrayOfLong2);
    AppMethodBeat.o(92067);
    return parama;
  }
  
  private static Pair<Integer, k> b(com.google.android.exoplayer2.i.m paramm, int paramInt1, int paramInt2)
  {
    boolean bool2 = true;
    AppMethodBeat.i(92070);
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
      if (n == a.cPi)
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
        if (n == a.cPd)
        {
          paramm.iH(4);
          localObject4 = paramm.readString(4);
          localObject3 = localObject1;
        }
        else
        {
          localObject3 = localObject1;
          localObject4 = localObject2;
          if (n == a.cPe)
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
        AppMethodBeat.o(92070);
        return paramm;
        bool1 = false;
        break;
        bool1 = false;
        break label216;
      }
    }
    AppMethodBeat.o(92070);
    return null;
  }
  
  private static Pair<String, byte[]> c(com.google.android.exoplayer2.i.m paramm, int paramInt)
  {
    Object localObject = null;
    AppMethodBeat.i(92068);
    paramm.setPosition(paramInt + 8 + 4);
    paramm.iH(1);
    k(paramm);
    paramm.iH(2);
    paramInt = paramm.readUnsignedByte();
    if ((paramInt & 0x80) != 0) {
      paramm.iH(2);
    }
    if ((paramInt & 0x40) != 0) {
      paramm.iH(paramm.readUnsignedShort());
    }
    if ((paramInt & 0x20) != 0) {
      paramm.iH(2);
    }
    paramm.iH(1);
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
        paramm.iH(12);
        paramm.iH(1);
        paramInt = k(paramm);
        byte[] arrayOfByte = new byte[paramInt];
        paramm.readBytes(arrayOfByte, 0, paramInt);
        paramm = Pair.create(localObject, arrayOfByte);
        AppMethodBeat.o(92068);
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
        AppMethodBeat.o(92068);
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
      AppMethodBeat.o(92068);
      return paramm;
    }
    paramm = Pair.create("audio/vnd.dts.hd", null);
    AppMethodBeat.o(92068);
    return paramm;
  }
  
  private static int k(com.google.android.exoplayer2.i.m paramm)
  {
    AppMethodBeat.i(92072);
    int j = paramm.readUnsignedByte();
    for (int i = j & 0x7F; (j & 0x80) == 128; i = i << 7 | j & 0x7F) {
      j = paramm.readUnsignedByte();
    }
    AppMethodBeat.o(92072);
    return i;
  }
  
  static final class a
  {
    public int cQh;
    private final boolean cQi;
    private final com.google.android.exoplayer2.i.m cQj;
    private final com.google.android.exoplayer2.i.m cQk;
    private int cQl;
    private int cQm;
    public int index;
    public final int length;
    public long offset;
    
    public a(com.google.android.exoplayer2.i.m paramm1, com.google.android.exoplayer2.i.m paramm2, boolean paramBoolean)
    {
      AppMethodBeat.i(92056);
      this.cQk = paramm1;
      this.cQj = paramm2;
      this.cQi = paramBoolean;
      paramm2.setPosition(12);
      this.length = paramm2.UN();
      paramm1.setPosition(12);
      this.cQm = paramm1.UN();
      if (paramm1.readInt() == 1) {}
      for (paramBoolean = bool;; paramBoolean = false)
      {
        com.google.android.exoplayer2.i.a.checkState(paramBoolean, "first_chunk must be 1");
        this.index = -1;
        AppMethodBeat.o(92056);
        return;
      }
    }
    
    public final boolean Sa()
    {
      AppMethodBeat.i(92057);
      int i = this.index + 1;
      this.index = i;
      if (i == this.length)
      {
        AppMethodBeat.o(92057);
        return false;
      }
      long l;
      if (this.cQi)
      {
        l = this.cQj.UP();
        this.offset = l;
        if (this.index == this.cQl)
        {
          this.cQh = this.cQk.UN();
          this.cQk.iH(4);
          i = this.cQm - 1;
          this.cQm = i;
          if (i <= 0) {
            break label131;
          }
        }
      }
      label131:
      for (i = this.cQk.UN() - 1;; i = -1)
      {
        this.cQl = i;
        AppMethodBeat.o(92057);
        return true;
        l = this.cQj.FT();
        break;
      }
    }
  }
  
  static abstract interface b
  {
    public abstract int Sb();
    
    public abstract boolean Sc();
    
    public abstract int getSampleCount();
  }
  
  static final class c
  {
    public Format cHc;
    public int cMd;
    public final k[] cQn;
    public int cQo;
    
    public c(int paramInt)
    {
      AppMethodBeat.i(92058);
      this.cQn = new k[paramInt];
      this.cQo = 0;
      AppMethodBeat.o(92058);
    }
  }
  
  static final class d
    implements b.b
  {
    private final com.google.android.exoplayer2.i.m cPZ;
    private final int cQp;
    private final int sampleCount;
    
    public d(a.b paramb)
    {
      AppMethodBeat.i(92059);
      this.cPZ = paramb.cPZ;
      this.cPZ.setPosition(12);
      this.cQp = this.cPZ.UN();
      this.sampleCount = this.cPZ.UN();
      AppMethodBeat.o(92059);
    }
    
    public final int Sb()
    {
      AppMethodBeat.i(92060);
      if (this.cQp == 0)
      {
        i = this.cPZ.UN();
        AppMethodBeat.o(92060);
        return i;
      }
      int i = this.cQp;
      AppMethodBeat.o(92060);
      return i;
    }
    
    public final boolean Sc()
    {
      return this.cQp != 0;
    }
    
    public final int getSampleCount()
    {
      return this.sampleCount;
    }
  }
  
  static final class e
    implements b.b
  {
    private final com.google.android.exoplayer2.i.m cPZ;
    private final int cQq;
    private int cQr;
    private int cQs;
    private final int sampleCount;
    
    public e(a.b paramb)
    {
      AppMethodBeat.i(92061);
      this.cPZ = paramb.cPZ;
      this.cPZ.setPosition(12);
      this.cQq = (this.cPZ.UN() & 0xFF);
      this.sampleCount = this.cPZ.UN();
      AppMethodBeat.o(92061);
    }
    
    public final int Sb()
    {
      AppMethodBeat.i(92062);
      if (this.cQq == 8)
      {
        i = this.cPZ.readUnsignedByte();
        AppMethodBeat.o(92062);
        return i;
      }
      if (this.cQq == 16)
      {
        i = this.cPZ.readUnsignedShort();
        AppMethodBeat.o(92062);
        return i;
      }
      int i = this.cQr;
      this.cQr = (i + 1);
      if (i % 2 == 0)
      {
        this.cQs = this.cPZ.readUnsignedByte();
        i = this.cQs;
        AppMethodBeat.o(92062);
        return (i & 0xF0) >> 4;
      }
      i = this.cQs;
      AppMethodBeat.o(92062);
      return i & 0xF;
    }
    
    public final boolean Sc()
    {
      return false;
    }
    
    public final int getSampleCount()
    {
      return this.sampleCount;
    }
  }
  
  static final class f
  {
    final int Gj;
    final long duration;
    final int id;
    
    public f(int paramInt1, long paramLong, int paramInt2)
    {
      this.id = paramInt1;
      this.duration = paramLong;
      this.Gj = paramInt2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.google.android.exoplayer2.c.d.b
 * JD-Core Version:    0.7.0.1
 */