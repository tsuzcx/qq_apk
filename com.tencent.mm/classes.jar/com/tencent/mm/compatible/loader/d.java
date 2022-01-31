package com.tencent.mm.compatible.loader;

import android.content.Context;
import android.content.res.AssetManager;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.r;
import com.tencent.mm.sdk.platformtools.y;
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
  private static Map<String, String> dzf;
  
  public static String v(Context paramContext, String paramString)
  {
    long l = bk.UY();
    if (dzf == null) {}
    try
    {
      String str1 = bk.convertStreamToString(paramContext.getAssets().open("preload/libraries.ini"));
      localObject2 = r.Zf(str1);
      y.v("MicroMsg.PluginClassLoader", "libraries.ini content\n%s", new Object[] { str1 });
      if ((localObject2 != null) && (((Map)localObject2).size() > 0)) {
        break label120;
      }
      y.e("MicroMsg.PluginClassLoader", "parse libraries.ini failed");
    }
    catch (Exception localException)
    {
      for (;;)
      {
        y.e("MicroMsg.PluginClassLoader", "load preload libraries failed");
        y.printErrStackTrace("MicroMsg.PluginClassLoader", localException, "", new Object[0]);
      }
      label120:
      dzf = new HashMap(((Map)localObject2).size());
      Object localObject1 = ((Map)localObject2).entrySet().iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (Map.Entry)((Iterator)localObject1).next();
        y.d("MicroMsg.PluginClassLoader", "preload file, plugin=%s, md5=%s", new Object[] { ((Map.Entry)localObject2).getKey(), ((Map.Entry)localObject2).getValue() });
        dzf.put(((Map.Entry)localObject2).getKey(), ((Map.Entry)localObject2).getValue());
      }
      paramContext = paramContext + "/" + paramString;
      localObject1 = (String)dzf.get(paramString);
      if (localObject1 != null) {
        break label282;
      }
      y.w("MicroMsg.PluginClassLoader", "extractVoipDex not in preloadfiles");
      return null;
      label282:
      Object localObject2 = new b(paramContext);
      if (!((b)localObject2).exists()) {
        break label377;
      }
      String str2 = e.aeY(j.n(((b)localObject2).mUri));
      if ((str2 == null) || (!str2.equalsIgnoreCase((String)localObject1))) {
        break label356;
      }
      y.d("MicroMsg.PluginClassLoader", "extractVoipDex: targetFilePath:[%s] time:%d", new Object[] { localObject2, Long.valueOf(bk.co(l)) });
      return paramContext;
      label356:
      y.e("MicroMsg.PluginClassLoader", "extractVoipDex target file exists, but md5 check failed, target=%s assets=%s", new Object[] { str2, localObject1 });
      label377:
      e.deleteFile(paramContext);
      if (e.r("assets:///preload/" + paramString, paramContext) >= 0L) {
        break label416;
      }
      y.f("MicroMsg.PluginClassLoader", "extractVoipDex  copyAssets failed");
      return null;
      label416:
      y.i("MicroMsg.PluginClassLoader", "extractVoipDex time:%d so:%s md5:%s ", new Object[] { Long.valueOf(bk.co(l)), paramString, localObject1 });
    }
    paramContext = paramContext.getDir("lib", 0).getAbsolutePath();
    if (dzf == null)
    {
      y.e("MicroMsg.PluginClassLoader", "extractVoipDex preload so files loaded failed");
      return null;
    }
    return paramContext;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.compatible.loader.d
 * JD-Core Version:    0.7.0.1
 */