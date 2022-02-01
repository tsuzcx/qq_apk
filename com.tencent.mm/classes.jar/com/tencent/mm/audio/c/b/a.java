package com.tencent.mm.audio.c.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.ad;
import d.g.b.p;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/audio/utils/recorder/AudioRecordReportUtil;", "", "()V", "RMS_TYPE_HIGH", "", "RMS_TYPE_LOW", "RMS_TYPE_MIDDLE", "RMS_TYPE_SILENT", "TAG", "", "checkRecordingHasMusicPlayingHasBeenReport", "", "mRMSInOneRecordProcess", "", "[Ljava/lang/Integer;", "resultSize", "byteArray2ShortArray", "", "data", "", "items", "calcDecibelLevel", "", "buffer", "readSize", "checkPCMAmplitude", "", "length", "checkRecordingHasMusicPlaying", "type", "checkZeroDataCauseHeadsetPlugged", "checkZeroDataCauseMicMute", "doAudioRecordHasBeenInitReport", "doAudioRecordKVReport", "audioType", "scenes", "featureKey", "pcmSilent", "pcmLow", "pcmMiddle", "pcmHigh", "systemSilent", "systemLow", "systemMiddle", "systemHigh", "audioSource", "mSampleRate", "mChannelConfig", "mRecordDetailState", "doAudioSourceSwitchFailedReport", "source", "doAudioSourceSwitchSuccessReport", "doAudioSourceUseErrorReport", "doAudioVolumeRecordKVReport", "doFinalAudioSourceRequstReport", "doMicroPhonesMuteReport", "doMinBufferSizeErrorReport", "doNewAudioRecordErrorReport", "doPCMRecordChecker", "doPCMRecordPercentReport", "index", "result", "", "doPCMRecordResultReport", "doRecordModeNullErrorReport", "doRecordReport", "doStartRecordErrorReport", "plugin-audiosdk_release"})
public final class a
{
  private static Integer[] diN;
  private static int diO;
  private static boolean diP;
  public static final a diQ;
  
  static
  {
    AppMethodBeat.i(130251);
    diQ = new a();
    Integer[] arrayOfInteger = new Integer[4];
    int i = 0;
    while (i < 4)
    {
      arrayOfInteger[i] = Integer.valueOf(0);
      i += 1;
    }
    diN = arrayOfInteger;
    AppMethodBeat.o(130251);
  }
  
  public static final void a(int paramInt1, String paramString, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    AppMethodBeat.i(130234);
    p.h(paramString, "featureKey");
    if (diO != 0)
    {
      int i = diN[0].intValue() * 100 / diO;
      int j = diN[1].intValue() * 100 / diO;
      int k = diN[2].intValue() * 100 / diO;
      int m = diN[3].intValue() * 100 / diO;
      ad.i("MicroMsg.AudioRecordReportUtil", "audioType = 0 ,scenes = " + paramInt1 + ",featureKey=" + paramString + ",pcmSilent=" + i + ", pcmLow=" + j + ",pcmMiddle=" + k + ",pcmHigh=" + m + ",systemSilent=0,systemLow=0,systemMiddle=0,systemHigh=0,audioSource=" + paramInt2 + ",sampleRate=" + paramInt3 + ",mChannelConfig=" + paramInt4 + ",mRecordDetailState=" + paramInt5);
      g.yhR.a(18554, true, true, new Object[] { Integer.valueOf(0), Integer.valueOf(paramInt1), paramString, Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k), Integer.valueOf(m), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Integer.valueOf(paramInt4), Integer.valueOf(paramInt5) });
      diP = false;
    }
    AppMethodBeat.o(130234);
  }
  
  public static final void cj(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(130243);
    switch (paramInt1)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(130243);
      return;
      switch (paramInt2)
      {
      default: 
        AppMethodBeat.o(130243);
        return;
      case 1: 
        c.Rm();
        AppMethodBeat.o(130243);
        return;
      }
      c.Rn();
      AppMethodBeat.o(130243);
      return;
      switch (paramInt2)
      {
      default: 
        break;
      case 1: 
        b.Rm();
        AppMethodBeat.o(130243);
        return;
      case 7: 
        b.Rn();
      }
    }
  }
  
  public static final void ck(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(130245);
    switch (paramInt1)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(130245);
      return;
      switch (paramInt2)
      {
      default: 
        AppMethodBeat.o(130245);
        return;
      case 1: 
        c.Rg();
        AppMethodBeat.o(130245);
        return;
      }
      c.Rh();
      AppMethodBeat.o(130245);
      return;
      b localb;
      switch (paramInt2)
      {
      default: 
        break;
      case 1: 
        localb = b.diR;
        b.Rg();
        AppMethodBeat.o(130245);
        return;
      case 7: 
        localb = b.diR;
        b.Rh();
      }
    }
  }
  
  public static final void cl(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(130246);
    switch (paramInt1)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(130246);
      return;
      switch (paramInt2)
      {
      default: 
        AppMethodBeat.o(130246);
        return;
      case 1: 
        c.Rl();
        AppMethodBeat.o(130246);
        return;
      }
      c.Rj();
      AppMethodBeat.o(130246);
      return;
      switch (paramInt2)
      {
      default: 
        break;
      case 1: 
        b.Rl();
        AppMethodBeat.o(130246);
        return;
      case 7: 
        b.Rj();
      }
    }
  }
  
  public static final void cm(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(130247);
    switch (paramInt1)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(130247);
      return;
      switch (paramInt2)
      {
      default: 
        AppMethodBeat.o(130247);
        return;
      case 1: 
        c.Rk();
        AppMethodBeat.o(130247);
        return;
      }
      c.Ri();
      AppMethodBeat.o(130247);
      return;
      switch (paramInt2)
      {
      default: 
        break;
      case 1: 
        b.Rk();
        AppMethodBeat.o(130247);
        return;
      case 7: 
        b.Ri();
      }
    }
  }
  
  public static final void e(int paramInt, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(130248);
    p.h(paramArrayOfByte, "data");
    double d;
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
      d = 0.0D;
      j = arrayOfShort.length;
      paramInt = 0;
      while (paramInt < j)
      {
        int k = arrayOfShort[paramInt];
        d += k * k;
        paramInt += 1;
      }
      d = Math.sqrt(d / i);
      if (d >= 50.0D) {
        break label169;
      }
      paramArrayOfByte = diN;
      paramArrayOfByte[0] = Integer.valueOf(paramArrayOfByte[0].intValue() + 1);
    }
    for (;;)
    {
      diO += 1;
      AppMethodBeat.o(130248);
      return;
      label169:
      if (d < 300.0D)
      {
        paramArrayOfByte = diN;
        paramArrayOfByte[1] = Integer.valueOf(paramArrayOfByte[1].intValue() + 1);
      }
      else if (d < 2000.0D)
      {
        paramArrayOfByte = diN;
        paramArrayOfByte[2] = Integer.valueOf(paramArrayOfByte[2].intValue() + 1);
      }
      else
      {
        paramArrayOfByte = diN;
        paramArrayOfByte[3] = Integer.valueOf(paramArrayOfByte[3].intValue() + 1);
      }
    }
  }
  
  public static final void hT(int paramInt)
  {
    AppMethodBeat.i(130235);
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(130235);
      return;
      c.Rt();
      AppMethodBeat.o(130235);
      return;
      b.Rt();
    }
  }
  
  public static final void hU(int paramInt)
  {
    AppMethodBeat.i(130236);
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(130236);
      return;
      c.Rs();
      AppMethodBeat.o(130236);
      return;
      b.Rs();
    }
  }
  
  public static final void hV(int paramInt)
  {
    AppMethodBeat.i(130237);
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(130237);
      return;
      c.Rr();
      AppMethodBeat.o(130237);
      return;
      b.Rr();
    }
  }
  
  public static final void hW(int paramInt)
  {
    AppMethodBeat.i(130238);
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(130238);
      return;
      c.Rv();
      AppMethodBeat.o(130238);
      return;
      b.Rv();
    }
  }
  
  public static final void hX(int paramInt)
  {
    AppMethodBeat.i(130239);
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(130239);
      return;
      c.Rw();
      AppMethodBeat.o(130239);
      return;
      b.Rw();
    }
  }
  
  public static final void hY(int paramInt)
  {
    AppMethodBeat.i(130240);
    ad.i("MicroMsg.AudioRecordReportUtil", "current happened recording and music playing ");
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(130240);
      return;
      if (!diP)
      {
        diP = true;
        c.Rx();
        AppMethodBeat.o(130240);
        return;
        if (!diP)
        {
          diP = true;
          b.Rx();
        }
      }
    }
  }
  
  public static final void hZ(int paramInt)
  {
    AppMethodBeat.i(130241);
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(130241);
      return;
      c.Rq();
      AppMethodBeat.o(130241);
      return;
      b.Rq();
    }
  }
  
  public static final void ia(int paramInt)
  {
    AppMethodBeat.i(130242);
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(130242);
      return;
      c.Rp();
      AppMethodBeat.o(130242);
      return;
      b.Rp();
    }
  }
  
  public static final void ib(int paramInt)
  {
    AppMethodBeat.i(130244);
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(130244);
      return;
      c.Ro();
      AppMethodBeat.o(130244);
      return;
      b.Ro();
    }
  }
  
  public static final void ic(int paramInt)
  {
    AppMethodBeat.i(130249);
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(130249);
      return;
      c.Ru();
      AppMethodBeat.o(130249);
      return;
      b.Ru();
    }
  }
  
  public static final void id(int paramInt)
  {
    AppMethodBeat.i(130250);
    if (diO != 0)
    {
      Integer[] arrayOfInteger = diN;
      int i = 0;
      int k = arrayOfInteger.length;
      int j = 0;
      if (j < k)
      {
        int m = ((Number)arrayOfInteger[j]).intValue();
        long l = m * 100 / diO;
        switch (paramInt)
        {
        default: 
          m = m * 100 / diO;
          switch (paramInt)
          {
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
                if (m == 0) {
                  c.Qk();
                } else if (m <= 20) {
                  c.Ql();
                } else if (m <= 40) {
                  c.Qm();
                } else if (m <= 60) {
                  c.Qn();
                } else if (m <= 80) {
                  c.Qo();
                } else if (m == 100) {
                  c.Qp();
                }
                break;
              case 1: 
                if (m == 0) {
                  c.Qq();
                } else if (m <= 20) {
                  c.Qr();
                } else if (m <= 40) {
                  c.Qs();
                } else if (m <= 60) {
                  c.Qt();
                } else if (m <= 80) {
                  c.Qu();
                } else if (m == 100) {
                  c.Qv();
                }
                break;
              case 2: 
                if (m == 0) {
                  c.Qw();
                } else if (m <= 20) {
                  c.Qx();
                } else if (m <= 40) {
                  c.Qy();
                } else if (m <= 60) {
                  c.Qz();
                } else if (m <= 80) {
                  c.QA();
                } else if (m == 100) {
                  c.QB();
                }
                break;
              case 3: 
                if (m == 0)
                {
                  c.QC();
                }
                else if (m <= 20)
                {
                  c.QD();
                }
                else if (m <= 40)
                {
                  c.QE();
                }
                else if (m <= 60)
                {
                  c.QF();
                }
                else if (m <= 80)
                {
                  c.QG();
                }
                else if (m == 100)
                {
                  c.QH();
                  continue;
                  switch (i)
                  {
                  default: 
                    break;
                  case 0: 
                    if (m == 0) {
                      b.Qk();
                    } else if (m <= 20) {
                      b.Ql();
                    } else if (m <= 40) {
                      b.Qm();
                    } else if (m <= 60) {
                      b.Qn();
                    } else if (m <= 80) {
                      b.Qo();
                    } else if (m <= 100) {
                      b.Qp();
                    }
                    break;
                  case 1: 
                    if (m == 0) {
                      b.Qq();
                    } else if (m <= 20) {
                      b.Qr();
                    } else if (m <= 40) {
                      b.Qs();
                    } else if (m <= 60) {
                      b.Qt();
                    } else if (m <= 80) {
                      b.Qu();
                    } else if (m <= 100) {
                      b.Qv();
                    }
                    break;
                  case 2: 
                    if (m == 0) {
                      b.Qw();
                    } else if (m <= 20) {
                      b.Qx();
                    } else if (m <= 40) {
                      b.Qy();
                    } else if (m <= 60) {
                      b.Qz();
                    } else if (m <= 80) {
                      b.QA();
                    } else if (m <= 100) {
                      b.QB();
                    }
                    break;
                  case 3: 
                    if (m == 0) {
                      b.QC();
                    } else if (m <= 20) {
                      b.QD();
                    } else if (m <= 40) {
                      b.QE();
                    } else if (m <= 60) {
                      b.QF();
                    } else if (m <= 80) {
                      b.QG();
                    } else if (m <= 100) {
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
      diO = 0;
      arrayOfInteger = new Integer[4];
      paramInt = 0;
      while (paramInt < 4)
      {
        arrayOfInteger[paramInt] = Integer.valueOf(0);
        paramInt += 1;
      }
      diN = arrayOfInteger;
    }
    AppMethodBeat.o(130250);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.audio.c.b.a
 * JD-Core Version:    0.7.0.1
 */