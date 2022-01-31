package com.tencent.mm.plugin.ipcall.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.it;
import com.tencent.mm.g.a.it.a;
import com.tencent.mm.protocal.protobuf.boh;
import com.tencent.mm.protocal.protobuf.boq;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.Iterator;
import java.util.LinkedList;

public final class h
  extends c<it>
{
  public h.a nMx;
  
  public h()
  {
    AppMethodBeat.i(21760);
    this.__eventId = it.class.getName().hashCode();
    AppMethodBeat.o(21760);
  }
  
  private boolean a(it paramit)
  {
    AppMethodBeat.i(21761);
    if ((paramit instanceof it))
    {
      paramit = paramit.cyj.cyk;
      if ((paramit == null) || (paramit.length <= 0))
      {
        AppMethodBeat.o(21761);
        return false;
      }
      if (paramit[0] == 101)
      {
        Object localObject = new byte[paramit.length - 1];
        System.arraycopy(paramit, 1, localObject, 0, localObject.length);
        try
        {
          paramit = (boh)new boh().parseFrom((byte[])localObject);
          ab.d("MicroMsg.IPCallSvrNotifyListener", "roomId: %d, roomKey: %d, DtmfPayloadType: %d", new Object[] { Integer.valueOf(paramit.wQP), Long.valueOf(paramit.wQQ), Integer.valueOf(paramit.nNu) });
          localObject = paramit.xCB;
          if (localObject != null)
          {
            localObject = ((LinkedList)localObject).iterator();
            while (((Iterator)localObject).hasNext())
            {
              boq localboq = (boq)((Iterator)localObject).next();
              ab.d("MicroMsg.IPCallSvrNotifyListener", "userstatus: %d, userstatusKey: %d, memberId: %d", new Object[] { Integer.valueOf(localboq.xCL), Integer.valueOf(localboq.xCM), Integer.valueOf(localboq.xCK) });
              continue;
              AppMethodBeat.o(21761);
            }
          }
        }
        catch (Exception paramit)
        {
          ab.e("MicroMsg.IPCallSvrNotifyListener", "parse PstnNotify error: %s", new Object[] { paramit.getMessage() });
        }
      }
    }
    for (;;)
    {
      return false;
      if (this.nMx != null) {
        this.nMx.a(paramit);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.a.h
 * JD-Core Version:    0.7.0.1
 */