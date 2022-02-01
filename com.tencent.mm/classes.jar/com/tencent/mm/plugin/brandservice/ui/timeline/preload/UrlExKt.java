package com.tencent.mm.plugin.brandservice.ui.timeline.preload;

import android.net.Uri;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.cbz;
import com.tencent.mm.sdk.platformtools.ad;
import d.a.e;
import d.a.j;
import d.l;
import d.n.i;
import d.n.n;
import d.v;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"isMpArticleUrl", "", "", "(Ljava/lang/String;)Z", "isMpUrl", "withProtocol", "getWithProtocol", "(Ljava/lang/String;)Ljava/lang/String;", "clearShortUrl", "rawUrl", "appendStats", "session", "Lcom/tencent/mm/protocal/protobuf/PreloadSession;", "appendUrlParam", "param", "value", "clearUrlParam", "clearUrlParams", "", "(Ljava/lang/String;[Ljava/lang/String;)Ljava/lang/String;", "getUrlParam", "getUrlParamPairRegex", "Lkotlin/text/Regex;", "getUrlParamRegex", "plugin-brandservice_release"})
public final class UrlExKt
{
  public static final String appendStats(String paramString, cbz paramcbz)
  {
    AppMethodBeat.i(193104);
    d.g.b.k.h(paramString, "$this$appendStats");
    d.g.b.k.h(paramcbz, "session");
    if (!n.a((CharSequence)paramString, (CharSequence)"mp.weixin.qq.com", false))
    {
      AppMethodBeat.o(193104);
      return paramString;
    }
    if (paramcbz.DYl) {}
    for (int j = 1;; j = 0)
    {
      int i = j;
      if (paramcbz.DYm) {
        i = j | 0x2;
      }
      j = i;
      if (paramcbz.DYn) {
        j = i | 0x4;
      }
      i = j;
      if (paramcbz.DYo) {
        i = j | 0x8;
      }
      j = i;
      if (paramcbz.DYp) {
        j = i | 0x10;
      }
      i = j;
      if (paramcbz.DYq) {
        i = j | 0x20;
      }
      paramString = appendUrlParam(appendUrlParam(appendUrlParam(appendUrlParam(appendUrlParam(paramString, "sessionid", String.valueOf(paramcbz.id)), "subscene", String.valueOf(paramcbz.niJ)), "scene", String.valueOf(paramcbz.mSu)), "ascene", String.valueOf(paramcbz.DYk)), "fasttmpl_type", String.valueOf(paramcbz.nee));
      paramcbz = paramcbz.yaG;
      d.g.b.k.g(paramcbz, "session.uid");
      paramString = appendUrlParam(appendUrlParam(appendUrlParam(paramString, "fasttmpl_fullversion", paramcbz), "fasttmpl_flag", String.valueOf(i)), "realreporttime", String.valueOf(System.currentTimeMillis()));
      AppMethodBeat.o(193104);
      return paramString;
    }
  }
  
  public static final String appendUrlParam(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(6763);
    d.g.b.k.h(paramString1, "$this$appendUrlParam");
    d.g.b.k.h(paramString2, "param");
    d.g.b.k.h(paramString3, "value");
    List localList = n.a((CharSequence)paramString1, new String[] { "#" });
    paramString1 = (String)localList.get(0);
    if (!n.a((CharSequence)paramString1, (CharSequence)"?", false)) {
      paramString1 = paramString1 + "?";
    }
    for (;;)
    {
      if (n.f((CharSequence)paramString1, (CharSequence)(paramString2 + '=')))
      {
        paramString1 = (CharSequence)paramString1;
        paramString1 = getUrlParamRegex(paramString2).d(paramString1, paramString3);
        if (localList.size() > 1)
        {
          paramString1 = paramString1 + '#' + (String)localList.get(1);
          AppMethodBeat.o(6763);
          return paramString1;
        }
      }
      else
      {
        StringBuilder localStringBuilder = new StringBuilder().append(paramString1);
        if (n.mB(paramString1, "?")) {}
        for (paramString1 = "";; paramString1 = "&")
        {
          paramString1 = paramString1 + paramString2 + '=' + paramString3;
          break;
        }
      }
      AppMethodBeat.o(6763);
      return paramString1;
    }
  }
  
  public static final String clearShortUrl(String paramString)
  {
    int i = 0;
    AppMethodBeat.i(6756);
    d.g.b.k.h(paramString, "rawUrl");
    while (i < 11)
    {
      paramString = clearUrlParam(paramString, new String[] { "sessionid", "subscene", "scene", "ascene", "enterid", "clicktime", "fasttmpl_type", "fasttmpl_fullversion", "fasttmpl_flag", "realreporttime", "reporttime" }[i]);
      i += 1;
    }
    paramString = n.a(paramString, new char[] { 63, 38 });
    AppMethodBeat.o(6756);
    return paramString;
  }
  
  public static final String clearUrlParam(String paramString1, String paramString2)
  {
    AppMethodBeat.i(6764);
    d.g.b.k.h(paramString1, "$this$clearUrlParam");
    d.g.b.k.h(paramString2, "param");
    paramString1 = (String)n.a((CharSequence)paramString1, new String[] { "#" }).get(0);
    CharSequence localCharSequence = (CharSequence)paramString1;
    paramString2 = getUrlParamPairRegex(paramString2).d(localCharSequence, "");
    if ((n.mB(paramString2, "&")) && (!n.mB(paramString1, "&")))
    {
      paramString1 = n.a(paramString2, new char[] { '&' });
      AppMethodBeat.o(6764);
      return paramString1;
    }
    AppMethodBeat.o(6764);
    return paramString2;
  }
  
  public static final String clearUrlParams(String paramString, String... paramVarArgs)
  {
    AppMethodBeat.i(193105);
    d.g.b.k.h(paramString, "$this$clearUrlParams");
    d.g.b.k.h(paramVarArgs, "param");
    try
    {
      Uri localUri = Uri.parse(paramString);
      d.g.b.k.g(localUri, "uri");
      Object localObject1 = localUri.getQueryParameterNames();
      d.g.b.k.g(localObject1, "uri.queryParameterNames");
      Object localObject2 = (Iterable)localObject1;
      localObject1 = (Collection)new ArrayList();
      localObject2 = ((Iterable)localObject2).iterator();
      Object localObject3;
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = ((Iterator)localObject2).next();
        if (!e.contains(paramVarArgs, (String)localObject3)) {
          ((Collection)localObject1).add(localObject3);
        }
      }
      String str;
      return paramString;
    }
    catch (Exception localException)
    {
      ad.e("String", "clearUrlParams:" + localException.getMessage() + ", " + paramVarArgs + ", " + paramString);
      while (paramString == null)
      {
        paramString = new v("null cannot be cast to non-null type kotlin.String");
        AppMethodBeat.o(193105);
        throw paramString;
        localObject2 = (Iterable)j.k((Iterable)localObject1);
        localObject1 = (Collection)new ArrayList(j.a((Iterable)localObject2, 10));
        localObject2 = ((Iterable)localObject2).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localObject3 = (String)((Iterator)localObject2).next();
          ((Collection)localObject1).add((String)localObject3 + '=' + localException.getQueryParameter((String)localObject3));
        }
        localObject1 = j.a((Iterable)localObject1, (CharSequence)"&", null, null, 0, null, null, 62);
        str = localException.getScheme() + "://" + localException.getHost() + localException.getPath() + '?' + (String)localObject1;
        paramString = str;
      }
      AppMethodBeat.o(193105);
    }
  }
  
  public static final String getUrlParam(String paramString1, String paramString2)
  {
    AppMethodBeat.i(6760);
    d.g.b.k.h(paramString1, "$this$getUrlParam");
    d.g.b.k.h(paramString2, "param");
    paramString1 = d.n.k.a(getUrlParamRegex(paramString2), (CharSequence)paramString1);
    if (paramString1 != null)
    {
      paramString1 = paramString1.getValue();
      AppMethodBeat.o(6760);
      return paramString1;
    }
    AppMethodBeat.o(6760);
    return null;
  }
  
  private static final d.n.k getUrlParamPairRegex(String paramString)
  {
    AppMethodBeat.i(6759);
    paramString = new d.n.k("(?<=[?|&])" + paramString + "=.+?(?:&|$)");
    AppMethodBeat.o(6759);
    return paramString;
  }
  
  private static final d.n.k getUrlParamRegex(String paramString)
  {
    AppMethodBeat.i(6758);
    paramString = new d.n.k("(?<=" + paramString + "=).+?(?=&)");
    AppMethodBeat.o(6758);
    return paramString;
  }
  
  public static final String getWithProtocol(String paramString)
  {
    AppMethodBeat.i(6765);
    d.g.b.k.h(paramString, "$this$withProtocol");
    if (!n.mA(paramString, "http"))
    {
      if (n.a((CharSequence)paramString, (CharSequence)"view.inews.qq.com", false))
      {
        paramString = "https://".concat(String.valueOf(paramString));
        AppMethodBeat.o(6765);
        return paramString;
      }
      paramString = "http://".concat(String.valueOf(paramString));
      AppMethodBeat.o(6765);
      return paramString;
    }
    AppMethodBeat.o(6765);
    return paramString;
  }
  
  public static final boolean isMpArticleUrl(String paramString)
  {
    AppMethodBeat.i(6762);
    d.g.b.k.h(paramString, "$this$isMpArticleUrl");
    if ((n.mA(paramString, "https://mp.weixin.qq.com/s?")) || (n.mA(paramString, "http://mp.weixin.qq.com/s?")) || (n.mA(paramString, "https://mp.weixin.qq.com/s/")) || (n.mA(paramString, "http://mp.weixin.qq.com/s/")))
    {
      AppMethodBeat.o(6762);
      return true;
    }
    AppMethodBeat.o(6762);
    return false;
  }
  
  public static final boolean isMpUrl(String paramString)
  {
    AppMethodBeat.i(6761);
    d.g.b.k.h(paramString, "$this$isMpUrl");
    if ((n.mA(paramString, "https://mp.weixin.qq.com/")) || (n.mA(paramString, "http://mp.weixin.qq.com/")))
    {
      AppMethodBeat.o(6761);
      return true;
    }
    AppMethodBeat.o(6761);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.preload.UrlExKt
 * JD-Core Version:    0.7.0.1
 */