package com.tencent.mm.plugin.finder.video;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.media.widget.camerarecordview.preview.CameraPreviewGLSurfaceView;
import com.tencent.mm.modelvideo.o;
import com.tencent.mm.plugin.recordvideo.b.g;
import com.tencent.mm.plugin.recordvideo.jumper.RecordConfigProvider;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.aw;
import com.tencent.mm.vfs.i;
import d.g.b.k;
import d.l;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/video/FinderCameraContainerProcess;", "Lcom/tencent/mm/plugin/recordvideo/config/CameraContainerProcess;", "configProvider", "Lcom/tencent/mm/plugin/recordvideo/jumper/RecordConfigProvider;", "previewPlugin", "Lcom/tencent/mm/media/widget/camerarecordview/preview/CameraPreviewGLSurfaceView;", "(Lcom/tencent/mm/plugin/recordvideo/jumper/RecordConfigProvider;Lcom/tencent/mm/media/widget/camerarecordview/preview/CameraPreviewGLSurfaceView;)V", "TAG", "", "getTAG", "()Ljava/lang/String;", "getEncodeConfig", "Lcom/tencent/mm/media/widget/camerarecordview/data/IEncodeConfig;", "useDaemonRecorder", "", "plugin-finder_release"})
public final class a
  extends com.tencent.mm.plugin.recordvideo.b.b
{
  private final String TAG;
  
  public a(RecordConfigProvider paramRecordConfigProvider, CameraPreviewGLSurfaceView paramCameraPreviewGLSurfaceView)
  {
    super(paramRecordConfigProvider, paramCameraPreviewGLSurfaceView);
    AppMethodBeat.i(167999);
    this.TAG = "Finder.FinderCameraContainerProcess";
    paramRecordConfigProvider = com.tencent.mm.plugin.finder.storage.b.rCU;
    if (com.tencent.mm.plugin.finder.storage.b.czH())
    {
      paramRecordConfigProvider = super.getVideoTransPara();
      paramCameraPreviewGLSurfaceView = com.tencent.mm.plugin.finder.storage.b.rCU;
      paramRecordConfigProvider.videoBitrate = com.tencent.mm.plugin.finder.storage.b.czI();
    }
    AppMethodBeat.o(167999);
  }
  
  public final boolean auY()
  {
    boolean bool2 = false;
    AppMethodBeat.i(178467);
    if (auW())
    {
      ac.i(this.TAG, "useDaemonRecorder useCpuCrop false");
      localObject = com.tencent.mm.plugin.recordvideo.e.a.wDA;
      com.tencent.mm.plugin.recordvideo.e.a.pJ(false);
      AppMethodBeat.o(178467);
      return false;
    }
    Object localObject = com.tencent.mm.plugin.finder.storage.b.rCU;
    boolean bool1 = bool2;
    if (com.tencent.mm.plugin.finder.storage.b.czH())
    {
      bool1 = bool2;
      if (this.woT.auL()) {
        bool1 = true;
      }
    }
    localObject = this.TAG;
    StringBuilder localStringBuilder = new StringBuilder("useDaemonRecorder useDaemonRecorder:").append(bool1).append(", FinderConfig.USE_DAEMON_RECORD:");
    com.tencent.mm.plugin.finder.storage.b localb = com.tencent.mm.plugin.finder.storage.b.rCU;
    ac.i((String)localObject, com.tencent.mm.plugin.finder.storage.b.czH());
    localObject = com.tencent.mm.plugin.recordvideo.e.a.wDA;
    com.tencent.mm.plugin.recordvideo.e.a.pJ(bool1);
    AppMethodBeat.o(178467);
    return bool1;
  }
  
  public final com.tencent.mm.media.widget.camerarecordview.b.a getEncodeConfig()
  {
    AppMethodBeat.i(203679);
    com.tencent.mm.media.widget.camerarecordview.b.a locala = (com.tencent.mm.media.widget.camerarecordview.b.a)new a(this);
    AppMethodBeat.o(203679);
    return locala;
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/plugin/finder/video/FinderCameraContainerProcess$getEncodeConfig$1", "Lcom/tencent/mm/media/widget/camerarecordview/data/IEncodeConfig;", "getFilePath", "", "getRecordType", "", "getThumbPath", "plugin-finder_release"})
  public static final class a
    implements com.tencent.mm.media.widget.camerarecordview.b.a
  {
    public final int auM()
    {
      AppMethodBeat.i(203677);
      if (aw.eVz().getBoolean("mediacodec_create_error", false))
      {
        AppMethodBeat.o(203677);
        return 1;
      }
      if (g.isInit())
      {
        g localg = g.wpE;
        i = g.dva();
        AppMethodBeat.o(203677);
        return i;
      }
      int i = this.rQE.rRi.wqp;
      AppMethodBeat.o(203677);
      return i;
    }
    
    public final String auN()
    {
      return "";
    }
    
    public final String getFilePath()
    {
      AppMethodBeat.i(203678);
      Object localObject = com.tencent.mm.plugin.recordvideo.e.b.wDE;
      if (!i.eA(com.tencent.mm.plugin.recordvideo.e.b.dxc())) {
        i.aSh(com.tencent.mm.plugin.recordvideo.e.b.dxc());
      }
      localObject = new StringBuilder();
      k.g(o.aJx(), "SubCoreVideo.getCore()");
      localObject = o.aJG() + "/" + System.currentTimeMillis();
      AppMethodBeat.o(203678);
      return localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.video.a
 * JD-Core Version:    0.7.0.1
 */