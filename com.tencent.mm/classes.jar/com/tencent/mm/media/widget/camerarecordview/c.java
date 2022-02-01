package com.tencent.mm.media.widget.camerarecordview;

import android.graphics.Point;
import android.opengl.EGLContext;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.media.i.b.f;
import com.tencent.mm.modelcontrol.VideoTransPara;
import d.g.b.k;
import d.l;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/media/widget/camerarecordview/CameraRecorderFactory;", "", "()V", "renderer", "Lcom/tencent/mm/media/render/AbsSurfaceRenderer;", "getRenderer", "()Lcom/tencent/mm/media/render/AbsSurfaceRenderer;", "setRenderer", "(Lcom/tencent/mm/media/render/AbsSurfaceRenderer;)V", "getAudioRecorder", "Lcom/tencent/mm/plugin/mmsight/model/encode/IMMSightAACRecorder;", "sampleRate", "", "bitrate", "audioChannelCount", "getCPUMediaRecorder", "Lcom/tencent/mm/media/widget/recorder/IMediaRecorder;", "recordType", "videoPara", "Lcom/tencent/mm/modelcontrol/VideoTransPara;", "camera", "Lcom/tencent/mm/media/widget/camera/ICommonCamera;", "getGPUMediaRecorder", "videoTransPara", "eglContext", "Landroid/opengl/EGLContext;", "view", "Lcom/tencent/mm/media/widget/camerarecordview/preview/ICameraPreviewView;", "useCPUCrop", "", "plugin-mediaeditor_release"})
public final class c
{
  private static com.tencent.mm.media.i.a gTi;
  public static final c hbw;
  
  static
  {
    AppMethodBeat.i(94272);
    hbw = new c();
    AppMethodBeat.o(94272);
  }
  
  public static com.tencent.mm.media.widget.c.b a(int paramInt, VideoTransPara paramVideoTransPara, com.tencent.mm.media.widget.a.e parame, EGLContext paramEGLContext, com.tencent.mm.media.widget.camerarecordview.preview.e parame1, boolean paramBoolean, com.tencent.mm.media.i.a parama)
  {
    AppMethodBeat.i(94270);
    k.h(paramVideoTransPara, "videoTransPara");
    k.h(parame, "camera");
    k.h(paramEGLContext, "eglContext");
    k.h(parame1, "view");
    if (paramInt == 2)
    {
      if (parama == null)
      {
        gTi = (com.tencent.mm.media.i.a)new b(paramBoolean);
        parama = gTi;
        if ((parama != null) && (parame.aty() != null))
        {
          parama.cS(com.tencent.mm.media.widget.a.b.getPreviewWidth(), com.tencent.mm.media.widget.a.b.getPreviewHeight());
          parama.mE(com.tencent.mm.media.widget.a.b.atq());
          parama.ee(com.tencent.mm.media.widget.a.b.att());
        }
        parame = gTi;
        parame1 = parame1.getPreviewTexture();
        if (parame1 == null) {
          break label155;
        }
      }
      label155:
      for (paramInt = parame1.gRW;; paramInt = -1)
      {
        paramVideoTransPara = (com.tencent.mm.media.widget.c.b)new com.tencent.mm.media.widget.c.c(paramVideoTransPara, parame, paramEGLContext, paramInt);
        AppMethodBeat.o(94270);
        return paramVideoTransPara;
        gTi = parama;
        break;
      }
    }
    if (parama == null) {}
    for (gTi = (com.tencent.mm.media.i.a)new c();; gTi = parama)
    {
      paramEGLContext = gTi;
      if ((paramEGLContext != null) && (parame.aty() != null))
      {
        parame1 = com.tencent.mm.media.widget.a.b.atu();
        paramEGLContext.cS(parame1.x, parame1.y);
        paramEGLContext.mE(com.tencent.mm.media.widget.a.b.atq());
        paramEGLContext.ee(com.tencent.mm.media.widget.a.b.att());
      }
      paramVideoTransPara = new com.tencent.mm.media.widget.c.d(paramVideoTransPara, gTi);
      parame.a(paramVideoTransPara.getFrameDataCallback());
      paramVideoTransPara = (com.tencent.mm.media.widget.c.b)paramVideoTransPara;
      AppMethodBeat.o(94270);
      return paramVideoTransPara;
    }
  }
  
  public static com.tencent.mm.media.widget.c.b a(int paramInt, VideoTransPara paramVideoTransPara, com.tencent.mm.media.widget.a.e parame, com.tencent.mm.media.i.a parama)
  {
    AppMethodBeat.i(94271);
    k.h(paramVideoTransPara, "videoPara");
    k.h(parame, "camera");
    if (paramInt == 2)
    {
      if (parama == null) {}
      for (gTi = (com.tencent.mm.media.i.a)new a();; gTi = parama)
      {
        parama = gTi;
        if ((parama != null) && (parame.aty() != null))
        {
          Point localPoint = com.tencent.mm.media.widget.a.b.atu();
          parama.cS(localPoint.x, localPoint.y);
          parama.mE(com.tencent.mm.media.widget.a.b.atq());
          parama.ee(com.tencent.mm.media.widget.a.b.att());
        }
        paramVideoTransPara = new com.tencent.mm.media.widget.c.c(paramVideoTransPara, gTi);
        parame.a(paramVideoTransPara.getFrameDataCallback());
        paramVideoTransPara = (com.tencent.mm.media.widget.c.b)paramVideoTransPara;
        AppMethodBeat.o(94271);
        return paramVideoTransPara;
      }
    }
    paramVideoTransPara = new com.tencent.mm.media.widget.c.e(paramVideoTransPara);
    if (parame.aty() != null) {
      paramVideoTransPara.setMirror(com.tencent.mm.media.widget.a.b.att());
    }
    parame.a(paramVideoTransPara.getFrameDataCallback());
    paramVideoTransPara = (com.tencent.mm.media.widget.c.b)paramVideoTransPara;
    AppMethodBeat.o(94271);
    return paramVideoTransPara;
  }
  
  public static void auK()
  {
    gTi = null;
  }
  
  public static com.tencent.mm.media.i.a getRenderer()
  {
    return gTi;
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/media/widget/camerarecordview/CameraRecorderFactory$getCPUMediaRecorder$1", "Lcom/tencent/mm/media/render/AbsSurfaceRenderer;", "doInitRenderProc", "Lcom/tencent/mm/media/render/proc/GLTextureRenderProc;", "plugin-mediaeditor_release"})
  public static final class a
    extends com.tencent.mm.media.i.a
  {
    a()
    {
      super(0, 0, 0, 62);
    }
    
    public final com.tencent.mm.media.i.b.a ajF()
    {
      AppMethodBeat.i(94267);
      com.tencent.mm.media.i.b.a locala = (com.tencent.mm.media.i.b.a)new f(this.gqZ, this.gra, this.grV, this.grW, this.gVm, this.scaleType);
      AppMethodBeat.o(94267);
      return locala;
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/media/widget/camerarecordview/CameraRecorderFactory$getGPUMediaRecorder$1", "Lcom/tencent/mm/media/render/SurfaceTextureRenderer;", "doInitRenderProc", "Lcom/tencent/mm/media/render/proc/GLTextureRenderProc;", "plugin-mediaeditor_release"})
  public static final class b
    extends com.tencent.mm.media.i.d
  {
    b(boolean paramBoolean)
    {
      super();
    }
    
    public final com.tencent.mm.media.i.b.a ajF()
    {
      AppMethodBeat.i(94268);
      if (this.hbx)
      {
        locala = (com.tencent.mm.media.i.b.a)new f(this.gqZ, this.gra, this.grV, this.grW, this.gVm, this.scaleType);
        AppMethodBeat.o(94268);
        return locala;
      }
      com.tencent.mm.media.i.b.a locala = (com.tencent.mm.media.i.b.a)new com.tencent.mm.media.i.b.c(this.gqZ, this.gra, this.grV, this.grW, this.gVm, this.scaleType);
      AppMethodBeat.o(94268);
      return locala;
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/media/widget/camerarecordview/CameraRecorderFactory$getGPUMediaRecorder$3", "Lcom/tencent/mm/media/render/AbsSurfaceRenderer;", "doInitRenderProc", "Lcom/tencent/mm/media/render/proc/GLTextureRenderProc;", "plugin-mediaeditor_release"})
  public static final class c
    extends com.tencent.mm.media.i.a
  {
    c()
    {
      super(0, 0, 0, 62);
    }
    
    public final com.tencent.mm.media.i.b.a ajF()
    {
      AppMethodBeat.i(94269);
      com.tencent.mm.media.i.b.a locala = (com.tencent.mm.media.i.b.a)new f(this.gqZ, this.gra, this.grV, this.grW, this.gVm, this.scaleType);
      AppMethodBeat.o(94269);
      return locala;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.media.widget.camerarecordview.c
 * JD-Core Version:    0.7.0.1
 */