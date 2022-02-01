package com.tencent.mm.plugin.hp.a;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.d.a;
import com.tencent.mm.plugin.hp.d.d;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.protocal.protobuf.dnx;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.vfs.o;
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
    if (!o.fB(this.uTK))
    {
      long l = System.currentTimeMillis();
      i = b.a(d.fJ(this.val$context), this.uTL, this.uTK, this.uTM.uUU);
      SharePatchFileUtil.safeDeleteFile(new File(this.uTL));
      ae.i("MicroMsg.Tinker.CTinkerInstaller", "merge apk use :%d second retCode:%d", new Object[] { Long.valueOf((System.currentTimeMillis() - l) / 1000L), Integer.valueOf(i) });
    }
    for (;;)
    {
      String str;
      if (i == 0)
      {
        boolean bool = a.fb(this.uTK);
        if (bool)
        {
          ae.i("MicroMsg.Tinker.CTinkerInstaller", "checkApk:%s", new Object[] { Boolean.valueOf(bool) });
          Context localContext = ak.getContext();
          if (bu.isNullOrNil(this.uTM.dfB()))
          {
            str = localContext.getString(2131764588);
            dnx localdnx = new dnx();
            localdnx.nZN = this.uTM.nZN;
            localdnx.title = localContext.getString(2131759571);
            localdnx.HVa = localContext.getString(2131760343);
            localdnx.uEP = localContext.getString(2131764569);
            localdnx.uUU = this.uTM.uUU;
            localdnx.uUV = this.uTM.uUV;
            localdnx.myJ = this.uTM.fileSize;
            localdnx.gKg = this.uTM.gKg;
            localdnx.patchMd5 = this.uTM.nZM;
            localdnx.versionCode = this.uTM.versionCode;
            localdnx.HUZ = this.uTK;
            localdnx.msg = str;
            d.a(localdnx);
            if (this.uTM.nZK.intValue() == 3) {
              g.yxI.idkeyStat(614L, 58L, 1L, false);
            }
            ae.d("MicroMsg.Tinker.CTinkerInstaller", "boots download success.");
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
        str = this.uTM.dfB();
        break;
        ae.i("MicroMsg.Tinker.CTinkerInstaller", "md5 is no equal.");
        break label342;
        ae.i("MicroMsg.Tinker.CTinkerInstaller", "merge apk failed.");
        break label342;
        g.yxI.idkeyStat(614L, 52L, 1L, false);
        ae.d("MicroMsg.Tinker.CTinkerInstaller", "boots download failed sdcard full.");
        AppMethodBeat.o(117377);
        return;
        g.yxI.idkeyStat(614L, 53L, 1L, false);
        ae.d("MicroMsg.Tinker.CTinkerInstaller", "boots download failed apk md5 no equal.");
      }
      i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.hp.a.a.1
 * JD-Core Version:    0.7.0.1
 */