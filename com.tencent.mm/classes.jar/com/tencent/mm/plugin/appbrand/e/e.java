package com.tencent.mm.plugin.appbrand.e;

import android.graphics.SurfaceTexture;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.i;
import org.json.JSONObject;

public class e
  implements g
{
  protected f fYs;
  protected int id;
  protected boolean qcQ;
  protected String type;
  
  public String a(c paramc, JSONObject paramJSONObject, i parami)
  {
    return null;
  }
  
  public final void a(f paramf)
  {
    this.fYs = paramf;
  }
  
  public final f afI()
  {
    return this.fYs;
  }
  
  public final boolean aly()
  {
    return this.qcQ;
  }
  
  public void d(SurfaceTexture paramSurfaceTexture)
  {
    this.qcQ = true;
  }
  
  public final int getId()
  {
    return this.id;
  }
  
  public final String getType()
  {
    return this.type;
  }
  
  public void qB()
  {
    this.qcQ = false;
  }
  
  public void qC() {}
  
  public void qD() {}
  
  public final void setId(int paramInt)
  {
    this.id = paramInt;
  }
  
  public final void setType(String paramString)
  {
    this.type = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.e.e
 * JD-Core Version:    0.7.0.1
 */