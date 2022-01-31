package com.tencent.mm.plugin.freewifi.d;

import android.content.Context;
import android.content.res.Resources;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.b.b;
import com.tencent.mm.ai.b.c;
import com.tencent.mm.plugin.freewifi.g.d;
import com.tencent.mm.plugin.freewifi.h;
import com.tencent.mm.plugin.freewifi.h.b;
import com.tencent.mm.plugin.freewifi.i;
import com.tencent.mm.plugin.freewifi.i.a;
import com.tencent.mm.plugin.freewifi.m;
import com.tencent.mm.plugin.freewifi.model.j;
import com.tencent.mm.protocal.protobuf.ac;
import com.tencent.mm.protocal.protobuf.ad;
import com.tencent.mm.protocal.protobuf.ccq;
import com.tencent.mm.protocal.protobuf.dh;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.LinkedList;

public final class b
  extends c
{
  private static int mKV = 7200;
  public String mac;
  private String ssid;
  
  public b(String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(20776);
    bAR();
    this.ssid = paramString2;
    this.mac = paramString1;
    LinkedList localLinkedList = new LinkedList();
    Object localObject = new dh();
    ((dh)localObject).ssid = paramString2;
    ((dh)localObject).mac = paramString1;
    ((dh)localObject).wpy = paramInt1;
    localLinkedList.add(localObject);
    localObject = (ac)this.rr.fsV.fta;
    ((ac)localObject).wlo = h.b.bAa().bzU();
    ((ac)localObject).wkW = localLinkedList;
    ((ac)localObject).wlp = m.bAj();
    ((ac)localObject).wlq = paramInt2;
    ab.i("MicroMsg.FreeWifi.NetSceneAPAuth", "new apcheck request. mac = %s, ssid = %s, rssi = %d", new Object[] { paramString1, paramString2, Integer.valueOf(paramInt1) });
    AppMethodBeat.o(20776);
  }
  
  protected final void b(int paramInt1, int paramInt2, int paramInt3, String paramString)
  {
    AppMethodBeat.i(20777);
    ab.i("MicroMsg.FreeWifi.NetSceneAPAuth", "apcheck returns. onGYNetEnd : errType : %d, errCode : %d, errMsg : %s ", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    boolean bool;
    if ((this.rr != null) && (this.rr.fsW.fta != null))
    {
      h.b.bAa().a((ad)this.rr.fsW.fta);
      if ((m.ep(paramInt2, paramInt3)) || (m.eq(paramInt2, paramInt3)))
      {
        paramString = (ad)this.rr.fsW.fta;
        paramInt1 = paramString.wlt;
        bool = paramString.wls;
        if ((paramInt1 != 0) && (paramInt1 != i.a.bAb().getInt("LOCAL_CONFIG_APCHECK_DELAY_CRD_EXPIRED_DAYS", 7))) {
          i.a.bAb().cl("LOCAL_CONFIG_APCHECK_DELAY_CRD_EXPIRED_DAYS", paramInt1);
        }
        if (bool) {
          i.a.bAb().V("LOCAL_CONFIG_LAST_APCHECK_SAVE_DELAY_CRD_TIMEMILLIS", System.currentTimeMillis());
        }
      }
    }
    Object localObject = j.bAK().OK(this.ssid);
    paramInt1 = 0;
    paramString = (String)localObject;
    if (localObject == null)
    {
      paramInt1 = 1;
      paramString = new com.tencent.mm.plugin.freewifi.g.c();
      paramString.field_ssidmd5 = ag.cE(this.ssid);
    }
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      localObject = (ad)this.rr.fsW.fta;
      paramString.field_ssid = this.ssid;
      paramString.field_showUrl = ((ad)localObject).wle;
      ccq localccq = ((ad)localObject).wlf;
      if (localccq != null)
      {
        ab.i("MicroMsg.FreeWifi.NetSceneAPAuth", "en : %s, cn : %s, tw : %s", new Object[] { localccq.xNe, localccq.xNf, localccq.xNg });
        paramString.field_showWordCn = localccq.xNf;
        paramString.field_showWordEn = localccq.xNe;
        paramString.field_showWordTw = localccq.xNg;
        paramString.field_action = ((ad)localObject).wld;
        paramString.field_verifyResult = 1;
        paramString.field_connectState = -1;
        if (((ad)localObject).wln <= 0) {
          ((ad)localObject).wln = mKV;
        }
        paramString.field_expiredTime = (bo.aox() + ((ad)localObject).wln);
        paramString.field_mac = this.mac;
        if (paramInt1 == 0) {
          break label490;
        }
        ab.i("MicroMsg.FreeWifi.NetSceneAPAuth", "insert freewifi ret = %b", new Object[] { Boolean.valueOf(j.bAK().insert(paramString)) });
      }
      for (;;)
      {
        j.bAK().OL(this.ssid);
        AppMethodBeat.o(20777);
        return;
        paramString.field_showWordCn = ah.getContext().getResources().getString(2131300186);
        paramString.field_showWordEn = ah.getContext().getResources().getString(2131300186);
        paramString.field_showWordTw = ah.getContext().getResources().getString(2131300186);
        break;
        label490:
        ab.i("MicroMsg.FreeWifi.NetSceneAPAuth", "insert freewifi ret = %b", new Object[] { Boolean.valueOf(j.bAK().update(paramString, new String[0])) });
      }
    }
    ab.e("MicroMsg.FreeWifi.NetSceneAPAuth", "check this ap failed, ssid is :%s", new Object[] { this.ssid });
    if (paramInt1 == 0)
    {
      bool = j.bAK().delete(paramString, new String[0]);
      ab.i("MicroMsg.FreeWifi.NetSceneAPAuth", "freewifi verify failed, delte local db infos : %s, ret = %b", new Object[] { this.ssid, Boolean.valueOf(bool) });
    }
    AppMethodBeat.o(20777);
  }
  
  protected final void bAR()
  {
    AppMethodBeat.i(20775);
    b.a locala = new b.a();
    locala.fsX = new ac();
    locala.fsY = new ad();
    locala.uri = "/cgi-bin/mmo2o-bin/apcheck";
    locala.funcId = 1744;
    locala.reqCmdId = 0;
    locala.respCmdId = 0;
    this.rr = locala.ado();
    AppMethodBeat.o(20775);
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