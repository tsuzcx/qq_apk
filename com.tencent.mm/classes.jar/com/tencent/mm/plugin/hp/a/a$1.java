package com.tencent.mm.plugin.hp.a;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.d.a;
import com.tencent.mm.plugin.hp.c.d;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.dhl;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bs;
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
    if (!i.eA(this.tFo))
    {
      long l = System.currentTimeMillis();
      i = b.a(d.fz(this.val$context), this.tFp, this.tFo, this.tFq.tGu);
      SharePatchFileUtil.safeDeleteFile(new File(this.tFp));
      ac.i("MicroMsg.Tinker.CTinkerInstaller", "merge apk use :%d second retCode:%d", new Object[] { Long.valueOf((System.currentTimeMillis() - l) / 1000L), Integer.valueOf(i) });
    }
    for (;;)
    {
      String str;
      if (i == 0)
      {
        boolean bool = a.eb(this.tFo);
        if (bool)
        {
          ac.i("MicroMsg.Tinker.CTinkerInstaller", "checkApk:%s", new Object[] { Boolean.valueOf(bool) });
          Context localContext = ai.getContext();
          if (bs.isNullOrNil(this.tFq.cTz()))
          {
            str = localContext.getString(2131764588);
            dhl localdhl = new dhl();
            localdhl.ntl = this.tFq.ntl;
            localdhl.title = localContext.getString(2131759571);
            localdhl.FQI = localContext.getString(2131760343);
            localdhl.tuX = localContext.getString(2131764569);
            localdhl.tGu = this.tFq.tGu;
            localdhl.tGv = this.tFq.tGv;
            localdhl.lTX = this.tFq.fileSize;
            localdhl.gnO = this.tFq.gnO;
            localdhl.patchMd5 = this.tFq.ntk;
            localdhl.versionCode = this.tFq.versionCode;
            localdhl.FQH = this.tFo;
            localdhl.bIO = str;
            d.a(localdhl);
            if (this.tFq.nti.intValue() == 3) {
              h.wUl.idkeyStat(614L, 58L, 1L, false);
            }
            ac.d("MicroMsg.Tinker.CTinkerInstaller", "boots download success.");
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
        str = this.tFq.cTz();
        break;
        ac.i("MicroMsg.Tinker.CTinkerInstaller", "md5 is no equal.");
        break label342;
        ac.i("MicroMsg.Tinker.CTinkerInstaller", "merge apk failed.");
        break label342;
        h.wUl.idkeyStat(614L, 52L, 1L, false);
        ac.d("MicroMsg.Tinker.CTinkerInstaller", "boots download failed sdcard full.");
        AppMethodBeat.o(117377);
        return;
        h.wUl.idkeyStat(614L, 53L, 1L, false);
        ac.d("MicroMsg.Tinker.CTinkerInstaller", "boots download failed apk md5 no equal.");
      }
      i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.hp.a.a.1
 * JD-Core Version:    0.7.0.1
 */