package com.tencent.mm.plugin.finder.video;

import android.graphics.Rect;
import android.graphics.RectF;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.media.i.b.a;
import com.tencent.mm.media.i.b.b;
import d.l;
import java.nio.FloatBuffer;
import java.util.Arrays;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/video/FinderGLTextureRenderProc;", "Lcom/tencent/mm/media/render/proc/GLTextureRenderProcBlend;", "textureWidth", "", "textureHeight", "drawWidth", "drawHeight", "renderOutputType", "scaleType", "(IIIIII)V", "videoHeight", "videoWidth", "initDrawCoordBuffer", "", "setVideoSize", "width", "height", "plugin-finder_release"})
public final class c
  extends b
{
  int videoHeight;
  int videoWidth;
  
  public c(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
  {
    super(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6);
  }
  
  public final void arp()
  {
    AppMethodBeat.i(203701);
    if (this.scaleType == 4)
    {
      Object localObject = aro();
      float f7 = ((RectF)localObject).left;
      float f1 = ((RectF)localObject).top;
      float f5 = ((RectF)localObject).right;
      float f2 = ((RectF)localObject).bottom;
      localObject = this.gVo;
      float[] arrayOfFloat;
      int i;
      if (localObject != null)
      {
        arrayOfFloat = com.tencent.mm.media.j.c.gWD;
        arrayOfFloat = Arrays.copyOf(arrayOfFloat, arrayOfFloat.length);
        c.a locala = c.a.rQM;
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
      for (int j = this.videoHeight;; j = this.gra)
      {
        float f6 = c.a.ai(((Rect)localObject).left / i);
        float f8 = c.a.ai(((Rect)localObject).right / i);
        float f4 = c.a.ai(((Rect)localObject).bottom / j);
        float f3 = c.a.ai(((Rect)localObject).top / j);
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
        this.grD.put(com.tencent.mm.media.j.c.gWD);
        this.grD.position(0);
        this.grD.put(arrayOfFloat);
        this.grD.position(0);
        this.grE.position(0);
        this.grE.position(0);
        this.grE.put(com.tencent.mm.media.j.c.gWC);
        this.grE.position(0);
        AppMethodBeat.o(203701);
        return;
        i = this.gqZ;
        break;
      }
    }
    super.arp();
    AppMethodBeat.o(203701);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.video.c
 * JD-Core Version:    0.7.0.1
 */