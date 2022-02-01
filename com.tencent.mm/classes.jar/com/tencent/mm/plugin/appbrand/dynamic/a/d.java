package com.tencent.mm.plugin.appbrand.dynamic.a;

import android.database.Cursor;
import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelappbrand.i;
import com.tencent.mm.modelappbrand.j;
import com.tencent.mm.modelappbrand.x;
import com.tencent.mm.plugin.appbrand.a.e;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgIntegrityChecker;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgIntegrityChecker.a;
import com.tencent.mm.plugin.appbrand.appcache.bb;
import com.tencent.mm.plugin.appbrand.appcache.bf;
import com.tencent.mm.plugin.appbrand.appcache.bh;
import com.tencent.mm.plugin.appbrand.appcache.bh.a;
import com.tencent.mm.sdk.e.f;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public final class d
  implements i
{
  public final void a(String paramString1, int paramInt, String paramString2, String paramString3)
  {
    AppMethodBeat.i(121239);
    ((e)g.ab(e.class)).aVa().d(paramString1, 10102, paramInt, paramString2, paramString3);
    AppMethodBeat.o(121239);
  }
  
  public final boolean a(String paramString1, int paramInt, String paramString2, final j paramj)
  {
    AppMethodBeat.i(121240);
    boolean bool = bh.b(paramString1, 10102, paramInt, paramString2, new bh.a()
    {
      private long totalLen;
    });
    AppMethodBeat.o(121240);
    return bool;
  }
  
  public final List<x> aAD()
  {
    Object localObject1 = null;
    AppMethodBeat.i(121242);
    Object localObject2 = ((e)g.ab(e.class)).aVa();
    if (localObject2 == null)
    {
      localObject1 = Collections.EMPTY_LIST;
      AppMethodBeat.o(121242);
      return localObject1;
    }
    Object localObject3 = new StringBuilder("debugType");
    ((StringBuilder)localObject3).append(" = 10102");
    localObject3 = ((StringBuilder)localObject3).toString();
    localObject2 = ((bf)localObject2).joN.a("AppBrandWxaPkgManifestRecord", null, (String)localObject3, null, null, null, null, 2);
    if (localObject2 == null) {}
    while ((localObject1 == null) || (((List)localObject1).isEmpty()))
    {
      localObject1 = Collections.emptyList();
      AppMethodBeat.o(121242);
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
          localObject3 = new bb();
          ((bb)localObject3).convertFrom((Cursor)localObject2);
          ((List)localObject1).add(localObject3);
        } while (((Cursor)localObject2).moveToNext());
        ((Cursor)localObject2).close();
      }
    }
    localObject2 = new ArrayList(((List)localObject1).size());
    localObject1 = ((List)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject3 = (bb)((Iterator)localObject1).next();
      x localx = new x();
      localx.djj = ((bb)localObject3).field_appId;
      localx.version = ((bb)localObject3).field_version;
      localx.md5 = ((bb)localObject3).field_versionMd5;
      ((List)localObject2).add(localx);
    }
    AppMethodBeat.o(121242);
    return localObject2;
  }
  
  public final boolean ae(String paramString, int paramInt)
  {
    AppMethodBeat.i(121241);
    paramString = WxaPkgIntegrityChecker.B(paramString, 10102, paramInt);
    if ((paramString != null) && (paramString.first == WxaPkgIntegrityChecker.a.jop))
    {
      AppMethodBeat.o(121241);
      return true;
    }
    AppMethodBeat.o(121241);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.dynamic.a.d
 * JD-Core Version:    0.7.0.1
 */