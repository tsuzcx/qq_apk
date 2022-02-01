package com.tencent.mm.plugin.exdevice.j;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.exdevice.service.o;
import com.tencent.mm.plugin.exdevice.service.p.a;
import junit.framework.Assert;

public final class m
  extends p.a
{
  private n qnM;
  l qnN;
  
  public m(com.tencent.mm.plugin.exdevice.c.c paramc, c paramc1)
  {
    AppMethodBeat.i(23819);
    this.qnM = null;
    this.qnN = null;
    Assert.assertNotNull(paramc);
    Assert.assertNotNull(paramc1);
    this.qnM = new n(paramc);
    this.qnN = new l(paramc1);
    AppMethodBeat.o(23819);
  }
  
  public final o cnh()
  {
    AppMethodBeat.i(23820);
    Assert.assertNotNull(this.qnM);
    n localn = this.qnM;
    AppMethodBeat.o(23820);
    return localn;
  }
  
  public final com.tencent.mm.plugin.exdevice.service.l cni()
  {
    AppMethodBeat.i(23821);
    Assert.assertNotNull(this.qnN);
    l locall = this.qnN;
    AppMethodBeat.o(23821);
    return locall;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.j.m
 * JD-Core Version:    0.7.0.1
 */