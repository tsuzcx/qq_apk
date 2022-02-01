package com.tencent.mm.audio.c.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/audio/utils/player/AudioPlayerReportUtil;", "", "()V", "mIsReportStart", "", "mRMSInOnePlayerProcess", "", "", "[Ljava/lang/Integer;", "mSystemVolumProcess", "byteArray2ShortArray", "", "data", "", "items", "calcDecibelLevel", "", "buffer", "readSize", "checkPCMAmplitude", "", "length", "checkSystemVolume", "type", "volume", "doAudioRecordKVReport", "audioType", "scenes", "featureKey", "", "pcmSilent", "pcmLow", "pcmMiddle", "pcmHigh", "systemSilent", "systemLow", "systemMiddle", "systemHigh", "audioSource", "doAudioVolumeRecordKVReport", "streamType", "doPCMPlayerChecker", "doPCMPlayerPercentReport", "index", "result", "", "doPCMPlayerResultReport", "doPcmPlayerReport", "doSystemVolumePercentReport", "doSystemVolumePlayerChecker", "doSystemVolumeResultReport", "getRMSInOnePlayerProcessReportSum", "getSystemVolumePercentReportSum", "Companion", "plugin-audiosdk_release"})
public final class a
{
  public static final a.a dAW;
  private boolean dAT;
  private Integer[] dAU;
  private Integer[] dAV;
  
  static
  {
    AppMethodBeat.i(130117);
    dAW = new a.a((byte)0);
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
    this.dAU = arrayOfInteger;
    arrayOfInteger = new Integer[4];
    i = 0;
    while (i < 4)
    {
      arrayOfInteger[i] = Integer.valueOf(0);
      i += 1;
    }
    this.dAV = arrayOfInteger;
    AppMethodBeat.o(130116);
  }
  
  private final int aaz()
  {
    AppMethodBeat.i(130113);
    Integer[] arrayOfInteger = this.dAU;
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
    p.h(paramString, "featureKey");
    int i3 = aaz();
    if (i3 != 0)
    {
      int i = this.dAU[0].intValue() * 100 / i3;
      int j = this.dAU[1].intValue() * 100 / i3;
      int k = this.dAU[2].intValue() * 100 / i3;
      int m = this.dAU[3].intValue() * 100 / i3;
      int n = this.dAV[0].intValue() * 100 / i3;
      int i1 = this.dAV[1].intValue() * 100 / i3;
      int i2 = this.dAV[2].intValue() * 100 / i3;
      i3 = this.dAV[3].intValue() * 100 / i3;
      Log.i("MicroMsg.AudioPlayerReportUtil", "audioType = 1 ,scenes = " + paramInt1 + ",featureKey=" + paramString + ",pcmSilent=" + i + ", pcmLow=" + j + ",pcmMiddle=" + k + ",pcmHigh=" + m + ",systemSilent=" + n + ",systemLow=" + i1 + ",systemMiddle=" + i2 + ",systemHigh=" + i3 + ",streamType=" + paramInt2 + '}');
      h.CyF.a(18554, true, true, new Object[] { Integer.valueOf(1), Integer.valueOf(paramInt1), paramString, Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k), Integer.valueOf(m), Integer.valueOf(n), Integer.valueOf(i1), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(paramInt2) });
    }
    AppMethodBeat.o(130109);
  }
  
  public final void ck(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(130114);
    if (!this.dAT)
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
        arrayOfInteger = this.dAV;
        arrayOfInteger[0] = Integer.valueOf(arrayOfInteger[0].intValue() + 1);
        AppMethodBeat.o(130114);
        return;
      }
      if (paramInt2 < 40)
      {
        arrayOfInteger = this.dAV;
        arrayOfInteger[1] = Integer.valueOf(arrayOfInteger[1].intValue() + 1);
        AppMethodBeat.o(130114);
        return;
      }
      if (paramInt2 < 80)
      {
        arrayOfInteger = this.dAV;
        arrayOfInteger[2] = Integer.valueOf(arrayOfInteger[2].intValue() + 1);
        AppMethodBeat.o(130114);
        return;
      }
      if (paramInt2 <= 100)
      {
        arrayOfInteger = this.dAV;
        arrayOfInteger[3] = Integer.valueOf(arrayOfInteger[3].intValue() + 1);
        AppMethodBeat.o(130114);
        return;
      }
      AppMethodBeat.o(130114);
      return;
      if (paramInt2 < 10)
      {
        arrayOfInteger = this.dAV;
        arrayOfInteger[0] = Integer.valueOf(arrayOfInteger[0].intValue() + 1);
        AppMethodBeat.o(130114);
        return;
      }
      if (paramInt2 < 40)
      {
        arrayOfInteger = this.dAV;
        arrayOfInteger[1] = Integer.valueOf(arrayOfInteger[1].intValue() + 1);
        AppMethodBeat.o(130114);
        return;
      }
      if (paramInt2 < 80)
      {
        arrayOfInteger = this.dAV;
        arrayOfInteger[2] = Integer.valueOf(arrayOfInteger[2].intValue() + 1);
        AppMethodBeat.o(130114);
        return;
      }
      if (paramInt2 <= 100)
      {
        arrayOfInteger = this.dAV;
        arrayOfInteger[3] = Integer.valueOf(arrayOfInteger[3].intValue() + 1);
      }
    }
  }
  
  public final void e(int paramInt, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(130115);
    p.h(paramArrayOfByte, "data");
    if (!this.dAT)
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
        paramArrayOfByte = this.dAU;
        paramArrayOfByte[0] = Integer.valueOf(paramArrayOfByte[0].intValue() + 1);
        AppMethodBeat.o(130115);
        return;
      }
      if (d < 300.0D)
      {
        paramArrayOfByte = this.dAU;
        paramArrayOfByte[1] = Integer.valueOf(paramArrayOfByte[1].intValue() + 1);
        AppMethodBeat.o(130115);
        return;
      }
      if (d < 2000.0D)
      {
        paramArrayOfByte = this.dAU;
        paramArrayOfByte[2] = Integer.valueOf(paramArrayOfByte[2].intValue() + 1);
        AppMethodBeat.o(130115);
        return;
      }
      paramArrayOfByte = this.dAU;
      paramArrayOfByte[3] = Integer.valueOf(paramArrayOfByte[3].intValue() + 1);
    }
    AppMethodBeat.o(130115);
  }
  
  public final void jm(int paramInt)
  {
    AppMethodBeat.i(130110);
    this.dAT = true;
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(130110);
      return;
      c.aaA();
      AppMethodBeat.o(130110);
      return;
      b.aaA();
    }
  }
  
  public final void jn(int paramInt)
  {
    AppMethodBeat.i(130111);
    if (!this.dAT)
    {
      AppMethodBeat.o(130111);
      return;
    }
    int k = aaz();
    if (k != 0)
    {
      Integer[] arrayOfInteger = this.dAU;
      int i = 0;
      int m = arrayOfInteger.length;
      int j = 0;
      if (j < m)
      {
        int n = ((Number)arrayOfInteger[j]).intValue();
        long l = n * 100 / k;
        if (this.dAT) {}
        switch (paramInt)
        {
        default: 
          n = n * 100 / k;
          if (this.dAT) {
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
            c.bv(l);
            break;
          case 1: 
            c.bw(l);
            break;
          case 2: 
            c.bx(l);
            break;
          case 3: 
            c.by(l);
            break;
            switch (i)
            {
            default: 
              break;
            case 0: 
              b.bv(l);
              break;
            case 1: 
              b.bw(l);
              break;
            case 2: 
              b.bx(l);
              break;
            case 3: 
              b.by(l);
              break;
              switch (i)
              {
              default: 
                break;
              case 0: 
                if (n == 0) {
                  c.aaB();
                } else if (n <= 20) {
                  c.aaC();
                } else if (n <= 40) {
                  c.aaD();
                } else if (n <= 60) {
                  c.aaE();
                } else if (n <= 80) {
                  c.aaF();
                } else if (n == 100) {
                  c.aaG();
                }
                break;
              case 1: 
                if (n == 0) {
                  c.aaH();
                } else if (n <= 20) {
                  c.aaI();
                } else if (n <= 40) {
                  c.aaJ();
                } else if (n <= 60) {
                  c.aaK();
                } else if (n <= 80) {
                  c.aaL();
                } else if (n == 100) {
                  c.aaM();
                }
                break;
              case 2: 
                if (n == 0) {
                  c.aaN();
                } else if (n <= 20) {
                  c.aaO();
                } else if (n <= 40) {
                  c.aaP();
                } else if (n <= 60) {
                  c.aaQ();
                } else if (n <= 80) {
                  c.aaR();
                } else if (n == 100) {
                  c.aaS();
                }
                break;
              case 3: 
                if (n == 0)
                {
                  c.aaT();
                }
                else if (n <= 20)
                {
                  c.aaU();
                }
                else if (n <= 40)
                {
                  c.aaV();
                }
                else if (n <= 60)
                {
                  c.aaW();
                }
                else if (n <= 80)
                {
                  c.aaX();
                }
                else if (n == 100)
                {
                  c.aaY();
                  continue;
                  switch (i)
                  {
                  default: 
                    break;
                  case 0: 
                    if (n == 0) {
                      b.aaB();
                    } else if (n <= 20) {
                      b.aaC();
                    } else if (n <= 40) {
                      b.aaD();
                    } else if (n <= 60) {
                      b.aaE();
                    } else if (n <= 80) {
                      b.aaF();
                    } else if (n <= 100) {
                      b.aaG();
                    }
                    break;
                  case 1: 
                    if (n == 0) {
                      b.aaH();
                    } else if (n <= 20) {
                      b.aaI();
                    } else if (n <= 40) {
                      b.aaJ();
                    } else if (n <= 60) {
                      b.aaK();
                    } else if (n <= 80) {
                      b.aaL();
                    } else if (n <= 100) {
                      b.aaM();
                    }
                    break;
                  case 2: 
                    if (n == 0) {
                      b.aaN();
                    } else if (n <= 20) {
                      b.aaO();
                    } else if (n <= 40) {
                      b.aaP();
                    } else if (n <= 60) {
                      b.aaQ();
                    } else if (n <= 80) {
                      b.aaR();
                    } else if (n <= 100) {
                      b.aaS();
                    }
                    break;
                  case 3: 
                    if (n == 0) {
                      b.aaT();
                    } else if (n <= 20) {
                      b.aaU();
                    } else if (n <= 40) {
                      b.aaV();
                    } else if (n <= 60) {
                      b.aaW();
                    } else if (n <= 80) {
                      b.aaX();
                    } else if (n <= 100) {
                      b.aaY();
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
      this.dAU = arrayOfInteger;
    }
    AppMethodBeat.o(130111);
  }
  
  public final void jo(int paramInt)
  {
    AppMethodBeat.i(130112);
    if (!this.dAT)
    {
      AppMethodBeat.o(130112);
      return;
    }
    Integer[] arrayOfInteger = this.dAV;
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
      arrayOfInteger = this.dAV;
      j = 0;
      m = arrayOfInteger.length;
      k = 0;
      if (k < m)
      {
        int n = ((Number)arrayOfInteger[k]).intValue();
        long l = n * 100 / i;
        if (this.dAT) {}
        switch (paramInt)
        {
        default: 
          n = n * 100 / i;
          if (this.dAT) {
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
            c.bz(l);
            break;
          case 1: 
            c.bA(l);
            break;
          case 2: 
            c.bB(l);
            break;
          case 3: 
            c.bC(l);
            break;
            switch (j)
            {
            default: 
              break;
            case 0: 
              b.bz(l);
              break;
            case 1: 
              b.bA(l);
              break;
            case 2: 
              b.bB(l);
              break;
            case 3: 
              b.bC(l);
              break;
              switch (j)
              {
              default: 
                break;
              case 0: 
                if (n == 0) {
                  c.aaZ();
                } else if (n <= 20) {
                  c.aba();
                } else if (n <= 40) {
                  c.abb();
                } else if (n <= 60) {
                  c.abc();
                } else if (n <= 80) {
                  c.abd();
                } else if (n == 100) {
                  c.abe();
                }
                break;
              case 1: 
                if (n == 0) {
                  c.abf();
                } else if (n <= 20) {
                  c.abg();
                } else if (n <= 40) {
                  c.abh();
                } else if (n <= 60) {
                  c.abi();
                } else if (n <= 80) {
                  c.abj();
                } else if (n == 100) {
                  c.abk();
                }
                break;
              case 2: 
                if (n == 0) {
                  c.abl();
                } else if (n <= 20) {
                  c.abm();
                } else if (n <= 40) {
                  c.abn();
                } else if (n <= 60) {
                  c.abo();
                } else if (n <= 80) {
                  c.abp();
                } else if (n == 100) {
                  c.abq();
                }
                break;
              case 3: 
                if (n == 0)
                {
                  c.abr();
                }
                else if (n <= 20)
                {
                  c.abs();
                }
                else if (n <= 40)
                {
                  c.abt();
                }
                else if (n <= 60)
                {
                  c.abu();
                }
                else if (n <= 80)
                {
                  c.abv();
                }
                else if (n == 100)
                {
                  c.abw();
                  continue;
                  switch (j)
                  {
                  default: 
                    break;
                  case 0: 
                    if (n == 0) {
                      b.aaZ();
                    } else if (n <= 20) {
                      b.aba();
                    } else if (n <= 40) {
                      b.abb();
                    } else if (n <= 60) {
                      b.abc();
                    } else if (n <= 80) {
                      b.abd();
                    } else if (n <= 100) {
                      b.abe();
                    }
                    break;
                  case 1: 
                    if (n == 0) {
                      b.abf();
                    } else if (n <= 20) {
                      b.abg();
                    } else if (n <= 40) {
                      b.abh();
                    } else if (n <= 60) {
                      b.abi();
                    } else if (n <= 80) {
                      b.abj();
                    } else if (n <= 100) {
                      b.abk();
                    }
                    break;
                  case 2: 
                    if (n == 0) {
                      b.abl();
                    } else if (n <= 20) {
                      b.abm();
                    } else if (n <= 40) {
                      b.abn();
                    } else if (n <= 60) {
                      b.abo();
                    } else if (n <= 80) {
                      b.abp();
                    } else if (n <= 100) {
                      b.abq();
                    }
                    break;
                  case 3: 
                    if (n == 0) {
                      b.abr();
                    } else if (n <= 20) {
                      b.abs();
                    } else if (n <= 40) {
                      b.abt();
                    } else if (n <= 60) {
                      b.abu();
                    } else if (n <= 80) {
                      b.abv();
                    } else if (n <= 100) {
                      b.abw();
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
      this.dAV = arrayOfInteger;
    }
    AppMethodBeat.o(130112);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.audio.c.a.a
 * JD-Core Version:    0.7.0.1
 */