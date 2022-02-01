package com.tencent.mm.plugin.facedetectaction.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expansions.e;
import com.tencent.mm.plugin.facedetect.PluginFace;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.youtu.ytcommon.YTCommonExInterface;
import com.tencent.youtu.ytfacetrack.YTFaceTrack;
import com.tencent.youtu.ytposedetect.YTPoseDetectInterface;
import com.tencent.youtu.ytposedetect.YTPoseDetectInterface.PoseDetectOnFrame;

public final class b
{
  int liveType;
  int status = -1;
  public YTPoseDetectInterface.PoseDetectOnFrame zZG = null;
  a zZH;
  
  static
  {
    AppMethodBeat.i(104209);
    tryLoadLibrary();
    YTCommonExInterface.setIsEnabledLog(true);
    YTCommonExInterface.setIsEnabledNativeLog(true);
    AppMethodBeat.o(104209);
  }
  
  public static void release()
  {
    AppMethodBeat.i(104208);
    try
    {
      Log.i("MicroMsg.FaceCheckActionEngine", "release");
      if (PluginFace.isEnabled())
      {
        YTPoseDetectInterface.releaseModel();
        YTFaceTrack.GlobalRelease();
        a.b.dPO().zZC = null;
      }
      AppMethodBeat.o(104208);
      return;
    }
    catch (Exception localException)
    {
      Log.printErrStackTrace("MicroMsg.FaceCheckActionEngine", localException, "release error", new Object[0]);
      AppMethodBeat.o(104208);
    }
  }
  
  static void tryLoadLibrary()
  {
    AppMethodBeat.i(104207);
    if (PluginFace.isEnabled())
    {
      e.tryLoadLibrary("YTCommon");
      e.tryLoadLibrary("YTFaceTrackPro2");
      e.tryLoadLibrary("YTNextCV");
      e.tryLoadLibrary("YTPoseDetect");
    }
    AppMethodBeat.o(104207);
  }
  
  public static abstract interface a
  {
    public abstract void a(byte[][] paramArrayOfByte, int paramInt1, int paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetectaction.model.b
 * JD-Core Version:    0.7.0.1
 */