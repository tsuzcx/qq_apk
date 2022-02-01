package com.tencent.mm.plugin.hp.a;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.d.a;
import com.tencent.mm.plugin.hp.d.d;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.eht;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.s;
import com.tencent.tinker.loader.shareutil.SharePatchFileUtil;
import java.io.File;

public final class a$1
  implements Runnable
{
  public a$1(String paramString1, Context paramContext, String paramString2, com.tencent.mm.plugin.hp.d.b paramb) {}
  
  public final void run()
  {
    AppMethodBeat.i(117377);
    int i;
    if (!s.YS(this.yml))
    {
      long l = System.currentTimeMillis();
      i = b.a(d.gp(this.val$context), this.ymm, this.yml, this.ymn.ynv);
      SharePatchFileUtil.safeDeleteFile(new File(this.ymm));
      Log.i("MicroMsg.Tinker.CTinkerInstaller", "merge apk use :%d second retCode:%d", new Object[] { Long.valueOf((System.currentTimeMillis() - l) / 1000L), Integer.valueOf(i) });
    }
    for (;;)
    {
      String str;
      if (i == 0)
      {
        boolean bool = a.fP(this.yml);
        if (bool)
        {
          Log.i("MicroMsg.Tinker.CTinkerInstaller", "checkApk:%s", new Object[] { Boolean.valueOf(bool) });
          Context localContext = MMApplicationContext.getContext();
          if (Util.isNullOrNil(this.ymn.dZv()))
          {
            str = localContext.getString(2131766934);
            eht localeht = new eht();
            localeht.cri = this.ymn.cri;
            localeht.title = localContext.getString(2131760888);
            localeht.Nhk = localContext.getString(2131761788);
            localeht.xWM = localContext.getString(2131766915);
            localeht.ynv = this.ymn.ynv;
            localeht.ynw = this.ymn.ynw;
            localeht.nJK = this.ymn.fileSize;
            localeht.pkK = this.ymn.pkK;
            localeht.patchMd5 = this.ymn.pkL;
            localeht.versionCode = this.ymn.versionCode;
            localeht.Nhj = this.yml;
            localeht.msg = str;
            d.a(localeht);
            if (this.ymn.pkI.intValue() == 3) {
              h.CyF.idkeyStat(614L, 58L, 1L, false);
            }
            Log.d("MicroMsg.Tinker.CTinkerInstaller", "boots download success.");
            label342:
            switch (i)
            {
            }
          }
        }
      }
      for (;;)
      {
        AppMethodBeat.o(117377);
        return;
        str = this.ymn.dZv();
        break;
        Log.i("MicroMsg.Tinker.CTinkerInstaller", "md5 is no equal.");
        break label342;
        Log.i("MicroMsg.Tinker.CTinkerInstaller", "merge apk failed.");
        break label342;
        h.CyF.idkeyStat(614L, 52L, 1L, false);
        Log.d("MicroMsg.Tinker.CTinkerInstaller", "boots download failed sdcard full.");
        AppMethodBeat.o(117377);
        return;
        h.CyF.idkeyStat(614L, 53L, 1L, false);
        Log.d("MicroMsg.Tinker.CTinkerInstaller", "boots download failed apk md5 no equal.");
      }
      i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.hp.a.a.1
 * JD-Core Version:    0.7.0.1
 */