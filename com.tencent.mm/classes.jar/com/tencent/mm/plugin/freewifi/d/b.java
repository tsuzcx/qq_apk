package com.tencent.mm.plugin.freewifi.d;

import android.content.Context;
import android.content.res.Resources;
import com.tencent.mm.R.l;
import com.tencent.mm.ah.b.a;
import com.tencent.mm.ah.b.b;
import com.tencent.mm.ah.b.c;
import com.tencent.mm.plugin.freewifi.g.d;
import com.tencent.mm.plugin.freewifi.h;
import com.tencent.mm.plugin.freewifi.h.b;
import com.tencent.mm.plugin.freewifi.i;
import com.tencent.mm.plugin.freewifi.i.a;
import com.tencent.mm.plugin.freewifi.m;
import com.tencent.mm.plugin.freewifi.model.j;
import com.tencent.mm.protocal.c.ac;
import com.tencent.mm.protocal.c.bsf;
import com.tencent.mm.protocal.c.cy;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.util.LinkedList;

public final class b
  extends c
{
  private static int kpi = 7200;
  public String mac;
  private String ssid;
  
  public b(String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    aUp();
    this.ssid = paramString2;
    this.mac = paramString1;
    LinkedList localLinkedList = new LinkedList();
    Object localObject = new cy();
    ((cy)localObject).ssid = paramString2;
    ((cy)localObject).mac = paramString1;
    ((cy)localObject).swm = paramInt1;
    localLinkedList.add(localObject);
    localObject = (ac)this.dmK.ecE.ecN;
    ((ac)localObject).ssJ = h.b.aTv().aTp();
    ((ac)localObject).ssr = localLinkedList;
    ((ac)localObject).ssK = m.aTF();
    ((ac)localObject).ssL = paramInt2;
    y.i("MicroMsg.FreeWifi.NetSceneAPAuth", "new apcheck request. mac = %s, ssid = %s, rssi = %d", new Object[] { paramString1, paramString2, Integer.valueOf(paramInt1) });
  }
  
  protected final void aUp()
  {
    b.a locala = new b.a();
    locala.ecH = new ac();
    locala.ecI = new com.tencent.mm.protocal.c.ad();
    locala.uri = "/cgi-bin/mmo2o-bin/apcheck";
    locala.ecG = 1744;
    locala.ecJ = 0;
    locala.ecK = 0;
    this.dmK = locala.Kt();
  }
  
  protected final void b(int paramInt1, int paramInt2, int paramInt3, String paramString)
  {
    y.i("MicroMsg.FreeWifi.NetSceneAPAuth", "apcheck returns. onGYNetEnd : errType : %d, errCode : %d, errMsg : %s ", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    boolean bool;
    if ((this.dmK != null) && (this.dmK.ecF.ecN != null))
    {
      h.b.aTv().a((com.tencent.mm.protocal.c.ad)this.dmK.ecF.ecN);
      if ((m.cR(paramInt2, paramInt3)) || (m.cS(paramInt2, paramInt3)))
      {
        paramString = (com.tencent.mm.protocal.c.ad)this.dmK.ecF.ecN;
        paramInt1 = paramString.ssO;
        bool = paramString.ssN;
        if ((paramInt1 != 0) && (paramInt1 != i.a.aTw().getInt("LOCAL_CONFIG_APCHECK_DELAY_CRD_EXPIRED_DAYS", 7))) {
          i.a.aTw().bD("LOCAL_CONFIG_APCHECK_DELAY_CRD_EXPIRED_DAYS", paramInt1);
        }
        if (bool) {
          i.a.aTw().D("LOCAL_CONFIG_LAST_APCHECK_SAVE_DELAY_CRD_TIMEMILLIS", System.currentTimeMillis());
        }
      }
    }
    paramString = j.aUi().DC(this.ssid);
    if (paramString == null)
    {
      paramString = new com.tencent.mm.plugin.freewifi.g.c();
      paramString.field_ssidmd5 = com.tencent.mm.sdk.platformtools.ad.bB(this.ssid);
    }
    for (paramInt1 = 1;; paramInt1 = 0)
    {
      if ((paramInt2 == 0) && (paramInt3 == 0))
      {
        com.tencent.mm.protocal.c.ad localad = (com.tencent.mm.protocal.c.ad)this.dmK.ecF.ecN;
        paramString.field_ssid = this.ssid;
        paramString.field_showUrl = localad.ssz;
        bsf localbsf = localad.ssA;
        if (localbsf != null)
        {
          y.i("MicroMsg.FreeWifi.NetSceneAPAuth", "en : %s, cn : %s, tw : %s", new Object[] { localbsf.tIQ, localbsf.tIR, localbsf.tIS });
          paramString.field_showWordCn = localbsf.tIR;
          paramString.field_showWordEn = localbsf.tIQ;
          paramString.field_showWordTw = localbsf.tIS;
          paramString.field_action = localad.ssy;
          paramString.field_verifyResult = 1;
          paramString.field_connectState = -1;
          if (localad.ssI <= 0) {
            localad.ssI = kpi;
          }
          paramString.field_expiredTime = (bk.UX() + localad.ssI);
          paramString.field_mac = this.mac;
          if (paramInt1 == 0) {
            break label472;
          }
          y.i("MicroMsg.FreeWifi.NetSceneAPAuth", "insert freewifi ret = %b", new Object[] { Boolean.valueOf(j.aUi().b(paramString)) });
          label407:
          j.aUi().DD(this.ssid);
        }
      }
      label472:
      do
      {
        return;
        paramString.field_showWordCn = ae.getContext().getResources().getString(R.l.free_wifi_verified);
        paramString.field_showWordEn = ae.getContext().getResources().getString(R.l.free_wifi_verified);
        paramString.field_showWordTw = ae.getContext().getResources().getString(R.l.free_wifi_verified);
        break;
        y.i("MicroMsg.FreeWifi.NetSceneAPAuth", "insert freewifi ret = %b", new Object[] { Boolean.valueOf(j.aUi().c(paramString, new String[0])) });
        break label407;
        y.e("MicroMsg.FreeWifi.NetSceneAPAuth", "check this ap failed, ssid is :%s", new Object[] { this.ssid });
      } while (paramInt1 != 0);
      bool = j.aUi().a(paramString, new String[0]);
      y.i("MicroMsg.FreeWifi.NetSceneAPAuth", "freewifi verify failed, delte local db infos : %s, ret = %b", new Object[] { this.ssid, Boolean.valueOf(bool) });
      return;
    }
  }
  
  public final int getType()
  {
    return 1744;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.freewifi.d.b
 * JD-Core Version:    0.7.0.1
 */