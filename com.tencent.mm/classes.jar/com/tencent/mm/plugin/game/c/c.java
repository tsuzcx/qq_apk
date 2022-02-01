package com.tencent.mm.plugin.game.c;

import android.os.Build;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.aa;
import com.tencent.mm.ak.aa.a;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.compatible.deviceinfo.q;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.game.api.f;
import com.tencent.mm.plugin.game.b.a.j;
import com.tencent.mm.plugin.game.b.a.k;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.n.n;
import kotlin.t;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/game/download/GameResourceDownloadReporter;", "", "()V", "STAGE_CANCEL_DOWNLOAD", "", "STAGE_FINISH_DOWNLOAD", "STAGE_START_DOWNLOAD", "STATUS_DOWNLOAD_FAIL", "STATUS_DOWNLOAD_SUCCESS", "TAG", "", "finishOneDownload", "", "packageName", "report", "downloadId", "", "plugin-game_release"})
public final class c
{
  public static final c xvR;
  
  static
  {
    AppMethodBeat.i(204352);
    xvR = new c();
    AppMethodBeat.o(204352);
  }
  
  private static void azv(String paramString)
  {
    AppMethodBeat.i(204351);
    Object localObject = g.af(f.class);
    p.g(localObject, "MMKernel.service(IGameStorage::class.java)");
    ((f)localObject).dSP().azy(paramString);
    localObject = b.xvL;
    b.azs(paramString);
    AppMethodBeat.o(204351);
  }
  
  public static void report(long paramLong)
  {
    AppMethodBeat.i(204350);
    Object localObject1 = com.tencent.mm.plugin.downloader.model.d.Cw(paramLong);
    if (localObject1 == null)
    {
      Log.i("MicroMsg.GameResourceDownloadReporter", "report, info is null");
      AppMethodBeat.o(204350);
      return;
    }
    if (((com.tencent.mm.plugin.downloader.g.a)localObject1).field_fileType != 3)
    {
      AppMethodBeat.o(204350);
      return;
    }
    int i;
    int j;
    switch (((com.tencent.mm.plugin.downloader.g.a)localObject1).field_status)
    {
    case 2: 
    default: 
      AppMethodBeat.o(204350);
      return;
    case 1: 
      i = 0;
      j = 3;
    }
    Object localObject2;
    for (;;)
    {
      str1 = Util.nullAsNil(((com.tencent.mm.plugin.downloader.g.a)localObject1).field_filePath);
      localObject2 = new j();
      ((j)localObject2).xuk = ((com.tencent.mm.plugin.downloader.g.a)localObject1).field_packageName;
      ((j)localObject2).xus = j;
      ((j)localObject2).oTW = i;
      p.g(str1, "filePath");
      i = n.g((CharSequence)str1, "/");
      if (str1 != null) {
        break;
      }
      localObject1 = new t("null cannot be cast to non-null type java.lang.String");
      AppMethodBeat.o(204350);
      throw ((Throwable)localObject1);
      localObject2 = ((com.tencent.mm.plugin.downloader.g.a)localObject1).field_packageName;
      p.g(localObject2, "info.field_packageName");
      azv((String)localObject2);
      i = 0;
      j = 4;
      continue;
      i = 1;
      localObject2 = ((com.tencent.mm.plugin.downloader.g.a)localObject1).field_packageName;
      p.g(localObject2, "info.field_packageName");
      azv((String)localObject2);
      j = 4;
      continue;
      localObject2 = ((com.tencent.mm.plugin.downloader.g.a)localObject1).field_packageName;
      p.g(localObject2, "info.field_packageName");
      azv((String)localObject2);
      i = 0;
      j = 5;
    }
    String str2 = str1.substring(i + 1);
    p.g(str2, "(this as java.lang.String).substring(startIndex)");
    ((j)localObject2).xuz = str2;
    ((j)localObject2).xuB = ((com.tencent.mm.plugin.downloader.g.a)localObject1).field_md5;
    String str1 = str1.substring(0, n.g((CharSequence)str1, "/") + 1);
    p.g(str1, "(this as java.lang.Strin…ing(startIndex, endIndex)");
    ((j)localObject2).xuC = str1;
    ((j)localObject2).errorCode = ((com.tencent.mm.plugin.downloader.g.a)localObject1).field_errCode;
    ((j)localObject2).xup = q.dr(false);
    ((j)localObject2).xuo = q.aoK();
    ((j)localObject2).xun = "";
    ((j)localObject2).xuq = String.valueOf(com.tencent.mm.plugin.game.e.c.aAH(((j)localObject2).xuk));
    ((j)localObject2).xur = com.tencent.mm.plugin.game.e.c.aAI(((j)localObject2).xuk);
    ((j)localObject2).oTJ = Build.MODEL;
    ((j)localObject2).oUj = Build.MANUFACTURER;
    Log.i("MicroMsg.GameResourceDownloadReporter", "PackageName:" + ((j)localObject2).xuk + ", Stage:" + ((j)localObject2).xus + ", Status:" + ((j)localObject2).oTW + ", FileName:" + ((j)localObject2).xuz + ", FileMd5:" + ((j)localObject2).xuB + ", DownloadPath:" + ((j)localObject2).xuC + ", errorCode:" + ((j)localObject2).errorCode + ", Imei:" + ((j)localObject2).xup + ", Oaid:" + ((j)localObject2).xuo + ", Xid:" + ((j)localObject2).xun + ", VersionCode:" + ((j)localObject2).xuq + ", VersionName:" + ((j)localObject2).xur + ", Model:" + ((j)localObject2).oTJ + ", Manufacturer:" + ((j)localObject2).oUj);
    localObject1 = new d.a();
    ((d.a)localObject1).sG(4100);
    ((d.a)localObject1).MB("/cgi-bin/mmgame-bin/reportgameresourcedownload");
    ((d.a)localObject1).c((com.tencent.mm.bw.a)localObject2);
    ((d.a)localObject1).d((com.tencent.mm.bw.a)new k());
    ((d.a)localObject1).sI(0);
    ((d.a)localObject1).sJ(0);
    aa.a(((d.a)localObject1).aXF(), (aa.a)c.a.xvS);
    AppMethodBeat.o(204350);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.game.c.c
 * JD-Core Version:    0.7.0.1
 */