package com.tencent.mm.plugin.ipcall.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.f;
import com.tencent.mm.autogen.a.mt;
import com.tencent.mm.autogen.a.mt.a;
import com.tencent.mm.protocal.protobuf.eib;
import com.tencent.mm.protocal.protobuf.eik;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Iterator;
import java.util.LinkedList;

public class IPCallSvrNotifyListener
  extends IListener<mt>
{
  public a JGs;
  
  public IPCallSvrNotifyListener()
  {
    super(f.hfK);
    AppMethodBeat.i(161381);
    this.__eventId = mt.class.getName().hashCode();
    AppMethodBeat.o(161381);
  }
  
  private boolean a(mt parammt)
  {
    AppMethodBeat.i(25380);
    if ((parammt instanceof mt))
    {
      parammt = parammt.hOT.hOU;
      if ((parammt == null) || (parammt.length <= 0))
      {
        AppMethodBeat.o(25380);
        return false;
      }
      if (parammt[0] == 101)
      {
        Object localObject = new byte[parammt.length - 1];
        System.arraycopy(parammt, 1, localObject, 0, localObject.length);
        try
        {
          parammt = (eib)new eib().parseFrom((byte[])localObject);
          Log.d("MicroMsg.IPCallSvrNotifyListener", "roomId: %d, roomKey: %d, DtmfPayloadType: %d", new Object[] { Integer.valueOf(parammt.Zvz), Long.valueOf(parammt.ZvA), Integer.valueOf(parammt.JHo) });
          localObject = parammt.abng;
          if (localObject != null)
          {
            localObject = ((LinkedList)localObject).iterator();
            while (((Iterator)localObject).hasNext())
            {
              eik localeik = (eik)((Iterator)localObject).next();
              Log.d("MicroMsg.IPCallSvrNotifyListener", "userstatus: %d, userstatusKey: %d, memberId: %d", new Object[] { Integer.valueOf(localeik.abnq), Integer.valueOf(localeik.abnr), Integer.valueOf(localeik.abnp) });
              continue;
              AppMethodBeat.o(25380);
            }
          }
        }
        catch (Exception parammt)
        {
          Log.e("MicroMsg.IPCallSvrNotifyListener", "parse PstnNotify error: %s", new Object[] { parammt.getMessage() });
        }
      }
    }
    for (;;)
    {
      return false;
      if (this.JGs != null) {
        this.JGs.a(parammt);
      }
    }
  }
  
  public static abstract interface a
  {
    public abstract void a(eib parameib);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.model.IPCallSvrNotifyListener
 * JD-Core Version:    0.7.0.1
 */