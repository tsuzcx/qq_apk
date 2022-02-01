package com.tencent.mm.plugin.exdevice.j;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.exdevice.service.o;
import com.tencent.mm.plugin.exdevice.service.p.a;
import junit.framework.Assert;

public final class m
  extends p.a
{
  private n vkD;
  l vkE;
  
  public m(com.tencent.mm.plugin.exdevice.c.c paramc, c paramc1)
  {
    AppMethodBeat.i(23819);
    this.vkD = null;
    this.vkE = null;
    Assert.assertNotNull(paramc);
    Assert.assertNotNull(paramc1);
    this.vkD = new n(paramc);
    this.vkE = new l(paramc1);
    AppMethodBeat.o(23819);
  }
  
  public final o dad()
  {
    AppMethodBeat.i(23820);
    Assert.assertNotNull(this.vkD);
    n localn = this.vkD;
    AppMethodBeat.o(23820);
    return localn;
  }
  
  public final com.tencent.mm.plugin.exdevice.service.l dae()
  {
    AppMethodBeat.i(23821);
    Assert.assertNotNull(this.vkE);
    l locall = this.vkE;
    AppMethodBeat.o(23821);
    return locall;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.j.m
 * JD-Core Version:    0.7.0.1
 */