package com.tencent.mm.plugin.downloader_app.b;

import com.tencent.mm.ah.b.a;
import com.tencent.mm.ah.b.c;
import com.tencent.mm.ah.m;
import com.tencent.mm.ah.w;
import com.tencent.mm.ah.w.a;
import com.tencent.mm.ipcinvoker.l;
import com.tencent.mm.plugin.downloader.e.c;
import com.tencent.mm.plugin.downloader_app.detail.d;
import com.tencent.mm.plugin.game.commlib.a.a;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.util.LinkedList;

public final class g
{
  static f iSo;
  
  public static void a(LinkedList<String> paramLinkedList, g.a parama)
  {
    b.a locala = new b.a();
    com.tencent.mm.plugin.downloader.e.b localb = new com.tencent.mm.plugin.downloader.e.b();
    localb.iPZ = paramLinkedList;
    localb.iQb = true;
    locala.ecH = localb;
    locala.ecI = new c();
    locala.uri = "/cgi-bin/mmgame-bin/batchgetappdownloadinfo";
    locala.ecG = 7797;
    w.a(locala.Kt(), new w.a()
    {
      public final int a(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, com.tencent.mm.ah.b paramAnonymousb, m paramAnonymousm)
      {
        y.i("MicroMsg.PbAppInfoManager", "errType = %d, errCode = %d", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2) });
        if ((paramAnonymousInt1 == 0) && (paramAnonymousInt2 == 0))
        {
          g.iSo = new f((c)paramAnonymousb.ecF.ecN);
          l.post(new Runnable()
          {
            public final void run()
            {
              String str = g.iSo.iSn;
              if (!bk.bl(str)) {
                d.zV(str);
              }
            }
          });
          if (this.iSp != null) {
            this.iSp.eR(true);
          }
        }
        while (this.iSp == null) {
          return 0;
        }
        this.iSp.eR(false);
        return 0;
      }
    });
  }
  
  public static f aGn()
  {
    if (iSo == null)
    {
      byte[] arrayOfByte = ((a)com.tencent.mm.kernel.g.r(a.class)).Ey("pb_appinfo");
      if (arrayOfByte != null)
      {
        iSo = new f(arrayOfByte);
        l.post(new Runnable()
        {
          public final void run()
          {
            String str = g.iSo.iSn;
            if (!bk.bl(str)) {
              d.zV(str);
            }
          }
        });
      }
    }
    return iSo;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader_app.b.g
 * JD-Core Version:    0.7.0.1
 */