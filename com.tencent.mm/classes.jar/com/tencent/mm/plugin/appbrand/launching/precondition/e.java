package com.tencent.mm.plugin.appbrand.launching.precondition;

import android.content.Context;
import com.tencent.mm.sdk.platformtools.am;
import com.tencent.mm.sdk.platformtools.bk;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;

final class e
  extends b
{
  private static final Map<String, e> gMB = new ConcurrentHashMap();
  private final String gMC;
  private final String gMD;
  
  e(Context paramContext, String paramString)
  {
    this.gMC = paramString;
    this.gMD = paramContext.getClass().getName();
    gMB.put(paramString, this);
    paramContext = new e.a(paramString);
    long l = TimeUnit.SECONDS.toMillis(300L);
    paramContext.S(l, l);
  }
  
  static e uX(String paramString)
  {
    if (bk.bl(paramString)) {
      return null;
    }
    return (e)gMB.remove(paramString);
  }
  
  protected final String alZ()
  {
    return this.gMD;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.precondition.e
 * JD-Core Version:    0.7.0.1
 */