package com.tencent.mm.media.h;

import a.f.b.j;
import a.l;
import a.v;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.graphics.SurfaceTexture;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.media.h.b.b;
import com.tencent.mm.sdk.platformtools.ab;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/media/render/MixRenderer;", "Lcom/tencent/mm/media/render/AbsSurfaceRenderer;", "textureWidth", "", "textureHeight", "drawWidth", "drawHeight", "renderOutputType", "scaleType", "(IIIIII)V", "TAG", "", "textureCropRect", "Landroid/graphics/Rect;", "doInitRenderProc", "Lcom/tencent/mm/media/render/proc/GLTextureRenderProc;", "render", "", "bitmap", "Landroid/graphics/Bitmap;", "setBlendBitmap", "setTextureCropRect", "rect", "plugin-mediaeditor_release"})
public final class c
  extends a
{
  private final String TAG = "MicroMsg.MixRenderer";
  public Rect eYq;
  
  private c(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
  {
    super(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6);
  }
  
  private final void q(Bitmap paramBitmap)
  {
    AppMethodBeat.i(13089);
    if ((this.eXY instanceof b))
    {
      Object localObject = this.eXY;
      if (localObject == null)
      {
        paramBitmap = new v("null cannot be cast to non-null type com.tencent.mm.media.render.proc.GLTextureRenderProcBlend");
        AppMethodBeat.o(13089);
        throw paramBitmap;
      }
      localObject = (b)localObject;
      j.q(paramBitmap, "bitmap");
      ((b)localObject).eYL = paramBitmap;
      AppMethodBeat.o(13089);
      return;
    }
    ab.e(this.TAG, "data don't match textureRender ");
    AppMethodBeat.o(13089);
  }
  
  protected final com.tencent.mm.media.h.b.a Ve()
  {
    AppMethodBeat.i(13087);
    Object localObject = new b(this.eYj, this.eYk, this.eYl, this.eYm, this.eYn, this.scaleType, (byte)0);
    ((com.tencent.mm.media.h.b.a)localObject).eYq = this.eYq;
    localObject = (com.tencent.mm.media.h.b.a)localObject;
    AppMethodBeat.o(13087);
    return localObject;
  }
  
  public final void Vf()
  {
    AppMethodBeat.i(13088);
    SurfaceTexture localSurfaceTexture = this.bbI;
    if (localSurfaceTexture != null) {
      localSurfaceTexture.updateTexImage();
    }
    input(this.eYa);
    super.Vf();
    AppMethodBeat.o(13088);
  }
  
  public final void r(Bitmap paramBitmap)
  {
    AppMethodBeat.i(13090);
    if (paramBitmap != null) {
      q(paramBitmap);
    }
    Vf();
    AppMethodBeat.o(13090);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.media.h.c
 * JD-Core Version:    0.7.0.1
 */