package com.tencent.mm.plugin.exdevice.j;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.exdevice.c.c;
import com.tencent.mm.plugin.exdevice.service.o.a;
import com.tencent.mm.sdk.platformtools.ad;
import junit.framework.Assert;

public final class n
  extends o.a
{
  private c oZW;
  
  public n(c paramc)
  {
    AppMethodBeat.i(23822);
    this.oZW = null;
    Assert.assertNotNull(paramc);
    this.oZW = paramc;
    AppMethodBeat.o(23822);
  }
  
  public final long bZZ()
  {
    AppMethodBeat.i(23823);
    ad.i("MicroMsg.exdevice.RemoteExDeviceTaskRequest", "getDeviceId : " + this.oZW.mQq);
    long l = this.oZW.mQq;
    AppMethodBeat.o(23823);
    return l;
  }
  
  public final byte[] caa()
  {
    AppMethodBeat.i(23824);
    byte[] arrayOfByte = this.oZW.bZd();
    AppMethodBeat.o(23824);
    return arrayOfByte;
  }
  
  public final int cab()
  {
    AppMethodBeat.i(23825);
    int i = this.oZW.bZb();
    AppMethodBeat.o(23825);
    return i;
  }
  
  public final int cac()
  {
    return this.oZW.oTg;
  }
  
  public final int cad()
  {
    AppMethodBeat.i(23826);
    int i = this.oZW.bZc();
    AppMethodBeat.o(23826);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.j.n
 * JD-Core Version:    0.7.0.1
 */