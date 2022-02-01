package com.tencent.mm.plugin.game.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.view.View;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.b.z;
import com.tencent.mm.game.report.g;
import com.tencent.mm.plugin.downloader.e.b;
import com.tencent.mm.plugin.downloader.model.FileDownloadTaskInfo;
import com.tencent.mm.plugin.downloader.model.f;
import com.tencent.mm.plugin.game.h.b;
import com.tencent.mm.plugin.game.h.i;
import com.tencent.mm.plugin.game.model.e;
import com.tencent.mm.plugin.game.protobuf.cl;
import com.tencent.mm.pluginsdk.model.app.v;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.y;

public final class h
  extends c
{
  public h(Context paramContext)
  {
    super(paramContext);
  }
  
  private void fHr()
  {
    AppMethodBeat.i(41970);
    if (!NetStatusUtil.isNetworkConnected(this.mContext))
    {
      Toast.makeText(this.mContext, this.mContext.getString(h.i.game_download_network_unavailable), 0).show();
      AppMethodBeat.o(41970);
      return;
    }
    if (NetStatusUtil.isWifi(this.mContext))
    {
      fHs();
      AppMethodBeat.o(41970);
      return;
    }
    com.tencent.mm.ui.base.k.a(this.mContext, this.mContext.getString(h.i.webview_download_ui_download_not_in_wifi_tips), this.mContext.getString(h.i.webview_download_ui_download_not_in_wifi_title), this.mContext.getString(h.i.webview_download_ui_btn_state_to_download), this.mContext.getString(h.i.app_cancel), false, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
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
    }, h.b.wechat_green);
    AppMethodBeat.o(41970);
  }
  
  private void fHs()
  {
    AppMethodBeat.i(41971);
    com.tencent.mm.plugin.downloader.e.a.a(10, new b(this.IDb.field_appId, this.IDb.hYi, this.IMJ.field_downloadId, ""));
    com.tencent.mm.modelstat.d.d(10, "GameClickListener_resumeDownloadTask", hashCode());
    if (f.duv().kU(this.IMJ.field_downloadId))
    {
      e.aU(this.mContext, this.IDb.field_appId);
      g.a(this.mContext, this.IDb.scene, this.IDb.hYi, this.IDb.position, 4, this.IDb.field_appId, this.IFc, this.IDb.hAR, this.IML);
      AppMethodBeat.o(41971);
      return;
    }
    Log.e("MicroMsg.GameClickListener", "resumeDownloadTask false");
    f.duv().kR(this.IMJ.field_downloadId);
    wu(false);
    AppMethodBeat.o(41971);
  }
  
  private static boolean kT(long paramLong)
  {
    AppMethodBeat.i(41972);
    com.tencent.mm.plugin.downloader.f.a locala = com.tencent.mm.plugin.downloader.model.d.la(paramLong);
    if ((locala != null) && (locala.field_downloadInWifi))
    {
      locala.field_downloadInWifi = false;
      com.tencent.mm.plugin.downloader.model.d.e(locala);
    }
    boolean bool = f.duv().kT(paramLong);
    AppMethodBeat.o(41972);
    return bool;
  }
  
  public final void je(String paramString1, String paramString2)
  {
    this.IML = paramString1;
    this.IMM = paramString2;
  }
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(41969);
    int j;
    int i;
    if ((paramView.getTag() instanceof com.tencent.mm.plugin.game.model.c))
    {
      this.IDb = ((com.tencent.mm.plugin.game.model.c)paramView.getTag());
      Log.i("MicroMsg.GameClickListener", "Clicked appid = " + this.IDb.field_appId);
      fHj();
      if (!com.tencent.mm.pluginsdk.model.app.h.y(this.mContext, this.IDb.field_appId)) {
        break label495;
      }
      if (!(this.IDb instanceof com.tencent.mm.plugin.game.model.c)) {
        break label819;
      }
      j = com.tencent.mm.plugin.game.d.c.aHj(this.IDb.field_packageName);
      i = this.IDb.versionCode;
    }
    for (;;)
    {
      if (i > j)
      {
        Log.i("MicroMsg.GameClickListener", "AppId: %s installed, local: %d, server: %d", new Object[] { this.IDb.field_appId, Integer.valueOf(j), Integer.valueOf(i) });
        com.tencent.mm.plugin.game.model.k.a(this.IDb.jOq, this.IDb.jOv, this.IDb.hYi, this.IDb.field_appId, this.IMK, "app_update");
        if (this.IMI.status == 1)
        {
          Log.i("MicroMsg.GameClickListener", "pauseDownloadTask ret = ".concat(String.valueOf(kT(this.IMI.id))));
          AppMethodBeat.o(41969);
          return;
          Log.e("MicroMsg.GameClickListener", "No AppInfo");
          AppMethodBeat.o(41969);
          return;
        }
        if (this.IMI.status == 2)
        {
          fHr();
          AppMethodBeat.o(41969);
          return;
        }
        if (this.IMI.status == 3)
        {
          if ((y.ZC(this.IMI.path)) && (com.tencent.mm.plugin.game.d.c.aHl(this.IMI.path) > j))
          {
            v.b(this.mContext, this.IMI.path, null, false);
            g.a(this.mContext, this.IDb.scene, this.IDb.hYi, this.IDb.position, 8, this.IDb.field_appId, this.IFc, this.IDb.hAR, this.IML);
            AppMethodBeat.o(41969);
            return;
          }
          wu(true);
          AppMethodBeat.o(41969);
          return;
        }
        wu(true);
        AppMethodBeat.o(41969);
        return;
      }
      Log.i("MicroMsg.GameClickListener", "launchFromWX, appId = %s, pkg = %s, openId = %s", new Object[] { this.IDb.field_appId, this.IDb.field_packageName, this.IDb.field_openId });
      g.a(this.mContext, this.IDb.scene, this.IDb.hYi, this.IDb.position, 3, this.IDb.field_appId, this.IFc, this.IDb.hAR, this.IML);
      fHi();
      AppMethodBeat.o(41969);
      return;
      label495:
      if (this.IDb.fFS())
      {
        com.tencent.mm.plugin.game.d.c.I(this.mContext, this.IDb.ICz.IKI, "game_center_hv_game");
        g.a(this.mContext, this.IDb.scene, this.IDb.hYi, this.IDb.position, 29, this.IDb.field_appId, this.IFc, this.IDb.hAR, this.IML);
        AppMethodBeat.o(41969);
        return;
      }
      com.tencent.mm.plugin.game.model.k.a(this.IDb.jOq, this.IDb.jOv, this.IDb.hYi, this.IDb.field_appId, this.IMK, this.IMM);
      switch (this.mStatus)
      {
      default: 
        wu(false);
        AppMethodBeat.o(41969);
        return;
      case 1: 
        Log.i("MicroMsg.GameClickListener", "pauseDownloadTask ret = ".concat(String.valueOf(kT(this.IMI.id))));
        AppMethodBeat.o(41969);
        return;
      case 2: 
        fHr();
        AppMethodBeat.o(41969);
        return;
      }
      if ((!Util.isNullOrNil(this.IMH)) && (y.ZC(this.IMH)) && (com.tencent.mm.plugin.game.d.c.jh(this.IMH, this.IMJ.field_md5)))
      {
        com.tencent.mm.plugin.game.d.c.rH(this.IMJ.field_downloadId);
        g.a(this.mContext, this.IDb.scene, this.IDb.hYi, this.IDb.position, 8, this.IDb.field_appId, this.IFc, this.IDb.hAR, this.IML);
        AppMethodBeat.o(41969);
        return;
      }
      wu(false);
      AppMethodBeat.o(41969);
      return;
      label819:
      i = 0;
      j = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.h
 * JD-Core Version:    0.7.0.1
 */