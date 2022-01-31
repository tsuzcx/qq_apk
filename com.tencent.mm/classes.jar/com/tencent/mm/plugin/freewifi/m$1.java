package com.tencent.mm.plugin.freewifi;

import com.tencent.mm.plugin.freewifi.d.a;
import com.tencent.mm.plugin.freewifi.ui.FreeWifiFrontPageUI;
import com.tencent.mm.plugin.freewifi.ui.FreeWifiFrontPageUI.a;
import com.tencent.mm.plugin.freewifi.ui.FreeWifiFrontPageUI.b;
import com.tencent.mm.plugin.freewifi.ui.FreeWifiFrontPageUI.d;
import com.tencent.mm.protocal.c.fd;
import com.tencent.mm.sdk.platformtools.y;

final class m$1
  implements m.a
{
  m$1(String paramString, FreeWifiFrontPageUI paramFreeWifiFrontPageUI, int paramInt) {}
  
  public final void i(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ah.m paramm)
  {
    Object localObject2;
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      if (!(paramm instanceof a)) {
        return;
      }
      paramString = ((a)paramm).aUw();
      if (paramString != null)
      {
        y.i(this.knG, "backPageInfo appid: %s, nickName: %s, userName: %s, finishActionCode: %d, finishUrl: %s, signature: %s, qingHuaiPageUrl: %s", new Object[] { paramString.svu, paramString.hRf, paramString.hPY, Integer.valueOf(paramString.syP), paramString.syQ, paramString.ffk, paramString.syR });
        paramm = this.knH;
        localObject1 = FreeWifiFrontPageUI.d.krW;
        localObject2 = new FreeWifiFrontPageUI.b();
        ((FreeWifiFrontPageUI.b)localObject2).krS = paramString;
        paramm.a((FreeWifiFrontPageUI.d)localObject1, localObject2);
        return;
      }
      y.i(this.knG, "backPageInfo is null");
      paramString = this.knH;
      paramm = FreeWifiFrontPageUI.d.krV;
      localObject1 = new FreeWifiFrontPageUI.a();
      ((FreeWifiFrontPageUI.a)localObject1).kru = m.a(this.kmW, k.b.knf, 21);
      paramString.a(paramm, localObject1);
      return;
    }
    if ((m.cS(paramInt1, paramInt2)) && (!m.isEmpty(paramString)))
    {
      paramm = this.knH;
      localObject1 = FreeWifiFrontPageUI.d.krV;
      localObject2 = new FreeWifiFrontPageUI.a();
      ((FreeWifiFrontPageUI.a)localObject2).text = paramString;
      ((FreeWifiFrontPageUI.a)localObject2).kru = m.a(this.kmW, k.b.knf, paramInt2);
      paramm.a((FreeWifiFrontPageUI.d)localObject1, localObject2);
      return;
    }
    paramString = this.knH;
    paramm = FreeWifiFrontPageUI.d.krV;
    Object localObject1 = new FreeWifiFrontPageUI.a();
    ((FreeWifiFrontPageUI.a)localObject1).kru = m.a(this.kmW, k.b.knf, paramInt2);
    paramString.a(paramm, localObject1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.freewifi.m.1
 * JD-Core Version:    0.7.0.1
 */