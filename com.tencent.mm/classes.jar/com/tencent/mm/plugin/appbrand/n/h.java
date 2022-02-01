package com.tencent.mm.plugin.appbrand.n;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appcache.ModulePkgInfo;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo.a;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes.WxaVersionModuleInfo;
import com.tencent.mm.sdk.platformtools.ac;
import d.a.j;
import d.b.a;
import d.g.b.k;
import d.l;
import d.n.n;
import d.v;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.List<+TM;>;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/appbrand/modularizing/WxaRuntimeModularizingUtils;", "", "()V", "TAG", "", "moduleAliases", "", "getModuleAliases", "(Ljava/lang/Object;)[Ljava/lang/String;", "moduleName", "getModuleName", "(Ljava/lang/Object;)Ljava/lang/String;", "findModule", "M", "", "pathOrModule", "message", "print", "", "(Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Z)Ljava/lang/Object;", "matchModule", "pathOrModuleName", "(Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;)Z", "sortModuleList", "splitPathPartsArray", "(Ljava/lang/String;)[Ljava/lang/String;", "startsWith", "prefixArr", "([Ljava/lang/String;[Ljava/lang/String;)Z", "WxaPkgModuleListMatcherIMPL", "luggage-wechat-full-sdk_release"})
public final class h
{
  public static final h lvP;
  
  static
  {
    AppMethodBeat.i(206221);
    lvP = new h();
    AppMethodBeat.o(206221);
  }
  
  private static String[] Pb(String paramString)
  {
    AppMethodBeat.i(206220);
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
        paramString = new v("null cannot be cast to non-null type java.lang.String");
        AppMethodBeat.o(206220);
        throw paramString;
      }
      paramString = paramString.substring(i, k);
      k.g(paramString, "(this as java.lang.Strin…ing(startIndex, endIndex)");
      paramString = ((Collection)n.a((CharSequence)paramString, new String[] { "/" })).toArray(new String[0]);
      if (paramString == null)
      {
        paramString = new v("null cannot be cast to non-null type kotlin.Array<T>");
        AppMethodBeat.o(206220);
        throw paramString;
      }
      paramString = (String[])paramString;
      AppMethodBeat.o(206220);
      return paramString;
      i = 0;
    }
  }
  
  public static final <M> boolean a(M paramM, String paramString1, String paramString2)
  {
    AppMethodBeat.i(210397);
    k.h(paramString1, "pathOrModuleName");
    boolean bool = k.g(g(j.listOf(paramM), paramString1, paramString2), paramM);
    AppMethodBeat.o(210397);
    return bool;
  }
  
  private static String cy(Object paramObject)
  {
    AppMethodBeat.i(206217);
    if ((paramObject instanceof WxaAttributes.WxaVersionModuleInfo))
    {
      paramObject = ((WxaAttributes.WxaVersionModuleInfo)paramObject).name;
      AppMethodBeat.o(206217);
      return paramObject;
    }
    if ((paramObject instanceof ModulePkgInfo))
    {
      paramObject = ((ModulePkgInfo)paramObject).name;
      AppMethodBeat.o(206217);
      return paramObject;
    }
    paramObject = (Throwable)new IllegalStateException("Only WxaAttributes.WxaVersionModuleInfo or ModulePkgInfo supported here.".toString());
    AppMethodBeat.o(206217);
    throw paramObject;
  }
  
  public static final <M> M d(List<? extends M> paramList, String paramString1, String paramString2)
  {
    AppMethodBeat.i(206219);
    paramList = g(paramList, paramString1, paramString2);
    AppMethodBeat.o(206219);
    return paramList;
  }
  
  private static <M> M g(List<? extends M> paramList, String paramString1, String paramString2)
  {
    AppMethodBeat.i(210398);
    k.h(paramList, "$this$findModule");
    k.h(paramString1, "pathOrModule");
    String[] arrayOfString = Pb(paramString1);
    k.h(paramList, "$this$sortModuleList");
    Iterator localIterator = ((Iterable)j.a((Iterable)paramList, (Comparator)new b())).iterator();
    Object localObject2;
    label109:
    int i;
    label138:
    label229:
    label234:
    String str;
    for (;;)
    {
      if (localIterator.hasNext())
      {
        localObject2 = localIterator.next();
        if (localObject2 != null)
        {
          paramList = cy(localObject2);
          if (paramList != null)
          {
            localObject1 = Pb(paramList);
            paramList = (List<? extends M>)localObject1;
            if (localObject1 != null) {
              break label109;
            }
          }
        }
        paramList = new String[0];
        int j = paramList.length;
        i = 0;
        if (i < j) {
          if ((k.g(arrayOfString[i], paramList[i]) ^ true))
          {
            i = 0;
            if (i == 0) {
              break label234;
            }
            localObject1 = new StringBuilder("findModule, hit module by name:");
            if (localObject2 == null) {
              break label229;
            }
          }
        }
        for (paramList = cy(localObject2);; paramList = null)
        {
          ac.i("Luggage.FULL.WxaRuntimeModularizingUtils", paramList + ", path:" + paramString1 + ", message[ " + paramString2 + " ]");
          if (localObject2 == null) {
            k.fOy();
          }
          AppMethodBeat.o(210398);
          return localObject2;
          i += 1;
          break;
          i = 1;
          break label138;
        }
        if (localObject2 != null) {
          if ((localObject2 instanceof WxaAttributes.WxaVersionModuleInfo))
          {
            paramList = ((WxaAttributes.WxaVersionModuleInfo)localObject2).aliases;
            label256:
            if (paramList == null) {
              break label366;
            }
            j = paramList.length;
            i = 0;
            label266:
            if (i >= j) {
              break label396;
            }
            str = paramList[i];
            if (str != null) {
              break label440;
            }
          }
        }
      }
    }
    label396:
    label440:
    for (Object localObject1 = "";; localObject1 = str)
    {
      if (n.nb(paramString1, (String)localObject1))
      {
        ac.i("Luggage.FULL.WxaRuntimeModularizingUtils", "findModule, hit module by alias:" + str + ", path:" + paramString1 + ", message[ " + paramString2 + " ]");
        AppMethodBeat.o(210398);
        return localObject2;
        if ((localObject2 instanceof ModulePkgInfo))
        {
          paramList = ((ModulePkgInfo)localObject2).aliases;
          break label256;
          label366:
          break;
        }
        paramList = (Throwable)new IllegalStateException("Only WxaAttributes.WxaVersionModuleInfo or ModulePkgInfo supported here.".toString());
        AppMethodBeat.o(210398);
        throw paramList;
      }
      i += 1;
      break label266;
      break;
      ac.i("Luggage.FULL.WxaRuntimeModularizingUtils", "findModule, return null with path:" + paramString1 + ", message[ " + paramString2 + " ]");
      AppMethodBeat.o(210398);
      return null;
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/appbrand/modularizing/WxaRuntimeModularizingUtils$WxaPkgModuleListMatcherIMPL;", "Lcom/tencent/mm/plugin/appbrand/appcache/WxaPkgWrappingInfo$WxaPkgModuleListMatcher;", "()V", "findModule", "Lcom/tencent/mm/plugin/appbrand/appcache/ModulePkgInfo;", "moduleList", "", "pathOrModuleName", "", "message", "luggage-wechat-full-sdk_release"})
  public static final class a
    implements WxaPkgWrappingInfo.a
  {
    public static final a lvQ;
    
    static
    {
      AppMethodBeat.i(206215);
      lvQ = new a();
      AppMethodBeat.o(206215);
    }
    
    public final ModulePkgInfo b(List<? extends ModulePkgInfo> paramList, String paramString1, String paramString2)
    {
      AppMethodBeat.i(206214);
      k.h(paramList, "moduleList");
      k.h(paramString1, "pathOrModuleName");
      paramList = (ModulePkgInfo)h.c(paramList, paramString1, paramString2);
      AppMethodBeat.o(206214);
      return paramList;
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "T", "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareByDescending$1"})
  public static final class b<T>
    implements Comparator<T>
  {
    public final int compare(T paramT1, T paramT2)
    {
      AppMethodBeat.i(206216);
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
        AppMethodBeat.o(206216);
        return i;
        if ((paramT2 instanceof ModulePkgInfo))
        {
          i = ((ModulePkgInfo)paramT2).name.length();
          break;
        }
        paramT1 = (Throwable)new IllegalStateException("Only WxaAttributes.WxaVersionModuleInfo or ModulePkgInfo supported here.".toString());
        AppMethodBeat.o(206216);
        throw paramT1;
        label112:
        if (!(paramT1 instanceof ModulePkgInfo)) {
          break label133;
        }
      }
      label133:
      paramT1 = (Throwable)new IllegalStateException("Only WxaAttributes.WxaVersionModuleInfo or ModulePkgInfo supported here.".toString());
      AppMethodBeat.o(206216);
      throw paramT1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.n.h
 * JD-Core Version:    0.7.0.1
 */