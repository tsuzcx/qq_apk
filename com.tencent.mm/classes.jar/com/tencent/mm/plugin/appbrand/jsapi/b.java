package com.tencent.mm.plugin.appbrand.jsapi;

import com.tencent.mm.compatible.loader.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import junit.framework.Assert;

public abstract class b
{
  private String hwF;
  
  public b()
  {
    Assert.assertTrue("Must declare NAME in subclasses", true);
  }
  
  public final String getName()
  {
    c localc;
    if (bo.isNullOrNil(this.hwF)) {
      localc = new c(this, "NAME", null);
    }
    try
    {
      this.hwF = ((String)localc.get());
      return this.hwF;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ab.e("MicroMsg.AppBrand.BaseJsApi", "getName exp = %s", new Object[] { bo.l(localException) });
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.b
 * JD-Core Version:    0.7.0.1
 */