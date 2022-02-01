package com.tencent.mm.plugin.game.b;

import android.os.Build;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.p;
import com.tencent.mm.am.z;
import com.tencent.mm.compatible.deviceinfo.q;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.game.api.f;
import com.tencent.mm.plugin.game.autogen.a.j;
import com.tencent.mm.plugin.game.autogen.a.k;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import kotlin.Metadata;
import kotlin.g.b.s;
import kotlin.n.n;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/game/download/GameResourceDownloadReporter;", "", "()V", "STAGE_CANCEL_DOWNLOAD", "", "STAGE_FINISH_DOWNLOAD", "STAGE_START_DOWNLOAD", "STATUS_DOWNLOAD_FAIL", "STATUS_DOWNLOAD_SUCCESS", "TAG", "", "finishOneDownload", "", "packageName", "report", "downloadId", "", "plugin-game_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class c
{
  public static final c Itx;
  
  static
  {
    AppMethodBeat.i(275333);
    Itx = new c();
    AppMethodBeat.o(275333);
  }
  
  private static void aFR(String paramString)
  {
    AppMethodBeat.i(275329);
    ((f)h.ax(f.class)).fCm().aFU(paramString);
    b localb = b.Itw;
    b.aFO(paramString);
    AppMethodBeat.o(275329);
  }
  
  private static final int e(int paramInt1, int paramInt2, String paramString, com.tencent.mm.am.c paramc, p paramp)
  {
    AppMethodBeat.i(275331);
    Log.i("MicroMsg.GameResourceDownloadReporter", "report, errType = %d, errCode = %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    AppMethodBeat.o(275331);
    return 0;
  }
  
  public static void report(long paramLong)
  {
    AppMethodBeat.i(275328);
    Object localObject1 = com.tencent.mm.plugin.downloader.model.d.la(paramLong);
    if (localObject1 == null)
    {
      Log.i("MicroMsg.GameResourceDownloadReporter", "report, info is null");
      AppMethodBeat.o(275328);
      return;
    }
    if (((com.tencent.mm.plugin.downloader.f.a)localObject1).field_fileType != 3)
    {
      AppMethodBeat.o(275328);
      return;
    }
    int i;
    int j;
    switch (((com.tencent.mm.plugin.downloader.f.a)localObject1).field_status)
    {
    case 2: 
    default: 
      AppMethodBeat.o(275328);
      return;
    case 1: 
      i = 0;
      j = 3;
    }
    for (;;)
    {
      String str1 = Util.nullAsNil(((com.tencent.mm.plugin.downloader.f.a)localObject1).field_filePath);
      Object localObject2 = new j();
      ((j)localObject2).IcK = ((com.tencent.mm.plugin.downloader.f.a)localObject1).field_packageName;
      ((j)localObject2).IcS = j;
      ((j)localObject2).vhk = i;
      s.s(str1, "filePath");
      s.s(str1, "filePath");
      String str2 = str1.substring(n.g((CharSequence)str1, "/") + 1);
      s.s(str2, "(this as java.lang.String).substring(startIndex)");
      ((j)localObject2).IcZ = str2;
      ((j)localObject2).Ida = ((com.tencent.mm.plugin.downloader.f.a)localObject1).field_md5;
      s.s(str1, "filePath");
      s.s(str1, "filePath");
      str1 = str1.substring(0, n.g((CharSequence)str1, "/") + 1);
      s.s(str1, "(this as java.lang.Strin…ing(startIndex, endIndex)");
      ((j)localObject2).Idb = str1;
      ((j)localObject2).errorCode = ((com.tencent.mm.plugin.downloader.f.a)localObject1).field_errCode;
      ((j)localObject2).IcP = q.eD(false);
      ((j)localObject2).IcO = q.aPk();
      ((j)localObject2).IcN = "";
      ((j)localObject2).IcQ = String.valueOf(com.tencent.mm.plugin.game.d.c.aHj(((j)localObject2).IcK));
      ((j)localObject2).IcR = com.tencent.mm.plugin.game.d.c.aHk(((j)localObject2).IcK);
      ((j)localObject2).vgX = q.aPo();
      ((j)localObject2).vhx = Build.MANUFACTURER;
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("PackageName:").append(((j)localObject2).IcK).append(", Stage:").append(((j)localObject2).IcS).append(", Status:").append(((j)localObject2).vhk).append(", FileName:").append(((j)localObject2).IcZ).append(", FileMd5:").append(((j)localObject2).Ida).append(", DownloadPath:").append(((j)localObject2).Idb).append(", errorCode:").append(((j)localObject2).errorCode).append(", Imei:").append(((j)localObject2).IcP).append(", Oaid:").append(((j)localObject2).IcO).append(", Xid:").append(((j)localObject2).IcN).append(", VersionCode:").append(((j)localObject2).IcQ).append(", VersionName:");
      ((StringBuilder)localObject1).append(((j)localObject2).IcR).append(", Model:").append(((j)localObject2).vgX).append(", Manufacturer:").append(((j)localObject2).vhx);
      Log.i("MicroMsg.GameResourceDownloadReporter", ((StringBuilder)localObject1).toString());
      localObject1 = new c.a();
      ((c.a)localObject1).funcId = 4100;
      ((c.a)localObject1).uri = "/cgi-bin/mmgame-bin/reportgameresourcedownload";
      ((c.a)localObject1).otE = ((com.tencent.mm.bx.a)localObject2);
      ((c.a)localObject1).otF = ((com.tencent.mm.bx.a)new k());
      ((c.a)localObject1).otG = 0;
      ((c.a)localObject1).respCmdId = 0;
      z.a(((c.a)localObject1).bEF(), c..ExternalSyntheticLambda0.INSTANCE);
      AppMethodBeat.o(275328);
      return;
      localObject2 = ((com.tencent.mm.plugin.downloader.f.a)localObject1).field_packageName;
      s.s(localObject2, "info.field_packageName");
      aFR((String)localObject2);
      i = 0;
      j = 4;
      continue;
      i = 1;
      localObject2 = ((com.tencent.mm.plugin.downloader.f.a)localObject1).field_packageName;
      s.s(localObject2, "info.field_packageName");
      aFR((String)localObject2);
      j = 4;
      continue;
      localObject2 = ((com.tencent.mm.plugin.downloader.f.a)localObject1).field_packageName;
      s.s(localObject2, "info.field_packageName");
      aFR((String)localObject2);
      i = 0;
      j = 5;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.b.c
 * JD-Core Version:    0.7.0.1
 */