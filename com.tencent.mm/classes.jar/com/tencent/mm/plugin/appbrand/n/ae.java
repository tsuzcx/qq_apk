package com.tencent.mm.plugin.appbrand.n;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storagebase.h;
import com.tencent.mm.vfs.j;
import com.tencent.mm.vfs.y;
import com.tencent.wcdb.database.SQLiteDatabase;
import com.tencent.wcdb.database.SQLiteException;
import com.tencent.wcdb.database.SQLiteStatement;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.a.p;
import kotlin.g.a.q;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/jsruntime/V8WasmCacheCleanupLogic;", "", "()V", "TAG", "", "clearByAppId", "", "appId", "doCleanup", "compileStatement", "Lcom/tencent/wcdb/database/SQLiteStatement;", "Lcom/tencent/mm/storagebase/SqliteDB;", "sql", "isEmptyDirectory", "", "Lcom/tencent/mm/vfs/FileEntry;", "rootDir", "USER_SCRIPT_HANDLER", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class ae
{
  public static final ae sTv;
  
  static
  {
    AppMethodBeat.i(319143);
    sTv = new ae();
    AppMethodBeat.o(319143);
  }
  
  private static boolean a(j paramj, String paramString)
  {
    AppMethodBeat.i(319129);
    if (paramj.agxh)
    {
      paramj = y.eB(paramString + '/' + paramj.name, false);
      if (paramj == null)
      {
        paramj = null;
        paramj = (Collection)paramj;
        if ((paramj != null) && (!paramj.isEmpty())) {
          break label88;
        }
      }
      label88:
      for (int i = 1;; i = 0)
      {
        if (i == 0) {
          break label93;
        }
        AppMethodBeat.o(319129);
        return true;
        paramj = p.p(paramj);
        break;
      }
    }
    label93:
    AppMethodBeat.o(319129);
    return false;
  }
  
  private static SQLiteStatement b(h paramh, String paramString)
  {
    Object localObject = null;
    AppMethodBeat.i(319134);
    try
    {
      paramh = paramh.jef().compileStatement(paramString);
      AppMethodBeat.o(319134);
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
  
  public static final void czn()
  {
    AppMethodBeat.i(319126);
    Object localObject1 = com.tencent.mm.plugin.appbrand.app.n.ceY();
    if (localObject1 == null)
    {
      AppMethodBeat.o(319126);
      return;
    }
    localObject1 = new a((h)localObject1);
    long l = Util.currentTicks();
    Object localObject2 = y.eB(af.cpf(), false);
    if (localObject2 != null)
    {
      localObject2 = ((Iterable)localObject2).iterator();
      int j = 0;
      int i = 0;
      for (;;)
      {
        m = j;
        k = i;
        if (!((Iterator)localObject2).hasNext()) {
          break;
        }
        j localj1 = (j)((Iterator)localObject2).next();
        if (localj1.agxh)
        {
          String str1 = localj1.name;
          s.s(str1, "dir.name");
          String str2 = af.cpf() + '/' + localj1.name;
          Object localObject3 = y.eB(str2, false);
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
              j localj2 = (j)((Iterator)localObject3).next();
              if (localj2.agxh)
              {
                j += 1;
                s.s(localj2, "subDir");
                k = ((a)localObject1).a(str1, str2, localj2).intValue();
                if (a(localj2, str2)) {
                  localj2.NP(true);
                }
                i = k + i;
              }
            }
            k = j;
            m = i;
          }
          s.s(localj1, "dir");
          str2 = af.cpf();
          s.s(str2, "retrieve()");
          j = m;
          i = k;
          if (a(localj1, str2))
          {
            Log.i("MicroMsg.AppBrand.V8WasmCacheCleanupLogic", "delete appID %s relPath %s", new Object[] { str1, localj1.acpB });
            localj1.NP(true);
            j = m;
            i = k;
          }
        }
      }
    }
    int m = 0;
    int k = 0;
    Log.i("MicroMsg.AppBrand.V8WasmCacheCleanupLogic", "doCleanup() cost:" + (Util.currentTicks() - l) + "ms, dirVisitedCount:" + k + ", fileDeletedCount:" + m);
    AppMethodBeat.o(319126);
  }
  
  public static final void fe(String paramString)
  {
    AppMethodBeat.i(319119);
    s.u(paramString, "appId");
    Object localObject = y.eB(af.cpf(), false);
    if (localObject != null)
    {
      localObject = ((Iterable)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        j localj = (j)((Iterator)localObject).next();
        if ((localj.agxh) && (s.p(paramString, localj.name)))
        {
          if (y.ew(af.cpf() + '/' + localj.name, true))
          {
            Log.d("MicroMsg.AppBrand.V8WasmCacheCleanupLogic", "wasm cache %s removed.", new Object[] { paramString });
            AppMethodBeat.o(319119);
            return;
          }
          Log.e("MicroMsg.AppBrand.V8WasmCacheCleanupLogic", "wasm cache %s remove failed.", new Object[] { paramString });
          AppMethodBeat.o(319119);
          return;
        }
      }
    }
    AppMethodBeat.o(319119);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/jsruntime/V8WasmCacheCleanupLogic$USER_SCRIPT_HANDLER;", "Lkotlin/Function3;", "", "Lcom/tencent/mm/vfs/FileEntry;", "", "Lcom/tencent/mm/plugin/appbrand/jsruntime/WasmCacheDirHandler;", "db", "Lcom/tencent/mm/storagebase/SqliteDB;", "(Lcom/tencent/mm/storagebase/SqliteDB;)V", "stmt", "Lcom/tencent/wcdb/database/SQLiteStatement;", "stmt2", "invoke", "appId", "rootDir", "dir", "(Ljava/lang/String;Ljava/lang/String;Lcom/tencent/mm/vfs/FileEntry;)Ljava/lang/Integer;", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
  static final class a
    implements q<String, String, j, Integer>
  {
    private final SQLiteStatement sTr;
    private final SQLiteStatement sTs;
    
    public a(h paramh)
    {
      AppMethodBeat.i(319092);
      ae localae = ae.sTv;
      this.sTr = ae.d(paramh, "SELECT COUNT(*) FROM AppBrandWxaPkgManifestRecord WHERE appId LIKE ? AND versionMd5=? ;");
      localae = ae.sTv;
      this.sTs = ae.d(paramh, "SELECT COUNT(*) FROM AppBrandWxaPkgManifestRecord WHERE appId LIKE ? AND NewMd5=? ;");
      AppMethodBeat.o(319092);
    }
    
    public final Integer a(String paramString1, String paramString2, j paramj)
    {
      AppMethodBeat.i(319094);
      s.u(paramString1, "appId");
      s.u(paramString2, "rootDir");
      s.u(paramj, "dir");
      if (this.sTr == null)
      {
        AppMethodBeat.o(319094);
        return Integer.valueOf(0);
      }
      if (this.sTs == null)
      {
        AppMethodBeat.o(319094);
        return Integer.valueOf(0);
      }
      paramString2 = y.eB(paramString2 + '/' + paramj.name, false);
      int i;
      int j;
      j localj;
      if (paramString2 != null)
      {
        paramj = paramString2.iterator();
        i = 0;
        do
        {
          j = i;
          if (!paramj.hasNext()) {
            break;
          }
          localj = (j)paramj.next();
        } while (localj.agxh);
        paramString2 = localj.name;
        s.s(paramString2, "file.name");
        String str = localj.name;
        s.s(str, "file.name");
        if (!kotlin.n.n.i((CharSequence)str, (CharSequence)".")) {
          break label336;
        }
        paramString2 = localj.name;
        s.s(paramString2, "file.name");
        paramString2 = (String)kotlin.n.n.b((CharSequence)paramString2, new String[] { "." }).get(0);
      }
      label333:
      label336:
      for (;;)
      {
        this.sTr.bindString(1, s.X(paramString1, "%%"));
        this.sTr.bindString(2, paramString2);
        for (;;)
        {
          try
          {
            l1 = this.sTr.simpleQueryForLong();
            this.sTs.bindString(1, s.X(paramString1, "%%"));
            this.sTs.bindString(2, paramString2);
          }
          catch (SQLiteException localSQLiteException)
          {
            try
            {
              l2 = this.sTs.simpleQueryForLong();
              if (l1 + l2 > 0L) {
                break label333;
              }
              localj.NP(true);
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
          AppMethodBeat.o(319094);
          return Integer.valueOf(j);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.n.ae
 * JD-Core Version:    0.7.0.1
 */