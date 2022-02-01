package com.tencent.mm.plugin.finder.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.b.a;
import com.tencent.mm.plugin.finder.publish.l.i;
import com.tencent.mm.protocal.protobuf.byt;
import com.tencent.mm.protocal.protobuf.byw;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatHosts;
import com.tencent.threadpool.h;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.t;
import kotlin.g.b.s;
import kotlin.n.n;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/cgi/FinderExtendReadingVerifier;", "", "()V", "ERROR_CODE_OK", "", "getERROR_CODE_OK", "()I", "ERROR_CODE_OUT_OF_TIME", "getERROR_CODE_OUT_OF_TIME", "ERROR_CODE_PARSE_FAILED", "getERROR_CODE_PARSE_FAILED", "ERROR_CODE_SVR_RESULT_INVALID", "getERROR_CODE_SVR_RESULT_INVALID", "ERROR_CODE_URL_INVALID", "getERROR_CODE_URL_INVALID", "TAG", "", "cacheLinks", "", "getCacheLinks", "()Ljava/util/Map;", "pattern", "Ljava/util/regex/Pattern;", "getPattern", "()Ljava/util/regex/Pattern;", "setPattern", "(Ljava/util/regex/Pattern;)V", "pattern2", "getPattern2", "setPattern2", "match", "p", "html", "verify", "", "link1", "onResult", "Lkotlin/Function6;", "Lkotlin/ParameterName;", "name", "errCode", "errMsg", "uri", "title", "style", "html5Style", "plugin-finder-publish_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class bk
{
  public static final bk ABs;
  private static final Map<String, String> ABt;
  private static final int ABu = 0;
  private static final int ABv;
  private static final int ABw;
  private static final int ABx;
  private static final int ABy;
  
  static
  {
    AppMethodBeat.i(336497);
    ABs = new bk();
    ABt = (Map)new LinkedHashMap();
    ABv = -100;
    ABw = -200;
    ABx = -300;
    ABy = -400;
    AppMethodBeat.o(336497);
  }
  
  private static final ah a(t paramt, String paramString, b.a parama)
  {
    Object localObject2 = null;
    int i = 0;
    AppMethodBeat.i(336482);
    s.u(paramt, "$onResult");
    s.u(paramString, "$link");
    Object localObject1;
    int j;
    if ((parama.errType == 0) && (parama.errCode == 0)) {
      if (parama == null)
      {
        localObject1 = localObject2;
        if (parama != null) {
          break label152;
        }
        j = i;
        label51:
        if (parama != null) {
          break label194;
        }
        i = 2;
        label57:
        if ((Util.isNullOrNil((String)localObject1)) || (localObject1 == null)) {
          break label233;
        }
        paramt.a(Integer.valueOf(ABu), "", paramString, localObject1, Integer.valueOf(j), Integer.valueOf(i));
      }
    }
    for (;;)
    {
      paramt = ah.aiuX;
      AppMethodBeat.o(336482);
      return paramt;
      Object localObject3 = (byw)parama.ott;
      localObject1 = localObject2;
      if (localObject3 == null) {
        break;
      }
      localObject3 = ((byw)localObject3).aahT;
      localObject1 = localObject2;
      if (localObject3 == null) {
        break;
      }
      localObject1 = ((byt)localObject3).title;
      break;
      label152:
      localObject2 = (byw)parama.ott;
      j = i;
      if (localObject2 == null) {
        break label51;
      }
      localObject2 = ((byw)localObject2).aahT;
      j = i;
      if (localObject2 == null) {
        break label51;
      }
      j = ((byt)localObject2).style;
      break label51;
      label194:
      parama = (byw)parama.ott;
      if (parama == null)
      {
        i = 2;
        break label57;
      }
      parama = parama.aahT;
      if (parama == null)
      {
        i = 2;
        break label57;
      }
      i = parama.aahR;
      break label57;
      label233:
      paramt.a(Integer.valueOf(ABy), "", paramString, "", Integer.valueOf(j), Integer.valueOf(2));
      continue;
      paramt.a(Integer.valueOf(parama.errCode), parama.errMsg, paramString, "", Integer.valueOf(0), Integer.valueOf(2));
    }
  }
  
  public static void a(String paramString, t<? super Integer, ? super String, ? super String, ? super String, ? super Integer, ? super Integer, ah> paramt)
  {
    AppMethodBeat.i(336474);
    s.u(paramString, "link1");
    s.u(paramt, "onResult");
    paramString = n.bq((CharSequence)paramString).toString();
    if ((ABt.containsKey(paramString)) && (!Util.isNullOrNil((String)ABt.get(paramString))))
    {
      Object localObject = ABt.get(paramString);
      s.checkNotNull(localObject);
      paramt.a(Integer.valueOf(0), "", paramString, localObject, Integer.valueOf(0), Integer.valueOf(2));
      paramt = new StringBuilder("verify in cache ").append(paramString).append(", ");
      paramString = ABt.get(paramString);
      s.checkNotNull(paramString);
      Log.i("Finder.FinderExtendReadingVerifier", (String)paramString);
      AppMethodBeat.o(336474);
      return;
    }
    h.ahAA.bm(new bk..ExternalSyntheticLambda1(paramString, paramt));
    AppMethodBeat.o(336474);
  }
  
  private static final void b(String paramString, t paramt)
  {
    AppMethodBeat.i(336489);
    s.u(paramString, "$link");
    s.u(paramt, "$onResult");
    Log.i("Finder.FinderExtendReadingVerifier", s.X("verify ", paramString));
    Object localObject3;
    Object localObject4;
    try
    {
      localObject3 = com.tencent.mm.k.i.aRC().getValue("FinderExtendedReadingPrefix");
      localObject1 = localObject3;
      if (Util.isNullOrNil((String)localObject3)) {
        localObject1 = "https://" + WeChatHosts.domainString(l.i.host_mp_weixin_qq_com) + ';';
      }
      s.s(localObject1, "prefixs");
      localObject3 = (Iterable)n.a((CharSequence)n.bq((CharSequence)localObject1).toString(), new char[] { ';' }, 0, 6);
      localObject1 = (Collection)new ArrayList();
      localObject3 = ((Iterable)localObject3).iterator();
    }
    catch (MalformedURLException localMalformedURLException)
    {
      for (;;)
      {
        Object localObject1;
        String str;
        Log.printErrStackTrace("Finder.FinderExtendReadingVerifier", (Throwable)localMalformedURLException, "MalformedURLException", new Object[0]);
        paramt.a(Integer.valueOf(ABv), "", paramString, "", Integer.valueOf(0), Integer.valueOf(2));
        AppMethodBeat.o(336489);
        return;
        if (Util.isNullOrNil(n.bq((CharSequence)str).toString())) {
          break;
        }
        i = 1;
        if (i != 0) {
          localMalformedURLException.add(localObject4);
        }
      }
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        Log.printErrStackTrace("Finder.FinderExtendReadingVerifier", (Throwable)localIOException, "IOException", new Object[0]);
        paramt.a(Integer.valueOf(ABx), "", paramString, "", Integer.valueOf(0), Integer.valueOf(2));
        AppMethodBeat.o(336489);
        return;
        i = 0;
      }
      localObject2 = ((Iterable)localIOException).iterator();
      i = 0;
      if (!((Iterator)localObject2).hasNext()) {
        break label467;
      }
      localObject3 = (String)((Iterator)localObject2).next();
      localObject4 = paramString.toLowerCase();
      s.s(localObject4, "(this as java.lang.String).toLowerCase()");
      if (localObject3 != null) {
        break label442;
      }
      localObject2 = new NullPointerException("null cannot be cast to non-null type kotlin.CharSequence");
      AppMethodBeat.o(336489);
      throw ((Throwable)localObject2);
    }
    finally
    {
      Log.printErrStackTrace("Finder.FinderExtendReadingVerifier", localThrowable, "Throwable", new Object[0]);
      paramt.a(Integer.valueOf(ABx), "", paramString, "", Integer.valueOf(0), Integer.valueOf(2));
      AppMethodBeat.o(336489);
      return;
    }
    if (((Iterator)localObject3).hasNext())
    {
      localObject4 = ((Iterator)localObject3).next();
      str = (String)localObject4;
      if (str == null)
      {
        localObject1 = new NullPointerException("null cannot be cast to non-null type kotlin.CharSequence");
        AppMethodBeat.o(336489);
        throw ((Throwable)localObject1);
      }
    }
    int i;
    for (;;)
    {
      Object localObject2;
      label442:
      if (n.U((String)localObject4, n.bq((CharSequence)localObject3).toString(), false)) {
        i = 1;
      }
    }
    label467:
    if (i != 0)
    {
      new av(paramString).bFJ().g(new bk..ExternalSyntheticLambda0(paramt, paramString));
      AppMethodBeat.o(336489);
      return;
    }
    Log.i("Finder.FinderExtendReadingVerifier", "scheme or host not valid");
    paramt.a(Integer.valueOf(ABv), "", paramString, "", Integer.valueOf(0), Integer.valueOf(2));
    AppMethodBeat.o(336489);
  }
  
  public static int dVx()
  {
    return ABu;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.bk
 * JD-Core Version:    0.7.0.1
 */