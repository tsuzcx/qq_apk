package com.tencent.mm.aw;

import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cache.g.a;
import com.tencent.mm.sdk.g.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.g;
import java.util.HashMap;

public final class d
{
  private HashMap<String, c> hZj;
  
  public d()
  {
    AppMethodBeat.i(150525);
    this.hZj = new HashMap();
    AppMethodBeat.o(150525);
  }
  
  public static void g(String paramString, Bitmap paramBitmap)
  {
    AppMethodBeat.i(150527);
    if ((paramString == null) || (paramString.length() == 0))
    {
      ad.e("MicroMsg.CdnImageService", "push fail, key is null");
      AppMethodBeat.o(150527);
      return;
    }
    g.a.a("local_cdn_img_cache", paramString, paramBitmap);
    AppMethodBeat.o(150527);
  }
  
  public static Bitmap vT(String paramString)
  {
    AppMethodBeat.i(150528);
    if ((paramString == null) || (paramString.length() == 0))
    {
      ad.e("MicroMsg.CdnImageService", "get fail, key is null");
      AppMethodBeat.o(150528);
      return null;
    }
    paramString = (Bitmap)g.a.U("local_cdn_img_cache", paramString);
    AppMethodBeat.o(150528);
    return paramString;
  }
  
  public final void Fb(String paramString)
  {
    AppMethodBeat.i(150529);
    if (bt.isNullOrNil(paramString))
    {
      ad.w("MicroMsg.CdnImageService", "stop load fail, url is empty");
      AppMethodBeat.o(150529);
      return;
    }
    this.hZj.remove(paramString);
    AppMethodBeat.o(150529);
  }
  
  public final void a(String paramString, c paramc)
  {
    AppMethodBeat.i(150530);
    if (bt.isNullOrNil(paramString))
    {
      ad.w("MicroMsg.CdnImageService", "do load fail, url is empty");
      AppMethodBeat.o(150530);
      return;
    }
    Bitmap localBitmap = vT(paramString);
    if ((localBitmap != null) && (!localBitmap.isRecycled()))
    {
      ad.i("MicroMsg.CdnImageService", "do load ok, url[%s], bitmap exists", new Object[] { paramString });
      if (paramc != null) {
        paramc.a(localBitmap, null);
      }
      AppMethodBeat.o(150530);
      return;
    }
    if (localBitmap == null) {}
    for (boolean bool = true;; bool = false)
    {
      ad.w("MicroMsg.CdnImageService", "try to download: url[%s], src bitmap is null[%B]", new Object[] { paramString, Boolean.valueOf(bool) });
      if (!this.hZj.containsKey(paramString)) {
        break;
      }
      ad.w("MicroMsg.CdnImageService", "contains url[%s]", new Object[] { paramString });
      AppMethodBeat.o(150530);
      return;
    }
    this.hZj.put(paramString, paramc);
    b.c(new b(paramString, this.hZj), "CdnImageService_download");
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
    private HashMap<String, d.c> hZj;
    private Bitmap hZk;
    private String url;
    
    public a(String paramString, Bitmap paramBitmap, HashMap<String, d.c> paramHashMap, byte[] paramArrayOfByte)
    {
      this.url = paramString;
      this.hZk = paramBitmap;
      this.hZj = paramHashMap;
      this.data = paramArrayOfByte;
    }
    
    public final void run()
    {
      AppMethodBeat.i(150523);
      q.aIE();
      d.g(this.url, this.hZk);
      if (this.hZj != null)
      {
        localObject = (d.c)this.hZj.remove(this.url);
        if (localObject != null) {
          ((d.c)localObject).a(this.hZk, this.data);
        }
      }
      if (this.url == null) {}
      for (Object localObject = "null";; localObject = this.url)
      {
        ad.i("MicroMsg.CdnImageService", "finish download post job, url[%s]", new Object[] { localObject });
        AppMethodBeat.o(150523);
        return;
      }
    }
  }
  
  static final class b
    implements Runnable
  {
    private HashMap<String, d.c> hZj;
    private String url;
    
    b(String paramString, HashMap<String, d.c> paramHashMap)
    {
      this.url = paramString;
      this.hZj = paramHashMap;
    }
    
    public final void run()
    {
      AppMethodBeat.i(150524);
      byte[] arrayOfByte = bt.aRi(this.url);
      if (arrayOfByte == null)
      {
        ad.w("MicroMsg.CdnImageService", "download fail: url[%s] data is null", new Object[] { this.url });
        AppMethodBeat.o(150524);
        return;
      }
      try
      {
        Bitmap localBitmap = g.cr(arrayOfByte);
        ad.i("MicroMsg.CdnImageService", "download finish, url[%s], do post job", new Object[] { this.url });
        aq.f(new d.a(this.url, localBitmap, this.hZj, arrayOfByte));
        AppMethodBeat.o(150524);
        return;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          ad.w("MicroMsg.CdnImageService", "download fail: url[%s] decode bitmap error[%s]", new Object[] { this.url, localException.getLocalizedMessage() });
          Object localObject = null;
        }
      }
    }
  }
  
  public static abstract interface c
  {
    public abstract void a(Bitmap paramBitmap, byte[] paramArrayOfByte);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.aw.d
 * JD-Core Version:    0.7.0.1
 */