package com.tencent.mm.plugin.finder.video;

import android.graphics.Rect;
import android.graphics.RectF;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.media.j.b.a;
import java.nio.FloatBuffer;
import java.util.Arrays;
import kotlin.g.b.q;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/video/FinderGLTextureRenderProc;", "Lcom/tencent/mm/media/render/proc/GLTextureRenderProcBlend;", "textureWidth", "", "textureHeight", "drawWidth", "drawHeight", "renderOutputType", "scaleType", "(IIIIII)V", "videoHeight", "videoWidth", "initDrawCoordBuffer", "", "setVideoSize", "width", "height", "plugin-finder_release"})
public final class c
  extends com.tencent.mm.media.j.b.b
{
  int videoHeight;
  int videoWidth;
  
  public c(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
  {
    super(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6);
  }
  
  public final void aVt()
  {
    AppMethodBeat.i(270895);
    if (getScaleType() == 4)
    {
      Object localObject = aVs();
      float f7 = ((RectF)localObject).left;
      float f1 = ((RectF)localObject).top;
      float f5 = ((RectF)localObject).right;
      float f2 = ((RectF)localObject).bottom;
      localObject = this.kYu;
      float[] arrayOfFloat;
      int i;
      if (localObject != null)
      {
        arrayOfFloat = com.tencent.mm.media.k.c.lak;
        arrayOfFloat = Arrays.copyOf(arrayOfFloat, arrayOfFloat.length);
        a locala = a.ALb;
        if (this.videoWidth <= 0) {
          break label354;
        }
        i = this.videoWidth;
        if (this.videoHeight <= 0) {
          break label363;
        }
      }
      label354:
      label363:
      for (int j = this.videoHeight;; j = aVy())
      {
        float f6 = a.au(((Rect)localObject).left / i);
        float f8 = a.au(((Rect)localObject).right / i);
        float f4 = a.au(((Rect)localObject).bottom / j);
        float f3 = a.au(((Rect)localObject).top / j);
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
        aVl().put(com.tencent.mm.media.k.c.lak);
        aVl().position(0);
        aVl().put(arrayOfFloat);
        aVl().position(0);
        aVm().position(0);
        aVm().position(0);
        aVm().put(com.tencent.mm.media.k.c.laj);
        aVm().position(0);
        AppMethodBeat.o(270895);
        return;
        i = aVx();
        break;
      }
    }
    super.aVt();
    AppMethodBeat.o(270895);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"valid", "", "size", "invoke"})
  static final class a
    extends q
    implements kotlin.g.a.b<Float, Float>
  {
    public static final a ALb;
    
    static
    {
      AppMethodBeat.i(286414);
      ALb = new a();
      AppMethodBeat.o(286414);
    }
    
    a()
    {
      super();
    }
    
    public static float au(float paramFloat)
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
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.video.c
 * JD-Core Version:    0.7.0.1
 */