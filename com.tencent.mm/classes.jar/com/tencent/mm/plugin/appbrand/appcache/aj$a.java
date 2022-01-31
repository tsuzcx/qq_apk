package com.tencent.mm.plugin.appbrand.appcache;

import android.net.Uri;
import android.os.HandlerThread;
import com.tencent.mm.ah.p;
import com.tencent.mm.j.f.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.network.e;
import com.tencent.mm.plugin.appbrand.u.k;
import com.tencent.mm.pluginsdk.g.a.c.l;
import com.tencent.mm.pluginsdk.g.a.c.m;
import com.tencent.mm.sdk.platformtools.am;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

final class aj$a
{
  public final m a(aj.c paramc)
  {
    String str1 = paramc.cls();
    y.i("MicroMsg.AppBrand.CdnHttpsDownloadPerformer", "downloadUsingCDN, url %s", new Object[] { paramc.fDR });
    for (;;)
    {
      try
      {
        CountDownLatch localCountDownLatch = new CountDownLatch(1);
        k localk = new k();
        com.tencent.mm.plugin.appbrand.appcache.a.a locala = paramc.aca();
        String str2 = locala.rVT;
        Object localObject1 = paramc.fDS;
        if (paramc.aca().fES)
        {
          localObject1 = new am(com.tencent.mm.cg.a.cxw().getLooper(), new aj.a.1(this, str2, (t.a)localObject1, locala, localk, localCountDownLatch), false);
          Object localObject2 = new aj.a.2(this, paramc, (am)localObject1, localk, localCountDownLatch);
          paramc = new com.tencent.mm.j.f();
          paramc.field_mediaId = str2;
          paramc.field_fullpath = locala.bjl();
          paramc.dlQ = locala.url;
          paramc.ceg = false;
          paramc.dlP = ((f.a)localObject2);
          paramc.dlR = ((int)TimeUnit.MILLISECONDS.toSeconds(locala.getConnectTimeout()));
          paramc.dlS = ((int)TimeUnit.MILLISECONDS.toSeconds(locala.getReadTimeout()));
          paramc.field_fileType = com.tencent.mm.j.a.dlx;
          if ((locala instanceof f)) {
            paramc.dlU = false;
          }
          str2 = Uri.parse(paramc.dlQ).getHost();
          if (!bk.bl(str2)) {
            localObject2 = new ArrayList();
          }
          try
          {
            g.DO().dJT.edx.getHostByName(str2, (List)localObject2);
            paramc.dlT = new String[((ArrayList)localObject2).size()];
            ((ArrayList)localObject2).toArray(paramc.dlT);
            com.tencent.mm.ak.f.Nd().b(paramc, -1);
            if (localObject1 != null)
            {
              long l = locala.getReadTimeout();
              ((am)localObject1).S(l, l);
            }
          }
          catch (Exception localException)
          {
            try
            {
              localCountDownLatch.await();
              return (m)localk.value;
            }
            catch (Exception paramc)
            {
              y.e("MicroMsg.AppBrand.CdnHttpsDownloadPerformer", "cdn https perform, urlKey %s semaphore await e = %s", new Object[] { str1, paramc });
              return null;
            }
            localException = localException;
            y.e("MicroMsg.AppBrand.CdnHttpsDownloadPerformer", "cdn https getHostByName e = %s", new Object[] { localException });
            continue;
          }
        }
        localObject1 = null;
      }
      catch (Exception paramc)
      {
        y.e("MicroMsg.AppBrand.CdnHttpsDownloadPerformer", "cdn https perform urlKey %s exp %s", new Object[] { str1, paramc });
        return null;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.aj.a
 * JD-Core Version:    0.7.0.1
 */