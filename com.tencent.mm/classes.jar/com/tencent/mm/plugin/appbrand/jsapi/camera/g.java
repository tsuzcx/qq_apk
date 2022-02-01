package com.tencent.mm.plugin.appbrand.jsapi.camera;

import android.graphics.SurfaceTexture;
import android.util.Size;
import android.view.MotionEvent;
import android.view.View;
import com.tencent.mm.plugin.appbrand.jsapi.h;

public abstract interface g
  extends f
{
  public static final g lQd = new g()
  {
    public final float aJ(float paramAnonymousFloat)
    {
      return 0.0F;
    }
    
    public final void ar(String paramAnonymousString, boolean paramAnonymousBoolean) {}
    
    public final void bFK() {}
    
    public final void bFM() {}
    
    public final void bFN() {}
    
    public final void bFT() {}
    
    public final void bFU() {}
    
    public final boolean dZ(int paramAnonymousInt1, int paramAnonymousInt2)
    {
      return false;
    }
    
    public final int getCameraId()
    {
      return 0;
    }
    
    public final View getView()
    {
      return null;
    }
    
    public final void initView() {}
    
    public final void o(MotionEvent paramAnonymousMotionEvent) {}
    
    public final void o(com.tencent.mm.plugin.appbrand.jsapi.f paramAnonymousf) {}
    
    public final void onBackground() {}
    
    public final void onDestroy() {}
    
    public final void onForeground() {}
    
    public final void release() {}
    
    public final void setAppId(String paramAnonymousString) {}
    
    public final void setCameraId(int paramAnonymousInt) {}
    
    public final void setCompressRecord(boolean paramAnonymousBoolean) {}
    
    public final void setCustomSurfaceTexture(SurfaceTexture paramAnonymousSurfaceTexture) {}
    
    public final void setDisplayScreenSize(Size paramAnonymousSize) {}
    
    public final void setFlash(String paramAnonymousString) {}
    
    public final void setFrameLimitSize(int paramAnonymousInt) {}
    
    public final void setMode(String paramAnonymousString) {}
    
    public final void setNeedOutput(boolean paramAnonymousBoolean) {}
    
    public final void setOperateCallBack(c paramAnonymousc) {}
    
    public final void setOutPutCallBack(b paramAnonymousb) {}
    
    public final void setPage(h paramAnonymoush) {}
    
    public final void setPageOrientation(boolean paramAnonymousBoolean) {}
    
    public final void setPreviewCenterCrop(boolean paramAnonymousBoolean) {}
    
    public final void setQuality(String paramAnonymousString) {}
    
    public final void setResolution(String paramAnonymousString) {}
    
    public final void setScanFreq(int paramAnonymousInt) {}
    
    public final void x(int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3, int paramAnonymousInt4) {}
  };
  
  public abstract void o(MotionEvent paramMotionEvent);
  
  public abstract void setCustomSurfaceTexture(SurfaceTexture paramSurfaceTexture);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.camera.g
 * JD-Core Version:    0.7.0.1
 */