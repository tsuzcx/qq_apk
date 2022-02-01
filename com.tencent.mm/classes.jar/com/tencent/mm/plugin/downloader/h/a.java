package com.tencent.mm.plugin.downloader.h;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.opensdk.modelmsg.WXAppExtendObject;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.downloader.e.b;
import com.tencent.mm.plugin.downloader.model.d;
import com.tencent.mm.plugin.downloader.model.e;
import com.tencent.mm.plugin.downloader.model.f;
import com.tencent.mm.pluginsdk.model.app.ap;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.pluginsdk.model.app.q;
import com.tencent.mm.pluginsdk.model.app.v;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.y;

public final class a
{
  public static void a(long paramLong, final boolean paramBoolean, final com.tencent.mm.pluginsdk.permission.a parama)
  {
    AppMethodBeat.i(89133);
    com.tencent.mm.plugin.downloader.f.a locala = d.la(paramLong);
    if ((locala == null) || (locala.field_status != 3) || (!y.ZC(locala.field_filePath)))
    {
      if (parama != null) {
        parama.iZ(false);
      }
      AppMethodBeat.o(89133);
      return;
    }
    if (!e.g(locala))
    {
      Log.i("MicroMsg.DownloadAppUtil", "install, md5 check fail");
      y.deleteFile(locala.field_filePath);
      d.lb(paramLong);
      com.tencent.mm.plugin.report.service.h.OAn.kJ(860, 35);
      AppMethodBeat.o(89133);
      return;
    }
    if (Util.isNullOrNil(locala.field_packageName))
    {
      String str = f.amQ(locala.field_filePath);
      if (!Util.isNullOrNil(str))
      {
        locala.field_packageName = str;
        Log.i("MicroMsg.DownloadAppUtil", "get package name from file : %s, %s", new Object[] { locala.field_filePath, str });
        d.e(locala);
      }
    }
    a(locala.field_filePath, new com.tencent.mm.pluginsdk.permission.a()
    {
      public final void iZ(boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(89130);
        b localb;
        if (paramAnonymousBoolean)
        {
          localb = new b();
          localb.k(a.this);
          String str = a.this.field_packageName;
          SharedPreferences localSharedPreferences = MMApplicationContext.getContext().getSharedPreferences("install_begin_time", 0);
          if (localSharedPreferences != null) {
            localSharedPreferences.edit().putLong(str, System.currentTimeMillis()).apply();
          }
          com.tencent.mm.plugin.downloader.e.a.a(a.this.field_appId, a.this.field_scene, 4, a.this.field_md5, a.this.field_downloadUrl, null, a.this.field_extInfo);
          localb.costTime = ((System.currentTimeMillis() - a.this.field_startTime) / 1000L);
          com.tencent.mm.plugin.downloader.e.a.a(4, localb);
          if (!paramBoolean) {
            break label170;
          }
          com.tencent.mm.plugin.downloader.e.a.a(15, localb);
        }
        for (;;)
        {
          if (parama != null) {
            parama.iZ(paramAnonymousBoolean);
          }
          AppMethodBeat.o(89130);
          return;
          label170:
          com.tencent.mm.plugin.downloader.e.a.a(16, localb);
        }
      }
    });
    AppMethodBeat.o(89133);
  }
  
  public static void a(String paramString, com.tencent.mm.pluginsdk.permission.a parama)
  {
    AppMethodBeat.i(89134);
    if (Util.isNullOrNil(paramString))
    {
      Log.e("MicroMsg.DownloadAppUtil", "installApk, path is null");
      if (parama != null) {
        parama.iZ(false);
      }
      AppMethodBeat.o(89134);
      return;
    }
    Log.i("MicroMsg.DownloadAppUtil", "installApk, path = ".concat(String.valueOf(paramString)));
    if (!y.ZC(paramString))
    {
      Log.e("MicroMsg.DownloadAppUtil", "installApk, path not exists");
      if (parama != null) {
        parama.iZ(false);
      }
      AppMethodBeat.o(89134);
      return;
    }
    v.b(MMApplicationContext.getContext(), paramString, parama, true);
    AppMethodBeat.o(89134);
  }
  
  public static void at(Context paramContext, final String paramString)
  {
    AppMethodBeat.i(267091);
    final ap local2 = new ap()
    {
      public final void onLaunchApp(boolean paramAnonymousBoolean1, boolean paramAnonymousBoolean2)
      {
        AppMethodBeat.i(267089);
        if (this.xpd != null) {
          this.xpd.onLaunchApp(paramAnonymousBoolean1, paramAnonymousBoolean2);
        }
        AppMethodBeat.o(267089);
      }
    };
    if (Util.isNullOrNil(paramString))
    {
      Log.e("MicroMsg.DownloadAppUtil", "null or nil appid");
      local2.onLaunchApp(false, false);
    }
    paramString = com.tencent.mm.pluginsdk.model.app.h.s(paramString, true, false);
    if ((paramString == null) || (Util.isNullOrNil(paramString.field_appId)))
    {
      Log.e("MicroMsg.DownloadAppUtil", "appinfo is null or appid is null");
      local2.onLaunchApp(false, false);
      AppMethodBeat.o(267091);
      return;
    }
    final WXMediaMessage localWXMediaMessage = new WXMediaMessage(new WXAppExtendObject());
    localWXMediaMessage.sdkVer = 638058496;
    localWXMediaMessage.messageAction = null;
    localWXMediaMessage.messageExt = "WX_GameCenter";
    Log.d("MicroMsg.DownloadAppUtil", "launch game app from wx: appid: [%s], appname:[%s], openid:[%s]", new Object[] { paramString.field_appId, paramString.field_appName, paramString.field_openId });
    if (Util.isNullOrNil(paramString.field_openId))
    {
      Log.i("MicroMsg.DownloadAppUtil", "open id is null or nil, try to get from server:[%s]", new Object[] { paramString.field_appName });
      com.tencent.mm.plugin.openapi.a.gxp().add(paramString.field_appId);
    }
    com.tencent.mm.ci.a.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(89132);
        com.tencent.mm.pluginsdk.model.app.h.a(a.this, paramString.field_packageName, localWXMediaMessage, paramString.field_appId, paramString.field_openId, 0, local2, null);
        AppMethodBeat.o(89132);
      }
    });
    AppMethodBeat.o(267091);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader.h.a
 * JD-Core Version:    0.7.0.1
 */