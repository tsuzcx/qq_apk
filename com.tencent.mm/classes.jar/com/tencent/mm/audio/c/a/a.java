package com.tencent.mm.audio.c.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/audio/utils/player/AudioPlayerReportUtil;", "", "()V", "mIsReportStart", "", "mRMSInOnePlayerProcess", "", "", "[Ljava/lang/Integer;", "mSystemVolumProcess", "byteArray2ShortArray", "", "data", "", "items", "calcDecibelLevel", "", "buffer", "readSize", "checkPCMAmplitude", "", "length", "checkSystemVolume", "type", "volume", "doAudioRecordKVReport", "audioType", "scenes", "featureKey", "", "pcmSilent", "pcmLow", "pcmMiddle", "pcmHigh", "systemSilent", "systemLow", "systemMiddle", "systemHigh", "audioSource", "doAudioVolumeRecordKVReport", "streamType", "doPCMPlayerChecker", "doPCMPlayerPercentReport", "index", "result", "", "doPCMPlayerResultReport", "doPcmPlayerReport", "doSystemVolumePercentReport", "doSystemVolumePlayerChecker", "doSystemVolumeResultReport", "getRMSInOnePlayerProcessReportSum", "getSystemVolumePercentReportSum", "Companion", "plugin-audiosdk_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
{
  public static final a.a hxX;
  private boolean hxY;
  private Integer[] hxZ;
  private Integer[] hya;
  
  static
  {
    AppMethodBeat.i(130117);
    hxX = new a.a((byte)0);
    AppMethodBeat.o(130117);
  }
  
  public a()
  {
    AppMethodBeat.i(130116);
    this.hxY = true;
    Integer[] arrayOfInteger = new Integer[4];
    int i = 0;
    while (i < 4)
    {
      arrayOfInteger[i] = Integer.valueOf(0);
      i += 1;
    }
    this.hxZ = arrayOfInteger;
    arrayOfInteger = new Integer[4];
    i = 0;
    while (i < 4)
    {
      arrayOfInteger[i] = Integer.valueOf(0);
      i += 1;
    }
    this.hya = arrayOfInteger;
    AppMethodBeat.o(130116);
  }
  
  private final int aHj()
  {
    AppMethodBeat.i(130113);
    Integer[] arrayOfInteger = this.hxZ;
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
    s.u(paramString, "featureKey");
    int i3 = aHj();
    if (i3 != 0)
    {
      int i = this.hxZ[0].intValue() * 100 / i3;
      int j = this.hxZ[1].intValue() * 100 / i3;
      int k = this.hxZ[2].intValue() * 100 / i3;
      int m = this.hxZ[3].intValue() * 100 / i3;
      int n = this.hya[0].intValue() * 100 / i3;
      int i1 = this.hya[1].intValue() * 100 / i3;
      int i2 = this.hya[2].intValue() * 100 / i3;
      i3 = this.hya[3].intValue() * 100 / i3;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("audioType = 1 ,scenes = ").append(paramInt1).append(",featureKey=").append(paramString).append(",pcmSilent=").append(i).append(", pcmLow=").append(j).append(",pcmMiddle=").append(k).append(",pcmHigh=").append(m).append(",systemSilent=").append(n).append(",systemLow=").append(i1).append(",systemMiddle=").append(i2).append(",systemHigh=").append(i3).append(",streamType=");
      localStringBuilder.append(paramInt2).append('}');
      Log.i("MicroMsg.AudioPlayerReportUtil", localStringBuilder.toString());
      h.OAn.a(18554, true, true, new Object[] { Integer.valueOf(1), Integer.valueOf(paramInt1), paramString, Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k), Integer.valueOf(m), Integer.valueOf(n), Integer.valueOf(i1), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(paramInt2) });
    }
    AppMethodBeat.o(130109);
  }
  
  public final void e(int paramInt, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(130115);
    s.u(paramArrayOfByte, "data");
    if (!this.hxY)
    {
      AppMethodBeat.o(130115);
      return;
    }
    short[] arrayOfShort;
    int i;
    int k;
    if (paramInt != 0)
    {
      arrayOfShort = new short[paramInt / 2];
      i = 0;
      k = arrayOfShort.length - 1;
      if (k < 0) {}
    }
    for (;;)
    {
      int j = i + 1;
      arrayOfShort[i] = ((short)(paramArrayOfByte[(i * 2)] & 0xFF | (paramArrayOfByte[(i * 2 + 1)] & 0xFF) << 8));
      if (j > k)
      {
        i = paramInt / 2;
        double d = 0.0D;
        paramInt = 0;
        j = arrayOfShort.length;
        while (paramInt < j)
        {
          k = arrayOfShort[paramInt];
          paramInt += 1;
          d += k * k;
        }
        d = Math.sqrt(d / i);
        if (d < 50.0D)
        {
          paramArrayOfByte = this.hxZ;
          paramArrayOfByte[0] = Integer.valueOf(paramArrayOfByte[0].intValue() + 1);
          AppMethodBeat.o(130115);
          return;
        }
        if (d < 300.0D)
        {
          paramArrayOfByte = this.hxZ;
          paramArrayOfByte[1] = Integer.valueOf(paramArrayOfByte[1].intValue() + 1);
          AppMethodBeat.o(130115);
          return;
        }
        if (d < 2000.0D)
        {
          paramArrayOfByte = this.hxZ;
          paramArrayOfByte[2] = Integer.valueOf(paramArrayOfByte[2].intValue() + 1);
          AppMethodBeat.o(130115);
          return;
        }
        paramArrayOfByte = this.hxZ;
        paramArrayOfByte[3] = Integer.valueOf(paramArrayOfByte[3].intValue() + 1);
        AppMethodBeat.o(130115);
        return;
      }
      i = j;
    }
  }
  
  public final void on(int paramInt)
  {
    AppMethodBeat.i(130110);
    this.hxY = false;
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(130110);
      return;
      c.aHk();
      AppMethodBeat.o(130110);
      return;
      b.aHk();
    }
  }
  
  public final void oo(int paramInt)
  {
    AppMethodBeat.i(130111);
    if (!this.hxY)
    {
      AppMethodBeat.o(130111);
      return;
    }
    int k = aHj();
    if (k != 0)
    {
      Integer[] arrayOfInteger = this.hxZ;
      int i = 0;
      int m = arrayOfInteger.length;
      int j = 0;
      if (j < m)
      {
        int n = ((Number)arrayOfInteger[j]).intValue();
        long l = n * 100 / k;
        if (this.hxY) {}
        switch (paramInt)
        {
        default: 
          n = n * 100 / k;
          if (this.hxY) {
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
            c.ec(l);
            break;
          case 1: 
            c.ed(l);
            break;
          case 2: 
            c.ee(l);
            break;
          case 3: 
            c.ef(l);
            break;
            switch (i)
            {
            default: 
              break;
            case 0: 
              b.ec(l);
              break;
            case 1: 
              b.ed(l);
              break;
            case 2: 
              b.ee(l);
              break;
            case 3: 
              b.ef(l);
              break;
              switch (i)
              {
              default: 
                break;
              case 0: 
                if (n == 0) {
                  c.aHl();
                } else if (n <= 20) {
                  c.aHm();
                } else if (n <= 40) {
                  c.aHn();
                } else if (n <= 60) {
                  c.aHo();
                } else if (n <= 80) {
                  c.aHp();
                } else if (n == 100) {
                  c.aHq();
                }
                break;
              case 1: 
                if (n == 0) {
                  c.aHr();
                } else if (n <= 20) {
                  c.aHs();
                } else if (n <= 40) {
                  c.aHt();
                } else if (n <= 60) {
                  c.aHu();
                } else if (n <= 80) {
                  c.aHv();
                } else if (n == 100) {
                  c.aHw();
                }
                break;
              case 2: 
                if (n == 0) {
                  c.aHx();
                } else if (n <= 20) {
                  c.aHy();
                } else if (n <= 40) {
                  c.aHz();
                } else if (n <= 60) {
                  c.aHA();
                } else if (n <= 80) {
                  c.aHB();
                } else if (n == 100) {
                  c.aHC();
                }
                break;
              case 3: 
                if (n == 0)
                {
                  c.aHD();
                }
                else if (n <= 20)
                {
                  c.aHE();
                }
                else if (n <= 40)
                {
                  c.aHF();
                }
                else if (n <= 60)
                {
                  c.aHG();
                }
                else if (n <= 80)
                {
                  c.aHH();
                }
                else if (n == 100)
                {
                  c.aHI();
                  continue;
                  switch (i)
                  {
                  default: 
                    break;
                  case 0: 
                    if (n == 0) {
                      b.aHl();
                    } else if (n <= 20) {
                      b.aHm();
                    } else if (n <= 40) {
                      b.aHn();
                    } else if (n <= 60) {
                      b.aHo();
                    } else if (n <= 80) {
                      b.aHp();
                    } else if (n <= 100) {
                      b.aHq();
                    }
                    break;
                  case 1: 
                    if (n == 0) {
                      b.aHr();
                    } else if (n <= 20) {
                      b.aHs();
                    } else if (n <= 40) {
                      b.aHt();
                    } else if (n <= 60) {
                      b.aHu();
                    } else if (n <= 80) {
                      b.aHv();
                    } else if (n <= 100) {
                      b.aHw();
                    }
                    break;
                  case 2: 
                    if (n == 0) {
                      b.aHx();
                    } else if (n <= 20) {
                      b.aHy();
                    } else if (n <= 40) {
                      b.aHz();
                    } else if (n <= 60) {
                      b.aHA();
                    } else if (n <= 80) {
                      b.aHB();
                    } else if (n <= 100) {
                      b.aHC();
                    }
                    break;
                  case 3: 
                    if (n == 0) {
                      b.aHD();
                    } else if (n <= 20) {
                      b.aHE();
                    } else if (n <= 40) {
                      b.aHF();
                    } else if (n <= 60) {
                      b.aHG();
                    } else if (n <= 80) {
                      b.aHH();
                    } else if (n <= 100) {
                      b.aHI();
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
      paramInt = 0;
      arrayOfInteger = new Integer[4];
      while (paramInt < 4)
      {
        arrayOfInteger[paramInt] = Integer.valueOf(0);
        paramInt += 1;
      }
      this.hxZ = arrayOfInteger;
    }
    AppMethodBeat.o(130111);
  }
  
  public final void op(int paramInt)
  {
    AppMethodBeat.i(130112);
    if (!this.hxY)
    {
      AppMethodBeat.o(130112);
      return;
    }
    Integer[] arrayOfInteger = this.hya;
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
      arrayOfInteger = this.hya;
      j = 0;
      m = arrayOfInteger.length;
      k = 0;
      if (k < m)
      {
        int n = ((Number)arrayOfInteger[k]).intValue();
        long l = n * 100 / i;
        if (this.hxY) {}
        switch (paramInt)
        {
        default: 
          n = n * 100 / i;
          if (this.hxY) {
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
            c.eg(l);
            break;
          case 1: 
            c.eh(l);
            break;
          case 2: 
            c.ei(l);
            break;
          case 3: 
            c.ej(l);
            break;
            switch (j)
            {
            default: 
              break;
            case 0: 
              b.eg(l);
              break;
            case 1: 
              b.eh(l);
              break;
            case 2: 
              b.ei(l);
              break;
            case 3: 
              b.ej(l);
              break;
              switch (j)
              {
              default: 
                break;
              case 0: 
                if (n == 0) {
                  c.aHJ();
                } else if (n <= 20) {
                  c.aHK();
                } else if (n <= 40) {
                  c.aHL();
                } else if (n <= 60) {
                  c.aHM();
                } else if (n <= 80) {
                  c.aHN();
                } else if (n == 100) {
                  c.aHO();
                }
                break;
              case 1: 
                if (n == 0) {
                  c.aHP();
                } else if (n <= 20) {
                  c.aHQ();
                } else if (n <= 40) {
                  c.aHR();
                } else if (n <= 60) {
                  c.aHS();
                } else if (n <= 80) {
                  c.aHT();
                } else if (n == 100) {
                  c.aHU();
                }
                break;
              case 2: 
                if (n == 0) {
                  c.aHV();
                } else if (n <= 20) {
                  c.aHW();
                } else if (n <= 40) {
                  c.aHX();
                } else if (n <= 60) {
                  c.aHY();
                } else if (n <= 80) {
                  c.aHZ();
                } else if (n == 100) {
                  c.aIa();
                }
                break;
              case 3: 
                if (n == 0)
                {
                  c.aIb();
                }
                else if (n <= 20)
                {
                  c.aIc();
                }
                else if (n <= 40)
                {
                  c.aId();
                }
                else if (n <= 60)
                {
                  c.aIe();
                }
                else if (n <= 80)
                {
                  c.aIf();
                }
                else if (n == 100)
                {
                  c.aIg();
                  continue;
                  switch (j)
                  {
                  default: 
                    break;
                  case 0: 
                    if (n == 0) {
                      b.aHJ();
                    } else if (n <= 20) {
                      b.aHK();
                    } else if (n <= 40) {
                      b.aHL();
                    } else if (n <= 60) {
                      b.aHM();
                    } else if (n <= 80) {
                      b.aHN();
                    } else if (n <= 100) {
                      b.aHO();
                    }
                    break;
                  case 1: 
                    if (n == 0) {
                      b.aHP();
                    } else if (n <= 20) {
                      b.aHQ();
                    } else if (n <= 40) {
                      b.aHR();
                    } else if (n <= 60) {
                      b.aHS();
                    } else if (n <= 80) {
                      b.aHT();
                    } else if (n <= 100) {
                      b.aHU();
                    }
                    break;
                  case 2: 
                    if (n == 0) {
                      b.aHV();
                    } else if (n <= 20) {
                      b.aHW();
                    } else if (n <= 40) {
                      b.aHX();
                    } else if (n <= 60) {
                      b.aHY();
                    } else if (n <= 80) {
                      b.aHZ();
                    } else if (n <= 100) {
                      b.aIa();
                    }
                    break;
                  case 3: 
                    if (n == 0) {
                      b.aIb();
                    } else if (n <= 20) {
                      b.aIc();
                    } else if (n <= 40) {
                      b.aId();
                    } else if (n <= 60) {
                      b.aIe();
                    } else if (n <= 80) {
                      b.aIf();
                    } else if (n <= 100) {
                      b.aIg();
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
      paramInt = 0;
      arrayOfInteger = new Integer[4];
      while (paramInt < 4)
      {
        arrayOfInteger[paramInt] = Integer.valueOf(0);
        paramInt += 1;
      }
      this.hya = arrayOfInteger;
    }
    AppMethodBeat.o(130112);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.tencent.mm.audio.c.a.a
 * JD-Core Version:    0.7.0.1
 */