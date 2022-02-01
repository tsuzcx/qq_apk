package com.tencent.mm.plugin.finder.view.manager;

import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.b.j;
import com.tencent.mm.plugin.finder.cgi.ae;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatHosts;
import com.tencent.mm.vending.c.a;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.g.a.s;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.n.n;
import kotlin.t;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/view/manager/FinderExtendReadingManager$FinderExtendReadingVerifier;", "", "()V", "ERROR_CODE_OK", "", "getERROR_CODE_OK", "()I", "ERROR_CODE_OUT_OF_TIME", "getERROR_CODE_OUT_OF_TIME", "ERROR_CODE_PARSE_FAILED", "getERROR_CODE_PARSE_FAILED", "ERROR_CODE_SVR_RESULT_INVALID", "getERROR_CODE_SVR_RESULT_INVALID", "ERROR_CODE_URL_INVALID", "getERROR_CODE_URL_INVALID", "TAG", "", "cacheLinks", "", "getCacheLinks", "()Ljava/util/Map;", "pattern", "Ljava/util/regex/Pattern;", "getPattern", "()Ljava/util/regex/Pattern;", "setPattern", "(Ljava/util/regex/Pattern;)V", "pattern2", "getPattern2", "setPattern2", "match", "p", "html", "readInputStream", "", "inStream", "Ljava/io/InputStream;", "verify", "", "link", "onResult", "Lkotlin/Function5;", "Lkotlin/ParameterName;", "name", "errCode", "errMsg", "uri", "title", "style", "plugin-finder_release"})
public final class c$a
{
  private static final Map<String, String> Bfp;
  private static final int Bfq = 0;
  private static final int Bfr = -100;
  private static final int Bfs = -200;
  private static final int Bft = -300;
  private static final int Bfu = -400;
  public static final a Bfv;
  private static final String TAG = "Finder.FinderExtendReadingVerifier";
  
  static
  {
    AppMethodBeat.i(168513);
    Bfv = new a();
    TAG = "Finder.FinderExtendReadingVerifier";
    Bfp = (Map)new LinkedHashMap();
    Bfr = -100;
    Bfs = -200;
    Bft = -300;
    Bfu = -400;
    AppMethodBeat.o(168513);
  }
  
  public static void a(String paramString, final s<? super Integer, ? super String, ? super String, ? super String, ? super Integer, x> params)
  {
    AppMethodBeat.i(277679);
    p.k(paramString, "link");
    p.k(params, "onResult");
    if ((Bfp.containsKey(paramString)) && (!Util.isNullOrNil((String)Bfp.get(paramString))))
    {
      Object localObject = Bfp.get(paramString);
      if (localObject == null) {
        p.iCn();
      }
      params.a(Integer.valueOf(0), "", paramString, localObject, Integer.valueOf(0));
      params = TAG;
      localObject = new StringBuilder("verify in cache ").append(paramString).append(", ");
      paramString = Bfp.get(paramString);
      if (paramString == null) {
        p.iCn();
      }
      Log.i(params, (String)paramString);
      AppMethodBeat.o(277679);
      return;
    }
    com.tencent.e.h.ZvG.be((Runnable)new a(paramString, params));
    AppMethodBeat.o(277679);
  }
  
  public static int ejO()
  {
    return Bfq;
  }
  
  public static int ejP()
  {
    return Bfr;
  }
  
  public static int ejQ()
  {
    return Bft;
  }
  
  public static int ejR()
  {
    return Bfu;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class a
    implements Runnable
  {
    a(String paramString, s params) {}
    
    public final void run()
    {
      AppMethodBeat.i(168510);
      Object localObject1 = c.a.Bfv;
      Log.i(c.a.ejS(), "verify " + this.qQa);
      Object localObject5;
      for (;;)
      {
        try
        {
          localObject4 = com.tencent.mm.n.h.axc().getValue("FinderExtendedReadingPrefix");
          localObject1 = localObject4;
          if (Util.isNullOrNil((String)localObject4)) {
            localObject1 = "https://" + WeChatHosts.domainString(b.j.host_mp_weixin_qq_com) + ";";
          }
          p.j(localObject1, "prefixs");
          if (localObject1 == null)
          {
            localObject1 = new t("null cannot be cast to non-null type kotlin.CharSequence");
            AppMethodBeat.o(168510);
            throw ((Throwable)localObject1);
          }
        }
        catch (MalformedURLException localMalformedURLException)
        {
          localObject4 = c.a.Bfv;
          Log.printErrStackTrace(c.a.ejS(), (Throwable)localMalformedURLException, "MalformedURLException", new Object[0]);
          Object localObject2 = params;
          localObject4 = c.a.Bfv;
          ((s)localObject2).a(Integer.valueOf(c.a.ejP()), "", this.qQa, "", Integer.valueOf(0));
          AppMethodBeat.o(168510);
          return;
          localObject4 = (Iterable)n.b((CharSequence)n.bb((CharSequence)localObject2).toString(), new char[] { ';' });
          localObject2 = (Collection)new ArrayList();
          localObject4 = ((Iterable)localObject4).iterator();
          if (!((Iterator)localObject4).hasNext()) {
            break;
          }
          localObject5 = ((Iterator)localObject4).next();
          str = (String)localObject5;
          if (str == null)
          {
            localObject2 = new t("null cannot be cast to non-null type kotlin.CharSequence");
            AppMethodBeat.o(168510);
            throw ((Throwable)localObject2);
          }
        }
        catch (IOException localIOException)
        {
          String str;
          localObject4 = c.a.Bfv;
          Log.printErrStackTrace(c.a.ejS(), (Throwable)localIOException, "IOException", new Object[0]);
          s locals = params;
          localObject4 = c.a.Bfv;
          locals.a(Integer.valueOf(c.a.ejQ()), "", this.qQa, "", Integer.valueOf(0));
          AppMethodBeat.o(168510);
          return;
          if (!Util.isNullOrNil(n.bb((CharSequence)str).toString()))
          {
            i = 1;
            if (i == 0) {
              continue;
            }
            locals.add(localObject5);
            continue;
          }
        }
        catch (Throwable localThrowable)
        {
          localObject4 = c.a.Bfv;
          Log.printErrStackTrace(c.a.ejS(), localThrowable, "Throwable", new Object[0]);
          localObject3 = params;
          localObject4 = c.a.Bfv;
          ((s)localObject3).a(Integer.valueOf(c.a.ejQ()), "", this.qQa, "", Integer.valueOf(0));
          AppMethodBeat.o(168510);
          return;
        }
        i = 0;
      }
      Object localObject3 = ((Iterable)localObject3).iterator();
      int i = 0;
      while (((Iterator)localObject3).hasNext())
      {
        localObject4 = (String)((Iterator)localObject3).next();
        localObject5 = this.qQa;
        if (localObject5 == null)
        {
          localObject3 = new t("null cannot be cast to non-null type java.lang.String");
          AppMethodBeat.o(168510);
          throw ((Throwable)localObject3);
        }
        localObject5 = ((String)localObject5).toLowerCase();
        p.j(localObject5, "(this as java.lang.String).toLowerCase()");
        if (localObject4 == null)
        {
          localObject3 = new t("null cannot be cast to non-null type kotlin.CharSequence");
          AppMethodBeat.o(168510);
          throw ((Throwable)localObject3);
        }
        if (n.M((String)localObject5, n.bb((CharSequence)localObject4).toString(), false)) {
          i = 1;
        }
      }
      if (i != 0)
      {
        new ae(this.qQa).bhW().g((a)new a() {});
        AppMethodBeat.o(168510);
        return;
      }
      localObject3 = c.a.Bfv;
      Log.i(c.a.ejS(), "scheme or host not valid");
      localObject3 = params;
      Object localObject4 = c.a.Bfv;
      ((s)localObject3).a(Integer.valueOf(c.a.ejP()), "", this.qQa, "", Integer.valueOf(0));
      AppMethodBeat.o(168510);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.view.manager.c.a
 * JD-Core Version:    0.7.0.1
 */