package com.tencent.mm.plugin.finder.video;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.media.widget.camerarecordview.preview.CameraPreviewGLSurfaceView;
import com.tencent.mm.modelvideo.o;
import com.tencent.mm.plugin.recordvideo.b.g;
import com.tencent.mm.plugin.recordvideo.jumper.RecordConfigProvider;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ax;
import com.tencent.mm.vfs.i;
import d.g.b.p;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/video/FinderCameraContainerProcess;", "Lcom/tencent/mm/plugin/recordvideo/config/CameraContainerProcess;", "configProvider", "Lcom/tencent/mm/plugin/recordvideo/jumper/RecordConfigProvider;", "previewPlugin", "Lcom/tencent/mm/media/widget/camerarecordview/preview/CameraPreviewGLSurfaceView;", "(Lcom/tencent/mm/plugin/recordvideo/jumper/RecordConfigProvider;Lcom/tencent/mm/media/widget/camerarecordview/preview/CameraPreviewGLSurfaceView;)V", "TAG", "", "getTAG", "()Ljava/lang/String;", "getEncodeConfig", "Lcom/tencent/mm/media/widget/camerarecordview/data/IEncodeConfig;", "useDaemonRecorder", "", "plugin-finder_release"})
public final class a
  extends com.tencent.mm.plugin.recordvideo.b.b
{
  private final String TAG;
  
  public a(RecordConfigProvider paramRecordConfigProvider, CameraPreviewGLSurfaceView paramCameraPreviewGLSurfaceView)
  {
    super(paramRecordConfigProvider, paramCameraPreviewGLSurfaceView);
    AppMethodBeat.i(167999);
    this.TAG = "Finder.FinderCameraContainerProcess";
    paramRecordConfigProvider = com.tencent.mm.plugin.finder.storage.b.sxa;
    if (com.tencent.mm.plugin.finder.storage.b.cGq())
    {
      paramRecordConfigProvider = super.getVideoTransPara();
      paramCameraPreviewGLSurfaceView = com.tencent.mm.plugin.finder.storage.b.sxa;
      paramRecordConfigProvider.videoBitrate = com.tencent.mm.plugin.finder.storage.b.cGr();
    }
    AppMethodBeat.o(167999);
  }
  
  public final boolean axL()
  {
    boolean bool2 = false;
    AppMethodBeat.i(178467);
    if (axJ())
    {
      ad.i(this.TAG, "useDaemonRecorder useCpuCrop false");
      localObject = com.tencent.mm.plugin.recordvideo.e.a.xRh;
      com.tencent.mm.plugin.recordvideo.e.a.qi(false);
      AppMethodBeat.o(178467);
      return false;
    }
    Object localObject = com.tencent.mm.plugin.finder.storage.b.sxa;
    boolean bool1 = bool2;
    if (com.tencent.mm.plugin.finder.storage.b.cGq())
    {
      bool1 = bool2;
      if (this.xwJ.axy()) {
        bool1 = true;
      }
    }
    localObject = this.TAG;
    StringBuilder localStringBuilder = new StringBuilder("useDaemonRecorder useDaemonRecorder:").append(bool1).append(", FinderConfig.USE_DAEMON_RECORD:");
    com.tencent.mm.plugin.finder.storage.b localb = com.tencent.mm.plugin.finder.storage.b.sxa;
    ad.i((String)localObject, com.tencent.mm.plugin.finder.storage.b.cGq());
    localObject = com.tencent.mm.plugin.recordvideo.e.a.xRh;
    com.tencent.mm.plugin.recordvideo.e.a.qi(bool1);
    AppMethodBeat.o(178467);
    return bool1;
  }
  
  public final com.tencent.mm.media.widget.camerarecordview.b.a getEncodeConfig()
  {
    AppMethodBeat.i(204587);
    com.tencent.mm.media.widget.camerarecordview.b.a locala = (com.tencent.mm.media.widget.camerarecordview.b.a)new a(this);
    AppMethodBeat.o(204587);
    return locala;
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/finder/video/FinderCameraContainerProcess$getEncodeConfig$1", "Lcom/tencent/mm/media/widget/camerarecordview/data/IEncodeConfig;", "getFilePath", "", "getRecordType", "", "getThumbPath", "plugin-finder_release"})
  public static final class a
    implements com.tencent.mm.media.widget.camerarecordview.b.a
  {
    public final String axA()
    {
      return "";
    }
    
    public final int axz()
    {
      AppMethodBeat.i(204585);
      if (ax.flg().getBoolean("mediacodec_create_error", false))
      {
        AppMethodBeat.o(204585);
        return 1;
      }
      if (g.isInit())
      {
        g localg = g.xxu;
        i = g.dFv();
        AppMethodBeat.o(204585);
        return i;
      }
      int i = this.sNe.sNI.xyf;
      AppMethodBeat.o(204585);
      return i;
    }
    
    public final String getFilePath()
    {
      AppMethodBeat.i(204586);
      Object localObject = com.tencent.mm.plugin.recordvideo.e.b.xRl;
      if (!i.fv(com.tencent.mm.plugin.recordvideo.e.b.dIu())) {
        i.aYg(com.tencent.mm.plugin.recordvideo.e.b.dIu());
      }
      localObject = new StringBuilder();
      p.g(o.aMI(), "SubCoreVideo.getCore()");
      localObject = o.aMR() + "/" + System.currentTimeMillis();
      AppMethodBeat.o(204586);
      return localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.video.a
 * JD-Core Version:    0.7.0.1
 */