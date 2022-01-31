package com.tencent.mm.plugin.exdevice.i;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.exdevice.b.c;
import com.tencent.mm.plugin.exdevice.service.o.a;
import com.tencent.mm.sdk.platformtools.ab;
import junit.framework.Assert;

public final class n
  extends o.a
{
  private c lJl;
  
  public n(c paramc)
  {
    AppMethodBeat.i(19754);
    this.lJl = null;
    Assert.assertNotNull(paramc);
    this.lJl = paramc;
    AppMethodBeat.o(19754);
  }
  
  public final long bqr()
  {
    AppMethodBeat.i(19755);
    ab.i("MicroMsg.exdevice.RemoteExDeviceTaskRequest", "getDeviceId : " + this.lJl.jRn);
    long l = this.lJl.jRn;
    AppMethodBeat.o(19755);
    return l;
  }
  
  public final byte[] bqs()
  {
    AppMethodBeat.i(19756);
    byte[] arrayOfByte = this.lJl.bpw();
    AppMethodBeat.o(19756);
    return arrayOfByte;
  }
  
  public final int bqt()
  {
    AppMethodBeat.i(19757);
    int i = this.lJl.bpu();
    AppMethodBeat.o(19757);
    return i;
  }
  
  public final int bqu()
  {
    return this.lJl.lCu;
  }
  
  public final int bqv()
  {
    AppMethodBeat.i(19758);
    int i = this.lJl.bpv();
    AppMethodBeat.o(19758);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.i.n
 * JD-Core Version:    0.7.0.1
 */