package com.tencent.mm.plugin.freewifi.d;

import android.content.Context;
import android.content.res.Resources;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.b.b;
import com.tencent.mm.ai.b.c;
import com.tencent.mm.plugin.freewifi.g.d;
import com.tencent.mm.plugin.freewifi.model.j;
import com.tencent.mm.protocal.protobuf.agg;
import com.tencent.mm.protocal.protobuf.agh;
import com.tencent.mm.protocal.protobuf.ccq;
import com.tencent.mm.protocal.protobuf.dh;
import com.tencent.mm.protocal.protobuf.gm;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;

public final class f
  extends c
{
  private static int mKV = 7200;
  private String mac;
  private String ssid;
  
  public f(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8)
  {
    AppMethodBeat.i(20785);
    bAR();
    this.ssid = paramString1;
    this.mac = paramString2;
    dh localdh = new dh();
    localdh.mac = paramString2;
    localdh.ssid = paramString1;
    paramString1 = (agg)this.rr.fsV.fta;
    paramString1.appId = paramString3;
    paramString1.mLu = paramString4;
    paramString1.mLv = paramString5;
    paramString1.mLw = paramString6;
    paramString1.cqf = paramString7;
    paramString1.sign = paramString8;
    paramString1.wZk = localdh;
    AppMethodBeat.o(20785);
  }
  
  protected final void b(int paramInt1, int paramInt2, int paramInt3, String paramString)
  {
    AppMethodBeat.i(20786);
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
      localObject = (agh)this.rr.fsW.fta;
      paramString.field_ssid = this.ssid;
      paramString.field_showUrl = ((agh)localObject).wle;
      ccq localccq = ((agh)localObject).wlf;
      if (localccq != null)
      {
        ab.i("MicroMsg.FreeWifi.NetSceneGetBackPageFor33", "en : %s, cn : %s, tw : %s", new Object[] { localccq.xNe, localccq.xNf, localccq.xNg });
        paramString.field_showWordCn = localccq.xNf;
        paramString.field_showWordEn = localccq.xNe;
        paramString.field_showWordTw = localccq.xNg;
        paramString.field_action = ((agh)localObject).wld;
        paramString.field_verifyResult = 1;
        paramString.field_connectState = -1;
        if (((agh)localObject).wln <= 0) {
          ((agh)localObject).wln = mKV;
        }
        paramString.field_expiredTime = (bo.aox() + ((agh)localObject).wln);
        paramString.field_mac = this.mac;
        if (paramInt1 == 0) {
          break label330;
        }
        ab.i("MicroMsg.FreeWifi.NetSceneGetBackPageFor33", "insert freewifi ret = %b", new Object[] { Boolean.valueOf(j.bAK().insert(paramString)) });
      }
      for (;;)
      {
        j.bAK().OL(this.ssid);
        AppMethodBeat.o(20786);
        return;
        paramString.field_showWordCn = ah.getContext().getResources().getString(2131300186);
        paramString.field_showWordEn = ah.getContext().getResources().getString(2131300186);
        paramString.field_showWordTw = ah.getContext().getResources().getString(2131300186);
        break;
        label330:
        ab.i("MicroMsg.FreeWifi.NetSceneGetBackPageFor33", "insert freewifi ret = %b", new Object[] { Boolean.valueOf(j.bAK().update(paramString, new String[0])) });
      }
    }
    ab.e("MicroMsg.FreeWifi.NetSceneGetBackPageFor33", "check this ap failed, ssid is :%s", new Object[] { this.ssid });
    if (paramInt1 == 0)
    {
      boolean bool = j.bAK().delete(paramString, new String[0]);
      ab.i("MicroMsg.FreeWifi.NetSceneGetBackPageFor33", "freewifi verify failed, delte local db infos : %s, ret = %b", new Object[] { this.ssid, Boolean.valueOf(bool) });
    }
    AppMethodBeat.o(20786);
  }
  
  protected final void bAR()
  {
    AppMethodBeat.i(20784);
    b.a locala = new b.a();
    locala.fsX = new agg();
    locala.fsY = new agh();
    locala.uri = "/cgi-bin/mmo2o-bin/getbackpagefor33";
    locala.funcId = 1726;
    locala.reqCmdId = 0;
    locala.respCmdId = 0;
    this.rr = locala.ado();
    AppMethodBeat.o(20784);
  }
  
  public final gm bAW()
  {
    return ((agh)this.rr.fsW.fta).mNG;
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