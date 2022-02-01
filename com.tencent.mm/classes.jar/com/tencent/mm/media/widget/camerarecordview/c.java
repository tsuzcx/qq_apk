package com.tencent.mm.media.widget.camerarecordview;

import android.graphics.Point;
import android.opengl.EGLContext;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.media.j.b.f;
import com.tencent.mm.modelcontrol.VideoTransPara;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/media/widget/camerarecordview/CameraRecorderFactory;", "", "()V", "renderer", "Lcom/tencent/mm/media/render/AbsSurfaceRenderer;", "getRenderer", "()Lcom/tencent/mm/media/render/AbsSurfaceRenderer;", "setRenderer", "(Lcom/tencent/mm/media/render/AbsSurfaceRenderer;)V", "getAudioRecorder", "Lcom/tencent/mm/plugin/mmsight/model/encode/IMMSightAACRecorder;", "sampleRate", "", "bitrate", "audioChannelCount", "getCPUMediaRecorder", "Lcom/tencent/mm/media/widget/recorder/IMediaRecorder;", "recordType", "videoPara", "Lcom/tencent/mm/modelcontrol/VideoTransPara;", "camera", "Lcom/tencent/mm/media/widget/camera/ICommonCamera;", "getGPUMediaRecorder", "videoTransPara", "eglContext", "Landroid/opengl/EGLContext;", "view", "Lcom/tencent/mm/media/widget/camerarecordview/preview/ICameraPreviewView;", "useCPUCrop", "", "plugin-mediaeditor_release"})
public final class c
{
  private static com.tencent.mm.media.j.a ihs;
  public static final c ipU;
  
  static
  {
    AppMethodBeat.i(94272);
    ipU = new c();
    AppMethodBeat.o(94272);
  }
  
  public static com.tencent.mm.media.widget.c.b a(int paramInt, VideoTransPara paramVideoTransPara, com.tencent.mm.media.widget.a.d paramd, EGLContext paramEGLContext, com.tencent.mm.media.widget.camerarecordview.preview.e parame, boolean paramBoolean, com.tencent.mm.media.j.a parama)
  {
    AppMethodBeat.i(94270);
    p.h(paramVideoTransPara, "videoTransPara");
    p.h(paramd, "camera");
    p.h(paramEGLContext, "eglContext");
    p.h(parame, "view");
    if (paramInt == 2)
    {
      if (parama == null)
      {
        ihs = (com.tencent.mm.media.j.a)new b(paramBoolean);
        parama = ihs;
        if ((parama != null) && (paramd.aPr() != null))
        {
          parama.cZ(com.tencent.mm.media.widget.a.b.getPreviewWidth(), com.tencent.mm.media.widget.a.b.getPreviewHeight());
          parama.qx(com.tencent.mm.media.widget.a.b.aPk());
          parama.eD(com.tencent.mm.media.widget.a.b.aPn());
        }
        paramd = ihs;
        parame = parame.getPreviewTexture();
        if (parame == null) {
          break label155;
        }
      }
      label155:
      for (paramInt = parame.igv;; paramInt = -1)
      {
        paramVideoTransPara = (com.tencent.mm.media.widget.c.b)new com.tencent.mm.media.widget.c.c(paramVideoTransPara, paramd, paramEGLContext, paramInt);
        AppMethodBeat.o(94270);
        return paramVideoTransPara;
        ihs = parama;
        break;
      }
    }
    if (parama == null) {}
    for (ihs = (com.tencent.mm.media.j.a)new c();; ihs = parama)
    {
      paramEGLContext = ihs;
      if ((paramEGLContext != null) && (paramd.aPr() != null))
      {
        parame = com.tencent.mm.media.widget.a.b.aPo();
        paramEGLContext.cZ(parame.x, parame.y);
        paramEGLContext.qx(com.tencent.mm.media.widget.a.b.aPk());
        paramEGLContext.eD(com.tencent.mm.media.widget.a.b.aPn());
      }
      paramVideoTransPara = new com.tencent.mm.media.widget.c.d(paramVideoTransPara, ihs);
      paramd.a(paramVideoTransPara.getFrameDataCallback());
      paramVideoTransPara = (com.tencent.mm.media.widget.c.b)paramVideoTransPara;
      AppMethodBeat.o(94270);
      return paramVideoTransPara;
    }
  }
  
  public static com.tencent.mm.media.widget.c.b a(int paramInt, VideoTransPara paramVideoTransPara, com.tencent.mm.media.widget.a.d paramd, com.tencent.mm.media.j.a parama)
  {
    AppMethodBeat.i(94271);
    p.h(paramVideoTransPara, "videoPara");
    p.h(paramd, "camera");
    if (paramInt == 2)
    {
      if (parama == null) {}
      for (ihs = (com.tencent.mm.media.j.a)new a();; ihs = parama)
      {
        parama = ihs;
        if ((parama != null) && (paramd.aPr() != null))
        {
          Point localPoint = com.tencent.mm.media.widget.a.b.aPo();
          parama.cZ(localPoint.x, localPoint.y);
          parama.qx(com.tencent.mm.media.widget.a.b.aPk());
          parama.eD(com.tencent.mm.media.widget.a.b.aPn());
        }
        paramVideoTransPara = new com.tencent.mm.media.widget.c.c(paramVideoTransPara, ihs);
        paramd.a(paramVideoTransPara.getFrameDataCallback());
        paramVideoTransPara = (com.tencent.mm.media.widget.c.b)paramVideoTransPara;
        AppMethodBeat.o(94271);
        return paramVideoTransPara;
      }
    }
    paramVideoTransPara = new com.tencent.mm.media.widget.c.e(paramVideoTransPara);
    if (paramd.aPr() != null) {
      paramVideoTransPara.setMirror(com.tencent.mm.media.widget.a.b.aPn());
    }
    paramd.a(paramVideoTransPara.getFrameDataCallback());
    paramVideoTransPara = (com.tencent.mm.media.widget.c.b)paramVideoTransPara;
    AppMethodBeat.o(94271);
    return paramVideoTransPara;
  }
  
  public static void aQk()
  {
    ihs = null;
  }
  
  public static com.tencent.mm.media.j.a getRenderer()
  {
    return ihs;
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/media/widget/camerarecordview/CameraRecorderFactory$getCPUMediaRecorder$1", "Lcom/tencent/mm/media/render/AbsSurfaceRenderer;", "doInitRenderProc", "Lcom/tencent/mm/media/render/proc/GLTextureRenderProc;", "plugin-mediaeditor_release"})
  public static final class a
    extends com.tencent.mm.media.j.a
  {
    a()
    {
      super(0, 0, 0, 62);
    }
    
    public final com.tencent.mm.media.j.b.a aEC()
    {
      AppMethodBeat.i(94267);
      com.tencent.mm.media.j.b.a locala = (com.tencent.mm.media.j.b.a)new f(this.hDn, this.hDo, this.hEp, this.hEq, this.ijy, this.scaleType);
      AppMethodBeat.o(94267);
      return locala;
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/media/widget/camerarecordview/CameraRecorderFactory$getGPUMediaRecorder$1", "Lcom/tencent/mm/media/render/SurfaceTextureRenderer;", "doInitRenderProc", "Lcom/tencent/mm/media/render/proc/GLTextureRenderProc;", "plugin-mediaeditor_release"})
  public static final class b
    extends com.tencent.mm.media.j.d
  {
    b(boolean paramBoolean)
    {
      super();
    }
    
    public final com.tencent.mm.media.j.b.a aEC()
    {
      AppMethodBeat.i(94268);
      if (this.ipV)
      {
        locala = (com.tencent.mm.media.j.b.a)new f(this.hDn, this.hDo, this.hEp, this.hEq, this.ijy, this.scaleType);
        AppMethodBeat.o(94268);
        return locala;
      }
      com.tencent.mm.media.j.b.a locala = (com.tencent.mm.media.j.b.a)new com.tencent.mm.media.j.b.c(this.hDn, this.hDo, this.hEp, this.hEq, this.ijy, this.scaleType);
      AppMethodBeat.o(94268);
      return locala;
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/media/widget/camerarecordview/CameraRecorderFactory$getGPUMediaRecorder$3", "Lcom/tencent/mm/media/render/AbsSurfaceRenderer;", "doInitRenderProc", "Lcom/tencent/mm/media/render/proc/GLTextureRenderProc;", "plugin-mediaeditor_release"})
  public static final class c
    extends com.tencent.mm.media.j.a
  {
    c()
    {
      super(0, 0, 0, 62);
    }
    
    public final com.tencent.mm.media.j.b.a aEC()
    {
      AppMethodBeat.i(94269);
      com.tencent.mm.media.j.b.a locala = (com.tencent.mm.media.j.b.a)new f(this.hDn, this.hDo, this.hEp, this.hEq, this.ijy, this.scaleType);
      AppMethodBeat.o(94269);
      return locala;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.media.widget.camerarecordview.c
 * JD-Core Version:    0.7.0.1
 */