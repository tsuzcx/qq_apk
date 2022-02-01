package com.tencent.mm.plugin.appbrand.jsapi;

import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import junit.framework.Assert;
import org.a.a;

public abstract class e
{
  private String lxk;
  
  public e()
  {
    Assert.assertTrue("Must declare NAME in subclasses", true);
  }
  
  public final String getName()
  {
    if (Util.isNullOrNil(this.lxk)) {}
    try
    {
      this.lxk = ((String)a.bF(getClass()).bvr("NAME").object);
      return this.lxk;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Log.e("MicroMsg.AppBrand.BaseJsApi", "getName exp = %s", new Object[] { Util.stackTraceToString(localException) });
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.e
 * JD-Core Version:    0.7.0.1
 */