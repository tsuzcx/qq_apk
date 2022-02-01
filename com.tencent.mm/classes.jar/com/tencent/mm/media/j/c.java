package com.tencent.mm.media.j;

import android.graphics.Bitmap;
import android.graphics.Rect;
import android.graphics.SurfaceTexture;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.media.g.d;
import com.tencent.mm.media.j.b.b;
import com.tencent.mm.sdk.platformtools.Log;
import java.nio.FloatBuffer;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/media/render/MixRenderer;", "Lcom/tencent/mm/media/render/AbsSurfaceRenderer;", "textureWidth", "", "textureHeight", "drawWidth", "drawHeight", "renderOutputType", "scaleType", "(IIIIII)V", "TAG", "", "textureCropRect", "Landroid/graphics/Rect;", "calcBlurBgTextureCoord", "", "calcCenterLocation", "doInitRenderProc", "Lcom/tencent/mm/media/render/proc/GLTextureRenderProc;", "getOutputTexture", "Lcom/tencent/mm/media/globject/GLTextureObject;", "getTextureCropRect", "render", "bitmap", "Landroid/graphics/Bitmap;", "blurBgBitmap", "setBlendBitmap", "setBlurBgBitmap", "setTextureCropRect", "rect", "plugin-mediaeditor_release"})
public class c
  extends a
{
  private final String TAG = "MicroMsg.MixRenderer";
  public Rect kYu;
  
  public c(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
  {
    super(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6);
  }
  
  private final void B(Bitmap paramBitmap)
  {
    AppMethodBeat.i(93840);
    if ((this.kYb instanceof b))
    {
      com.tencent.mm.media.j.b.a locala = this.kYb;
      if (locala == null)
      {
        paramBitmap = new t("null cannot be cast to non-null type com.tencent.mm.media.render.proc.GLTextureRenderProcBlend");
        AppMethodBeat.o(93840);
        throw paramBitmap;
      }
      b.a((b)locala, paramBitmap);
      AppMethodBeat.o(93840);
      return;
    }
    Log.e(this.TAG, "setBlendBitmap data don't match textureRender ");
    AppMethodBeat.o(93840);
  }
  
  private final void C(Bitmap paramBitmap)
  {
    AppMethodBeat.i(93841);
    if ((this.kYb instanceof b))
    {
      Object localObject = this.kYb;
      if (localObject == null)
      {
        paramBitmap = new t("null cannot be cast to non-null type com.tencent.mm.media.render.proc.GLTextureRenderProcBlend");
        AppMethodBeat.o(93841);
        throw paramBitmap;
      }
      localObject = (b)localObject;
      p.k(paramBitmap, "bitmap");
      ((b)localObject).kYW = paramBitmap;
      AppMethodBeat.o(93841);
      return;
    }
    Log.e(this.TAG, "setBlurBgBitmap data don't match textureRender ");
    AppMethodBeat.o(93841);
  }
  
  private final void aVj()
  {
    AppMethodBeat.i(93842);
    if ((this.kYb instanceof b))
    {
      float f1 = this.ksu / this.krg;
      float f2 = this.ksv / this.krh;
      float f4;
      float f3;
      if (f2 < f1)
      {
        f2 *= this.krg;
        f4 = this.ksv;
        f1 = (this.ksu - f2) / 2.0F;
        f2 = f1 + f2;
        f3 = 0.0F;
      }
      for (;;)
      {
        Log.i(this.TAG, "calcCenterLocation drawWidth:" + this.ksu + " drawHeight:" + this.ksv + " textureWidth:" + this.krg + " textureHeight:" + this.krh + " top:" + f4 + " bottom:" + f3 + " left:" + f1 + " right:" + f2);
        localObject = this.kYb;
        if (localObject != null) {
          break;
        }
        localObject = new t("null cannot be cast to non-null type com.tencent.mm.media.render.proc.GLTextureRenderProcBlend");
        AppMethodBeat.o(93842);
        throw ((Throwable)localObject);
        f1 *= this.krh;
        f4 = (this.ksv - f1) / 2.0F + f1;
        f3 = (this.ksv - f1) / 2.0F;
        f2 = this.ksu;
        f1 = 0.0F;
      }
      Object localObject = (b)localObject;
      ((b)localObject).kYY[0] = f4;
      ((b)localObject).kYY[1] = f3;
      ((b)localObject).kYY[2] = f1;
      ((b)localObject).kYY[3] = f2;
      AppMethodBeat.o(93842);
      return;
    }
    Log.e(this.TAG, "calcCenterLocation data don't match textureRender ");
    AppMethodBeat.o(93842);
  }
  
  private final void aVk()
  {
    AppMethodBeat.i(93843);
    if ((this.kYb instanceof b))
    {
      float f1 = this.ksu / this.krg;
      float f2 = this.ksv / this.krh;
      Object localObject1 = new float[8];
      if (f1 < f2)
      {
        f1 *= this.krh;
        f2 = (this.ksv - f1) / f1;
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
        Log.i(this.TAG, "calcBlurBgTextureCoord :[0.0, " + f1 + " \n 1.0, " + f1 + " \n 0.0, " + f2 + " \n 1.0, " + f2 + ']');
      }
      for (;;)
      {
        localObject2 = this.kYb;
        if (localObject2 != null) {
          break;
        }
        localObject1 = new t("null cannot be cast to non-null type com.tencent.mm.media.render.proc.GLTextureRenderProcBlend");
        AppMethodBeat.o(93843);
        throw ((Throwable)localObject1);
        f1 = this.krg * f2;
        f2 = (this.ksu - f1) / f1;
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
      p.k(localObject1, "blurBgCoord");
      ((b)localObject2).kZp.position(0);
      ((b)localObject2).kZp.put((float[])localObject1);
      ((b)localObject2).kZp.position(0);
      AppMethodBeat.o(93843);
      return;
    }
    Log.e(this.TAG, "calcBlurBgTextureCoord data don't match textureRender ");
    AppMethodBeat.o(93843);
  }
  
  public final void a(Bitmap paramBitmap1, Bitmap paramBitmap2)
  {
    AppMethodBeat.i(93844);
    if (paramBitmap1 != null) {
      B(paramBitmap1);
    }
    if (paramBitmap2 != null)
    {
      C(paramBitmap2);
      aVj();
      aVk();
    }
    aMU();
    AppMethodBeat.o(93844);
  }
  
  protected com.tencent.mm.media.j.b.a aMT()
  {
    AppMethodBeat.i(93838);
    Object localObject = new b(this.krg, this.krh, this.ksu, this.ksv, aVh(), getScaleType());
    ((com.tencent.mm.media.j.b.a)localObject).kYu = this.kYu;
    localObject = (com.tencent.mm.media.j.b.a)localObject;
    AppMethodBeat.o(93838);
    return localObject;
  }
  
  public final void aMU()
  {
    AppMethodBeat.i(93839);
    Object localObject = getSurfaceTexture();
    if (localObject != null) {
      ((SurfaceTexture)localObject).updateTexImage();
    }
    localObject = this.kYd;
    if (localObject != null) {}
    for (int i = ((d)localObject).kVj;; i = -1)
    {
      tZ(i);
      super.aMU();
      AppMethodBeat.o(93839);
      return;
    }
  }
  
  public final d aMV()
  {
    com.tencent.mm.media.j.b.a locala = this.kYb;
    if (locala != null) {
      return locala.kYx;
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.media.j.c
 * JD-Core Version:    0.7.0.1
 */