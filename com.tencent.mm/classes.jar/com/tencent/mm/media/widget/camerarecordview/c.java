package com.tencent.mm.media.widget.camerarecordview;

import android.graphics.Point;
import android.opengl.EGLContext;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.media.j.b.f;
import com.tencent.mm.modelcontrol.VideoTransPara;
import d.g.b.p;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/media/widget/camerarecordview/CameraRecorderFactory;", "", "()V", "renderer", "Lcom/tencent/mm/media/render/AbsSurfaceRenderer;", "getRenderer", "()Lcom/tencent/mm/media/render/AbsSurfaceRenderer;", "setRenderer", "(Lcom/tencent/mm/media/render/AbsSurfaceRenderer;)V", "getAudioRecorder", "Lcom/tencent/mm/plugin/mmsight/model/encode/IMMSightAACRecorder;", "sampleRate", "", "bitrate", "audioChannelCount", "getCPUMediaRecorder", "Lcom/tencent/mm/media/widget/recorder/IMediaRecorder;", "recordType", "videoPara", "Lcom/tencent/mm/modelcontrol/VideoTransPara;", "camera", "Lcom/tencent/mm/media/widget/camera/ICommonCamera;", "getGPUMediaRecorder", "videoTransPara", "eglContext", "Landroid/opengl/EGLContext;", "view", "Lcom/tencent/mm/media/widget/camerarecordview/preview/ICameraPreviewView;", "useCPUCrop", "", "plugin-mediaeditor_release"})
public final class c
{
  private static com.tencent.mm.media.j.a hlj;
  public static final c htE;
  
  static
  {
    AppMethodBeat.i(94272);
    htE = new c();
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
        hlj = (com.tencent.mm.media.j.a)new b(paramBoolean);
        parama = hlj;
        if ((parama != null) && (parame.awl() != null))
        {
          parama.cU(com.tencent.mm.media.widget.a.b.getPreviewWidth(), com.tencent.mm.media.widget.a.b.getPreviewHeight());
          parama.nd(com.tencent.mm.media.widget.a.b.awd());
          parama.eg(com.tencent.mm.media.widget.a.b.awg());
        }
        parame = hlj;
        parame1 = parame1.getPreviewTexture();
        if (parame1 == null) {
          break label155;
        }
      }
      label155:
      for (paramInt = parame1.hko;; paramInt = -1)
      {
        paramVideoTransPara = (com.tencent.mm.media.widget.c.b)new com.tencent.mm.media.widget.c.c(paramVideoTransPara, parame, paramEGLContext, paramInt);
        AppMethodBeat.o(94270);
        return paramVideoTransPara;
        hlj = parama;
        break;
      }
    }
    if (parama == null) {}
    for (hlj = (com.tencent.mm.media.j.a)new c();; hlj = parama)
    {
      paramEGLContext = hlj;
      if ((paramEGLContext != null) && (parame.awl() != null))
      {
        parame1 = com.tencent.mm.media.widget.a.b.awh();
        paramEGLContext.cU(parame1.x, parame1.y);
        paramEGLContext.nd(com.tencent.mm.media.widget.a.b.awd());
        paramEGLContext.eg(com.tencent.mm.media.widget.a.b.awg());
      }
      paramVideoTransPara = new com.tencent.mm.media.widget.c.d(paramVideoTransPara, hlj);
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
      for (hlj = (com.tencent.mm.media.j.a)new a();; hlj = parama)
      {
        parama = hlj;
        if ((parama != null) && (parame.awl() != null))
        {
          Point localPoint = com.tencent.mm.media.widget.a.b.awh();
          parama.cU(localPoint.x, localPoint.y);
          parama.nd(com.tencent.mm.media.widget.a.b.awd());
          parama.eg(com.tencent.mm.media.widget.a.b.awg());
        }
        paramVideoTransPara = new com.tencent.mm.media.widget.c.c(paramVideoTransPara, hlj);
        parame.a(paramVideoTransPara.getFrameDataCallback());
        paramVideoTransPara = (com.tencent.mm.media.widget.c.b)paramVideoTransPara;
        AppMethodBeat.o(94271);
        return paramVideoTransPara;
      }
    }
    paramVideoTransPara = new com.tencent.mm.media.widget.c.e(paramVideoTransPara);
    if (parame.awl() != null) {
      paramVideoTransPara.setMirror(com.tencent.mm.media.widget.a.b.awg());
    }
    parame.a(paramVideoTransPara.getFrameDataCallback());
    paramVideoTransPara = (com.tencent.mm.media.widget.c.b)paramVideoTransPara;
    AppMethodBeat.o(94271);
    return paramVideoTransPara;
  }
  
  public static void axx()
  {
    hlj = null;
  }
  
  public static com.tencent.mm.media.j.a getRenderer()
  {
    return hlj;
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/media/widget/camerarecordview/CameraRecorderFactory$getCPUMediaRecorder$1", "Lcom/tencent/mm/media/render/AbsSurfaceRenderer;", "doInitRenderProc", "Lcom/tencent/mm/media/render/proc/GLTextureRenderProc;", "plugin-mediaeditor_release"})
  public static final class a
    extends com.tencent.mm.media.j.a
  {
    a()
    {
      super(0, 0, 0, 62);
    }
    
    public final com.tencent.mm.media.j.b.a amr()
    {
      AppMethodBeat.i(94267);
      com.tencent.mm.media.j.b.a locala = (com.tencent.mm.media.j.b.a)new f(this.gKJ, this.gKK, this.gLD, this.gLE, this.hnp, this.scaleType);
      AppMethodBeat.o(94267);
      return locala;
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/media/widget/camerarecordview/CameraRecorderFactory$getGPUMediaRecorder$1", "Lcom/tencent/mm/media/render/SurfaceTextureRenderer;", "doInitRenderProc", "Lcom/tencent/mm/media/render/proc/GLTextureRenderProc;", "plugin-mediaeditor_release"})
  public static final class b
    extends com.tencent.mm.media.j.d
  {
    b(boolean paramBoolean)
    {
      super();
    }
    
    public final com.tencent.mm.media.j.b.a amr()
    {
      AppMethodBeat.i(94268);
      if (this.htF)
      {
        locala = (com.tencent.mm.media.j.b.a)new f(this.gKJ, this.gKK, this.gLD, this.gLE, this.hnp, this.scaleType);
        AppMethodBeat.o(94268);
        return locala;
      }
      com.tencent.mm.media.j.b.a locala = (com.tencent.mm.media.j.b.a)new com.tencent.mm.media.j.b.c(this.gKJ, this.gKK, this.gLD, this.gLE, this.hnp, this.scaleType);
      AppMethodBeat.o(94268);
      return locala;
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/media/widget/camerarecordview/CameraRecorderFactory$getGPUMediaRecorder$3", "Lcom/tencent/mm/media/render/AbsSurfaceRenderer;", "doInitRenderProc", "Lcom/tencent/mm/media/render/proc/GLTextureRenderProc;", "plugin-mediaeditor_release"})
  public static final class c
    extends com.tencent.mm.media.j.a
  {
    c()
    {
      super(0, 0, 0, 62);
    }
    
    public final com.tencent.mm.media.j.b.a amr()
    {
      AppMethodBeat.i(94269);
      com.tencent.mm.media.j.b.a locala = (com.tencent.mm.media.j.b.a)new f(this.gKJ, this.gKK, this.gLD, this.gLE, this.hnp, this.scaleType);
      AppMethodBeat.o(94269);
      return locala;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.media.widget.camerarecordview.c
 * JD-Core Version:    0.7.0.1
 */