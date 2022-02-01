package com.tencent.mm.plugin.exdevice.j;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.exdevice.c.c;
import com.tencent.mm.plugin.exdevice.service.o.a;
import com.tencent.mm.sdk.platformtools.ad;
import junit.framework.Assert;

public final class n
  extends o.a
{
  private c qgM;
  
  public n(c paramc)
  {
    AppMethodBeat.i(23822);
    this.qgM = null;
    Assert.assertNotNull(paramc);
    this.qgM = paramc;
    AppMethodBeat.o(23822);
  }
  
  public final long clM()
  {
    AppMethodBeat.i(23823);
    ad.i("MicroMsg.exdevice.RemoteExDeviceTaskRequest", "getDeviceId : " + this.qgM.nTx);
    long l = this.qgM.nTx;
    AppMethodBeat.o(23823);
    return l;
  }
  
  public final byte[] clN()
  {
    AppMethodBeat.i(23824);
    byte[] arrayOfByte = this.qgM.ckQ();
    AppMethodBeat.o(23824);
    return arrayOfByte;
  }
  
  public final int clO()
  {
    AppMethodBeat.i(23825);
    int i = this.qgM.ckO();
    AppMethodBeat.o(23825);
    return i;
  }
  
  public final int clP()
  {
    return this.qgM.pZW;
  }
  
  public final int clQ()
  {
    AppMethodBeat.i(23826);
    int i = this.qgM.ckP();
    AppMethodBeat.o(23826);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.j.n
 * JD-Core Version:    0.7.0.1
 */