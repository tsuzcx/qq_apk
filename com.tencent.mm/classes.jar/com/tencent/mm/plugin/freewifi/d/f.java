package com.tencent.mm.plugin.freewifi.d;

import android.content.Context;
import android.content.res.Resources;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.d.b;
import com.tencent.mm.ak.d.c;
import com.tencent.mm.plugin.freewifi.model.j;
import com.tencent.mm.protocal.protobuf.bip;
import com.tencent.mm.protocal.protobuf.biq;
import com.tencent.mm.protocal.protobuf.dyj;
import com.tencent.mm.protocal.protobuf.ei;
import com.tencent.mm.protocal.protobuf.ih;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MD5Util;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;

public final class f
  extends c
{
  private static int wPp = 7200;
  private String mac;
  private String ssid;
  
  public f(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8)
  {
    AppMethodBeat.i(24855);
    dNu();
    this.ssid = paramString1;
    this.mac = paramString2;
    ei localei = new ei();
    localei.mac = paramString2;
    localei.ssid = paramString1;
    paramString1 = (bip)this.rr.iLK.iLR;
    paramString1.appId = paramString3;
    paramString1.wPN = paramString4;
    paramString1.wPO = paramString5;
    paramString1.extend = paramString6;
    paramString1.dmc = paramString7;
    paramString1.sign = paramString8;
    paramString1.LSI = localei;
    AppMethodBeat.o(24855);
  }
  
  protected final void a(int paramInt1, int paramInt2, int paramInt3, String paramString)
  {
    AppMethodBeat.i(24856);
    Object localObject = j.dNn().aya(this.ssid);
    paramInt1 = 0;
    paramString = (String)localObject;
    if (localObject == null)
    {
      paramInt1 = 1;
      paramString = new com.tencent.mm.plugin.freewifi.g.c();
      paramString.field_ssidmd5 = MD5Util.getMD5String(this.ssid);
    }
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      localObject = (biq)this.rr.iLL.iLR;
      paramString.field_ssid = this.ssid;
      paramString.field_showUrl = ((biq)localObject).KCE;
      dyj localdyj = ((biq)localObject).KCF;
      if (localdyj != null)
      {
        Log.i("MicroMsg.FreeWifi.NetSceneGetBackPageFor33", "en : %s, cn : %s, tw : %s", new Object[] { localdyj.MXX, localdyj.MXY, localdyj.MXZ });
        paramString.field_showWordCn = localdyj.MXY;
        paramString.field_showWordEn = localdyj.MXX;
        paramString.field_showWordTw = localdyj.MXZ;
        paramString.field_action = ((biq)localObject).KCD;
        paramString.field_verifyResult = 1;
        paramString.field_connectState = -1;
        if (((biq)localObject).KCN <= 0) {
          ((biq)localObject).KCN = wPp;
        }
        paramString.field_expiredTime = (Util.nowSecond() + ((biq)localObject).KCN);
        paramString.field_mac = this.mac;
        if (paramInt1 == 0) {
          break label330;
        }
        Log.i("MicroMsg.FreeWifi.NetSceneGetBackPageFor33", "insert freewifi ret = %b", new Object[] { Boolean.valueOf(j.dNn().insert(paramString)) });
      }
      for (;;)
      {
        j.dNn().ayb(this.ssid);
        AppMethodBeat.o(24856);
        return;
        paramString.field_showWordCn = MMApplicationContext.getContext().getResources().getString(2131760979);
        paramString.field_showWordEn = MMApplicationContext.getContext().getResources().getString(2131760979);
        paramString.field_showWordTw = MMApplicationContext.getContext().getResources().getString(2131760979);
        break;
        label330:
        Log.i("MicroMsg.FreeWifi.NetSceneGetBackPageFor33", "insert freewifi ret = %b", new Object[] { Boolean.valueOf(j.dNn().update(paramString, new String[0])) });
      }
    }
    Log.e("MicroMsg.FreeWifi.NetSceneGetBackPageFor33", "check this ap failed, ssid is :%s", new Object[] { this.ssid });
    if (paramInt1 == 0)
    {
      boolean bool = j.dNn().delete(paramString, new String[0]);
      Log.i("MicroMsg.FreeWifi.NetSceneGetBackPageFor33", "freewifi verify failed, delte local db infos : %s, ret = %b", new Object[] { this.ssid, Boolean.valueOf(bool) });
    }
    AppMethodBeat.o(24856);
  }
  
  protected final void dNu()
  {
    AppMethodBeat.i(24854);
    d.a locala = new d.a();
    locala.iLN = new bip();
    locala.iLO = new biq();
    locala.uri = "/cgi-bin/mmo2o-bin/getbackpagefor33";
    locala.funcId = 1726;
    locala.iLP = 0;
    locala.respCmdId = 0;
    this.rr = locala.aXF();
    AppMethodBeat.o(24854);
  }
  
  public final ih dNz()
  {
    return ((biq)this.rr.iLL.iLR).wRL;
  }
  
  public final int getType()
  {
    return 1726;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.freewifi.d.f
 * JD-Core Version:    0.7.0.1
 */