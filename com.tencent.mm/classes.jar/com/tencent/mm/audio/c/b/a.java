package com.tencent.mm.audio.c.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ad;
import d.g.b.k;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/audio/utils/recorder/AudioRecordReportUtil;", "", "()V", "RMS_TYPE_HIGH", "", "RMS_TYPE_LOW", "RMS_TYPE_MIDDLE", "RMS_TYPE_SILENT", "TAG", "", "checkRecordingHasMusicPlayingHasBeenReport", "", "mRMSInOneRecordProcess", "", "[Ljava/lang/Integer;", "resultSize", "byteArray2ShortArray", "", "data", "", "items", "calcDecibelLevel", "", "buffer", "readSize", "checkPCMAmplitude", "", "length", "checkRecordingHasMusicPlaying", "type", "checkZeroDataCauseHeadsetPlugged", "checkZeroDataCauseMicMute", "doAudioRecordHasBeenInitReport", "doAudioRecordKVReport", "audioType", "scenes", "featureKey", "pcmSilent", "pcmLow", "pcmMiddle", "pcmHigh", "systemSilent", "systemLow", "systemMiddle", "systemHigh", "audioSource", "mSampleRate", "mChannelConfig", "mRecordDetailState", "doAudioSourceSwitchFailedReport", "source", "doAudioSourceSwitchSuccessReport", "doAudioSourceUseErrorReport", "doAudioVolumeRecordKVReport", "doFinalAudioSourceRequstReport", "doMicroPhonesMuteReport", "doMinBufferSizeErrorReport", "doNewAudioRecordErrorReport", "doPCMRecordChecker", "doPCMRecordPercentReport", "index", "result", "", "doPCMRecordResultReport", "doRecordModeNullErrorReport", "doRecordReport", "doStartRecordErrorReport", "plugin-audiosdk_release"})
public final class a
{
  private static Integer[] cZZ;
  private static int daa;
  private static boolean dab;
  public static final a dac;
  
  static
  {
    AppMethodBeat.i(130251);
    dac = new a();
    Integer[] arrayOfInteger = new Integer[4];
    int i = 0;
    while (i < 4)
    {
      arrayOfInteger[i] = Integer.valueOf(0);
      i += 1;
    }
    cZZ = arrayOfInteger;
    AppMethodBeat.o(130251);
  }
  
  public static final void a(int paramInt1, String paramString, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    AppMethodBeat.i(130234);
    k.h(paramString, "featureKey");
    if (daa != 0)
    {
      int i = cZZ[0].intValue() * 100 / daa;
      int j = cZZ[1].intValue() * 100 / daa;
      int k = cZZ[2].intValue() * 100 / daa;
      int m = cZZ[3].intValue() * 100 / daa;
      ad.i("MicroMsg.AudioRecordReportUtil", "audioType = 0 ,scenes = " + paramInt1 + ",featureKey=" + paramString + ",pcmSilent=" + i + ", pcmLow=" + j + ",pcmMiddle=" + k + ",pcmHigh=" + m + ",systemSilent=0,systemLow=0,systemMiddle=0,systemHigh=0,audioSource=" + paramInt2 + ",sampleRate=" + paramInt3 + ",mChannelConfig=" + paramInt4 + ",mRecordDetailState=" + paramInt5);
      h.vKh.a(18554, true, true, new Object[] { Integer.valueOf(0), Integer.valueOf(paramInt1), paramString, Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k), Integer.valueOf(m), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Integer.valueOf(paramInt4), Integer.valueOf(paramInt5) });
      dab = false;
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
      }
      for (;;)
      {
        AppMethodBeat.o(130243);
        return;
        c.PE();
        AppMethodBeat.o(130243);
        return;
        c.PF();
      }
      switch (paramInt2)
      {
      default: 
        break;
      case 1: 
        b.PE();
        AppMethodBeat.o(130243);
        return;
      case 7: 
        b.PF();
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
      }
      for (;;)
      {
        AppMethodBeat.o(130245);
        return;
        c.Py();
        AppMethodBeat.o(130245);
        return;
        c.Pz();
      }
      b localb;
      switch (paramInt2)
      {
      default: 
        break;
      case 1: 
        localb = b.dad;
        b.Py();
        AppMethodBeat.o(130245);
        return;
      case 7: 
        localb = b.dad;
        b.Pz();
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
      }
      for (;;)
      {
        AppMethodBeat.o(130246);
        return;
        c.PD();
        AppMethodBeat.o(130246);
        return;
        c.PB();
      }
      switch (paramInt2)
      {
      default: 
        break;
      case 1: 
        b.PD();
        AppMethodBeat.o(130246);
        return;
      case 7: 
        b.PB();
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
      }
      for (;;)
      {
        AppMethodBeat.o(130247);
        return;
        c.PC();
        AppMethodBeat.o(130247);
        return;
        c.PA();
      }
      switch (paramInt2)
      {
      default: 
        break;
      case 1: 
        b.PC();
        AppMethodBeat.o(130247);
        return;
      case 7: 
        b.PA();
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
      paramArrayOfByte = cZZ;
      paramArrayOfByte[0] = Integer.valueOf(paramArrayOfByte[0].intValue() + 1);
    }
    for (;;)
    {
      daa += 1;
      AppMethodBeat.o(130248);
      return;
      label169:
      if (d < 300.0D)
      {
        paramArrayOfByte = cZZ;
        paramArrayOfByte[1] = Integer.valueOf(paramArrayOfByte[1].intValue() + 1);
      }
      else if (d < 2000.0D)
      {
        paramArrayOfByte = cZZ;
        paramArrayOfByte[2] = Integer.valueOf(paramArrayOfByte[2].intValue() + 1);
      }
      else
      {
        paramArrayOfByte = cZZ;
        paramArrayOfByte[3] = Integer.valueOf(paramArrayOfByte[3].intValue() + 1);
      }
    }
  }
  
  public static final void ic(int paramInt)
  {
    AppMethodBeat.i(130235);
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(130235);
      return;
      c.PL();
      AppMethodBeat.o(130235);
      return;
      b.PL();
    }
  }
  
  public static final void id(int paramInt)
  {
    AppMethodBeat.i(130236);
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(130236);
      return;
      c.PK();
      AppMethodBeat.o(130236);
      return;
      b.PK();
    }
  }
  
  public static final void ie(int paramInt)
  {
    AppMethodBeat.i(130237);
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(130237);
      return;
      c.PJ();
      AppMethodBeat.o(130237);
      return;
      b.PJ();
    }
  }
  
  public static final void jdMethod_if(int paramInt)
  {
    AppMethodBeat.i(130238);
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(130238);
      return;
      c.PN();
      AppMethodBeat.o(130238);
      return;
      b.PN();
    }
  }
  
  public static final void ig(int paramInt)
  {
    AppMethodBeat.i(130239);
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(130239);
      return;
      c.PO();
      AppMethodBeat.o(130239);
      return;
      b.PO();
    }
  }
  
  public static final void ih(int paramInt)
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
      if (!dab)
      {
        dab = true;
        c.PP();
        AppMethodBeat.o(130240);
        return;
        if (!dab)
        {
          dab = true;
          b.PP();
        }
      }
    }
  }
  
  public static final void ii(int paramInt)
  {
    AppMethodBeat.i(130241);
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(130241);
      return;
      c.PI();
      AppMethodBeat.o(130241);
      return;
      b.PI();
    }
  }
  
  public static final void ij(int paramInt)
  {
    AppMethodBeat.i(130242);
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(130242);
      return;
      c.PH();
      AppMethodBeat.o(130242);
      return;
      b.PH();
    }
  }
  
  public static final void ik(int paramInt)
  {
    AppMethodBeat.i(130244);
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(130244);
      return;
      c.PG();
      AppMethodBeat.o(130244);
      return;
      b.PG();
    }
  }
  
  public static final void il(int paramInt)
  {
    AppMethodBeat.i(130249);
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(130249);
      return;
      c.PM();
      AppMethodBeat.o(130249);
      return;
      b.PM();
    }
  }
  
  public static final void im(int paramInt)
  {
    AppMethodBeat.i(130250);
    if (daa != 0)
    {
      Integer[] arrayOfInteger = cZZ;
      int i = 0;
      int k = arrayOfInteger.length;
      int j = 0;
      if (j < k)
      {
        int m = ((Number)arrayOfInteger[j]).intValue();
        long l = m * 100 / daa;
        switch (paramInt)
        {
        default: 
          m = m * 100 / daa;
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
            c.bi(l);
            break;
          case 1: 
            c.bj(l);
            break;
          case 2: 
            c.bk(l);
            break;
          case 3: 
            c.bl(l);
            break;
            switch (i)
            {
            default: 
              break;
            case 0: 
              b.bi(l);
              break;
            case 1: 
              b.bj(l);
              break;
            case 2: 
              b.bk(l);
              break;
            case 3: 
              b.bl(l);
              break;
              switch (i)
              {
              default: 
                break;
              case 0: 
                if (m == 0) {
                  c.OC();
                } else if (m <= 20) {
                  c.OD();
                } else if (m <= 40) {
                  c.OE();
                } else if (m <= 60) {
                  c.OF();
                } else if (m <= 80) {
                  c.OG();
                } else if (m == 100) {
                  c.OH();
                }
                break;
              case 1: 
                if (m == 0) {
                  c.OI();
                } else if (m <= 20) {
                  c.OJ();
                } else if (m <= 40) {
                  c.OK();
                } else if (m <= 60) {
                  c.OL();
                } else if (m <= 80) {
                  c.OM();
                } else if (m == 100) {
                  c.ON();
                }
                break;
              case 2: 
                if (m == 0) {
                  c.OO();
                } else if (m <= 20) {
                  c.OP();
                } else if (m <= 40) {
                  c.OQ();
                } else if (m <= 60) {
                  c.OR();
                } else if (m <= 80) {
                  c.OS();
                } else if (m == 100) {
                  c.OT();
                }
                break;
              case 3: 
                if (m == 0)
                {
                  c.OU();
                }
                else if (m <= 20)
                {
                  c.OV();
                }
                else if (m <= 40)
                {
                  c.OW();
                }
                else if (m <= 60)
                {
                  c.OX();
                }
                else if (m <= 80)
                {
                  c.OY();
                }
                else if (m == 100)
                {
                  c.OZ();
                  continue;
                  switch (i)
                  {
                  default: 
                    break;
                  case 0: 
                    if (m == 0) {
                      b.OC();
                    } else if (m <= 20) {
                      b.OD();
                    } else if (m <= 40) {
                      b.OE();
                    } else if (m <= 60) {
                      b.OF();
                    } else if (m <= 80) {
                      b.OG();
                    } else if (m <= 100) {
                      b.OH();
                    }
                    break;
                  case 1: 
                    if (m == 0) {
                      b.OI();
                    } else if (m <= 20) {
                      b.OJ();
                    } else if (m <= 40) {
                      b.OK();
                    } else if (m <= 60) {
                      b.OL();
                    } else if (m <= 80) {
                      b.OM();
                    } else if (m <= 100) {
                      b.ON();
                    }
                    break;
                  case 2: 
                    if (m == 0) {
                      b.OO();
                    } else if (m <= 20) {
                      b.OP();
                    } else if (m <= 40) {
                      b.OQ();
                    } else if (m <= 60) {
                      b.OR();
                    } else if (m <= 80) {
                      b.OS();
                    } else if (m <= 100) {
                      b.OT();
                    }
                    break;
                  case 3: 
                    if (m == 0) {
                      b.OU();
                    } else if (m <= 20) {
                      b.OV();
                    } else if (m <= 40) {
                      b.OW();
                    } else if (m <= 60) {
                      b.OX();
                    } else if (m <= 80) {
                      b.OY();
                    } else if (m <= 100) {
                      b.OZ();
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
      daa = 0;
      arrayOfInteger = new Integer[4];
      paramInt = 0;
      while (paramInt < 4)
      {
        arrayOfInteger[paramInt] = Integer.valueOf(0);
        paramInt += 1;
      }
      cZZ = arrayOfInteger;
    }
    AppMethodBeat.o(130250);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.audio.c.b.a
 * JD-Core Version:    0.7.0.1
 */