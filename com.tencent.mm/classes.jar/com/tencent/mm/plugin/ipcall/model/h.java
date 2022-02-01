package com.tencent.mm.plugin.ipcall.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.jz;
import com.tencent.mm.g.a.jz.a;
import com.tencent.mm.protocal.protobuf.chz;
import com.tencent.mm.protocal.protobuf.cii;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ac;
import java.util.Iterator;
import java.util.LinkedList;

public final class h
  extends c<jz>
{
  public a tIa;
  
  public h()
  {
    AppMethodBeat.i(161381);
    this.__eventId = jz.class.getName().hashCode();
    AppMethodBeat.o(161381);
  }
  
  private boolean a(jz paramjz)
  {
    AppMethodBeat.i(25380);
    if ((paramjz instanceof jz))
    {
      paramjz = paramjz.dlA.dlB;
      if ((paramjz == null) || (paramjz.length <= 0))
      {
        AppMethodBeat.o(25380);
        return false;
      }
      if (paramjz[0] == 101)
      {
        Object localObject = new byte[paramjz.length - 1];
        System.arraycopy(paramjz, 1, localObject, 0, localObject.length);
        try
        {
          paramjz = (chz)new chz().parseFrom((byte[])localObject);
          ac.d("MicroMsg.IPCallSvrNotifyListener", "roomId: %d, roomKey: %d, DtmfPayloadType: %d", new Object[] { Integer.valueOf(paramjz.Exf), Long.valueOf(paramjz.Exg), Integer.valueOf(paramjz.tJa) });
          localObject = paramjz.Fwi;
          if (localObject != null)
          {
            localObject = ((LinkedList)localObject).iterator();
            while (((Iterator)localObject).hasNext())
            {
              cii localcii = (cii)((Iterator)localObject).next();
              ac.d("MicroMsg.IPCallSvrNotifyListener", "userstatus: %d, userstatusKey: %d, memberId: %d", new Object[] { Integer.valueOf(localcii.Fws), Integer.valueOf(localcii.Fwt), Integer.valueOf(localcii.Fwr) });
              continue;
              AppMethodBeat.o(25380);
            }
          }
        }
        catch (Exception paramjz)
        {
          ac.e("MicroMsg.IPCallSvrNotifyListener", "parse PstnNotify error: %s", new Object[] { paramjz.getMessage() });
        }
      }
    }
    for (;;)
    {
      return false;
      if (this.tIa != null) {
        this.tIa.a(paramjz);
      }
    }
  }
  
  public static abstract interface a
  {
    public abstract void a(chz paramchz);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.model.h
 * JD-Core Version:    0.7.0.1
 */