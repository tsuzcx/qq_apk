package com.bumptech.glide.load.a;

import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import com.bumptech.glide.g.c;
import com.bumptech.glide.g.f;
import com.bumptech.glide.load.a;
import com.bumptech.glide.load.c.h;
import com.bumptech.glide.load.e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public final class j
  implements d<InputStream>
{
  static final b aFi;
  private final com.bumptech.glide.load.c.g aFj;
  private final b aFk;
  private HttpURLConnection aFl;
  private InputStream aFm;
  private volatile boolean isCancelled;
  private final int timeout;
  
  static
  {
    AppMethodBeat.i(76893);
    aFi = new a();
    AppMethodBeat.o(76893);
  }
  
  public j(com.bumptech.glide.load.c.g paramg, int paramInt)
  {
    this(paramg, paramInt, aFi);
  }
  
  private j(com.bumptech.glide.load.c.g paramg, int paramInt, b paramb)
  {
    this.aFj = paramg;
    this.timeout = paramInt;
    this.aFk = paramb;
  }
  
  private InputStream a(URL paramURL1, int paramInt, URL paramURL2, Map<String, String> paramMap)
  {
    AppMethodBeat.i(76891);
    int j;
    for (;;)
    {
      if (paramInt >= 5)
      {
        paramURL1 = new e("Too many (> 5) redirects!");
        AppMethodBeat.o(76891);
        throw paramURL1;
      }
      if (paramURL2 != null) {
        try
        {
          if (paramURL1.toURI().equals(paramURL2.toURI()))
          {
            paramURL2 = new e("In re-direct loop");
            AppMethodBeat.o(76891);
            throw paramURL2;
          }
        }
        catch (URISyntaxException paramURL2) {}
      }
      this.aFl = this.aFk.b(paramURL1);
      paramURL2 = paramMap.entrySet().iterator();
      while (paramURL2.hasNext())
      {
        localObject = (Map.Entry)paramURL2.next();
        this.aFl.addRequestProperty((String)((Map.Entry)localObject).getKey(), (String)((Map.Entry)localObject).getValue());
      }
      this.aFl.setConnectTimeout(this.timeout);
      this.aFl.setReadTimeout(this.timeout);
      this.aFl.setUseCaches(false);
      this.aFl.setDoInput(true);
      this.aFl.setInstanceFollowRedirects(false);
      this.aFl.connect();
      this.aFm = this.aFl.getInputStream();
      if (this.isCancelled)
      {
        AppMethodBeat.o(76891);
        return null;
      }
      j = this.aFl.getResponseCode();
      if (j / 100 == 2)
      {
        i = 1;
        if (i == 0) {
          break label332;
        }
        paramURL1 = this.aFl;
        if (!TextUtils.isEmpty(paramURL1.getContentEncoding())) {
          break label295;
        }
        paramInt = paramURL1.getContentLength();
      }
      for (this.aFm = c.a(paramURL1.getInputStream(), paramInt);; this.aFm = paramURL1.getInputStream())
      {
        paramURL1 = this.aFm;
        AppMethodBeat.o(76891);
        return paramURL1;
        i = 0;
        break;
        label295:
        if (Log.isLoggable("HttpUrlFetcher", 3)) {
          new StringBuilder("Got non empty content encoding: ").append(paramURL1.getContentEncoding());
        }
      }
      label332:
      if (j / 100 == 3) {}
      for (int i = 1;; i = 0)
      {
        if (i == 0) {
          break label416;
        }
        paramURL2 = this.aFl.getHeaderField("Location");
        if (!TextUtils.isEmpty(paramURL2)) {
          break;
        }
        paramURL1 = new e("Received empty or null redirect url");
        AppMethodBeat.o(76891);
        throw paramURL1;
      }
      Object localObject = new URL(paramURL1, paramURL2);
      cleanup();
      paramInt += 1;
      paramURL2 = paramURL1;
      paramURL1 = (URL)localObject;
    }
    label416:
    if (j == -1)
    {
      paramURL1 = new e(j);
      AppMethodBeat.o(76891);
      throw paramURL1;
    }
    paramURL1 = new e(this.aFl.getResponseMessage(), j);
    AppMethodBeat.o(76891);
    throw paramURL1;
  }
  
  public final void a(com.bumptech.glide.g paramg, d.a<? super InputStream> parama)
  {
    AppMethodBeat.i(76890);
    long l = f.qt();
    try
    {
      com.bumptech.glide.load.c.g localg = this.aFj;
      if (localg.aJU == null)
      {
        if (TextUtils.isEmpty(localg.aJT))
        {
          String str = localg.aJS;
          paramg = str;
          if (TextUtils.isEmpty(str)) {
            paramg = ((URL)com.bumptech.glide.g.j.checkNotNull(localg.url, "Argument must not be null")).toString();
          }
          localg.aJT = Uri.encode(paramg, "@#&=*+-_.,:!?()/~'%;$");
        }
        localg.aJU = new URL(localg.aJT);
      }
      parama.S(a(localg.aJU, 0, null, this.aFj.aJR.getHeaders()));
      return;
    }
    catch (IOException paramg)
    {
      Log.isLoggable("HttpUrlFetcher", 3);
      parama.e(paramg);
      return;
    }
    finally
    {
      if (Log.isLoggable("HttpUrlFetcher", 2)) {
        new StringBuilder("Finished http url fetcher fetch in ").append(f.p(l));
      }
      AppMethodBeat.o(76890);
    }
    AppMethodBeat.o(76890);
  }
  
  public final void cancel()
  {
    this.isCancelled = true;
  }
  
  public final void cleanup()
  {
    AppMethodBeat.i(76892);
    if (this.aFm != null) {}
    try
    {
      this.aFm.close();
      label20:
      if (this.aFl != null) {
        this.aFl.disconnect();
      }
      this.aFl = null;
      AppMethodBeat.o(76892);
      return;
    }
    catch (IOException localIOException)
    {
      break label20;
    }
  }
  
  public final Class<InputStream> os()
  {
    return InputStream.class;
  }
  
  public final a ot()
  {
    return a.aEH;
  }
  
  static final class a
    implements j.b
  {
    public final HttpURLConnection b(URL paramURL)
    {
      AppMethodBeat.i(76889);
      paramURL = (HttpURLConnection)paramURL.openConnection();
      AppMethodBeat.o(76889);
      return paramURL;
    }
  }
  
  static abstract interface b
  {
    public abstract HttpURLConnection b(URL paramURL);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.bumptech.glide.load.a.j
 * JD-Core Version:    0.7.0.1
 */