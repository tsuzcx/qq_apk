package com.tencent.mm.plugin.favorite.ui;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.v;
import com.tencent.mm.opensdk.modelmsg.SendMessageToWX.Req;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.base.stub.d;
import com.tencent.mm.plugin.base.stub.d.a;
import com.tencent.mm.plugin.fav.a.b;
import com.tencent.mm.pluginsdk.model.app.ReportUtil;
import com.tencent.mm.pluginsdk.model.app.ReportUtil.ReportArgs;
import com.tencent.mm.pluginsdk.ui.applet.y.a;
import com.tencent.mm.protocal.protobuf.ajx;
import com.tencent.mm.protocal.protobuf.akn;
import com.tencent.mm.protocal.protobuf.akt;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aw;
import com.tencent.mm.sdk.platformtools.aw.a;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.sdk.platformtools.z;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.a;

@a(7)
public class FavOpenApiEntry
  extends MMActivity
{
  private String appId;
  private aw cYd;
  private Bundle dyY;
  private Intent dzp;
  private SendMessageToWX.Req rNG;
  private String rNH;
  private int rNI;
  private String source;
  
  public FavOpenApiEntry()
  {
    AppMethodBeat.i(24619);
    this.rNI = 0;
    this.cYd = new aw(new aw.a()
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
        new d(FavOpenApiEntry.this, FavOpenApiEntry.c(FavOpenApiEntry.this), FavOpenApiEntry.d(FavOpenApiEntry.this).openId, new d.a()
        {
          public final void jb(boolean paramAnonymous2Boolean)
          {
            AppMethodBeat.i(24616);
            boolean bool = FavOpenApiEntry.this.isFinishing();
            ae.i("MicroMsg.FavOpenApiEntry", "onCheckEnd, isPass = " + paramAnonymous2Boolean + ", isFinishing = " + bool);
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
        }).bMY();
        AppMethodBeat.o(24617);
        return false;
      }
    }, true);
    AppMethodBeat.o(24619);
  }
  
  private void L(com.tencent.mm.plugin.fav.a.g paramg)
  {
    AppMethodBeat.i(24624);
    akt localakt = new akt();
    localakt.aQI(this.appId);
    localakt.aax(4);
    localakt.aQC(v.aAC());
    localakt.aQD(v.aAC());
    paramg.field_fromUser = localakt.dzZ;
    paramg.field_toUser = localakt.toUser;
    paramg.field_favProto.a(localakt);
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
          com.tencent.mm.pluginsdk.ui.tools.o.a(z.getIntExtra(FavOpenApiEntry.this.getIntent(), "_mmessage_sdkVersion", 0), FavOpenApiEntry.c(FavOpenApiEntry.this), paramWXMediaMessage);
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
  
  private static ajx a(WXMediaMessage paramWXMediaMessage, String paramString, byte[] paramArrayOfByte, int paramInt)
  {
    AppMethodBeat.i(24625);
    ajx localajx = new ajx();
    localajx.aPC(paramWXMediaMessage.title);
    localajx.aPD(paramWXMediaMessage.description);
    localajx.aao(paramInt);
    if (paramString != null)
    {
      localajx.aPQ(paramString);
      localajx.aPM(com.tencent.mm.vfs.o.aaw(paramString));
      a(paramWXMediaMessage, localajx, paramInt);
      AppMethodBeat.o(24625);
      return localajx;
    }
    paramString = com.tencent.mm.b.g.getMessageDigest(paramArrayOfByte);
    if (paramArrayOfByte.length >= 256) {
      localajx.aPO(paramString);
    }
    for (;;)
    {
      localajx.aPN(paramString);
      localajx.De(paramArrayOfByte.length);
      localajx.aPP(b.dm(localajx.toString(), paramInt));
      com.tencent.mm.vfs.o.e(b.d(localajx), paramArrayOfByte, paramArrayOfByte.length);
      break;
      byte[] arrayOfByte = new byte[256];
      System.arraycopy(paramArrayOfByte, 0, arrayOfByte, 0, 256);
      localajx.aPO(com.tencent.mm.b.g.getMessageDigest(arrayOfByte));
    }
  }
  
  private static void a(WXMediaMessage paramWXMediaMessage, com.tencent.mm.plugin.fav.a.g paramg)
  {
    AppMethodBeat.i(24623);
    paramg.field_sourceType = 4;
    paramg.field_favProto.aQA(paramWXMediaMessage.title);
    paramg.field_favProto.aQB(paramWXMediaMessage.description);
    AppMethodBeat.o(24623);
  }
  
  private static void a(WXMediaMessage paramWXMediaMessage, ajx paramajx, int paramInt)
  {
    AppMethodBeat.i(24626);
    if (paramWXMediaMessage.thumbData != null)
    {
      Object localObject = com.tencent.mm.b.g.getMessageDigest(paramWXMediaMessage.thumbData);
      paramajx.aPS((String)localObject);
      if (paramWXMediaMessage.thumbData.length >= 256) {
        paramajx.aPT((String)localObject);
      }
      for (;;)
      {
        if (bu.isNullOrNil(paramajx.dua)) {
          paramajx.aPP(b.dm(paramajx.toString(), paramInt));
        }
        paramajx.Df(paramWXMediaMessage.thumbData.length);
        paramajx = b.a(paramajx);
        paramWXMediaMessage = paramWXMediaMessage.thumbData;
        com.tencent.mm.vfs.o.e(paramajx, paramWXMediaMessage, paramWXMediaMessage.length);
        AppMethodBeat.o(24626);
        return;
        localObject = new byte[256];
        System.arraycopy(paramWXMediaMessage.thumbData, 0, localObject, 0, 256);
        paramajx.aPT(com.tencent.mm.b.g.getMessageDigest((byte[])localObject));
      }
    }
    paramajx.wt(true);
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
    if (this.dzp == null) {
      this.dzp = getIntent();
    }
    this.dyY = this.dzp.getExtras();
    this.appId = this.dyY.getString("SendAppMessageWrapper_AppId");
    if (this.appId == null) {
      this.appId = Uri.parse(this.dyY.getString("_mmessage_content")).getQueryParameter("appid");
    }
    this.rNG = new SendMessageToWX.Req(this.dyY);
    if (this.rNG.scene != 2)
    {
      ae.e("MicroMsg.FavOpenApiEntry", "scene not WXSceneFavorite!");
      finish();
      AppMethodBeat.o(24620);
      return;
    }
    this.rNH = getString(2131758845);
    this.source = getString(2131757563, new Object[] { b.getAppName(this, this.appId) });
    this.cYd.ay(100L, 100L);
    AppMethodBeat.o(24620);
  }
  
  public void onNewIntent(Intent paramIntent)
  {
    AppMethodBeat.i(24621);
    super.onNewIntent(paramIntent);
    this.dzp = paramIntent;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.favorite.ui.FavOpenApiEntry
 * JD-Core Version:    0.7.0.1
 */