package com.tencent.mm.plugin.freewifi.d;

import android.content.Context;
import android.content.res.Resources;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.b.b;
import com.tencent.mm.ai.b.c;
import com.tencent.mm.plugin.freewifi.g.d;
import com.tencent.mm.plugin.freewifi.m;
import com.tencent.mm.plugin.freewifi.model.j;
import com.tencent.mm.protocal.protobuf.aa;
import com.tencent.mm.protocal.protobuf.aeg;
import com.tencent.mm.protocal.protobuf.bpx;
import com.tencent.mm.protocal.protobuf.ccq;
import com.tencent.mm.protocal.protobuf.dh;
import com.tencent.mm.protocal.protobuf.gm;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import java.net.URLDecoder;
import java.util.LinkedList;

public final class a
  extends c
{
  private static int mKV = 7200;
  private int ctW;
  private String mac;
  private String ssid;
  
  public a(String paramString1, int paramInt, String paramString2)
  {
    AppMethodBeat.i(20773);
    bAR();
    this.ctW = 4;
    aa localaa = (aa)this.rr.fsV.fta;
    localaa.OpCode = 4;
    localaa.URL = paramString1;
    localaa.wkX = paramInt;
    localaa.wkY = paramString2;
    localaa.wkZ = m.bAh();
    localaa.wkW = new LinkedList();
    paramString2 = new dh();
    paramString2.ssid = m.Ow("MicroMsg.FreeWifi.NetSceneAPAuth");
    paramString2.mac = m.Ox("MicroMsg.FreeWifi.NetSceneAPAuth");
    localaa.wkW.add(paramString2);
    localaa.wla = m.Oy("MicroMsg.FreeWifi.NetSceneAPAuth");
    com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.FreeWifi.NetSceneAPAuth", "Constructing get front page request, HasMobile=%d, Ap_info[0].ssid=%s, Ap_info[0].mac=%s", new Object[] { Integer.valueOf(localaa.wkZ), paramString2.ssid, paramString2.mac });
    com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.FreeWifi.NetSceneAPAuth", "opCode = %d, url = %s", new Object[] { Integer.valueOf(4), paramString1 });
    AppMethodBeat.o(20773);
  }
  
  public a(String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, String paramString4)
  {
    AppMethodBeat.i(20772);
    bAR();
    this.ssid = paramString3;
    this.mac = paramString2;
    this.ctW = 1;
    LinkedList localLinkedList = new LinkedList();
    Object localObject = new dh();
    ((dh)localObject).ssid = paramString3;
    ((dh)localObject).mac = paramString2;
    ((dh)localObject).wpy = paramInt1;
    localLinkedList.add(localObject);
    localObject = (aa)this.rr.fsV.fta;
    ((aa)localObject).OpCode = 1;
    ((aa)localObject).wkW = localLinkedList;
    ((aa)localObject).URL = paramString1;
    ((aa)localObject).wkX = paramInt2;
    ((aa)localObject).wkY = paramString4;
    ((aa)localObject).wla = m.Oy("MicroMsg.FreeWifi.NetSceneAPAuth");
    com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.FreeWifi.NetSceneAPAuth", "opcode = %d, mac = %s, ssid = %s, rssi = %d", new Object[] { Integer.valueOf(1), paramString2, paramString3, Integer.valueOf(paramInt1) });
    AppMethodBeat.o(20772);
  }
  
  public a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, int paramInt, String paramString7)
  {
    AppMethodBeat.i(20771);
    bAR();
    this.ssid = paramString2;
    this.mac = paramString3;
    aa localaa = (aa)this.rr.fsV.fta;
    String str = URLDecoder.decode(paramString5);
    localaa.OpCode = 0;
    localaa.URL = paramString1;
    localaa.SSID = paramString2;
    localaa.wkT = paramString4;
    localaa.wkU = str;
    localaa.wkV = paramString6;
    localaa.wkX = paramInt;
    localaa.wkY = paramString7;
    paramString7 = new LinkedList();
    dh localdh = new dh();
    localdh.ssid = paramString2;
    localdh.mac = paramString3;
    paramString7.add(localdh);
    localaa.wkW = paramString7;
    com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.FreeWifi.NetSceneAPAuth", "url : %s, ssid : %s, mid : %s, mac : %s, apauthdata : %s, decoded apauthdata :%s,  token : %s", new Object[] { paramString1, paramString2, paramString4, paramString3, paramString5, str, paramString6 });
    AppMethodBeat.o(20771);
  }
  
  public final String Ge()
  {
    com.tencent.mm.protocal.protobuf.ab localab = (com.tencent.mm.protocal.protobuf.ab)this.rr.fsW.fta;
    if (localab != null) {
      return localab.wlm;
    }
    return null;
  }
  
  protected final void b(int paramInt1, int paramInt2, int paramInt3, String paramString)
  {
    AppMethodBeat.i(20774);
    com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.FreeWifi.NetSceneAPAuth", "onGYNetEnd : errType : %d, errCode : %d, errMsg : %s, opCode = %d", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString, Integer.valueOf(this.ctW) });
    switch (this.ctW)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(20774);
      return;
      if ((paramInt2 == 0) && (paramInt3 == 0))
      {
        Object localObject = j.bAK().OK(this.ssid);
        paramString = this.ssid;
        ccq localccq;
        if (localObject == null)
        {
          bool = true;
          com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.FreeWifi.NetSceneAPAuth", "get freewifi by ssid :%s, is wifi info = null ? %b", new Object[] { paramString, Boolean.valueOf(bool) });
          paramInt1 = 0;
          paramString = (String)localObject;
          if (localObject == null)
          {
            paramInt1 = 1;
            paramString = new com.tencent.mm.plugin.freewifi.g.c();
            paramString.field_ssidmd5 = ag.cE(this.ssid);
          }
          paramString.field_wifiType = 1;
          localObject = (com.tencent.mm.protocal.protobuf.ab)this.rr.fsW.fta;
          localccq = ((com.tencent.mm.protocal.protobuf.ab)localObject).wlf;
          if (localccq == null) {
            break label470;
          }
          com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.FreeWifi.NetSceneAPAuth", "en : %s, cn : %s, tw : %s", new Object[] { localccq.xNe, localccq.xNf, localccq.xNg });
          paramString.field_showWordCn = localccq.xNf;
          paramString.field_showWordEn = localccq.xNe;
        }
        for (paramString.field_showWordTw = localccq.xNg;; paramString.field_showWordTw = ah.getContext().getResources().getString(2131300186))
        {
          paramString.field_action = ((com.tencent.mm.protocal.protobuf.ab)localObject).wld;
          paramString.field_verifyResult = 1;
          paramString.field_connectState = -1;
          if (((com.tencent.mm.protocal.protobuf.ab)localObject).wln <= 0) {
            ((com.tencent.mm.protocal.protobuf.ab)localObject).wln = mKV;
          }
          paramString.field_expiredTime = (bo.aox() + ((com.tencent.mm.protocal.protobuf.ab)localObject).wln);
          paramString.field_showUrl = ((com.tencent.mm.protocal.protobuf.ab)localObject).wle;
          paramString.field_action = ((com.tencent.mm.protocal.protobuf.ab)localObject).wld;
          paramString.field_ssid = this.ssid;
          paramString.field_mac = this.mac;
          paramString.field_wifiType = 1;
          if (paramInt1 == 0) {
            break label524;
          }
          bool = j.bAK().insert(paramString);
          com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.FreeWifi.NetSceneAPAuth", "insert freewifi ret = %b", new Object[] { Boolean.valueOf(bool) });
          com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.FreeWifi.NetSceneAPAuth", "insert local freewifi info : %s, %b, expiredTime : %d, action :%d, showurl : %s", new Object[] { this.ssid, Boolean.valueOf(bool), Integer.valueOf(((com.tencent.mm.protocal.protobuf.ab)localObject).wlc), Integer.valueOf(((com.tencent.mm.protocal.protobuf.ab)localObject).wld), ((com.tencent.mm.protocal.protobuf.ab)localObject).wle });
          AppMethodBeat.o(20774);
          return;
          bool = false;
          break;
          label470:
          paramString.field_showWordCn = ah.getContext().getResources().getString(2131300186);
          paramString.field_showWordEn = ah.getContext().getResources().getString(2131300186);
        }
        label524:
        boolean bool = j.bAK().update(paramString, new String[0]);
        com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.FreeWifi.NetSceneAPAuth", "update local freewifi info : %s, %b, expiredTime : %d, action :%d, showurl : %s", new Object[] { this.ssid, Boolean.valueOf(bool), Integer.valueOf(((com.tencent.mm.protocal.protobuf.ab)localObject).wlc), Integer.valueOf(((com.tencent.mm.protocal.protobuf.ab)localObject).wld), ((com.tencent.mm.protocal.protobuf.ab)localObject).wle });
        AppMethodBeat.o(20774);
        return;
        localObject = j.bAK().OK(this.ssid);
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
          localObject = (com.tencent.mm.protocal.protobuf.ab)this.rr.fsW.fta;
          paramString.field_ssid = this.ssid;
          paramString.field_showUrl = ((com.tencent.mm.protocal.protobuf.ab)localObject).wle;
          localccq = ((com.tencent.mm.protocal.protobuf.ab)localObject).wlf;
          com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.FreeWifi.NetSceneAPAuth", "get resp info : %s, expiredTime : %d, action :%d, showurl : %s", new Object[] { this.ssid, Integer.valueOf(((com.tencent.mm.protocal.protobuf.ab)localObject).wlc), Integer.valueOf(((com.tencent.mm.protocal.protobuf.ab)localObject).wld), ((com.tencent.mm.protocal.protobuf.ab)localObject).wle });
          if (localccq != null)
          {
            com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.FreeWifi.NetSceneAPAuth", "en : %s, cn : %s, tw : %s", new Object[] { localccq.xNe, localccq.xNf, localccq.xNg });
            paramString.field_showWordCn = localccq.xNf;
            paramString.field_showWordEn = localccq.xNe;
            paramString.field_showWordTw = localccq.xNg;
            paramString.field_action = ((com.tencent.mm.protocal.protobuf.ab)localObject).wld;
            paramString.field_verifyResult = 1;
            paramString.field_connectState = -1;
            if (((com.tencent.mm.protocal.protobuf.ab)localObject).wln <= 0) {
              ((com.tencent.mm.protocal.protobuf.ab)localObject).wln = mKV;
            }
            paramString.field_expiredTime = (bo.aox() + ((com.tencent.mm.protocal.protobuf.ab)localObject).wln);
            paramString.field_mac = this.mac;
            if (paramInt1 == 0) {
              break label979;
            }
            com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.FreeWifi.NetSceneAPAuth", "insert freewifi ret = %b", new Object[] { Boolean.valueOf(j.bAK().insert(paramString)) });
          }
          for (;;)
          {
            j.bAK().OL(this.ssid);
            AppMethodBeat.o(20774);
            return;
            paramString.field_showWordCn = ah.getContext().getResources().getString(2131300186);
            paramString.field_showWordEn = ah.getContext().getResources().getString(2131300186);
            paramString.field_showWordTw = ah.getContext().getResources().getString(2131300186);
            break;
            label979:
            com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.FreeWifi.NetSceneAPAuth", "insert freewifi ret = %b", new Object[] { Boolean.valueOf(j.bAK().update(paramString, new String[0])) });
          }
        }
        com.tencent.mm.sdk.platformtools.ab.e("MicroMsg.FreeWifi.NetSceneAPAuth", "check this ap failed, ssid is :%s", new Object[] { this.ssid });
        if (paramInt1 == 0)
        {
          bool = j.bAK().delete(paramString, new String[0]);
          com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.FreeWifi.NetSceneAPAuth", "freewifi verify failed, delte local db infos : %s, ret = %b", new Object[] { this.ssid, Boolean.valueOf(bool) });
        }
      }
    }
  }
  
  protected final void bAR()
  {
    AppMethodBeat.i(20770);
    b.a locala = new b.a();
    locala.fsX = new aa();
    locala.fsY = new com.tencent.mm.protocal.protobuf.ab();
    locala.uri = "/cgi-bin/micromsg-bin/apauth";
    locala.funcId = 640;
    locala.reqCmdId = 0;
    locala.respCmdId = 0;
    this.rr = locala.ado();
    AppMethodBeat.o(20770);
  }
  
  public final String bAS()
  {
    com.tencent.mm.protocal.protobuf.ab localab = (com.tencent.mm.protocal.protobuf.ab)this.rr.fsW.fta;
    if (localab != null) {
      return localab.wlb;
    }
    return null;
  }
  
  public final bpx bAT()
  {
    com.tencent.mm.protocal.protobuf.ab localab = (com.tencent.mm.protocal.protobuf.ab)this.rr.fsW.fta;
    if (localab != null) {
      return localab.wli;
    }
    return null;
  }
  
  public final boolean bAU()
  {
    com.tencent.mm.protocal.protobuf.ab localab = (com.tencent.mm.protocal.protobuf.ab)this.rr.fsW.fta;
    if ((localab != null) && (localab.wlj != null)) {
      return localab.wlj.wkZ == 1;
    }
    return false;
  }
  
  public final aeg bAV()
  {
    com.tencent.mm.protocal.protobuf.ab localab = (com.tencent.mm.protocal.protobuf.ab)this.rr.fsW.fta;
    if (localab != null) {
      return localab.wlj;
    }
    return null;
  }
  
  public final gm bAW()
  {
    com.tencent.mm.protocal.protobuf.ab localab = (com.tencent.mm.protocal.protobuf.ab)this.rr.fsW.fta;
    if (localab != null) {
      return localab.wlk;
    }
    return null;
  }
  
  public final String getOpenId()
  {
    com.tencent.mm.protocal.protobuf.ab localab = (com.tencent.mm.protocal.protobuf.ab)this.rr.fsW.fta;
    if (localab != null) {
      return localab.wll;
    }
    return null;
  }
  
  public final int getType()
  {
    return 640;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.freewifi.d.a
 * JD-Core Version:    0.7.0.1
 */