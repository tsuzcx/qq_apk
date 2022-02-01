package com.tencent.mm.plugin.hp.a;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.d.a;
import com.tencent.mm.plugin.hp.d.d;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.protocal.protobuf.dna;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.vfs.i;
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
    if (!i.fv(this.uHX))
    {
      long l = System.currentTimeMillis();
      i = b.a(d.fE(this.val$context), this.uHY, this.uHX, this.uHZ.uJh);
      SharePatchFileUtil.safeDeleteFile(new File(this.uHY));
      ad.i("MicroMsg.Tinker.CTinkerInstaller", "merge apk use :%d second retCode:%d", new Object[] { Long.valueOf((System.currentTimeMillis() - l) / 1000L), Integer.valueOf(i) });
    }
    for (;;)
    {
      String str;
      if (i == 0)
      {
        boolean bool = a.eW(this.uHX);
        if (bool)
        {
          ad.i("MicroMsg.Tinker.CTinkerInstaller", "checkApk:%s", new Object[] { Boolean.valueOf(bool) });
          Context localContext = aj.getContext();
          if (bt.isNullOrNil(this.uHZ.dcJ()))
          {
            str = localContext.getString(2131764588);
            dna localdna = new dna();
            localdna.nUh = this.uHZ.nUh;
            localdna.title = localContext.getString(2131759571);
            localdna.HBn = localContext.getString(2131760343);
            localdna.utw = localContext.getString(2131764569);
            localdna.uJh = this.uHZ.uJh;
            localdna.uJi = this.uHZ.uJi;
            localdna.mtM = this.uHZ.fileSize;
            localdna.gHx = this.uHZ.gHx;
            localdna.patchMd5 = this.uHZ.nUg;
            localdna.versionCode = this.uHZ.versionCode;
            localdna.HBm = this.uHX;
            localdna.msg = str;
            d.a(localdna);
            if (this.uHZ.nUe.intValue() == 3) {
              g.yhR.idkeyStat(614L, 58L, 1L, false);
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
        str = this.uHZ.dcJ();
        break;
        ad.i("MicroMsg.Tinker.CTinkerInstaller", "md5 is no equal.");
        break label342;
        ad.i("MicroMsg.Tinker.CTinkerInstaller", "merge apk failed.");
        break label342;
        g.yhR.idkeyStat(614L, 52L, 1L, false);
        ad.d("MicroMsg.Tinker.CTinkerInstaller", "boots download failed sdcard full.");
        AppMethodBeat.o(117377);
        return;
        g.yhR.idkeyStat(614L, 53L, 1L, false);
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