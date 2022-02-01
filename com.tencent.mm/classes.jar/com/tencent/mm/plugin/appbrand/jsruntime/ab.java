package com.tencent.mm.plugin.appbrand.jsruntime;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appcache.ay;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storagebase.h;
import com.tencent.mm.vfs.c;
import com.tencent.mm.vfs.o;
import com.tencent.wcdb.database.SQLiteDatabase;
import com.tencent.wcdb.database.SQLiteException;
import com.tencent.wcdb.database.SQLiteStatement;
import d.a.e;
import d.g.a.b;
import d.g.b.p;
import d.l;
import d.n.n;
import d.v;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/appbrand/jsruntime/V8CodeCacheCleanupLogic;", "", "()V", "IGNORE_DIR_NAME_LIST", "", "", "[Ljava/lang/String;", "TAG", "doCleanup", "", "compileStatement", "Lcom/tencent/wcdb/database/SQLiteStatement;", "Lcom/tencent/mm/storagebase/SqliteDB;", "sql", "isEmptyDirectory", "", "Lcom/tencent/mm/vfs/FileEntry;", "LIB_SCRIPT_HANDLER", "USER_SCRIPT_HANDLER", "plugin-appbrand-integration_release"})
public final class ab
{
  private static final String[] lGp;
  public static final ab lGq;
  
  static
  {
    AppMethodBeat.i(223497);
    lGq = new ab();
    lGp = new String[] { "page_scripts" };
    AppMethodBeat.o(223497);
  }
  
  private static SQLiteStatement b(h paramh, String paramString)
  {
    Object localObject = null;
    AppMethodBeat.i(223496);
    try
    {
      paramh = paramh.fxU().compileStatement(paramString);
      AppMethodBeat.o(223496);
      return paramh;
    }
    catch (SQLiteException paramh)
    {
      for (;;)
      {
        ae.e("MicroMsg.AppBrand.V8CodeCacheCleanupLogic", "compileStatement with sql:" + paramString + ", get exception:" + paramh);
        paramh = localObject;
      }
    }
    catch (IllegalStateException paramh)
    {
      for (;;)
      {
        ae.e("MicroMsg.AppBrand.V8CodeCacheCleanupLogic", "compileStatement with sql:" + paramString + ", get exception:" + paramh);
        paramh = localObject;
      }
    }
  }
  
  public static final void bqX()
  {
    AppMethodBeat.i(223495);
    Object localObject1 = com.tencent.mm.plugin.appbrand.app.j.aZh();
    b localb;
    long l;
    int m;
    int i;
    int j;
    c localc;
    Object localObject2;
    if (localObject1 != null)
    {
      localObject1 = (h)localObject1;
      localb = new b((h)localObject1);
      a locala = new a((h)localObject1);
      l = bu.HQ();
      m = 0;
      i = 0;
      localObject1 = o.dh(ad.bie(), false);
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
          localc = (c)localIterator.next();
        } while ((!localc.LGd) || (e.contains(lGp, localc.name)));
        localObject1 = null;
        localObject2 = ay.jKy;
        m = localObject2.length;
        k = 0;
        while (k < m)
        {
          Object localObject3 = localObject2[k];
          if (!p.i(localObject3, localc.name))
          {
            p.g(localObject3, "name");
            String str = localc.name;
            p.g(str, "dir.name");
            if (!n.nG(localObject3, str)) {}
          }
          else
          {
            localObject1 = (b)locala;
          }
          k += 1;
        }
      }
    }
    else
    {
      AppMethodBeat.o(223495);
      return;
      localObject2 = localObject1;
      if (localObject1 == null) {
        localObject2 = (b)localb;
      }
      p.g(localc, "dir");
      k = j + ((Number)((b)localObject2).invoke(localc)).intValue();
      if (localc.LGd)
      {
        localObject1 = o.dh(localc.Itr, false);
        if (localObject1 != null)
        {
          localObject1 = d.a.j.l((Iterable)localObject1);
          label287:
          localObject1 = (Collection)localObject1;
          if ((localObject1 != null) && (!((Collection)localObject1).isEmpty())) {
            break label342;
          }
          j = 1;
          label311:
          if (j == 0) {
            break label347;
          }
        }
      }
      label342:
      label347:
      for (j = 1;; j = 0)
      {
        if (j != 0) {
          localc.delete();
        }
        i += 1;
        j = k;
        break;
        localObject1 = null;
        break label287;
        j = 0;
        break label311;
      }
    }
    int k = 0;
    ae.i("MicroMsg.AppBrand.V8CodeCacheCleanupLogic", "doCleanup() cost:" + (bu.HQ() - l) + "ms, dirVisitedCount:" + m + ", fileDeletedCount:" + k);
    AppMethodBeat.o(223495);
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/appbrand/jsruntime/V8CodeCacheCleanupLogic$LIB_SCRIPT_HANDLER;", "Lkotlin/Function1;", "Lcom/tencent/mm/vfs/FileEntry;", "", "Lcom/tencent/mm/plugin/appbrand/jsruntime/CacheDirHandler;", "db", "Lcom/tencent/mm/storagebase/SqliteDB;", "(Lcom/tencent/mm/storagebase/SqliteDB;)V", "stmt", "Lcom/tencent/wcdb/database/SQLiteStatement;", "invoke", "dir", "(Lcom/tencent/mm/vfs/FileEntry;)Ljava/lang/Integer;", "plugin-appbrand-integration_release"})
  static final class a
    implements b<c, Integer>
  {
    private final SQLiteStatement lGr;
    
    public a(h paramh)
    {
      AppMethodBeat.i(223491);
      ab localab = ab.lGq;
      this.lGr = ab.c(paramh, "SELECT COUNT(*) FROM AppBrandWxaPkgManifestRecord WHERE appId =? AND version=? ;");
      AppMethodBeat.o(223491);
    }
    
    private Integer a(c paramc)
    {
      AppMethodBeat.i(223489);
      p.h(paramc, "dir");
      if (this.lGr == null)
      {
        AppMethodBeat.o(223489);
        return Integer.valueOf(0);
      }
      paramc = o.dh(paramc.Itr, false);
      int i;
      int j;
      c localc;
      if (paramc != null)
      {
        paramc = paramc.iterator();
        i = 0;
        j = i;
        if (!paramc.hasNext()) {
          break label225;
        }
        localc = (c)paramc.next();
        try
        {
          Object localObject = localc.name;
          p.g(localObject, "file.name");
          if (localObject != null) {
            break label186;
          }
          localObject = new v("null cannot be cast to non-null type java.lang.String");
          AppMethodBeat.o(223489);
          throw ((Throwable)localObject);
        }
        catch (NumberFormatException localNumberFormatException)
        {
          j = -1;
        }
        if ((j == -1) || (j == 0) || (j == 999) || (j == ay.VERSION)) {
          break label235;
        }
        this.lGr.bindString(1, "@LibraryAppId");
        this.lGr.bindLong(2, j);
      }
      label186:
      label225:
      label235:
      for (;;)
      {
        try
        {
          l = this.lGr.simpleQueryForLong();
          if (l > 0L) {
            break label235;
          }
          localc.delete();
          i += 1;
          break;
          String str = localNumberFormatException.substring(1);
          p.g(str, "(this as java.lang.String).substring(startIndex)");
          j = Integer.parseInt(str, d.n.a.ami(10));
        }
        catch (SQLiteException localSQLiteException)
        {
          long l = 0L;
          continue;
        }
        j = 0;
        AppMethodBeat.o(223489);
        return Integer.valueOf(j);
      }
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/appbrand/jsruntime/V8CodeCacheCleanupLogic$USER_SCRIPT_HANDLER;", "Lkotlin/Function1;", "Lcom/tencent/mm/vfs/FileEntry;", "", "Lcom/tencent/mm/plugin/appbrand/jsruntime/CacheDirHandler;", "db", "Lcom/tencent/mm/storagebase/SqliteDB;", "(Lcom/tencent/mm/storagebase/SqliteDB;)V", "stmt", "Lcom/tencent/wcdb/database/SQLiteStatement;", "stmt2", "invoke", "dir", "(Lcom/tencent/mm/vfs/FileEntry;)Ljava/lang/Integer;", "plugin-appbrand-integration_release"})
  static final class b
    implements b<c, Integer>
  {
    private final SQLiteStatement lGr;
    private final SQLiteStatement lGs;
    
    public b(h paramh)
    {
      AppMethodBeat.i(223494);
      ab localab = ab.lGq;
      this.lGr = ab.c(paramh, "SELECT COUNT(*) FROM AppBrandWxaPkgManifestRecord WHERE appId LIKE ? AND versionMd5=? ;");
      localab = ab.lGq;
      this.lGs = ab.c(paramh, "SELECT COUNT(*) FROM AppBrandWxaPkgManifestRecord WHERE appId LIKE ? AND NewMd5=? ;");
      AppMethodBeat.o(223494);
    }
    
    private Integer a(c paramc)
    {
      String str = null;
      int i1 = 0;
      int n = 0;
      AppMethodBeat.i(223492);
      p.h(paramc, "dir");
      if (this.lGr == null)
      {
        AppMethodBeat.o(223492);
        return Integer.valueOf(0);
      }
      if (this.lGs == null)
      {
        AppMethodBeat.o(223492);
        return Integer.valueOf(0);
      }
      Object localObject = paramc.name;
      if (localObject == null)
      {
        localObject = null;
        if (localObject != null)
        {
          p.h(localObject, "$this$lastOrNull");
          if (localObject.length != 0) {
            break label289;
          }
          i = 1;
          label88:
          if (i == 0) {
            break label294;
          }
          localObject = null;
          label95:
          str = (String)localObject;
        }
        localObject = (CharSequence)str;
        if ((localObject != null) && (((CharSequence)localObject).length() != 0)) {
          break label307;
        }
      }
      label289:
      label294:
      label307:
      for (int i = 1;; i = 0)
      {
        if (i == 0) {
          break label312;
        }
        AppMethodBeat.o(223492);
        return Integer.valueOf(0);
        int i2 = ((String)localObject).length();
        if (i2 == 0)
        {
          localObject = org.apache.commons.b.a.EMPTY_STRING_ARRAY;
          break;
        }
        ArrayList localArrayList = new ArrayList();
        j = 0;
        int k = 0;
        i = 0;
        while (i < i2) {
          if (((String)localObject).charAt(i) == '_')
          {
            int m = j;
            if (j != 0)
            {
              localArrayList.add(((String)localObject).substring(k, i));
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
          localArrayList.add(((String)localObject).substring(k, i));
        }
        localObject = (String[])localArrayList.toArray(new String[localArrayList.size()]);
        break;
        i = 0;
        break label88;
        localObject = localObject[(localObject.length - 1)];
        break label95;
      }
      label312:
      paramc = o.dh(paramc.Itr, false);
      int j = i1;
      if (paramc != null)
      {
        paramc = paramc.iterator();
        i = n;
        for (;;)
        {
          j = i;
          if (paramc.hasNext())
          {
            localObject = (c)paramc.next();
            if (((c)localObject).LGd) {
              continue;
            }
            this.lGr.bindString(1, str + "%%");
            this.lGr.bindString(2, ((c)localObject).name);
            try
            {
              l1 = this.lGr.simpleQueryForLong();
              this.lGs.bindString(1, str + "%%");
              this.lGs.bindString(2, ((c)localObject).name);
            }
            catch (SQLiteException localSQLiteException1)
            {
              try
              {
                long l1;
                l2 = this.lGs.simpleQueryForLong();
                if (l1 + l2 <= 0L)
                {
                  ((c)localObject).delete();
                  i += 1;
                  continue;
                  localSQLiteException1 = localSQLiteException1;
                  l1 = 0L;
                }
              }
              catch (SQLiteException localSQLiteException2)
              {
                for (;;)
                {
                  long l2 = 0L;
                }
              }
            }
          }
        }
      }
      AppMethodBeat.o(223492);
      return Integer.valueOf(j);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsruntime.ab
 * JD-Core Version:    0.7.0.1
 */