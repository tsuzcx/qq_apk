package com.tencent.mm.plugin.exdevice.j;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.exdevice.service.o;
import com.tencent.mm.plugin.exdevice.service.p.a;
import junit.framework.Assert;

public final class m
  extends p.a
{
  private n pDC;
  l pDD;
  
  public m(com.tencent.mm.plugin.exdevice.c.c paramc, c paramc1)
  {
    AppMethodBeat.i(23819);
    this.pDC = null;
    this.pDD = null;
    Assert.assertNotNull(paramc);
    Assert.assertNotNull(paramc1);
    this.pDC = new n(paramc);
    this.pDD = new l(paramc1);
    AppMethodBeat.o(23819);
  }
  
  public final o chn()
  {
    AppMethodBeat.i(23820);
    Assert.assertNotNull(this.pDC);
    n localn = this.pDC;
    AppMethodBeat.o(23820);
    return localn;
  }
  
  public final com.tencent.mm.plugin.exdevice.service.l cho()
  {
    AppMethodBeat.i(23821);
    Assert.assertNotNull(this.pDD);
    l locall = this.pDD;
    AppMethodBeat.o(23821);
    return locall;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.j.m
 * JD-Core Version:    0.7.0.1
 */