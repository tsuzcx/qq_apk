package com.tencent.mm.plugin.appbrand.jsapi.websocket;

import com.tencent.mm.plugin.appbrand.af.e.a;
import com.tencent.mm.plugin.appbrand.af.e.h;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Map;
import org.json.JSONObject;

public abstract interface d
{
  public static final ArrayList<e> pFQ = new ArrayList();
  
  public abstract void a(e parame);
  
  public abstract void a(e parame, int paramInt, String paramString);
  
  public abstract void a(e parame, String paramString);
  
  public abstract void a(e parame, ByteBuffer paramByteBuffer);
  
  public abstract void a(String paramString1, String paramString2, int paramInt1, int paramInt2, JSONObject paramJSONObject, Map<String, String> paramMap, a parama);
  
  public abstract e ajs(String paramString);
  
  public abstract boolean b(e parame);
  
  public abstract void release();
  
  public static abstract interface a
  {
    public abstract void a(a parama);
    
    public abstract void a(h paramh, Map<String, Long> paramMap);
    
    public abstract void afG(String paramString);
    
    public abstract void afH(String paramString);
    
    public abstract void ag(int paramInt, String paramString);
    
    public abstract void aii(String paramString);
    
    public abstract void h(ByteBuffer paramByteBuffer);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.websocket.d
 * JD-Core Version:    0.7.0.1
 */