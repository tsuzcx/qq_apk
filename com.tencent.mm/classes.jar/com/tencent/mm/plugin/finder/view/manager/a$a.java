package com.tencent.mm.plugin.finder.view.manager;

import com.tencent.e.h;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.m.e;
import com.tencent.mm.m.g;
import com.tencent.mm.network.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import d.g.a.q;
import d.g.b.k;
import d.l;
import d.n.d;
import d.n.n;
import d.v;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/view/manager/FinderExtendReadingManager$FinderExtendReadingVerifier;", "", "()V", "ERROR_CODE_OK", "", "getERROR_CODE_OK", "()I", "ERROR_CODE_OUT_OF_TIME", "getERROR_CODE_OUT_OF_TIME", "ERROR_CODE_PARSE_FAILED", "getERROR_CODE_PARSE_FAILED", "ERROR_CODE_URL_INVALID", "getERROR_CODE_URL_INVALID", "TAG", "", "cacheLinks", "", "getCacheLinks", "()Ljava/util/Map;", "pattern", "Ljava/util/regex/Pattern;", "getPattern", "()Ljava/util/regex/Pattern;", "setPattern", "(Ljava/util/regex/Pattern;)V", "pattern2", "getPattern2", "setPattern2", "match", "p", "html", "readInputStream", "", "inStream", "Ljava/io/InputStream;", "verify", "", "link", "onResult", "Lkotlin/Function3;", "Lkotlin/ParameterName;", "name", "errCode", "uri", "title", "plugin-finder_release"})
public final class a$a
{
  private static final String TAG = "Finder.FinderExtendReadingVerifier";
  private static Pattern jmw;
  private static final Map<String, String> qZb;
  private static Pattern qZc;
  private static final int qZd = 0;
  private static final int qZe = -1;
  private static final int qZf = -2;
  private static final int qZg = -3;
  public static final a qZh;
  
  static
  {
    AppMethodBeat.i(168513);
    qZh = new a();
    TAG = "Finder.FinderExtendReadingVerifier";
    qZb = (Map)new LinkedHashMap();
    qZe = -1;
    qZf = -2;
    qZg = -3;
    AppMethodBeat.o(168513);
  }
  
  public static byte[] G(InputStream paramInputStream)
  {
    AppMethodBeat.i(168512);
    k.h(paramInputStream, "inStream");
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    byte[] arrayOfByte = new byte[1024];
    for (int i = paramInputStream.read(arrayOfByte); i != -1; i = paramInputStream.read(arrayOfByte)) {
      localByteArrayOutputStream.write(arrayOfByte, 0, i);
    }
    paramInputStream.close();
    paramInputStream = localByteArrayOutputStream.toByteArray();
    k.g(paramInputStream, "outStream.toByteArray()");
    AppMethodBeat.o(168512);
    return paramInputStream;
  }
  
  public static String a(Pattern paramPattern, String paramString)
  {
    AppMethodBeat.i(177565);
    k.h(paramString, "html");
    if (paramPattern == null)
    {
      AppMethodBeat.o(177565);
      return "";
    }
    paramPattern = paramPattern.matcher((CharSequence)paramString);
    if ((paramPattern.find()) && (paramPattern.groupCount() > 0))
    {
      paramPattern = paramPattern.group(1);
      ad.i(TAG, "succ ".concat(String.valueOf(paramPattern)));
      k.g(paramPattern, "title");
      AppMethodBeat.o(177565);
      return paramPattern;
    }
    ad.i(TAG, "regex not find");
    AppMethodBeat.o(177565);
    return "";
  }
  
  public static void a(String paramString, final q<? super Integer, ? super String, ? super String, d.y> paramq)
  {
    AppMethodBeat.i(168511);
    k.h(paramString, "link");
    k.h(paramq, "onResult");
    if ((qZb.containsKey(paramString)) && (!bt.isNullOrNil((String)qZb.get(paramString))))
    {
      Object localObject = qZb.get(paramString);
      if (localObject == null) {
        k.fvU();
      }
      paramq.d(Integer.valueOf(0), paramString, localObject);
      paramq = TAG;
      localObject = new StringBuilder("verify in cache ").append(paramString).append(", ");
      paramString = qZb.get(paramString);
      if (paramString == null) {
        k.fvU();
      }
      ad.i(paramq, (String)paramString);
      AppMethodBeat.o(168511);
      return;
    }
    h.Iye.aP((Runnable)new a(paramString, paramq));
    AppMethodBeat.o(168511);
  }
  
  public static void a(Pattern paramPattern)
  {
    jmw = paramPattern;
  }
  
  public static void b(Pattern paramPattern)
  {
    qZc = paramPattern;
  }
  
  public static Map<String, String> ctd()
  {
    return qZb;
  }
  
  public static Pattern cte()
  {
    return jmw;
  }
  
  public static Pattern ctf()
  {
    return qZc;
  }
  
  public static int ctg()
  {
    return qZd;
  }
  
  public static int cth()
  {
    return qZe;
  }
  
  public static int cti()
  {
    return qZg;
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "run"})
  static final class a
    implements Runnable
  {
    a(String paramString, q paramq) {}
    
    public final void run()
    {
      AppMethodBeat.i(168510);
      Object localObject1 = a.a.qZh;
      ad.i(a.a.ctj(), "verify " + this.qrc);
      Object localObject4;
      Object localObject5;
      for (;;)
      {
        try
        {
          localObject4 = g.Zd().getValue("FinderExtendedReadingPrefix");
          localObject1 = localObject4;
          if (bt.isNullOrNil((String)localObject4)) {
            localObject1 = "https://mp.weixin.qq.com;";
          }
          k.g(localObject1, "prefixs");
          if (localObject1 == null)
          {
            localObject1 = new v("null cannot be cast to non-null type kotlin.CharSequence");
            AppMethodBeat.o(168510);
            throw ((Throwable)localObject1);
          }
        }
        catch (MalformedURLException localMalformedURLException)
        {
          localObject4 = a.a.qZh;
          ad.printErrStackTrace(a.a.ctj(), (Throwable)localMalformedURLException, "MalformedURLException", new Object[0]);
          Object localObject2 = paramq;
          localObject4 = a.a.qZh;
          ((q)localObject2).d(Integer.valueOf(a.a.cth()), this.qrc, "");
          AppMethodBeat.o(168510);
          return;
          localObject4 = (Iterable)n.b((CharSequence)n.trim((CharSequence)localObject2).toString(), new char[] { ';' });
          localObject2 = (Collection)new ArrayList();
          localObject4 = ((Iterable)localObject4).iterator();
          if (!((Iterator)localObject4).hasNext()) {
            break;
          }
          localObject5 = ((Iterator)localObject4).next();
          str = (String)localObject5;
          if (str == null)
          {
            localObject2 = new v("null cannot be cast to non-null type kotlin.CharSequence");
            AppMethodBeat.o(168510);
            throw ((Throwable)localObject2);
          }
        }
        catch (IOException localIOException)
        {
          String str;
          localObject4 = a.a.qZh;
          ad.printErrStackTrace(a.a.ctj(), (Throwable)localIOException, "IOException", new Object[0]);
          q localq = paramq;
          localObject4 = a.a.qZh;
          localq.d(Integer.valueOf(a.a.cti()), this.qrc, "");
          AppMethodBeat.o(168510);
          return;
          if (!bt.isNullOrNil(n.trim((CharSequence)str).toString()))
          {
            i = 1;
            if (i == 0) {
              continue;
            }
            localq.add(localObject5);
            continue;
          }
        }
        catch (Throwable localThrowable)
        {
          localObject4 = a.a.qZh;
          ad.printErrStackTrace(a.a.ctj(), localThrowable, "Throwable", new Object[0]);
          localObject3 = paramq;
          localObject4 = a.a.qZh;
          ((q)localObject3).d(Integer.valueOf(a.a.cti()), this.qrc, "");
          AppMethodBeat.o(168510);
          return;
        }
        i = 0;
      }
      Object localObject3 = ((Iterable)localObject3).iterator();
      int i = 0;
      for (;;)
      {
        if (((Iterator)localObject3).hasNext())
        {
          localObject4 = (String)((Iterator)localObject3).next();
          localObject5 = this.qrc;
          if (localObject5 == null)
          {
            localObject3 = new v("null cannot be cast to non-null type java.lang.String");
            AppMethodBeat.o(168510);
            throw ((Throwable)localObject3);
          }
          localObject5 = ((String)localObject5).toLowerCase();
          k.g(localObject5, "(this as java.lang.String).toLowerCase()");
          if (localObject4 == null)
          {
            localObject3 = new v("null cannot be cast to non-null type kotlin.CharSequence");
            AppMethodBeat.o(168510);
            throw ((Throwable)localObject3);
          }
          if (n.mA((String)localObject5, n.trim((CharSequence)localObject4).toString())) {
            i = 1;
          }
        }
        else
        {
          if (i != 0)
          {
            localObject3 = b.AZ(this.qrc);
            ((com.tencent.mm.network.y)localObject3).aFa();
            ((com.tencent.mm.network.y)localObject3).setConnectTimeout(3000);
            ((com.tencent.mm.network.y)localObject3).setReadTimeout(3000);
            localObject4 = a.a.qZh;
            k.g(localObject3, "connectionHttps");
            localObject3 = ((com.tencent.mm.network.y)localObject3).getInputStream();
            k.g(localObject3, "connectionHttps.inputStream");
            localObject5 = new String(a.a.G((InputStream)localObject3), d.UTF_8);
            localObject3 = a.a.qZh;
            if (a.a.cte() == null)
            {
              localObject3 = a.a.qZh;
              a.a.a(Pattern.compile("var msg_title = \"(.*)\";"));
            }
            localObject3 = a.a.qZh;
            if (a.a.ctf() == null)
            {
              localObject3 = a.a.qZh;
              a.a.b(Pattern.compile("property=\"og:title\"\\s*content=\"(.*)\""));
            }
            localObject3 = a.a.qZh;
            localObject3 = a.a.qZh;
            localObject4 = a.a.a(a.a.cte(), (String)localObject5);
            localObject3 = localObject4;
            if (bt.isNullOrNil((String)localObject4))
            {
              localObject3 = a.a.qZh;
              localObject3 = a.a.qZh;
              localObject3 = a.a.a(a.a.ctf(), (String)localObject5);
            }
            if (!bt.isNullOrNil((String)localObject3))
            {
              localObject4 = paramq;
              localObject5 = a.a.qZh;
              ((q)localObject4).d(Integer.valueOf(a.a.ctg()), this.qrc, localObject3);
              localObject4 = a.a.qZh;
              a.a.ctd().put(this.qrc, localObject3);
              AppMethodBeat.o(168510);
              return;
            }
            localObject3 = paramq;
            localObject4 = a.a.qZh;
            ((q)localObject3).d(Integer.valueOf(a.a.cti()), this.qrc, "");
            AppMethodBeat.o(168510);
            return;
          }
          localObject3 = a.a.qZh;
          ad.i(a.a.ctj(), "scheme or host not valid");
          localObject3 = paramq;
          localObject4 = a.a.qZh;
          ((q)localObject3).d(Integer.valueOf(a.a.cth()), this.qrc, "");
          AppMethodBeat.o(168510);
          return;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.view.manager.a.a
 * JD-Core Version:    0.7.0.1
 */