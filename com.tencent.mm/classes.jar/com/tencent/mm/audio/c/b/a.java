package com.tencent.mm.audio.c.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/audio/utils/recorder/AudioRecordReportUtil;", "", "()V", "RMS_TYPE_HIGH", "", "RMS_TYPE_LOW", "RMS_TYPE_MIDDLE", "RMS_TYPE_SILENT", "TAG", "", "checkRecordingHasMusicPlayingHasBeenReport", "", "mRMSInOneRecordProcess", "", "[Ljava/lang/Integer;", "resultSize", "byteArray2ShortArray", "", "data", "", "items", "calcDecibelLevel", "", "buffer", "readSize", "checkPCMAmplitude", "", "length", "checkRecordingHasMusicPlaying", "type", "checkZeroDataCauseHeadsetPlugged", "checkZeroDataCauseMicMute", "doAudioRecordHasBeenInitReport", "doAudioRecordKVReport", "audioType", "scenes", "featureKey", "pcmSilent", "pcmLow", "pcmMiddle", "pcmHigh", "systemSilent", "systemLow", "systemMiddle", "systemHigh", "audioSource", "mSampleRate", "mChannelConfig", "mRecordDetailState", "doAudioSourceSwitchFailedReport", "source", "doAudioSourceSwitchSuccessReport", "doAudioSourceUseErrorReport", "doAudioVolumeRecordKVReport", "doFinalAudioSourceRequstReport", "doMicroPhonesMuteReport", "doMinBufferSizeErrorReport", "doNewAudioRecordErrorReport", "doPCMRecordChecker", "doPCMRecordPercentReport", "index", "result", "", "doPCMRecordResultReport", "doRecordModeNullErrorReport", "doRecordReport", "doStartRecordErrorReport", "plugin-audiosdk_release"})
public final class a
{
  private static Integer[] ftO;
  private static int ftP;
  private static boolean ftQ;
  public static final a ftR;
  
  static
  {
    AppMethodBeat.i(130251);
    ftR = new a();
    Integer[] arrayOfInteger = new Integer[4];
    int i = 0;
    while (i < 4)
    {
      arrayOfInteger[i] = Integer.valueOf(0);
      i += 1;
    }
    ftO = arrayOfInteger;
    AppMethodBeat.o(130251);
  }
  
  public static final void a(int paramInt1, String paramString, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    AppMethodBeat.i(130234);
    p.k(paramString, "featureKey");
    if (ftP != 0)
    {
      int i = ftO[0].intValue() * 100 / ftP;
      int j = ftO[1].intValue() * 100 / ftP;
      int k = ftO[2].intValue() * 100 / ftP;
      int m = ftO[3].intValue() * 100 / ftP;
      Log.i("MicroMsg.AudioRecordReportUtil", "audioType = 0 ,scenes = " + paramInt1 + ",featureKey=" + paramString + ",pcmSilent=" + i + ", pcmLow=" + j + ",pcmMiddle=" + k + ",pcmHigh=" + m + ",systemSilent=0,systemLow=0,systemMiddle=0,systemHigh=0,audioSource=" + paramInt2 + ",sampleRate=" + paramInt3 + ",mChannelConfig=" + paramInt4 + ",mRecordDetailState=" + paramInt5);
      h.IzE.a(18554, true, true, new Object[] { Integer.valueOf(0), Integer.valueOf(paramInt1), paramString, Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k), Integer.valueOf(m), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Integer.valueOf(paramInt4), Integer.valueOf(paramInt5) });
      ftQ = false;
    }
    AppMethodBeat.o(130234);
  }
  
  public static final void cD(int paramInt1, int paramInt2)
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
        c.agq();
        AppMethodBeat.o(130243);
        return;
      }
      c.agr();
      AppMethodBeat.o(130243);
      return;
      switch (paramInt2)
      {
      default: 
        break;
      case 1: 
        b.agq();
        AppMethodBeat.o(130243);
        return;
      case 7: 
        b.agr();
      }
    }
  }
  
  public static final void cE(int paramInt1, int paramInt2)
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
        c.agk();
        AppMethodBeat.o(130245);
        return;
      }
      c.agl();
      AppMethodBeat.o(130245);
      return;
      b localb;
      switch (paramInt2)
      {
      default: 
        break;
      case 1: 
        localb = b.ftS;
        b.agk();
        AppMethodBeat.o(130245);
        return;
      case 7: 
        localb = b.ftS;
        b.agl();
      }
    }
  }
  
  public static final void cF(int paramInt1, int paramInt2)
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
        c.agp();
        AppMethodBeat.o(130246);
        return;
      }
      c.agn();
      AppMethodBeat.o(130246);
      return;
      switch (paramInt2)
      {
      default: 
        break;
      case 1: 
        b.agp();
        AppMethodBeat.o(130246);
        return;
      case 7: 
        b.agn();
      }
    }
  }
  
  public static final void cG(int paramInt1, int paramInt2)
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
        c.ago();
        AppMethodBeat.o(130247);
        return;
      }
      c.agm();
      AppMethodBeat.o(130247);
      return;
      switch (paramInt2)
      {
      default: 
        break;
      case 1: 
        b.ago();
        AppMethodBeat.o(130247);
        return;
      case 7: 
        b.agm();
      }
    }
  }
  
  public static final void e(int paramInt, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(130248);
    p.k(paramArrayOfByte, "data");
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
      paramArrayOfByte = ftO;
      paramArrayOfByte[0] = Integer.valueOf(paramArrayOfByte[0].intValue() + 1);
    }
    for (;;)
    {
      ftP += 1;
      AppMethodBeat.o(130248);
      return;
      label169:
      if (d < 300.0D)
      {
        paramArrayOfByte = ftO;
        paramArrayOfByte[1] = Integer.valueOf(paramArrayOfByte[1].intValue() + 1);
      }
      else if (d < 2000.0D)
      {
        paramArrayOfByte = ftO;
        paramArrayOfByte[2] = Integer.valueOf(paramArrayOfByte[2].intValue() + 1);
      }
      else
      {
        paramArrayOfByte = ftO;
        paramArrayOfByte[3] = Integer.valueOf(paramArrayOfByte[3].intValue() + 1);
      }
    }
  }
  
  public static final void kJ(int paramInt)
  {
    AppMethodBeat.i(130235);
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(130235);
      return;
      c.agx();
      AppMethodBeat.o(130235);
      return;
      b.agx();
    }
  }
  
  public static final void kK(int paramInt)
  {
    AppMethodBeat.i(130236);
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(130236);
      return;
      c.agw();
      AppMethodBeat.o(130236);
      return;
      b.agw();
    }
  }
  
  public static final void kL(int paramInt)
  {
    AppMethodBeat.i(130237);
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(130237);
      return;
      c.agv();
      AppMethodBeat.o(130237);
      return;
      b.agv();
    }
  }
  
  public static final void kM(int paramInt)
  {
    AppMethodBeat.i(130238);
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(130238);
      return;
      c.agz();
      AppMethodBeat.o(130238);
      return;
      b.agz();
    }
  }
  
  public static final void kN(int paramInt)
  {
    AppMethodBeat.i(130239);
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(130239);
      return;
      c.agA();
      AppMethodBeat.o(130239);
      return;
      b.agA();
    }
  }
  
  public static final void kO(int paramInt)
  {
    AppMethodBeat.i(130240);
    Log.i("MicroMsg.AudioRecordReportUtil", "current happened recording and music playing ");
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(130240);
      return;
      if (!ftQ)
      {
        ftQ = true;
        c.agB();
        AppMethodBeat.o(130240);
        return;
        if (!ftQ)
        {
          ftQ = true;
          b.agB();
        }
      }
    }
  }
  
  public static final void kP(int paramInt)
  {
    AppMethodBeat.i(130241);
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(130241);
      return;
      c.agu();
      AppMethodBeat.o(130241);
      return;
      b.agu();
    }
  }
  
  public static final void kQ(int paramInt)
  {
    AppMethodBeat.i(130242);
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(130242);
      return;
      c.agt();
      AppMethodBeat.o(130242);
      return;
      b.agt();
    }
  }
  
  public static final void kR(int paramInt)
  {
    AppMethodBeat.i(130244);
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(130244);
      return;
      c.ags();
      AppMethodBeat.o(130244);
      return;
      b.ags();
    }
  }
  
  public static final void kS(int paramInt)
  {
    AppMethodBeat.i(130249);
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(130249);
      return;
      c.agy();
      AppMethodBeat.o(130249);
      return;
      b.agy();
    }
  }
  
  public static final void kT(int paramInt)
  {
    AppMethodBeat.i(130250);
    if (ftP != 0)
    {
      Integer[] arrayOfInteger = ftO;
      int i = 0;
      int k = arrayOfInteger.length;
      int j = 0;
      if (j < k)
      {
        int m = ((Number)arrayOfInteger[j]).intValue();
        long l = m * 100 / ftP;
        switch (paramInt)
        {
        default: 
          m = m * 100 / ftP;
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
                if (m == 0) {
                  c.afo();
                } else if (m <= 20) {
                  c.afp();
                } else if (m <= 40) {
                  c.afq();
                } else if (m <= 60) {
                  c.afr();
                } else if (m <= 80) {
                  c.afs();
                } else if (m == 100) {
                  c.aft();
                }
                break;
              case 1: 
                if (m == 0) {
                  c.afu();
                } else if (m <= 20) {
                  c.afv();
                } else if (m <= 40) {
                  c.afw();
                } else if (m <= 60) {
                  c.afx();
                } else if (m <= 80) {
                  c.afy();
                } else if (m == 100) {
                  c.afz();
                }
                break;
              case 2: 
                if (m == 0) {
                  c.afA();
                } else if (m <= 20) {
                  c.afB();
                } else if (m <= 40) {
                  c.afC();
                } else if (m <= 60) {
                  c.afD();
                } else if (m <= 80) {
                  c.afE();
                } else if (m == 100) {
                  c.afF();
                }
                break;
              case 3: 
                if (m == 0)
                {
                  c.afG();
                }
                else if (m <= 20)
                {
                  c.afH();
                }
                else if (m <= 40)
                {
                  c.afI();
                }
                else if (m <= 60)
                {
                  c.afJ();
                }
                else if (m <= 80)
                {
                  c.afK();
                }
                else if (m == 100)
                {
                  c.afL();
                  continue;
                  switch (i)
                  {
                  default: 
                    break;
                  case 0: 
                    if (m == 0) {
                      b.afo();
                    } else if (m <= 20) {
                      b.afp();
                    } else if (m <= 40) {
                      b.afq();
                    } else if (m <= 60) {
                      b.afr();
                    } else if (m <= 80) {
                      b.afs();
                    } else if (m <= 100) {
                      b.aft();
                    }
                    break;
                  case 1: 
                    if (m == 0) {
                      b.afu();
                    } else if (m <= 20) {
                      b.afv();
                    } else if (m <= 40) {
                      b.afw();
                    } else if (m <= 60) {
                      b.afx();
                    } else if (m <= 80) {
                      b.afy();
                    } else if (m <= 100) {
                      b.afz();
                    }
                    break;
                  case 2: 
                    if (m == 0) {
                      b.afA();
                    } else if (m <= 20) {
                      b.afB();
                    } else if (m <= 40) {
                      b.afC();
                    } else if (m <= 60) {
                      b.afD();
                    } else if (m <= 80) {
                      b.afE();
                    } else if (m <= 100) {
                      b.afF();
                    }
                    break;
                  case 3: 
                    if (m == 0) {
                      b.afG();
                    } else if (m <= 20) {
                      b.afH();
                    } else if (m <= 40) {
                      b.afI();
                    } else if (m <= 60) {
                      b.afJ();
                    } else if (m <= 80) {
                      b.afK();
                    } else if (m <= 100) {
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
      ftP = 0;
      arrayOfInteger = new Integer[4];
      paramInt = 0;
      while (paramInt < 4)
      {
        arrayOfInteger[paramInt] = Integer.valueOf(0);
        paramInt += 1;
      }
      ftO = arrayOfInteger;
    }
    AppMethodBeat.o(130250);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.audio.c.b.a
 * JD-Core Version:    0.7.0.1
 */