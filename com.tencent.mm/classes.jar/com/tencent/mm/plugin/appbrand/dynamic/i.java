package com.tencent.mm.plugin.appbrand.dynamic;

import android.text.TextUtils;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public final class i
{
  private static final i fUa = new i();
  private Map<String, String> fTZ = new HashMap();
  
  public static i aeX()
  {
    return fUa;
  }
  
  public final Collection<String> aeY()
  {
    return this.fTZ.values();
  }
  
  public final void bm(String paramString1, String paramString2)
  {
    if (TextUtils.isEmpty(paramString2)) {
      return;
    }
    this.fTZ.put(paramString1, paramString2);
  }
  
  public final String sX(String paramString)
  {
    return (String)this.fTZ.get(paramString);
  }
  
  public final void sY(String paramString)
  {
    this.fTZ.remove(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.dynamic.i
 * JD-Core Version:    0.7.0.1
 */