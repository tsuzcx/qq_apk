package com.tencent.mm.bw;

import a.f.b.j;
import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.ttpic.PTFaceAttr;
import com.tencent.ttpic.PTFaceDetector;
import com.tencent.ttpic.util.BenchUtil;
import com.tencent.ttpic.util.VideoFilterUtil;
import com.tencent.ttpic.util.youtu.VideoPreviewFaceOutlineDetector;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/ptsdk/PTFaceDetectorProcess;", "", "faceDetectWidth", "", "(I)V", "faceDetector", "Lcom/tencent/ttpic/PTFaceDetector;", "lastHasFace", "", "lastRotation", "destroy", "", "detectFace", "Lcom/tencent/ttpic/PTFaceAttr;", "frame", "Lcom/tencent/filter/Frame;", "needGesture", "sync", "isAllFrameDetect", "rotate", "getFaceDetector", "Lcom/tencent/ttpic/util/youtu/VideoPreviewFaceOutlineDetector;", "getPhotoAngle", "", "init", "updateFaceDetector", "Companion", "plugin-ptsdk_release"})
public final class a
{
  public static final a.a yin;
  private int cdJ;
  public PTFaceDetector yik;
  private boolean yil;
  private final int yim = 180;
  
  static
  {
    AppMethodBeat.i(71507);
    yin = new a.a((byte)0);
    AppMethodBeat.o(71507);
  }
  
  private a() {}
  
  public a(char paramChar)
  {
    this((byte)0);
  }
  
  private final void dqK()
  {
    AppMethodBeat.i(71506);
    Object localObject = this.yik;
    if (localObject != null)
    {
      localObject = ((PTFaceDetector)localObject).getFaceDetector();
      if (localObject != null)
      {
        ((VideoPreviewFaceOutlineDetector)localObject).clearActionCounter();
        AppMethodBeat.o(71506);
        return;
      }
    }
    AppMethodBeat.o(71506);
  }
  
  public final PTFaceAttr a(com.tencent.filter.h paramh, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, int paramInt)
  {
    AppMethodBeat.i(141783);
    j.q(paramh, "frame");
    int i = paramInt;
    if (paramInt < 0) {}
    for (;;)
    {
      try
      {
        i = VideoFilterUtil.get4DirectionAngle(getPhotoAngle());
        paramInt = (i + 360) % 360;
        double d = this.yim * 1.0D / paramh.width;
        BenchUtil.benchStart("PTFaceDetector");
        PTFaceDetector localPTFaceDetector = this.yik;
        if (localPTFaceDetector != null)
        {
          if (this.yil) {
            paramInt = this.cdJ;
          }
          paramh = localPTFaceDetector.detectFrame(paramh, null, paramInt, true, paramBoolean1, false, d, paramBoolean2, paramBoolean3);
          if (paramh != null)
          {
            if (paramh.getFaceCount() <= 0) {
              break label182;
            }
            paramBoolean1 = true;
            this.yil = paramBoolean1;
            if (this.yil) {
              this.cdJ = paramh.getRotation();
            }
            BenchUtil.benchEnd("PTFaceDetector");
            AppMethodBeat.o(141783);
            return paramh;
          }
          this.yil = false;
          continue;
        }
        paramh = null;
      }
      catch (Exception paramh)
      {
        com.tencent.mm.plugin.report.service.h.qsU.cT(1012, 50);
        AppMethodBeat.o(141783);
        return null;
      }
      continue;
      label182:
      paramBoolean1 = false;
    }
  }
  
  public final void destroy()
  {
    AppMethodBeat.i(71505);
    ab.i("MicroMsg.PTFaceDetectorProcess", "destroy");
    try
    {
      PTFaceDetector localPTFaceDetector = this.yik;
      if (localPTFaceDetector != null) {
        localPTFaceDetector.destroy();
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        com.tencent.mm.plugin.report.service.h.qsU.cT(1012, 51);
      }
    }
    this.yik = null;
    AppMethodBeat.o(71505);
  }
  
  public final float getPhotoAngle()
  {
    AppMethodBeat.i(71502);
    Object localObject = this.yik;
    if (localObject != null)
    {
      localObject = ((PTFaceDetector)localObject).getFaceDetector();
      if (localObject != null)
      {
        float f = ((VideoPreviewFaceOutlineDetector)localObject).getPhotoAngle();
        AppMethodBeat.o(71502);
        return f;
      }
    }
    AppMethodBeat.o(71502);
    return 0.0F;
  }
  
  public final void init()
  {
    AppMethodBeat.i(71501);
    ab.i("MicroMsg.PTFaceDetectorProcess", "init");
    try
    {
      this.yik = new PTFaceDetector();
      PTFaceDetector localPTFaceDetector = this.yik;
      if (localPTFaceDetector != null) {
        localPTFaceDetector.init();
      }
      dqK();
      AppMethodBeat.o(71501);
      return;
    }
    catch (Exception localException)
    {
      com.tencent.mm.plugin.report.service.h.qsU.cT(1012, 49);
      AppMethodBeat.o(71501);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.bw.a
 * JD-Core Version:    0.7.0.1
 */