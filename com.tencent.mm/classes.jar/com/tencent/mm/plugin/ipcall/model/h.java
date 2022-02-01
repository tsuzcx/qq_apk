package com.tencent.mm.plugin.ipcall.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.jr;
import com.tencent.mm.g.a.jr.a;
import com.tencent.mm.protocal.protobuf.ccw;
import com.tencent.mm.protocal.protobuf.cdf;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ad;
import java.util.Iterator;
import java.util.LinkedList;

public final class h
  extends c<jr>
{
  public a sAq;
  
  public h()
  {
    AppMethodBeat.i(161381);
    this.__eventId = jr.class.getName().hashCode();
    AppMethodBeat.o(161381);
  }
  
  private boolean a(jr paramjr)
  {
    AppMethodBeat.i(25380);
    if ((paramjr instanceof jr))
    {
      paramjr = paramjr.dnR.dnS;
      if ((paramjr == null) || (paramjr.length <= 0))
      {
        AppMethodBeat.o(25380);
        return false;
      }
      if (paramjr[0] == 101)
      {
        Object localObject = new byte[paramjr.length - 1];
        System.arraycopy(paramjr, 1, localObject, 0, localObject.length);
        try
        {
          paramjr = (ccw)new ccw().parseFrom((byte[])localObject);
          ad.d("MicroMsg.IPCallSvrNotifyListener", "roomId: %d, roomKey: %d, DtmfPayloadType: %d", new Object[] { Integer.valueOf(paramjr.DdZ), Long.valueOf(paramjr.Dea), Integer.valueOf(paramjr.sBs) });
          localObject = paramjr.DZm;
          if (localObject != null)
          {
            localObject = ((LinkedList)localObject).iterator();
            while (((Iterator)localObject).hasNext())
            {
              cdf localcdf = (cdf)((Iterator)localObject).next();
              ad.d("MicroMsg.IPCallSvrNotifyListener", "userstatus: %d, userstatusKey: %d, memberId: %d", new Object[] { Integer.valueOf(localcdf.DZw), Integer.valueOf(localcdf.DZx), Integer.valueOf(localcdf.DZv) });
              continue;
              AppMethodBeat.o(25380);
            }
          }
        }
        catch (Exception paramjr)
        {
          ad.e("MicroMsg.IPCallSvrNotifyListener", "parse PstnNotify error: %s", new Object[] { paramjr.getMessage() });
        }
      }
    }
    for (;;)
    {
      return false;
      if (this.sAq != null) {
        this.sAq.a(paramjr);
      }
    }
  }
  
  public static abstract interface a
  {
    public abstract void a(ccw paramccw);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.model.h
 * JD-Core Version:    0.7.0.1
 */