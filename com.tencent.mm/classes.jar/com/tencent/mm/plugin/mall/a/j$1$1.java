package com.tencent.mm.plugin.mall.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.wallet_core.model.mall.MallNews;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;
import com.tencent.mm.x.a;
import java.util.Map;

final class j$1$1
  implements Runnable
{
  j$1$1(j.1 param1, String paramString) {}
  
  public final void run()
  {
    AppMethodBeat.i(43116);
    com.tencent.mm.plugin.wallet_core.model.mall.c localc = com.tencent.mm.plugin.wallet_core.model.mall.c.cUX();
    Object localObject = this.gWF;
    MallNews localMallNews = com.tencent.mm.plugin.wallet_core.model.mall.c.afs((String)localObject);
    if (localMallNews != null)
    {
      if (!"2".equals(localMallNews.type))
      {
        localc.umy.put(localMallNews.ftd, localMallNews);
        ab.i("MicroMsg.MallNewsManager", "onRecieveMsg : ".concat(String.valueOf(localObject)));
        localc.cbo();
        if (com.tencent.mm.plugin.wallet_core.model.mall.c.a(localMallNews))
        {
          ab.i("MicroMsg.MallNewsManager", "set OutOfDateRedDot");
          AppMethodBeat.o(43116);
          return;
        }
        if (localMallNews.showType == 0)
        {
          ab.d("MicroMsg.MallNewsManager", "showType New");
          com.tencent.mm.x.c.PJ().x(262156, true);
          g.RM();
          g.RL().Ru().set(ac.a.yHf, Long.valueOf(System.currentTimeMillis()));
        }
        for (;;)
        {
          com.tencent.mm.plugin.wallet_core.model.mall.c.cUZ();
          AppMethodBeat.o(43116);
          return;
          if (localMallNews.showType == 1)
          {
            ab.d("MicroMsg.MallNewsManager", "showType Dot");
            com.tencent.mm.x.c.PJ().y(262156, true);
            g.RM();
            g.RL().Ru().set(ac.a.yHf, Long.valueOf(System.currentTimeMillis()));
          }
        }
      }
      ab.d("MicroMsg.MallNewsManager", "removeNews : ".concat(String.valueOf(localMallNews)));
      localObject = (MallNews)localc.umy.get(localMallNews.ftd);
      if ((localObject != null) && (((MallNews)localObject).sWB.equals(localMallNews.sWB)) && (((MallNews)localObject).crs.equals(localMallNews.crs)))
      {
        ab.i("MicroMsg.MallNewsManager", "onRecieveMsg remove : " + localMallNews.ftd);
        localc.umy.remove(localMallNews.ftd);
        AppMethodBeat.o(43116);
        return;
      }
      ab.i("MicroMsg.MallNewsManager", "onRecieveMsg cancel not found!");
    }
    AppMethodBeat.o(43116);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.mall.a.j.1.1
 * JD-Core Version:    0.7.0.1
 */