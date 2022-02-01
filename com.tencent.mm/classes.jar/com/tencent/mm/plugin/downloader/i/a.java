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
import com.tencent.mm.pluginsdk.model.app.am;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.pluginsdk.model.app.n;
import com.tencent.mm.pluginsdk.model.app.r;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.vfs.i;

public final class a
{
  public static void a(long paramLong, final boolean paramBoolean, final com.tencent.mm.pluginsdk.permission.a parama)
  {
    AppMethodBeat.i(89133);
    com.tencent.mm.plugin.downloader.g.a locala = d.sc(paramLong);
    if ((locala == null) || (locala.field_status != 3) || (!i.eA(locala.field_filePath)))
    {
      if (parama != null) {
        parama.gk(false);
      }
      AppMethodBeat.o(89133);
      return;
    }
    if (!e.g(locala))
    {
      ac.i("MicroMsg.DownloadAppUtil", "install, md5 check fail");
      i.deleteFile(locala.field_filePath);
      d.sd(paramLong);
      com.tencent.mm.plugin.report.service.h.wUl.dB(860, 35);
      AppMethodBeat.o(89133);
      return;
    }
    a(locala.field_filePath, new com.tencent.mm.pluginsdk.permission.a()
    {
      public final void gk(boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(89130);
        b localb;
        if (paramAnonymousBoolean)
        {
          localb = new b();
          localb.k(this.oIu);
          String str = this.oIu.field_packageName;
          SharedPreferences localSharedPreferences = ai.getContext().getSharedPreferences("install_begin_time", 0);
          if (localSharedPreferences != null) {
            localSharedPreferences.edit().putLong(str, System.currentTimeMillis()).apply();
          }
          com.tencent.mm.plugin.downloader.f.a.a(this.oIu.field_appId, this.oIu.field_scene, 4, this.oIu.field_md5, this.oIu.field_downloadUrl, null, this.oIu.field_extInfo);
          localb.lTa = ((System.currentTimeMillis() - this.oIu.field_startTime) / 1000L);
          com.tencent.mm.plugin.downloader.f.a.a(4, localb);
          if (!paramBoolean) {
            break label170;
          }
          com.tencent.mm.plugin.downloader.f.a.a(15, localb);
        }
        for (;;)
        {
          if (parama != null) {
            parama.gk(paramAnonymousBoolean);
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
  
  public static void a(Context paramContext, final String paramString, final am paramam)
  {
    AppMethodBeat.i(89135);
    paramam = new am()
    {
      public final void v(boolean paramAnonymousBoolean1, boolean paramAnonymousBoolean2)
      {
        AppMethodBeat.i(209635);
        if (this.oKc != null) {
          this.oKc.v(paramAnonymousBoolean1, paramAnonymousBoolean2);
        }
        AppMethodBeat.o(209635);
      }
    };
    if (bs.isNullOrNil(paramString))
    {
      ac.e("MicroMsg.DownloadAppUtil", "null or nil appid");
      paramam.v(false, false);
    }
    paramString = com.tencent.mm.pluginsdk.model.app.h.k(paramString, true, false);
    if ((paramString == null) || (bs.isNullOrNil(paramString.field_appId)))
    {
      ac.e("MicroMsg.DownloadAppUtil", "appinfo is null or appid is null");
      paramam.v(false, false);
      AppMethodBeat.o(89135);
      return;
    }
    final WXMediaMessage localWXMediaMessage = new WXMediaMessage(new WXAppExtendObject());
    localWXMediaMessage.sdkVer = 637927424;
    localWXMediaMessage.messageAction = null;
    localWXMediaMessage.messageExt = "WX_GameCenter";
    ac.d("MicroMsg.DownloadAppUtil", "launch game app from wx: appid: [%s], appname:[%s], openid:[%s]", new Object[] { paramString.field_appId, paramString.field_appName, paramString.field_openId });
    if (bs.isNullOrNil(paramString.field_openId))
    {
      ac.i("MicroMsg.DownloadAppUtil", "open id is null or nil, try to get from server:[%s]", new Object[] { paramString.field_appName });
      com.tencent.mm.plugin.s.a.dnA().Bk(paramString.field_appId);
    }
    com.tencent.mm.ci.a.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(89132);
        com.tencent.mm.pluginsdk.model.app.h.a(this.val$context, paramString.field_packageName, localWXMediaMessage, paramString.field_appId, paramString.field_openId, 0, paramam, null);
        AppMethodBeat.o(89132);
      }
    });
    AppMethodBeat.o(89135);
  }
  
  public static void a(String paramString, com.tencent.mm.pluginsdk.permission.a parama)
  {
    AppMethodBeat.i(89134);
    if (bs.isNullOrNil(paramString))
    {
      ac.e("MicroMsg.DownloadAppUtil", "installApk, path is null");
      if (parama != null) {
        parama.gk(false);
      }
      AppMethodBeat.o(89134);
      return;
    }
    ac.i("MicroMsg.DownloadAppUtil", "installApk, path = ".concat(String.valueOf(paramString)));
    if (!i.eA(paramString))
    {
      ac.e("MicroMsg.DownloadAppUtil", "installApk, path not exists");
      if (parama != null) {
        parama.gk(false);
      }
      AppMethodBeat.o(89134);
      return;
    }
    r.b(ai.getContext(), paramString, parama, true);
    AppMethodBeat.o(89134);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader.i.a
 * JD-Core Version:    0.7.0.1
 */