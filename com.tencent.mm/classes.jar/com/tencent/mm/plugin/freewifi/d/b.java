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
import com.tencent.mm.protocal.protobuf.dej;
import com.tencent.mm.protocal.protobuf.dw;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.LinkedList;

public final class b
  extends c
{
  private static int tnu = 7200;
  public String mac;
  private String ssid;
  
  public b(String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(24845);
    cRG();
    this.ssid = paramString2;
    this.mac = paramString1;
    LinkedList localLinkedList = new LinkedList();
    Object localObject = new dw();
    ((dw)localObject).ssid = paramString2;
    ((dw)localObject).mac = paramString1;
    ((dw)localObject).gfo = paramInt1;
    localLinkedList.add(localObject);
    localObject = (ae)this.rr.hNK.hNQ;
    ((ae)localObject).FqY = h.b.cQP().cQK();
    ((ae)localObject).FqG = localLinkedList;
    ((ae)localObject).FqZ = m.cQY();
    ((ae)localObject).Fra = paramInt2;
    ad.i("MicroMsg.FreeWifi.NetSceneAPAuth", "new apcheck request. mac = %s, ssid = %s, rssi = %d", new Object[] { paramString1, paramString2, Integer.valueOf(paramInt1) });
    AppMethodBeat.o(24845);
  }
  
  protected final void b(int paramInt1, int paramInt2, int paramInt3, String paramString)
  {
    AppMethodBeat.i(24846);
    ad.i("MicroMsg.FreeWifi.NetSceneAPAuth", "apcheck returns. onGYNetEnd : errType : %d, errCode : %d, errMsg : %s ", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    boolean bool;
    if ((this.rr != null) && (this.rr.hNL.hNQ != null))
    {
      h.b.cQP().a((af)this.rr.hNL.hNQ);
      if ((m.gc(paramInt2, paramInt3)) || (m.gd(paramInt2, paramInt3)))
      {
        paramString = (af)this.rr.hNL.hNQ;
        paramInt1 = paramString.Frd;
        bool = paramString.Frc;
        if ((paramInt1 != 0) && (paramInt1 != i.a.cQQ().getInt("LOCAL_CONFIG_APCHECK_DELAY_CRD_EXPIRED_DAYS", 7))) {
          i.a.cQQ().dB("LOCAL_CONFIG_APCHECK_DELAY_CRD_EXPIRED_DAYS", paramInt1);
        }
        if (bool) {
          i.a.cQQ().at("LOCAL_CONFIG_LAST_APCHECK_SAVE_DELAY_CRD_TIMEMILLIS", System.currentTimeMillis());
        }
      }
    }
    Object localObject = j.cRz().ajY(this.ssid);
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
      localObject = (af)this.rr.hNL.hNQ;
      paramString.field_ssid = this.ssid;
      paramString.field_showUrl = ((af)localObject).FqO;
      dej localdej = ((af)localObject).FqP;
      if (localdej != null)
      {
        ad.i("MicroMsg.FreeWifi.NetSceneAPAuth", "en : %s, cn : %s, tw : %s", new Object[] { localdej.HsK, localdej.HsL, localdej.HsM });
        paramString.field_showWordCn = localdej.HsL;
        paramString.field_showWordEn = localdej.HsK;
        paramString.field_showWordTw = localdej.HsM;
        paramString.field_action = ((af)localObject).FqN;
        paramString.field_verifyResult = 1;
        paramString.field_connectState = -1;
        if (((af)localObject).FqX <= 0) {
          ((af)localObject).FqX = tnu;
        }
        paramString.field_expiredTime = (bt.aQJ() + ((af)localObject).FqX);
        paramString.field_mac = this.mac;
        if (paramInt1 == 0) {
          break label490;
        }
        ad.i("MicroMsg.FreeWifi.NetSceneAPAuth", "insert freewifi ret = %b", new Object[] { Boolean.valueOf(j.cRz().insert(paramString)) });
      }
      for (;;)
      {
        j.cRz().ajZ(this.ssid);
        AppMethodBeat.o(24846);
        return;
        paramString.field_showWordCn = aj.getContext().getResources().getString(2131759658);
        paramString.field_showWordEn = aj.getContext().getResources().getString(2131759658);
        paramString.field_showWordTw = aj.getContext().getResources().getString(2131759658);
        break;
        label490:
        ad.i("MicroMsg.FreeWifi.NetSceneAPAuth", "insert freewifi ret = %b", new Object[] { Boolean.valueOf(j.cRz().update(paramString, new String[0])) });
      }
    }
    ad.e("MicroMsg.FreeWifi.NetSceneAPAuth", "check this ap failed, ssid is :%s", new Object[] { this.ssid });
    if (paramInt1 == 0)
    {
      bool = j.cRz().delete(paramString, new String[0]);
      ad.i("MicroMsg.FreeWifi.NetSceneAPAuth", "freewifi verify failed, delte local db infos : %s, ret = %b", new Object[] { this.ssid, Boolean.valueOf(bool) });
    }
    AppMethodBeat.o(24846);
  }
  
  protected final void cRG()
  {
    AppMethodBeat.i(24844);
    b.a locala = new b.a();
    locala.hNM = new ae();
    locala.hNN = new af();
    locala.uri = "/cgi-bin/mmo2o-bin/apcheck";
    locala.funcId = 1744;
    locala.hNO = 0;
    locala.respCmdId = 0;
    this.rr = locala.aDC();
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