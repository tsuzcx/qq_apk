package com.tencent.mm.plugin.exdevice.i;

import com.tencent.mm.plugin.exdevice.b.c;
import com.tencent.mm.plugin.exdevice.service.o.a;
import com.tencent.mm.sdk.platformtools.y;
import junit.framework.Assert;

public final class n
  extends o.a
{
  private c jzM = null;
  
  public n(c paramc)
  {
    Assert.assertNotNull(paramc);
    this.jzM = paramc;
  }
  
  public final long aMe()
  {
    y.i("MicroMsg.exdevice.RemoteExDeviceTaskRequest", "getDeviceId : " + this.jzM.hXu);
    return this.jzM.hXu;
  }
  
  public final byte[] aMf()
  {
    return this.jzM.aLj();
  }
  
  public final int aMg()
  {
    return this.jzM.aLh();
  }
  
  public final int aMh()
  {
    return this.jzM.jsV;
  }
  
  public final int aMi()
  {
    return this.jzM.aLi();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.i.n
 * JD-Core Version:    0.7.0.1
 */