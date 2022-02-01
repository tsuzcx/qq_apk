package com.tencent.mm.plugin.favorite.ui;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.u;
import com.tencent.mm.opensdk.modelmsg.SendMessageToWX.Req;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.base.stub.d;
import com.tencent.mm.plugin.base.stub.d.a;
import com.tencent.mm.plugin.fav.a.b;
import com.tencent.mm.pluginsdk.model.app.ReportUtil;
import com.tencent.mm.pluginsdk.model.app.ReportUtil.ReportArgs;
import com.tencent.mm.pluginsdk.ui.applet.y.a;
import com.tencent.mm.pluginsdk.ui.tools.o;
import com.tencent.mm.protocal.protobuf.afy;
import com.tencent.mm.protocal.protobuf.ago;
import com.tencent.mm.protocal.protobuf.agu;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.av;
import com.tencent.mm.sdk.platformtools.av.a;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.vfs.i;

@a(7)
public class FavOpenApiEntry
  extends MMActivity
{
  private String appId;
  private av cOx;
  private Intent doO;
  private Bundle dow;
  private SendMessageToWX.Req qmF;
  private String qmG;
  private int qmH;
  private String source;
  
  public FavOpenApiEntry()
  {
    AppMethodBeat.i(24619);
    this.qmH = 0;
    this.cOx = new av(new av.a()
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
          public final void it(boolean paramAnonymous2Boolean)
          {
            AppMethodBeat.i(24616);
            boolean bool = FavOpenApiEntry.this.isFinishing();
            ad.i("MicroMsg.FavOpenApiEntry", "onCheckEnd, isPass = " + paramAnonymous2Boolean + ", isFinishing = " + bool);
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
        }).bAT();
        AppMethodBeat.o(24617);
        return false;
      }
    }, true);
    AppMethodBeat.o(24619);
  }
  
  private void L(com.tencent.mm.plugin.fav.a.g paramg)
  {
    AppMethodBeat.i(24624);
    agu localagu = new agu();
    localagu.aEr(this.appId);
    localagu.VM(4);
    localagu.aEl(u.aqG());
    localagu.aEm(u.aqG());
    paramg.field_fromUser = localagu.dpv;
    paramg.field_toUser = localagu.toUser;
    paramg.field_favProto.a(localagu);
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
          o.a(y.getIntExtra(FavOpenApiEntry.this.getIntent(), "_mmessage_sdkVersion", 0), FavOpenApiEntry.c(FavOpenApiEntry.this), paramWXMediaMessage);
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
  
  private static afy a(WXMediaMessage paramWXMediaMessage, String paramString, byte[] paramArrayOfByte, int paramInt)
  {
    AppMethodBeat.i(24625);
    afy localafy = new afy();
    localafy.aDl(paramWXMediaMessage.title);
    localafy.aDm(paramWXMediaMessage.description);
    localafy.VD(paramInt);
    if (paramString != null)
    {
      localafy.aDz(paramString);
      localafy.aDv(i.RK(paramString));
      a(paramWXMediaMessage, localafy, paramInt);
      AppMethodBeat.o(24625);
      return localafy;
    }
    paramString = com.tencent.mm.b.g.getMessageDigest(paramArrayOfByte);
    if (paramArrayOfByte.length >= 256) {
      localafy.aDx(paramString);
    }
    for (;;)
    {
      localafy.aDw(paramString);
      localafy.vp(paramArrayOfByte.length);
      localafy.aDy(b.cT(localafy.toString(), paramInt));
      i.e(b.d(localafy), paramArrayOfByte, paramArrayOfByte.length);
      break;
      byte[] arrayOfByte = new byte[256];
      System.arraycopy(paramArrayOfByte, 0, arrayOfByte, 0, 256);
      localafy.aDx(com.tencent.mm.b.g.getMessageDigest(arrayOfByte));
    }
  }
  
  private static void a(WXMediaMessage paramWXMediaMessage, com.tencent.mm.plugin.fav.a.g paramg)
  {
    AppMethodBeat.i(24623);
    paramg.field_sourceType = 4;
    paramg.field_favProto.aEj(paramWXMediaMessage.title);
    paramg.field_favProto.aEk(paramWXMediaMessage.description);
    AppMethodBeat.o(24623);
  }
  
  private static void a(WXMediaMessage paramWXMediaMessage, afy paramafy, int paramInt)
  {
    AppMethodBeat.i(24626);
    if (paramWXMediaMessage.thumbData != null)
    {
      Object localObject = com.tencent.mm.b.g.getMessageDigest(paramWXMediaMessage.thumbData);
      paramafy.aDB((String)localObject);
      if (paramWXMediaMessage.thumbData.length >= 256) {
        paramafy.aDC((String)localObject);
      }
      for (;;)
      {
        if (bt.isNullOrNil(paramafy.dkb)) {
          paramafy.aDy(b.cT(paramafy.toString(), paramInt));
        }
        paramafy.vq(paramWXMediaMessage.thumbData.length);
        paramafy = b.a(paramafy);
        paramWXMediaMessage = paramWXMediaMessage.thumbData;
        i.e(paramafy, paramWXMediaMessage, paramWXMediaMessage.length);
        AppMethodBeat.o(24626);
        return;
        localObject = new byte[256];
        System.arraycopy(paramWXMediaMessage.thumbData, 0, localObject, 0, 256);
        paramafy.aDC(com.tencent.mm.b.g.getMessageDigest((byte[])localObject));
      }
    }
    paramafy.ux(true);
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
    if (this.doO == null) {
      this.doO = getIntent();
    }
    this.dow = this.doO.getExtras();
    this.appId = this.dow.getString("SendAppMessageWrapper_AppId");
    if (this.appId == null) {
      this.appId = Uri.parse(this.dow.getString("_mmessage_content")).getQueryParameter("appid");
    }
    this.qmF = new SendMessageToWX.Req(this.dow);
    if (this.qmF.scene != 2)
    {
      ad.e("MicroMsg.FavOpenApiEntry", "scene not WXSceneFavorite!");
      finish();
      AppMethodBeat.o(24620);
      return;
    }
    this.qmG = getString(2131758845);
    this.source = getString(2131757563, new Object[] { b.getAppName(this, this.appId) });
    this.cOx.av(100L, 100L);
    AppMethodBeat.o(24620);
  }
  
  public void onNewIntent(Intent paramIntent)
  {
    AppMethodBeat.i(24621);
    super.onNewIntent(paramIntent);
    this.doO = paramIntent;
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