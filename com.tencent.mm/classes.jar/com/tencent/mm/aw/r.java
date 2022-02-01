package com.tencent.mm.aw;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.os.AsyncTask;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.j.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class r
  implements d.c
{
  List<c> icI;
  c icJ;
  boolean icK;
  
  public r()
  {
    AppMethodBeat.i(150764);
    this.icI = new LinkedList();
    this.icJ = null;
    this.icK = false;
    AppMethodBeat.o(150764);
  }
  
  static String FA(String paramString)
  {
    AppMethodBeat.i(150769);
    try
    {
      String str = URLEncoder.encode(paramString, "UTF-8");
      if (bt.isNullOrNil(str))
      {
        ad.e("MicroMsg.UrlImageCacheService", "encode result is null: ".concat(String.valueOf(paramString)));
        AppMethodBeat.o(150769);
        return null;
      }
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      ad.e("MicroMsg.UrlImageCacheService", "try encode unsupport character: ".concat(String.valueOf(paramString)));
      AppMethodBeat.o(150769);
      return null;
    }
    paramString = new StringBuilder();
    paramString.append(b.asd());
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
      ad.e("MicroMsg.UrlImageCacheService", "load from url failed: " + this.icJ.url);
      this.icJ = null;
      aIL();
      AppMethodBeat.o(150770);
      return;
    }
    ad.i("MicroMsg.UrlImageCacheService", "load from %s successed", new Object[] { this.icJ.url });
    boolean bool;
    if ((!bt.isNullOrNil(this.icJ.md5)) && (paramArrayOfByte != null))
    {
      paramArrayOfByte = com.tencent.mm.b.g.getMessageDigest(paramArrayOfByte);
      if (!bt.lQ(paramArrayOfByte, this.icJ.md5))
      {
        bool = false;
        ad.i("MicroMsg.UrlImageCacheService", "orgmd5:%s newmd5:%s checkReuslt:%s", new Object[] { this.icJ.md5, paramArrayOfByte, Boolean.valueOf(bool) });
      }
    }
    for (;;)
    {
      if (bool)
      {
        paramArrayOfByte = FA(this.icJ.url);
        new AsyncTask()new b
        {
          private static Integer a(r.b... paramAnonymousVarArgs)
          {
            AppMethodBeat.i(150762);
            if ((paramAnonymousVarArgs.length == 0) || (bt.isNullOrNil(paramAnonymousVarArgs[0].path)) || (paramAnonymousVarArgs[0].bitmap == null))
            {
              ad.e("MicroMsg.UrlImageCacheService", "nothing to save");
              AppMethodBeat.o(150762);
              return null;
            }
            try
            {
              com.tencent.mm.sdk.platformtools.g.a(paramAnonymousVarArgs[0].bitmap, 100, Bitmap.CompressFormat.PNG, paramAnonymousVarArgs[0].path, false);
              AppMethodBeat.o(150762);
              return null;
            }
            catch (IOException paramAnonymousVarArgs)
            {
              for (;;)
              {
                ad.e("MicroMsg.UrlImageCacheService", "save bitmap to image failed: " + paramAnonymousVarArgs.toString());
              }
            }
          }
        }.execute(new b[] { new b(paramArrayOfByte, paramBitmap) });
        if (!this.icK)
        {
          q.aIE();
          d.g(this.icJ.url, paramBitmap);
          this.icJ.icM.a(this.icJ.url, paramBitmap, paramArrayOfByte);
        }
      }
      for (;;)
      {
        this.icJ = null;
        aIL();
        AppMethodBeat.o(150770);
        return;
        if (!this.icK) {
          this.icJ.icM.a(this.icJ.url, null, "");
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
    if ((bt.isNullOrNil(paramString1)) || (parama == null))
    {
      ad.e("MicroMsg.UrlImageCacheService", "url is null or nil, or callback is null");
      AppMethodBeat.o(150766);
      return;
    }
    if ((this.icJ != null) && (this.icJ.url.equals(paramString1)) && (this.icJ.icM == parama))
    {
      ad.e("MicroMsg.UrlImageCacheService", "url and callback is loading");
      AppMethodBeat.o(150766);
      return;
    }
    Iterator localIterator = this.icI.iterator();
    while (localIterator.hasNext())
    {
      c localc = (c)localIterator.next();
      if ((localc.url.equals(paramString1)) && (localc.icM == parama))
      {
        ad.e("MicroMsg.UrlImageCacheService", "url and callback is loading");
        AppMethodBeat.o(150766);
        return;
      }
    }
    this.icI.add(new c(paramString1, paramString2, parama));
    aIL();
    AppMethodBeat.o(150766);
  }
  
  final void aIL()
  {
    AppMethodBeat.i(150768);
    for (;;)
    {
      if ((this.icJ != null) || (this.icI.size() == 0))
      {
        ad.d("MicroMsg.UrlImageCacheService", "task is downing or no more task");
        AppMethodBeat.o(150768);
        return;
      }
      this.icJ = ((c)this.icI.get(0));
      this.icI.remove(0);
      this.icK = false;
      q.aIE();
      Bitmap localBitmap = d.vT(this.icJ.url);
      if (localBitmap == null) {
        break;
      }
      ad.d("MicroMsg.UrlImageCacheService", "find bitmap in cache of " + this.icJ.url);
      if (!this.icK) {
        this.icJ.icM.a(this.icJ.url, localBitmap, FA(this.icJ.url));
      }
      this.icJ = null;
    }
    new AsyncTask() {}.execute(new String[] { this.icJ.url });
    AppMethodBeat.o(150768);
  }
  
  public final void b(String paramString, a parama)
  {
    AppMethodBeat.i(150767);
    if ((bt.isNullOrNil(paramString)) || (parama == null))
    {
      ad.e("MicroMsg.UrlImageCacheService", "url is null or nil, or callback is null");
      AppMethodBeat.o(150767);
      return;
    }
    if ((this.icJ != null) && (this.icJ.url.equals(paramString)) && (this.icJ.icM == parama))
    {
      this.icK = true;
      ad.i("MicroMsg.UrlImageCacheService", "cancel task that is loading, url:%s", new Object[] { paramString });
      AppMethodBeat.o(150767);
      return;
    }
    Iterator localIterator = this.icI.iterator();
    while (localIterator.hasNext())
    {
      c localc = (c)localIterator.next();
      if ((localc.url.equals(paramString)) && (localc.icM == parama))
      {
        ad.i("MicroMsg.UrlImageCacheService", "cancel task, url:%s", new Object[] { paramString });
        this.icI.remove(localc);
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
    public r.a icM;
    public String md5;
    public String url;
    
    public c(String paramString1, String paramString2, r.a parama)
    {
      this.url = paramString1;
      this.md5 = paramString2;
      this.icM = parama;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.aw.r
 * JD-Core Version:    0.7.0.1
 */