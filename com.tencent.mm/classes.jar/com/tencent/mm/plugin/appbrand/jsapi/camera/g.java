package com.tencent.mm.plugin.appbrand.jsapi.camera;

import android.util.Size;
import android.view.MotionEvent;
import android.view.Surface;
import android.view.View;
import com.tencent.mm.plugin.appbrand.jsapi.h;

public abstract interface g
  extends f
{
  public static final g rQt = new g()
  {
    public final void F(int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3, int paramAnonymousInt4) {}
    
    public final void aE(String paramAnonymousString, boolean paramAnonymousBoolean) {}
    
    public final float bH(float paramAnonymousFloat)
    {
      return 0.0F;
    }
    
    public final void crB() {}
    
    public final void crC() {}
    
    public final void crI() {}
    
    public final boolean fs(int paramAnonymousInt1, int paramAnonymousInt2)
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
    
    public final void jl(boolean paramAnonymousBoolean) {}
    
    public final void jm(boolean paramAnonymousBoolean) {}
    
    public final void o(MotionEvent paramAnonymousMotionEvent) {}
    
    public final void onBackground() {}
    
    public final void onDestroy() {}
    
    public final void onForeground() {}
    
    public final void release() {}
    
    public final void s(com.tencent.mm.plugin.appbrand.jsapi.f paramAnonymousf) {}
    
    public final void setAppId(String paramAnonymousString) {}
    
    public final void setCameraId(int paramAnonymousInt) {}
    
    public final void setCompressRecord(boolean paramAnonymousBoolean) {}
    
    public final void setCustomSurface(Surface paramAnonymousSurface) {}
    
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
  };
  
  public abstract void o(MotionEvent paramMotionEvent);
  
  public abstract void setCustomSurface(Surface paramSurface);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.camera.g
 * JD-Core Version:    0.7.0.1
 */