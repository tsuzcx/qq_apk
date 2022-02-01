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
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ay;
import com.tencent.mm.sdk.platformtools.bt;

public abstract class c
  implements View.OnClickListener
{
  protected long ksY = -1L;
  protected Context mContext;
  protected int mStatus = -1;
  protected com.tencent.mm.plugin.game.model.c ubv = null;
  protected int udq;
  protected String ukJ;
  protected FileDownloadTaskInfo ukK;
  protected com.tencent.mm.plugin.downloader.g.a ukL;
  protected String ukM;
  protected String ukN;
  protected String ukO;
  private String ukP = "xiaomi";
  
  public c(Context paramContext)
  {
    this.mContext = paramContext;
  }
  
  private void ni(boolean paramBoolean)
  {
    g.a locala;
    if (paramBoolean)
    {
      k.a(this.ubv.eHt, this.ubv.eHy, this.ubv.dFG, this.ubv.field_appId, this.ukM, "app_update");
      locala = new g.a();
      locala.aak(this.ubv.eHt);
      locala.aal(this.ubv.uaT);
      locala.ui(this.ubv.mtE);
      locala.aam(com.tencent.mm.pluginsdk.model.app.h.a(this.mContext, this.ubv, null));
      locala.setAppId(this.ubv.field_appId);
      locala.aan(this.ubv.eHy);
      locala.jQ(true);
      locala.Bp(1);
      locala.ft(this.ubv.field_packageName);
      locala.setScene(this.ubv.dFG);
      if (this.ubv.duJ != 1) {
        break label324;
      }
    }
    label324:
    for (long l = com.tencent.mm.plugin.downloader.model.f.ccl().b(locala.pmN);; l = com.tencent.mm.plugin.downloader.model.f.ccl().a(locala.pmN))
    {
      ad.i("MicroMsg.CommonGameClickLinstener", " add download task result:[%d], appid[%s]，downloaerType[%d]", new Object[] { Long.valueOf(l), this.ubv.field_appId, Integer.valueOf(this.ubv.duJ) });
      com.tencent.mm.plugin.game.model.e.av(this.mContext, this.ubv.field_appId);
      com.tencent.mm.plugin.downloader.f.a.a(9, new b(this.ubv.field_appId, this.ubv.dFG, l, ""));
      com.tencent.mm.modelstat.d.d(10, "CommonGameClickListener_addDownloadTask", hashCode());
      return;
      k.a(this.ubv.eHt, this.ubv.eHy, this.ubv.dFG, this.ubv.field_appId, this.ukM, this.ukO);
      break;
    }
  }
  
  protected final void cZM()
  {
    com.tencent.mm.plugin.game.model.e.ai(this.mContext, this.ubv.field_appId);
  }
  
  protected final void cZN()
  {
    this.ukL = com.tencent.mm.plugin.downloader.model.d.aad(this.ubv.field_appId);
    this.ukK = com.tencent.mm.plugin.downloader.model.f.ccl().aai(this.ubv.field_appId);
    this.ksY = this.ukK.id;
    this.mStatus = this.ukK.status;
    this.ukJ = this.ukK.path;
  }
  
  protected final void nh(final boolean paramBoolean)
  {
    if (!ay.isNetworkConnected(this.mContext))
    {
      Toast.makeText(this.mContext, this.mContext.getString(2131759864), 0).show();
      k.cYR();
      k.a(this.ubv.field_appId, com.tencent.mm.plugin.downloader.a.a.pjj, false, null);
    }
    for (;;)
    {
      return;
      com.tencent.mm.kernel.g.ajD();
      if (!com.tencent.mm.kernel.g.ajC().isSDCardAvailable())
      {
        Toast.makeText(this.mContext, this.mContext.getString(2131759868), 0).show();
        k.cYR();
        k.a(this.ubv.field_appId, com.tencent.mm.plugin.downloader.a.a.pjk, false, null);
        return;
      }
      if ((!com.tencent.mm.plugin.downloader.model.h.uk(this.ubv.mtE)) && (!com.tencent.mm.plugin.downloader.model.h.uj(this.ubv.mtE)))
      {
        Toast.makeText(this.mContext, this.mContext.getString(2131759865), 0).show();
        k.cYR();
        k.a(this.ubv.field_appId, com.tencent.mm.plugin.downloader.a.a.pjk, false, null);
        return;
      }
      if (com.tencent.mm.protocal.d.Fnd.toLowerCase().contains(this.ukP)) {}
      try
      {
        if ((Settings.Secure.getInt(this.mContext.getContentResolver(), "install_non_market_apps") == 0) && (!com.tencent.mm.plugin.game.model.e.fp(this.mContext)))
        {
          com.tencent.mm.ui.base.h.a(this.mContext, 2131759987, 2131759988, 2131759885, 2131755691, false, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              AppMethodBeat.i(41860);
              Object localObject = new Intent("android.settings.SECURITY_SETTINGS");
              Context localContext = c.this.mContext;
              localObject = new com.tencent.mm.hellhoundlib.b.a().bc(localObject);
              com.tencent.mm.hellhoundlib.a.a.a(localContext, ((com.tencent.mm.hellhoundlib.b.a)localObject).ahp(), "com/tencent/mm/plugin/game/ui/CommonGameClickListener$3", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              localContext.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).mq(0));
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
          com.tencent.mm.plugin.game.model.e.fq(this.mContext);
        }
        if ((bt.isNullOrNil(this.ubv.eHt)) || (bt.isNullOrNil(this.ubv.eHy)))
        {
          ad.d("MicroMsg.CommonGameClickLinstener", "downloadApk: appdownloadurl is null or appmd5 is null, try gpDownload");
          if (bt.isNullOrNil(this.ubv.eHz))
          {
            ad.e("MicroMsg.CommonGameClickLinstener", "downloadApk fail, gpDownloadUrl is null");
            if (bt.isNullOrNil(this.ubv.eHt))
            {
              k.cYR();
              k.a(this.ubv.field_appId, com.tencent.mm.plugin.downloader.a.a.DOWNLOAD_ERR_URL_INVALID, false, null);
            }
            if (!bt.isNullOrNil(this.ubv.eHy)) {
              continue;
            }
            k.cYR();
            k.a(this.ubv.field_appId, com.tencent.mm.plugin.downloader.a.a.pjh, false, null);
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
          ad.d("MicroMsg.CommonGameClickLinstener", "downloadApk with gp, ret = %b", new Object[] { Boolean.valueOf(r.bP(this.mContext, this.ubv.eHz)) });
        }
        com.tencent.mm.game.report.f.a(this.mContext, this.ubv.scene, this.ubv.dFG, this.ubv.position, 4, this.ubv.field_appId, this.udq, this.ubv.dls, this.ukN);
        if (ay.isWifi(this.mContext))
        {
          ni(paramBoolean);
          return;
        }
        com.tencent.mm.plugin.report.service.g.yhR.f(14217, new Object[] { this.ubv.field_appId, Integer.valueOf(4), "", this.ubv.eHt, Integer.valueOf(2) });
        com.tencent.mm.ui.base.h.a(this.mContext, this.mContext.getString(2131766086), this.mContext.getString(2131766087), this.mContext.getString(2131766081), this.mContext.getString(2131755691), false, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(41858);
            com.tencent.mm.plugin.report.service.g.yhR.f(14217, new Object[] { c.this.ubv.field_appId, Integer.valueOf(5), "", c.this.ubv.eHt, Integer.valueOf(2) });
            c.a(c.this, paramBoolean);
            paramAnonymousDialogInterface.dismiss();
            AppMethodBeat.o(41858);
          }
        }, new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(41859);
            com.tencent.mm.plugin.report.service.g.yhR.f(14217, new Object[] { c.this.ubv.field_appId, Integer.valueOf(6), "", c.this.ubv.eHt, Integer.valueOf(2) });
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
    this.udq = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.c
 * JD-Core Version:    0.7.0.1
 */