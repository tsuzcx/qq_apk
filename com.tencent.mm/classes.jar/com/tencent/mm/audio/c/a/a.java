package com.tencent.mm.audio.c.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/audio/utils/player/AudioPlayerReportUtil;", "", "()V", "mIsReportStart", "", "mRMSInOnePlayerProcess", "", "", "[Ljava/lang/Integer;", "mSystemVolumProcess", "byteArray2ShortArray", "", "data", "", "items", "calcDecibelLevel", "", "buffer", "readSize", "checkPCMAmplitude", "", "length", "checkSystemVolume", "type", "volume", "doAudioRecordKVReport", "audioType", "scenes", "featureKey", "", "pcmSilent", "pcmLow", "pcmMiddle", "pcmHigh", "systemSilent", "systemLow", "systemMiddle", "systemHigh", "audioSource", "doAudioVolumeRecordKVReport", "streamType", "doPCMPlayerChecker", "doPCMPlayerPercentReport", "index", "result", "", "doPCMPlayerResultReport", "doPcmPlayerReport", "doSystemVolumePercentReport", "doSystemVolumePlayerChecker", "doSystemVolumeResultReport", "getRMSInOnePlayerProcessReportSum", "getSystemVolumePercentReportSum", "Companion", "plugin-audiosdk_release"})
public final class a
{
  public static final a.a ftL;
  private boolean ftI;
  private Integer[] ftJ;
  private Integer[] ftK;
  
  static
  {
    AppMethodBeat.i(130117);
    ftL = new a.a((byte)0);
    AppMethodBeat.o(130117);
  }
  
  public a()
  {
    AppMethodBeat.i(130116);
    this.ftI = true;
    Integer[] arrayOfInteger = new Integer[4];
    int i = 0;
    while (i < 4)
    {
      arrayOfInteger[i] = Integer.valueOf(0);
      i += 1;
    }
    this.ftJ = arrayOfInteger;
    arrayOfInteger = new Integer[4];
    i = 0;
    while (i < 4)
    {
      arrayOfInteger[i] = Integer.valueOf(0);
      i += 1;
    }
    this.ftK = arrayOfInteger;
    AppMethodBeat.o(130116);
  }
  
  private final int afm()
  {
    AppMethodBeat.i(130113);
    Integer[] arrayOfInteger = this.ftJ;
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
    p.k(paramString, "featureKey");
    int i3 = afm();
    if (i3 != 0)
    {
      int i = this.ftJ[0].intValue() * 100 / i3;
      int j = this.ftJ[1].intValue() * 100 / i3;
      int k = this.ftJ[2].intValue() * 100 / i3;
      int m = this.ftJ[3].intValue() * 100 / i3;
      int n = this.ftK[0].intValue() * 100 / i3;
      int i1 = this.ftK[1].intValue() * 100 / i3;
      int i2 = this.ftK[2].intValue() * 100 / i3;
      i3 = this.ftK[3].intValue() * 100 / i3;
      Log.i("MicroMsg.AudioPlayerReportUtil", "audioType = 1 ,scenes = " + paramInt1 + ",featureKey=" + paramString + ",pcmSilent=" + i + ", pcmLow=" + j + ",pcmMiddle=" + k + ",pcmHigh=" + m + ",systemSilent=" + n + ",systemLow=" + i1 + ",systemMiddle=" + i2 + ",systemHigh=" + i3 + ",streamType=" + paramInt2 + '}');
      h.IzE.a(18554, true, true, new Object[] { Integer.valueOf(1), Integer.valueOf(paramInt1), paramString, Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k), Integer.valueOf(m), Integer.valueOf(n), Integer.valueOf(i1), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(paramInt2) });
    }
    AppMethodBeat.o(130109);
  }
  
  public final void e(int paramInt, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(130115);
    p.k(paramArrayOfByte, "data");
    if (!this.ftI)
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
        paramArrayOfByte = this.ftJ;
        paramArrayOfByte[0] = Integer.valueOf(paramArrayOfByte[0].intValue() + 1);
        AppMethodBeat.o(130115);
        return;
      }
      if (d < 300.0D)
      {
        paramArrayOfByte = this.ftJ;
        paramArrayOfByte[1] = Integer.valueOf(paramArrayOfByte[1].intValue() + 1);
        AppMethodBeat.o(130115);
        return;
      }
      if (d < 2000.0D)
      {
        paramArrayOfByte = this.ftJ;
        paramArrayOfByte[2] = Integer.valueOf(paramArrayOfByte[2].intValue() + 1);
        AppMethodBeat.o(130115);
        return;
      }
      paramArrayOfByte = this.ftJ;
      paramArrayOfByte[3] = Integer.valueOf(paramArrayOfByte[3].intValue() + 1);
    }
    AppMethodBeat.o(130115);
  }
  
  public final void kG(int paramInt)
  {
    AppMethodBeat.i(130110);
    this.ftI = false;
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(130110);
      return;
      c.afn();
      AppMethodBeat.o(130110);
      return;
      b.afn();
    }
  }
  
  public final void kH(int paramInt)
  {
    AppMethodBeat.i(130111);
    if (!this.ftI)
    {
      AppMethodBeat.o(130111);
      return;
    }
    int k = afm();
    if (k != 0)
    {
      Integer[] arrayOfInteger = this.ftJ;
      int i = 0;
      int m = arrayOfInteger.length;
      int j = 0;
      if (j < m)
      {
        int n = ((Number)arrayOfInteger[j]).intValue();
        long l = n * 100 / k;
        if (this.ftI) {}
        switch (paramInt)
        {
        default: 
          n = n * 100 / k;
          if (this.ftI) {
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
            c.bK(l);
            break;
          case 1: 
            c.bL(l);
            break;
          case 2: 
            c.bM(l);
            break;
          case 3: 
            c.bN(l);
            break;
            switch (i)
            {
            default: 
              break;
            case 0: 
              b.bK(l);
              break;
            case 1: 
              b.bL(l);
              break;
            case 2: 
              b.bM(l);
              break;
            case 3: 
              b.bN(l);
              break;
              switch (i)
              {
              default: 
                break;
              case 0: 
                if (n == 0) {
                  c.afo();
                } else if (n <= 20) {
                  c.afp();
                } else if (n <= 40) {
                  c.afq();
                } else if (n <= 60) {
                  c.afr();
                } else if (n <= 80) {
                  c.afs();
                } else if (n == 100) {
                  c.aft();
                }
                break;
              case 1: 
                if (n == 0) {
                  c.afu();
                } else if (n <= 20) {
                  c.afv();
                } else if (n <= 40) {
                  c.afw();
                } else if (n <= 60) {
                  c.afx();
                } else if (n <= 80) {
                  c.afy();
                } else if (n == 100) {
                  c.afz();
                }
                break;
              case 2: 
                if (n == 0) {
                  c.afA();
                } else if (n <= 20) {
                  c.afB();
                } else if (n <= 40) {
                  c.afC();
                } else if (n <= 60) {
                  c.afD();
                } else if (n <= 80) {
                  c.afE();
                } else if (n == 100) {
                  c.afF();
                }
                break;
              case 3: 
                if (n == 0)
                {
                  c.afG();
                }
                else if (n <= 20)
                {
                  c.afH();
                }
                else if (n <= 40)
                {
                  c.afI();
                }
                else if (n <= 60)
                {
                  c.afJ();
                }
                else if (n <= 80)
                {
                  c.afK();
                }
                else if (n == 100)
                {
                  c.afL();
                  continue;
                  switch (i)
                  {
                  default: 
                    break;
                  case 0: 
                    if (n == 0) {
                      b.afo();
                    } else if (n <= 20) {
                      b.afp();
                    } else if (n <= 40) {
                      b.afq();
                    } else if (n <= 60) {
                      b.afr();
                    } else if (n <= 80) {
                      b.afs();
                    } else if (n <= 100) {
                      b.aft();
                    }
                    break;
                  case 1: 
                    if (n == 0) {
                      b.afu();
                    } else if (n <= 20) {
                      b.afv();
                    } else if (n <= 40) {
                      b.afw();
                    } else if (n <= 60) {
                      b.afx();
                    } else if (n <= 80) {
                      b.afy();
                    } else if (n <= 100) {
                      b.afz();
                    }
                    break;
                  case 2: 
                    if (n == 0) {
                      b.afA();
                    } else if (n <= 20) {
                      b.afB();
                    } else if (n <= 40) {
                      b.afC();
                    } else if (n <= 60) {
                      b.afD();
                    } else if (n <= 80) {
                      b.afE();
                    } else if (n <= 100) {
                      b.afF();
                    }
                    break;
                  case 3: 
                    if (n == 0) {
                      b.afG();
                    } else if (n <= 20) {
                      b.afH();
                    } else if (n <= 40) {
                      b.afI();
                    } else if (n <= 60) {
                      b.afJ();
                    } else if (n <= 80) {
                      b.afK();
                    } else if (n <= 100) {
                      b.afL();
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
      this.ftJ = arrayOfInteger;
    }
    AppMethodBeat.o(130111);
  }
  
  public final void kI(int paramInt)
  {
    AppMethodBeat.i(130112);
    if (!this.ftI)
    {
      AppMethodBeat.o(130112);
      return;
    }
    Integer[] arrayOfInteger = this.ftK;
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
      arrayOfInteger = this.ftK;
      j = 0;
      m = arrayOfInteger.length;
      k = 0;
      if (k < m)
      {
        int n = ((Number)arrayOfInteger[k]).intValue();
        long l = n * 100 / i;
        if (this.ftI) {}
        switch (paramInt)
        {
        default: 
          n = n * 100 / i;
          if (this.ftI) {
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
            c.bO(l);
            break;
          case 1: 
            c.bP(l);
            break;
          case 2: 
            c.bQ(l);
            break;
          case 3: 
            c.bR(l);
            break;
            switch (j)
            {
            default: 
              break;
            case 0: 
              b.bO(l);
              break;
            case 1: 
              b.bP(l);
              break;
            case 2: 
              b.bQ(l);
              break;
            case 3: 
              b.bR(l);
              break;
              switch (j)
              {
              default: 
                break;
              case 0: 
                if (n == 0) {
                  c.afM();
                } else if (n <= 20) {
                  c.afN();
                } else if (n <= 40) {
                  c.afO();
                } else if (n <= 60) {
                  c.afP();
                } else if (n <= 80) {
                  c.afQ();
                } else if (n == 100) {
                  c.afR();
                }
                break;
              case 1: 
                if (n == 0) {
                  c.afS();
                } else if (n <= 20) {
                  c.afT();
                } else if (n <= 40) {
                  c.afU();
                } else if (n <= 60) {
                  c.afV();
                } else if (n <= 80) {
                  c.afW();
                } else if (n == 100) {
                  c.afX();
                }
                break;
              case 2: 
                if (n == 0) {
                  c.afY();
                } else if (n <= 20) {
                  c.afZ();
                } else if (n <= 40) {
                  c.aga();
                } else if (n <= 60) {
                  c.agb();
                } else if (n <= 80) {
                  c.agc();
                } else if (n == 100) {
                  c.agd();
                }
                break;
              case 3: 
                if (n == 0)
                {
                  c.age();
                }
                else if (n <= 20)
                {
                  c.agf();
                }
                else if (n <= 40)
                {
                  c.agg();
                }
                else if (n <= 60)
                {
                  c.agh();
                }
                else if (n <= 80)
                {
                  c.agi();
                }
                else if (n == 100)
                {
                  c.agj();
                  continue;
                  switch (j)
                  {
                  default: 
                    break;
                  case 0: 
                    if (n == 0) {
                      b.afM();
                    } else if (n <= 20) {
                      b.afN();
                    } else if (n <= 40) {
                      b.afO();
                    } else if (n <= 60) {
                      b.afP();
                    } else if (n <= 80) {
                      b.afQ();
                    } else if (n <= 100) {
                      b.afR();
                    }
                    break;
                  case 1: 
                    if (n == 0) {
                      b.afS();
                    } else if (n <= 20) {
                      b.afT();
                    } else if (n <= 40) {
                      b.afU();
                    } else if (n <= 60) {
                      b.afV();
                    } else if (n <= 80) {
                      b.afW();
                    } else if (n <= 100) {
                      b.afX();
                    }
                    break;
                  case 2: 
                    if (n == 0) {
                      b.afY();
                    } else if (n <= 20) {
                      b.afZ();
                    } else if (n <= 40) {
                      b.aga();
                    } else if (n <= 60) {
                      b.agb();
                    } else if (n <= 80) {
                      b.agc();
                    } else if (n <= 100) {
                      b.agd();
                    }
                    break;
                  case 3: 
                    if (n == 0) {
                      b.age();
                    } else if (n <= 20) {
                      b.agf();
                    } else if (n <= 40) {
                      b.agg();
                    } else if (n <= 60) {
                      b.agh();
                    } else if (n <= 80) {
                      b.agi();
                    } else if (n <= 100) {
                      b.agj();
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
      this.ftK = arrayOfInteger;
    }
    AppMethodBeat.o(130112);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.audio.c.a.a
 * JD-Core Version:    0.7.0.1
 */