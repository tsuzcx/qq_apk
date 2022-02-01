package com.tencent.mm.plugin.appbrand.jsapi.y.a;

import android.annotation.TargetApi;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@TargetApi(5)
public abstract class a
  implements c
{
  private Map<String, Object> kvN = new ConcurrentHashMap();
  
  protected void O(String paramString, int paramInt1, int paramInt2)
  {
    paramString = this.kvN.values().iterator();
    while (paramString.hasNext()) {
      paramString.next();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.y.a.a
 * JD-Core Version:    0.7.0.1
 */