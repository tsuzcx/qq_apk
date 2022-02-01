package com.tencent.mm.plugin.finder.video;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.media.widget.camerarecordview.preview.CameraPreviewGLSurfaceView;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.modelvideo.s;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.recordvideo.e.c;
import com.tencent.mm.plugin.recordvideo.jumper.RecordConfigProvider;
import com.tencent.mm.plugin.xlabeffect.XEffectConfig;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.vfs.u;
import kotlin.g.a.m;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/video/FinderCameraContainerProcess;", "Lcom/tencent/mm/plugin/recordvideo/config/CameraContainerProcess;", "configProvider", "Lcom/tencent/mm/plugin/recordvideo/jumper/RecordConfigProvider;", "previewPlugin", "Lcom/tencent/mm/media/widget/camerarecordview/preview/CameraPreviewGLSurfaceView;", "(Lcom/tencent/mm/plugin/recordvideo/jumper/RecordConfigProvider;Lcom/tencent/mm/media/widget/camerarecordview/preview/CameraPreviewGLSurfaceView;)V", "TAG", "", "getTAG", "()Ljava/lang/String;", "getEncodeConfig", "Lcom/tencent/mm/media/widget/camerarecordview/data/IEncodeConfig;", "getPreviewRenderer", "Lcom/tencent/mm/media/render/AbsSurfaceRenderer;", "getResolutionLimit", "", "getVideoTransPara", "Lcom/tencent/mm/modelcontrol/VideoTransPara;", "useDaemonRecorder", "", "plugin-finder_release"})
public final class a
  extends com.tencent.mm.plugin.recordvideo.b.b
{
  private final String TAG;
  
  public a(RecordConfigProvider paramRecordConfigProvider, CameraPreviewGLSurfaceView paramCameraPreviewGLSurfaceView)
  {
    super(paramRecordConfigProvider, paramCameraPreviewGLSurfaceView);
    AppMethodBeat.i(167999);
    this.TAG = "Finder.FinderCameraContainerProcess";
    paramRecordConfigProvider = com.tencent.mm.plugin.finder.storage.d.AjH;
    if (com.tencent.mm.plugin.finder.storage.d.dTl())
    {
      paramRecordConfigProvider = super.getVideoTransPara();
      paramCameraPreviewGLSurfaceView = com.tencent.mm.plugin.finder.storage.d.AjH;
      paramRecordConfigProvider.videoBitrate = com.tencent.mm.plugin.finder.storage.d.dTm();
    }
    AppMethodBeat.o(167999);
  }
  
  public final boolean aZq()
  {
    boolean bool2 = false;
    AppMethodBeat.i(178467);
    if (aZo())
    {
      Log.i(this.TAG, "useDaemonRecorder useCpuCrop false");
      localObject = c.IeQ;
      c.xc(false);
      AppMethodBeat.o(178467);
      return false;
    }
    Object localObject = com.tencent.mm.plugin.finder.storage.d.AjH;
    boolean bool1 = bool2;
    if (com.tencent.mm.plugin.finder.storage.d.dTl())
    {
      bool1 = bool2;
      if (fvw().aZc()) {
        bool1 = true;
      }
    }
    localObject = this.TAG;
    StringBuilder localStringBuilder = new StringBuilder("useDaemonRecorder useDaemonRecorder:").append(bool1).append(", FinderConfig.USE_DAEMON_RECORD:");
    com.tencent.mm.plugin.finder.storage.d locald = com.tencent.mm.plugin.finder.storage.d.AjH;
    Log.i((String)localObject, com.tencent.mm.plugin.finder.storage.d.dTl());
    localObject = c.IeQ;
    c.xc(bool1);
    AppMethodBeat.o(178467);
    return bool1;
  }
  
  public final com.tencent.mm.media.widget.camerarecordview.b.a getEncodeConfig()
  {
    AppMethodBeat.i(281544);
    com.tencent.mm.media.widget.camerarecordview.b.a locala = (com.tencent.mm.media.widget.camerarecordview.b.a)new a(this);
    AppMethodBeat.o(281544);
    return locala;
  }
  
  public final com.tencent.mm.media.j.a getPreviewRenderer()
  {
    AppMethodBeat.i(281545);
    if ((this.ALV.HLp.QPr) || (this.ALV.HLp.QPs)) {}
    for (int i = 1;; i = 0)
    {
      if ((i != 0) && (fvx() == null))
      {
        a(new com.tencent.mm.plugin.recordvideo.c.b(6));
        this.HJv = new com.tencent.mm.plugin.recordvideo.c.a();
        localObject = fvx();
        if (localObject != null) {
          ((com.tencent.mm.plugin.recordvideo.c.b)localObject).HUh = ((m)new b(this));
        }
      }
      Object localObject = super.getPreviewRenderer();
      AppMethodBeat.o(281545);
      return localObject;
    }
  }
  
  public final int getResolutionLimit()
  {
    return 2500;
  }
  
  public final VideoTransPara getVideoTransPara()
  {
    AppMethodBeat.i(281543);
    VideoTransPara localVideoTransPara = super.getVideoTransPara();
    int i = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vKC, 1920);
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
      localVideoTransPara.width = com.tencent.mm.plugin.mmsight.d.WV(localVideoTransPara.width);
      localVideoTransPara.height = com.tencent.mm.plugin.mmsight.d.WV(localVideoTransPara.height);
      Log.i(this.TAG, "getVideoTransPara, do size crop, width:" + localVideoTransPara.width + ", height:" + localVideoTransPara.height + ", maxSize:" + i);
      AppMethodBeat.o(281543);
      return localVideoTransPara;
      label206:
      localVideoTransPara.width = ((int)(i / f));
      localVideoTransPara.height = i;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/video/FinderCameraContainerProcess$getEncodeConfig$1", "Lcom/tencent/mm/media/widget/camerarecordview/data/IEncodeConfig;", "getFilePath", "", "getRecordType", "", "getThumbPath", "plugin-finder_release"})
  public static final class a
    implements com.tencent.mm.media.widget.camerarecordview.b.a
  {
    public final int aZd()
    {
      AppMethodBeat.i(271856);
      if (MultiProcessMMKV.getSingleDefault().getBoolean("mediacodec_create_error", false))
      {
        AppMethodBeat.o(271856);
        return 1;
      }
      if (com.tencent.mm.plugin.recordvideo.b.h.isInit())
      {
        com.tencent.mm.plugin.recordvideo.b.h localh = com.tencent.mm.plugin.recordvideo.b.h.HKf;
        i = com.tencent.mm.plugin.recordvideo.b.h.fvJ();
        AppMethodBeat.o(271856);
        return i;
      }
      int i = this.AJO.ALV.recordType;
      AppMethodBeat.o(271856);
      return i;
    }
    
    public final String aZe()
    {
      return "";
    }
    
    public final String getFilePath()
    {
      AppMethodBeat.i(271857);
      Object localObject = com.tencent.mm.plugin.recordvideo.e.d.IeU;
      if (!u.agG(com.tencent.mm.plugin.recordvideo.e.d.fzv())) {
        u.bBD(com.tencent.mm.plugin.recordvideo.e.d.fzv());
      }
      localObject = new StringBuilder();
      p.j(s.bqA(), "SubCoreVideo.getCore()");
      localObject = s.bqJ() + "/" + System.currentTimeMillis();
      AppMethodBeat.o(271857);
      return localObject;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "width", "", "height", "invoke"})
  static final class b
    extends q
    implements m<Integer, Integer, x>
  {
    b(a parama)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.video.a
 * JD-Core Version:    0.7.0.1
 */