package com.tencent.mm.plugin.appbrand.jsruntime;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appcache.ax;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storagebase.h;
import com.tencent.mm.vfs.FileSystem.a;
import com.tencent.mm.vfs.i;
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

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/appbrand/jsruntime/V8CodeCacheCleanupLogic;", "", "()V", "IGNORE_DIR_NAME_LIST", "", "", "[Ljava/lang/String;", "TAG", "doCleanup", "", "compileStatement", "Lcom/tencent/wcdb/database/SQLiteStatement;", "Lcom/tencent/mm/storagebase/SqliteDB;", "sql", "isEmptyDirectory", "", "Lcom/tencent/mm/vfs/FileSystem$FileEntry;", "LIB_SCRIPT_HANDLER", "USER_SCRIPT_HANDLER", "plugin-appbrand-integration_release"})
public final class aa
{
  private static final String[] lBQ;
  public static final aa lBR;
  
  static
  {
    AppMethodBeat.i(189240);
    lBR = new aa();
    lBQ = new String[] { "page_scripts" };
    AppMethodBeat.o(189240);
  }
  
  private static SQLiteStatement b(h paramh, String paramString)
  {
    Object localObject = null;
    AppMethodBeat.i(189239);
    try
    {
      paramh = paramh.ftT().compileStatement(paramString);
      AppMethodBeat.o(189239);
      return paramh;
    }
    catch (SQLiteException paramh)
    {
      for (;;)
      {
        ad.e("MicroMsg.AppBrand.V8CodeCacheCleanupLogic", "compileStatement with sql:" + paramString + ", get exception:" + paramh);
        paramh = localObject;
      }
    }
    catch (IllegalStateException paramh)
    {
      for (;;)
      {
        ad.e("MicroMsg.AppBrand.V8CodeCacheCleanupLogic", "compileStatement with sql:" + paramString + ", get exception:" + paramh);
        paramh = localObject;
      }
    }
  }
  
  public static final void bqn()
  {
    AppMethodBeat.i(189238);
    Object localObject1 = com.tencent.mm.plugin.appbrand.app.j.aYL();
    b localb;
    long l;
    int m;
    int i;
    int j;
    FileSystem.a locala1;
    Object localObject2;
    if (localObject1 != null)
    {
      localObject1 = (h)localObject1;
      localb = new b((h)localObject1);
      a locala = new a((h)localObject1);
      l = bt.HI();
      m = 0;
      i = 0;
      localObject1 = i.de(ac.bhw(), false);
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
          locala1 = (FileSystem.a)localIterator.next();
        } while ((!locala1.LjL) || (e.contains(lBQ, locala1.name)));
        localObject1 = null;
        localObject2 = ax.jHx;
        m = localObject2.length;
        k = 0;
        while (k < m)
        {
          Object localObject3 = localObject2[k];
          if (!p.i(localObject3, locala1.name))
          {
            p.g(localObject3, "name");
            String str = locala1.name;
            p.g(str, "dir.name");
            if (!n.nA(localObject3, str)) {}
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
      AppMethodBeat.o(189238);
      return;
      localObject2 = localObject1;
      if (localObject1 == null) {
        localObject2 = (b)localb;
      }
      p.g(locala1, "dir");
      k = j + ((Number)((b)localObject2).invoke(locala1)).intValue();
      if (locala1.LjL)
      {
        localObject1 = i.de(locala1.HZk, false);
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
          locala1.delete();
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
    ad.i("MicroMsg.AppBrand.V8CodeCacheCleanupLogic", "doCleanup() cost:" + (bt.HI() - l) + "ms, dirVisitedCount:" + m + ", fileDeletedCount:" + k);
    AppMethodBeat.o(189238);
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/appbrand/jsruntime/V8CodeCacheCleanupLogic$LIB_SCRIPT_HANDLER;", "Lkotlin/Function1;", "Lcom/tencent/mm/vfs/FileSystem$FileEntry;", "", "Lcom/tencent/mm/plugin/appbrand/jsruntime/CacheDirHandler;", "db", "Lcom/tencent/mm/storagebase/SqliteDB;", "(Lcom/tencent/mm/storagebase/SqliteDB;)V", "stmt", "Lcom/tencent/wcdb/database/SQLiteStatement;", "invoke", "dir", "(Lcom/tencent/mm/vfs/FileSystem$FileEntry;)Ljava/lang/Integer;", "plugin-appbrand-integration_release"})
  static final class a
    implements b<FileSystem.a, Integer>
  {
    private final SQLiteStatement lBS;
    
    public a(h paramh)
    {
      AppMethodBeat.i(189234);
      aa localaa = aa.lBR;
      this.lBS = aa.c(paramh, "SELECT COUNT(*) FROM AppBrandWxaPkgManifestRecord WHERE appId =? AND version=? ;");
      AppMethodBeat.o(189234);
    }
    
    private Integer a(FileSystem.a parama)
    {
      AppMethodBeat.i(189232);
      p.h(parama, "dir");
      if (this.lBS == null)
      {
        AppMethodBeat.o(189232);
        return Integer.valueOf(0);
      }
      parama = i.de(parama.HZk, false);
      int i;
      int j;
      FileSystem.a locala;
      if (parama != null)
      {
        parama = parama.iterator();
        i = 0;
        j = i;
        if (!parama.hasNext()) {
          break label225;
        }
        locala = (FileSystem.a)parama.next();
        try
        {
          Object localObject = locala.name;
          p.g(localObject, "file.name");
          if (localObject != null) {
            break label186;
          }
          localObject = new v("null cannot be cast to non-null type java.lang.String");
          AppMethodBeat.o(189232);
          throw ((Throwable)localObject);
        }
        catch (NumberFormatException localNumberFormatException)
        {
          j = -1;
        }
        if ((j == -1) || (j == 0) || (j == 999) || (j == ax.VERSION)) {
          break label235;
        }
        this.lBS.bindString(1, "@LibraryAppId");
        this.lBS.bindLong(2, j);
      }
      label186:
      label225:
      label235:
      for (;;)
      {
        try
        {
          l = this.lBS.simpleQueryForLong();
          if (l > 0L) {
            break label235;
          }
          locala.delete();
          i += 1;
          break;
          String str = localNumberFormatException.substring(1);
          p.g(str, "(this as java.lang.String).substring(startIndex)");
          j = Integer.parseInt(str, d.n.a.aly(10));
        }
        catch (SQLiteException localSQLiteException)
        {
          long l = 0L;
          continue;
        }
        j = 0;
        AppMethodBeat.o(189232);
        return Integer.valueOf(j);
      }
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/appbrand/jsruntime/V8CodeCacheCleanupLogic$USER_SCRIPT_HANDLER;", "Lkotlin/Function1;", "Lcom/tencent/mm/vfs/FileSystem$FileEntry;", "", "Lcom/tencent/mm/plugin/appbrand/jsruntime/CacheDirHandler;", "db", "Lcom/tencent/mm/storagebase/SqliteDB;", "(Lcom/tencent/mm/storagebase/SqliteDB;)V", "stmt", "Lcom/tencent/wcdb/database/SQLiteStatement;", "stmt2", "invoke", "dir", "(Lcom/tencent/mm/vfs/FileSystem$FileEntry;)Ljava/lang/Integer;", "plugin-appbrand-integration_release"})
  static final class b
    implements b<FileSystem.a, Integer>
  {
    private final SQLiteStatement lBS;
    private final SQLiteStatement lBT;
    
    public b(h paramh)
    {
      AppMethodBeat.i(189237);
      aa localaa = aa.lBR;
      this.lBS = aa.c(paramh, "SELECT COUNT(*) FROM AppBrandWxaPkgManifestRecord WHERE appId LIKE ? AND versionMd5=? ;");
      localaa = aa.lBR;
      this.lBT = aa.c(paramh, "SELECT COUNT(*) FROM AppBrandWxaPkgManifestRecord WHERE appId LIKE ? AND NewMd5=? ;");
      AppMethodBeat.o(189237);
    }
    
    private Integer a(FileSystem.a parama)
    {
      String str = null;
      int i1 = 0;
      int n = 0;
      AppMethodBeat.i(189235);
      p.h(parama, "dir");
      if (this.lBS == null)
      {
        AppMethodBeat.o(189235);
        return Integer.valueOf(0);
      }
      if (this.lBT == null)
      {
        AppMethodBeat.o(189235);
        return Integer.valueOf(0);
      }
      Object localObject = parama.name;
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
        AppMethodBeat.o(189235);
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
      parama = i.de(parama.HZk, false);
      int j = i1;
      if (parama != null)
      {
        parama = parama.iterator();
        i = n;
        for (;;)
        {
          j = i;
          if (parama.hasNext())
          {
            localObject = (FileSystem.a)parama.next();
            if (((FileSystem.a)localObject).LjL) {
              continue;
            }
            this.lBS.bindString(1, str + "%%");
            this.lBS.bindString(2, ((FileSystem.a)localObject).name);
            try
            {
              l1 = this.lBS.simpleQueryForLong();
              this.lBT.bindString(1, str + "%%");
              this.lBT.bindString(2, ((FileSystem.a)localObject).name);
            }
            catch (SQLiteException localSQLiteException1)
            {
              try
              {
                long l1;
                l2 = this.lBT.simpleQueryForLong();
                if (l1 + l2 <= 0L)
                {
                  ((FileSystem.a)localObject).delete();
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
      AppMethodBeat.o(189235);
      return Integer.valueOf(j);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsruntime.aa
 * JD-Core Version:    0.7.0.1
 */