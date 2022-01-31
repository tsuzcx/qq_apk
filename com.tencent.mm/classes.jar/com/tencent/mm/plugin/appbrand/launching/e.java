package com.tencent.mm.plugin.appbrand.launching;

import android.database.Cursor;
import android.util.Pair;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.plugin.appbrand.appcache.a;
import com.tencent.mm.plugin.appbrand.appcache.ai;
import com.tencent.mm.plugin.appbrand.appcache.am;
import com.tencent.mm.plugin.appbrand.appcache.am.a;
import com.tencent.mm.plugin.appbrand.appcache.an;
import com.tencent.mm.plugin.appbrand.appcache.ar;
import com.tencent.mm.plugin.appbrand.appcache.s;
import com.tencent.mm.plugin.appbrand.u.d;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.io.Closeable;
import java.io.FileNotFoundException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import org.json.JSONArray;
import org.json.JSONObject;

public final class e
{
  static an a(s params, int paramInt, String paramString)
  {
    Object localObject1 = com.tencent.mm.plugin.appbrand.app.e.abb();
    if ((params == null) || (bk.bl(paramString)))
    {
      params = null;
      if (params == null) {
        break label261;
      }
      params = params.iterator();
    }
    for (;;)
    {
      if (params.hasNext())
      {
        localObject1 = (an)params.next();
        if (((an)localObject1).field_version == paramInt) {}
      }
      else
      {
        label261:
        try
        {
          if (!paramString.equals(((an)localObject1).field_versionMd5)) {
            continue;
          }
          boolean bool = paramString.equals(com.tencent.mm.a.g.b(com.tencent.mm.vfs.e.openRead(((an)localObject1).field_pkgPath), 4096));
          if (!bool) {
            continue;
          }
          return localObject1;
        }
        catch (FileNotFoundException localFileNotFoundException) {}
        Object localObject2 = String.format(Locale.US, "select * from %s where %s=? and %s=? and %s=? order by %s desc", new Object[] { "AppBrandWxaPkgManifestRecord", "appId", "debugType", "versionMd5", "version" });
        localObject1 = ((ar)localObject1).fEC.a((String)localObject2, new String[] { params.toString(), "0", paramString }, 0);
        if ((localObject1 == null) || (((Cursor)localObject1).isClosed()))
        {
          params = null;
          break;
        }
        if (!((Cursor)localObject1).moveToFirst())
        {
          ((Cursor)localObject1).close();
          params = null;
          break;
        }
        params = new LinkedList();
        do
        {
          localObject2 = new an();
          ((an)localObject2).d((Cursor)localObject1);
          params.add(localObject2);
        } while (((Cursor)localObject1).moveToNext());
        ((Cursor)localObject1).close();
        break;
        return null;
      }
    }
  }
  
  public static WxaPkgWrappingInfo aU(String paramString, int paramInt)
  {
    int[] arrayOfInt = com.tencent.mm.plugin.appbrand.app.e.abb().ri(paramString);
    if ((arrayOfInt != null) && (arrayOfInt.length > paramInt)) {}
    for (;;)
    {
      int i = paramInt + 1;
      Pair localPair = am.t(paramString, 0, arrayOfInt[paramInt]);
      if ((localPair.first == am.a.fEc) && (localPair.second != null)) {
        return (WxaPkgWrappingInfo)localPair.second;
      }
      if (i >= arrayOfInt.length) {
        return null;
      }
      paramInt = i;
    }
  }
  
  static boolean bO(String paramString1, String paramString2)
  {
    boolean bool = true;
    if ((bk.bl(paramString1)) || (!com.tencent.mm.vfs.e.bK(paramString1))) {
      return false;
    }
    ai localai = new ai(paramString1);
    if (!localai.abX())
    {
      localai.close();
      return false;
    }
    if (bk.bl(paramString2))
    {
      localai.close();
      return false;
    }
    paramString2 = a.qQ(com.tencent.luggage.j.g.bi(paramString2));
    Object localObject = localai.rb(paramString2);
    if (localObject != null) {
      bk.b((Closeable)localObject);
    }
    for (;;)
    {
      localai.close();
      return bool;
      localObject = d.convertStreamToString(localai.rb("app-config.json"));
      if (!bk.bl((String)localObject)) {
        try
        {
          localObject = com.tencent.mm.ab.h.fU((String)localObject).getJSONArray("pages");
          int i = 0;
          while (i < ((JSONArray)localObject).length())
          {
            String str = ((JSONArray)localObject).getString(i);
            if (!bk.bl(str))
            {
              bool = paramString2.startsWith(a.qQ(str));
              if (bool) {
                return true;
              }
            }
            i += 1;
          }
          bool = false;
        }
        catch (Exception localException)
        {
          y.e("MicroMsg.AppBrand.Launching.CheckPkgLogic", "isFilePathExistsInPkg, parse app-config.json, pkgPath(%s), queryPath(%s), e = %s", new Object[] { paramString1, paramString2, localException });
        }
      } else {
        bool = false;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.e
 * JD-Core Version:    0.7.0.1
 */