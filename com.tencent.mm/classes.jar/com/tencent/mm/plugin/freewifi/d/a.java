package com.tencent.mm.plugin.freewifi.d;

import android.content.Context;
import android.content.res.Resources;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.plugin.freewifi.g.d;
import com.tencent.mm.plugin.freewifi.m;
import com.tencent.mm.plugin.freewifi.model.j;
import com.tencent.mm.protocal.protobuf.ac;
import com.tencent.mm.protocal.protobuf.ad;
import com.tencent.mm.protocal.protobuf.aui;
import com.tencent.mm.protocal.protobuf.cpp;
import com.tencent.mm.protocal.protobuf.dfd;
import com.tencent.mm.protocal.protobuf.dw;
import com.tencent.mm.protocal.protobuf.hu;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bu;
import java.net.URLDecoder;
import java.util.LinkedList;

public final class a
  extends c
{
  private static int tym = 7200;
  private int dsO;
  private String mac;
  private String ssid;
  
  public a(String paramString1, int paramInt, String paramString2)
  {
    AppMethodBeat.i(24842);
    cUl();
    this.dsO = 4;
    ac localac = (ac)this.rr.hQD.hQJ;
    localac.OpCode = 4;
    localac.URL = paramString1;
    localac.FJf = paramInt;
    localac.FJg = paramString2;
    localac.FJh = m.cTB();
    localac.FJe = new LinkedList();
    paramString2 = new dw();
    paramString2.ssid = m.akI("MicroMsg.FreeWifi.NetSceneAPAuth");
    paramString2.mac = m.akJ("MicroMsg.FreeWifi.NetSceneAPAuth");
    localac.FJe.add(paramString2);
    localac.FJi = m.akK("MicroMsg.FreeWifi.NetSceneAPAuth");
    ae.i("MicroMsg.FreeWifi.NetSceneAPAuth", "Constructing get front page request, HasMobile=%d, Ap_info[0].ssid=%s, Ap_info[0].mac=%s", new Object[] { Integer.valueOf(localac.FJh), paramString2.ssid, paramString2.mac });
    ae.i("MicroMsg.FreeWifi.NetSceneAPAuth", "opCode = %d, url = %s", new Object[] { Integer.valueOf(4), paramString1 });
    AppMethodBeat.o(24842);
  }
  
  public a(String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, String paramString4)
  {
    AppMethodBeat.i(24841);
    cUl();
    this.ssid = paramString3;
    this.mac = paramString2;
    this.dsO = 1;
    LinkedList localLinkedList = new LinkedList();
    Object localObject = new dw();
    ((dw)localObject).ssid = paramString3;
    ((dw)localObject).mac = paramString2;
    ((dw)localObject).ghG = paramInt1;
    localLinkedList.add(localObject);
    localObject = (ac)this.rr.hQD.hQJ;
    ((ac)localObject).OpCode = 1;
    ((ac)localObject).FJe = localLinkedList;
    ((ac)localObject).URL = paramString1;
    ((ac)localObject).FJf = paramInt2;
    ((ac)localObject).FJg = paramString4;
    ((ac)localObject).FJi = m.akK("MicroMsg.FreeWifi.NetSceneAPAuth");
    ae.i("MicroMsg.FreeWifi.NetSceneAPAuth", "opcode = %d, mac = %s, ssid = %s, rssi = %d", new Object[] { Integer.valueOf(1), paramString2, paramString3, Integer.valueOf(paramInt1) });
    AppMethodBeat.o(24841);
  }
  
  public a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, int paramInt, String paramString7)
  {
    AppMethodBeat.i(24840);
    cUl();
    this.ssid = paramString2;
    this.mac = paramString3;
    ac localac = (ac)this.rr.hQD.hQJ;
    String str = URLDecoder.decode(paramString5);
    localac.OpCode = 0;
    localac.URL = paramString1;
    localac.SSID = paramString2;
    localac.FJb = paramString4;
    localac.FJc = str;
    localac.FJd = paramString6;
    localac.FJf = paramInt;
    localac.FJg = paramString7;
    paramString7 = new LinkedList();
    dw localdw = new dw();
    localdw.ssid = paramString2;
    localdw.mac = paramString3;
    paramString7.add(localdw);
    localac.FJe = paramString7;
    ae.i("MicroMsg.FreeWifi.NetSceneAPAuth", "url : %s, ssid : %s, mid : %s, mac : %s, apauthdata : %s, decoded apauthdata :%s,  token : %s", new Object[] { paramString1, paramString2, paramString4, paramString3, paramString5, str, paramString6 });
    AppMethodBeat.o(24840);
  }
  
  public final String Ug()
  {
    ad localad = (ad)this.rr.hQE.hQJ;
    if (localad != null) {
      return localad.FJu;
    }
    return null;
  }
  
  protected final void b(int paramInt1, int paramInt2, int paramInt3, String paramString)
  {
    AppMethodBeat.i(24843);
    ae.i("MicroMsg.FreeWifi.NetSceneAPAuth", "onGYNetEnd : errType : %d, errCode : %d, errMsg : %s, opCode = %d", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString, Integer.valueOf(this.dsO) });
    switch (this.dsO)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(24843);
      return;
      if ((paramInt2 == 0) && (paramInt3 == 0))
      {
        Object localObject = j.cUe().akW(this.ssid);
        paramString = this.ssid;
        dfd localdfd;
        if (localObject == null)
        {
          bool = true;
          ae.i("MicroMsg.FreeWifi.NetSceneAPAuth", "get freewifi by ssid :%s, is wifi info = null ? %b", new Object[] { paramString, Boolean.valueOf(bool) });
          paramInt1 = 0;
          paramString = (String)localObject;
          if (localObject == null)
          {
            paramInt1 = 1;
            paramString = new com.tencent.mm.plugin.freewifi.g.c();
            paramString.field_ssidmd5 = aj.ej(this.ssid);
          }
          paramString.field_wifiType = 1;
          localObject = (ad)this.rr.hQE.hQJ;
          localdfd = ((ad)localObject).FJn;
          if (localdfd == null) {
            break label470;
          }
          ae.i("MicroMsg.FreeWifi.NetSceneAPAuth", "en : %s, cn : %s, tw : %s", new Object[] { localdfd.HMn, localdfd.HMo, localdfd.HMp });
          paramString.field_showWordCn = localdfd.HMo;
          paramString.field_showWordEn = localdfd.HMn;
        }
        for (paramString.field_showWordTw = localdfd.HMp;; paramString.field_showWordTw = ak.getContext().getResources().getString(2131759658))
        {
          paramString.field_action = ((ad)localObject).FJl;
          paramString.field_verifyResult = 1;
          paramString.field_connectState = -1;
          if (((ad)localObject).FJv <= 0) {
            ((ad)localObject).FJv = tym;
          }
          paramString.field_expiredTime = (bu.aRi() + ((ad)localObject).FJv);
          paramString.field_showUrl = ((ad)localObject).FJm;
          paramString.field_action = ((ad)localObject).FJl;
          paramString.field_ssid = this.ssid;
          paramString.field_mac = this.mac;
          paramString.field_wifiType = 1;
          if (paramInt1 == 0) {
            break label524;
          }
          bool = j.cUe().insert(paramString);
          ae.i("MicroMsg.FreeWifi.NetSceneAPAuth", "insert freewifi ret = %b", new Object[] { Boolean.valueOf(bool) });
          ae.i("MicroMsg.FreeWifi.NetSceneAPAuth", "insert local freewifi info : %s, %b, expiredTime : %d, action :%d, showurl : %s", new Object[] { this.ssid, Boolean.valueOf(bool), Integer.valueOf(((ad)localObject).FJk), Integer.valueOf(((ad)localObject).FJl), ((ad)localObject).FJm });
          AppMethodBeat.o(24843);
          return;
          bool = false;
          break;
          label470:
          paramString.field_showWordCn = ak.getContext().getResources().getString(2131759658);
          paramString.field_showWordEn = ak.getContext().getResources().getString(2131759658);
        }
        label524:
        boolean bool = j.cUe().update(paramString, new String[0]);
        ae.i("MicroMsg.FreeWifi.NetSceneAPAuth", "update local freewifi info : %s, %b, expiredTime : %d, action :%d, showurl : %s", new Object[] { this.ssid, Boolean.valueOf(bool), Integer.valueOf(((ad)localObject).FJk), Integer.valueOf(((ad)localObject).FJl), ((ad)localObject).FJm });
        AppMethodBeat.o(24843);
        return;
        localObject = j.cUe().akW(this.ssid);
        paramInt1 = 0;
        paramString = (String)localObject;
        if (localObject == null)
        {
          paramInt1 = 1;
          paramString = new com.tencent.mm.plugin.freewifi.g.c();
          paramString.field_ssidmd5 = aj.ej(this.ssid);
        }
        if ((paramInt2 == 0) && (paramInt3 == 0))
        {
          localObject = (ad)this.rr.hQE.hQJ;
          paramString.field_ssid = this.ssid;
          paramString.field_showUrl = ((ad)localObject).FJm;
          localdfd = ((ad)localObject).FJn;
          ae.i("MicroMsg.FreeWifi.NetSceneAPAuth", "get resp info : %s, expiredTime : %d, action :%d, showurl : %s", new Object[] { this.ssid, Integer.valueOf(((ad)localObject).FJk), Integer.valueOf(((ad)localObject).FJl), ((ad)localObject).FJm });
          if (localdfd != null)
          {
            ae.i("MicroMsg.FreeWifi.NetSceneAPAuth", "en : %s, cn : %s, tw : %s", new Object[] { localdfd.HMn, localdfd.HMo, localdfd.HMp });
            paramString.field_showWordCn = localdfd.HMo;
            paramString.field_showWordEn = localdfd.HMn;
            paramString.field_showWordTw = localdfd.HMp;
            paramString.field_action = ((ad)localObject).FJl;
            paramString.field_verifyResult = 1;
            paramString.field_connectState = -1;
            if (((ad)localObject).FJv <= 0) {
              ((ad)localObject).FJv = tym;
            }
            paramString.field_expiredTime = (bu.aRi() + ((ad)localObject).FJv);
            paramString.field_mac = this.mac;
            if (paramInt1 == 0) {
              break label979;
            }
            ae.i("MicroMsg.FreeWifi.NetSceneAPAuth", "insert freewifi ret = %b", new Object[] { Boolean.valueOf(j.cUe().insert(paramString)) });
          }
          for (;;)
          {
            j.cUe().akX(this.ssid);
            AppMethodBeat.o(24843);
            return;
            paramString.field_showWordCn = ak.getContext().getResources().getString(2131759658);
            paramString.field_showWordEn = ak.getContext().getResources().getString(2131759658);
            paramString.field_showWordTw = ak.getContext().getResources().getString(2131759658);
            break;
            label979:
            ae.i("MicroMsg.FreeWifi.NetSceneAPAuth", "insert freewifi ret = %b", new Object[] { Boolean.valueOf(j.cUe().update(paramString, new String[0])) });
          }
        }
        ae.e("MicroMsg.FreeWifi.NetSceneAPAuth", "check this ap failed, ssid is :%s", new Object[] { this.ssid });
        if (paramInt1 == 0)
        {
          bool = j.cUe().delete(paramString, new String[0]);
          ae.i("MicroMsg.FreeWifi.NetSceneAPAuth", "freewifi verify failed, delte local db infos : %s, ret = %b", new Object[] { this.ssid, Boolean.valueOf(bool) });
        }
      }
    }
  }
  
  protected final void cUl()
  {
    AppMethodBeat.i(24839);
    b.a locala = new b.a();
    locala.hQF = new ac();
    locala.hQG = new ad();
    locala.uri = "/cgi-bin/micromsg-bin/apauth";
    locala.funcId = 640;
    locala.hQH = 0;
    locala.respCmdId = 0;
    this.rr = locala.aDS();
    AppMethodBeat.o(24839);
  }
  
  public final String cUm()
  {
    ad localad = (ad)this.rr.hQE.hQJ;
    if (localad != null) {
      return localad.FJj;
    }
    return null;
  }
  
  public final cpp cUn()
  {
    ad localad = (ad)this.rr.hQE.hQJ;
    if (localad != null) {
      return localad.FJq;
    }
    return null;
  }
  
  public final boolean cUo()
  {
    ad localad = (ad)this.rr.hQE.hQJ;
    if ((localad != null) && (localad.FJr != null)) {
      return localad.FJr.FJh == 1;
    }
    return false;
  }
  
  public final aui cUp()
  {
    ad localad = (ad)this.rr.hQE.hQJ;
    if (localad != null) {
      return localad.FJr;
    }
    return null;
  }
  
  public final hu cUq()
  {
    ad localad = (ad)this.rr.hQE.hQJ;
    if (localad != null) {
      return localad.FJs;
    }
    return null;
  }
  
  public final String getOpenId()
  {
    ad localad = (ad)this.rr.hQE.hQJ;
    if (localad != null) {
      return localad.FJt;
    }
    return null;
  }
  
  public final int getType()
  {
    return 640;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.freewifi.d.a
 * JD-Core Version:    0.7.0.1
 */