package com.tencent.mm.audio.c.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ad;
import d.g.b.k;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/audio/utils/player/AudioPlayerReportUtil;", "", "()V", "mIsReportStart", "", "mRMSInOnePlayerProcess", "", "", "[Ljava/lang/Integer;", "mSystemVolumProcess", "byteArray2ShortArray", "", "data", "", "items", "calcDecibelLevel", "", "buffer", "readSize", "checkPCMAmplitude", "", "length", "checkSystemVolume", "type", "volume", "doAudioRecordKVReport", "audioType", "scenes", "featureKey", "", "pcmSilent", "pcmLow", "pcmMiddle", "pcmHigh", "systemSilent", "systemLow", "systemMiddle", "systemHigh", "audioSource", "doAudioVolumeRecordKVReport", "streamType", "doPCMPlayerChecker", "doPCMPlayerPercentReport", "index", "result", "", "doPCMPlayerResultReport", "doPcmPlayerReport", "doSystemVolumePercentReport", "doSystemVolumePlayerChecker", "doSystemVolumeResultReport", "getRMSInOnePlayerProcessReportSum", "getSystemVolumePercentReportSum", "Companion", "plugin-audiosdk_release"})
public final class a
{
  public static final a.a cZW;
  private boolean cZT;
  private Integer[] cZU;
  private Integer[] cZV;
  
  static
  {
    AppMethodBeat.i(130117);
    cZW = new a.a((byte)0);
    AppMethodBeat.o(130117);
  }
  
  public a()
  {
    AppMethodBeat.i(130116);
    Integer[] arrayOfInteger = new Integer[4];
    int i = 0;
    while (i < 4)
    {
      arrayOfInteger[i] = Integer.valueOf(0);
      i += 1;
    }
    this.cZU = arrayOfInteger;
    arrayOfInteger = new Integer[4];
    i = 0;
    while (i < 4)
    {
      arrayOfInteger[i] = Integer.valueOf(0);
      i += 1;
    }
    this.cZV = arrayOfInteger;
    AppMethodBeat.o(130116);
  }
  
  private final int OA()
  {
    AppMethodBeat.i(130113);
    Integer[] arrayOfInteger = this.cZU;
    int k = arrayOfInteger.length;
    int i = 0;
    int j = 0;
    while (i < k)
    {
      j += ((Number)arrayOfInteger[i]).intValue();
      i += 1;
    }
    AppMethodBeat.o(130113);
    return j;
  }
  
  public final void b(int paramInt1, String paramString, int paramInt2)
  {
    AppMethodBeat.i(130109);
    k.h(paramString, "featureKey");
    int i3 = OA();
    if (i3 != 0)
    {
      int i = this.cZU[0].intValue() * 100 / i3;
      int j = this.cZU[1].intValue() * 100 / i3;
      int k = this.cZU[2].intValue() * 100 / i3;
      int m = this.cZU[3].intValue() * 100 / i3;
      int n = this.cZV[0].intValue() * 100 / i3;
      int i1 = this.cZV[1].intValue() * 100 / i3;
      int i2 = this.cZV[2].intValue() * 100 / i3;
      i3 = this.cZV[3].intValue() * 100 / i3;
      ad.i("MicroMsg.AudioPlayerReportUtil", "audioType = 1 ,scenes = " + paramInt1 + ",featureKey=" + paramString + ",pcmSilent=" + i + ", pcmLow=" + j + ",pcmMiddle=" + k + ",pcmHigh=" + m + ",systemSilent=" + n + ",systemLow=" + i1 + ",systemMiddle=" + i2 + ",systemHigh=" + i3 + ",streamType=" + paramInt2 + '}');
      h.vKh.a(18554, true, true, new Object[] { Integer.valueOf(1), Integer.valueOf(paramInt1), paramString, Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k), Integer.valueOf(m), Integer.valueOf(n), Integer.valueOf(i1), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(paramInt2) });
    }
    AppMethodBeat.o(130109);
  }
  
  public final void ci(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(130114);
    if (!this.cZT)
    {
      AppMethodBeat.o(130114);
      return;
    }
    switch (paramInt1)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(130114);
      return;
      Integer[] arrayOfInteger;
      if (paramInt2 < 10)
      {
        arrayOfInteger = this.cZV;
        arrayOfInteger[0] = Integer.valueOf(arrayOfInteger[0].intValue() + 1);
        AppMethodBeat.o(130114);
        return;
      }
      if (paramInt2 < 40)
      {
        arrayOfInteger = this.cZV;
        arrayOfInteger[1] = Integer.valueOf(arrayOfInteger[1].intValue() + 1);
        AppMethodBeat.o(130114);
        return;
      }
      if (paramInt2 < 80)
      {
        arrayOfInteger = this.cZV;
        arrayOfInteger[2] = Integer.valueOf(arrayOfInteger[2].intValue() + 1);
        AppMethodBeat.o(130114);
        return;
      }
      if (paramInt2 <= 100)
      {
        arrayOfInteger = this.cZV;
        arrayOfInteger[3] = Integer.valueOf(arrayOfInteger[3].intValue() + 1);
      }
      AppMethodBeat.o(130114);
      return;
      if (paramInt2 < 10)
      {
        arrayOfInteger = this.cZV;
        arrayOfInteger[0] = Integer.valueOf(arrayOfInteger[0].intValue() + 1);
        AppMethodBeat.o(130114);
        return;
      }
      if (paramInt2 < 40)
      {
        arrayOfInteger = this.cZV;
        arrayOfInteger[1] = Integer.valueOf(arrayOfInteger[1].intValue() + 1);
        AppMethodBeat.o(130114);
        return;
      }
      if (paramInt2 < 80)
      {
        arrayOfInteger = this.cZV;
        arrayOfInteger[2] = Integer.valueOf(arrayOfInteger[2].intValue() + 1);
        AppMethodBeat.o(130114);
        return;
      }
      if (paramInt2 <= 100)
      {
        arrayOfInteger = this.cZV;
        arrayOfInteger[3] = Integer.valueOf(arrayOfInteger[3].intValue() + 1);
      }
    }
  }
  
  public final void e(int paramInt, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(130115);
    k.h(paramArrayOfByte, "data");
    if (!this.cZT)
    {
      AppMethodBeat.o(130115);
      return;
    }
    if (paramInt != 0)
    {
      short[] arrayOfShort = new short[paramInt / 2];
      int j = arrayOfShort.length;
      int i = 0;
      while (i < j)
      {
        arrayOfShort[i] = ((short)(paramArrayOfByte[(i * 2)] & 0xFF | (paramArrayOfByte[(i * 2 + 1)] & 0xFF) << 8));
        i += 1;
      }
      i = paramInt / 2;
      double d = 0.0D;
      j = arrayOfShort.length;
      paramInt = 0;
      while (paramInt < j)
      {
        int k = arrayOfShort[paramInt];
        d += k * k;
        paramInt += 1;
      }
      d = Math.sqrt(d / i);
      if (d < 50.0D)
      {
        paramArrayOfByte = this.cZU;
        paramArrayOfByte[0] = Integer.valueOf(paramArrayOfByte[0].intValue() + 1);
        AppMethodBeat.o(130115);
        return;
      }
      if (d < 300.0D)
      {
        paramArrayOfByte = this.cZU;
        paramArrayOfByte[1] = Integer.valueOf(paramArrayOfByte[1].intValue() + 1);
        AppMethodBeat.o(130115);
        return;
      }
      if (d < 2000.0D)
      {
        paramArrayOfByte = this.cZU;
        paramArrayOfByte[2] = Integer.valueOf(paramArrayOfByte[2].intValue() + 1);
        AppMethodBeat.o(130115);
        return;
      }
      paramArrayOfByte = this.cZU;
      paramArrayOfByte[3] = Integer.valueOf(paramArrayOfByte[3].intValue() + 1);
    }
    AppMethodBeat.o(130115);
  }
  
  public final void hZ(int paramInt)
  {
    AppMethodBeat.i(130110);
    this.cZT = true;
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(130110);
      return;
      c.OB();
      AppMethodBeat.o(130110);
      return;
      b.OB();
    }
  }
  
  public final void ia(int paramInt)
  {
    AppMethodBeat.i(130111);
    if (!this.cZT)
    {
      AppMethodBeat.o(130111);
      return;
    }
    int k = OA();
    if (k != 0)
    {
      Integer[] arrayOfInteger = this.cZU;
      int i = 0;
      int m = arrayOfInteger.length;
      int j = 0;
      if (j < m)
      {
        int n = ((Number)arrayOfInteger[j]).intValue();
        long l = n * 100 / k;
        if (this.cZT) {}
        switch (paramInt)
        {
        default: 
          n = n * 100 / k;
          if (this.cZT) {
            switch (paramInt)
            {
            }
          }
          break;
        }
        for (;;)
        {
          j += 1;
          i += 1;
          break;
          switch (i)
          {
          default: 
            break;
          case 0: 
            c.bi(l);
            break;
          case 1: 
            c.bj(l);
            break;
          case 2: 
            c.bk(l);
            break;
          case 3: 
            c.bl(l);
            break;
            switch (i)
            {
            default: 
              break;
            case 0: 
              b.bi(l);
              break;
            case 1: 
              b.bj(l);
              break;
            case 2: 
              b.bk(l);
              break;
            case 3: 
              b.bl(l);
              break;
              switch (i)
              {
              default: 
                break;
              case 0: 
                if (n == 0) {
                  c.OC();
                } else if (n <= 20) {
                  c.OD();
                } else if (n <= 40) {
                  c.OE();
                } else if (n <= 60) {
                  c.OF();
                } else if (n <= 80) {
                  c.OG();
                } else if (n == 100) {
                  c.OH();
                }
                break;
              case 1: 
                if (n == 0) {
                  c.OI();
                } else if (n <= 20) {
                  c.OJ();
                } else if (n <= 40) {
                  c.OK();
                } else if (n <= 60) {
                  c.OL();
                } else if (n <= 80) {
                  c.OM();
                } else if (n == 100) {
                  c.ON();
                }
                break;
              case 2: 
                if (n == 0) {
                  c.OO();
                } else if (n <= 20) {
                  c.OP();
                } else if (n <= 40) {
                  c.OQ();
                } else if (n <= 60) {
                  c.OR();
                } else if (n <= 80) {
                  c.OS();
                } else if (n == 100) {
                  c.OT();
                }
                break;
              case 3: 
                if (n == 0)
                {
                  c.OU();
                }
                else if (n <= 20)
                {
                  c.OV();
                }
                else if (n <= 40)
                {
                  c.OW();
                }
                else if (n <= 60)
                {
                  c.OX();
                }
                else if (n <= 80)
                {
                  c.OY();
                }
                else if (n == 100)
                {
                  c.OZ();
                  continue;
                  switch (i)
                  {
                  default: 
                    break;
                  case 0: 
                    if (n == 0) {
                      b.OC();
                    } else if (n <= 20) {
                      b.OD();
                    } else if (n <= 40) {
                      b.OE();
                    } else if (n <= 60) {
                      b.OF();
                    } else if (n <= 80) {
                      b.OG();
                    } else if (n <= 100) {
                      b.OH();
                    }
                    break;
                  case 1: 
                    if (n == 0) {
                      b.OI();
                    } else if (n <= 20) {
                      b.OJ();
                    } else if (n <= 40) {
                      b.OK();
                    } else if (n <= 60) {
                      b.OL();
                    } else if (n <= 80) {
                      b.OM();
                    } else if (n <= 100) {
                      b.ON();
                    }
                    break;
                  case 2: 
                    if (n == 0) {
                      b.OO();
                    } else if (n <= 20) {
                      b.OP();
                    } else if (n <= 40) {
                      b.OQ();
                    } else if (n <= 60) {
                      b.OR();
                    } else if (n <= 80) {
                      b.OS();
                    } else if (n <= 100) {
                      b.OT();
                    }
                    break;
                  case 3: 
                    if (n == 0) {
                      b.OU();
                    } else if (n <= 20) {
                      b.OV();
                    } else if (n <= 40) {
                      b.OW();
                    } else if (n <= 60) {
                      b.OX();
                    } else if (n <= 80) {
                      b.OY();
                    } else if (n <= 100) {
                      b.OZ();
                    }
                    break;
                  }
                }
                break;
              }
              break;
            }
            break;
          }
        }
      }
      arrayOfInteger = new Integer[4];
      paramInt = 0;
      while (paramInt < 4)
      {
        arrayOfInteger[paramInt] = Integer.valueOf(0);
        paramInt += 1;
      }
      this.cZU = arrayOfInteger;
    }
    AppMethodBeat.o(130111);
  }
  
  public final void ib(int paramInt)
  {
    AppMethodBeat.i(130112);
    if (!this.cZT)
    {
      AppMethodBeat.o(130112);
      return;
    }
    Integer[] arrayOfInteger = this.cZV;
    int k = arrayOfInteger.length;
    int j = 0;
    int i = 0;
    int m;
    while (j < k)
    {
      m = ((Number)arrayOfInteger[j]).intValue();
      j += 1;
      i += m;
    }
    if (i != 0)
    {
      arrayOfInteger = this.cZV;
      j = 0;
      m = arrayOfInteger.length;
      k = 0;
      if (k < m)
      {
        int n = ((Number)arrayOfInteger[k]).intValue();
        long l = n * 100 / i;
        if (this.cZT) {}
        switch (paramInt)
        {
        default: 
          n = n * 100 / i;
          if (this.cZT) {
            switch (paramInt)
            {
            }
          }
          break;
        }
        for (;;)
        {
          k += 1;
          j += 1;
          break;
          switch (j)
          {
          default: 
            break;
          case 0: 
            c.bm(l);
            break;
          case 1: 
            c.bn(l);
            break;
          case 2: 
            c.bo(l);
            break;
          case 3: 
            c.bp(l);
            break;
            switch (j)
            {
            default: 
              break;
            case 0: 
              b.bm(l);
              break;
            case 1: 
              b.bn(l);
              break;
            case 2: 
              b.bo(l);
              break;
            case 3: 
              b.bp(l);
              break;
              switch (j)
              {
              default: 
                break;
              case 0: 
                if (n == 0) {
                  c.Pa();
                } else if (n <= 20) {
                  c.Pb();
                } else if (n <= 40) {
                  c.Pc();
                } else if (n <= 60) {
                  c.Pd();
                } else if (n <= 80) {
                  c.Pe();
                } else if (n == 100) {
                  c.Pf();
                }
                break;
              case 1: 
                if (n == 0) {
                  c.Pg();
                } else if (n <= 20) {
                  c.Ph();
                } else if (n <= 40) {
                  c.Pi();
                } else if (n <= 60) {
                  c.Pj();
                } else if (n <= 80) {
                  c.Pk();
                } else if (n == 100) {
                  c.Pl();
                }
                break;
              case 2: 
                if (n == 0) {
                  c.Pm();
                } else if (n <= 20) {
                  c.Pn();
                } else if (n <= 40) {
                  c.Po();
                } else if (n <= 60) {
                  c.Pp();
                } else if (n <= 80) {
                  c.Pq();
                } else if (n == 100) {
                  c.Pr();
                }
                break;
              case 3: 
                if (n == 0)
                {
                  c.Ps();
                }
                else if (n <= 20)
                {
                  c.Pt();
                }
                else if (n <= 40)
                {
                  c.Pu();
                }
                else if (n <= 60)
                {
                  c.Pv();
                }
                else if (n <= 80)
                {
                  c.Pw();
                }
                else if (n == 100)
                {
                  c.Px();
                  continue;
                  switch (j)
                  {
                  default: 
                    break;
                  case 0: 
                    if (n == 0) {
                      b.Pa();
                    } else if (n <= 20) {
                      b.Pb();
                    } else if (n <= 40) {
                      b.Pc();
                    } else if (n <= 60) {
                      b.Pd();
                    } else if (n <= 80) {
                      b.Pe();
                    } else if (n <= 100) {
                      b.Pf();
                    }
                    break;
                  case 1: 
                    if (n == 0) {
                      b.Pg();
                    } else if (n <= 20) {
                      b.Ph();
                    } else if (n <= 40) {
                      b.Pi();
                    } else if (n <= 60) {
                      b.Pj();
                    } else if (n <= 80) {
                      b.Pk();
                    } else if (n <= 100) {
                      b.Pl();
                    }
                    break;
                  case 2: 
                    if (n == 0) {
                      b.Pm();
                    } else if (n <= 20) {
                      b.Pn();
                    } else if (n <= 40) {
                      b.Po();
                    } else if (n <= 60) {
                      b.Pp();
                    } else if (n <= 80) {
                      b.Pq();
                    } else if (n <= 100) {
                      b.Pr();
                    }
                    break;
                  case 3: 
                    if (n == 0) {
                      b.Ps();
                    } else if (n <= 20) {
                      b.Pt();
                    } else if (n <= 40) {
                      b.Pu();
                    } else if (n <= 60) {
                      b.Pv();
                    } else if (n <= 80) {
                      b.Pw();
                    } else if (n <= 100) {
                      b.Px();
                    }
                    break;
                  }
                }
                break;
              }
              break;
            }
            break;
          }
        }
      }
      arrayOfInteger = new Integer[4];
      paramInt = 0;
      while (paramInt < 4)
      {
        arrayOfInteger[paramInt] = Integer.valueOf(0);
        paramInt += 1;
      }
      this.cZV = arrayOfInteger;
    }
    AppMethodBeat.o(130112);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.audio.c.a.a
 * JD-Core Version:    0.7.0.1
 */