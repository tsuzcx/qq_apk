package com.tencent.mm.plugin.audio.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/audio/util/AudioReportUtil;", "", "()V", "ID", "", "TAG", "", "markErrorSco", "", "caller", "markIPCallUseScoError", "markMultitalkUseScoError", "markMusicUseScoError", "markOpenVoiceUseScoError", "markSenceRecordUseScoError", "markVoipCSUseScoError", "markVoipUseScoError", "reportAudioStatus", "deviceType", "", "majorClass", "deviceClass", "errorCode", "deviceName", "deviceAddress", "(ILjava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)V", "plugin-audio_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
{
  private static final long ID;
  public static final a uVn;
  
  static
  {
    AppMethodBeat.i(263779);
    uVn = new a();
    ID = 1524L;
    AppMethodBeat.o(263779);
  }
  
  public static void a(Integer paramInteger1, Integer paramInteger2, String paramString1, int paramInt, String paramString2, String paramString3)
  {
    AppMethodBeat.i(263734);
    s.u(paramString1, "caller");
    Log.i("MicroMsg.AudioReportUtil", "report audio device bt status \n deviceType: 4 \n majorClass:" + paramInteger1 + "\n deviceClass:" + paramInteger2 + "\n caller:" + paramString1 + "\n errorCode:" + paramInt + "\n deviceName:" + paramString2 + "\n deviceAddress:" + paramString3);
    h.OAn.a(21246, true, true, new Object[] { Integer.valueOf(4), paramInteger1, paramInteger2, paramString1, Integer.valueOf(paramInt), paramString2, paramString3 });
    AppMethodBeat.o(263734);
  }
  
  public static void cUi()
  {
    AppMethodBeat.i(263739);
    Log.i("MicroMsg.AudioReportUtil", "markVoipUseScoError");
    h.OAn.p(ID, 0L, 1L);
    AppMethodBeat.o(263739);
  }
  
  public static void cUj()
  {
    AppMethodBeat.i(263747);
    Log.i("MicroMsg.AudioReportUtil", "markSenceRecordUseScoError");
    h.OAn.p(ID, 1L, 1L);
    AppMethodBeat.o(263747);
  }
  
  public static void cUk()
  {
    AppMethodBeat.i(263754);
    Log.i("MicroMsg.AudioReportUtil", "markMultitalkUseScoError");
    h.OAn.p(ID, 2L, 1L);
    AppMethodBeat.o(263754);
  }
  
  public static void cUl()
  {
    AppMethodBeat.i(263761);
    Log.i("MicroMsg.AudioReportUtil", "markOpenVoiceUseScoError");
    h.OAn.p(ID, 3L, 1L);
    AppMethodBeat.o(263761);
  }
  
  public static void cUm()
  {
    AppMethodBeat.i(263765);
    Log.i("MicroMsg.AudioReportUtil", "markIPCallUseScoError");
    h.OAn.p(ID, 4L, 1L);
    AppMethodBeat.o(263765);
  }
  
  public static void cUn()
  {
    AppMethodBeat.i(263771);
    Log.i("MicroMsg.AudioReportUtil", "markMusicUseScoError");
    h.OAn.p(ID, 5L, 1L);
    AppMethodBeat.o(263771);
  }
  
  public static void cUo()
  {
    AppMethodBeat.i(263776);
    Log.i("MicroMsg.AudioReportUtil", "markVoipCSUseScoError");
    h.OAn.p(ID, 6L, 1L);
    AppMethodBeat.o(263776);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.audio.d.a
 * JD-Core Version:    0.7.0.1
 */