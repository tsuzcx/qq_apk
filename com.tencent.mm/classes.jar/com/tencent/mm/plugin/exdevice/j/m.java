package com.tencent.mm.plugin.exdevice.j;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.exdevice.service.o;
import com.tencent.mm.plugin.exdevice.service.p.a;
import junit.framework.Assert;

public final class m
  extends p.a
{
  private n rET;
  l rEU;
  
  public m(com.tencent.mm.plugin.exdevice.c.c paramc, c paramc1)
  {
    AppMethodBeat.i(23819);
    this.rET = null;
    this.rEU = null;
    Assert.assertNotNull(paramc);
    Assert.assertNotNull(paramc1);
    this.rET = new n(paramc);
    this.rEU = new l(paramc1);
    AppMethodBeat.o(23819);
  }
  
  public final o cLq()
  {
    AppMethodBeat.i(23820);
    Assert.assertNotNull(this.rET);
    n localn = this.rET;
    AppMethodBeat.o(23820);
    return localn;
  }
  
  public final com.tencent.mm.plugin.exdevice.service.l cLr()
  {
    AppMethodBeat.i(23821);
    Assert.assertNotNull(this.rEU);
    l locall = this.rEU;
    AppMethodBeat.o(23821);
    return locall;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.j.m
 * JD-Core Version:    0.7.0.1
 */