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
import com.tencent.mm.protocal.protobuf.apn;
import com.tencent.mm.protocal.protobuf.apo;
import com.tencent.mm.protocal.protobuf.ctl;
import com.tencent.mm.protocal.protobuf.dt;
import com.tencent.mm.protocal.protobuf.hj;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;

public final class f
  extends c
{
  private static int rhZ = 7200;
  private String mac;
  private String ssid;
  
  public f(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8)
  {
    AppMethodBeat.i(24855);
    cwf();
    this.ssid = paramString1;
    this.mac = paramString2;
    dt localdt = new dt();
    localdt.mac = paramString2;
    localdt.ssid = paramString1;
    paramString1 = (apn)this.rr.gUS.gUX;
    paramString1.appId = paramString3;
    paramString1.riy = paramString4;
    paramString1.riz = paramString5;
    paramString1.riA = paramString6;
    paramString1.cMo = paramString7;
    paramString1.sign = paramString8;
    paramString1.DqZ = localdt;
    AppMethodBeat.o(24855);
  }
  
  protected final void b(int paramInt1, int paramInt2, int paramInt3, String paramString)
  {
    AppMethodBeat.i(24856);
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
      localObject = (apo)this.rr.gUT.gUX;
      paramString.field_ssid = this.ssid;
      paramString.field_showUrl = ((apo)localObject).Cts;
      ctl localctl = ((apo)localObject).Ctt;
      if (localctl != null)
      {
        ad.i("MicroMsg.FreeWifi.NetSceneGetBackPageFor33", "en : %s, cn : %s, tw : %s", new Object[] { localctl.Ele, localctl.Elf, localctl.Elg });
        paramString.field_showWordCn = localctl.Elf;
        paramString.field_showWordEn = localctl.Ele;
        paramString.field_showWordTw = localctl.Elg;
        paramString.field_action = ((apo)localObject).Ctr;
        paramString.field_verifyResult = 1;
        paramString.field_connectState = -1;
        if (((apo)localObject).CtB <= 0) {
          ((apo)localObject).CtB = rhZ;
        }
        paramString.field_expiredTime = (bt.aGK() + ((apo)localObject).CtB);
        paramString.field_mac = this.mac;
        if (paramInt1 == 0) {
          break label330;
        }
        ad.i("MicroMsg.FreeWifi.NetSceneGetBackPageFor33", "insert freewifi ret = %b", new Object[] { Boolean.valueOf(j.cvY().insert(paramString)) });
      }
      for (;;)
      {
        j.cvY().aaJ(this.ssid);
        AppMethodBeat.o(24856);
        return;
        paramString.field_showWordCn = aj.getContext().getResources().getString(2131759658);
        paramString.field_showWordEn = aj.getContext().getResources().getString(2131759658);
        paramString.field_showWordTw = aj.getContext().getResources().getString(2131759658);
        break;
        label330:
        ad.i("MicroMsg.FreeWifi.NetSceneGetBackPageFor33", "insert freewifi ret = %b", new Object[] { Boolean.valueOf(j.cvY().update(paramString, new String[0])) });
      }
    }
    ad.e("MicroMsg.FreeWifi.NetSceneGetBackPageFor33", "check this ap failed, ssid is :%s", new Object[] { this.ssid });
    if (paramInt1 == 0)
    {
      boolean bool = j.cvY().delete(paramString, new String[0]);
      ad.i("MicroMsg.FreeWifi.NetSceneGetBackPageFor33", "freewifi verify failed, delte local db infos : %s, ret = %b", new Object[] { this.ssid, Boolean.valueOf(bool) });
    }
    AppMethodBeat.o(24856);
  }
  
  protected final void cwf()
  {
    AppMethodBeat.i(24854);
    b.a locala = new b.a();
    locala.gUU = new apn();
    locala.gUV = new apo();
    locala.uri = "/cgi-bin/mmo2o-bin/getbackpagefor33";
    locala.funcId = 1726;
    locala.reqCmdId = 0;
    locala.respCmdId = 0;
    this.rr = locala.atI();
    AppMethodBeat.o(24854);
  }
  
  public final hj cwk()
  {
    return ((apo)this.rr.gUT.gUX).rky;
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