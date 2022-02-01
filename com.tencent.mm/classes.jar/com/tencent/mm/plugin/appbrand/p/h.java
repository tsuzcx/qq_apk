package com.tencent.mm.plugin.appbrand.p;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appcache.ModulePkgInfo;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo.a;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes.WxaVersionModuleInfo;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.List<+TM;>;
import kotlin.a.j;
import kotlin.b.a;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.n.n;
import kotlin.t;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/modularizing/WxaRuntimeModularizingUtils;", "", "()V", "TAG", "", "moduleAliases", "", "getModuleAliases", "(Ljava/lang/Object;)[Ljava/lang/String;", "moduleName", "getModuleName", "(Ljava/lang/Object;)Ljava/lang/String;", "findModule", "M", "", "pathOrModule", "message", "print", "", "(Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Z)Ljava/lang/Object;", "matchModule", "pathOrModuleName", "(Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;)Z", "sortModuleList", "splitPathPartsArray", "(Ljava/lang/String;)[Ljava/lang/String;", "startsWith", "prefixArr", "([Ljava/lang/String;[Ljava/lang/String;)Z", "WxaPkgModuleListMatcherIMPL", "luggage-wechat-full-sdk_release"})
public final class h
{
  public static final h nhn;
  
  static
  {
    AppMethodBeat.i(230118);
    nhn = new h();
    AppMethodBeat.o(230118);
  }
  
  public static final <M> boolean a(M paramM, String paramString1, String paramString2)
  {
    AppMethodBeat.i(230113);
    p.h(paramString1, "pathOrModuleName");
    boolean bool = p.j(c(j.listOf(paramM), paramString1, paramString2), paramM);
    AppMethodBeat.o(230113);
    return bool;
  }
  
  private static String[] acP(String paramString)
  {
    AppMethodBeat.i(230117);
    int j = ((CharSequence)paramString).length();
    int i = 0;
    if (i < j) {
      if (paramString.charAt(i) == '/') {}
    }
    for (;;)
    {
      int k = paramString.length();
      j = paramString.length() - 1;
      for (;;)
      {
        if ((j >= 0) && (paramString.charAt(j) == '/'))
        {
          k -= 1;
          j -= 1;
          continue;
          i += 1;
          break;
        }
      }
      if (paramString == null)
      {
        paramString = new t("null cannot be cast to non-null type java.lang.String");
        AppMethodBeat.o(230117);
        throw paramString;
      }
      paramString = paramString.substring(i, k);
      p.g(paramString, "(this as java.lang.Strin…ing(startIndex, endIndex)");
      paramString = ((Collection)n.a((CharSequence)paramString, new String[] { "/" })).toArray(new String[0]);
      if (paramString == null)
      {
        paramString = new t("null cannot be cast to non-null type kotlin.Array<T>");
        AppMethodBeat.o(230117);
        throw paramString;
      }
      paramString = (String[])paramString;
      AppMethodBeat.o(230117);
      return paramString;
      i = 0;
    }
  }
  
  private static <M> M c(List<? extends M> paramList, String paramString1, String paramString2)
  {
    AppMethodBeat.i(230114);
    p.h(paramList, "$this$findModule");
    p.h(paramString1, "pathOrModule");
    String[] arrayOfString = acP(paramString1);
    p.h(paramList, "$this$sortModuleList");
    Iterator localIterator = ((Iterable)j.a((Iterable)paramList, (Comparator)new b())).iterator();
    label269:
    label401:
    label432:
    label437:
    while (localIterator.hasNext())
    {
      Object localObject2 = localIterator.next();
      Object localObject1;
      if (localObject2 != null)
      {
        paramList = cK(localObject2);
        if (paramList != null)
        {
          localObject1 = acP(paramList);
          paramList = (List<? extends M>)localObject1;
          if (localObject1 != null) {
            break label109;
          }
        }
      }
      paramList = new String[0];
      label109:
      int i;
      if (arrayOfString.length < paramList.length)
      {
        i = 0;
        if (i == 0) {
          break label247;
        }
        localObject1 = new StringBuilder("findModule, hit module by name:");
        if (localObject2 == null) {
          break label242;
        }
      }
      int j;
      label237:
      label242:
      for (paramList = cK(localObject2);; paramList = null)
      {
        Log.i("Luggage.FULL.WxaRuntimeModularizingUtils", paramList + ", path:" + paramString1 + ", message[ " + paramString2 + " ]");
        if (localObject2 == null) {
          p.hyc();
        }
        AppMethodBeat.o(230114);
        return localObject2;
        j = paramList.length;
        i = 0;
        for (;;)
        {
          if (i >= j) {
            break label237;
          }
          if ((p.j(arrayOfString[i], paramList[i]) ^ true))
          {
            i = 0;
            break;
          }
          i += 1;
        }
        i = 1;
        break;
      }
      label247:
      if (localObject2 != null)
      {
        int k;
        if ((localObject2 instanceof WxaAttributes.WxaVersionModuleInfo))
        {
          paramList = ((WxaAttributes.WxaVersionModuleInfo)localObject2).aliases;
          if (paramList == null) {
            break label401;
          }
          k = paramList.length;
          i = 0;
        }
        for (;;)
        {
          if (i >= k) {
            break label437;
          }
          localObject1 = paramList[i];
          CharSequence localCharSequence = (CharSequence)localObject1;
          if ((localCharSequence == null) || (localCharSequence.length() == 0)) {}
          for (j = 1;; j = 0)
          {
            if ((j != 0) || (!n.J(paramString1, (String)localObject1, false))) {
              break label432;
            }
            Log.i("Luggage.FULL.WxaRuntimeModularizingUtils", "findModule, hit module by alias:" + (String)localObject1 + ", path:" + paramString1 + ", message[ " + paramString2 + " ]");
            AppMethodBeat.o(230114);
            return localObject2;
            if ((localObject2 instanceof ModulePkgInfo))
            {
              paramList = ((ModulePkgInfo)localObject2).aliases;
              break label269;
              break;
            }
            paramList = (Throwable)new IllegalStateException("Only WxaAttributes.WxaVersionModuleInfo or ModulePkgInfo supported here.".toString());
            AppMethodBeat.o(230114);
            throw paramList;
          }
          i += 1;
        }
      }
    }
    Log.i("Luggage.FULL.WxaRuntimeModularizingUtils", "findModule, return null with path:" + paramString1 + ", message[ " + paramString2 + " ]");
    AppMethodBeat.o(230114);
    return null;
  }
  
  private static String cK(Object paramObject)
  {
    AppMethodBeat.i(230112);
    if ((paramObject instanceof WxaAttributes.WxaVersionModuleInfo))
    {
      paramObject = ((WxaAttributes.WxaVersionModuleInfo)paramObject).name;
      AppMethodBeat.o(230112);
      return paramObject;
    }
    if ((paramObject instanceof ModulePkgInfo))
    {
      paramObject = ((ModulePkgInfo)paramObject).name;
      AppMethodBeat.o(230112);
      return paramObject;
    }
    paramObject = (Throwable)new IllegalStateException("Only WxaAttributes.WxaVersionModuleInfo or ModulePkgInfo supported here.".toString());
    AppMethodBeat.o(230112);
    throw paramObject;
  }
  
  public static final <M> M e(List<? extends M> paramList, String paramString1, String paramString2)
  {
    AppMethodBeat.i(230116);
    paramList = c(paramList, paramString1, paramString2);
    AppMethodBeat.o(230116);
    return paramList;
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/modularizing/WxaRuntimeModularizingUtils$WxaPkgModuleListMatcherIMPL;", "Lcom/tencent/mm/plugin/appbrand/appcache/WxaPkgWrappingInfo$WxaPkgModuleListMatcher;", "()V", "findModule", "Lcom/tencent/mm/plugin/appbrand/appcache/ModulePkgInfo;", "moduleList", "", "pathOrModuleName", "", "message", "luggage-wechat-full-sdk_release"})
  public static final class a
    implements WxaPkgWrappingInfo.a
  {
    public static final a nho;
    
    static
    {
      AppMethodBeat.i(230110);
      nho = new a();
      AppMethodBeat.o(230110);
    }
    
    public final ModulePkgInfo b(List<? extends ModulePkgInfo> paramList, String paramString1, String paramString2)
    {
      AppMethodBeat.i(230109);
      p.h(paramList, "moduleList");
      p.h(paramString1, "pathOrModuleName");
      paramList = (ModulePkgInfo)h.d(paramList, paramString1, paramString2);
      AppMethodBeat.o(230109);
      return paramList;
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "T", "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareByDescending$1"})
  public static final class b<T>
    implements Comparator<T>
  {
    public final int compare(T paramT1, T paramT2)
    {
      AppMethodBeat.i(230111);
      if ((paramT2 instanceof WxaAttributes.WxaVersionModuleInfo))
      {
        i = ((WxaAttributes.WxaVersionModuleInfo)paramT2).name.length();
        paramT2 = (Comparable)Integer.valueOf(i);
        if (!(paramT1 instanceof WxaAttributes.WxaVersionModuleInfo)) {
          break label112;
        }
      }
      for (int i = ((WxaAttributes.WxaVersionModuleInfo)paramT1).name.length();; i = ((ModulePkgInfo)paramT1).name.length())
      {
        i = a.a(paramT2, (Comparable)Integer.valueOf(i));
        AppMethodBeat.o(230111);
        return i;
        if ((paramT2 instanceof ModulePkgInfo))
        {
          i = ((ModulePkgInfo)paramT2).name.length();
          break;
        }
        paramT1 = (Throwable)new IllegalStateException("Only WxaAttributes.WxaVersionModuleInfo or ModulePkgInfo supported here.".toString());
        AppMethodBeat.o(230111);
        throw paramT1;
        label112:
        if (!(paramT1 instanceof ModulePkgInfo)) {
          break label133;
        }
      }
      label133:
      paramT1 = (Throwable)new IllegalStateException("Only WxaAttributes.WxaVersionModuleInfo or ModulePkgInfo supported here.".toString());
      AppMethodBeat.o(230111);
      throw paramT1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.p.h
 * JD-Core Version:    0.7.0.1
 */