package com.tencent.mm.ay;

import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cache.g.a;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.thread.ThreadPool;
import java.util.HashMap;

public final class d
{
  private HashMap<String, c> lNu;
  
  public d()
  {
    AppMethodBeat.i(150525);
    this.lNu = new HashMap();
    AppMethodBeat.o(150525);
  }
  
  public static Bitmap LI(String paramString)
  {
    AppMethodBeat.i(150528);
    if ((paramString == null) || (paramString.length() == 0))
    {
      Log.e("MicroMsg.CdnImageService", "get fail, key is null");
      AppMethodBeat.o(150528);
      return null;
    }
    paramString = (Bitmap)g.a.ab("local_cdn_img_cache", paramString);
    AppMethodBeat.o(150528);
    return paramString;
  }
  
  public static void g(String paramString, Bitmap paramBitmap)
  {
    AppMethodBeat.i(150527);
    if ((paramString == null) || (paramString.length() == 0))
    {
      Log.e("MicroMsg.CdnImageService", "push fail, key is null");
      AppMethodBeat.o(150527);
      return;
    }
    g.a.a("local_cdn_img_cache", paramString, paramBitmap);
    AppMethodBeat.o(150527);
  }
  
  public final void VL(String paramString)
  {
    AppMethodBeat.i(150529);
    if (Util.isNullOrNil(paramString))
    {
      Log.w("MicroMsg.CdnImageService", "stop load fail, url is empty");
      AppMethodBeat.o(150529);
      return;
    }
    this.lNu.remove(paramString);
    AppMethodBeat.o(150529);
  }
  
  public final void a(String paramString, c paramc)
  {
    AppMethodBeat.i(150530);
    if (Util.isNullOrNil(paramString))
    {
      Log.w("MicroMsg.CdnImageService", "do load fail, url is empty");
      AppMethodBeat.o(150530);
      return;
    }
    Bitmap localBitmap = LI(paramString);
    if ((localBitmap != null) && (!localBitmap.isRecycled()))
    {
      Log.i("MicroMsg.CdnImageService", "do load ok, url[%s], bitmap exists", new Object[] { paramString });
      if (paramc != null) {
        paramc.a(localBitmap, null);
      }
      AppMethodBeat.o(150530);
      return;
    }
    if (localBitmap == null) {}
    for (boolean bool = true;; bool = false)
    {
      Log.w("MicroMsg.CdnImageService", "try to download: url[%s], src bitmap is null[%B]", new Object[] { paramString, Boolean.valueOf(bool) });
      if (!this.lNu.containsKey(paramString)) {
        break;
      }
      Log.w("MicroMsg.CdnImageService", "contains url[%s]", new Object[] { paramString });
      AppMethodBeat.o(150530);
      return;
    }
    this.lNu.put(paramString, paramc);
    ThreadPool.post(new b(paramString, this.lNu), "CdnImageService_download");
    AppMethodBeat.o(150530);
  }
  
  protected final void finalize()
  {
    AppMethodBeat.i(150526);
    super.finalize();
    AppMethodBeat.o(150526);
  }
  
  static final class a
    implements Runnable
  {
    private byte[] data;
    private HashMap<String, d.c> lNu;
    private Bitmap lNv;
    private String url;
    
    public a(String paramString, Bitmap paramBitmap, HashMap<String, d.c> paramHashMap, byte[] paramArrayOfByte)
    {
      this.url = paramString;
      this.lNv = paramBitmap;
      this.lNu = paramHashMap;
      this.data = paramArrayOfByte;
    }
    
    public final void run()
    {
      AppMethodBeat.i(150523);
      q.bmg();
      d.g(this.url, this.lNv);
      if (this.lNu != null)
      {
        localObject = (d.c)this.lNu.remove(this.url);
        if (localObject != null) {
          ((d.c)localObject).a(this.lNv, this.data);
        }
      }
      if (this.url == null) {}
      for (Object localObject = "null";; localObject = this.url)
      {
        Log.i("MicroMsg.CdnImageService", "finish download post job, url[%s]", new Object[] { localObject });
        AppMethodBeat.o(150523);
        return;
      }
    }
  }
  
  static final class b
    implements Runnable
  {
    private HashMap<String, d.c> lNu;
    private String url;
    
    b(String paramString, HashMap<String, d.c> paramHashMap)
    {
      this.url = paramString;
      this.lNu = paramHashMap;
    }
    
    public final void run()
    {
      Object localObject = null;
      AppMethodBeat.i(150524);
      byte[] arrayOfByte = Util.httpGet(this.url);
      if (arrayOfByte == null)
      {
        Log.w("MicroMsg.CdnImageService", "download fail: url[%s] data is null", new Object[] { this.url });
        MMHandlerThread.postToMainThread(new d.a(this.url, null, this.lNu, arrayOfByte));
        AppMethodBeat.o(150524);
        return;
      }
      try
      {
        Bitmap localBitmap = BitmapUtil.decodeByteArray(arrayOfByte);
        localObject = localBitmap;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          Log.w("MicroMsg.CdnImageService", "download fail: url[%s] decode bitmap error[%s]", new Object[] { this.url, localException.getLocalizedMessage() });
        }
      }
      Log.i("MicroMsg.CdnImageService", "download finish, url[%s], do post job", new Object[] { this.url });
      MMHandlerThread.postToMainThread(new d.a(this.url, localObject, this.lNu, arrayOfByte));
      AppMethodBeat.o(150524);
    }
  }
  
  public static abstract interface c
  {
    public abstract void a(Bitmap paramBitmap, byte[] paramArrayOfByte);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ay.d
 * JD-Core Version:    0.7.0.1
 */