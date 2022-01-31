package com.tencent.mm.plugin.exdevice.model;

import com.tencent.mm.plugin.exdevice.i.d;
import com.tencent.mm.plugin.exdevice.service.m;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.y;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.Vector;

public final class c
  implements d
{
  public static c jtq;
  private byte[] dhN = new byte[0];
  private ai eAg = new ai("ExdeviceHandlerThread");
  private final Map<Integer, Set<d>> edB = new HashMap();
  public m jtr;
  c.a jts;
  Vector<ae> jtt = new Vector();
  
  public final void a(long paramLong, int paramInt1, int paramInt2, String arg5)
  {
    y.i("MicroMsg.exdevice.ExDeviceTaskService", "onTaskSceneEnd, taskid =%d, errType =%d, errCode = %d, errMsg =%s, wattingtask size : %d", new Object[] { Long.valueOf(paramLong), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), ???, Integer.valueOf(this.jtt.size()) });
    synchronized (this.dhN)
    {
      aLr();
      return;
    }
  }
  
  public final boolean a(ae paramae)
  {
    this.eAg.O(new c.2(this, paramae));
    return true;
  }
  
  final void aLr()
  {
    y.i("MicroMsg.exdevice.ExDeviceTaskService", "now watting task size is %d", new Object[] { Integer.valueOf(this.jtt.size()) });
    if (!this.jtt.isEmpty()) {
      a((ae)this.jtt.remove(0));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.model.c
 * JD-Core Version:    0.7.0.1
 */