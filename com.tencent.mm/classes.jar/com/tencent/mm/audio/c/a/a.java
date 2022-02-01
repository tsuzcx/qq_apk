package com.tencent.mm.audio.c.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.ad;
import d.g.b.p;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/audio/utils/player/AudioPlayerReportUtil;", "", "()V", "mIsReportStart", "", "mRMSInOnePlayerProcess", "", "", "[Ljava/lang/Integer;", "mSystemVolumProcess", "byteArray2ShortArray", "", "data", "", "items", "calcDecibelLevel", "", "buffer", "readSize", "checkPCMAmplitude", "", "length", "checkSystemVolume", "type", "volume", "doAudioRecordKVReport", "audioType", "scenes", "featureKey", "", "pcmSilent", "pcmLow", "pcmMiddle", "pcmHigh", "systemSilent", "systemLow", "systemMiddle", "systemHigh", "audioSource", "doAudioVolumeRecordKVReport", "streamType", "doPCMPlayerChecker", "doPCMPlayerPercentReport", "index", "result", "", "doPCMPlayerResultReport", "doPcmPlayerReport", "doSystemVolumePercentReport", "doSystemVolumePlayerChecker", "doSystemVolumeResultReport", "getRMSInOnePlayerProcessReportSum", "getSystemVolumePercentReportSum", "Companion", "plugin-audiosdk_release"})
public final class a
{
  public static final a.a diK;
  private boolean diH;
  private Integer[] diI;
  private Integer[] diJ;
  
  static
  {
    AppMethodBeat.i(130117);
    diK = new a.a((byte)0);
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
    this.diI = arrayOfInteger;
    arrayOfInteger = new Integer[4];
    i = 0;
    while (i < 4)
    {
      arrayOfInteger[i] = Integer.valueOf(0);
      i += 1;
    }
    this.diJ = arrayOfInteger;
    AppMethodBeat.o(130116);
  }
  
  private final int Qi()
  {
    AppMethodBeat.i(130113);
    Integer[] arrayOfInteger = this.diI;
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
    int i3 = Qi();
    if (i3 != 0)
    {
      int i = this.diI[0].intValue() * 100 / i3;
      int j = this.diI[1].intValue() * 100 / i3;
      int k = this.diI[2].intValue() * 100 / i3;
      int m = this.diI[3].intValue() * 100 / i3;
      int n = this.diJ[0].intValue() * 100 / i3;
      int i1 = this.diJ[1].intValue() * 100 / i3;
      int i2 = this.diJ[2].intValue() * 100 / i3;
      i3 = this.diJ[3].intValue() * 100 / i3;
      ad.i("MicroMsg.AudioPlayerReportUtil", "audioType = 1 ,scenes = " + paramInt1 + ",featureKey=" + paramString + ",pcmSilent=" + i + ", pcmLow=" + j + ",pcmMiddle=" + k + ",pcmHigh=" + m + ",systemSilent=" + n + ",systemLow=" + i1 + ",systemMiddle=" + i2 + ",systemHigh=" + i3 + ",streamType=" + paramInt2 + '}');
      g.yhR.a(18554, true, true, new Object[] { Integer.valueOf(1), Integer.valueOf(paramInt1), paramString, Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k), Integer.valueOf(m), Integer.valueOf(n), Integer.valueOf(i1), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(paramInt2) });
    }
    AppMethodBeat.o(130109);
  }
  
  public final void ci(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(130114);
    if (!this.diH)
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
        arrayOfInteger = this.diJ;
        arrayOfInteger[0] = Integer.valueOf(arrayOfInteger[0].intValue() + 1);
        AppMethodBeat.o(130114);
        return;
      }
      if (paramInt2 < 40)
      {
        arrayOfInteger = this.diJ;
        arrayOfInteger[1] = Integer.valueOf(arrayOfInteger[1].intValue() + 1);
        AppMethodBeat.o(130114);
        return;
      }
      if (paramInt2 < 80)
      {
        arrayOfInteger = this.diJ;
        arrayOfInteger[2] = Integer.valueOf(arrayOfInteger[2].intValue() + 1);
        AppMethodBeat.o(130114);
        return;
      }
      if (paramInt2 <= 100)
      {
        arrayOfInteger = this.diJ;
        arrayOfInteger[3] = Integer.valueOf(arrayOfInteger[3].intValue() + 1);
        AppMethodBeat.o(130114);
        return;
      }
      AppMethodBeat.o(130114);
      return;
      if (paramInt2 < 10)
      {
        arrayOfInteger = this.diJ;
        arrayOfInteger[0] = Integer.valueOf(arrayOfInteger[0].intValue() + 1);
        AppMethodBeat.o(130114);
        return;
      }
      if (paramInt2 < 40)
      {
        arrayOfInteger = this.diJ;
        arrayOfInteger[1] = Integer.valueOf(arrayOfInteger[1].intValue() + 1);
        AppMethodBeat.o(130114);
        return;
      }
      if (paramInt2 < 80)
      {
        arrayOfInteger = this.diJ;
        arrayOfInteger[2] = Integer.valueOf(arrayOfInteger[2].intValue() + 1);
        AppMethodBeat.o(130114);
        return;
      }
      if (paramInt2 <= 100)
      {
        arrayOfInteger = this.diJ;
        arrayOfInteger[3] = Integer.valueOf(arrayOfInteger[3].intValue() + 1);
      }
    }
  }
  
  public final void e(int paramInt, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(130115);
    p.h(paramArrayOfByte, "data");
    if (!this.diH)
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
        paramArrayOfByte = this.diI;
        paramArrayOfByte[0] = Integer.valueOf(paramArrayOfByte[0].intValue() + 1);
        AppMethodBeat.o(130115);
        return;
      }
      if (d < 300.0D)
      {
        paramArrayOfByte = this.diI;
        paramArrayOfByte[1] = Integer.valueOf(paramArrayOfByte[1].intValue() + 1);
        AppMethodBeat.o(130115);
        return;
      }
      if (d < 2000.0D)
      {
        paramArrayOfByte = this.diI;
        paramArrayOfByte[2] = Integer.valueOf(paramArrayOfByte[2].intValue() + 1);
        AppMethodBeat.o(130115);
        return;
      }
      paramArrayOfByte = this.diI;
      paramArrayOfByte[3] = Integer.valueOf(paramArrayOfByte[3].intValue() + 1);
    }
    AppMethodBeat.o(130115);
  }
  
  public final void hQ(int paramInt)
  {
    AppMethodBeat.i(130110);
    this.diH = true;
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(130110);
      return;
      c.Qj();
      AppMethodBeat.o(130110);
      return;
      b.Qj();
    }
  }
  
  public final void hR(int paramInt)
  {
    AppMethodBeat.i(130111);
    if (!this.diH)
    {
      AppMethodBeat.o(130111);
      return;
    }
    int k = Qi();
    if (k != 0)
    {
      Integer[] arrayOfInteger = this.diI;
      int i = 0;
      int m = arrayOfInteger.length;
      int j = 0;
      if (j < m)
      {
        int n = ((Number)arrayOfInteger[j]).intValue();
        long l = n * 100 / k;
        if (this.diH) {}
        switch (paramInt)
        {
        default: 
          n = n * 100 / k;
          if (this.diH) {
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
                  c.Qk();
                } else if (n <= 20) {
                  c.Ql();
                } else if (n <= 40) {
                  c.Qm();
                } else if (n <= 60) {
                  c.Qn();
                } else if (n <= 80) {
                  c.Qo();
                } else if (n == 100) {
                  c.Qp();
                }
                break;
              case 1: 
                if (n == 0) {
                  c.Qq();
                } else if (n <= 20) {
                  c.Qr();
                } else if (n <= 40) {
                  c.Qs();
                } else if (n <= 60) {
                  c.Qt();
                } else if (n <= 80) {
                  c.Qu();
                } else if (n == 100) {
                  c.Qv();
                }
                break;
              case 2: 
                if (n == 0) {
                  c.Qw();
                } else if (n <= 20) {
                  c.Qx();
                } else if (n <= 40) {
                  c.Qy();
                } else if (n <= 60) {
                  c.Qz();
                } else if (n <= 80) {
                  c.QA();
                } else if (n == 100) {
                  c.QB();
                }
                break;
              case 3: 
                if (n == 0)
                {
                  c.QC();
                }
                else if (n <= 20)
                {
                  c.QD();
                }
                else if (n <= 40)
                {
                  c.QE();
                }
                else if (n <= 60)
                {
                  c.QF();
                }
                else if (n <= 80)
                {
                  c.QG();
                }
                else if (n == 100)
                {
                  c.QH();
                  continue;
                  switch (i)
                  {
                  default: 
                    break;
                  case 0: 
                    if (n == 0) {
                      b.Qk();
                    } else if (n <= 20) {
                      b.Ql();
                    } else if (n <= 40) {
                      b.Qm();
                    } else if (n <= 60) {
                      b.Qn();
                    } else if (n <= 80) {
                      b.Qo();
                    } else if (n <= 100) {
                      b.Qp();
                    }
                    break;
                  case 1: 
                    if (n == 0) {
                      b.Qq();
                    } else if (n <= 20) {
                      b.Qr();
                    } else if (n <= 40) {
                      b.Qs();
                    } else if (n <= 60) {
                      b.Qt();
                    } else if (n <= 80) {
                      b.Qu();
                    } else if (n <= 100) {
                      b.Qv();
                    }
                    break;
                  case 2: 
                    if (n == 0) {
                      b.Qw();
                    } else if (n <= 20) {
                      b.Qx();
                    } else if (n <= 40) {
                      b.Qy();
                    } else if (n <= 60) {
                      b.Qz();
                    } else if (n <= 80) {
                      b.QA();
                    } else if (n <= 100) {
                      b.QB();
                    }
                    break;
                  case 3: 
                    if (n == 0) {
                      b.QC();
                    } else if (n <= 20) {
                      b.QD();
                    } else if (n <= 40) {
                      b.QE();
                    } else if (n <= 60) {
                      b.QF();
                    } else if (n <= 80) {
                      b.QG();
                    } else if (n <= 100) {
                      b.QH();
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
      this.diI = arrayOfInteger;
    }
    AppMethodBeat.o(130111);
  }
  
  public final void hS(int paramInt)
  {
    AppMethodBeat.i(130112);
    if (!this.diH)
    {
      AppMethodBeat.o(130112);
      return;
    }
    Integer[] arrayOfInteger = this.diJ;
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
      arrayOfInteger = this.diJ;
      j = 0;
      m = arrayOfInteger.length;
      k = 0;
      if (k < m)
      {
        int n = ((Number)arrayOfInteger[k]).intValue();
        long l = n * 100 / i;
        if (this.diH) {}
        switch (paramInt)
        {
        default: 
          n = n * 100 / i;
          if (this.diH) {
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
                  c.QI();
                } else if (n <= 20) {
                  c.QJ();
                } else if (n <= 40) {
                  c.QK();
                } else if (n <= 60) {
                  c.QL();
                } else if (n <= 80) {
                  c.QM();
                } else if (n == 100) {
                  c.QN();
                }
                break;
              case 1: 
                if (n == 0) {
                  c.QO();
                } else if (n <= 20) {
                  c.QP();
                } else if (n <= 40) {
                  c.QQ();
                } else if (n <= 60) {
                  c.QR();
                } else if (n <= 80) {
                  c.QS();
                } else if (n == 100) {
                  c.QT();
                }
                break;
              case 2: 
                if (n == 0) {
                  c.QU();
                } else if (n <= 20) {
                  c.QV();
                } else if (n <= 40) {
                  c.QW();
                } else if (n <= 60) {
                  c.QX();
                } else if (n <= 80) {
                  c.QY();
                } else if (n == 100) {
                  c.QZ();
                }
                break;
              case 3: 
                if (n == 0)
                {
                  c.Ra();
                }
                else if (n <= 20)
                {
                  c.Rb();
                }
                else if (n <= 40)
                {
                  c.Rc();
                }
                else if (n <= 60)
                {
                  c.Rd();
                }
                else if (n <= 80)
                {
                  c.Re();
                }
                else if (n == 100)
                {
                  c.Rf();
                  continue;
                  switch (j)
                  {
                  default: 
                    break;
                  case 0: 
                    if (n == 0) {
                      b.QI();
                    } else if (n <= 20) {
                      b.QJ();
                    } else if (n <= 40) {
                      b.QK();
                    } else if (n <= 60) {
                      b.QL();
                    } else if (n <= 80) {
                      b.QM();
                    } else if (n <= 100) {
                      b.QN();
                    }
                    break;
                  case 1: 
                    if (n == 0) {
                      b.QO();
                    } else if (n <= 20) {
                      b.QP();
                    } else if (n <= 40) {
                      b.QQ();
                    } else if (n <= 60) {
                      b.QR();
                    } else if (n <= 80) {
                      b.QS();
                    } else if (n <= 100) {
                      b.QT();
                    }
                    break;
                  case 2: 
                    if (n == 0) {
                      b.QU();
                    } else if (n <= 20) {
                      b.QV();
                    } else if (n <= 40) {
                      b.QW();
                    } else if (n <= 60) {
                      b.QX();
                    } else if (n <= 80) {
                      b.QY();
                    } else if (n <= 100) {
                      b.QZ();
                    }
                    break;
                  case 3: 
                    if (n == 0) {
                      b.Ra();
                    } else if (n <= 20) {
                      b.Rb();
                    } else if (n <= 40) {
                      b.Rc();
                    } else if (n <= 60) {
                      b.Rd();
                    } else if (n <= 80) {
                      b.Re();
                    } else if (n <= 100) {
                      b.Rf();
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
      this.diJ = arrayOfInteger;
    }
    AppMethodBeat.o(130112);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.audio.c.a.a
 * JD-Core Version:    0.7.0.1
 */