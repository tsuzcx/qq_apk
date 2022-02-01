package com.tencent.mm.live.core.core.trtc;

import android.graphics.Point;
import android.graphics.SurfaceTexture;
import android.view.TextureView.SurfaceTextureListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.live.core.b.d;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.ui.bf;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"com/tencent/mm/live/core/core/trtc/AbsLiveTRTCCore$switchScreenShareMode$1", "Landroid/view/TextureView$SurfaceTextureListener;", "onSurfaceTextureAvailable", "", "surface", "Landroid/graphics/SurfaceTexture;", "width", "", "height", "onSurfaceTextureDestroyed", "", "onSurfaceTextureSizeChanged", "onSurfaceTextureUpdated", "plugin-core_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a$v
  implements TextureView.SurfaceTextureListener
{
  a$v(a parama) {}
  
  public final void onSurfaceTextureAvailable(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(248255);
    s.u(paramSurfaceTexture, "surface");
    Log.i("MicroMsg.LiveCore", "docMode onSurfaceTextureAvailable, surface:" + paramSurfaceTexture + ", size:[" + paramInt1 + ", " + paramInt2 + ']');
    int j = bf.bf(MMApplicationContext.getContext()).x;
    int i = bf.bf(MMApplicationContext.getContext()).y;
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
        this.mSf.mRs.di(paramSurfaceTexture);
        this.mSf.mRs.ej(k, m);
        AppMethodBeat.o(248255);
        return;
        if (i <= j) {
          break label196;
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
      label196:
      int k = i;
      i = j;
      j = k;
    }
  }
  
  public final boolean onSurfaceTextureDestroyed(SurfaceTexture paramSurfaceTexture)
  {
    AppMethodBeat.i(248241);
    s.u(paramSurfaceTexture, "surface");
    Log.i("MicroMsg.LiveCore", "docMode onSurfaceTextureDestroyed");
    AppMethodBeat.o(248241);
    return false;
  }
  
  public final void onSurfaceTextureSizeChanged(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(248232);
    s.u(paramSurfaceTexture, "surface");
    Log.i("MicroMsg.LiveCore", "docMode onSurfaceTextureSizeChanged, surface:" + paramSurfaceTexture + ", size:[" + paramInt1 + ", " + paramInt2 + ']');
    this.mSf.mRs.ej(paramInt1, paramInt2);
    AppMethodBeat.o(248232);
  }
  
  public final void onSurfaceTextureUpdated(SurfaceTexture paramSurfaceTexture)
  {
    AppMethodBeat.i(248237);
    s.u(paramSurfaceTexture, "surface");
    AppMethodBeat.o(248237);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.live.core.core.trtc.a.v
 * JD-Core Version:    0.7.0.1
 */