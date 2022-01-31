package com.tencent.mm.plugin.downloader_app.b;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.plugin.downloader.model.e.a;
import com.tencent.mm.plugin.downloader_app.b.h;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.vfs.e;
import java.util.LinkedList;

public final class c
{
  public static void a(Context paramContext, com.tencent.mm.plugin.downloader.f.a parama, c.b paramb)
  {
    if (!aq.isConnected(paramContext))
    {
      h.a(paramContext, paramContext.getString(b.h.network_disconnected_tips), paramContext.getString(b.h.network_disconnected_title), paramContext.getString(b.h.knowed), false, new c.9(parama, paramb));
      return;
    }
    d.zZ(parama.field_appId);
    if (aq.isWifi(paramContext))
    {
      a(parama, true, paramb);
      return;
    }
    if (parama.field_downloadInWifi)
    {
      h.a(paramContext, paramContext.getString(b.h.has_reserve_wifi_tips), "", paramContext.getString(b.h.wait_for_wifi), paramContext.getString(b.h.download_straight), false, new c.10(paramb, parama), new c.11(parama, paramb));
      return;
    }
    int i = (int)(parama.field_totalSize - parama.field_downloadedSize) / 1048576;
    if (i <= 0) {}
    for (String str = paramContext.getString(b.h.download_wifi_no_size_tips);; str = paramContext.getString(b.h.download_wifi_tips, new Object[] { Integer.valueOf(i) }))
    {
      h.a(paramContext, str, paramContext.getString(b.h.reserve_wifi_download), paramContext.getString(b.h.reserve_wifi_download), paramContext.getString(b.h.download_straight), false, new c.12(parama, paramb), new c.13(parama, paramb));
      return;
    }
  }
  
  public static void a(Context paramContext, a parama, c.b paramb)
  {
    if (paramContext == null) {
      return;
    }
    if (!aq.isConnected(paramContext))
    {
      h.a(paramContext, paramContext.getString(b.h.network_disconnected_tips), paramContext.getString(b.h.network_disconnected_title), paramContext.getString(b.h.knowed), false, new c.1(parama, paramb));
      return;
    }
    d.zZ(parama.appId);
    if (aq.isWifi(paramContext))
    {
      a(parama, true, paramb);
      return;
    }
    int i = (int)parama.iRS / 1048576;
    h.a(paramContext, paramContext.getString(b.h.download_wifi_tips, new Object[] { Integer.valueOf(i) }), paramContext.getString(b.h.reserve_wifi_download), paramContext.getString(b.h.reserve_wifi_download), paramContext.getString(b.h.download_straight), false, new c.6(parama, paramb), new c.7(parama, paramb));
  }
  
  public static void a(Context paramContext, j paramj)
  {
    if ((paramContext == null) || (paramj == null)) {
      return;
    }
    a locala = new a();
    locala.downloadUrl = paramj.iSt.dlQ;
    locala.iRR = paramj.iSt.iQl;
    locala.appId = paramj.appId;
    locala.appName = paramj.appName;
    locala.iRS = paramj.iSt.iQf;
    locala.iRT = paramj.iSt.iQg;
    locala.packageName = paramj.iSt.iQe;
    locala.bOz = paramj.iSt.iQh;
    a(paramContext, locala, null);
  }
  
  static void a(com.tencent.mm.plugin.downloader.f.a parama, boolean paramBoolean, c.b paramb)
  {
    if ((paramBoolean) && (!aq.isWifi(ae.getContext()))) {
      d.Aa(parama.field_appId);
    }
    if ((parama.field_downloadInWifi != paramBoolean) || (parama.field_showNotification) || (!parama.field_fromDownloadApp))
    {
      parama.field_downloadInWifi = paramBoolean;
      parama.field_showNotification = false;
      parama.field_fromDownloadApp = true;
      com.tencent.mm.plugin.downloader.model.c.d(parama);
    }
    boolean bool = com.tencent.mm.plugin.downloader.model.d.aFP().df(parama.field_downloadId);
    c.a locala;
    if (paramb != null)
    {
      if ((!paramBoolean) || (aq.isWifi(ae.getContext()))) {
        break label108;
      }
      locala = c.a.iSb;
    }
    for (;;)
    {
      paramb.a(locala, parama.field_downloadId);
      return;
      label108:
      if (bool) {
        locala = c.a.iRZ;
      } else {
        locala = c.a.iSa;
      }
    }
  }
  
  static void a(a parama, boolean paramBoolean, c.b paramb)
  {
    if (!k.contains(parama.appId))
    {
      localObject = k.aGr();
      ((LinkedList)localObject).add(parama.appId);
      g.a((LinkedList)localObject, new c.8(parama));
    }
    if ((paramBoolean) && (!aq.isWifi(ae.getContext()))) {
      d.Aa(parama.appId);
    }
    Object localObject = new e.a();
    ((e.a)localObject).zN(parama.downloadUrl);
    ((e.a)localObject).zO(parama.iRR);
    ((e.a)localObject).dp(parama.iRS);
    ((e.a)localObject).zP(parama.appName);
    ((e.a)localObject).setAppId(parama.appId);
    ((e.a)localObject).zQ(parama.iRT);
    ((e.a)localObject).eO(false);
    ((e.a)localObject).eP(false);
    ((e.a)localObject).pE(1);
    ((e.a)localObject).cq(parama.packageName);
    ((e.a)localObject).iPG.iPF = true;
    ((e.a)localObject).setScene(6001);
    long l;
    if (paramBoolean)
    {
      ((e.a)localObject).eQ(true);
      if (parama.bOz != 1) {
        break label271;
      }
      l = com.tencent.mm.plugin.downloader.model.d.aFP().b(((e.a)localObject).iPG);
      label195:
      y.i("MicroMsg.DownloadPluginUtil", " add download task result:[%d], appid[%s]，downloaerType[%d]", new Object[] { Long.valueOf(l), parama.appId, Integer.valueOf(parama.bOz) });
      if (paramb != null)
      {
        if ((!paramBoolean) || (aq.isWifi(ae.getContext()))) {
          break label286;
        }
        parama = c.a.iSb;
      }
    }
    for (;;)
    {
      paramb.a(parama, l);
      return;
      ((e.a)localObject).eQ(false);
      break;
      label271:
      l = com.tencent.mm.plugin.downloader.model.d.aFP().a(((e.a)localObject).iPG);
      break label195;
      label286:
      if (l > 0L) {
        parama = c.a.iRZ;
      } else {
        parama = c.a.iSa;
      }
    }
  }
  
  public static void b(Context paramContext, j paramj)
  {
    com.tencent.mm.plugin.downloader.f.a locala = com.tencent.mm.plugin.downloader.model.c.zH(paramj.appId);
    if (locala == null) {
      return;
    }
    if (e.bK(locala.field_filePath))
    {
      com.tencent.mm.plugin.downloader.h.a.m(locala.field_downloadId, false);
      return;
    }
    h.a(paramContext, paramContext.getString(b.h.package_deleted_dialog_tips), paramContext.getString(b.h.package_deleted_dialog_title), paramContext.getString(b.h.restart_download_app), paramContext.getString(b.h.task_cancel), false, new c.2(paramContext, paramj), new c.3());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader_app.b.c
 * JD-Core Version:    0.7.0.1
 */