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

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/media/render/MixRenderer;", "Lcom/tencent/mm/media/render/AbsSurfaceRenderer;", "textureWidth", "", "textureHeight", "drawWidth", "drawHeight", "renderOutputType", "scaleType", "(IIIIII)V", "TAG", "", "textureCropRect", "Landroid/graphics/Rect;", "calcBlurBgTextureCoord", "", "calcCenterLocation", "doInitRenderProc", "Lcom/tencent/mm/media/render/proc/GLTextureRenderProc;", "getOutputTexture", "Lcom/tencent/mm/media/globject/GLTextureObject;", "getTextureCropRect", "render", "bitmap", "Landroid/graphics/Bitmap;", "blurBgBitmap", "setBlendBitmap", "setBlurBgBitmap", "setTextureCropRect", "rect", "plugin-mediaeditor_release"})
public class c
  extends a
{
  private final String TAG = "MicroMsg.MixRenderer";
  public Rect ijA;
  
  public c(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
  {
    super(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6);
  }
  
  private final void E(Bitmap paramBitmap)
  {
    AppMethodBeat.i(93840);
    if ((this.ijo instanceof b))
    {
      com.tencent.mm.media.j.b.a locala = this.ijo;
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
  
  private final void F(Bitmap paramBitmap)
  {
    AppMethodBeat.i(93841);
    if ((this.ijo instanceof b))
    {
      Object localObject = this.ijo;
      if (localObject == null)
      {
        paramBitmap = new t("null cannot be cast to non-null type com.tencent.mm.media.render.proc.GLTextureRenderProcBlend");
        AppMethodBeat.o(93841);
        throw paramBitmap;
      }
      localObject = (b)localObject;
      p.h(paramBitmap, "bitmap");
      ((b)localObject).ikc = paramBitmap;
      AppMethodBeat.o(93841);
      return;
    }
    Log.e(this.TAG, "setBlurBgBitmap data don't match textureRender ");
    AppMethodBeat.o(93841);
  }
  
  private final void aMO()
  {
    AppMethodBeat.i(93842);
    if ((this.ijo instanceof b))
    {
      float f1 = this.hEp / this.hDn;
      float f2 = this.hEq / this.hDo;
      float f4;
      float f3;
      if (f2 < f1)
      {
        f2 *= this.hDn;
        f4 = this.hEq;
        f1 = (this.hEp - f2) / 2.0F;
        f2 = f1 + f2;
        f3 = 0.0F;
      }
      for (;;)
      {
        Log.i(this.TAG, "calcCenterLocation drawWidth:" + this.hEp + " drawHeight:" + this.hEq + " textureWidth:" + this.hDn + " textureHeight:" + this.hDo + " top:" + f4 + " bottom:" + f3 + " left:" + f1 + " right:" + f2);
        localObject = this.ijo;
        if (localObject != null) {
          break;
        }
        localObject = new t("null cannot be cast to non-null type com.tencent.mm.media.render.proc.GLTextureRenderProcBlend");
        AppMethodBeat.o(93842);
        throw ((Throwable)localObject);
        f1 *= this.hDo;
        f4 = (this.hEq - f1) / 2.0F + f1;
        f3 = (this.hEq - f1) / 2.0F;
        f2 = this.hEp;
        f1 = 0.0F;
      }
      Object localObject = (b)localObject;
      ((b)localObject).ike[0] = f4;
      ((b)localObject).ike[1] = f3;
      ((b)localObject).ike[2] = f1;
      ((b)localObject).ike[3] = f2;
      AppMethodBeat.o(93842);
      return;
    }
    Log.e(this.TAG, "calcCenterLocation data don't match textureRender ");
    AppMethodBeat.o(93842);
  }
  
  private final void aMP()
  {
    AppMethodBeat.i(93843);
    if ((this.ijo instanceof b))
    {
      float f1 = this.hEp / this.hDn;
      float f2 = this.hEq / this.hDo;
      Object localObject1 = new float[8];
      if (f1 < f2)
      {
        f1 *= this.hDo;
        f2 = (this.hEq - f1) / f1;
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
        localObject2 = this.ijo;
        if (localObject2 != null) {
          break;
        }
        localObject1 = new t("null cannot be cast to non-null type com.tencent.mm.media.render.proc.GLTextureRenderProcBlend");
        AppMethodBeat.o(93843);
        throw ((Throwable)localObject1);
        f1 = this.hDn * f2;
        f2 = (this.hEp - f1) / f1;
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
      ((b)localObject2).ikv.position(0);
      ((b)localObject2).ikv.put((float[])localObject1);
      ((b)localObject2).ikv.position(0);
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
      E(paramBitmap1);
    }
    if (paramBitmap2 != null)
    {
      F(paramBitmap2);
      aMO();
      aMP();
    }
    aED();
    AppMethodBeat.o(93844);
  }
  
  protected com.tencent.mm.media.j.b.a aEC()
  {
    AppMethodBeat.i(93838);
    Object localObject = new b(this.hDn, this.hDo, this.hEp, this.hEq, this.ijy, this.scaleType);
    ((com.tencent.mm.media.j.b.a)localObject).ijA = this.ijA;
    localObject = (com.tencent.mm.media.j.b.a)localObject;
    AppMethodBeat.o(93838);
    return localObject;
  }
  
  public final void aED()
  {
    AppMethodBeat.i(93839);
    Object localObject = this.surfaceTexture;
    if (localObject != null) {
      ((SurfaceTexture)localObject).updateTexImage();
    }
    localObject = this.ijq;
    if (localObject != null) {}
    for (int i = ((d)localObject).igv;; i = -1)
    {
      input(i);
      super.aED();
      AppMethodBeat.o(93839);
      return;
    }
  }
  
  public final d aEE()
  {
    com.tencent.mm.media.j.b.a locala = this.ijo;
    if (locala != null) {
      return locala.ijD;
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.media.j.c
 * JD-Core Version:    0.7.0.1
 */