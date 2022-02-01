package com.tencent.mm.plugin.appbrand.appusage;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.as;
import com.tencent.mm.plugin.appbrand.app.n;
import com.tencent.mm.plugin.appbrand.appcache.bh;
import com.tencent.mm.plugin.appbrand.m.ad;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.ISQLiteDatabaseEx;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.vfs.aa;
import com.tencent.mm.vfs.o;
import com.tencent.mm.vfs.s;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class r
  extends as
{
  public final String getTag()
  {
    return "AppBrandPluginCodeCodeCacheTransfer";
  }
  
  public final boolean rT(int paramInt)
  {
    AppMethodBeat.i(226392);
    boolean bool = g.aAh().azQ().getBoolean(ar.a.NYm, false);
    Log.d("AppBrandPluginCodeCodeCacheTransfer", "needTransfer doneIssue %b", new Object[] { Boolean.valueOf(bool) });
    if (!bool)
    {
      AppMethodBeat.o(226392);
      return true;
    }
    AppMethodBeat.o(226392);
    return false;
  }
  
  public final void transfer(int paramInt)
  {
    AppMethodBeat.i(226391);
    try
    {
      localObject1 = n.buL().kNJ.rawQuery(String.format("select distinct %s from %s where %s like '%%$%s' ", new Object[] { "appId", "AppBrandWxaPkgManifestRecord", "appId", "__PLUGINCODE__" }), null, 2);
      ArrayList localArrayList = new ArrayList();
      while (((Cursor)localObject1).moveToNext()) {
        localArrayList.add(((Cursor)localObject1).getString(0));
      }
      ((Cursor)localObject1).close();
    }
    catch (Exception localException)
    {
      Log.printErrStackTrace("AppBrandPluginCodeCodeCacheTransfer", localException, "transfer failed", new Object[0]);
      AppMethodBeat.o(226391);
      return;
    }
    if ((Util.isNullOrNil(localException)) || (localException.size() <= 0))
    {
      Log.i("AppBrandPluginCodeCodeCacheTransfer", "no need to transfer pluginAppIdList :%d", new Object[] { Integer.valueOf(localException.size()) });
      g.aAh().azQ().set(ar.a.NYm, Boolean.TRUE);
      AppMethodBeat.o(226391);
      return;
    }
    Object localObject1 = new o(ad.bDt()).het();
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
          Log.d("AppBrandPluginCodeCodeCacheTransfer", "fileName:%s", new Object[] { str1 });
          if (!Util.isNullOrNil(str1))
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
              bool = s.dy(aa.z(localObject2.mUri), true);
            }
            for (;;)
            {
              Log.d("AppBrandPluginCodeCodeCacheTransfer", "delete file:%s ret:%b", new Object[] { str1, Boolean.valueOf(bool) });
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
        g.aAh().azQ().set(ar.a.NYm, Boolean.TRUE);
        AppMethodBeat.o(226391);
        return;
      }
      paramInt += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appusage.r
 * JD-Core Version:    0.7.0.1
 */