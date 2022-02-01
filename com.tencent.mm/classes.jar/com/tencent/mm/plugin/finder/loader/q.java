package com.tencent.mm.plugin.finder.loader;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.d.b.b;
import com.tencent.mm.loader.e.e;
import com.tencent.mm.loader.f.g;
import com.tencent.mm.loader.h.a.a;
import com.tencent.mm.loader.h.f;
import com.tencent.mm.plugin.finder.storage.u;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import javax.net.ssl.SSLHandshakeException;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/loader/FinderImageDownloader;", "Lcom/tencent/mm/loader/common/IDataFetcher;", "Lcom/tencent/mm/plugin/finder/loader/FinderLoaderData;", "()V", "loadDataImp", "", "item", "Lcom/tencent/mm/loader/model/data/DataItem;", "fileNameCreator", "Lcom/tencent/mm/loader/listener/ILoadFileNameCreator;", "callback", "Lcom/tencent/mm/loader/common/IDataFetcher$IDataReady2;", "Companion", "DefaultHttpClientFactory", "plugin-finder_release"})
public final class q
  extends com.tencent.mm.loader.d.b<w>
{
  public static final a ztM;
  
  static
  {
    AppMethodBeat.i(166323);
    ztM = new a((byte)0);
    AppMethodBeat.o(166323);
  }
  
  public final void a(a<w> parama, g paramg, b.b paramb)
  {
    AppMethodBeat.i(166322);
    p.k(parama, "item");
    p.k(paramg, "fileNameCreator");
    p.k(paramb, "callback");
    try
    {
      paramg = (w)parama.aSr();
      if (paramg.dIX() == u.Aly)
      {
        parama = paramg.getUrl();
        Log.i("Finder.ImageDownloader", "loadDataImp http " + paramg.dIX() + " thumbUrl " + paramg.aJi() + " url " + paramg.getUrl());
        paramg = q.b.ztN;
        p.k(parama, "url");
        parama = q.b.aDp(parama);
        if (parama.getResponseCode() < 300) {
          break label172;
        }
        parama.disconnect();
        Log.w("Finder.ImageDownloader", "dz[httpURLConnectionGet 300]");
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
        parama = paramg.aJi();
        break;
        localObject = parama.getInputStream();
        paramg = parama.getContentType();
        localObject = e.p((InputStream)localObject);
        parama.disconnect();
      }
      label204:
      paramb.onError();
      AppMethodBeat.o(166322);
      return;
    }
    catch (InterruptedException parama)
    {
      Log.e("Finder.ImageDownloader", "[cpan] getOption image data failed.:%s", new Object[] { Util.stackTraceToString((Throwable)parama) });
      paramb.onError();
      AppMethodBeat.o(166322);
      return;
    }
    catch (UnknownHostException parama)
    {
      for (;;)
      {
        Log.e("Finder.ImageDownloader", "[cpan] getOption image data failed.:%s", new Object[] { Util.stackTraceToString((Throwable)parama) });
      }
    }
    catch (SSLHandshakeException parama)
    {
      for (;;)
      {
        Log.e("Finder.ImageDownloader", "[cpan] getOption image data failed.:%s", new Object[] { Util.stackTraceToString((Throwable)parama) });
      }
    }
    catch (SocketException parama)
    {
      for (;;)
      {
        Log.e("Finder.ImageDownloader", "[cpan] getOption image data failed.:%s", new Object[] { Util.stackTraceToString((Throwable)parama) });
      }
    }
    catch (SocketTimeoutException parama)
    {
      for (;;)
      {
        Log.e("Finder.ImageDownloader", "[cpan] getOption image data failed.:%s", new Object[] { Util.stackTraceToString((Throwable)parama) });
      }
    }
    catch (IOException parama)
    {
      for (;;)
      {
        Log.e("Finder.ImageDownloader", "[cpan] getOption image data failed.:%s", new Object[] { Util.stackTraceToString((Throwable)parama) });
      }
    }
    catch (Exception parama)
    {
      for (;;)
      {
        Log.e("Finder.ImageDownloader", "[cpan] getOption image data failed.:%s", new Object[] { Util.stackTraceToString((Throwable)parama) });
      }
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/loader/FinderImageDownloader$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.loader.q
 * JD-Core Version:    0.7.0.1
 */