package com.tencent.mm.plugin.appbrand.jsapi.ag.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.vfs.o;
import java.util.Collection;
import java.util.Iterator;
import kotlin.g.b.p;
import kotlin.l;
import org.json.JSONObject;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/jsapi/xwebplugin/live/AppBrandResCacheChecker;", "", "()V", "INVALID_LAST_MODIFIED", "", "MMKV_KEY_PREFIX_META_DATA_DIR", "", "MMKV_KEY_PREFIX_META_DATA_FILE", "MMKV_NAME_RES_CACHE_META", "getDirMeta", "file", "Lcom/tencent/mm/vfs/VFSFile;", "getFileLastModified", "isValid", "", "cacheFile", "record", "recordDir", "cacheDir", "recordFile", "saveDirMeta", "", "dir", "dirMeta", "saveFileLastModified", "validateDir", "validateFile", "validateMeta", "metaData", "Lcom/tencent/mm/plugin/appbrand/jsapi/xwebplugin/live/FileMetaData;", "parentDir", "luggage-xweb-ext_release"})
public final class d
{
  public static final d mJM;
  
  static
  {
    AppMethodBeat.i(215990);
    mJM = new d();
    AppMethodBeat.o(215990);
  }
  
  public static boolean C(o paramo)
  {
    AppMethodBeat.i(215986);
    p.h(paramo, "cacheFile");
    if (paramo.isDirectory())
    {
      Log.d("MicroMsg.AppBrand.AppBrandResCacheChecker", "recordDir, cacheDir: ".concat(String.valueOf(paramo)));
      localObject1 = g.mJU;
      localObject1 = g.a.G(paramo);
      if (localObject1 == null)
      {
        Log.w("MicroMsg.AppBrand.AppBrandResCacheChecker", "recordDir, metaData is null");
        AppMethodBeat.o(215986);
        return false;
      }
      localObject1 = ((g)localObject1).toJson();
      if (localObject1 != null)
      {
        localObject1 = ((JSONObject)localObject1).toString();
        localObject2 = (CharSequence)localObject1;
        if ((localObject2 != null) && (((CharSequence)localObject2).length() != 0)) {
          break label129;
        }
      }
      label129:
      for (int i = 1;; i = 0)
      {
        if (i == 0) {
          break label134;
        }
        Log.w("MicroMsg.AppBrand.AppBrandResCacheChecker", "recordDir, metaDataStr is empty");
        AppMethodBeat.o(215986);
        return false;
        localObject1 = null;
        break;
      }
      label134:
      localObject2 = MultiProcessMMKV.getMMKV("AppBrandResCacheMeta");
      paramo = "metaData_dir_" + paramo.getAbsolutePath();
      Log.d("MicroMsg.AppBrand.AppBrandResCacheChecker", "saveDirMeta, key: ".concat(String.valueOf(paramo)));
      ((MultiProcessMMKV)localObject2).putString(paramo, (String)localObject1);
      AppMethodBeat.o(215986);
      return true;
    }
    Object localObject1 = MultiProcessMMKV.getMMKV("AppBrandResCacheMeta");
    Object localObject2 = "metaData_file_" + paramo.getAbsolutePath();
    long l = paramo.lastModified();
    Log.d("MicroMsg.AppBrand.AppBrandResCacheChecker", "saveFileLastModified, key: " + (String)localObject2 + ", lastModified: " + l);
    ((MultiProcessMMKV)localObject1).putLong((String)localObject2, l);
    AppMethodBeat.o(215986);
    return true;
  }
  
  public static boolean D(o paramo)
  {
    AppMethodBeat.i(215987);
    p.h(paramo, "cacheFile");
    if (paramo.isDirectory())
    {
      boolean bool = E(paramo);
      AppMethodBeat.o(215987);
      return bool;
    }
    MultiProcessMMKV localMultiProcessMMKV = MultiProcessMMKV.getMMKV("AppBrandResCacheMeta");
    String str = "metaData_file_" + paramo.getAbsolutePath();
    Log.d("MicroMsg.AppBrand.AppBrandResCacheChecker", "getFileLastModified, key: ".concat(String.valueOf(str)));
    long l1 = localMultiProcessMMKV.getLong(str, -1L);
    long l2 = paramo.lastModified();
    Log.d("MicroMsg.AppBrand.AppBrandResCacheChecker", "validateFile, cacheFile: " + paramo + ", savedLastModified: " + l1 + ", realLastModified: " + l2);
    if (l1 == l2)
    {
      AppMethodBeat.o(215987);
      return true;
    }
    AppMethodBeat.o(215987);
    return false;
  }
  
  private static boolean E(o paramo)
  {
    AppMethodBeat.i(215988);
    Log.d("MicroMsg.AppBrand.AppBrandResCacheChecker", "validateDir, cacheDir: ".concat(String.valueOf(paramo)));
    Object localObject1 = MultiProcessMMKV.getMMKV("AppBrandResCacheMeta");
    Object localObject2 = "metaData_dir_" + paramo.getAbsolutePath();
    Log.d("MicroMsg.AppBrand.AppBrandResCacheChecker", "getDirMeta, key: ".concat(String.valueOf(localObject2)));
    localObject1 = ((MultiProcessMMKV)localObject1).getString((String)localObject2, null);
    localObject2 = (CharSequence)localObject1;
    if ((localObject2 == null) || (((CharSequence)localObject2).length() == 0)) {}
    for (int i = 1; i != 0; i = 0)
    {
      Log.w("MicroMsg.AppBrand.AppBrandResCacheChecker", "validateDir, metaDataStr is empty");
      AppMethodBeat.o(215988);
      return false;
    }
    try
    {
      localObject2 = h.mJV;
      localObject1 = h.a.aj(new JSONObject((String)localObject1));
      if (localObject1 == null)
      {
        Log.w("MicroMsg.AppBrand.AppBrandResCacheChecker", "validateDir, metaData is null");
        AppMethodBeat.o(215988);
        return false;
      }
    }
    catch (Exception localException)
    {
      h localh;
      for (;;)
      {
        Log.d("MicroMsg.AppBrand.AppBrandResCacheChecker", "validateDir, get metaData fail since ".concat(String.valueOf(localException)));
        localh = null;
      }
      paramo = paramo.heq();
      if (paramo == null) {
        p.hyc();
      }
      if (!a(localh, paramo))
      {
        Log.w("MicroMsg.AppBrand.AppBrandResCacheChecker", "validateDir, validateMeta fail");
        AppMethodBeat.o(215988);
        return false;
      }
      AppMethodBeat.o(215988);
    }
    return true;
  }
  
  private static boolean a(h paramh, o paramo)
  {
    AppMethodBeat.i(215989);
    paramo = new o(paramo, paramh.name);
    Log.d("MicroMsg.AppBrand.AppBrandResCacheChecker", "validateMeta, unzipFile: ".concat(String.valueOf(paramo)));
    if ((paramh instanceof g))
    {
      paramh = (Iterable)((g)paramh).mJT;
      if ((!(paramh instanceof Collection)) || (!((Collection)paramh).isEmpty()))
      {
        paramh = paramh.iterator();
        while (paramh.hasNext()) {
          if (!a((h)paramh.next(), paramo))
          {
            AppMethodBeat.o(215989);
            return false;
          }
        }
      }
      AppMethodBeat.o(215989);
      return true;
    }
    if ((paramo.exists()) && (paramo.isFile()))
    {
      if (paramh.kSb == paramo.lastModified())
      {
        AppMethodBeat.o(215989);
        return true;
      }
      AppMethodBeat.o(215989);
      return false;
    }
    AppMethodBeat.o(215989);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.ag.c.d
 * JD-Core Version:    0.7.0.1
 */