package com.tencent.mm.plugin.appbrand.appusage;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.al;
import com.tencent.mm.plugin.appbrand.app.j;
import com.tencent.mm.plugin.appbrand.appcache.bf;
import com.tencent.mm.sdk.e.f;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.ah.a;
import com.tencent.mm.vfs.i;
import com.tencent.mm.vfs.q;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class r
  extends al
{
  public final String getTag()
  {
    return "AppBrandPluginCodeCodeCacheTransfer";
  }
  
  public final boolean nP(int paramInt)
  {
    AppMethodBeat.i(186341);
    boolean bool = g.agR().agA().getBoolean(ah.a.GJv, false);
    com.tencent.mm.sdk.platformtools.ac.d("AppBrandPluginCodeCodeCacheTransfer", "needTransfer doneIssue %b", new Object[] { Boolean.valueOf(bool) });
    if (!bool)
    {
      AppMethodBeat.o(186341);
      return true;
    }
    AppMethodBeat.o(186341);
    return false;
  }
  
  public final void transfer(int paramInt)
  {
    AppMethodBeat.i(186340);
    try
    {
      localObject1 = j.aVC().joN.a(String.format("select distinct %s from %s where %s like '%%$%s' ", new Object[] { "appId", "AppBrandWxaPkgManifestRecord", "appId", "__PLUGINCODE__" }), null, 2);
      ArrayList localArrayList = new ArrayList();
      while (((Cursor)localObject1).moveToNext()) {
        localArrayList.add(((Cursor)localObject1).getString(0));
      }
      ((Cursor)localObject1).close();
    }
    catch (Exception localException)
    {
      com.tencent.mm.sdk.platformtools.ac.printErrStackTrace("AppBrandPluginCodeCodeCacheTransfer", localException, "transfer failed", new Object[0]);
      AppMethodBeat.o(186340);
      return;
    }
    if ((bs.gY(localException)) || (localException.size() <= 0))
    {
      com.tencent.mm.sdk.platformtools.ac.i("AppBrandPluginCodeCodeCacheTransfer", "no need to transfer pluginAppIdList :%d", new Object[] { Integer.valueOf(localException.size()) });
      g.agR().agA().set(ah.a.GJv, Boolean.TRUE);
      AppMethodBeat.o(186340);
      return;
    }
    Object localObject1 = new com.tencent.mm.vfs.e(com.tencent.mm.plugin.appbrand.jsruntime.ac.bdS()).fxX();
    int i = localObject1.length;
    paramInt = 0;
    for (;;)
    {
      if (paramInt < i)
      {
        Object localObject2 = localObject1[paramInt];
        if (localObject2.isDirectory())
        {
          String str1 = localObject2.getName();
          com.tencent.mm.sdk.platformtools.ac.d("AppBrandPluginCodeCodeCacheTransfer", "fileName:%s", new Object[] { str1 });
          if (!bs.isNullOrNil(str1))
          {
            Iterator localIterator = localException.iterator();
            String str2;
            do
            {
              if (!localIterator.hasNext()) {
                break;
              }
              str2 = (String)localIterator.next();
            } while (!str1.startsWith(str2.substring(0, str2.indexOf("$"))));
            boolean bool = localObject2.delete();
            if (localObject2.isDirectory()) {
              bool = i.cU(q.B(localObject2.mUri), true);
            }
            for (;;)
            {
              com.tencent.mm.sdk.platformtools.ac.d("AppBrandPluginCodeCodeCacheTransfer", "delete file:%s ret:%b", new Object[] { str1, Boolean.valueOf(bool) });
              break;
              if (localObject2.isFile()) {
                bool = localObject2.delete();
              }
            }
          }
        }
      }
      else
      {
        g.agR().agA().set(ah.a.GJv, Boolean.TRUE);
        AppMethodBeat.o(186340);
        return;
      }
      paramInt += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appusage.r
 * JD-Core Version:    0.7.0.1
 */