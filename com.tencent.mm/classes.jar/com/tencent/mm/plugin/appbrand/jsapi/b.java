package com.tencent.mm.plugin.appbrand.jsapi;

import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import junit.framework.Assert;
import org.a.a;

public abstract class b
{
  private String jVR;
  
  public b()
  {
    Assert.assertTrue("Must declare NAME in subclasses", true);
  }
  
  public final String getName()
  {
    if (bs.isNullOrNil(this.jVR)) {}
    try
    {
      this.jVR = ((String)a.bD(getClass()).aXB("NAME").object);
      return this.jVR;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ac.e("MicroMsg.AppBrand.BaseJsApi", "getName exp = %s", new Object[] { bs.m(localException) });
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.b
 * JD-Core Version:    0.7.0.1
 */