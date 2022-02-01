package com.tencent.mm.media.j;

import android.graphics.Bitmap;
import android.graphics.Rect;
import android.graphics.SurfaceTexture;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.media.g.d;
import com.tencent.mm.media.j.b.b;
import com.tencent.mm.sdk.platformtools.ae;
import d.g.b.p;
import d.l;
import d.v;
import java.nio.FloatBuffer;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/media/render/MixRenderer;", "Lcom/tencent/mm/media/render/AbsSurfaceRenderer;", "textureWidth", "", "textureHeight", "drawWidth", "drawHeight", "renderOutputType", "scaleType", "(IIIIII)V", "TAG", "", "textureCropRect", "Landroid/graphics/Rect;", "calcBlurBgTextureCoord", "", "calcCenterLocation", "doInitRenderProc", "Lcom/tencent/mm/media/render/proc/GLTextureRenderProc;", "getTextureCropRect", "render", "bitmap", "Landroid/graphics/Bitmap;", "blurBgBitmap", "setBlendBitmap", "setBlurBgBitmap", "setTextureCropRect", "rect", "plugin-mediaeditor_release"})
public class c
  extends a
{
  private final String TAG = "MicroMsg.MixRenderer";
  public Rect hqf;
  
  public c(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
  {
    super(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6);
  }
  
  private final void A(Bitmap paramBitmap)
  {
    AppMethodBeat.i(93840);
    if ((this.hpT instanceof b))
    {
      com.tencent.mm.media.j.b.a locala = this.hpT;
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
    ae.e(this.TAG, "setBlendBitmap data don't match textureRender ");
    AppMethodBeat.o(93840);
  }
  
  private final void B(Bitmap paramBitmap)
  {
    AppMethodBeat.i(93841);
    if ((this.hpT instanceof b))
    {
      Object localObject = this.hpT;
      if (localObject == null)
      {
        paramBitmap = new v("null cannot be cast to non-null type com.tencent.mm.media.render.proc.GLTextureRenderProcBlend");
        AppMethodBeat.o(93841);
        throw paramBitmap;
      }
      localObject = (b)localObject;
      p.h(paramBitmap, "bitmap");
      ((b)localObject).hqG = paramBitmap;
      AppMethodBeat.o(93841);
      return;
    }
    ae.e(this.TAG, "setBlurBgBitmap data don't match textureRender ");
    AppMethodBeat.o(93841);
  }
  
  private final void aun()
  {
    AppMethodBeat.i(93842);
    if ((this.hpT instanceof b))
    {
      float f1 = this.gOm / this.gNs;
      float f2 = this.gOn / this.gNt;
      float f4;
      float f3;
      if (f2 < f1)
      {
        f2 *= this.gNs;
        f4 = this.gOn;
        f1 = (this.gOm - f2) / 2.0F;
        f2 = f1 + f2;
        f3 = 0.0F;
      }
      for (;;)
      {
        ae.i(this.TAG, "calcCenterLocation drawWidth:" + this.gOm + " drawHeight:" + this.gOn + " textureWidth:" + this.gNs + " textureHeight:" + this.gNt + " top:" + f4 + " bottom:" + f3 + " left:" + f1 + " right:" + f2);
        localObject = this.hpT;
        if (localObject != null) {
          break;
        }
        localObject = new v("null cannot be cast to non-null type com.tencent.mm.media.render.proc.GLTextureRenderProcBlend");
        AppMethodBeat.o(93842);
        throw ((Throwable)localObject);
        f1 *= this.gNt;
        f4 = (this.gOn - f1) / 2.0F + f1;
        f3 = (this.gOn - f1) / 2.0F;
        f2 = this.gOm;
        f1 = 0.0F;
      }
      Object localObject = (b)localObject;
      ((b)localObject).hqI[0] = f4;
      ((b)localObject).hqI[1] = f3;
      ((b)localObject).hqI[2] = f1;
      ((b)localObject).hqI[3] = f2;
      AppMethodBeat.o(93842);
      return;
    }
    ae.e(this.TAG, "calcCenterLocation data don't match textureRender ");
    AppMethodBeat.o(93842);
  }
  
  private final void auo()
  {
    AppMethodBeat.i(93843);
    if ((this.hpT instanceof b))
    {
      float f1 = this.gOm / this.gNs;
      float f2 = this.gOn / this.gNt;
      Object localObject1 = new float[8];
      if (f1 < f2)
      {
        f1 *= this.gNt;
        f2 = (this.gOn - f1) / f1;
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
        ae.i(this.TAG, "calcBlurBgTextureCoord :[0.0, " + f1 + " \n 1.0, " + f1 + " \n 0.0, " + f2 + " \n 1.0, " + f2 + ']');
      }
      for (;;)
      {
        localObject2 = this.hpT;
        if (localObject2 != null) {
          break;
        }
        localObject1 = new v("null cannot be cast to non-null type com.tencent.mm.media.render.proc.GLTextureRenderProcBlend");
        AppMethodBeat.o(93843);
        throw ((Throwable)localObject1);
        f1 = this.gNs * f2;
        f2 = (this.gOm - f1) / f1;
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
      ((b)localObject2).hqZ.position(0);
      ((b)localObject2).hqZ.put((float[])localObject1);
      ((b)localObject2).hqZ.position(0);
      AppMethodBeat.o(93843);
      return;
    }
    ae.e(this.TAG, "calcBlurBgTextureCoord data don't match textureRender ");
    AppMethodBeat.o(93843);
  }
  
  public final void a(Bitmap paramBitmap1, Bitmap paramBitmap2)
  {
    AppMethodBeat.i(93844);
    if (paramBitmap1 != null) {
      A(paramBitmap1);
    }
    if (paramBitmap2 != null)
    {
      B(paramBitmap2);
      aun();
      auo();
    }
    amH();
    AppMethodBeat.o(93844);
  }
  
  protected com.tencent.mm.media.j.b.a amG()
  {
    AppMethodBeat.i(93838);
    Object localObject = new b(this.gNs, this.gNt, this.gOm, this.gOn, this.hqd, this.scaleType);
    ((com.tencent.mm.media.j.b.a)localObject).hqf = this.hqf;
    localObject = (com.tencent.mm.media.j.b.a)localObject;
    AppMethodBeat.o(93838);
    return localObject;
  }
  
  public final void amH()
  {
    AppMethodBeat.i(93839);
    Object localObject = this.surfaceTexture;
    if (localObject != null) {
      ((SurfaceTexture)localObject).updateTexImage();
    }
    localObject = this.hpV;
    if (localObject != null) {}
    for (int i = ((d)localObject).hnc;; i = -1)
    {
      input(i);
      super.amH();
      AppMethodBeat.o(93839);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.media.j.c
 * JD-Core Version:    0.7.0.1
 */