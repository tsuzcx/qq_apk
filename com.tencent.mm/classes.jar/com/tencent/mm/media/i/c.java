package com.tencent.mm.media.i;

import android.graphics.Bitmap;
import android.graphics.Rect;
import android.graphics.SurfaceTexture;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.media.f.d;
import com.tencent.mm.media.i.b.b;
import com.tencent.mm.sdk.platformtools.ad;
import d.g.b.k;
import d.l;
import d.v;
import java.nio.FloatBuffer;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/media/render/MixRenderer;", "Lcom/tencent/mm/media/render/AbsSurfaceRenderer;", "textureWidth", "", "textureHeight", "drawWidth", "drawHeight", "renderOutputType", "scaleType", "(IIIIII)V", "TAG", "", "textureCropRect", "Landroid/graphics/Rect;", "calcBlurBgTextureCoord", "", "calcCenterLocation", "doInitRenderProc", "Lcom/tencent/mm/media/render/proc/GLTextureRenderProc;", "getTextureCropRect", "render", "bitmap", "Landroid/graphics/Bitmap;", "blurBgBitmap", "setBlendBitmap", "setBlurBgBitmap", "setTextureCropRect", "rect", "plugin-mediaeditor_release"})
public class c
  extends a
{
  private final String TAG = "MicroMsg.MixRenderer";
  protected Rect guP;
  
  public c(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
  {
    super(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6);
  }
  
  private final void A(Bitmap paramBitmap)
  {
    AppMethodBeat.i(93841);
    if ((this.gux instanceof b))
    {
      Object localObject = this.gux;
      if (localObject == null)
      {
        paramBitmap = new v("null cannot be cast to non-null type com.tencent.mm.media.render.proc.GLTextureRenderProcBlend");
        AppMethodBeat.o(93841);
        throw paramBitmap;
      }
      localObject = (b)localObject;
      k.h(paramBitmap, "bitmap");
      ((b)localObject).gvp = paramBitmap;
      AppMethodBeat.o(93841);
      return;
    }
    ad.e(this.TAG, "setBlurBgBitmap data don't match textureRender ");
    AppMethodBeat.o(93841);
  }
  
  private final void akq()
  {
    AppMethodBeat.i(93842);
    if ((this.gux instanceof b))
    {
      float f1 = this.guK / this.guI;
      float f2 = this.guL / this.guJ;
      float f4;
      float f3;
      if (f2 < f1)
      {
        f2 *= this.guI;
        f4 = this.guL;
        f1 = (this.guK - f2) / 2.0F;
        f2 = f1 + f2;
        f3 = 0.0F;
      }
      for (;;)
      {
        ad.i(this.TAG, "calcCenterLocation drawWidth:" + this.guK + " drawHeight:" + this.guL + " textureWidth:" + this.guI + " textureHeight:" + this.guJ + " top:" + f4 + " bottom:" + f3 + " left:" + f1 + " right:" + f2);
        localObject = this.gux;
        if (localObject != null) {
          break;
        }
        localObject = new v("null cannot be cast to non-null type com.tencent.mm.media.render.proc.GLTextureRenderProcBlend");
        AppMethodBeat.o(93842);
        throw ((Throwable)localObject);
        f1 *= this.guJ;
        f4 = (this.guL - f1) / 2.0F + f1;
        f3 = (this.guL - f1) / 2.0F;
        f2 = this.guK;
        f1 = 0.0F;
      }
      Object localObject = (b)localObject;
      ((b)localObject).gvr[0] = f4;
      ((b)localObject).gvr[1] = f3;
      ((b)localObject).gvr[2] = f1;
      ((b)localObject).gvr[3] = f2;
      AppMethodBeat.o(93842);
      return;
    }
    ad.e(this.TAG, "calcCenterLocation data don't match textureRender ");
    AppMethodBeat.o(93842);
  }
  
  private final void akr()
  {
    AppMethodBeat.i(93843);
    if ((this.gux instanceof b))
    {
      float f1 = this.guK / this.guI;
      float f2 = this.guL / this.guJ;
      Object localObject1 = new float[8];
      if (f1 < f2)
      {
        f1 *= this.guJ;
        f2 = (this.guL - f1) / f1;
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
        localObject2 = this.gux;
        if (localObject2 != null) {
          break;
        }
        localObject1 = new v("null cannot be cast to non-null type com.tencent.mm.media.render.proc.GLTextureRenderProcBlend");
        AppMethodBeat.o(93843);
        throw ((Throwable)localObject1);
        f1 = this.guI * f2;
        f2 = (this.guK - f1) / f1;
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
      k.h(localObject1, "blurBgCoord");
      ((b)localObject2).gvI.position(0);
      ((b)localObject2).gvI.put((float[])localObject1);
      ((b)localObject2).gvI.position(0);
      AppMethodBeat.o(93843);
      return;
    }
    ad.e(this.TAG, "calcBlurBgTextureCoord data don't match textureRender ");
    AppMethodBeat.o(93843);
  }
  
  private final void z(Bitmap paramBitmap)
  {
    AppMethodBeat.i(93840);
    if ((this.gux instanceof b))
    {
      com.tencent.mm.media.i.b.a locala = this.gux;
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
      akq();
      akr();
    }
    akk();
    AppMethodBeat.o(93844);
  }
  
  protected com.tencent.mm.media.i.b.a akj()
  {
    AppMethodBeat.i(93838);
    Object localObject = new b(this.guI, this.guJ, this.guK, this.guL, this.guM, this.scaleType);
    ((com.tencent.mm.media.i.b.a)localObject).guP = this.guP;
    localObject = (com.tencent.mm.media.i.b.a)localObject;
    AppMethodBeat.o(93838);
    return localObject;
  }
  
  public final void akk()
  {
    AppMethodBeat.i(93839);
    Object localObject = this.surfaceTexture;
    if (localObject != null) {
      ((SurfaceTexture)localObject).updateTexImage();
    }
    localObject = this.guz;
    if (localObject != null) {}
    for (int i = ((d)localObject).gro;; i = -1)
    {
      input(i);
      super.akk();
      AppMethodBeat.o(93839);
      return;
    }
  }
  
  public final void j(Rect paramRect)
  {
    AppMethodBeat.i(164116);
    k.h(paramRect, "rect");
    this.guP = paramRect;
    AppMethodBeat.o(164116);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.media.i.c
 * JD-Core Version:    0.7.0.1
 */