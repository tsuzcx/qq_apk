package com.tencent.mm.plugin.api.recordView;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.util.AttributeSet;
import android.view.TextureView.SurfaceTextureListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.ui.base.MMTextureView;

class MMSightRecordTextureView
  extends MMTextureView
  implements TextureView.SurfaceTextureListener
{
  private d jxB;
  private c jxC;
  private int surfaceHeight;
  private int surfaceWidth;
  
  public MMSightRecordTextureView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(89211);
    setSurfaceTextureListener(this);
    AppMethodBeat.o(89211);
  }
  
  public MMSightRecordTextureView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(89210);
    setSurfaceTextureListener(this);
    AppMethodBeat.o(89210);
  }
  
  public void onSurfaceTextureAvailable(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(89212);
    ae.i("MicroMsg.MMSightRecordTextureViewImpl", "onSurfaceTextureAvailable, surface: %s, width: %s, height: %s", new Object[] { paramSurfaceTexture, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    this.surfaceWidth = paramInt1;
    this.surfaceHeight = paramInt2;
    this.jxB = new d();
    this.jxC = new c(paramSurfaceTexture, this.jxB);
    this.jxB.dB(paramInt1, paramInt2);
    this.jxC.jxD = true;
    this.jxC.start();
    AppMethodBeat.o(89212);
  }
  
  public boolean onSurfaceTextureDestroyed(SurfaceTexture paramSurfaceTexture)
  {
    AppMethodBeat.i(89214);
    this.jxC.jxD = false;
    try
    {
      this.jxC.join();
      this.jxC = null;
      AppMethodBeat.o(89214);
      return false;
    }
    catch (InterruptedException paramSurfaceTexture)
    {
      for (;;)
      {
        ae.printErrStackTrace("MicroMsg.MMSightRecordTextureViewImpl", paramSurfaceTexture, "onSurfaceTextureDestroyed error: %s", new Object[] { paramSurfaceTexture.getMessage() });
      }
    }
  }
  
  public void onSurfaceTextureSizeChanged(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(89213);
    ae.i("MicroMsg.MMSightRecordTextureViewImpl", "onSurfaceTextureSizeChanged, surface: %s, width: %s, height: %s", new Object[] { paramSurfaceTexture, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    this.surfaceWidth = paramInt1;
    this.surfaceHeight = paramInt2;
    this.jxB.dB(paramInt1, paramInt2);
    AppMethodBeat.o(89213);
  }
  
  public void onSurfaceTextureUpdated(SurfaceTexture paramSurfaceTexture) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.api.recordView.MMSightRecordTextureView
 * JD-Core Version:    0.7.0.1
 */