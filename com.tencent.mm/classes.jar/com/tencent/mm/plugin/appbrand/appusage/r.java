package com.tencent.mm.plugin.appbrand.appusage;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.am;
import com.tencent.mm.plugin.appbrand.app.j;
import com.tencent.mm.plugin.appbrand.appcache.bg;
import com.tencent.mm.plugin.appbrand.jsruntime.ac;
import com.tencent.mm.sdk.e.f;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.al.a;
import com.tencent.mm.vfs.i;
import com.tencent.mm.vfs.q;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class r
  extends am
{
  public final String getTag()
  {
    return "AppBrandPluginCodeCodeCacheTransfer";
  }
  
  public final boolean op(int paramInt)
  {
    AppMethodBeat.i(188033);
    boolean bool = g.ajC().ajl().getBoolean(al.a.IvN, false);
    ad.d("AppBrandPluginCodeCodeCacheTransfer", "needTransfer doneIssue %b", new Object[] { Boolean.valueOf(bool) });
    if (!bool)
    {
      AppMethodBeat.o(188033);
      return true;
    }
    AppMethodBeat.o(188033);
    return false;
  }
  
  public final void transfer(int paramInt)
  {
    AppMethodBeat.i(188032);
    try
    {
      localObject1 = j.aYX().jIJ.a(String.format("select distinct %s from %s where %s like '%%$%s' ", new Object[] { "appId", "AppBrandWxaPkgManifestRecord", "appId", "__PLUGINCODE__" }), null, 2);
      ArrayList localArrayList = new ArrayList();
      while (((Cursor)localObject1).moveToNext()) {
        localArrayList.add(((Cursor)localObject1).getString(0));
      }
      ((Cursor)localObject1).close();
    }
    catch (Exception localException)
    {
      ad.printErrStackTrace("AppBrandPluginCodeCodeCacheTransfer", localException, "transfer failed", new Object[0]);
      AppMethodBeat.o(188032);
      return;
    }
    if ((bt.hj(localException)) || (localException.size() <= 0))
    {
      ad.i("AppBrandPluginCodeCodeCacheTransfer", "no need to transfer pluginAppIdList :%d", new Object[] { Integer.valueOf(localException.size()) });
      g.ajC().ajl().set(al.a.IvN, Boolean.TRUE);
      AppMethodBeat.o(188032);
      return;
    }
    Object localObject1 = new com.tencent.mm.vfs.e(ac.bhw()).fOM();
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
          ad.d("AppBrandPluginCodeCodeCacheTransfer", "fileName:%s", new Object[] { str1 });
          if (!bt.isNullOrNil(str1))
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
              bool = i.cZ(q.B(localObject2.mUri), true);
            }
            for (;;)
            {
              ad.d("AppBrandPluginCodeCodeCacheTransfer", "delete file:%s ret:%b", new Object[] { str1, Boolean.valueOf(bool) });
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
        g.ajC().ajl().set(al.a.IvN, Boolean.TRUE);
        AppMethodBeat.o(188032);
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