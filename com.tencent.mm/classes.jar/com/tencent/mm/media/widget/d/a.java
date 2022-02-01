package com.tencent.mm.media.widget.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/media/widget/util/Camera2ProcessIDKeyStat;", "", "()V", "ID", "", "KV_ID", "", "TAG", "", "markCamera2Open", "", "markCamera2OpenFailed", "markCamera2OpenSuccess", "markCamera2Release", "markCamera2SupportEXTERNAL", "markCamera2SupportFULL", "markCamera2SupportLEGACY", "markCamera2SupportLEVEL3", "markCamera2SupportLIMITED", "markCamera2TakePhotoBack", "markCamera2TakePhotoBackError", "markCamera2TakePhotoFront", "markCamera2TakePhotoFrontError", "markCamera2TakePhotoUseHDRSystem", "markCamera2UseEISSystem", "markCamera2UseOISSystem", "markCamera2UseRecordStream", "markCameraNumberAllBeenRemove", "markCameraNumberHasOne", "markCameraNumberHasTwo", "markCameraNumberMoreThanTwo", "markCameraQueryFail", "markCaptureSuccessUseImageBack", "markCaptureSuccessUseImageFront", "markCaptureUseImageCostTimes", "times", "markCaptureUseImageCostTimesBack", "markCaptureUseImageCostTimesFront", "markCaptureUseImageSuccess", "markErrorFindImage", "markErrorFindPreview", "markImageAvailable", "markReportCamera2Info", "numbers", "supportLevels", "levelDiffCameras", "frontLevel", "backLevel", "frontCameraNumber", "backCameraNumber", "markSupportLevelDiffCameras", "plugin-mediaeditor_release"})
public final class a
{
  public static final a lim;
  
  static
  {
    AppMethodBeat.i(261233);
    lim = new a();
    AppMethodBeat.o(261233);
  }
  
  public static void Gd(long paramLong)
  {
    AppMethodBeat.i(261218);
    Log.i("MicroMsg.Camera2ProcessIDKeyStat", "markCaptureUseImageCostTimesFront ".concat(String.valueOf(paramLong)));
    h.IzE.p(1099L, 24L, paramLong);
    AppMethodBeat.o(261218);
  }
  
  public static void Ge(long paramLong)
  {
    AppMethodBeat.i(261219);
    Log.i("MicroMsg.Camera2ProcessIDKeyStat", "markCaptureUseImageCostTimesBack ".concat(String.valueOf(paramLong)));
    h.IzE.p(1099L, 25L, paramLong);
    AppMethodBeat.o(261219);
  }
  
  public static void a(int paramInt1, String paramString1, int paramInt2, String paramString2, String paramString3, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(261229);
    p.k(paramString1, "supportLevels");
    p.k(paramString2, "frontLevel");
    p.k(paramString3, "backLevel");
    Log.i("MicroMsg.Camera2ProcessIDKeyStat", "markReportCamera2Info " + paramInt1 + ',' + paramString1 + ',' + paramInt2 + ',' + paramString2 + ',' + paramString3 + ',' + paramInt3 + ',' + paramInt4);
    h.IzE.a(22109, new Object[] { Integer.valueOf(paramInt1), paramString1, Integer.valueOf(paramInt2), paramString2, paramString3, Integer.valueOf(paramInt3), Integer.valueOf(paramInt4) });
    AppMethodBeat.o(261229);
  }
  
  public static void aZU()
  {
    AppMethodBeat.i(261173);
    Log.i("MicroMsg.Camera2ProcessIDKeyStat", "markCamera2Open");
    h.IzE.p(1099L, 0L, 1L);
    AppMethodBeat.o(261173);
  }
  
  public static void aZV()
  {
    AppMethodBeat.i(261175);
    Log.i("MicroMsg.Camera2ProcessIDKeyStat", "markCamera2OpenSuccess");
    h.IzE.p(1099L, 1L, 1L);
    AppMethodBeat.o(261175);
  }
  
  public static void aZW()
  {
    AppMethodBeat.i(261176);
    Log.i("MicroMsg.Camera2ProcessIDKeyStat", "markCamera2OpenFailed");
    h.IzE.p(1099L, 2L, 1L);
    AppMethodBeat.o(261176);
  }
  
  public static void aZX()
  {
    AppMethodBeat.i(261179);
    Log.i("MicroMsg.Camera2ProcessIDKeyStat", "markCamera2Release");
    h.IzE.p(1099L, 3L, 1L);
    AppMethodBeat.o(261179);
  }
  
  public static void aZY()
  {
    AppMethodBeat.i(261183);
    Log.i("MicroMsg.Camera2ProcessIDKeyStat", "markCamera2TakePhotoFront");
    h.IzE.p(1099L, 4L, 1L);
    AppMethodBeat.o(261183);
  }
  
  public static void aZZ()
  {
    AppMethodBeat.i(261185);
    Log.i("MicroMsg.Camera2ProcessIDKeyStat", "markCamera2TakePhotoBack");
    h.IzE.p(1099L, 5L, 1L);
    AppMethodBeat.o(261185);
  }
  
  public static void baa()
  {
    AppMethodBeat.i(261189);
    Log.i("MicroMsg.Camera2ProcessIDKeyStat", "markCamera2TakePhotoBackError");
    h.IzE.p(1099L, 6L, 1L);
    AppMethodBeat.o(261189);
  }
  
  public static void bab()
  {
    AppMethodBeat.i(261191);
    Log.i("MicroMsg.Camera2ProcessIDKeyStat", "markCamera2TakePhotoBackError");
    com.tencent.mm.compatible.d.a locala = com.tencent.mm.compatible.d.a.jnF;
    com.tencent.mm.compatible.d.a.v(1099L, 7L);
    AppMethodBeat.o(261191);
  }
  
  public static void bac()
  {
    AppMethodBeat.i(261194);
    Log.i("MicroMsg.Camera2ProcessIDKeyStat", "markCamera2UseOISSystem");
    h.IzE.p(1099L, 9L, 1L);
    AppMethodBeat.o(261194);
  }
  
  public static void bad()
  {
    AppMethodBeat.i(261197);
    Log.i("MicroMsg.Camera2ProcessIDKeyStat", "markErrorFindImage");
    h.IzE.p(1099L, 12L, 1L);
    AppMethodBeat.o(261197);
  }
  
  public static void bae()
  {
    AppMethodBeat.i(261199);
    Log.i("MicroMsg.Camera2ProcessIDKeyStat", "markImageAvailable");
    h.IzE.p(1099L, 13L, 1L);
    AppMethodBeat.o(261199);
  }
  
  public static void baf()
  {
    AppMethodBeat.i(261202);
    Log.i("MicroMsg.Camera2ProcessIDKeyStat", "markCaptureSuccessUseImageBack");
    h.IzE.p(1099L, 14L, 1L);
    AppMethodBeat.o(261202);
  }
  
  public static void bag()
  {
    AppMethodBeat.i(261204);
    Log.i("MicroMsg.Camera2ProcessIDKeyStat", "markCaptureSuccessUseImageFront");
    h.IzE.p(1099L, 15L, 1L);
    AppMethodBeat.o(261204);
  }
  
  public static void bah()
  {
    AppMethodBeat.i(261206);
    Log.i("MicroMsg.Camera2ProcessIDKeyStat", "markCaptureUseImageSuccess");
    h.IzE.p(1099L, 16L, 1L);
    AppMethodBeat.o(261206);
  }
  
  public static void bai()
  {
    AppMethodBeat.i(261208);
    Log.i("MicroMsg.Camera2ProcessIDKeyStat", "markCamera2UseRecordStream");
    h.IzE.p(1099L, 18L, 1L);
    AppMethodBeat.o(261208);
  }
  
  public static void baj()
  {
    AppMethodBeat.i(261210);
    Log.i("MicroMsg.Camera2ProcessIDKeyStat", "markCamera2SupportLIMITED");
    h.IzE.p(1099L, 19L, 1L);
    AppMethodBeat.o(261210);
  }
  
  public static void bak()
  {
    AppMethodBeat.i(261211);
    Log.i("MicroMsg.Camera2ProcessIDKeyStat", "markCamera2SupportFULL");
    h.IzE.p(1099L, 20L, 1L);
    AppMethodBeat.o(261211);
  }
  
  public static void bal()
  {
    AppMethodBeat.i(261213);
    Log.i("MicroMsg.Camera2ProcessIDKeyStat", "markCamera2SupportLEGACY");
    h.IzE.p(1099L, 21L, 1L);
    AppMethodBeat.o(261213);
  }
  
  public static void bam()
  {
    AppMethodBeat.i(261215);
    Log.i("MicroMsg.Camera2ProcessIDKeyStat", "markCamera2SupportLEVEL3");
    h.IzE.p(1099L, 22L, 1L);
    AppMethodBeat.o(261215);
  }
  
  public static void ban()
  {
    AppMethodBeat.i(261217);
    Log.i("MicroMsg.Camera2ProcessIDKeyStat", "markCamera2SupportEXTERNAL");
    h.IzE.p(1099L, 23L, 1L);
    AppMethodBeat.o(261217);
  }
  
  public static void bao()
  {
    AppMethodBeat.i(261220);
    Log.i("MicroMsg.Camera2ProcessIDKeyStat", "markCameraNumberAllBeenRemove ");
    h.IzE.p(1099L, 26L, 1L);
    AppMethodBeat.o(261220);
  }
  
  public static void bap()
  {
    AppMethodBeat.i(261221);
    Log.i("MicroMsg.Camera2ProcessIDKeyStat", "markCameraNumberHasOne ");
    h.IzE.p(1099L, 27L, 1L);
    AppMethodBeat.o(261221);
  }
  
  public static void baq()
  {
    AppMethodBeat.i(261222);
    Log.i("MicroMsg.Camera2ProcessIDKeyStat", "markCameraNumberHasTwo");
    h.IzE.p(1099L, 28L, 1L);
    AppMethodBeat.o(261222);
  }
  
  public static void bar()
  {
    AppMethodBeat.i(261223);
    Log.i("MicroMsg.Camera2ProcessIDKeyStat", "markCameraNumberMoreThanTwo");
    h.IzE.p(1099L, 29L, 1L);
    AppMethodBeat.o(261223);
  }
  
  public static void bas()
  {
    AppMethodBeat.i(261224);
    Log.i("MicroMsg.Camera2ProcessIDKeyStat", "markSupportLevelDiffCameras");
    h.IzE.p(1099L, 30L, 1L);
    AppMethodBeat.o(261224);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.media.widget.d.a
 * JD-Core Version:    0.7.0.1
 */