package com.tencent.mm.plugin.game.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.provider.Settings.Secure;
import android.provider.Settings.SettingNotFoundException;
import android.view.View.OnClickListener;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.y;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.downloader.f.b;
import com.tencent.mm.plugin.downloader.model.FileDownloadTaskInfo;
import com.tencent.mm.plugin.downloader.model.g.a;
import com.tencent.mm.plugin.game.model.k;
import com.tencent.mm.pluginsdk.model.app.r;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;

public abstract class c
  implements View.OnClickListener
{
  protected long lAs = -1L;
  protected Context mContext;
  protected int mStatus = -1;
  protected com.tencent.mm.plugin.game.model.c xEP = null;
  protected int xGR;
  protected String xOh;
  protected FileDownloadTaskInfo xOi;
  protected com.tencent.mm.plugin.downloader.g.a xOj;
  protected String xOk;
  protected String xOl;
  protected String xOm;
  private String xOn = "xiaomi";
  
  public c(Context paramContext)
  {
    this.mContext = paramContext;
  }
  
  private void pS(boolean paramBoolean)
  {
    g.a locala;
    if (paramBoolean)
    {
      k.a(this.xEP.fmE, this.xEP.fmJ, this.xEP.dYu, this.xEP.field_appId, this.xOk, "app_update");
      locala = new g.a();
      locala.alj(this.xEP.fmE);
      locala.alk(this.xEP.xEn);
      locala.setFileSize(this.xEP.nJC);
      locala.all(com.tencent.mm.pluginsdk.model.app.h.a(this.mContext, this.xEP, null));
      locala.setAppId(this.xEP.field_appId);
      locala.setFileMD5(this.xEP.fmJ);
      locala.kS(true);
      locala.Fl(1);
      locala.gm(this.xEP.field_packageName);
      locala.setScene(this.xEP.dYu);
      if (this.xEP.dNv != 1) {
        break label324;
      }
    }
    label324:
    for (long l = com.tencent.mm.plugin.downloader.model.f.cBv().b(locala.qIY);; l = com.tencent.mm.plugin.downloader.model.f.cBv().a(locala.qIY))
    {
      Log.i("MicroMsg.CommonGameClickLinstener", " add download task result:[%d], appid[%s]，downloaerType[%d]", new Object[] { Long.valueOf(l), this.xEP.field_appId, Integer.valueOf(this.xEP.dNv) });
      com.tencent.mm.plugin.game.model.e.aK(this.mContext, this.xEP.field_appId);
      com.tencent.mm.plugin.downloader.f.a.a(9, new b(this.xEP.field_appId, this.xEP.dYu, l, ""));
      com.tencent.mm.modelstat.d.d(10, "CommonGameClickListener_addDownloadTask", hashCode());
      return;
      k.a(this.xEP.fmE, this.xEP.fmJ, this.xEP.dYu, this.xEP.field_appId, this.xOk, this.xOm);
      break;
    }
  }
  
  protected final void dWe()
  {
    com.tencent.mm.plugin.game.model.e.at(this.mContext, this.xEP.field_appId);
  }
  
  protected final void dWf()
  {
    this.xOj = com.tencent.mm.plugin.downloader.model.d.alb(this.xEP.field_appId);
    this.xOi = com.tencent.mm.plugin.downloader.model.f.cBv().alg(this.xEP.field_appId);
    this.lAs = this.xOi.id;
    this.mStatus = this.xOi.status;
    this.xOh = this.xOi.path;
  }
  
  protected final void pR(final boolean paramBoolean)
  {
    if (!NetStatusUtil.isNetworkConnected(this.mContext))
    {
      Toast.makeText(this.mContext, this.mContext.getString(2131761199), 0).show();
      k.dVi();
      k.a(this.xEP.field_appId, com.tencent.mm.plugin.downloader.a.a.qFt, false, null);
    }
    for (;;)
    {
      return;
      g.aAi();
      if (!g.aAh().isSDCardAvailable())
      {
        Toast.makeText(this.mContext, this.mContext.getString(2131761203), 0).show();
        k.dVi();
        k.a(this.xEP.field_appId, com.tencent.mm.plugin.downloader.a.a.qFu, false, null);
        return;
      }
      if ((!com.tencent.mm.plugin.downloader.model.h.CF(this.xEP.nJC)) && (!com.tencent.mm.plugin.downloader.model.h.CE(this.xEP.nJC)))
      {
        Toast.makeText(this.mContext, this.mContext.getString(2131761200), 0).show();
        k.dVi();
        k.a(this.xEP.field_appId, com.tencent.mm.plugin.downloader.a.a.qFu, false, null);
        return;
      }
      if (com.tencent.mm.protocal.d.KyI.toLowerCase().contains(this.xOn)) {}
      try
      {
        if ((Settings.Secure.getInt(this.mContext.getContentResolver(), "install_non_market_apps") == 0) && (!com.tencent.mm.plugin.game.model.e.fZ(this.mContext)))
        {
          com.tencent.mm.ui.base.h.a(this.mContext, 2131761351, 2131761352, 2131761222, 2131755761, false, new c.3(this), new c.4(this));
          com.tencent.mm.plugin.game.model.e.ga(this.mContext);
        }
        if ((Util.isNullOrNil(this.xEP.fmE)) || (Util.isNullOrNil(this.xEP.fmJ)))
        {
          Log.d("MicroMsg.CommonGameClickLinstener", "downloadApk: appdownloadurl is null or appmd5 is null, try gpDownload");
          if (Util.isNullOrNil(this.xEP.fmK))
          {
            Log.e("MicroMsg.CommonGameClickLinstener", "downloadApk fail, gpDownloadUrl is null");
            if (Util.isNullOrNil(this.xEP.fmE))
            {
              k.dVi();
              k.a(this.xEP.field_appId, com.tencent.mm.plugin.downloader.a.a.DOWNLOAD_ERR_URL_INVALID, false, null);
            }
            if (!Util.isNullOrNil(this.xEP.fmJ)) {
              continue;
            }
            k.dVi();
            k.a(this.xEP.field_appId, com.tencent.mm.plugin.downloader.a.a.qFr, false, null);
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
          Log.d("MicroMsg.CommonGameClickLinstener", "downloadApk with gp, ret = %b", new Object[] { Boolean.valueOf(r.ck(this.mContext, this.xEP.fmK)) });
        }
        com.tencent.mm.game.report.f.a(this.mContext, this.xEP.scene, this.xEP.dYu, this.xEP.position, 4, this.xEP.field_appId, this.xGR, this.xEP.dDJ, this.xOl);
        if (NetStatusUtil.isWifi(this.mContext))
        {
          pS(paramBoolean);
          return;
        }
        com.tencent.mm.plugin.report.service.h.CyF.a(14217, new Object[] { this.xEP.field_appId, Integer.valueOf(4), "", this.xEP.fmE, Integer.valueOf(2) });
        com.tencent.mm.ui.base.h.a(this.mContext, this.mContext.getString(2131768552), this.mContext.getString(2131768553), this.mContext.getString(2131768547), this.mContext.getString(2131755761), false, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(41858);
            com.tencent.mm.plugin.report.service.h.CyF.a(14217, new Object[] { c.this.xEP.field_appId, Integer.valueOf(5), "", c.this.xEP.fmE, Integer.valueOf(2) });
            c.a(c.this, paramBoolean);
            paramAnonymousDialogInterface.dismiss();
            AppMethodBeat.o(41858);
          }
        }, new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(41859);
            com.tencent.mm.plugin.report.service.h.CyF.a(14217, new Object[] { c.this.xEP.field_appId, Integer.valueOf(6), "", c.this.xEP.fmE, Integer.valueOf(2) });
            paramAnonymousDialogInterface.dismiss();
            Log.i("MicroMsg.CommonGameClickLinstener", "addDownloadTask not wifi, user cancel");
            AppMethodBeat.o(41859);
          }
        }, 2131101414);
      }
    }
  }
  
  public final void setSourceScene(int paramInt)
  {
    this.xGR = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.c
 * JD-Core Version:    0.7.0.1
 */