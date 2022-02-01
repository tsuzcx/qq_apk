package com.tencent.mm.plugin.finder.video;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.media.widget.camerarecordview.preview.CameraPreviewGLSurfaceView;
import com.tencent.mm.plugin.recordvideo.b.g;
import com.tencent.mm.plugin.recordvideo.jumper.RecordConfigProvider;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ay;
import d.g.b.p;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/video/FinderCameraContainerProcess;", "Lcom/tencent/mm/plugin/recordvideo/config/CameraContainerProcess;", "configProvider", "Lcom/tencent/mm/plugin/recordvideo/jumper/RecordConfigProvider;", "previewPlugin", "Lcom/tencent/mm/media/widget/camerarecordview/preview/CameraPreviewGLSurfaceView;", "(Lcom/tencent/mm/plugin/recordvideo/jumper/RecordConfigProvider;Lcom/tencent/mm/media/widget/camerarecordview/preview/CameraPreviewGLSurfaceView;)V", "TAG", "", "getTAG", "()Ljava/lang/String;", "getEncodeConfig", "Lcom/tencent/mm/media/widget/camerarecordview/data/IEncodeConfig;", "useDaemonRecorder", "", "plugin-finder_release"})
public final class a
  extends com.tencent.mm.plugin.recordvideo.b.b
{
  private final String TAG;
  
  public a(RecordConfigProvider paramRecordConfigProvider, CameraPreviewGLSurfaceView paramCameraPreviewGLSurfaceView)
  {
    super(paramRecordConfigProvider, paramCameraPreviewGLSurfaceView);
    AppMethodBeat.i(167999);
    this.TAG = "Finder.FinderCameraContainerProcess";
    paramRecordConfigProvider = com.tencent.mm.plugin.finder.storage.b.sHP;
    if (com.tencent.mm.plugin.finder.storage.b.cIn())
    {
      paramRecordConfigProvider = super.getVideoTransPara();
      paramCameraPreviewGLSurfaceView = com.tencent.mm.plugin.finder.storage.b.sHP;
      paramRecordConfigProvider.videoBitrate = com.tencent.mm.plugin.finder.storage.b.cIo();
    }
    AppMethodBeat.o(167999);
  }
  
  public final boolean aya()
  {
    boolean bool2 = false;
    AppMethodBeat.i(178467);
    if (axY())
    {
      ae.i(this.TAG, "useDaemonRecorder useCpuCrop false");
      localObject = com.tencent.mm.plugin.recordvideo.e.a.yha;
      com.tencent.mm.plugin.recordvideo.e.a.qp(false);
      AppMethodBeat.o(178467);
      return false;
    }
    Object localObject = com.tencent.mm.plugin.finder.storage.b.sHP;
    boolean bool1 = bool2;
    if (com.tencent.mm.plugin.finder.storage.b.cIn())
    {
      bool1 = bool2;
      if (this.xMG.axN()) {
        bool1 = true;
      }
    }
    localObject = this.TAG;
    StringBuilder localStringBuilder = new StringBuilder("useDaemonRecorder useDaemonRecorder:").append(bool1).append(", FinderConfig.USE_DAEMON_RECORD:");
    com.tencent.mm.plugin.finder.storage.b localb = com.tencent.mm.plugin.finder.storage.b.sHP;
    ae.i((String)localObject, com.tencent.mm.plugin.finder.storage.b.cIn());
    localObject = com.tencent.mm.plugin.recordvideo.e.a.yha;
    com.tencent.mm.plugin.recordvideo.e.a.qp(bool1);
    AppMethodBeat.o(178467);
    return bool1;
  }
  
  public final com.tencent.mm.media.widget.camerarecordview.b.a getEncodeConfig()
  {
    AppMethodBeat.i(205211);
    com.tencent.mm.media.widget.camerarecordview.b.a locala = (com.tencent.mm.media.widget.camerarecordview.b.a)new a(this);
    AppMethodBeat.o(205211);
    return locala;
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/finder/video/FinderCameraContainerProcess$getEncodeConfig$1", "Lcom/tencent/mm/media/widget/camerarecordview/data/IEncodeConfig;", "getFilePath", "", "getRecordType", "", "getThumbPath", "plugin-finder_release"})
  public static final class a
    implements com.tencent.mm.media.widget.camerarecordview.b.a
  {
    public final int axO()
    {
      AppMethodBeat.i(205209);
      if (ay.fpb().getBoolean("mediacodec_create_error", false))
      {
        AppMethodBeat.o(205209);
        return 1;
      }
      if (g.isInit())
      {
        g localg = g.xNr;
        i = g.dIM();
        AppMethodBeat.o(205209);
        return i;
      }
      int i = this.sYp.sYT.xOc;
      AppMethodBeat.o(205209);
      return i;
    }
    
    public final String axP()
    {
      return "";
    }
    
    public final String getFilePath()
    {
      AppMethodBeat.i(205210);
      Object localObject = com.tencent.mm.plugin.recordvideo.e.b.yhe;
      if (!com.tencent.mm.vfs.o.fB(com.tencent.mm.plugin.recordvideo.e.b.dLL())) {
        com.tencent.mm.vfs.o.aZI(com.tencent.mm.plugin.recordvideo.e.b.dLL());
      }
      localObject = new StringBuilder();
      p.g(com.tencent.mm.modelvideo.o.aNg(), "SubCoreVideo.getCore()");
      localObject = com.tencent.mm.modelvideo.o.aNp() + "/" + System.currentTimeMillis();
      AppMethodBeat.o(205210);
      return localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.video.a
 * JD-Core Version:    0.7.0.1
 */