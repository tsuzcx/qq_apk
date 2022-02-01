package com.tencent.mm.plugin.appbrand.jsapi.websocket;

import com.tencent.mm.plugin.appbrand.ah.e.a;
import com.tencent.mm.plugin.appbrand.ah.e.h;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Map;
import org.json.JSONObject;

public abstract interface d
{
  public static final ArrayList<e> sKY = new ArrayList();
  
  public abstract void a(e parame);
  
  public abstract void a(e parame, int paramInt, String paramString);
  
  public abstract void a(e parame, String paramString);
  
  public abstract void a(e parame, ByteBuffer paramByteBuffer);
  
  public abstract void a(String paramString1, String paramString2, int paramInt1, int paramInt2, JSONObject paramJSONObject, Map<String, String> paramMap, a parama);
  
  public abstract e act(String paramString);
  
  public abstract boolean b(e parame);
  
  public abstract void release();
  
  public static abstract interface a
  {
    public abstract void Yf(String paramString);
    
    public abstract void Yg(String paramString);
    
    public abstract void a(a parama);
    
    public abstract void a(h paramh, Map<String, String> paramMap);
    
    public abstract void abg(String paramString);
    
    public abstract void ap(int paramInt, String paramString);
    
    public abstract void n(ByteBuffer paramByteBuffer);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.websocket.d
 * JD-Core Version:    0.7.0.1
 */