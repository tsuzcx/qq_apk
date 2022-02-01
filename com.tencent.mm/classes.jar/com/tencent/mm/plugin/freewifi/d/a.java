package com.tencent.mm.plugin.freewifi.d;

import android.content.Context;
import android.content.res.Resources;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.plugin.freewifi.g.d;
import com.tencent.mm.plugin.freewifi.m;
import com.tencent.mm.plugin.freewifi.model.j;
import com.tencent.mm.protocal.protobuf.ac;
import com.tencent.mm.protocal.protobuf.ats;
import com.tencent.mm.protocal.protobuf.cov;
import com.tencent.mm.protocal.protobuf.dej;
import com.tencent.mm.protocal.protobuf.dw;
import com.tencent.mm.protocal.protobuf.hu;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import java.net.URLDecoder;
import java.util.LinkedList;

public final class a
  extends c
{
  private static int tnu = 7200;
  private int drI;
  private String mac;
  private String ssid;
  
  public a(String paramString1, int paramInt, String paramString2)
  {
    AppMethodBeat.i(24842);
    cRG();
    this.drI = 4;
    ac localac = (ac)this.rr.hNK.hNQ;
    localac.OpCode = 4;
    localac.URL = paramString1;
    localac.FqH = paramInt;
    localac.FqI = paramString2;
    localac.FqJ = m.cQW();
    localac.FqG = new LinkedList();
    paramString2 = new dw();
    paramString2.ssid = m.ajK("MicroMsg.FreeWifi.NetSceneAPAuth");
    paramString2.mac = m.ajL("MicroMsg.FreeWifi.NetSceneAPAuth");
    localac.FqG.add(paramString2);
    localac.FqK = m.ajM("MicroMsg.FreeWifi.NetSceneAPAuth");
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.FreeWifi.NetSceneAPAuth", "Constructing get front page request, HasMobile=%d, Ap_info[0].ssid=%s, Ap_info[0].mac=%s", new Object[] { Integer.valueOf(localac.FqJ), paramString2.ssid, paramString2.mac });
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.FreeWifi.NetSceneAPAuth", "opCode = %d, url = %s", new Object[] { Integer.valueOf(4), paramString1 });
    AppMethodBeat.o(24842);
  }
  
  public a(String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, String paramString4)
  {
    AppMethodBeat.i(24841);
    cRG();
    this.ssid = paramString3;
    this.mac = paramString2;
    this.drI = 1;
    LinkedList localLinkedList = new LinkedList();
    Object localObject = new dw();
    ((dw)localObject).ssid = paramString3;
    ((dw)localObject).mac = paramString2;
    ((dw)localObject).gfo = paramInt1;
    localLinkedList.add(localObject);
    localObject = (ac)this.rr.hNK.hNQ;
    ((ac)localObject).OpCode = 1;
    ((ac)localObject).FqG = localLinkedList;
    ((ac)localObject).URL = paramString1;
    ((ac)localObject).FqH = paramInt2;
    ((ac)localObject).FqI = paramString4;
    ((ac)localObject).FqK = m.ajM("MicroMsg.FreeWifi.NetSceneAPAuth");
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.FreeWifi.NetSceneAPAuth", "opcode = %d, mac = %s, ssid = %s, rssi = %d", new Object[] { Integer.valueOf(1), paramString2, paramString3, Integer.valueOf(paramInt1) });
    AppMethodBeat.o(24841);
  }
  
  public a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, int paramInt, String paramString7)
  {
    AppMethodBeat.i(24840);
    cRG();
    this.ssid = paramString2;
    this.mac = paramString3;
    ac localac = (ac)this.rr.hNK.hNQ;
    String str = URLDecoder.decode(paramString5);
    localac.OpCode = 0;
    localac.URL = paramString1;
    localac.SSID = paramString2;
    localac.FqD = paramString4;
    localac.FqE = str;
    localac.FqF = paramString6;
    localac.FqH = paramInt;
    localac.FqI = paramString7;
    paramString7 = new LinkedList();
    dw localdw = new dw();
    localdw.ssid = paramString2;
    localdw.mac = paramString3;
    paramString7.add(localdw);
    localac.FqG = paramString7;
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.FreeWifi.NetSceneAPAuth", "url : %s, ssid : %s, mid : %s, mac : %s, apauthdata : %s, decoded apauthdata :%s,  token : %s", new Object[] { paramString1, paramString2, paramString4, paramString3, paramString5, str, paramString6 });
    AppMethodBeat.o(24840);
  }
  
  public final String Ua()
  {
    com.tencent.mm.protocal.protobuf.ad localad = (com.tencent.mm.protocal.protobuf.ad)this.rr.hNL.hNQ;
    if (localad != null) {
      return localad.FqW;
    }
    return null;
  }
  
  protected final void b(int paramInt1, int paramInt2, int paramInt3, String paramString)
  {
    AppMethodBeat.i(24843);
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.FreeWifi.NetSceneAPAuth", "onGYNetEnd : errType : %d, errCode : %d, errMsg : %s, opCode = %d", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString, Integer.valueOf(this.drI) });
    switch (this.drI)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(24843);
      return;
      if ((paramInt2 == 0) && (paramInt3 == 0))
      {
        Object localObject = j.cRz().ajY(this.ssid);
        paramString = this.ssid;
        dej localdej;
        if (localObject == null)
        {
          bool = true;
          com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.FreeWifi.NetSceneAPAuth", "get freewifi by ssid :%s, is wifi info = null ? %b", new Object[] { paramString, Boolean.valueOf(bool) });
          paramInt1 = 0;
          paramString = (String)localObject;
          if (localObject == null)
          {
            paramInt1 = 1;
            paramString = new com.tencent.mm.plugin.freewifi.g.c();
            paramString.field_ssidmd5 = ai.ee(this.ssid);
          }
          paramString.field_wifiType = 1;
          localObject = (com.tencent.mm.protocal.protobuf.ad)this.rr.hNL.hNQ;
          localdej = ((com.tencent.mm.protocal.protobuf.ad)localObject).FqP;
          if (localdej == null) {
            break label470;
          }
          com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.FreeWifi.NetSceneAPAuth", "en : %s, cn : %s, tw : %s", new Object[] { localdej.HsK, localdej.HsL, localdej.HsM });
          paramString.field_showWordCn = localdej.HsL;
          paramString.field_showWordEn = localdej.HsK;
        }
        for (paramString.field_showWordTw = localdej.HsM;; paramString.field_showWordTw = aj.getContext().getResources().getString(2131759658))
        {
          paramString.field_action = ((com.tencent.mm.protocal.protobuf.ad)localObject).FqN;
          paramString.field_verifyResult = 1;
          paramString.field_connectState = -1;
          if (((com.tencent.mm.protocal.protobuf.ad)localObject).FqX <= 0) {
            ((com.tencent.mm.protocal.protobuf.ad)localObject).FqX = tnu;
          }
          paramString.field_expiredTime = (bt.aQJ() + ((com.tencent.mm.protocal.protobuf.ad)localObject).FqX);
          paramString.field_showUrl = ((com.tencent.mm.protocal.protobuf.ad)localObject).FqO;
          paramString.field_action = ((com.tencent.mm.protocal.protobuf.ad)localObject).FqN;
          paramString.field_ssid = this.ssid;
          paramString.field_mac = this.mac;
          paramString.field_wifiType = 1;
          if (paramInt1 == 0) {
            break label524;
          }
          bool = j.cRz().insert(paramString);
          com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.FreeWifi.NetSceneAPAuth", "insert freewifi ret = %b", new Object[] { Boolean.valueOf(bool) });
          com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.FreeWifi.NetSceneAPAuth", "insert local freewifi info : %s, %b, expiredTime : %d, action :%d, showurl : %s", new Object[] { this.ssid, Boolean.valueOf(bool), Integer.valueOf(((com.tencent.mm.protocal.protobuf.ad)localObject).FqM), Integer.valueOf(((com.tencent.mm.protocal.protobuf.ad)localObject).FqN), ((com.tencent.mm.protocal.protobuf.ad)localObject).FqO });
          AppMethodBeat.o(24843);
          return;
          bool = false;
          break;
          label470:
          paramString.field_showWordCn = aj.getContext().getResources().getString(2131759658);
          paramString.field_showWordEn = aj.getContext().getResources().getString(2131759658);
        }
        label524:
        boolean bool = j.cRz().update(paramString, new String[0]);
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.FreeWifi.NetSceneAPAuth", "update local freewifi info : %s, %b, expiredTime : %d, action :%d, showurl : %s", new Object[] { this.ssid, Boolean.valueOf(bool), Integer.valueOf(((com.tencent.mm.protocal.protobuf.ad)localObject).FqM), Integer.valueOf(((com.tencent.mm.protocal.protobuf.ad)localObject).FqN), ((com.tencent.mm.protocal.protobuf.ad)localObject).FqO });
        AppMethodBeat.o(24843);
        return;
        localObject = j.cRz().ajY(this.ssid);
        paramInt1 = 0;
        paramString = (String)localObject;
        if (localObject == null)
        {
          paramInt1 = 1;
          paramString = new com.tencent.mm.plugin.freewifi.g.c();
          paramString.field_ssidmd5 = ai.ee(this.ssid);
        }
        if ((paramInt2 == 0) && (paramInt3 == 0))
        {
          localObject = (com.tencent.mm.protocal.protobuf.ad)this.rr.hNL.hNQ;
          paramString.field_ssid = this.ssid;
          paramString.field_showUrl = ((com.tencent.mm.protocal.protobuf.ad)localObject).FqO;
          localdej = ((com.tencent.mm.protocal.protobuf.ad)localObject).FqP;
          com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.FreeWifi.NetSceneAPAuth", "get resp info : %s, expiredTime : %d, action :%d, showurl : %s", new Object[] { this.ssid, Integer.valueOf(((com.tencent.mm.protocal.protobuf.ad)localObject).FqM), Integer.valueOf(((com.tencent.mm.protocal.protobuf.ad)localObject).FqN), ((com.tencent.mm.protocal.protobuf.ad)localObject).FqO });
          if (localdej != null)
          {
            com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.FreeWifi.NetSceneAPAuth", "en : %s, cn : %s, tw : %s", new Object[] { localdej.HsK, localdej.HsL, localdej.HsM });
            paramString.field_showWordCn = localdej.HsL;
            paramString.field_showWordEn = localdej.HsK;
            paramString.field_showWordTw = localdej.HsM;
            paramString.field_action = ((com.tencent.mm.protocal.protobuf.ad)localObject).FqN;
            paramString.field_verifyResult = 1;
            paramString.field_connectState = -1;
            if (((com.tencent.mm.protocal.protobuf.ad)localObject).FqX <= 0) {
              ((com.tencent.mm.protocal.protobuf.ad)localObject).FqX = tnu;
            }
            paramString.field_expiredTime = (bt.aQJ() + ((com.tencent.mm.protocal.protobuf.ad)localObject).FqX);
            paramString.field_mac = this.mac;
            if (paramInt1 == 0) {
              break label979;
            }
            com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.FreeWifi.NetSceneAPAuth", "insert freewifi ret = %b", new Object[] { Boolean.valueOf(j.cRz().insert(paramString)) });
          }
          for (;;)
          {
            j.cRz().ajZ(this.ssid);
            AppMethodBeat.o(24843);
            return;
            paramString.field_showWordCn = aj.getContext().getResources().getString(2131759658);
            paramString.field_showWordEn = aj.getContext().getResources().getString(2131759658);
            paramString.field_showWordTw = aj.getContext().getResources().getString(2131759658);
            break;
            label979:
            com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.FreeWifi.NetSceneAPAuth", "insert freewifi ret = %b", new Object[] { Boolean.valueOf(j.cRz().update(paramString, new String[0])) });
          }
        }
        com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.FreeWifi.NetSceneAPAuth", "check this ap failed, ssid is :%s", new Object[] { this.ssid });
        if (paramInt1 == 0)
        {
          bool = j.cRz().delete(paramString, new String[0]);
          com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.FreeWifi.NetSceneAPAuth", "freewifi verify failed, delte local db infos : %s, ret = %b", new Object[] { this.ssid, Boolean.valueOf(bool) });
        }
      }
    }
  }
  
  protected final void cRG()
  {
    AppMethodBeat.i(24839);
    b.a locala = new b.a();
    locala.hNM = new ac();
    locala.hNN = new com.tencent.mm.protocal.protobuf.ad();
    locala.uri = "/cgi-bin/micromsg-bin/apauth";
    locala.funcId = 640;
    locala.hNO = 0;
    locala.respCmdId = 0;
    this.rr = locala.aDC();
    AppMethodBeat.o(24839);
  }
  
  public final String cRH()
  {
    com.tencent.mm.protocal.protobuf.ad localad = (com.tencent.mm.protocal.protobuf.ad)this.rr.hNL.hNQ;
    if (localad != null) {
      return localad.FqL;
    }
    return null;
  }
  
  public final cov cRI()
  {
    com.tencent.mm.protocal.protobuf.ad localad = (com.tencent.mm.protocal.protobuf.ad)this.rr.hNL.hNQ;
    if (localad != null) {
      return localad.FqS;
    }
    return null;
  }
  
  public final boolean cRJ()
  {
    com.tencent.mm.protocal.protobuf.ad localad = (com.tencent.mm.protocal.protobuf.ad)this.rr.hNL.hNQ;
    if ((localad != null) && (localad.FqT != null)) {
      return localad.FqT.FqJ == 1;
    }
    return false;
  }
  
  public final ats cRK()
  {
    com.tencent.mm.protocal.protobuf.ad localad = (com.tencent.mm.protocal.protobuf.ad)this.rr.hNL.hNQ;
    if (localad != null) {
      return localad.FqT;
    }
    return null;
  }
  
  public final hu cRL()
  {
    com.tencent.mm.protocal.protobuf.ad localad = (com.tencent.mm.protocal.protobuf.ad)this.rr.hNL.hNQ;
    if (localad != null) {
      return localad.FqU;
    }
    return null;
  }
  
  public final String getOpenId()
  {
    com.tencent.mm.protocal.protobuf.ad localad = (com.tencent.mm.protocal.protobuf.ad)this.rr.hNL.hNQ;
    if (localad != null) {
      return localad.FqV;
    }
    return null;
  }
  
  public final int getType()
  {
    return 640;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.freewifi.d.a
 * JD-Core Version:    0.7.0.1
 */