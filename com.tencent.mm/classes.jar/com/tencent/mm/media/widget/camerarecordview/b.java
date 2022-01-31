package com.tencent.mm.media.widget.camerarecordview;

import a.f.b.j;
import a.l;
import android.graphics.Point;
import android.opengl.EGLContext;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelcontrol.VideoTransPara;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/media/widget/camerarecordview/CameraRecorderFactory;", "", "()V", "renderer", "Lcom/tencent/mm/media/render/AbsSurfaceRenderer;", "getRenderer", "()Lcom/tencent/mm/media/render/AbsSurfaceRenderer;", "setRenderer", "(Lcom/tencent/mm/media/render/AbsSurfaceRenderer;)V", "getAudioRecorder", "Lcom/tencent/mm/plugin/mmsight/model/encode/IMMSightAACRecorder;", "sampleRate", "", "bitrate", "audioChannelCount", "getCPUMediaRecorder", "Lcom/tencent/mm/media/widget/recorder/IMediaRecorder;", "recordType", "videoPara", "Lcom/tencent/mm/modelcontrol/VideoTransPara;", "camera", "Lcom/tencent/mm/media/widget/camera/ICommonCamera;", "getGPUMediaRecorder", "videoTransPara", "eglContext", "Landroid/opengl/EGLContext;", "view", "Lcom/tencent/mm/media/widget/camerarecordview/preview/ICameraPreviewView;", "useCPUCrop", "", "plugin-mediaeditor_release"})
public final class b
{
  private static com.tencent.mm.media.h.a eWh;
  public static final b fbj;
  
  static
  {
    AppMethodBeat.i(13256);
    fbj = new b();
    AppMethodBeat.o(13256);
  }
  
  public static void Xg()
  {
    eWh = null;
  }
  
  public static com.tencent.mm.media.widget.b.b a(int paramInt, VideoTransPara paramVideoTransPara, com.tencent.mm.media.widget.a.e parame, EGLContext paramEGLContext, com.tencent.mm.media.widget.camerarecordview.preview.c paramc, boolean paramBoolean, com.tencent.mm.media.h.a parama)
  {
    AppMethodBeat.i(13253);
    j.q(paramVideoTransPara, "videoTransPara");
    j.q(parame, "camera");
    j.q(paramEGLContext, "eglContext");
    j.q(paramc, "view");
    if (paramInt == 2)
    {
      if (parama == null) {}
      for (eWh = (com.tencent.mm.media.h.a)new b(paramBoolean);; eWh = parama)
      {
        parama = eWh;
        if ((parama != null) && (parame.WX() != null))
        {
          parama.cm(com.tencent.mm.media.widget.a.b.getPreviewWidth(), com.tencent.mm.media.widget.a.b.getPreviewHeight());
          parama.jX(com.tencent.mm.media.widget.a.b.WP());
          parama.cE(com.tencent.mm.media.widget.a.b.WS());
        }
        paramVideoTransPara = (com.tencent.mm.media.widget.b.b)new com.tencent.mm.media.widget.b.c(paramVideoTransPara, eWh, paramEGLContext, paramc.getPreviewTextureId());
        AppMethodBeat.o(13253);
        return paramVideoTransPara;
      }
    }
    if (parama == null) {}
    for (eWh = (com.tencent.mm.media.h.a)new c();; eWh = parama)
    {
      paramEGLContext = eWh;
      if ((paramEGLContext != null) && (parame.WX() != null))
      {
        paramc = com.tencent.mm.media.widget.a.b.WT();
        paramEGLContext.cm(paramc.x, paramc.y);
        paramEGLContext.jX(com.tencent.mm.media.widget.a.b.WP());
        paramEGLContext.cE(com.tencent.mm.media.widget.a.b.WS());
      }
      paramVideoTransPara = new com.tencent.mm.media.widget.b.d(paramVideoTransPara, eWh);
      parame.a(paramVideoTransPara.getFrameDataCallback());
      paramVideoTransPara = (com.tencent.mm.media.widget.b.b)paramVideoTransPara;
      AppMethodBeat.o(13253);
      return paramVideoTransPara;
    }
  }
  
  public static com.tencent.mm.media.widget.b.b a(int paramInt, VideoTransPara paramVideoTransPara, com.tencent.mm.media.widget.a.e parame, com.tencent.mm.media.h.a parama)
  {
    AppMethodBeat.i(13254);
    j.q(paramVideoTransPara, "videoPara");
    j.q(parame, "camera");
    if (paramInt == 2)
    {
      if (parama == null) {}
      for (eWh = (com.tencent.mm.media.h.a)new a();; eWh = parama)
      {
        parama = eWh;
        if ((parama != null) && (parame.WX() != null))
        {
          Point localPoint = com.tencent.mm.media.widget.a.b.WT();
          parama.cm(localPoint.x, localPoint.y);
          parama.jX(com.tencent.mm.media.widget.a.b.WP());
          parama.cE(com.tencent.mm.media.widget.a.b.WS());
        }
        paramVideoTransPara = new com.tencent.mm.media.widget.b.c(paramVideoTransPara, eWh);
        parame.a(paramVideoTransPara.getFrameDataCallback());
        paramVideoTransPara = (com.tencent.mm.media.widget.b.b)paramVideoTransPara;
        AppMethodBeat.o(13254);
        return paramVideoTransPara;
      }
    }
    paramVideoTransPara = new com.tencent.mm.media.widget.b.e(paramVideoTransPara);
    parame.a(paramVideoTransPara.getFrameDataCallback());
    paramVideoTransPara = (com.tencent.mm.media.widget.b.b)paramVideoTransPara;
    AppMethodBeat.o(13254);
    return paramVideoTransPara;
  }
  
  public static com.tencent.mm.media.h.a getRenderer()
  {
    return eWh;
  }
  
  @l(eaO={1, 1, 13}, eaP={""}, eaQ={"com/tencent/mm/media/widget/camerarecordview/CameraRecorderFactory$getCPUMediaRecorder$1", "Lcom/tencent/mm/media/render/AbsSurfaceRenderer;", "doInitRenderProc", "Lcom/tencent/mm/media/render/proc/GLTextureRenderProc;", "plugin-mediaeditor_release"})
  public static final class a
    extends com.tencent.mm.media.h.a
  {
    a()
    {
      super(0, 0, 0, 62);
    }
    
    public final com.tencent.mm.media.h.b.a Ve()
    {
      AppMethodBeat.i(13249);
      com.tencent.mm.media.h.b.a locala = (com.tencent.mm.media.h.b.a)new com.tencent.mm.media.h.b.e(this.eYj, this.eYk, this.eYl, this.eYm, this.eYn, this.scaleType);
      AppMethodBeat.o(13249);
      return locala;
    }
  }
  
  @l(eaO={1, 1, 13}, eaP={""}, eaQ={"com/tencent/mm/media/widget/camerarecordview/CameraRecorderFactory$getGPUMediaRecorder$1", "Lcom/tencent/mm/media/render/SurfaceTextureRenderer;", "doInitRenderProc", "Lcom/tencent/mm/media/render/proc/GLTextureRenderProc;", "plugin-mediaeditor_release"})
  public static final class b
    extends com.tencent.mm.media.h.d
  {
    b(boolean paramBoolean) {}
    
    public final com.tencent.mm.media.h.b.a Ve()
    {
      AppMethodBeat.i(13251);
      if (this.fbk)
      {
        locala = (com.tencent.mm.media.h.b.a)new com.tencent.mm.media.h.b.e(this.eYj, this.eYk, this.eYl, this.eYm, this.eYn, this.scaleType);
        AppMethodBeat.o(13251);
        return locala;
      }
      com.tencent.mm.media.h.b.a locala = (com.tencent.mm.media.h.b.a)new com.tencent.mm.media.h.b.c(this.eYj, this.eYk, this.eYl, this.eYm, this.eYn, this.scaleType);
      AppMethodBeat.o(13251);
      return locala;
    }
  }
  
  @l(eaO={1, 1, 13}, eaP={""}, eaQ={"com/tencent/mm/media/widget/camerarecordview/CameraRecorderFactory$getGPUMediaRecorder$3", "Lcom/tencent/mm/media/render/AbsSurfaceRenderer;", "doInitRenderProc", "Lcom/tencent/mm/media/render/proc/GLTextureRenderProc;", "plugin-mediaeditor_release"})
  public static final class c
    extends com.tencent.mm.media.h.a
  {
    c()
    {
      super(0, 0, 0, 62);
    }
    
    public final com.tencent.mm.media.h.b.a Ve()
    {
      AppMethodBeat.i(13252);
      com.tencent.mm.media.h.b.a locala = (com.tencent.mm.media.h.b.a)new com.tencent.mm.media.h.b.e(this.eYj, this.eYk, this.eYl, this.eYm, this.eYn, this.scaleType);
      AppMethodBeat.o(13252);
      return locala;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.media.widget.camerarecordview.b
 * JD-Core Version:    0.7.0.1
 */