package com.tencent.mm.plugin.exdevice.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.exdevice.i.d;
import com.tencent.mm.plugin.exdevice.service.m;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.Vector;

public final class c
  implements d
{
  private static c lCP;
  private byte[] dZg;
  private al fPW;
  private final Map<Integer, Set<d>> ftE;
  public m lCQ;
  c.a lCR;
  Vector<ae> lCS;
  
  public c()
  {
    AppMethodBeat.i(19092);
    this.ftE = new HashMap();
    this.dZg = new byte[0];
    this.lCS = new Vector();
    this.fPW = new al("ExdeviceHandlerThread");
    AppMethodBeat.o(19092);
  }
  
  public static c bpE()
  {
    AppMethodBeat.i(19094);
    if (lCP == null) {
      lCP = new c();
    }
    c localc = lCP;
    AppMethodBeat.o(19094);
    return localc;
  }
  
  public final void a(long paramLong, int paramInt1, int paramInt2, String arg5)
  {
    AppMethodBeat.i(19096);
    ab.i("MicroMsg.exdevice.ExDeviceTaskService", "onTaskSceneEnd, taskid =%d, errType =%d, errCode = %d, errMsg =%s, wattingtask size : %d", new Object[] { Long.valueOf(paramLong), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), ???, Integer.valueOf(this.lCS.size()) });
    synchronized (this.dZg)
    {
      bpF();
      AppMethodBeat.o(19096);
      return;
    }
  }
  
  public final boolean a(ae paramae)
  {
    AppMethodBeat.i(19093);
    this.fPW.ac(new c.2(this, paramae));
    AppMethodBeat.o(19093);
    return true;
  }
  
  final void bpF()
  {
    AppMethodBeat.i(19095);
    ab.i("MicroMsg.exdevice.ExDeviceTaskService", "now watting task size is %d", new Object[] { Integer.valueOf(this.lCS.size()) });
    if (!this.lCS.isEmpty()) {
      a((ae)this.lCS.remove(0));
    }
    AppMethodBeat.o(19095);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.model.c
 * JD-Core Version:    0.7.0.1
 */