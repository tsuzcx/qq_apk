package com.tencent.mm.plugin.ipcall.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.ki;
import com.tencent.mm.g.a.ki.a;
import com.tencent.mm.protocal.protobuf.cnt;
import com.tencent.mm.protocal.protobuf.coc;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ae;
import java.util.Iterator;
import java.util.LinkedList;

public final class h
  extends c<ki>
{
  public a uWA;
  
  public h()
  {
    AppMethodBeat.i(161381);
    this.__eventId = ki.class.getName().hashCode();
    AppMethodBeat.o(161381);
  }
  
  private boolean a(ki paramki)
  {
    AppMethodBeat.i(25380);
    if ((paramki instanceof ki))
    {
      paramki = paramki.dys.dyt;
      if ((paramki == null) || (paramki.length <= 0))
      {
        AppMethodBeat.o(25380);
        return false;
      }
      if (paramki[0] == 101)
      {
        Object localObject = new byte[paramki.length - 1];
        System.arraycopy(paramki, 1, localObject, 0, localObject.length);
        try
        {
          paramki = (cnt)new cnt().parseFrom((byte[])localObject);
          ae.d("MicroMsg.IPCallSvrNotifyListener", "roomId: %d, roomKey: %d, DtmfPayloadType: %d", new Object[] { Integer.valueOf(paramki.Gxq), Long.valueOf(paramki.Gxr), Integer.valueOf(paramki.uXA) });
          localObject = paramki.HzO;
          if (localObject != null)
          {
            localObject = ((LinkedList)localObject).iterator();
            while (((Iterator)localObject).hasNext())
            {
              coc localcoc = (coc)((Iterator)localObject).next();
              ae.d("MicroMsg.IPCallSvrNotifyListener", "userstatus: %d, userstatusKey: %d, memberId: %d", new Object[] { Integer.valueOf(localcoc.HzY), Integer.valueOf(localcoc.HzZ), Integer.valueOf(localcoc.HzX) });
              continue;
              AppMethodBeat.o(25380);
            }
          }
        }
        catch (Exception paramki)
        {
          ae.e("MicroMsg.IPCallSvrNotifyListener", "parse PstnNotify error: %s", new Object[] { paramki.getMessage() });
        }
      }
    }
    for (;;)
    {
      return false;
      if (this.uWA != null) {
        this.uWA.a(paramki);
      }
    }
  }
  
  public static abstract interface a
  {
    public abstract void a(cnt paramcnt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.model.h
 * JD-Core Version:    0.7.0.1
 */