package com.tencent.mm.plugin.mall.a;

import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.wallet_core.model.mall.MallNews;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;
import com.tencent.mm.y.a;
import java.util.Map;

final class f$1$1
  implements Runnable
{
  f$1$1(f.1 param1, String paramString) {}
  
  public final void run()
  {
    com.tencent.mm.plugin.wallet_core.model.mall.c localc = com.tencent.mm.plugin.wallet_core.model.mall.c.bWg();
    Object localObject = this.fEp;
    MallNews localMallNews = com.tencent.mm.plugin.wallet_core.model.mall.c.Qy((String)localObject);
    if (localMallNews != null)
    {
      if ("2".equals(localMallNews.type)) {
        break label184;
      }
      localc.qzO.put(localMallNews.ecR, localMallNews);
      y.i("MicroMsg.MallNewsManager", "onRecieveMsg : " + (String)localObject);
      localc.bsi();
      if (com.tencent.mm.plugin.wallet_core.model.mall.c.a(localMallNews)) {
        y.i("MicroMsg.MallNewsManager", "set OutOfDateRedDot");
      }
    }
    else
    {
      return;
    }
    if (localMallNews.showType == 0)
    {
      y.d("MicroMsg.MallNewsManager", "showType New");
      com.tencent.mm.y.c.BS().v(262156, true);
      g.DQ();
      g.DP().Dz().c(ac.a.uwW, Long.valueOf(System.currentTimeMillis()));
    }
    for (;;)
    {
      com.tencent.mm.plugin.wallet_core.model.mall.c.bWi();
      return;
      if (localMallNews.showType == 1)
      {
        y.d("MicroMsg.MallNewsManager", "showType Dot");
        com.tencent.mm.y.c.BS().w(262156, true);
        g.DQ();
        g.DP().Dz().c(ac.a.uwW, Long.valueOf(System.currentTimeMillis()));
      }
    }
    label184:
    y.d("MicroMsg.MallNewsManager", "removeNews : " + localMallNews);
    localObject = (MallNews)localc.qzO.get(localMallNews.ecR);
    if ((localObject != null) && (((MallNews)localObject).pva.equals(localMallNews.pva)) && (((MallNews)localObject).bJY.equals(localMallNews.bJY)))
    {
      y.i("MicroMsg.MallNewsManager", "onRecieveMsg remove : " + localMallNews.ecR);
      localc.qzO.remove(localMallNews.ecR);
      return;
    }
    y.i("MicroMsg.MallNewsManager", "onRecieveMsg cancel not found!");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.mall.a.f.1.1
 * JD-Core Version:    0.7.0.1
 */