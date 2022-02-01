package com.tencent.mm.plugin.lite.api;

import android.content.Context;
import android.os.Bundle;
import com.tencent.liteapp.storage.WxaLiteAppBaselibInfo;
import com.tencent.liteapp.storage.WxaLiteAppInfo;
import com.tencent.mm.kernel.c.a;
import org.json.JSONObject;

public abstract interface c
  extends a
{
  public abstract void a(Context paramContext, Bundle paramBundle, boolean paramBoolean1, boolean paramBoolean2, a parama);
  
  public abstract void a(WxaLiteAppInfo paramWxaLiteAppInfo);
  
  public abstract void a(String paramString, b paramb);
  
  public abstract void aB(String paramString1, String paramString2, String paramString3);
  
  public abstract void aJS(String paramString);
  
  public abstract boolean aJT(String paramString);
  
  public abstract boolean aJU(String paramString);
  
  public abstract int bo(JSONObject paramJSONObject);
  
  public abstract int bp(JSONObject paramJSONObject);
  
  public abstract WxaLiteAppInfo et(String paramString);
  
  public abstract void fTS();
  
  public abstract boolean fTT();
  
  public abstract WxaLiteAppBaselibInfo fTU();
  
  public abstract void iK(Context paramContext);
  
  public abstract boolean isInitialized();
  
  public abstract void jS(String paramString1, String paramString2);
  
  public abstract void jT(String paramString1, String paramString2);
  
  public static abstract interface a
  {
    public abstract void csx();
    
    public abstract void csy();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.lite.api.c
 * JD-Core Version:    0.7.0.1
 */