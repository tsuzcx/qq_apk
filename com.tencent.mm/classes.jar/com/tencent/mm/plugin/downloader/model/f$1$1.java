package com.tencent.mm.plugin.downloader.model;

import android.content.SharedPreferences;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.c.c;
import com.tencent.mm.plugin.downloader.g.a;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.sdk.platformtools.MultiProcessSharedPreferences;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import java.io.File;

final class f$1$1
  implements f
{
  f$1$1(f.1 param1) {}
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    AppMethodBeat.i(2406);
    paramm.setHasCallbackToQueue(true);
    if ((paramInt1 != 0) || (paramInt2 != 0))
    {
      ab.w("MicroMsg.FileDownloadManager", "summertoken onMD5CheckSucceeded get pkg sig error");
      com.tencent.mm.plugin.report.service.h.qsU.idkeyStat(322L, 28L, 1L, false);
      com.tencent.mm.plugin.report.service.h.qsU.e(11098, new Object[] { Integer.valueOf(4028), String.format("%s,%s,%d,%d", new Object[] { this.kYB.kYh.field_packageName, this.kYB.kYh.field_filePath, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }) });
      if ((!bo.isNullOrNil(this.kYB.kYh.field_appId)) && (g.dG(this.kYB.kYh.field_appId)))
      {
        ab.i("MicroMsg.FileDownloadManager", "onSceneEnd, fail, appId: %s", new Object[] { this.kYB.kYh.field_appId });
        com.tencent.mm.plugin.report.service.h.qsU.idkeyStat(710L, 24L, 1L, false);
      }
    }
    for (;;)
    {
      al.d(new f.2(this.kYB.kYA, this.kYB.kYh, this.kYB.kYn));
      AppMethodBeat.o(2406);
      return;
      paramString = MultiProcessSharedPreferences.getSharedPreferences(ah.getContext(), "yyb_pkg_sig_prefs", com.tencent.mm.compatible.util.h.Mp()).getString(this.kYB.kYh.field_packageName, "");
      ab.i("MicroMsg.FileDownloadManager", "summertoken onMD5CheckSucceeded sig[%s]", new Object[] { paramString });
      if (!bo.isNullOrNil(paramString))
      {
        try
        {
          c.c(new File(this.kYB.kYh.field_filePath), paramString);
          ab.i("MicroMsg.FileDownloadManager", "summertoken onMD5CheckSucceeded writeSecurityCode done");
          com.tencent.mm.plugin.report.service.h.qsU.idkeyStat(322L, 25L, 1L, false);
          com.tencent.mm.plugin.report.service.h.qsU.e(11098, new Object[] { Integer.valueOf(4025), String.format("%s,%s,%s", new Object[] { this.kYB.kYh.field_packageName, this.kYB.kYh.field_filePath, paramString }) });
        }
        catch (Exception paramString)
        {
          ab.w("MicroMsg.FileDownloadManager", "summertoken onMD5CheckSucceeded writeSecurityCode e: " + paramString.getMessage());
          com.tencent.mm.plugin.report.service.h.qsU.idkeyStat(322L, 27L, 1L, false);
          com.tencent.mm.plugin.report.service.h.qsU.e(11098, new Object[] { Integer.valueOf(4027), String.format("%s,%s,%s", new Object[] { this.kYB.kYh.field_packageName, this.kYB.kYh.field_filePath, paramString.getMessage() }) });
        }
      }
      else
      {
        com.tencent.mm.plugin.report.service.h.qsU.idkeyStat(322L, 26L, 1L, false);
        com.tencent.mm.plugin.report.service.h.qsU.e(11098, new Object[] { Integer.valueOf(4026), String.format("%s,%s", new Object[] { this.kYB.kYh.field_packageName, this.kYB.kYh.field_filePath }) });
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader.model.f.1.1
 * JD-Core Version:    0.7.0.1
 */