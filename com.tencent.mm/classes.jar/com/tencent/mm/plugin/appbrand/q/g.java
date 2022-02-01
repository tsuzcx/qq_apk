package com.tencent.mm.plugin.appbrand.q;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appcache.ModulePkgInfo;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes.WxaVersionModuleInfo;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.a.p;
import kotlin.b.a;
import kotlin.g.b.s;
import kotlin.n.n;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/modularizing/WxaRuntimeModularizingUtils;", "", "()V", "TAG", "", "moduleAliases", "", "getModuleAliases", "(Ljava/lang/Object;)[Ljava/lang/String;", "moduleName", "getModuleName", "(Ljava/lang/Object;)Ljava/lang/String;", "findModule", "M", "", "pathOrModule", "message", "print", "", "(Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Z)Ljava/lang/Object;", "matchModule", "pathOrModuleName", "(Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;)Z", "sortModuleList", "splitPathPartsArray", "(Ljava/lang/String;)[Ljava/lang/String;", "startsWith", "prefixArr", "([Ljava/lang/String;[Ljava/lang/String;)Z", "WxaPkgModuleListMatcherIMPL", "luggage-wechat-full-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class g
{
  public static final g tmG;
  
  static
  {
    AppMethodBeat.i(321611);
    tmG = new g();
    AppMethodBeat.o(321611);
  }
  
  public static final <M> boolean a(M paramM, String paramString1, String paramString2)
  {
    AppMethodBeat.i(321585);
    s.u(paramString1, "pathOrModuleName");
    boolean bool = s.p(a(p.listOf(paramM), paramString1, paramString2, 4), paramM);
    AppMethodBeat.o(321585);
    return bool;
  }
  
  private static String[] adP(String paramString)
  {
    AppMethodBeat.i(321597);
    int k = paramString.length() - 1;
    if (k >= 0) {}
    int j;
    label52:
    label188:
    label195:
    label200:
    for (int i = 0;; i = j)
    {
      j = i + 1;
      int m;
      int n;
      if (paramString.charAt(i) != '/')
      {
        k = i;
        i = paramString.length();
        m = paramString.length() - 1;
        if (m < 0) {
          break label195;
        }
        n = m - 1;
        j = i;
        if (paramString.charAt(m) == '/')
        {
          i -= 1;
          if (n >= 0) {
            break label188;
          }
        }
      }
      for (j = i;; j = i)
      {
        if (paramString == null)
        {
          paramString = new NullPointerException("null cannot be cast to non-null type java.lang.String");
          AppMethodBeat.o(321597);
          throw paramString;
          if (j <= k) {
            break label200;
          }
          k = 0;
          break;
        }
        paramString = paramString.substring(k, j);
        s.s(paramString, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        paramString = ((Collection)n.b((CharSequence)paramString, new String[] { "/" })).toArray(new String[0]);
        if (paramString == null)
        {
          paramString = new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
          AppMethodBeat.o(321597);
          throw paramString;
        }
        paramString = (String[])paramString;
        AppMethodBeat.o(321597);
        return paramString;
        m = n;
        break label52;
      }
    }
  }
  
  private static <M> M b(List<? extends M> paramList, String paramString1, String paramString2)
  {
    AppMethodBeat.i(321589);
    s.u(paramList, "<this>");
    s.u(paramString1, "pathOrModule");
    Object localObject2 = adP(paramString1);
    s.u(paramList, "<this>");
    Iterator localIterator = ((Iterable)p.a((Iterable)paramList, (Comparator)new b())).iterator();
    Object localObject1;
    label107:
    int k;
    if (localIterator.hasNext())
    {
      localObject1 = localIterator.next();
      if (localObject1 == null)
      {
        paramList = null;
        if (paramList != null) {
          break label188;
        }
      }
      label129:
      label188:
      for (paramList = (String[])new String[0];; paramList = adP(paramList))
      {
        if (localObject2.length >= paramList.length) {
          break label196;
        }
        i = 0;
        if (i == 0) {
          break label253;
        }
        localObject2 = new StringBuilder("findModule, hit module by name:");
        if (localObject1 != null) {
          break label244;
        }
        paramList = null;
        Log.i("Luggage.FULL.WxaRuntimeModularizingUtils", paramList + ", path:" + paramString1 + ", message[ " + paramString2 + " ]");
        s.checkNotNull(localObject1);
        AppMethodBeat.o(321589);
        return localObject1;
        paramList = eh(localObject1);
        break;
      }
      label196:
      k = paramList.length - 1;
      if (k < 0) {}
    }
    int j;
    for (int i = 0;; i = j)
    {
      j = i + 1;
      if (!s.p(localObject2[i], paramList[i]))
      {
        i = 0;
        break label107;
      }
      if (j > k)
      {
        i = 1;
        break label107;
        label244:
        paramList = eh(localObject1);
        break label129;
        label253:
        if (localObject1 == null) {
          break;
        }
        if ((localObject1 instanceof WxaAttributes.WxaVersionModuleInfo))
        {
          paramList = ((WxaAttributes.WxaVersionModuleInfo)localObject1).aliases;
          label275:
          if (paramList == null) {
            break label407;
          }
          k = paramList.length;
          i = 0;
        }
        for (;;)
        {
          if (i >= k) {
            break label443;
          }
          String str = paramList[i];
          CharSequence localCharSequence = (CharSequence)str;
          if ((localCharSequence == null) || (localCharSequence.length() == 0)) {}
          for (j = 1;; j = 0)
          {
            if ((j != 0) || (!n.U(paramString1, str, false))) {
              break label438;
            }
            Log.i("Luggage.FULL.WxaRuntimeModularizingUtils", "findModule, hit module by alias:" + str + ", path:" + paramString1 + ", message[ " + paramString2 + " ]");
            AppMethodBeat.o(321589);
            return localObject1;
            if ((localObject1 instanceof ModulePkgInfo))
            {
              paramList = ((ModulePkgInfo)localObject1).aliases;
              break label275;
              label407:
              break;
            }
            paramList = (Throwable)new IllegalStateException("Only WxaAttributes.WxaVersionModuleInfo or ModulePkgInfo supported here.".toString());
            AppMethodBeat.o(321589);
            throw paramList;
          }
          label438:
          i += 1;
        }
        label443:
        break;
        Log.i("Luggage.FULL.WxaRuntimeModularizingUtils", "findModule, return null with path:" + paramString1 + ", message[ " + paramString2 + " ]");
        AppMethodBeat.o(321589);
        return null;
      }
    }
  }
  
  public static final <M> M c(List<? extends M> paramList, String paramString1, String paramString2)
  {
    AppMethodBeat.i(321601);
    s.u(paramList, "<this>");
    s.u(paramString1, "pathOrModule");
    paramList = a(paramList, paramString1, paramString2, 4);
    AppMethodBeat.o(321601);
    return paramList;
  }
  
  private static String eh(Object paramObject)
  {
    AppMethodBeat.i(321583);
    if ((paramObject instanceof WxaAttributes.WxaVersionModuleInfo))
    {
      paramObject = ((WxaAttributes.WxaVersionModuleInfo)paramObject).name;
      AppMethodBeat.o(321583);
      return paramObject;
    }
    if ((paramObject instanceof ModulePkgInfo))
    {
      paramObject = ((ModulePkgInfo)paramObject).name;
      AppMethodBeat.o(321583);
      return paramObject;
    }
    paramObject = (Throwable)new IllegalStateException("Only WxaAttributes.WxaVersionModuleInfo or ModulePkgInfo supported here.".toString());
    AppMethodBeat.o(321583);
    throw paramObject;
  }
  
  public static final <M> M i(List<? extends M> paramList, String paramString)
  {
    AppMethodBeat.i(321606);
    s.u(paramList, "<this>");
    s.u(paramString, "pathOrModule");
    paramList = a(paramList, paramString, null, 6);
    AppMethodBeat.o(321606);
    return paramList;
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "T", "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareByDescending$1"}, k=3, mv={1, 5, 1})
  public static final class b<T>
    implements Comparator
  {
    public final int compare(T paramT1, T paramT2)
    {
      AppMethodBeat.i(321591);
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
        i = a.b(paramT2, (Comparable)Integer.valueOf(i));
        AppMethodBeat.o(321591);
        return i;
        if ((paramT2 instanceof ModulePkgInfo))
        {
          i = ((ModulePkgInfo)paramT2).name.length();
          break;
        }
        paramT1 = (Throwable)new IllegalStateException("Only WxaAttributes.WxaVersionModuleInfo or ModulePkgInfo supported here.".toString());
        AppMethodBeat.o(321591);
        throw paramT1;
        label112:
        if (!(paramT1 instanceof ModulePkgInfo)) {
          break label133;
        }
      }
      label133:
      paramT1 = (Throwable)new IllegalStateException("Only WxaAttributes.WxaVersionModuleInfo or ModulePkgInfo supported here.".toString());
      AppMethodBeat.o(321591);
      throw paramT1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.q.g
 * JD-Core Version:    0.7.0.1
 */