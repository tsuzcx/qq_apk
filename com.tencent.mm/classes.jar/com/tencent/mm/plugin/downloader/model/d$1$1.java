package com.tencent.mm.plugin.downloader.model;

import android.content.SharedPreferences;
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.c.c;
import com.tencent.mm.plugin.downloader.f.a;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.MultiProcessSharedPreferences;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.io.File;

final class d$1$1
  implements f
{
  d$1$1(d.1 param1) {}
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    paramm.edh = true;
    if ((paramInt1 != 0) || (paramInt2 != 0))
    {
      y.w("MicroMsg.FileDownloadManager", "summertoken onMD5CheckSucceeded get pkg sig error");
      h.nFQ.a(322L, 28L, 1L, false);
      h.nFQ.f(11098, new Object[] { Integer.valueOf(4028), String.format("%s,%s,%d,%d", new Object[] { this.iPs.iOZ.field_packageName, this.iPs.iOZ.field_filePath, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }) });
    }
    for (;;)
    {
      ai.d(new d.1.1.1(this));
      return;
      paramString = MultiProcessSharedPreferences.getSharedPreferences(ae.getContext(), "yyb_pkg_sig_prefs", 4).getString(this.iPs.iOZ.field_packageName, "");
      y.i("MicroMsg.FileDownloadManager", "summertoken onMD5CheckSucceeded sig[%s]", new Object[] { paramString });
      if (!bk.bl(paramString))
      {
        try
        {
          c.c(new File(this.iPs.iOZ.field_filePath), paramString);
          y.i("MicroMsg.FileDownloadManager", "summertoken onMD5CheckSucceeded writeSecurityCode done");
          h.nFQ.a(322L, 25L, 1L, false);
          h.nFQ.f(11098, new Object[] { Integer.valueOf(4025), String.format("%s,%s,%s", new Object[] { this.iPs.iOZ.field_packageName, this.iPs.iOZ.field_filePath, paramString }) });
        }
        catch (Exception paramString)
        {
          y.w("MicroMsg.FileDownloadManager", "summertoken onMD5CheckSucceeded writeSecurityCode e: " + paramString.getMessage());
          h.nFQ.a(322L, 27L, 1L, false);
          h.nFQ.f(11098, new Object[] { Integer.valueOf(4027), String.format("%s,%s,%s", new Object[] { this.iPs.iOZ.field_packageName, this.iPs.iOZ.field_filePath, paramString.getMessage() }) });
        }
      }
      else
      {
        h.nFQ.a(322L, 26L, 1L, false);
        h.nFQ.f(11098, new Object[] { Integer.valueOf(4026), String.format("%s,%s", new Object[] { this.iPs.iOZ.field_packageName, this.iPs.iOZ.field_filePath }) });
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader.model.d.1.1
 * JD-Core Version:    0.7.0.1
 */