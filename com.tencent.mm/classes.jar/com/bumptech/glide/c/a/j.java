package com.bumptech.glide.c.a;

import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import com.bumptech.glide.c.a;
import com.bumptech.glide.c.c.h;
import com.bumptech.glide.h.c;
import com.bumptech.glide.h.i;
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
  static final b aDB;
  private final com.bumptech.glide.c.c.g aDC;
  private final b aDD;
  private HttpURLConnection aDE;
  private InputStream aDF;
  private volatile boolean isCancelled;
  private final int timeout;
  
  static
  {
    AppMethodBeat.i(76893);
    aDB = new a();
    AppMethodBeat.o(76893);
  }
  
  public j(com.bumptech.glide.c.c.g paramg, int paramInt)
  {
    this(paramg, paramInt, aDB);
  }
  
  private j(com.bumptech.glide.c.c.g paramg, int paramInt, b paramb)
  {
    this.aDC = paramg;
    this.timeout = paramInt;
    this.aDD = paramb;
  }
  
  private InputStream a(URL paramURL1, int paramInt, URL paramURL2, Map<String, String> paramMap)
  {
    AppMethodBeat.i(76891);
    int j;
    for (;;)
    {
      if (paramInt >= 5)
      {
        paramURL1 = new com.bumptech.glide.c.e("Too many (> 5) redirects!");
        AppMethodBeat.o(76891);
        throw paramURL1;
      }
      if (paramURL2 != null) {
        try
        {
          if (paramURL1.toURI().equals(paramURL2.toURI()))
          {
            paramURL2 = new com.bumptech.glide.c.e("In re-direct loop");
            AppMethodBeat.o(76891);
            throw paramURL2;
          }
        }
        catch (URISyntaxException paramURL2) {}
      }
      this.aDE = this.aDD.b(paramURL1);
      paramURL2 = paramMap.entrySet().iterator();
      while (paramURL2.hasNext())
      {
        localObject = (Map.Entry)paramURL2.next();
        this.aDE.addRequestProperty((String)((Map.Entry)localObject).getKey(), (String)((Map.Entry)localObject).getValue());
      }
      this.aDE.setConnectTimeout(this.timeout);
      this.aDE.setReadTimeout(this.timeout);
      this.aDE.setUseCaches(false);
      this.aDE.setDoInput(true);
      this.aDE.setInstanceFollowRedirects(false);
      this.aDE.connect();
      this.aDF = this.aDE.getInputStream();
      if (this.isCancelled)
      {
        AppMethodBeat.o(76891);
        return null;
      }
      j = this.aDE.getResponseCode();
      if (j / 100 == 2)
      {
        i = 1;
        if (i == 0) {
          break label332;
        }
        paramURL1 = this.aDE;
        if (!TextUtils.isEmpty(paramURL1.getContentEncoding())) {
          break label295;
        }
        paramInt = paramURL1.getContentLength();
      }
      for (this.aDF = c.a(paramURL1.getInputStream(), paramInt);; this.aDF = paramURL1.getInputStream())
      {
        paramURL1 = this.aDF;
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
        paramURL2 = this.aDE.getHeaderField("Location");
        if (!TextUtils.isEmpty(paramURL2)) {
          break;
        }
        paramURL1 = new com.bumptech.glide.c.e("Received empty or null redirect url");
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
      paramURL1 = new com.bumptech.glide.c.e(j);
      AppMethodBeat.o(76891);
      throw paramURL1;
    }
    paramURL1 = new com.bumptech.glide.c.e(this.aDE.getResponseMessage(), j);
    AppMethodBeat.o(76891);
    throw paramURL1;
  }
  
  public final void a(com.bumptech.glide.g paramg, d.a<? super InputStream> parama)
  {
    AppMethodBeat.i(76890);
    long l = com.bumptech.glide.h.e.pY();
    try
    {
      com.bumptech.glide.c.c.g localg = this.aDC;
      if (localg.aIk == null)
      {
        if (TextUtils.isEmpty(localg.aIj))
        {
          String str = localg.aIi;
          paramg = str;
          if (TextUtils.isEmpty(str)) {
            paramg = ((URL)i.checkNotNull(localg.url, "Argument must not be null")).toString();
          }
          localg.aIj = Uri.encode(paramg, "@#&=*+-_.,:!?()/~'%;$");
        }
        localg.aIk = new URL(localg.aIj);
      }
      parama.R(a(localg.aIk, 0, null, this.aDC.aIh.getHeaders()));
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
        new StringBuilder("Finished http url fetcher fetch in ").append(com.bumptech.glide.h.e.p(l));
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
    if (this.aDF != null) {}
    try
    {
      this.aDF.close();
      label20:
      if (this.aDE != null) {
        this.aDE.disconnect();
      }
      this.aDE = null;
      AppMethodBeat.o(76892);
      return;
    }
    catch (IOException localIOException)
    {
      break label20;
    }
  }
  
  public final Class<InputStream> nU()
  {
    return InputStream.class;
  }
  
  public final a nV()
  {
    return a.aCQ;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.bumptech.glide.c.a.j
 * JD-Core Version:    0.7.0.1
 */