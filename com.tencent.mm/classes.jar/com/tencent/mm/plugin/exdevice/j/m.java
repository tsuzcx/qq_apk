package com.tencent.mm.plugin.exdevice.j;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.exdevice.service.o;
import com.tencent.mm.plugin.exdevice.service.p.a;
import junit.framework.Assert;

public final class m
  extends p.a
{
  private n par;
  l pas;
  
  public m(com.tencent.mm.plugin.exdevice.c.c paramc, c paramc1)
  {
    AppMethodBeat.i(23819);
    this.par = null;
    this.pas = null;
    Assert.assertNotNull(paramc);
    Assert.assertNotNull(paramc1);
    this.par = new n(paramc);
    this.pas = new l(paramc1);
    AppMethodBeat.o(23819);
  }
  
  public final o cae()
  {
    AppMethodBeat.i(23820);
    Assert.assertNotNull(this.par);
    n localn = this.par;
    AppMethodBeat.o(23820);
    return localn;
  }
  
  public final com.tencent.mm.plugin.exdevice.service.l caf()
  {
    AppMethodBeat.i(23821);
    Assert.assertNotNull(this.pas);
    l locall = this.pas;
    AppMethodBeat.o(23821);
    return locall;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.j.m
 * JD-Core Version:    0.7.0.1
 */