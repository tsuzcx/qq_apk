package com.tencent.mm.plugin.brandservice.ui.timeline.preload;

import android.net.Uri;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.brandservice.d.i;
import com.tencent.mm.protocal.protobuf.dny;
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

@l(iBK={1, 1, 16}, iBL={""}, iBM={"isGameCenterUrl", "", "", "(Ljava/lang/String;)Z", "isMpAlbumUrl", "isMpArticleUrl", "isMpUrl", "withProtocol", "getWithProtocol", "(Ljava/lang/String;)Ljava/lang/String;", "clearShortUrl", "rawUrl", "ignoreHashTag", "appendStats", "session", "Lcom/tencent/mm/protocal/protobuf/PreloadSession;", "appendUrlParam", "param", "value", "clearUrlParam", "clearUrlParams", "", "(Ljava/lang/String;[Ljava/lang/String;)Ljava/lang/String;", "getUrlParam", "getUrlParamPairRegex", "Lkotlin/text/Regex;", "getUrlParamRegex", "plugin-brandservice_release"})
public final class UrlExKt
{
  public static final String appendStats(String paramString, dny paramdny)
  {
    AppMethodBeat.i(258503);
    p.k(paramString, "$this$appendStats");
    p.k(paramdny, "session");
    if (!n.g((CharSequence)paramString, (CharSequence)WeChatHosts.domainString(d.i.host_mp_weixin_qq_com)))
    {
      AppMethodBeat.o(258503);
      return paramString;
    }
    int j = 0;
    if (paramdny.TVg) {
      j = 1;
    }
    int i = j;
    if (paramdny.TVh) {
      i = j | 0x2;
    }
    j = i;
    if (paramdny.TVi) {
      j = i | 0x4;
    }
    i = j;
    if (paramdny.TVj) {
      i = j | 0x8;
    }
    j = i;
    if (paramdny.TVk) {
      j = i | 0x10;
    }
    i = j;
    if (paramdny.TVl) {
      i = j | 0x20;
    }
    paramString = appendUrlParam(appendUrlParam(appendUrlParam(appendUrlParam(appendUrlParam(paramString, "sessionid", String.valueOf(paramdny.id)), "subscene", String.valueOf(paramdny.wGA)), "scene", String.valueOf(paramdny.svv)), "ascene", String.valueOf(paramdny.TVf)), "fasttmpl_type", String.valueOf(paramdny.sNh));
    paramdny = paramdny.ktM;
    p.j(paramdny, "session.uid");
    paramString = appendUrlParam(appendUrlParam(appendUrlParam(paramString, "fasttmpl_fullversion", paramdny), "fasttmpl_flag", String.valueOf(i)), "realreporttime", String.valueOf(MMSlotKt.now()));
    AppMethodBeat.o(258503);
    return paramString;
  }
  
  public static final String appendUrlParam(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(6763);
    p.k(paramString1, "$this$appendUrlParam");
    p.k(paramString2, "param");
    p.k(paramString3, "value");
    List localList = n.a((CharSequence)paramString1, new String[] { "#" });
    paramString1 = (String)localList.get(0);
    if (!n.a((CharSequence)paramString1, (CharSequence)"?", false)) {
      paramString1 = paramString1 + "?";
    }
    for (;;)
    {
      if (n.g((CharSequence)paramString1, (CharSequence)(paramString2 + '=')))
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
        if (n.pu(paramString1, "?")) {}
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
    AppMethodBeat.i(258500);
    p.k(paramString, "rawUrl");
    String str;
    int i;
    if (paramBoolean)
    {
      str = n.bz(paramString, "#", "");
      if (((CharSequence)str).length() > 0)
      {
        i = 1;
        if (i == 0) {
          break label175;
        }
        str = "#".concat(String.valueOf(str));
      }
    }
    for (;;)
    {
      paramString = n.a(clearUrlParams(paramString, new String[] { "sessionid", "subscene", "scene", "ascene", "enterid", "clicktime", "fasttmpl_type", "fasttmpl_fullversion", "fasttmpl_flag", "realreporttime", "reporttime", "from" }), new char[] { 63, 38 });
      paramString = paramString + str;
      AppMethodBeat.o(258500);
      return paramString;
      i = 0;
      break;
      label175:
      str = "";
      continue;
      str = "";
    }
  }
  
  public static final String clearUrlParam(String paramString1, String paramString2, boolean paramBoolean)
  {
    AppMethodBeat.i(258506);
    p.k(paramString1, "$this$clearUrlParam");
    p.k(paramString2, "param");
    if (paramBoolean) {}
    for (;;)
    {
      CharSequence localCharSequence = (CharSequence)paramString1;
      paramString2 = getUrlParamPairRegex(paramString2).f(localCharSequence, "");
      if ((!n.pu(paramString2, "&")) || (n.pu(paramString1, "&"))) {
        break;
      }
      paramString1 = n.a(paramString2, new char[] { '&' });
      AppMethodBeat.o(258506);
      return paramString1;
      paramString1 = (String)n.a((CharSequence)paramString1, new String[] { "#" }).get(0);
    }
    AppMethodBeat.o(258506);
    return paramString2;
  }
  
  public static final String clearUrlParams(String paramString, String... paramVarArgs)
  {
    AppMethodBeat.i(258508);
    p.k(paramString, "$this$clearUrlParams");
    p.k(paramVarArgs, "param");
    try
    {
      Uri localUri = Uri.parse(paramString);
      p.j(localUri, "uri");
      Object localObject1 = localUri.getQueryParameterNames();
      p.j(localObject1, "uri.queryParameterNames");
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
        AppMethodBeat.o(258508);
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
      AppMethodBeat.o(258508);
    }
  }
  
  public static final String getUrlParam(String paramString1, String paramString2)
  {
    AppMethodBeat.i(6760);
    p.k(paramString1, "$this$getUrlParam");
    p.k(paramString2, "param");
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
    p.k(paramString, "$this$withProtocol");
    if (!n.M(paramString, "http", false))
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
  
  public static final boolean isGameCenterUrl(String paramString)
  {
    AppMethodBeat.i(258505);
    p.k(paramString, "$this$isGameCenterUrl");
    if ((n.M(paramString, "https://" + WeChatHosts.domainString(d.i.host_game_weixin_qq_com) + "/", false)) || (n.M(paramString, "http://" + WeChatHosts.domainString(d.i.host_game_weixin_qq_com) + "/", false)))
    {
      AppMethodBeat.o(258505);
      return true;
    }
    AppMethodBeat.o(258505);
    return false;
  }
  
  public static final boolean isMpAlbumUrl(String paramString)
  {
    AppMethodBeat.i(258504);
    p.k(paramString, "$this$isMpAlbumUrl");
    if ((n.M(paramString, "https://" + WeChatHosts.domainString(d.i.host_mp_weixin_qq_com) + "/mp/appmsgalbum?", false)) || (n.M(paramString, "http://" + WeChatHosts.domainString(d.i.host_mp_weixin_qq_com) + "/mp/appmsgalbum?", false)))
    {
      AppMethodBeat.o(258504);
      return true;
    }
    AppMethodBeat.o(258504);
    return false;
  }
  
  public static final boolean isMpArticleUrl(String paramString)
  {
    AppMethodBeat.i(6762);
    p.k(paramString, "$this$isMpArticleUrl");
    if ((n.M(paramString, "https://" + WeChatHosts.domainString(d.i.host_mp_weixin_qq_com) + "/s?", false)) || (n.M(paramString, "http://" + WeChatHosts.domainString(d.i.host_mp_weixin_qq_com) + "/s?", false)) || (n.M(paramString, "https://" + WeChatHosts.domainString(d.i.host_mp_weixin_qq_com) + "/s/", false)) || (n.M(paramString, "http://" + WeChatHosts.domainString(d.i.host_mp_weixin_qq_com) + "/s/", false)))
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
    p.k(paramString, "$this$isMpUrl");
    if ((n.M(paramString, "https://" + WeChatHosts.domainString(d.i.host_mp_weixin_qq_com) + "/", false)) || (n.M(paramString, "http://" + WeChatHosts.domainString(d.i.host_mp_weixin_qq_com) + "/", false)))
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