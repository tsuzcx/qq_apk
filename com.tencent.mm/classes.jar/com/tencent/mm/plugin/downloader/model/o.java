package com.tencent.mm.plugin.downloader.model;

import android.content.Context;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.downloader_app.a.c;
import com.tencent.mm.pointers.PBool;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.at;
import org.json.JSONObject;

public final class o
{
  private static void a(Context paramContext, long paramLong, o.a parama)
  {
    AppMethodBeat.i(141088);
    com.tencent.mm.plugin.downloader.g.a locala = d.iJ(paramLong);
    if (locala == null)
    {
      parama.c("fail", null);
      AppMethodBeat.o(141088);
      return;
    }
    PBool localPBool = new PBool();
    JSONObject localJSONObject = new JSONObject();
    ((c)g.E(c.class)).b(paramContext, locala.field_appId, new o.8(localPBool, locala, parama), new o.9(localPBool, localJSONObject, locala, parama), new o.10(localPBool, parama));
    AppMethodBeat.o(141088);
  }
  
  public static void a(Context paramContext, long paramLong, boolean paramBoolean, o.a parama)
  {
    AppMethodBeat.i(141086);
    if (paramLong <= 0L)
    {
      ab.e("MicroMsg.JsApiGameDownloadManager", "fail, invalid downloadId = ".concat(String.valueOf(paramLong)));
      parama.c("invalid_downloadid", null);
      AppMethodBeat.o(141086);
      return;
    }
    com.tencent.mm.plugin.downloader.g.a locala = d.iJ(paramLong);
    if (locala == null)
    {
      parama.c("fail", null);
      AppMethodBeat.o(141086);
      return;
    }
    Object localObject = f.bjl().iA(locala.field_downloadId);
    if (localObject != null)
    {
      if (((FileDownloadTaskInfo)localObject).status == 1)
      {
        parama.c(null, null);
        AppMethodBeat.o(141086);
        return;
      }
      if (((FileDownloadTaskInfo)localObject).status == 3)
      {
        com.tencent.mm.plugin.downloader.i.a.a(((FileDownloadTaskInfo)localObject).id, false, null);
        parama.c(null, null);
        AppMethodBeat.o(141086);
        return;
      }
    }
    if (at.isWifi(paramContext))
    {
      a(locala, false, parama);
      AppMethodBeat.o(141086);
      return;
    }
    if (paramBoolean)
    {
      if (locala.field_reserveInWifi)
      {
        a(paramContext, locala.field_downloadId, parama);
        AppMethodBeat.o(141086);
        return;
      }
      localObject = new PBool();
      ((c)g.E(c.class)).a(paramContext, locala.field_appId, new o.2((PBool)localObject, locala, parama), new o.3((PBool)localObject, locala, parama), new o.4((PBool)localObject, parama));
      AppMethodBeat.o(141086);
      return;
    }
    if (locala.field_reserveInWifi)
    {
      locala.field_downloadInWifi = false;
      locala.field_reserveInWifi = false;
      d.e(locala);
    }
    com.tencent.mm.ui.base.h.a(paramContext, paramContext.getString(2131305852), paramContext.getString(2131305853), paramContext.getString(2131305847), paramContext.getString(2131296888), false, new o.5(locala, parama), new o.6(parama), 2131690701);
    AppMethodBeat.o(141086);
  }
  
  public static void a(Context paramContext, com.tencent.mm.plugin.downloader_app.b.a parama, o.a parama1)
  {
    AppMethodBeat.i(141084);
    if ((parama == null) || (!parama.isValid()))
    {
      parama1.c("fail", null);
      AppMethodBeat.o(141084);
      return;
    }
    if (!at.isNetworkConnected(paramContext))
    {
      parama1.c("network_not_connected", null);
      al.d(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(141066);
          Toast.makeText(this.val$context, this.val$context.getString(2131300360), 0).show();
          AppMethodBeat.o(141066);
        }
      });
      ab.i("MicroMsg.JsApiGameDownloadManager", " fail, network not ready");
      AppMethodBeat.o(141084);
      return;
    }
    if (!com.tencent.mm.compatible.util.f.Mi())
    {
      parama1.c("sdcard_not_ready", null);
      al.d(new o.11(paramContext));
      ab.i("MicroMsg.JsApiGameDownloadManager", " fail, sdcard not ready");
      AppMethodBeat.o(141084);
      return;
    }
    if ((parama.laC > 0L) && (!com.tencent.mm.compatible.util.f.gc(parama.laC)) && (!h.iS(parama.laC)))
    {
      parama1.c("has_not_enough_space", null);
      al.d(new o.12(paramContext));
      ab.i("MicroMsg.JsApiGameDownloadManager", "fail, not enough space, require size = " + parama.laC);
      AppMethodBeat.o(141084);
      return;
    }
    Object localObject = d.JG(parama.downloadUrl);
    if (localObject != null)
    {
      FileDownloadTaskInfo localFileDownloadTaskInfo = f.bjl().iA(((com.tencent.mm.plugin.downloader.g.a)localObject).field_downloadId);
      if (localFileDownloadTaskInfo != null)
      {
        if (localFileDownloadTaskInfo.status == 1)
        {
          parama1.c(null, null);
          AppMethodBeat.o(141084);
          return;
        }
        if (localFileDownloadTaskInfo.status == 3)
        {
          com.tencent.mm.plugin.downloader.i.a.a(localFileDownloadTaskInfo.id, false, null);
          parama1.c(null, null);
          AppMethodBeat.o(141084);
          return;
        }
        if ((parama.kYZ) && (((com.tencent.mm.plugin.downloader.g.a)localObject).field_reserveInWifi) && (!at.isWifi(paramContext)))
        {
          a(paramContext, ((com.tencent.mm.plugin.downloader.g.a)localObject).field_downloadId, parama1);
          AppMethodBeat.o(141084);
          return;
        }
      }
    }
    if (at.isWifi(paramContext))
    {
      a(parama, parama1, false);
      AppMethodBeat.o(141084);
      return;
    }
    if (parama.kYZ)
    {
      localObject = new PBool();
      ((c)g.E(c.class)).a(paramContext, parama.appId, new o.13((PBool)localObject, parama, parama1), new o.14((PBool)localObject, parama, parama1), new o.15((PBool)localObject, parama1));
      AppMethodBeat.o(141084);
      return;
    }
    com.tencent.mm.ui.base.h.a(paramContext, paramContext.getString(2131305852), paramContext.getString(2131305853), paramContext.getString(2131305847), paramContext.getString(2131296888), false, new o.16(parama, parama1), new o.17(parama1), 2131690701);
    AppMethodBeat.o(141084);
  }
  
  static void a(com.tencent.mm.plugin.downloader.g.a parama, boolean paramBoolean, o.a parama1)
  {
    AppMethodBeat.i(141087);
    com.tencent.mm.modelstat.d.b(10, "LuggageGameWebViewUI_resumeGameDownloadTask", "JsApiGameDownloadManager".hashCode());
    ((com.tencent.mm.plugin.downloader_app.a.d)g.E(com.tencent.mm.plugin.downloader_app.a.d.class)).a(parama.field_downloadId, paramBoolean, new o.7(paramBoolean, parama1));
    AppMethodBeat.o(141087);
  }
  
  static void a(com.tencent.mm.plugin.downloader_app.b.a parama, o.a parama1, boolean paramBoolean)
  {
    AppMethodBeat.i(141085);
    parama.kYZ = paramBoolean;
    ((com.tencent.mm.plugin.downloader_app.a.d)g.E(com.tencent.mm.plugin.downloader_app.a.d.class)).a(parama, new o.18(parama1));
    AppMethodBeat.o(141085);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader.model.o
 * JD-Core Version:    0.7.0.1
 */