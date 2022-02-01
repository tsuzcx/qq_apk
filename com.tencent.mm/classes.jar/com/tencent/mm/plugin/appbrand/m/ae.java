package com.tencent.mm.plugin.appbrand.m;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storagebase.h;
import com.tencent.mm.vfs.e;
import com.tencent.mm.vfs.s;
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

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/jsruntime/V8WasmCacheCleanupLogic;", "", "()V", "TAG", "", "clearByAppId", "", "appId", "doCleanup", "compileStatement", "Lcom/tencent/wcdb/database/SQLiteStatement;", "Lcom/tencent/mm/storagebase/SqliteDB;", "sql", "isEmptyDirectory", "", "Lcom/tencent/mm/vfs/FileEntry;", "rootDir", "USER_SCRIPT_HANDLER", "plugin-appbrand-integration_release"})
public final class ae
{
  public static final ae mOe;
  
  static
  {
    AppMethodBeat.i(228614);
    mOe = new ae();
    AppMethodBeat.o(228614);
  }
  
  public static final void WY(String paramString)
  {
    AppMethodBeat.i(228610);
    p.h(paramString, "appId");
    Object localObject = s.dC(af.bDt(), false);
    if (localObject != null)
    {
      localObject = ((Iterable)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        e locale = (e)((Iterator)localObject).next();
        if ((locale.RbJ) && (p.j(paramString, locale.name)))
        {
          if (s.dy(af.bDt() + "/" + locale.name, true))
          {
            Log.d("MicroMsg.AppBrand.V8WasmCacheCleanupLogic", "wasm cache %s removed.", new Object[] { paramString });
            AppMethodBeat.o(228610);
            return;
          }
          Log.e("MicroMsg.AppBrand.V8WasmCacheCleanupLogic", "wasm cache %s remove failed.", new Object[] { paramString });
          AppMethodBeat.o(228610);
          return;
        }
      }
      AppMethodBeat.o(228610);
      return;
    }
    AppMethodBeat.o(228610);
  }
  
  private static boolean a(e parame, String paramString)
  {
    AppMethodBeat.i(258054);
    if (parame.RbJ)
    {
      parame = s.dC(paramString + "/" + parame.name, false);
      if (parame != null)
      {
        parame = j.p(parame);
        parame = (Collection)parame;
        if ((parame != null) && (!parame.isEmpty())) {
          break label88;
        }
      }
      label88:
      for (int i = 1;; i = 0)
      {
        if (i == 0) {
          break label93;
        }
        AppMethodBeat.o(258054);
        return true;
        parame = null;
        break;
      }
    }
    label93:
    AppMethodBeat.o(258054);
    return false;
  }
  
  private static SQLiteStatement b(h paramh, String paramString)
  {
    Object localObject = null;
    AppMethodBeat.i(228613);
    try
    {
      paramh = paramh.gFH().compileStatement(paramString);
      AppMethodBeat.o(228613);
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
  
  public static final void bMJ()
  {
    AppMethodBeat.i(228611);
    Object localObject1 = com.tencent.mm.plugin.appbrand.app.n.buy();
    long l;
    Object localObject2;
    int j;
    int i;
    if (localObject1 != null)
    {
      localObject1 = new a((h)localObject1);
      l = Util.currentTicks();
      localObject2 = s.dC(af.bDt(), false);
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
        e locale1 = (e)((Iterator)localObject2).next();
        if (locale1.RbJ)
        {
          String str1 = locale1.name;
          String str2 = af.bDt() + "/" + locale1.name;
          Object localObject3 = s.dC(str2, false);
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
              e locale2 = (e)((Iterator)localObject3).next();
              if (locale2.RbJ)
              {
                j += 1;
                p.g(str1, "appId");
                p.g(locale2, "subDir");
                k = ((a)localObject1).a(str1, str2, locale2).intValue();
                if (a(locale2, str2)) {
                  locale2.delete();
                }
                i = k + i;
                continue;
                AppMethodBeat.o(228611);
                return;
              }
            }
            k = j;
            m = i;
          }
          p.g(locale1, "dir");
          str2 = af.bDt();
          p.g(str2, "V8WasmCachePathRetriever.retrieve()");
          j = m;
          i = k;
          if (a(locale1, str2))
          {
            Log.i("MicroMsg.AppBrand.V8WasmCacheCleanupLogic", "delete appID %s relPath %s", new Object[] { str1, locale1.NGP });
            locale1.delete();
            j = m;
            i = k;
          }
        }
      }
    }
    int m = 0;
    int k = 0;
    Log.i("MicroMsg.AppBrand.V8WasmCacheCleanupLogic", "doCleanup() cost:" + (Util.currentTicks() - l) + "ms, dirVisitedCount:" + k + ", fileDeletedCount:" + m);
    AppMethodBeat.o(228611);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/jsruntime/V8WasmCacheCleanupLogic$USER_SCRIPT_HANDLER;", "Lkotlin/Function3;", "", "Lcom/tencent/mm/vfs/FileEntry;", "", "Lcom/tencent/mm/plugin/appbrand/jsruntime/WasmCacheDirHandler;", "db", "Lcom/tencent/mm/storagebase/SqliteDB;", "(Lcom/tencent/mm/storagebase/SqliteDB;)V", "stmt", "Lcom/tencent/wcdb/database/SQLiteStatement;", "stmt2", "invoke", "appId", "rootDir", "dir", "(Ljava/lang/String;Ljava/lang/String;Lcom/tencent/mm/vfs/FileEntry;)Ljava/lang/Integer;", "plugin-appbrand-integration_release"})
  static final class a
    implements q<String, String, e, Integer>
  {
    private final SQLiteStatement mOb;
    private final SQLiteStatement mOc;
    
    public a(h paramh)
    {
      AppMethodBeat.i(228609);
      ae localae = ae.mOe;
      this.mOb = ae.d(paramh, "SELECT COUNT(*) FROM AppBrandWxaPkgManifestRecord WHERE appId LIKE ? AND versionMd5=? ;");
      localae = ae.mOe;
      this.mOc = ae.d(paramh, "SELECT COUNT(*) FROM AppBrandWxaPkgManifestRecord WHERE appId LIKE ? AND NewMd5=? ;");
      AppMethodBeat.o(228609);
    }
    
    public final Integer a(String paramString1, String paramString2, e parame)
    {
      AppMethodBeat.i(258052);
      p.h(paramString1, "appId");
      p.h(paramString2, "rootDir");
      p.h(parame, "dir");
      if (this.mOb == null)
      {
        AppMethodBeat.o(258052);
        return Integer.valueOf(0);
      }
      if (this.mOc == null)
      {
        AppMethodBeat.o(258052);
        return Integer.valueOf(0);
      }
      paramString2 = s.dC(paramString2 + "/" + parame.name, false);
      int i;
      int j;
      e locale;
      if (paramString2 != null)
      {
        parame = paramString2.iterator();
        i = 0;
        do
        {
          j = i;
          if (!parame.hasNext()) {
            break;
          }
          locale = (e)parame.next();
        } while (locale.RbJ);
        paramString2 = locale.name;
        String str = locale.name;
        p.g(str, "file.name");
        if (!kotlin.n.n.e((CharSequence)str, (CharSequence)".")) {
          break label355;
        }
        paramString2 = locale.name;
        p.g(paramString2, "file.name");
        paramString2 = (String)kotlin.n.n.b((CharSequence)paramString2, new String[] { "." }).get(0);
      }
      label352:
      label355:
      for (;;)
      {
        this.mOb.bindString(1, paramString1 + "%%");
        this.mOb.bindString(2, paramString2);
        for (;;)
        {
          try
          {
            l1 = this.mOb.simpleQueryForLong();
            this.mOc.bindString(1, paramString1 + "%%");
            this.mOc.bindString(2, paramString2);
          }
          catch (SQLiteException localSQLiteException)
          {
            try
            {
              l2 = this.mOc.simpleQueryForLong();
              if (l1 + l2 > 0L) {
                break label352;
              }
              locale.delete();
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
          AppMethodBeat.o(258052);
          return Integer.valueOf(j);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.m.ae
 * JD-Core Version:    0.7.0.1
 */