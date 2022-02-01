package com.tencent.mm.plugin.brandservice.ui.timeline.preload;

import android.net.Uri;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.brandservice.d.i;
import com.tencent.mm.protocal.protobuf.egp;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMSlotKt;
import com.tencent.mm.sdk.platformtools.WeChatHosts;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.a.p;
import kotlin.g.b.s;
import kotlin.n.i;
import kotlin.n.n;

@Metadata(d1={""}, d2={"isGameCenterUrl", "", "", "(Ljava/lang/String;)Z", "isMpAlbumUrl", "isMpArticleUrl", "isMpRecWeb", "isMpTpUrl", "isMpUrl", "withProtocol", "getWithProtocol", "(Ljava/lang/String;)Ljava/lang/String;", "clearShortUrl", "rawUrl", "ignoreHashTag", "appendStats", "session", "Lcom/tencent/mm/protocal/protobuf/PreloadSession;", "appendUrlParam", "param", "value", "clearUrlParam", "clearUrlParams", "", "(Ljava/lang/String;[Ljava/lang/String;)Ljava/lang/String;", "getUrlParam", "getUrlParamPairRegex", "Lkotlin/text/Regex;", "getUrlParamRegex", "plugin-brandservice_release"}, k=2, mv={1, 5, 1}, xi=48)
public final class UrlExKt
{
  public static final String appendStats(String paramString, egp paramegp)
  {
    AppMethodBeat.i(302895);
    s.u(paramString, "<this>");
    s.u(paramegp, "session");
    if (!n.i((CharSequence)paramString, (CharSequence)WeChatHosts.domainString(d.i.host_mp_weixin_qq_com)))
    {
      AppMethodBeat.o(302895);
      return paramString;
    }
    int j = 0;
    if (paramegp.ablQ) {
      j = 1;
    }
    int i = j;
    if (paramegp.ablR) {
      i = j | 0x2;
    }
    j = i;
    if (paramegp.ablS) {
      j = i | 0x4;
    }
    i = j;
    if (paramegp.ablT) {
      i = j | 0x8;
    }
    j = i;
    if (paramegp.ablU) {
      j = i | 0x10;
    }
    i = j;
    if (paramegp.ablV) {
      i = j | 0x20;
    }
    paramString = appendUrlParam(appendUrlParam(appendUrlParam(appendUrlParam(appendUrlParam(paramString, "sessionid", String.valueOf(paramegp.id)), "subscene", String.valueOf(paramegp.AcJ)), "scene", String.valueOf(paramegp.vAZ)), "ascene", String.valueOf(paramegp.ablP)), "fasttmpl_type", String.valueOf(paramegp.vST));
    paramegp = paramegp.mXG;
    s.s(paramegp, "session.uid");
    paramString = appendUrlParam(appendUrlParam(appendUrlParam(paramString, "fasttmpl_fullversion", paramegp), "fasttmpl_flag", String.valueOf(i)), "realreporttime", String.valueOf(MMSlotKt.now()));
    AppMethodBeat.o(302895);
    return paramString;
  }
  
  public static final String appendUrlParam(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(6763);
    s.u(paramString1, "<this>");
    s.u(paramString2, "param");
    s.u(paramString3, "value");
    List localList = n.a((CharSequence)paramString1, new String[] { "#" });
    paramString1 = (String)localList.get(0);
    if (!n.a((CharSequence)paramString1, (CharSequence)"?", false)) {
      paramString1 = s.X(paramString1, "?");
    }
    for (;;)
    {
      if (n.a((CharSequence)paramString1, (CharSequence)s.X(paramString2, "="), false))
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
        if (n.rs(paramString1, "?")) {}
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
    AppMethodBeat.i(302886);
    s.u(paramString, "rawUrl");
    String str;
    int i;
    if (paramBoolean)
    {
      str = n.bY(paramString, "#", "");
      if (((CharSequence)str).length() > 0)
      {
        i = 1;
        if (i == 0) {
          break label157;
        }
        str = s.X("#", str);
      }
    }
    for (;;)
    {
      paramString = s.X(n.a(clearUrlParams(paramString, new String[] { "sessionid", "subscene", "scene", "ascene", "enterid", "clicktime", "fasttmpl_type", "fasttmpl_fullversion", "fasttmpl_flag", "realreporttime", "reporttime", "from" }), new char[] { '?', '&' }), str);
      AppMethodBeat.o(302886);
      return paramString;
      i = 0;
      break;
      label157:
      str = "";
      continue;
      str = "";
    }
  }
  
  public static final String clearUrlParam(String paramString1, String paramString2, boolean paramBoolean)
  {
    AppMethodBeat.i(302954);
    s.u(paramString1, "<this>");
    s.u(paramString2, "param");
    if (paramBoolean) {}
    for (;;)
    {
      CharSequence localCharSequence = (CharSequence)paramString1;
      paramString2 = getUrlParamPairRegex(paramString2).f(localCharSequence, "");
      if ((!n.rs(paramString2, "&")) || (n.rs(paramString1, "&"))) {
        break;
      }
      paramString1 = n.a(paramString2, new char[] { '&' });
      AppMethodBeat.o(302954);
      return paramString1;
      paramString1 = (String)n.a((CharSequence)paramString1, new String[] { "#" }).get(0);
    }
    AppMethodBeat.o(302954);
    return paramString2;
  }
  
  public static final String clearUrlParams(String paramString, String... paramVarArgs)
  {
    AppMethodBeat.i(302969);
    s.u(paramString, "<this>");
    s.u(paramVarArgs, "param");
    Object localObject1;
    Object localObject2;
    Object localObject3;
    try
    {
      Uri localUri = Uri.parse(paramString);
      localObject1 = localUri.getQueryParameterNames();
      s.s(localObject1, "uri.queryParameterNames");
      localObject2 = (Iterable)localObject1;
      localObject1 = (Collection)new ArrayList();
      localObject2 = ((Iterable)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = ((Iterator)localObject2).next();
        if (!kotlin.a.k.contains(paramVarArgs, (String)localObject3))
        {
          ((Collection)localObject1).add(localObject3);
          continue;
          AppMethodBeat.o(302969);
        }
      }
    }
    catch (Exception localException)
    {
      Log.e("String", "clearUrlParams:" + localException.getMessage() + ", " + paramVarArgs + ", " + paramString);
    }
    for (;;)
    {
      return paramString;
      localObject2 = (Iterable)p.n((Iterable)localObject1);
      localObject1 = (Collection)new ArrayList(p.a((Iterable)localObject2, 10));
      localObject2 = ((Iterable)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (String)((Iterator)localObject2).next();
        ((Collection)localObject1).add(localObject3 + '=' + localException.getQueryParameter((String)localObject3));
      }
      localObject1 = p.a((Iterable)localObject1, (CharSequence)"&", null, null, 0, null, null, 62);
      String str = localException.getScheme() + "://" + localException.getHost() + localException.getPath() + '?' + (String)localObject1;
      paramString = str;
    }
  }
  
  public static final String getUrlParam(String paramString1, String paramString2)
  {
    AppMethodBeat.i(6760);
    s.u(paramString1, "<this>");
    s.u(paramString2, "param");
    paramString1 = kotlin.n.k.a(getUrlParamRegex(paramString2), (CharSequence)paramString1);
    if (paramString1 == null)
    {
      AppMethodBeat.o(6760);
      return null;
    }
    paramString1 = paramString1.getValue();
    AppMethodBeat.o(6760);
    return paramString1;
  }
  
  private static final kotlin.n.k getUrlParamPairRegex(String paramString)
  {
    AppMethodBeat.i(6759);
    paramString = new kotlin.n.k("(?<=[?|&])" + paramString + "=.+?(?:&|$)");
    AppMethodBeat.o(6759);
    return paramString;
  }
  
  private static final kotlin.n.k getUrlParamRegex(String paramString)
  {
    AppMethodBeat.i(6758);
    paramString = new kotlin.n.k("(?<=" + paramString + "=).+?(?=&)");
    AppMethodBeat.o(6758);
    return paramString;
  }
  
  public static final String getWithProtocol(String paramString)
  {
    AppMethodBeat.i(6765);
    s.u(paramString, "<this>");
    if (!n.U(paramString, "http", false))
    {
      if (n.a((CharSequence)paramString, (CharSequence)"view.inews.qq.com", false))
      {
        paramString = s.X("https://", paramString);
        AppMethodBeat.o(6765);
        return paramString;
      }
      paramString = s.X("http://", paramString);
      AppMethodBeat.o(6765);
      return paramString;
    }
    AppMethodBeat.o(6765);
    return paramString;
  }
  
  public static final boolean isGameCenterUrl(String paramString)
  {
    AppMethodBeat.i(302933);
    s.u(paramString, "<this>");
    if ((n.U(paramString, "https://" + WeChatHosts.domainString(d.i.host_game_weixin_qq_com) + '/', false)) || (n.U(paramString, "http://" + WeChatHosts.domainString(d.i.host_game_weixin_qq_com) + '/', false)))
    {
      AppMethodBeat.o(302933);
      return true;
    }
    AppMethodBeat.o(302933);
    return false;
  }
  
  public static final boolean isMpAlbumUrl(String paramString)
  {
    AppMethodBeat.i(302930);
    s.u(paramString, "<this>");
    if ((n.U(paramString, "https://" + WeChatHosts.domainString(d.i.host_mp_weixin_qq_com) + "/mp/appmsgalbum?", false)) || (n.U(paramString, "http://" + WeChatHosts.domainString(d.i.host_mp_weixin_qq_com) + "/mp/appmsgalbum?", false)))
    {
      AppMethodBeat.o(302930);
      return true;
    }
    AppMethodBeat.o(302930);
    return false;
  }
  
  public static final boolean isMpArticleUrl(String paramString)
  {
    AppMethodBeat.i(6762);
    s.u(paramString, "<this>");
    if ((n.U(paramString, "https://" + WeChatHosts.domainString(d.i.host_mp_weixin_qq_com) + "/s?", false)) || (n.U(paramString, "http://" + WeChatHosts.domainString(d.i.host_mp_weixin_qq_com) + "/s?", false)) || (n.U(paramString, "https://" + WeChatHosts.domainString(d.i.host_mp_weixin_qq_com) + "/s/", false)) || (n.U(paramString, "http://" + WeChatHosts.domainString(d.i.host_mp_weixin_qq_com) + "/s/", false)))
    {
      AppMethodBeat.o(6762);
      return true;
    }
    AppMethodBeat.o(6762);
    return false;
  }
  
  public static final boolean isMpRecWeb(String paramString)
  {
    AppMethodBeat.i(302936);
    s.u(paramString, "<this>");
    if ((n.U(paramString, "https://" + WeChatHosts.domainString(d.i.host_mp_weixin_qq_com) + "/recweb/clientjump?", false)) || (n.U(paramString, "http://" + WeChatHosts.domainString(d.i.host_mp_weixin_qq_com) + "/recweb/clientjump?", false)))
    {
      AppMethodBeat.o(302936);
      return true;
    }
    AppMethodBeat.o(302936);
    return false;
  }
  
  public static final boolean isMpTpUrl(String paramString)
  {
    AppMethodBeat.i(302940);
    s.u(paramString, "<this>");
    if ((n.U(paramString, "https://" + WeChatHosts.domainString(d.i.host_mp_weixin_qq_com) + "/tp/", false)) || (n.U(paramString, "http://" + WeChatHosts.domainString(d.i.host_mp_weixin_qq_com) + "/tp/", false)))
    {
      AppMethodBeat.o(302940);
      return true;
    }
    AppMethodBeat.o(302940);
    return false;
  }
  
  public static final boolean isMpUrl(String paramString)
  {
    AppMethodBeat.i(6761);
    s.u(paramString, "<this>");
    if ((n.U(paramString, "https://" + WeChatHosts.domainString(d.i.host_mp_weixin_qq_com) + '/', false)) || (n.U(paramString, "http://" + WeChatHosts.domainString(d.i.host_mp_weixin_qq_com) + '/', false)))
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