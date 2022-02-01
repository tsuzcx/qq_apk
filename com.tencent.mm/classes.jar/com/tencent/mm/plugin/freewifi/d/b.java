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
import com.tencent.mm.protocal.protobuf.ae;
import com.tencent.mm.protocal.protobuf.af;
import com.tencent.mm.protocal.protobuf.cyw;
import com.tencent.mm.protocal.protobuf.dv;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bs;
import java.util.LinkedList;

public final class b
  extends c
{
  private static int sqS = 7200;
  public String mac;
  private String ssid;
  
  public b(String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(24845);
    cJr();
    this.ssid = paramString2;
    this.mac = paramString1;
    LinkedList localLinkedList = new LinkedList();
    Object localObject = new dv();
    ((dv)localObject).ssid = paramString2;
    ((dv)localObject).mac = paramString1;
    ((dv)localObject).fLO = paramInt1;
    localLinkedList.add(localObject);
    localObject = (ae)this.rr.hvr.hvw;
    ((ae)localObject).DLT = h.b.cIA().cIv();
    ((ae)localObject).DLB = localLinkedList;
    ((ae)localObject).DLU = m.cIJ();
    ((ae)localObject).DLV = paramInt2;
    ac.i("MicroMsg.FreeWifi.NetSceneAPAuth", "new apcheck request. mac = %s, ssid = %s, rssi = %d", new Object[] { paramString1, paramString2, Integer.valueOf(paramInt1) });
    AppMethodBeat.o(24845);
  }
  
  protected final void b(int paramInt1, int paramInt2, int paramInt3, String paramString)
  {
    AppMethodBeat.i(24846);
    ac.i("MicroMsg.FreeWifi.NetSceneAPAuth", "apcheck returns. onGYNetEnd : errType : %d, errCode : %d, errMsg : %s ", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    boolean bool;
    if ((this.rr != null) && (this.rr.hvs.hvw != null))
    {
      h.b.cIA().a((af)this.rr.hvs.hvw);
      if ((m.fM(paramInt2, paramInt3)) || (m.fN(paramInt2, paramInt3)))
      {
        paramString = (af)this.rr.hvs.hvw;
        paramInt1 = paramString.DLY;
        bool = paramString.DLX;
        if ((paramInt1 != 0) && (paramInt1 != i.a.cIB().getInt("LOCAL_CONFIG_APCHECK_DELAY_CRD_EXPIRED_DAYS", 7))) {
          i.a.cIB().dl("LOCAL_CONFIG_APCHECK_DELAY_CRD_EXPIRED_DAYS", paramInt1);
        }
        if (bool) {
          i.a.cIB().aq("LOCAL_CONFIG_LAST_APCHECK_SAVE_DELAY_CRD_TIMEMILLIS", System.currentTimeMillis());
        }
      }
    }
    Object localObject = j.cJk().afA(this.ssid);
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
      localObject = (af)this.rr.hvs.hvw;
      paramString.field_ssid = this.ssid;
      paramString.field_showUrl = ((af)localObject).DLJ;
      cyw localcyw = ((af)localObject).DLK;
      if (localcyw != null)
      {
        ac.i("MicroMsg.FreeWifi.NetSceneAPAuth", "en : %s, cn : %s, tw : %s", new Object[] { localcyw.FIc, localcyw.FId, localcyw.FIe });
        paramString.field_showWordCn = localcyw.FId;
        paramString.field_showWordEn = localcyw.FIc;
        paramString.field_showWordTw = localcyw.FIe;
        paramString.field_action = ((af)localObject).DLI;
        paramString.field_verifyResult = 1;
        paramString.field_connectState = -1;
        if (((af)localObject).DLS <= 0) {
          ((af)localObject).DLS = sqS;
        }
        paramString.field_expiredTime = (bs.aNx() + ((af)localObject).DLS);
        paramString.field_mac = this.mac;
        if (paramInt1 == 0) {
          break label490;
        }
        ac.i("MicroMsg.FreeWifi.NetSceneAPAuth", "insert freewifi ret = %b", new Object[] { Boolean.valueOf(j.cJk().insert(paramString)) });
      }
      for (;;)
      {
        j.cJk().afB(this.ssid);
        AppMethodBeat.o(24846);
        return;
        paramString.field_showWordCn = ai.getContext().getResources().getString(2131759658);
        paramString.field_showWordEn = ai.getContext().getResources().getString(2131759658);
        paramString.field_showWordTw = ai.getContext().getResources().getString(2131759658);
        break;
        label490:
        ac.i("MicroMsg.FreeWifi.NetSceneAPAuth", "insert freewifi ret = %b", new Object[] { Boolean.valueOf(j.cJk().update(paramString, new String[0])) });
      }
    }
    ac.e("MicroMsg.FreeWifi.NetSceneAPAuth", "check this ap failed, ssid is :%s", new Object[] { this.ssid });
    if (paramInt1 == 0)
    {
      bool = j.cJk().delete(paramString, new String[0]);
      ac.i("MicroMsg.FreeWifi.NetSceneAPAuth", "freewifi verify failed, delte local db infos : %s, ret = %b", new Object[] { this.ssid, Boolean.valueOf(bool) });
    }
    AppMethodBeat.o(24846);
  }
  
  protected final void cJr()
  {
    AppMethodBeat.i(24844);
    b.a locala = new b.a();
    locala.hvt = new ae();
    locala.hvu = new af();
    locala.uri = "/cgi-bin/mmo2o-bin/apcheck";
    locala.funcId = 1744;
    locala.reqCmdId = 0;
    locala.respCmdId = 0;
    this.rr = locala.aAz();
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