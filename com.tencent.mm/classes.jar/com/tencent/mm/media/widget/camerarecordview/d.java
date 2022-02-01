package com.tencent.mm.media.widget.camerarecordview;

import android.graphics.Point;
import android.opengl.EGLContext;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.media.widget.c.e;
import com.tencent.mm.modelcontrol.VideoTransPara;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/media/widget/camerarecordview/CameraRecorderFactory;", "", "()V", "renderer", "Lcom/tencent/mm/media/render/AbsSurfaceRenderer;", "getRenderer", "()Lcom/tencent/mm/media/render/AbsSurfaceRenderer;", "setRenderer", "(Lcom/tencent/mm/media/render/AbsSurfaceRenderer;)V", "getAudioRecorder", "Lcom/tencent/mm/plugin/mmsight/model/encode/IMMSightAACRecorder;", "sampleRate", "", "bitrate", "audioChannelCount", "getCPUMediaRecorder", "Lcom/tencent/mm/media/widget/recorder/IMediaRecorder;", "recordType", "videoPara", "Lcom/tencent/mm/modelcontrol/VideoTransPara;", "camera", "Lcom/tencent/mm/media/widget/camera/ICommonCamera;", "getGPUMediaRecorder", "videoTransPara", "eglContext", "Landroid/opengl/EGLContext;", "view", "Lcom/tencent/mm/media/widget/camerarecordview/preview/ICameraPreviewView;", "plugin-mediaeditor_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class d
{
  private static com.tencent.mm.media.j.a nBj;
  public static final d nJI;
  
  static
  {
    AppMethodBeat.i(94272);
    nJI = new d();
    AppMethodBeat.o(94272);
  }
  
  public static com.tencent.mm.media.widget.c.b a(int paramInt, VideoTransPara paramVideoTransPara, com.tencent.mm.media.widget.a.f paramf, EGLContext paramEGLContext, com.tencent.mm.media.widget.camerarecordview.preview.b paramb, com.tencent.mm.media.j.a parama)
  {
    int i = -1;
    AppMethodBeat.i(237632);
    s.u(paramVideoTransPara, "videoTransPara");
    s.u(paramf, "camera");
    s.u(paramEGLContext, "eglContext");
    s.u(paramb, "view");
    Object localObject = (kotlin.g.a.a)new d.b(paramInt);
    if (paramInt == 2)
    {
      if (parama == null)
      {
        nBj = (com.tencent.mm.media.j.a)((kotlin.g.a.a)localObject).invoke();
        parama = nBj;
        if (parama != null)
        {
          localObject = com.tencent.mm.media.widget.a.c.nGn;
          if (!com.tencent.mm.media.widget.a.c.bsQ()) {
            break label152;
          }
          parama.el(paramVideoTransPara.width, paramVideoTransPara.height);
        }
        label103:
        paramf = nBj;
        paramb = paramb.getPreviewTexture();
        if (paramb != null) {
          break label191;
        }
      }
      for (;;)
      {
        paramVideoTransPara = (com.tencent.mm.media.widget.c.b)new com.tencent.mm.media.widget.c.c(paramVideoTransPara, paramf, paramEGLContext, i);
        AppMethodBeat.o(237632);
        return paramVideoTransPara;
        nBj = parama;
        break;
        label152:
        if (paramf.btc() == null) {
          break label103;
        }
        parama.el(com.tencent.mm.media.widget.a.b.getPreviewWidth(), com.tencent.mm.media.widget.a.b.getPreviewHeight());
        parama.th(com.tencent.mm.media.widget.a.b.bsL());
        parama.fQ(com.tencent.mm.media.widget.a.b.isFrontCamera());
        break label103;
        label191:
        i = paramb.nAF;
      }
    }
    if (parama == null)
    {
      nBj = (com.tencent.mm.media.j.a)((kotlin.g.a.a)localObject).invoke();
      parama = nBj;
      if (parama != null)
      {
        localObject = com.tencent.mm.media.widget.a.c.nGn;
        if (!com.tencent.mm.media.widget.a.c.bsQ()) {
          break label302;
        }
        parama.el(paramVideoTransPara.width, paramVideoTransPara.height);
      }
      label253:
      paramf = nBj;
      paramb = paramb.getPreviewTexture();
      if (paramb != null) {
        break label347;
      }
    }
    for (;;)
    {
      paramVideoTransPara = (com.tencent.mm.media.widget.c.b)new com.tencent.mm.media.widget.c.d(paramVideoTransPara, paramf, paramEGLContext, i);
      AppMethodBeat.o(237632);
      return paramVideoTransPara;
      nBj = parama;
      break;
      label302:
      if (paramf.btc() == null) {
        break label253;
      }
      paramf = com.tencent.mm.media.widget.a.b.bsP();
      parama.el(paramf.x, paramf.y);
      parama.th(com.tencent.mm.media.widget.a.b.bsL());
      parama.fQ(com.tencent.mm.media.widget.a.b.isFrontCamera());
      break label253;
      label347:
      i = paramb.nAF;
    }
  }
  
  public static com.tencent.mm.media.widget.c.b a(int paramInt, VideoTransPara paramVideoTransPara, com.tencent.mm.media.widget.a.f paramf, com.tencent.mm.media.j.a parama)
  {
    AppMethodBeat.i(94271);
    s.u(paramVideoTransPara, "videoPara");
    s.u(paramf, "camera");
    if (paramInt == 2)
    {
      if (parama == null) {}
      for (nBj = (com.tencent.mm.media.j.a)new a();; nBj = parama)
      {
        parama = nBj;
        if ((parama != null) && (paramf.btc() != null))
        {
          Point localPoint = com.tencent.mm.media.widget.a.b.bsP();
          parama.el(localPoint.x, localPoint.y);
          parama.th(com.tencent.mm.media.widget.a.b.bsL());
          parama.fQ(com.tencent.mm.media.widget.a.b.isFrontCamera());
        }
        paramVideoTransPara = new com.tencent.mm.media.widget.c.c(paramVideoTransPara, nBj);
        paramf.a(paramVideoTransPara.getFrameDataCallback());
        paramVideoTransPara = (com.tencent.mm.media.widget.c.b)paramVideoTransPara;
        AppMethodBeat.o(94271);
        return paramVideoTransPara;
      }
    }
    paramVideoTransPara = new e(paramVideoTransPara);
    if (paramf.btc() != null) {
      paramVideoTransPara.setMirror(com.tencent.mm.media.widget.a.b.isFrontCamera());
    }
    paramf.a(paramVideoTransPara.getFrameDataCallback());
    paramVideoTransPara = (com.tencent.mm.media.widget.c.b)paramVideoTransPara;
    AppMethodBeat.o(94271);
    return paramVideoTransPara;
  }
  
  public static void bua()
  {
    nBj = null;
  }
  
  public static com.tencent.mm.media.j.a getRenderer()
  {
    return nBj;
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/media/widget/camerarecordview/CameraRecorderFactory$getCPUMediaRecorder$1", "Lcom/tencent/mm/media/render/AbsSurfaceRenderer;", "doInitRenderProc", "Lcom/tencent/mm/media/render/proc/GLTextureRenderProc;", "plugin-mediaeditor_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
    extends com.tencent.mm.media.j.a
  {
    a()
    {
      super(0, 0, 0, 62);
    }
    
    public final com.tencent.mm.media.j.b.a bgD()
    {
      AppMethodBeat.i(94267);
      com.tencent.mm.media.j.b.a locala = (com.tencent.mm.media.j.b.a)new com.tencent.mm.media.j.b.f(this.mVd, this.mVe, this.mWn, this.mWo, bpJ(), getScaleType());
      AppMethodBeat.o(94267);
      return locala;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.media.widget.camerarecordview.d
 * JD-Core Version:    0.7.0.1
 */