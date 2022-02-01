package com.tencent.mm.media.j;

import android.graphics.Bitmap;
import android.graphics.Rect;
import android.graphics.SurfaceTexture;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.media.g.d;
import com.tencent.mm.media.j.b.b;
import com.tencent.mm.sdk.platformtools.ad;
import d.g.b.p;
import d.l;
import d.v;
import java.nio.FloatBuffer;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/media/render/MixRenderer;", "Lcom/tencent/mm/media/render/AbsSurfaceRenderer;", "textureWidth", "", "textureHeight", "drawWidth", "drawHeight", "renderOutputType", "scaleType", "(IIIIII)V", "TAG", "", "textureCropRect", "Landroid/graphics/Rect;", "calcBlurBgTextureCoord", "", "calcCenterLocation", "doInitRenderProc", "Lcom/tencent/mm/media/render/proc/GLTextureRenderProc;", "getTextureCropRect", "render", "bitmap", "Landroid/graphics/Bitmap;", "blurBgBitmap", "setBlendBitmap", "setBlurBgBitmap", "setTextureCropRect", "rect", "plugin-mediaeditor_release"})
public class c
  extends a
{
  private final String TAG = "MicroMsg.MixRenderer";
  public Rect hnr;
  
  public c(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
  {
    super(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6);
  }
  
  private final void A(Bitmap paramBitmap)
  {
    AppMethodBeat.i(93841);
    if ((this.hnf instanceof b))
    {
      Object localObject = this.hnf;
      if (localObject == null)
      {
        paramBitmap = new v("null cannot be cast to non-null type com.tencent.mm.media.render.proc.GLTextureRenderProcBlend");
        AppMethodBeat.o(93841);
        throw paramBitmap;
      }
      localObject = (b)localObject;
      p.h(paramBitmap, "bitmap");
      ((b)localObject).hnS = paramBitmap;
      AppMethodBeat.o(93841);
      return;
    }
    ad.e(this.TAG, "setBlurBgBitmap data don't match textureRender ");
    AppMethodBeat.o(93841);
  }
  
  private final void atY()
  {
    AppMethodBeat.i(93842);
    if ((this.hnf instanceof b))
    {
      float f1 = this.gLD / this.gKJ;
      float f2 = this.gLE / this.gKK;
      float f4;
      float f3;
      if (f2 < f1)
      {
        f2 *= this.gKJ;
        f4 = this.gLE;
        f1 = (this.gLD - f2) / 2.0F;
        f2 = f1 + f2;
        f3 = 0.0F;
      }
      for (;;)
      {
        ad.i(this.TAG, "calcCenterLocation drawWidth:" + this.gLD + " drawHeight:" + this.gLE + " textureWidth:" + this.gKJ + " textureHeight:" + this.gKK + " top:" + f4 + " bottom:" + f3 + " left:" + f1 + " right:" + f2);
        localObject = this.hnf;
        if (localObject != null) {
          break;
        }
        localObject = new v("null cannot be cast to non-null type com.tencent.mm.media.render.proc.GLTextureRenderProcBlend");
        AppMethodBeat.o(93842);
        throw ((Throwable)localObject);
        f1 *= this.gKK;
        f4 = (this.gLE - f1) / 2.0F + f1;
        f3 = (this.gLE - f1) / 2.0F;
        f2 = this.gLD;
        f1 = 0.0F;
      }
      Object localObject = (b)localObject;
      ((b)localObject).hnU[0] = f4;
      ((b)localObject).hnU[1] = f3;
      ((b)localObject).hnU[2] = f1;
      ((b)localObject).hnU[3] = f2;
      AppMethodBeat.o(93842);
      return;
    }
    ad.e(this.TAG, "calcCenterLocation data don't match textureRender ");
    AppMethodBeat.o(93842);
  }
  
  private final void atZ()
  {
    AppMethodBeat.i(93843);
    if ((this.hnf instanceof b))
    {
      float f1 = this.gLD / this.gKJ;
      float f2 = this.gLE / this.gKK;
      Object localObject1 = new float[8];
      if (f1 < f2)
      {
        f1 *= this.gKK;
        f2 = (this.gLE - f1) / f1;
        f1 = f2 / 2.0F + 1.0F;
        f2 = 0.0F - f2 / 2.0F;
        localObject1[0] = 0.0F;
        localObject1[1] = f1;
        localObject1[2] = 1.0F;
        localObject1[3] = f1;
        localObject1[4] = 0.0F;
        localObject1[5] = f2;
        localObject1[6] = 1.0F;
        localObject1[7] = f2;
        ad.i(this.TAG, "calcBlurBgTextureCoord :[0.0, " + f1 + " \n 1.0, " + f1 + " \n 0.0, " + f2 + " \n 1.0, " + f2 + ']');
      }
      for (;;)
      {
        localObject2 = this.hnf;
        if (localObject2 != null) {
          break;
        }
        localObject1 = new v("null cannot be cast to non-null type com.tencent.mm.media.render.proc.GLTextureRenderProcBlend");
        AppMethodBeat.o(93843);
        throw ((Throwable)localObject1);
        f1 = this.gKJ * f2;
        f2 = (this.gLD - f1) / f1;
        f1 = 0.0F - f2 / 2.0F;
        f2 = f2 / 2.0F + 1.0F;
        localObject1[0] = f1;
        localObject1[1] = 1.0F;
        localObject1[2] = f2;
        localObject1[3] = 1.0F;
        localObject1[4] = f1;
        localObject1[5] = 0.0F;
        localObject1[6] = f2;
        localObject1[7] = 0.0F;
      }
      Object localObject2 = (b)localObject2;
      p.h(localObject1, "blurBgCoord");
      ((b)localObject2).hol.position(0);
      ((b)localObject2).hol.put((float[])localObject1);
      ((b)localObject2).hol.position(0);
      AppMethodBeat.o(93843);
      return;
    }
    ad.e(this.TAG, "calcBlurBgTextureCoord data don't match textureRender ");
    AppMethodBeat.o(93843);
  }
  
  private final void z(Bitmap paramBitmap)
  {
    AppMethodBeat.i(93840);
    if ((this.hnf instanceof b))
    {
      com.tencent.mm.media.j.b.a locala = this.hnf;
      if (locala == null)
      {
        paramBitmap = new v("null cannot be cast to non-null type com.tencent.mm.media.render.proc.GLTextureRenderProcBlend");
        AppMethodBeat.o(93840);
        throw paramBitmap;
      }
      b.a((b)locala, paramBitmap);
      AppMethodBeat.o(93840);
      return;
    }
    ad.e(this.TAG, "setBlendBitmap data don't match textureRender ");
    AppMethodBeat.o(93840);
  }
  
  public final void a(Bitmap paramBitmap1, Bitmap paramBitmap2)
  {
    AppMethodBeat.i(93844);
    if (paramBitmap1 != null) {
      z(paramBitmap1);
    }
    if (paramBitmap2 != null)
    {
      A(paramBitmap2);
      atY();
      atZ();
    }
    ams();
    AppMethodBeat.o(93844);
  }
  
  protected com.tencent.mm.media.j.b.a amr()
  {
    AppMethodBeat.i(93838);
    Object localObject = new b(this.gKJ, this.gKK, this.gLD, this.gLE, this.hnp, this.scaleType);
    ((com.tencent.mm.media.j.b.a)localObject).hnr = this.hnr;
    localObject = (com.tencent.mm.media.j.b.a)localObject;
    AppMethodBeat.o(93838);
    return localObject;
  }
  
  public final void ams()
  {
    AppMethodBeat.i(93839);
    Object localObject = this.surfaceTexture;
    if (localObject != null) {
      ((SurfaceTexture)localObject).updateTexImage();
    }
    localObject = this.hnh;
    if (localObject != null) {}
    for (int i = ((d)localObject).hko;; i = -1)
    {
      input(i);
      super.ams();
      AppMethodBeat.o(93839);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.media.j.c
 * JD-Core Version:    0.7.0.1
 */