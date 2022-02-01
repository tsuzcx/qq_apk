package com.tencent.mm.plugin.hp.a;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.d.a;
import com.tencent.mm.plugin.hp.c.d;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.dbz;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.vfs.i;
import com.tencent.tinker.loader.shareutil.SharePatchFileUtil;
import java.io.File;

public final class a$1
  implements Runnable
{
  public a$1(String paramString1, Context paramContext, String paramString2, com.tencent.mm.plugin.hp.c.b paramb) {}
  
  public final void run()
  {
    AppMethodBeat.i(117377);
    int i;
    if (!i.eK(this.sxz))
    {
      long l = System.currentTimeMillis();
      i = b.a(d.fm(this.val$context), this.sxA, this.sxz, this.sxB.syK);
      SharePatchFileUtil.safeDeleteFile(new File(this.sxA));
      ad.i("MicroMsg.Tinker.CTinkerInstaller", "merge apk use :%d second retCode:%d", new Object[] { Long.valueOf((System.currentTimeMillis() - l) / 1000L), Integer.valueOf(i) });
    }
    for (;;)
    {
      String str;
      if (i == 0)
      {
        boolean bool = a.em(this.sxz);
        if (bool)
        {
          ad.i("MicroMsg.Tinker.CTinkerInstaller", "checkApk:%s", new Object[] { Boolean.valueOf(bool) });
          Context localContext = aj.getContext();
          if (bt.isNullOrNil(this.sxB.cGp()))
          {
            str = localContext.getString(2131764588);
            dbz localdbz = new dbz();
            localdbz.syJ = this.sxB.syJ;
            localdbz.title = localContext.getString(2131759571);
            localdbz.EtG = localContext.getString(2131760343);
            localdbz.sne = localContext.getString(2131764569);
            localdbz.syK = this.sxB.syK;
            localdbz.syL = this.sxB.syL;
            localdbz.lsc = this.sxB.fileSize;
            localdbz.syH = this.sxB.syH;
            localdbz.patchMd5 = this.sxB.syI;
            localdbz.versionCode = this.sxB.versionCode;
            localdbz.EtF = this.sxz;
            localdbz.bLg = str;
            d.a(localdbz);
            if (this.sxB.syF.intValue() == 3) {
              h.vKh.idkeyStat(614L, 58L, 1L, false);
            }
            ad.d("MicroMsg.Tinker.CTinkerInstaller", "boots download success.");
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
        str = this.sxB.cGp();
        break;
        ad.i("MicroMsg.Tinker.CTinkerInstaller", "md5 is no equal.");
        break label342;
        ad.i("MicroMsg.Tinker.CTinkerInstaller", "merge apk failed.");
        break label342;
        h.vKh.idkeyStat(614L, 52L, 1L, false);
        ad.d("MicroMsg.Tinker.CTinkerInstaller", "boots download failed sdcard full.");
        AppMethodBeat.o(117377);
        return;
        h.vKh.idkeyStat(614L, 53L, 1L, false);
        ad.d("MicroMsg.Tinker.CTinkerInstaller", "boots download failed apk md5 no equal.");
      }
      i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.hp.a.a.1
 * JD-Core Version:    0.7.0.1
 */