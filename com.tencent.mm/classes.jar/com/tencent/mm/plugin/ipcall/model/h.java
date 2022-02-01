package com.tencent.mm.plugin.ipcall.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.kh;
import com.tencent.mm.g.a.kh.a;
import com.tencent.mm.protocal.protobuf.cmz;
import com.tencent.mm.protocal.protobuf.cni;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ad;
import java.util.Iterator;
import java.util.LinkedList;

public final class h
  extends c<kh>
{
  public a uKN;
  
  public h()
  {
    AppMethodBeat.i(161381);
    this.__eventId = kh.class.getName().hashCode();
    AppMethodBeat.o(161381);
  }
  
  private boolean a(kh paramkh)
  {
    AppMethodBeat.i(25380);
    if ((paramkh instanceof kh))
    {
      paramkh = paramkh.dxn.dxo;
      if ((paramkh == null) || (paramkh.length <= 0))
      {
        AppMethodBeat.o(25380);
        return false;
      }
      if (paramkh[0] == 101)
      {
        Object localObject = new byte[paramkh.length - 1];
        System.arraycopy(paramkh, 1, localObject, 0, localObject.length);
        try
        {
          paramkh = (cmz)new cmz().parseFrom((byte[])localObject);
          ad.d("MicroMsg.IPCallSvrNotifyListener", "roomId: %d, roomKey: %d, DtmfPayloadType: %d", new Object[] { Integer.valueOf(paramkh.GeI), Long.valueOf(paramkh.GeJ), Integer.valueOf(paramkh.uLN) });
          localObject = paramkh.Hgo;
          if (localObject != null)
          {
            localObject = ((LinkedList)localObject).iterator();
            while (((Iterator)localObject).hasNext())
            {
              cni localcni = (cni)((Iterator)localObject).next();
              ad.d("MicroMsg.IPCallSvrNotifyListener", "userstatus: %d, userstatusKey: %d, memberId: %d", new Object[] { Integer.valueOf(localcni.Hgy), Integer.valueOf(localcni.Hgz), Integer.valueOf(localcni.Hgx) });
              continue;
              AppMethodBeat.o(25380);
            }
          }
        }
        catch (Exception paramkh)
        {
          ad.e("MicroMsg.IPCallSvrNotifyListener", "parse PstnNotify error: %s", new Object[] { paramkh.getMessage() });
        }
      }
    }
    for (;;)
    {
      return false;
      if (this.uKN != null) {
        this.uKN.a(paramkh);
      }
    }
  }
  
  public static abstract interface a
  {
    public abstract void a(cmz paramcmz);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.model.h
 * JD-Core Version:    0.7.0.1
 */