package com.tencent.mm.plugin.game.ui;

import android.content.Context;
import android.net.Uri;
import android.view.View;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.t;
import com.tencent.mm.plugin.downloader.f.b;
import com.tencent.mm.plugin.downloader.model.FileDownloadTaskInfo;
import com.tencent.mm.plugin.downloader.model.f;
import com.tencent.mm.plugin.game.d.bx;
import com.tencent.mm.plugin.game.model.j;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.pluginsdk.model.app.q;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.at;
import com.tencent.mm.sdk.platformtools.bo;
import java.io.File;

public final class h
  extends c
{
  public h(Context paramContext)
  {
    super(paramContext);
  }
  
  private void bHj()
  {
    AppMethodBeat.i(111802);
    if (!at.isNetworkConnected(this.mContext))
    {
      Toast.makeText(this.mContext, this.mContext.getString(2131300360), 0).show();
      AppMethodBeat.o(111802);
      return;
    }
    if (at.isWifi(this.mContext))
    {
      bHk();
      AppMethodBeat.o(111802);
      return;
    }
    com.tencent.mm.ui.base.h.a(this.mContext, this.mContext.getString(2131305852), this.mContext.getString(2131305853), this.mContext.getString(2131305847), this.mContext.getString(2131296888), false, new h.1(this), new h.2(this), 2131690701);
    AppMethodBeat.o(111802);
  }
  
  private void bHk()
  {
    AppMethodBeat.i(111803);
    com.tencent.mm.plugin.downloader.f.a.a(10, new b(this.nmJ.field_appId, this.nmJ.cFj, this.nuO.field_downloadId, ""));
    com.tencent.mm.modelstat.d.b(10, "GameClickListener_resumeDownloadTask", hashCode());
    if (f.bjl().iC(this.nuO.field_downloadId))
    {
      com.tencent.mm.plugin.game.model.e.ar(this.mContext, this.nmJ.field_appId);
      com.tencent.mm.game.report.c.a(this.mContext, this.nmJ.scene, this.nmJ.cFj, this.nmJ.position, 4, this.nmJ.field_appId, this.nok, this.nmJ.cnG, this.nuQ);
      AppMethodBeat.o(111803);
      return;
    }
    ab.e("MicroMsg.GameClickListener", "resumeDownloadTask false");
    f.bjl().iz(this.nuO.field_downloadId);
    ih(false);
    AppMethodBeat.o(111803);
  }
  
  private static boolean iB(long paramLong)
  {
    AppMethodBeat.i(111804);
    com.tencent.mm.plugin.downloader.g.a locala = com.tencent.mm.plugin.downloader.model.d.iJ(paramLong);
    if ((locala != null) && (locala.field_downloadInWifi))
    {
      locala.field_downloadInWifi = false;
      com.tencent.mm.plugin.downloader.model.d.e(locala);
    }
    boolean bool = f.bjl().iB(paramLong);
    AppMethodBeat.o(111804);
    return bool;
  }
  
  public final void eI(String paramString1, String paramString2)
  {
    this.nuQ = paramString1;
    this.nuR = paramString2;
  }
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(111801);
    int j;
    int i;
    if ((paramView.getTag() instanceof com.tencent.mm.plugin.game.model.c))
    {
      this.nmJ = ((com.tencent.mm.plugin.game.model.c)paramView.getTag());
      ab.i("MicroMsg.GameClickListener", "Clicked appid = " + this.nmJ.field_appId);
      bHd();
      if (!g.u(this.mContext, this.nmJ.field_appId)) {
        break label505;
      }
      if (!(this.nmJ instanceof com.tencent.mm.plugin.game.model.c)) {
        break label831;
      }
      j = com.tencent.mm.plugin.game.f.c.Qy(this.nmJ.field_packageName);
      i = this.nmJ.versionCode;
    }
    for (;;)
    {
      if (i > j)
      {
        ab.i("MicroMsg.GameClickListener", "AppId: %s installed, local: %d, server: %d", new Object[] { this.nmJ.field_appId, Integer.valueOf(j), Integer.valueOf(i) });
        j.a(this.nmJ.djJ, this.nmJ.djO, this.nmJ.cFj, this.nmJ.field_appId, this.nuP, "app_update");
        if (this.nuN.status == 1)
        {
          ab.i("MicroMsg.GameClickListener", "pauseDownloadTask ret = ".concat(String.valueOf(iB(this.nuN.id))));
          AppMethodBeat.o(111801);
          return;
          ab.e("MicroMsg.GameClickListener", "No AppInfo");
          AppMethodBeat.o(111801);
          return;
        }
        if (this.nuN.status == 2)
        {
          bHj();
          AppMethodBeat.o(111801);
          return;
        }
        if (this.nuN.status == 3)
        {
          if ((com.tencent.mm.a.e.cN(this.nuN.path)) && (com.tencent.mm.plugin.game.f.c.Qz(this.nuN.path) > j))
          {
            paramView = Uri.fromFile(new File(this.nuN.path));
            q.a(this.mContext, paramView, null);
            com.tencent.mm.game.report.c.a(this.mContext, this.nmJ.scene, this.nmJ.cFj, this.nmJ.position, 8, this.nmJ.field_appId, this.nok, this.nmJ.cnG, this.nuQ);
            AppMethodBeat.o(111801);
            return;
          }
          ih(true);
          AppMethodBeat.o(111801);
          return;
        }
        ih(true);
        AppMethodBeat.o(111801);
        return;
      }
      ab.i("MicroMsg.GameClickListener", "launchFromWX, appId = %s, pkg = %s, openId = %s", new Object[] { this.nmJ.field_appId, this.nmJ.field_packageName, this.nmJ.field_openId });
      com.tencent.mm.game.report.c.a(this.mContext, this.nmJ.scene, this.nmJ.cFj, this.nmJ.position, 3, this.nmJ.field_appId, this.nok, this.nmJ.cnG, this.nuQ);
      bHc();
      AppMethodBeat.o(111801);
      return;
      label505:
      if (this.nmJ.bFQ())
      {
        com.tencent.mm.plugin.game.f.c.t(this.mContext, this.nmJ.nmp.nto, "game_center_hv_game");
        com.tencent.mm.game.report.c.a(this.mContext, this.nmJ.scene, this.nmJ.cFj, this.nmJ.position, 29, this.nmJ.field_appId, this.nok, this.nmJ.cnG, this.nuQ);
        AppMethodBeat.o(111801);
        return;
      }
      j.a(this.nmJ.djJ, this.nmJ.djO, this.nmJ.cFj, this.nmJ.field_appId, this.nuP, this.nuR);
      switch (this.mStatus)
      {
      default: 
        ih(false);
        AppMethodBeat.o(111801);
        return;
      case 1: 
        ab.i("MicroMsg.GameClickListener", "pauseDownloadTask ret = ".concat(String.valueOf(iB(this.nuN.id))));
        AppMethodBeat.o(111801);
        return;
      case 2: 
        bHj();
        AppMethodBeat.o(111801);
        return;
      }
      if ((!bo.isNullOrNil(this.nuM)) && (com.tencent.mm.a.e.cN(this.nuM)) && (com.tencent.mm.plugin.game.f.c.eJ(this.nuM, this.nuO.field_md5)))
      {
        com.tencent.mm.plugin.game.f.c.km(this.nuO.field_downloadId);
        com.tencent.mm.game.report.c.a(this.mContext, this.nmJ.scene, this.nmJ.cFj, this.nmJ.position, 8, this.nmJ.field_appId, this.nok, this.nmJ.cnG, this.nuQ);
        AppMethodBeat.o(111801);
        return;
      }
      ih(false);
      AppMethodBeat.o(111801);
      return;
      label831:
      i = 0;
      j = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.h
 * JD-Core Version:    0.7.0.1
 */