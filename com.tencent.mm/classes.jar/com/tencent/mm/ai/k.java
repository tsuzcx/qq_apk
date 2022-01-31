package com.tencent.mm.ai;

import com.tencent.mm.kernel.g;
import com.tencent.mm.m.e;
import com.tencent.mm.plugin.zero.b.a;
import com.tencent.mm.protocal.d;
import com.tencent.mm.protocal.f;
import com.tencent.mm.protocal.j.e;
import com.tencent.mm.protocal.j.e.a;
import com.tencent.mm.protocal.l.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

public abstract class k
  implements com.tencent.mm.network.q
{
  private static final String TAG = "MicroMsg.MMReqRespBase";
  private boolean isSingleSession = true;
  private boolean isUserCmd = false;
  private l.d req;
  
  public static void fillBaseReq(l.d paramd, k paramk)
  {
    paramd.setDeviceID(com.tencent.mm.compatible.e.q.LK());
    paramd.setDeviceType(d.eQs);
    paramd.setClientVersion(d.whH);
    paramd.setUin(j.e.a.wim.aaE());
    if ((f.whQ) && (g.RG()))
    {
      int j = paramk.getType();
      boolean bool;
      int k;
      int i;
      if (((a)g.E(a.class)).Nq().getInt("UseAesGcmSessionKeySwitch", 1) == 0)
      {
        bool = true;
        ab.i("MicroMsg.MMReqRespBase", "summerauths check cgi[%s] accHasReady openSwitch[%s] ", new Object[] { Integer.valueOf(j), Boolean.valueOf(bool) });
        if (bool)
        {
          paramd = ((a)g.E(a.class)).Nq().getValue("UseAesGcmSessionKeyCgiList");
          if (!bo.isNullOrNil(paramd))
          {
            ab.i("MicroMsg.MMReqRespBase", "summerauths check cgi list[%s]", new Object[] { paramd });
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
          if (j == bo.getInt(str, 0))
          {
            paramk.setSingleSession(false);
            ab.i("MicroMsg.MMReqRespBase", "summerauths check cgi list found cgi[%s] singleSession[%s]", new Object[] { str, Boolean.valueOf(paramk.isSingleSession()) });
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
    ab.i("MicroMsg.MMReqRespBase", "summerauths check cgi[%s] USE_ECDH[%s] accHasReady[%s] ", new Object[] { Integer.valueOf(paramd.getCmdId()), Boolean.valueOf(f.whQ), Boolean.valueOf(g.RG()) });
  }
  
  public boolean getIsUserCmd()
  {
    return this.isUserCmd;
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
 * Qualified Name:     com.tencent.mm.ai.k
 * JD-Core Version:    0.7.0.1
 */