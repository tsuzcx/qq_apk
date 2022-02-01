package com.tencent.mm.plugin.ipcall.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.a.lo;
import com.tencent.mm.f.a.lo.a;
import com.tencent.mm.protocal.protobuf.dph;
import com.tencent.mm.protocal.protobuf.dpq;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Iterator;
import java.util.LinkedList;

public final class h
  extends IListener<lo>
{
  public a DPd;
  
  public h()
  {
    AppMethodBeat.i(161381);
    this.__eventId = lo.class.getName().hashCode();
    AppMethodBeat.o(161381);
  }
  
  private boolean a(lo paramlo)
  {
    AppMethodBeat.i(25380);
    if ((paramlo instanceof lo))
    {
      paramlo = paramlo.fJq.fJr;
      if ((paramlo == null) || (paramlo.length <= 0))
      {
        AppMethodBeat.o(25380);
        return false;
      }
      if (paramlo[0] == 101)
      {
        Object localObject = new byte[paramlo.length - 1];
        System.arraycopy(paramlo, 1, localObject, 0, localObject.length);
        try
        {
          paramlo = (dph)new dph().parseFrom((byte[])localObject);
          Log.d("MicroMsg.IPCallSvrNotifyListener", "roomId: %d, roomKey: %d, DtmfPayloadType: %d", new Object[] { Integer.valueOf(paramlo.Svu), Long.valueOf(paramlo.Svv), Integer.valueOf(paramlo.DQd) });
          localObject = paramlo.TWr;
          if (localObject != null)
          {
            localObject = ((LinkedList)localObject).iterator();
            while (((Iterator)localObject).hasNext())
            {
              dpq localdpq = (dpq)((Iterator)localObject).next();
              Log.d("MicroMsg.IPCallSvrNotifyListener", "userstatus: %d, userstatusKey: %d, memberId: %d", new Object[] { Integer.valueOf(localdpq.TWB), Integer.valueOf(localdpq.TWC), Integer.valueOf(localdpq.TWA) });
              continue;
              AppMethodBeat.o(25380);
            }
          }
        }
        catch (Exception paramlo)
        {
          Log.e("MicroMsg.IPCallSvrNotifyListener", "parse PstnNotify error: %s", new Object[] { paramlo.getMessage() });
        }
      }
    }
    for (;;)
    {
      return false;
      if (this.DPd != null) {
        this.DPd.a(paramlo);
      }
    }
  }
  
  public static abstract interface a
  {
    public abstract void a(dph paramdph);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.model.h
 * JD-Core Version:    0.7.0.1
 */