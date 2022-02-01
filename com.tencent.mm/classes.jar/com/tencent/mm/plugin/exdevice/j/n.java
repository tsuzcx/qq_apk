package com.tencent.mm.plugin.exdevice.j;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.exdevice.c.c;
import com.tencent.mm.plugin.exdevice.service.o.a;
import com.tencent.mm.sdk.platformtools.ac;
import junit.framework.Assert;

public final class n
  extends o.a
{
  private c pDh;
  
  public n(c paramc)
  {
    AppMethodBeat.i(23822);
    this.pDh = null;
    Assert.assertNotNull(paramc);
    this.pDh = paramc;
    AppMethodBeat.o(23822);
  }
  
  public final long chi()
  {
    AppMethodBeat.i(23823);
    ac.i("MicroMsg.exdevice.RemoteExDeviceTaskRequest", "getDeviceId : " + this.pDh.nsB);
    long l = this.pDh.nsB;
    AppMethodBeat.o(23823);
    return l;
  }
  
  public final byte[] chj()
  {
    AppMethodBeat.i(23824);
    byte[] arrayOfByte = this.pDh.cgm();
    AppMethodBeat.o(23824);
    return arrayOfByte;
  }
  
  public final int chk()
  {
    AppMethodBeat.i(23825);
    int i = this.pDh.cgk();
    AppMethodBeat.o(23825);
    return i;
  }
  
  public final int chl()
  {
    return this.pDh.pwr;
  }
  
  public final int chm()
  {
    AppMethodBeat.i(23826);
    int i = this.pDh.cgl();
    AppMethodBeat.o(23826);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.j.n
 * JD-Core Version:    0.7.0.1
 */