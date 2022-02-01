package com.tencent.mm.media.widget.camerarecordview;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.media.g.d;
import com.tencent.mm.media.j.b.f;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/media/widget/camerarecordview/CameraPreviewRenderer;", "Lcom/tencent/mm/media/render/SurfaceTextureRenderer;", "cpuCrop", "", "(Z)V", "getCpuCrop", "()Z", "cropCameraTexture", "outputMirror", "outputTexHeight", "", "outputTexRenderProc", "Lcom/tencent/mm/media/render/proc/GLTextureRenderProcExternalTexture;", "outputTexWidth", "doInitRenderProc", "Lcom/tencent/mm/media/render/proc/GLTextureRenderProc;", "getOutputTexture", "Lcom/tencent/mm/media/globject/GLTextureObject;", "getOutputTextureSize", "Landroid/graphics/Point;", "getSurfaceTexture", "initRenderProcInGlesThread", "", "createSurfaceTexture", "prepareOutputTexture", "release", "shouldDestroySurfaceTexture", "render", "renderOutputTexture", "setOutputTextureInfo", "width", "height", "mirrorOutput", "plugin-mediaeditor_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class c
  extends com.tencent.mm.media.j.c
{
  private final boolean nJC;
  private com.tencent.mm.media.j.b.c nJD;
  private final boolean nJE;
  int nJF;
  int nJG;
  boolean nJH;
  
  public c(boolean paramBoolean)
  {
    super(1);
    AppMethodBeat.i(237628);
    this.nJC = paramBoolean;
    com.tencent.mm.media.widget.a.c localc = com.tencent.mm.media.widget.a.c.nGn;
    this.nJE = com.tencent.mm.media.widget.a.c.bsQ();
    this.nJF = -1;
    this.nJG = -1;
    AppMethodBeat.o(237628);
  }
  
  public final com.tencent.mm.media.j.b.a bgD()
  {
    AppMethodBeat.i(237631);
    if (this.nJC)
    {
      locala = (com.tencent.mm.media.j.b.a)new f(this.mVd, this.mVe, this.mWn, this.mWo, bpJ(), getScaleType());
      AppMethodBeat.o(237631);
      return locala;
    }
    com.tencent.mm.media.j.b.a locala = (com.tencent.mm.media.j.b.a)new com.tencent.mm.media.j.b.c(this.mVd, this.mVe, this.mWn, this.mWo, bpJ(), getScaleType());
    AppMethodBeat.o(237631);
    return locala;
  }
  
  public final void bgE()
  {
    AppMethodBeat.i(237648);
    super.bgE();
    Object localObject;
    int i;
    if (this.nJE)
    {
      localObject = bpK();
      if (localObject != null) {
        break label193;
      }
      localObject = null;
      if (localObject != null)
      {
        i = ((Integer)localObject).intValue();
        localObject = this.nJD;
        if (localObject != null) {
          ((com.tencent.mm.media.j.b.c)localObject).el(this.mVd, this.mVe);
        }
        if ((this.nJF <= 0) || (this.nJG <= 0)) {
          break label204;
        }
        localObject = this.nJD;
        if (localObject != null) {
          ((com.tencent.mm.media.j.b.c)localObject).ek(this.nJF, this.nJG);
        }
        label92:
        if (this.nDr >= 0)
        {
          localObject = this.nJD;
          if (localObject != null) {
            ((com.tencent.mm.media.j.b.c)localObject).th(this.nDr);
          }
        }
        localObject = this.nJD;
        if (localObject != null) {
          if ((!this.nvG) || (!this.nJH)) {
            break label228;
          }
        }
      }
    }
    label193:
    label204:
    label228:
    for (boolean bool = true;; bool = false)
    {
      ((com.tencent.mm.media.j.b.c)localObject).gr(bool);
      localObject = this.nJD;
      if (localObject != null) {
        ((com.tencent.mm.media.j.b.c)localObject).gq(true);
      }
      localObject = this.nJD;
      if (localObject != null) {
        ((com.tencent.mm.media.j.b.c)localObject).nEx = i;
      }
      localObject = this.nJD;
      if (localObject != null) {
        ((com.tencent.mm.media.j.b.c)localObject).bgE();
      }
      AppMethodBeat.o(237648);
      return;
      localObject = Integer.valueOf(((d)localObject).nAF);
      break;
      localObject = this.nJD;
      if (localObject == null) {
        break label92;
      }
      ((com.tencent.mm.media.j.b.c)localObject).ek(this.mVd, this.mVe);
      break label92;
    }
  }
  
  public final d bgF()
  {
    AppMethodBeat.i(237644);
    if (this.nJE)
    {
      localObject = this.nJD;
      if (localObject == null)
      {
        AppMethodBeat.o(237644);
        return null;
      }
      localObject = ((com.tencent.mm.media.j.b.a)localObject).nDF;
      AppMethodBeat.o(237644);
      return localObject;
    }
    Object localObject = super.bgF();
    AppMethodBeat.o(237644);
    return localObject;
  }
  
  public final d bpP()
  {
    AppMethodBeat.i(237639);
    if (this.nJE)
    {
      localObject = this.nJD;
      if (localObject == null)
      {
        AppMethodBeat.o(237639);
        return null;
      }
      localObject = ((com.tencent.mm.media.j.b.a)localObject).nDF;
      AppMethodBeat.o(237639);
      return localObject;
    }
    Object localObject = super.bpP();
    AppMethodBeat.o(237639);
    return localObject;
  }
  
  public final void gp(boolean paramBoolean)
  {
    AppMethodBeat.i(237636);
    super.gp(paramBoolean);
    Object localObject;
    if (this.nJE)
    {
      this.nJD = new com.tencent.mm.media.j.b.c(this.mVd, this.mVe, this.mVd, this.mVe, 2, 2);
      localObject = this.nJD;
      if (localObject != null) {
        break label74;
      }
      localObject = null;
    }
    for (;;)
    {
      Log.i("MicroMsg.Media.AbsSurfaceRenderer", s.X("prepareOutputTexture:", localObject));
      AppMethodBeat.o(237636);
      return;
      label74:
      localObject = ((com.tencent.mm.media.j.b.a)localObject).nDF;
      if (localObject == null) {
        localObject = null;
      } else {
        localObject = Integer.valueOf(((d)localObject).nAF);
      }
    }
  }
  
  public final void release(boolean paramBoolean)
  {
    AppMethodBeat.i(237655);
    super.release(paramBoolean);
    com.tencent.mm.media.j.b.c localc = this.nJD;
    if (localc != null) {
      localc.release();
    }
    AppMethodBeat.o(237655);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.media.widget.camerarecordview.c
 * JD-Core Version:    0.7.0.1
 */