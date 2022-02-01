package com.tencent.mm.plugin.favorite.ui;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.z;
import com.tencent.mm.opensdk.modelmsg.SendMessageToWX.Req;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.opensdk.modelmsg.WXMusicVideoObject;
import com.tencent.mm.plugin.base.stub.d;
import com.tencent.mm.plugin.fav.a.b;
import com.tencent.mm.pluginsdk.model.app.ReportUtil;
import com.tencent.mm.pluginsdk.model.app.ReportUtil.ReportArgs;
import com.tencent.mm.pluginsdk.ui.applet.y.a;
import com.tencent.mm.pluginsdk.ui.tools.q;
import com.tencent.mm.protocal.protobuf.aml;
import com.tencent.mm.protocal.protobuf.anb;
import com.tencent.mm.protocal.protobuf.anh;
import com.tencent.mm.sdk.platformtools.IntentUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.vfs.s;

@a(7)
public class FavOpenApiEntry
  extends MMActivity
{
  private String appId;
  private Bundle dQL;
  private Intent dRc;
  private String source;
  private MTimerHandler timer;
  private SendMessageToWX.Req tnr;
  private String tns;
  private int tnt;
  
  public FavOpenApiEntry()
  {
    AppMethodBeat.i(24619);
    this.tnt = 0;
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
          public final void jZ(boolean paramAnonymous2Boolean)
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
        }).cjR();
        AppMethodBeat.o(24617);
        return false;
      }
    }, true);
    AppMethodBeat.o(24619);
  }
  
  private void L(com.tencent.mm.plugin.fav.a.g paramg)
  {
    AppMethodBeat.i(24624);
    anh localanh = new anh();
    localanh.bhl(this.appId);
    localanh.ajm(4);
    localanh.bhf(z.aTY());
    localanh.bhg(z.aTY());
    paramg.field_fromUser = localanh.dRL;
    paramg.field_toUser = localanh.toUser;
    paramg.field_favProto.a(localanh);
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
          q.a(IntentUtil.getIntExtra(FavOpenApiEntry.this.getIntent(), "_mmessage_sdkVersion", 0), FavOpenApiEntry.c(FavOpenApiEntry.this), paramWXMediaMessage);
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
  
  private static aml a(WXMediaMessage paramWXMediaMessage, String paramString, byte[] paramArrayOfByte, int paramInt)
  {
    AppMethodBeat.i(24625);
    aml localaml = new aml();
    localaml.bgf(paramWXMediaMessage.title);
    localaml.bgg(paramWXMediaMessage.description);
    localaml.ajd(paramInt);
    if (paramString != null)
    {
      localaml.bgt(paramString);
      localaml.bgp(s.akC(paramString));
      a(paramWXMediaMessage, localaml, paramInt);
      AppMethodBeat.o(24625);
      return localaml;
    }
    paramString = com.tencent.mm.b.g.getMessageDigest(paramArrayOfByte);
    if (paramArrayOfByte.length >= 256) {
      localaml.bgr(paramString);
    }
    for (;;)
    {
      localaml.bgq(paramString);
      localaml.Mu(paramArrayOfByte.length);
      localaml.bgs(b.ds(localaml.toString(), paramInt));
      s.e(b.d(localaml), paramArrayOfByte, paramArrayOfByte.length);
      break;
      byte[] arrayOfByte = new byte[256];
      System.arraycopy(paramArrayOfByte, 0, arrayOfByte, 0, 256);
      localaml.bgr(com.tencent.mm.b.g.getMessageDigest(arrayOfByte));
    }
  }
  
  private static void a(WXMediaMessage paramWXMediaMessage, com.tencent.mm.plugin.fav.a.g paramg)
  {
    AppMethodBeat.i(24623);
    paramg.field_sourceType = 4;
    paramg.field_favProto.bhd(paramWXMediaMessage.title);
    paramg.field_favProto.bhe(paramWXMediaMessage.description);
    AppMethodBeat.o(24623);
  }
  
  private static void a(WXMediaMessage paramWXMediaMessage, aml paramaml, int paramInt)
  {
    AppMethodBeat.i(24626);
    if (paramWXMediaMessage.thumbData != null)
    {
      Object localObject = com.tencent.mm.b.g.getMessageDigest(paramWXMediaMessage.thumbData);
      paramaml.bgv((String)localObject);
      if (paramWXMediaMessage.thumbData.length >= 256) {
        paramaml.bgw((String)localObject);
      }
      for (;;)
      {
        if (Util.isNullOrNil(paramaml.dLl)) {
          paramaml.bgs(b.ds(paramaml.toString(), paramInt));
        }
        paramaml.Mv(paramWXMediaMessage.thumbData.length);
        paramaml = b.a(paramaml);
        paramWXMediaMessage = paramWXMediaMessage.thumbData;
        s.e(paramaml, paramWXMediaMessage, paramWXMediaMessage.length);
        AppMethodBeat.o(24626);
        return;
        localObject = new byte[256];
        System.arraycopy(paramWXMediaMessage.thumbData, 0, localObject, 0, 256);
        paramaml.bgw(com.tencent.mm.b.g.getMessageDigest((byte[])localObject));
      }
    }
    paramaml.At(true);
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
    if (this.dRc == null) {
      this.dRc = getIntent();
    }
    this.dQL = this.dRc.getExtras();
    this.appId = this.dQL.getString("SendAppMessageWrapper_AppId");
    if (this.appId == null) {
      this.appId = Uri.parse(this.dQL.getString("_mmessage_content")).getQueryParameter("appid");
    }
    this.tnr = new SendMessageToWX.Req(this.dQL);
    if (this.tnr.scene != 2)
    {
      Log.e("MicroMsg.FavOpenApiEntry", "scene not WXSceneFavorite!");
      finish();
      AppMethodBeat.o(24620);
      return;
    }
    this.tns = getString(2131759168);
    this.source = getString(2131757790, new Object[] { b.getAppName(this, this.appId) });
    this.timer.startTimer(100L);
    AppMethodBeat.o(24620);
  }
  
  public void onNewIntent(Intent paramIntent)
  {
    AppMethodBeat.i(24621);
    super.onNewIntent(paramIntent);
    this.dRc = paramIntent;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.favorite.ui.FavOpenApiEntry
 * JD-Core Version:    0.7.0.1
 */