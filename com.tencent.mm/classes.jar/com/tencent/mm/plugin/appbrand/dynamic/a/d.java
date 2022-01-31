package com.tencent.mm.plugin.appbrand.dynamic.a;

import android.database.Cursor;
import android.util.Pair;
import com.tencent.mm.modelappbrand.w;
import com.tencent.mm.plugin.appbrand.a.c;
import com.tencent.mm.plugin.appbrand.appcache.am;
import com.tencent.mm.plugin.appbrand.appcache.am.a;
import com.tencent.mm.plugin.appbrand.appcache.an;
import com.tencent.mm.plugin.appbrand.appcache.ar;
import com.tencent.mm.plugin.appbrand.appcache.at;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public final class d
  implements com.tencent.mm.modelappbrand.g
{
  public final List<w> Jo()
  {
    Object localObject1 = null;
    Object localObject2 = ((c)com.tencent.mm.kernel.g.r(c.class)).aaG();
    if (localObject2 == null) {
      return Collections.EMPTY_LIST;
    }
    Object localObject3 = new StringBuilder("debugType");
    ((StringBuilder)localObject3).append(" = 10102");
    localObject3 = ((StringBuilder)localObject3).toString();
    localObject2 = ((ar)localObject2).fEC.a("AppBrandWxaPkgManifestRecord", null, (String)localObject3, null, null, null, null, 2);
    if (localObject2 == null) {}
    while ((localObject1 == null) || (((List)localObject1).isEmpty()))
    {
      return Collections.emptyList();
      if (!((Cursor)localObject2).moveToFirst())
      {
        ((Cursor)localObject2).close();
      }
      else
      {
        localObject1 = new ArrayList();
        do
        {
          localObject3 = new an();
          ((an)localObject3).d((Cursor)localObject2);
          ((List)localObject1).add(localObject3);
        } while (((Cursor)localObject2).moveToNext());
        ((Cursor)localObject2).close();
      }
    }
    localObject2 = new ArrayList(((List)localObject1).size());
    localObject1 = ((List)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject3 = (an)((Iterator)localObject1).next();
      w localw = new w();
      localw.bOL = ((an)localObject3).field_appId;
      localw.version = ((an)localObject3).field_version;
      localw.bIW = ((an)localObject3).field_versionMd5;
      ((List)localObject2).add(localw);
    }
    return localObject2;
  }
  
  public final boolean K(String paramString, int paramInt)
  {
    paramString = am.t(paramString, 10102, paramInt);
    return (paramString != null) && (paramString.first == am.a.fEc);
  }
  
  public final void a(String paramString1, int paramInt, String paramString2, String paramString3)
  {
    ((c)com.tencent.mm.kernel.g.r(c.class)).aaG().a(paramString1, 10102, paramInt, paramString2, paramString3);
  }
  
  public final boolean a(String paramString1, int paramInt, String paramString2, com.tencent.mm.modelappbrand.h paramh)
  {
    return at.b(paramString1, 10102, paramInt, paramString2, new d.1(this, paramh));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.dynamic.a.d
 * JD-Core Version:    0.7.0.1
 */