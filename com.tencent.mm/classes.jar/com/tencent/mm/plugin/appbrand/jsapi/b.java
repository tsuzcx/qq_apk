package com.tencent.mm.plugin.appbrand.jsapi;

import com.tencent.mm.compatible.loader.c;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import junit.framework.Assert;

public abstract class b
{
  private String geG;
  
  public b()
  {
    Assert.assertTrue("Must declare NAME in subclasses", true);
  }
  
  public final String getName()
  {
    c localc;
    if (bk.bl(this.geG)) {
      localc = new c(this, "NAME", null);
    }
    try
    {
      this.geG = ((String)localc.get());
      return this.geG;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        y.e("MicroMsg.AppBrand.BaseJsApi", "getName exp = %s", new Object[] { bk.j(localException) });
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.b
 * JD-Core Version:    0.7.0.1
 */