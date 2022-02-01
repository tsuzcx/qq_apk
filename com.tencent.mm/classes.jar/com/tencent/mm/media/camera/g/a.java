package com.tencent.mm.media.camera.g;

import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.mmdata.rpt.aj;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/media/camera/report/CameraKitReport;", "", "()V", "BufferPreviewType", "", "TAG", "", "TexturePreviewType", "reportMap", "Landroid/util/SparseArray;", "Lcom/tencent/mm/autogen/mmdata/rpt/CameraReportStruct;", "get", "sessionId", "getOrCreate", "markCameraCreate", "", "markCameraStartRet", "result", "", "markCaptureCost", "cost", "", "markEnter", "scene", "markExit", "markFrameUpdate", "markPreviewSize", "width", "height", "markRenderCost", "format", "custom", "screen", "markResolution", "markScreenView", "type", "plugin-camera_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
{
  public static final a nwA;
  public static final SparseArray<aj> nwB;
  
  static
  {
    AppMethodBeat.i(237262);
    nwA = new a();
    nwB = new SparseArray();
    AppMethodBeat.o(237262);
  }
  
  public static void K(int paramInt, String paramString)
  {
    AppMethodBeat.i(237248);
    s.u(paramString, "type");
    aj localaj = tW(paramInt);
    if (localaj != null) {
      localaj.ioH = localaj.F("ScreenViewType", paramString, true);
    }
    AppMethodBeat.o(237248);
  }
  
  public static void U(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(237233);
    aj localaj = tW(paramInt);
    if (localaj != null) {
      if (!paramBoolean) {
        break label31;
      }
    }
    label31:
    for (paramInt = 1;; paramInt = 0)
    {
      localaj.ior = paramInt;
      AppMethodBeat.o(237233);
      return;
    }
  }
  
  public static aj tW(int paramInt)
  {
    AppMethodBeat.i(237214);
    aj localaj = (aj)nwB.get(paramInt);
    AppMethodBeat.o(237214);
    return localaj;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.media.camera.g.a
 * JD-Core Version:    0.7.0.1
 */