package com.tencent.mm.plugin.ipcall.a;

import com.tencent.mm.h.a.im;
import com.tencent.mm.h.a.im.a;
import com.tencent.mm.protocal.c.bgb;
import com.tencent.mm.protocal.c.bgk;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.y;
import java.util.Iterator;
import java.util.LinkedList;

public final class h
  extends c<im>
{
  public h.a lpb;
  
  public h()
  {
    this.udX = im.class.getName().hashCode();
  }
  
  private boolean a(im paramim)
  {
    if ((paramim instanceof im))
    {
      paramim = paramim.bQJ.bQK;
      if ((paramim != null) && (paramim.length > 0)) {
        break label26;
      }
    }
    for (;;)
    {
      return false;
      label26:
      if (paramim[0] == 101)
      {
        Object localObject = new byte[paramim.length - 1];
        System.arraycopy(paramim, 1, localObject, 0, localObject.length);
        try
        {
          paramim = (bgb)new bgb().aH((byte[])localObject);
          y.d("MicroMsg.IPCallSvrNotifyListener", "roomId: %d, roomKey: %d, DtmfPayloadType: %d", new Object[] { Integer.valueOf(paramim.sST), Long.valueOf(paramim.sSU), Integer.valueOf(paramim.lpY) });
          localObject = paramim.tAT;
          if (localObject != null)
          {
            localObject = ((LinkedList)localObject).iterator();
            while (((Iterator)localObject).hasNext())
            {
              bgk localbgk = (bgk)((Iterator)localObject).next();
              y.d("MicroMsg.IPCallSvrNotifyListener", "userstatus: %d, userstatusKey: %d, memberId: %d", new Object[] { Integer.valueOf(localbgk.tzB), Integer.valueOf(localbgk.tBd), Integer.valueOf(localbgk.tBc) });
            }
          }
          if (this.lpb == null) {}
        }
        catch (Exception paramim)
        {
          y.e("MicroMsg.IPCallSvrNotifyListener", "parse PstnNotify error: %s", new Object[] { paramim.getMessage() });
          return false;
        }
      }
    }
    this.lpb.a(paramim);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.a.h
 * JD-Core Version:    0.7.0.1
 */