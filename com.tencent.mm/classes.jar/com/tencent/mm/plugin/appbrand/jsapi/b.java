package com.tencent.mm.plugin.appbrand.jsapi;

import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import junit.framework.Assert;
import org.a.a;

public abstract class b
{
  private String jvv;
  
  public b()
  {
    Assert.assertTrue("Must declare NAME in subclasses", true);
  }
  
  public final String getName()
  {
    if (bt.isNullOrNil(this.jvv)) {}
    try
    {
      this.jvv = ((String)a.bA(getClass()).aRB("NAME").object);
      return this.jvv;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ad.e("MicroMsg.AppBrand.BaseJsApi", "getName exp = %s", new Object[] { bt.m(localException) });
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.b
 * JD-Core Version:    0.7.0.1
 */