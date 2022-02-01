package com.tencent.mm.plugin.appbrand.jsapi;

import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import junit.framework.Assert;
import org.a.a;

public abstract class e
{
  private String rvR;
  
  public e()
  {
    Assert.assertTrue("Must declare NAME in subclasses", true);
  }
  
  public final String getName()
  {
    if (Util.isNullOrNil(this.rvR)) {}
    try
    {
      this.rvR = ((String)a.cQ(getClass()).bLt("NAME").object);
      return this.rvR;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.e
 * JD-Core Version:    0.7.0.1
 */