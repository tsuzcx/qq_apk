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
import com.tencent.mm.plugin.downloader.f.b;
import com.tencent.mm.plugin.downloader.model.FileDownloadTaskInfo;
import com.tencent.mm.plugin.downloader.model.g.a;
import com.tencent.mm.plugin.game.model.k;
import com.tencent.mm.pluginsdk.model.app.r;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.az;
import com.tencent.mm.sdk.platformtools.bu;

public abstract class c
  implements View.OnClickListener
{
  protected long kwo = -1L;
  protected Context mContext;
  protected int mStatus = -1;
  protected com.tencent.mm.plugin.game.model.c umx = null;
  protected int uoy;
  protected String uwg;
  protected FileDownloadTaskInfo uwh;
  protected com.tencent.mm.plugin.downloader.g.a uwi;
  protected String uwj;
  protected String uwk;
  protected String uwl;
  private String uwm = "xiaomi";
  
  public c(Context paramContext)
  {
    this.mContext = paramContext;
  }
  
  private void nm(boolean paramBoolean)
  {
    g.a locala;
    if (paramBoolean)
    {
      k.a(this.umx.eJc, this.umx.eJh, this.umx.dGL, this.umx.field_appId, this.uwj, "app_update");
      locala = new g.a();
      locala.abb(this.umx.eJc);
      locala.abc(this.umx.ulV);
      locala.uz(this.umx.myB);
      locala.abd(com.tencent.mm.pluginsdk.model.app.h.a(this.mContext, this.umx, null));
      locala.setAppId(this.umx.field_appId);
      locala.abe(this.umx.eJh);
      locala.jP(true);
      locala.BB(1);
      locala.fz(this.umx.field_packageName);
      locala.setScene(this.umx.dGL);
      if (this.umx.dvO != 1) {
        break label324;
      }
    }
    label324:
    for (long l = com.tencent.mm.plugin.downloader.model.f.cdA().b(locala.ptu);; l = com.tencent.mm.plugin.downloader.model.f.cdA().a(locala.ptu))
    {
      ae.i("MicroMsg.CommonGameClickLinstener", " add download task result:[%d], appid[%s]，downloaerType[%d]", new Object[] { Long.valueOf(l), this.umx.field_appId, Integer.valueOf(this.umx.dvO) });
      com.tencent.mm.plugin.game.model.e.ax(this.mContext, this.umx.field_appId);
      com.tencent.mm.plugin.downloader.f.a.a(9, new b(this.umx.field_appId, this.umx.dGL, l, ""));
      com.tencent.mm.modelstat.d.d(10, "CommonGameClickListener_addDownloadTask", hashCode());
      return;
      k.a(this.umx.eJc, this.umx.eJh, this.umx.dGL, this.umx.field_appId, this.uwj, this.uwl);
      break;
    }
  }
  
  protected final void dcx()
  {
    com.tencent.mm.plugin.game.model.e.ak(this.mContext, this.umx.field_appId);
  }
  
  protected final void dcy()
  {
    this.uwi = com.tencent.mm.plugin.downloader.model.d.aaU(this.umx.field_appId);
    this.uwh = com.tencent.mm.plugin.downloader.model.f.cdA().aaZ(this.umx.field_appId);
    this.kwo = this.uwh.id;
    this.mStatus = this.uwh.status;
    this.uwg = this.uwh.path;
  }
  
  protected final void nl(final boolean paramBoolean)
  {
    if (!az.isNetworkConnected(this.mContext))
    {
      Toast.makeText(this.mContext, this.mContext.getString(2131759864), 0).show();
      k.dbB();
      k.a(this.umx.field_appId, com.tencent.mm.plugin.downloader.a.a.ppO, false, null);
    }
    for (;;)
    {
      return;
      com.tencent.mm.kernel.g.ajS();
      if (!com.tencent.mm.kernel.g.ajR().isSDCardAvailable())
      {
        Toast.makeText(this.mContext, this.mContext.getString(2131759868), 0).show();
        k.dbB();
        k.a(this.umx.field_appId, com.tencent.mm.plugin.downloader.a.a.ppP, false, null);
        return;
      }
      if ((!com.tencent.mm.plugin.downloader.model.h.uB(this.umx.myB)) && (!com.tencent.mm.plugin.downloader.model.h.uA(this.umx.myB)))
      {
        Toast.makeText(this.mContext, this.mContext.getString(2131759865), 0).show();
        k.dbB();
        k.a(this.umx.field_appId, com.tencent.mm.plugin.downloader.a.a.ppP, false, null);
        return;
      }
      if (com.tencent.mm.protocal.d.FFB.toLowerCase().contains(this.uwm)) {}
      try
      {
        if ((Settings.Secure.getInt(this.mContext.getContentResolver(), "install_non_market_apps") == 0) && (!com.tencent.mm.plugin.game.model.e.ft(this.mContext)))
        {
          com.tencent.mm.ui.base.h.a(this.mContext, 2131759987, 2131759988, 2131759885, 2131755691, false, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              AppMethodBeat.i(41860);
              Object localObject = new Intent("android.settings.SECURITY_SETTINGS");
              Context localContext = c.this.mContext;
              localObject = new com.tencent.mm.hellhoundlib.b.a().bc(localObject);
              com.tencent.mm.hellhoundlib.a.a.a(localContext, ((com.tencent.mm.hellhoundlib.b.a)localObject).ahE(), "com/tencent/mm/plugin/game/ui/CommonGameClickListener$3", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              localContext.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).mt(0));
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
          com.tencent.mm.plugin.game.model.e.fu(this.mContext);
        }
        if ((bu.isNullOrNil(this.umx.eJc)) || (bu.isNullOrNil(this.umx.eJh)))
        {
          ae.d("MicroMsg.CommonGameClickLinstener", "downloadApk: appdownloadurl is null or appmd5 is null, try gpDownload");
          if (bu.isNullOrNil(this.umx.eJi))
          {
            ae.e("MicroMsg.CommonGameClickLinstener", "downloadApk fail, gpDownloadUrl is null");
            if (bu.isNullOrNil(this.umx.eJc))
            {
              k.dbB();
              k.a(this.umx.field_appId, com.tencent.mm.plugin.downloader.a.a.DOWNLOAD_ERR_URL_INVALID, false, null);
            }
            if (!bu.isNullOrNil(this.umx.eJh)) {
              continue;
            }
            k.dbB();
            k.a(this.umx.field_appId, com.tencent.mm.plugin.downloader.a.a.ppM, false, null);
            return;
          }
        }
      }
      catch (Settings.SettingNotFoundException localSettingNotFoundException)
      {
        for (;;)
        {
          ae.e("MicroMsg.CommonGameClickLinstener", "SettingNotFoundException ; %S", new Object[] { localSettingNotFoundException.getMessage() });
          continue;
          ae.d("MicroMsg.CommonGameClickLinstener", "downloadApk with gp, ret = %b", new Object[] { Boolean.valueOf(r.bQ(this.mContext, this.umx.eJi)) });
        }
        com.tencent.mm.game.report.f.a(this.mContext, this.umx.scene, this.umx.dGL, this.umx.position, 4, this.umx.field_appId, this.uoy, this.umx.dmu, this.uwk);
        if (az.isWifi(this.mContext))
        {
          nm(paramBoolean);
          return;
        }
        com.tencent.mm.plugin.report.service.g.yxI.f(14217, new Object[] { this.umx.field_appId, Integer.valueOf(4), "", this.umx.eJc, Integer.valueOf(2) });
        com.tencent.mm.ui.base.h.a(this.mContext, this.mContext.getString(2131766086), this.mContext.getString(2131766087), this.mContext.getString(2131766081), this.mContext.getString(2131755691), false, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(41858);
            com.tencent.mm.plugin.report.service.g.yxI.f(14217, new Object[] { c.this.umx.field_appId, Integer.valueOf(5), "", c.this.umx.eJc, Integer.valueOf(2) });
            c.a(c.this, paramBoolean);
            paramAnonymousDialogInterface.dismiss();
            AppMethodBeat.o(41858);
          }
        }, new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(41859);
            com.tencent.mm.plugin.report.service.g.yxI.f(14217, new Object[] { c.this.umx.field_appId, Integer.valueOf(6), "", c.this.umx.eJc, Integer.valueOf(2) });
            paramAnonymousDialogInterface.dismiss();
            ae.i("MicroMsg.CommonGameClickLinstener", "addDownloadTask not wifi, user cancel");
            AppMethodBeat.o(41859);
          }
        }, 2131101171);
      }
    }
  }
  
  public final void setSourceScene(int paramInt)
  {
    this.uoy = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.c
 * JD-Core Version:    0.7.0.1
 */