package com.tencent.mm.plugin.appbrand.appusage;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ao;
import com.tencent.mm.plugin.appbrand.app.j;
import com.tencent.mm.plugin.appbrand.appcache.bh;
import com.tencent.mm.plugin.appbrand.jsruntime.ad;
import com.tencent.mm.sdk.e.f;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.am.a;
import com.tencent.mm.vfs.k;
import com.tencent.mm.vfs.o;
import com.tencent.mm.vfs.w;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class r
  extends ao
{
  public final String getTag()
  {
    return "AppBrandPluginCodeCodeCacheTransfer";
  }
  
  public final boolean os(int paramInt)
  {
    AppMethodBeat.i(222152);
    boolean bool = g.ajR().ajA().getBoolean(am.a.IQl, false);
    ae.d("AppBrandPluginCodeCodeCacheTransfer", "needTransfer doneIssue %b", new Object[] { Boolean.valueOf(bool) });
    if (!bool)
    {
      AppMethodBeat.o(222152);
      return true;
    }
    AppMethodBeat.o(222152);
    return false;
  }
  
  public final void transfer(int paramInt)
  {
    AppMethodBeat.i(222151);
    try
    {
      localObject1 = j.aZu().jLK.a(String.format("select distinct %s from %s where %s like '%%$%s' ", new Object[] { "appId", "AppBrandWxaPkgManifestRecord", "appId", "__PLUGINCODE__" }), null, 2);
      ArrayList localArrayList = new ArrayList();
      while (((Cursor)localObject1).moveToNext()) {
        localArrayList.add(((Cursor)localObject1).getString(0));
      }
      ((Cursor)localObject1).close();
    }
    catch (Exception localException)
    {
      ae.printErrStackTrace("AppBrandPluginCodeCodeCacheTransfer", localException, "transfer failed", new Object[0]);
      AppMethodBeat.o(222151);
      return;
    }
    if ((bu.ht(localException)) || (localException.size() <= 0))
    {
      ae.i("AppBrandPluginCodeCodeCacheTransfer", "no need to transfer pluginAppIdList :%d", new Object[] { Integer.valueOf(localException.size()) });
      g.ajR().ajA().set(am.a.IQl, Boolean.TRUE);
      AppMethodBeat.o(222151);
      return;
    }
    Object localObject1 = new k(ad.bie()).fTj();
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
          ae.d("AppBrandPluginCodeCodeCacheTransfer", "fileName:%s", new Object[] { str1 });
          if (!bu.isNullOrNil(str1))
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
              bool = o.dd(w.B(localObject2.mUri), true);
            }
            for (;;)
            {
              ae.d("AppBrandPluginCodeCodeCacheTransfer", "delete file:%s ret:%b", new Object[] { str1, Boolean.valueOf(bool) });
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
        g.ajR().ajA().set(am.a.IQl, Boolean.TRUE);
        AppMethodBeat.o(222151);
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