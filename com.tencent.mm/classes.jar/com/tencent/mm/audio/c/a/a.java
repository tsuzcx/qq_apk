package com.tencent.mm.audio.c.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.ae;
import d.g.b.p;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/audio/utils/player/AudioPlayerReportUtil;", "", "()V", "mIsReportStart", "", "mRMSInOnePlayerProcess", "", "", "[Ljava/lang/Integer;", "mSystemVolumProcess", "byteArray2ShortArray", "", "data", "", "items", "calcDecibelLevel", "", "buffer", "readSize", "checkPCMAmplitude", "", "length", "checkSystemVolume", "type", "volume", "doAudioRecordKVReport", "audioType", "scenes", "featureKey", "", "pcmSilent", "pcmLow", "pcmMiddle", "pcmHigh", "systemSilent", "systemLow", "systemMiddle", "systemHigh", "audioSource", "doAudioVolumeRecordKVReport", "streamType", "doPCMPlayerChecker", "doPCMPlayerPercentReport", "index", "result", "", "doPCMPlayerResultReport", "doPcmPlayerReport", "doSystemVolumePercentReport", "doSystemVolumePlayerChecker", "doSystemVolumeResultReport", "getRMSInOnePlayerProcessReportSum", "getSystemVolumePercentReportSum", "Companion", "plugin-audiosdk_release"})
public final class a
{
  public static final a.a djM;
  private boolean djJ;
  private Integer[] djK;
  private Integer[] djL;
  
  static
  {
    AppMethodBeat.i(130117);
    djM = new a.a((byte)0);
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
    this.djK = arrayOfInteger;
    arrayOfInteger = new Integer[4];
    i = 0;
    while (i < 4)
    {
      arrayOfInteger[i] = Integer.valueOf(0);
      i += 1;
    }
    this.djL = arrayOfInteger;
    AppMethodBeat.o(130116);
  }
  
  private final int Qh()
  {
    AppMethodBeat.i(130113);
    Integer[] arrayOfInteger = this.djK;
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
    int i3 = Qh();
    if (i3 != 0)
    {
      int i = this.djK[0].intValue() * 100 / i3;
      int j = this.djK[1].intValue() * 100 / i3;
      int k = this.djK[2].intValue() * 100 / i3;
      int m = this.djK[3].intValue() * 100 / i3;
      int n = this.djL[0].intValue() * 100 / i3;
      int i1 = this.djL[1].intValue() * 100 / i3;
      int i2 = this.djL[2].intValue() * 100 / i3;
      i3 = this.djL[3].intValue() * 100 / i3;
      ae.i("MicroMsg.AudioPlayerReportUtil", "audioType = 1 ,scenes = " + paramInt1 + ",featureKey=" + paramString + ",pcmSilent=" + i + ", pcmLow=" + j + ",pcmMiddle=" + k + ",pcmHigh=" + m + ",systemSilent=" + n + ",systemLow=" + i1 + ",systemMiddle=" + i2 + ",systemHigh=" + i3 + ",streamType=" + paramInt2 + '}');
      g.yxI.a(18554, true, true, new Object[] { Integer.valueOf(1), Integer.valueOf(paramInt1), paramString, Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k), Integer.valueOf(m), Integer.valueOf(n), Integer.valueOf(i1), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(paramInt2) });
    }
    AppMethodBeat.o(130109);
  }
  
  public final void ci(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(130114);
    if (!this.djJ)
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
        arrayOfInteger = this.djL;
        arrayOfInteger[0] = Integer.valueOf(arrayOfInteger[0].intValue() + 1);
        AppMethodBeat.o(130114);
        return;
      }
      if (paramInt2 < 40)
      {
        arrayOfInteger = this.djL;
        arrayOfInteger[1] = Integer.valueOf(arrayOfInteger[1].intValue() + 1);
        AppMethodBeat.o(130114);
        return;
      }
      if (paramInt2 < 80)
      {
        arrayOfInteger = this.djL;
        arrayOfInteger[2] = Integer.valueOf(arrayOfInteger[2].intValue() + 1);
        AppMethodBeat.o(130114);
        return;
      }
      if (paramInt2 <= 100)
      {
        arrayOfInteger = this.djL;
        arrayOfInteger[3] = Integer.valueOf(arrayOfInteger[3].intValue() + 1);
        AppMethodBeat.o(130114);
        return;
      }
      AppMethodBeat.o(130114);
      return;
      if (paramInt2 < 10)
      {
        arrayOfInteger = this.djL;
        arrayOfInteger[0] = Integer.valueOf(arrayOfInteger[0].intValue() + 1);
        AppMethodBeat.o(130114);
        return;
      }
      if (paramInt2 < 40)
      {
        arrayOfInteger = this.djL;
        arrayOfInteger[1] = Integer.valueOf(arrayOfInteger[1].intValue() + 1);
        AppMethodBeat.o(130114);
        return;
      }
      if (paramInt2 < 80)
      {
        arrayOfInteger = this.djL;
        arrayOfInteger[2] = Integer.valueOf(arrayOfInteger[2].intValue() + 1);
        AppMethodBeat.o(130114);
        return;
      }
      if (paramInt2 <= 100)
      {
        arrayOfInteger = this.djL;
        arrayOfInteger[3] = Integer.valueOf(arrayOfInteger[3].intValue() + 1);
      }
    }
  }
  
  public final void e(int paramInt, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(130115);
    p.h(paramArrayOfByte, "data");
    if (!this.djJ)
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
        paramArrayOfByte = this.djK;
        paramArrayOfByte[0] = Integer.valueOf(paramArrayOfByte[0].intValue() + 1);
        AppMethodBeat.o(130115);
        return;
      }
      if (d < 300.0D)
      {
        paramArrayOfByte = this.djK;
        paramArrayOfByte[1] = Integer.valueOf(paramArrayOfByte[1].intValue() + 1);
        AppMethodBeat.o(130115);
        return;
      }
      if (d < 2000.0D)
      {
        paramArrayOfByte = this.djK;
        paramArrayOfByte[2] = Integer.valueOf(paramArrayOfByte[2].intValue() + 1);
        AppMethodBeat.o(130115);
        return;
      }
      paramArrayOfByte = this.djK;
      paramArrayOfByte[3] = Integer.valueOf(paramArrayOfByte[3].intValue() + 1);
    }
    AppMethodBeat.o(130115);
  }
  
  public final void hS(int paramInt)
  {
    AppMethodBeat.i(130110);
    this.djJ = true;
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(130110);
      return;
      c.Qi();
      AppMethodBeat.o(130110);
      return;
      b.Qi();
    }
  }
  
  public final void hT(int paramInt)
  {
    AppMethodBeat.i(130111);
    if (!this.djJ)
    {
      AppMethodBeat.o(130111);
      return;
    }
    int k = Qh();
    if (k != 0)
    {
      Integer[] arrayOfInteger = this.djK;
      int i = 0;
      int m = arrayOfInteger.length;
      int j = 0;
      if (j < m)
      {
        int n = ((Number)arrayOfInteger[j]).intValue();
        long l = n * 100 / k;
        if (this.djJ) {}
        switch (paramInt)
        {
        default: 
          n = n * 100 / k;
          if (this.djJ) {
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
                  c.Qj();
                } else if (n <= 20) {
                  c.Qk();
                } else if (n <= 40) {
                  c.Ql();
                } else if (n <= 60) {
                  c.Qm();
                } else if (n <= 80) {
                  c.Qn();
                } else if (n == 100) {
                  c.Qo();
                }
                break;
              case 1: 
                if (n == 0) {
                  c.Qp();
                } else if (n <= 20) {
                  c.Qq();
                } else if (n <= 40) {
                  c.Qr();
                } else if (n <= 60) {
                  c.Qs();
                } else if (n <= 80) {
                  c.Qt();
                } else if (n == 100) {
                  c.Qu();
                }
                break;
              case 2: 
                if (n == 0) {
                  c.Qv();
                } else if (n <= 20) {
                  c.Qw();
                } else if (n <= 40) {
                  c.Qx();
                } else if (n <= 60) {
                  c.Qy();
                } else if (n <= 80) {
                  c.Qz();
                } else if (n == 100) {
                  c.QA();
                }
                break;
              case 3: 
                if (n == 0)
                {
                  c.QB();
                }
                else if (n <= 20)
                {
                  c.QC();
                }
                else if (n <= 40)
                {
                  c.QD();
                }
                else if (n <= 60)
                {
                  c.QE();
                }
                else if (n <= 80)
                {
                  c.QF();
                }
                else if (n == 100)
                {
                  c.QG();
                  continue;
                  switch (i)
                  {
                  default: 
                    break;
                  case 0: 
                    if (n == 0) {
                      b.Qj();
                    } else if (n <= 20) {
                      b.Qk();
                    } else if (n <= 40) {
                      b.Ql();
                    } else if (n <= 60) {
                      b.Qm();
                    } else if (n <= 80) {
                      b.Qn();
                    } else if (n <= 100) {
                      b.Qo();
                    }
                    break;
                  case 1: 
                    if (n == 0) {
                      b.Qp();
                    } else if (n <= 20) {
                      b.Qq();
                    } else if (n <= 40) {
                      b.Qr();
                    } else if (n <= 60) {
                      b.Qs();
                    } else if (n <= 80) {
                      b.Qt();
                    } else if (n <= 100) {
                      b.Qu();
                    }
                    break;
                  case 2: 
                    if (n == 0) {
                      b.Qv();
                    } else if (n <= 20) {
                      b.Qw();
                    } else if (n <= 40) {
                      b.Qx();
                    } else if (n <= 60) {
                      b.Qy();
                    } else if (n <= 80) {
                      b.Qz();
                    } else if (n <= 100) {
                      b.QA();
                    }
                    break;
                  case 3: 
                    if (n == 0) {
                      b.QB();
                    } else if (n <= 20) {
                      b.QC();
                    } else if (n <= 40) {
                      b.QD();
                    } else if (n <= 60) {
                      b.QE();
                    } else if (n <= 80) {
                      b.QF();
                    } else if (n <= 100) {
                      b.QG();
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
      this.djK = arrayOfInteger;
    }
    AppMethodBeat.o(130111);
  }
  
  public final void hU(int paramInt)
  {
    AppMethodBeat.i(130112);
    if (!this.djJ)
    {
      AppMethodBeat.o(130112);
      return;
    }
    Integer[] arrayOfInteger = this.djL;
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
      arrayOfInteger = this.djL;
      j = 0;
      m = arrayOfInteger.length;
      k = 0;
      if (k < m)
      {
        int n = ((Number)arrayOfInteger[k]).intValue();
        long l = n * 100 / i;
        if (this.djJ) {}
        switch (paramInt)
        {
        default: 
          n = n * 100 / i;
          if (this.djJ) {
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
                  c.QH();
                } else if (n <= 20) {
                  c.QI();
                } else if (n <= 40) {
                  c.QJ();
                } else if (n <= 60) {
                  c.QK();
                } else if (n <= 80) {
                  c.QL();
                } else if (n == 100) {
                  c.QM();
                }
                break;
              case 1: 
                if (n == 0) {
                  c.QN();
                } else if (n <= 20) {
                  c.QO();
                } else if (n <= 40) {
                  c.QP();
                } else if (n <= 60) {
                  c.QQ();
                } else if (n <= 80) {
                  c.QR();
                } else if (n == 100) {
                  c.QS();
                }
                break;
              case 2: 
                if (n == 0) {
                  c.QT();
                } else if (n <= 20) {
                  c.QU();
                } else if (n <= 40) {
                  c.QV();
                } else if (n <= 60) {
                  c.QW();
                } else if (n <= 80) {
                  c.QX();
                } else if (n == 100) {
                  c.QY();
                }
                break;
              case 3: 
                if (n == 0)
                {
                  c.QZ();
                }
                else if (n <= 20)
                {
                  c.Ra();
                }
                else if (n <= 40)
                {
                  c.Rb();
                }
                else if (n <= 60)
                {
                  c.Rc();
                }
                else if (n <= 80)
                {
                  c.Rd();
                }
                else if (n == 100)
                {
                  c.Re();
                  continue;
                  switch (j)
                  {
                  default: 
                    break;
                  case 0: 
                    if (n == 0) {
                      b.QH();
                    } else if (n <= 20) {
                      b.QI();
                    } else if (n <= 40) {
                      b.QJ();
                    } else if (n <= 60) {
                      b.QK();
                    } else if (n <= 80) {
                      b.QL();
                    } else if (n <= 100) {
                      b.QM();
                    }
                    break;
                  case 1: 
                    if (n == 0) {
                      b.QN();
                    } else if (n <= 20) {
                      b.QO();
                    } else if (n <= 40) {
                      b.QP();
                    } else if (n <= 60) {
                      b.QQ();
                    } else if (n <= 80) {
                      b.QR();
                    } else if (n <= 100) {
                      b.QS();
                    }
                    break;
                  case 2: 
                    if (n == 0) {
                      b.QT();
                    } else if (n <= 20) {
                      b.QU();
                    } else if (n <= 40) {
                      b.QV();
                    } else if (n <= 60) {
                      b.QW();
                    } else if (n <= 80) {
                      b.QX();
                    } else if (n <= 100) {
                      b.QY();
                    }
                    break;
                  case 3: 
                    if (n == 0) {
                      b.QZ();
                    } else if (n <= 20) {
                      b.Ra();
                    } else if (n <= 40) {
                      b.Rb();
                    } else if (n <= 60) {
                      b.Rc();
                    } else if (n <= 80) {
                      b.Rd();
                    } else if (n <= 100) {
                      b.Re();
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
      this.djL = arrayOfInteger;
    }
    AppMethodBeat.o(130112);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.audio.c.a.a
 * JD-Core Version:    0.7.0.1
 */