package com.tencent.mm.plugin.game.ui;

import android.content.Context;
import android.provider.Settings.Secure;
import android.provider.Settings.SettingNotFoundException;
import android.view.View.OnClickListener;
import android.widget.Toast;
import com.tencent.mm.g.c.t;
import com.tencent.mm.plugin.downloader.f.b;
import com.tencent.mm.plugin.downloader.model.FileDownloadTaskInfo;
import com.tencent.mm.plugin.downloader.model.g.a;
import com.tencent.mm.plugin.game.model.j;
import com.tencent.mm.pluginsdk.model.app.q;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.at;
import com.tencent.mm.sdk.platformtools.bo;

public abstract class c
  implements View.OnClickListener
{
  protected long hyK = -1L;
  protected Context mContext;
  protected int mStatus = -1;
  protected com.tencent.mm.plugin.game.model.c nmJ = null;
  protected int nok;
  protected String nuM;
  protected FileDownloadTaskInfo nuN;
  protected com.tencent.mm.plugin.downloader.g.a nuO;
  protected String nuP;
  protected String nuQ;
  protected String nuR;
  private String nuS = "xiaomi";
  
  public c(Context paramContext)
  {
    this.mContext = paramContext;
  }
  
  private void ii(boolean paramBoolean)
  {
    g.a locala;
    if (paramBoolean)
    {
      j.a(this.nmJ.djJ, this.nmJ.djO, this.nmJ.cFj, this.nmJ.field_appId, this.nuP, "app_update");
      locala = new g.a();
      locala.JJ(this.nmJ.djJ);
      locala.JK(this.nmJ.nmn);
      locala.iR(this.nmJ.nmo);
      locala.JL(com.tencent.mm.pluginsdk.model.app.g.b(this.mContext, this.nmJ, null));
      locala.setAppId(this.nmJ.field_appId);
      locala.JM(this.nmJ.djO);
      locala.gr(true);
      locala.tV(1);
      locala.dC(this.nmJ.field_packageName);
      locala.setScene(this.nmJ.cFj);
      if (this.nmJ.cvQ != 1) {
        break label324;
      }
    }
    label324:
    for (long l = com.tencent.mm.plugin.downloader.model.f.bjl().b(locala.kYR);; l = com.tencent.mm.plugin.downloader.model.f.bjl().a(locala.kYR))
    {
      ab.i("MicroMsg.CommonGameClickLinstener", " add download task result:[%d], appid[%s]，downloaerType[%d]", new Object[] { Long.valueOf(l), this.nmJ.field_appId, Integer.valueOf(this.nmJ.cvQ) });
      com.tencent.mm.plugin.game.model.e.ar(this.mContext, this.nmJ.field_appId);
      com.tencent.mm.plugin.downloader.f.a.a(9, new b(this.nmJ.field_appId, this.nmJ.cFj, l, ""));
      com.tencent.mm.modelstat.d.b(10, "CommonGameClickListener_addDownloadTask", hashCode());
      return;
      j.a(this.nmJ.djJ, this.nmJ.djO, this.nmJ.cFj, this.nmJ.field_appId, this.nuP, this.nuR);
      break;
    }
  }
  
  protected final void bHc()
  {
    com.tencent.mm.plugin.game.model.e.aj(this.mContext, this.nmJ.field_appId);
  }
  
  protected final void bHd()
  {
    this.nuO = com.tencent.mm.plugin.downloader.model.d.JD(this.nmJ.field_appId);
    this.nuN = com.tencent.mm.plugin.downloader.model.f.bjl().JH(this.nmJ.field_appId);
    this.hyK = this.nuN.id;
    this.mStatus = this.nuN.status;
    this.nuM = this.nuN.path;
  }
  
  protected final void ih(boolean paramBoolean)
  {
    if (!at.isNetworkConnected(this.mContext))
    {
      Toast.makeText(this.mContext, this.mContext.getString(2131300360), 0).show();
      j.bGh();
      j.a(this.nmJ.field_appId, com.tencent.mm.plugin.downloader.a.a.kVw, false, null);
    }
    for (;;)
    {
      return;
      com.tencent.mm.kernel.g.RM();
      if (!com.tencent.mm.kernel.g.RL().isSDCardAvailable())
      {
        Toast.makeText(this.mContext, this.mContext.getString(2131300364), 0).show();
        j.bGh();
        j.a(this.nmJ.field_appId, com.tencent.mm.plugin.downloader.a.a.kVx, false, null);
        return;
      }
      if ((!com.tencent.mm.compatible.util.f.gc(this.nmJ.nmo)) && (!com.tencent.mm.plugin.downloader.model.h.iS(this.nmJ.nmo)))
      {
        Toast.makeText(this.mContext, this.mContext.getString(2131300361), 0).show();
        j.bGh();
        j.a(this.nmJ.field_appId, com.tencent.mm.plugin.downloader.a.a.kVx, false, null);
        return;
      }
      if (com.tencent.mm.protocal.d.whB.toLowerCase().contains(this.nuS)) {}
      try
      {
        if ((Settings.Secure.getInt(this.mContext.getContentResolver(), "install_non_market_apps") == 0) && (!com.tencent.mm.plugin.game.model.e.ed(this.mContext)))
        {
          com.tencent.mm.ui.base.h.a(this.mContext, 2131300461, 2131300462, 2131300378, 2131296888, false, new c.3(this), new c.4(this));
          com.tencent.mm.plugin.game.model.e.ee(this.mContext);
        }
        if ((bo.isNullOrNil(this.nmJ.djJ)) || (bo.isNullOrNil(this.nmJ.djO)))
        {
          ab.d("MicroMsg.CommonGameClickLinstener", "downloadApk: appdownloadurl is null or appmd5 is null, try gpDownload");
          if (bo.isNullOrNil(this.nmJ.djP))
          {
            ab.e("MicroMsg.CommonGameClickLinstener", "downloadApk fail, gpDownloadUrl is null");
            if (bo.isNullOrNil(this.nmJ.djJ))
            {
              j.bGh();
              j.a(this.nmJ.field_appId, com.tencent.mm.plugin.downloader.a.a.DOWNLOAD_ERR_URL_INVALID, false, null);
            }
            if (!bo.isNullOrNil(this.nmJ.djO)) {
              continue;
            }
            j.bGh();
            j.a(this.nmJ.field_appId, com.tencent.mm.plugin.downloader.a.a.kVu, false, null);
            return;
          }
        }
      }
      catch (Settings.SettingNotFoundException localSettingNotFoundException)
      {
        for (;;)
        {
          ab.e("MicroMsg.CommonGameClickLinstener", "SettingNotFoundException ; %S", new Object[] { localSettingNotFoundException.getMessage() });
          continue;
          ab.d("MicroMsg.CommonGameClickLinstener", "downloadApk with gp, ret = %b", new Object[] { Boolean.valueOf(q.bw(this.mContext, this.nmJ.djP)) });
        }
        com.tencent.mm.game.report.c.a(this.mContext, this.nmJ.scene, this.nmJ.cFj, this.nmJ.position, 4, this.nmJ.field_appId, this.nok, this.nmJ.cnG, this.nuQ);
        if (at.isWifi(this.mContext))
        {
          ii(paramBoolean);
          return;
        }
        com.tencent.mm.plugin.report.service.h.qsU.e(14217, new Object[] { this.nmJ.field_appId, Integer.valueOf(4), "", this.nmJ.djJ, Integer.valueOf(2) });
        com.tencent.mm.ui.base.h.a(this.mContext, this.mContext.getString(2131305852), this.mContext.getString(2131305853), this.mContext.getString(2131305847), this.mContext.getString(2131296888), false, new c.1(this, paramBoolean), new c.2(this), 2131690701);
      }
    }
  }
  
  public final void setSourceScene(int paramInt)
  {
    this.nok = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.c
 * JD-Core Version:    0.7.0.1
 */