package com.tencent.mm.plugin.exdevice.j;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.exdevice.c.c;
import com.tencent.mm.plugin.exdevice.service.o.a;
import com.tencent.mm.sdk.platformtools.ae;
import junit.framework.Assert;

public final class n
  extends o.a
{
  private c qnr;
  
  public n(c paramc)
  {
    AppMethodBeat.i(23822);
    this.qnr = null;
    Assert.assertNotNull(paramc);
    this.qnr = paramc;
    AppMethodBeat.o(23822);
  }
  
  public final long cnc()
  {
    AppMethodBeat.i(23823);
    ae.i("MicroMsg.exdevice.RemoteExDeviceTaskRequest", "getDeviceId : " + this.qnr.nZd);
    long l = this.qnr.nZd;
    AppMethodBeat.o(23823);
    return l;
  }
  
  public final byte[] cnd()
  {
    AppMethodBeat.i(23824);
    byte[] arrayOfByte = this.qnr.cmg();
    AppMethodBeat.o(23824);
    return arrayOfByte;
  }
  
  public final int cne()
  {
    AppMethodBeat.i(23825);
    int i = this.qnr.cme();
    AppMethodBeat.o(23825);
    return i;
  }
  
  public final int cnf()
  {
    return this.qnr.qgB;
  }
  
  public final int cng()
  {
    AppMethodBeat.i(23826);
    int i = this.qnr.cmf();
    AppMethodBeat.o(23826);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.j.n
 * JD-Core Version:    0.7.0.1
 */