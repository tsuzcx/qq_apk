package com.tencent.mm.plugin.hp.a;

import android.content.Context;
import com.tencent.mm.R.l;
import com.tencent.mm.a.e;
import com.tencent.mm.c.a;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.f.i;
import com.tencent.mm.protocal.c.bxs;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.tinker.loader.shareutil.SharePatchFileUtil;
import java.io.File;

public final class a$1
  implements Runnable
{
  public a$1(String paramString1, Context paramContext, String paramString2, com.tencent.mm.plugin.hp.d.b paramb) {}
  
  public final void run()
  {
    int i;
    if (!e.bK(this.lmB))
    {
      long l = System.currentTimeMillis();
      i = b.b(i.eV(this.val$context), this.lmC, this.lmB, this.lmD.lnz);
      SharePatchFileUtil.ah(new File(this.lmC));
      y.i("MicroMsg.Tinker.CTinkerInstaller", "merge apk use :%d second retCode:%d", new Object[] { Long.valueOf((System.currentTimeMillis() - l) / 1000L), Integer.valueOf(i) });
    }
    for (;;)
    {
      String str;
      if (i == 0)
      {
        boolean bool = a.cd(this.lmB);
        if (bool)
        {
          y.i("MicroMsg.Tinker.CTinkerInstaller", "checkApk:%s", new Object[] { Boolean.valueOf(bool) });
          Context localContext = ae.getContext();
          if (bk.bl(this.lmD.bbp()))
          {
            str = localContext.getString(R.l.update_tip_recommended_down);
            label153:
            bxs localbxs = new bxs();
            localbxs.lny = this.lmD.lny;
            localbxs.title = localContext.getString(R.l.fmt_update);
            localbxs.tNL = localContext.getString(R.l.install_now);
            localbxs.lfK = localContext.getString(R.l.update_cancel);
            localbxs.lnz = this.lmD.lnz;
            localbxs.lnA = this.lmD.lnA;
            localbxs.gZD = this.lmD.fileSize;
            localbxs.lnw = this.lmD.lnw;
            localbxs.bvC = this.lmD.lnx;
            localbxs.versionCode = this.lmD.versionCode;
            localbxs.tNK = this.lmB;
            localbxs.bHk = str;
            i.a(localbxs);
            if (this.lmD.lnu.intValue() == 3) {
              h.nFQ.a(614L, 58L, 1L, false);
            }
            y.d("MicroMsg.Tinker.CTinkerInstaller", "boots download success.");
          }
        }
      }
      for (;;)
      {
        switch (i)
        {
        default: 
          return;
          str = this.lmD.bbp();
          break label153;
          y.i("MicroMsg.Tinker.CTinkerInstaller", "md5 is no equal.");
          continue;
          y.i("MicroMsg.Tinker.CTinkerInstaller", "merge apk failed.");
        }
      }
      h.nFQ.a(614L, 52L, 1L, false);
      y.d("MicroMsg.Tinker.CTinkerInstaller", "boots download failed sdcard full.");
      return;
      h.nFQ.a(614L, 53L, 1L, false);
      y.d("MicroMsg.Tinker.CTinkerInstaller", "boots download failed apk md5 no equal.");
      return;
      i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.hp.a.a.1
 * JD-Core Version:    0.7.0.1
 */