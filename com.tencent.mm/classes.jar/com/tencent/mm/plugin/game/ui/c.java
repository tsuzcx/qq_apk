package com.tencent.mm.plugin.game.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.provider.Settings.Secure;
import android.provider.Settings.SettingNotFoundException;
import android.view.View.OnClickListener;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.b.z;
import com.tencent.mm.game.report.g;
import com.tencent.mm.plugin.downloader.e.b;
import com.tencent.mm.plugin.downloader.model.FileDownloadTaskInfo;
import com.tencent.mm.plugin.downloader.model.g.a;
import com.tencent.mm.plugin.game.h.b;
import com.tencent.mm.plugin.game.h.i;
import com.tencent.mm.plugin.game.model.e;
import com.tencent.mm.pluginsdk.model.app.v;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;

public abstract class c
  implements View.OnClickListener
{
  protected com.tencent.mm.plugin.game.model.c IDb = null;
  protected int IFc;
  protected String IMH;
  protected FileDownloadTaskInfo IMI;
  protected com.tencent.mm.plugin.downloader.f.a IMJ;
  protected String IMK;
  protected String IML;
  protected String IMM;
  private String IMN = "xiaomi";
  protected Context mContext;
  protected int mStatus = -1;
  protected long rzd = -1L;
  
  public c(Context paramContext)
  {
    this.mContext = paramContext;
  }
  
  private void wv(boolean paramBoolean)
  {
    g.a locala;
    if (paramBoolean)
    {
      com.tencent.mm.plugin.game.model.k.a(this.IDb.jOq, this.IDb.jOv, this.IDb.hYi, this.IDb.field_appId, this.IMK, "app_update");
      locala = new g.a();
      locala.amR(this.IDb.jOq);
      locala.amS(this.IDb.ICy);
      locala.setFileSize(this.IDb.tQv);
      locala.amT(com.tencent.mm.pluginsdk.model.app.h.a(this.mContext, this.IDb, null));
      locala.setAppId(this.IDb.field_appId);
      locala.setFileMD5(this.IDb.jOv);
      locala.nA(true);
      locala.JA(1);
      locala.setPackageName(this.IDb.field_packageName);
      locala.setScene(this.IDb.hYi);
      if (this.IDb.hMd != 1) {
        break label324;
      }
    }
    label324:
    for (long l = com.tencent.mm.plugin.downloader.model.f.duv().b(locala.xoe);; l = com.tencent.mm.plugin.downloader.model.f.duv().a(locala.xoe))
    {
      Log.i("MicroMsg.CommonGameClickLinstener", " add download task result:[%d], appid[%s]，downloaerType[%d]", new Object[] { Long.valueOf(l), this.IDb.field_appId, Integer.valueOf(this.IDb.hMd) });
      e.aU(this.mContext, this.IDb.field_appId);
      com.tencent.mm.plugin.downloader.e.a.a(9, new b(this.IDb.field_appId, this.IDb.hYi, l, ""));
      com.tencent.mm.modelstat.d.d(10, "CommonGameClickListener_addDownloadTask", hashCode());
      return;
      com.tencent.mm.plugin.game.model.k.a(this.IDb.jOq, this.IDb.jOv, this.IDb.hYi, this.IDb.field_appId, this.IMK, this.IMM);
      break;
    }
  }
  
  protected final void fHi()
  {
    e.au(this.mContext, this.IDb.field_appId);
  }
  
  protected final void fHj()
  {
    this.IMJ = com.tencent.mm.plugin.downloader.model.d.amJ(this.IDb.field_appId);
    this.IMI = com.tencent.mm.plugin.downloader.model.f.duv().amO(this.IDb.field_appId);
    this.rzd = this.IMI.id;
    this.mStatus = this.IMI.status;
    this.IMH = this.IMI.path;
  }
  
  public final void setSourceScene(int paramInt)
  {
    this.IFc = paramInt;
  }
  
  protected final void wu(final boolean paramBoolean)
  {
    if (!NetStatusUtil.isNetworkConnected(this.mContext))
    {
      Toast.makeText(this.mContext, this.mContext.getString(h.i.game_download_network_unavailable), 0).show();
      com.tencent.mm.plugin.game.model.k.fGm();
      com.tencent.mm.plugin.game.model.k.b(this.IDb.field_appId, com.tencent.mm.plugin.downloader.a.a.xkx, false, null);
    }
    for (;;)
    {
      return;
      com.tencent.mm.kernel.h.baF();
      if (!com.tencent.mm.kernel.h.baE().isSDCardAvailable())
      {
        Toast.makeText(this.mContext, this.mContext.getString(h.i.game_download_sdcard_unavailable), 0).show();
        com.tencent.mm.plugin.game.model.k.fGm();
        com.tencent.mm.plugin.game.model.k.b(this.IDb.field_appId, com.tencent.mm.plugin.downloader.a.a.xky, false, null);
        return;
      }
      if ((!com.tencent.mm.plugin.downloader.model.h.lj(this.IDb.tQv)) && (!com.tencent.mm.plugin.downloader.model.h.li(this.IDb.tQv)))
      {
        Toast.makeText(this.mContext, this.mContext.getString(h.i.game_download_not_enough_space), 0).show();
        com.tencent.mm.plugin.game.model.k.fGm();
        com.tencent.mm.plugin.game.model.k.b(this.IDb.field_appId, com.tencent.mm.plugin.downloader.a.a.xky, false, null);
        return;
      }
      if (com.tencent.mm.protocal.d.Yxa.toLowerCase().contains(this.IMN)) {}
      try
      {
        if ((Settings.Secure.getInt(this.mContext.getContentResolver(), "install_non_market_apps") == 0) && (!e.hM(this.mContext)))
        {
          com.tencent.mm.ui.base.k.a(this.mContext, h.i.IbX, h.i.IbY, h.i.IaZ, h.i.app_cancel, false, new c.3(this), new c.4(this));
          e.hN(this.mContext);
        }
        if ((Util.isNullOrNil(this.IDb.jOq)) || (Util.isNullOrNil(this.IDb.jOv)))
        {
          Log.d("MicroMsg.CommonGameClickLinstener", "downloadApk: appdownloadurl is null or appmd5 is null, try gpDownload");
          if (Util.isNullOrNil(this.IDb.jOw))
          {
            Log.e("MicroMsg.CommonGameClickLinstener", "downloadApk fail, gpDownloadUrl is null");
            if (Util.isNullOrNil(this.IDb.jOq))
            {
              com.tencent.mm.plugin.game.model.k.fGm();
              com.tencent.mm.plugin.game.model.k.b(this.IDb.field_appId, com.tencent.mm.plugin.downloader.a.a.DOWNLOAD_ERR_URL_INVALID, false, null);
            }
            if (!Util.isNullOrNil(this.IDb.jOv)) {
              continue;
            }
            com.tencent.mm.plugin.game.model.k.fGm();
            com.tencent.mm.plugin.game.model.k.b(this.IDb.field_appId, com.tencent.mm.plugin.downloader.a.a.xkv, false, null);
            return;
          }
        }
      }
      catch (Settings.SettingNotFoundException localSettingNotFoundException)
      {
        for (;;)
        {
          Log.e("MicroMsg.CommonGameClickLinstener", "SettingNotFoundException ; %S", new Object[] { localSettingNotFoundException.getMessage() });
          continue;
          Log.d("MicroMsg.CommonGameClickLinstener", "downloadApk with gp, ret = %b", new Object[] { Boolean.valueOf(v.cH(this.mContext, this.IDb.jOw)) });
        }
        g.a(this.mContext, this.IDb.scene, this.IDb.hYi, this.IDb.position, 4, this.IDb.field_appId, this.IFc, this.IDb.hAR, this.IML);
        if (NetStatusUtil.isWifi(this.mContext))
        {
          wv(paramBoolean);
          return;
        }
        com.tencent.mm.plugin.report.service.h.OAn.b(14217, new Object[] { this.IDb.field_appId, Integer.valueOf(4), "", this.IDb.jOq, Integer.valueOf(2) });
        com.tencent.mm.ui.base.k.a(this.mContext, this.mContext.getString(h.i.webview_download_ui_download_not_in_wifi_tips), this.mContext.getString(h.i.webview_download_ui_download_not_in_wifi_title), this.mContext.getString(h.i.webview_download_ui_btn_state_to_download), this.mContext.getString(h.i.app_cancel), false, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(41858);
            com.tencent.mm.plugin.report.service.h.OAn.b(14217, new Object[] { c.this.IDb.field_appId, Integer.valueOf(5), "", c.this.IDb.jOq, Integer.valueOf(2) });
            c.a(c.this, paramBoolean);
            paramAnonymousDialogInterface.dismiss();
            AppMethodBeat.o(41858);
          }
        }, new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(41859);
            com.tencent.mm.plugin.report.service.h.OAn.b(14217, new Object[] { c.this.IDb.field_appId, Integer.valueOf(6), "", c.this.IDb.jOq, Integer.valueOf(2) });
            paramAnonymousDialogInterface.dismiss();
            Log.i("MicroMsg.CommonGameClickLinstener", "addDownloadTask not wifi, user cancel");
            AppMethodBeat.o(41859);
          }
        }, h.b.wechat_green);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.c
 * JD-Core Version:    0.7.0.1
 */