package com.tencent.mm.plugin.appbrand.dynamic.a;

import android.database.Cursor;
import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelappbrand.h;
import com.tencent.mm.modelappbrand.x;
import com.tencent.mm.plugin.appbrand.appcache.as;
import com.tencent.mm.plugin.appbrand.appcache.as.a;
import com.tencent.mm.plugin.appbrand.appcache.at;
import com.tencent.mm.plugin.appbrand.appcache.ay;
import com.tencent.mm.plugin.appbrand.appcache.ba;
import com.tencent.mm.sdk.e.f;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public final class d
  implements com.tencent.mm.modelappbrand.g
{
  public final boolean S(String paramString, int paramInt)
  {
    AppMethodBeat.i(10759);
    paramString = as.F(paramString, 10102, paramInt);
    if ((paramString != null) && (paramString.first == as.a.gWs))
    {
      AppMethodBeat.o(10759);
      return true;
    }
    AppMethodBeat.o(10759);
    return false;
  }
  
  public final void a(String paramString1, int paramInt, String paramString2, String paramString3)
  {
    AppMethodBeat.i(10757);
    ((com.tencent.mm.plugin.appbrand.a.d)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.appbrand.a.d.class)).we().a(paramString1, 10102, paramInt, paramString2, paramString3);
    AppMethodBeat.o(10757);
  }
  
  public final boolean a(String paramString1, int paramInt, String paramString2, h paramh)
  {
    AppMethodBeat.i(10758);
    boolean bool = ba.b(paramString1, 10102, paramInt, paramString2, new d.1(this, paramh));
    AppMethodBeat.o(10758);
    return bool;
  }
  
  public final List<x> acm()
  {
    Object localObject1 = null;
    AppMethodBeat.i(10760);
    Object localObject2 = ((com.tencent.mm.plugin.appbrand.a.d)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.appbrand.a.d.class)).we();
    if (localObject2 == null)
    {
      localObject1 = Collections.EMPTY_LIST;
      AppMethodBeat.o(10760);
      return localObject1;
    }
    Object localObject3 = new StringBuilder("debugType");
    ((StringBuilder)localObject3).append(" = 10102");
    localObject3 = ((StringBuilder)localObject3).toString();
    localObject2 = ((ay)localObject2).gWU.a("AppBrandWxaPkgManifestRecord", null, (String)localObject3, null, null, null, null, 2);
    if (localObject2 == null) {}
    while ((localObject1 == null) || (((List)localObject1).isEmpty()))
    {
      localObject1 = Collections.emptyList();
      AppMethodBeat.o(10760);
      return localObject1;
      if (!((Cursor)localObject2).moveToFirst())
      {
        ((Cursor)localObject2).close();
      }
      else
      {
        localObject1 = new ArrayList();
        do
        {
          localObject3 = new at();
          ((at)localObject3).convertFrom((Cursor)localObject2);
          ((List)localObject1).add(localObject3);
        } while (((Cursor)localObject2).moveToNext());
        ((Cursor)localObject2).close();
      }
    }
    localObject2 = new ArrayList(((List)localObject1).size());
    localObject1 = ((List)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject3 = (at)((Iterator)localObject1).next();
      x localx = new x();
      localx.cwc = ((at)localObject3).field_appId;
      localx.version = ((at)localObject3).field_version;
      localx.cqq = ((at)localObject3).field_versionMd5;
      ((List)localObject2).add(localx);
    }
    AppMethodBeat.o(10760);
    return localObject2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.dynamic.a.d
 * JD-Core Version:    0.7.0.1
 */