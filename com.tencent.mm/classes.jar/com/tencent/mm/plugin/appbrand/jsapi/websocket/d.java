package com.tencent.mm.plugin.appbrand.jsapi.websocket;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Map;
import org.json.JSONObject;

public abstract interface d
{
  public static final ArrayList<e> igD = new ArrayList();
  
  public abstract e CX(String paramString);
  
  public abstract void a(e parame);
  
  public abstract void a(e parame, int paramInt, String paramString);
  
  public abstract void a(e parame, String paramString);
  
  public abstract void a(e parame, ByteBuffer paramByteBuffer);
  
  public abstract void a(String paramString1, String paramString2, int paramInt1, int paramInt2, JSONObject paramJSONObject, Map<String, String> paramMap, d.a parama);
  
  public abstract boolean b(e parame);
  
  public abstract void release();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.websocket.d
 * JD-Core Version:    0.7.0.1
 */