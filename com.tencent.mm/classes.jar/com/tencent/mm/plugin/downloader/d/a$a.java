package com.tencent.mm.plugin.downloader.d;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.mm.game.report.api.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.downloader.model.c;
import com.tencent.mm.plugin.downloader.model.d;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.y;
import java.util.Iterator;
import java.util.LinkedList;

final class a$a
  extends BroadcastReceiver
{
  public final void onReceive(Context paramContext, Intent paramIntent)
  {
    if ((!g.DK()) || (com.tencent.mm.kernel.a.CW())) {
      y.e("MicroMsg.Downloader.NetWorkManager", "acc has not ready");
    }
    for (;;)
    {
      return;
      int i = aq.getNetType(ae.getContext());
      if (i != a.access$100())
      {
        a.pF(i);
        y.i("MicroMsg.Downloader.NetWorkManager", "onNetStateChange, netState = " + i);
        if (!aq.isConnected(paramContext))
        {
          y.w("MicroMsg.Downloader.NetWorkManager", "network is not connected");
          return;
        }
        com.tencent.mm.plugin.downloader.f.a locala;
        long l;
        if (aq.isWifi(i))
        {
          paramContext = c.aFO();
          if (paramContext != null)
          {
            paramContext = paramContext.iterator();
            while (paramContext.hasNext())
            {
              locala = (com.tencent.mm.plugin.downloader.f.a)paramContext.next();
              y.i("MicroMsg.Downloader.NetWorkManager", "resumeTask, appId = %s, state = %d", new Object[] { locala.field_appId, Integer.valueOf(locala.field_status) });
              if (locala.field_status == 2)
              {
                paramIntent = d.aFP();
                l = locala.field_downloadId;
                locala = c.dk(l);
                if ((locala != null) && (locala.field_downloaderType == 3))
                {
                  paramIntent = paramIntent.aFU();
                  b.dCw.a(l, new com.tencent.mm.game.report.api.a(14));
                  paramIntent.k(l, true);
                }
                else
                {
                  paramIntent = paramIntent.aFT();
                  b.dCw.a(l, new com.tencent.mm.game.report.api.a(14));
                  paramIntent.k(l, true);
                }
              }
            }
          }
        }
        else
        {
          paramContext = c.aFN();
          if (paramContext != null)
          {
            paramContext = paramContext.iterator();
            while (paramContext.hasNext())
            {
              locala = (com.tencent.mm.plugin.downloader.f.a)paramContext.next();
              y.i("MicroMsg.Downloader.NetWorkManager", "pauseTask, appId: " + locala.field_appId);
              paramIntent = d.aFP();
              l = locala.field_downloadId;
              locala = c.dk(l);
              if ((locala != null) && (locala.field_downloaderType == 3))
              {
                paramIntent.aFU().iH(l);
              }
              else
              {
                paramIntent = paramIntent.aFT();
                b.dCw.a(l, new com.tencent.mm.game.report.api.a(13));
                paramIntent.de(l);
              }
            }
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader.d.a.a
 * JD-Core Version:    0.7.0.1
 */