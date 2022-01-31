package com.tencent.mm.plugin.game.model.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.w;
import com.tencent.mm.plugin.downloader.g.a;
import com.tencent.mm.plugin.game.api.e;
import com.tencent.mm.protocal.protobuf.re;
import com.tencent.mm.protocal.protobuf.rf;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

final class h$1$2
  implements Runnable
{
  h$1$2(h.1 param1) {}
  
  public final void run()
  {
    long l1 = 0L;
    AppMethodBeat.i(111535);
    Object localObject;
    String str;
    long l2;
    label81:
    int i;
    if (this.npO.npM.field_isFirst)
    {
      localObject = ((e)com.tencent.mm.kernel.g.E(e.class)).bEU();
      str = this.npO.npM.field_appId;
      if (bo.isNullOrNil(str))
      {
        ab.i("MicroMsg.GameSilentDownloadStorage", "updateFirstFlag: appid is null");
        l2 = this.npO.npM.field_randomTime;
        if (l2 > 0L) {
          break label358;
        }
        ((e)com.tencent.mm.kernel.g.E(e.class)).bEU().X(this.npO.npM.field_appId, l1);
        if (bo.aox() < l1) {
          break label418;
        }
        i = 1;
      }
    }
    for (;;)
    {
      if (i != 0)
      {
        localObject = this.npO.npN;
        str = this.npO.npM.field_appId;
        ab.i("MicroMsg.GameSilentDownloader", "source:%d, appid:%s", new Object[] { Integer.valueOf(1), str });
        b.a locala = new b.a();
        locala.funcId = 2819;
        locala.reqCmdId = 0;
        locala.respCmdId = 0;
        locala.uri = "/cgi-bin/mmgame-bin/checkappdownloadquota";
        re localre = new re();
        localre.niK = 1;
        localre.fKw = str;
        a locala1 = com.tencent.mm.plugin.downloader.model.d.JD(str);
        if (locala1 != null)
        {
          localre.wxa = locala1.field_downloadUrl;
          localre.wJu = locala1.field_downloadedSize;
        }
        locala.fsX = localre;
        locala.fsY = new rf();
        w.a(locala.ado(), new h.2((h)localObject, str));
      }
      AppMethodBeat.o(111535);
      return;
      ab.i("MicroMsg.GameSilentDownloadStorage", "updateFirstFlag ret:%b", new Object[] { Boolean.valueOf(((g)localObject).execSQL("GameSilentDownload", String.format("update %s set %s=0 where %s='%s'", new Object[] { "GameSilentDownload", "isFirst", "appId", str }))) });
      break;
      label358:
      i = bo.hk((int)l2, 0);
      ab.i("MicroMsg.GameSilentDownloader", "random time interval:%d", new Object[] { Integer.valueOf(i) });
      l1 = bo.aox();
      l1 = i + l1;
      break label81;
      if (bo.aox() >= this.npO.npM.field_nextCheckTime) {
        i = 1;
      } else {
        label418:
        i = 0;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.game.model.a.h.1.2
 * JD-Core Version:    0.7.0.1
 */