package com.tencent.mm.media.j;

import android.graphics.Bitmap;
import android.graphics.Rect;
import android.graphics.SurfaceTexture;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.media.g.d;
import com.tencent.mm.sdk.platformtools.Log;
import java.nio.FloatBuffer;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/media/render/MixRenderer;", "Lcom/tencent/mm/media/render/AbsSurfaceRenderer;", "textureWidth", "", "textureHeight", "drawWidth", "drawHeight", "renderOutputType", "scaleType", "(IIIIII)V", "TAG", "", "textureCropRect", "Landroid/graphics/Rect;", "calcBlurBgTextureCoord", "", "calcCenterLocation", "doInitRenderProc", "Lcom/tencent/mm/media/render/proc/GLTextureRenderProc;", "getOutputTexture", "Lcom/tencent/mm/media/globject/GLTextureObject;", "getTextureCropRect", "render", "bitmap", "Landroid/graphics/Bitmap;", "blurBgBitmap", "setBlendBitmap", "setBlurBgBitmap", "setTextureCropRect", "rect", "plugin-mediaeditor_release"}, k=1, mv={1, 5, 1}, xi=48)
public class b
  extends a
{
  private final String TAG = "MicroMsg.MixRenderer";
  public Rect nDB;
  
  public b(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
  {
    super(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6);
  }
  
  private final void J(Bitmap paramBitmap)
  {
    AppMethodBeat.i(93840);
    if ((this.nDm instanceof com.tencent.mm.media.j.b.b))
    {
      com.tencent.mm.media.j.b.a locala = this.nDm;
      if (locala == null)
      {
        paramBitmap = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.media.render.proc.GLTextureRenderProcBlend");
        AppMethodBeat.o(93840);
        throw paramBitmap;
      }
      com.tencent.mm.media.j.b.b.a((com.tencent.mm.media.j.b.b)locala, paramBitmap);
      AppMethodBeat.o(93840);
      return;
    }
    Log.e(this.TAG, "setBlendBitmap data don't match textureRender ");
    AppMethodBeat.o(93840);
  }
  
  private final void K(Bitmap paramBitmap)
  {
    AppMethodBeat.i(93841);
    if ((this.nDm instanceof com.tencent.mm.media.j.b.b))
    {
      Object localObject = this.nDm;
      if (localObject == null)
      {
        paramBitmap = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.media.render.proc.GLTextureRenderProcBlend");
        AppMethodBeat.o(93841);
        throw paramBitmap;
      }
      localObject = (com.tencent.mm.media.j.b.b)localObject;
      s.u(paramBitmap, "bitmap");
      ((com.tencent.mm.media.j.b.b)localObject).nEc = paramBitmap;
      AppMethodBeat.o(93841);
      return;
    }
    Log.e(this.TAG, "setBlurBgBitmap data don't match textureRender ");
    AppMethodBeat.o(93841);
  }
  
  private final void bpR()
  {
    AppMethodBeat.i(93842);
    if ((this.nDm instanceof com.tencent.mm.media.j.b.b))
    {
      float f1 = this.mWn / this.mVd;
      float f2 = this.mWo / this.mVe;
      float f4;
      float f3;
      if (f2 < f1)
      {
        f1 = this.mVd * f2;
        f4 = this.mWo;
        f2 = (this.mWn - f1) / 2.0F;
        f1 += f2;
        f3 = 0.0F;
      }
      for (;;)
      {
        Log.i(this.TAG, "calcCenterLocation drawWidth:" + this.mWn + " drawHeight:" + this.mWo + " textureWidth:" + this.mVd + " textureHeight:" + this.mVe + " top:" + f4 + " bottom:" + f3 + " left:" + f2 + " right:" + f1);
        localObject = this.nDm;
        if (localObject != null) {
          break;
        }
        localObject = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.media.render.proc.GLTextureRenderProcBlend");
        AppMethodBeat.o(93842);
        throw ((Throwable)localObject);
        f1 *= this.mVe;
        f4 = (this.mWo - f1) / 2.0F + f1;
        f3 = (this.mWo - f1) / 2.0F;
        f1 = this.mWn;
        f2 = 0.0F;
      }
      Object localObject = (com.tencent.mm.media.j.b.b)localObject;
      ((com.tencent.mm.media.j.b.b)localObject).nEe[0] = f4;
      ((com.tencent.mm.media.j.b.b)localObject).nEe[1] = f3;
      ((com.tencent.mm.media.j.b.b)localObject).nEe[2] = f2;
      ((com.tencent.mm.media.j.b.b)localObject).nEe[3] = f1;
      AppMethodBeat.o(93842);
      return;
    }
    Log.e(this.TAG, "calcCenterLocation data don't match textureRender ");
    AppMethodBeat.o(93842);
  }
  
  private final void bpS()
  {
    AppMethodBeat.i(93843);
    if ((this.nDm instanceof com.tencent.mm.media.j.b.b))
    {
      float f1 = this.mWn / this.mVd;
      float f2 = this.mWo / this.mVe;
      Object localObject1 = new float[8];
      if (f1 < f2)
      {
        f1 *= this.mVe;
        f2 = (this.mWo - f1) / f1;
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
        localObject2 = this.nDm;
        if (localObject2 != null) {
          break;
        }
        localObject1 = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.media.render.proc.GLTextureRenderProcBlend");
        AppMethodBeat.o(93843);
        throw ((Throwable)localObject1);
        f1 = this.mVd * f2;
        f2 = (this.mWn - f1) / f1;
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
      Object localObject2 = (com.tencent.mm.media.j.b.b)localObject2;
      s.u(localObject1, "blurBgCoord");
      ((com.tencent.mm.media.j.b.b)localObject2).nEv.position(0);
      ((com.tencent.mm.media.j.b.b)localObject2).nEv.put((float[])localObject1);
      ((com.tencent.mm.media.j.b.b)localObject2).nEv.position(0);
      AppMethodBeat.o(93843);
      return;
    }
    Log.e(this.TAG, "calcBlurBgTextureCoord data don't match textureRender ");
    AppMethodBeat.o(93843);
  }
  
  public final void b(Bitmap paramBitmap1, Bitmap paramBitmap2)
  {
    AppMethodBeat.i(93844);
    if (paramBitmap1 != null) {
      J(paramBitmap1);
    }
    if (paramBitmap2 != null)
    {
      K(paramBitmap2);
      bpR();
      bpS();
    }
    bgE();
    AppMethodBeat.o(93844);
  }
  
  protected com.tencent.mm.media.j.b.a bgD()
  {
    AppMethodBeat.i(93838);
    Object localObject = new com.tencent.mm.media.j.b.b(this.mVd, this.mVe, this.mWn, this.mWo, bpJ(), getScaleType());
    ((com.tencent.mm.media.j.b.a)localObject).nDB = this.nDB;
    localObject = (com.tencent.mm.media.j.b.a)localObject;
    AppMethodBeat.o(93838);
    return localObject;
  }
  
  public final void bgE()
  {
    AppMethodBeat.i(93839);
    Object localObject = getSurfaceTexture();
    if (localObject != null) {
      ((SurfaceTexture)localObject).updateTexImage();
    }
    localObject = bpP();
    if (localObject == null) {}
    for (int i = -1;; i = ((d)localObject).nAF)
    {
      tY(i);
      super.bgE();
      AppMethodBeat.o(93839);
      return;
    }
  }
  
  public final d bgF()
  {
    com.tencent.mm.media.j.b.a locala = this.nDm;
    if (locala == null) {
      return null;
    }
    return locala.nDF;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.media.j.b
 * JD-Core Version:    0.7.0.1
 */