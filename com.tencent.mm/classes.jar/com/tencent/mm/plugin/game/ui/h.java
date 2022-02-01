package com.tencent.mm.plugin.game.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.view.View;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.y;
import com.tencent.mm.plugin.downloader.f.b;
import com.tencent.mm.plugin.downloader.model.FileDownloadTaskInfo;
import com.tencent.mm.plugin.game.d.cc;
import com.tencent.mm.plugin.game.model.e;
import com.tencent.mm.plugin.game.model.k;
import com.tencent.mm.pluginsdk.model.app.r;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ay;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.vfs.i;

public final class h
  extends c
{
  public h(Context paramContext)
  {
    super(paramContext);
  }
  
  private void cZT()
  {
    AppMethodBeat.i(41970);
    if (!ay.isNetworkConnected(this.mContext))
    {
      Toast.makeText(this.mContext, this.mContext.getString(2131759864), 0).show();
      AppMethodBeat.o(41970);
      return;
    }
    if (ay.isWifi(this.mContext))
    {
      cZU();
      AppMethodBeat.o(41970);
      return;
    }
    com.tencent.mm.ui.base.h.a(this.mContext, this.mContext.getString(2131766086), this.mContext.getString(2131766087), this.mContext.getString(2131766081), this.mContext.getString(2131755691), false, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(41967);
        h.a(h.this);
        paramAnonymousDialogInterface.dismiss();
        AppMethodBeat.o(41967);
      }
    }, new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(41968);
        paramAnonymousDialogInterface.dismiss();
        ad.i("MicroMsg.GameClickListener", "resumeDownloadTask not wifi, user cancel");
        AppMethodBeat.o(41968);
      }
    }, 2131101171);
    AppMethodBeat.o(41970);
  }
  
  private void cZU()
  {
    AppMethodBeat.i(41971);
    com.tencent.mm.plugin.downloader.f.a.a(10, new b(this.ubv.field_appId, this.ubv.dFG, this.ukL.field_downloadId, ""));
    com.tencent.mm.modelstat.d.d(10, "GameClickListener_resumeDownloadTask", hashCode());
    if (com.tencent.mm.plugin.downloader.model.f.ccl().tU(this.ukL.field_downloadId))
    {
      e.av(this.mContext, this.ubv.field_appId);
      com.tencent.mm.game.report.f.a(this.mContext, this.ubv.scene, this.ubv.dFG, this.ubv.position, 4, this.ubv.field_appId, this.udq, this.ubv.dls, this.ukN);
      AppMethodBeat.o(41971);
      return;
    }
    ad.e("MicroMsg.GameClickListener", "resumeDownloadTask false");
    com.tencent.mm.plugin.downloader.model.f.ccl().tR(this.ukL.field_downloadId);
    nh(false);
    AppMethodBeat.o(41971);
  }
  
  private static boolean tT(long paramLong)
  {
    AppMethodBeat.i(41972);
    com.tencent.mm.plugin.downloader.g.a locala = com.tencent.mm.plugin.downloader.model.d.ua(paramLong);
    if ((locala != null) && (locala.field_downloadInWifi))
    {
      locala.field_downloadInWifi = false;
      com.tencent.mm.plugin.downloader.model.d.e(locala);
    }
    boolean bool = com.tencent.mm.plugin.downloader.model.f.ccl().tT(paramLong);
    AppMethodBeat.o(41972);
    return bool;
  }
  
  public final void hc(String paramString1, String paramString2)
  {
    this.ukN = paramString1;
    this.ukO = paramString2;
  }
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(41969);
    int j;
    int i;
    if ((paramView.getTag() instanceof com.tencent.mm.plugin.game.model.c))
    {
      this.ubv = ((com.tencent.mm.plugin.game.model.c)paramView.getTag());
      ad.i("MicroMsg.GameClickListener", "Clicked appid = " + this.ubv.field_appId);
      cZN();
      if (!com.tencent.mm.pluginsdk.model.app.h.s(this.mContext, this.ubv.field_appId)) {
        break label494;
      }
      if (!(this.ubv instanceof com.tencent.mm.plugin.game.model.c)) {
        break label819;
      }
      j = com.tencent.mm.plugin.game.f.c.ams(this.ubv.field_packageName);
      i = this.ubv.versionCode;
    }
    for (;;)
    {
      if (i > j)
      {
        ad.i("MicroMsg.GameClickListener", "AppId: %s installed, local: %d, server: %d", new Object[] { this.ubv.field_appId, Integer.valueOf(j), Integer.valueOf(i) });
        k.a(this.ubv.eHt, this.ubv.eHy, this.ubv.dFG, this.ubv.field_appId, this.ukM, "app_update");
        if (this.ukK.status == 1)
        {
          ad.i("MicroMsg.GameClickListener", "pauseDownloadTask ret = ".concat(String.valueOf(tT(this.ukK.id))));
          AppMethodBeat.o(41969);
          return;
          ad.e("MicroMsg.GameClickListener", "No AppInfo");
          AppMethodBeat.o(41969);
          return;
        }
        if (this.ukK.status == 2)
        {
          cZT();
          AppMethodBeat.o(41969);
          return;
        }
        if (this.ukK.status == 3)
        {
          if ((i.fv(this.ukK.path)) && (com.tencent.mm.plugin.game.f.c.amt(this.ukK.path) > j))
          {
            r.b(this.mContext, this.ukK.path, null, false);
            com.tencent.mm.game.report.f.a(this.mContext, this.ubv.scene, this.ubv.dFG, this.ubv.position, 8, this.ubv.field_appId, this.udq, this.ubv.dls, this.ukN);
            AppMethodBeat.o(41969);
            return;
          }
          nh(true);
          AppMethodBeat.o(41969);
          return;
        }
        nh(true);
        AppMethodBeat.o(41969);
        return;
      }
      ad.i("MicroMsg.GameClickListener", "launchFromWX, appId = %s, pkg = %s, openId = %s", new Object[] { this.ubv.field_appId, this.ubv.field_packageName, this.ubv.field_openId });
      com.tencent.mm.game.report.f.a(this.mContext, this.ubv.scene, this.ubv.dFG, this.ubv.position, 3, this.ubv.field_appId, this.udq, this.ubv.dls, this.ukN);
      cZM();
      AppMethodBeat.o(41969);
      return;
      label494:
      if (this.ubv.cYy())
      {
        com.tencent.mm.plugin.game.f.c.B(this.mContext, this.ubv.uaU.uiQ, "game_center_hv_game");
        com.tencent.mm.game.report.f.a(this.mContext, this.ubv.scene, this.ubv.dFG, this.ubv.position, 29, this.ubv.field_appId, this.udq, this.ubv.dls, this.ukN);
        AppMethodBeat.o(41969);
        return;
      }
      k.a(this.ubv.eHt, this.ubv.eHy, this.ubv.dFG, this.ubv.field_appId, this.ukM, this.ukO);
      switch (this.mStatus)
      {
      default: 
        nh(false);
        AppMethodBeat.o(41969);
        return;
      case 1: 
        ad.i("MicroMsg.GameClickListener", "pauseDownloadTask ret = ".concat(String.valueOf(tT(this.ukK.id))));
        AppMethodBeat.o(41969);
        return;
      case 2: 
        cZT();
        AppMethodBeat.o(41969);
        return;
      }
      if ((!bt.isNullOrNil(this.ukJ)) && (i.fv(this.ukJ)) && (com.tencent.mm.plugin.game.f.c.hd(this.ukJ, this.ukL.field_md5)))
      {
        com.tencent.mm.plugin.game.f.c.xG(this.ukL.field_downloadId);
        com.tencent.mm.game.report.f.a(this.mContext, this.ubv.scene, this.ubv.dFG, this.ubv.position, 8, this.ubv.field_appId, this.udq, this.ubv.dls, this.ukN);
        AppMethodBeat.o(41969);
        return;
      }
      nh(false);
      AppMethodBeat.o(41969);
      return;
      label819:
      i = 0;
      j = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.h
 * JD-Core Version:    0.7.0.1
 */