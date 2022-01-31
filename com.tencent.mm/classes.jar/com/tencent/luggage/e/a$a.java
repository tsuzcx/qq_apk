package com.tencent.luggage.e;

import com.tencent.luggage.bridge.k;
import java.util.Map;
import org.json.JSONObject;

public final class a$a
{
  public CONTEXT big;
  public k bih;
  
  public a$a(a parama) {}
  
  public final void a(String paramString, JSONObject paramJSONObject)
  {
    this.bih.a(paramString, paramJSONObject);
  }
  
  public final void c(String paramString, Map<String, Object> paramMap)
  {
    k localk = this.bih;
    String str = paramString;
    if (paramString == null) {
      str = "";
    }
    localk.bhD = str;
    if (paramMap != null) {}
    for (paramString = new JSONObject(paramMap);; paramString = null)
    {
      localk.bhE = paramString;
      if (localk.bhx != 0) {
        localk.pQ();
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.luggage.e.a.a
 * JD-Core Version:    0.7.0.1
 */