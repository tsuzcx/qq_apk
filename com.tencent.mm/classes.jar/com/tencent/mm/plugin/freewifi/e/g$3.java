package com.tencent.mm.plugin.freewifi.e;

import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.plugin.freewifi.d.a;
import com.tencent.mm.plugin.freewifi.model.c;
import com.tencent.mm.plugin.freewifi.model.j;
import com.tencent.mm.protocal.c.fd;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.y;

final class g$3
  implements f
{
  g$3(g paramg) {}
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    y.i("MicroMsg.FreeWifi.ProtocolOne", "errType : %d, errCode : %d, errMsg : %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      paramm = (a)paramm;
      paramString = paramm.aUq();
      y.i("MicroMsg.FreeWifi.ProtocolOne", "authUrl : %s", new Object[] { paramString });
      paramm = paramm.aUw();
      if (paramm != null)
      {
        y.i("MicroMsg.FreeWifi.ProtocolOne", "backPageInfo appid: %s, nickName: %s, userName: %s, finishActionCode: %d, finishUrl: %s, signature: %s", new Object[] { paramm.svu, paramm.hRf, paramm.hPY, Integer.valueOf(paramm.syP), paramm.syQ, paramm.ffk });
        g localg = this.kpB;
        j.aUl().aTT().post(new g.4(localg, paramString, paramm));
        return;
      }
      g.c(this.kpB);
      return;
    }
    g.c(this.kpB);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.freewifi.e.g.3
 * JD-Core Version:    0.7.0.1
 */