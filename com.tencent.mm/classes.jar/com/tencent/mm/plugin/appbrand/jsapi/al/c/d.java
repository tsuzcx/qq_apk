package com.tencent.mm.plugin.appbrand.jsapi.al.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.vfs.ah;
import com.tencent.mm.vfs.u;
import java.util.Collection;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.g.b.s;
import org.json.JSONObject;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/jsapi/xwebplugin/live/AppBrandResCacheChecker;", "", "()V", "INVALID_LAST_MODIFIED", "", "MMKV_KEY_PREFIX_META_DATA_DIR", "", "MMKV_KEY_PREFIX_META_DATA_FILE", "MMKV_NAME_RES_CACHE_META", "getDirMeta", "file", "Lcom/tencent/mm/vfs/VFSFile;", "getFileLastModified", "isValid", "", "cacheFile", "record", "recordDir", "cacheDir", "recordFile", "saveDirMeta", "", "dir", "dirMeta", "saveFileLastModified", "validateDir", "validateFile", "validateMeta", "metaData", "Lcom/tencent/mm/plugin/appbrand/jsapi/xwebplugin/live/FileMetaData;", "parentDir", "luggage-xweb-ext_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class d
{
  public static final d sPx;
  
  static
  {
    AppMethodBeat.i(327127);
    sPx = new d();
    AppMethodBeat.o(327127);
  }
  
  public static boolean B(u paramu)
  {
    AppMethodBeat.i(327105);
    s.u(paramu, "cacheFile");
    if (paramu.isDirectory())
    {
      Log.d("MicroMsg.AppBrand.AppBrandResCacheChecker", s.X("recordDir, cacheDir: ", paramu));
      localObject1 = g.sPE;
      localObject1 = g.a.F(paramu);
      if (localObject1 == null)
      {
        Log.w("MicroMsg.AppBrand.AppBrandResCacheChecker", "recordDir, metaData is null");
        AppMethodBeat.o(327105);
        return false;
      }
      localObject1 = ((g)localObject1).toJson();
      if (localObject1 == null)
      {
        localObject1 = null;
        localObject2 = (CharSequence)localObject1;
        if ((localObject2 != null) && (((CharSequence)localObject2).length() != 0)) {
          break label126;
        }
      }
      label126:
      for (int i = 1;; i = 0)
      {
        if (i == 0) {
          break label131;
        }
        Log.w("MicroMsg.AppBrand.AppBrandResCacheChecker", "recordDir, metaDataStr is empty");
        AppMethodBeat.o(327105);
        return false;
        localObject1 = ((JSONObject)localObject1).toString();
        break;
      }
      label131:
      localObject2 = MultiProcessMMKV.getMMKV("AppBrandResCacheMeta");
      paramu = s.X("metaData_dir_", ah.v(paramu.jKT()));
      Log.d("MicroMsg.AppBrand.AppBrandResCacheChecker", s.X("saveDirMeta, key: ", paramu));
      ((MultiProcessMMKV)localObject2).putString(paramu, (String)localObject1);
      AppMethodBeat.o(327105);
      return true;
    }
    Object localObject1 = MultiProcessMMKV.getMMKV("AppBrandResCacheMeta");
    Object localObject2 = s.X("metaData_file_", ah.v(paramu.jKT()));
    long l = paramu.lastModified();
    Log.d("MicroMsg.AppBrand.AppBrandResCacheChecker", "saveFileLastModified, key: " + (String)localObject2 + ", lastModified: " + l);
    ((MultiProcessMMKV)localObject1).putLong((String)localObject2, l);
    AppMethodBeat.o(327105);
    return true;
  }
  
  public static boolean C(u paramu)
  {
    AppMethodBeat.i(327114);
    s.u(paramu, "cacheFile");
    if (paramu.isDirectory())
    {
      boolean bool = D(paramu);
      AppMethodBeat.o(327114);
      return bool;
    }
    MultiProcessMMKV localMultiProcessMMKV = MultiProcessMMKV.getMMKV("AppBrandResCacheMeta");
    String str = s.X("metaData_file_", ah.v(paramu.jKT()));
    Log.d("MicroMsg.AppBrand.AppBrandResCacheChecker", s.X("getFileLastModified, key: ", str));
    long l1 = localMultiProcessMMKV.getLong(str, -1L);
    long l2 = paramu.lastModified();
    Log.d("MicroMsg.AppBrand.AppBrandResCacheChecker", "validateFile, cacheFile: " + paramu + ", savedLastModified: " + l1 + ", realLastModified: " + l2);
    if (l1 == l2)
    {
      AppMethodBeat.o(327114);
      return true;
    }
    AppMethodBeat.o(327114);
    return false;
  }
  
  private static boolean D(u paramu)
  {
    AppMethodBeat.i(327119);
    Log.d("MicroMsg.AppBrand.AppBrandResCacheChecker", s.X("validateDir, cacheDir: ", paramu));
    Object localObject1 = MultiProcessMMKV.getMMKV("AppBrandResCacheMeta");
    Object localObject2 = s.X("metaData_dir_", ah.v(paramu.jKT()));
    Log.d("MicroMsg.AppBrand.AppBrandResCacheChecker", s.X("getDirMeta, key: ", localObject2));
    localObject1 = ((MultiProcessMMKV)localObject1).getString((String)localObject2, null);
    localObject2 = (CharSequence)localObject1;
    if ((localObject2 == null) || (((CharSequence)localObject2).length() == 0)) {}
    for (int i = 1; i != 0; i = 0)
    {
      Log.w("MicroMsg.AppBrand.AppBrandResCacheChecker", "validateDir, metaDataStr is empty");
      AppMethodBeat.o(327119);
      return false;
    }
    try
    {
      localObject2 = h.sPG;
      localObject1 = h.a.ax(new JSONObject((String)localObject1));
      if (localObject1 == null)
      {
        Log.w("MicroMsg.AppBrand.AppBrandResCacheChecker", "validateDir, metaData is null");
        AppMethodBeat.o(327119);
        return false;
      }
    }
    catch (Exception localException)
    {
      h localh;
      for (;;)
      {
        Log.d("MicroMsg.AppBrand.AppBrandResCacheChecker", s.X("validateDir, get metaData fail since ", localException));
        localh = null;
      }
      paramu = paramu.jKP();
      s.checkNotNull(paramu);
      if (!a(localh, paramu))
      {
        Log.w("MicroMsg.AppBrand.AppBrandResCacheChecker", "validateDir, validateMeta fail");
        AppMethodBeat.o(327119);
        return false;
      }
      AppMethodBeat.o(327119);
    }
    return true;
  }
  
  private static boolean a(h paramh, u paramu)
  {
    AppMethodBeat.i(327125);
    paramu = new u(paramu, paramh.name);
    Log.d("MicroMsg.AppBrand.AppBrandResCacheChecker", s.X("validateMeta, unzipFile: ", paramu));
    if ((paramh instanceof g))
    {
      paramh = (Iterable)((g)paramh).sPF;
      if ((!(paramh instanceof Collection)) || (!((Collection)paramh).isEmpty()))
      {
        paramh = paramh.iterator();
        while (paramh.hasNext()) {
          if (!a((h)paramh.next(), paramu))
          {
            AppMethodBeat.o(327125);
            return false;
          }
        }
      }
      AppMethodBeat.o(327125);
      return true;
    }
    if ((paramu.jKS()) && (paramu.jKV()))
    {
      if (paramh.qMk == paramu.lastModified())
      {
        AppMethodBeat.o(327125);
        return true;
      }
      AppMethodBeat.o(327125);
      return false;
    }
    AppMethodBeat.o(327125);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.al.c.d
 * JD-Core Version:    0.7.0.1
 */