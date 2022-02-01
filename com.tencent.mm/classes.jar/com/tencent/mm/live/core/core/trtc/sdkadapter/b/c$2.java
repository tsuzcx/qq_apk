package com.tencent.mm.live.core.core.trtc.sdkadapter.b;

import android.graphics.SurfaceTexture;
import android.view.Surface;
import android.view.TextureView.SurfaceTextureListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.live.core.b.h;
import com.tencent.mm.sdk.platformtools.Log;

final class c$2
  implements TextureView.SurfaceTextureListener
{
  c$2(c paramc, h paramh) {}
  
  public final void onSurfaceTextureAvailable(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(248302);
    Log.i("MicroMsg.LiveCoreVisitor", "customRender onSurfaceTextureAvailable, size:[%s, %s]", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    this.mTQ.di(new Surface(paramSurfaceTexture));
    this.mTQ.ej(paramInt1, paramInt2);
    AppMethodBeat.o(248302);
  }
  
  public final boolean onSurfaceTextureDestroyed(SurfaceTexture paramSurfaceTexture)
  {
    AppMethodBeat.i(248316);
    Log.i("MicroMsg.LiveCoreVisitor", "customRender onSurfaceTextureDestroyed");
    this.mTQ.bgH();
    AppMethodBeat.o(248316);
    return false;
  }
  
  public final void onSurfaceTextureSizeChanged(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(248311);
    Log.i("MicroMsg.LiveCoreVisitor", "customRender onSurfaceTextureSizeChanged, size:[%s, %s]", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    this.mTQ.ej(paramInt1, paramInt2);
    AppMethodBeat.o(248311);
  }
  
  public final void onSurfaceTextureUpdated(SurfaceTexture paramSurfaceTexture) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.live.core.core.trtc.sdkadapter.b.c.2
 * JD-Core Version:    0.7.0.1
 */