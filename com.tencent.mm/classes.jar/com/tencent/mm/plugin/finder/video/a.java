package com.tencent.mm.plugin.finder.video;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.media.widget.camerarecordview.preview.CameraPreviewGLSurfaceView;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.modelvideo.o;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.mmsight.d;
import com.tencent.mm.plugin.recordvideo.jumper.RecordConfigProvider;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.vfs.s;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/video/FinderCameraContainerProcess;", "Lcom/tencent/mm/plugin/recordvideo/config/CameraContainerProcess;", "configProvider", "Lcom/tencent/mm/plugin/recordvideo/jumper/RecordConfigProvider;", "previewPlugin", "Lcom/tencent/mm/media/widget/camerarecordview/preview/CameraPreviewGLSurfaceView;", "(Lcom/tencent/mm/plugin/recordvideo/jumper/RecordConfigProvider;Lcom/tencent/mm/media/widget/camerarecordview/preview/CameraPreviewGLSurfaceView;)V", "TAG", "", "getTAG", "()Ljava/lang/String;", "getEncodeConfig", "Lcom/tencent/mm/media/widget/camerarecordview/data/IEncodeConfig;", "getVideoTransPara", "Lcom/tencent/mm/modelcontrol/VideoTransPara;", "useDaemonRecorder", "", "plugin-finder_release"})
public final class a
  extends com.tencent.mm.plugin.recordvideo.b.b
{
  private final String TAG;
  
  public a(RecordConfigProvider paramRecordConfigProvider, CameraPreviewGLSurfaceView paramCameraPreviewGLSurfaceView)
  {
    super(paramRecordConfigProvider, paramCameraPreviewGLSurfaceView);
    AppMethodBeat.i(167999);
    this.TAG = "Finder.FinderCameraContainerProcess";
    paramRecordConfigProvider = com.tencent.mm.plugin.finder.storage.c.vCb;
    if (com.tencent.mm.plugin.finder.storage.c.drX())
    {
      paramRecordConfigProvider = super.getVideoTransPara();
      paramCameraPreviewGLSurfaceView = com.tencent.mm.plugin.finder.storage.c.vCb;
      paramRecordConfigProvider.videoBitrate = com.tencent.mm.plugin.finder.storage.c.drY();
    }
    AppMethodBeat.o(167999);
  }
  
  public final boolean aQy()
  {
    boolean bool2 = false;
    AppMethodBeat.i(178467);
    if (aQw())
    {
      Log.i(this.TAG, "useDaemonRecorder useCpuCrop false");
      localObject = com.tencent.mm.plugin.recordvideo.e.b.ChY;
      com.tencent.mm.plugin.recordvideo.e.b.tG(false);
      AppMethodBeat.o(178467);
      return false;
    }
    Object localObject = com.tencent.mm.plugin.finder.storage.c.vCb;
    boolean bool1 = bool2;
    if (com.tencent.mm.plugin.finder.storage.c.drX())
    {
      bool1 = bool2;
      if (this.BMN.aQl()) {
        bool1 = true;
      }
    }
    localObject = this.TAG;
    StringBuilder localStringBuilder = new StringBuilder("useDaemonRecorder useDaemonRecorder:").append(bool1).append(", FinderConfig.USE_DAEMON_RECORD:");
    com.tencent.mm.plugin.finder.storage.c localc = com.tencent.mm.plugin.finder.storage.c.vCb;
    Log.i((String)localObject, com.tencent.mm.plugin.finder.storage.c.drX());
    localObject = com.tencent.mm.plugin.recordvideo.e.b.ChY;
    com.tencent.mm.plugin.recordvideo.e.b.tG(bool1);
    AppMethodBeat.o(178467);
    return bool1;
  }
  
  public final com.tencent.mm.media.widget.camerarecordview.b.a getEncodeConfig()
  {
    AppMethodBeat.i(253862);
    com.tencent.mm.media.widget.camerarecordview.b.a locala = (com.tencent.mm.media.widget.camerarecordview.b.a)new a(this);
    AppMethodBeat.o(253862);
    return locala;
  }
  
  public final VideoTransPara getVideoTransPara()
  {
    AppMethodBeat.i(258557);
    VideoTransPara localVideoTransPara = super.getVideoTransPara();
    int i = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.RbN, 1920);
    float f;
    if ((localVideoTransPara.width > i) || (localVideoTransPara.height > i))
    {
      Log.i(this.TAG, "getVideoTransPara, size to large, originWidth:" + localVideoTransPara.width + ", originHeight:" + localVideoTransPara.height + ", maxSize:" + i);
      f = localVideoTransPara.height / localVideoTransPara.width;
      if (localVideoTransPara.width <= localVideoTransPara.height) {
        break label206;
      }
      localVideoTransPara.height = ((int)(f * i));
      localVideoTransPara.width = i;
    }
    for (;;)
    {
      localVideoTransPara.width = d.QH(localVideoTransPara.width);
      localVideoTransPara.height = d.QH(localVideoTransPara.height);
      Log.i(this.TAG, "getVideoTransPara, do size crop, width:" + localVideoTransPara.width + ", height:" + localVideoTransPara.height + ", maxSize:" + i);
      AppMethodBeat.o(258557);
      return localVideoTransPara;
      label206:
      localVideoTransPara.width = ((int)(i / f));
      localVideoTransPara.height = i;
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/video/FinderCameraContainerProcess$getEncodeConfig$1", "Lcom/tencent/mm/media/widget/camerarecordview/data/IEncodeConfig;", "getFilePath", "", "getRecordType", "", "getThumbPath", "plugin-finder_release"})
  public static final class a
    implements com.tencent.mm.media.widget.camerarecordview.b.a
  {
    public final int aQm()
    {
      AppMethodBeat.i(253860);
      if (MultiProcessMMKV.getSingleDefault().getBoolean("mediacodec_create_error", false))
      {
        AppMethodBeat.o(253860);
        return 1;
      }
      if (com.tencent.mm.plugin.recordvideo.b.g.isInit())
      {
        com.tencent.mm.plugin.recordvideo.b.g localg = com.tencent.mm.plugin.recordvideo.b.g.BNx;
        i = com.tencent.mm.plugin.recordvideo.b.g.eJz();
        AppMethodBeat.o(253860);
        return i;
      }
      int i = this.wbh.wdm.BOi;
      AppMethodBeat.o(253860);
      return i;
    }
    
    public final String aQn()
    {
      return "";
    }
    
    public final String getFilePath()
    {
      AppMethodBeat.i(253861);
      Object localObject = com.tencent.mm.plugin.recordvideo.e.c.Cic;
      if (!s.YS(com.tencent.mm.plugin.recordvideo.e.c.eMJ())) {
        s.boN(com.tencent.mm.plugin.recordvideo.e.c.eMJ());
      }
      localObject = new StringBuilder();
      p.g(o.bhi(), "SubCoreVideo.getCore()");
      localObject = o.bhr() + "/" + System.currentTimeMillis();
      AppMethodBeat.o(253861);
      return localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.video.a
 * JD-Core Version:    0.7.0.1
 */