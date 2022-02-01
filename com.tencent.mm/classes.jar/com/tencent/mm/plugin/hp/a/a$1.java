package com.tencent.mm.plugin.hp.a;

import android.content.Context;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.boots.b.a;
import com.tencent.mm.plugin.hp.b.d;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.fne;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.y;
import com.tencent.tinker.loader.shareutil.SharePatchFileUtil;
import java.io.File;

public final class a$1
  implements Runnable
{
  public a$1(com.tencent.mm.plugin.hp.b.b paramb, boolean paramBoolean1, Context paramContext, String paramString, boolean paramBoolean2) {}
  
  public final void run()
  {
    AppMethodBeat.i(117377);
    String str2 = d.aIO(this.JDA.JEL);
    String str1;
    Object localObject1;
    Object localObject3;
    if (this.JDB)
    {
      str1 = this.JDA.JEL;
      localObject1 = d.iH(this.val$context);
      localObject3 = this.JDC;
      localObject2 = localObject1;
      if (!a.fPF()) {
        break label1241;
      }
      if (c.fPG())
      {
        Toast.makeText(MMApplicationContext.getContext(), "download ok", 1).show();
        localObject1 = "/storage/emulated/0/Android/data/com.tencent.mm/MicroMsg/Download/tmp/old.apk";
      }
      localObject2 = localObject1;
      if (!c.fPH()) {
        break label1241;
      }
    }
    for (Object localObject2 = "/storage/emulated/0/Android/data/com.tencent.mm/MicroMsg/WebNetFile/tmp_test.patch";; localObject2 = localException1)
    {
      localObject3 = d.fQv() + "_tmpold.apk";
      long l1;
      int i;
      long l2;
      label385:
      boolean bool;
      if (c.jD((String)localObject1, (String)localObject3))
      {
        Log.i("MicroMsg.Tinker.CTinkerInstaller", "HdiffApk filterApkExtInfo success, oldPath = ".concat(String.valueOf(localObject3)));
        localObject1 = localObject3;
        Log.i("MicroMsg.Tinker.CTinkerInstaller", "start HdiffApk newApkPath: " + str2 + ", size: " + new File(str2).length() + "\n, oldApk: " + (String)localObject1 + ", size: " + new File((String)localObject1).length() + "\n, hDiffPathTmp: " + (String)localObject2 + ", size: " + new File((String)localObject2).length() + "\n, newApkMd5: " + str1 + "\n, tmpFilePath: " + (String)localObject3 + "\n, UpdateUtil.getCurrentApkPath(context): " + d.iH(this.val$context));
        if ((y.ZC(str2)) && (new File(str2).length() == 0L))
        {
          SharePatchFileUtil.safeDeleteFile(new File(str2));
          Log.w("MicroMsg.Tinker.CTinkerInstaller", "newApkPath is exists but size = 0.");
        }
        if (y.ZC(str2)) {
          break label975;
        }
        l1 = System.currentTimeMillis();
        i = c.a((String)localObject1, (String)localObject2, str2, this.JDA);
        l2 = System.currentTimeMillis();
        if (i != 0) {
          break label929;
        }
        c.t(106, i, l2);
        h.OAn.idkeyStat(614L, 106L, 1L, false);
        bool = SharePatchFileUtil.safeDeleteFile(new File((String)localObject2));
        Log.i("MicroMsg.Tinker.CTinkerInstaller", "HdiffAPk, merge apk use :%d second retCode:%d, deleteDownloadPatch:%s", new Object[] { Long.valueOf((l2 - l1) / 1000L), Integer.valueOf(i), Boolean.valueOf(bool) });
        if (i == 0)
        {
          this.JDA.JEM = str1;
          localObject3 = "";
        }
      }
      try
      {
        str1 = y.bub((String)localObject1);
        localObject3 = str1;
      }
      catch (Exception localException2)
      {
        for (;;)
        {
          Log.i("MicroMsg.Tinker.CTinkerInstaller", "Exception = ".concat(String.valueOf(localException2)));
        }
      }
      Log.i("MicroMsg.Tinker.CTinkerInstaller", "HdiffApk oldApkMd5 = " + (String)localObject3 + ", response.oldApkMd5 = " + this.JDA.JEM);
      label504:
      Log.i("MicroMsg.Tinker.CTinkerInstaller", "end HdiffApk newApkPath: " + str2 + ", size: " + new File(str2).length() + "\n, oldApk: " + (String)localObject1 + ", size: " + new File((String)localObject1).length() + "\n, hDiffPathTmp: " + (String)localObject2 + ", size: " + new File((String)localObject2).length() + "\n, retCode: " + i);
      for (;;)
      {
        label615:
        if (i == 0)
        {
          bool = com.tencent.mm.d.a.hZ(str2);
          Log.i("MicroMsg.Tinker.CTinkerInstaller", "HdiffApk checkApk:%s", new Object[] { Boolean.valueOf(bool) });
          if (bool)
          {
            localObject2 = MMApplicationContext.getContext();
            if (Util.isNullOrNil(this.JDA.fQl()))
            {
              localObject1 = ((Context)localObject2).getString(b.a.update_tip_recommended_down);
              localObject3 = new fne();
              ((fne)localObject3).egJ = this.JDA.egJ;
              ((fne)localObject3).title = ((Context)localObject2).getString(b.a.fmt_update);
              ((fne)localObject3).abNm = ((Context)localObject2).getString(b.a.install_now);
              ((fne)localObject3).IVk = ((Context)localObject2).getString(b.a.update_cancel);
              ((fne)localObject3).JEL = this.JDA.JEL;
              ((fne)localObject3).JEM = this.JDA.JEM;
              ((fne)localObject3).tQE = this.JDA.fileSize;
              ((fne)localObject3).mOI = this.JDA.mOI;
              ((fne)localObject3).hDq = this.JDA.vyQ.intValue();
              ((fne)localObject3).patchMd5 = this.JDA.vyS;
              ((fne)localObject3).versionCode = this.JDA.versionCode;
              ((fne)localObject3).abNl = str2;
              ((fne)localObject3).msg = ((String)localObject1);
              d.a((fne)localObject3);
              if (!this.JDD) {
                break label1129;
              }
              h.OAn.idkeyStat(614L, 58L, 1L, false);
              Log.i("MicroMsg.Tinker.CTinkerInstaller", "boots download success.");
              label873:
              if (this.JDD) {
                switch (i)
                {
                }
              }
            }
          }
        }
        for (;;)
        {
          for (;;)
          {
            label678:
            label865:
            AppMethodBeat.o(117377);
            return;
            Log.i("MicroMsg.Tinker.CTinkerInstaller", "HdiffApk filterApkExtInfo fail, oldPath = ".concat(String.valueOf(localObject1)));
            break;
            label929:
            c.t(105, i, l2);
            h.OAn.idkeyStat(614L, 105L, 1L, false);
            break label385;
            label975:
            this.JDA.JEM = this.JDA.JEL;
            try
            {
              this.JDA.JEL = y.bub(str2);
              i = 0;
            }
            catch (Exception localException1)
            {
              Log.i("MicroMsg.Tinker.CTinkerInstaller", "Exception = ".concat(String.valueOf(localException1)));
              i = 0;
            }
          }
          break label504;
          if (y.ZC(str2)) {
            break label1236;
          }
          l1 = System.currentTimeMillis();
          i = b.A(d.iH(this.val$context), this.JDC, str2, this.JDA.JEL);
          SharePatchFileUtil.safeDeleteFile(new File(this.JDC));
          Log.i("MicroMsg.Tinker.CTinkerInstaller", "merge apk use :%d second retCode:%d", new Object[] { Long.valueOf((System.currentTimeMillis() - l1) / 1000L), Integer.valueOf(i) });
          break label615;
          localObject1 = this.JDA.fQl();
          break label678;
          label1129:
          if (!this.JDB) {
            break label865;
          }
          c.t(125, -100, 0L);
          h.OAn.idkeyStat(614L, 125L, 1L, false);
          break label865;
          Log.i("MicroMsg.Tinker.CTinkerInstaller", "md5 is no equal.");
          break label873;
          Log.i("MicroMsg.Tinker.CTinkerInstaller", "merge apk failed.");
          break label873;
          h.OAn.idkeyStat(614L, 52L, 1L, false);
          Log.d("MicroMsg.Tinker.CTinkerInstaller", "boots download failed sdcard full.");
          AppMethodBeat.o(117377);
          return;
          h.OAn.idkeyStat(614L, 53L, 1L, false);
          Log.d("MicroMsg.Tinker.CTinkerInstaller", "boots download failed apk md5 no equal.");
        }
        label1236:
        i = 0;
      }
      label1241:
      localObject1 = localObject2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.hp.a.a.1
 * JD-Core Version:    0.7.0.1
 */