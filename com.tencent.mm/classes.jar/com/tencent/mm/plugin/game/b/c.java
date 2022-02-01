package com.tencent.mm.plugin.game.b;

import android.os.Build;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.aa;
import com.tencent.mm.an.aa.a;
import com.tencent.mm.an.d.a;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.game.api.f;
import com.tencent.mm.plugin.game.autogen.a.j;
import com.tencent.mm.plugin.game.autogen.a.k;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.n.n;
import kotlin.t;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/game/download/GameResourceDownloadReporter;", "", "()V", "STAGE_CANCEL_DOWNLOAD", "", "STAGE_FINISH_DOWNLOAD", "STAGE_START_DOWNLOAD", "STATUS_DOWNLOAD_FAIL", "STATUS_DOWNLOAD_SUCCESS", "TAG", "", "finishOneDownload", "", "packageName", "report", "downloadId", "", "plugin-game_release"})
public final class c
{
  public static final c CzL;
  
  static
  {
    AppMethodBeat.i(193190);
    CzL = new c();
    AppMethodBeat.o(193190);
  }
  
  private static void aJf(String paramString)
  {
    AppMethodBeat.i(193184);
    Object localObject = h.ae(f.class);
    p.j(localObject, "MMKernel.service(IGameStorage::class.java)");
    ((f)localObject).evt().aJi(paramString);
    localObject = b.CzF;
    b.aJc(paramString);
    AppMethodBeat.o(193184);
  }
  
  public static void report(long paramLong)
  {
    AppMethodBeat.i(193181);
    Object localObject1 = com.tencent.mm.plugin.downloader.model.d.IF(paramLong);
    if (localObject1 == null)
    {
      Log.i("MicroMsg.GameResourceDownloadReporter", "report, info is null");
      AppMethodBeat.o(193181);
      return;
    }
    if (((com.tencent.mm.plugin.downloader.g.a)localObject1).field_fileType != 3)
    {
      AppMethodBeat.o(193181);
      return;
    }
    int i;
    int j;
    switch (((com.tencent.mm.plugin.downloader.g.a)localObject1).field_status)
    {
    case 2: 
    default: 
      AppMethodBeat.o(193181);
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
      ((j)localObject2).CqB = ((com.tencent.mm.plugin.downloader.g.a)localObject1).field_packageName;
      ((j)localObject2).CqJ = j;
      ((j)localObject2).rVU = i;
      p.j(str1, "filePath");
      i = n.g((CharSequence)str1, "/");
      if (str1 != null) {
        break;
      }
      localObject1 = new t("null cannot be cast to non-null type java.lang.String");
      AppMethodBeat.o(193181);
      throw ((Throwable)localObject1);
      localObject2 = ((com.tencent.mm.plugin.downloader.g.a)localObject1).field_packageName;
      p.j(localObject2, "info.field_packageName");
      aJf((String)localObject2);
      i = 0;
      j = 4;
      continue;
      i = 1;
      localObject2 = ((com.tencent.mm.plugin.downloader.g.a)localObject1).field_packageName;
      p.j(localObject2, "info.field_packageName");
      aJf((String)localObject2);
      j = 4;
      continue;
      localObject2 = ((com.tencent.mm.plugin.downloader.g.a)localObject1).field_packageName;
      p.j(localObject2, "info.field_packageName");
      aJf((String)localObject2);
      i = 0;
      j = 5;
    }
    String str2 = str1.substring(i + 1);
    p.j(str2, "(this as java.lang.String).substring(startIndex)");
    ((j)localObject2).CqQ = str2;
    ((j)localObject2).CqS = ((com.tencent.mm.plugin.downloader.g.a)localObject1).field_md5;
    String str1 = str1.substring(0, n.g((CharSequence)str1, "/") + 1);
    p.j(str1, "(this as java.lang.Strin…ing(startIndex, endIndex)");
    ((j)localObject2).CqT = str1;
    ((j)localObject2).errorCode = ((com.tencent.mm.plugin.downloader.g.a)localObject1).field_errCode;
    ((j)localObject2).CqG = com.tencent.mm.compatible.deviceinfo.q.dR(false);
    ((j)localObject2).CqF = com.tencent.mm.compatible.deviceinfo.q.auQ();
    ((j)localObject2).CqE = "";
    ((j)localObject2).CqH = String.valueOf(com.tencent.mm.plugin.game.d.c.aKt(((j)localObject2).CqB));
    ((j)localObject2).CqI = com.tencent.mm.plugin.game.d.c.aKu(((j)localObject2).CqB);
    ((j)localObject2).rVH = Build.MODEL;
    ((j)localObject2).rWh = Build.MANUFACTURER;
    Log.i("MicroMsg.GameResourceDownloadReporter", "PackageName:" + ((j)localObject2).CqB + ", Stage:" + ((j)localObject2).CqJ + ", Status:" + ((j)localObject2).rVU + ", FileName:" + ((j)localObject2).CqQ + ", FileMd5:" + ((j)localObject2).CqS + ", DownloadPath:" + ((j)localObject2).CqT + ", errorCode:" + ((j)localObject2).errorCode + ", Imei:" + ((j)localObject2).CqG + ", Oaid:" + ((j)localObject2).CqF + ", Xid:" + ((j)localObject2).CqE + ", VersionCode:" + ((j)localObject2).CqH + ", VersionName:" + ((j)localObject2).CqI + ", Model:" + ((j)localObject2).rVH + ", Manufacturer:" + ((j)localObject2).rWh);
    localObject1 = new d.a();
    ((d.a)localObject1).vD(4100);
    ((d.a)localObject1).TW("/cgi-bin/mmgame-bin/reportgameresourcedownload");
    ((d.a)localObject1).c((com.tencent.mm.cd.a)localObject2);
    ((d.a)localObject1).d((com.tencent.mm.cd.a)new k());
    ((d.a)localObject1).vF(0);
    ((d.a)localObject1).vG(0);
    aa.a(((d.a)localObject1).bgN(), (aa.a)a.CzM);
    AppMethodBeat.o(193181);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "errType", "errCode", "errMsg", "", "kotlin.jvm.PlatformType", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "callback"})
  static final class a
    implements aa.a
  {
    public static final a CzM;
    
    static
    {
      AppMethodBeat.i(202796);
      CzM = new a();
      AppMethodBeat.o(202796);
    }
    
    public final int a(int paramInt1, int paramInt2, String paramString, com.tencent.mm.an.d paramd, com.tencent.mm.an.q paramq)
    {
      AppMethodBeat.i(202795);
      Log.i("MicroMsg.GameResourceDownloadReporter", "report, errType = %d, errCode = %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      AppMethodBeat.o(202795);
      return 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.b.c
 * JD-Core Version:    0.7.0.1
 */