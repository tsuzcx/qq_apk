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
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ax;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.vfs.i;

public final class h
  extends c
{
  public h(Context paramContext)
  {
    super(paramContext);
  }
  
  private void cRn()
  {
    AppMethodBeat.i(41970);
    if (!ax.isNetworkConnected(this.mContext))
    {
      Toast.makeText(this.mContext, this.mContext.getString(2131759864), 0).show();
      AppMethodBeat.o(41970);
      return;
    }
    if (ax.isWifi(this.mContext))
    {
      cRo();
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
        ac.i("MicroMsg.GameClickListener", "resumeDownloadTask not wifi, user cancel");
        AppMethodBeat.o(41968);
      }
    }, 2131101171);
    AppMethodBeat.o(41970);
  }
  
  private void cRo()
  {
    AppMethodBeat.i(41971);
    com.tencent.mm.plugin.downloader.f.a.a(10, new b(this.tdF.field_appId, this.tdF.dtF, this.tmm.field_downloadId, ""));
    com.tencent.mm.modelstat.d.d(10, "GameClickListener_resumeDownloadTask", hashCode());
    if (f.bXJ().rV(this.tmm.field_downloadId))
    {
      com.tencent.mm.plugin.game.model.e.as(this.mContext, this.tdF.field_appId);
      com.tencent.mm.game.report.e.a(this.mContext, this.tdF.scene, this.tdF.dtF, this.tdF.position, 4, this.tdF.field_appId, this.tfA, this.tdF.daa, this.tmo);
      AppMethodBeat.o(41971);
      return;
    }
    ac.e("MicroMsg.GameClickListener", "resumeDownloadTask false");
    f.bXJ().rS(this.tmm.field_downloadId);
    mN(false);
    AppMethodBeat.o(41971);
  }
  
  private static boolean rU(long paramLong)
  {
    AppMethodBeat.i(41972);
    com.tencent.mm.plugin.downloader.g.a locala = com.tencent.mm.plugin.downloader.model.d.sc(paramLong);
    if ((locala != null) && (locala.field_downloadInWifi))
    {
      locala.field_downloadInWifi = false;
      com.tencent.mm.plugin.downloader.model.d.e(locala);
    }
    boolean bool = f.bXJ().rU(paramLong);
    AppMethodBeat.o(41972);
    return bool;
  }
  
  public final void gR(String paramString1, String paramString2)
  {
    this.tmo = paramString1;
    this.tmp = paramString2;
  }
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(41969);
    int j;
    int i;
    if ((paramView.getTag() instanceof com.tencent.mm.plugin.game.model.c))
    {
      this.tdF = ((com.tencent.mm.plugin.game.model.c)paramView.getTag());
      ac.i("MicroMsg.GameClickListener", "Clicked appid = " + this.tdF.field_appId);
      cRh();
      if (!com.tencent.mm.pluginsdk.model.app.h.t(this.mContext, this.tdF.field_appId)) {
        break label494;
      }
      if (!(this.tdF instanceof com.tencent.mm.plugin.game.model.c)) {
        break label819;
      }
      j = com.tencent.mm.plugin.game.f.c.ahP(this.tdF.field_packageName);
      i = this.tdF.versionCode;
    }
    for (;;)
    {
      if (i > j)
      {
        ac.i("MicroMsg.GameClickListener", "AppId: %s installed, local: %d, server: %d", new Object[] { this.tdF.field_appId, Integer.valueOf(j), Integer.valueOf(i) });
        k.a(this.tdF.eqk, this.tdF.eqp, this.tdF.dtF, this.tdF.field_appId, this.tmn, "app_update");
        if (this.tml.status == 1)
        {
          ac.i("MicroMsg.GameClickListener", "pauseDownloadTask ret = ".concat(String.valueOf(rU(this.tml.id))));
          AppMethodBeat.o(41969);
          return;
          ac.e("MicroMsg.GameClickListener", "No AppInfo");
          AppMethodBeat.o(41969);
          return;
        }
        if (this.tml.status == 2)
        {
          cRn();
          AppMethodBeat.o(41969);
          return;
        }
        if (this.tml.status == 3)
        {
          if ((i.eA(this.tml.path)) && (com.tencent.mm.plugin.game.f.c.ahQ(this.tml.path) > j))
          {
            r.b(this.mContext, this.tml.path, null, false);
            com.tencent.mm.game.report.e.a(this.mContext, this.tdF.scene, this.tdF.dtF, this.tdF.position, 8, this.tdF.field_appId, this.tfA, this.tdF.daa, this.tmo);
            AppMethodBeat.o(41969);
            return;
          }
          mN(true);
          AppMethodBeat.o(41969);
          return;
        }
        mN(true);
        AppMethodBeat.o(41969);
        return;
      }
      ac.i("MicroMsg.GameClickListener", "launchFromWX, appId = %s, pkg = %s, openId = %s", new Object[] { this.tdF.field_appId, this.tdF.field_packageName, this.tdF.field_openId });
      com.tencent.mm.game.report.e.a(this.mContext, this.tdF.scene, this.tdF.dtF, this.tdF.position, 3, this.tdF.field_appId, this.tfA, this.tdF.daa, this.tmo);
      cRg();
      AppMethodBeat.o(41969);
      return;
      label494:
      if (this.tdF.cPT())
      {
        com.tencent.mm.plugin.game.f.c.z(this.mContext, this.tdF.tde.tkK, "game_center_hv_game");
        com.tencent.mm.game.report.e.a(this.mContext, this.tdF.scene, this.tdF.dtF, this.tdF.position, 29, this.tdF.field_appId, this.tfA, this.tdF.daa, this.tmo);
        AppMethodBeat.o(41969);
        return;
      }
      k.a(this.tdF.eqk, this.tdF.eqp, this.tdF.dtF, this.tdF.field_appId, this.tmn, this.tmp);
      switch (this.mStatus)
      {
      default: 
        mN(false);
        AppMethodBeat.o(41969);
        return;
      case 1: 
        ac.i("MicroMsg.GameClickListener", "pauseDownloadTask ret = ".concat(String.valueOf(rU(this.tml.id))));
        AppMethodBeat.o(41969);
        return;
      case 2: 
        cRn();
        AppMethodBeat.o(41969);
        return;
      }
      if ((!bs.isNullOrNil(this.tmk)) && (i.eA(this.tmk)) && (com.tencent.mm.plugin.game.f.c.gS(this.tmk, this.tmm.field_md5)))
      {
        com.tencent.mm.plugin.game.f.c.vz(this.tmm.field_downloadId);
        com.tencent.mm.game.report.e.a(this.mContext, this.tdF.scene, this.tdF.dtF, this.tdF.position, 8, this.tdF.field_appId, this.tfA, this.tdF.daa, this.tmo);
        AppMethodBeat.o(41969);
        return;
      }
      mN(false);
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