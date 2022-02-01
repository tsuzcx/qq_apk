package com.tencent.mm.ay;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.os.AsyncTask;
import com.tencent.e.h;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.g;
import com.tencent.mm.loader.j.b;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
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
  private List<c> lQR;
  c lQS;
  boolean lQT;
  
  public r()
  {
    AppMethodBeat.i(150764);
    this.lQR = new LinkedList();
    this.lQS = null;
    this.lQT = false;
    AppMethodBeat.o(150764);
  }
  
  static String Wl(String paramString)
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
    paramString.append(b.aSU());
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
      Log.e("MicroMsg.UrlImageCacheService", "load from url failed: " + this.lQS.url);
      if (!this.lQT) {
        this.lQS.lQX.a(this.lQS.url, paramBitmap, null);
      }
      this.lQS = null;
      bmo();
      AppMethodBeat.o(150770);
      return;
    }
    Log.i("MicroMsg.UrlImageCacheService", "load from %s successed", new Object[] { this.lQS.url });
    boolean bool;
    if ((!Util.isNullOrNil(this.lQS.md5)) && (paramArrayOfByte != null))
    {
      paramArrayOfByte = g.getMessageDigest(paramArrayOfByte);
      if (!Util.isEqual(paramArrayOfByte, this.lQS.md5))
      {
        bool = false;
        Log.i("MicroMsg.UrlImageCacheService", "orgmd5:%s newmd5:%s checkReuslt:%s", new Object[] { this.lQS.md5, paramArrayOfByte, Boolean.valueOf(bool) });
      }
    }
    for (;;)
    {
      if (bool)
      {
        paramArrayOfByte = Wl(this.lQS.url);
        new AsyncTask()new b
        {
          private static Integer a(r.b... paramAnonymousVarArgs)
          {
            AppMethodBeat.i(189351);
            if ((paramAnonymousVarArgs.length == 0) || (Util.isNullOrNil(paramAnonymousVarArgs[0].path)) || (paramAnonymousVarArgs[0].bitmap == null))
            {
              Log.e("MicroMsg.UrlImageCacheService", "nothing to save");
              AppMethodBeat.o(189351);
              return null;
            }
            try
            {
              BitmapUtil.saveBitmapToImage(paramAnonymousVarArgs[0].bitmap, 100, Bitmap.CompressFormat.PNG, paramAnonymousVarArgs[0].path, false);
              AppMethodBeat.o(189351);
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
        if (!this.lQT)
        {
          q.bmg();
          d.g(this.lQS.url, paramBitmap);
          this.lQS.lQX.a(this.lQS.url, paramBitmap, paramArrayOfByte);
        }
      }
      for (;;)
      {
        this.lQS = null;
        bmo();
        AppMethodBeat.o(150770);
        return;
        if (!this.lQT) {
          this.lQS.lQX.a(this.lQS.url, null, "");
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
  
  public final void a(final String paramString1, final String paramString2, final a parama)
  {
    AppMethodBeat.i(150766);
    if (MMHandlerThread.isMainThread())
    {
      b(paramString1, paramString2, parama);
      AppMethodBeat.o(150766);
      return;
    }
    h.ZvG.bc(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(213997);
        r.this.b(paramString1, paramString2, parama);
        AppMethodBeat.o(213997);
      }
    });
    AppMethodBeat.o(150766);
  }
  
  public final void b(final String paramString, final a parama)
  {
    AppMethodBeat.i(150767);
    if (MMHandlerThread.isMainThread())
    {
      c(paramString, parama);
      AppMethodBeat.o(150767);
      return;
    }
    h.ZvG.bc(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(194055);
        r.this.c(paramString, parama);
        AppMethodBeat.o(194055);
      }
    });
    AppMethodBeat.o(150767);
  }
  
  final void b(String paramString1, String paramString2, a parama)
  {
    AppMethodBeat.i(194975);
    if ((Util.isNullOrNil(paramString1)) || (parama == null))
    {
      Log.e("MicroMsg.UrlImageCacheService", "url is null or nil, or callback is null");
      AppMethodBeat.o(194975);
      return;
    }
    if ((this.lQS != null) && (this.lQS.url.equals(paramString1)) && (this.lQS.lQX == parama))
    {
      Log.e("MicroMsg.UrlImageCacheService", "url and callback is loading");
      AppMethodBeat.o(194975);
      return;
    }
    Iterator localIterator = this.lQR.iterator();
    while (localIterator.hasNext())
    {
      c localc = (c)localIterator.next();
      if ((localc.url.equals(paramString1)) && (localc.lQX == parama))
      {
        Log.e("MicroMsg.UrlImageCacheService", "url and callback is loading");
        AppMethodBeat.o(194975);
        return;
      }
    }
    this.lQR.add(new c(paramString1, paramString2, parama));
    bmo();
    AppMethodBeat.o(194975);
  }
  
  final void bmn()
  {
    AppMethodBeat.i(194987);
    this.lQR.clear();
    this.lQT = true;
    AppMethodBeat.o(194987);
  }
  
  final void bmo()
  {
    AppMethodBeat.i(150768);
    for (;;)
    {
      if (!MMHandlerThread.isMainThread()) {
        Log.e("MicroMsg.UrlImageCacheService", "err call tryLoadImage:%s", new Object[] { Util.getStack() });
      }
      if ((this.lQS != null) || (this.lQR.size() == 0))
      {
        Log.d("MicroMsg.UrlImageCacheService", "task is downing or no more task");
        AppMethodBeat.o(150768);
        return;
      }
      this.lQS = ((c)this.lQR.get(0));
      this.lQR.remove(0);
      this.lQT = false;
      q.bmg();
      Bitmap localBitmap = d.LI(this.lQS.url);
      if (localBitmap == null) {
        break;
      }
      Log.d("MicroMsg.UrlImageCacheService", "find bitmap in cache of " + this.lQS.url);
      if (!this.lQT) {
        this.lQS.lQX.a(this.lQS.url, localBitmap, Wl(this.lQS.url));
      }
      this.lQS = null;
    }
    new AsyncTask() {}.execute(new String[] { this.lQS.url });
    AppMethodBeat.o(150768);
  }
  
  final void c(String paramString, a parama)
  {
    AppMethodBeat.i(194982);
    if ((Util.isNullOrNil(paramString)) || (parama == null))
    {
      Log.e("MicroMsg.UrlImageCacheService", "url is null or nil, or callback is null");
      AppMethodBeat.o(194982);
      return;
    }
    if ((this.lQS != null) && (this.lQS.url.equals(paramString)) && (this.lQS.lQX == parama))
    {
      this.lQT = true;
      Log.i("MicroMsg.UrlImageCacheService", "cancel task that is loading, url:%s", new Object[] { paramString });
      AppMethodBeat.o(194982);
      return;
    }
    Iterator localIterator = this.lQR.iterator();
    while (localIterator.hasNext())
    {
      c localc = (c)localIterator.next();
      if ((localc.url.equals(paramString)) && (localc.lQX == parama))
      {
        Log.i("MicroMsg.UrlImageCacheService", "cancel task, url:%s", new Object[] { paramString });
        this.lQR.remove(localc);
        AppMethodBeat.o(194982);
        return;
      }
    }
    AppMethodBeat.o(194982);
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
    public r.a lQX;
    public String md5;
    public String url;
    
    public c(String paramString1, String paramString2, r.a parama)
    {
      this.url = paramString1;
      this.md5 = paramString2;
      this.lQX = parama;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ay.r
 * JD-Core Version:    0.7.0.1
 */