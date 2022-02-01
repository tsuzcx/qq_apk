package com.tencent.mm.plugin.appbrand.appstorage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.file.at;
import com.tencent.mm.plugin.appbrand.jsapi.video.AppBrandVideoDownLoadMgr;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.vfs.k;
import com.tencent.mm.vfs.m;
import com.tencent.mm.vfs.o;
import com.tencent.mm.vfs.w;
import java.util.concurrent.TimeUnit;

public final class g
{
  public static final Runnable jPx;
  private static final long jPy;
  private static final long jPz;
  
  static
  {
    AppMethodBeat.i(44454);
    jPx = new Runnable()
    {
      private void q(k paramAnonymousk)
      {
        int i = 0;
        AppMethodBeat.i(174713);
        if ((!paramAnonymousk.exists()) || (!paramAnonymousk.isDirectory()))
        {
          AppMethodBeat.o(174713);
          return;
        }
        if (o.fB(w.B(paramAnonymousk.fTh()) + "/dir.lock"))
        {
          if (bu.fpO() - new k(w.B(paramAnonymousk.fTh()) + "/dir.lock").lastModified() < g.jPz)
          {
            ae.d("MicroMsg.AppBrandLocalMediaPruner", "pruneAppDir dirName %s, locked", new Object[] { paramAnonymousk.getName() });
            AppMethodBeat.o(174713);
            return;
          }
          ae.e("MicroMsg.AppBrandLocalMediaPruner", "pruneAppDir dirName %s, lock expired", new Object[] { paramAnonymousk.getName() });
        }
        ae.d("MicroMsg.AppBrandLocalMediaPruner", "pruneAppDir dirName %s, lock free", new Object[] { paramAnonymousk.getName() });
        paramAnonymousk = paramAnonymousk.a(new m()
        {
          public final boolean accept(k paramAnonymous2k)
          {
            AppMethodBeat.i(174712);
            if ((!paramAnonymous2k.getName().endsWith(".data")) && (!paramAnonymous2k.getName().startsWith("store_")) && (!paramAnonymous2k.getName().endsWith(".nomedia")))
            {
              AppMethodBeat.o(174712);
              return true;
            }
            AppMethodBeat.o(174712);
            return false;
          }
        });
        if ((paramAnonymousk == null) || (paramAnonymousk.length <= 0))
        {
          AppMethodBeat.o(174713);
          return;
        }
        long l = bu.fpO();
        int j = paramAnonymousk.length;
        while (i < j)
        {
          Object localObject = paramAnonymousk[i];
          if (l - localObject.lastModified() >= g.jPy) {
            o.deleteFile(w.B(localObject.fTh()));
          }
          i += 1;
        }
        AppMethodBeat.o(174713);
      }
      
      public final void run()
      {
        int j = 0;
        AppMethodBeat.i(44452);
        Object localObject = new k(at.bkQ());
        if ((!((k)localObject).exists()) || (!((k)localObject).isDirectory()))
        {
          AppMethodBeat.o(44452);
          return;
        }
        localObject = ((k)localObject).fTj();
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
        localObject = new k(AppBrandVideoDownLoadMgr.loX);
        if ((!((k)localObject).exists()) || (!((k)localObject).isDirectory()))
        {
          AppMethodBeat.o(44452);
          return;
        }
        localObject = ((k)localObject).fTj();
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
    jPy = TimeUnit.MINUTES.toMillis(30L);
    jPz = TimeUnit.DAYS.toMillis(1L);
    AppMethodBeat.o(44454);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appstorage.g
 * JD-Core Version:    0.7.0.1
 */