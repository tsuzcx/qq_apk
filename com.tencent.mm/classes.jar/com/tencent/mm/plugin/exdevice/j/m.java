package com.tencent.mm.plugin.exdevice.j;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.exdevice.service.o;
import com.tencent.mm.plugin.exdevice.service.p.a;
import junit.framework.Assert;

public final class m
  extends p.a
{
  private n ywB;
  l ywC;
  
  public m(com.tencent.mm.plugin.exdevice.c.c paramc, c paramc1)
  {
    AppMethodBeat.i(23819);
    this.ywB = null;
    this.ywC = null;
    Assert.assertNotNull(paramc);
    Assert.assertNotNull(paramc1);
    this.ywB = new n(paramc);
    this.ywC = new l(paramc1);
    AppMethodBeat.o(23819);
  }
  
  public final o dGw()
  {
    AppMethodBeat.i(23820);
    Assert.assertNotNull(this.ywB);
    n localn = this.ywB;
    AppMethodBeat.o(23820);
    return localn;
  }
  
  public final com.tencent.mm.plugin.exdevice.service.l dGx()
  {
    AppMethodBeat.i(23821);
    Assert.assertNotNull(this.ywC);
    l locall = this.ywC;
    AppMethodBeat.o(23821);
    return locall;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.j.m
 * JD-Core Version:    0.7.0.1
 */