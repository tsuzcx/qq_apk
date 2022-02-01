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
import com.tencent.mm.plugin.game.d.cj;
import com.tencent.mm.plugin.game.model.e;
import com.tencent.mm.plugin.game.model.k;
import com.tencent.mm.pluginsdk.model.app.r;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.az;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.vfs.o;

public final class h
  extends c
{
  public h(Context paramContext)
  {
    super(paramContext);
  }
  
  private void dcE()
  {
    AppMethodBeat.i(41970);
    if (!az.isNetworkConnected(this.mContext))
    {
      Toast.makeText(this.mContext, this.mContext.getString(2131759864), 0).show();
      AppMethodBeat.o(41970);
      return;
    }
    if (az.isWifi(this.mContext))
    {
      dcF();
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
        ae.i("MicroMsg.GameClickListener", "resumeDownloadTask not wifi, user cancel");
        AppMethodBeat.o(41968);
      }
    }, 2131101171);
    AppMethodBeat.o(41970);
  }
  
  private void dcF()
  {
    AppMethodBeat.i(41971);
    com.tencent.mm.plugin.downloader.f.a.a(10, new b(this.umx.field_appId, this.umx.dGL, this.uwi.field_downloadId, ""));
    com.tencent.mm.modelstat.d.d(10, "GameClickListener_resumeDownloadTask", hashCode());
    if (com.tencent.mm.plugin.downloader.model.f.cdA().ul(this.uwi.field_downloadId))
    {
      e.ax(this.mContext, this.umx.field_appId);
      com.tencent.mm.game.report.f.a(this.mContext, this.umx.scene, this.umx.dGL, this.umx.position, 4, this.umx.field_appId, this.uoy, this.umx.dmu, this.uwk);
      AppMethodBeat.o(41971);
      return;
    }
    ae.e("MicroMsg.GameClickListener", "resumeDownloadTask false");
    com.tencent.mm.plugin.downloader.model.f.cdA().ui(this.uwi.field_downloadId);
    nl(false);
    AppMethodBeat.o(41971);
  }
  
  private static boolean uk(long paramLong)
  {
    AppMethodBeat.i(41972);
    com.tencent.mm.plugin.downloader.g.a locala = com.tencent.mm.plugin.downloader.model.d.ur(paramLong);
    if ((locala != null) && (locala.field_downloadInWifi))
    {
      locala.field_downloadInWifi = false;
      com.tencent.mm.plugin.downloader.model.d.e(locala);
    }
    boolean bool = com.tencent.mm.plugin.downloader.model.f.cdA().uk(paramLong);
    AppMethodBeat.o(41972);
    return bool;
  }
  
  public final void hh(String paramString1, String paramString2)
  {
    this.uwk = paramString1;
    this.uwl = paramString2;
  }
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(41969);
    int j;
    int i;
    if ((paramView.getTag() instanceof com.tencent.mm.plugin.game.model.c))
    {
      this.umx = ((com.tencent.mm.plugin.game.model.c)paramView.getTag());
      ae.i("MicroMsg.GameClickListener", "Clicked appid = " + this.umx.field_appId);
      dcy();
      if (!com.tencent.mm.pluginsdk.model.app.h.s(this.mContext, this.umx.field_appId)) {
        break label494;
      }
      if (!(this.umx instanceof com.tencent.mm.plugin.game.model.c)) {
        break label819;
      }
      j = com.tencent.mm.plugin.game.f.c.anq(this.umx.field_packageName);
      i = this.umx.versionCode;
    }
    for (;;)
    {
      if (i > j)
      {
        ae.i("MicroMsg.GameClickListener", "AppId: %s installed, local: %d, server: %d", new Object[] { this.umx.field_appId, Integer.valueOf(j), Integer.valueOf(i) });
        k.a(this.umx.eJc, this.umx.eJh, this.umx.dGL, this.umx.field_appId, this.uwj, "app_update");
        if (this.uwh.status == 1)
        {
          ae.i("MicroMsg.GameClickListener", "pauseDownloadTask ret = ".concat(String.valueOf(uk(this.uwh.id))));
          AppMethodBeat.o(41969);
          return;
          ae.e("MicroMsg.GameClickListener", "No AppInfo");
          AppMethodBeat.o(41969);
          return;
        }
        if (this.uwh.status == 2)
        {
          dcE();
          AppMethodBeat.o(41969);
          return;
        }
        if (this.uwh.status == 3)
        {
          if ((o.fB(this.uwh.path)) && (com.tencent.mm.plugin.game.f.c.anr(this.uwh.path) > j))
          {
            r.b(this.mContext, this.uwh.path, null, false);
            com.tencent.mm.game.report.f.a(this.mContext, this.umx.scene, this.umx.dGL, this.umx.position, 8, this.umx.field_appId, this.uoy, this.umx.dmu, this.uwk);
            AppMethodBeat.o(41969);
            return;
          }
          nl(true);
          AppMethodBeat.o(41969);
          return;
        }
        nl(true);
        AppMethodBeat.o(41969);
        return;
      }
      ae.i("MicroMsg.GameClickListener", "launchFromWX, appId = %s, pkg = %s, openId = %s", new Object[] { this.umx.field_appId, this.umx.field_packageName, this.umx.field_openId });
      com.tencent.mm.game.report.f.a(this.mContext, this.umx.scene, this.umx.dGL, this.umx.position, 3, this.umx.field_appId, this.uoy, this.umx.dmu, this.uwk);
      dcx();
      AppMethodBeat.o(41969);
      return;
      label494:
      if (this.umx.dbi())
      {
        com.tencent.mm.plugin.game.f.c.B(this.mContext, this.umx.ulW.uun, "game_center_hv_game");
        com.tencent.mm.game.report.f.a(this.mContext, this.umx.scene, this.umx.dGL, this.umx.position, 29, this.umx.field_appId, this.uoy, this.umx.dmu, this.uwk);
        AppMethodBeat.o(41969);
        return;
      }
      k.a(this.umx.eJc, this.umx.eJh, this.umx.dGL, this.umx.field_appId, this.uwj, this.uwl);
      switch (this.mStatus)
      {
      default: 
        nl(false);
        AppMethodBeat.o(41969);
        return;
      case 1: 
        ae.i("MicroMsg.GameClickListener", "pauseDownloadTask ret = ".concat(String.valueOf(uk(this.uwh.id))));
        AppMethodBeat.o(41969);
        return;
      case 2: 
        dcE();
        AppMethodBeat.o(41969);
        return;
      }
      if ((!bu.isNullOrNil(this.uwg)) && (o.fB(this.uwg)) && (com.tencent.mm.plugin.game.f.c.hk(this.uwg, this.uwi.field_md5)))
      {
        com.tencent.mm.plugin.game.f.c.ya(this.uwi.field_downloadId);
        com.tencent.mm.game.report.f.a(this.mContext, this.umx.scene, this.umx.dGL, this.umx.position, 8, this.umx.field_appId, this.uoy, this.umx.dmu, this.uwk);
        AppMethodBeat.o(41969);
        return;
      }
      nl(false);
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