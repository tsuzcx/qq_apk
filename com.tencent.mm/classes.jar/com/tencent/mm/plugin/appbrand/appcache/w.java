package com.tencent.mm.plugin.appbrand.appcache;

import android.os.SystemClock;
import com.eclipsesource.a.a;
import com.eclipsesource.a.e;
import com.tencent.luggage.l.m;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.f;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.appbrand.utils.ao;
import com.tencent.mm.sdk.platformtools.FilePathGenerator;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.vfs.ah;
import com.tencent.mm.vfs.u;
import com.tencent.mm.vfs.y;
import java.io.IOException;
import java.util.List;
import kotlin.Metadata;
import kotlin.a.p;
import kotlin.g.b.s;
import kotlin.r;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/appcache/IndexStorageMM;", "Lcom/tencent/mm/plugin/appbrand/appcache/WxaVersionPagePathIndexStorage;", "()V", "DIR_PATH", "", "getDIR_PATH", "()Ljava/lang/String;", "INDEX_FILE_SUFFIX", "TAG", "FILE_PATH", "appId", "appVersion", "", "PARSE_FILE_NAME", "Lkotlin/Pair;", "name", "checkIsPageIndexExisted", "", "checkIsPagePathIncluded", "pagePath", "cleanExpiredIndex", "", "removeIndexByAppId", "updatePageIndex", "pagesJson", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
final class w
  implements bv
{
  public static final w qEE;
  
  static
  {
    AppMethodBeat.i(320318);
    qEE = new w();
    AppMethodBeat.o(320318);
  }
  
  private static r<String, Integer> Vh(String paramString)
  {
    AppMethodBeat.i(320307);
    paramString = kotlin.n.n.a((CharSequence)kotlin.n.n.d(paramString, (CharSequence)".idx"), new char[] { '_' }, 0, 6);
    try
    {
      paramString = new r((String)paramString.get(0), Integer.valueOf(Integer.parseInt((String)paramString.get(1))));
      AppMethodBeat.o(320307);
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
  
  private static String by(String paramString, int paramInt)
  {
    AppMethodBeat.i(320302);
    paramString = ah.v(new u(cgh(), paramString + '_' + paramInt + ".idx").jKT());
    s.s(paramString, "VFSFile(DIR_PATH, \"${app…LE_SUFFIX}\").absolutePath");
    AppMethodBeat.o(320302);
    return paramString;
  }
  
  private static String cgh()
  {
    AppMethodBeat.i(320298);
    String str2 = h.baE().cachePath;
    s.s(str2, "accPath");
    String str1 = str2;
    if (!kotlin.n.n.rs(str2, "/")) {
      str1 = s.X(str2, "/");
    }
    str1 = s.X(str1, "appbrand/pagesidx/");
    FilePathGenerator.checkMkdir(str1);
    AppMethodBeat.o(320298);
    return str1;
  }
  
  public static void s(String paramString1, int paramInt, String paramString2)
  {
    AppMethodBeat.i(320314);
    s.u(paramString1, "appId");
    s.u(paramString2, "pagesJson");
    if (!h.baC().aZN())
    {
      Log.e("MicroMsg.WxaVersionPagePathIndexStorage.IndexStorageMM", "updatePageIndex(appId:" + paramString1 + ", appVersion:" + paramInt + "), account().hasInitialized()==FALSE");
      AppMethodBeat.o(320314);
      return;
    }
    String str;
    long l;
    boolean bool;
    try
    {
      str = "updatePageIndex(appId:" + paramString1 + ", appVersion:" + paramInt + ", pagesJson.length=" + paramString2.length() + ')';
      Object localObject = com.tencent.luggage.sdk.h.d.evM;
      l = SystemClock.elapsedRealtime();
      localObject = by(paramString1, paramInt);
      paramString2 = paramString2.getBytes(kotlin.n.d.UTF_8);
      s.s(paramString2, "(this as java.lang.String).getBytes(charset)");
      localObject = Integer.valueOf(y.f((String)localObject, paramString2, paramString2.length)).toString();
      paramString2 = (String)localObject;
      if (localObject == null) {
        paramString2 = "";
      }
      bool = ao.aoz();
      l = SystemClock.elapsedRealtime() - l;
      if ((l > 32L) && (bool))
      {
        Log.w("Luggage.Utils.Profile", "block main thread and skip " + (int)(l / 16L) + " frames! runProfiled:log:" + str + " cost " + l + " ms result:" + paramString2 + " isMainThread: " + bool + ' ');
        AppMethodBeat.o(320314);
        return;
      }
    }
    catch (IOException paramString2)
    {
      Log.e("MicroMsg.WxaVersionPagePathIndexStorage.IndexStorageMM", "updatePageIndex(appId:" + paramString1 + ", appVersion:" + paramInt + "), writeFile failed by " + paramString2);
      AppMethodBeat.o(320314);
      return;
    }
    Log.i("Luggage.Utils.Profile", "runProfiled:log:" + str + " cost " + l + " ms result:" + paramString2 + " isMainThread: " + bool + ' ');
    AppMethodBeat.o(320314);
  }
  
  public final void Vi(String paramString)
  {
    AppMethodBeat.i(320337);
    s.u(paramString, "appId");
    if (!h.baC().aZN())
    {
      Log.e("MicroMsg.WxaVersionPagePathIndexStorage.IndexStorageMM", "removeIndexByAppId(" + paramString + "), account().hasInitialized()==FALSE");
      AppMethodBeat.o(320337);
      return;
    }
    Object localObject = new u(cgh());
    if ((!((u)localObject).jKS()) || (!((u)localObject).isDirectory())) {
      try
      {
        ((u)localObject).diJ();
        AppMethodBeat.o(320337);
        return;
      }
      catch (Exception paramString)
      {
        AppMethodBeat.o(320337);
        return;
      }
    }
    u[] arrayOfu = ((u)localObject).jKX();
    if (arrayOfu != null)
    {
      int k = arrayOfu.length;
      int i = 0;
      if (i < k)
      {
        u localu = arrayOfu[i];
        label143:
        int j;
        if (localu == null)
        {
          localObject = null;
          localObject = (CharSequence)localObject;
          if ((localObject != null) && (((CharSequence)localObject).length() != 0)) {
            break label238;
          }
          j = 1;
          label167:
          if (j == 0)
          {
            s.checkNotNull(localu);
            localObject = localu.getName();
            s.s(localObject, "file!!.name");
            localObject = Vh((String)localObject);
            if (localObject != null) {
              break label243;
            }
          }
        }
        label238:
        label243:
        for (localObject = null;; localObject = (String)((r)localObject).bsC)
        {
          if (s.p(paramString, localObject)) {
            localu.diJ();
          }
          i += 1;
          break;
          localObject = localu.getName();
          break label143;
          j = 0;
          break label167;
        }
      }
    }
    AppMethodBeat.o(320337);
  }
  
  public final boolean bz(String paramString, int paramInt)
  {
    AppMethodBeat.i(320327);
    s.u(paramString, "appId");
    if (!h.baC().aZN())
    {
      Log.e("MicroMsg.WxaVersionPagePathIndexStorage.IndexStorageMM", "checkIsPageIndexExisted(appId:" + paramString + ", appVersion:" + paramInt + "), account().hasInitialized()==FALSE");
      AppMethodBeat.o(320327);
      return false;
    }
    boolean bool = y.ZC(by(paramString, paramInt));
    AppMethodBeat.o(320327);
    return bool;
  }
  
  public final void cgi()
  {
    AppMethodBeat.i(320333);
    if (!h.baC().aZN())
    {
      Log.e("MicroMsg.WxaVersionPagePathIndexStorage.IndexStorageMM", "cleanExpiredIndex(), account().hasInitialized()==FALSE");
      AppMethodBeat.o(320333);
      return;
    }
    u localu1 = new u(cgh());
    if ((!localu1.jKS()) || (!localu1.isDirectory())) {
      try
      {
        localu1.diJ();
        AppMethodBeat.o(320333);
        return;
      }
      catch (Exception localException)
      {
        AppMethodBeat.o(320333);
        return;
      }
    }
    bm localbm = com.tencent.mm.plugin.appbrand.app.n.cfm();
    if (localbm == null)
    {
      AppMethodBeat.o(320333);
      return;
    }
    u[] arrayOfu = localException.jKX();
    if (arrayOfu != null)
    {
      int k = arrayOfu.length;
      int i = 0;
      if (i < k)
      {
        u localu2 = arrayOfu[i];
        Object localObject;
        if (localu2 == null)
        {
          localObject = null;
          label134:
          localObject = (CharSequence)localObject;
          if ((localObject != null) && (((CharSequence)localObject).length() != 0)) {
            break label244;
          }
        }
        label244:
        for (int j = 1;; j = 0)
        {
          if (j == 0)
          {
            s.checkNotNull(localu2);
            localObject = localu2.getName();
            s.s(localObject, "file!!.name");
            localObject = Vh((String)localObject);
            if ((localObject != null) && (!localbm.bH((String)((r)localObject).bsC, ((Number)((r)localObject).bsD).intValue()))) {
              localu2.diJ();
            }
          }
          i += 1;
          break;
          localObject = localu2.getName();
          break label134;
        }
      }
    }
    AppMethodBeat.o(320333);
  }
  
  public final boolean r(String paramString1, int paramInt, String paramString2)
  {
    AppMethodBeat.i(320323);
    s.u(paramString1, "appId");
    s.u(paramString2, "pagePath");
    if (!h.baC().aZN())
    {
      Log.e("MicroMsg.WxaVersionPagePathIndexStorage.IndexStorageMM", "checkIsPagePathIncluded(appId:" + paramString1 + ", appVersion:" + paramInt + ", pagePath:" + paramString2 + "), account().hasInitialized()==FALSE");
      AppMethodBeat.o(320323);
      return false;
    }
    String str1 = m.fL(paramString2);
    String str2;
    Object localObject2;
    Object localObject1;
    if (str1 == null)
    {
      str1 = "";
      str2 = kotlin.n.n.d(str1, (CharSequence)".html");
      if (((CharSequence)str2).length() == 0) {}
      for (int i = 1; i != 0; i = 0)
      {
        AppMethodBeat.o(320323);
        return false;
      }
      try
      {
        str1 = y.bEn(by(paramString1, paramInt));
        localObject2 = (CharSequence)str1;
        if ((localObject2 == null) || (((CharSequence)localObject2).length() == 0))
        {
          i = 1;
          if (i == 0) {
            break label210;
          }
          AppMethodBeat.o(320323);
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
        Object localObject3 = com.tencent.luggage.sdk.h.d.evM;
        l = SystemClock.elapsedRealtime();
        localObject1 = a.co((String)localObject1);
        if (!(localObject1 instanceof e)) {
          continue;
        }
        if (((e)localObject1).cr(str2) == null) {
          continue;
        }
        bool = true;
        localObject3 = Boolean.valueOf(bool);
        str2 = localObject3.toString();
        localObject1 = str2;
        if (str2 == null) {
          localObject1 = "";
        }
        bool = ao.aoz();
        l = SystemClock.elapsedRealtime() - l;
        if ((l <= 32L) || (!bool)) {
          continue;
        }
        Log.w("Luggage.Utils.Profile", "block main thread and skip " + (int)(l / 16L) + " frames! runProfiled:log:" + (String)localObject2 + " cost " + l + " ms result:" + (String)localObject1 + " isMainThread: " + bool + ' ');
        bool = ((Boolean)localObject3).booleanValue();
      }
      catch (Exception localException)
      {
        long l;
        Log.e("MicroMsg.WxaVersionPagePathIndexStorage.IndexStorageMM", "checkIsPagePathIncluded(appId:" + paramString1 + ", appVersion:" + paramInt + ", pagePath:" + paramString2 + "), parse pagesJson failed by " + localException);
        bool = false;
        continue;
      }
      AppMethodBeat.o(320323);
      return bool;
      boolean bool = false;
      continue;
      if ((localObject1 instanceof com.eclipsesource.a.b))
      {
        s.s(localObject1, "it");
        bool = p.a((Iterable)localObject1, a.cn(str2));
        continue;
        Log.i("Luggage.Utils.Profile", "runProfiled:log:" + (String)localObject2 + " cost " + l + " ms result:" + (String)localObject1 + " isMainThread: " + bool + ' ');
        continue;
        break;
      }
      bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.w
 * JD-Core Version:    0.7.0.1
 */