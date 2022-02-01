package com.tencent.mm.plugin.downloader.i;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.opensdk.modelmsg.WXAppExtendObject;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.downloader.model.d;
import com.tencent.mm.plugin.downloader.model.e;
import com.tencent.mm.plugin.downloader.model.f;
import com.tencent.mm.pluginsdk.model.app.al;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.pluginsdk.model.app.n;
import com.tencent.mm.pluginsdk.model.app.r;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.s;

public final class a
{
  public static void a(long paramLong, boolean paramBoolean, com.tencent.mm.pluginsdk.permission.a parama)
  {
    AppMethodBeat.i(89133);
    com.tencent.mm.plugin.downloader.g.a locala = d.Cw(paramLong);
    if ((locala == null) || (locala.field_status != 3) || (!s.YS(locala.field_filePath)))
    {
      if (parama != null) {
        parama.hk(false);
      }
      AppMethodBeat.o(89133);
      return;
    }
    if (!e.g(locala))
    {
      Log.i("MicroMsg.DownloadAppUtil", "install, md5 check fail");
      s.deleteFile(locala.field_filePath);
      d.Cx(paramLong);
      com.tencent.mm.plugin.report.service.h.CyF.dN(860, 35);
      AppMethodBeat.o(89133);
      return;
    }
    if (Util.isNullOrNil(locala.field_packageName))
    {
      String str = f.ali(locala.field_filePath);
      if (!Util.isNullOrNil(str))
      {
        locala.field_packageName = str;
        Log.i("MicroMsg.DownloadAppUtil", "get package name from file : %s, %s", new Object[] { locala.field_filePath, str });
        d.e(locala);
      }
    }
    a(locala.field_filePath, new a.1(locala, paramBoolean, parama));
    AppMethodBeat.o(89133);
  }
  
  public static void a(String paramString, com.tencent.mm.pluginsdk.permission.a parama)
  {
    AppMethodBeat.i(89134);
    if (Util.isNullOrNil(paramString))
    {
      Log.e("MicroMsg.DownloadAppUtil", "installApk, path is null");
      if (parama != null) {
        parama.hk(false);
      }
      AppMethodBeat.o(89134);
      return;
    }
    Log.i("MicroMsg.DownloadAppUtil", "installApk, path = ".concat(String.valueOf(paramString)));
    if (!s.YS(paramString))
    {
      Log.e("MicroMsg.DownloadAppUtil", "installApk, path not exists");
      if (parama != null) {
        parama.hk(false);
      }
      AppMethodBeat.o(89134);
      return;
    }
    r.b(MMApplicationContext.getContext(), paramString, parama, true);
    AppMethodBeat.o(89134);
  }
  
  public static void as(Context paramContext, String paramString)
  {
    AppMethodBeat.i(192276);
    al local2 = new al()
    {
      public final void v(boolean paramAnonymousBoolean1, boolean paramAnonymousBoolean2)
      {
        AppMethodBeat.i(192275);
        if (this.qJV != null) {
          this.qJV.v(paramAnonymousBoolean1, paramAnonymousBoolean2);
        }
        AppMethodBeat.o(192275);
      }
    };
    if (Util.isNullOrNil(paramString))
    {
      Log.e("MicroMsg.DownloadAppUtil", "null or nil appid");
      local2.v(false, false);
    }
    paramString = com.tencent.mm.pluginsdk.model.app.h.o(paramString, true, false);
    if ((paramString == null) || (Util.isNullOrNil(paramString.field_appId)))
    {
      Log.e("MicroMsg.DownloadAppUtil", "appinfo is null or appid is null");
      local2.v(false, false);
      AppMethodBeat.o(192276);
      return;
    }
    WXMediaMessage localWXMediaMessage = new WXMediaMessage(new WXAppExtendObject());
    localWXMediaMessage.sdkVer = 637928960;
    localWXMediaMessage.messageAction = null;
    localWXMediaMessage.messageExt = "WX_GameCenter";
    Log.d("MicroMsg.DownloadAppUtil", "launch game app from wx: appid: [%s], appname:[%s], openid:[%s]", new Object[] { paramString.field_appId, paramString.field_appName, paramString.field_openId });
    if (Util.isNullOrNil(paramString.field_openId))
    {
      Log.i("MicroMsg.DownloadAppUtil", "open id is null or nil, try to get from server:[%s]", new Object[] { paramString.field_appName });
      com.tencent.mm.plugin.r.a.eAU().add(paramString.field_appId);
    }
    com.tencent.mm.ch.a.post(new a.3(paramContext, paramString, localWXMediaMessage, local2));
    AppMethodBeat.o(192276);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader.i.a
 * JD-Core Version:    0.7.0.1
 */