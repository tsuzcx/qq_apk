package com.tencent.mm.plugin.appbrand.jsapi.camera;

import android.util.Size;
import android.view.View;
import com.tencent.mm.plugin.appbrand.jsapi.h;
import com.tencent.mm.plugin.appbrand.jsapi.i.b;
import com.tencent.mm.plugin.appbrand.jsapi.i.c;
import com.tencent.mm.plugin.appbrand.jsapi.i.d;

public abstract interface f
  extends i.b, i.c, i.d
{
  public static final f lQc = new f()
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
    
    public final void o(com.tencent.mm.plugin.appbrand.jsapi.f paramAnonymousf) {}
    
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
    
    public final void setPage(h paramAnonymoush) {}
    
    public final void setPageOrientation(boolean paramAnonymousBoolean) {}
    
    public final void setPreviewCenterCrop(boolean paramAnonymousBoolean) {}
    
    public final void setQuality(String paramAnonymousString) {}
    
    public final void setResolution(String paramAnonymousString) {}
    
    public final void setScanFreq(int paramAnonymousInt) {}
    
    public final void x(int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3, int paramAnonymousInt4) {}
  };
  
  public abstract float aJ(float paramFloat);
  
  public abstract void ar(String paramString, boolean paramBoolean);
  
  public abstract void bFK();
  
  public abstract void bFM();
  
  public abstract void bFN();
  
  public abstract void bFT();
  
  public abstract void bFU();
  
  public abstract boolean dZ(int paramInt1, int paramInt2);
  
  public abstract int getCameraId();
  
  public abstract View getView();
  
  public abstract void initView();
  
  public abstract void o(com.tencent.mm.plugin.appbrand.jsapi.f paramf);
  
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
  
  public abstract void setPage(h paramh);
  
  public abstract void setPageOrientation(boolean paramBoolean);
  
  public abstract void setPreviewCenterCrop(boolean paramBoolean);
  
  public abstract void setQuality(String paramString);
  
  public abstract void setResolution(String paramString);
  
  public abstract void setScanFreq(int paramInt);
  
  public abstract void x(int paramInt1, int paramInt2, int paramInt3, int paramInt4);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.camera.f
 * JD-Core Version:    0.7.0.1
 */