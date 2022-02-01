package com.tencent.mm.plugin.appbrand.m;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appcache.ay;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storagebase.h;
import com.tencent.mm.vfs.s;
import com.tencent.wcdb.database.SQLiteDatabase;
import com.tencent.wcdb.database.SQLiteException;
import com.tencent.wcdb.database.SQLiteStatement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.a.j;
import kotlin.g.a.m;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/jsruntime/V8CodeCacheCleanupLogic;", "", "()V", "IGNORE_DIR_NAME_LIST", "", "", "[Ljava/lang/String;", "TAG", "doCleanup", "", "compileStatement", "Lcom/tencent/wcdb/database/SQLiteStatement;", "Lcom/tencent/mm/storagebase/SqliteDB;", "sql", "isEmptyDirectory", "", "Lcom/tencent/mm/vfs/FileEntry;", "rootDir", "LIB_SCRIPT_HANDLER", "USER_SCRIPT_HANDLER", "plugin-appbrand-integration_release"})
public final class ab
{
  private static final String[] mNZ;
  public static final ab mOa;
  
  static
  {
    AppMethodBeat.i(228605);
    mOa = new ab();
    mNZ = new String[] { "page_scripts" };
    AppMethodBeat.o(228605);
  }
  
  private static SQLiteStatement b(h paramh, String paramString)
  {
    Object localObject = null;
    AppMethodBeat.i(228604);
    try
    {
      paramh = paramh.gFH().compileStatement(paramString);
      AppMethodBeat.o(228604);
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
  
  public static final void bMJ()
  {
    AppMethodBeat.i(228603);
    Object localObject1 = com.tencent.mm.plugin.appbrand.app.n.buy();
    b localb;
    long l;
    int m;
    int i;
    int j;
    com.tencent.mm.vfs.e locale;
    Object localObject2;
    if (localObject1 != null)
    {
      localObject1 = (h)localObject1;
      localb = new b((h)localObject1);
      a locala = new a((h)localObject1);
      l = Util.currentTicks();
      m = 0;
      i = 0;
      localObject1 = s.dC(ad.bDt(), false);
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
          locale = (com.tencent.mm.vfs.e)localIterator.next();
        } while ((!locale.RbJ) || (kotlin.a.e.contains(mNZ, locale.name)));
        localObject1 = null;
        localObject2 = ay.kMx;
        m = localObject2.length;
        k = 0;
        while (k < m)
        {
          Object localObject3 = localObject2[k];
          if (!p.j(localObject3, locale.name))
          {
            p.g(localObject3, "name");
            String str = locale.name;
            p.g(str, "dir.name");
            if (!kotlin.n.n.K(localObject3, str, false)) {}
          }
          else
          {
            localObject1 = (m)locala;
          }
          k += 1;
        }
      }
    }
    else
    {
      AppMethodBeat.o(228603);
      return;
      localObject2 = localObject1;
      if (localObject1 == null) {
        localObject2 = (m)localb;
      }
      localObject1 = ad.bDt();
      p.g(localObject1, "V8CodeCachePathRetriever.retrieve()");
      p.g(locale, "dir");
      k = j + ((Number)((m)localObject2).invoke(localObject1, locale)).intValue();
      localObject1 = ad.bDt();
      p.g(localObject1, "V8CodeCachePathRetriever.retrieve()");
      if (locale.RbJ)
      {
        localObject1 = s.dC((String)localObject1 + "/" + locale.name, false);
        if (localObject1 != null)
        {
          localObject1 = j.p((Iterable)localObject1);
          label337:
          localObject1 = (Collection)localObject1;
          if ((localObject1 != null) && (!((Collection)localObject1).isEmpty())) {
            break label411;
          }
          j = 1;
          label361:
          if (j == 0) {
            break label416;
          }
        }
      }
      label411:
      label416:
      for (j = 1;; j = 0)
      {
        if (j != 0)
        {
          Log.i("MicroMsg.AppBrand.V8CodeCacheCleanupLogic", "delete relPath %s", new Object[] { locale.NGP });
          locale.delete();
        }
        i += 1;
        j = k;
        break;
        localObject1 = null;
        break label337;
        j = 0;
        break label361;
      }
    }
    int k = 0;
    Log.i("MicroMsg.AppBrand.V8CodeCacheCleanupLogic", "doCleanup() cost:" + (Util.currentTicks() - l) + "ms, dirVisitedCount:" + m + ", fileDeletedCount:" + k);
    AppMethodBeat.o(228603);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/jsruntime/V8CodeCacheCleanupLogic$LIB_SCRIPT_HANDLER;", "Lkotlin/Function2;", "", "Lcom/tencent/mm/vfs/FileEntry;", "", "Lcom/tencent/mm/plugin/appbrand/jsruntime/CacheDirHandler;", "db", "Lcom/tencent/mm/storagebase/SqliteDB;", "(Lcom/tencent/mm/storagebase/SqliteDB;)V", "stmt", "Lcom/tencent/wcdb/database/SQLiteStatement;", "invoke", "rootDir", "dir", "(Ljava/lang/String;Lcom/tencent/mm/vfs/FileEntry;)Ljava/lang/Integer;", "plugin-appbrand-integration_release"})
  static final class a
    implements m<String, com.tencent.mm.vfs.e, Integer>
  {
    private final SQLiteStatement mOb;
    
    public a(h paramh)
    {
      AppMethodBeat.i(228599);
      ab localab = ab.mOa;
      this.mOb = ab.c(paramh, "SELECT COUNT(*) FROM AppBrandWxaPkgManifestRecord WHERE appId =? AND version=? ;");
      AppMethodBeat.o(228599);
    }
    
    private Integer a(String paramString, com.tencent.mm.vfs.e parame)
    {
      AppMethodBeat.i(258048);
      p.h(paramString, "rootDir");
      p.h(parame, "dir");
      if (this.mOb == null)
      {
        AppMethodBeat.o(258048);
        return Integer.valueOf(0);
      }
      paramString = s.dC(paramString + "/" + parame.name, false);
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
        parame = (com.tencent.mm.vfs.e)paramString.next();
        try
        {
          Object localObject = parame.name;
          p.g(localObject, "file.name");
          if (localObject != null) {
            break label218;
          }
          localObject = new t("null cannot be cast to non-null type java.lang.String");
          AppMethodBeat.o(258048);
          throw ((Throwable)localObject);
        }
        catch (NumberFormatException localNumberFormatException)
        {
          j = -1;
        }
        if ((j == -1) || (j == 0) || (j == 999) || (j == ay.VERSION)) {
          break label270;
        }
        this.mOb.bindString(1, "@LibraryAppId");
        this.mOb.bindLong(2, j);
      }
      label259:
      label270:
      for (;;)
      {
        try
        {
          l = this.mOb.simpleQueryForLong();
          if (l > 0L) {
            break label270;
          }
          parame.delete();
          i += 1;
          break;
          label218:
          String str = localNumberFormatException.substring(1);
          p.g(str, "(this as java.lang.String).substring(startIndex)");
          j = Integer.parseInt(str, kotlin.n.a.avR(10));
        }
        catch (SQLiteException localSQLiteException)
        {
          long l = 0L;
          continue;
        }
        j = 0;
        AppMethodBeat.o(258048);
        return Integer.valueOf(j);
      }
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/jsruntime/V8CodeCacheCleanupLogic$USER_SCRIPT_HANDLER;", "Lkotlin/Function2;", "", "Lcom/tencent/mm/vfs/FileEntry;", "", "Lcom/tencent/mm/plugin/appbrand/jsruntime/CacheDirHandler;", "db", "Lcom/tencent/mm/storagebase/SqliteDB;", "(Lcom/tencent/mm/storagebase/SqliteDB;)V", "stmt", "Lcom/tencent/wcdb/database/SQLiteStatement;", "stmt2", "invoke", "rootDir", "dir", "(Ljava/lang/String;Lcom/tencent/mm/vfs/FileEntry;)Ljava/lang/Integer;", "plugin-appbrand-integration_release"})
  static final class b
    implements m<String, com.tencent.mm.vfs.e, Integer>
  {
    private final SQLiteStatement mOb;
    private final SQLiteStatement mOc;
    
    public b(h paramh)
    {
      AppMethodBeat.i(228602);
      ab localab = ab.mOa;
      this.mOb = ab.c(paramh, "SELECT COUNT(*) FROM AppBrandWxaPkgManifestRecord WHERE appId LIKE ? AND versionMd5=? ;");
      localab = ab.mOa;
      this.mOc = ab.c(paramh, "SELECT COUNT(*) FROM AppBrandWxaPkgManifestRecord WHERE appId LIKE ? AND NewMd5=? ;");
      AppMethodBeat.o(228602);
    }
    
    private Integer a(String paramString, com.tencent.mm.vfs.e parame)
    {
      AppMethodBeat.i(258050);
      p.h(paramString, "rootDir");
      p.h(parame, "dir");
      if (this.mOb == null)
      {
        AppMethodBeat.o(258050);
        return Integer.valueOf(0);
      }
      if (this.mOc == null)
      {
        AppMethodBeat.o(258050);
        return Integer.valueOf(0);
      }
      Object localObject1 = parame.name;
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
        p.h(localObject1, "$this$lastOrNull");
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
        AppMethodBeat.o(258050);
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
      paramString = s.dC(paramString + "/" + parame.name, false);
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
          parame = (com.tencent.mm.vfs.e)paramString.next();
        } while (parame.RbJ);
        this.mOb.bindString(1, (String)localObject1 + "%%");
        this.mOb.bindString(2, parame.name);
      }
      label544:
      for (;;)
      {
        try
        {
          l1 = this.mOb.simpleQueryForLong();
          this.mOc.bindString(1, (String)localObject1 + "%%");
          this.mOc.bindString(2, parame.name);
        }
        catch (SQLiteException localSQLiteException1)
        {
          try
          {
            l2 = this.mOc.simpleQueryForLong();
            if (l1 + l2 > 0L) {
              break label544;
            }
            parame.delete();
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
        AppMethodBeat.o(258050);
        return Integer.valueOf(j);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.m.ab
 * JD-Core Version:    0.7.0.1
 */