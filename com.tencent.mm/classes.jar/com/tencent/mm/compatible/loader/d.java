package com.tencent.mm.compatible.loader;

import android.content.Context;
import android.content.res.AssetManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.u;
import com.tencent.mm.vfs.b;
import com.tencent.mm.vfs.e;
import com.tencent.mm.vfs.j;
import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public final class d
{
  private static Map<String, String> erU;
  
  public static String B(Context paramContext, String paramString)
  {
    AppMethodBeat.i(93035);
    long l = bo.aoy();
    if (erU == null) {}
    try
    {
      ab.i("MicroMsg.PluginClassLoader", "ensurePreloadFiles");
      String str1 = bo.convertStreamToString(paramContext.getAssets().open("preload/libraries.ini"));
      localObject2 = u.apd(str1);
      ab.i("MicroMsg.PluginClassLoader", "libraries.ini content\n%s", new Object[] { str1 });
      if ((localObject2 != null) && (((Map)localObject2).size() > 0)) {
        break label137;
      }
      ab.e("MicroMsg.PluginClassLoader", "parse libraries.ini failed");
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ab.e("MicroMsg.PluginClassLoader", "load preload libraries failed");
        ab.printErrStackTrace("MicroMsg.PluginClassLoader", localException, "", new Object[0]);
      }
      label137:
      erU = new HashMap(((Map)localObject2).size());
      Object localObject1 = ((Map)localObject2).entrySet().iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (Map.Entry)((Iterator)localObject1).next();
        ab.d("MicroMsg.PluginClassLoader", "preload file, plugin=%s, md5=%s", new Object[] { ((Map.Entry)localObject2).getKey(), ((Map.Entry)localObject2).getValue() });
        erU.put(((Map.Entry)localObject2).getKey(), ((Map.Entry)localObject2).getValue());
      }
      paramContext = paramContext + "/" + paramString;
      localObject1 = (String)erU.get(paramString);
      if (localObject1 != null) {
        break label304;
      }
      ab.w("MicroMsg.PluginClassLoader", "extractVoipDex not in preloadfiles");
      AppMethodBeat.o(93035);
      return null;
      label304:
      Object localObject2 = new b(paramContext);
      if (!((b)localObject2).exists()) {
        break label404;
      }
      String str2 = e.avP(j.p(((b)localObject2).mUri));
      if ((str2 == null) || (!str2.equalsIgnoreCase((String)localObject1))) {
        break label383;
      }
      ab.d("MicroMsg.PluginClassLoader", "extractVoipDex: targetFilePath:[%s] time:%d", new Object[] { localObject2, Long.valueOf(bo.hl(l)) });
      AppMethodBeat.o(93035);
      return paramContext;
      label383:
      ab.e("MicroMsg.PluginClassLoader", "extractVoipDex target file exists, but md5 check failed, target=%s assets=%s", new Object[] { str2, localObject1 });
      label404:
      e.deleteFile(paramContext);
      if (e.C("assets:///preload/".concat(String.valueOf(paramString)), paramContext) >= 0L) {
        break label441;
      }
      ab.f("MicroMsg.PluginClassLoader", "extractVoipDex  copyAssets failed");
      AppMethodBeat.o(93035);
      return null;
      label441:
      ab.i("MicroMsg.PluginClassLoader", "extractVoipDex time:%d so:%s md5:%s ", new Object[] { Long.valueOf(bo.hl(l)), paramString, localObject1 });
      AppMethodBeat.o(93035);
    }
    paramContext = paramContext.getDir("lib", 0).getAbsolutePath();
    if (erU == null)
    {
      ab.e("MicroMsg.PluginClassLoader", "extractVoipDex preload so files loaded failed");
      AppMethodBeat.o(93035);
      return null;
    }
    return paramContext;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.compatible.loader.d
 * JD-Core Version:    0.7.0.1
 */