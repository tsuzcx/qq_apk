package com.tencent.mm.plugin.freewifi.d;

import android.content.Context;
import android.content.res.Resources;
import com.tencent.mm.R.l;
import com.tencent.mm.ah.b;
import com.tencent.mm.ah.b.a;
import com.tencent.mm.ah.b.b;
import com.tencent.mm.ah.b.c;
import com.tencent.mm.plugin.freewifi.g.d;
import com.tencent.mm.plugin.freewifi.model.j;
import com.tencent.mm.protocal.c.abq;
import com.tencent.mm.protocal.c.abr;
import com.tencent.mm.protocal.c.bsf;
import com.tencent.mm.protocal.c.cy;
import com.tencent.mm.protocal.c.fd;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;

public final class f
  extends c
{
  private static int kpi = 7200;
  private String mac;
  private String ssid;
  
  public f(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8)
  {
    aUp();
    this.ssid = paramString1;
    this.mac = paramString2;
    cy localcy = new cy();
    localcy.mac = paramString2;
    localcy.ssid = paramString1;
    paramString1 = (abq)this.dmK.ecE.ecN;
    paramString1.appId = paramString3;
    paramString1.kpI = paramString4;
    paramString1.kpJ = paramString5;
    paramString1.kpK = paramString6;
    paramString1.bIK = paramString7;
    paramString1.sign = paramString8;
    paramString1.taU = localcy;
  }
  
  protected final void aUp()
  {
    b.a locala = new b.a();
    locala.ecH = new abq();
    locala.ecI = new abr();
    locala.uri = "/cgi-bin/mmo2o-bin/getbackpagefor33";
    locala.ecG = 1726;
    locala.ecJ = 0;
    locala.ecK = 0;
    this.dmK = locala.Kt();
  }
  
  public final fd aUw()
  {
    return ((abr)this.dmK.ecF.ecN).krS;
  }
  
  protected final void b(int paramInt1, int paramInt2, int paramInt3, String paramString)
  {
    paramString = j.aUi().DC(this.ssid);
    if (paramString == null)
    {
      paramString = new com.tencent.mm.plugin.freewifi.g.c();
      paramString.field_ssidmd5 = ad.bB(this.ssid);
    }
    for (paramInt1 = 1;; paramInt1 = 0)
    {
      if ((paramInt2 == 0) && (paramInt3 == 0))
      {
        abr localabr = (abr)this.dmK.ecF.ecN;
        paramString.field_ssid = this.ssid;
        paramString.field_showUrl = localabr.ssz;
        bsf localbsf = localabr.ssA;
        if (localbsf != null)
        {
          y.i("MicroMsg.FreeWifi.NetSceneGetBackPageFor33", "en : %s, cn : %s, tw : %s", new Object[] { localbsf.tIQ, localbsf.tIR, localbsf.tIS });
          paramString.field_showWordCn = localbsf.tIR;
          paramString.field_showWordEn = localbsf.tIQ;
          paramString.field_showWordTw = localbsf.tIS;
          paramString.field_action = localabr.ssy;
          paramString.field_verifyResult = 1;
          paramString.field_connectState = -1;
          if (localabr.ssI <= 0) {
            localabr.ssI = kpi;
          }
          paramString.field_expiredTime = (bk.UX() + localabr.ssI);
          paramString.field_mac = this.mac;
          if (paramInt1 == 0) {
            break label315;
          }
          y.i("MicroMsg.FreeWifi.NetSceneGetBackPageFor33", "insert freewifi ret = %b", new Object[] { Boolean.valueOf(j.aUi().b(paramString)) });
          label250:
          j.aUi().DD(this.ssid);
        }
      }
      label315:
      do
      {
        return;
        paramString.field_showWordCn = ae.getContext().getResources().getString(R.l.free_wifi_verified);
        paramString.field_showWordEn = ae.getContext().getResources().getString(R.l.free_wifi_verified);
        paramString.field_showWordTw = ae.getContext().getResources().getString(R.l.free_wifi_verified);
        break;
        y.i("MicroMsg.FreeWifi.NetSceneGetBackPageFor33", "insert freewifi ret = %b", new Object[] { Boolean.valueOf(j.aUi().c(paramString, new String[0])) });
        break label250;
        y.e("MicroMsg.FreeWifi.NetSceneGetBackPageFor33", "check this ap failed, ssid is :%s", new Object[] { this.ssid });
      } while (paramInt1 != 0);
      boolean bool = j.aUi().a(paramString, new String[0]);
      y.i("MicroMsg.FreeWifi.NetSceneGetBackPageFor33", "freewifi verify failed, delte local db infos : %s, ret = %b", new Object[] { this.ssid, Boolean.valueOf(bool) });
      return;
    }
  }
  
  public final int getType()
  {
    return 1726;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.freewifi.d.f
 * JD-Core Version:    0.7.0.1
 */