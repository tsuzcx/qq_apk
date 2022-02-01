package com.tencent.mm.av;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.os.AsyncTask;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.g;
import com.tencent.mm.loader.j.b;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class r
  implements d.c
{
  List<c> jaw;
  c jax;
  boolean jay;
  
  public r()
  {
    AppMethodBeat.i(150764);
    this.jaw = new LinkedList();
    this.jax = null;
    this.jay = false;
    AppMethodBeat.o(150764);
  }
  
  static String ON(String paramString)
  {
    AppMethodBeat.i(150769);
    try
    {
      String str = URLEncoder.encode(paramString, "UTF-8");
      if (Util.isNullOrNil(str))
      {
        Log.e("MicroMsg.UrlImageCacheService", "encode result is null: ".concat(String.valueOf(paramString)));
        AppMethodBeat.o(150769);
        return null;
      }
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      Log.e("MicroMsg.UrlImageCacheService", "try encode unsupport character: ".concat(String.valueOf(paramString)));
      AppMethodBeat.o(150769);
      return null;
    }
    paramString = new StringBuilder();
    paramString.append(b.aKS());
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
      Log.e("MicroMsg.UrlImageCacheService", "load from url failed: " + this.jax.url);
      this.jax = null;
      bcX();
      AppMethodBeat.o(150770);
      return;
    }
    Log.i("MicroMsg.UrlImageCacheService", "load from %s successed", new Object[] { this.jax.url });
    boolean bool;
    if ((!Util.isNullOrNil(this.jax.md5)) && (paramArrayOfByte != null))
    {
      paramArrayOfByte = g.getMessageDigest(paramArrayOfByte);
      if (!Util.isEqual(paramArrayOfByte, this.jax.md5))
      {
        bool = false;
        Log.i("MicroMsg.UrlImageCacheService", "orgmd5:%s newmd5:%s checkReuslt:%s", new Object[] { this.jax.md5, paramArrayOfByte, Boolean.valueOf(bool) });
      }
    }
    for (;;)
    {
      if (bool)
      {
        paramArrayOfByte = ON(this.jax.url);
        new AsyncTask()new b
        {
          private static Integer a(r.b... paramAnonymousVarArgs)
          {
            AppMethodBeat.i(150762);
            if ((paramAnonymousVarArgs.length == 0) || (Util.isNullOrNil(paramAnonymousVarArgs[0].path)) || (paramAnonymousVarArgs[0].bitmap == null))
            {
              Log.e("MicroMsg.UrlImageCacheService", "nothing to save");
              AppMethodBeat.o(150762);
              return null;
            }
            try
            {
              BitmapUtil.saveBitmapToImage(paramAnonymousVarArgs[0].bitmap, 100, Bitmap.CompressFormat.PNG, paramAnonymousVarArgs[0].path, false);
              AppMethodBeat.o(150762);
              return null;
            }
            catch (IOException paramAnonymousVarArgs)
            {
              for (;;)
              {
                Log.e("MicroMsg.UrlImageCacheService", "save bitmap to image failed: " + paramAnonymousVarArgs.toString());
              }
            }
          }
        }.execute(new b[] { new b(paramArrayOfByte, paramBitmap) });
        if (!this.jay)
        {
          q.bcQ();
          d.g(this.jax.url, paramBitmap);
          this.jax.jaA.a(this.jax.url, paramBitmap, paramArrayOfByte);
        }
      }
      for (;;)
      {
        this.jax = null;
        bcX();
        AppMethodBeat.o(150770);
        return;
        if (!this.jay) {
          this.jax.jaA.a(this.jax.url, null, "");
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
    if ((Util.isNullOrNil(paramString1)) || (parama == null))
    {
      Log.e("MicroMsg.UrlImageCacheService", "url is null or nil, or callback is null");
      AppMethodBeat.o(150766);
      return;
    }
    if ((this.jax != null) && (this.jax.url.equals(paramString1)) && (this.jax.jaA == parama))
    {
      Log.e("MicroMsg.UrlImageCacheService", "url and callback is loading");
      AppMethodBeat.o(150766);
      return;
    }
    Iterator localIterator = this.jaw.iterator();
    while (localIterator.hasNext())
    {
      c localc = (c)localIterator.next();
      if ((localc.url.equals(paramString1)) && (localc.jaA == parama))
      {
        Log.e("MicroMsg.UrlImageCacheService", "url and callback is loading");
        AppMethodBeat.o(150766);
        return;
      }
    }
    this.jaw.add(new c(paramString1, paramString2, parama));
    bcX();
    AppMethodBeat.o(150766);
  }
  
  public final void b(String paramString, a parama)
  {
    AppMethodBeat.i(150767);
    if ((Util.isNullOrNil(paramString)) || (parama == null))
    {
      Log.e("MicroMsg.UrlImageCacheService", "url is null or nil, or callback is null");
      AppMethodBeat.o(150767);
      return;
    }
    if ((this.jax != null) && (this.jax.url.equals(paramString)) && (this.jax.jaA == parama))
    {
      this.jay = true;
      Log.i("MicroMsg.UrlImageCacheService", "cancel task that is loading, url:%s", new Object[] { paramString });
      AppMethodBeat.o(150767);
      return;
    }
    Iterator localIterator = this.jaw.iterator();
    while (localIterator.hasNext())
    {
      c localc = (c)localIterator.next();
      if ((localc.url.equals(paramString)) && (localc.jaA == parama))
      {
        Log.i("MicroMsg.UrlImageCacheService", "cancel task, url:%s", new Object[] { paramString });
        this.jaw.remove(localc);
        AppMethodBeat.o(150767);
        return;
      }
    }
    AppMethodBeat.o(150767);
  }
  
  final void bcX()
  {
    AppMethodBeat.i(150768);
    for (;;)
    {
      if ((this.jax != null) || (this.jaw.size() == 0))
      {
        Log.d("MicroMsg.UrlImageCacheService", "task is downing or no more task");
        AppMethodBeat.o(150768);
        return;
      }
      this.jax = ((c)this.jaw.get(0));
      this.jaw.remove(0);
      this.jay = false;
      q.bcQ();
      Bitmap localBitmap = d.EP(this.jax.url);
      if (localBitmap == null) {
        break;
      }
      Log.d("MicroMsg.UrlImageCacheService", "find bitmap in cache of " + this.jax.url);
      if (!this.jay) {
        this.jax.jaA.a(this.jax.url, localBitmap, ON(this.jax.url));
      }
      this.jax = null;
    }
    new AsyncTask() {}.execute(new String[] { this.jax.url });
    AppMethodBeat.o(150768);
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
    public r.a jaA;
    public String md5;
    public String url;
    
    public c(String paramString1, String paramString2, r.a parama)
    {
      this.url = paramString1;
      this.md5 = paramString2;
      this.jaA = parama;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.av.r
 * JD-Core Version:    0.7.0.1
 */