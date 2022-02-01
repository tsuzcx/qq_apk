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
import com.tencent.mm.protocal.protobuf.asr;
import com.tencent.mm.protocal.protobuf.ass;
import com.tencent.mm.protocal.protobuf.cyw;
import com.tencent.mm.protocal.protobuf.dv;
import com.tencent.mm.protocal.protobuf.hn;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bs;

public final class f
  extends c
{
  private static int sqS = 7200;
  private String mac;
  private String ssid;
  
  public f(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8)
  {
    AppMethodBeat.i(24855);
    cJr();
    this.ssid = paramString1;
    this.mac = paramString2;
    dv localdv = new dv();
    localdv.mac = paramString2;
    localdv.ssid = paramString1;
    paramString1 = (asr)this.rr.hvr.hvw;
    paramString1.appId = paramString3;
    paramString1.srr = paramString4;
    paramString1.srs = paramString5;
    paramString1.srt = paramString6;
    paramString1.cJz = paramString7;
    paramString1.sign = paramString8;
    paramString1.EMb = localdv;
    AppMethodBeat.o(24855);
  }
  
  protected final void b(int paramInt1, int paramInt2, int paramInt3, String paramString)
  {
    AppMethodBeat.i(24856);
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
      localObject = (ass)this.rr.hvs.hvw;
      paramString.field_ssid = this.ssid;
      paramString.field_showUrl = ((ass)localObject).DLJ;
      cyw localcyw = ((ass)localObject).DLK;
      if (localcyw != null)
      {
        ac.i("MicroMsg.FreeWifi.NetSceneGetBackPageFor33", "en : %s, cn : %s, tw : %s", new Object[] { localcyw.FIc, localcyw.FId, localcyw.FIe });
        paramString.field_showWordCn = localcyw.FId;
        paramString.field_showWordEn = localcyw.FIc;
        paramString.field_showWordTw = localcyw.FIe;
        paramString.field_action = ((ass)localObject).DLI;
        paramString.field_verifyResult = 1;
        paramString.field_connectState = -1;
        if (((ass)localObject).DLS <= 0) {
          ((ass)localObject).DLS = sqS;
        }
        paramString.field_expiredTime = (bs.aNx() + ((ass)localObject).DLS);
        paramString.field_mac = this.mac;
        if (paramInt1 == 0) {
          break label330;
        }
        ac.i("MicroMsg.FreeWifi.NetSceneGetBackPageFor33", "insert freewifi ret = %b", new Object[] { Boolean.valueOf(j.cJk().insert(paramString)) });
      }
      for (;;)
      {
        j.cJk().afB(this.ssid);
        AppMethodBeat.o(24856);
        return;
        paramString.field_showWordCn = ai.getContext().getResources().getString(2131759658);
        paramString.field_showWordEn = ai.getContext().getResources().getString(2131759658);
        paramString.field_showWordTw = ai.getContext().getResources().getString(2131759658);
        break;
        label330:
        ac.i("MicroMsg.FreeWifi.NetSceneGetBackPageFor33", "insert freewifi ret = %b", new Object[] { Boolean.valueOf(j.cJk().update(paramString, new String[0])) });
      }
    }
    ac.e("MicroMsg.FreeWifi.NetSceneGetBackPageFor33", "check this ap failed, ssid is :%s", new Object[] { this.ssid });
    if (paramInt1 == 0)
    {
      boolean bool = j.cJk().delete(paramString, new String[0]);
      ac.i("MicroMsg.FreeWifi.NetSceneGetBackPageFor33", "freewifi verify failed, delte local db infos : %s, ret = %b", new Object[] { this.ssid, Boolean.valueOf(bool) });
    }
    AppMethodBeat.o(24856);
  }
  
  protected final void cJr()
  {
    AppMethodBeat.i(24854);
    b.a locala = new b.a();
    locala.hvt = new asr();
    locala.hvu = new ass();
    locala.uri = "/cgi-bin/mmo2o-bin/getbackpagefor33";
    locala.funcId = 1726;
    locala.reqCmdId = 0;
    locala.respCmdId = 0;
    this.rr = locala.aAz();
    AppMethodBeat.o(24854);
  }
  
  public final hn cJw()
  {
    return ((ass)this.rr.hvs.hvw).str;
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