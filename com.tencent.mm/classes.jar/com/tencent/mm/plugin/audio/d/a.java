package com.tencent.mm.plugin.audio.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/audio/util/AudioReportUtil;", "", "()V", "ID", "", "TAG", "", "markErrorSco", "", "caller", "markIPCallUseScoError", "markMultitalkUseScoError", "markMusicUseScoError", "markOpenVoiceUseScoError", "markSenceRecordUseScoError", "markVoipCSUseScoError", "markVoipUseScoError", "reportAudioStatus", "deviceType", "", "majorClass", "deviceClass", "errorCode", "deviceName", "deviceAddress", "(ILjava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)V", "plugin-audio_release"})
public final class a
{
  private static final long rJY = 1524L;
  public static final a rJZ;
  
  static
  {
    AppMethodBeat.i(257552);
    rJZ = new a();
    rJY = 1524L;
    AppMethodBeat.o(257552);
  }
  
  public static void a(Integer paramInteger1, Integer paramInteger2, String paramString1, int paramInt, String paramString2, String paramString3)
  {
    AppMethodBeat.i(257543);
    p.k(paramString1, "caller");
    Log.i("MicroMsg.AudioReportUtil", "report audio device bt status \n deviceType: 4 " + "\n majorClass:" + paramInteger1 + "\n deviceClass:" + paramInteger2 + "\n caller:" + paramString1 + "\n errorCode:" + paramInt + "\n deviceName:" + paramString2 + "\n deviceAddress:" + paramString3);
    h.IzE.a(21246, true, true, new Object[] { Integer.valueOf(4), paramInteger1, paramInteger2, paramString1, Integer.valueOf(paramInt), paramString2, paramString3 });
    AppMethodBeat.o(257543);
  }
  
  public static void crA()
  {
    AppMethodBeat.i(257547);
    Log.i("MicroMsg.AudioReportUtil", "markMultitalkUseScoError");
    h.IzE.p(rJY, 2L, 1L);
    AppMethodBeat.o(257547);
  }
  
  public static void crB()
  {
    AppMethodBeat.i(257548);
    Log.i("MicroMsg.AudioReportUtil", "markOpenVoiceUseScoError");
    h.IzE.p(rJY, 3L, 1L);
    AppMethodBeat.o(257548);
  }
  
  public static void crC()
  {
    AppMethodBeat.i(257549);
    Log.i("MicroMsg.AudioReportUtil", "markIPCallUseScoError");
    h.IzE.p(rJY, 4L, 1L);
    AppMethodBeat.o(257549);
  }
  
  public static void crD()
  {
    AppMethodBeat.i(257550);
    Log.i("MicroMsg.AudioReportUtil", "markMusicUseScoError");
    h.IzE.p(rJY, 5L, 1L);
    AppMethodBeat.o(257550);
  }
  
  public static void crE()
  {
    AppMethodBeat.i(257551);
    Log.i("MicroMsg.AudioReportUtil", "markVoipCSUseScoError");
    h.IzE.p(rJY, 6L, 1L);
    AppMethodBeat.o(257551);
  }
  
  public static void cry()
  {
    AppMethodBeat.i(257545);
    Log.i("MicroMsg.AudioReportUtil", "markVoipUseScoError");
    h.IzE.p(rJY, 0L, 1L);
    AppMethodBeat.o(257545);
  }
  
  public static void crz()
  {
    AppMethodBeat.i(257546);
    Log.i("MicroMsg.AudioReportUtil", "markSenceRecordUseScoError");
    h.IzE.p(rJY, 1L, 1L);
    AppMethodBeat.o(257546);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.audio.d.a
 * JD-Core Version:    0.7.0.1
 */