package com.tencent.mm.audio.c.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/audio/utils/recorder/AudioRecordReportUtil;", "", "()V", "RMS_TYPE_HIGH", "", "RMS_TYPE_LOW", "RMS_TYPE_MIDDLE", "RMS_TYPE_SILENT", "TAG", "", "checkRecordingHasMusicPlayingHasBeenReport", "", "mRMSInOneRecordProcess", "", "[Ljava/lang/Integer;", "resultSize", "byteArray2ShortArray", "", "data", "", "items", "calcDecibelLevel", "", "buffer", "readSize", "checkPCMAmplitude", "", "length", "checkRecordingHasMusicPlaying", "type", "checkZeroDataCauseHeadsetPlugged", "checkZeroDataCauseMicMute", "doAudioRecordHasBeenInitReport", "doAudioRecordKVReport", "audioType", "scenes", "featureKey", "pcmSilent", "pcmLow", "pcmMiddle", "pcmHigh", "systemSilent", "systemLow", "systemMiddle", "systemHigh", "audioSource", "mSampleRate", "mChannelConfig", "mRecordDetailState", "doAudioSourceSwitchFailedReport", "source", "doAudioSourceSwitchSuccessReport", "doAudioSourceUseErrorReport", "doAudioVolumeRecordKVReport", "doFinalAudioSourceRequstReport", "doMicroPhonesMuteReport", "doMinBufferSizeErrorReport", "doNewAudioRecordErrorReport", "doPCMRecordChecker", "doPCMRecordPercentReport", "index", "result", "", "doPCMRecordResultReport", "doRecordModeNullErrorReport", "doRecordReport", "doStartRecordErrorReport", "plugin-audiosdk_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
{
  public static final a hyd;
  private static Integer[] hye;
  private static int hyf;
  private static boolean hyg;
  
  static
  {
    AppMethodBeat.i(130251);
    hyd = new a();
    Integer[] arrayOfInteger = new Integer[4];
    int i = 0;
    while (i < 4)
    {
      arrayOfInteger[i] = Integer.valueOf(0);
      i += 1;
    }
    hye = arrayOfInteger;
    AppMethodBeat.o(130251);
  }
  
  public static final void a(int paramInt1, String paramString, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    AppMethodBeat.i(130234);
    s.u(paramString, "featureKey");
    if (hyf != 0)
    {
      int i = hye[0].intValue() * 100 / hyf;
      int j = hye[1].intValue() * 100 / hyf;
      int k = hye[2].intValue() * 100 / hyf;
      int m = hye[3].intValue() * 100 / hyf;
      Log.i("MicroMsg.AudioRecordReportUtil", "audioType = 0 ,scenes = " + paramInt1 + ",featureKey=" + paramString + ",pcmSilent=" + i + ", pcmLow=" + j + ",pcmMiddle=" + k + ",pcmHigh=" + m + ",systemSilent=0,systemLow=0,systemMiddle=0,systemHigh=0,audioSource=" + paramInt2 + ",sampleRate=" + paramInt3 + ",mChannelConfig=" + paramInt4 + ",mRecordDetailState=" + paramInt5);
      h.OAn.a(18554, true, true, new Object[] { Integer.valueOf(0), Integer.valueOf(paramInt1), paramString, Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k), Integer.valueOf(m), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Integer.valueOf(paramInt4), Integer.valueOf(paramInt5) });
      hyg = false;
    }
    AppMethodBeat.o(130234);
  }
  
  public static final void dt(int paramInt1, int paramInt2)
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
      }
      for (;;)
      {
        AppMethodBeat.o(130243);
        return;
        c.aIn();
        AppMethodBeat.o(130243);
        return;
        c.aIo();
      }
      switch (paramInt2)
      {
      default: 
        break;
      case 1: 
        b.aIn();
        AppMethodBeat.o(130243);
        return;
      case 7: 
        b.aIo();
      }
    }
  }
  
  public static final void du(int paramInt1, int paramInt2)
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
      }
      for (;;)
      {
        AppMethodBeat.o(130245);
        return;
        c.aIh();
        AppMethodBeat.o(130245);
        return;
        c.aIi();
      }
      b localb;
      switch (paramInt2)
      {
      default: 
        break;
      case 1: 
        localb = b.hyh;
        b.aIh();
        AppMethodBeat.o(130245);
        return;
      case 7: 
        localb = b.hyh;
        b.aIi();
      }
    }
  }
  
  public static final void dv(int paramInt1, int paramInt2)
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
      }
      for (;;)
      {
        AppMethodBeat.o(130246);
        return;
        c.aIm();
        AppMethodBeat.o(130246);
        return;
        c.aIk();
      }
      switch (paramInt2)
      {
      default: 
        break;
      case 1: 
        b.aIm();
        AppMethodBeat.o(130246);
        return;
      case 7: 
        b.aIk();
      }
    }
  }
  
  public static final void dw(int paramInt1, int paramInt2)
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
      }
      for (;;)
      {
        AppMethodBeat.o(130247);
        return;
        c.aIl();
        AppMethodBeat.o(130247);
        return;
        c.aIj();
      }
      switch (paramInt2)
      {
      default: 
        break;
      case 1: 
        b.aIl();
        AppMethodBeat.o(130247);
        return;
      case 7: 
        b.aIj();
      }
    }
  }
  
  public static final void e(int paramInt, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(130248);
    s.u(paramArrayOfByte, "data");
    short[] arrayOfShort;
    int k;
    if (paramInt != 0)
    {
      arrayOfShort = new short[paramInt / 2];
      k = arrayOfShort.length - 1;
      if (k < 0) {}
    }
    int j;
    for (int i = 0;; i = j)
    {
      j = i + 1;
      arrayOfShort[i] = ((short)(paramArrayOfByte[(i * 2)] & 0xFF | (paramArrayOfByte[(i * 2 + 1)] & 0xFF) << 8));
      if (j > k)
      {
        i = paramInt / 2;
        double d = 0.0D;
        j = arrayOfShort.length;
        paramInt = 0;
        while (paramInt < j)
        {
          k = arrayOfShort[paramInt];
          paramInt += 1;
          d += k * k;
        }
        d = Math.sqrt(d / i);
        if (d < 50.0D)
        {
          paramArrayOfByte = hye;
          paramArrayOfByte[0] = Integer.valueOf(paramArrayOfByte[0].intValue() + 1);
        }
        for (;;)
        {
          hyf += 1;
          AppMethodBeat.o(130248);
          return;
          if (d < 300.0D)
          {
            paramArrayOfByte = hye;
            paramArrayOfByte[1] = Integer.valueOf(paramArrayOfByte[1].intValue() + 1);
          }
          else if (d < 2000.0D)
          {
            paramArrayOfByte = hye;
            paramArrayOfByte[2] = Integer.valueOf(paramArrayOfByte[2].intValue() + 1);
          }
          else
          {
            paramArrayOfByte = hye;
            paramArrayOfByte[3] = Integer.valueOf(paramArrayOfByte[3].intValue() + 1);
          }
        }
      }
    }
  }
  
  public static final void oA(int paramInt)
  {
    AppMethodBeat.i(130250);
    if (hyf != 0)
    {
      Integer[] arrayOfInteger = hye;
      int i = 0;
      int k = arrayOfInteger.length;
      int j = 0;
      if (j < k)
      {
        int m = ((Number)arrayOfInteger[j]).intValue();
        long l = m * 100 / hyf;
        switch (paramInt)
        {
        default: 
          m = m * 100 / hyf;
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
                if (m == 0) {
                  c.aHl();
                } else if (m <= 20) {
                  c.aHm();
                } else if (m <= 40) {
                  c.aHn();
                } else if (m <= 60) {
                  c.aHo();
                } else if (m <= 80) {
                  c.aHp();
                } else if (m == 100) {
                  c.aHq();
                }
                break;
              case 1: 
                if (m == 0) {
                  c.aHr();
                } else if (m <= 20) {
                  c.aHs();
                } else if (m <= 40) {
                  c.aHt();
                } else if (m <= 60) {
                  c.aHu();
                } else if (m <= 80) {
                  c.aHv();
                } else if (m == 100) {
                  c.aHw();
                }
                break;
              case 2: 
                if (m == 0) {
                  c.aHx();
                } else if (m <= 20) {
                  c.aHy();
                } else if (m <= 40) {
                  c.aHz();
                } else if (m <= 60) {
                  c.aHA();
                } else if (m <= 80) {
                  c.aHB();
                } else if (m == 100) {
                  c.aHC();
                }
                break;
              case 3: 
                if (m == 0)
                {
                  c.aHD();
                }
                else if (m <= 20)
                {
                  c.aHE();
                }
                else if (m <= 40)
                {
                  c.aHF();
                }
                else if (m <= 60)
                {
                  c.aHG();
                }
                else if (m <= 80)
                {
                  c.aHH();
                }
                else if (m == 100)
                {
                  c.aHI();
                  continue;
                  switch (i)
                  {
                  default: 
                    break;
                  case 0: 
                    if (m == 0) {
                      b.aHl();
                    } else if (m <= 20) {
                      b.aHm();
                    } else if (m <= 40) {
                      b.aHn();
                    } else if (m <= 60) {
                      b.aHo();
                    } else if (m <= 80) {
                      b.aHp();
                    } else if (m <= 100) {
                      b.aHq();
                    }
                    break;
                  case 1: 
                    if (m == 0) {
                      b.aHr();
                    } else if (m <= 20) {
                      b.aHs();
                    } else if (m <= 40) {
                      b.aHt();
                    } else if (m <= 60) {
                      b.aHu();
                    } else if (m <= 80) {
                      b.aHv();
                    } else if (m <= 100) {
                      b.aHw();
                    }
                    break;
                  case 2: 
                    if (m == 0) {
                      b.aHx();
                    } else if (m <= 20) {
                      b.aHy();
                    } else if (m <= 40) {
                      b.aHz();
                    } else if (m <= 60) {
                      b.aHA();
                    } else if (m <= 80) {
                      b.aHB();
                    } else if (m <= 100) {
                      b.aHC();
                    }
                    break;
                  case 3: 
                    if (m == 0) {
                      b.aHD();
                    } else if (m <= 20) {
                      b.aHE();
                    } else if (m <= 40) {
                      b.aHF();
                    } else if (m <= 60) {
                      b.aHG();
                    } else if (m <= 80) {
                      b.aHH();
                    } else if (m <= 100) {
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
      hyf = 0;
      paramInt = 0;
      arrayOfInteger = new Integer[4];
      while (paramInt < 4)
      {
        arrayOfInteger[paramInt] = Integer.valueOf(0);
        paramInt += 1;
      }
      hye = arrayOfInteger;
    }
    AppMethodBeat.o(130250);
  }
  
  public static final void oq(int paramInt)
  {
    AppMethodBeat.i(130235);
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(130235);
      return;
      c.aIu();
      AppMethodBeat.o(130235);
      return;
      b.aIu();
    }
  }
  
  public static final void or(int paramInt)
  {
    AppMethodBeat.i(130236);
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(130236);
      return;
      c.aIt();
      AppMethodBeat.o(130236);
      return;
      b.aIt();
    }
  }
  
  public static final void os(int paramInt)
  {
    AppMethodBeat.i(130237);
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(130237);
      return;
      c.aIs();
      AppMethodBeat.o(130237);
      return;
      b.aIs();
    }
  }
  
  public static final void ot(int paramInt)
  {
    AppMethodBeat.i(130238);
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(130238);
      return;
      c.aIw();
      AppMethodBeat.o(130238);
      return;
      b.aIw();
    }
  }
  
  public static final void ou(int paramInt)
  {
    AppMethodBeat.i(130239);
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(130239);
      return;
      c.aIx();
      AppMethodBeat.o(130239);
      return;
      b.aIx();
    }
  }
  
  public static final void ov(int paramInt)
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
      if (!hyg)
      {
        hyg = true;
        c.aIy();
        AppMethodBeat.o(130240);
        return;
        if (!hyg)
        {
          hyg = true;
          b.aIy();
        }
      }
    }
  }
  
  public static final void ow(int paramInt)
  {
    AppMethodBeat.i(130241);
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(130241);
      return;
      c.aIr();
      AppMethodBeat.o(130241);
      return;
      b.aIr();
    }
  }
  
  public static final void ox(int paramInt)
  {
    AppMethodBeat.i(130242);
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(130242);
      return;
      c.aIq();
      AppMethodBeat.o(130242);
      return;
      b.aIq();
    }
  }
  
  public static final void oy(int paramInt)
  {
    AppMethodBeat.i(130244);
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(130244);
      return;
      c.aIp();
      AppMethodBeat.o(130244);
      return;
      b.aIp();
    }
  }
  
  public static final void oz(int paramInt)
  {
    AppMethodBeat.i(130249);
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(130249);
      return;
      c.aIv();
      AppMethodBeat.o(130249);
      return;
      b.aIv();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.tencent.mm.audio.c.b.a
 * JD-Core Version:    0.7.0.1
 */