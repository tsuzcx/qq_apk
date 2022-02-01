package com.tencent.mm.plugin.favorite.ui;

import android.app.Activity;
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
import com.tencent.mm.plugin.base.stub.d;
import com.tencent.mm.pluginsdk.model.app.ReportUtil;
import com.tencent.mm.pluginsdk.model.app.ReportUtil.ReportArgs;
import com.tencent.mm.pluginsdk.ui.applet.y.a;
import com.tencent.mm.pluginsdk.ui.tools.s;
import com.tencent.mm.protocal.protobuf.anm;
import com.tencent.mm.protocal.protobuf.ann;
import com.tencent.mm.protocal.protobuf.aoc;
import com.tencent.mm.protocal.protobuf.aoi;
import com.tencent.mm.protocal.protobuf.dbr;
import com.tencent.mm.sdk.platformtools.IntentUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.vfs.u;
import java.util.LinkedList;

@a(7)
public class FavOpenApiEntry
  extends MMActivity
{
  private String appId;
  private Bundle fKb;
  private Intent fKs;
  private String source;
  private MTimerHandler timer;
  private SendMessageToWX.Req wTP;
  private String wTQ;
  private int wTR;
  
  public FavOpenApiEntry()
  {
    AppMethodBeat.i(24619);
    this.wTR = 0;
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
          public final void lk(boolean paramAnonymous2Boolean)
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
            ReportUtil.ReportArgs localReportArgs = ReportUtil.d(FavOpenApiEntry.this.getIntent().getExtras(), -3);
            ReportUtil.a(FavOpenApiEntry.this, localReportArgs, false);
            FavOpenApiEntry.this.finish();
            AppMethodBeat.o(24616);
          }
        }).cxi();
        AppMethodBeat.o(24617);
        return false;
      }
    }, true);
    AppMethodBeat.o(24619);
  }
  
  private void L(com.tencent.mm.plugin.fav.a.g paramg)
  {
    AppMethodBeat.i(24624);
    aoi localaoi = new aoi();
    localaoi.btD(this.appId);
    localaoi.arz(4);
    localaoi.btx(z.bcZ());
    localaoi.bty(z.bcZ());
    paramg.field_fromUser = localaoi.fLi;
    paramg.field_toUser = localaoi.toUser;
    paramg.field_favProto.a(localaoi);
    AppMethodBeat.o(24624);
  }
  
  private y.a a(final WXMediaMessage paramWXMediaMessage)
  {
    AppMethodBeat.i(24627);
    paramWXMediaMessage = new y.a()
    {
      public final void a(boolean paramAnonymousBoolean, String paramAnonymousString, int paramAnonymousInt)
      {
        AppMethodBeat.i(24618);
        if (paramAnonymousBoolean)
        {
          s.a(IntentUtil.getIntExtra(FavOpenApiEntry.this.getIntent(), "_mmessage_sdkVersion", 0), FavOpenApiEntry.c(FavOpenApiEntry.this), paramWXMediaMessage);
          FavOpenApiEntry.b(FavOpenApiEntry.this, paramWXMediaMessage);
          paramAnonymousString = ReportUtil.d(FavOpenApiEntry.this.getIntent().getExtras(), 0);
          ReportUtil.a(FavOpenApiEntry.this, paramAnonymousString, false);
          AppMethodBeat.o(24618);
          return;
        }
        FavOpenApiEntry.this.finish();
        ReportUtil.a(FavOpenApiEntry.this, ReportUtil.d(FavOpenApiEntry.this.getIntent().getExtras(), 0), true);
        AppMethodBeat.o(24618);
      }
    };
    AppMethodBeat.o(24627);
    return paramWXMediaMessage;
  }
  
  private static anm a(WXMediaMessage paramWXMediaMessage, String paramString, byte[] paramArrayOfByte, int paramInt)
  {
    AppMethodBeat.i(24625);
    anm localanm = new anm();
    localanm.bsx(paramWXMediaMessage.title);
    localanm.bsy(paramWXMediaMessage.description);
    localanm.arq(paramInt);
    if (paramString != null)
    {
      localanm.bsL(paramString);
      localanm.bsH(u.asq(paramString));
      a(paramWXMediaMessage, localanm, paramInt);
      AppMethodBeat.o(24625);
      return localanm;
    }
    paramString = com.tencent.mm.b.g.getMessageDigest(paramArrayOfByte);
    if (paramArrayOfByte.length >= 256) {
      localanm.bsJ(paramString);
    }
    for (;;)
    {
      localanm.bsI(paramString);
      localanm.TY(paramArrayOfByte.length);
      localanm.bsK(com.tencent.mm.plugin.fav.a.b.dN(localanm.toString(), paramInt));
      u.F(com.tencent.mm.plugin.fav.a.b.d(localanm), paramArrayOfByte);
      break;
      byte[] arrayOfByte = new byte[256];
      System.arraycopy(paramArrayOfByte, 0, arrayOfByte, 0, 256);
      localanm.bsJ(com.tencent.mm.b.g.getMessageDigest(arrayOfByte));
    }
  }
  
  private static void a(WXMediaMessage paramWXMediaMessage, com.tencent.mm.plugin.fav.a.g paramg)
  {
    AppMethodBeat.i(24623);
    paramg.field_sourceType = 4;
    paramg.field_favProto.btv(paramWXMediaMessage.title);
    paramg.field_favProto.btw(paramWXMediaMessage.description);
    AppMethodBeat.o(24623);
  }
  
  private static void a(WXMediaMessage paramWXMediaMessage, anm paramanm, int paramInt)
  {
    AppMethodBeat.i(24626);
    if (paramWXMediaMessage.thumbData != null)
    {
      Object localObject = com.tencent.mm.b.g.getMessageDigest(paramWXMediaMessage.thumbData);
      paramanm.bsN((String)localObject);
      if (paramWXMediaMessage.thumbData.length >= 256) {
        paramanm.bsO((String)localObject);
      }
      for (;;)
      {
        if (Util.isNullOrNil(paramanm.fEa)) {
          paramanm.bsK(com.tencent.mm.plugin.fav.a.b.dN(paramanm.toString(), paramInt));
        }
        paramanm.TZ(paramWXMediaMessage.thumbData.length);
        u.F(com.tencent.mm.plugin.fav.a.b.a(paramanm), paramWXMediaMessage.thumbData);
        AppMethodBeat.o(24626);
        return;
        localObject = new byte[256];
        System.arraycopy(paramWXMediaMessage.thumbData, 0, localObject, 0, 256);
        paramanm.bsO(com.tencent.mm.b.g.getMessageDigest((byte[])localObject));
      }
    }
    paramanm.Ey(true);
    AppMethodBeat.o(24626);
  }
  
  private void a(WXMediaMessage paramWXMediaMessage, String paramString)
  {
    AppMethodBeat.i(277418);
    WXMusicVideoObject localWXMusicVideoObject = (WXMusicVideoObject)paramWXMediaMessage.mediaObject;
    com.tencent.mm.plugin.fav.a.g localg = new com.tencent.mm.plugin.fav.a.g();
    localg.field_type = 21;
    a(paramWXMediaMessage, localg);
    anm localanm = new anm();
    localanm.bsx(paramWXMediaMessage.title);
    localanm.bsy(paramWXMediaMessage.description);
    a(paramWXMediaMessage, localanm, localg.field_type);
    localanm.Ex(true);
    localanm.arq(localg.field_type);
    localanm.bsD(localWXMusicVideoObject.musicUrl);
    localanm.bsE(localWXMusicVideoObject.musicDataUrl);
    localanm.btd(paramString);
    localanm.bte(localWXMusicVideoObject.songLyric);
    paramString = new dbr();
    paramString.singerName = localWXMusicVideoObject.singerName;
    paramString.albumName = localWXMusicVideoObject.albumName;
    paramString.musicGenre = localWXMusicVideoObject.musicGenre;
    paramString.issueDate = localWXMusicVideoObject.issueDate;
    paramString.identification = localWXMusicVideoObject.identification;
    paramString.FSG = localWXMusicVideoObject.duration;
    paramString.extraInfo = paramWXMediaMessage.messageExt;
    paramWXMediaMessage = new ann();
    paramWXMediaMessage.e(paramString);
    localanm.a(paramWXMediaMessage);
    localg.field_favProto.syG.add(localanm);
    L(localg);
    com.tencent.mm.plugin.fav.ui.b.C(localg);
    AppMethodBeat.o(277418);
  }
  
  public int getLayoutId()
  {
    return -1;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(24620);
    super.onCreate(paramBundle);
    if (this.fKs == null) {
      this.fKs = getIntent();
    }
    this.fKb = this.fKs.getExtras();
    this.appId = this.fKb.getString("SendAppMessageWrapper_AppId");
    if (this.appId == null) {
      this.appId = Uri.parse(this.fKb.getString("_mmessage_content")).getQueryParameter("appid");
    }
    this.wTP = new SendMessageToWX.Req(this.fKb);
    if (this.wTP.scene != 2)
    {
      Log.e("MicroMsg.FavOpenApiEntry", "scene not WXSceneFavorite!");
      finish();
      AppMethodBeat.o(24620);
      return;
    }
    this.wTQ = getString(R.l.favorite);
    paramBundle = com.tencent.mm.plugin.fav.a.b.getAppName(this, this.appId);
    this.source = getString(R.l.confirm_dialog_source, new Object[] { paramBundle });
    this.timer.startTimer(100L);
    AppMethodBeat.o(24620);
  }
  
  public void onNewIntent(Intent paramIntent)
  {
    AppMethodBeat.i(24621);
    super.onNewIntent(paramIntent);
    this.fKs = paramIntent;
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