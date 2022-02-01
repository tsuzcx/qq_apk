package com.tencent.mm.media.widget.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/media/widget/util/Camera2ProcessIDKeyStat;", "", "()V", "ID", "", "KV_ID", "", "TAG", "", "markCamera2Open", "", "markCamera2OpenFailed", "markCamera2OpenSuccess", "markCamera2Release", "markCamera2SupportEXTERNAL", "markCamera2SupportFULL", "markCamera2SupportLEGACY", "markCamera2SupportLEVEL3", "markCamera2SupportLIMITED", "markCamera2TakePhotoBack", "markCamera2TakePhotoBackError", "markCamera2TakePhotoFront", "markCamera2TakePhotoFrontError", "markCamera2TakePhotoUseHDRSystem", "markCamera2UseEISSystem", "markCamera2UseOISSystem", "markCamera2UseRecordStream", "markCameraNumberAllBeenRemove", "markCameraNumberHasOne", "markCameraNumberHasTwo", "markCameraNumberMoreThanTwo", "markCameraQueryFail", "markCaptureSuccessUseImageBack", "markCaptureSuccessUseImageFront", "markCaptureUseImageCostTimes", "times", "markCaptureUseImageCostTimesBack", "markCaptureUseImageCostTimesFront", "markCaptureUseImageSuccess", "markErrorFindImage", "markErrorFindPreview", "markImageAvailable", "markReportCamera2Info", "numbers", "supportLevels", "levelDiffCameras", "frontLevel", "backLevel", "frontCameraNumber", "backCameraNumber", "markSupportLevelDiffCameras", "plugin-mediaeditor_release"})
public final class a
{
  public static final a itg;
  
  static
  {
    AppMethodBeat.i(218938);
    itg = new a();
    AppMethodBeat.o(218938);
  }
  
  public static void a(int paramInt1, String paramString1, int paramInt2, String paramString2, String paramString3, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(218937);
    p.h(paramString1, "supportLevels");
    p.h(paramString2, "frontLevel");
    p.h(paramString3, "backLevel");
    Log.i("MicroMsg.Camera2ProcessIDKeyStat", "markReportCamera2Info " + paramInt1 + ',' + paramString1 + ',' + paramInt2 + ',' + paramString2 + ',' + paramString3 + ',' + paramInt3 + ',' + paramInt4);
    h.CyF.a(22109, new Object[] { Integer.valueOf(paramInt1), paramString1, Integer.valueOf(paramInt2), paramString2, paramString3, Integer.valueOf(paramInt3), Integer.valueOf(paramInt4) });
    AppMethodBeat.o(218937);
  }
  
  public static void aRb()
  {
    AppMethodBeat.i(218910);
    Log.i("MicroMsg.Camera2ProcessIDKeyStat", "markCamera2Open");
    h.CyF.n(1099L, 0L, 1L);
    AppMethodBeat.o(218910);
  }
  
  public static void aRc()
  {
    AppMethodBeat.i(218911);
    Log.i("MicroMsg.Camera2ProcessIDKeyStat", "markCamera2OpenSuccess");
    h.CyF.n(1099L, 1L, 1L);
    AppMethodBeat.o(218911);
  }
  
  public static void aRd()
  {
    AppMethodBeat.i(218912);
    Log.i("MicroMsg.Camera2ProcessIDKeyStat", "markCamera2OpenFailed");
    h.CyF.n(1099L, 2L, 1L);
    AppMethodBeat.o(218912);
  }
  
  public static void aRe()
  {
    AppMethodBeat.i(218913);
    Log.i("MicroMsg.Camera2ProcessIDKeyStat", "markCamera2Release");
    h.CyF.n(1099L, 3L, 1L);
    AppMethodBeat.o(218913);
  }
  
  public static void aRf()
  {
    AppMethodBeat.i(218914);
    Log.i("MicroMsg.Camera2ProcessIDKeyStat", "markCamera2TakePhotoFront");
    h.CyF.n(1099L, 4L, 1L);
    AppMethodBeat.o(218914);
  }
  
  public static void aRg()
  {
    AppMethodBeat.i(218915);
    Log.i("MicroMsg.Camera2ProcessIDKeyStat", "markCamera2TakePhotoBack");
    h.CyF.n(1099L, 5L, 1L);
    AppMethodBeat.o(218915);
  }
  
  public static void aRh()
  {
    AppMethodBeat.i(218916);
    Log.i("MicroMsg.Camera2ProcessIDKeyStat", "markCamera2TakePhotoBackError");
    h.CyF.n(1099L, 6L, 1L);
    AppMethodBeat.o(218916);
  }
  
  public static void aRi()
  {
    AppMethodBeat.i(218917);
    Log.i("MicroMsg.Camera2ProcessIDKeyStat", "markCamera2TakePhotoBackError");
    com.tencent.mm.compatible.d.a locala = com.tencent.mm.compatible.d.a.gDv;
    com.tencent.mm.compatible.d.a.v(1099L, 7L);
    AppMethodBeat.o(218917);
  }
  
  public static void aRj()
  {
    AppMethodBeat.i(218918);
    Log.i("MicroMsg.Camera2ProcessIDKeyStat", "markCamera2UseOISSystem");
    h.CyF.n(1099L, 9L, 1L);
    AppMethodBeat.o(218918);
  }
  
  public static void aRk()
  {
    AppMethodBeat.i(218919);
    Log.i("MicroMsg.Camera2ProcessIDKeyStat", "markErrorFindImage");
    h.CyF.n(1099L, 12L, 1L);
    AppMethodBeat.o(218919);
  }
  
  public static void aRl()
  {
    AppMethodBeat.i(218920);
    Log.i("MicroMsg.Camera2ProcessIDKeyStat", "markImageAvailable");
    h.CyF.n(1099L, 13L, 1L);
    AppMethodBeat.o(218920);
  }
  
  public static void aRm()
  {
    AppMethodBeat.i(218921);
    Log.i("MicroMsg.Camera2ProcessIDKeyStat", "markCaptureSuccessUseImageBack");
    h.CyF.n(1099L, 14L, 1L);
    AppMethodBeat.o(218921);
  }
  
  public static void aRn()
  {
    AppMethodBeat.i(218922);
    Log.i("MicroMsg.Camera2ProcessIDKeyStat", "markCaptureSuccessUseImageFront");
    h.CyF.n(1099L, 15L, 1L);
    AppMethodBeat.o(218922);
  }
  
  public static void aRo()
  {
    AppMethodBeat.i(218923);
    Log.i("MicroMsg.Camera2ProcessIDKeyStat", "markCaptureUseImageSuccess");
    h.CyF.n(1099L, 16L, 1L);
    AppMethodBeat.o(218923);
  }
  
  public static void aRp()
  {
    AppMethodBeat.i(218924);
    Log.i("MicroMsg.Camera2ProcessIDKeyStat", "markCamera2UseRecordStream");
    h.CyF.n(1099L, 18L, 1L);
    AppMethodBeat.o(218924);
  }
  
  public static void aRq()
  {
    AppMethodBeat.i(218925);
    Log.i("MicroMsg.Camera2ProcessIDKeyStat", "markCamera2SupportLIMITED");
    h.CyF.n(1099L, 19L, 1L);
    AppMethodBeat.o(218925);
  }
  
  public static void aRr()
  {
    AppMethodBeat.i(218926);
    Log.i("MicroMsg.Camera2ProcessIDKeyStat", "markCamera2SupportFULL");
    h.CyF.n(1099L, 20L, 1L);
    AppMethodBeat.o(218926);
  }
  
  public static void aRs()
  {
    AppMethodBeat.i(218927);
    Log.i("MicroMsg.Camera2ProcessIDKeyStat", "markCamera2SupportLEGACY");
    h.CyF.n(1099L, 21L, 1L);
    AppMethodBeat.o(218927);
  }
  
  public static void aRt()
  {
    AppMethodBeat.i(218928);
    Log.i("MicroMsg.Camera2ProcessIDKeyStat", "markCamera2SupportLEVEL3");
    h.CyF.n(1099L, 22L, 1L);
    AppMethodBeat.o(218928);
  }
  
  public static void aRu()
  {
    AppMethodBeat.i(218929);
    Log.i("MicroMsg.Camera2ProcessIDKeyStat", "markCamera2SupportEXTERNAL");
    h.CyF.n(1099L, 23L, 1L);
    AppMethodBeat.o(218929);
  }
  
  public static void aRv()
  {
    AppMethodBeat.i(218932);
    Log.i("MicroMsg.Camera2ProcessIDKeyStat", "markCameraNumberAllBeenRemove ");
    h.CyF.n(1099L, 26L, 1L);
    AppMethodBeat.o(218932);
  }
  
  public static void aRw()
  {
    AppMethodBeat.i(218933);
    Log.i("MicroMsg.Camera2ProcessIDKeyStat", "markCameraNumberHasOne ");
    h.CyF.n(1099L, 27L, 1L);
    AppMethodBeat.o(218933);
  }
  
  public static void aRx()
  {
    AppMethodBeat.i(218934);
    Log.i("MicroMsg.Camera2ProcessIDKeyStat", "markCameraNumberHasTwo");
    h.CyF.n(1099L, 28L, 1L);
    AppMethodBeat.o(218934);
  }
  
  public static void aRy()
  {
    AppMethodBeat.i(218935);
    Log.i("MicroMsg.Camera2ProcessIDKeyStat", "markCameraNumberMoreThanTwo");
    h.CyF.n(1099L, 29L, 1L);
    AppMethodBeat.o(218935);
  }
  
  public static void aRz()
  {
    AppMethodBeat.i(218936);
    Log.i("MicroMsg.Camera2ProcessIDKeyStat", "markSupportLevelDiffCameras");
    h.CyF.n(1099L, 30L, 1L);
    AppMethodBeat.o(218936);
  }
  
  public static void zW(long paramLong)
  {
    AppMethodBeat.i(218930);
    Log.i("MicroMsg.Camera2ProcessIDKeyStat", "markCaptureUseImageCostTimesFront ".concat(String.valueOf(paramLong)));
    h.CyF.n(1099L, 24L, paramLong);
    AppMethodBeat.o(218930);
  }
  
  public static void zX(long paramLong)
  {
    AppMethodBeat.i(218931);
    Log.i("MicroMsg.Camera2ProcessIDKeyStat", "markCaptureUseImageCostTimesBack ".concat(String.valueOf(paramLong)));
    h.CyF.n(1099L, 25L, paramLong);
    AppMethodBeat.o(218931);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.media.widget.d.a
 * JD-Core Version:    0.7.0.1
 */