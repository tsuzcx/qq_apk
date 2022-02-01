package com.tencent.mm.plugin.finder.loader;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.d.b.b;
import com.tencent.mm.loader.e.d;
import com.tencent.mm.loader.h.a.a;
import com.tencent.mm.plugin.finder.storage.h;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import d.g.b.k;
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

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/loader/FinderImageDownloader;", "Lcom/tencent/mm/loader/common/IDataFetcher;", "Lcom/tencent/mm/plugin/finder/loader/FinderLoaderData;", "()V", "loadDataImp", "", "item", "Lcom/tencent/mm/loader/model/data/DataItem;", "fileNameCreator", "Lcom/tencent/mm/loader/listener/ILoadFileNameCreator;", "callback", "Lcom/tencent/mm/loader/common/IDataFetcher$IDataReady2;", "Companion", "DefaultHttpClientFactory", "plugin-finder_release"})
public final class g
  extends com.tencent.mm.loader.d.b<j>
{
  public static final a qCm;
  
  static
  {
    AppMethodBeat.i(166323);
    qCm = new a((byte)0);
    AppMethodBeat.o(166323);
  }
  
  public final void a(a<j> parama, com.tencent.mm.loader.f.f paramf, b.b paramb)
  {
    AppMethodBeat.i(166322);
    k.h(parama, "item");
    k.h(paramf, "fileNameCreator");
    k.h(paramb, "callback");
    try
    {
      paramf = (j)parama.value();
      if (paramf.cmR() == h.qJY)
      {
        parama = paramf.getUrl();
        ad.d("Finder.ImageDownloader", "loadDataImp http " + paramf.cmR() + " thumbUrl " + paramf.cmT() + " url " + paramf.getUrl());
        paramf = b.qCn;
        k.h(parama, "url");
        parama = b.Zc(parama);
        if (parama.getResponseCode() < 300) {
          break label172;
        }
        parama.disconnect();
        ad.w("Finder.ImageDownloader", "dz[httpURLConnectionGet 300]");
      }
      label172:
      Object localObject;
      for (parama = null;; parama = com.tencent.mm.loader.h.b.d((byte[])localObject, paramf))
      {
        if (parama == null) {
          break label204;
        }
        paramb.a((com.tencent.mm.loader.h.f)parama);
        AppMethodBeat.o(166322);
        return;
        parama = paramf.cmT();
        break;
        localObject = parama.getInputStream();
        paramf = parama.getContentType();
        localObject = d.p((InputStream)localObject);
        parama.disconnect();
      }
      label204:
      paramb.onError();
      AppMethodBeat.o(166322);
      return;
    }
    catch (InterruptedException parama)
    {
      ad.e("Finder.ImageDownloader", "[cpan] getOption image data failed.:%s", new Object[] { bt.m((Throwable)parama) });
      paramb.onError();
      AppMethodBeat.o(166322);
      return;
    }
    catch (UnknownHostException parama)
    {
      for (;;)
      {
        ad.e("Finder.ImageDownloader", "[cpan] getOption image data failed.:%s", new Object[] { bt.m((Throwable)parama) });
      }
    }
    catch (SSLHandshakeException parama)
    {
      for (;;)
      {
        ad.e("Finder.ImageDownloader", "[cpan] getOption image data failed.:%s", new Object[] { bt.m((Throwable)parama) });
      }
    }
    catch (SocketException parama)
    {
      for (;;)
      {
        ad.e("Finder.ImageDownloader", "[cpan] getOption image data failed.:%s", new Object[] { bt.m((Throwable)parama) });
      }
    }
    catch (SocketTimeoutException parama)
    {
      for (;;)
      {
        ad.e("Finder.ImageDownloader", "[cpan] getOption image data failed.:%s", new Object[] { bt.m((Throwable)parama) });
      }
    }
    catch (IOException parama)
    {
      for (;;)
      {
        ad.e("Finder.ImageDownloader", "[cpan] getOption image data failed.:%s", new Object[] { bt.m((Throwable)parama) });
      }
    }
    catch (Exception parama)
    {
      for (;;)
      {
        ad.e("Finder.ImageDownloader", "[cpan] getOption image data failed.:%s", new Object[] { bt.m((Throwable)parama) });
      }
    }
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/loader/FinderImageDownloader$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
  public static final class a {}
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/loader/FinderImageDownloader$DefaultHttpClientFactory;", "", "()V", "httpURLConnectionGet", "Lcom/tencent/mm/loader/model/HttpResponse;", "url", "", "openConnection", "Ljava/net/HttpURLConnection;", "plugin-finder_release"})
  public static final class b
  {
    public static final b qCn;
    
    static
    {
      AppMethodBeat.i(166321);
      qCn = new b();
      AppMethodBeat.o(166321);
    }
    
    public static HttpURLConnection Zc(String paramString)
    {
      AppMethodBeat.i(166320);
      k.h(paramString, "url");
      ad.i("Finder.ImageDownloader", "[openConnection] url:".concat(String.valueOf(paramString)));
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.loader.g
 * JD-Core Version:    0.7.0.1
 */