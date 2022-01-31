package com.tencent.mm.plugin.api.recordView;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.util.AttributeSet;
import android.view.TextureView.SurfaceTextureListener;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.base.MMTextureView;

class MMSightRecordTextureView
  extends MMTextureView
  implements TextureView.SurfaceTextureListener
{
  private int fvV;
  private int fvW;
  private d fwE;
  private c fwF;
  
  public MMSightRecordTextureView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    setSurfaceTextureListener(this);
  }
  
  public MMSightRecordTextureView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    setSurfaceTextureListener(this);
  }
  
  public void onSurfaceTextureAvailable(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
  {
    y.i("MicroMsg.MMSightRecordTextureViewImpl", "onSurfaceTextureAvailable, surface: %s, width: %s, height: %s", new Object[] { paramSurfaceTexture, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    this.fvV = paramInt1;
    this.fvW = paramInt2;
    this.fwE = new d();
    this.fwF = new c(paramSurfaceTexture, this.fwE);
    this.fwE.bH(paramInt1, paramInt2);
    this.fwF.needRender = true;
    this.fwF.start();
  }
  
  public boolean onSurfaceTextureDestroyed(SurfaceTexture paramSurfaceTexture)
  {
    this.fwF.needRender = false;
    try
    {
      this.fwF.join();
      this.fwF = null;
      return false;
    }
    catch (InterruptedException paramSurfaceTexture)
    {
      for (;;)
      {
        y.printErrStackTrace("MicroMsg.MMSightRecordTextureViewImpl", paramSurfaceTexture, "onSurfaceTextureDestroyed error: %s", new Object[] { paramSurfaceTexture.getMessage() });
      }
    }
  }
  
  public void onSurfaceTextureSizeChanged(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
  {
    y.i("MicroMsg.MMSightRecordTextureViewImpl", "onSurfaceTextureSizeChanged, surface: %s, width: %s, height: %s", new Object[] { paramSurfaceTexture, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    this.fvV = paramInt1;
    this.fvW = paramInt2;
    this.fwE.bH(paramInt1, paramInt2);
  }
  
  public void onSurfaceTextureUpdated(SurfaceTexture paramSurfaceTexture) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.api.recordView.MMSightRecordTextureView
 * JD-Core Version:    0.7.0.1
 */