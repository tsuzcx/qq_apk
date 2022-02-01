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
import com.tencent.mm.plugin.downloader.model.f;
import com.tencent.mm.plugin.game.d.bx;
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
  
  private void cEd()
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
      cEe();
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
  
  private void cEe()
  {
    AppMethodBeat.i(41971);
    com.tencent.mm.plugin.downloader.f.a.a(10, new b(this.rVN.field_appId, this.rVN.dvS, this.set.field_downloadId, ""));
    com.tencent.mm.modelstat.d.c(10, "GameClickListener_resumeDownloadTask", hashCode());
    if (f.bQt().oj(this.set.field_downloadId))
    {
      com.tencent.mm.plugin.game.model.e.ar(this.mContext, this.rVN.field_appId);
      com.tencent.mm.game.report.e.a(this.mContext, this.rVN.scene, this.rVN.dvS, this.rVN.position, 4, this.rVN.field_appId, this.rXI, this.rVN.dcC, this.sev);
      AppMethodBeat.o(41971);
      return;
    }
    ad.e("MicroMsg.GameClickListener", "resumeDownloadTask false");
    f.bQt().og(this.set.field_downloadId);
    lU(false);
    AppMethodBeat.o(41971);
  }
  
  private static boolean oi(long paramLong)
  {
    AppMethodBeat.i(41972);
    com.tencent.mm.plugin.downloader.g.a locala = com.tencent.mm.plugin.downloader.model.d.oq(paramLong);
    if ((locala != null) && (locala.field_downloadInWifi))
    {
      locala.field_downloadInWifi = false;
      com.tencent.mm.plugin.downloader.model.d.e(locala);
    }
    boolean bool = f.bQt().oi(paramLong);
    AppMethodBeat.o(41972);
    return bool;
  }
  
  public final void gA(String paramString1, String paramString2)
  {
    this.sev = paramString1;
    this.sew = paramString2;
  }
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(41969);
    int j;
    int i;
    if ((paramView.getTag() instanceof com.tencent.mm.plugin.game.model.c))
    {
      this.rVN = ((com.tencent.mm.plugin.game.model.c)paramView.getTag());
      ad.i("MicroMsg.GameClickListener", "Clicked appid = " + this.rVN.field_appId);
      cDX();
      if (!com.tencent.mm.pluginsdk.model.app.h.t(this.mContext, this.rVN.field_appId)) {
        break label494;
      }
      if (!(this.rVN instanceof com.tencent.mm.plugin.game.model.c)) {
        break label819;
      }
      j = com.tencent.mm.plugin.game.f.c.acX(this.rVN.field_packageName);
      i = this.rVN.versionCode;
    }
    for (;;)
    {
      if (i > j)
      {
        ad.i("MicroMsg.GameClickListener", "AppId: %s installed, local: %d, server: %d", new Object[] { this.rVN.field_appId, Integer.valueOf(j), Integer.valueOf(i) });
        k.a(this.rVN.eog, this.rVN.eol, this.rVN.dvS, this.rVN.field_appId, this.seu, "app_update");
        if (this.ses.status == 1)
        {
          ad.i("MicroMsg.GameClickListener", "pauseDownloadTask ret = ".concat(String.valueOf(oi(this.ses.id))));
          AppMethodBeat.o(41969);
          return;
          ad.e("MicroMsg.GameClickListener", "No AppInfo");
          AppMethodBeat.o(41969);
          return;
        }
        if (this.ses.status == 2)
        {
          cEd();
          AppMethodBeat.o(41969);
          return;
        }
        if (this.ses.status == 3)
        {
          if ((i.eK(this.ses.path)) && (com.tencent.mm.plugin.game.f.c.acY(this.ses.path) > j))
          {
            r.b(this.mContext, this.ses.path, null, false);
            com.tencent.mm.game.report.e.a(this.mContext, this.rVN.scene, this.rVN.dvS, this.rVN.position, 8, this.rVN.field_appId, this.rXI, this.rVN.dcC, this.sev);
            AppMethodBeat.o(41969);
            return;
          }
          lU(true);
          AppMethodBeat.o(41969);
          return;
        }
        lU(true);
        AppMethodBeat.o(41969);
        return;
      }
      ad.i("MicroMsg.GameClickListener", "launchFromWX, appId = %s, pkg = %s, openId = %s", new Object[] { this.rVN.field_appId, this.rVN.field_packageName, this.rVN.field_openId });
      com.tencent.mm.game.report.e.a(this.mContext, this.rVN.scene, this.rVN.dvS, this.rVN.position, 3, this.rVN.field_appId, this.rXI, this.rVN.dcC, this.sev);
      cDW();
      AppMethodBeat.o(41969);
      return;
      label494:
      if (this.rVN.cCJ())
      {
        com.tencent.mm.plugin.game.f.c.A(this.mContext, this.rVN.rVm.scQ, "game_center_hv_game");
        com.tencent.mm.game.report.e.a(this.mContext, this.rVN.scene, this.rVN.dvS, this.rVN.position, 29, this.rVN.field_appId, this.rXI, this.rVN.dcC, this.sev);
        AppMethodBeat.o(41969);
        return;
      }
      k.a(this.rVN.eog, this.rVN.eol, this.rVN.dvS, this.rVN.field_appId, this.seu, this.sew);
      switch (this.mStatus)
      {
      default: 
        lU(false);
        AppMethodBeat.o(41969);
        return;
      case 1: 
        ad.i("MicroMsg.GameClickListener", "pauseDownloadTask ret = ".concat(String.valueOf(oi(this.ses.id))));
        AppMethodBeat.o(41969);
        return;
      case 2: 
        cEd();
        AppMethodBeat.o(41969);
        return;
      }
      if ((!bt.isNullOrNil(this.ser)) && (i.eK(this.ser)) && (com.tencent.mm.plugin.game.f.c.gB(this.ser, this.set.field_md5)))
      {
        com.tencent.mm.plugin.game.f.c.qW(this.set.field_downloadId);
        com.tencent.mm.game.report.e.a(this.mContext, this.rVN.scene, this.rVN.dvS, this.rVN.position, 8, this.rVN.field_appId, this.rXI, this.rVN.dcC, this.sev);
        AppMethodBeat.o(41969);
        return;
      }
      lU(false);
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