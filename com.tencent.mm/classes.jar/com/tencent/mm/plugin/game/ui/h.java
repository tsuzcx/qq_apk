package com.tencent.mm.plugin.game.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.view.View;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.c.y;
import com.tencent.mm.game.report.g;
import com.tencent.mm.plugin.downloader.f.b;
import com.tencent.mm.plugin.downloader.model.FileDownloadTaskInfo;
import com.tencent.mm.plugin.downloader.model.f;
import com.tencent.mm.plugin.game.g.b;
import com.tencent.mm.plugin.game.g.i;
import com.tencent.mm.plugin.game.model.e;
import com.tencent.mm.plugin.game.model.k;
import com.tencent.mm.plugin.game.protobuf.ck;
import com.tencent.mm.pluginsdk.model.app.r;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.u;

public final class h
  extends c
{
  public h(Context paramContext)
  {
    super(paramContext);
  }
  
  private static boolean Iy(long paramLong)
  {
    AppMethodBeat.i(41972);
    com.tencent.mm.plugin.downloader.g.a locala = com.tencent.mm.plugin.downloader.model.d.IF(paramLong);
    if ((locala != null) && (locala.field_downloadInWifi))
    {
      locala.field_downloadInWifi = false;
      com.tencent.mm.plugin.downloader.model.d.e(locala);
    }
    boolean bool = f.cPZ().Iy(paramLong);
    AppMethodBeat.o(41972);
    return bool;
  }
  
  private void ezt()
  {
    AppMethodBeat.i(41970);
    if (!NetStatusUtil.isNetworkConnected(this.mContext))
    {
      Toast.makeText(this.mContext, this.mContext.getString(g.i.game_download_network_unavailable), 0).show();
      AppMethodBeat.o(41970);
      return;
    }
    if (NetStatusUtil.isWifi(this.mContext))
    {
      ezu();
      AppMethodBeat.o(41970);
      return;
    }
    com.tencent.mm.ui.base.h.a(this.mContext, this.mContext.getString(g.i.webview_download_ui_download_not_in_wifi_tips), this.mContext.getString(g.i.webview_download_ui_download_not_in_wifi_title), this.mContext.getString(g.i.webview_download_ui_btn_state_to_download), this.mContext.getString(g.i.app_cancel), false, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(41967);
        h.a(h.this);
        paramAnonymousDialogInterface.dismiss();
        AppMethodBeat.o(41967);
      }
    }, new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(41968);
        paramAnonymousDialogInterface.dismiss();
        Log.i("MicroMsg.GameClickListener", "resumeDownloadTask not wifi, user cancel");
        AppMethodBeat.o(41968);
      }
    }, g.b.wechat_green);
    AppMethodBeat.o(41970);
  }
  
  private void ezu()
  {
    AppMethodBeat.i(41971);
    com.tencent.mm.plugin.downloader.f.a.a(10, new b(this.CIQ.field_appId, this.CIQ.fSl, this.CSt.field_downloadId, ""));
    com.tencent.mm.modelstat.d.d(10, "GameClickListener_resumeDownloadTask", hashCode());
    if (f.cPZ().Iz(this.CSt.field_downloadId))
    {
      e.aS(this.mContext, this.CIQ.field_appId);
      g.a(this.mContext, this.CIQ.scene, this.CIQ.fSl, this.CIQ.position, 4, this.CIQ.field_appId, this.CKU, this.CIQ.fwt, this.CSv);
      AppMethodBeat.o(41971);
      return;
    }
    Log.e("MicroMsg.GameClickListener", "resumeDownloadTask false");
    f.cPZ().Iw(this.CSt.field_downloadId);
    so(false);
    AppMethodBeat.o(41971);
  }
  
  public final void hX(String paramString1, String paramString2)
  {
    this.CSv = paramString1;
    this.CSw = paramString2;
  }
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(41969);
    int j;
    int i;
    if ((paramView.getTag() instanceof com.tencent.mm.plugin.game.model.c))
    {
      this.CIQ = ((com.tencent.mm.plugin.game.model.c)paramView.getTag());
      Log.i("MicroMsg.GameClickListener", "Clicked appid = " + this.CIQ.field_appId);
      ezn();
      if (!com.tencent.mm.pluginsdk.model.app.h.u(this.mContext, this.CIQ.field_appId)) {
        break label495;
      }
      if (!(this.CIQ instanceof com.tencent.mm.plugin.game.model.c)) {
        break label819;
      }
      j = com.tencent.mm.plugin.game.d.c.aKt(this.CIQ.field_packageName);
      i = this.CIQ.versionCode;
    }
    for (;;)
    {
      if (i > j)
      {
        Log.i("MicroMsg.GameClickListener", "AppId: %s installed, local: %d, server: %d", new Object[] { this.CIQ.field_appId, Integer.valueOf(j), Integer.valueOf(i) });
        k.a(this.CIQ.hrD, this.CIQ.hrI, this.CIQ.fSl, this.CIQ.field_appId, this.CSu, "app_update");
        if (this.CSs.status == 1)
        {
          Log.i("MicroMsg.GameClickListener", "pauseDownloadTask ret = ".concat(String.valueOf(Iy(this.CSs.id))));
          AppMethodBeat.o(41969);
          return;
          Log.e("MicroMsg.GameClickListener", "No AppInfo");
          AppMethodBeat.o(41969);
          return;
        }
        if (this.CSs.status == 2)
        {
          ezt();
          AppMethodBeat.o(41969);
          return;
        }
        if (this.CSs.status == 3)
        {
          if ((u.agG(this.CSs.path)) && (com.tencent.mm.plugin.game.d.c.aKv(this.CSs.path) > j))
          {
            r.b(this.mContext, this.CSs.path, null, false);
            g.a(this.mContext, this.CIQ.scene, this.CIQ.fSl, this.CIQ.position, 8, this.CIQ.field_appId, this.CKU, this.CIQ.fwt, this.CSv);
            AppMethodBeat.o(41969);
            return;
          }
          so(true);
          AppMethodBeat.o(41969);
          return;
        }
        so(true);
        AppMethodBeat.o(41969);
        return;
      }
      Log.i("MicroMsg.GameClickListener", "launchFromWX, appId = %s, pkg = %s, openId = %s", new Object[] { this.CIQ.field_appId, this.CIQ.field_packageName, this.CIQ.field_openId });
      g.a(this.mContext, this.CIQ.scene, this.CIQ.fSl, this.CIQ.position, 3, this.CIQ.field_appId, this.CKU, this.CIQ.fwt, this.CSv);
      ezm();
      AppMethodBeat.o(41969);
      return;
      label495:
      if (this.CIQ.exW())
      {
        com.tencent.mm.plugin.game.d.c.I(this.mContext, this.CIQ.CIp.CQy, "game_center_hv_game");
        g.a(this.mContext, this.CIQ.scene, this.CIQ.fSl, this.CIQ.position, 29, this.CIQ.field_appId, this.CKU, this.CIQ.fwt, this.CSv);
        AppMethodBeat.o(41969);
        return;
      }
      k.a(this.CIQ.hrD, this.CIQ.hrI, this.CIQ.fSl, this.CIQ.field_appId, this.CSu, this.CSw);
      switch (this.mStatus)
      {
      default: 
        so(false);
        AppMethodBeat.o(41969);
        return;
      case 1: 
        Log.i("MicroMsg.GameClickListener", "pauseDownloadTask ret = ".concat(String.valueOf(Iy(this.CSs.id))));
        AppMethodBeat.o(41969);
        return;
      case 2: 
        ezt();
        AppMethodBeat.o(41969);
        return;
      }
      if ((!Util.isNullOrNil(this.CSr)) && (u.agG(this.CSr)) && (com.tencent.mm.plugin.game.d.c.ia(this.CSr, this.CSt.field_md5)))
      {
        com.tencent.mm.plugin.game.d.c.NQ(this.CSt.field_downloadId);
        g.a(this.mContext, this.CIQ.scene, this.CIQ.fSl, this.CIQ.position, 8, this.CIQ.field_appId, this.CKU, this.CIQ.fwt, this.CSv);
        AppMethodBeat.o(41969);
        return;
      }
      so(false);
      AppMethodBeat.o(41969);
      return;
      label819:
      i = 0;
      j = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.h
 * JD-Core Version:    0.7.0.1
 */