package com.tencent.mm.plugin.finder.video;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.media.widget.camerarecordview.preview.CameraPreviewGLSurfaceView;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.modelvideo.v;
import com.tencent.mm.plugin.expt.b.c.a;
import com.tencent.mm.plugin.recordvideo.jumper.RecordConfigProvider;
import com.tencent.mm.plugin.recordvideo.util.f;
import com.tencent.mm.plugin.xlabeffect.XEffectConfig;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.vfs.y;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.m;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/video/FinderCameraContainerProcess;", "Lcom/tencent/mm/plugin/recordvideo/config/CameraContainerProcess;", "configProvider", "Lcom/tencent/mm/plugin/recordvideo/jumper/RecordConfigProvider;", "previewPlugin", "Lcom/tencent/mm/media/widget/camerarecordview/preview/CameraPreviewGLSurfaceView;", "(Lcom/tencent/mm/plugin/recordvideo/jumper/RecordConfigProvider;Lcom/tencent/mm/media/widget/camerarecordview/preview/CameraPreviewGLSurfaceView;)V", "TAG", "", "getTAG", "()Ljava/lang/String;", "getEncodeConfig", "Lcom/tencent/mm/media/widget/camerarecordview/data/IEncodeConfig;", "getPreviewRenderer", "Lcom/tencent/mm/media/render/AbsSurfaceRenderer;", "getResolutionLimit", "", "getVideoTransPara", "Lcom/tencent/mm/modelcontrol/VideoTransPara;", "useDaemonRecorder", "", "plugin-finder-publish_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
  extends com.tencent.mm.plugin.recordvideo.c.b
{
  private final String TAG;
  
  public a(RecordConfigProvider paramRecordConfigProvider, CameraPreviewGLSurfaceView paramCameraPreviewGLSurfaceView)
  {
    super(paramRecordConfigProvider, paramCameraPreviewGLSurfaceView);
    AppMethodBeat.i(167999);
    this.TAG = "Finder.FinderCameraContainerProcess";
    paramRecordConfigProvider = com.tencent.mm.plugin.finder.storage.d.FAy;
    if (com.tencent.mm.plugin.finder.storage.d.eRA())
    {
      paramRecordConfigProvider = super.getVideoTransPara();
      paramCameraPreviewGLSurfaceView = com.tencent.mm.plugin.finder.storage.d.FAy;
      paramRecordConfigProvider.videoBitrate = com.tencent.mm.plugin.finder.storage.d.eRB();
    }
    AppMethodBeat.o(167999);
  }
  
  public final boolean bup()
  {
    boolean bool2 = false;
    AppMethodBeat.i(178467);
    if (bun())
    {
      Log.i(this.TAG, "useDaemonRecorder useCpuCrop false");
      localObject = com.tencent.mm.plugin.recordvideo.util.d.Obm;
      com.tencent.mm.plugin.recordvideo.util.d.BD(false);
      AppMethodBeat.o(178467);
      return false;
    }
    Object localObject = com.tencent.mm.plugin.finder.storage.d.FAy;
    boolean bool1 = bool2;
    if (com.tencent.mm.plugin.finder.storage.d.eRA())
    {
      bool1 = bool2;
      if (gHl().bub()) {
        bool1 = true;
      }
    }
    localObject = this.TAG;
    StringBuilder localStringBuilder = new StringBuilder("useDaemonRecorder useDaemonRecorder:").append(bool1).append(", FinderConfig.USE_DAEMON_RECORD:");
    com.tencent.mm.plugin.finder.storage.d locald = com.tencent.mm.plugin.finder.storage.d.FAy;
    Log.i((String)localObject, com.tencent.mm.plugin.finder.storage.d.eRA());
    localObject = com.tencent.mm.plugin.recordvideo.util.d.Obm;
    com.tencent.mm.plugin.recordvideo.util.d.BD(bool1);
    AppMethodBeat.o(178467);
    return bool1;
  }
  
  public final com.tencent.mm.media.widget.camerarecordview.b.a getEncodeConfig()
  {
    AppMethodBeat.i(334941);
    com.tencent.mm.media.widget.camerarecordview.b.a locala = (com.tencent.mm.media.widget.camerarecordview.b.a)new a(this);
    AppMethodBeat.o(334941);
    return locala;
  }
  
  public final com.tencent.mm.media.j.a getPreviewRenderer()
  {
    AppMethodBeat.i(334952);
    if ((this.oaV.NIn.XKq) || (this.oaV.NIn.XKr)) {}
    for (int i = 1;; i = 0)
    {
      if ((i != 0) && (gHm() == null))
      {
        a(new com.tencent.mm.plugin.recordvideo.e.c(6));
        this.NGv = new com.tencent.mm.plugin.recordvideo.e.b();
        localObject = gHm();
        if (localObject != null) {
          ((com.tencent.mm.plugin.recordvideo.e.c)localObject).NQZ = ((m)new b(this));
        }
      }
      Object localObject = super.getPreviewRenderer();
      AppMethodBeat.o(334952);
      return localObject;
    }
  }
  
  public final int getResolutionLimit()
  {
    return 2500;
  }
  
  public final VideoTransPara getVideoTransPara()
  {
    AppMethodBeat.i(334937);
    VideoTransPara localVideoTransPara = super.getVideoTransPara();
    int i = ((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.zaW, 1920);
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
      localVideoTransPara.width = com.tencent.mm.plugin.mmsight.d.aaX(localVideoTransPara.width);
      localVideoTransPara.height = com.tencent.mm.plugin.mmsight.d.aaX(localVideoTransPara.height);
      Log.i(this.TAG, "getVideoTransPara, do size crop, width:" + localVideoTransPara.width + ", height:" + localVideoTransPara.height + ", maxSize:" + i);
      AppMethodBeat.o(334937);
      return localVideoTransPara;
      label206:
      localVideoTransPara.width = ((int)(i / f));
      localVideoTransPara.height = i;
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/video/FinderCameraContainerProcess$getEncodeConfig$1", "Lcom/tencent/mm/media/widget/camerarecordview/data/IEncodeConfig;", "getFilePath", "", "getRecordType", "", "getThumbPath", "plugin-finder-publish_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
    implements com.tencent.mm.media.widget.camerarecordview.b.a
  {
    a(a parama) {}
    
    public final int buc()
    {
      AppMethodBeat.i(335104);
      if (MultiProcessMMKV.getSingleDefault().getBoolean("mediacodec_create_error", false))
      {
        AppMethodBeat.o(335104);
        return 1;
      }
      if (com.tencent.mm.plugin.recordvideo.c.h.isInit())
      {
        com.tencent.mm.plugin.recordvideo.c.h localh = com.tencent.mm.plugin.recordvideo.c.h.NHb;
        i = com.tencent.mm.plugin.recordvideo.c.h.gHx();
        AppMethodBeat.o(335104);
        return i;
      }
      int i = this.GmA.oaV.recordType;
      AppMethodBeat.o(335104);
      return i;
    }
    
    public final String bud()
    {
      return "";
    }
    
    public final String getFilePath()
    {
      AppMethodBeat.i(335112);
      Object localObject = f.Obq;
      if (!y.ZC(f.gLh())) {
        y.bDX(f.gLh());
      }
      localObject = new StringBuilder();
      v.bOg();
      localObject = v.bOp() + '/' + System.currentTimeMillis();
      AppMethodBeat.o(335112);
      return localObject;
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "width", "", "height"}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements m<Integer, Integer, ah>
  {
    b(a parama)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.video.a
 * JD-Core Version:    0.7.0.1
 */