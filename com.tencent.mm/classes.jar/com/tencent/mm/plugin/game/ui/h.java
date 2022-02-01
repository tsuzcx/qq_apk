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
import com.tencent.mm.plugin.game.model.e;
import com.tencent.mm.plugin.game.model.k;
import com.tencent.mm.plugin.game.protobuf.cj;
import com.tencent.mm.pluginsdk.model.app.r;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.s;

public final class h
  extends c
{
  public h(Context paramContext)
  {
    super(paramContext);
  }
  
  private static boolean Cp(long paramLong)
  {
    AppMethodBeat.i(41972);
    com.tencent.mm.plugin.downloader.g.a locala = com.tencent.mm.plugin.downloader.model.d.Cw(paramLong);
    if ((locala != null) && (locala.field_downloadInWifi))
    {
      locala.field_downloadInWifi = false;
      com.tencent.mm.plugin.downloader.model.d.e(locala);
    }
    boolean bool = com.tencent.mm.plugin.downloader.model.f.cBv().Cp(paramLong);
    AppMethodBeat.o(41972);
    return bool;
  }
  
  private void dWl()
  {
    AppMethodBeat.i(41970);
    if (!NetStatusUtil.isNetworkConnected(this.mContext))
    {
      Toast.makeText(this.mContext, this.mContext.getString(2131761199), 0).show();
      AppMethodBeat.o(41970);
      return;
    }
    if (NetStatusUtil.isWifi(this.mContext))
    {
      dWm();
      AppMethodBeat.o(41970);
      return;
    }
    com.tencent.mm.ui.base.h.a(this.mContext, this.mContext.getString(2131768552), this.mContext.getString(2131768553), this.mContext.getString(2131768547), this.mContext.getString(2131755761), false, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
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
        Log.i("MicroMsg.GameClickListener", "resumeDownloadTask not wifi, user cancel");
        AppMethodBeat.o(41968);
      }
    }, 2131101414);
    AppMethodBeat.o(41970);
  }
  
  private void dWm()
  {
    AppMethodBeat.i(41971);
    com.tencent.mm.plugin.downloader.f.a.a(10, new b(this.xEP.field_appId, this.xEP.dYu, this.xOj.field_downloadId, ""));
    com.tencent.mm.modelstat.d.d(10, "GameClickListener_resumeDownloadTask", hashCode());
    if (com.tencent.mm.plugin.downloader.model.f.cBv().Cq(this.xOj.field_downloadId))
    {
      e.aK(this.mContext, this.xEP.field_appId);
      com.tencent.mm.game.report.f.a(this.mContext, this.xEP.scene, this.xEP.dYu, this.xEP.position, 4, this.xEP.field_appId, this.xGR, this.xEP.dDJ, this.xOl);
      AppMethodBeat.o(41971);
      return;
    }
    Log.e("MicroMsg.GameClickListener", "resumeDownloadTask false");
    com.tencent.mm.plugin.downloader.model.f.cBv().Cn(this.xOj.field_downloadId);
    pR(false);
    AppMethodBeat.o(41971);
  }
  
  public final void hO(String paramString1, String paramString2)
  {
    this.xOl = paramString1;
    this.xOm = paramString2;
  }
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(41969);
    int j;
    int i;
    if ((paramView.getTag() instanceof com.tencent.mm.plugin.game.model.c))
    {
      this.xEP = ((com.tencent.mm.plugin.game.model.c)paramView.getTag());
      Log.i("MicroMsg.GameClickListener", "Clicked appid = " + this.xEP.field_appId);
      dWf();
      if (!com.tencent.mm.pluginsdk.model.app.h.s(this.mContext, this.xEP.field_appId)) {
        break label494;
      }
      if (!(this.xEP instanceof com.tencent.mm.plugin.game.model.c)) {
        break label819;
      }
      j = com.tencent.mm.plugin.game.e.c.aAH(this.xEP.field_packageName);
      i = this.xEP.versionCode;
    }
    for (;;)
    {
      if (i > j)
      {
        Log.i("MicroMsg.GameClickListener", "AppId: %s installed, local: %d, server: %d", new Object[] { this.xEP.field_appId, Integer.valueOf(j), Integer.valueOf(i) });
        k.a(this.xEP.fmE, this.xEP.fmJ, this.xEP.dYu, this.xEP.field_appId, this.xOk, "app_update");
        if (this.xOi.status == 1)
        {
          Log.i("MicroMsg.GameClickListener", "pauseDownloadTask ret = ".concat(String.valueOf(Cp(this.xOi.id))));
          AppMethodBeat.o(41969);
          return;
          Log.e("MicroMsg.GameClickListener", "No AppInfo");
          AppMethodBeat.o(41969);
          return;
        }
        if (this.xOi.status == 2)
        {
          dWl();
          AppMethodBeat.o(41969);
          return;
        }
        if (this.xOi.status == 3)
        {
          if ((s.YS(this.xOi.path)) && (com.tencent.mm.plugin.game.e.c.aAJ(this.xOi.path) > j))
          {
            r.b(this.mContext, this.xOi.path, null, false);
            com.tencent.mm.game.report.f.a(this.mContext, this.xEP.scene, this.xEP.dYu, this.xEP.position, 8, this.xEP.field_appId, this.xGR, this.xEP.dDJ, this.xOl);
            AppMethodBeat.o(41969);
            return;
          }
          pR(true);
          AppMethodBeat.o(41969);
          return;
        }
        pR(true);
        AppMethodBeat.o(41969);
        return;
      }
      Log.i("MicroMsg.GameClickListener", "launchFromWX, appId = %s, pkg = %s, openId = %s", new Object[] { this.xEP.field_appId, this.xEP.field_packageName, this.xEP.field_openId });
      com.tencent.mm.game.report.f.a(this.mContext, this.xEP.scene, this.xEP.dYu, this.xEP.position, 3, this.xEP.field_appId, this.xGR, this.xEP.dDJ, this.xOl);
      dWe();
      AppMethodBeat.o(41969);
      return;
      label494:
      if (this.xEP.dUP())
      {
        com.tencent.mm.plugin.game.e.c.D(this.mContext, this.xEP.xEo.xMp, "game_center_hv_game");
        com.tencent.mm.game.report.f.a(this.mContext, this.xEP.scene, this.xEP.dYu, this.xEP.position, 29, this.xEP.field_appId, this.xGR, this.xEP.dDJ, this.xOl);
        AppMethodBeat.o(41969);
        return;
      }
      k.a(this.xEP.fmE, this.xEP.fmJ, this.xEP.dYu, this.xEP.field_appId, this.xOk, this.xOm);
      switch (this.mStatus)
      {
      default: 
        pR(false);
        AppMethodBeat.o(41969);
        return;
      case 1: 
        Log.i("MicroMsg.GameClickListener", "pauseDownloadTask ret = ".concat(String.valueOf(Cp(this.xOi.id))));
        AppMethodBeat.o(41969);
        return;
      case 2: 
        dWl();
        AppMethodBeat.o(41969);
        return;
      }
      if ((!Util.isNullOrNil(this.xOh)) && (s.YS(this.xOh)) && (com.tencent.mm.plugin.game.e.c.hR(this.xOh, this.xOj.field_md5)))
      {
        com.tencent.mm.plugin.game.e.c.GK(this.xOj.field_downloadId);
        com.tencent.mm.game.report.f.a(this.mContext, this.xEP.scene, this.xEP.dYu, this.xEP.position, 8, this.xEP.field_appId, this.xGR, this.xEP.dDJ, this.xOl);
        AppMethodBeat.o(41969);
        return;
      }
      pR(false);
      AppMethodBeat.o(41969);
      return;
      label819:
      i = 0;
      j = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.h
 * JD-Core Version:    0.7.0.1
 */