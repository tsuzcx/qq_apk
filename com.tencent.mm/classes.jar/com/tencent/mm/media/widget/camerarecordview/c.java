package com.tencent.mm.media.widget.camerarecordview;

import android.graphics.Point;
import android.opengl.EGLContext;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.media.j.b.f;
import com.tencent.mm.modelcontrol.VideoTransPara;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/media/widget/camerarecordview/CameraRecorderFactory;", "", "()V", "renderer", "Lcom/tencent/mm/media/render/AbsSurfaceRenderer;", "getRenderer", "()Lcom/tencent/mm/media/render/AbsSurfaceRenderer;", "setRenderer", "(Lcom/tencent/mm/media/render/AbsSurfaceRenderer;)V", "getAudioRecorder", "Lcom/tencent/mm/plugin/mmsight/model/encode/IMMSightAACRecorder;", "sampleRate", "", "bitrate", "audioChannelCount", "getCPUMediaRecorder", "Lcom/tencent/mm/media/widget/recorder/IMediaRecorder;", "recordType", "videoPara", "Lcom/tencent/mm/modelcontrol/VideoTransPara;", "camera", "Lcom/tencent/mm/media/widget/camera/ICommonCamera;", "getGPUMediaRecorder", "videoTransPara", "eglContext", "Landroid/opengl/EGLContext;", "view", "Lcom/tencent/mm/media/widget/camerarecordview/preview/ICameraPreviewView;", "useCPUCrop", "", "plugin-mediaeditor_release"})
public final class c
{
  private static com.tencent.mm.media.j.a kWg;
  public static final c lfa;
  
  static
  {
    AppMethodBeat.i(94272);
    lfa = new c();
    AppMethodBeat.o(94272);
  }
  
  public static com.tencent.mm.media.widget.c.b a(int paramInt, VideoTransPara paramVideoTransPara, com.tencent.mm.media.widget.a.e parame, EGLContext paramEGLContext, com.tencent.mm.media.widget.camerarecordview.preview.e parame1, boolean paramBoolean, com.tencent.mm.media.j.a parama)
  {
    AppMethodBeat.i(94270);
    p.k(paramVideoTransPara, "videoTransPara");
    p.k(parame, "camera");
    p.k(paramEGLContext, "eglContext");
    p.k(parame1, "view");
    if (paramInt == 2)
    {
      if (parama == null)
      {
        kWg = (com.tencent.mm.media.j.a)new b(paramBoolean);
        parama = kWg;
        if ((parama != null) && (parame.aYf() != null))
        {
          parama.dv(com.tencent.mm.media.widget.a.b.getPreviewWidth(), com.tencent.mm.media.widget.a.b.getPreviewHeight());
          parama.tm(com.tencent.mm.media.widget.a.b.aVp());
          parama.fj(com.tencent.mm.media.widget.a.b.isFrontCamera());
        }
        parame = kWg;
        parame1 = parame1.getPreviewTexture();
        if (parame1 == null) {
          break label155;
        }
      }
      label155:
      for (paramInt = parame1.kVj;; paramInt = -1)
      {
        paramVideoTransPara = (com.tencent.mm.media.widget.c.b)new com.tencent.mm.media.widget.c.c(paramVideoTransPara, parame, paramEGLContext, paramInt);
        AppMethodBeat.o(94270);
        return paramVideoTransPara;
        kWg = parama;
        break;
      }
    }
    if (parama == null) {}
    for (kWg = (com.tencent.mm.media.j.a)new c();; kWg = parama)
    {
      paramEGLContext = kWg;
      if ((paramEGLContext != null) && (parame.aYf() != null))
      {
        parame1 = com.tencent.mm.media.widget.a.b.aYa();
        paramEGLContext.dv(parame1.x, parame1.y);
        paramEGLContext.tm(com.tencent.mm.media.widget.a.b.aVp());
        paramEGLContext.fj(com.tencent.mm.media.widget.a.b.isFrontCamera());
      }
      paramVideoTransPara = new com.tencent.mm.media.widget.c.d(paramVideoTransPara, kWg);
      parame.a(paramVideoTransPara.getFrameDataCallback());
      paramVideoTransPara = (com.tencent.mm.media.widget.c.b)paramVideoTransPara;
      AppMethodBeat.o(94270);
      return paramVideoTransPara;
    }
  }
  
  public static com.tencent.mm.media.widget.c.b a(int paramInt, VideoTransPara paramVideoTransPara, com.tencent.mm.media.widget.a.e parame, com.tencent.mm.media.j.a parama)
  {
    AppMethodBeat.i(94271);
    p.k(paramVideoTransPara, "videoPara");
    p.k(parame, "camera");
    if (paramInt == 2)
    {
      if (parama == null) {}
      for (kWg = (com.tencent.mm.media.j.a)new a();; kWg = parama)
      {
        parama = kWg;
        if ((parama != null) && (parame.aYf() != null))
        {
          Point localPoint = com.tencent.mm.media.widget.a.b.aYa();
          parama.dv(localPoint.x, localPoint.y);
          parama.tm(com.tencent.mm.media.widget.a.b.aVp());
          parama.fj(com.tencent.mm.media.widget.a.b.isFrontCamera());
        }
        paramVideoTransPara = new com.tencent.mm.media.widget.c.c(paramVideoTransPara, kWg);
        parame.a(paramVideoTransPara.getFrameDataCallback());
        paramVideoTransPara = (com.tencent.mm.media.widget.c.b)paramVideoTransPara;
        AppMethodBeat.o(94271);
        return paramVideoTransPara;
      }
    }
    paramVideoTransPara = new com.tencent.mm.media.widget.c.e(paramVideoTransPara);
    if (parame.aYf() != null) {
      paramVideoTransPara.setMirror(com.tencent.mm.media.widget.a.b.isFrontCamera());
    }
    parame.a(paramVideoTransPara.getFrameDataCallback());
    paramVideoTransPara = (com.tencent.mm.media.widget.c.b)paramVideoTransPara;
    AppMethodBeat.o(94271);
    return paramVideoTransPara;
  }
  
  public static void aZb()
  {
    kWg = null;
  }
  
  public static com.tencent.mm.media.j.a getRenderer()
  {
    return kWg;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/media/widget/camerarecordview/CameraRecorderFactory$getCPUMediaRecorder$1", "Lcom/tencent/mm/media/render/AbsSurfaceRenderer;", "doInitRenderProc", "Lcom/tencent/mm/media/render/proc/GLTextureRenderProc;", "plugin-mediaeditor_release"})
  public static final class a
    extends com.tencent.mm.media.j.a
  {
    a()
    {
      super(0, 0, 0, 62);
    }
    
    public final com.tencent.mm.media.j.b.a aMT()
    {
      AppMethodBeat.i(94267);
      com.tencent.mm.media.j.b.a locala = (com.tencent.mm.media.j.b.a)new f(this.krg, this.krh, this.ksu, this.ksv, aVh(), getScaleType());
      AppMethodBeat.o(94267);
      return locala;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/media/widget/camerarecordview/CameraRecorderFactory$getGPUMediaRecorder$1", "Lcom/tencent/mm/media/render/SurfaceTextureRenderer;", "doInitRenderProc", "Lcom/tencent/mm/media/render/proc/GLTextureRenderProc;", "plugin-mediaeditor_release"})
  public static final class b
    extends com.tencent.mm.media.j.d
  {
    b(boolean paramBoolean)
    {
      super();
    }
    
    public final com.tencent.mm.media.j.b.a aMT()
    {
      AppMethodBeat.i(94268);
      if (this.lfb)
      {
        locala = (com.tencent.mm.media.j.b.a)new f(this.krg, this.krh, this.ksu, this.ksv, aVh(), getScaleType());
        AppMethodBeat.o(94268);
        return locala;
      }
      com.tencent.mm.media.j.b.a locala = (com.tencent.mm.media.j.b.a)new com.tencent.mm.media.j.b.c(this.krg, this.krh, this.ksu, this.ksv, aVh(), getScaleType());
      AppMethodBeat.o(94268);
      return locala;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/media/widget/camerarecordview/CameraRecorderFactory$getGPUMediaRecorder$3", "Lcom/tencent/mm/media/render/AbsSurfaceRenderer;", "doInitRenderProc", "Lcom/tencent/mm/media/render/proc/GLTextureRenderProc;", "plugin-mediaeditor_release"})
  public static final class c
    extends com.tencent.mm.media.j.a
  {
    c()
    {
      super(0, 0, 0, 62);
    }
    
    public final com.tencent.mm.media.j.b.a aMT()
    {
      AppMethodBeat.i(94269);
      com.tencent.mm.media.j.b.a locala = (com.tencent.mm.media.j.b.a)new f(this.krg, this.krh, this.ksu, this.ksv, aVh(), getScaleType());
      AppMethodBeat.o(94269);
      return locala;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.media.widget.camerarecordview.c
 * JD-Core Version:    0.7.0.1
 */