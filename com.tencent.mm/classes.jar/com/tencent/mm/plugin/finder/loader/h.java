package com.tencent.mm.plugin.finder.loader;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.d.b.b;
import com.tencent.mm.loader.e.e;
import com.tencent.mm.loader.f.g;
import com.tencent.mm.loader.h.a.a;
import com.tencent.mm.loader.h.f;
import com.tencent.mm.plugin.finder.storage.r;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import d.g.b.p;
import d.l;
import d.v;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.net.UnknownHostException;
import javax.net.ssl.SSLHandshakeException;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/loader/FinderImageDownloader;", "Lcom/tencent/mm/loader/common/IDataFetcher;", "Lcom/tencent/mm/plugin/finder/loader/FinderLoaderData;", "()V", "loadDataImp", "", "item", "Lcom/tencent/mm/loader/model/data/DataItem;", "fileNameCreator", "Lcom/tencent/mm/loader/listener/ILoadFileNameCreator;", "callback", "Lcom/tencent/mm/loader/common/IDataFetcher$IDataReady2;", "Companion", "DefaultHttpClientFactory", "plugin-finder_release"})
public final class h
  extends com.tencent.mm.loader.d.b<k>
{
  public static final a srA;
  
  static
  {
    AppMethodBeat.i(166323);
    srA = new a((byte)0);
    AppMethodBeat.o(166323);
  }
  
  public final void a(a<k> parama, g paramg, b.b paramb)
  {
    AppMethodBeat.i(166322);
    p.h(parama, "item");
    p.h(paramg, "fileNameCreator");
    p.h(paramb, "callback");
    try
    {
      paramg = (k)parama.value();
      if (paramg.cEj() == r.sJu)
      {
        parama = paramg.getUrl();
        ae.i("Finder.ImageDownloader", "loadDataImp http " + paramg.cEj() + " thumbUrl " + paramg.all() + " url " + paramg.getUrl());
        paramg = b.srB;
        p.h(parama, "url");
        parama = b.aiu(parama);
        if (parama.getResponseCode() < 300) {
          break label172;
        }
        parama.disconnect();
        ae.w("Finder.ImageDownloader", "dz[httpURLConnectionGet 300]");
      }
      label172:
      Object localObject;
      for (parama = null;; parama = com.tencent.mm.loader.h.b.d((byte[])localObject, paramg))
      {
        if (parama == null) {
          break label204;
        }
        paramb.a((f)parama);
        AppMethodBeat.o(166322);
        return;
        parama = paramg.all();
        break;
        localObject = parama.getInputStream();
        paramg = parama.getContentType();
        localObject = e.s((InputStream)localObject);
        parama.disconnect();
      }
      label204:
      paramb.onError();
      AppMethodBeat.o(166322);
      return;
    }
    catch (InterruptedException parama)
    {
      ae.e("Finder.ImageDownloader", "[cpan] getOption image data failed.:%s", new Object[] { bu.o((Throwable)parama) });
      paramb.onError();
      AppMethodBeat.o(166322);
      return;
    }
    catch (UnknownHostException parama)
    {
      for (;;)
      {
        ae.e("Finder.ImageDownloader", "[cpan] getOption image data failed.:%s", new Object[] { bu.o((Throwable)parama) });
      }
    }
    catch (SSLHandshakeException parama)
    {
      for (;;)
      {
        ae.e("Finder.ImageDownloader", "[cpan] getOption image data failed.:%s", new Object[] { bu.o((Throwable)parama) });
      }
    }
    catch (SocketException parama)
    {
      for (;;)
      {
        ae.e("Finder.ImageDownloader", "[cpan] getOption image data failed.:%s", new Object[] { bu.o((Throwable)parama) });
      }
    }
    catch (SocketTimeoutException parama)
    {
      for (;;)
      {
        ae.e("Finder.ImageDownloader", "[cpan] getOption image data failed.:%s", new Object[] { bu.o((Throwable)parama) });
      }
    }
    catch (IOException parama)
    {
      for (;;)
      {
        ae.e("Finder.ImageDownloader", "[cpan] getOption image data failed.:%s", new Object[] { bu.o((Throwable)parama) });
      }
    }
    catch (Exception parama)
    {
      for (;;)
      {
        ae.e("Finder.ImageDownloader", "[cpan] getOption image data failed.:%s", new Object[] { bu.o((Throwable)parama) });
      }
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/loader/FinderImageDownloader$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
  public static final class a {}
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/loader/FinderImageDownloader$DefaultHttpClientFactory;", "", "()V", "httpURLConnectionGet", "Lcom/tencent/mm/loader/model/HttpResponse;", "url", "", "openConnection", "Ljava/net/HttpURLConnection;", "plugin-finder_release"})
  public static final class b
  {
    public static final b srB;
    
    static
    {
      AppMethodBeat.i(166321);
      srB = new b();
      AppMethodBeat.o(166321);
    }
    
    public static HttpURLConnection aiu(String paramString)
    {
      AppMethodBeat.i(166320);
      p.h(paramString, "url");
      ae.i("Finder.ImageDownloader", "[openConnection] url:".concat(String.valueOf(paramString)));
      paramString = new URL(paramString).openConnection();
      if (paramString == null)
      {
        paramString = new v("null cannot be cast to non-null type java.net.HttpURLConnection");
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.loader.h
 * JD-Core Version:    0.7.0.1
 */