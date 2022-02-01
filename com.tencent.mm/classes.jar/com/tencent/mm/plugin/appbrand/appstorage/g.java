package com.tencent.mm.plugin.appbrand.appstorage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.file.ar;
import com.tencent.mm.plugin.appbrand.jsapi.video.AppBrandVideoDownLoadMgr;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.vfs.e;
import com.tencent.mm.vfs.i;
import com.tencent.mm.vfs.q;
import java.util.concurrent.TimeUnit;

public final class g
{
  public static final Runnable jMl;
  private static final long jMm;
  private static final long jMn;
  
  static
  {
    AppMethodBeat.i(44454);
    jMl = new Runnable()
    {
      private void q(e paramAnonymouse)
      {
        int i = 0;
        AppMethodBeat.i(174713);
        if ((!paramAnonymouse.exists()) || (!paramAnonymouse.isDirectory()))
        {
          AppMethodBeat.o(174713);
          return;
        }
        if (i.fv(q.B(paramAnonymouse.fOK()) + "/dir.lock"))
        {
          if (bt.flT() - new e(q.B(paramAnonymouse.fOK()) + "/dir.lock").lastModified() < g.jMn)
          {
            ad.d("MicroMsg.AppBrandLocalMediaPruner", "pruneAppDir dirName %s, locked", new Object[] { paramAnonymouse.getName() });
            AppMethodBeat.o(174713);
            return;
          }
          ad.e("MicroMsg.AppBrandLocalMediaPruner", "pruneAppDir dirName %s, lock expired", new Object[] { paramAnonymouse.getName() });
        }
        ad.d("MicroMsg.AppBrandLocalMediaPruner", "pruneAppDir dirName %s, lock free", new Object[] { paramAnonymouse.getName() });
        paramAnonymouse = paramAnonymouse.a(new com.tencent.mm.vfs.g()
        {
          public final boolean accept(e paramAnonymous2e)
          {
            AppMethodBeat.i(174712);
            if ((!paramAnonymous2e.getName().endsWith(".data")) && (!paramAnonymous2e.getName().startsWith("store_")) && (!paramAnonymous2e.getName().endsWith(".nomedia")))
            {
              AppMethodBeat.o(174712);
              return true;
            }
            AppMethodBeat.o(174712);
            return false;
          }
        });
        if ((paramAnonymouse == null) || (paramAnonymouse.length <= 0))
        {
          AppMethodBeat.o(174713);
          return;
        }
        long l = bt.flT();
        int j = paramAnonymouse.length;
        while (i < j)
        {
          Object localObject = paramAnonymouse[i];
          if (l - localObject.lastModified() >= g.jMm) {
            i.deleteFile(q.B(localObject.fOK()));
          }
          i += 1;
        }
        AppMethodBeat.o(174713);
      }
      
      public final void run()
      {
        int j = 0;
        AppMethodBeat.i(44452);
        Object localObject = new e(ar.bkh());
        if ((!((e)localObject).exists()) || (!((e)localObject).isDirectory()))
        {
          AppMethodBeat.o(44452);
          return;
        }
        localObject = ((e)localObject).fOM();
        if ((localObject == null) || (localObject.length <= 0))
        {
          AppMethodBeat.o(44452);
          return;
        }
        int k = localObject.length;
        int i = 0;
        while (i < k)
        {
          q(localObject[i]);
          i += 1;
        }
        localObject = new e(AppBrandVideoDownLoadMgr.lkz);
        if ((!((e)localObject).exists()) || (!((e)localObject).isDirectory()))
        {
          AppMethodBeat.o(44452);
          return;
        }
        localObject = ((e)localObject).fOM();
        if ((localObject == null) || (localObject.length <= 0))
        {
          AppMethodBeat.o(44452);
          return;
        }
        k = localObject.length;
        i = j;
        while (i < k)
        {
          q(localObject[i]);
          i += 1;
        }
        AppMethodBeat.o(44452);
      }
    };
    jMm = TimeUnit.MINUTES.toMillis(30L);
    jMn = TimeUnit.DAYS.toMillis(1L);
    AppMethodBeat.o(44454);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appstorage.g
 * JD-Core Version:    0.7.0.1
 */