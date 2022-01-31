package com.tencent.mm.plugin.exdevice.i;

import com.tencent.mm.plugin.exdevice.service.o;
import com.tencent.mm.plugin.exdevice.service.p.a;
import junit.framework.Assert;

public final class m
  extends p.a
{
  private n jAi = null;
  l jAj = null;
  
  public m(com.tencent.mm.plugin.exdevice.b.c paramc, c paramc1)
  {
    Assert.assertNotNull(paramc);
    Assert.assertNotNull(paramc1);
    this.jAi = new n(paramc);
    this.jAj = new l(paramc1);
  }
  
  public final o aMj()
  {
    Assert.assertNotNull(this.jAi);
    return this.jAi;
  }
  
  public final com.tencent.mm.plugin.exdevice.service.l aMk()
  {
    Assert.assertNotNull(this.jAj);
    return this.jAj;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.i.m
 * JD-Core Version:    0.7.0.1
 */