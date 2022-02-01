package com.tencent.mm.audio.c.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ac;
import d.g.b.k;
import d.l;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/audio/utils/player/AudioPlayerReportUtil;", "", "()V", "mIsReportStart", "", "mRMSInOnePlayerProcess", "", "", "[Ljava/lang/Integer;", "mSystemVolumProcess", "byteArray2ShortArray", "", "data", "", "items", "calcDecibelLevel", "", "buffer", "readSize", "checkPCMAmplitude", "", "length", "checkSystemVolume", "type", "volume", "doAudioRecordKVReport", "audioType", "scenes", "featureKey", "", "pcmSilent", "pcmLow", "pcmMiddle", "pcmHigh", "systemSilent", "systemLow", "systemMiddle", "systemHigh", "audioSource", "doAudioVolumeRecordKVReport", "streamType", "doPCMPlayerChecker", "doPCMPlayerPercentReport", "index", "result", "", "doPCMPlayerResultReport", "doPcmPlayerReport", "doSystemVolumePercentReport", "doSystemVolumePlayerChecker", "doSystemVolumeResultReport", "getRMSInOnePlayerProcessReportSum", "getSystemVolumePercentReportSum", "Companion", "plugin-audiosdk_release"})
public final class a
{
  public static final a.a cXs;
  private boolean cXp;
  private Integer[] cXq;
  private Integer[] cXr;
  
  static
  {
    AppMethodBeat.i(130117);
    cXs = new a.a((byte)0);
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
    this.cXq = arrayOfInteger;
    arrayOfInteger = new Integer[4];
    i = 0;
    while (i < 4)
    {
      arrayOfInteger[i] = Integer.valueOf(0);
      i += 1;
    }
    this.cXr = arrayOfInteger;
    AppMethodBeat.o(130116);
  }
  
  private final int Ow()
  {
    AppMethodBeat.i(130113);
    Integer[] arrayOfInteger = this.cXq;
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
    int i3 = Ow();
    if (i3 != 0)
    {
      int i = this.cXq[0].intValue() * 100 / i3;
      int j = this.cXq[1].intValue() * 100 / i3;
      int k = this.cXq[2].intValue() * 100 / i3;
      int m = this.cXq[3].intValue() * 100 / i3;
      int n = this.cXr[0].intValue() * 100 / i3;
      int i1 = this.cXr[1].intValue() * 100 / i3;
      int i2 = this.cXr[2].intValue() * 100 / i3;
      i3 = this.cXr[3].intValue() * 100 / i3;
      ac.i("MicroMsg.AudioPlayerReportUtil", "audioType = 1 ,scenes = " + paramInt1 + ",featureKey=" + paramString + ",pcmSilent=" + i + ", pcmLow=" + j + ",pcmMiddle=" + k + ",pcmHigh=" + m + ",systemSilent=" + n + ",systemLow=" + i1 + ",systemMiddle=" + i2 + ",systemHigh=" + i3 + ",streamType=" + paramInt2 + '}');
      h.wUl.a(18554, true, true, new Object[] { Integer.valueOf(1), Integer.valueOf(paramInt1), paramString, Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k), Integer.valueOf(m), Integer.valueOf(n), Integer.valueOf(i1), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(paramInt2) });
    }
    AppMethodBeat.o(130109);
  }
  
  public final void cg(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(130114);
    if (!this.cXp)
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
        arrayOfInteger = this.cXr;
        arrayOfInteger[0] = Integer.valueOf(arrayOfInteger[0].intValue() + 1);
        AppMethodBeat.o(130114);
        return;
      }
      if (paramInt2 < 40)
      {
        arrayOfInteger = this.cXr;
        arrayOfInteger[1] = Integer.valueOf(arrayOfInteger[1].intValue() + 1);
        AppMethodBeat.o(130114);
        return;
      }
      if (paramInt2 < 80)
      {
        arrayOfInteger = this.cXr;
        arrayOfInteger[2] = Integer.valueOf(arrayOfInteger[2].intValue() + 1);
        AppMethodBeat.o(130114);
        return;
      }
      if (paramInt2 <= 100)
      {
        arrayOfInteger = this.cXr;
        arrayOfInteger[3] = Integer.valueOf(arrayOfInteger[3].intValue() + 1);
      }
      AppMethodBeat.o(130114);
      return;
      if (paramInt2 < 10)
      {
        arrayOfInteger = this.cXr;
        arrayOfInteger[0] = Integer.valueOf(arrayOfInteger[0].intValue() + 1);
        AppMethodBeat.o(130114);
        return;
      }
      if (paramInt2 < 40)
      {
        arrayOfInteger = this.cXr;
        arrayOfInteger[1] = Integer.valueOf(arrayOfInteger[1].intValue() + 1);
        AppMethodBeat.o(130114);
        return;
      }
      if (paramInt2 < 80)
      {
        arrayOfInteger = this.cXr;
        arrayOfInteger[2] = Integer.valueOf(arrayOfInteger[2].intValue() + 1);
        AppMethodBeat.o(130114);
        return;
      }
      if (paramInt2 <= 100)
      {
        arrayOfInteger = this.cXr;
        arrayOfInteger[3] = Integer.valueOf(arrayOfInteger[3].intValue() + 1);
      }
    }
  }
  
  public final void e(int paramInt, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(130115);
    k.h(paramArrayOfByte, "data");
    if (!this.cXp)
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
        paramArrayOfByte = this.cXq;
        paramArrayOfByte[0] = Integer.valueOf(paramArrayOfByte[0].intValue() + 1);
        AppMethodBeat.o(130115);
        return;
      }
      if (d < 300.0D)
      {
        paramArrayOfByte = this.cXq;
        paramArrayOfByte[1] = Integer.valueOf(paramArrayOfByte[1].intValue() + 1);
        AppMethodBeat.o(130115);
        return;
      }
      if (d < 2000.0D)
      {
        paramArrayOfByte = this.cXq;
        paramArrayOfByte[2] = Integer.valueOf(paramArrayOfByte[2].intValue() + 1);
        AppMethodBeat.o(130115);
        return;
      }
      paramArrayOfByte = this.cXq;
      paramArrayOfByte[3] = Integer.valueOf(paramArrayOfByte[3].intValue() + 1);
    }
    AppMethodBeat.o(130115);
  }
  
  public final void hJ(int paramInt)
  {
    AppMethodBeat.i(130110);
    this.cXp = true;
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(130110);
      return;
      c.Ox();
      AppMethodBeat.o(130110);
      return;
      b.Ox();
    }
  }
  
  public final void hK(int paramInt)
  {
    AppMethodBeat.i(130111);
    if (!this.cXp)
    {
      AppMethodBeat.o(130111);
      return;
    }
    int k = Ow();
    if (k != 0)
    {
      Integer[] arrayOfInteger = this.cXq;
      int i = 0;
      int m = arrayOfInteger.length;
      int j = 0;
      if (j < m)
      {
        int n = ((Number)arrayOfInteger[j]).intValue();
        long l = n * 100 / k;
        if (this.cXp) {}
        switch (paramInt)
        {
        default: 
          n = n * 100 / k;
          if (this.cXp) {
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
            c.bf(l);
            break;
          case 1: 
            c.bg(l);
            break;
          case 2: 
            c.bh(l);
            break;
          case 3: 
            c.bi(l);
            break;
            switch (i)
            {
            default: 
              break;
            case 0: 
              b.bf(l);
              break;
            case 1: 
              b.bg(l);
              break;
            case 2: 
              b.bh(l);
              break;
            case 3: 
              b.bi(l);
              break;
              switch (i)
              {
              default: 
                break;
              case 0: 
                if (n == 0) {
                  c.Oy();
                } else if (n <= 20) {
                  c.Oz();
                } else if (n <= 40) {
                  c.OA();
                } else if (n <= 60) {
                  c.OB();
                } else if (n <= 80) {
                  c.OC();
                } else if (n == 100) {
                  c.OD();
                }
                break;
              case 1: 
                if (n == 0) {
                  c.OE();
                } else if (n <= 20) {
                  c.OF();
                } else if (n <= 40) {
                  c.OG();
                } else if (n <= 60) {
                  c.OH();
                } else if (n <= 80) {
                  c.OI();
                } else if (n == 100) {
                  c.OJ();
                }
                break;
              case 2: 
                if (n == 0) {
                  c.OK();
                } else if (n <= 20) {
                  c.OL();
                } else if (n <= 40) {
                  c.OM();
                } else if (n <= 60) {
                  c.ON();
                } else if (n <= 80) {
                  c.OO();
                } else if (n == 100) {
                  c.OP();
                }
                break;
              case 3: 
                if (n == 0)
                {
                  c.OQ();
                }
                else if (n <= 20)
                {
                  c.OR();
                }
                else if (n <= 40)
                {
                  c.OS();
                }
                else if (n <= 60)
                {
                  c.OT();
                }
                else if (n <= 80)
                {
                  c.OU();
                }
                else if (n == 100)
                {
                  c.OV();
                  continue;
                  switch (i)
                  {
                  default: 
                    break;
                  case 0: 
                    if (n == 0) {
                      b.Oy();
                    } else if (n <= 20) {
                      b.Oz();
                    } else if (n <= 40) {
                      b.OA();
                    } else if (n <= 60) {
                      b.OB();
                    } else if (n <= 80) {
                      b.OC();
                    } else if (n <= 100) {
                      b.OD();
                    }
                    break;
                  case 1: 
                    if (n == 0) {
                      b.OE();
                    } else if (n <= 20) {
                      b.OF();
                    } else if (n <= 40) {
                      b.OG();
                    } else if (n <= 60) {
                      b.OH();
                    } else if (n <= 80) {
                      b.OI();
                    } else if (n <= 100) {
                      b.OJ();
                    }
                    break;
                  case 2: 
                    if (n == 0) {
                      b.OK();
                    } else if (n <= 20) {
                      b.OL();
                    } else if (n <= 40) {
                      b.OM();
                    } else if (n <= 60) {
                      b.ON();
                    } else if (n <= 80) {
                      b.OO();
                    } else if (n <= 100) {
                      b.OP();
                    }
                    break;
                  case 3: 
                    if (n == 0) {
                      b.OQ();
                    } else if (n <= 20) {
                      b.OR();
                    } else if (n <= 40) {
                      b.OS();
                    } else if (n <= 60) {
                      b.OT();
                    } else if (n <= 80) {
                      b.OU();
                    } else if (n <= 100) {
                      b.OV();
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
      this.cXq = arrayOfInteger;
    }
    AppMethodBeat.o(130111);
  }
  
  public final void hL(int paramInt)
  {
    AppMethodBeat.i(130112);
    if (!this.cXp)
    {
      AppMethodBeat.o(130112);
      return;
    }
    Integer[] arrayOfInteger = this.cXr;
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
      arrayOfInteger = this.cXr;
      j = 0;
      m = arrayOfInteger.length;
      k = 0;
      if (k < m)
      {
        int n = ((Number)arrayOfInteger[k]).intValue();
        long l = n * 100 / i;
        if (this.cXp) {}
        switch (paramInt)
        {
        default: 
          n = n * 100 / i;
          if (this.cXp) {
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
            c.bj(l);
            break;
          case 1: 
            c.bk(l);
            break;
          case 2: 
            c.bl(l);
            break;
          case 3: 
            c.bm(l);
            break;
            switch (j)
            {
            default: 
              break;
            case 0: 
              b.bj(l);
              break;
            case 1: 
              b.bk(l);
              break;
            case 2: 
              b.bl(l);
              break;
            case 3: 
              b.bm(l);
              break;
              switch (j)
              {
              default: 
                break;
              case 0: 
                if (n == 0) {
                  c.OW();
                } else if (n <= 20) {
                  c.OX();
                } else if (n <= 40) {
                  c.OY();
                } else if (n <= 60) {
                  c.OZ();
                } else if (n <= 80) {
                  c.Pa();
                } else if (n == 100) {
                  c.Pb();
                }
                break;
              case 1: 
                if (n == 0) {
                  c.Pc();
                } else if (n <= 20) {
                  c.Pd();
                } else if (n <= 40) {
                  c.Pe();
                } else if (n <= 60) {
                  c.Pf();
                } else if (n <= 80) {
                  c.Pg();
                } else if (n == 100) {
                  c.Ph();
                }
                break;
              case 2: 
                if (n == 0) {
                  c.Pi();
                } else if (n <= 20) {
                  c.Pj();
                } else if (n <= 40) {
                  c.Pk();
                } else if (n <= 60) {
                  c.Pl();
                } else if (n <= 80) {
                  c.Pm();
                } else if (n == 100) {
                  c.Pn();
                }
                break;
              case 3: 
                if (n == 0)
                {
                  c.Po();
                }
                else if (n <= 20)
                {
                  c.Pp();
                }
                else if (n <= 40)
                {
                  c.Pq();
                }
                else if (n <= 60)
                {
                  c.Pr();
                }
                else if (n <= 80)
                {
                  c.Ps();
                }
                else if (n == 100)
                {
                  c.Pt();
                  continue;
                  switch (j)
                  {
                  default: 
                    break;
                  case 0: 
                    if (n == 0) {
                      b.OW();
                    } else if (n <= 20) {
                      b.OX();
                    } else if (n <= 40) {
                      b.OY();
                    } else if (n <= 60) {
                      b.OZ();
                    } else if (n <= 80) {
                      b.Pa();
                    } else if (n <= 100) {
                      b.Pb();
                    }
                    break;
                  case 1: 
                    if (n == 0) {
                      b.Pc();
                    } else if (n <= 20) {
                      b.Pd();
                    } else if (n <= 40) {
                      b.Pe();
                    } else if (n <= 60) {
                      b.Pf();
                    } else if (n <= 80) {
                      b.Pg();
                    } else if (n <= 100) {
                      b.Ph();
                    }
                    break;
                  case 2: 
                    if (n == 0) {
                      b.Pi();
                    } else if (n <= 20) {
                      b.Pj();
                    } else if (n <= 40) {
                      b.Pk();
                    } else if (n <= 60) {
                      b.Pl();
                    } else if (n <= 80) {
                      b.Pm();
                    } else if (n <= 100) {
                      b.Pn();
                    }
                    break;
                  case 3: 
                    if (n == 0) {
                      b.Po();
                    } else if (n <= 20) {
                      b.Pp();
                    } else if (n <= 40) {
                      b.Pq();
                    } else if (n <= 60) {
                      b.Pr();
                    } else if (n <= 80) {
                      b.Ps();
                    } else if (n <= 100) {
                      b.Pt();
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
      this.cXr = arrayOfInteger;
    }
    AppMethodBeat.o(130112);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.audio.c.a.a
 * JD-Core Version:    0.7.0.1
 */