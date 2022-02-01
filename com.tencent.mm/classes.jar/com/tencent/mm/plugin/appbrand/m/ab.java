package com.tencent.mm.plugin.appbrand.m;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appcache.bb;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storagebase.h;
import com.tencent.mm.vfs.f;
import com.tencent.mm.vfs.u;
import com.tencent.wcdb.database.SQLiteDatabase;
import com.tencent.wcdb.database.SQLiteException;
import com.tencent.wcdb.database.SQLiteStatement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.a.e;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.n.n;
import kotlin.t;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/jsruntime/V8CodeCacheCleanupLogic;", "", "()V", "IGNORE_DIR_NAME_LIST", "", "", "[Ljava/lang/String;", "TAG", "doCleanup", "", "compileStatement", "Lcom/tencent/wcdb/database/SQLiteStatement;", "Lcom/tencent/mm/storagebase/SqliteDB;", "sql", "isEmptyDirectory", "", "Lcom/tencent/mm/vfs/FileEntry;", "rootDir", "LIB_SCRIPT_HANDLER", "USER_SCRIPT_HANDLER", "plugin-appbrand-integration_release"})
public final class ab
{
  private static final String[] pOR;
  public static final ab pOS;
  
  static
  {
    AppMethodBeat.i(277341);
    pOS = new ab();
    pOR = new String[] { "page_scripts" };
    AppMethodBeat.o(277341);
  }
  
  private static SQLiteStatement b(h paramh, String paramString)
  {
    Object localObject = null;
    AppMethodBeat.i(277340);
    try
    {
      paramh = paramh.hBZ().compileStatement(paramString);
      AppMethodBeat.o(277340);
      return paramh;
    }
    catch (SQLiteException paramh)
    {
      for (;;)
      {
        Log.e("MicroMsg.AppBrand.V8CodeCacheCleanupLogic", "compileStatement with sql:" + paramString + ", get exception:" + paramh);
        paramh = localObject;
      }
    }
    catch (IllegalStateException paramh)
    {
      for (;;)
      {
        Log.e("MicroMsg.AppBrand.V8CodeCacheCleanupLogic", "compileStatement with sql:" + paramString + ", get exception:" + paramh);
        paramh = localObject;
      }
    }
  }
  
  public static final void bZa()
  {
    AppMethodBeat.i(277339);
    Object localObject1 = com.tencent.mm.plugin.appbrand.app.m.bFB();
    b localb;
    long l;
    int m;
    int i;
    int j;
    f localf;
    Object localObject2;
    if (localObject1 != null)
    {
      localObject1 = (h)localObject1;
      localb = new b((h)localObject1);
      a locala = new a((h)localObject1);
      l = Util.currentTicks();
      m = 0;
      i = 0;
      localObject1 = u.dP(ad.bOR(), false);
      if (localObject1 != null)
      {
        Iterator localIterator = ((Iterable)localObject1).iterator();
        j = 0;
        do
        {
          m = i;
          k = j;
          if (!localIterator.hasNext()) {
            break;
          }
          localf = (f)localIterator.next();
        } while ((!localf.YCj) || (e.contains(pOR, localf.name)));
        localObject1 = null;
        localObject2 = bb.nGr;
        m = localObject2.length;
        k = 0;
        while (k < m)
        {
          Object localObject3 = localObject2[k];
          if (!p.h(localObject3, localf.name))
          {
            p.j(localObject3, "name");
            String str = localf.name;
            p.j(str, "dir.name");
            if (!n.pu(localObject3, str)) {}
          }
          else
          {
            localObject1 = (kotlin.g.a.m)locala;
          }
          k += 1;
        }
      }
    }
    else
    {
      AppMethodBeat.o(277339);
      return;
      localObject2 = localObject1;
      if (localObject1 == null) {
        localObject2 = (kotlin.g.a.m)localb;
      }
      localObject1 = ad.bOR();
      p.j(localObject1, "V8CodeCachePathRetriever.retrieve()");
      p.j(localf, "dir");
      k = j + ((Number)((kotlin.g.a.m)localObject2).invoke(localObject1, localf)).intValue();
      localObject1 = ad.bOR();
      p.j(localObject1, "V8CodeCachePathRetriever.retrieve()");
      if (localf.YCj)
      {
        localObject1 = u.dP((String)localObject1 + "/" + localf.name, false);
        if (localObject1 != null)
        {
          localObject1 = j.p((Iterable)localObject1);
          label336:
          localObject1 = (Collection)localObject1;
          if ((localObject1 != null) && (!((Collection)localObject1).isEmpty())) {
            break label410;
          }
          j = 1;
          label360:
          if (j == 0) {
            break label415;
          }
        }
      }
      label410:
      label415:
      for (j = 1;; j = 0)
      {
        if (j != 0)
        {
          Log.i("MicroMsg.AppBrand.V8CodeCacheCleanupLogic", "delete relPath %s", new Object[] { localf.UUr });
          localf.cFq();
        }
        i += 1;
        j = k;
        break;
        localObject1 = null;
        break label336;
        j = 0;
        break label360;
      }
    }
    int k = 0;
    Log.i("MicroMsg.AppBrand.V8CodeCacheCleanupLogic", "doCleanup() cost:" + (Util.currentTicks() - l) + "ms, dirVisitedCount:" + m + ", fileDeletedCount:" + k);
    AppMethodBeat.o(277339);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/jsruntime/V8CodeCacheCleanupLogic$LIB_SCRIPT_HANDLER;", "Lkotlin/Function2;", "", "Lcom/tencent/mm/vfs/FileEntry;", "", "Lcom/tencent/mm/plugin/appbrand/jsruntime/CacheDirHandler;", "db", "Lcom/tencent/mm/storagebase/SqliteDB;", "(Lcom/tencent/mm/storagebase/SqliteDB;)V", "stmt", "Lcom/tencent/wcdb/database/SQLiteStatement;", "invoke", "rootDir", "dir", "(Ljava/lang/String;Lcom/tencent/mm/vfs/FileEntry;)Ljava/lang/Integer;", "plugin-appbrand-integration_release"})
  static final class a
    implements kotlin.g.a.m<String, f, Integer>
  {
    private final SQLiteStatement pOT;
    
    public a(h paramh)
    {
      AppMethodBeat.i(271462);
      ab localab = ab.pOS;
      this.pOT = ab.c(paramh, "SELECT COUNT(*) FROM AppBrandWxaPkgManifestRecord WHERE appId =? AND version=? ;");
      AppMethodBeat.o(271462);
    }
    
    private Integer a(String paramString, f paramf)
    {
      AppMethodBeat.i(271459);
      p.k(paramString, "rootDir");
      p.k(paramf, "dir");
      if (this.pOT == null)
      {
        AppMethodBeat.o(271459);
        return Integer.valueOf(0);
      }
      paramString = u.dP(paramString + "/" + paramf.name, false);
      int i;
      int j;
      if (paramString != null)
      {
        paramString = paramString.iterator();
        i = 0;
        j = i;
        if (!paramString.hasNext()) {
          break label259;
        }
        paramf = (f)paramString.next();
        try
        {
          Object localObject = paramf.name;
          p.j(localObject, "file.name");
          if (localObject != null) {
            break label218;
          }
          localObject = new t("null cannot be cast to non-null type java.lang.String");
          AppMethodBeat.o(271459);
          throw ((Throwable)localObject);
        }
        catch (NumberFormatException localNumberFormatException)
        {
          j = -1;
        }
        if ((j == -1) || (j == 0) || (j == 999) || (j == bb.VERSION)) {
          break label270;
        }
        this.pOT.bindString(1, "@LibraryAppId");
        this.pOT.bindLong(2, j);
      }
      label259:
      label270:
      for (;;)
      {
        try
        {
          l = this.pOT.simpleQueryForLong();
          if (l > 0L) {
            break label270;
          }
          paramf.cFq();
          i += 1;
          break;
          label218:
          String str = localNumberFormatException.substring(1);
          p.j(str, "(this as java.lang.String).substring(startIndex)");
          j = Integer.parseInt(str, kotlin.n.a.aFL(10));
        }
        catch (SQLiteException localSQLiteException)
        {
          long l = 0L;
          continue;
        }
        j = 0;
        AppMethodBeat.o(271459);
        return Integer.valueOf(j);
      }
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/jsruntime/V8CodeCacheCleanupLogic$USER_SCRIPT_HANDLER;", "Lkotlin/Function2;", "", "Lcom/tencent/mm/vfs/FileEntry;", "", "Lcom/tencent/mm/plugin/appbrand/jsruntime/CacheDirHandler;", "db", "Lcom/tencent/mm/storagebase/SqliteDB;", "(Lcom/tencent/mm/storagebase/SqliteDB;)V", "stmt", "Lcom/tencent/wcdb/database/SQLiteStatement;", "stmt2", "invoke", "rootDir", "dir", "(Ljava/lang/String;Lcom/tencent/mm/vfs/FileEntry;)Ljava/lang/Integer;", "plugin-appbrand-integration_release"})
  static final class b
    implements kotlin.g.a.m<String, f, Integer>
  {
    private final SQLiteStatement pOT;
    private final SQLiteStatement pOU;
    
    public b(h paramh)
    {
      AppMethodBeat.i(244051);
      ab localab = ab.pOS;
      this.pOT = ab.c(paramh, "SELECT COUNT(*) FROM AppBrandWxaPkgManifestRecord WHERE appId LIKE ? AND versionMd5=? ;");
      localab = ab.pOS;
      this.pOU = ab.c(paramh, "SELECT COUNT(*) FROM AppBrandWxaPkgManifestRecord WHERE appId LIKE ? AND NewMd5=? ;");
      AppMethodBeat.o(244051);
    }
    
    private Integer a(String paramString, f paramf)
    {
      AppMethodBeat.i(244046);
      p.k(paramString, "rootDir");
      p.k(paramf, "dir");
      if (this.pOT == null)
      {
        AppMethodBeat.o(244046);
        return Integer.valueOf(0);
      }
      if (this.pOU == null)
      {
        AppMethodBeat.o(244046);
        return Integer.valueOf(0);
      }
      Object localObject1 = paramf.name;
      label85:
      label92:
      label99:
      Object localObject2;
      if (localObject1 == null)
      {
        localObject1 = null;
        if (localObject1 == null) {
          break label310;
        }
        p.k(localObject1, "$this$lastOrNull");
        if (localObject1.length != 0) {
          break label292;
        }
        i = 1;
        if (i == 0) {
          break label297;
        }
        localObject1 = null;
        localObject1 = (String)localObject1;
        localObject2 = (CharSequence)localObject1;
        if ((localObject2 != null) && (((CharSequence)localObject2).length() != 0)) {
          break label316;
        }
      }
      int j;
      label292:
      label297:
      label310:
      label316:
      for (int i = 1;; i = 0)
      {
        if (i == 0) {
          break label321;
        }
        AppMethodBeat.o(244046);
        return Integer.valueOf(0);
        int n = ((String)localObject1).length();
        if (n == 0)
        {
          localObject1 = org.apache.commons.b.a.EMPTY_STRING_ARRAY;
          break;
        }
        localObject2 = new ArrayList();
        int k = 0;
        j = 0;
        i = 0;
        while (i < n) {
          if (((String)localObject1).charAt(i) == '_')
          {
            int m = j;
            if (j != 0)
            {
              ((List)localObject2).add(((String)localObject1).substring(k, i));
              m = 0;
            }
            i += 1;
            k = i;
            j = m;
          }
          else
          {
            j = 1;
            i += 1;
          }
        }
        if (j != 0) {
          ((List)localObject2).add(((String)localObject1).substring(k, i));
        }
        localObject1 = (String[])((List)localObject2).toArray(new String[((List)localObject2).size()]);
        break;
        i = 0;
        break label85;
        localObject1 = localObject1[(localObject1.length - 1)];
        break label92;
        localObject1 = null;
        break label99;
      }
      label321:
      paramString = u.dP(paramString + "/" + paramf.name, false);
      if (paramString != null)
      {
        paramString = paramString.iterator();
        i = 0;
        do
        {
          j = i;
          if (!paramString.hasNext()) {
            break;
          }
          paramf = (f)paramString.next();
        } while (paramf.YCj);
        this.pOT.bindString(1, (String)localObject1 + "%%");
        this.pOT.bindString(2, paramf.name);
      }
      label544:
      for (;;)
      {
        try
        {
          l1 = this.pOT.simpleQueryForLong();
          this.pOU.bindString(1, (String)localObject1 + "%%");
          this.pOU.bindString(2, paramf.name);
        }
        catch (SQLiteException localSQLiteException1)
        {
          try
          {
            l2 = this.pOU.simpleQueryForLong();
            if (l1 + l2 > 0L) {
              break label544;
            }
            paramf.cFq();
            i += 1;
            break;
            localSQLiteException1 = localSQLiteException1;
            long l1 = 0L;
          }
          catch (SQLiteException localSQLiteException2)
          {
            long l2 = 0L;
            continue;
          }
        }
        j = 0;
        AppMethodBeat.o(244046);
        return Integer.valueOf(j);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.m.ab
 * JD-Core Version:    0.7.0.1
 */