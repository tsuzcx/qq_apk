package com.tencent.mm.plugin.appbrand.jsapi.camera;

import com.tencent.mm.plugin.appbrand.jsapi.e;
import com.tencent.mm.plugin.appbrand.jsapi.e.b;
import com.tencent.mm.plugin.appbrand.jsapi.e.c;
import com.tencent.mm.plugin.appbrand.jsapi.e.d;

public abstract interface d
  extends e.b, e.c, e.d
{
  public static final d goY = new d.1();
  
  public abstract void ae(String paramString, boolean paramBoolean);
  
  public abstract void aiF();
  
  public abstract void aiH();
  
  public abstract void aiN();
  
  public abstract boolean bV(int paramInt1, int paramInt2);
  
  public abstract int getCameraId();
  
  public abstract void initView();
  
  public abstract void o(int paramInt1, int paramInt2, int paramInt3, int paramInt4);
  
  public abstract void release();
  
  public abstract void setAppId(String paramString);
  
  public abstract void setCameraId(int paramInt);
  
  public abstract void setFlash(String paramString);
  
  public abstract void setMode(String paramString);
  
  public abstract void setNeedOutput(boolean paramBoolean);
  
  public abstract void setOperateCallBack(c paramc);
  
  public abstract void setOutPutCallBack(b paramb);
  
  public abstract void setPage(e parame);
  
  public abstract void setQuality(String paramString);
  
  public abstract void setScanFreq(int paramInt);
  
  public abstract void startRecord();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.camera.d
 * JD-Core Version:    0.7.0.1
 */