package com.tencent.mm.audio.c.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/audio/utils/recorder/AudioRecordReportUtil;", "", "()V", "RMS_TYPE_HIGH", "", "RMS_TYPE_LOW", "RMS_TYPE_MIDDLE", "RMS_TYPE_SILENT", "TAG", "", "checkRecordingHasMusicPlayingHasBeenReport", "", "mRMSInOneRecordProcess", "", "[Ljava/lang/Integer;", "resultSize", "byteArray2ShortArray", "", "data", "", "items", "calcDecibelLevel", "", "buffer", "readSize", "checkPCMAmplitude", "", "length", "checkRecordingHasMusicPlaying", "type", "checkZeroDataCauseHeadsetPlugged", "checkZeroDataCauseMicMute", "doAudioRecordHasBeenInitReport", "doAudioRecordKVReport", "audioType", "scenes", "featureKey", "pcmSilent", "pcmLow", "pcmMiddle", "pcmHigh", "systemSilent", "systemLow", "systemMiddle", "systemHigh", "audioSource", "mSampleRate", "mChannelConfig", "mRecordDetailState", "doAudioSourceSwitchFailedReport", "source", "doAudioSourceSwitchSuccessReport", "doAudioSourceUseErrorReport", "doAudioVolumeRecordKVReport", "doFinalAudioSourceRequstReport", "doMicroPhonesMuteReport", "doMinBufferSizeErrorReport", "doNewAudioRecordErrorReport", "doPCMRecordChecker", "doPCMRecordPercentReport", "index", "result", "", "doPCMRecordResultReport", "doRecordModeNullErrorReport", "doRecordReport", "doStartRecordErrorReport", "plugin-audiosdk_release"})
public final class a
{
  private static Integer[] dAZ;
  private static int dBa;
  private static boolean dBb;
  public static final a dBc;
  
  static
  {
    AppMethodBeat.i(130251);
    dBc = new a();
    Integer[] arrayOfInteger = new Integer[4];
    int i = 0;
    while (i < 4)
    {
      arrayOfInteger[i] = Integer.valueOf(0);
      i += 1;
    }
    dAZ = arrayOfInteger;
    AppMethodBeat.o(130251);
  }
  
  public static final void a(int paramInt1, String paramString, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    AppMethodBeat.i(130234);
    p.h(paramString, "featureKey");
    if (dBa != 0)
    {
      int i = dAZ[0].intValue() * 100 / dBa;
      int j = dAZ[1].intValue() * 100 / dBa;
      int k = dAZ[2].intValue() * 100 / dBa;
      int m = dAZ[3].intValue() * 100 / dBa;
      Log.i("MicroMsg.AudioRecordReportUtil", "audioType = 0 ,scenes = " + paramInt1 + ",featureKey=" + paramString + ",pcmSilent=" + i + ", pcmLow=" + j + ",pcmMiddle=" + k + ",pcmHigh=" + m + ",systemSilent=0,systemLow=0,systemMiddle=0,systemHigh=0,audioSource=" + paramInt2 + ",sampleRate=" + paramInt3 + ",mChannelConfig=" + paramInt4 + ",mRecordDetailState=" + paramInt5);
      h.CyF.a(18554, true, true, new Object[] { Integer.valueOf(0), Integer.valueOf(paramInt1), paramString, Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k), Integer.valueOf(m), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Integer.valueOf(paramInt4), Integer.valueOf(paramInt5) });
      dBb = false;
    }
    AppMethodBeat.o(130234);
  }
  
  public static final void cl(int paramInt1, int paramInt2)
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
        c.abD();
        AppMethodBeat.o(130243);
        return;
      }
      c.abE();
      AppMethodBeat.o(130243);
      return;
      switch (paramInt2)
      {
      default: 
        break;
      case 1: 
        b.abD();
        AppMethodBeat.o(130243);
        return;
      case 7: 
        b.abE();
      }
    }
  }
  
  public static final void cm(int paramInt1, int paramInt2)
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
        c.abx();
        AppMethodBeat.o(130245);
        return;
      }
      c.aby();
      AppMethodBeat.o(130245);
      return;
      b localb;
      switch (paramInt2)
      {
      default: 
        break;
      case 1: 
        localb = b.dBd;
        b.abx();
        AppMethodBeat.o(130245);
        return;
      case 7: 
        localb = b.dBd;
        b.aby();
      }
    }
  }
  
  public static final void cn(int paramInt1, int paramInt2)
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
        c.abC();
        AppMethodBeat.o(130246);
        return;
      }
      c.abA();
      AppMethodBeat.o(130246);
      return;
      switch (paramInt2)
      {
      default: 
        break;
      case 1: 
        b.abC();
        AppMethodBeat.o(130246);
        return;
      case 7: 
        b.abA();
      }
    }
  }
  
  public static final void co(int paramInt1, int paramInt2)
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
        c.abB();
        AppMethodBeat.o(130247);
        return;
      }
      c.abz();
      AppMethodBeat.o(130247);
      return;
      switch (paramInt2)
      {
      default: 
        break;
      case 1: 
        b.abB();
        AppMethodBeat.o(130247);
        return;
      case 7: 
        b.abz();
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
      paramArrayOfByte = dAZ;
      paramArrayOfByte[0] = Integer.valueOf(paramArrayOfByte[0].intValue() + 1);
    }
    for (;;)
    {
      dBa += 1;
      AppMethodBeat.o(130248);
      return;
      label169:
      if (d < 300.0D)
      {
        paramArrayOfByte = dAZ;
        paramArrayOfByte[1] = Integer.valueOf(paramArrayOfByte[1].intValue() + 1);
      }
      else if (d < 2000.0D)
      {
        paramArrayOfByte = dAZ;
        paramArrayOfByte[2] = Integer.valueOf(paramArrayOfByte[2].intValue() + 1);
      }
      else
      {
        paramArrayOfByte = dAZ;
        paramArrayOfByte[3] = Integer.valueOf(paramArrayOfByte[3].intValue() + 1);
      }
    }
  }
  
  public static final void jp(int paramInt)
  {
    AppMethodBeat.i(130235);
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(130235);
      return;
      c.abK();
      AppMethodBeat.o(130235);
      return;
      b.abK();
    }
  }
  
  public static final void jq(int paramInt)
  {
    AppMethodBeat.i(130236);
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(130236);
      return;
      c.abJ();
      AppMethodBeat.o(130236);
      return;
      b.abJ();
    }
  }
  
  public static final void jr(int paramInt)
  {
    AppMethodBeat.i(130237);
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(130237);
      return;
      c.abI();
      AppMethodBeat.o(130237);
      return;
      b.abI();
    }
  }
  
  public static final void js(int paramInt)
  {
    AppMethodBeat.i(130238);
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(130238);
      return;
      c.abM();
      AppMethodBeat.o(130238);
      return;
      b.abM();
    }
  }
  
  public static final void jt(int paramInt)
  {
    AppMethodBeat.i(130239);
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(130239);
      return;
      c.abN();
      AppMethodBeat.o(130239);
      return;
      b.abN();
    }
  }
  
  public static final void ju(int paramInt)
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
      if (!dBb)
      {
        dBb = true;
        c.abO();
        AppMethodBeat.o(130240);
        return;
        if (!dBb)
        {
          dBb = true;
          b.abO();
        }
      }
    }
  }
  
  public static final void jv(int paramInt)
  {
    AppMethodBeat.i(130241);
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(130241);
      return;
      c.abH();
      AppMethodBeat.o(130241);
      return;
      b.abH();
    }
  }
  
  public static final void jw(int paramInt)
  {
    AppMethodBeat.i(130242);
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(130242);
      return;
      c.abG();
      AppMethodBeat.o(130242);
      return;
      b.abG();
    }
  }
  
  public static final void jx(int paramInt)
  {
    AppMethodBeat.i(130244);
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(130244);
      return;
      c.abF();
      AppMethodBeat.o(130244);
      return;
      b.abF();
    }
  }
  
  public static final void jy(int paramInt)
  {
    AppMethodBeat.i(130249);
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(130249);
      return;
      c.abL();
      AppMethodBeat.o(130249);
      return;
      b.abL();
    }
  }
  
  public static final void jz(int paramInt)
  {
    AppMethodBeat.i(130250);
    if (dBa != 0)
    {
      Integer[] arrayOfInteger = dAZ;
      int i = 0;
      int k = arrayOfInteger.length;
      int j = 0;
      if (j < k)
      {
        int m = ((Number)arrayOfInteger[j]).intValue();
        long l = m * 100 / dBa;
        switch (paramInt)
        {
        default: 
          m = m * 100 / dBa;
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
                if (m == 0) {
                  c.aaB();
                } else if (m <= 20) {
                  c.aaC();
                } else if (m <= 40) {
                  c.aaD();
                } else if (m <= 60) {
                  c.aaE();
                } else if (m <= 80) {
                  c.aaF();
                } else if (m == 100) {
                  c.aaG();
                }
                break;
              case 1: 
                if (m == 0) {
                  c.aaH();
                } else if (m <= 20) {
                  c.aaI();
                } else if (m <= 40) {
                  c.aaJ();
                } else if (m <= 60) {
                  c.aaK();
                } else if (m <= 80) {
                  c.aaL();
                } else if (m == 100) {
                  c.aaM();
                }
                break;
              case 2: 
                if (m == 0) {
                  c.aaN();
                } else if (m <= 20) {
                  c.aaO();
                } else if (m <= 40) {
                  c.aaP();
                } else if (m <= 60) {
                  c.aaQ();
                } else if (m <= 80) {
                  c.aaR();
                } else if (m == 100) {
                  c.aaS();
                }
                break;
              case 3: 
                if (m == 0)
                {
                  c.aaT();
                }
                else if (m <= 20)
                {
                  c.aaU();
                }
                else if (m <= 40)
                {
                  c.aaV();
                }
                else if (m <= 60)
                {
                  c.aaW();
                }
                else if (m <= 80)
                {
                  c.aaX();
                }
                else if (m == 100)
                {
                  c.aaY();
                  continue;
                  switch (i)
                  {
                  default: 
                    break;
                  case 0: 
                    if (m == 0) {
                      b.aaB();
                    } else if (m <= 20) {
                      b.aaC();
                    } else if (m <= 40) {
                      b.aaD();
                    } else if (m <= 60) {
                      b.aaE();
                    } else if (m <= 80) {
                      b.aaF();
                    } else if (m <= 100) {
                      b.aaG();
                    }
                    break;
                  case 1: 
                    if (m == 0) {
                      b.aaH();
                    } else if (m <= 20) {
                      b.aaI();
                    } else if (m <= 40) {
                      b.aaJ();
                    } else if (m <= 60) {
                      b.aaK();
                    } else if (m <= 80) {
                      b.aaL();
                    } else if (m <= 100) {
                      b.aaM();
                    }
                    break;
                  case 2: 
                    if (m == 0) {
                      b.aaN();
                    } else if (m <= 20) {
                      b.aaO();
                    } else if (m <= 40) {
                      b.aaP();
                    } else if (m <= 60) {
                      b.aaQ();
                    } else if (m <= 80) {
                      b.aaR();
                    } else if (m <= 100) {
                      b.aaS();
                    }
                    break;
                  case 3: 
                    if (m == 0) {
                      b.aaT();
                    } else if (m <= 20) {
                      b.aaU();
                    } else if (m <= 40) {
                      b.aaV();
                    } else if (m <= 60) {
                      b.aaW();
                    } else if (m <= 80) {
                      b.aaX();
                    } else if (m <= 100) {
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
      dBa = 0;
      arrayOfInteger = new Integer[4];
      paramInt = 0;
      while (paramInt < 4)
      {
        arrayOfInteger[paramInt] = Integer.valueOf(0);
        paramInt += 1;
      }
      dAZ = arrayOfInteger;
    }
    AppMethodBeat.o(130250);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.audio.c.b.a
 * JD-Core Version:    0.7.0.1
 */