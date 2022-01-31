package com.tencent.mm.plugin.appbrand.game.f.a;

import android.content.Context;
import android.graphics.SurfaceTexture;
import com.tencent.matrix.trace.core.AppMethodBeat;
import org.xwalk.core.Log;

public final class b
  extends a
{
  private boolean htQ = false;
  private com.tencent.mm.media.h.a htR = null;
  private int mSurfaceHeight = 0;
  private int mSurfaceWidth = 0;
  
  public b(Context paramContext)
  {
    super(paramContext);
  }
  
  public final com.tencent.mm.media.h.a getAbsSurfaceRenderer()
  {
    return this.htR;
  }
  
  public final int getSurfaceHeight()
  {
    return this.mSurfaceHeight;
  }
  
  public final int getSurfaceWidth()
  {
    return this.mSurfaceWidth;
  }
  
  public final boolean isAvailable()
  {
    return this.htQ;
  }
  
  public final void onSurfaceTextureAvailable(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(143201);
    Log.i("MicroMsg.ScreenView", "onSurfaceTextureAvailable, surface:" + paramSurfaceTexture + ", width:" + paramInt1 + ", height:" + paramInt2);
    try
    {
      this.htR = new b.1(this);
      this.htR.cm(paramInt1, paramInt2);
      this.htR.cn(paramInt1, paramInt2);
      setPreviewRenderer(new b.2(this, paramInt1, paramInt2));
      try
      {
        this.htQ = true;
        this.mSurfaceWidth = paramInt1;
        this.mSurfaceHeight = paramInt2;
        super.onSurfaceTextureAvailable(paramSurfaceTexture, paramInt1, paramInt2);
        AppMethodBeat.o(143201);
        return;
      }
      finally
      {
        AppMethodBeat.o(143201);
      }
      return;
    }
    catch (Exception paramSurfaceTexture)
    {
      Log.i("MicroMsg.ScreenView", "onSurfaceTextureAvailable, error:" + paramSurfaceTexture.getMessage());
      AppMethodBeat.o(143201);
    }
  }
  
  public final boolean onSurfaceTextureDestroyed(SurfaceTexture paramSurfaceTexture)
  {
    AppMethodBeat.i(143203);
    Log.i("MicroMsg.ScreenView", "onSurfaceTextureDestroyed, surface:".concat(String.valueOf(paramSurfaceTexture)));
    boolean bool = super.onSurfaceTextureDestroyed(paramSurfaceTexture);
    AppMethodBeat.o(143203);
    return bool;
  }
  
  public final void onSurfaceTextureSizeChanged(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(143202);
    Log.i("MicroMsg.ScreenView", "onSurfaceTextureSizeChanged, surface:" + paramSurfaceTexture + ", width:" + paramInt1 + ", height:" + paramInt2);
    super.onSurfaceTextureSizeChanged(paramSurfaceTexture, paramInt1, paramInt2);
    AppMethodBeat.o(143202);
  }
  
  public final void onSurfaceTextureUpdated(SurfaceTexture paramSurfaceTexture)
  {
    AppMethodBeat.i(143204);
    super.onSurfaceTextureUpdated(paramSurfaceTexture);
    AppMethodBeat.o(143204);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.game.f.a.b
 * JD-Core Version:    0.7.0.1
 */