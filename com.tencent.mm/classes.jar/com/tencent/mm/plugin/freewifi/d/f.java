package com.tencent.mm.plugin.freewifi.d;

import android.content.Context;
import android.content.res.Resources;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.plugin.freewifi.g.d;
import com.tencent.mm.plugin.freewifi.model.j;
import com.tencent.mm.protocal.protobuf.axf;
import com.tencent.mm.protocal.protobuf.axg;
import com.tencent.mm.protocal.protobuf.dfd;
import com.tencent.mm.protocal.protobuf.dw;
import com.tencent.mm.protocal.protobuf.hu;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bu;

public final class f
  extends c
{
  private static int tym = 7200;
  private String mac;
  private String ssid;
  
  public f(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8)
  {
    AppMethodBeat.i(24855);
    cUl();
    this.ssid = paramString1;
    this.mac = paramString2;
    dw localdw = new dw();
    localdw.mac = paramString2;
    localdw.ssid = paramString1;
    paramString1 = (axf)this.rr.hQD.hQJ;
    paramString1.appId = paramString3;
    paramString1.tyK = paramString4;
    paramString1.tyL = paramString5;
    paramString1.tyM = paramString6;
    paramString1.cVJ = paramString7;
    paramString1.sign = paramString8;
    paramString1.GOE = localdw;
    AppMethodBeat.o(24855);
  }
  
  protected final void b(int paramInt1, int paramInt2, int paramInt3, String paramString)
  {
    AppMethodBeat.i(24856);
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
      localObject = (axg)this.rr.hQE.hQJ;
      paramString.field_ssid = this.ssid;
      paramString.field_showUrl = ((axg)localObject).FJm;
      dfd localdfd = ((axg)localObject).FJn;
      if (localdfd != null)
      {
        ae.i("MicroMsg.FreeWifi.NetSceneGetBackPageFor33", "en : %s, cn : %s, tw : %s", new Object[] { localdfd.HMn, localdfd.HMo, localdfd.HMp });
        paramString.field_showWordCn = localdfd.HMo;
        paramString.field_showWordEn = localdfd.HMn;
        paramString.field_showWordTw = localdfd.HMp;
        paramString.field_action = ((axg)localObject).FJl;
        paramString.field_verifyResult = 1;
        paramString.field_connectState = -1;
        if (((axg)localObject).FJv <= 0) {
          ((axg)localObject).FJv = tym;
        }
        paramString.field_expiredTime = (bu.aRi() + ((axg)localObject).FJv);
        paramString.field_mac = this.mac;
        if (paramInt1 == 0) {
          break label330;
        }
        ae.i("MicroMsg.FreeWifi.NetSceneGetBackPageFor33", "insert freewifi ret = %b", new Object[] { Boolean.valueOf(j.cUe().insert(paramString)) });
      }
      for (;;)
      {
        j.cUe().akX(this.ssid);
        AppMethodBeat.o(24856);
        return;
        paramString.field_showWordCn = ak.getContext().getResources().getString(2131759658);
        paramString.field_showWordEn = ak.getContext().getResources().getString(2131759658);
        paramString.field_showWordTw = ak.getContext().getResources().getString(2131759658);
        break;
        label330:
        ae.i("MicroMsg.FreeWifi.NetSceneGetBackPageFor33", "insert freewifi ret = %b", new Object[] { Boolean.valueOf(j.cUe().update(paramString, new String[0])) });
      }
    }
    ae.e("MicroMsg.FreeWifi.NetSceneGetBackPageFor33", "check this ap failed, ssid is :%s", new Object[] { this.ssid });
    if (paramInt1 == 0)
    {
      boolean bool = j.cUe().delete(paramString, new String[0]);
      ae.i("MicroMsg.FreeWifi.NetSceneGetBackPageFor33", "freewifi verify failed, delte local db infos : %s, ret = %b", new Object[] { this.ssid, Boolean.valueOf(bool) });
    }
    AppMethodBeat.o(24856);
  }
  
  protected final void cUl()
  {
    AppMethodBeat.i(24854);
    b.a locala = new b.a();
    locala.hQF = new axf();
    locala.hQG = new axg();
    locala.uri = "/cgi-bin/mmo2o-bin/getbackpagefor33";
    locala.funcId = 1726;
    locala.hQH = 0;
    locala.respCmdId = 0;
    this.rr = locala.aDS();
    AppMethodBeat.o(24854);
  }
  
  public final hu cUq()
  {
    return ((axg)this.rr.hQE.hQJ).tAK;
  }
  
  public final int getType()
  {
    return 1726;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.freewifi.d.f
 * JD-Core Version:    0.7.0.1
 */