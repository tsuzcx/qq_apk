package com.tencent.mm.plugin.brandservice.ui.timeline.preload;

import a.f.b.j;
import a.l;
import a.l.i;
import a.l.k;
import a.l.m;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"isMpArticleUrl", "", "", "(Ljava/lang/String;)Z", "isMpUrl", "clearShortUrl", "rawUrl", "appendStats", "session", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/PreloadLogic$PreloadSession;", "appendUrlParam", "param", "value", "clearUrlParam", "getUrlParam", "getUrlParamPairRegex", "Lkotlin/text/Regex;", "getUrlParamRegex", "plugin-brandservice_release"})
public final class p
{
  public static final boolean GI(java.lang.String paramString)
  {
    AppMethodBeat.i(14976);
    j.q(paramString, "receiver$0");
    if ((m.jw(paramString, "https://mp.weixin.qq.com/")) || (m.jw(paramString, "http://mp.weixin.qq.com/")))
    {
      AppMethodBeat.o(14976);
      return true;
    }
    AppMethodBeat.o(14976);
    return false;
  }
  
  public static final java.lang.String Hb(java.lang.String paramString)
  {
    AppMethodBeat.i(14971);
    j.q(paramString, "rawUrl");
    int i = 0;
    while (i < 9)
    {
      paramString = dk(paramString, new java.lang.String[] { "sessionid", "subscene", "scene", "ascene", "fasttmpl_type", "fasttmpl_fullversion", "fasttmpl_flag", "realreporttime", "reporttime" }[i]);
      i += 1;
    }
    char[] arrayOfChar = new char[2];
    char[] tmp94_92 = arrayOfChar;
    tmp94_92[0] = 63;
    char[] tmp99_94 = tmp94_92;
    tmp99_94[1] = 38;
    tmp99_94;
    j.q(paramString, "receiver$0");
    j.q(arrayOfChar, "chars");
    paramString = (CharSequence)paramString;
    int j = paramString.length() - 1;
    if (j >= 0)
    {
      int k = paramString.charAt(j);
      j.q(arrayOfChar, "receiver$0");
      j.q(arrayOfChar, "receiver$0");
      i = 0;
      label160:
      if (i < 2) {
        if (k == arrayOfChar[i])
        {
          label173:
          if (i < 0) {
            break label219;
          }
          i = 1;
          label179:
          if (i != 0) {
            break label224;
          }
        }
      }
    }
    for (paramString = paramString.subSequence(0, j + 1);; paramString = (CharSequence)"")
    {
      paramString = paramString.toString();
      AppMethodBeat.o(14971);
      return paramString;
      i += 1;
      break label160;
      i = -1;
      break label173;
      label219:
      i = 0;
      break label179;
      label224:
      j -= 1;
      break;
    }
  }
  
  private static final k Hc(java.lang.String paramString)
  {
    AppMethodBeat.i(14973);
    paramString = new k("(?<=" + paramString + "=).+?(?=&)");
    AppMethodBeat.o(14973);
    return paramString;
  }
  
  private static final k Hd(java.lang.String paramString)
  {
    AppMethodBeat.i(14974);
    paramString = new k("(?<=[?|&])" + paramString + "=.+?(?:&|$)");
    AppMethodBeat.o(14974);
    return paramString;
  }
  
  public static final boolean He(java.lang.String paramString)
  {
    AppMethodBeat.i(14977);
    j.q(paramString, "receiver$0");
    if ((m.jw(paramString, "https://mp.weixin.qq.com/s?")) || (m.jw(paramString, "http://mp.weixin.qq.com/s?")))
    {
      AppMethodBeat.o(14977);
      return true;
    }
    AppMethodBeat.o(14977);
    return false;
  }
  
  public static final java.lang.String I(java.lang.String paramString1, java.lang.String paramString2, java.lang.String paramString3)
  {
    AppMethodBeat.i(14978);
    j.q(paramString1, "receiver$0");
    j.q(paramString2, "param");
    j.q(paramString3, "value");
    List localList = m.a((CharSequence)paramString1, new java.lang.String[] { "#" });
    paramString1 = (java.lang.String)localList.get(0);
    if (!m.a((CharSequence)paramString1, (CharSequence)"?", false)) {
      paramString1 = paramString1 + "?";
    }
    for (;;)
    {
      if (m.d((CharSequence)paramString1, (CharSequence)(paramString2 + '=')))
      {
        paramString1 = (CharSequence)paramString1;
        paramString1 = Hc(paramString2).c(paramString1, paramString3);
        if (localList.size() > 1)
        {
          paramString1 = paramString1 + '#' + (java.lang.String)localList.get(1);
          AppMethodBeat.o(14978);
          return paramString1;
        }
      }
      else
      {
        StringBuilder localStringBuilder = new StringBuilder().append(paramString1);
        if (m.jx(paramString1, "?")) {}
        for (paramString1 = "";; paramString1 = "&")
        {
          paramString1 = paramString1 + paramString2 + '=' + paramString3;
          break;
        }
      }
      AppMethodBeat.o(14978);
      return paramString1;
    }
  }
  
  public static final java.lang.String a(java.lang.String paramString, PreloadLogic.PreloadSession paramPreloadSession)
  {
    AppMethodBeat.i(14972);
    j.q(paramString, "receiver$0");
    j.q(paramPreloadSession, "session");
    if (!m.a((CharSequence)paramString, (CharSequence)"mp.weixin.qq.com", false))
    {
      AppMethodBeat.o(14972);
      return paramString;
    }
    if (paramPreloadSession.kbQ) {}
    for (int j = 1;; j = 0)
    {
      int i = j;
      if (paramPreloadSession.kbR) {
        i = j | 0x2;
      }
      j = i;
      if (paramPreloadSession.kbS) {
        j = i | 0x4;
      }
      i = j;
      if (paramPreloadSession.kbT) {
        i = j | 0x8;
      }
      j = i;
      if (paramPreloadSession.kbU) {
        j = i | 0x10;
      }
      i = j;
      if (paramPreloadSession.kbV) {
        i = j | 0x20;
      }
      int k = paramPreloadSession.id;
      int m = paramPreloadSession.kbN;
      int n = paramPreloadSession.kbq;
      int i1 = paramPreloadSession.kbO;
      int i2 = paramPreloadSession.kbM;
      paramPreloadSession = paramPreloadSession.kbP;
      long l = System.currentTimeMillis();
      j = 0;
      while (j < 8)
      {
        [Ljava.lang.String localString; = new java.lang.String[][] { { "sessionid", java.lang.String.valueOf(k) }, { "subscene", java.lang.String.valueOf(m) }, { "scene", java.lang.String.valueOf(n) }, { "ascene", java.lang.String.valueOf(i1) }, { "fasttmpl_type", java.lang.String.valueOf(i2) }, { "fasttmpl_fullversion", paramPreloadSession }, { "fasttmpl_flag", java.lang.String.valueOf(i) }, { "realreporttime", java.lang.String.valueOf(l) } }[j];
        paramString = I(paramString, localString;[0], localString;[1]);
        j += 1;
      }
      AppMethodBeat.o(14972);
      return paramString;
    }
  }
  
  public static final java.lang.String dj(java.lang.String paramString1, java.lang.String paramString2)
  {
    AppMethodBeat.i(14975);
    j.q(paramString1, "receiver$0");
    j.q(paramString2, "param");
    paramString1 = k.a(Hc(paramString2), (CharSequence)paramString1);
    if (paramString1 != null)
    {
      paramString1 = paramString1.getValue();
      AppMethodBeat.o(14975);
      return paramString1;
    }
    AppMethodBeat.o(14975);
    return null;
  }
  
  public static final java.lang.String dk(java.lang.String paramString1, java.lang.String paramString2)
  {
    AppMethodBeat.i(14979);
    j.q(paramString1, "receiver$0");
    j.q(paramString2, "param");
    paramString1 = (CharSequence)m.a((CharSequence)paramString1, new java.lang.String[] { "#" }).get(0);
    paramString1 = Hd(paramString2).c(paramString1, "");
    AppMethodBeat.o(14979);
    return paramString1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.preload.p
 * JD-Core Version:    0.7.0.1
 */