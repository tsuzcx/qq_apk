package com.tencent.mm.plugin.appbrand.appcache;

import com.tencent.mm.plugin.appbrand.appcache.a.a;
import com.tencent.mm.sdk.platformtools.bk;
import java.util.concurrent.ConcurrentHashMap;

public final class m
  implements t.b
{
  private static final ConcurrentHashMap<String, Boolean> fCm = new ConcurrentHashMap();
  
  public static void qT(String paramString)
  {
    if (bk.bl(paramString)) {
      return;
    }
    fCm.put(paramString, Boolean.valueOf(true));
  }
  
  public final t.a a(a parama)
  {
    if ((ak.class == parama.getClass()) || (ae.class == parama.getClass()) || (af.class == parama.getClass())) {
      return new m.a(parama, (byte)0);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.m
 * JD-Core Version:    0.7.0.1
 */