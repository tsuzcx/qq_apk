package com.tencent.mm.plugin.exdevice.j;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.exdevice.service.o;
import com.tencent.mm.plugin.exdevice.service.p.a;
import junit.framework.Assert;

public final class m
  extends p.a
{
  private n qhh;
  l qhi;
  
  public m(com.tencent.mm.plugin.exdevice.c.c paramc, c paramc1)
  {
    AppMethodBeat.i(23819);
    this.qhh = null;
    this.qhi = null;
    Assert.assertNotNull(paramc);
    Assert.assertNotNull(paramc1);
    this.qhh = new n(paramc);
    this.qhi = new l(paramc1);
    AppMethodBeat.o(23819);
  }
  
  public final o clR()
  {
    AppMethodBeat.i(23820);
    Assert.assertNotNull(this.qhh);
    n localn = this.qhh;
    AppMethodBeat.o(23820);
    return localn;
  }
  
  public final com.tencent.mm.plugin.exdevice.service.l clS()
  {
    AppMethodBeat.i(23821);
    Assert.assertNotNull(this.qhi);
    l locall = this.qhi;
    AppMethodBeat.o(23821);
    return locall;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.j.m
 * JD-Core Version:    0.7.0.1
 */