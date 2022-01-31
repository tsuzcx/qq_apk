package com.tencent.mm.plugin.favorite.ui;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.r;
import com.tencent.mm.opensdk.modelmsg.SendMessageToWX.Req;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.fav.a.b;
import com.tencent.mm.pluginsdk.ui.applet.q.a;
import com.tencent.mm.protocal.protobuf.aca;
import com.tencent.mm.protocal.protobuf.acq;
import com.tencent.mm.protocal.protobuf.acw;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.vfs.e;

@a(7)
public class FavOpenApiEntry
  extends MMActivity
{
  private String appId;
  private ap caS;
  private Intent cyJ;
  private Bundle mEJ;
  private SendMessageToWX.Req mEK;
  private String mEL;
  private int mEM;
  private String source;
  
  public FavOpenApiEntry()
  {
    AppMethodBeat.i(20542);
    this.mEM = 0;
    this.caS = new ap(new FavOpenApiEntry.1(this), true);
    AppMethodBeat.o(20542);
  }
  
  private void J(com.tencent.mm.plugin.fav.a.g paramg)
  {
    AppMethodBeat.i(20547);
    acw localacw = new acw();
    localacw.aot(this.appId);
    localacw.MR(4);
    localacw.aon(r.Zn());
    localacw.aoo(r.Zn());
    paramg.field_fromUser = localacw.czp;
    paramg.field_toUser = localacw.toUser;
    paramg.field_favProto.a(localacw);
    AppMethodBeat.o(20547);
  }
  
  private q.a a(WXMediaMessage paramWXMediaMessage)
  {
    AppMethodBeat.i(20550);
    paramWXMediaMessage = new FavOpenApiEntry.2(this, paramWXMediaMessage);
    AppMethodBeat.o(20550);
    return paramWXMediaMessage;
  }
  
  private static aca a(WXMediaMessage paramWXMediaMessage, String paramString, byte[] paramArrayOfByte, int paramInt)
  {
    AppMethodBeat.i(20548);
    aca localaca = new aca();
    localaca.anq(paramWXMediaMessage.title);
    localaca.anr(paramWXMediaMessage.description);
    localaca.MI(paramInt);
    if (paramString != null)
    {
      localaca.anE(paramString);
      localaca.anA(e.cP(paramString));
      a(paramWXMediaMessage, localaca, paramInt);
      AppMethodBeat.o(20548);
      return localaca;
    }
    paramString = com.tencent.mm.a.g.w(paramArrayOfByte);
    if (paramArrayOfByte.length >= 256) {
      localaca.anC(paramString);
    }
    for (;;)
    {
      localaca.anB(paramString);
      localaca.nC(paramArrayOfByte.length);
      localaca.anD(b.cj(localaca.toString(), paramInt));
      e.a(b.b(localaca), paramArrayOfByte, paramArrayOfByte.length);
      break;
      byte[] arrayOfByte = new byte[256];
      System.arraycopy(paramArrayOfByte, 0, arrayOfByte, 0, 256);
      localaca.anC(com.tencent.mm.a.g.w(arrayOfByte));
    }
  }
  
  private static void a(WXMediaMessage paramWXMediaMessage, com.tencent.mm.plugin.fav.a.g paramg)
  {
    AppMethodBeat.i(20546);
    paramg.field_sourceType = 4;
    paramg.field_favProto.aol(paramWXMediaMessage.title);
    paramg.field_favProto.aom(paramWXMediaMessage.description);
    AppMethodBeat.o(20546);
  }
  
  private static void a(WXMediaMessage paramWXMediaMessage, aca paramaca, int paramInt)
  {
    AppMethodBeat.i(20549);
    if (paramWXMediaMessage.thumbData != null)
    {
      Object localObject = com.tencent.mm.a.g.w(paramWXMediaMessage.thumbData);
      paramaca.anG((String)localObject);
      if (paramWXMediaMessage.thumbData.length >= 256) {
        paramaca.anH((String)localObject);
      }
      for (;;)
      {
        if (bo.isNullOrNil(paramaca.mBq)) {
          paramaca.anD(b.cj(paramaca.toString(), paramInt));
        }
        paramaca.nD(paramWXMediaMessage.thumbData.length);
        paramaca = b.c(paramaca);
        paramWXMediaMessage = paramWXMediaMessage.thumbData;
        e.a(paramaca, paramWXMediaMessage, paramWXMediaMessage.length);
        AppMethodBeat.o(20549);
        return;
        localObject = new byte[256];
        System.arraycopy(paramWXMediaMessage.thumbData, 0, localObject, 0, 256);
        paramaca.anH(com.tencent.mm.a.g.w((byte[])localObject));
      }
    }
    paramaca.pz(true);
    AppMethodBeat.o(20549);
  }
  
  public int getLayoutId()
  {
    return -1;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(20543);
    super.onCreate(paramBundle);
    if (this.cyJ == null) {
      this.cyJ = getIntent();
    }
    this.mEJ = this.cyJ.getExtras();
    this.appId = this.mEJ.getString("SendAppMessageWrapper_AppId");
    if (this.appId == null) {
      this.appId = Uri.parse(this.mEJ.getString("_mmessage_content")).getQueryParameter("appid");
    }
    this.mEK = new SendMessageToWX.Req(this.mEJ);
    if (this.mEK.scene != 2)
    {
      ab.e("MicroMsg.FavOpenApiEntry", "scene not WXSceneFavorite!");
      finish();
      AppMethodBeat.o(20543);
      return;
    }
    this.mEL = getString(2131299680);
    this.source = getString(2131298504, new Object[] { b.getAppName(this, this.appId) });
    this.caS.ag(100L, 100L);
    AppMethodBeat.o(20543);
  }
  
  public void onNewIntent(Intent paramIntent)
  {
    AppMethodBeat.i(20544);
    super.onNewIntent(paramIntent);
    this.cyJ = paramIntent;
    AppMethodBeat.o(20544);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(20551);
    super.onPause();
    AppMethodBeat.o(20551);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(20545);
    super.onResume();
    AppMethodBeat.o(20545);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.favorite.ui.FavOpenApiEntry
 * JD-Core Version:    0.7.0.1
 */