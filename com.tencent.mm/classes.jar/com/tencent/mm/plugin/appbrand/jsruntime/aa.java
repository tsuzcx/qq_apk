package com.tencent.mm.plugin.appbrand.jsruntime;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appcache.aw;
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
import d.g.b.k;
import d.l;
import d.n.n;
import d.v;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/appbrand/jsruntime/V8CodeCacheCleanupLogic;", "", "()V", "IGNORE_DIR_NAME_LIST", "", "", "[Ljava/lang/String;", "TAG", "doCleanup", "", "compileStatement", "Lcom/tencent/wcdb/database/SQLiteStatement;", "Lcom/tencent/mm/storagebase/SqliteDB;", "sql", "isEmptyDirectory", "", "Lcom/tencent/mm/vfs/FileSystem$FileEntry;", "LIB_SCRIPT_HANDLER", "USER_SCRIPT_HANDLER", "plugin-appbrand-integration_release"})
public final class aa
{
  public static final aa kDA;
  private static final String[] kDz;
  
  static
  {
    AppMethodBeat.i(196353);
    kDA = new aa();
    kDz = new String[] { "page_scripts" };
    AppMethodBeat.o(196353);
  }
  
  private static SQLiteStatement a(h paramh, String paramString)
  {
    Object localObject = null;
    AppMethodBeat.i(196352);
    try
    {
      paramh = paramh.eOh().compileStatement(paramString);
      AppMethodBeat.o(196352);
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
  
  public static final void bfI()
  {
    AppMethodBeat.i(196351);
    Object localObject1 = com.tencent.mm.plugin.appbrand.app.j.aOy();
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
      l = bt.GC();
      m = 0;
      i = 0;
      localObject1 = i.cT(ac.aWU(), false);
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
        } while ((!locala1.HRB) || (e.contains(kDz, locala1.name)));
        localObject1 = null;
        localObject2 = aw.iNs;
        m = localObject2.length;
        k = 0;
        while (k < m)
        {
          Object localObject3 = localObject2[k];
          if (!k.g(localObject3, locala1.name))
          {
            k.g(localObject3, "name");
            String str = locala1.name;
            k.g(str, "dir.name");
            if (!n.mB(localObject3, str)) {}
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
      AppMethodBeat.o(196351);
      return;
      localObject2 = localObject1;
      if (localObject1 == null) {
        localObject2 = (b)localb;
      }
      k.g(locala1, "dir");
      k = j + ((Number)((b)localObject2).aA(locala1)).intValue();
      if (locala1.HRB)
      {
        localObject1 = i.cT(locala1.EQk, false);
        if (localObject1 != null)
        {
          localObject1 = d.a.j.m((Iterable)localObject1);
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
    ad.i("MicroMsg.AppBrand.V8CodeCacheCleanupLogic", "doCleanup() cost:" + (bt.GC() - l) + "ms, dirVisitedCount:" + m + ", fileDeletedCount:" + k);
    AppMethodBeat.o(196351);
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/appbrand/jsruntime/V8CodeCacheCleanupLogic$LIB_SCRIPT_HANDLER;", "Lkotlin/Function1;", "Lcom/tencent/mm/vfs/FileSystem$FileEntry;", "", "Lcom/tencent/mm/plugin/appbrand/jsruntime/CacheDirHandler;", "db", "Lcom/tencent/mm/storagebase/SqliteDB;", "(Lcom/tencent/mm/storagebase/SqliteDB;)V", "stmt", "Lcom/tencent/wcdb/database/SQLiteStatement;", "invoke", "dir", "(Lcom/tencent/mm/vfs/FileSystem$FileEntry;)Ljava/lang/Integer;", "plugin-appbrand-integration_release"})
  static final class a
    implements b<FileSystem.a, Integer>
  {
    private final SQLiteStatement kDB;
    
    public a(h paramh)
    {
      AppMethodBeat.i(196347);
      aa localaa = aa.kDA;
      this.kDB = aa.b(paramh, "SELECT COUNT(*) FROM AppBrandWxaPkgManifestRecord WHERE appId =? AND version=? ;");
      AppMethodBeat.o(196347);
    }
    
    private Integer a(FileSystem.a parama)
    {
      AppMethodBeat.i(196345);
      k.h(parama, "dir");
      if (this.kDB == null)
      {
        AppMethodBeat.o(196345);
        return Integer.valueOf(0);
      }
      parama = i.cT(parama.EQk, false);
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
          k.g(localObject, "file.name");
          if (localObject != null) {
            break label186;
          }
          localObject = new v("null cannot be cast to non-null type java.lang.String");
          AppMethodBeat.o(196345);
          throw ((Throwable)localObject);
        }
        catch (NumberFormatException localNumberFormatException)
        {
          j = -1;
        }
        if ((j == -1) || (j == 0) || (j == 999) || (j == aw.VERSION)) {
          break label235;
        }
        this.kDB.bindString(1, "@LibraryAppId");
        this.kDB.bindLong(2, j);
      }
      label186:
      label225:
      label235:
      for (;;)
      {
        try
        {
          l = this.kDB.simpleQueryForLong();
          if (l > 0L) {
            break label235;
          }
          locala.delete();
          i += 1;
          break;
          String str = localNumberFormatException.substring(1);
          k.g(str, "(this as java.lang.String).substring(startIndex)");
          j = Integer.parseInt(str, d.n.a.agb(10));
        }
        catch (SQLiteException localSQLiteException)
        {
          long l = 0L;
          continue;
        }
        j = 0;
        AppMethodBeat.o(196345);
        return Integer.valueOf(j);
      }
    }
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/appbrand/jsruntime/V8CodeCacheCleanupLogic$USER_SCRIPT_HANDLER;", "Lkotlin/Function1;", "Lcom/tencent/mm/vfs/FileSystem$FileEntry;", "", "Lcom/tencent/mm/plugin/appbrand/jsruntime/CacheDirHandler;", "db", "Lcom/tencent/mm/storagebase/SqliteDB;", "(Lcom/tencent/mm/storagebase/SqliteDB;)V", "stmt", "Lcom/tencent/wcdb/database/SQLiteStatement;", "invoke", "dir", "(Lcom/tencent/mm/vfs/FileSystem$FileEntry;)Ljava/lang/Integer;", "plugin-appbrand-integration_release"})
  static final class b
    implements b<FileSystem.a, Integer>
  {
    private final SQLiteStatement kDB;
    
    public b(h paramh)
    {
      AppMethodBeat.i(196350);
      aa localaa = aa.kDA;
      this.kDB = aa.b(paramh, "SELECT COUNT(*) FROM AppBrandWxaPkgManifestRecord WHERE appId LIKE ? AND versionMd5=? ;");
      AppMethodBeat.o(196350);
    }
    
    private Integer a(FileSystem.a parama)
    {
      String str = null;
      int i1 = 0;
      int n = 0;
      AppMethodBeat.i(196348);
      k.h(parama, "dir");
      if (this.kDB == null)
      {
        AppMethodBeat.o(196348);
        return Integer.valueOf(0);
      }
      Object localObject = parama.name;
      if (localObject == null)
      {
        localObject = null;
        if (localObject != null)
        {
          k.h(localObject, "$this$lastOrNull");
          if (localObject.length != 0) {
            break label272;
          }
          i = 1;
          label71:
          if (i == 0) {
            break label277;
          }
          localObject = null;
          label78:
          str = (String)localObject;
        }
        localObject = (CharSequence)str;
        if ((localObject != null) && (((CharSequence)localObject).length() != 0)) {
          break label290;
        }
      }
      label272:
      label277:
      label290:
      for (int i = 1;; i = 0)
      {
        if (i == 0) {
          break label295;
        }
        AppMethodBeat.o(196348);
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
        break label71;
        localObject = localObject[(localObject.length - 1)];
        break label78;
      }
      label295:
      parama = i.cT(parama.EQk, false);
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
            if (((FileSystem.a)localObject).HRB) {
              continue;
            }
            this.kDB.bindString(1, str + "%%");
            this.kDB.bindString(2, ((FileSystem.a)localObject).name);
            try
            {
              l = this.kDB.simpleQueryForLong();
              if (l <= 0L)
              {
                ((FileSystem.a)localObject).delete();
                i += 1;
              }
            }
            catch (SQLiteException localSQLiteException)
            {
              for (;;)
              {
                long l = 0L;
              }
            }
          }
        }
      }
      AppMethodBeat.o(196348);
      return Integer.valueOf(j);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsruntime.aa
 * JD-Core Version:    0.7.0.1
 */