package com.tencent.mm.plugin.downloader.i;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.opensdk.modelmsg.WXAppExtendObject;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.downloader.model.d;
import com.tencent.mm.pluginsdk.model.app.ai;
import com.tencent.mm.pluginsdk.model.app.f;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.pluginsdk.model.app.m;
import com.tencent.mm.pluginsdk.model.app.q;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.vfs.e;
import java.io.File;

public final class a
{
  public static void a(long paramLong, boolean paramBoolean, com.tencent.mm.pluginsdk.permission.a parama)
  {
    AppMethodBeat.i(2525);
    com.tencent.mm.plugin.downloader.g.a locala = d.iJ(paramLong);
    if ((locala == null) || (locala.field_status != 3) || (!e.cN(locala.field_filePath)))
    {
      if (parama != null) {
        parama.eb(false);
      }
      AppMethodBeat.o(2525);
      return;
    }
    a(locala.field_filePath, new a.1(locala, paramBoolean, parama));
    AppMethodBeat.o(2525);
  }
  
  public static void a(Context paramContext, final String paramString, final ai paramai)
  {
    AppMethodBeat.i(2527);
    paramai = new a.2(paramai);
    if (bo.isNullOrNil(paramString))
    {
      ab.e("MicroMsg.DownloadAppUtil", "null or nil appid");
      paramai.dZ(false);
    }
    paramString = g.ca(paramString, true);
    if ((paramString == null) || (bo.isNullOrNil(paramString.field_appId)))
    {
      ab.e("MicroMsg.DownloadAppUtil", "appinfo is null or appid is null");
      paramai.dZ(false);
      AppMethodBeat.o(2527);
      return;
    }
    final WXMediaMessage localWXMediaMessage = new WXMediaMessage(new WXAppExtendObject());
    localWXMediaMessage.sdkVer = 620954624;
    localWXMediaMessage.messageAction = null;
    localWXMediaMessage.messageExt = "WX_GameCenter";
    ab.d("MicroMsg.DownloadAppUtil", "launch game app from wx: appid: [%s], appname:[%s], openid:[%s]", new Object[] { paramString.field_appId, paramString.field_appName, paramString.field_openId });
    if (bo.isNullOrNil(paramString.field_openId))
    {
      ab.i("MicroMsg.DownloadAppUtil", "open id is null or nil, try to get from server:[%s]", new Object[] { paramString.field_appName });
      com.tencent.mm.plugin.s.a.cae().xB(paramString.field_appId);
    }
    com.tencent.mm.ch.a.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(2524);
        g.a(this.val$context, paramString.field_packageName, localWXMediaMessage, paramString.field_appId, paramString.field_openId, 0, paramai, null);
        AppMethodBeat.o(2524);
      }
    });
    AppMethodBeat.o(2527);
  }
  
  public static void a(String paramString, com.tencent.mm.pluginsdk.permission.a parama)
  {
    AppMethodBeat.i(2526);
    if (bo.isNullOrNil(paramString))
    {
      ab.e("MicroMsg.DownloadAppUtil", "installApk, path is null");
      if (parama != null) {
        parama.eb(false);
      }
      AppMethodBeat.o(2526);
      return;
    }
    ab.i("MicroMsg.DownloadAppUtil", "installApk, path = ".concat(String.valueOf(paramString)));
    if (!e.cN(paramString))
    {
      ab.e("MicroMsg.DownloadAppUtil", "installApk, path not exists");
      if (parama != null) {
        parama.eb(false);
      }
      AppMethodBeat.o(2526);
      return;
    }
    paramString = new File(paramString);
    q.a(ah.getContext(), paramString, parama, true);
    AppMethodBeat.o(2526);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader.i.a
 * JD-Core Version:    0.7.0.1
 */