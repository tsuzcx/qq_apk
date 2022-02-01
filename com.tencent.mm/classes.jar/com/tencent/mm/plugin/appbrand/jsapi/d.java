package com.tencent.mm.plugin.appbrand.jsapi;

import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import junit.framework.Assert;
import org.a.a;

public abstract class d
{
  private String orX;
  
  public d()
  {
    Assert.assertTrue("Must declare NAME in subclasses", true);
  }
  
  public final String getName()
  {
    if (Util.isNullOrNil(this.orX)) {}
    try
    {
      this.orX = ((String)a.ce(getClass()).bIx("NAME").object);
      return this.orX;
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
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.d
 * JD-Core Version:    0.7.0.1
 */