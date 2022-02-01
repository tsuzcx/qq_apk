package com.tencent.mm.plugin.finder.video;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.media.widget.camerarecordview.preview.CameraPreviewGLSurfaceView;
import com.tencent.mm.plugin.recordvideo.jumper.RecordConfigProvider;
import com.tencent.mm.sdk.platformtools.ad;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/video/FinderCameraContainerProcess;", "Lcom/tencent/mm/plugin/recordvideo/config/CameraContainerProcess;", "configProvider", "Lcom/tencent/mm/plugin/recordvideo/jumper/RecordConfigProvider;", "previewPlugin", "Lcom/tencent/mm/media/widget/camerarecordview/preview/CameraPreviewGLSurfaceView;", "(Lcom/tencent/mm/plugin/recordvideo/jumper/RecordConfigProvider;Lcom/tencent/mm/media/widget/camerarecordview/preview/CameraPreviewGLSurfaceView;)V", "TAG", "", "getTAG", "()Ljava/lang/String;", "getEncodeConfig", "Lcom/tencent/mm/media/widget/camerarecordview/data/IEncodeConfig;", "useDaemonRecorder", "", "plugin-finder_release"})
public final class a
  extends com.tencent.mm.plugin.recordvideo.b.b
{
  private final String TAG;
  
  public a(RecordConfigProvider paramRecordConfigProvider, CameraPreviewGLSurfaceView paramCameraPreviewGLSurfaceView)
  {
    super(paramRecordConfigProvider, paramCameraPreviewGLSurfaceView);
    AppMethodBeat.i(167999);
    this.TAG = "Finder.FinderCameraContainerProcess";
    paramRecordConfigProvider = com.tencent.mm.plugin.finder.storage.b.qJA;
    if (com.tencent.mm.plugin.finder.storage.b.cqg())
    {
      paramRecordConfigProvider = super.getVideoTransPara();
      paramCameraPreviewGLSurfaceView = com.tencent.mm.plugin.finder.storage.b.qJA;
      paramRecordConfigProvider.videoBitrate = com.tencent.mm.plugin.finder.storage.b.cqh();
    }
    AppMethodBeat.o(167999);
  }
  
  public final boolean aoh()
  {
    boolean bool2 = false;
    AppMethodBeat.i(178467);
    if (aof())
    {
      ad.i(this.TAG, "useDaemonRecorder useCpuCrop false");
      localObject = com.tencent.mm.plugin.recordvideo.e.a.vtA;
      com.tencent.mm.plugin.recordvideo.e.a.oL(false);
      AppMethodBeat.o(178467);
      return false;
    }
    Object localObject = com.tencent.mm.plugin.finder.storage.b.qJA;
    boolean bool1 = bool2;
    if (com.tencent.mm.plugin.finder.storage.b.cqg())
    {
      bool1 = bool2;
      if (this.vgh.anV()) {
        bool1 = true;
      }
    }
    localObject = this.TAG;
    StringBuilder localStringBuilder = new StringBuilder("useDaemonRecorder useDaemonRecorder:").append(bool1).append(", FinderConfig.USE_DAEMON_RECORD:");
    com.tencent.mm.plugin.finder.storage.b localb = com.tencent.mm.plugin.finder.storage.b.qJA;
    ad.i((String)localObject, com.tencent.mm.plugin.finder.storage.b.cqg());
    localObject = com.tencent.mm.plugin.recordvideo.e.a.vtA;
    com.tencent.mm.plugin.recordvideo.e.a.oL(bool1);
    AppMethodBeat.o(178467);
    return bool1;
  }
  
  public final com.tencent.mm.media.widget.camerarecordview.b.a getEncodeConfig()
  {
    AppMethodBeat.i(199694);
    com.tencent.mm.media.widget.camerarecordview.b.a locala = (com.tencent.mm.media.widget.camerarecordview.b.a)new a.a(this);
    AppMethodBeat.o(199694);
    return locala;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.video.a
 * JD-Core Version:    0.7.0.1
 */