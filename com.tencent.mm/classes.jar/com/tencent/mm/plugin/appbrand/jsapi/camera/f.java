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
  public static final f kIb = new f()
  {
    public final void ap(String paramAnonymousString, boolean paramAnonymousBoolean) {}
    
    public final float az(float paramAnonymousFloat)
    {
      return 0.0F;
    }
    
    public final void bjF() {}
    
    public final void bjH() {}
    
    public final void bjI() {}
    
    public final void bjO() {}
    
    public final void bjP() {}
    
    public final boolean dO(int paramAnonymousInt1, int paramAnonymousInt2)
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
    
    public final void x(int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3, int paramAnonymousInt4) {}
  };
  
  public abstract void ap(String paramString, boolean paramBoolean);
  
  public abstract float az(float paramFloat);
  
  public abstract void bjF();
  
  public abstract void bjH();
  
  public abstract void bjI();
  
  public abstract void bjO();
  
  public abstract void bjP();
  
  public abstract boolean dO(int paramInt1, int paramInt2);
  
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
  
  public abstract void x(int paramInt1, int paramInt2, int paramInt3, int paramInt4);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.camera.f
 * JD-Core Version:    0.7.0.1
 */