package com.tencent.mm.plugin.audio.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/audio/util/AudioReportUtil;", "", "()V", "ID", "", "TAG", "", "markErrorSco", "", "caller", "markIPCallUseScoError", "markMultitalkUseScoError", "markMusicUseScoError", "markOpenVoiceUseScoError", "markSenceRecordUseScoError", "markVoipCSUseScoError", "markVoipUseScoError", "reportAudioStatus", "deviceType", "", "majorClass", "deviceClass", "errorCode", "deviceName", "deviceAddress", "(ILjava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)V", "plugin-audio_release"})
public final class a
{
  private static final long oIi = 1524L;
  public static final a oIj;
  
  static
  {
    AppMethodBeat.i(224011);
    oIj = new a();
    oIi = 1524L;
    AppMethodBeat.o(224011);
  }
  
  public static void a(Integer paramInteger1, Integer paramInteger2, String paramString1, int paramInt, String paramString2, String paramString3)
  {
    AppMethodBeat.i(224003);
    p.h(paramString1, "caller");
    Log.i("MicroMsg.AudioReportUtil", "report audio device bt status \n deviceType: 4 " + "\n majorClass:" + paramInteger1 + "\n deviceClass:" + paramInteger2 + "\n caller:" + paramString1 + "\n errorCode:" + paramInt + "\n deviceName:" + paramString2 + "\n deviceAddress:" + paramString3);
    h.CyF.a(21246, true, true, new Object[] { Integer.valueOf(4), paramInteger1, paramInteger2, paramString1, Integer.valueOf(paramInt), paramString2, paramString3 });
    AppMethodBeat.o(224003);
  }
  
  public static void cel()
  {
    AppMethodBeat.i(224004);
    Log.i("MicroMsg.AudioReportUtil", "markVoipUseScoError");
    h.CyF.n(oIi, 0L, 1L);
    AppMethodBeat.o(224004);
  }
  
  public static void cem()
  {
    AppMethodBeat.i(224005);
    Log.i("MicroMsg.AudioReportUtil", "markSenceRecordUseScoError");
    h.CyF.n(oIi, 1L, 1L);
    AppMethodBeat.o(224005);
  }
  
  public static void cen()
  {
    AppMethodBeat.i(224006);
    Log.i("MicroMsg.AudioReportUtil", "markMultitalkUseScoError");
    h.CyF.n(oIi, 2L, 1L);
    AppMethodBeat.o(224006);
  }
  
  public static void ceo()
  {
    AppMethodBeat.i(224007);
    Log.i("MicroMsg.AudioReportUtil", "markOpenVoiceUseScoError");
    h.CyF.n(oIi, 3L, 1L);
    AppMethodBeat.o(224007);
  }
  
  public static void cep()
  {
    AppMethodBeat.i(224008);
    Log.i("MicroMsg.AudioReportUtil", "markIPCallUseScoError");
    h.CyF.n(oIi, 4L, 1L);
    AppMethodBeat.o(224008);
  }
  
  public static void ceq()
  {
    AppMethodBeat.i(224009);
    Log.i("MicroMsg.AudioReportUtil", "markMusicUseScoError");
    h.CyF.n(oIi, 5L, 1L);
    AppMethodBeat.o(224009);
  }
  
  public static void cer()
  {
    AppMethodBeat.i(224010);
    Log.i("MicroMsg.AudioReportUtil", "markVoipCSUseScoError");
    h.CyF.n(oIi, 6L, 1L);
    AppMethodBeat.o(224010);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.audio.d.a
 * JD-Core Version:    0.7.0.1
 */