package com.tencent.mm.plugin.exdevice.i;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.exdevice.service.o;
import com.tencent.mm.plugin.exdevice.service.p.a;
import junit.framework.Assert;

public final class m
  extends p.a
{
  private n lJH;
  l lJI;
  
  public m(com.tencent.mm.plugin.exdevice.b.c paramc, c paramc1)
  {
    AppMethodBeat.i(19751);
    this.lJH = null;
    this.lJI = null;
    Assert.assertNotNull(paramc);
    Assert.assertNotNull(paramc1);
    this.lJH = new n(paramc);
    this.lJI = new l(paramc1);
    AppMethodBeat.o(19751);
  }
  
  public final o bqw()
  {
    AppMethodBeat.i(19752);
    Assert.assertNotNull(this.lJH);
    n localn = this.lJH;
    AppMethodBeat.o(19752);
    return localn;
  }
  
  public final com.tencent.mm.plugin.exdevice.service.l bqx()
  {
    AppMethodBeat.i(19753);
    Assert.assertNotNull(this.lJI);
    l locall = this.lJI;
    AppMethodBeat.o(19753);
    return locall;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.i.m
 * JD-Core Version:    0.7.0.1
 */