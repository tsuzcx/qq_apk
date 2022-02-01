package com.tencent.mm.plugin.game.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.provider.Settings.Secure;
import android.provider.Settings.SettingNotFoundException;
import android.view.View.OnClickListener;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.c.y;
import com.tencent.mm.game.report.g;
import com.tencent.mm.plugin.downloader.f.b;
import com.tencent.mm.plugin.downloader.model.FileDownloadTaskInfo;
import com.tencent.mm.plugin.downloader.model.g.a;
import com.tencent.mm.plugin.game.g.b;
import com.tencent.mm.plugin.game.g.i;
import com.tencent.mm.plugin.game.model.e;
import com.tencent.mm.plugin.game.model.k;
import com.tencent.mm.pluginsdk.model.app.r;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;

public abstract class c
  implements View.OnClickListener
{
  protected com.tencent.mm.plugin.game.model.c CIQ = null;
  protected int CKU;
  protected String CSr;
  protected FileDownloadTaskInfo CSs;
  protected com.tencent.mm.plugin.downloader.g.a CSt;
  protected String CSu;
  protected String CSv;
  protected String CSw;
  private String CSx = "xiaomi";
  protected Context mContext;
  protected int mStatus = -1;
  protected long ovJ = -1L;
  
  public c(Context paramContext)
  {
    this.mContext = paramContext;
  }
  
  private void sp(boolean paramBoolean)
  {
    g.a locala;
    if (paramBoolean)
    {
      k.a(this.CIQ.hrD, this.CIQ.hrI, this.CIQ.fSl, this.CIQ.field_appId, this.CSu, "app_update");
      locala = new g.a();
      locala.atc(this.CIQ.hrD);
      locala.atd(this.CIQ.CIo);
      locala.setFileSize(this.CIQ.qLO);
      locala.ate(com.tencent.mm.pluginsdk.model.app.h.a(this.mContext, this.CIQ, null));
      locala.setAppId(this.CIQ.field_appId);
      locala.setFileMD5(this.CIQ.hrI);
      locala.me(true);
      locala.IS(1);
      locala.setPackageName(this.CIQ.field_packageName);
      locala.setScene(this.CIQ.fSl);
      if (this.CIQ.fGH != 1) {
        break label324;
      }
    }
    label324:
    for (long l = com.tencent.mm.plugin.downloader.model.f.cPZ().b(locala.uhY);; l = com.tencent.mm.plugin.downloader.model.f.cPZ().a(locala.uhY))
    {
      Log.i("MicroMsg.CommonGameClickLinstener", " add download task result:[%d], appid[%s]，downloaerType[%d]", new Object[] { Long.valueOf(l), this.CIQ.field_appId, Integer.valueOf(this.CIQ.fGH) });
      e.aS(this.mContext, this.CIQ.field_appId);
      com.tencent.mm.plugin.downloader.f.a.a(9, new b(this.CIQ.field_appId, this.CIQ.fSl, l, ""));
      com.tencent.mm.modelstat.d.d(10, "CommonGameClickListener_addDownloadTask", hashCode());
      return;
      k.a(this.CIQ.hrD, this.CIQ.hrI, this.CIQ.fSl, this.CIQ.field_appId, this.CSu, this.CSw);
      break;
    }
  }
  
  protected final void ezm()
  {
    e.at(this.mContext, this.CIQ.field_appId);
  }
  
  protected final void ezn()
  {
    this.CSt = com.tencent.mm.plugin.downloader.model.d.asU(this.CIQ.field_appId);
    this.CSs = com.tencent.mm.plugin.downloader.model.f.cPZ().asZ(this.CIQ.field_appId);
    this.ovJ = this.CSs.id;
    this.mStatus = this.CSs.status;
    this.CSr = this.CSs.path;
  }
  
  public final void setSourceScene(int paramInt)
  {
    this.CKU = paramInt;
  }
  
  protected final void so(final boolean paramBoolean)
  {
    if (!NetStatusUtil.isNetworkConnected(this.mContext))
    {
      Toast.makeText(this.mContext, this.mContext.getString(g.i.game_download_network_unavailable), 0).show();
      k.eyq();
      k.a(this.CIQ.field_appId, com.tencent.mm.plugin.downloader.a.a.uev, false, null);
    }
    for (;;)
    {
      return;
      com.tencent.mm.kernel.h.aHH();
      if (!com.tencent.mm.kernel.h.aHG().isSDCardAvailable())
      {
        Toast.makeText(this.mContext, this.mContext.getString(g.i.game_download_sdcard_unavailable), 0).show();
        k.eyq();
        k.a(this.CIQ.field_appId, com.tencent.mm.plugin.downloader.a.a.uew, false, null);
        return;
      }
      if ((!com.tencent.mm.plugin.downloader.model.h.IO(this.CIQ.qLO)) && (!com.tencent.mm.plugin.downloader.model.h.IN(this.CIQ.qLO)))
      {
        Toast.makeText(this.mContext, this.mContext.getString(g.i.game_download_not_enough_space), 0).show();
        k.eyq();
        k.a(this.CIQ.field_appId, com.tencent.mm.plugin.downloader.a.a.uew, false, null);
        return;
      }
      if (com.tencent.mm.protocal.d.RAw.toLowerCase().contains(this.CSx)) {}
      try
      {
        if ((Settings.Secure.getInt(this.mContext.getContentResolver(), "install_non_market_apps") == 0) && (!e.gt(this.mContext)))
        {
          com.tencent.mm.ui.base.h.a(this.mContext, g.i.CpP, g.i.CpQ, g.i.CoR, g.i.app_cancel, false, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              AppMethodBeat.i(41860);
              Object localObject = new Intent("android.settings.SECURITY_SETTINGS");
              Context localContext = c.this.mContext;
              localObject = new com.tencent.mm.hellhoundlib.b.a().bm(localObject);
              com.tencent.mm.hellhoundlib.a.a.b(localContext, ((com.tencent.mm.hellhoundlib.b.a)localObject).aFh(), "com/tencent/mm/plugin/game/ui/CommonGameClickListener$3", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              localContext.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sf(0));
              com.tencent.mm.hellhoundlib.a.a.c(localContext, "com/tencent/mm/plugin/game/ui/CommonGameClickListener$3", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              paramAnonymousDialogInterface.cancel();
              AppMethodBeat.o(41860);
            }
          }, new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              AppMethodBeat.i(41861);
              paramAnonymousDialogInterface.cancel();
              AppMethodBeat.o(41861);
            }
          });
          e.gu(this.mContext);
        }
        if ((Util.isNullOrNil(this.CIQ.hrD)) || (Util.isNullOrNil(this.CIQ.hrI)))
        {
          Log.d("MicroMsg.CommonGameClickLinstener", "downloadApk: appdownloadurl is null or appmd5 is null, try gpDownload");
          if (Util.isNullOrNil(this.CIQ.hrJ))
          {
            Log.e("MicroMsg.CommonGameClickLinstener", "downloadApk fail, gpDownloadUrl is null");
            if (Util.isNullOrNil(this.CIQ.hrD))
            {
              k.eyq();
              k.a(this.CIQ.field_appId, com.tencent.mm.plugin.downloader.a.a.DOWNLOAD_ERR_URL_INVALID, false, null);
            }
            if (!Util.isNullOrNil(this.CIQ.hrI)) {
              continue;
            }
            k.eyq();
            k.a(this.CIQ.field_appId, com.tencent.mm.plugin.downloader.a.a.uet, false, null);
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
          Log.d("MicroMsg.CommonGameClickLinstener", "downloadApk with gp, ret = %b", new Object[] { Boolean.valueOf(r.cw(this.mContext, this.CIQ.hrJ)) });
        }
        g.a(this.mContext, this.CIQ.scene, this.CIQ.fSl, this.CIQ.position, 4, this.CIQ.field_appId, this.CKU, this.CIQ.fwt, this.CSv);
        if (NetStatusUtil.isWifi(this.mContext))
        {
          sp(paramBoolean);
          return;
        }
        com.tencent.mm.plugin.report.service.h.IzE.a(14217, new Object[] { this.CIQ.field_appId, Integer.valueOf(4), "", this.CIQ.hrD, Integer.valueOf(2) });
        com.tencent.mm.ui.base.h.a(this.mContext, this.mContext.getString(g.i.webview_download_ui_download_not_in_wifi_tips), this.mContext.getString(g.i.webview_download_ui_download_not_in_wifi_title), this.mContext.getString(g.i.webview_download_ui_btn_state_to_download), this.mContext.getString(g.i.app_cancel), false, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(41858);
            com.tencent.mm.plugin.report.service.h.IzE.a(14217, new Object[] { c.this.CIQ.field_appId, Integer.valueOf(5), "", c.this.CIQ.hrD, Integer.valueOf(2) });
            c.a(c.this, paramBoolean);
            paramAnonymousDialogInterface.dismiss();
            AppMethodBeat.o(41858);
          }
        }, new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(41859);
            com.tencent.mm.plugin.report.service.h.IzE.a(14217, new Object[] { c.this.CIQ.field_appId, Integer.valueOf(6), "", c.this.CIQ.hrD, Integer.valueOf(2) });
            paramAnonymousDialogInterface.dismiss();
            Log.i("MicroMsg.CommonGameClickLinstener", "addDownloadTask not wifi, user cancel");
            AppMethodBeat.o(41859);
          }
        }, g.b.wechat_green);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.c
 * JD-Core Version:    0.7.0.1
 */