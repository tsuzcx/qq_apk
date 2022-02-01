package com.tencent.mm.plugin.freewifi.d;

import android.content.Context;
import android.content.res.Resources;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.d.b;
import com.tencent.mm.ak.d.c;
import com.tencent.mm.plugin.freewifi.h;
import com.tencent.mm.plugin.freewifi.h.b;
import com.tencent.mm.plugin.freewifi.i;
import com.tencent.mm.plugin.freewifi.i.a;
import com.tencent.mm.plugin.freewifi.m;
import com.tencent.mm.plugin.freewifi.model.j;
import com.tencent.mm.protocal.protobuf.ag;
import com.tencent.mm.protocal.protobuf.ah;
import com.tencent.mm.protocal.protobuf.dyj;
import com.tencent.mm.protocal.protobuf.ei;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MD5Util;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.LinkedList;

public final class b
  extends c
{
  private static int wPp = 7200;
  public String mac;
  private String ssid;
  
  public b(String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(24845);
    dNu();
    this.ssid = paramString2;
    this.mac = paramString1;
    LinkedList localLinkedList = new LinkedList();
    Object localObject = new ei();
    ((ei)localObject).ssid = paramString2;
    ((ei)localObject).mac = paramString1;
    ((ei)localObject).gNm = paramInt1;
    localLinkedList.add(localObject);
    localObject = (ag)this.rr.iLK.iLR;
    ((ag)localObject).KCO = h.b.dMD().dMy();
    ((ag)localObject).KCw = localLinkedList;
    ((ag)localObject).KCP = m.dMM();
    ((ag)localObject).KCQ = paramInt2;
    Log.i("MicroMsg.FreeWifi.NetSceneAPAuth", "new apcheck request. mac = %s, ssid = %s, rssi = %d", new Object[] { paramString1, paramString2, Integer.valueOf(paramInt1) });
    AppMethodBeat.o(24845);
  }
  
  protected final void a(int paramInt1, int paramInt2, int paramInt3, String paramString)
  {
    AppMethodBeat.i(24846);
    Log.i("MicroMsg.FreeWifi.NetSceneAPAuth", "apcheck returns. onGYNetEnd : errType : %d, errCode : %d, errMsg : %s ", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    boolean bool;
    if ((this.rr != null) && (this.rr.iLL.iLR != null))
    {
      h.b.dMD().a((ah)this.rr.iLL.iLR);
      if ((m.gB(paramInt2, paramInt3)) || (m.gC(paramInt2, paramInt3)))
      {
        paramString = (ah)this.rr.iLL.iLR;
        paramInt1 = paramString.KCT;
        bool = paramString.KCS;
        if ((paramInt1 != 0) && (paramInt1 != i.a.dME().getInt("LOCAL_CONFIG_APCHECK_DELAY_CRD_EXPIRED_DAYS", 7))) {
          i.a.dME().dU("LOCAL_CONFIG_APCHECK_DELAY_CRD_EXPIRED_DAYS", paramInt1);
        }
        if (bool) {
          i.a.dME().at("LOCAL_CONFIG_LAST_APCHECK_SAVE_DELAY_CRD_TIMEMILLIS", System.currentTimeMillis());
        }
      }
    }
    Object localObject = j.dNn().aya(this.ssid);
    paramInt1 = 0;
    paramString = (String)localObject;
    if (localObject == null)
    {
      paramInt1 = 1;
      paramString = new com.tencent.mm.plugin.freewifi.g.c();
      paramString.field_ssidmd5 = MD5Util.getMD5String(this.ssid);
    }
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      localObject = (ah)this.rr.iLL.iLR;
      paramString.field_ssid = this.ssid;
      paramString.field_showUrl = ((ah)localObject).KCE;
      dyj localdyj = ((ah)localObject).KCF;
      if (localdyj != null)
      {
        Log.i("MicroMsg.FreeWifi.NetSceneAPAuth", "en : %s, cn : %s, tw : %s", new Object[] { localdyj.MXX, localdyj.MXY, localdyj.MXZ });
        paramString.field_showWordCn = localdyj.MXY;
        paramString.field_showWordEn = localdyj.MXX;
        paramString.field_showWordTw = localdyj.MXZ;
        paramString.field_action = ((ah)localObject).KCD;
        paramString.field_verifyResult = 1;
        paramString.field_connectState = -1;
        if (((ah)localObject).KCN <= 0) {
          ((ah)localObject).KCN = wPp;
        }
        paramString.field_expiredTime = (Util.nowSecond() + ((ah)localObject).KCN);
        paramString.field_mac = this.mac;
        if (paramInt1 == 0) {
          break label490;
        }
        Log.i("MicroMsg.FreeWifi.NetSceneAPAuth", "insert freewifi ret = %b", new Object[] { Boolean.valueOf(j.dNn().insert(paramString)) });
      }
      for (;;)
      {
        j.dNn().ayb(this.ssid);
        AppMethodBeat.o(24846);
        return;
        paramString.field_showWordCn = MMApplicationContext.getContext().getResources().getString(2131760979);
        paramString.field_showWordEn = MMApplicationContext.getContext().getResources().getString(2131760979);
        paramString.field_showWordTw = MMApplicationContext.getContext().getResources().getString(2131760979);
        break;
        label490:
        Log.i("MicroMsg.FreeWifi.NetSceneAPAuth", "insert freewifi ret = %b", new Object[] { Boolean.valueOf(j.dNn().update(paramString, new String[0])) });
      }
    }
    Log.e("MicroMsg.FreeWifi.NetSceneAPAuth", "check this ap failed, ssid is :%s", new Object[] { this.ssid });
    if (paramInt1 == 0)
    {
      bool = j.dNn().delete(paramString, new String[0]);
      Log.i("MicroMsg.FreeWifi.NetSceneAPAuth", "freewifi verify failed, delte local db infos : %s, ret = %b", new Object[] { this.ssid, Boolean.valueOf(bool) });
    }
    AppMethodBeat.o(24846);
  }
  
  protected final void dNu()
  {
    AppMethodBeat.i(24844);
    d.a locala = new d.a();
    locala.iLN = new ag();
    locala.iLO = new ah();
    locala.uri = "/cgi-bin/mmo2o-bin/apcheck";
    locala.funcId = 1744;
    locala.iLP = 0;
    locala.respCmdId = 0;
    this.rr = locala.aXF();
    AppMethodBeat.o(24844);
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