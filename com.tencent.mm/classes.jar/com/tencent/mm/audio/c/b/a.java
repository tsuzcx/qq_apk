package com.tencent.mm.audio.c.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ac;
import d.g.b.k;
import d.l;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/audio/utils/recorder/AudioRecordReportUtil;", "", "()V", "RMS_TYPE_HIGH", "", "RMS_TYPE_LOW", "RMS_TYPE_MIDDLE", "RMS_TYPE_SILENT", "TAG", "", "checkRecordingHasMusicPlayingHasBeenReport", "", "mRMSInOneRecordProcess", "", "[Ljava/lang/Integer;", "resultSize", "byteArray2ShortArray", "", "data", "", "items", "calcDecibelLevel", "", "buffer", "readSize", "checkPCMAmplitude", "", "length", "checkRecordingHasMusicPlaying", "type", "checkZeroDataCauseHeadsetPlugged", "checkZeroDataCauseMicMute", "doAudioRecordHasBeenInitReport", "doAudioRecordKVReport", "audioType", "scenes", "featureKey", "pcmSilent", "pcmLow", "pcmMiddle", "pcmHigh", "systemSilent", "systemLow", "systemMiddle", "systemHigh", "audioSource", "mSampleRate", "mChannelConfig", "mRecordDetailState", "doAudioSourceSwitchFailedReport", "source", "doAudioSourceSwitchSuccessReport", "doAudioSourceUseErrorReport", "doAudioVolumeRecordKVReport", "doFinalAudioSourceRequstReport", "doMicroPhonesMuteReport", "doMinBufferSizeErrorReport", "doNewAudioRecordErrorReport", "doPCMRecordChecker", "doPCMRecordPercentReport", "index", "result", "", "doPCMRecordResultReport", "doRecordModeNullErrorReport", "doRecordReport", "doStartRecordErrorReport", "plugin-audiosdk_release"})
public final class a
{
  private static Integer[] cXv;
  private static int cXw;
  private static boolean cXx;
  public static final a cXy;
  
  static
  {
    AppMethodBeat.i(130251);
    cXy = new a();
    Integer[] arrayOfInteger = new Integer[4];
    int i = 0;
    while (i < 4)
    {
      arrayOfInteger[i] = Integer.valueOf(0);
      i += 1;
    }
    cXv = arrayOfInteger;
    AppMethodBeat.o(130251);
  }
  
  public static final void a(int paramInt1, String paramString, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    AppMethodBeat.i(130234);
    k.h(paramString, "featureKey");
    if (cXw != 0)
    {
      int i = cXv[0].intValue() * 100 / cXw;
      int j = cXv[1].intValue() * 100 / cXw;
      int k = cXv[2].intValue() * 100 / cXw;
      int m = cXv[3].intValue() * 100 / cXw;
      ac.i("MicroMsg.AudioRecordReportUtil", "audioType = 0 ,scenes = " + paramInt1 + ",featureKey=" + paramString + ",pcmSilent=" + i + ", pcmLow=" + j + ",pcmMiddle=" + k + ",pcmHigh=" + m + ",systemSilent=0,systemLow=0,systemMiddle=0,systemHigh=0,audioSource=" + paramInt2 + ",sampleRate=" + paramInt3 + ",mChannelConfig=" + paramInt4 + ",mRecordDetailState=" + paramInt5);
      h.wUl.a(18554, true, true, new Object[] { Integer.valueOf(0), Integer.valueOf(paramInt1), paramString, Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k), Integer.valueOf(m), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Integer.valueOf(paramInt4), Integer.valueOf(paramInt5) });
      cXx = false;
    }
    AppMethodBeat.o(130234);
  }
  
  public static final void ch(int paramInt1, int paramInt2)
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
        c.PA();
        AppMethodBeat.o(130243);
        return;
        c.PB();
      }
      switch (paramInt2)
      {
      default: 
        break;
      case 1: 
        b.PA();
        AppMethodBeat.o(130243);
        return;
      case 7: 
        b.PB();
      }
    }
  }
  
  public static final void ci(int paramInt1, int paramInt2)
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
        c.Pu();
        AppMethodBeat.o(130245);
        return;
        c.Pv();
      }
      b localb;
      switch (paramInt2)
      {
      default: 
        break;
      case 1: 
        localb = b.cXz;
        b.Pu();
        AppMethodBeat.o(130245);
        return;
      case 7: 
        localb = b.cXz;
        b.Pv();
      }
    }
  }
  
  public static final void cj(int paramInt1, int paramInt2)
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
        c.Pz();
        AppMethodBeat.o(130246);
        return;
        c.Px();
      }
      switch (paramInt2)
      {
      default: 
        break;
      case 1: 
        b.Pz();
        AppMethodBeat.o(130246);
        return;
      case 7: 
        b.Px();
      }
    }
  }
  
  public static final void ck(int paramInt1, int paramInt2)
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
        c.Py();
        AppMethodBeat.o(130247);
        return;
        c.Pw();
      }
      switch (paramInt2)
      {
      default: 
        break;
      case 1: 
        b.Py();
        AppMethodBeat.o(130247);
        return;
      case 7: 
        b.Pw();
      }
    }
  }
  
  public static final void e(int paramInt, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(130248);
    k.h(paramArrayOfByte, "data");
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
      paramArrayOfByte = cXv;
      paramArrayOfByte[0] = Integer.valueOf(paramArrayOfByte[0].intValue() + 1);
    }
    for (;;)
    {
      cXw += 1;
      AppMethodBeat.o(130248);
      return;
      label169:
      if (d < 300.0D)
      {
        paramArrayOfByte = cXv;
        paramArrayOfByte[1] = Integer.valueOf(paramArrayOfByte[1].intValue() + 1);
      }
      else if (d < 2000.0D)
      {
        paramArrayOfByte = cXv;
        paramArrayOfByte[2] = Integer.valueOf(paramArrayOfByte[2].intValue() + 1);
      }
      else
      {
        paramArrayOfByte = cXv;
        paramArrayOfByte[3] = Integer.valueOf(paramArrayOfByte[3].intValue() + 1);
      }
    }
  }
  
  public static final void hM(int paramInt)
  {
    AppMethodBeat.i(130235);
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(130235);
      return;
      c.PH();
      AppMethodBeat.o(130235);
      return;
      b.PH();
    }
  }
  
  public static final void hN(int paramInt)
  {
    AppMethodBeat.i(130236);
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(130236);
      return;
      c.PG();
      AppMethodBeat.o(130236);
      return;
      b.PG();
    }
  }
  
  public static final void hO(int paramInt)
  {
    AppMethodBeat.i(130237);
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(130237);
      return;
      c.PF();
      AppMethodBeat.o(130237);
      return;
      b.PF();
    }
  }
  
  public static final void hP(int paramInt)
  {
    AppMethodBeat.i(130238);
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(130238);
      return;
      c.PJ();
      AppMethodBeat.o(130238);
      return;
      b.PJ();
    }
  }
  
  public static final void hQ(int paramInt)
  {
    AppMethodBeat.i(130239);
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(130239);
      return;
      c.PK();
      AppMethodBeat.o(130239);
      return;
      b.PK();
    }
  }
  
  public static final void hR(int paramInt)
  {
    AppMethodBeat.i(130240);
    ac.i("MicroMsg.AudioRecordReportUtil", "current happened recording and music playing ");
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(130240);
      return;
      if (!cXx)
      {
        cXx = true;
        c.PL();
        AppMethodBeat.o(130240);
        return;
        if (!cXx)
        {
          cXx = true;
          b.PL();
        }
      }
    }
  }
  
  public static final void hS(int paramInt)
  {
    AppMethodBeat.i(130241);
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(130241);
      return;
      c.PE();
      AppMethodBeat.o(130241);
      return;
      b.PE();
    }
  }
  
  public static final void hT(int paramInt)
  {
    AppMethodBeat.i(130242);
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(130242);
      return;
      c.PD();
      AppMethodBeat.o(130242);
      return;
      b.PD();
    }
  }
  
  public static final void hU(int paramInt)
  {
    AppMethodBeat.i(130244);
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(130244);
      return;
      c.PC();
      AppMethodBeat.o(130244);
      return;
      b.PC();
    }
  }
  
  public static final void hV(int paramInt)
  {
    AppMethodBeat.i(130249);
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(130249);
      return;
      c.PI();
      AppMethodBeat.o(130249);
      return;
      b.PI();
    }
  }
  
  public static final void hW(int paramInt)
  {
    AppMethodBeat.i(130250);
    if (cXw != 0)
    {
      Integer[] arrayOfInteger = cXv;
      int i = 0;
      int k = arrayOfInteger.length;
      int j = 0;
      if (j < k)
      {
        int m = ((Number)arrayOfInteger[j]).intValue();
        long l = m * 100 / cXw;
        switch (paramInt)
        {
        default: 
          m = m * 100 / cXw;
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
                  c.Oy();
                } else if (m <= 20) {
                  c.Oz();
                } else if (m <= 40) {
                  c.OA();
                } else if (m <= 60) {
                  c.OB();
                } else if (m <= 80) {
                  c.OC();
                } else if (m == 100) {
                  c.OD();
                }
                break;
              case 1: 
                if (m == 0) {
                  c.OE();
                } else if (m <= 20) {
                  c.OF();
                } else if (m <= 40) {
                  c.OG();
                } else if (m <= 60) {
                  c.OH();
                } else if (m <= 80) {
                  c.OI();
                } else if (m == 100) {
                  c.OJ();
                }
                break;
              case 2: 
                if (m == 0) {
                  c.OK();
                } else if (m <= 20) {
                  c.OL();
                } else if (m <= 40) {
                  c.OM();
                } else if (m <= 60) {
                  c.ON();
                } else if (m <= 80) {
                  c.OO();
                } else if (m == 100) {
                  c.OP();
                }
                break;
              case 3: 
                if (m == 0)
                {
                  c.OQ();
                }
                else if (m <= 20)
                {
                  c.OR();
                }
                else if (m <= 40)
                {
                  c.OS();
                }
                else if (m <= 60)
                {
                  c.OT();
                }
                else if (m <= 80)
                {
                  c.OU();
                }
                else if (m == 100)
                {
                  c.OV();
                  continue;
                  switch (i)
                  {
                  default: 
                    break;
                  case 0: 
                    if (m == 0) {
                      b.Oy();
                    } else if (m <= 20) {
                      b.Oz();
                    } else if (m <= 40) {
                      b.OA();
                    } else if (m <= 60) {
                      b.OB();
                    } else if (m <= 80) {
                      b.OC();
                    } else if (m <= 100) {
                      b.OD();
                    }
                    break;
                  case 1: 
                    if (m == 0) {
                      b.OE();
                    } else if (m <= 20) {
                      b.OF();
                    } else if (m <= 40) {
                      b.OG();
                    } else if (m <= 60) {
                      b.OH();
                    } else if (m <= 80) {
                      b.OI();
                    } else if (m <= 100) {
                      b.OJ();
                    }
                    break;
                  case 2: 
                    if (m == 0) {
                      b.OK();
                    } else if (m <= 20) {
                      b.OL();
                    } else if (m <= 40) {
                      b.OM();
                    } else if (m <= 60) {
                      b.ON();
                    } else if (m <= 80) {
                      b.OO();
                    } else if (m <= 100) {
                      b.OP();
                    }
                    break;
                  case 3: 
                    if (m == 0) {
                      b.OQ();
                    } else if (m <= 20) {
                      b.OR();
                    } else if (m <= 40) {
                      b.OS();
                    } else if (m <= 60) {
                      b.OT();
                    } else if (m <= 80) {
                      b.OU();
                    } else if (m <= 100) {
                      b.OV();
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
      cXw = 0;
      arrayOfInteger = new Integer[4];
      paramInt = 0;
      while (paramInt < 4)
      {
        arrayOfInteger[paramInt] = Integer.valueOf(0);
        paramInt += 1;
      }
      cXv = arrayOfInteger;
    }
    AppMethodBeat.o(130250);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.audio.c.b.a
 * JD-Core Version:    0.7.0.1
 */