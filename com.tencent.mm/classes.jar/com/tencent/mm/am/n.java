package com.tencent.mm.am;

import com.tencent.mm.compatible.deviceinfo.q;
import com.tencent.mm.kernel.h;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.zero.b.a;
import com.tencent.mm.protocal.d;
import com.tencent.mm.protocal.j.e;
import com.tencent.mm.protocal.j.e.a;
import com.tencent.mm.protocal.l.d;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public abstract class n
  implements s
{
  private static final String TAG = "MicroMsg.MMReqRespBase";
  private boolean isSingleSession = true;
  private boolean isUserCmd = false;
  private l.d req;
  
  public static void fillBaseReq(l.d paramd, n paramn)
  {
    paramd.setDeviceID(q.aPg());
    paramd.setDeviceType(d.nsC);
    paramd.setClientVersion(d.Yxh);
    paramd.setUin(j.e.a.YxQ.bCD());
    if (h.baz())
    {
      int j = paramn.getType();
      boolean bool;
      int k;
      int i;
      if (((a)h.ax(a.class)).aRC().getInt("UseAesGcmSessionKeySwitch", 1) == 0)
      {
        bool = true;
        Log.i("MicroMsg.MMReqRespBase", "summerauths check cgi[%s] accHasReady openSwitch[%s] ", new Object[] { Integer.valueOf(j), Boolean.valueOf(bool) });
        if (bool)
        {
          paramd = ((a)h.ax(a.class)).aRC().getValue("UseAesGcmSessionKeyCgiList");
          if (!Util.isNullOrNil(paramd))
          {
            Log.i("MicroMsg.MMReqRespBase", "summerauths check cgi list[%s]", new Object[] { paramd });
            paramd = paramd.trim().split(",");
            if (paramd.length > 0)
            {
              k = paramd.length;
              i = 0;
            }
          }
        }
      }
      for (;;)
      {
        if (i < k)
        {
          String str = paramd[i];
          if (j == Util.getInt(str, 0))
          {
            paramn.setSingleSession(false);
            Log.i("MicroMsg.MMReqRespBase", "summerauths check cgi list found cgi[%s] singleSession[%s]", new Object[] { str, Boolean.valueOf(paramn.isSingleSession()) });
          }
        }
        else
        {
          return;
          bool = false;
          break;
        }
        i += 1;
      }
    }
    Log.i("MicroMsg.MMReqRespBase", "summerauths check cgi[%s] USE_ECDH[%s] accHasReady[%s] ", new Object[] { Integer.valueOf(paramd.getCmdId()), Boolean.valueOf(com.tencent.mm.protocal.f.Yxs), Boolean.valueOf(h.baz()) });
  }
  
  public boolean getIsLongPolling()
  {
    return false;
  }
  
  public boolean getIsUserCmd()
  {
    return this.isUserCmd;
  }
  
  public int getLongPollingTimeout()
  {
    return 0;
  }
  
  public int getNewExtFlags()
  {
    return 0;
  }
  
  public int getOptions()
  {
    return 0;
  }
  
  public boolean getPush()
  {
    return false;
  }
  
  public final l.d getReqObj()
  {
    if (this.req == null)
    {
      this.req = getReqObjImp();
      fillBaseReq(this.req, this);
    }
    return this.req;
  }
  
  protected abstract l.d getReqObjImp();
  
  public int getTimeOut()
  {
    return 0;
  }
  
  public byte[] getTransHeader()
  {
    return null;
  }
  
  public boolean isSingleSession()
  {
    return this.isSingleSession;
  }
  
  public boolean keepAlive()
  {
    return false;
  }
  
  public void setConnectionInfo(String paramString) {}
  
  public void setIsUserCmd(boolean paramBoolean)
  {
    this.isUserCmd = paramBoolean;
  }
  
  void setSingleSession(boolean paramBoolean)
  {
    this.isSingleSession = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.am.n
 * JD-Core Version:    0.7.0.1
 */