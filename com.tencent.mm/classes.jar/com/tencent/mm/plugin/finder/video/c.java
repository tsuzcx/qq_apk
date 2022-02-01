package com.tencent.mm.plugin.finder.video;

import android.graphics.Rect;
import android.graphics.RectF;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.media.j.b.a;
import com.tencent.mm.media.j.b.b;
import java.nio.FloatBuffer;
import java.util.Arrays;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/video/FinderGLTextureRenderProc;", "Lcom/tencent/mm/media/render/proc/GLTextureRenderProcBlend;", "textureWidth", "", "textureHeight", "drawWidth", "drawHeight", "renderOutputType", "scaleType", "(IIIIII)V", "videoHeight", "videoWidth", "initDrawCoordBuffer", "", "setVideoSize", "width", "height", "plugin-finder_release"})
public final class c
  extends b
{
  int videoHeight;
  int videoWidth;
  
  public c(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
  {
    super(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6);
  }
  
  public final void aMS()
  {
    AppMethodBeat.i(254014);
    if (this.scaleType == 4)
    {
      Object localObject = aMR();
      float f7 = ((RectF)localObject).left;
      float f1 = ((RectF)localObject).top;
      float f5 = ((RectF)localObject).right;
      float f2 = ((RectF)localObject).bottom;
      localObject = this.ijA;
      float[] arrayOfFloat;
      int i;
      if (localObject != null)
      {
        arrayOfFloat = com.tencent.mm.media.k.c.iln;
        arrayOfFloat = Arrays.copyOf(arrayOfFloat, arrayOfFloat.length);
        c.a locala = c.a.wct;
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
      for (int j = this.videoHeight;; j = this.hDo)
      {
        float f6 = c.a.au(((Rect)localObject).left / i);
        float f8 = c.a.au(((Rect)localObject).right / i);
        float f4 = c.a.au(((Rect)localObject).bottom / j);
        float f3 = c.a.au(((Rect)localObject).top / j);
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
        this.hDT.put(com.tencent.mm.media.k.c.iln);
        this.hDT.position(0);
        this.hDT.put(arrayOfFloat);
        this.hDT.position(0);
        this.hDU.position(0);
        this.hDU.position(0);
        this.hDU.put(com.tencent.mm.media.k.c.ilm);
        this.hDU.position(0);
        AppMethodBeat.o(254014);
        return;
        i = this.hDn;
        break;
      }
    }
    super.aMS();
    AppMethodBeat.o(254014);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.video.c
 * JD-Core Version:    0.7.0.1
 */