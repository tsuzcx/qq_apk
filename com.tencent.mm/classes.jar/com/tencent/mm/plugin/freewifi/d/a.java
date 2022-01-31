package com.tencent.mm.plugin.freewifi.d;

import android.content.Context;
import android.content.res.Resources;
import com.tencent.mm.R.l;
import com.tencent.mm.ah.b;
import com.tencent.mm.ah.b.a;
import com.tencent.mm.ah.b.b;
import com.tencent.mm.ah.b.c;
import com.tencent.mm.plugin.freewifi.g.d;
import com.tencent.mm.plugin.freewifi.m;
import com.tencent.mm.plugin.freewifi.model.j;
import com.tencent.mm.protocal.c.aa;
import com.tencent.mm.protocal.c.ab;
import com.tencent.mm.protocal.c.bhn;
import com.tencent.mm.protocal.c.bsf;
import com.tencent.mm.protocal.c.cy;
import com.tencent.mm.protocal.c.fd;
import com.tencent.mm.protocal.c.zo;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.net.URLDecoder;
import java.util.LinkedList;

public final class a
  extends c
{
  private static int kpi = 7200;
  private int bMC;
  private String mac;
  private String ssid;
  
  public a(String paramString1, int paramInt, String paramString2)
  {
    aUp();
    this.bMC = 4;
    aa localaa = (aa)this.dmK.ecE.ecN;
    localaa.ssq = 4;
    localaa.URL = paramString1;
    localaa.sss = paramInt;
    localaa.sst = paramString2;
    localaa.ssu = m.aTD();
    localaa.ssr = new LinkedList();
    paramString2 = new cy();
    paramString2.ssid = m.Do("MicroMsg.FreeWifi.NetSceneAPAuth");
    paramString2.mac = m.Dp("MicroMsg.FreeWifi.NetSceneAPAuth");
    localaa.ssr.add(paramString2);
    localaa.ssv = m.Dq("MicroMsg.FreeWifi.NetSceneAPAuth");
    y.i("MicroMsg.FreeWifi.NetSceneAPAuth", "Constructing get front page request, HasMobile=%d, Ap_info[0].ssid=%s, Ap_info[0].mac=%s", new Object[] { Integer.valueOf(localaa.ssu), paramString2.ssid, paramString2.mac });
    y.i("MicroMsg.FreeWifi.NetSceneAPAuth", "opCode = %d, url = %s", new Object[] { Integer.valueOf(4), paramString1 });
  }
  
  public a(String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, String paramString4)
  {
    aUp();
    this.ssid = paramString3;
    this.mac = paramString2;
    this.bMC = 1;
    LinkedList localLinkedList = new LinkedList();
    Object localObject = new cy();
    ((cy)localObject).ssid = paramString3;
    ((cy)localObject).mac = paramString2;
    ((cy)localObject).swm = paramInt1;
    localLinkedList.add(localObject);
    localObject = (aa)this.dmK.ecE.ecN;
    ((aa)localObject).ssq = 1;
    ((aa)localObject).ssr = localLinkedList;
    ((aa)localObject).URL = paramString1;
    ((aa)localObject).sss = paramInt2;
    ((aa)localObject).sst = paramString4;
    ((aa)localObject).ssv = m.Dq("MicroMsg.FreeWifi.NetSceneAPAuth");
    y.i("MicroMsg.FreeWifi.NetSceneAPAuth", "opcode = %d, mac = %s, ssid = %s, rssi = %d", new Object[] { Integer.valueOf(1), paramString2, paramString3, Integer.valueOf(paramInt1) });
  }
  
  public a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, int paramInt, String paramString7)
  {
    aUp();
    this.ssid = paramString2;
    this.mac = paramString3;
    aa localaa = (aa)this.dmK.ecE.ecN;
    String str = URLDecoder.decode(paramString5);
    localaa.ssq = 0;
    localaa.URL = paramString1;
    localaa.SSID = paramString2;
    localaa.ssn = paramString4;
    localaa.sso = str;
    localaa.ssp = paramString6;
    localaa.sss = paramInt;
    localaa.sst = paramString7;
    paramString7 = new LinkedList();
    cy localcy = new cy();
    localcy.ssid = paramString2;
    localcy.mac = paramString3;
    paramString7.add(localcy);
    localaa.ssr = paramString7;
    y.i("MicroMsg.FreeWifi.NetSceneAPAuth", "url : %s, ssid : %s, mid : %s, mac : %s, apauthdata : %s, decoded apauthdata :%s,  token : %s", new Object[] { paramString1, paramString2, paramString4, paramString3, paramString5, str, paramString6 });
  }
  
  protected final void aUp()
  {
    b.a locala = new b.a();
    locala.ecH = new aa();
    locala.ecI = new ab();
    locala.uri = "/cgi-bin/micromsg-bin/apauth";
    locala.ecG = 640;
    locala.ecJ = 0;
    locala.ecK = 0;
    this.dmK = locala.Kt();
  }
  
  public final String aUq()
  {
    ab localab = (ab)this.dmK.ecF.ecN;
    if (localab != null) {
      return localab.ssw;
    }
    return null;
  }
  
  public final bhn aUr()
  {
    ab localab = (ab)this.dmK.ecF.ecN;
    if (localab != null) {
      return localab.ssD;
    }
    return null;
  }
  
  public final boolean aUs()
  {
    ab localab = (ab)this.dmK.ecF.ecN;
    if ((localab != null) && (localab.ssE != null)) {
      return localab.ssE.ssu == 1;
    }
    return false;
  }
  
  public final zo aUt()
  {
    ab localab = (ab)this.dmK.ecF.ecN;
    if (localab != null) {
      return localab.ssE;
    }
    return null;
  }
  
  public final String aUu()
  {
    ab localab = (ab)this.dmK.ecF.ecN;
    if (localab != null) {
      return localab.ssG;
    }
    return null;
  }
  
  public final String aUv()
  {
    ab localab = (ab)this.dmK.ecF.ecN;
    if (localab != null) {
      return localab.ssH;
    }
    return null;
  }
  
  public final fd aUw()
  {
    ab localab = (ab)this.dmK.ecF.ecN;
    if (localab != null) {
      return localab.ssF;
    }
    return null;
  }
  
  protected final void b(int paramInt1, int paramInt2, int paramInt3, String paramString)
  {
    y.i("MicroMsg.FreeWifi.NetSceneAPAuth", "onGYNetEnd : errType : %d, errCode : %d, errMsg : %s, opCode = %d", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString, Integer.valueOf(this.bMC) });
    switch (this.bMC)
    {
    }
    label455:
    label509:
    do
    {
      do
      {
        return;
      } while ((paramInt2 != 0) || (paramInt3 != 0));
      Object localObject = j.aUi().DC(this.ssid);
      paramString = this.ssid;
      bsf localbsf;
      if (localObject == null)
      {
        bool = true;
        y.i("MicroMsg.FreeWifi.NetSceneAPAuth", "get freewifi by ssid :%s, is wifi info = null ? %b", new Object[] { paramString, Boolean.valueOf(bool) });
        paramInt1 = 0;
        paramString = (String)localObject;
        if (localObject == null)
        {
          paramInt1 = 1;
          paramString = new com.tencent.mm.plugin.freewifi.g.c();
          paramString.field_ssidmd5 = ad.bB(this.ssid);
        }
        paramString.field_wifiType = 1;
        localObject = (ab)this.dmK.ecF.ecN;
        localbsf = ((ab)localObject).ssA;
        if (localbsf == null) {
          break label455;
        }
        y.i("MicroMsg.FreeWifi.NetSceneAPAuth", "en : %s, cn : %s, tw : %s", new Object[] { localbsf.tIQ, localbsf.tIR, localbsf.tIS });
        paramString.field_showWordCn = localbsf.tIR;
        paramString.field_showWordEn = localbsf.tIQ;
      }
      for (paramString.field_showWordTw = localbsf.tIS;; paramString.field_showWordTw = ae.getContext().getResources().getString(R.l.free_wifi_verified))
      {
        paramString.field_action = ((ab)localObject).ssy;
        paramString.field_verifyResult = 1;
        paramString.field_connectState = -1;
        if (((ab)localObject).ssI <= 0) {
          ((ab)localObject).ssI = kpi;
        }
        paramString.field_expiredTime = (bk.UX() + ((ab)localObject).ssI);
        paramString.field_showUrl = ((ab)localObject).ssz;
        paramString.field_action = ((ab)localObject).ssy;
        paramString.field_ssid = this.ssid;
        paramString.field_mac = this.mac;
        paramString.field_wifiType = 1;
        if (paramInt1 == 0) {
          break label509;
        }
        bool = j.aUi().b(paramString);
        y.i("MicroMsg.FreeWifi.NetSceneAPAuth", "insert freewifi ret = %b", new Object[] { Boolean.valueOf(bool) });
        y.i("MicroMsg.FreeWifi.NetSceneAPAuth", "insert local freewifi info : %s, %b, expiredTime : %d, action :%d, showurl : %s", new Object[] { this.ssid, Boolean.valueOf(bool), Integer.valueOf(((ab)localObject).ssx), Integer.valueOf(((ab)localObject).ssy), ((ab)localObject).ssz });
        return;
        bool = false;
        break;
        paramString.field_showWordCn = ae.getContext().getResources().getString(R.l.free_wifi_verified);
        paramString.field_showWordEn = ae.getContext().getResources().getString(R.l.free_wifi_verified);
      }
      bool = j.aUi().c(paramString, new String[0]);
      y.i("MicroMsg.FreeWifi.NetSceneAPAuth", "update local freewifi info : %s, %b, expiredTime : %d, action :%d, showurl : %s", new Object[] { this.ssid, Boolean.valueOf(bool), Integer.valueOf(((ab)localObject).ssx), Integer.valueOf(((ab)localObject).ssy), ((ab)localObject).ssz });
      return;
      localObject = j.aUi().DC(this.ssid);
      paramInt1 = 0;
      paramString = (String)localObject;
      if (localObject == null)
      {
        paramInt1 = 1;
        paramString = new com.tencent.mm.plugin.freewifi.g.c();
        paramString.field_ssidmd5 = ad.bB(this.ssid);
      }
      if ((paramInt2 == 0) && (paramInt3 == 0))
      {
        localObject = (ab)this.dmK.ecF.ecN;
        paramString.field_ssid = this.ssid;
        paramString.field_showUrl = ((ab)localObject).ssz;
        localbsf = ((ab)localObject).ssA;
        y.i("MicroMsg.FreeWifi.NetSceneAPAuth", "get resp info : %s, expiredTime : %d, action :%d, showurl : %s", new Object[] { this.ssid, Integer.valueOf(((ab)localObject).ssx), Integer.valueOf(((ab)localObject).ssy), ((ab)localObject).ssz });
        if (localbsf != null)
        {
          y.i("MicroMsg.FreeWifi.NetSceneAPAuth", "en : %s, cn : %s, tw : %s", new Object[] { localbsf.tIQ, localbsf.tIR, localbsf.tIS });
          paramString.field_showWordCn = localbsf.tIR;
          paramString.field_showWordEn = localbsf.tIQ;
          paramString.field_showWordTw = localbsf.tIS;
          paramString.field_action = ((ab)localObject).ssy;
          paramString.field_verifyResult = 1;
          paramString.field_connectState = -1;
          if (((ab)localObject).ssI <= 0) {
            ((ab)localObject).ssI = kpi;
          }
          paramString.field_expiredTime = (bk.UX() + ((ab)localObject).ssI);
          paramString.field_mac = this.mac;
          if (paramInt1 == 0) {
            break label953;
          }
          y.i("MicroMsg.FreeWifi.NetSceneAPAuth", "insert freewifi ret = %b", new Object[] { Boolean.valueOf(j.aUi().b(paramString)) });
        }
        for (;;)
        {
          j.aUi().DD(this.ssid);
          return;
          paramString.field_showWordCn = ae.getContext().getResources().getString(R.l.free_wifi_verified);
          paramString.field_showWordEn = ae.getContext().getResources().getString(R.l.free_wifi_verified);
          paramString.field_showWordTw = ae.getContext().getResources().getString(R.l.free_wifi_verified);
          break;
          y.i("MicroMsg.FreeWifi.NetSceneAPAuth", "insert freewifi ret = %b", new Object[] { Boolean.valueOf(j.aUi().c(paramString, new String[0])) });
        }
      }
      y.e("MicroMsg.FreeWifi.NetSceneAPAuth", "check this ap failed, ssid is :%s", new Object[] { this.ssid });
    } while (paramInt1 != 0);
    label953:
    boolean bool = j.aUi().a(paramString, new String[0]);
    y.i("MicroMsg.FreeWifi.NetSceneAPAuth", "freewifi verify failed, delte local db infos : %s, ret = %b", new Object[] { this.ssid, Boolean.valueOf(bool) });
  }
  
  public final int getType()
  {
    return 640;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.freewifi.d.a
 * JD-Core Version:    0.7.0.1
 */