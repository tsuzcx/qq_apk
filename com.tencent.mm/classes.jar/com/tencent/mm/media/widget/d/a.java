package com.tencent.mm.media.widget.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/media/widget/util/Camera2ProcessIDKeyStat;", "", "()V", "ID", "", "KV_ID", "", "TAG", "", "markCamera2Open", "", "markCamera2OpenFailed", "markCamera2OpenSuccess", "markCamera2Release", "markCamera2SupportEXTERNAL", "markCamera2SupportFULL", "markCamera2SupportLEGACY", "markCamera2SupportLEVEL3", "markCamera2SupportLIMITED", "markCamera2TakePhotoBack", "markCamera2TakePhotoBackError", "markCamera2TakePhotoFront", "markCamera2TakePhotoFrontError", "markCamera2TakePhotoUseHDRSystem", "markCamera2UseEISSystem", "markCamera2UseOISSystem", "markCamera2UseRecordStream", "markCameraNumberAllBeenRemove", "markCameraNumberHasOne", "markCameraNumberHasTwo", "markCameraNumberMoreThanTwo", "markCameraQueryFail", "markCaptureSuccessUseImageBack", "markCaptureSuccessUseImageFront", "markCaptureUseImageCostTimes", "times", "markCaptureUseImageCostTimesBack", "markCaptureUseImageCostTimesFront", "markCaptureUseImageSuccess", "markErrorFindImage", "markErrorFindPreview", "markImageAvailable", "markReportCamera2Info", "numbers", "supportLevels", "levelDiffCameras", "frontLevel", "backLevel", "frontCameraNumber", "backCameraNumber", "markSupportLevelDiffCameras", "plugin-mediaeditor_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
{
  public static final a nMV;
  
  static
  {
    AppMethodBeat.i(237587);
    nMV = new a();
    AppMethodBeat.o(237587);
  }
  
  public static void a(int paramInt1, String paramString1, int paramInt2, String paramString2, String paramString3, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(237583);
    s.u(paramString1, "supportLevels");
    s.u(paramString2, "frontLevel");
    s.u(paramString3, "backLevel");
    Log.i("MicroMsg.Camera2ProcessIDKeyStat", "markReportCamera2Info " + paramInt1 + ',' + paramString1 + ',' + paramInt2 + ',' + paramString2 + ',' + paramString3 + ',' + paramInt3 + ',' + paramInt4);
    h.OAn.b(22109, new Object[] { Integer.valueOf(paramInt1), paramString1, Integer.valueOf(paramInt2), paramString2, paramString3, Integer.valueOf(paramInt3), Integer.valueOf(paramInt4) });
    AppMethodBeat.o(237583);
  }
  
  public static void buR()
  {
    AppMethodBeat.i(237499);
    Log.i("MicroMsg.Camera2ProcessIDKeyStat", "markCamera2Open");
    h.OAn.p(1099L, 0L, 1L);
    AppMethodBeat.o(237499);
  }
  
  public static void buS()
  {
    AppMethodBeat.i(237502);
    Log.i("MicroMsg.Camera2ProcessIDKeyStat", "markCamera2OpenSuccess");
    h.OAn.p(1099L, 1L, 1L);
    AppMethodBeat.o(237502);
  }
  
  public static void buT()
  {
    AppMethodBeat.i(237508);
    Log.i("MicroMsg.Camera2ProcessIDKeyStat", "markCamera2OpenFailed");
    h.OAn.p(1099L, 2L, 1L);
    AppMethodBeat.o(237508);
  }
  
  public static void buU()
  {
    AppMethodBeat.i(237513);
    Log.i("MicroMsg.Camera2ProcessIDKeyStat", "markCamera2Release");
    h.OAn.p(1099L, 3L, 1L);
    AppMethodBeat.o(237513);
  }
  
  public static void buV()
  {
    AppMethodBeat.i(237515);
    Log.i("MicroMsg.Camera2ProcessIDKeyStat", "markCamera2TakePhotoFront");
    h.OAn.p(1099L, 4L, 1L);
    AppMethodBeat.o(237515);
  }
  
  public static void buW()
  {
    AppMethodBeat.i(237520);
    Log.i("MicroMsg.Camera2ProcessIDKeyStat", "markCamera2TakePhotoBack");
    h.OAn.p(1099L, 5L, 1L);
    AppMethodBeat.o(237520);
  }
  
  public static void buX()
  {
    AppMethodBeat.i(237523);
    Log.i("MicroMsg.Camera2ProcessIDKeyStat", "markCamera2TakePhotoBackError");
    h.OAn.p(1099L, 6L, 1L);
    AppMethodBeat.o(237523);
  }
  
  public static void buY()
  {
    AppMethodBeat.i(237525);
    Log.i("MicroMsg.Camera2ProcessIDKeyStat", "markCamera2TakePhotoBackError");
    com.tencent.mm.compatible.d.a locala = com.tencent.mm.compatible.d.a.lQN;
    com.tencent.mm.compatible.d.a.T(1099L, 7L);
    AppMethodBeat.o(237525);
  }
  
  public static void buZ()
  {
    AppMethodBeat.i(237529);
    Log.i("MicroMsg.Camera2ProcessIDKeyStat", "markCamera2UseOISSystem");
    h.OAn.p(1099L, 9L, 1L);
    AppMethodBeat.o(237529);
  }
  
  public static void bva()
  {
    AppMethodBeat.i(237531);
    Log.i("MicroMsg.Camera2ProcessIDKeyStat", "markErrorFindImage");
    h.OAn.p(1099L, 12L, 1L);
    AppMethodBeat.o(237531);
  }
  
  public static void bvb()
  {
    AppMethodBeat.i(237537);
    Log.i("MicroMsg.Camera2ProcessIDKeyStat", "markImageAvailable");
    h.OAn.p(1099L, 13L, 1L);
    AppMethodBeat.o(237537);
  }
  
  public static void bvc()
  {
    AppMethodBeat.i(237539);
    Log.i("MicroMsg.Camera2ProcessIDKeyStat", "markCaptureSuccessUseImageBack");
    h.OAn.p(1099L, 14L, 1L);
    AppMethodBeat.o(237539);
  }
  
  public static void bvd()
  {
    AppMethodBeat.i(237542);
    Log.i("MicroMsg.Camera2ProcessIDKeyStat", "markCaptureSuccessUseImageFront");
    h.OAn.p(1099L, 15L, 1L);
    AppMethodBeat.o(237542);
  }
  
  public static void bve()
  {
    AppMethodBeat.i(237544);
    Log.i("MicroMsg.Camera2ProcessIDKeyStat", "markCaptureUseImageSuccess");
    h.OAn.p(1099L, 16L, 1L);
    AppMethodBeat.o(237544);
  }
  
  public static void bvf()
  {
    AppMethodBeat.i(237547);
    Log.i("MicroMsg.Camera2ProcessIDKeyStat", "markCamera2UseRecordStream");
    h.OAn.p(1099L, 18L, 1L);
    AppMethodBeat.o(237547);
  }
  
  public static void bvg()
  {
    AppMethodBeat.i(237550);
    Log.i("MicroMsg.Camera2ProcessIDKeyStat", "markCamera2SupportLIMITED");
    h.OAn.p(1099L, 19L, 1L);
    AppMethodBeat.o(237550);
  }
  
  public static void bvh()
  {
    AppMethodBeat.i(237556);
    Log.i("MicroMsg.Camera2ProcessIDKeyStat", "markCamera2SupportFULL");
    h.OAn.p(1099L, 20L, 1L);
    AppMethodBeat.o(237556);
  }
  
  public static void bvi()
  {
    AppMethodBeat.i(237557);
    Log.i("MicroMsg.Camera2ProcessIDKeyStat", "markCamera2SupportLEGACY");
    h.OAn.p(1099L, 21L, 1L);
    AppMethodBeat.o(237557);
  }
  
  public static void bvj()
  {
    AppMethodBeat.i(237559);
    Log.i("MicroMsg.Camera2ProcessIDKeyStat", "markCamera2SupportLEVEL3");
    h.OAn.p(1099L, 22L, 1L);
    AppMethodBeat.o(237559);
  }
  
  public static void bvk()
  {
    AppMethodBeat.i(237562);
    Log.i("MicroMsg.Camera2ProcessIDKeyStat", "markCamera2SupportEXTERNAL");
    h.OAn.p(1099L, 23L, 1L);
    AppMethodBeat.o(237562);
  }
  
  public static void bvl()
  {
    AppMethodBeat.i(237568);
    Log.i("MicroMsg.Camera2ProcessIDKeyStat", "markCameraNumberAllBeenRemove ");
    h.OAn.p(1099L, 26L, 1L);
    AppMethodBeat.o(237568);
  }
  
  public static void bvm()
  {
    AppMethodBeat.i(237570);
    Log.i("MicroMsg.Camera2ProcessIDKeyStat", "markCameraNumberHasOne ");
    h.OAn.p(1099L, 27L, 1L);
    AppMethodBeat.o(237570);
  }
  
  public static void bvn()
  {
    AppMethodBeat.i(237572);
    Log.i("MicroMsg.Camera2ProcessIDKeyStat", "markCameraNumberHasTwo");
    h.OAn.p(1099L, 28L, 1L);
    AppMethodBeat.o(237572);
  }
  
  public static void bvo()
  {
    AppMethodBeat.i(237577);
    Log.i("MicroMsg.Camera2ProcessIDKeyStat", "markCameraNumberMoreThanTwo");
    h.OAn.p(1099L, 29L, 1L);
    AppMethodBeat.o(237577);
  }
  
  public static void bvp()
  {
    AppMethodBeat.i(237579);
    Log.i("MicroMsg.Camera2ProcessIDKeyStat", "markSupportLevelDiffCameras");
    h.OAn.p(1099L, 30L, 1L);
    AppMethodBeat.o(237579);
  }
  
  public static void il(long paramLong)
  {
    AppMethodBeat.i(237563);
    Log.i("MicroMsg.Camera2ProcessIDKeyStat", s.X("markCaptureUseImageCostTimesFront ", Long.valueOf(paramLong)));
    h.OAn.p(1099L, 24L, paramLong);
    AppMethodBeat.o(237563);
  }
  
  public static void im(long paramLong)
  {
    AppMethodBeat.i(237566);
    Log.i("MicroMsg.Camera2ProcessIDKeyStat", s.X("markCaptureUseImageCostTimesBack ", Long.valueOf(paramLong)));
    h.OAn.p(1099L, 25L, paramLong);
    AppMethodBeat.o(237566);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.media.widget.d.a
 * JD-Core Version:    0.7.0.1
 */