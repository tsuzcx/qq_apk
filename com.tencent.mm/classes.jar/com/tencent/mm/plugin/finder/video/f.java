package com.tencent.mm.plugin.finder.video;

import android.graphics.Rect;
import android.graphics.RectF;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.media.i.b.a;
import com.tencent.mm.media.j.c;
import java.nio.FloatBuffer;
import java.util.Arrays;

@d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/video/FinderGLTextureRenderProc;", "Lcom/tencent/mm/media/render/proc/GLTextureRenderProcBlend;", "textureWidth", "", "textureHeight", "drawWidth", "drawHeight", "renderOutputType", "scaleType", "(IIIIII)V", "videoHeight", "videoWidth", "initDrawCoordBuffer", "", "setVideoSize", "width", "height", "plugin-finder_release"})
public final class f
  extends com.tencent.mm.media.i.b.b
{
  int videoHeight;
  int videoWidth;
  
  public f(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
  {
    super(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6);
  }
  
  public final void fQF()
  {
    AppMethodBeat.i(199716);
    if (this.scaleType == 4)
    {
      Object localObject = fQE();
      float f7 = ((RectF)localObject).left;
      float f1 = ((RectF)localObject).top;
      float f5 = ((RectF)localObject).right;
      float f2 = ((RectF)localObject).bottom;
      localObject = this.guP;
      float[] arrayOfFloat;
      int i;
      if (localObject != null)
      {
        arrayOfFloat = c.gwf;
        arrayOfFloat = Arrays.copyOf(arrayOfFloat, arrayOfFloat.length);
        a locala = a.LbJ;
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
      for (int j = this.videoHeight;; j = this.guJ)
      {
        float f6 = a.ae(((Rect)localObject).left / i);
        float f8 = a.ae(((Rect)localObject).right / i);
        float f4 = a.ae(((Rect)localObject).bottom / j);
        float f3 = a.ae(((Rect)localObject).top / j);
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
        this.guS.put(c.gwf);
        this.guS.position(0);
        this.guS.put(arrayOfFloat);
        this.guS.position(0);
        this.guT.position(0);
        this.guT.position(0);
        this.guT.put(c.gwe);
        this.guT.position(0);
        AppMethodBeat.o(199716);
        return;
        i = this.guI;
        break;
      }
    }
    super.fQF();
    AppMethodBeat.o(199716);
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"valid", "", "size", "invoke"})
  static final class a
    extends d.g.b.l
    implements d.g.a.b<Float, Float>
  {
    public static final a LbJ;
    
    static
    {
      AppMethodBeat.i(199715);
      LbJ = new a();
      AppMethodBeat.o(199715);
    }
    
    a()
    {
      super();
    }
    
    public static float ae(float paramFloat)
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
 * Qualified Name:     com.tencent.mm.plugin.finder.video.f
 * JD-Core Version:    0.7.0.1
 */