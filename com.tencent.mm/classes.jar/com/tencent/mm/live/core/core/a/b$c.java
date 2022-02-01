package com.tencent.mm.live.core.core.a;

import android.content.Context;
import android.graphics.Point;
import android.graphics.SurfaceTexture;
import android.view.TextureView;
import android.view.TextureView.SurfaceTextureListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.live.core.b.d;
import com.tencent.mm.live.core.c.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.bf;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"com/tencent/mm/live/core/core/anchor/LiveAnchorTRTCCore$floatMode$2", "Landroid/view/TextureView$SurfaceTextureListener;", "onSurfaceTextureAvailable", "", "surface", "Landroid/graphics/SurfaceTexture;", "width", "", "height", "onSurfaceTextureDestroyed", "", "onSurfaceTextureSizeChanged", "onSurfaceTextureUpdated", "plugin-core_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b$c
  implements TextureView.SurfaceTextureListener
{
  b$c(b paramb, long paramLong, Context paramContext, TextureView paramTextureView) {}
  
  public final void onSurfaceTextureAvailable(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(248177);
    s.u(paramSurfaceTexture, "surface");
    Log.i("MicroMsg.LiveCoreAnchor", "float onSurfaceTextureAvailable, surface:" + paramSurfaceTexture + ", size:[" + paramInt1 + ", " + paramInt2 + ']');
    a.tk((int)Util.ticksToNow(this.mMu));
    int j = bf.bf(this.$context).x;
    int i = bf.bf(this.$context).y;
    if (j > i) {}
    for (;;)
    {
      float f;
      int m;
      if (paramInt1 < paramInt2)
      {
        f = paramInt1;
        m = (int)(j / i * f);
        k = paramInt1;
      }
      for (;;)
      {
        b.c(this.mMt).di(this.mMv.getSurfaceTexture());
        b.c(this.mMt).ej(k, m);
        AppMethodBeat.o(248177);
        return;
        if (i <= j) {
          break label215;
        }
        k = i;
        i = j;
        j = k;
        break;
        k = paramInt1;
        m = paramInt2;
        if (paramInt2 < paramInt1)
        {
          f = paramInt2;
          k = (int)(j / i * f);
          m = paramInt2;
        }
      }
      label215:
      int k = i;
      i = j;
      j = k;
    }
  }
  
  public final boolean onSurfaceTextureDestroyed(SurfaceTexture paramSurfaceTexture)
  {
    AppMethodBeat.i(248169);
    s.u(paramSurfaceTexture, "surface");
    Log.i("MicroMsg.LiveCoreAnchor", "float onSurfaceTextureDestroyed");
    AppMethodBeat.o(248169);
    return false;
  }
  
  public final void onSurfaceTextureSizeChanged(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(248159);
    s.u(paramSurfaceTexture, "surface");
    Log.i("MicroMsg.LiveCoreAnchor", "float onSurfaceTextureSizeChanged, surface:" + paramSurfaceTexture + ", size:[" + paramInt1 + ", " + paramInt2 + ']');
    b.c(this.mMt).ej(paramInt1, paramInt2);
    AppMethodBeat.o(248159);
  }
  
  public final void onSurfaceTextureUpdated(SurfaceTexture paramSurfaceTexture)
  {
    AppMethodBeat.i(248164);
    s.u(paramSurfaceTexture, "surface");
    AppMethodBeat.o(248164);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.live.core.core.a.b.c
 * JD-Core Version:    0.7.0.1
 */