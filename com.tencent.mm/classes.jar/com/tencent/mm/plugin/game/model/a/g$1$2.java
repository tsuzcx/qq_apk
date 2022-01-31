package com.tencent.mm.plugin.game.model.a;

import com.tencent.mm.ah.b.a;
import com.tencent.mm.ah.w;
import com.tencent.mm.plugin.downloader.f.a;
import com.tencent.mm.protocal.c.oc;
import com.tencent.mm.protocal.c.od;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;

final class g$1$2
  implements Runnable
{
  g$1$2(g.1 param1) {}
  
  public final void run()
  {
    long l1 = 0L;
    Object localObject;
    String str;
    long l2;
    label76:
    int i;
    if (this.kRL.kRJ.field_isFirst)
    {
      localObject = ((com.tencent.mm.plugin.game.a.c)com.tencent.mm.kernel.g.r(com.tencent.mm.plugin.game.a.c.class)).aYh();
      str = this.kRL.kRJ.field_appId;
      if (bk.bl(str))
      {
        y.i("MicroMsg.GameSilentDownloadStorage", "updateFirstFlag: appid is null");
        l2 = this.kRL.kRJ.field_randomTime;
        if (l2 > 0L) {
          break label348;
        }
        ((com.tencent.mm.plugin.game.a.c)com.tencent.mm.kernel.g.r(com.tencent.mm.plugin.game.a.c.class)).aYh().F(this.kRL.kRJ.field_appId, l1);
        if (bk.UX() < l1) {
          break label408;
        }
        i = 1;
      }
    }
    for (;;)
    {
      if (i != 0)
      {
        localObject = this.kRL.kRK;
        str = this.kRL.kRJ.field_appId;
        y.i("MicroMsg.GameSilentDownloader", "source:%d, appid:%s", new Object[] { Integer.valueOf(1), str });
        b.a locala = new b.a();
        locala.ecG = 2819;
        locala.ecJ = 0;
        locala.ecK = 0;
        locala.uri = "/cgi-bin/mmgame-bin/checkappdownloadquota";
        oc localoc = new oc();
        localoc.swS = 1;
        localoc.euK = str;
        a locala1 = com.tencent.mm.plugin.downloader.model.c.zH(str);
        if (locala1 != null)
        {
          localoc.sww = locala1.field_downloadUrl;
          localoc.sLH = locala1.field_downloadedSize;
        }
        locala.ecH = localoc;
        locala.ecI = new od();
        w.a(locala.Kt(), new g.2((g)localObject, str));
      }
      return;
      y.i("MicroMsg.GameSilentDownloadStorage", "updateFirstFlag ret:%b", new Object[] { Boolean.valueOf(((f)localObject).gk("GameSilentDownload", String.format("update %s set %s=0 where %s='%s'", new Object[] { "GameSilentDownload", "isFirst", "appId", str }))) });
      break;
      label348:
      i = bk.fe((int)l2, 0);
      y.i("MicroMsg.GameSilentDownloader", "random time interval:%d", new Object[] { Integer.valueOf(i) });
      l1 = bk.UX();
      l1 = i + l1;
      break label76;
      if (bk.UX() >= this.kRL.kRJ.field_nextCheckTime) {
        i = 1;
      } else {
        label408:
        i = 0;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.game.model.a.g.1.2
 * JD-Core Version:    0.7.0.1
 */