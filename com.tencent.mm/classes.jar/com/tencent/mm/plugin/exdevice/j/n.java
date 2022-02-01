package com.tencent.mm.plugin.exdevice.j;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.exdevice.c.c;
import com.tencent.mm.plugin.exdevice.service.o.a;
import com.tencent.mm.sdk.platformtools.Log;
import junit.framework.Assert;

public final class n
  extends o.a
{
  private c rEy;
  
  public n(c paramc)
  {
    AppMethodBeat.i(23822);
    this.rEy = null;
    Assert.assertNotNull(paramc);
    this.rEy = paramc;
    AppMethodBeat.o(23822);
  }
  
  public final long cLk()
  {
    AppMethodBeat.i(23823);
    Log.i("MicroMsg.exdevice.RemoteExDeviceTaskRequest", "getDeviceId : " + this.rEy.pkb);
    long l = this.rEy.pkb;
    AppMethodBeat.o(23823);
    return l;
  }
  
  public final byte[] cLl()
  {
    AppMethodBeat.i(23824);
    byte[] arrayOfByte = this.rEy.cKi();
    AppMethodBeat.o(23824);
    return arrayOfByte;
  }
  
  public final int cLm()
  {
    AppMethodBeat.i(23825);
    int i = this.rEy.cKg();
    AppMethodBeat.o(23825);
    return i;
  }
  
  public final int cLn()
  {
    return this.rEy.rxx;
  }
  
  public final int cLo()
  {
    AppMethodBeat.i(23826);
    int i = this.rEy.cKh();
    AppMethodBeat.o(23826);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.j.n
 * JD-Core Version:    0.7.0.1
 */