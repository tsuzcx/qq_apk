package com.tencent.mm.plugin.exdevice.j;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.exdevice.c.c;
import com.tencent.mm.plugin.exdevice.service.o.a;
import com.tencent.mm.sdk.platformtools.Log;
import junit.framework.Assert;

public final class n
  extends o.a
{
  private c ywg;
  
  public n(c paramc)
  {
    AppMethodBeat.i(23822);
    this.ywg = null;
    Assert.assertNotNull(paramc);
    this.ywg = paramc;
    AppMethodBeat.o(23822);
  }
  
  public final long dGq()
  {
    AppMethodBeat.i(23823);
    Log.i("MicroMsg.exdevice.RemoteExDeviceTaskRequest", "getDeviceId : " + this.ywg.vyj);
    long l = this.ywg.vyj;
    AppMethodBeat.o(23823);
    return l;
  }
  
  public final byte[] dGr()
  {
    AppMethodBeat.i(23824);
    byte[] arrayOfByte = this.ywg.dFj();
    AppMethodBeat.o(23824);
    return arrayOfByte;
  }
  
  public final int dGs()
  {
    AppMethodBeat.i(23825);
    int i = this.ywg.dFh();
    AppMethodBeat.o(23825);
    return i;
  }
  
  public final int dGt()
  {
    return this.ywg.yoQ;
  }
  
  public final int dGu()
  {
    AppMethodBeat.i(23826);
    int i = this.ywg.dFi();
    AppMethodBeat.o(23826);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.j.n
 * JD-Core Version:    0.7.0.1
 */