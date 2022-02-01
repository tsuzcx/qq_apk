package com.tencent.mm.plugin.facedetectaction.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expansions.a;
import com.tencent.mm.plugin.facedetect.PluginFace;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.youtu.ytcommon.YTCommonExInterface;
import com.tencent.youtu.ytfacetrack.YTFaceTrack;
import com.tencent.youtu.ytposedetect.YTPoseDetectInterface;
import com.tencent.youtu.ytposedetect.YTPoseDetectInterface.PoseDetectOnFrame;

public final class b
{
  int pWX;
  public YTPoseDetectInterface.PoseDetectOnFrame pWY = null;
  a pWZ;
  int status = -1;
  
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
      ad.i("MicroMsg.FaceCheckActionEngine", "release");
      if (PluginFace.isEnabled())
      {
        YTPoseDetectInterface.releaseModel();
        YTFaceTrack.GlobalRelease();
      }
      AppMethodBeat.o(104208);
      return;
    }
    catch (Exception localException)
    {
      ad.printErrStackTrace("MicroMsg.FaceCheckActionEngine", localException, "release error", new Object[0]);
      AppMethodBeat.o(104208);
    }
  }
  
  static void tryLoadLibrary()
  {
    AppMethodBeat.i(104207);
    if (PluginFace.isEnabled())
    {
      a.Vi("YTCommon");
      a.Vi("YTFaceTrack");
      a.Vi("YTFaceTrackPro");
      a.Vi("YTNextCV");
      a.Vi("YTPoseDetect");
    }
    AppMethodBeat.o(104207);
  }
  
  public static abstract interface a
  {
    public abstract void a(byte[][] paramArrayOfByte, int paramInt1, int paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetectaction.b.b
 * JD-Core Version:    0.7.0.1
 */