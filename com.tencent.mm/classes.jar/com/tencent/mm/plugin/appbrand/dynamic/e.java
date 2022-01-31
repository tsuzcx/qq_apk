package com.tencent.mm.plugin.appbrand.dynamic;

import android.view.View;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class e
{
  private static volatile e fTQ;
  public Map<String, WeakReference<View>> fTR = new ConcurrentHashMap();
  
  public static e aeV()
  {
    if (fTQ == null) {}
    try
    {
      if (fTQ == null) {
        fTQ = new e();
      }
      return fTQ;
    }
    finally {}
  }
  
  public final View sU(String paramString)
  {
    if (bk.bl(paramString))
    {
      y.w("MicroMsg.DynamicPageViewMgr", "get view from manager failed, key is null or nil.");
      return null;
    }
    paramString = (WeakReference)this.fTR.get(paramString);
    if (paramString != null) {
      return (View)paramString.get();
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.dynamic.e
 * JD-Core Version:    0.7.0.1
 */