package com.tencent.mm.plugin.freewifi.d;

import android.content.Context;
import android.content.res.Resources;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.plugin.freewifi.g.d;
import com.tencent.mm.plugin.freewifi.model.j;
import com.tencent.mm.protocal.protobuf.awp;
import com.tencent.mm.protocal.protobuf.awq;
import com.tencent.mm.protocal.protobuf.dej;
import com.tencent.mm.protocal.protobuf.dw;
import com.tencent.mm.protocal.protobuf.hu;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;

public final class f
  extends c
{
  private static int tnu = 7200;
  private String mac;
  private String ssid;
  
  public f(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8)
  {
    AppMethodBeat.i(24855);
    cRG();
    this.ssid = paramString1;
    this.mac = paramString2;
    dw localdw = new dw();
    localdw.mac = paramString2;
    localdw.ssid = paramString1;
    paramString1 = (awp)this.rr.hNK.hNQ;
    paramString1.appId = paramString3;
    paramString1.tnS = paramString4;
    paramString1.tnT = paramString5;
    paramString1.tnU = paramString6;
    paramString1.cUM = paramString7;
    paramString1.sign = paramString8;
    paramString1.Gvf = localdw;
    AppMethodBeat.o(24855);
  }
  
  protected final void b(int paramInt1, int paramInt2, int paramInt3, String paramString)
  {
    AppMethodBeat.i(24856);
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
      localObject = (awq)this.rr.hNL.hNQ;
      paramString.field_ssid = this.ssid;
      paramString.field_showUrl = ((awq)localObject).FqO;
      dej localdej = ((awq)localObject).FqP;
      if (localdej != null)
      {
        ad.i("MicroMsg.FreeWifi.NetSceneGetBackPageFor33", "en : %s, cn : %s, tw : %s", new Object[] { localdej.HsK, localdej.HsL, localdej.HsM });
        paramString.field_showWordCn = localdej.HsL;
        paramString.field_showWordEn = localdej.HsK;
        paramString.field_showWordTw = localdej.HsM;
        paramString.field_action = ((awq)localObject).FqN;
        paramString.field_verifyResult = 1;
        paramString.field_connectState = -1;
        if (((awq)localObject).FqX <= 0) {
          ((awq)localObject).FqX = tnu;
        }
        paramString.field_expiredTime = (bt.aQJ() + ((awq)localObject).FqX);
        paramString.field_mac = this.mac;
        if (paramInt1 == 0) {
          break label330;
        }
        ad.i("MicroMsg.FreeWifi.NetSceneGetBackPageFor33", "insert freewifi ret = %b", new Object[] { Boolean.valueOf(j.cRz().insert(paramString)) });
      }
      for (;;)
      {
        j.cRz().ajZ(this.ssid);
        AppMethodBeat.o(24856);
        return;
        paramString.field_showWordCn = aj.getContext().getResources().getString(2131759658);
        paramString.field_showWordEn = aj.getContext().getResources().getString(2131759658);
        paramString.field_showWordTw = aj.getContext().getResources().getString(2131759658);
        break;
        label330:
        ad.i("MicroMsg.FreeWifi.NetSceneGetBackPageFor33", "insert freewifi ret = %b", new Object[] { Boolean.valueOf(j.cRz().update(paramString, new String[0])) });
      }
    }
    ad.e("MicroMsg.FreeWifi.NetSceneGetBackPageFor33", "check this ap failed, ssid is :%s", new Object[] { this.ssid });
    if (paramInt1 == 0)
    {
      boolean bool = j.cRz().delete(paramString, new String[0]);
      ad.i("MicroMsg.FreeWifi.NetSceneGetBackPageFor33", "freewifi verify failed, delte local db infos : %s, ret = %b", new Object[] { this.ssid, Boolean.valueOf(bool) });
    }
    AppMethodBeat.o(24856);
  }
  
  protected final void cRG()
  {
    AppMethodBeat.i(24854);
    b.a locala = new b.a();
    locala.hNM = new awp();
    locala.hNN = new awq();
    locala.uri = "/cgi-bin/mmo2o-bin/getbackpagefor33";
    locala.funcId = 1726;
    locala.hNO = 0;
    locala.respCmdId = 0;
    this.rr = locala.aDC();
    AppMethodBeat.o(24854);
  }
  
  public final hu cRL()
  {
    return ((awq)this.rr.hNL.hNQ).tpT;
  }
  
  public final int getType()
  {
    return 1726;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.freewifi.d.f
 * JD-Core Version:    0.7.0.1
 */