package com.tencent.mm.plugin.finder.video;

import android.graphics.Rect;
import android.graphics.RectF;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.media.j.b.a;
import com.tencent.mm.media.j.b.b;
import java.nio.FloatBuffer;
import java.util.Arrays;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/video/FinderGLTextureRenderProc;", "Lcom/tencent/mm/media/render/proc/GLTextureRenderProcBlend;", "textureWidth", "", "textureHeight", "drawWidth", "drawHeight", "renderOutputType", "scaleType", "(IIIIII)V", "videoHeight", "videoWidth", "initDrawCoordBuffer", "", "setVideoSize", "width", "height", "plugin-finder-publish_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class c
  extends b
{
  int videoHeight;
  int videoWidth;
  
  public c(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
  {
    super(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6);
  }
  
  private static final float cp(float paramFloat)
  {
    float f;
    if (paramFloat > 1.0F) {
      f = 1.0F;
    }
    do
    {
      return f;
      f = paramFloat;
    } while (paramFloat >= 0.0F);
    return 0.0F;
  }
  
  public final void bqd()
  {
    AppMethodBeat.i(334933);
    if (getScaleType() == 4)
    {
      Object localObject = bqc();
      float f7 = ((RectF)localObject).left;
      float f1 = ((RectF)localObject).top;
      float f5 = ((RectF)localObject).right;
      float f2 = ((RectF)localObject).bottom;
      localObject = this.nDB;
      float[] arrayOfFloat;
      int i;
      if (localObject != null)
      {
        arrayOfFloat = com.tencent.mm.media.util.c.nFu;
        arrayOfFloat = Arrays.copyOf(arrayOfFloat, arrayOfFloat.length);
        if (this.videoWidth <= 0) {
          break label349;
        }
        i = this.videoWidth;
        if (this.videoHeight <= 0) {
          break label358;
        }
      }
      label349:
      label358:
      for (int j = this.videoHeight;; j = bpU())
      {
        float f6 = cp(((Rect)localObject).left / i);
        float f8 = cp(((Rect)localObject).right / i);
        float f4 = cp(((Rect)localObject).bottom / j);
        float f3 = cp(((Rect)localObject).top / j);
        float f9 = Math.abs(f5 - f7);
        f5 = Math.abs(f2 - f1);
        f6 = f6 * f9 + f7;
        f7 = f8 * f9 + f7;
        f4 = Math.min(f1, f2) + f5 * f4;
        f1 = f3 * f5 + Math.min(f1, f2);
        arrayOfFloat[0] = f6;
        arrayOfFloat[1] = f1;
        arrayOfFloat[2] = f7;
        arrayOfFloat[3] = f1;
        arrayOfFloat[4] = f6;
        arrayOfFloat[5] = f4;
        arrayOfFloat[6] = f7;
        arrayOfFloat[7] = f4;
        bpV().put(com.tencent.mm.media.util.c.nFu);
        bpV().position(0);
        bpV().put(arrayOfFloat);
        bpV().position(0);
        bpW().position(0);
        bpW().position(0);
        bpW().put(com.tencent.mm.media.util.c.nFt);
        bpW().position(0);
        AppMethodBeat.o(334933);
        return;
        i = bpT();
        break;
      }
    }
    super.bqd();
    AppMethodBeat.o(334933);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.video.c
 * JD-Core Version:    0.7.0.1
 */