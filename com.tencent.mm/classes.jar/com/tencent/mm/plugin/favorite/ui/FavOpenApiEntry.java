package com.tencent.mm.plugin.favorite.ui;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.l;
import com.tencent.mm.model.z;
import com.tencent.mm.opensdk.modelmsg.SendMessageToWX.Req;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.opensdk.modelmsg.WXMusicVideoObject;
import com.tencent.mm.opensdk.modelmsg.WXMusicVipInfo;
import com.tencent.mm.plugin.base.stub.d;
import com.tencent.mm.plugin.fav.a.b;
import com.tencent.mm.pluginsdk.model.app.ReportUtil;
import com.tencent.mm.pluginsdk.model.app.ReportUtil.ReportArgs;
import com.tencent.mm.pluginsdk.ui.applet.y.a;
import com.tencent.mm.pluginsdk.ui.tools.r;
import com.tencent.mm.protocal.protobuf.arf;
import com.tencent.mm.protocal.protobuf.arg;
import com.tencent.mm.protocal.protobuf.arv;
import com.tencent.mm.protocal.protobuf.asb;
import com.tencent.mm.protocal.protobuf.dtj;
import com.tencent.mm.sdk.platformtools.IntentUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.vfs.y;
import java.util.LinkedList;

@com.tencent.mm.ui.base.a(7)
public class FavOpenApiEntry
  extends MMActivity
{
  private SendMessageToWX.Req Aqs;
  private String Aqt;
  private int Aqu;
  private String appId;
  private Bundle hPH;
  private Intent hPY;
  private String source;
  private MTimerHandler timer;
  
  public FavOpenApiEntry()
  {
    AppMethodBeat.i(24619);
    this.Aqu = 0;
    this.timer = new MTimerHandler(new MTimerHandler.CallBack()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(24617);
        if ((FavOpenApiEntry.this.getWindow() == null) || (FavOpenApiEntry.this.getWindow().getDecorView() == null) || (FavOpenApiEntry.this.getWindow().getDecorView().getWindowToken() == null))
        {
          if (FavOpenApiEntry.a(FavOpenApiEntry.this) < 10)
          {
            FavOpenApiEntry.b(FavOpenApiEntry.this);
            AppMethodBeat.o(24617);
            return true;
          }
          AppMethodBeat.o(24617);
          return false;
        }
        new d(FavOpenApiEntry.this, FavOpenApiEntry.c(FavOpenApiEntry.this), FavOpenApiEntry.d(FavOpenApiEntry.this).openId, new com.tencent.mm.plugin.base.stub.d.a()
        {
          public final void mC(boolean paramAnonymous2Boolean)
          {
            AppMethodBeat.i(24616);
            boolean bool = FavOpenApiEntry.this.isFinishing();
            Log.i("MicroMsg.FavOpenApiEntry", "onCheckEnd, isPass = " + paramAnonymous2Boolean + ", isFinishing = " + bool);
            if ((paramAnonymous2Boolean) && (!bool))
            {
              FavOpenApiEntry.a(FavOpenApiEntry.this, FavOpenApiEntry.d(FavOpenApiEntry.this).message);
              AppMethodBeat.o(24616);
              return;
            }
            ReportUtil.ReportArgs localReportArgs = ReportUtil.c(FavOpenApiEntry.this.getIntent().getExtras(), -3);
            ReportUtil.a(FavOpenApiEntry.this, localReportArgs, false);
            FavOpenApiEntry.this.finish();
            AppMethodBeat.o(24616);
          }
        }).cZW();
        AppMethodBeat.o(24617);
        return false;
      }
    }, true);
    AppMethodBeat.o(24619);
  }
  
  private void L(com.tencent.mm.plugin.fav.a.g paramg)
  {
    AppMethodBeat.i(24624);
    asb localasb = new asb();
    localasb.btu(this.appId);
    localasb.axH(4);
    localasb.bto(z.bAM());
    localasb.btp(z.bAM());
    paramg.field_fromUser = localasb.hQQ;
    paramg.field_toUser = localasb.toUser;
    paramg.field_favProto.a(localasb);
    AppMethodBeat.o(24624);
  }
  
  private y.a a(final WXMediaMessage paramWXMediaMessage)
  {
    AppMethodBeat.i(24627);
    paramWXMediaMessage = new y.a()
    {
      public final void onDialogClick(boolean paramAnonymousBoolean, String paramAnonymousString, int paramAnonymousInt)
      {
        AppMethodBeat.i(24618);
        if (paramAnonymousBoolean)
        {
          r.a(IntentUtil.getIntExtra(FavOpenApiEntry.this.getIntent(), "_mmessage_sdkVersion", 0), FavOpenApiEntry.c(FavOpenApiEntry.this), paramWXMediaMessage);
          FavOpenApiEntry.b(FavOpenApiEntry.this, paramWXMediaMessage);
          paramAnonymousString = ReportUtil.c(FavOpenApiEntry.this.getIntent().getExtras(), 0);
          ReportUtil.a(FavOpenApiEntry.this, paramAnonymousString, false);
          AppMethodBeat.o(24618);
          return;
        }
        FavOpenApiEntry.this.finish();
        ReportUtil.a(FavOpenApiEntry.this, ReportUtil.c(FavOpenApiEntry.this.getIntent().getExtras(), 0), true);
        AppMethodBeat.o(24618);
      }
    };
    AppMethodBeat.o(24627);
    return paramWXMediaMessage;
  }
  
  private static arf a(WXMediaMessage paramWXMediaMessage, String paramString, byte[] paramArrayOfByte, int paramInt)
  {
    AppMethodBeat.i(24625);
    arf localarf = new arf();
    localarf.bso(paramWXMediaMessage.title);
    localarf.bsp(paramWXMediaMessage.description);
    localarf.axy(paramInt);
    if (paramString != null)
    {
      localarf.bsC(paramString);
      localarf.bsy(y.alV(paramString));
      a(paramWXMediaMessage, localarf, paramInt);
      AppMethodBeat.o(24625);
      return localarf;
    }
    paramString = com.tencent.mm.b.g.getMessageDigest(paramArrayOfByte);
    if (paramArrayOfByte.length >= 256) {
      localarf.bsA(paramString);
    }
    for (;;)
    {
      localarf.bsz(paramString);
      localarf.yo(paramArrayOfByte.length);
      localarf.bsB(b.er(localarf.toString(), paramInt));
      y.e(b.d(localarf), paramArrayOfByte, paramArrayOfByte.length);
      break;
      byte[] arrayOfByte = new byte[256];
      System.arraycopy(paramArrayOfByte, 0, arrayOfByte, 0, 256);
      localarf.bsA(com.tencent.mm.b.g.getMessageDigest(arrayOfByte));
    }
  }
  
  private static void a(WXMediaMessage paramWXMediaMessage, com.tencent.mm.plugin.fav.a.g paramg)
  {
    AppMethodBeat.i(24623);
    paramg.field_sourceType = 4;
    paramg.field_favProto.btm(paramWXMediaMessage.title);
    paramg.field_favProto.btn(paramWXMediaMessage.description);
    AppMethodBeat.o(24623);
  }
  
  private static void a(WXMediaMessage paramWXMediaMessage, arf paramarf, int paramInt)
  {
    AppMethodBeat.i(24626);
    if (paramWXMediaMessage.thumbData != null)
    {
      Object localObject = com.tencent.mm.b.g.getMessageDigest(paramWXMediaMessage.thumbData);
      paramarf.bsE((String)localObject);
      if (paramWXMediaMessage.thumbData.length >= 256) {
        paramarf.bsF((String)localObject);
      }
      for (;;)
      {
        if (Util.isNullOrNil(paramarf.hIQ)) {
          paramarf.bsB(b.er(paramarf.toString(), paramInt));
        }
        paramarf.yp(paramWXMediaMessage.thumbData.length);
        paramarf = b.a(paramarf);
        paramWXMediaMessage = paramWXMediaMessage.thumbData;
        y.e(paramarf, paramWXMediaMessage, paramWXMediaMessage.length);
        AppMethodBeat.o(24626);
        return;
        localObject = new byte[256];
        System.arraycopy(paramWXMediaMessage.thumbData, 0, localObject, 0, 256);
        paramarf.bsF(com.tencent.mm.b.g.getMessageDigest((byte[])localObject));
      }
    }
    paramarf.Kk(true);
    AppMethodBeat.o(24626);
  }
  
  private void a(WXMediaMessage paramWXMediaMessage, String paramString)
  {
    AppMethodBeat.i(261372);
    WXMusicVideoObject localWXMusicVideoObject = (WXMusicVideoObject)paramWXMediaMessage.mediaObject;
    com.tencent.mm.plugin.fav.a.g localg = new com.tencent.mm.plugin.fav.a.g();
    localg.field_type = 21;
    a(paramWXMediaMessage, localg);
    arf localarf = new arf();
    localarf.bso(paramWXMediaMessage.title);
    localarf.bsp(paramWXMediaMessage.description);
    a(paramWXMediaMessage, localarf, localg.field_type);
    localarf.Kj(true);
    localarf.axy(localg.field_type);
    localarf.bsu(localWXMusicVideoObject.musicUrl);
    localarf.bsv(localWXMusicVideoObject.musicDataUrl);
    localarf.bsU(paramString);
    localarf.bsV(localWXMusicVideoObject.songLyric);
    paramString = new dtj();
    paramString.singerName = localWXMusicVideoObject.singerName;
    paramString.albumName = localWXMusicVideoObject.albumName;
    paramString.musicGenre = localWXMusicVideoObject.musicGenre;
    paramString.issueDate = localWXMusicVideoObject.issueDate;
    paramString.identification = localWXMusicVideoObject.identification;
    paramString.LNC = localWXMusicVideoObject.duration;
    paramString.musicOperationUrl = localWXMusicVideoObject.musicOperationUrl;
    paramString.extraInfo = paramWXMediaMessage.messageExt;
    if (localWXMusicVideoObject.musicVipInfo != null)
    {
      paramWXMediaMessage = com.tencent.mm.aw.a.OK(localWXMusicVideoObject.musicVipInfo.musicId);
      paramString.oOZ = paramWXMediaMessage;
      paramWXMediaMessage = localWXMusicVideoObject.singerName;
      if (localWXMusicVideoObject.musicVipInfo == null) {
        break label337;
      }
    }
    label337:
    for (boolean bool = true;; bool = false)
    {
      Log.i("MicroMsg.FavOpenApiEntry", "share music mv to fav, singerName:%s, musicVipInfo is valid:%b", new Object[] { paramWXMediaMessage, Boolean.valueOf(bool) });
      paramWXMediaMessage = new arg();
      paramWXMediaMessage.e(paramString);
      localarf.a(paramWXMediaMessage);
      localg.field_favProto.vEn.add(localarf);
      L(localg);
      com.tencent.mm.plugin.fav.ui.a.C(localg);
      AppMethodBeat.o(261372);
      return;
      paramWXMediaMessage = "";
      break;
    }
  }
  
  public int getLayoutId()
  {
    return -1;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(24620);
    super.onCreate(paramBundle);
    if (this.hPY == null) {
      this.hPY = getIntent();
    }
    this.hPH = this.hPY.getExtras();
    this.appId = this.hPH.getString("SendAppMessageWrapper_AppId");
    if (this.appId == null) {
      this.appId = Uri.parse(this.hPH.getString("_mmessage_content")).getQueryParameter("appid");
    }
    this.Aqs = new SendMessageToWX.Req(this.hPH);
    if (this.Aqs.scene != 2)
    {
      Log.e("MicroMsg.FavOpenApiEntry", "scene not WXSceneFavorite!");
      finish();
      AppMethodBeat.o(24620);
      return;
    }
    this.Aqt = getString(R.l.favorite);
    paramBundle = b.getAppName(this, this.appId);
    this.source = getString(R.l.confirm_dialog_source, new Object[] { paramBundle });
    this.timer.startTimer(100L);
    AppMethodBeat.o(24620);
  }
  
  public void onNewIntent(Intent paramIntent)
  {
    AppMethodBeat.i(24621);
    super.onNewIntent(paramIntent);
    this.hPY = paramIntent;
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