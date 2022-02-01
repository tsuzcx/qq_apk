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
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ax;
import com.tencent.mm.sdk.platformtools.bs;

public abstract class c
  implements View.OnClickListener
{
  protected long jYC = -1L;
  protected Context mContext;
  protected int mStatus = -1;
  protected com.tencent.mm.plugin.game.model.c tdF = null;
  protected int tfA;
  protected String tmk;
  protected FileDownloadTaskInfo tml;
  protected com.tencent.mm.plugin.downloader.g.a tmm;
  protected String tmn;
  protected String tmo;
  protected String tmp;
  private String tmq = "xiaomi";
  
  public c(Context paramContext)
  {
    this.mContext = paramContext;
  }
  
  private void mO(boolean paramBoolean)
  {
    g.a locala;
    if (paramBoolean)
    {
      k.a(this.tdF.eqk, this.tdF.eqp, this.tdF.dtF, this.tdF.field_appId, this.tmn, "app_update");
      locala = new g.a();
      locala.WD(this.tdF.eqk);
      locala.WE(this.tdF.tdd);
      locala.sk(this.tdF.lTP);
      locala.WF(com.tencent.mm.pluginsdk.model.app.h.a(this.mContext, this.tdF, null));
      locala.setAppId(this.tdF.field_appId);
      locala.WG(this.tdF.eqp);
      locala.jF(true);
      locala.AG(1);
      locala.ey(this.tdF.field_packageName);
      locala.setScene(this.tdF.dtF);
      if (this.tdF.diX != 1) {
        break label324;
      }
    }
    label324:
    for (long l = f.bXJ().b(locala.oJg);; l = f.bXJ().a(locala.oJg))
    {
      ac.i("MicroMsg.CommonGameClickLinstener", " add download task result:[%d], appid[%s]，downloaerType[%d]", new Object[] { Long.valueOf(l), this.tdF.field_appId, Integer.valueOf(this.tdF.diX) });
      com.tencent.mm.plugin.game.model.e.as(this.mContext, this.tdF.field_appId);
      com.tencent.mm.plugin.downloader.f.a.a(9, new b(this.tdF.field_appId, this.tdF.dtF, l, ""));
      com.tencent.mm.modelstat.d.d(10, "CommonGameClickListener_addDownloadTask", hashCode());
      return;
      k.a(this.tdF.eqk, this.tdF.eqp, this.tdF.dtF, this.tdF.field_appId, this.tmn, this.tmp);
      break;
    }
  }
  
  protected final void cRg()
  {
    com.tencent.mm.plugin.game.model.e.aj(this.mContext, this.tdF.field_appId);
  }
  
  protected final void cRh()
  {
    this.tmm = com.tencent.mm.plugin.downloader.model.d.Ww(this.tdF.field_appId);
    this.tml = f.bXJ().WB(this.tdF.field_appId);
    this.jYC = this.tml.id;
    this.mStatus = this.tml.status;
    this.tmk = this.tml.path;
  }
  
  protected final void mN(final boolean paramBoolean)
  {
    if (!ax.isNetworkConnected(this.mContext))
    {
      Toast.makeText(this.mContext, this.mContext.getString(2131759864), 0).show();
      k.cQm();
      k.a(this.tdF.field_appId, com.tencent.mm.plugin.downloader.a.a.oFF, false, null);
    }
    for (;;)
    {
      return;
      g.agS();
      if (!g.agR().isSDCardAvailable())
      {
        Toast.makeText(this.mContext, this.mContext.getString(2131759868), 0).show();
        k.cQm();
        k.a(this.tdF.field_appId, com.tencent.mm.plugin.downloader.a.a.oFG, false, null);
        return;
      }
      if ((!com.tencent.mm.plugin.downloader.model.h.sm(this.tdF.lTP)) && (!com.tencent.mm.plugin.downloader.model.h.sl(this.tdF.lTP)))
      {
        Toast.makeText(this.mContext, this.mContext.getString(2131759865), 0).show();
        k.cQm();
        k.a(this.tdF.field_appId, com.tencent.mm.plugin.downloader.a.a.oFG, false, null);
        return;
      }
      if (com.tencent.mm.protocal.d.DHW.toLowerCase().contains(this.tmq)) {}
      try
      {
        if ((Settings.Secure.getInt(this.mContext.getContentResolver(), "install_non_market_apps") == 0) && (!com.tencent.mm.plugin.game.model.e.fl(this.mContext)))
        {
          com.tencent.mm.ui.base.h.a(this.mContext, 2131759987, 2131759988, 2131759885, 2131755691, false, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              AppMethodBeat.i(41860);
              Object localObject = new Intent("android.settings.SECURITY_SETTINGS");
              Context localContext = c.this.mContext;
              localObject = new com.tencent.mm.hellhoundlib.b.a().ba(localObject);
              com.tencent.mm.hellhoundlib.a.a.a(localContext, ((com.tencent.mm.hellhoundlib.b.a)localObject).aeD(), "com/tencent/mm/plugin/game/ui/CommonGameClickListener$3", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              localContext.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).lR(0));
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
          com.tencent.mm.plugin.game.model.e.fm(this.mContext);
        }
        if ((bs.isNullOrNil(this.tdF.eqk)) || (bs.isNullOrNil(this.tdF.eqp)))
        {
          ac.d("MicroMsg.CommonGameClickLinstener", "downloadApk: appdownloadurl is null or appmd5 is null, try gpDownload");
          if (bs.isNullOrNil(this.tdF.eqq))
          {
            ac.e("MicroMsg.CommonGameClickLinstener", "downloadApk fail, gpDownloadUrl is null");
            if (bs.isNullOrNil(this.tdF.eqk))
            {
              k.cQm();
              k.a(this.tdF.field_appId, com.tencent.mm.plugin.downloader.a.a.DOWNLOAD_ERR_URL_INVALID, false, null);
            }
            if (!bs.isNullOrNil(this.tdF.eqp)) {
              continue;
            }
            k.cQm();
            k.a(this.tdF.field_appId, com.tencent.mm.plugin.downloader.a.a.oFD, false, null);
            return;
          }
        }
      }
      catch (Settings.SettingNotFoundException localSettingNotFoundException)
      {
        for (;;)
        {
          ac.e("MicroMsg.CommonGameClickLinstener", "SettingNotFoundException ; %S", new Object[] { localSettingNotFoundException.getMessage() });
          continue;
          ac.d("MicroMsg.CommonGameClickLinstener", "downloadApk with gp, ret = %b", new Object[] { Boolean.valueOf(r.bL(this.mContext, this.tdF.eqq)) });
        }
        com.tencent.mm.game.report.e.a(this.mContext, this.tdF.scene, this.tdF.dtF, this.tdF.position, 4, this.tdF.field_appId, this.tfA, this.tdF.daa, this.tmo);
        if (ax.isWifi(this.mContext))
        {
          mO(paramBoolean);
          return;
        }
        com.tencent.mm.plugin.report.service.h.wUl.f(14217, new Object[] { this.tdF.field_appId, Integer.valueOf(4), "", this.tdF.eqk, Integer.valueOf(2) });
        com.tencent.mm.ui.base.h.a(this.mContext, this.mContext.getString(2131766086), this.mContext.getString(2131766087), this.mContext.getString(2131766081), this.mContext.getString(2131755691), false, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(41858);
            com.tencent.mm.plugin.report.service.h.wUl.f(14217, new Object[] { c.this.tdF.field_appId, Integer.valueOf(5), "", c.this.tdF.eqk, Integer.valueOf(2) });
            c.a(c.this, paramBoolean);
            paramAnonymousDialogInterface.dismiss();
            AppMethodBeat.o(41858);
          }
        }, new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(41859);
            com.tencent.mm.plugin.report.service.h.wUl.f(14217, new Object[] { c.this.tdF.field_appId, Integer.valueOf(6), "", c.this.tdF.eqk, Integer.valueOf(2) });
            paramAnonymousDialogInterface.dismiss();
            ac.i("MicroMsg.CommonGameClickLinstener", "addDownloadTask not wifi, user cancel");
            AppMethodBeat.o(41859);
          }
        }, 2131101171);
      }
    }
  }
  
  public final void setSourceScene(int paramInt)
  {
    this.tfA = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.c
 * JD-Core Version:    0.7.0.1
 */