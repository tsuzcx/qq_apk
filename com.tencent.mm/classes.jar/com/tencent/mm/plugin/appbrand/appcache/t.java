package com.tencent.mm.plugin.appbrand.appcache;

import android.os.SystemClock;
import com.eclipsesource.a.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes.WxaVersionInfo;
import com.tencent.mm.plugin.appbrand.config.v;
import com.tencent.mm.plugin.appbrand.config.x;
import com.tencent.mm.plugin.appbrand.config.z;
import com.tencent.mm.plugin.appbrand.utils.ag;
import com.tencent.mm.sdk.platformtools.FilePathGenerator;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.vfs.s;
import java.io.IOException;
import java.util.List;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.n.d;

@kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/appcache/IndexStorageMM;", "Lcom/tencent/mm/plugin/appbrand/appcache/WxaVersionPagePathIndexStorage;", "()V", "DIR_PATH", "", "getDIR_PATH", "()Ljava/lang/String;", "INDEX_FILE_SUFFIX", "TAG", "FILE_PATH", "appId", "appVersion", "", "PARSE_FILE_NAME", "Lkotlin/Pair;", "name", "checkIsPageIndexExisted", "", "checkIsPagePathIncluded", "pagePath", "cleanExpiredIndex", "", "removeIndexByAppId", "updatePageIndex", "pagesJson", "checkIsAppVersionAvailable", "Lcom/tencent/mm/plugin/appbrand/config/WxaAttrStorage;", "plugin-appbrand-integration_release"})
final class t
  implements bp
{
  public static final t kKS;
  
  static
  {
    AppMethodBeat.i(227985);
    kKS = new t();
    AppMethodBeat.o(227985);
  }
  
  private static kotlin.o<String, Integer> UY(String paramString)
  {
    AppMethodBeat.i(227978);
    paramString = kotlin.n.n.a((CharSequence)kotlin.n.n.c(paramString, (CharSequence)".idx"), new char[] { '_' });
    try
    {
      paramString = new kotlin.o((String)paramString.get(0), Integer.valueOf(Integer.parseInt((String)paramString.get(1))));
      AppMethodBeat.o(227978);
      return paramString;
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        paramString = null;
      }
    }
  }
  
  private static boolean a(x paramx, String paramString, int paramInt)
  {
    AppMethodBeat.i(227983);
    paramx = paramx.e(paramString, new String[] { "versionInfo" });
    if (paramx != null)
    {
      paramx = paramx.bAp();
      if ((paramx != null) && (paramx.appVersion == paramInt))
      {
        AppMethodBeat.o(227983);
        return true;
      }
    }
    AppMethodBeat.o(227983);
    return false;
  }
  
  private static String aP(String paramString, int paramInt)
  {
    AppMethodBeat.i(227977);
    paramString = new com.tencent.mm.vfs.o(bvC(), paramString + '_' + paramInt + ".idx").getAbsolutePath();
    p.g(paramString, "VFSFile(DIR_PATH, \"${app…LE_SUFFIX}\").absolutePath");
    AppMethodBeat.o(227977);
    return paramString;
  }
  
  private static String bvC()
  {
    AppMethodBeat.i(227976);
    Object localObject = g.aAh();
    p.g(localObject, "MMKernel.storage()");
    String str = ((com.tencent.mm.kernel.e)localObject).azM();
    p.g(str, "accPath");
    localObject = str;
    if (!kotlin.n.n.K(str, "/", false)) {
      localObject = str + "/";
    }
    localObject = (String)localObject + "appbrand/pagesidx/";
    FilePathGenerator.checkMkdir((String)localObject);
    AppMethodBeat.o(227976);
    return localObject;
  }
  
  public static void p(String paramString1, int paramInt, String paramString2)
  {
    AppMethodBeat.i(227981);
    p.h(paramString1, "appId");
    p.h(paramString2, "pagesJson");
    if (!g.aAf().azp())
    {
      Log.e("MicroMsg.WxaVersionPagePathIndexStorage.IndexStorageMM", "updatePageIndex(appId:" + paramString1 + ", appVersion:" + paramInt + "), account().hasInitialized()==FALSE");
      AppMethodBeat.o(227981);
      return;
    }
    String str2;
    long l;
    boolean bool;
    try
    {
      str2 = "updatePageIndex(appId:" + paramString1 + ", appVersion:" + paramInt + ", pagesJson.length=" + paramString2.length() + ')';
      l = SystemClock.elapsedRealtime();
      String str1 = aP(paramString1, paramInt);
      paramString2 = paramString2.getBytes(d.UTF_8);
      p.g(paramString2, "(this as java.lang.String).getBytes(charset)");
      str1 = Integer.valueOf(s.C(str1, paramString2)).toString();
      paramString2 = str1;
      if (str1 == null) {
        paramString2 = "";
      }
      bool = ag.LB();
      l = SystemClock.elapsedRealtime() - l;
      if ((l > 32L) && (bool))
      {
        Log.w("Luggage.Utils.Profile", "block main thread and skip " + (int)(l / 16L) + " frames! runProfiled:log:" + str2 + " cost " + l + " ms result:" + paramString2 + " isMainThread: " + bool + ' ');
        AppMethodBeat.o(227981);
        return;
      }
    }
    catch (IOException paramString2)
    {
      Log.e("MicroMsg.WxaVersionPagePathIndexStorage.IndexStorageMM", "updatePageIndex(appId:" + paramString1 + ", appVersion:" + paramInt + "), writeFile failed by " + paramString2);
      AppMethodBeat.o(227981);
      return;
    }
    Log.i("Luggage.Utils.Profile", "runProfiled:log:" + str2 + " cost " + l + " ms result:" + paramString2 + " isMainThread: " + bool + ' ');
    AppMethodBeat.o(227981);
  }
  
  public final void UZ(String paramString)
  {
    AppMethodBeat.i(227984);
    p.h(paramString, "appId");
    if (!g.aAf().azp())
    {
      Log.e("MicroMsg.WxaVersionPagePathIndexStorage.IndexStorageMM", "removeIndexByAppId(" + paramString + "), account().hasInitialized()==FALSE");
      AppMethodBeat.o(227984);
      return;
    }
    Object localObject = new com.tencent.mm.vfs.o(bvC());
    if ((!((com.tencent.mm.vfs.o)localObject).exists()) || (!((com.tencent.mm.vfs.o)localObject).isDirectory())) {
      try
      {
        ((com.tencent.mm.vfs.o)localObject).delete();
        AppMethodBeat.o(227984);
        return;
      }
      catch (Exception paramString)
      {
        AppMethodBeat.o(227984);
        return;
      }
    }
    com.tencent.mm.vfs.o[] arrayOfo = ((com.tencent.mm.vfs.o)localObject).het();
    if (arrayOfo != null)
    {
      int k = arrayOfo.length;
      int i = 0;
      if (i < k)
      {
        com.tencent.mm.vfs.o localo = arrayOfo[i];
        p.g(localo, "file");
        localObject = (CharSequence)localo.getName();
        int j;
        if ((localObject == null) || (((CharSequence)localObject).length() == 0))
        {
          j = 1;
          label170:
          if (j == 0)
          {
            localObject = localo.getName();
            p.g(localObject, "file.name");
            localObject = UY((String)localObject);
            if (localObject == null) {
              break label238;
            }
          }
        }
        label238:
        for (localObject = (String)((kotlin.o)localObject).first;; localObject = null)
        {
          if (p.j(paramString, localObject)) {
            localo.delete();
          }
          i += 1;
          break;
          j = 0;
          break label170;
        }
      }
      AppMethodBeat.o(227984);
      return;
    }
    AppMethodBeat.o(227984);
  }
  
  public final boolean aQ(String paramString, int paramInt)
  {
    AppMethodBeat.i(227980);
    p.h(paramString, "appId");
    if (!g.aAf().azp())
    {
      Log.e("MicroMsg.WxaVersionPagePathIndexStorage.IndexStorageMM", "checkIsPageIndexExisted(appId:" + paramString + ", appVersion:" + paramInt + "), account().hasInitialized()==FALSE");
      AppMethodBeat.o(227980);
      return false;
    }
    boolean bool = s.YS(aP(paramString, paramInt));
    AppMethodBeat.o(227980);
    return bool;
  }
  
  public final void bvD()
  {
    AppMethodBeat.i(227982);
    if (!g.aAf().azp())
    {
      Log.e("MicroMsg.WxaVersionPagePathIndexStorage.IndexStorageMM", "cleanExpiredIndex(), account().hasInitialized()==FALSE");
      AppMethodBeat.o(227982);
      return;
    }
    Object localObject1 = new com.tencent.mm.vfs.o(bvC());
    if ((!((com.tencent.mm.vfs.o)localObject1).exists()) || (!((com.tencent.mm.vfs.o)localObject1).isDirectory())) {
      try
      {
        ((com.tencent.mm.vfs.o)localObject1).delete();
        AppMethodBeat.o(227982);
        return;
      }
      catch (Exception localException)
      {
        AppMethodBeat.o(227982);
        return;
      }
    }
    z localz = (z)com.tencent.mm.plugin.appbrand.app.n.W(z.class);
    if (localz == null)
    {
      AppMethodBeat.o(227982);
      return;
    }
    v localv = (v)com.tencent.mm.plugin.appbrand.app.n.W(v.class);
    if (localv == null)
    {
      AppMethodBeat.o(227982);
      return;
    }
    localObject1 = ((com.tencent.mm.vfs.o)localObject1).het();
    if (localObject1 != null)
    {
      int k = localObject1.length;
      int i = 0;
      if (i < k)
      {
        Object localObject2 = localObject1[i];
        p.g(localObject2, "file");
        Object localObject3 = (CharSequence)localObject2.getName();
        int j;
        if ((localObject3 == null) || (((CharSequence)localObject3).length() == 0))
        {
          j = 1;
          label190:
          if (j == 0)
          {
            localObject3 = localObject2.getName();
            p.g(localObject3, "file.name");
            localObject3 = UY((String)localObject3);
            if (localObject3 != null) {
              break label233;
            }
          }
        }
        for (;;)
        {
          i += 1;
          break;
          j = 0;
          break label190;
          label233:
          String str = (String)((kotlin.o)localObject3).first;
          j = ((Number)((kotlin.o)localObject3).second).intValue();
          if ((!a((x)localz, str, j)) && (!a((x)localv, str, j))) {
            localObject2.delete();
          }
        }
      }
      AppMethodBeat.o(227982);
      return;
    }
    AppMethodBeat.o(227982);
  }
  
  public final boolean o(String paramString1, int paramInt, String paramString2)
  {
    AppMethodBeat.i(227979);
    p.h(paramString1, "appId");
    p.h(paramString2, "pagePath");
    if (!g.aAf().azp())
    {
      Log.e("MicroMsg.WxaVersionPagePathIndexStorage.IndexStorageMM", "checkIsPagePathIncluded(appId:" + paramString1 + ", appVersion:" + paramInt + ", pagePath:" + paramString2 + "), account().hasInitialized()==FALSE");
      AppMethodBeat.o(227979);
      return false;
    }
    String str1 = com.tencent.luggage.h.l.dM(paramString2);
    String str2;
    Object localObject2;
    Object localObject1;
    if (str1 == null)
    {
      str1 = "";
      str2 = kotlin.n.n.c(str1, (CharSequence)".html");
      if (((CharSequence)str2).length() == 0) {}
      for (int i = 1; i != 0; i = 0)
      {
        AppMethodBeat.o(227979);
        return false;
      }
      try
      {
        str1 = s.boY(aP(paramString1, paramInt));
        localObject2 = (CharSequence)str1;
        if ((localObject2 == null) || (((CharSequence)localObject2).length() == 0))
        {
          i = 1;
          if (i == 0) {
            break label210;
          }
          AppMethodBeat.o(227979);
          return false;
        }
      }
      catch (IOException localIOException)
      {
        for (;;)
        {
          localObject1 = "";
          continue;
          i = 0;
        }
      }
    }
    for (;;)
    {
      try
      {
        label210:
        localObject2 = "checkIsPagePathIncluded(pagesJson.length=" + ((String)localObject1).length() + ')';
        l = SystemClock.elapsedRealtime();
        localObject1 = com.eclipsesource.a.a.aR((String)localObject1);
        if (!(localObject1 instanceof com.eclipsesource.a.e)) {
          continue;
        }
        if (((com.eclipsesource.a.e)localObject1).aU(str2) == null) {
          continue;
        }
        bool = true;
        Boolean localBoolean = Boolean.valueOf(bool);
        str2 = localBoolean.toString();
        localObject1 = str2;
        if (str2 == null) {
          localObject1 = "";
        }
        bool = ag.LB();
        l = SystemClock.elapsedRealtime() - l;
        if ((l <= 32L) || (!bool)) {
          continue;
        }
        Log.w("Luggage.Utils.Profile", "block main thread and skip " + (int)(l / 16L) + " frames! runProfiled:log:" + (String)localObject2 + " cost " + l + " ms result:" + (String)localObject1 + " isMainThread: " + bool + ' ');
        bool = localBoolean.booleanValue();
      }
      catch (Exception localException)
      {
        long l;
        Log.e("MicroMsg.WxaVersionPagePathIndexStorage.IndexStorageMM", "checkIsPagePathIncluded(appId:" + paramString1 + ", appVersion:" + paramInt + ", pagePath:" + paramString2 + "), parse pagesJson failed by " + localException);
        bool = false;
        continue;
      }
      AppMethodBeat.o(227979);
      return bool;
      boolean bool = false;
      continue;
      if ((localObject1 instanceof b))
      {
        bool = j.a((Iterable)localObject1, com.eclipsesource.a.a.aQ(str2));
        continue;
        Log.i("Luggage.Utils.Profile", "runProfiled:log:" + (String)localObject2 + " cost " + l + " ms result:" + (String)localObject1 + " isMainThread: " + bool + ' ');
        continue;
        break;
      }
      bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.t
 * JD-Core Version:    0.7.0.1
 */