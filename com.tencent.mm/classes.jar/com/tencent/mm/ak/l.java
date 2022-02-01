package com.tencent.mm.ak;

import com.tencent.mm.kernel.g;
import com.tencent.mm.m.e;
import com.tencent.mm.plugin.zero.b.a;
import com.tencent.mm.protocal.d;
import com.tencent.mm.protocal.f;
import com.tencent.mm.protocal.j.e;
import com.tencent.mm.protocal.j.e.a;
import com.tencent.mm.protocal.l.d;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;

public abstract class l
  implements com.tencent.mm.network.q
{
  private static final String TAG = "MicroMsg.MMReqRespBase";
  private boolean isSingleSession = true;
  private boolean isUserCmd = false;
  private l.d req;
  
  public static void fillBaseReq(l.d paramd, l paraml)
  {
    paramd.setDeviceID(com.tencent.mm.compatible.deviceinfo.q.XX());
    paramd.setDeviceType(d.gMK);
    paramd.setClientVersion(d.DIc);
    paramd.setUin(j.e.a.DIH.ayQ());
    if (g.agM())
    {
      int j = paraml.getType();
      boolean bool;
      int k;
      int i;
      if (((a)g.ab(a.class)).ZY().getInt("UseAesGcmSessionKeySwitch", 1) == 0)
      {
        bool = true;
        ac.i("MicroMsg.MMReqRespBase", "summerauths check cgi[%s] accHasReady openSwitch[%s] ", new Object[] { Integer.valueOf(j), Boolean.valueOf(bool) });
        if (bool)
        {
          paramd = ((a)g.ab(a.class)).ZY().getValue("UseAesGcmSessionKeyCgiList");
          if (!bs.isNullOrNil(paramd))
          {
            ac.i("MicroMsg.MMReqRespBase", "summerauths check cgi list[%s]", new Object[] { paramd });
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
          if (j == bs.getInt(str, 0))
          {
            paraml.setSingleSession(false);
            ac.i("MicroMsg.MMReqRespBase", "summerauths check cgi list found cgi[%s] singleSession[%s]", new Object[] { str, Boolean.valueOf(paraml.isSingleSession()) });
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
    ac.i("MicroMsg.MMReqRespBase", "summerauths check cgi[%s] USE_ECDH[%s] accHasReady[%s] ", new Object[] { Integer.valueOf(paramd.getCmdId()), Boolean.valueOf(f.DIl), Boolean.valueOf(g.agM()) });
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
  
  public boolean isSingleSession()
  {
    return this.isSingleSession;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ak.l
 * JD-Core Version:    0.7.0.1
 */