package com.tencent.mm.plugin.game.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.provider.Settings.Secure;
import android.provider.Settings.SettingNotFoundException;
import android.view.View.OnClickListener;
import android.widget.Toast;
import com.tencent.mm.h.c.r;
import com.tencent.mm.kernel.e;
import com.tencent.mm.plugin.downloader.model.FileDownloadTaskInfo;
import com.tencent.mm.plugin.downloader.model.e.a;
import com.tencent.mm.plugin.game.g.b;
import com.tencent.mm.plugin.game.g.i;
import com.tencent.mm.plugin.game.model.k;
import com.tencent.mm.pluginsdk.model.app.q;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;

public abstract class c
  implements View.OnClickListener
{
  protected long ghp = -1L;
  protected com.tencent.mm.plugin.game.model.d kOM = null;
  protected int kQh;
  protected String kWK;
  protected FileDownloadTaskInfo kWL;
  protected com.tencent.mm.plugin.downloader.f.a kWM;
  protected String kWN;
  protected String kWO;
  protected String kWP;
  private String kWQ = "xiaomi";
  protected Context mContext;
  protected int mStatus = -1;
  
  public c(Context paramContext)
  {
    this.mContext = paramContext;
  }
  
  private void gz(boolean paramBoolean)
  {
    e.a locala;
    if (paramBoolean)
    {
      k.a(this.kOM.cvy, this.kOM.cvD, this.kOM.bXn, this.kOM.field_appId, this.kWN, "app_update");
      locala = new e.a();
      locala.zN(this.kOM.cvy);
      locala.zO(this.kOM.kOq);
      locala.dp(this.kOM.kOr);
      locala.zP(com.tencent.mm.pluginsdk.model.app.g.b(this.mContext, this.kOM, null));
      locala.setAppId(this.kOM.field_appId);
      locala.zQ(this.kOM.cvD);
      locala.eO(true);
      locala.pE(1);
      locala.cq(this.kOM.field_packageName);
      locala.setScene(this.kOM.bXn);
      if (this.kOM.bOz != 1) {
        break label321;
      }
    }
    label321:
    for (long l = com.tencent.mm.plugin.downloader.model.d.aFP().b(locala.iPG);; l = com.tencent.mm.plugin.downloader.model.d.aFP().a(locala.iPG))
    {
      y.i("MicroMsg.CommonGameClickLinstener", " add download task result:[%d], appid[%s]，downloaerType[%d]", new Object[] { Long.valueOf(l), this.kOM.field_appId, Integer.valueOf(this.kOM.bOz) });
      com.tencent.mm.plugin.game.model.f.aj(this.mContext, this.kOM.field_appId);
      com.tencent.mm.game.report.api.b.dCw.a(this.kOM.field_appId, this.kOM.bXn, 9, l, "", null);
      com.tencent.mm.modelstat.d.b(10, "CommonGameClickListener_addDownloadTask", hashCode());
      return;
      k.a(this.kOM.cvy, this.kOM.cvD, this.kOM.bXn, this.kOM.field_appId, this.kWN, this.kWP);
      break;
    }
  }
  
  protected final void aZU()
  {
    com.tencent.mm.plugin.game.model.f.ai(this.mContext, this.kOM.field_appId);
  }
  
  protected final void aZV()
  {
    this.kWM = com.tencent.mm.plugin.downloader.model.c.zH(this.kOM.field_appId);
    this.kWL = com.tencent.mm.plugin.downloader.model.d.aFP().zL(this.kOM.field_appId);
    this.ghp = this.kWL.id;
    this.mStatus = this.kWL.status;
    this.kWK = this.kWL.path;
  }
  
  protected final void gy(final boolean paramBoolean)
  {
    if (!aq.isNetworkConnected(this.mContext))
    {
      Toast.makeText(this.mContext, this.mContext.getString(g.i.game_download_network_unavailable), 0).show();
      k.aZi();
      k.a(this.kOM.field_appId, com.tencent.mm.plugin.downloader.a.a.iOq, false, null);
    }
    for (;;)
    {
      return;
      com.tencent.mm.kernel.g.DQ();
      if (!com.tencent.mm.kernel.g.DP().isSDCardAvailable())
      {
        Toast.makeText(this.mContext, this.mContext.getString(g.i.game_download_sdcard_unavailable), 0).show();
        k.aZi();
        k.a(this.kOM.field_appId, com.tencent.mm.plugin.downloader.a.a.iOr, false, null);
        return;
      }
      if (!com.tencent.mm.compatible.util.f.bs(this.kOM.kOr))
      {
        Toast.makeText(this.mContext, this.mContext.getString(g.i.game_download_not_enough_space), 0).show();
        k.aZi();
        k.a(this.kOM.field_appId, com.tencent.mm.plugin.downloader.a.a.iOr, false, null);
        return;
      }
      if (com.tencent.mm.protocal.d.soU.toLowerCase().contains(this.kWQ)) {}
      try
      {
        if ((Settings.Secure.getInt(this.mContext.getContentResolver(), "install_non_market_apps") == 0) && (!com.tencent.mm.plugin.game.model.f.dq(this.mContext)))
        {
          com.tencent.mm.ui.base.h.a(this.mContext, g.i.game_show_tips_message, g.i.game_show_tips_title, g.i.game_gcontact_authorize_title, g.i.app_cancel, false, new c.3(this), new c.4(this));
          com.tencent.mm.plugin.game.model.f.dr(this.mContext);
        }
        if ((bk.bl(this.kOM.cvy)) || (bk.bl(this.kOM.cvD)))
        {
          y.d("MicroMsg.CommonGameClickLinstener", "downloadApk: appdownloadurl is null or appmd5 is null, try gpDownload");
          if (bk.bl(this.kOM.cvE))
          {
            y.e("MicroMsg.CommonGameClickLinstener", "downloadApk fail, gpDownloadUrl is null");
            if (bk.bl(this.kOM.cvy))
            {
              k.aZi();
              k.a(this.kOM.field_appId, com.tencent.mm.plugin.downloader.a.a.DOWNLOAD_ERR_URL_INVALID, false, null);
            }
            if (!bk.bl(this.kOM.cvD)) {
              continue;
            }
            k.aZi();
            k.a(this.kOM.field_appId, com.tencent.mm.plugin.downloader.a.a.iOo, false, null);
            return;
          }
        }
      }
      catch (Settings.SettingNotFoundException localSettingNotFoundException)
      {
        for (;;)
        {
          y.e("MicroMsg.CommonGameClickLinstener", "SettingNotFoundException ; %S", new Object[] { localSettingNotFoundException.getMessage() });
          continue;
          y.d("MicroMsg.CommonGameClickLinstener", "downloadApk with gp, ret = %b", new Object[] { Boolean.valueOf(q.bk(this.mContext, this.kOM.cvE)) });
        }
        com.tencent.mm.plugin.game.e.b.a(this.mContext, this.kOM.scene, this.kOM.bXn, this.kOM.position, 4, this.kOM.field_appId, this.kQh, this.kOM.bGy, this.kWO);
        if (aq.isWifi(this.mContext))
        {
          gz(paramBoolean);
          return;
        }
        com.tencent.mm.plugin.report.service.h.nFQ.f(14217, new Object[] { this.kOM.field_appId, Integer.valueOf(4), "", this.kOM.cvy, Integer.valueOf(2) });
        com.tencent.mm.ui.base.h.a(this.mContext, this.mContext.getString(g.i.webview_download_ui_download_not_in_wifi_tips), this.mContext.getString(g.i.webview_download_ui_download_not_in_wifi_title), this.mContext.getString(g.i.webview_download_ui_btn_state_to_download), this.mContext.getString(g.i.app_cancel), false, new DialogInterface.OnClickListener()new c.2
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            com.tencent.mm.plugin.report.service.h.nFQ.f(14217, new Object[] { c.this.kOM.field_appId, Integer.valueOf(5), "", c.this.kOM.cvy, Integer.valueOf(2) });
            c.a(c.this, paramBoolean);
            paramAnonymousDialogInterface.dismiss();
          }
        }, new c.2(this), g.b.wechat_green);
      }
    }
  }
  
  public final void setSourceScene(int paramInt)
  {
    this.kQh = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.c
 * JD-Core Version:    0.7.0.1
 */