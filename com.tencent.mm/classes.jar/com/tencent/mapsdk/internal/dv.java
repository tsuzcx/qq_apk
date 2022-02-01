package com.tencent.mapsdk.internal;

import com.tencent.map.sdk.comps.vis.VisualLayer;
import com.tencent.map.sdk.comps.vis.VisualLayerOptions;
import com.tencent.map.tools.Callback;
import com.tencent.tencentmap.mapsdk.maps.TencentMapComponent.Component;
import org.json.JSONObject;

public abstract interface dv
  extends TencentMapComponent.Component
{
  public abstract VisualLayer a(VisualLayerOptions paramVisualLayerOptions);
  
  public abstract void a(String paramString);
  
  public abstract void a(String paramString, int paramInt);
  
  public abstract void a(String paramString, int paramInt1, int paramInt2);
  
  public abstract void a(String paramString, Callback<byte[]> paramCallback);
  
  public abstract void a(String paramString, byte[] paramArrayOfByte);
  
  public abstract void a(JSONObject paramJSONObject);
  
  public abstract boolean a();
  
  public abstract void b(String paramString);
  
  public abstract void b(String paramString, Callback<byte[]> paramCallback);
  
  public abstract boolean c(String paramString);
  
  public abstract bm c_();
  
  public abstract void d(String paramString);
  
  public abstract void e(String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mapsdk.internal.dv
 * JD-Core Version:    0.7.0.1
 */