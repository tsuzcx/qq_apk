package com.tencent.mm.plugin.appbrand.jsapi.ai.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.vfs.q;
import java.util.Collection;
import java.util.Iterator;
import kotlin.g.b.p;
import kotlin.l;
import org.json.JSONObject;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/jsapi/xwebplugin/live/AppBrandResCacheChecker;", "", "()V", "INVALID_LAST_MODIFIED", "", "MMKV_KEY_PREFIX_META_DATA_DIR", "", "MMKV_KEY_PREFIX_META_DATA_FILE", "MMKV_NAME_RES_CACHE_META", "getDirMeta", "file", "Lcom/tencent/mm/vfs/VFSFile;", "getFileLastModified", "isValid", "", "cacheFile", "record", "recordDir", "cacheDir", "recordFile", "saveDirMeta", "", "dir", "dirMeta", "saveFileLastModified", "validateDir", "validateFile", "validateMeta", "metaData", "Lcom/tencent/mm/plugin/appbrand/jsapi/xwebplugin/live/FileMetaData;", "parentDir", "luggage-xweb-ext_release"})
public final class d
{
  public static final d pKE;
  
  static
  {
    AppMethodBeat.i(222034);
    pKE = new d();
    AppMethodBeat.o(222034);
  }
  
  public static boolean B(q paramq)
  {
    AppMethodBeat.i(222014);
    p.k(paramq, "cacheFile");
    if (paramq.isDirectory())
    {
      Log.d("MicroMsg.AppBrand.AppBrandResCacheChecker", "recordDir, cacheDir: ".concat(String.valueOf(paramq)));
      localObject1 = g.pKM;
      localObject1 = g.a.F(paramq);
      if (localObject1 == null)
      {
        Log.w("MicroMsg.AppBrand.AppBrandResCacheChecker", "recordDir, metaData is null");
        AppMethodBeat.o(222014);
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
        AppMethodBeat.o(222014);
        return false;
        localObject1 = null;
        break;
      }
      label134:
      localObject2 = MultiProcessMMKV.getMMKV("AppBrandResCacheMeta");
      paramq = "metaData_dir_" + paramq.bOF();
      Log.d("MicroMsg.AppBrand.AppBrandResCacheChecker", "saveDirMeta, key: ".concat(String.valueOf(paramq)));
      ((MultiProcessMMKV)localObject2).putString(paramq, (String)localObject1);
      AppMethodBeat.o(222014);
      return true;
    }
    Object localObject1 = MultiProcessMMKV.getMMKV("AppBrandResCacheMeta");
    Object localObject2 = "metaData_file_" + paramq.bOF();
    long l = paramq.lastModified();
    Log.d("MicroMsg.AppBrand.AppBrandResCacheChecker", "saveFileLastModified, key: " + (String)localObject2 + ", lastModified: " + l);
    ((MultiProcessMMKV)localObject1).putLong((String)localObject2, l);
    AppMethodBeat.o(222014);
    return true;
  }
  
  public static boolean C(q paramq)
  {
    AppMethodBeat.i(222019);
    p.k(paramq, "cacheFile");
    if (paramq.isDirectory())
    {
      boolean bool = D(paramq);
      AppMethodBeat.o(222019);
      return bool;
    }
    MultiProcessMMKV localMultiProcessMMKV = MultiProcessMMKV.getMMKV("AppBrandResCacheMeta");
    String str = "metaData_file_" + paramq.bOF();
    Log.d("MicroMsg.AppBrand.AppBrandResCacheChecker", "getFileLastModified, key: ".concat(String.valueOf(str)));
    long l1 = localMultiProcessMMKV.getLong(str, -1L);
    long l2 = paramq.lastModified();
    Log.d("MicroMsg.AppBrand.AppBrandResCacheChecker", "validateFile, cacheFile: " + paramq + ", savedLastModified: " + l1 + ", realLastModified: " + l2);
    if (l1 == l2)
    {
      AppMethodBeat.o(222019);
      return true;
    }
    AppMethodBeat.o(222019);
    return false;
  }
  
  private static boolean D(q paramq)
  {
    AppMethodBeat.i(222026);
    Log.d("MicroMsg.AppBrand.AppBrandResCacheChecker", "validateDir, cacheDir: ".concat(String.valueOf(paramq)));
    Object localObject1 = MultiProcessMMKV.getMMKV("AppBrandResCacheMeta");
    Object localObject2 = "metaData_dir_" + paramq.bOF();
    Log.d("MicroMsg.AppBrand.AppBrandResCacheChecker", "getDirMeta, key: ".concat(String.valueOf(localObject2)));
    localObject1 = ((MultiProcessMMKV)localObject1).getString((String)localObject2, null);
    localObject2 = (CharSequence)localObject1;
    if ((localObject2 == null) || (((CharSequence)localObject2).length() == 0)) {}
    for (int i = 1; i != 0; i = 0)
    {
      Log.w("MicroMsg.AppBrand.AppBrandResCacheChecker", "validateDir, metaDataStr is empty");
      AppMethodBeat.o(222026);
      return false;
    }
    try
    {
      localObject2 = h.pKN;
      localObject1 = h.a.an(new JSONObject((String)localObject1));
      if (localObject1 == null)
      {
        Log.w("MicroMsg.AppBrand.AppBrandResCacheChecker", "validateDir, metaData is null");
        AppMethodBeat.o(222026);
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
      paramq = paramq.ifB();
      if (paramq == null) {
        p.iCn();
      }
      if (!a(localh, paramq))
      {
        Log.w("MicroMsg.AppBrand.AppBrandResCacheChecker", "validateDir, validateMeta fail");
        AppMethodBeat.o(222026);
        return false;
      }
      AppMethodBeat.o(222026);
    }
    return true;
  }
  
  private static boolean a(h paramh, q paramq)
  {
    AppMethodBeat.i(222032);
    paramq = new q(paramq, paramh.name);
    Log.d("MicroMsg.AppBrand.AppBrandResCacheChecker", "validateMeta, unzipFile: ".concat(String.valueOf(paramq)));
    if ((paramh instanceof g))
    {
      paramh = (Iterable)((g)paramh).pKL;
      if ((!(paramh instanceof Collection)) || (!((Collection)paramh).isEmpty()))
      {
        paramh = paramh.iterator();
        while (paramh.hasNext()) {
          if (!a((h)paramh.next(), paramq))
          {
            AppMethodBeat.o(222032);
            return false;
          }
        }
      }
      AppMethodBeat.o(222032);
      return true;
    }
    if ((paramq.ifE()) && (paramq.ifH()))
    {
      if (paramh.nMj == paramq.lastModified())
      {
        AppMethodBeat.o(222032);
        return true;
      }
      AppMethodBeat.o(222032);
      return false;
    }
    AppMethodBeat.o(222032);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.ai.c.d
 * JD-Core Version:    0.7.0.1
 */