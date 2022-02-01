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
import com.tencent.mm.g.c.y;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.downloader.f.b;
import com.tencent.mm.plugin.downloader.model.FileDownloadTaskInfo;
import com.tencent.mm.plugin.downloader.model.f;
import com.tencent.mm.plugin.downloader.model.g.a;
import com.tencent.mm.plugin.game.model.k;
import com.tencent.mm.pluginsdk.model.app.r;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ay;
import com.tencent.mm.sdk.platformtools.bt;

public abstract class c
  implements View.OnClickListener
{
  protected long jyh = -1L;
  protected Context mContext;
  protected int mStatus = -1;
  protected com.tencent.mm.plugin.game.model.c rVN = null;
  protected int rXI;
  protected String ser;
  protected FileDownloadTaskInfo ses;
  protected com.tencent.mm.plugin.downloader.g.a set;
  protected String seu;
  protected String sev;
  protected String sew;
  private String sex = "xiaomi";
  
  public c(Context paramContext)
  {
    this.mContext = paramContext;
  }
  
  private void lV(boolean paramBoolean)
  {
    g.a locala;
    if (paramBoolean)
    {
      k.a(this.rVN.eog, this.rVN.eol, this.rVN.dvS, this.rVN.field_appId, this.seu, "app_update");
      locala = new g.a();
      locala.Sr(this.rVN.eog);
      locala.Ss(this.rVN.rVl);
      locala.oy(this.rVN.lrU);
      locala.St(com.tencent.mm.pluginsdk.model.app.h.a(this.mContext, this.rVN, null));
      locala.setAppId(this.rVN.field_appId);
      locala.Su(this.rVN.eol);
      locala.jc(true);
      locala.zO(1);
      locala.eI(this.rVN.field_packageName);
      locala.setScene(this.rVN.dvS);
      if (this.rVN.dlp != 1) {
        break label324;
      }
    }
    label324:
    for (long l = f.bQt().b(locala.ofF);; l = f.bQt().a(locala.ofF))
    {
      ad.i("MicroMsg.CommonGameClickLinstener", " add download task result:[%d], appid[%s]，downloaerType[%d]", new Object[] { Long.valueOf(l), this.rVN.field_appId, Integer.valueOf(this.rVN.dlp) });
      com.tencent.mm.plugin.game.model.e.ar(this.mContext, this.rVN.field_appId);
      com.tencent.mm.plugin.downloader.f.a.a(9, new b(this.rVN.field_appId, this.rVN.dvS, l, ""));
      com.tencent.mm.modelstat.d.c(10, "CommonGameClickListener_addDownloadTask", hashCode());
      return;
      k.a(this.rVN.eog, this.rVN.eol, this.rVN.dvS, this.rVN.field_appId, this.seu, this.sew);
      break;
    }
  }
  
  protected final void cDW()
  {
    com.tencent.mm.plugin.game.model.e.ai(this.mContext, this.rVN.field_appId);
  }
  
  protected final void cDX()
  {
    this.set = com.tencent.mm.plugin.downloader.model.d.Sk(this.rVN.field_appId);
    this.ses = f.bQt().Sp(this.rVN.field_appId);
    this.jyh = this.ses.id;
    this.mStatus = this.ses.status;
    this.ser = this.ses.path;
  }
  
  protected final void lU(final boolean paramBoolean)
  {
    if (!ay.isNetworkConnected(this.mContext))
    {
      Toast.makeText(this.mContext, this.mContext.getString(2131759864), 0).show();
      k.cDc();
      k.a(this.rVN.field_appId, com.tencent.mm.plugin.downloader.a.a.ocg, false, null);
    }
    for (;;)
    {
      return;
      g.afC();
      if (!g.afB().isSDCardAvailable())
      {
        Toast.makeText(this.mContext, this.mContext.getString(2131759868), 0).show();
        k.cDc();
        k.a(this.rVN.field_appId, com.tencent.mm.plugin.downloader.a.a.och, false, null);
        return;
      }
      if ((!com.tencent.mm.plugin.downloader.model.h.oA(this.rVN.lrU)) && (!com.tencent.mm.plugin.downloader.model.h.oz(this.rVN.lrU)))
      {
        Toast.makeText(this.mContext, this.mContext.getString(2131759865), 0).show();
        k.cDc();
        k.a(this.rVN.field_appId, com.tencent.mm.plugin.downloader.a.a.och, false, null);
        return;
      }
      if (com.tencent.mm.protocal.d.CpE.toLowerCase().contains(this.sex)) {}
      try
      {
        if ((Settings.Secure.getInt(this.mContext.getContentResolver(), "install_non_market_apps") == 0) && (!com.tencent.mm.plugin.game.model.e.eY(this.mContext)))
        {
          com.tencent.mm.ui.base.h.a(this.mContext, 2131759987, 2131759988, 2131759885, 2131755691, false, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              AppMethodBeat.i(41860);
              Object localObject = new Intent("android.settings.SECURITY_SETTINGS");
              Context localContext = c.this.mContext;
              localObject = new com.tencent.mm.hellhoundlib.b.a().bd(localObject);
              com.tencent.mm.hellhoundlib.a.a.a(localContext, ((com.tencent.mm.hellhoundlib.b.a)localObject).adn(), "com/tencent/mm/plugin/game/ui/CommonGameClickListener$3", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              localContext.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).lS(0));
              com.tencent.mm.hellhoundlib.a.a.a(localContext, "com/tencent/mm/plugin/game/ui/CommonGameClickListener$3", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
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
          com.tencent.mm.plugin.game.model.e.eZ(this.mContext);
        }
        if ((bt.isNullOrNil(this.rVN.eog)) || (bt.isNullOrNil(this.rVN.eol)))
        {
          ad.d("MicroMsg.CommonGameClickLinstener", "downloadApk: appdownloadurl is null or appmd5 is null, try gpDownload");
          if (bt.isNullOrNil(this.rVN.eom))
          {
            ad.e("MicroMsg.CommonGameClickLinstener", "downloadApk fail, gpDownloadUrl is null");
            if (bt.isNullOrNil(this.rVN.eog))
            {
              k.cDc();
              k.a(this.rVN.field_appId, com.tencent.mm.plugin.downloader.a.a.DOWNLOAD_ERR_URL_INVALID, false, null);
            }
            if (!bt.isNullOrNil(this.rVN.eol)) {
              continue;
            }
            k.cDc();
            k.a(this.rVN.field_appId, com.tencent.mm.plugin.downloader.a.a.oce, false, null);
            return;
          }
        }
      }
      catch (Settings.SettingNotFoundException localSettingNotFoundException)
      {
        for (;;)
        {
          ad.e("MicroMsg.CommonGameClickLinstener", "SettingNotFoundException ; %S", new Object[] { localSettingNotFoundException.getMessage() });
          continue;
          ad.d("MicroMsg.CommonGameClickLinstener", "downloadApk with gp, ret = %b", new Object[] { Boolean.valueOf(r.bK(this.mContext, this.rVN.eom)) });
        }
        com.tencent.mm.game.report.e.a(this.mContext, this.rVN.scene, this.rVN.dvS, this.rVN.position, 4, this.rVN.field_appId, this.rXI, this.rVN.dcC, this.sev);
        if (ay.isWifi(this.mContext))
        {
          lV(paramBoolean);
          return;
        }
        com.tencent.mm.plugin.report.service.h.vKh.f(14217, new Object[] { this.rVN.field_appId, Integer.valueOf(4), "", this.rVN.eog, Integer.valueOf(2) });
        com.tencent.mm.ui.base.h.a(this.mContext, this.mContext.getString(2131766086), this.mContext.getString(2131766087), this.mContext.getString(2131766081), this.mContext.getString(2131755691), false, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(41858);
            com.tencent.mm.plugin.report.service.h.vKh.f(14217, new Object[] { c.this.rVN.field_appId, Integer.valueOf(5), "", c.this.rVN.eog, Integer.valueOf(2) });
            c.a(c.this, paramBoolean);
            paramAnonymousDialogInterface.dismiss();
            AppMethodBeat.o(41858);
          }
        }, new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(41859);
            com.tencent.mm.plugin.report.service.h.vKh.f(14217, new Object[] { c.this.rVN.field_appId, Integer.valueOf(6), "", c.this.rVN.eog, Integer.valueOf(2) });
            paramAnonymousDialogInterface.dismiss();
            ad.i("MicroMsg.CommonGameClickLinstener", "addDownloadTask not wifi, user cancel");
            AppMethodBeat.o(41859);
          }
        }, 2131101171);
      }
    }
  }
  
  public final void setSourceScene(int paramInt)
  {
    this.rXI = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.c
 * JD-Core Version:    0.7.0.1
 */