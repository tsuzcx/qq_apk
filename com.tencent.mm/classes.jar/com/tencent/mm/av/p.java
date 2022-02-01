package com.tencent.mm.av;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.os.AsyncTask;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.g;
import com.tencent.mm.loader.j.b;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.sdk.platformtools.f;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class p
  implements c.c
{
  List<c> hJR;
  c hJS;
  boolean hJT;
  
  public p()
  {
    AppMethodBeat.i(150764);
    this.hJR = new LinkedList();
    this.hJS = null;
    this.hJT = false;
    AppMethodBeat.o(150764);
  }
  
  static String Cw(String paramString)
  {
    AppMethodBeat.i(150769);
    try
    {
      String str = URLEncoder.encode(paramString, "UTF-8");
      if (bs.isNullOrNil(str))
      {
        ac.e("MicroMsg.UrlImageCacheService", "encode result is null: ".concat(String.valueOf(paramString)));
        AppMethodBeat.o(150769);
        return null;
      }
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      ac.e("MicroMsg.UrlImageCacheService", "try encode unsupport character: ".concat(String.valueOf(paramString)));
      AppMethodBeat.o(150769);
      return null;
    }
    paramString = new StringBuilder();
    paramString.append(b.app());
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
      ac.e("MicroMsg.UrlImageCacheService", "load from url failed: " + this.hJS.url);
      this.hJS = null;
      aFD();
      AppMethodBeat.o(150770);
      return;
    }
    ac.i("MicroMsg.UrlImageCacheService", "load from %s successed", new Object[] { this.hJS.url });
    boolean bool;
    if ((!bs.isNullOrNil(this.hJS.md5)) && (paramArrayOfByte != null))
    {
      paramArrayOfByte = g.getMessageDigest(paramArrayOfByte);
      if (!bs.lr(paramArrayOfByte, this.hJS.md5))
      {
        bool = false;
        ac.i("MicroMsg.UrlImageCacheService", "orgmd5:%s newmd5:%s checkReuslt:%s", new Object[] { this.hJS.md5, paramArrayOfByte, Boolean.valueOf(bool) });
      }
    }
    for (;;)
    {
      if (bool)
      {
        paramArrayOfByte = Cw(this.hJS.url);
        new AsyncTask()new b
        {
          private static Integer a(p.b... paramAnonymousVarArgs)
          {
            AppMethodBeat.i(150762);
            if ((paramAnonymousVarArgs.length == 0) || (bs.isNullOrNil(paramAnonymousVarArgs[0].path)) || (paramAnonymousVarArgs[0].bitmap == null))
            {
              ac.e("MicroMsg.UrlImageCacheService", "nothing to save");
              AppMethodBeat.o(150762);
              return null;
            }
            try
            {
              f.a(paramAnonymousVarArgs[0].bitmap, 100, Bitmap.CompressFormat.PNG, paramAnonymousVarArgs[0].path, false);
              AppMethodBeat.o(150762);
              return null;
            }
            catch (IOException paramAnonymousVarArgs)
            {
              for (;;)
              {
                ac.e("MicroMsg.UrlImageCacheService", "save bitmap to image failed: " + paramAnonymousVarArgs.toString());
              }
            }
          }
        }.execute(new b[] { new b(paramArrayOfByte, paramBitmap) });
        if (!this.hJT)
        {
          o.aFw();
          c.g(this.hJS.url, paramBitmap);
          this.hJS.hJV.a(this.hJS.url, paramBitmap, paramArrayOfByte);
        }
      }
      for (;;)
      {
        this.hJS = null;
        aFD();
        AppMethodBeat.o(150770);
        return;
        if (!this.hJT) {
          this.hJS.hJV.a(this.hJS.url, null, "");
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
    if ((bs.isNullOrNil(paramString1)) || (parama == null))
    {
      ac.e("MicroMsg.UrlImageCacheService", "url is null or nil, or callback is null");
      AppMethodBeat.o(150766);
      return;
    }
    if ((this.hJS != null) && (this.hJS.url.equals(paramString1)) && (this.hJS.hJV == parama))
    {
      ac.e("MicroMsg.UrlImageCacheService", "url and callback is loading");
      AppMethodBeat.o(150766);
      return;
    }
    Iterator localIterator = this.hJR.iterator();
    while (localIterator.hasNext())
    {
      c localc = (c)localIterator.next();
      if ((localc.url.equals(paramString1)) && (localc.hJV == parama))
      {
        ac.e("MicroMsg.UrlImageCacheService", "url and callback is loading");
        AppMethodBeat.o(150766);
        return;
      }
    }
    this.hJR.add(new c(paramString1, paramString2, parama));
    aFD();
    AppMethodBeat.o(150766);
  }
  
  final void aFD()
  {
    AppMethodBeat.i(150768);
    for (;;)
    {
      if ((this.hJS != null) || (this.hJR.size() == 0))
      {
        ac.d("MicroMsg.UrlImageCacheService", "task is downing or no more task");
        AppMethodBeat.o(150768);
        return;
      }
      this.hJS = ((c)this.hJR.get(0));
      this.hJR.remove(0);
      this.hJT = false;
      o.aFw();
      Bitmap localBitmap = c.te(this.hJS.url);
      if (localBitmap == null) {
        break;
      }
      ac.d("MicroMsg.UrlImageCacheService", "find bitmap in cache of " + this.hJS.url);
      if (!this.hJT) {
        this.hJS.hJV.a(this.hJS.url, localBitmap, Cw(this.hJS.url));
      }
      this.hJS = null;
    }
    new AsyncTask() {}.execute(new String[] { this.hJS.url });
    AppMethodBeat.o(150768);
  }
  
  public final void b(String paramString, a parama)
  {
    AppMethodBeat.i(150767);
    if ((bs.isNullOrNil(paramString)) || (parama == null))
    {
      ac.e("MicroMsg.UrlImageCacheService", "url is null or nil, or callback is null");
      AppMethodBeat.o(150767);
      return;
    }
    if ((this.hJS != null) && (this.hJS.url.equals(paramString)) && (this.hJS.hJV == parama))
    {
      this.hJT = true;
      ac.i("MicroMsg.UrlImageCacheService", "cancel task that is loading, url:%s", new Object[] { paramString });
      AppMethodBeat.o(150767);
      return;
    }
    Iterator localIterator = this.hJR.iterator();
    while (localIterator.hasNext())
    {
      c localc = (c)localIterator.next();
      if ((localc.url.equals(paramString)) && (localc.hJV == parama))
      {
        ac.i("MicroMsg.UrlImageCacheService", "cancel task, url:%s", new Object[] { paramString });
        this.hJR.remove(localc);
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
    public p.a hJV;
    public String md5;
    public String url;
    
    public c(String paramString1, String paramString2, p.a parama)
    {
      this.url = paramString1;
      this.md5 = paramString2;
      this.hJV = parama;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.av.p
 * JD-Core Version:    0.7.0.1
 */