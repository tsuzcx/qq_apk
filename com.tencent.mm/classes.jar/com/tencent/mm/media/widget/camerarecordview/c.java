package com.tencent.mm.media.widget.camerarecordview;

import android.graphics.Point;
import android.opengl.EGLContext;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.media.j.b.f;
import com.tencent.mm.modelcontrol.VideoTransPara;
import d.g.b.p;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/media/widget/camerarecordview/CameraRecorderFactory;", "", "()V", "renderer", "Lcom/tencent/mm/media/render/AbsSurfaceRenderer;", "getRenderer", "()Lcom/tencent/mm/media/render/AbsSurfaceRenderer;", "setRenderer", "(Lcom/tencent/mm/media/render/AbsSurfaceRenderer;)V", "getAudioRecorder", "Lcom/tencent/mm/plugin/mmsight/model/encode/IMMSightAACRecorder;", "sampleRate", "", "bitrate", "audioChannelCount", "getCPUMediaRecorder", "Lcom/tencent/mm/media/widget/recorder/IMediaRecorder;", "recordType", "videoPara", "Lcom/tencent/mm/modelcontrol/VideoTransPara;", "camera", "Lcom/tencent/mm/media/widget/camera/ICommonCamera;", "getGPUMediaRecorder", "videoTransPara", "eglContext", "Landroid/opengl/EGLContext;", "view", "Lcom/tencent/mm/media/widget/camerarecordview/preview/ICameraPreviewView;", "useCPUCrop", "", "plugin-mediaeditor_release"})
public final class c
{
  private static com.tencent.mm.media.j.a hnY;
  public static final c hws;
  
  static
  {
    AppMethodBeat.i(94272);
    hws = new c();
    AppMethodBeat.o(94272);
  }
  
  public static com.tencent.mm.media.widget.c.b a(int paramInt, VideoTransPara paramVideoTransPara, com.tencent.mm.media.widget.a.e parame, EGLContext paramEGLContext, com.tencent.mm.media.widget.camerarecordview.preview.e parame1, boolean paramBoolean, com.tencent.mm.media.j.a parama)
  {
    AppMethodBeat.i(94270);
    p.h(paramVideoTransPara, "videoTransPara");
    p.h(parame, "camera");
    p.h(paramEGLContext, "eglContext");
    p.h(parame1, "view");
    if (paramInt == 2)
    {
      if (parama == null)
      {
        hnY = (com.tencent.mm.media.j.a)new b(paramBoolean);
        parama = hnY;
        if ((parama != null) && (parame.awA() != null))
        {
          parama.cU(com.tencent.mm.media.widget.a.b.getPreviewWidth(), com.tencent.mm.media.widget.a.b.getPreviewHeight());
          parama.ng(com.tencent.mm.media.widget.a.b.aws());
          parama.ei(com.tencent.mm.media.widget.a.b.awv());
        }
        parame = hnY;
        parame1 = parame1.getPreviewTexture();
        if (parame1 == null) {
          break label155;
        }
      }
      label155:
      for (paramInt = parame1.hnc;; paramInt = -1)
      {
        paramVideoTransPara = (com.tencent.mm.media.widget.c.b)new com.tencent.mm.media.widget.c.c(paramVideoTransPara, parame, paramEGLContext, paramInt);
        AppMethodBeat.o(94270);
        return paramVideoTransPara;
        hnY = parama;
        break;
      }
    }
    if (parama == null) {}
    for (hnY = (com.tencent.mm.media.j.a)new c();; hnY = parama)
    {
      paramEGLContext = hnY;
      if ((paramEGLContext != null) && (parame.awA() != null))
      {
        parame1 = com.tencent.mm.media.widget.a.b.aww();
        paramEGLContext.cU(parame1.x, parame1.y);
        paramEGLContext.ng(com.tencent.mm.media.widget.a.b.aws());
        paramEGLContext.ei(com.tencent.mm.media.widget.a.b.awv());
      }
      paramVideoTransPara = new com.tencent.mm.media.widget.c.d(paramVideoTransPara, hnY);
      parame.a(paramVideoTransPara.getFrameDataCallback());
      paramVideoTransPara = (com.tencent.mm.media.widget.c.b)paramVideoTransPara;
      AppMethodBeat.o(94270);
      return paramVideoTransPara;
    }
  }
  
  public static com.tencent.mm.media.widget.c.b a(int paramInt, VideoTransPara paramVideoTransPara, com.tencent.mm.media.widget.a.e parame, com.tencent.mm.media.j.a parama)
  {
    AppMethodBeat.i(94271);
    p.h(paramVideoTransPara, "videoPara");
    p.h(parame, "camera");
    if (paramInt == 2)
    {
      if (parama == null) {}
      for (hnY = (com.tencent.mm.media.j.a)new a();; hnY = parama)
      {
        parama = hnY;
        if ((parama != null) && (parame.awA() != null))
        {
          Point localPoint = com.tencent.mm.media.widget.a.b.aww();
          parama.cU(localPoint.x, localPoint.y);
          parama.ng(com.tencent.mm.media.widget.a.b.aws());
          parama.ei(com.tencent.mm.media.widget.a.b.awv());
        }
        paramVideoTransPara = new com.tencent.mm.media.widget.c.c(paramVideoTransPara, hnY);
        parame.a(paramVideoTransPara.getFrameDataCallback());
        paramVideoTransPara = (com.tencent.mm.media.widget.c.b)paramVideoTransPara;
        AppMethodBeat.o(94271);
        return paramVideoTransPara;
      }
    }
    paramVideoTransPara = new com.tencent.mm.media.widget.c.e(paramVideoTransPara);
    if (parame.awA() != null) {
      paramVideoTransPara.setMirror(com.tencent.mm.media.widget.a.b.awv());
    }
    parame.a(paramVideoTransPara.getFrameDataCallback());
    paramVideoTransPara = (com.tencent.mm.media.widget.c.b)paramVideoTransPara;
    AppMethodBeat.o(94271);
    return paramVideoTransPara;
  }
  
  public static void axM()
  {
    hnY = null;
  }
  
  public static com.tencent.mm.media.j.a getRenderer()
  {
    return hnY;
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/media/widget/camerarecordview/CameraRecorderFactory$getCPUMediaRecorder$1", "Lcom/tencent/mm/media/render/AbsSurfaceRenderer;", "doInitRenderProc", "Lcom/tencent/mm/media/render/proc/GLTextureRenderProc;", "plugin-mediaeditor_release"})
  public static final class a
    extends com.tencent.mm.media.j.a
  {
    a()
    {
      super(0, 0, 0, 62);
    }
    
    public final com.tencent.mm.media.j.b.a amG()
    {
      AppMethodBeat.i(94267);
      com.tencent.mm.media.j.b.a locala = (com.tencent.mm.media.j.b.a)new f(this.gNs, this.gNt, this.gOm, this.gOn, this.hqd, this.scaleType);
      AppMethodBeat.o(94267);
      return locala;
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/media/widget/camerarecordview/CameraRecorderFactory$getGPUMediaRecorder$1", "Lcom/tencent/mm/media/render/SurfaceTextureRenderer;", "doInitRenderProc", "Lcom/tencent/mm/media/render/proc/GLTextureRenderProc;", "plugin-mediaeditor_release"})
  public static final class b
    extends com.tencent.mm.media.j.d
  {
    b(boolean paramBoolean)
    {
      super();
    }
    
    public final com.tencent.mm.media.j.b.a amG()
    {
      AppMethodBeat.i(94268);
      if (this.hwt)
      {
        locala = (com.tencent.mm.media.j.b.a)new f(this.gNs, this.gNt, this.gOm, this.gOn, this.hqd, this.scaleType);
        AppMethodBeat.o(94268);
        return locala;
      }
      com.tencent.mm.media.j.b.a locala = (com.tencent.mm.media.j.b.a)new com.tencent.mm.media.j.b.c(this.gNs, this.gNt, this.gOm, this.gOn, this.hqd, this.scaleType);
      AppMethodBeat.o(94268);
      return locala;
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/media/widget/camerarecordview/CameraRecorderFactory$getGPUMediaRecorder$3", "Lcom/tencent/mm/media/render/AbsSurfaceRenderer;", "doInitRenderProc", "Lcom/tencent/mm/media/render/proc/GLTextureRenderProc;", "plugin-mediaeditor_release"})
  public static final class c
    extends com.tencent.mm.media.j.a
  {
    c()
    {
      super(0, 0, 0, 62);
    }
    
    public final com.tencent.mm.media.j.b.a amG()
    {
      AppMethodBeat.i(94269);
      com.tencent.mm.media.j.b.a locala = (com.tencent.mm.media.j.b.a)new f(this.gNs, this.gNt, this.gOm, this.gOn, this.hqd, this.scaleType);
      AppMethodBeat.o(94269);
      return locala;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.media.widget.camerarecordview.c
 * JD-Core Version:    0.7.0.1
 */