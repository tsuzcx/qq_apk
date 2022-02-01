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
import com.tencent.mm.protocal.protobuf.ajn;
import com.tencent.mm.protocal.protobuf.akd;
import com.tencent.mm.protocal.protobuf.akj;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.av;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.vfs.i;

@a(7)
public class FavOpenApiEntry
  extends MMActivity
{
  private String appId;
  private av cXg;
  private Bundle dxT;
  private Intent dyk;
  private SendMessageToWX.Req rFv;
  private String rFw;
  private int rFx;
  private String source;
  
  public FavOpenApiEntry()
  {
    AppMethodBeat.i(24619);
    this.rFx = 0;
    this.cXg = new av(new FavOpenApiEntry.1(this), true);
    AppMethodBeat.o(24619);
  }
  
  private void L(com.tencent.mm.plugin.fav.a.g paramg)
  {
    AppMethodBeat.i(24624);
    akj localakj = new akj();
    localakj.aPl(this.appId);
    localakj.ZR(4);
    localakj.aPf(u.aAm());
    localakj.aPg(u.aAm());
    paramg.field_fromUser = localakj.dyU;
    paramg.field_toUser = localakj.toUser;
    paramg.field_favProto.a(localakj);
    AppMethodBeat.o(24624);
  }
  
  private y.a a(WXMediaMessage paramWXMediaMessage)
  {
    AppMethodBeat.i(24627);
    paramWXMediaMessage = new FavOpenApiEntry.2(this, paramWXMediaMessage);
    AppMethodBeat.o(24627);
    return paramWXMediaMessage;
  }
  
  private static ajn a(WXMediaMessage paramWXMediaMessage, String paramString, byte[] paramArrayOfByte, int paramInt)
  {
    AppMethodBeat.i(24625);
    ajn localajn = new ajn();
    localajn.aOf(paramWXMediaMessage.title);
    localajn.aOg(paramWXMediaMessage.description);
    localajn.ZI(paramInt);
    if (paramString != null)
    {
      localajn.aOt(paramString);
      localajn.aOp(i.ZF(paramString));
      a(paramWXMediaMessage, localajn, paramInt);
      AppMethodBeat.o(24625);
      return localajn;
    }
    paramString = com.tencent.mm.b.g.getMessageDigest(paramArrayOfByte);
    if (paramArrayOfByte.length >= 256) {
      localajn.aOr(paramString);
    }
    for (;;)
    {
      localajn.aOq(paramString);
      localajn.CG(paramArrayOfByte.length);
      localajn.aOs(b.di(localajn.toString(), paramInt));
      i.e(b.d(localajn), paramArrayOfByte, paramArrayOfByte.length);
      break;
      byte[] arrayOfByte = new byte[256];
      System.arraycopy(paramArrayOfByte, 0, arrayOfByte, 0, 256);
      localajn.aOr(com.tencent.mm.b.g.getMessageDigest(arrayOfByte));
    }
  }
  
  private static void a(WXMediaMessage paramWXMediaMessage, com.tencent.mm.plugin.fav.a.g paramg)
  {
    AppMethodBeat.i(24623);
    paramg.field_sourceType = 4;
    paramg.field_favProto.aPd(paramWXMediaMessage.title);
    paramg.field_favProto.aPe(paramWXMediaMessage.description);
    AppMethodBeat.o(24623);
  }
  
  private static void a(WXMediaMessage paramWXMediaMessage, ajn paramajn, int paramInt)
  {
    AppMethodBeat.i(24626);
    if (paramWXMediaMessage.thumbData != null)
    {
      Object localObject = com.tencent.mm.b.g.getMessageDigest(paramWXMediaMessage.thumbData);
      paramajn.aOv((String)localObject);
      if (paramWXMediaMessage.thumbData.length >= 256) {
        paramajn.aOw((String)localObject);
      }
      for (;;)
      {
        if (bt.isNullOrNil(paramajn.dsU)) {
          paramajn.aOs(b.di(paramajn.toString(), paramInt));
        }
        paramajn.CH(paramWXMediaMessage.thumbData.length);
        paramajn = b.a(paramajn);
        paramWXMediaMessage = paramWXMediaMessage.thumbData;
        i.e(paramajn, paramWXMediaMessage, paramWXMediaMessage.length);
        AppMethodBeat.o(24626);
        return;
        localObject = new byte[256];
        System.arraycopy(paramWXMediaMessage.thumbData, 0, localObject, 0, 256);
        paramajn.aOw(com.tencent.mm.b.g.getMessageDigest((byte[])localObject));
      }
    }
    paramajn.wl(true);
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
    if (this.dyk == null) {
      this.dyk = getIntent();
    }
    this.dxT = this.dyk.getExtras();
    this.appId = this.dxT.getString("SendAppMessageWrapper_AppId");
    if (this.appId == null) {
      this.appId = Uri.parse(this.dxT.getString("_mmessage_content")).getQueryParameter("appid");
    }
    this.rFv = new SendMessageToWX.Req(this.dxT);
    if (this.rFv.scene != 2)
    {
      ad.e("MicroMsg.FavOpenApiEntry", "scene not WXSceneFavorite!");
      finish();
      AppMethodBeat.o(24620);
      return;
    }
    this.rFw = getString(2131758845);
    this.source = getString(2131757563, new Object[] { b.getAppName(this, this.appId) });
    this.cXg.az(100L, 100L);
    AppMethodBeat.o(24620);
  }
  
  public void onNewIntent(Intent paramIntent)
  {
    AppMethodBeat.i(24621);
    super.onNewIntent(paramIntent);
    this.dyk = paramIntent;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.favorite.ui.FavOpenApiEntry
 * JD-Core Version:    0.7.0.1
 */