package com.tencent.mm.plugin.downloader.model;

import android.content.SharedPreferences;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.ak.t;
import com.tencent.mm.d.c;
import com.tencent.mm.kernel.b;
import com.tencent.mm.modelsimple.af;
import com.tencent.mm.plugin.downloader.g.a;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.MultiProcessSharedPreferences;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.s;
import java.io.File;

final class f$1
  implements Runnable
{
  f$1(f paramf, a parama, int paramInt, boolean paramBoolean) {}
  
  public final void run()
  {
    AppMethodBeat.i(88972);
    Object localObject = com.tencent.mm.kernel.g.aAg().hqi;
    if (localObject == null)
    {
      AppMethodBeat.o(88972);
      return;
    }
    localObject = ((t)localObject).iMw;
    if (localObject == null)
    {
      AppMethodBeat.o(88972);
      return;
    }
    new af(this.qIi.field_packageName, this.qIB).doScene((com.tencent.mm.network.g)localObject, new i()
    {
      public final void onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, q paramAnonymousq)
      {
        AppMethodBeat.i(88971);
        paramAnonymousq.setHasCallbackToQueue(true);
        if ((paramAnonymousInt1 != 0) || (paramAnonymousInt2 != 0))
        {
          Log.w("MicroMsg.FileDownloadManager", "summertoken onMD5CheckSucceeded get pkg sig error");
          com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(322L, 28L, 1L, false);
          com.tencent.mm.plugin.report.service.h.CyF.a(11098, new Object[] { Integer.valueOf(4028), String.format("%s,%s,%d,%d", new Object[] { f.1.this.qIi.field_packageName, f.1.this.qIi.field_filePath, Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2) }) });
          if ((!Util.isNullOrNil(f.1.this.qIi.field_appId)) && (com.tencent.mm.pluginsdk.model.app.h.gq(f.1.this.qIi.field_appId)))
          {
            Log.i("MicroMsg.FileDownloadManager", "onSceneEnd, fail, appId: %s", new Object[] { f.1.this.qIi.field_appId });
            com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(710L, 24L, 1L, false);
          }
        }
        for (;;)
        {
          MMHandlerThread.postToMainThread(new f.2(f.1.this.qIC, f.1.this.qIi, f.1.this.qIn));
          AppMethodBeat.o(88971);
          return;
          paramAnonymousString = MultiProcessSharedPreferences.getSharedPreferences(MMApplicationContext.getContext(), "yyb_pkg_sig_prefs", com.tencent.mm.compatible.util.g.aps()).getString(f.1.this.qIi.field_packageName, "");
          Log.i("MicroMsg.FileDownloadManager", "summertoken onMD5CheckSucceeded sig[%s]", new Object[] { paramAnonymousString });
          if ((!Util.isNullOrNil(paramAnonymousString)) && (!BuildInfo.IS_FLAVOR_RED) && (!BuildInfo.IS_FLAVOR_PURPLE))
          {
            try
            {
              c.g(new File(s.k(f.1.this.qIi.field_filePath, true)), paramAnonymousString);
              Log.i("MicroMsg.FileDownloadManager", "summertoken onMD5CheckSucceeded writeSecurityCode done");
              com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(322L, 25L, 1L, false);
              com.tencent.mm.plugin.report.service.h.CyF.a(11098, new Object[] { Integer.valueOf(4025), String.format("%s,%s,%s", new Object[] { f.1.this.qIi.field_packageName, f.1.this.qIi.field_filePath, paramAnonymousString }) });
            }
            catch (Exception paramAnonymousString)
            {
              Log.w("MicroMsg.FileDownloadManager", "summertoken onMD5CheckSucceeded writeSecurityCode e: " + paramAnonymousString.getMessage());
              com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(322L, 27L, 1L, false);
              com.tencent.mm.plugin.report.service.h.CyF.a(11098, new Object[] { Integer.valueOf(4027), String.format("%s,%s,%s", new Object[] { f.1.this.qIi.field_packageName, f.1.this.qIi.field_filePath, paramAnonymousString.getMessage() }) });
            }
          }
          else
          {
            com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(322L, 26L, 1L, false);
            com.tencent.mm.plugin.report.service.h.CyF.a(11098, new Object[] { Integer.valueOf(4026), String.format("%s,%s", new Object[] { f.1.this.qIi.field_packageName, f.1.this.qIi.field_filePath }) });
          }
        }
      }
    });
    AppMethodBeat.o(88972);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader.model.f.1
 * JD-Core Version:    0.7.0.1
 */