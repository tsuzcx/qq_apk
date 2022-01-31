package com.tencent.mm.plugin.cloudvoip.cloudvoice.c;

import com.tencent.mm.sdk.platformtools.y;

final class j$12$1
  implements Runnable
{
  j$12$1(j.12 param12, int paramInt1, int paramInt2, k paramk, boolean paramBoolean) {}
  
  public final void run()
  {
    if (!j.b(this.iGd.iFU))
    {
      y.w("MicroMsg.OpenVoice.OpenVoiceService", "hy: not joining room! abort");
      return;
    }
    if ((this.bEf == 0) && (this.bEg == 0) && (this.iGb != null) && (this.iGb.isValid()))
    {
      if (!j.c(this.iGd.iFU))
      {
        int i = j.a(this.iGd.iFU, this.iGb.iGw);
        if (i != 0)
        {
          j.a(this.iGd.iFU, this.iGd.iFY, -10086, -3, "init failed: " + i);
          return;
        }
        h localh = h.iEY;
        y.i("MicroMsg.OpenVoice.OpenVoiceNetworkMgr", "hy: start listen to network change");
        h.pt(0);
      }
      for (;;)
      {
        j.d(this.iGd.iFU);
        j.a(this.iGd.iFU, this.iGd.iFM, this.iGd.iFN, this.iGd.iFP, this.iGd.iFO, this.iGd.iFY);
        return;
        if (this.iGc)
        {
          y.i("MicroMsg.OpenVoice.OpenVoiceService", "hy: already initialized, but the former ");
          g.zu(this.iGb.iGw);
        }
      }
    }
    j.a(this.iGd.iFU, this.iGd.iFY, -10087, -8, "get session key failed");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.cloudvoip.cloudvoice.c.j.12.1
 * JD-Core Version:    0.7.0.1
 */