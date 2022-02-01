package com.tencent.mm.plugin.ipcall.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.kx;
import com.tencent.mm.g.a.kx.a;
import com.tencent.mm.protocal.protobuf.dfn;
import com.tencent.mm.protocal.protobuf.dfw;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Iterator;
import java.util.LinkedList;

public final class h
  extends IListener<kx>
{
  public a ypb;
  
  public h()
  {
    AppMethodBeat.i(161381);
    this.__eventId = kx.class.getName().hashCode();
    AppMethodBeat.o(161381);
  }
  
  private boolean a(kx paramkx)
  {
    AppMethodBeat.i(25380);
    if ((paramkx instanceof kx))
    {
      paramkx = paramkx.dPZ.dQa;
      if ((paramkx == null) || (paramkx.length <= 0))
      {
        AppMethodBeat.o(25380);
        return false;
      }
      if (paramkx[0] == 101)
      {
        Object localObject = new byte[paramkx.length - 1];
        System.arraycopy(paramkx, 1, localObject, 0, localObject.length);
        try
        {
          paramkx = (dfn)new dfn().parseFrom((byte[])localObject);
          Log.d("MicroMsg.IPCallSvrNotifyListener", "roomId: %d, roomKey: %d, DtmfPayloadType: %d", new Object[] { Integer.valueOf(paramkx.LsZ), Long.valueOf(paramkx.Lta), Integer.valueOf(paramkx.yqb) });
          localObject = paramkx.MKx;
          if (localObject != null)
          {
            localObject = ((LinkedList)localObject).iterator();
            while (((Iterator)localObject).hasNext())
            {
              dfw localdfw = (dfw)((Iterator)localObject).next();
              Log.d("MicroMsg.IPCallSvrNotifyListener", "userstatus: %d, userstatusKey: %d, memberId: %d", new Object[] { Integer.valueOf(localdfw.MKH), Integer.valueOf(localdfw.MKI), Integer.valueOf(localdfw.MKG) });
              continue;
              AppMethodBeat.o(25380);
            }
          }
        }
        catch (Exception paramkx)
        {
          Log.e("MicroMsg.IPCallSvrNotifyListener", "parse PstnNotify error: %s", new Object[] { paramkx.getMessage() });
        }
      }
    }
    for (;;)
    {
      return false;
      if (this.ypb != null) {
        this.ypb.a(paramkx);
      }
    }
  }
  
  public static abstract interface a
  {
    public abstract void a(dfn paramdfn);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.model.h
 * JD-Core Version:    0.7.0.1
 */