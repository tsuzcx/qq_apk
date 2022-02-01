package com.tencent.mm.av;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.os.AsyncTask;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.g;
import com.tencent.mm.loader.j.b;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.sdk.platformtools.h;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class r
  implements d.c
{
  List<c> ifB;
  c ifC;
  boolean ifD;
  
  public r()
  {
    AppMethodBeat.i(150764);
    this.ifB = new LinkedList();
    this.ifC = null;
    this.ifD = false;
    AppMethodBeat.o(150764);
  }
  
  static String Gc(String paramString)
  {
    AppMethodBeat.i(150769);
    try
    {
      String str = URLEncoder.encode(paramString, "UTF-8");
      if (bu.isNullOrNil(str))
      {
        ae.e("MicroMsg.UrlImageCacheService", "encode result is null: ".concat(String.valueOf(paramString)));
        AppMethodBeat.o(150769);
        return null;
      }
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      ae.e("MicroMsg.UrlImageCacheService", "try encode unsupport character: ".concat(String.valueOf(paramString)));
      AppMethodBeat.o(150769);
      return null;
    }
    paramString = new StringBuilder();
    paramString.append(b.ass());
    int j = localUnsupportedEncodingException.length();
    int i = 0;
    while (i < j)
    {
      paramString.append('/');
      if (i + 20 < j)
      {
        paramString.append(localUnsupportedEncodingException.substring(i, i + 20));
        i += 20;
      }
      else
      {
        paramString.append(localUnsupportedEncodingException.substring(i, j));
        i = j;
      }
    }
    paramString = paramString.toString();
    AppMethodBeat.o(150769);
    return paramString;
  }
  
  public final void a(Bitmap paramBitmap, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(150770);
    if (paramBitmap == null)
    {
      ae.e("MicroMsg.UrlImageCacheService", "load from url failed: " + this.ifC.url);
      this.ifC = null;
      aJd();
      AppMethodBeat.o(150770);
      return;
    }
    ae.i("MicroMsg.UrlImageCacheService", "load from %s successed", new Object[] { this.ifC.url });
    boolean bool;
    if ((!bu.isNullOrNil(this.ifC.md5)) && (paramArrayOfByte != null))
    {
      paramArrayOfByte = g.getMessageDigest(paramArrayOfByte);
      if (!bu.lX(paramArrayOfByte, this.ifC.md5))
      {
        bool = false;
        ae.i("MicroMsg.UrlImageCacheService", "orgmd5:%s newmd5:%s checkReuslt:%s", new Object[] { this.ifC.md5, paramArrayOfByte, Boolean.valueOf(bool) });
      }
    }
    for (;;)
    {
      if (bool)
      {
        paramArrayOfByte = Gc(this.ifC.url);
        new AsyncTask()new b
        {
          private static Integer a(r.b... paramAnonymousVarArgs)
          {
            AppMethodBeat.i(150762);
            if ((paramAnonymousVarArgs.length == 0) || (bu.isNullOrNil(paramAnonymousVarArgs[0].path)) || (paramAnonymousVarArgs[0].bitmap == null))
            {
              ae.e("MicroMsg.UrlImageCacheService", "nothing to save");
              AppMethodBeat.o(150762);
              return null;
            }
            try
            {
              h.a(paramAnonymousVarArgs[0].bitmap, 100, Bitmap.CompressFormat.PNG, paramAnonymousVarArgs[0].path, false);
              AppMethodBeat.o(150762);
              return null;
            }
            catch (IOException paramAnonymousVarArgs)
            {
              for (;;)
              {
                ae.e("MicroMsg.UrlImageCacheService", "save bitmap to image failed: " + paramAnonymousVarArgs.toString());
              }
            }
          }
        }.execute(new b[] { new b(paramArrayOfByte, paramBitmap) });
        if (!this.ifD)
        {
          q.aIW();
          d.g(this.ifC.url, paramBitmap);
          this.ifC.ifF.a(this.ifC.url, paramBitmap, paramArrayOfByte);
        }
      }
      for (;;)
      {
        this.ifC = null;
        aJd();
        AppMethodBeat.o(150770);
        return;
        if (!this.ifD) {
          this.ifC.ifF.a(this.ifC.url, null, "");
        }
      }
      bool = true;
      break;
      bool = true;
    }
  }
  
  public final void a(String paramString, a parama)
  {
    AppMethodBeat.i(150765);
    a(paramString, "", parama);
    AppMethodBeat.o(150765);
  }
  
  public final void a(String paramString1, String paramString2, a parama)
  {
    AppMethodBeat.i(150766);
    if ((bu.isNullOrNil(paramString1)) || (parama == null))
    {
      ae.e("MicroMsg.UrlImageCacheService", "url is null or nil, or callback is null");
      AppMethodBeat.o(150766);
      return;
    }
    if ((this.ifC != null) && (this.ifC.url.equals(paramString1)) && (this.ifC.ifF == parama))
    {
      ae.e("MicroMsg.UrlImageCacheService", "url and callback is loading");
      AppMethodBeat.o(150766);
      return;
    }
    Iterator localIterator = this.ifB.iterator();
    while (localIterator.hasNext())
    {
      c localc = (c)localIterator.next();
      if ((localc.url.equals(paramString1)) && (localc.ifF == parama))
      {
        ae.e("MicroMsg.UrlImageCacheService", "url and callback is loading");
        AppMethodBeat.o(150766);
        return;
      }
    }
    this.ifB.add(new c(paramString1, paramString2, parama));
    aJd();
    AppMethodBeat.o(150766);
  }
  
  final void aJd()
  {
    AppMethodBeat.i(150768);
    for (;;)
    {
      if ((this.ifC != null) || (this.ifB.size() == 0))
      {
        ae.d("MicroMsg.UrlImageCacheService", "task is downing or no more task");
        AppMethodBeat.o(150768);
        return;
      }
      this.ifC = ((c)this.ifB.get(0));
      this.ifB.remove(0);
      this.ifD = false;
      q.aIW();
      Bitmap localBitmap = d.wA(this.ifC.url);
      if (localBitmap == null) {
        break;
      }
      ae.d("MicroMsg.UrlImageCacheService", "find bitmap in cache of " + this.ifC.url);
      if (!this.ifD) {
        this.ifC.ifF.a(this.ifC.url, localBitmap, Gc(this.ifC.url));
      }
      this.ifC = null;
    }
    new AsyncTask() {}.execute(new String[] { this.ifC.url });
    AppMethodBeat.o(150768);
  }
  
  public final void b(String paramString, a parama)
  {
    AppMethodBeat.i(150767);
    if ((bu.isNullOrNil(paramString)) || (parama == null))
    {
      ae.e("MicroMsg.UrlImageCacheService", "url is null or nil, or callback is null");
      AppMethodBeat.o(150767);
      return;
    }
    if ((this.ifC != null) && (this.ifC.url.equals(paramString)) && (this.ifC.ifF == parama))
    {
      this.ifD = true;
      ae.i("MicroMsg.UrlImageCacheService", "cancel task that is loading, url:%s", new Object[] { paramString });
      AppMethodBeat.o(150767);
      return;
    }
    Iterator localIterator = this.ifB.iterator();
    while (localIterator.hasNext())
    {
      c localc = (c)localIterator.next();
      if ((localc.url.equals(paramString)) && (localc.ifF == parama))
      {
        ae.i("MicroMsg.UrlImageCacheService", "cancel task, url:%s", new Object[] { paramString });
        this.ifB.remove(localc);
        AppMethodBeat.o(150767);
        return;
      }
    }
    AppMethodBeat.o(150767);
  }
  
  public static abstract interface a
  {
    public abstract void a(String paramString1, Bitmap paramBitmap, String paramString2);
  }
  
  static final class b
  {
    public Bitmap bitmap;
    public String path;
    
    public b(String paramString, Bitmap paramBitmap)
    {
      this.path = paramString;
      this.bitmap = paramBitmap;
    }
  }
  
  static final class c
  {
    public r.a ifF;
    public String md5;
    public String url;
    
    public c(String paramString1, String paramString2, r.a parama)
    {
      this.url = paramString1;
      this.md5 = paramString2;
      this.ifF = parama;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.av.r
 * JD-Core Version:    0.7.0.1
 */