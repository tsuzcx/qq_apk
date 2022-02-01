package com.tencent.mm.plugin.downloader.i;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.opensdk.modelmsg.WXAppExtendObject;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.downloader.f.b;
import com.tencent.mm.plugin.downloader.model.d;
import com.tencent.mm.plugin.downloader.model.e;
import com.tencent.mm.pluginsdk.model.app.al;
import com.tencent.mm.pluginsdk.model.app.h;
import com.tencent.mm.pluginsdk.model.app.n;
import com.tencent.mm.pluginsdk.model.app.r;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.vfs.o;

public final class a
{
  public static void a(long paramLong, final boolean paramBoolean, final com.tencent.mm.pluginsdk.permission.a parama)
  {
    AppMethodBeat.i(89133);
    com.tencent.mm.plugin.downloader.g.a locala = d.ur(paramLong);
    if ((locala == null) || (locala.field_status != 3) || (!o.fB(locala.field_filePath)))
    {
      if (parama != null) {
        parama.gn(false);
      }
      AppMethodBeat.o(89133);
      return;
    }
    if (!e.g(locala))
    {
      ae.i("MicroMsg.DownloadAppUtil", "install, md5 check fail");
      o.deleteFile(locala.field_filePath);
      d.us(paramLong);
      com.tencent.mm.plugin.report.service.g.yxI.dD(860, 35);
      AppMethodBeat.o(89133);
      return;
    }
    a(locala.field_filePath, new com.tencent.mm.pluginsdk.permission.a()
    {
      public final void gn(boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(89130);
        b localb;
        if (paramAnonymousBoolean)
        {
          localb = new b();
          localb.k(this.psD);
          String str = this.psD.field_packageName;
          SharedPreferences localSharedPreferences = ak.getContext().getSharedPreferences("install_begin_time", 0);
          if (localSharedPreferences != null) {
            localSharedPreferences.edit().putLong(str, System.currentTimeMillis()).apply();
          }
          com.tencent.mm.plugin.downloader.f.a.a(this.psD.field_appId, this.psD.field_scene, 4, this.psD.field_md5, this.psD.field_downloadUrl, null, this.psD.field_extInfo);
          localb.mxN = ((System.currentTimeMillis() - this.psD.field_startTime) / 1000L);
          com.tencent.mm.plugin.downloader.f.a.a(4, localb);
          if (!paramBoolean) {
            break label170;
          }
          com.tencent.mm.plugin.downloader.f.a.a(15, localb);
        }
        for (;;)
        {
          if (parama != null) {
            parama.gn(paramAnonymousBoolean);
          }
          AppMethodBeat.o(89130);
          return;
          label170:
          com.tencent.mm.plugin.downloader.f.a.a(16, localb);
        }
      }
    });
    AppMethodBeat.o(89133);
  }
  
  public static void a(Context paramContext, final String paramString, final al paramal)
  {
    AppMethodBeat.i(89135);
    paramal = new al()
    {
      public final void v(boolean paramAnonymousBoolean1, boolean paramAnonymousBoolean2)
      {
        AppMethodBeat.i(207170);
        if (this.puq != null) {
          this.puq.v(paramAnonymousBoolean1, paramAnonymousBoolean2);
        }
        AppMethodBeat.o(207170);
      }
    };
    if (bu.isNullOrNil(paramString))
    {
      ae.e("MicroMsg.DownloadAppUtil", "null or nil appid");
      paramal.v(false, false);
    }
    paramString = h.m(paramString, true, false);
    if ((paramString == null) || (bu.isNullOrNil(paramString.field_appId)))
    {
      ae.e("MicroMsg.DownloadAppUtil", "appinfo is null or appid is null");
      paramal.v(false, false);
      AppMethodBeat.o(89135);
      return;
    }
    final WXMediaMessage localWXMediaMessage = new WXMediaMessage(new WXAppExtendObject());
    localWXMediaMessage.sdkVer = 637928960;
    localWXMediaMessage.messageAction = null;
    localWXMediaMessage.messageExt = "WX_GameCenter";
    ae.d("MicroMsg.DownloadAppUtil", "launch game app from wx: appid: [%s], appname:[%s], openid:[%s]", new Object[] { paramString.field_appId, paramString.field_appName, paramString.field_openId });
    if (bu.isNullOrNil(paramString.field_openId))
    {
      ae.i("MicroMsg.DownloadAppUtil", "open id is null or nil, try to get from server:[%s]", new Object[] { paramString.field_appName });
      com.tencent.mm.plugin.s.a.dBi().EL(paramString.field_appId);
    }
    com.tencent.mm.ch.a.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(89132);
        h.a(this.val$context, paramString.field_packageName, localWXMediaMessage, paramString.field_appId, paramString.field_openId, 0, paramal, null);
        AppMethodBeat.o(89132);
      }
    });
    AppMethodBeat.o(89135);
  }
  
  public static void a(String paramString, com.tencent.mm.pluginsdk.permission.a parama)
  {
    AppMethodBeat.i(89134);
    if (bu.isNullOrNil(paramString))
    {
      ae.e("MicroMsg.DownloadAppUtil", "installApk, path is null");
      if (parama != null) {
        parama.gn(false);
      }
      AppMethodBeat.o(89134);
      return;
    }
    ae.i("MicroMsg.DownloadAppUtil", "installApk, path = ".concat(String.valueOf(paramString)));
    if (!o.fB(paramString))
    {
      ae.e("MicroMsg.DownloadAppUtil", "installApk, path not exists");
      if (parama != null) {
        parama.gn(false);
      }
      AppMethodBeat.o(89134);
      return;
    }
    r.b(ak.getContext(), paramString, parama, true);
    AppMethodBeat.o(89134);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader.i.a
 * JD-Core Version:    0.7.0.1
 */