package com.tencent.mm.plugin.appbrand.appcache;

import android.os.SystemClock;
import com.eclipsesource.a.a;
import com.eclipsesource.a.e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.f;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.appbrand.app.m;
import com.tencent.mm.plugin.appbrand.utils.ai;
import com.tencent.mm.sdk.platformtools.FilePathGenerator;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.vfs.q;
import java.io.IOException;
import java.util.List;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.n.d;
import kotlin.n.n;
import kotlin.o;

@kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/appcache/IndexStorageMM;", "Lcom/tencent/mm/plugin/appbrand/appcache/WxaVersionPagePathIndexStorage;", "()V", "DIR_PATH", "", "getDIR_PATH", "()Ljava/lang/String;", "INDEX_FILE_SUFFIX", "TAG", "FILE_PATH", "appId", "appVersion", "", "PARSE_FILE_NAME", "Lkotlin/Pair;", "name", "checkIsPageIndexExisted", "", "checkIsPagePathIncluded", "pagePath", "cleanExpiredIndex", "", "removeIndexByAppId", "updatePageIndex", "pagesJson", "plugin-appbrand-integration_release"})
final class u
  implements bw
{
  public static final u nEH;
  
  static
  {
    AppMethodBeat.i(281370);
    nEH = new u();
    AppMethodBeat.o(281370);
  }
  
  private static o<String, Integer> acI(String paramString)
  {
    AppMethodBeat.i(281364);
    paramString = n.a((CharSequence)n.c(paramString, (CharSequence)".idx"), new char[] { '_' });
    try
    {
      paramString = new o((String)paramString.get(0), Integer.valueOf(Integer.parseInt((String)paramString.get(1))));
      AppMethodBeat.o(281364);
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
  
  private static String bGJ()
  {
    AppMethodBeat.i(281359);
    Object localObject = h.aHG();
    p.j(localObject, "MMKernel.storage()");
    String str = ((f)localObject).aHl();
    p.j(str, "accPath");
    localObject = str;
    if (!n.pu(str, "/")) {
      localObject = str + "/";
    }
    localObject = (String)localObject + "appbrand/pagesidx/";
    FilePathGenerator.checkMkdir((String)localObject);
    AppMethodBeat.o(281359);
    return localObject;
  }
  
  private static String bh(String paramString, int paramInt)
  {
    AppMethodBeat.i(281361);
    paramString = new q(bGJ(), paramString + '_' + paramInt + ".idx").bOF();
    p.j(paramString, "VFSFile(DIR_PATH, \"${app…LE_SUFFIX}\").absolutePath");
    AppMethodBeat.o(281361);
    return paramString;
  }
  
  public static void q(String paramString1, int paramInt, String paramString2)
  {
    AppMethodBeat.i(281367);
    p.k(paramString1, "appId");
    p.k(paramString2, "pagesJson");
    if (!h.aHE().aGM())
    {
      Log.e("MicroMsg.WxaVersionPagePathIndexStorage.IndexStorageMM", "updatePageIndex(appId:" + paramString1 + ", appVersion:" + paramInt + "), account().hasInitialized()==FALSE");
      AppMethodBeat.o(281367);
      return;
    }
    String str2;
    long l;
    boolean bool;
    try
    {
      str2 = "updatePageIndex(appId:" + paramString1 + ", appVersion:" + paramInt + ", pagesJson.length=" + paramString2.length() + ')';
      l = SystemClock.elapsedRealtime();
      String str1 = bh(paramString1, paramInt);
      paramString2 = paramString2.getBytes(d.UTF_8);
      p.j(paramString2, "(this as java.lang.String).getBytes(charset)");
      str1 = Integer.valueOf(com.tencent.mm.vfs.u.H(str1, paramString2)).toString();
      paramString2 = str1;
      if (str1 == null) {
        paramString2 = "";
      }
      bool = ai.Or();
      l = SystemClock.elapsedRealtime() - l;
      if ((l > 32L) && (bool))
      {
        Log.w("Luggage.Utils.Profile", "block main thread and skip " + (int)(l / 16L) + " frames! runProfiled:log:" + str2 + " cost " + l + " ms result:" + paramString2 + " isMainThread: " + bool + ' ');
        AppMethodBeat.o(281367);
        return;
      }
    }
    catch (IOException paramString2)
    {
      Log.e("MicroMsg.WxaVersionPagePathIndexStorage.IndexStorageMM", "updatePageIndex(appId:" + paramString1 + ", appVersion:" + paramInt + "), writeFile failed by " + paramString2);
      AppMethodBeat.o(281367);
      return;
    }
    Log.i("Luggage.Utils.Profile", "runProfiled:log:" + str2 + " cost " + l + " ms result:" + paramString2 + " isMainThread: " + bool + ' ');
    AppMethodBeat.o(281367);
  }
  
  public final void acJ(String paramString)
  {
    AppMethodBeat.i(281369);
    p.k(paramString, "appId");
    if (!h.aHE().aGM())
    {
      Log.e("MicroMsg.WxaVersionPagePathIndexStorage.IndexStorageMM", "removeIndexByAppId(" + paramString + "), account().hasInitialized()==FALSE");
      AppMethodBeat.o(281369);
      return;
    }
    Object localObject = new q(bGJ());
    if ((!((q)localObject).ifE()) || (!((q)localObject).isDirectory())) {
      try
      {
        ((q)localObject).cFq();
        AppMethodBeat.o(281369);
        return;
      }
      catch (Exception paramString)
      {
        AppMethodBeat.o(281369);
        return;
      }
    }
    q[] arrayOfq = ((q)localObject).ifJ();
    if (arrayOfq != null)
    {
      int k = arrayOfq.length;
      int i = 0;
      if (i < k)
      {
        q localq = arrayOfq[i];
        label147:
        int j;
        if (localq != null)
        {
          localObject = localq.getName();
          localObject = (CharSequence)localObject;
          if ((localObject != null) && (((CharSequence)localObject).length() != 0)) {
            break label248;
          }
          j = 1;
          label171:
          if (j == 0)
          {
            if (localq == null) {
              p.iCn();
            }
            localObject = localq.getName();
            p.j(localObject, "file!!.name");
            localObject = acI((String)localObject);
            if (localObject == null) {
              break label253;
            }
          }
        }
        label248:
        label253:
        for (localObject = (String)((o)localObject).Mx;; localObject = null)
        {
          if (p.h(paramString, localObject)) {
            localq.cFq();
          }
          i += 1;
          break;
          localObject = null;
          break label147;
          j = 0;
          break label171;
        }
      }
      AppMethodBeat.o(281369);
      return;
    }
    AppMethodBeat.o(281369);
  }
  
  public final void bGK()
  {
    AppMethodBeat.i(281368);
    if (!h.aHE().aGM())
    {
      Log.e("MicroMsg.WxaVersionPagePathIndexStorage.IndexStorageMM", "cleanExpiredIndex(), account().hasInitialized()==FALSE");
      AppMethodBeat.o(281368);
      return;
    }
    q localq1 = new q(bGJ());
    if ((!localq1.ifE()) || (!localq1.isDirectory())) {
      try
      {
        localq1.cFq();
        AppMethodBeat.o(281368);
        return;
      }
      catch (Exception localException)
      {
        AppMethodBeat.o(281368);
        return;
      }
    }
    bm localbm = m.bFP();
    if (localbm == null)
    {
      AppMethodBeat.o(281368);
      return;
    }
    q[] arrayOfq = localException.ifJ();
    if (arrayOfq != null)
    {
      int k = arrayOfq.length;
      int i = 0;
      if (i < k)
      {
        q localq2 = arrayOfq[i];
        Object localObject;
        label138:
        int j;
        if (localq2 != null)
        {
          localObject = localq2.getName();
          localObject = (CharSequence)localObject;
          if ((localObject != null) && (((CharSequence)localObject).length() != 0)) {
            break label214;
          }
          j = 1;
          label162:
          if (j == 0)
          {
            if (localq2 == null) {
              p.iCn();
            }
            localObject = localq2.getName();
            p.j(localObject, "file!!.name");
            localObject = acI((String)localObject);
            if (localObject != null) {
              break label219;
            }
          }
        }
        for (;;)
        {
          i += 1;
          break;
          localObject = null;
          break label138;
          label214:
          j = 0;
          break label162;
          label219:
          if (!localbm.bq((String)((o)localObject).Mx, ((Number)((o)localObject).My).intValue())) {
            localq2.cFq();
          }
        }
      }
      AppMethodBeat.o(281368);
      return;
    }
    AppMethodBeat.o(281368);
  }
  
  public final boolean bi(String paramString, int paramInt)
  {
    AppMethodBeat.i(281366);
    p.k(paramString, "appId");
    if (!h.aHE().aGM())
    {
      Log.e("MicroMsg.WxaVersionPagePathIndexStorage.IndexStorageMM", "checkIsPageIndexExisted(appId:" + paramString + ", appVersion:" + paramInt + "), account().hasInitialized()==FALSE");
      AppMethodBeat.o(281366);
      return false;
    }
    boolean bool = com.tencent.mm.vfs.u.agG(bh(paramString, paramInt));
    AppMethodBeat.o(281366);
    return bool;
  }
  
  public final boolean p(String paramString1, int paramInt, String paramString2)
  {
    AppMethodBeat.i(281365);
    p.k(paramString1, "appId");
    p.k(paramString2, "pagePath");
    if (!h.aHE().aGM())
    {
      Log.e("MicroMsg.WxaVersionPagePathIndexStorage.IndexStorageMM", "checkIsPagePathIncluded(appId:" + paramString1 + ", appVersion:" + paramInt + ", pagePath:" + paramString2 + "), account().hasInitialized()==FALSE");
      AppMethodBeat.o(281365);
      return false;
    }
    String str1 = com.tencent.luggage.k.l.eo(paramString2);
    String str2;
    Object localObject2;
    Object localObject1;
    if (str1 == null)
    {
      str1 = "";
      str2 = n.c(str1, (CharSequence)".html");
      if (((CharSequence)str2).length() == 0) {}
      for (int i = 1; i != 0; i = 0)
      {
        AppMethodBeat.o(281365);
        return false;
      }
      try
      {
        str1 = com.tencent.mm.vfs.u.bBS(bh(paramString1, paramInt));
        localObject2 = (CharSequence)str1;
        if ((localObject2 == null) || (((CharSequence)localObject2).length() == 0))
        {
          i = 1;
          if (i == 0) {
            break label208;
          }
          AppMethodBeat.o(281365);
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
        label208:
        localObject2 = "checkIsPagePathIncluded(pagesJson.length=" + ((String)localObject1).length() + ')';
        l = SystemClock.elapsedRealtime();
        localObject1 = a.bb((String)localObject1);
        if (!(localObject1 instanceof e)) {
          continue;
        }
        if (((e)localObject1).be(str2) == null) {
          continue;
        }
        bool = true;
        Boolean localBoolean = Boolean.valueOf(bool);
        str2 = localBoolean.toString();
        localObject1 = str2;
        if (str2 == null) {
          localObject1 = "";
        }
        bool = ai.Or();
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
      AppMethodBeat.o(281365);
      return bool;
      boolean bool = false;
      continue;
      if ((localObject1 instanceof com.eclipsesource.a.b))
      {
        bool = j.a((Iterable)localObject1, a.ba(str2));
        continue;
        Log.i("Luggage.Utils.Profile", "runProfiled:log:" + (String)localObject2 + " cost " + l + " ms result:" + (String)localObject1 + " isMainThread: " + bool + ' ');
        continue;
        break;
      }
      bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.u
 * JD-Core Version:    0.7.0.1
 */