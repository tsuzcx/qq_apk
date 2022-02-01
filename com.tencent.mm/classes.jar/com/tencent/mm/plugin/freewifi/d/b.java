package com.tencent.mm.plugin.freewifi.d;

import android.content.Context;
import android.content.res.Resources;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.plugin.freewifi.g.d;
import com.tencent.mm.plugin.freewifi.h;
import com.tencent.mm.plugin.freewifi.h.b;
import com.tencent.mm.plugin.freewifi.i;
import com.tencent.mm.plugin.freewifi.i.a;
import com.tencent.mm.plugin.freewifi.m;
import com.tencent.mm.plugin.freewifi.model.j;
import com.tencent.mm.protocal.protobuf.af;
import com.tencent.mm.protocal.protobuf.dfd;
import com.tencent.mm.protocal.protobuf.dw;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bu;
import java.util.LinkedList;

public final class b
  extends c
{
  private static int tym = 7200;
  public String mac;
  private String ssid;
  
  public b(String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(24845);
    cUl();
    this.ssid = paramString2;
    this.mac = paramString1;
    LinkedList localLinkedList = new LinkedList();
    Object localObject = new dw();
    ((dw)localObject).ssid = paramString2;
    ((dw)localObject).mac = paramString1;
    ((dw)localObject).ghG = paramInt1;
    localLinkedList.add(localObject);
    localObject = (com.tencent.mm.protocal.protobuf.ae)this.rr.hQD.hQJ;
    ((com.tencent.mm.protocal.protobuf.ae)localObject).FJw = h.b.cTu().cTp();
    ((com.tencent.mm.protocal.protobuf.ae)localObject).FJe = localLinkedList;
    ((com.tencent.mm.protocal.protobuf.ae)localObject).FJx = m.cTD();
    ((com.tencent.mm.protocal.protobuf.ae)localObject).FJy = paramInt2;
    com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.FreeWifi.NetSceneAPAuth", "new apcheck request. mac = %s, ssid = %s, rssi = %d", new Object[] { paramString1, paramString2, Integer.valueOf(paramInt1) });
    AppMethodBeat.o(24845);
  }
  
  protected final void b(int paramInt1, int paramInt2, int paramInt3, String paramString)
  {
    AppMethodBeat.i(24846);
    com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.FreeWifi.NetSceneAPAuth", "apcheck returns. onGYNetEnd : errType : %d, errCode : %d, errMsg : %s ", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    boolean bool;
    if ((this.rr != null) && (this.rr.hQE.hQJ != null))
    {
      h.b.cTu().a((af)this.rr.hQE.hQJ);
      if ((m.gc(paramInt2, paramInt3)) || (m.gd(paramInt2, paramInt3)))
      {
        paramString = (af)this.rr.hQE.hQJ;
        paramInt1 = paramString.FJB;
        bool = paramString.FJA;
        if ((paramInt1 != 0) && (paramInt1 != i.a.cTv().getInt("LOCAL_CONFIG_APCHECK_DELAY_CRD_EXPIRED_DAYS", 7))) {
          i.a.cTv().dF("LOCAL_CONFIG_APCHECK_DELAY_CRD_EXPIRED_DAYS", paramInt1);
        }
        if (bool) {
          i.a.cTv().at("LOCAL_CONFIG_LAST_APCHECK_SAVE_DELAY_CRD_TIMEMILLIS", System.currentTimeMillis());
        }
      }
    }
    Object localObject = j.cUe().akW(this.ssid);
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
      localObject = (af)this.rr.hQE.hQJ;
      paramString.field_ssid = this.ssid;
      paramString.field_showUrl = ((af)localObject).FJm;
      dfd localdfd = ((af)localObject).FJn;
      if (localdfd != null)
      {
        com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.FreeWifi.NetSceneAPAuth", "en : %s, cn : %s, tw : %s", new Object[] { localdfd.HMn, localdfd.HMo, localdfd.HMp });
        paramString.field_showWordCn = localdfd.HMo;
        paramString.field_showWordEn = localdfd.HMn;
        paramString.field_showWordTw = localdfd.HMp;
        paramString.field_action = ((af)localObject).FJl;
        paramString.field_verifyResult = 1;
        paramString.field_connectState = -1;
        if (((af)localObject).FJv <= 0) {
          ((af)localObject).FJv = tym;
        }
        paramString.field_expiredTime = (bu.aRi() + ((af)localObject).FJv);
        paramString.field_mac = this.mac;
        if (paramInt1 == 0) {
          break label490;
        }
        com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.FreeWifi.NetSceneAPAuth", "insert freewifi ret = %b", new Object[] { Boolean.valueOf(j.cUe().insert(paramString)) });
      }
      for (;;)
      {
        j.cUe().akX(this.ssid);
        AppMethodBeat.o(24846);
        return;
        paramString.field_showWordCn = ak.getContext().getResources().getString(2131759658);
        paramString.field_showWordEn = ak.getContext().getResources().getString(2131759658);
        paramString.field_showWordTw = ak.getContext().getResources().getString(2131759658);
        break;
        label490:
        com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.FreeWifi.NetSceneAPAuth", "insert freewifi ret = %b", new Object[] { Boolean.valueOf(j.cUe().update(paramString, new String[0])) });
      }
    }
    com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.FreeWifi.NetSceneAPAuth", "check this ap failed, ssid is :%s", new Object[] { this.ssid });
    if (paramInt1 == 0)
    {
      bool = j.cUe().delete(paramString, new String[0]);
      com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.FreeWifi.NetSceneAPAuth", "freewifi verify failed, delte local db infos : %s, ret = %b", new Object[] { this.ssid, Boolean.valueOf(bool) });
    }
    AppMethodBeat.o(24846);
  }
  
  protected final void cUl()
  {
    AppMethodBeat.i(24844);
    b.a locala = new b.a();
    locala.hQF = new com.tencent.mm.protocal.protobuf.ae();
    locala.hQG = new af();
    locala.uri = "/cgi-bin/mmo2o-bin/apcheck";
    locala.funcId = 1744;
    locala.hQH = 0;
    locala.respCmdId = 0;
    this.rr = locala.aDS();
    AppMethodBeat.o(24844);
  }
  
  public final int getType()
  {
    return 1744;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.freewifi.d.b
 * JD-Core Version:    0.7.0.1
 */