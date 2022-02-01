package com.tencent.mm.modelimage;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.os.AsyncTask;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.g;
import com.tencent.mm.loader.i.b;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.threadpool.h;
import com.tencent.threadpool.i;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class s
  implements e.c
{
  private List<c> oJB;
  c oJC;
  boolean oJD;
  
  public s()
  {
    AppMethodBeat.i(150764);
    this.oJB = new LinkedList();
    this.oJC = null;
    this.oJD = false;
    AppMethodBeat.o(150764);
  }
  
  static String Ol(String paramString)
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
    paramString.append(b.bmI());
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
      Log.e("MicroMsg.UrlImageCacheService", "load from url failed: " + this.oJC.url);
      if (!this.oJD) {
        this.oJC.oJH.onLoadImageEnd(this.oJC.url, paramBitmap, null);
      }
      this.oJC = null;
      bKh();
      AppMethodBeat.o(150770);
      return;
    }
    Log.i("MicroMsg.UrlImageCacheService", "load from %s successed", new Object[] { this.oJC.url });
    boolean bool;
    if ((!Util.isNullOrNil(this.oJC.md5)) && (paramArrayOfByte != null))
    {
      paramArrayOfByte = g.getMessageDigest(paramArrayOfByte);
      if (!Util.isEqual(paramArrayOfByte, this.oJC.md5))
      {
        bool = false;
        Log.i("MicroMsg.UrlImageCacheService", "orgmd5:%s newmd5:%s checkReuslt:%s", new Object[] { this.oJC.md5, paramArrayOfByte, Boolean.valueOf(bool) });
      }
    }
    for (;;)
    {
      if (bool)
      {
        paramArrayOfByte = Ol(this.oJC.url);
        new AsyncTask()new b
        {
          private static Integer a(s.b... paramAnonymousVarArgs)
          {
            AppMethodBeat.i(238948);
            if ((paramAnonymousVarArgs.length == 0) || (Util.isNullOrNil(paramAnonymousVarArgs[0].path)) || (paramAnonymousVarArgs[0].bitmap == null))
            {
              Log.e("MicroMsg.UrlImageCacheService", "nothing to save");
              AppMethodBeat.o(238948);
              return null;
            }
            try
            {
              BitmapUtil.saveBitmapToImage(paramAnonymousVarArgs[0].bitmap, 100, Bitmap.CompressFormat.PNG, paramAnonymousVarArgs[0].path, false);
              AppMethodBeat.o(238948);
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
        if (!this.oJD)
        {
          r.bJZ();
          e.g(this.oJC.url, paramBitmap);
          this.oJC.oJH.onLoadImageEnd(this.oJC.url, paramBitmap, paramArrayOfByte);
        }
      }
      for (;;)
      {
        this.oJC = null;
        bKh();
        AppMethodBeat.o(150770);
        return;
        if (!this.oJD) {
          this.oJC.oJH.onLoadImageEnd(this.oJC.url, null, "");
        }
      }
      bool = true;
      break;
      bool = true;
    }
  }
  
  public final void a(String paramString, s.a parama)
  {
    AppMethodBeat.i(150765);
    a(paramString, "", parama);
    AppMethodBeat.o(150765);
  }
  
  public final void a(final String paramString1, final String paramString2, final s.a parama)
  {
    AppMethodBeat.i(150766);
    if (MMHandlerThread.isMainThread())
    {
      b(paramString1, paramString2, parama);
      AppMethodBeat.o(150766);
      return;
    }
    h.ahAA.bk(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(238949);
        s.this.b(paramString1, paramString2, parama);
        AppMethodBeat.o(238949);
      }
    });
    AppMethodBeat.o(150766);
  }
  
  public final void b(final String paramString, final s.a parama)
  {
    AppMethodBeat.i(150767);
    if (MMHandlerThread.isMainThread())
    {
      c(paramString, parama);
      AppMethodBeat.o(150767);
      return;
    }
    h.ahAA.bk(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(238947);
        s.this.c(paramString, parama);
        AppMethodBeat.o(238947);
      }
    });
    AppMethodBeat.o(150767);
  }
  
  final void b(String paramString1, String paramString2, s.a parama)
  {
    AppMethodBeat.i(238987);
    if ((Util.isNullOrNil(paramString1)) || (parama == null))
    {
      Log.e("MicroMsg.UrlImageCacheService", "url is null or nil, or callback is null");
      AppMethodBeat.o(238987);
      return;
    }
    if ((this.oJC != null) && (this.oJC.url.equals(paramString1)) && (this.oJC.oJH == parama))
    {
      Log.e("MicroMsg.UrlImageCacheService", "url and callback is loading");
      AppMethodBeat.o(238987);
      return;
    }
    Iterator localIterator = this.oJB.iterator();
    while (localIterator.hasNext())
    {
      c localc = (c)localIterator.next();
      if ((localc.url.equals(paramString1)) && (localc.oJH == parama))
      {
        Log.e("MicroMsg.UrlImageCacheService", "url and callback is loading");
        AppMethodBeat.o(238987);
        return;
      }
    }
    this.oJB.add(new c(paramString1, paramString2, parama));
    bKh();
    AppMethodBeat.o(238987);
  }
  
  final void bKg()
  {
    AppMethodBeat.i(238992);
    this.oJB.clear();
    this.oJD = true;
    AppMethodBeat.o(238992);
  }
  
  final void bKh()
  {
    AppMethodBeat.i(150768);
    for (;;)
    {
      if (!MMHandlerThread.isMainThread()) {
        Log.e("MicroMsg.UrlImageCacheService", "err call tryLoadImage:%s", new Object[] { Util.getStack() });
      }
      if ((this.oJC != null) || (this.oJB.size() == 0))
      {
        Log.d("MicroMsg.UrlImageCacheService", "task is downing or no more task");
        AppMethodBeat.o(150768);
        return;
      }
      this.oJC = ((c)this.oJB.get(0));
      this.oJB.remove(0);
      this.oJD = false;
      r.bJZ();
      Bitmap localBitmap = e.Eo(this.oJC.url);
      if (localBitmap == null) {
        break;
      }
      Log.d("MicroMsg.UrlImageCacheService", "find bitmap in cache of " + this.oJC.url);
      if (!this.oJD) {
        this.oJC.oJH.onLoadImageEnd(this.oJC.url, localBitmap, Ol(this.oJC.url));
      }
      this.oJC = null;
    }
    new AsyncTask() {}.execute(new String[] { this.oJC.url });
    AppMethodBeat.o(150768);
  }
  
  final void c(String paramString, s.a parama)
  {
    AppMethodBeat.i(238990);
    if ((Util.isNullOrNil(paramString)) || (parama == null))
    {
      Log.e("MicroMsg.UrlImageCacheService", "url is null or nil, or callback is null");
      AppMethodBeat.o(238990);
      return;
    }
    if ((this.oJC != null) && (this.oJC.url.equals(paramString)) && (this.oJC.oJH == parama))
    {
      this.oJD = true;
      Log.i("MicroMsg.UrlImageCacheService", "cancel task that is loading, url:%s", new Object[] { paramString });
      AppMethodBeat.o(238990);
      return;
    }
    Iterator localIterator = this.oJB.iterator();
    while (localIterator.hasNext())
    {
      c localc = (c)localIterator.next();
      if ((localc.url.equals(paramString)) && (localc.oJH == parama))
      {
        Log.i("MicroMsg.UrlImageCacheService", "cancel task, url:%s", new Object[] { paramString });
        this.oJB.remove(localc);
        AppMethodBeat.o(238990);
        return;
      }
    }
    AppMethodBeat.o(238990);
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
    public String md5;
    public s.a oJH;
    public String url;
    
    public c(String paramString1, String paramString2, s.a parama)
    {
      this.url = paramString1;
      this.md5 = paramString2;
      this.oJH = parama;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.modelimage.s
 * JD-Core Version:    0.7.0.1
 */