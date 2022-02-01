package com.tencent.mm.plugin.finder.loader;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import java.net.HttpURLConnection;
import java.net.URL;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/loader/FinderImageDownloader$DefaultHttpClientFactory;", "", "()V", "httpURLConnectionGet", "Lcom/tencent/mm/loader/model/HttpResponse;", "url", "", "openConnection", "Ljava/net/HttpURLConnection;", "plugin-finder_release"})
public final class q$b
{
  public static final b ztN;
  
  static
  {
    AppMethodBeat.i(166321);
    ztN = new b();
    AppMethodBeat.o(166321);
  }
  
  public static HttpURLConnection aDp(String paramString)
  {
    AppMethodBeat.i(166320);
    p.k(paramString, "url");
    Log.i("Finder.ImageDownloader", "[openConnection] url:".concat(String.valueOf(paramString)));
    paramString = new URL(paramString).openConnection();
    if (paramString == null)
    {
      paramString = new t("null cannot be cast to non-null type java.net.HttpURLConnection");
      AppMethodBeat.o(166320);
      throw paramString;
    }
    paramString = (HttpURLConnection)paramString;
    paramString.setConnectTimeout(15000);
    paramString.setReadTimeout(20000);
    AppMethodBeat.o(166320);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.loader.q.b
 * JD-Core Version:    0.7.0.1
 */