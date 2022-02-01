package com.tencent.mm.plugin.api.recordView;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.util.AttributeSet;
import android.view.TextureView.SurfaceTextureListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.ui.base.MMTextureView;

class MMSightRecordTextureView
  extends MMTextureView
  implements TextureView.SurfaceTextureListener
{
  private d jbx;
  private c jby;
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
    ac.i("MicroMsg.MMSightRecordTextureViewImpl", "onSurfaceTextureAvailable, surface: %s, width: %s, height: %s", new Object[] { paramSurfaceTexture, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    this.surfaceWidth = paramInt1;
    this.surfaceHeight = paramInt2;
    this.jbx = new d();
    this.jby = new c(paramSurfaceTexture, this.jbx);
    this.jbx.dz(paramInt1, paramInt2);
    this.jby.jbz = true;
    this.jby.start();
    AppMethodBeat.o(89212);
  }
  
  public boolean onSurfaceTextureDestroyed(SurfaceTexture paramSurfaceTexture)
  {
    AppMethodBeat.i(89214);
    this.jby.jbz = false;
    try
    {
      this.jby.join();
      this.jby = null;
      AppMethodBeat.o(89214);
      return false;
    }
    catch (InterruptedException paramSurfaceTexture)
    {
      for (;;)
      {
        ac.printErrStackTrace("MicroMsg.MMSightRecordTextureViewImpl", paramSurfaceTexture, "onSurfaceTextureDestroyed error: %s", new Object[] { paramSurfaceTexture.getMessage() });
      }
    }
  }
  
  public void onSurfaceTextureSizeChanged(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(89213);
    ac.i("MicroMsg.MMSightRecordTextureViewImpl", "onSurfaceTextureSizeChanged, surface: %s, width: %s, height: %s", new Object[] { paramSurfaceTexture, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    this.surfaceWidth = paramInt1;
    this.surfaceHeight = paramInt2;
    this.jbx.dz(paramInt1, paramInt2);
    AppMethodBeat.o(89213);
  }
  
  public void onSurfaceTextureUpdated(SurfaceTexture paramSurfaceTexture) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.api.recordView.MMSightRecordTextureView
 * JD-Core Version:    0.7.0.1
 */