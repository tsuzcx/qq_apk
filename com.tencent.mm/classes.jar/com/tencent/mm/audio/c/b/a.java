package com.tencent.mm.audio.c.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.ae;
import d.g.b.p;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/audio/utils/recorder/AudioRecordReportUtil;", "", "()V", "RMS_TYPE_HIGH", "", "RMS_TYPE_LOW", "RMS_TYPE_MIDDLE", "RMS_TYPE_SILENT", "TAG", "", "checkRecordingHasMusicPlayingHasBeenReport", "", "mRMSInOneRecordProcess", "", "[Ljava/lang/Integer;", "resultSize", "byteArray2ShortArray", "", "data", "", "items", "calcDecibelLevel", "", "buffer", "readSize", "checkPCMAmplitude", "", "length", "checkRecordingHasMusicPlaying", "type", "checkZeroDataCauseHeadsetPlugged", "checkZeroDataCauseMicMute", "doAudioRecordHasBeenInitReport", "doAudioRecordKVReport", "audioType", "scenes", "featureKey", "pcmSilent", "pcmLow", "pcmMiddle", "pcmHigh", "systemSilent", "systemLow", "systemMiddle", "systemHigh", "audioSource", "mSampleRate", "mChannelConfig", "mRecordDetailState", "doAudioSourceSwitchFailedReport", "source", "doAudioSourceSwitchSuccessReport", "doAudioSourceUseErrorReport", "doAudioVolumeRecordKVReport", "doFinalAudioSourceRequstReport", "doMicroPhonesMuteReport", "doMinBufferSizeErrorReport", "doNewAudioRecordErrorReport", "doPCMRecordChecker", "doPCMRecordPercentReport", "index", "result", "", "doPCMRecordResultReport", "doRecordModeNullErrorReport", "doRecordReport", "doStartRecordErrorReport", "plugin-audiosdk_release"})
public final class a
{
  private static Integer[] djP;
  private static int djQ;
  private static boolean djR;
  public static final a djS;
  
  static
  {
    AppMethodBeat.i(130251);
    djS = new a();
    Integer[] arrayOfInteger = new Integer[4];
    int i = 0;
    while (i < 4)
    {
      arrayOfInteger[i] = Integer.valueOf(0);
      i += 1;
    }
    djP = arrayOfInteger;
    AppMethodBeat.o(130251);
  }
  
  public static final void a(int paramInt1, String paramString, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    AppMethodBeat.i(130234);
    p.h(paramString, "featureKey");
    if (djQ != 0)
    {
      int i = djP[0].intValue() * 100 / djQ;
      int j = djP[1].intValue() * 100 / djQ;
      int k = djP[2].intValue() * 100 / djQ;
      int m = djP[3].intValue() * 100 / djQ;
      ae.i("MicroMsg.AudioRecordReportUtil", "audioType = 0 ,scenes = " + paramInt1 + ",featureKey=" + paramString + ",pcmSilent=" + i + ", pcmLow=" + j + ",pcmMiddle=" + k + ",pcmHigh=" + m + ",systemSilent=0,systemLow=0,systemMiddle=0,systemHigh=0,audioSource=" + paramInt2 + ",sampleRate=" + paramInt3 + ",mChannelConfig=" + paramInt4 + ",mRecordDetailState=" + paramInt5);
      g.yxI.a(18554, true, true, new Object[] { Integer.valueOf(0), Integer.valueOf(paramInt1), paramString, Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k), Integer.valueOf(m), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Integer.valueOf(paramInt4), Integer.valueOf(paramInt5) });
      djR = false;
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
        c.Rl();
        AppMethodBeat.o(130243);
        return;
      }
      c.Rm();
      AppMethodBeat.o(130243);
      return;
      switch (paramInt2)
      {
      default: 
        break;
      case 1: 
        b.Rl();
        AppMethodBeat.o(130243);
        return;
      case 7: 
        b.Rm();
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
        c.Rf();
        AppMethodBeat.o(130245);
        return;
      }
      c.Rg();
      AppMethodBeat.o(130245);
      return;
      b localb;
      switch (paramInt2)
      {
      default: 
        break;
      case 1: 
        localb = b.djT;
        b.Rf();
        AppMethodBeat.o(130245);
        return;
      case 7: 
        localb = b.djT;
        b.Rg();
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
        c.Rk();
        AppMethodBeat.o(130246);
        return;
      }
      c.Ri();
      AppMethodBeat.o(130246);
      return;
      switch (paramInt2)
      {
      default: 
        break;
      case 1: 
        b.Rk();
        AppMethodBeat.o(130246);
        return;
      case 7: 
        b.Ri();
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
        c.Rj();
        AppMethodBeat.o(130247);
        return;
      }
      c.Rh();
      AppMethodBeat.o(130247);
      return;
      switch (paramInt2)
      {
      default: 
        break;
      case 1: 
        b.Rj();
        AppMethodBeat.o(130247);
        return;
      case 7: 
        b.Rh();
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
      paramArrayOfByte = djP;
      paramArrayOfByte[0] = Integer.valueOf(paramArrayOfByte[0].intValue() + 1);
    }
    for (;;)
    {
      djQ += 1;
      AppMethodBeat.o(130248);
      return;
      label169:
      if (d < 300.0D)
      {
        paramArrayOfByte = djP;
        paramArrayOfByte[1] = Integer.valueOf(paramArrayOfByte[1].intValue() + 1);
      }
      else if (d < 2000.0D)
      {
        paramArrayOfByte = djP;
        paramArrayOfByte[2] = Integer.valueOf(paramArrayOfByte[2].intValue() + 1);
      }
      else
      {
        paramArrayOfByte = djP;
        paramArrayOfByte[3] = Integer.valueOf(paramArrayOfByte[3].intValue() + 1);
      }
    }
  }
  
  public static final void hV(int paramInt)
  {
    AppMethodBeat.i(130235);
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(130235);
      return;
      c.Rs();
      AppMethodBeat.o(130235);
      return;
      b.Rs();
    }
  }
  
  public static final void hW(int paramInt)
  {
    AppMethodBeat.i(130236);
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(130236);
      return;
      c.Rr();
      AppMethodBeat.o(130236);
      return;
      b.Rr();
    }
  }
  
  public static final void hX(int paramInt)
  {
    AppMethodBeat.i(130237);
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(130237);
      return;
      c.Rq();
      AppMethodBeat.o(130237);
      return;
      b.Rq();
    }
  }
  
  public static final void hY(int paramInt)
  {
    AppMethodBeat.i(130238);
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(130238);
      return;
      c.Ru();
      AppMethodBeat.o(130238);
      return;
      b.Ru();
    }
  }
  
  public static final void hZ(int paramInt)
  {
    AppMethodBeat.i(130239);
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(130239);
      return;
      c.Rv();
      AppMethodBeat.o(130239);
      return;
      b.Rv();
    }
  }
  
  public static final void ia(int paramInt)
  {
    AppMethodBeat.i(130240);
    ae.i("MicroMsg.AudioRecordReportUtil", "current happened recording and music playing ");
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(130240);
      return;
      if (!djR)
      {
        djR = true;
        c.Rw();
        AppMethodBeat.o(130240);
        return;
        if (!djR)
        {
          djR = true;
          b.Rw();
        }
      }
    }
  }
  
  public static final void ib(int paramInt)
  {
    AppMethodBeat.i(130241);
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(130241);
      return;
      c.Rp();
      AppMethodBeat.o(130241);
      return;
      b.Rp();
    }
  }
  
  public static final void ic(int paramInt)
  {
    AppMethodBeat.i(130242);
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(130242);
      return;
      c.Ro();
      AppMethodBeat.o(130242);
      return;
      b.Ro();
    }
  }
  
  public static final void id(int paramInt)
  {
    AppMethodBeat.i(130244);
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(130244);
      return;
      c.Rn();
      AppMethodBeat.o(130244);
      return;
      b.Rn();
    }
  }
  
  public static final void ie(int paramInt)
  {
    AppMethodBeat.i(130249);
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(130249);
      return;
      c.Rt();
      AppMethodBeat.o(130249);
      return;
      b.Rt();
    }
  }
  
  public static final void jdMethod_if(int paramInt)
  {
    AppMethodBeat.i(130250);
    if (djQ != 0)
    {
      Integer[] arrayOfInteger = djP;
      int i = 0;
      int k = arrayOfInteger.length;
      int j = 0;
      if (j < k)
      {
        int m = ((Number)arrayOfInteger[j]).intValue();
        long l = m * 100 / djQ;
        switch (paramInt)
        {
        default: 
          m = m * 100 / djQ;
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
                  c.Qj();
                } else if (m <= 20) {
                  c.Qk();
                } else if (m <= 40) {
                  c.Ql();
                } else if (m <= 60) {
                  c.Qm();
                } else if (m <= 80) {
                  c.Qn();
                } else if (m == 100) {
                  c.Qo();
                }
                break;
              case 1: 
                if (m == 0) {
                  c.Qp();
                } else if (m <= 20) {
                  c.Qq();
                } else if (m <= 40) {
                  c.Qr();
                } else if (m <= 60) {
                  c.Qs();
                } else if (m <= 80) {
                  c.Qt();
                } else if (m == 100) {
                  c.Qu();
                }
                break;
              case 2: 
                if (m == 0) {
                  c.Qv();
                } else if (m <= 20) {
                  c.Qw();
                } else if (m <= 40) {
                  c.Qx();
                } else if (m <= 60) {
                  c.Qy();
                } else if (m <= 80) {
                  c.Qz();
                } else if (m == 100) {
                  c.QA();
                }
                break;
              case 3: 
                if (m == 0)
                {
                  c.QB();
                }
                else if (m <= 20)
                {
                  c.QC();
                }
                else if (m <= 40)
                {
                  c.QD();
                }
                else if (m <= 60)
                {
                  c.QE();
                }
                else if (m <= 80)
                {
                  c.QF();
                }
                else if (m == 100)
                {
                  c.QG();
                  continue;
                  switch (i)
                  {
                  default: 
                    break;
                  case 0: 
                    if (m == 0) {
                      b.Qj();
                    } else if (m <= 20) {
                      b.Qk();
                    } else if (m <= 40) {
                      b.Ql();
                    } else if (m <= 60) {
                      b.Qm();
                    } else if (m <= 80) {
                      b.Qn();
                    } else if (m <= 100) {
                      b.Qo();
                    }
                    break;
                  case 1: 
                    if (m == 0) {
                      b.Qp();
                    } else if (m <= 20) {
                      b.Qq();
                    } else if (m <= 40) {
                      b.Qr();
                    } else if (m <= 60) {
                      b.Qs();
                    } else if (m <= 80) {
                      b.Qt();
                    } else if (m <= 100) {
                      b.Qu();
                    }
                    break;
                  case 2: 
                    if (m == 0) {
                      b.Qv();
                    } else if (m <= 20) {
                      b.Qw();
                    } else if (m <= 40) {
                      b.Qx();
                    } else if (m <= 60) {
                      b.Qy();
                    } else if (m <= 80) {
                      b.Qz();
                    } else if (m <= 100) {
                      b.QA();
                    }
                    break;
                  case 3: 
                    if (m == 0) {
                      b.QB();
                    } else if (m <= 20) {
                      b.QC();
                    } else if (m <= 40) {
                      b.QD();
                    } else if (m <= 60) {
                      b.QE();
                    } else if (m <= 80) {
                      b.QF();
                    } else if (m <= 100) {
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
      djQ = 0;
      arrayOfInteger = new Integer[4];
      paramInt = 0;
      while (paramInt < 4)
      {
        arrayOfInteger[paramInt] = Integer.valueOf(0);
        paramInt += 1;
      }
      djP = arrayOfInteger;
    }
    AppMethodBeat.o(130250);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.audio.c.b.a
 * JD-Core Version:    0.7.0.1
 */