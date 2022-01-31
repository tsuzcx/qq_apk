package com.tencent.mm.plugin.game.ui;

import android.content.Context;
import android.net.Uri;
import android.view.View;
import android.widget.Toast;
import com.tencent.mm.a.e;
import com.tencent.mm.h.c.r;
import com.tencent.mm.plugin.downloader.f.a;
import com.tencent.mm.plugin.downloader.model.FileDownloadTaskInfo;
import com.tencent.mm.plugin.game.d.bw;
import com.tencent.mm.plugin.game.g.b;
import com.tencent.mm.plugin.game.g.i;
import com.tencent.mm.plugin.game.model.f;
import com.tencent.mm.plugin.game.model.k;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.pluginsdk.model.app.q;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.io.File;

public final class h
  extends c
{
  public h(Context paramContext)
  {
    super(paramContext);
  }
  
  private void bae()
  {
    if (!aq.isNetworkConnected(this.mContext))
    {
      Toast.makeText(this.mContext, this.mContext.getString(g.i.game_download_network_unavailable), 0).show();
      return;
    }
    if (aq.isWifi(this.mContext))
    {
      baf();
      return;
    }
    com.tencent.mm.ui.base.h.a(this.mContext, this.mContext.getString(g.i.webview_download_ui_download_not_in_wifi_tips), this.mContext.getString(g.i.webview_download_ui_download_not_in_wifi_title), this.mContext.getString(g.i.webview_download_ui_btn_state_to_download), this.mContext.getString(g.i.app_cancel), false, new h.1(this), new h.2(this), g.b.wechat_green);
  }
  
  private void baf()
  {
    com.tencent.mm.game.report.api.b.dCw.a(this.kOM.field_appId, this.kOM.bXn, 10, this.kWM.field_downloadId, "", null);
    com.tencent.mm.modelstat.d.b(10, "GameClickListener_resumeDownloadTask", hashCode());
    if (com.tencent.mm.plugin.downloader.model.d.aFP().df(this.kWM.field_downloadId))
    {
      f.aj(this.mContext, this.kOM.field_appId);
      com.tencent.mm.plugin.game.e.b.a(this.mContext, this.kOM.scene, this.kOM.bXn, this.kOM.position, 4, this.kOM.field_appId, this.kQh, this.kOM.bGy, this.kWO);
      return;
    }
    y.e("MicroMsg.GameClickListener", "resumeDownloadTask false");
    com.tencent.mm.plugin.downloader.model.d.aFP().dc(this.kWM.field_downloadId);
    gy(false);
  }
  
  private static boolean de(long paramLong)
  {
    a locala = com.tencent.mm.plugin.downloader.model.c.dk(paramLong);
    if ((locala != null) && (locala.field_downloadInWifi))
    {
      locala.field_downloadInWifi = false;
      com.tencent.mm.plugin.downloader.model.c.d(locala);
    }
    return com.tencent.mm.plugin.downloader.model.d.aFP().de(paramLong);
  }
  
  public final void dr(String paramString1, String paramString2)
  {
    this.kWO = paramString1;
    this.kWP = paramString2;
  }
  
  public final void onClick(View paramView)
  {
    int j;
    int i;
    if ((paramView.getTag() instanceof com.tencent.mm.plugin.game.model.d))
    {
      this.kOM = ((com.tencent.mm.plugin.game.model.d)paramView.getTag());
      y.i("MicroMsg.GameClickListener", "Clicked appid = " + this.kOM.field_appId);
      aZV();
      if (!g.o(this.mContext, this.kOM.field_appId)) {
        break label476;
      }
      if (!(this.kOM instanceof com.tencent.mm.plugin.game.model.d)) {
        break label810;
      }
      j = com.tencent.mm.plugin.game.f.c.Fe(this.kOM.field_packageName);
      i = this.kOM.versionCode;
    }
    for (;;)
    {
      boolean bool;
      if (i > j)
      {
        y.i("MicroMsg.GameClickListener", "AppId: %s installed, local: %d, server: %d", new Object[] { this.kOM.field_appId, Integer.valueOf(j), Integer.valueOf(i) });
        k.a(this.kOM.cvy, this.kOM.cvD, this.kOM.bXn, this.kOM.field_appId, this.kWN, "app_update");
        if (this.kWL.status == 1)
        {
          bool = de(this.kWL.id);
          y.i("MicroMsg.GameClickListener", "pauseDownloadTask ret = " + bool);
          return;
          y.e("MicroMsg.GameClickListener", "No AppInfo");
          return;
        }
        if (this.kWL.status == 2)
        {
          bae();
          return;
        }
        if (this.kWL.status == 3)
        {
          if ((e.bK(this.kWL.path)) && (com.tencent.mm.plugin.game.f.c.Ff(this.kWL.path) > j))
          {
            paramView = Uri.fromFile(new File(this.kWL.path));
            q.g(this.mContext, paramView);
            com.tencent.mm.plugin.game.e.b.a(this.mContext, this.kOM.scene, this.kOM.bXn, this.kOM.position, 8, this.kOM.field_appId, this.kQh, this.kOM.bGy, this.kWO);
            return;
          }
          gy(true);
          return;
        }
        gy(true);
        return;
      }
      y.i("MicroMsg.GameClickListener", "launchFromWX, appId = %s, pkg = %s, openId = %s", new Object[] { this.kOM.field_appId, this.kOM.field_packageName, this.kOM.field_openId });
      com.tencent.mm.plugin.game.e.b.a(this.mContext, this.kOM.scene, this.kOM.bXn, this.kOM.position, 3, this.kOM.field_appId, this.kQh, this.kOM.bGy, this.kWO);
      aZU();
      return;
      label476:
      if (this.kOM.aYR())
      {
        com.tencent.mm.plugin.game.f.c.o(this.mContext, this.kOM.kOs.kVm, "game_center_hv_game");
        com.tencent.mm.plugin.game.e.b.a(this.mContext, this.kOM.scene, this.kOM.bXn, this.kOM.position, 29, this.kOM.field_appId, this.kQh, this.kOM.bGy, this.kWO);
        return;
      }
      k.a(this.kOM.cvy, this.kOM.cvD, this.kOM.bXn, this.kOM.field_appId, this.kWN, this.kWP);
      switch (this.mStatus)
      {
      default: 
        gy(false);
        return;
      case 1: 
        bool = de(this.kWL.id);
        y.i("MicroMsg.GameClickListener", "pauseDownloadTask ret = " + bool);
        return;
      case 2: 
        bae();
        return;
      }
      if ((!bk.bl(this.kWK)) && (e.bK(this.kWK)) && (com.tencent.mm.plugin.game.f.c.ds(this.kWK, this.kWM.field_md5)))
      {
        paramView = this.kOM.field_appId;
        i = this.kOM.bXn;
        long l = this.kWM.field_downloadId;
        paramView = this.kWM.field_channelId;
        com.tencent.mm.plugin.game.f.c.eQ(l);
        com.tencent.mm.plugin.game.e.b.a(this.mContext, this.kOM.scene, this.kOM.bXn, this.kOM.position, 8, this.kOM.field_appId, this.kQh, this.kOM.bGy, this.kWO);
        return;
      }
      gy(false);
      return;
      label810:
      i = 0;
      j = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.h
 * JD-Core Version:    0.7.0.1
 */