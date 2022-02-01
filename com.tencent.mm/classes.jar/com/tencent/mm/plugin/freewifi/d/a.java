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
import com.tencent.mm.protocal.protobuf.ad;
import com.tencent.mm.protocal.protobuf.apy;
import com.tencent.mm.protocal.protobuf.cjv;
import com.tencent.mm.protocal.protobuf.cyw;
import com.tencent.mm.protocal.protobuf.dv;
import com.tencent.mm.protocal.protobuf.hn;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bs;
import java.net.URLDecoder;
import java.util.LinkedList;

public final class a
  extends c
{
  private static int sqS = 7200;
  private int dgm;
  private String mac;
  private String ssid;
  
  public a(String paramString1, int paramInt, String paramString2)
  {
    AppMethodBeat.i(24842);
    cJr();
    this.dgm = 4;
    com.tencent.mm.protocal.protobuf.ac localac = (com.tencent.mm.protocal.protobuf.ac)this.rr.hvr.hvw;
    localac.OpCode = 4;
    localac.URL = paramString1;
    localac.DLC = paramInt;
    localac.DLD = paramString2;
    localac.DLE = m.cIH();
    localac.DLB = new LinkedList();
    paramString2 = new dv();
    paramString2.ssid = m.afm("MicroMsg.FreeWifi.NetSceneAPAuth");
    paramString2.mac = m.afn("MicroMsg.FreeWifi.NetSceneAPAuth");
    localac.DLB.add(paramString2);
    localac.DLF = m.afo("MicroMsg.FreeWifi.NetSceneAPAuth");
    com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.FreeWifi.NetSceneAPAuth", "Constructing get front page request, HasMobile=%d, Ap_info[0].ssid=%s, Ap_info[0].mac=%s", new Object[] { Integer.valueOf(localac.DLE), paramString2.ssid, paramString2.mac });
    com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.FreeWifi.NetSceneAPAuth", "opCode = %d, url = %s", new Object[] { Integer.valueOf(4), paramString1 });
    AppMethodBeat.o(24842);
  }
  
  public a(String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, String paramString4)
  {
    AppMethodBeat.i(24841);
    cJr();
    this.ssid = paramString3;
    this.mac = paramString2;
    this.dgm = 1;
    LinkedList localLinkedList = new LinkedList();
    Object localObject = new dv();
    ((dv)localObject).ssid = paramString3;
    ((dv)localObject).mac = paramString2;
    ((dv)localObject).fLO = paramInt1;
    localLinkedList.add(localObject);
    localObject = (com.tencent.mm.protocal.protobuf.ac)this.rr.hvr.hvw;
    ((com.tencent.mm.protocal.protobuf.ac)localObject).OpCode = 1;
    ((com.tencent.mm.protocal.protobuf.ac)localObject).DLB = localLinkedList;
    ((com.tencent.mm.protocal.protobuf.ac)localObject).URL = paramString1;
    ((com.tencent.mm.protocal.protobuf.ac)localObject).DLC = paramInt2;
    ((com.tencent.mm.protocal.protobuf.ac)localObject).DLD = paramString4;
    ((com.tencent.mm.protocal.protobuf.ac)localObject).DLF = m.afo("MicroMsg.FreeWifi.NetSceneAPAuth");
    com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.FreeWifi.NetSceneAPAuth", "opcode = %d, mac = %s, ssid = %s, rssi = %d", new Object[] { Integer.valueOf(1), paramString2, paramString3, Integer.valueOf(paramInt1) });
    AppMethodBeat.o(24841);
  }
  
  public a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, int paramInt, String paramString7)
  {
    AppMethodBeat.i(24840);
    cJr();
    this.ssid = paramString2;
    this.mac = paramString3;
    com.tencent.mm.protocal.protobuf.ac localac = (com.tencent.mm.protocal.protobuf.ac)this.rr.hvr.hvw;
    String str = URLDecoder.decode(paramString5);
    localac.OpCode = 0;
    localac.URL = paramString1;
    localac.SSID = paramString2;
    localac.DLy = paramString4;
    localac.DLz = str;
    localac.DLA = paramString6;
    localac.DLC = paramInt;
    localac.DLD = paramString7;
    paramString7 = new LinkedList();
    dv localdv = new dv();
    localdv.ssid = paramString2;
    localdv.mac = paramString3;
    paramString7.add(localdv);
    localac.DLB = paramString7;
    com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.FreeWifi.NetSceneAPAuth", "url : %s, ssid : %s, mid : %s, mac : %s, apauthdata : %s, decoded apauthdata :%s,  token : %s", new Object[] { paramString1, paramString2, paramString4, paramString3, paramString5, str, paramString6 });
    AppMethodBeat.o(24840);
  }
  
  public final String RT()
  {
    ad localad = (ad)this.rr.hvs.hvw;
    if (localad != null) {
      return localad.DLR;
    }
    return null;
  }
  
  protected final void b(int paramInt1, int paramInt2, int paramInt3, String paramString)
  {
    AppMethodBeat.i(24843);
    com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.FreeWifi.NetSceneAPAuth", "onGYNetEnd : errType : %d, errCode : %d, errMsg : %s, opCode = %d", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString, Integer.valueOf(this.dgm) });
    switch (this.dgm)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(24843);
      return;
      if ((paramInt2 == 0) && (paramInt3 == 0))
      {
        Object localObject = j.cJk().afA(this.ssid);
        paramString = this.ssid;
        cyw localcyw;
        if (localObject == null)
        {
          bool = true;
          com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.FreeWifi.NetSceneAPAuth", "get freewifi by ssid :%s, is wifi info = null ? %b", new Object[] { paramString, Boolean.valueOf(bool) });
          paramInt1 = 0;
          paramString = (String)localObject;
          if (localObject == null)
          {
            paramInt1 = 1;
            paramString = new com.tencent.mm.plugin.freewifi.g.c();
            paramString.field_ssidmd5 = ah.dg(this.ssid);
          }
          paramString.field_wifiType = 1;
          localObject = (ad)this.rr.hvs.hvw;
          localcyw = ((ad)localObject).DLK;
          if (localcyw == null) {
            break label470;
          }
          com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.FreeWifi.NetSceneAPAuth", "en : %s, cn : %s, tw : %s", new Object[] { localcyw.FIc, localcyw.FId, localcyw.FIe });
          paramString.field_showWordCn = localcyw.FId;
          paramString.field_showWordEn = localcyw.FIc;
        }
        for (paramString.field_showWordTw = localcyw.FIe;; paramString.field_showWordTw = ai.getContext().getResources().getString(2131759658))
        {
          paramString.field_action = ((ad)localObject).DLI;
          paramString.field_verifyResult = 1;
          paramString.field_connectState = -1;
          if (((ad)localObject).DLS <= 0) {
            ((ad)localObject).DLS = sqS;
          }
          paramString.field_expiredTime = (bs.aNx() + ((ad)localObject).DLS);
          paramString.field_showUrl = ((ad)localObject).DLJ;
          paramString.field_action = ((ad)localObject).DLI;
          paramString.field_ssid = this.ssid;
          paramString.field_mac = this.mac;
          paramString.field_wifiType = 1;
          if (paramInt1 == 0) {
            break label524;
          }
          bool = j.cJk().insert(paramString);
          com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.FreeWifi.NetSceneAPAuth", "insert freewifi ret = %b", new Object[] { Boolean.valueOf(bool) });
          com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.FreeWifi.NetSceneAPAuth", "insert local freewifi info : %s, %b, expiredTime : %d, action :%d, showurl : %s", new Object[] { this.ssid, Boolean.valueOf(bool), Integer.valueOf(((ad)localObject).DLH), Integer.valueOf(((ad)localObject).DLI), ((ad)localObject).DLJ });
          AppMethodBeat.o(24843);
          return;
          bool = false;
          break;
          label470:
          paramString.field_showWordCn = ai.getContext().getResources().getString(2131759658);
          paramString.field_showWordEn = ai.getContext().getResources().getString(2131759658);
        }
        label524:
        boolean bool = j.cJk().update(paramString, new String[0]);
        com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.FreeWifi.NetSceneAPAuth", "update local freewifi info : %s, %b, expiredTime : %d, action :%d, showurl : %s", new Object[] { this.ssid, Boolean.valueOf(bool), Integer.valueOf(((ad)localObject).DLH), Integer.valueOf(((ad)localObject).DLI), ((ad)localObject).DLJ });
        AppMethodBeat.o(24843);
        return;
        localObject = j.cJk().afA(this.ssid);
        paramInt1 = 0;
        paramString = (String)localObject;
        if (localObject == null)
        {
          paramInt1 = 1;
          paramString = new com.tencent.mm.plugin.freewifi.g.c();
          paramString.field_ssidmd5 = ah.dg(this.ssid);
        }
        if ((paramInt2 == 0) && (paramInt3 == 0))
        {
          localObject = (ad)this.rr.hvs.hvw;
          paramString.field_ssid = this.ssid;
          paramString.field_showUrl = ((ad)localObject).DLJ;
          localcyw = ((ad)localObject).DLK;
          com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.FreeWifi.NetSceneAPAuth", "get resp info : %s, expiredTime : %d, action :%d, showurl : %s", new Object[] { this.ssid, Integer.valueOf(((ad)localObject).DLH), Integer.valueOf(((ad)localObject).DLI), ((ad)localObject).DLJ });
          if (localcyw != null)
          {
            com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.FreeWifi.NetSceneAPAuth", "en : %s, cn : %s, tw : %s", new Object[] { localcyw.FIc, localcyw.FId, localcyw.FIe });
            paramString.field_showWordCn = localcyw.FId;
            paramString.field_showWordEn = localcyw.FIc;
            paramString.field_showWordTw = localcyw.FIe;
            paramString.field_action = ((ad)localObject).DLI;
            paramString.field_verifyResult = 1;
            paramString.field_connectState = -1;
            if (((ad)localObject).DLS <= 0) {
              ((ad)localObject).DLS = sqS;
            }
            paramString.field_expiredTime = (bs.aNx() + ((ad)localObject).DLS);
            paramString.field_mac = this.mac;
            if (paramInt1 == 0) {
              break label979;
            }
            com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.FreeWifi.NetSceneAPAuth", "insert freewifi ret = %b", new Object[] { Boolean.valueOf(j.cJk().insert(paramString)) });
          }
          for (;;)
          {
            j.cJk().afB(this.ssid);
            AppMethodBeat.o(24843);
            return;
            paramString.field_showWordCn = ai.getContext().getResources().getString(2131759658);
            paramString.field_showWordEn = ai.getContext().getResources().getString(2131759658);
            paramString.field_showWordTw = ai.getContext().getResources().getString(2131759658);
            break;
            label979:
            com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.FreeWifi.NetSceneAPAuth", "insert freewifi ret = %b", new Object[] { Boolean.valueOf(j.cJk().update(paramString, new String[0])) });
          }
        }
        com.tencent.mm.sdk.platformtools.ac.e("MicroMsg.FreeWifi.NetSceneAPAuth", "check this ap failed, ssid is :%s", new Object[] { this.ssid });
        if (paramInt1 == 0)
        {
          bool = j.cJk().delete(paramString, new String[0]);
          com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.FreeWifi.NetSceneAPAuth", "freewifi verify failed, delte local db infos : %s, ret = %b", new Object[] { this.ssid, Boolean.valueOf(bool) });
        }
      }
    }
  }
  
  protected final void cJr()
  {
    AppMethodBeat.i(24839);
    b.a locala = new b.a();
    locala.hvt = new com.tencent.mm.protocal.protobuf.ac();
    locala.hvu = new ad();
    locala.uri = "/cgi-bin/micromsg-bin/apauth";
    locala.funcId = 640;
    locala.reqCmdId = 0;
    locala.respCmdId = 0;
    this.rr = locala.aAz();
    AppMethodBeat.o(24839);
  }
  
  public final String cJs()
  {
    ad localad = (ad)this.rr.hvs.hvw;
    if (localad != null) {
      return localad.DLG;
    }
    return null;
  }
  
  public final cjv cJt()
  {
    ad localad = (ad)this.rr.hvs.hvw;
    if (localad != null) {
      return localad.DLN;
    }
    return null;
  }
  
  public final boolean cJu()
  {
    ad localad = (ad)this.rr.hvs.hvw;
    if ((localad != null) && (localad.DLO != null)) {
      return localad.DLO.DLE == 1;
    }
    return false;
  }
  
  public final apy cJv()
  {
    ad localad = (ad)this.rr.hvs.hvw;
    if (localad != null) {
      return localad.DLO;
    }
    return null;
  }
  
  public final hn cJw()
  {
    ad localad = (ad)this.rr.hvs.hvw;
    if (localad != null) {
      return localad.DLP;
    }
    return null;
  }
  
  public final String getOpenId()
  {
    ad localad = (ad)this.rr.hvs.hvw;
    if (localad != null) {
      return localad.DLQ;
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