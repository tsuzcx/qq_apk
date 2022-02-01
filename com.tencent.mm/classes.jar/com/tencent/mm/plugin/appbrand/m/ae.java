package com.tencent.mm.plugin.appbrand.m;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.app.m;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storagebase.h;
import com.tencent.mm.vfs.f;
import com.tencent.mm.vfs.u;
import com.tencent.wcdb.database.SQLiteDatabase;
import com.tencent.wcdb.database.SQLiteException;
import com.tencent.wcdb.database.SQLiteStatement;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.a.j;
import kotlin.g.a.q;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.n.n;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/jsruntime/V8WasmCacheCleanupLogic;", "", "()V", "TAG", "", "clearByAppId", "", "appId", "doCleanup", "compileStatement", "Lcom/tencent/wcdb/database/SQLiteStatement;", "Lcom/tencent/mm/storagebase/SqliteDB;", "sql", "isEmptyDirectory", "", "Lcom/tencent/mm/vfs/FileEntry;", "rootDir", "USER_SCRIPT_HANDLER", "plugin-appbrand-integration_release"})
public final class ae
{
  public static final ae pOW;
  
  static
  {
    AppMethodBeat.i(283748);
    pOW = new ae();
    AppMethodBeat.o(283748);
  }
  
  private static boolean a(f paramf, String paramString)
  {
    AppMethodBeat.i(283746);
    if (paramf.YCj)
    {
      paramf = u.dP(paramString + "/" + paramf.name, false);
      if (paramf != null)
      {
        paramf = j.p(paramf);
        paramf = (Collection)paramf;
        if ((paramf != null) && (!paramf.isEmpty())) {
          break label88;
        }
      }
      label88:
      for (int i = 1;; i = 0)
      {
        if (i == 0) {
          break label93;
        }
        AppMethodBeat.o(283746);
        return true;
        paramf = null;
        break;
      }
    }
    label93:
    AppMethodBeat.o(283746);
    return false;
  }
  
  private static SQLiteStatement b(h paramh, String paramString)
  {
    Object localObject = null;
    AppMethodBeat.i(283747);
    try
    {
      paramh = paramh.hBZ().compileStatement(paramString);
      AppMethodBeat.o(283747);
      return paramh;
    }
    catch (SQLiteException paramh)
    {
      for (;;)
      {
        Log.e("MicroMsg.AppBrand.V8WasmCacheCleanupLogic", "compileStatement with sql:" + paramString + ", get exception:" + paramh);
        paramh = localObject;
      }
    }
    catch (IllegalStateException paramh)
    {
      for (;;)
      {
        Log.e("MicroMsg.AppBrand.V8WasmCacheCleanupLogic", "compileStatement with sql:" + paramString + ", get exception:" + paramh);
        paramh = localObject;
      }
    }
  }
  
  public static final void bZa()
  {
    AppMethodBeat.i(283744);
    Object localObject1 = m.bFB();
    long l;
    Object localObject2;
    int j;
    int i;
    if (localObject1 != null)
    {
      localObject1 = new a((h)localObject1);
      l = Util.currentTicks();
      localObject2 = u.dP(af.bOR(), false);
      if (localObject2 != null)
      {
        localObject2 = ((Iterable)localObject2).iterator();
        j = 0;
        i = 0;
      }
    }
    else
    {
      for (;;)
      {
        m = j;
        k = i;
        if (!((Iterator)localObject2).hasNext()) {
          break;
        }
        f localf1 = (f)((Iterator)localObject2).next();
        if (localf1.YCj)
        {
          String str1 = localf1.name;
          String str2 = af.bOR() + "/" + localf1.name;
          Object localObject3 = u.dP(str2, false);
          m = j;
          k = i;
          if (localObject3 != null)
          {
            localObject3 = ((Iterable)localObject3).iterator();
            k = j;
            j = i;
            i = k;
            while (((Iterator)localObject3).hasNext())
            {
              f localf2 = (f)((Iterator)localObject3).next();
              if (localf2.YCj)
              {
                j += 1;
                p.j(str1, "appId");
                p.j(localf2, "subDir");
                k = ((a)localObject1).a(str1, str2, localf2).intValue();
                if (a(localf2, str2)) {
                  localf2.cFq();
                }
                i = k + i;
                continue;
                AppMethodBeat.o(283744);
                return;
              }
            }
            k = j;
            m = i;
          }
          p.j(localf1, "dir");
          str2 = af.bOR();
          p.j(str2, "V8WasmCachePathRetriever.retrieve()");
          j = m;
          i = k;
          if (a(localf1, str2))
          {
            Log.i("MicroMsg.AppBrand.V8WasmCacheCleanupLogic", "delete appID %s relPath %s", new Object[] { str1, localf1.UUr });
            localf1.cFq();
            j = m;
            i = k;
          }
        }
      }
    }
    int m = 0;
    int k = 0;
    Log.i("MicroMsg.AppBrand.V8WasmCacheCleanupLogic", "doCleanup() cost:" + (Util.currentTicks() - l) + "ms, dirVisitedCount:" + k + ", fileDeletedCount:" + m);
    AppMethodBeat.o(283744);
  }
  
  public static final void dU(String paramString)
  {
    AppMethodBeat.i(283741);
    p.k(paramString, "appId");
    Object localObject = u.dP(af.bOR(), false);
    if (localObject != null)
    {
      localObject = ((Iterable)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        f localf = (f)((Iterator)localObject).next();
        if ((localf.YCj) && (p.h(paramString, localf.name)))
        {
          if (u.dK(af.bOR() + "/" + localf.name, true))
          {
            Log.d("MicroMsg.AppBrand.V8WasmCacheCleanupLogic", "wasm cache %s removed.", new Object[] { paramString });
            AppMethodBeat.o(283741);
            return;
          }
          Log.e("MicroMsg.AppBrand.V8WasmCacheCleanupLogic", "wasm cache %s remove failed.", new Object[] { paramString });
          AppMethodBeat.o(283741);
          return;
        }
      }
      AppMethodBeat.o(283741);
      return;
    }
    AppMethodBeat.o(283741);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/jsruntime/V8WasmCacheCleanupLogic$USER_SCRIPT_HANDLER;", "Lkotlin/Function3;", "", "Lcom/tencent/mm/vfs/FileEntry;", "", "Lcom/tencent/mm/plugin/appbrand/jsruntime/WasmCacheDirHandler;", "db", "Lcom/tencent/mm/storagebase/SqliteDB;", "(Lcom/tencent/mm/storagebase/SqliteDB;)V", "stmt", "Lcom/tencent/wcdb/database/SQLiteStatement;", "stmt2", "invoke", "appId", "rootDir", "dir", "(Ljava/lang/String;Ljava/lang/String;Lcom/tencent/mm/vfs/FileEntry;)Ljava/lang/Integer;", "plugin-appbrand-integration_release"})
  static final class a
    implements q<String, String, f, Integer>
  {
    private final SQLiteStatement pOT;
    private final SQLiteStatement pOU;
    
    public a(h paramh)
    {
      AppMethodBeat.i(242934);
      ae localae = ae.pOW;
      this.pOT = ae.d(paramh, "SELECT COUNT(*) FROM AppBrandWxaPkgManifestRecord WHERE appId LIKE ? AND versionMd5=? ;");
      localae = ae.pOW;
      this.pOU = ae.d(paramh, "SELECT COUNT(*) FROM AppBrandWxaPkgManifestRecord WHERE appId LIKE ? AND NewMd5=? ;");
      AppMethodBeat.o(242934);
    }
    
    public final Integer a(String paramString1, String paramString2, f paramf)
    {
      AppMethodBeat.i(242932);
      p.k(paramString1, "appId");
      p.k(paramString2, "rootDir");
      p.k(paramf, "dir");
      if (this.pOT == null)
      {
        AppMethodBeat.o(242932);
        return Integer.valueOf(0);
      }
      if (this.pOU == null)
      {
        AppMethodBeat.o(242932);
        return Integer.valueOf(0);
      }
      paramString2 = u.dP(paramString2 + "/" + paramf.name, false);
      int i;
      int j;
      f localf;
      if (paramString2 != null)
      {
        paramf = paramString2.iterator();
        i = 0;
        do
        {
          j = i;
          if (!paramf.hasNext()) {
            break;
          }
          localf = (f)paramf.next();
        } while (localf.YCj);
        paramString2 = localf.name;
        String str = localf.name;
        p.j(str, "file.name");
        if (!n.g((CharSequence)str, (CharSequence)".")) {
          break label355;
        }
        paramString2 = localf.name;
        p.j(paramString2, "file.name");
        paramString2 = (String)n.b((CharSequence)paramString2, new String[] { "." }).get(0);
      }
      label352:
      label355:
      for (;;)
      {
        this.pOT.bindString(1, paramString1 + "%%");
        this.pOT.bindString(2, paramString2);
        for (;;)
        {
          try
          {
            l1 = this.pOT.simpleQueryForLong();
            this.pOU.bindString(1, paramString1 + "%%");
            this.pOU.bindString(2, paramString2);
          }
          catch (SQLiteException localSQLiteException)
          {
            try
            {
              l2 = this.pOU.simpleQueryForLong();
              if (l1 + l2 > 0L) {
                break label352;
              }
              localf.cFq();
              i += 1;
              break;
              localSQLiteException = localSQLiteException;
              long l1 = 0L;
            }
            catch (SQLiteException paramString2)
            {
              long l2 = 0L;
              continue;
            }
          }
          j = 0;
          AppMethodBeat.o(242932);
          return Integer.valueOf(j);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.m.ae
 * JD-Core Version:    0.7.0.1
 */