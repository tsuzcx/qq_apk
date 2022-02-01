package com.tencent.mm.plugin.appbrand.appcache;

import android.os.SystemClock;
import com.eclipsesource.a.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes.WxaVersionInfo;
import com.tencent.mm.plugin.appbrand.config.s;
import com.tencent.mm.plugin.appbrand.config.u;
import com.tencent.mm.plugin.appbrand.config.w;
import com.tencent.mm.plugin.appbrand.utils.ag;
import com.tencent.mm.sdk.platformtools.ae;
import d.g.b.p;
import d.l;
import d.n.d;
import java.io.IOException;
import java.util.List;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/appbrand/appcache/IndexStorageMM;", "Lcom/tencent/mm/plugin/appbrand/appcache/WxaVersionPagePathIndexStorage;", "()V", "DIR_PATH", "", "getDIR_PATH", "()Ljava/lang/String;", "INDEX_FILE_SUFFIX", "TAG", "FILE_PATH", "appId", "appVersion", "", "PARSE_FILE_NAME", "Lkotlin/Pair;", "name", "checkIsPageIndexExisted", "", "checkIsPagePathIncluded", "pagePath", "cleanExpiredIndex", "", "removeIndexByAppId", "updatePageIndex", "pagesJson", "checkIsAppVersionAvailable", "Lcom/tencent/mm/plugin/appbrand/config/WxaAttrStorage;", "plugin-appbrand-integration_release"})
final class t
  implements bp
{
  public static final t jIW;
  
  static
  {
    AppMethodBeat.i(223206);
    jIW = new t();
    AppMethodBeat.o(223206);
  }
  
  private static d.o<String, Integer> LP(String paramString)
  {
    AppMethodBeat.i(223199);
    paramString = d.n.n.b((CharSequence)d.n.n.c(paramString, (CharSequence)".idx"), new char[] { '_' });
    try
    {
      paramString = new d.o((String)paramString.get(0), Integer.valueOf(Integer.parseInt((String)paramString.get(1))));
      AppMethodBeat.o(223199);
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
  
  private static boolean a(u paramu, String paramString, int paramInt)
  {
    AppMethodBeat.i(223204);
    paramu = paramu.e(paramString, new String[] { "versionInfo" });
    if (paramu != null)
    {
      paramu = paramu.beV();
      if ((paramu != null) && (paramu.aDD == paramInt))
      {
        AppMethodBeat.o(223204);
        return true;
      }
    }
    AppMethodBeat.o(223204);
    return false;
  }
  
  private static String aJ(String paramString, int paramInt)
  {
    AppMethodBeat.i(223198);
    paramString = new com.tencent.mm.vfs.k(bam(), paramString + '_' + paramInt + ".idx").getAbsolutePath();
    p.g(paramString, "VFSFile(DIR_PATH, \"${app…LE_SUFFIX}\").absolutePath");
    AppMethodBeat.o(223198);
    return paramString;
  }
  
  private static String bam()
  {
    AppMethodBeat.i(223197);
    Object localObject = g.ajR();
    p.g(localObject, "MMKernel.storage()");
    String str = ((com.tencent.mm.kernel.e)localObject).ajw();
    p.g(str, "accPath");
    localObject = str;
    if (!d.n.n.nG(str, "/")) {
      localObject = str + "/";
    }
    localObject = (String)localObject + "appbrand/pagesidx/";
    com.tencent.mm.sdk.platformtools.n.aMy((String)localObject);
    AppMethodBeat.o(223197);
    return localObject;
  }
  
  public static void m(String paramString1, int paramInt, String paramString2)
  {
    AppMethodBeat.i(223202);
    p.h(paramString1, "appId");
    p.h(paramString2, "pagesJson");
    if (!g.ajP().aiZ())
    {
      ae.e("MicroMsg.WxaVersionPagePathIndexStorage.IndexStorageMM", "updatePageIndex(appId:" + paramString1 + ", appVersion:" + paramInt + "), account().hasInitialized()==FALSE");
      AppMethodBeat.o(223202);
      return;
    }
    String str2;
    long l;
    boolean bool;
    try
    {
      str2 = "updatePageIndex(appId:" + paramString1 + ", appVersion:" + paramInt + ", pagesJson.length=" + paramString2.length() + ')';
      l = SystemClock.elapsedRealtime();
      String str1 = aJ(paramString1, paramInt);
      paramString2 = paramString2.getBytes(d.UTF_8);
      p.g(paramString2, "(this as java.lang.String).getBytes(charset)");
      str1 = Integer.valueOf(com.tencent.mm.vfs.o.C(str1, paramString2)).toString();
      paramString2 = str1;
      if (str1 == null) {
        paramString2 = "";
      }
      bool = ag.Ck();
      l = SystemClock.elapsedRealtime() - l;
      if ((l > 32L) && (bool))
      {
        ae.w("Luggage.Utils.Profile", "block main thread and skip " + (int)(l / 16L) + " frames! runProfiled:log:" + str2 + " cost " + l + " ms result:" + paramString2 + " isMainThread: " + bool + ' ');
        AppMethodBeat.o(223202);
        return;
      }
    }
    catch (IOException paramString2)
    {
      ae.e("MicroMsg.WxaVersionPagePathIndexStorage.IndexStorageMM", "updatePageIndex(appId:" + paramString1 + ", appVersion:" + paramInt + "), writeFile failed by " + paramString2);
      AppMethodBeat.o(223202);
      return;
    }
    ae.i("Luggage.Utils.Profile", "runProfiled:log:" + str2 + " cost " + l + " ms result:" + paramString2 + " isMainThread: " + bool + ' ');
    AppMethodBeat.o(223202);
  }
  
  public final void LQ(String paramString)
  {
    AppMethodBeat.i(223205);
    p.h(paramString, "appId");
    if (!g.ajP().aiZ())
    {
      ae.e("MicroMsg.WxaVersionPagePathIndexStorage.IndexStorageMM", "removeIndexByAppId(" + paramString + "), account().hasInitialized()==FALSE");
      AppMethodBeat.o(223205);
      return;
    }
    Object localObject = new com.tencent.mm.vfs.k(bam());
    if ((!((com.tencent.mm.vfs.k)localObject).exists()) || (!((com.tencent.mm.vfs.k)localObject).isDirectory())) {
      try
      {
        ((com.tencent.mm.vfs.k)localObject).delete();
        AppMethodBeat.o(223205);
        return;
      }
      catch (Exception paramString)
      {
        AppMethodBeat.o(223205);
        return;
      }
    }
    com.tencent.mm.vfs.k[] arrayOfk = ((com.tencent.mm.vfs.k)localObject).fTj();
    p.g(arrayOfk, "dir.listFiles()");
    int k = arrayOfk.length;
    int i = 0;
    if (i < k)
    {
      com.tencent.mm.vfs.k localk = arrayOfk[i];
      p.g(localk, "file");
      localObject = (CharSequence)localk.getName();
      int j;
      if ((localObject == null) || (((CharSequence)localObject).length() == 0))
      {
        j = 1;
        label173:
        if (j == 0)
        {
          localObject = localk.getName();
          p.g(localObject, "file.name");
          localObject = LP((String)localObject);
          if (localObject == null) {
            break label241;
          }
        }
      }
      label241:
      for (localObject = (String)((d.o)localObject).first;; localObject = null)
      {
        if (p.i(paramString, localObject)) {
          localk.delete();
        }
        i += 1;
        break;
        j = 0;
        break label173;
      }
    }
    AppMethodBeat.o(223205);
  }
  
  public final boolean aK(String paramString, int paramInt)
  {
    AppMethodBeat.i(223201);
    p.h(paramString, "appId");
    if (!g.ajP().aiZ())
    {
      ae.e("MicroMsg.WxaVersionPagePathIndexStorage.IndexStorageMM", "checkIsPageIndexExisted(appId:" + paramString + ", appVersion:" + paramInt + "), account().hasInitialized()==FALSE");
      AppMethodBeat.o(223201);
      return false;
    }
    boolean bool = com.tencent.mm.vfs.o.fB(aJ(paramString, paramInt));
    AppMethodBeat.o(223201);
    return bool;
  }
  
  public final void ban()
  {
    AppMethodBeat.i(223203);
    if (!g.ajP().aiZ())
    {
      ae.e("MicroMsg.WxaVersionPagePathIndexStorage.IndexStorageMM", "cleanExpiredIndex(), account().hasInitialized()==FALSE");
      AppMethodBeat.o(223203);
      return;
    }
    Object localObject1 = new com.tencent.mm.vfs.k(bam());
    if ((!((com.tencent.mm.vfs.k)localObject1).exists()) || (!((com.tencent.mm.vfs.k)localObject1).isDirectory())) {
      try
      {
        ((com.tencent.mm.vfs.k)localObject1).delete();
        AppMethodBeat.o(223203);
        return;
      }
      catch (Exception localException)
      {
        AppMethodBeat.o(223203);
        return;
      }
    }
    w localw = (w)com.tencent.mm.plugin.appbrand.app.j.T(w.class);
    if (localw == null)
    {
      AppMethodBeat.o(223203);
      return;
    }
    s locals = (s)com.tencent.mm.plugin.appbrand.app.j.T(s.class);
    if (locals == null)
    {
      AppMethodBeat.o(223203);
      return;
    }
    localObject1 = ((com.tencent.mm.vfs.k)localObject1).fTj();
    p.g(localObject1, "dir.listFiles()");
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
        label193:
        if (j == 0)
        {
          localObject3 = localObject2.getName();
          p.g(localObject3, "file.name");
          localObject3 = LP((String)localObject3);
          if (localObject3 != null) {
            break label236;
          }
        }
      }
      for (;;)
      {
        i += 1;
        break;
        j = 0;
        break label193;
        label236:
        String str = (String)((d.o)localObject3).first;
        j = ((Number)((d.o)localObject3).second).intValue();
        if ((!a((u)localw, str, j)) && (!a((u)locals, str, j))) {
          localObject2.delete();
        }
      }
    }
    AppMethodBeat.o(223203);
  }
  
  public final boolean l(String paramString1, int paramInt, String paramString2)
  {
    AppMethodBeat.i(223200);
    p.h(paramString1, "appId");
    p.h(paramString2, "pagePath");
    if (!g.ajP().aiZ())
    {
      ae.e("MicroMsg.WxaVersionPagePathIndexStorage.IndexStorageMM", "checkIsPagePathIncluded(appId:" + paramString1 + ", appVersion:" + paramInt + ", pagePath:" + paramString2 + "), account().hasInitialized()==FALSE");
      AppMethodBeat.o(223200);
      return false;
    }
    String str1 = com.tencent.luggage.h.k.dt(paramString2);
    String str2;
    Object localObject2;
    Object localObject1;
    if (str1 == null)
    {
      str1 = "";
      str2 = d.n.n.c(str1, (CharSequence)".html");
      if (((CharSequence)str2).length() == 0) {}
      for (int i = 1; i != 0; i = 0)
      {
        AppMethodBeat.o(223200);
        return false;
      }
      try
      {
        str1 = com.tencent.mm.vfs.o.aZT(aJ(paramString1, paramInt));
        localObject2 = (CharSequence)str1;
        if ((localObject2 == null) || (((CharSequence)localObject2).length() == 0))
        {
          i = 1;
          if (i == 0) {
            break label210;
          }
          AppMethodBeat.o(223200);
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
        bool = ag.Ck();
        l = SystemClock.elapsedRealtime() - l;
        if ((l <= 32L) || (!bool)) {
          continue;
        }
        ae.w("Luggage.Utils.Profile", "block main thread and skip " + (int)(l / 16L) + " frames! runProfiled:log:" + (String)localObject2 + " cost " + l + " ms result:" + (String)localObject1 + " isMainThread: " + bool + ' ');
        bool = localBoolean.booleanValue();
      }
      catch (Exception localException)
      {
        long l;
        ae.e("MicroMsg.WxaVersionPagePathIndexStorage.IndexStorageMM", "checkIsPagePathIncluded(appId:" + paramString1 + ", appVersion:" + paramInt + ", pagePath:" + paramString2 + "), parse pagesJson failed by " + localException);
        bool = false;
        continue;
      }
      AppMethodBeat.o(223200);
      return bool;
      boolean bool = false;
      continue;
      if ((localObject1 instanceof b))
      {
        bool = d.a.j.a((Iterable)localObject1, com.eclipsesource.a.a.aQ(str2));
        continue;
        ae.i("Luggage.Utils.Profile", "runProfiled:log:" + (String)localObject2 + " cost " + l + " ms result:" + (String)localObject1 + " isMainThread: " + bool + ' ');
        continue;
        break;
      }
      bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.t
 * JD-Core Version:    0.7.0.1
 */