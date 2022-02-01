package com.tencent.mm.plugin.appbrand.jsapi;

import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import junit.framework.Assert;
import org.a.a;

public abstract class b
{
  private String ktu;
  
  public b()
  {
    Assert.assertTrue("Must declare NAME in subclasses", true);
  }
  
  public final String getName()
  {
    if (bu.isNullOrNil(this.ktu)) {}
    try
    {
      this.ktu = ((String)a.bF(getClass()).bfB("NAME").object);
      return this.ktu;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ae.e("MicroMsg.AppBrand.BaseJsApi", "getName exp = %s", new Object[] { bu.o(localException) });
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.b
 * JD-Core Version:    0.7.0.1
 */