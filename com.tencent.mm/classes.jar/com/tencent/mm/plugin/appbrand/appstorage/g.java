package com.tencent.mm.plugin.appbrand.appstorage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.file.at;
import com.tencent.mm.plugin.appbrand.jsapi.video.AppBrandVideoDownLoadMgr;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.aa;
import com.tencent.mm.vfs.o;
import com.tencent.mm.vfs.q;
import com.tencent.mm.vfs.s;
import java.util.concurrent.TimeUnit;

public final class g
{
  public static final Runnable kSf;
  private static final long kSg;
  private static final long kSh;
  
  static
  {
    AppMethodBeat.i(44454);
    kSf = new Runnable()
    {
      private void p(o paramAnonymouso)
      {
        int i = 0;
        AppMethodBeat.i(174713);
        if ((!paramAnonymouso.exists()) || (!paramAnonymouso.isDirectory()))
        {
          AppMethodBeat.o(174713);
          return;
        }
        if (s.YS(aa.z(paramAnonymouso.her()) + "/dir.lock"))
        {
          if (Util.nowMilliSecond() - new o(aa.z(paramAnonymouso.her()) + "/dir.lock").lastModified() < g.kSh)
          {
            Log.d("MicroMsg.AppBrandLocalMediaPruner", "pruneAppDir dirName %s, locked", new Object[] { paramAnonymouso.getName() });
            AppMethodBeat.o(174713);
            return;
          }
          Log.e("MicroMsg.AppBrandLocalMediaPruner", "pruneAppDir dirName %s, lock expired", new Object[] { paramAnonymouso.getName() });
        }
        Log.d("MicroMsg.AppBrandLocalMediaPruner", "pruneAppDir dirName %s, lock free", new Object[] { paramAnonymouso.getName() });
        paramAnonymouso = paramAnonymouso.a(new q()
        {
          public final boolean accept(o paramAnonymous2o)
          {
            AppMethodBeat.i(174712);
            if ((!paramAnonymous2o.getName().endsWith(".data")) && (!paramAnonymous2o.getName().startsWith("store_")) && (!paramAnonymous2o.getName().endsWith(".nomedia")))
            {
              AppMethodBeat.o(174712);
              return true;
            }
            AppMethodBeat.o(174712);
            return false;
          }
        });
        if ((paramAnonymouso == null) || (paramAnonymouso.length <= 0))
        {
          AppMethodBeat.o(174713);
          return;
        }
        long l = Util.nowMilliSecond();
        int j = paramAnonymouso.length;
        while (i < j)
        {
          Object localObject = paramAnonymouso[i];
          if (l - localObject.lastModified() >= g.kSg) {
            s.deleteFile(aa.z(localObject.her()));
          }
          i += 1;
        }
        AppMethodBeat.o(174713);
      }
      
      public final void run()
      {
        int j = 0;
        AppMethodBeat.i(44452);
        Object localObject = new o(at.bGo());
        if ((!((o)localObject).exists()) || (!((o)localObject).isDirectory()))
        {
          AppMethodBeat.o(44452);
          return;
        }
        localObject = ((o)localObject).het();
        if ((localObject == null) || (localObject.length <= 0))
        {
          AppMethodBeat.o(44452);
          return;
        }
        int k = localObject.length;
        int i = 0;
        while (i < k)
        {
          p(localObject[i]);
          i += 1;
        }
        localObject = new o(AppBrandVideoDownLoadMgr.mvD);
        if ((!((o)localObject).exists()) || (!((o)localObject).isDirectory()))
        {
          AppMethodBeat.o(44452);
          return;
        }
        localObject = ((o)localObject).het();
        if ((localObject == null) || (localObject.length <= 0))
        {
          AppMethodBeat.o(44452);
          return;
        }
        k = localObject.length;
        i = j;
        while (i < k)
        {
          p(localObject[i]);
          i += 1;
        }
        AppMethodBeat.o(44452);
      }
    };
    kSg = TimeUnit.MINUTES.toMillis(30L);
    kSh = TimeUnit.DAYS.toMillis(1L);
    AppMethodBeat.o(44454);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appstorage.g
 * JD-Core Version:    0.7.0.1
 */