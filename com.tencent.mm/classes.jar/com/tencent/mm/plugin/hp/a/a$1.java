package com.tencent.mm.plugin.hp.a;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.d.a;
import com.tencent.mm.plugin.boots.b.a;
import com.tencent.mm.plugin.hp.d.d;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.erv;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.u;
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
    if (!u.agG(this.DMn))
    {
      long l = System.currentTimeMillis();
      i = b.b(d.hm(this.val$context), this.DMo, this.DMn, this.DMp.DNx);
      SharePatchFileUtil.safeDeleteFile(new File(this.DMo));
      Log.i("MicroMsg.Tinker.CTinkerInstaller", "merge apk use :%d second retCode:%d", new Object[] { Long.valueOf((System.currentTimeMillis() - l) / 1000L), Integer.valueOf(i) });
    }
    for (;;)
    {
      String str;
      if (i == 0)
      {
        boolean bool = a.gz(this.DMn);
        if (bool)
        {
          Log.i("MicroMsg.Tinker.CTinkerInstaller", "checkApk:%s", new Object[] { Boolean.valueOf(bool) });
          Context localContext = MMApplicationContext.getContext();
          if (Util.isNullOrNil(this.DMp.eIs()))
          {
            str = localContext.getString(b.a.update_tip_recommended_down);
            erv localerv = new erv();
            localerv.coY = this.DMp.coY;
            localerv.title = localContext.getString(b.a.fmt_update);
            localerv.UtQ = localContext.getString(b.a.install_now);
            localerv.DaW = localContext.getString(b.a.update_cancel);
            localerv.DNx = this.DMp.DNx;
            localerv.DNy = this.DMp.DNy;
            localerv.qLX = this.DMp.fileSize;
            localerv.smT = this.DMp.smT;
            localerv.patchMd5 = this.DMp.smU;
            localerv.versionCode = this.DMp.versionCode;
            localerv.UtP = this.DMn;
            localerv.msg = str;
            d.a(localerv);
            if (this.DMp.smR.intValue() == 3) {
              h.IzE.idkeyStat(614L, 58L, 1L, false);
            }
            Log.d("MicroMsg.Tinker.CTinkerInstaller", "boots download success.");
            label346:
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
        str = this.DMp.eIs();
        break;
        Log.i("MicroMsg.Tinker.CTinkerInstaller", "md5 is no equal.");
        break label346;
        Log.i("MicroMsg.Tinker.CTinkerInstaller", "merge apk failed.");
        break label346;
        h.IzE.idkeyStat(614L, 52L, 1L, false);
        Log.d("MicroMsg.Tinker.CTinkerInstaller", "boots download failed sdcard full.");
        AppMethodBeat.o(117377);
        return;
        h.IzE.idkeyStat(614L, 53L, 1L, false);
        Log.d("MicroMsg.Tinker.CTinkerInstaller", "boots download failed apk md5 no equal.");
      }
      i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.hp.a.a.1
 * JD-Core Version:    0.7.0.1
 */