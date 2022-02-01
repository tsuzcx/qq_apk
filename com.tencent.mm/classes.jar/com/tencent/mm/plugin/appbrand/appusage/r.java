package com.tencent.mm.plugin.appbrand.appusage;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.al;
import com.tencent.mm.plugin.appbrand.app.j;
import com.tencent.mm.plugin.appbrand.appcache.bf;
import com.tencent.mm.plugin.appbrand.jsruntime.ac;
import com.tencent.mm.sdk.e.f;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.ae.a;
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
  
  public final boolean nb(int paramInt)
  {
    AppMethodBeat.i(195627);
    boolean bool = g.afB().afk().getBoolean(ae.a.FlG, false);
    ad.d("AppBrandPluginCodeCodeCacheTransfer", "needTransfer doneIssue %b", new Object[] { Boolean.valueOf(bool) });
    if (!bool)
    {
      AppMethodBeat.o(195627);
      return true;
    }
    AppMethodBeat.o(195627);
    return false;
  }
  
  public final void transfer(int paramInt)
  {
    AppMethodBeat.i(195626);
    try
    {
      localObject1 = j.aOK().iOE.a(String.format("select distinct %s from %s where %s like '%%$%s' ", new Object[] { "appId", "AppBrandWxaPkgManifestRecord", "appId", "__PLUGINCODE__" }), null, 2);
      ArrayList localArrayList = new ArrayList();
      while (((Cursor)localObject1).moveToNext()) {
        localArrayList.add(((Cursor)localObject1).getString(0));
      }
      ((Cursor)localObject1).close();
    }
    catch (Exception localException)
    {
      ad.printErrStackTrace("AppBrandPluginCodeCodeCacheTransfer", localException, "transfer failed", new Object[0]);
      AppMethodBeat.o(195626);
      return;
    }
    if ((bt.gL(localException)) || (localException.size() <= 0))
    {
      ad.i("AppBrandPluginCodeCodeCacheTransfer", "no need to transfer pluginAppIdList :%d", new Object[] { Integer.valueOf(localException.size()) });
      g.afB().afk().set(ae.a.FlG, Boolean.TRUE);
      AppMethodBeat.o(195626);
      return;
    }
    Object localObject1 = new com.tencent.mm.vfs.e(ac.aWU()).fhW();
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
              bool = i.cO(q.B(localObject2.mUri), true);
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
        g.afB().afk().set(ae.a.FlG, Boolean.TRUE);
        AppMethodBeat.o(195626);
        return;
      }
      paramInt += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appusage.r
 * JD-Core Version:    0.7.0.1
 */