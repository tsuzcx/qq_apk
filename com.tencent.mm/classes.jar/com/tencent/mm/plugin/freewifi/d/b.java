package com.tencent.mm.plugin.freewifi.d;

import android.content.Context;
import android.content.res.Resources;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.plugin.freewifi.g.d;
import com.tencent.mm.plugin.freewifi.h;
import com.tencent.mm.plugin.freewifi.h.b;
import com.tencent.mm.plugin.freewifi.i;
import com.tencent.mm.plugin.freewifi.i.a;
import com.tencent.mm.plugin.freewifi.m;
import com.tencent.mm.plugin.freewifi.model.j;
import com.tencent.mm.protocal.protobuf.ae;
import com.tencent.mm.protocal.protobuf.af;
import com.tencent.mm.protocal.protobuf.ctl;
import com.tencent.mm.protocal.protobuf.dt;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.LinkedList;

public final class b
  extends c
{
  private static int rhZ = 7200;
  public String mac;
  private String ssid;
  
  public b(String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(24845);
    cwf();
    this.ssid = paramString2;
    this.mac = paramString1;
    LinkedList localLinkedList = new LinkedList();
    Object localObject = new dt();
    ((dt)localObject).ssid = paramString2;
    ((dt)localObject).mac = paramString1;
    ((dt)localObject).fIi = paramInt1;
    localLinkedList.add(localObject);
    localObject = (ae)this.rr.gUS.gUX;
    ((ae)localObject).CtC = h.b.cvo().cvj();
    ((ae)localObject).Ctk = localLinkedList;
    ((ae)localObject).CtD = m.cvx();
    ((ae)localObject).CtE = paramInt2;
    ad.i("MicroMsg.FreeWifi.NetSceneAPAuth", "new apcheck request. mac = %s, ssid = %s, rssi = %d", new Object[] { paramString1, paramString2, Integer.valueOf(paramInt1) });
    AppMethodBeat.o(24845);
  }
  
  protected final void b(int paramInt1, int paramInt2, int paramInt3, String paramString)
  {
    AppMethodBeat.i(24846);
    ad.i("MicroMsg.FreeWifi.NetSceneAPAuth", "apcheck returns. onGYNetEnd : errType : %d, errCode : %d, errMsg : %s ", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    boolean bool;
    if ((this.rr != null) && (this.rr.gUT.gUX != null))
    {
      h.b.cvo().a((af)this.rr.gUT.gUX);
      if ((m.fF(paramInt2, paramInt3)) || (m.fG(paramInt2, paramInt3)))
      {
        paramString = (af)this.rr.gUT.gUX;
        paramInt1 = paramString.CtH;
        bool = paramString.CtG;
        if ((paramInt1 != 0) && (paramInt1 != i.a.cvp().getInt("LOCAL_CONFIG_APCHECK_DELAY_CRD_EXPIRED_DAYS", 7))) {
          i.a.cvp().df("LOCAL_CONFIG_APCHECK_DELAY_CRD_EXPIRED_DAYS", paramInt1);
        }
        if (bool) {
          i.a.cvp().ao("LOCAL_CONFIG_LAST_APCHECK_SAVE_DELAY_CRD_TIMEMILLIS", System.currentTimeMillis());
        }
      }
    }
    Object localObject = j.cvY().aaI(this.ssid);
    paramInt1 = 0;
    paramString = (String)localObject;
    if (localObject == null)
    {
      paramInt1 = 1;
      paramString = new com.tencent.mm.plugin.freewifi.g.c();
      paramString.field_ssidmd5 = ai.du(this.ssid);
    }
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      localObject = (af)this.rr.gUT.gUX;
      paramString.field_ssid = this.ssid;
      paramString.field_showUrl = ((af)localObject).Cts;
      ctl localctl = ((af)localObject).Ctt;
      if (localctl != null)
      {
        ad.i("MicroMsg.FreeWifi.NetSceneAPAuth", "en : %s, cn : %s, tw : %s", new Object[] { localctl.Ele, localctl.Elf, localctl.Elg });
        paramString.field_showWordCn = localctl.Elf;
        paramString.field_showWordEn = localctl.Ele;
        paramString.field_showWordTw = localctl.Elg;
        paramString.field_action = ((af)localObject).Ctr;
        paramString.field_verifyResult = 1;
        paramString.field_connectState = -1;
        if (((af)localObject).CtB <= 0) {
          ((af)localObject).CtB = rhZ;
        }
        paramString.field_expiredTime = (bt.aGK() + ((af)localObject).CtB);
        paramString.field_mac = this.mac;
        if (paramInt1 == 0) {
          break label490;
        }
        ad.i("MicroMsg.FreeWifi.NetSceneAPAuth", "insert freewifi ret = %b", new Object[] { Boolean.valueOf(j.cvY().insert(paramString)) });
      }
      for (;;)
      {
        j.cvY().aaJ(this.ssid);
        AppMethodBeat.o(24846);
        return;
        paramString.field_showWordCn = aj.getContext().getResources().getString(2131759658);
        paramString.field_showWordEn = aj.getContext().getResources().getString(2131759658);
        paramString.field_showWordTw = aj.getContext().getResources().getString(2131759658);
        break;
        label490:
        ad.i("MicroMsg.FreeWifi.NetSceneAPAuth", "insert freewifi ret = %b", new Object[] { Boolean.valueOf(j.cvY().update(paramString, new String[0])) });
      }
    }
    ad.e("MicroMsg.FreeWifi.NetSceneAPAuth", "check this ap failed, ssid is :%s", new Object[] { this.ssid });
    if (paramInt1 == 0)
    {
      bool = j.cvY().delete(paramString, new String[0]);
      ad.i("MicroMsg.FreeWifi.NetSceneAPAuth", "freewifi verify failed, delte local db infos : %s, ret = %b", new Object[] { this.ssid, Boolean.valueOf(bool) });
    }
    AppMethodBeat.o(24846);
  }
  
  protected final void cwf()
  {
    AppMethodBeat.i(24844);
    b.a locala = new b.a();
    locala.gUU = new ae();
    locala.gUV = new af();
    locala.uri = "/cgi-bin/mmo2o-bin/apcheck";
    locala.funcId = 1744;
    locala.reqCmdId = 0;
    locala.respCmdId = 0;
    this.rr = locala.atI();
    AppMethodBeat.o(24844);
  }
  
  public final int getType()
  {
    return 1744;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.freewifi.d.b
 * JD-Core Version:    0.7.0.1
 */