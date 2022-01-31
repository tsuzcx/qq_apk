package com.tencent.mm.plugin.downloader.h;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import com.tencent.mm.game.report.api.b;
import com.tencent.mm.opensdk.modelmsg.WXAppExtendObject;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.downloader.model.c;
import com.tencent.mm.pluginsdk.model.app.am;
import com.tencent.mm.pluginsdk.model.app.f;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.pluginsdk.model.app.m;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.vfs.e;
import java.io.File;

public final class a
{
  public static void a(Context paramContext, String paramString, am paramam)
  {
    paramam = new a.1(paramam);
    if (bk.bl(paramString))
    {
      y.e("MicroMsg.DownloadAppUtil", "null or nil appid");
      paramam.cW(false);
    }
    paramString = g.by(paramString, true);
    if ((paramString == null) || (bk.bl(paramString.field_appId)))
    {
      y.e("MicroMsg.DownloadAppUtil", "appinfo is null or appid is null");
      paramam.cW(false);
      return;
    }
    WXMediaMessage localWXMediaMessage = new WXMediaMessage(new WXAppExtendObject());
    localWXMediaMessage.sdkVer = 620824064;
    localWXMediaMessage.messageAction = null;
    localWXMediaMessage.messageExt = "WX_GameCenter";
    y.d("MicroMsg.DownloadAppUtil", "launch game app from wx: appid: [%s], appname:[%s], openid:[%s]", new Object[] { paramString.field_appId, paramString.field_appName, paramString.field_openId });
    if (bk.bl(paramString.field_openId))
    {
      y.i("MicroMsg.DownloadAppUtil", "open id is null or nil, try to get from server:[%s]", new Object[] { paramString.field_appName });
      com.tencent.mm.plugin.z.a.brp().qh(paramString.field_appId);
    }
    com.tencent.mm.cg.a.post(new a.2(paramContext, paramString, localWXMediaMessage, paramam));
  }
  
  public static boolean m(long paramLong, boolean paramBoolean)
  {
    com.tencent.mm.plugin.downloader.f.a locala = c.dk(paramLong);
    if ((locala == null) || (locala.field_status != 3) || (!e.bK(locala.field_filePath))) {
      return false;
    }
    Boolean localBoolean = Boolean.valueOf(zT(locala.field_filePath));
    if (localBoolean.booleanValue())
    {
      b.dCw.a(locala.field_appId, locala.field_scene, 4, locala.field_md5, locala.field_downloadUrl, null, locala.field_extInfo);
      b.dCw.a(locala.field_appId, locala.field_scene, 4, locala.field_startSize, locala.field_downloadedSize - locala.field_startSize, locala.field_totalSize, locala.field_downloadUrl, locala.field_errCode, locala.field_downloaderType, locala.field_channelId, (System.currentTimeMillis() - locala.field_startTime) / 1000L, locala.field_startState, locala.field_downloadId, locala.field_extInfo);
      if (!paramBoolean) {
        break label232;
      }
      b.dCw.a(locala.field_appId, locala.field_scene, 15, locala.field_startSize, locala.field_downloadedSize - locala.field_startSize, locala.field_totalSize, locala.field_downloadUrl, locala.field_errCode, locala.field_downloaderType, locala.field_channelId, (System.currentTimeMillis() - locala.field_startTime) / 1000L, locala.field_startState, locala.field_downloadId, locala.field_extInfo);
    }
    for (;;)
    {
      return localBoolean.booleanValue();
      label232:
      b.dCw.a(locala.field_appId, locala.field_scene, 16, locala.field_startSize, locala.field_downloadedSize - locala.field_startSize, locala.field_totalSize, locala.field_downloadUrl, locala.field_errCode, locala.field_downloaderType, locala.field_channelId, (System.currentTimeMillis() - locala.field_startTime) / 1000L, locala.field_startState, locala.field_downloadId, locala.field_extInfo);
    }
  }
  
  public static boolean zT(String paramString)
  {
    if (bk.bl(paramString))
    {
      y.e("MicroMsg.DownloadAppUtil", "installApk, path is null");
      return false;
    }
    y.i("MicroMsg.DownloadAppUtil", "installApk, path = " + paramString);
    if (!e.bK(paramString))
    {
      y.e("MicroMsg.DownloadAppUtil", "installApk, path not exists");
      return false;
    }
    paramString = Uri.fromFile(new File(paramString));
    Intent localIntent = new Intent("android.intent.action.VIEW");
    if (Build.BRAND.equals("vivo"))
    {
      localIntent.putExtra("installDir", true);
      y.i("MicroMsg.DownloadAppUtil", "is vivo, try to prevent the interception");
    }
    localIntent.setDataAndType(paramString, "application/vnd.android.package-archive");
    localIntent.addFlags(268435456);
    try
    {
      ae.getContext().startActivity(localIntent);
      return true;
    }
    catch (Exception localException)
    {
      y.e("MicroMsg.DownloadAppUtil", "install app failed: " + paramString.toString() + ", ex = " + localException.getMessage());
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader.h.a
 * JD-Core Version:    0.7.0.1
 */