package com.tencent.mm.plugin.appbrand.jsapi.camera;

import android.util.Size;
import android.view.View;
import com.tencent.mm.plugin.appbrand.jsapi.e;
import com.tencent.mm.plugin.appbrand.jsapi.f.b;
import com.tencent.mm.plugin.appbrand.jsapi.f.c;
import com.tencent.mm.plugin.appbrand.jsapi.f.d;

public abstract interface f
  extends f.b, f.c, f.d
{
  public static final f knb = new f()
  {
    public final void ao(String paramAnonymousString, boolean paramAnonymousBoolean) {}
    
    public final float aw(float paramAnonymousFloat)
    {
      return 0.0F;
    }
    
    public final void bgb() {}
    
    public final void bgd() {}
    
    public final void bge() {}
    
    public final void bgk() {}
    
    public final void bgl() {}
    
    public final boolean dM(int paramAnonymousInt1, int paramAnonymousInt2)
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
    
    public final void o(com.tencent.mm.plugin.appbrand.jsapi.c paramAnonymousc) {}
    
    public final void onBackground() {}
    
    public final void onDestroy() {}
    
    public final void onForeground() {}
    
    public final void release() {}
    
    public final void setAppId(String paramAnonymousString) {}
    
    public final void setCameraId(int paramAnonymousInt) {}
    
    public final void setCompressRecord(boolean paramAnonymousBoolean) {}
    
    public final void setDisplayScreenSize(Size paramAnonymousSize) {}
    
    public final void setFlash(String paramAnonymousString) {}
    
    public final void setFrameLimitSize(int paramAnonymousInt) {}
    
    public final void setMode(String paramAnonymousString) {}
    
    public final void setNeedOutput(boolean paramAnonymousBoolean) {}
    
    public final void setOperateCallBack(c paramAnonymousc) {}
    
    public final void setOutPutCallBack(b paramAnonymousb) {}
    
    public final void setPage(e paramAnonymouse) {}
    
    public final void setPreviewCenterCrop(boolean paramAnonymousBoolean) {}
    
    public final void setQuality(String paramAnonymousString) {}
    
    public final void setResolution(String paramAnonymousString) {}
    
    public final void setScanFreq(int paramAnonymousInt) {}
    
    public final void w(int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3, int paramAnonymousInt4) {}
  };
  
  public abstract void ao(String paramString, boolean paramBoolean);
  
  public abstract float aw(float paramFloat);
  
  public abstract void bgb();
  
  public abstract void bgd();
  
  public abstract void bge();
  
  public abstract void bgk();
  
  public abstract void bgl();
  
  public abstract boolean dM(int paramInt1, int paramInt2);
  
  public abstract int getCameraId();
  
  public abstract View getView();
  
  public abstract void initView();
  
  public abstract void o(com.tencent.mm.plugin.appbrand.jsapi.c paramc);
  
  public abstract void release();
  
  public abstract void setAppId(String paramString);
  
  public abstract void setCameraId(int paramInt);
  
  public abstract void setCompressRecord(boolean paramBoolean);
  
  public abstract void setDisplayScreenSize(Size paramSize);
  
  public abstract void setFlash(String paramString);
  
  public abstract void setFrameLimitSize(int paramInt);
  
  public abstract void setMode(String paramString);
  
  public abstract void setNeedOutput(boolean paramBoolean);
  
  public abstract void setOperateCallBack(c paramc);
  
  public abstract void setOutPutCallBack(b paramb);
  
  public abstract void setPage(e parame);
  
  public abstract void setPreviewCenterCrop(boolean paramBoolean);
  
  public abstract void setQuality(String paramString);
  
  public abstract void setResolution(String paramString);
  
  public abstract void setScanFreq(int paramInt);
  
  public abstract void w(int paramInt1, int paramInt2, int paramInt3, int paramInt4);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.camera.f
 * JD-Core Version:    0.7.0.1
 */