package com.tencent.mm.plugin.appbrand.jsapi.camera;

import android.view.View;
import com.tencent.mm.plugin.appbrand.jsapi.f.b;
import com.tencent.mm.plugin.appbrand.jsapi.f.c;
import com.tencent.mm.plugin.appbrand.jsapi.f.d;

public abstract interface e
  extends f.b, f.c, f.d
{
  public static final e hJc = new e.1();
  
  public abstract void aCA();
  
  public abstract void aCC();
  
  public abstract void aCD();
  
  public abstract void aCJ();
  
  public abstract void aCK();
  
  public abstract void aj(String paramString, boolean paramBoolean);
  
  public abstract boolean dg(int paramInt1, int paramInt2);
  
  public abstract int getCameraId();
  
  public abstract View getView();
  
  public abstract void initView();
  
  public abstract void p(com.tencent.mm.plugin.appbrand.jsapi.c paramc);
  
  public abstract void release();
  
  public abstract void setAppId(String paramString);
  
  public abstract void setCameraId(int paramInt);
  
  public abstract void setCompressRecord(boolean paramBoolean);
  
  public abstract void setFlash(String paramString);
  
  public abstract void setFrameLimitSize(int paramInt);
  
  public abstract void setMode(String paramString);
  
  public abstract void setNeedOutput(boolean paramBoolean);
  
  public abstract void setOperateCallBack(c paramc);
  
  public abstract void setOutPutCallBack(b paramb);
  
  public abstract void setPage(com.tencent.mm.plugin.appbrand.jsapi.e parame);
  
  public abstract void setQuality(String paramString);
  
  public abstract void setScanFreq(int paramInt);
  
  public abstract void w(int paramInt1, int paramInt2, int paramInt3, int paramInt4);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.camera.e
 * JD-Core Version:    0.7.0.1
 */