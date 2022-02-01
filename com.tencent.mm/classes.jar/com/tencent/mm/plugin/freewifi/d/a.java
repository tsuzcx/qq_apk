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
import com.tencent.mm.protocal.protobuf.amu;
import com.tencent.mm.protocal.protobuf.ces;
import com.tencent.mm.protocal.protobuf.ctl;
import com.tencent.mm.protocal.protobuf.dt;
import com.tencent.mm.protocal.protobuf.hj;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import java.net.URLDecoder;
import java.util.LinkedList;

public final class a
  extends c
{
  private static int rhZ = 7200;
  private int diR;
  private String mac;
  private String ssid;
  
  public a(String paramString1, int paramInt, String paramString2)
  {
    AppMethodBeat.i(24842);
    cwf();
    this.diR = 4;
    ac localac = (ac)this.rr.gUS.gUX;
    localac.OpCode = 4;
    localac.URL = paramString1;
    localac.Ctl = paramInt;
    localac.Ctm = paramString2;
    localac.Ctn = m.cvv();
    localac.Ctk = new LinkedList();
    paramString2 = new dt();
    paramString2.ssid = m.aau("MicroMsg.FreeWifi.NetSceneAPAuth");
    paramString2.mac = m.aav("MicroMsg.FreeWifi.NetSceneAPAuth");
    localac.Ctk.add(paramString2);
    localac.Cto = m.aaw("MicroMsg.FreeWifi.NetSceneAPAuth");
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.FreeWifi.NetSceneAPAuth", "Constructing get front page request, HasMobile=%d, Ap_info[0].ssid=%s, Ap_info[0].mac=%s", new Object[] { Integer.valueOf(localac.Ctn), paramString2.ssid, paramString2.mac });
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.FreeWifi.NetSceneAPAuth", "opCode = %d, url = %s", new Object[] { Integer.valueOf(4), paramString1 });
    AppMethodBeat.o(24842);
  }
  
  public a(String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, String paramString4)
  {
    AppMethodBeat.i(24841);
    cwf();
    this.ssid = paramString3;
    this.mac = paramString2;
    this.diR = 1;
    LinkedList localLinkedList = new LinkedList();
    Object localObject = new dt();
    ((dt)localObject).ssid = paramString3;
    ((dt)localObject).mac = paramString2;
    ((dt)localObject).fIi = paramInt1;
    localLinkedList.add(localObject);
    localObject = (ac)this.rr.gUS.gUX;
    ((ac)localObject).OpCode = 1;
    ((ac)localObject).Ctk = localLinkedList;
    ((ac)localObject).URL = paramString1;
    ((ac)localObject).Ctl = paramInt2;
    ((ac)localObject).Ctm = paramString4;
    ((ac)localObject).Cto = m.aaw("MicroMsg.FreeWifi.NetSceneAPAuth");
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.FreeWifi.NetSceneAPAuth", "opcode = %d, mac = %s, ssid = %s, rssi = %d", new Object[] { Integer.valueOf(1), paramString2, paramString3, Integer.valueOf(paramInt1) });
    AppMethodBeat.o(24841);
  }
  
  public a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, int paramInt, String paramString7)
  {
    AppMethodBeat.i(24840);
    cwf();
    this.ssid = paramString2;
    this.mac = paramString3;
    ac localac = (ac)this.rr.gUS.gUX;
    String str = URLDecoder.decode(paramString5);
    localac.OpCode = 0;
    localac.URL = paramString1;
    localac.SSID = paramString2;
    localac.Cth = paramString4;
    localac.Cti = str;
    localac.Ctj = paramString6;
    localac.Ctl = paramInt;
    localac.Ctm = paramString7;
    paramString7 = new LinkedList();
    dt localdt = new dt();
    localdt.ssid = paramString2;
    localdt.mac = paramString3;
    paramString7.add(localdt);
    localac.Ctk = paramString7;
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.FreeWifi.NetSceneAPAuth", "url : %s, ssid : %s, mid : %s, mac : %s, apauthdata : %s, decoded apauthdata :%s,  token : %s", new Object[] { paramString1, paramString2, paramString4, paramString3, paramString5, str, paramString6 });
    AppMethodBeat.o(24840);
  }
  
  public final String Rr()
  {
    com.tencent.mm.protocal.protobuf.ad localad = (com.tencent.mm.protocal.protobuf.ad)this.rr.gUT.gUX;
    if (localad != null) {
      return localad.CtA;
    }
    return null;
  }
  
  protected final void b(int paramInt1, int paramInt2, int paramInt3, String paramString)
  {
    AppMethodBeat.i(24843);
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.FreeWifi.NetSceneAPAuth", "onGYNetEnd : errType : %d, errCode : %d, errMsg : %s, opCode = %d", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString, Integer.valueOf(this.diR) });
    switch (this.diR)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(24843);
      return;
      if ((paramInt2 == 0) && (paramInt3 == 0))
      {
        Object localObject = j.cvY().aaI(this.ssid);
        paramString = this.ssid;
        ctl localctl;
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
            paramString.field_ssidmd5 = ai.du(this.ssid);
          }
          paramString.field_wifiType = 1;
          localObject = (com.tencent.mm.protocal.protobuf.ad)this.rr.gUT.gUX;
          localctl = ((com.tencent.mm.protocal.protobuf.ad)localObject).Ctt;
          if (localctl == null) {
            break label470;
          }
          com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.FreeWifi.NetSceneAPAuth", "en : %s, cn : %s, tw : %s", new Object[] { localctl.Ele, localctl.Elf, localctl.Elg });
          paramString.field_showWordCn = localctl.Elf;
          paramString.field_showWordEn = localctl.Ele;
        }
        for (paramString.field_showWordTw = localctl.Elg;; paramString.field_showWordTw = aj.getContext().getResources().getString(2131759658))
        {
          paramString.field_action = ((com.tencent.mm.protocal.protobuf.ad)localObject).Ctr;
          paramString.field_verifyResult = 1;
          paramString.field_connectState = -1;
          if (((com.tencent.mm.protocal.protobuf.ad)localObject).CtB <= 0) {
            ((com.tencent.mm.protocal.protobuf.ad)localObject).CtB = rhZ;
          }
          paramString.field_expiredTime = (bt.aGK() + ((com.tencent.mm.protocal.protobuf.ad)localObject).CtB);
          paramString.field_showUrl = ((com.tencent.mm.protocal.protobuf.ad)localObject).Cts;
          paramString.field_action = ((com.tencent.mm.protocal.protobuf.ad)localObject).Ctr;
          paramString.field_ssid = this.ssid;
          paramString.field_mac = this.mac;
          paramString.field_wifiType = 1;
          if (paramInt1 == 0) {
            break label524;
          }
          bool = j.cvY().insert(paramString);
          com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.FreeWifi.NetSceneAPAuth", "insert freewifi ret = %b", new Object[] { Boolean.valueOf(bool) });
          com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.FreeWifi.NetSceneAPAuth", "insert local freewifi info : %s, %b, expiredTime : %d, action :%d, showurl : %s", new Object[] { this.ssid, Boolean.valueOf(bool), Integer.valueOf(((com.tencent.mm.protocal.protobuf.ad)localObject).Ctq), Integer.valueOf(((com.tencent.mm.protocal.protobuf.ad)localObject).Ctr), ((com.tencent.mm.protocal.protobuf.ad)localObject).Cts });
          AppMethodBeat.o(24843);
          return;
          bool = false;
          break;
          label470:
          paramString.field_showWordCn = aj.getContext().getResources().getString(2131759658);
          paramString.field_showWordEn = aj.getContext().getResources().getString(2131759658);
        }
        label524:
        boolean bool = j.cvY().update(paramString, new String[0]);
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.FreeWifi.NetSceneAPAuth", "update local freewifi info : %s, %b, expiredTime : %d, action :%d, showurl : %s", new Object[] { this.ssid, Boolean.valueOf(bool), Integer.valueOf(((com.tencent.mm.protocal.protobuf.ad)localObject).Ctq), Integer.valueOf(((com.tencent.mm.protocal.protobuf.ad)localObject).Ctr), ((com.tencent.mm.protocal.protobuf.ad)localObject).Cts });
        AppMethodBeat.o(24843);
        return;
        localObject = j.cvY().aaI(this.ssid);
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
          localObject = (com.tencent.mm.protocal.protobuf.ad)this.rr.gUT.gUX;
          paramString.field_ssid = this.ssid;
          paramString.field_showUrl = ((com.tencent.mm.protocal.protobuf.ad)localObject).Cts;
          localctl = ((com.tencent.mm.protocal.protobuf.ad)localObject).Ctt;
          com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.FreeWifi.NetSceneAPAuth", "get resp info : %s, expiredTime : %d, action :%d, showurl : %s", new Object[] { this.ssid, Integer.valueOf(((com.tencent.mm.protocal.protobuf.ad)localObject).Ctq), Integer.valueOf(((com.tencent.mm.protocal.protobuf.ad)localObject).Ctr), ((com.tencent.mm.protocal.protobuf.ad)localObject).Cts });
          if (localctl != null)
          {
            com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.FreeWifi.NetSceneAPAuth", "en : %s, cn : %s, tw : %s", new Object[] { localctl.Ele, localctl.Elf, localctl.Elg });
            paramString.field_showWordCn = localctl.Elf;
            paramString.field_showWordEn = localctl.Ele;
            paramString.field_showWordTw = localctl.Elg;
            paramString.field_action = ((com.tencent.mm.protocal.protobuf.ad)localObject).Ctr;
            paramString.field_verifyResult = 1;
            paramString.field_connectState = -1;
            if (((com.tencent.mm.protocal.protobuf.ad)localObject).CtB <= 0) {
              ((com.tencent.mm.protocal.protobuf.ad)localObject).CtB = rhZ;
            }
            paramString.field_expiredTime = (bt.aGK() + ((com.tencent.mm.protocal.protobuf.ad)localObject).CtB);
            paramString.field_mac = this.mac;
            if (paramInt1 == 0) {
              break label979;
            }
            com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.FreeWifi.NetSceneAPAuth", "insert freewifi ret = %b", new Object[] { Boolean.valueOf(j.cvY().insert(paramString)) });
          }
          for (;;)
          {
            j.cvY().aaJ(this.ssid);
            AppMethodBeat.o(24843);
            return;
            paramString.field_showWordCn = aj.getContext().getResources().getString(2131759658);
            paramString.field_showWordEn = aj.getContext().getResources().getString(2131759658);
            paramString.field_showWordTw = aj.getContext().getResources().getString(2131759658);
            break;
            label979:
            com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.FreeWifi.NetSceneAPAuth", "insert freewifi ret = %b", new Object[] { Boolean.valueOf(j.cvY().update(paramString, new String[0])) });
          }
        }
        com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.FreeWifi.NetSceneAPAuth", "check this ap failed, ssid is :%s", new Object[] { this.ssid });
        if (paramInt1 == 0)
        {
          bool = j.cvY().delete(paramString, new String[0]);
          com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.FreeWifi.NetSceneAPAuth", "freewifi verify failed, delte local db infos : %s, ret = %b", new Object[] { this.ssid, Boolean.valueOf(bool) });
        }
      }
    }
  }
  
  protected final void cwf()
  {
    AppMethodBeat.i(24839);
    b.a locala = new b.a();
    locala.gUU = new ac();
    locala.gUV = new com.tencent.mm.protocal.protobuf.ad();
    locala.uri = "/cgi-bin/micromsg-bin/apauth";
    locala.funcId = 640;
    locala.reqCmdId = 0;
    locala.respCmdId = 0;
    this.rr = locala.atI();
    AppMethodBeat.o(24839);
  }
  
  public final String cwg()
  {
    com.tencent.mm.protocal.protobuf.ad localad = (com.tencent.mm.protocal.protobuf.ad)this.rr.gUT.gUX;
    if (localad != null) {
      return localad.Ctp;
    }
    return null;
  }
  
  public final ces cwh()
  {
    com.tencent.mm.protocal.protobuf.ad localad = (com.tencent.mm.protocal.protobuf.ad)this.rr.gUT.gUX;
    if (localad != null) {
      return localad.Ctw;
    }
    return null;
  }
  
  public final boolean cwi()
  {
    com.tencent.mm.protocal.protobuf.ad localad = (com.tencent.mm.protocal.protobuf.ad)this.rr.gUT.gUX;
    if ((localad != null) && (localad.Ctx != null)) {
      return localad.Ctx.Ctn == 1;
    }
    return false;
  }
  
  public final amu cwj()
  {
    com.tencent.mm.protocal.protobuf.ad localad = (com.tencent.mm.protocal.protobuf.ad)this.rr.gUT.gUX;
    if (localad != null) {
      return localad.Ctx;
    }
    return null;
  }
  
  public final hj cwk()
  {
    com.tencent.mm.protocal.protobuf.ad localad = (com.tencent.mm.protocal.protobuf.ad)this.rr.gUT.gUX;
    if (localad != null) {
      return localad.Cty;
    }
    return null;
  }
  
  public final String getOpenId()
  {
    com.tencent.mm.protocal.protobuf.ad localad = (com.tencent.mm.protocal.protobuf.ad)this.rr.gUT.gUX;
    if (localad != null) {
      return localad.Ctz;
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