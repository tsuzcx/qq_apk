package com.tencent.mm.plugin.favorite.ui;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.u;
import com.tencent.mm.opensdk.modelmsg.SendMessageToWX.Req;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.fav.a.b;
import com.tencent.mm.pluginsdk.ui.applet.y.a;
import com.tencent.mm.protocal.protobuf.agx;
import com.tencent.mm.protocal.protobuf.ahn;
import com.tencent.mm.protocal.protobuf.aht;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.au;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.vfs.i;

@a(7)
public class FavOpenApiEntry
  extends MMActivity
{
  private String appId;
  private au cLS;
  private Bundle dmf;
  private Intent dmw;
  private SendMessageToWX.Req qVh;
  private String qVi;
  private int qVj;
  private String source;
  
  public FavOpenApiEntry()
  {
    AppMethodBeat.i(24619);
    this.qVj = 0;
    this.cLS = new au(new FavOpenApiEntry.1(this), true);
    AppMethodBeat.o(24619);
  }
  
  private void L(com.tencent.mm.plugin.fav.a.g paramg)
  {
    AppMethodBeat.i(24624);
    aht localaht = new aht();
    localaht.aJI(this.appId);
    localaht.XV(4);
    localaht.aJC(u.axw());
    localaht.aJD(u.axw());
    paramg.field_fromUser = localaht.dng;
    paramg.field_toUser = localaht.toUser;
    paramg.field_favProto.a(localaht);
    AppMethodBeat.o(24624);
  }
  
  private y.a a(WXMediaMessage paramWXMediaMessage)
  {
    AppMethodBeat.i(24627);
    paramWXMediaMessage = new FavOpenApiEntry.2(this, paramWXMediaMessage);
    AppMethodBeat.o(24627);
    return paramWXMediaMessage;
  }
  
  private static agx a(WXMediaMessage paramWXMediaMessage, String paramString, byte[] paramArrayOfByte, int paramInt)
  {
    AppMethodBeat.i(24625);
    agx localagx = new agx();
    localagx.aIC(paramWXMediaMessage.title);
    localagx.aID(paramWXMediaMessage.description);
    localagx.XM(paramInt);
    if (paramString != null)
    {
      localagx.aIQ(paramString);
      localagx.aIM(i.VW(paramString));
      a(paramWXMediaMessage, localagx, paramInt);
      AppMethodBeat.o(24625);
      return localagx;
    }
    paramString = com.tencent.mm.b.g.getMessageDigest(paramArrayOfByte);
    if (paramArrayOfByte.length >= 256) {
      localagx.aIO(paramString);
    }
    for (;;)
    {
      localagx.aIN(paramString);
      localagx.zS(paramArrayOfByte.length);
      localagx.aIP(b.cY(localagx.toString(), paramInt));
      i.e(b.d(localagx), paramArrayOfByte, paramArrayOfByte.length);
      break;
      byte[] arrayOfByte = new byte[256];
      System.arraycopy(paramArrayOfByte, 0, arrayOfByte, 0, 256);
      localagx.aIO(com.tencent.mm.b.g.getMessageDigest(arrayOfByte));
    }
  }
  
  private static void a(WXMediaMessage paramWXMediaMessage, com.tencent.mm.plugin.fav.a.g paramg)
  {
    AppMethodBeat.i(24623);
    paramg.field_sourceType = 4;
    paramg.field_favProto.aJA(paramWXMediaMessage.title);
    paramg.field_favProto.aJB(paramWXMediaMessage.description);
    AppMethodBeat.o(24623);
  }
  
  private static void a(WXMediaMessage paramWXMediaMessage, agx paramagx, int paramInt)
  {
    AppMethodBeat.i(24626);
    if (paramWXMediaMessage.thumbData != null)
    {
      Object localObject = com.tencent.mm.b.g.getMessageDigest(paramWXMediaMessage.thumbData);
      paramagx.aIS((String)localObject);
      if (paramWXMediaMessage.thumbData.length >= 256) {
        paramagx.aIT((String)localObject);
      }
      for (;;)
      {
        if (bs.isNullOrNil(paramagx.dhw)) {
          paramagx.aIP(b.cY(paramagx.toString(), paramInt));
        }
        paramagx.zT(paramWXMediaMessage.thumbData.length);
        paramagx = b.a(paramagx);
        paramWXMediaMessage = paramWXMediaMessage.thumbData;
        i.e(paramagx, paramWXMediaMessage, paramWXMediaMessage.length);
        AppMethodBeat.o(24626);
        return;
        localObject = new byte[256];
        System.arraycopy(paramWXMediaMessage.thumbData, 0, localObject, 0, 256);
        paramagx.aIT(com.tencent.mm.b.g.getMessageDigest((byte[])localObject));
      }
    }
    paramagx.vz(true);
    AppMethodBeat.o(24626);
  }
  
  public int getLayoutId()
  {
    return -1;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(24620);
    super.onCreate(paramBundle);
    if (this.dmw == null) {
      this.dmw = getIntent();
    }
    this.dmf = this.dmw.getExtras();
    this.appId = this.dmf.getString("SendAppMessageWrapper_AppId");
    if (this.appId == null) {
      this.appId = Uri.parse(this.dmf.getString("_mmessage_content")).getQueryParameter("appid");
    }
    this.qVh = new SendMessageToWX.Req(this.dmf);
    if (this.qVh.scene != 2)
    {
      ac.e("MicroMsg.FavOpenApiEntry", "scene not WXSceneFavorite!");
      finish();
      AppMethodBeat.o(24620);
      return;
    }
    this.qVi = getString(2131758845);
    this.source = getString(2131757563, new Object[] { b.getAppName(this, this.appId) });
    this.cLS.au(100L, 100L);
    AppMethodBeat.o(24620);
  }
  
  public void onNewIntent(Intent paramIntent)
  {
    AppMethodBeat.i(24621);
    super.onNewIntent(paramIntent);
    this.dmw = paramIntent;
    AppMethodBeat.o(24621);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(24628);
    super.onPause();
    AppMethodBeat.o(24628);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(24622);
    super.onResume();
    AppMethodBeat.o(24622);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.favorite.ui.FavOpenApiEntry
 * JD-Core Version:    0.7.0.1
 */