package com.tencent.mm.plugin.hp.a;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.a.e;
import com.tencent.mm.c.a;
import com.tencent.mm.plugin.hp.d.d;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.ckf;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.tinker.loader.shareutil.SharePatchFileUtil;
import java.io.File;

public final class a$1
  implements Runnable
{
  public a$1(String paramString1, Context paramContext, String paramString2, com.tencent.mm.plugin.hp.d.b paramb) {}
  
  public final void run()
  {
    AppMethodBeat.i(90545);
    int i;
    if (!e.cN(this.nJT))
    {
      long l = System.currentTimeMillis();
      i = b.b(d.er(this.val$context), this.nJU, this.nJT, this.nJV.nKS);
      SharePatchFileUtil.aq(new File(this.nJU));
      ab.i("MicroMsg.Tinker.CTinkerInstaller", "merge apk use :%d second retCode:%d", new Object[] { Long.valueOf((System.currentTimeMillis() - l) / 1000L), Integer.valueOf(i) });
    }
    for (;;)
    {
      String str;
      if (i == 0)
      {
        boolean bool = a.jdMethod_do(this.nJT);
        if (bool)
        {
          ab.i("MicroMsg.Tinker.CTinkerInstaller", "checkApk:%s", new Object[] { Boolean.valueOf(bool) });
          Context localContext = ah.getContext();
          if (bo.isNullOrNil(this.nJV.bIu()))
          {
            str = localContext.getString(2131304442);
            ckf localckf = new ckf();
            localckf.nKR = this.nJV.nKR;
            localckf.title = localContext.getString(2131300104);
            localckf.xUl = localContext.getString(2131300742);
            localckf.nDF = localContext.getString(2131304423);
            localckf.nKS = this.nJV.nKS;
            localckf.nKT = this.nJV.nKT;
            localckf.iHT = this.nJV.fileSize;
            localckf.nKP = this.nJV.nKP;
            localckf.bWN = this.nJV.nKQ;
            localckf.versionCode = this.nJV.versionCode;
            localckf.xUk = this.nJT;
            localckf.bjm = str;
            d.a(localckf);
            if (this.nJV.nKN.intValue() == 3) {
              h.qsU.idkeyStat(614L, 58L, 1L, false);
            }
            ab.d("MicroMsg.Tinker.CTinkerInstaller", "boots download success.");
            label342:
            switch (i)
            {
            }
          }
        }
      }
      for (;;)
      {
        AppMethodBeat.o(90545);
        return;
        str = this.nJV.bIu();
        break;
        ab.i("MicroMsg.Tinker.CTinkerInstaller", "md5 is no equal.");
        break label342;
        ab.i("MicroMsg.Tinker.CTinkerInstaller", "merge apk failed.");
        break label342;
        h.qsU.idkeyStat(614L, 52L, 1L, false);
        ab.d("MicroMsg.Tinker.CTinkerInstaller", "boots download failed sdcard full.");
        AppMethodBeat.o(90545);
        return;
        h.qsU.idkeyStat(614L, 53L, 1L, false);
        ab.d("MicroMsg.Tinker.CTinkerInstaller", "boots download failed apk md5 no equal.");
      }
      i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.hp.a.a.1
 * JD-Core Version:    0.7.0.1
 */