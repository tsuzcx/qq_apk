package com.tencent.mm.plugin.exdevice.j;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.exdevice.c.c;
import com.tencent.mm.plugin.exdevice.service.o.a;
import com.tencent.mm.sdk.platformtools.Log;
import junit.framework.Assert;

public final class n
  extends o.a
{
  private c vki;
  
  public n(c paramc)
  {
    AppMethodBeat.i(23822);
    this.vki = null;
    Assert.assertNotNull(paramc);
    this.vki = paramc;
    AppMethodBeat.o(23822);
  }
  
  public final long cZX()
  {
    AppMethodBeat.i(23823);
    Log.i("MicroMsg.exdevice.RemoteExDeviceTaskRequest", "getDeviceId : " + this.vki.smk);
    long l = this.vki.smk;
    AppMethodBeat.o(23823);
    return l;
  }
  
  public final byte[] cZY()
  {
    AppMethodBeat.i(23824);
    byte[] arrayOfByte = this.vki.cYS();
    AppMethodBeat.o(23824);
    return arrayOfByte;
  }
  
  public final int cZZ()
  {
    AppMethodBeat.i(23825);
    int i = this.vki.cYQ();
    AppMethodBeat.o(23825);
    return i;
  }
  
  public final int daa()
  {
    return this.vki.vdd;
  }
  
  public final int dab()
  {
    AppMethodBeat.i(23826);
    int i = this.vki.cYR();
    AppMethodBeat.o(23826);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.j.n
 * JD-Core Version:    0.7.0.1
 */