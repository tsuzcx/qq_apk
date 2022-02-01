package com.tencent.mm.plugin.brandservice.ui.timeline.preload;

import android.net.Uri;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.dei;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMSlotKt;
import com.tencent.mm.sdk.platformtools.WeChatHosts;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.a.e;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.n.i;
import kotlin.n.k;
import kotlin.n.n;
import kotlin.t;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"isMpArticleUrl", "", "", "(Ljava/lang/String;)Z", "isMpUrl", "withProtocol", "getWithProtocol", "(Ljava/lang/String;)Ljava/lang/String;", "clearShortUrl", "rawUrl", "ignoreHashTag", "appendStats", "session", "Lcom/tencent/mm/protocal/protobuf/PreloadSession;", "appendUrlParam", "param", "value", "clearUrlParam", "clearUrlParams", "", "(Ljava/lang/String;[Ljava/lang/String;)Ljava/lang/String;", "getUrlParam", "getUrlParamPairRegex", "Lkotlin/text/Regex;", "getUrlParamRegex", "plugin-brandservice_release"})
public final class UrlExKt
{
  public static final String appendStats(String paramString, dei paramdei)
  {
    AppMethodBeat.i(195642);
    p.h(paramString, "$this$appendStats");
    p.h(paramdei, "session");
    if (!n.e((CharSequence)paramString, (CharSequence)WeChatHosts.domainString(2131761726)))
    {
      AppMethodBeat.o(195642);
      return paramString;
    }
    int j = 0;
    if (paramdei.MJr) {
      j = 1;
    }
    int i = j;
    if (paramdei.MJs) {
      i = j | 0x2;
    }
    j = i;
    if (paramdei.MJt) {
      j = i | 0x4;
    }
    i = j;
    if (paramdei.MJu) {
      i = j | 0x8;
    }
    j = i;
    if (paramdei.MJv) {
      j = i | 0x10;
    }
    i = j;
    if (paramdei.MJw) {
      i = j | 0x20;
    }
    paramString = appendUrlParam(appendUrlParam(appendUrlParam(appendUrlParam(appendUrlParam(paramString, "sessionid", String.valueOf(paramdei.id)), "subscene", String.valueOf(paramdei.pHw)), "scene", String.valueOf(paramdei.pmM)), "ascene", String.valueOf(paramdei.MJq)), "fasttmpl_type", String.valueOf(paramdei.pCV));
    paramdei = paramdei.hFF;
    p.g(paramdei, "session.uid");
    paramString = appendUrlParam(appendUrlParam(appendUrlParam(paramString, "fasttmpl_fullversion", paramdei), "fasttmpl_flag", String.valueOf(i)), "realreporttime", String.valueOf(MMSlotKt.now()));
    AppMethodBeat.o(195642);
    return paramString;
  }
  
  public static final String appendUrlParam(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(6763);
    p.h(paramString1, "$this$appendUrlParam");
    p.h(paramString2, "param");
    p.h(paramString3, "value");
    List localList = n.a((CharSequence)paramString1, new String[] { "#" });
    paramString1 = (String)localList.get(0);
    if (!n.a((CharSequence)paramString1, (CharSequence)"?", false)) {
      paramString1 = paramString1 + "?";
    }
    for (;;)
    {
      if (n.e((CharSequence)paramString1, (CharSequence)(paramString2 + '=')))
      {
        paramString1 = (CharSequence)paramString1;
        paramString1 = getUrlParamRegex(paramString2).f(paramString1, paramString3);
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
        if (n.K(paramString1, "?", false)) {}
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
  
  public static final String clearShortUrl(String paramString, boolean paramBoolean)
  {
    int i = 0;
    AppMethodBeat.i(195640);
    p.h(paramString, "rawUrl");
    while (i < 11)
    {
      paramString = clearUrlParam(paramString, new String[] { "sessionid", "subscene", "scene", "ascene", "enterid", "clicktime", "fasttmpl_type", "fasttmpl_fullversion", "fasttmpl_flag", "realreporttime", "reporttime" }[i], paramBoolean);
      i += 1;
    }
    paramString = n.a(paramString, new char[] { 63, 38 });
    AppMethodBeat.o(195640);
    return paramString;
  }
  
  public static final String clearUrlParam(String paramString1, String paramString2, boolean paramBoolean)
  {
    AppMethodBeat.i(195643);
    p.h(paramString1, "$this$clearUrlParam");
    p.h(paramString2, "param");
    if (paramBoolean) {}
    for (;;)
    {
      CharSequence localCharSequence = (CharSequence)paramString1;
      paramString2 = getUrlParamPairRegex(paramString2).f(localCharSequence, "");
      if ((!n.K(paramString2, "&", false)) || (n.K(paramString1, "&", false))) {
        break;
      }
      paramString1 = n.a(paramString2, new char[] { '&' });
      AppMethodBeat.o(195643);
      return paramString1;
      paramString1 = (String)n.a((CharSequence)paramString1, new String[] { "#" }).get(0);
    }
    AppMethodBeat.o(195643);
    return paramString2;
  }
  
  public static final String clearUrlParams(String paramString, String... paramVarArgs)
  {
    AppMethodBeat.i(195645);
    p.h(paramString, "$this$clearUrlParams");
    p.h(paramVarArgs, "param");
    try
    {
      Uri localUri = Uri.parse(paramString);
      p.g(localUri, "uri");
      Object localObject1 = localUri.getQueryParameterNames();
      p.g(localObject1, "uri.queryParameterNames");
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
      Log.e("String", "clearUrlParams:" + localException.getMessage() + ", " + paramVarArgs + ", " + paramString);
      while (paramString == null)
      {
        paramString = new t("null cannot be cast to non-null type kotlin.String");
        AppMethodBeat.o(195645);
        throw paramString;
        localObject2 = (Iterable)j.n((Iterable)localObject1);
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
      AppMethodBeat.o(195645);
    }
  }
  
  public static final String getUrlParam(String paramString1, String paramString2)
  {
    AppMethodBeat.i(6760);
    p.h(paramString1, "$this$getUrlParam");
    p.h(paramString2, "param");
    paramString1 = k.a(getUrlParamRegex(paramString2), (CharSequence)paramString1);
    if (paramString1 != null)
    {
      paramString1 = paramString1.getValue();
      AppMethodBeat.o(6760);
      return paramString1;
    }
    AppMethodBeat.o(6760);
    return null;
  }
  
  private static final k getUrlParamPairRegex(String paramString)
  {
    AppMethodBeat.i(6759);
    paramString = new k("(?<=[?|&])" + paramString + "=.+?(?:&|$)");
    AppMethodBeat.o(6759);
    return paramString;
  }
  
  private static final k getUrlParamRegex(String paramString)
  {
    AppMethodBeat.i(6758);
    paramString = new k("(?<=" + paramString + "=).+?(?=&)");
    AppMethodBeat.o(6758);
    return paramString;
  }
  
  public static final String getWithProtocol(String paramString)
  {
    AppMethodBeat.i(6765);
    p.h(paramString, "$this$withProtocol");
    if (!n.J(paramString, "http", false))
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
    p.h(paramString, "$this$isMpArticleUrl");
    if ((n.J(paramString, "https://" + WeChatHosts.domainString(2131761726) + "/s?", false)) || (n.J(paramString, "http://" + WeChatHosts.domainString(2131761726) + "/s?", false)) || (n.J(paramString, "https://" + WeChatHosts.domainString(2131761726) + "/s/", false)) || (n.J(paramString, "http://" + WeChatHosts.domainString(2131761726) + "/s/", false)))
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
    p.h(paramString, "$this$isMpUrl");
    if ((n.J(paramString, "https://" + WeChatHosts.domainString(2131761726) + "/", false)) || (n.J(paramString, "http://" + WeChatHosts.domainString(2131761726) + "/", false)))
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