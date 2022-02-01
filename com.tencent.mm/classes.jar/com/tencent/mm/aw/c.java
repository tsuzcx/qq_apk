package com.tencent.mm.aw;

import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cache.g.a;
import com.tencent.mm.sdk.g.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.f;
import java.util.HashMap;

public final class c
{
  private HashMap<String, c> hfW;
  
  public c()
  {
    AppMethodBeat.i(150525);
    this.hfW = new HashMap();
    AppMethodBeat.o(150525);
  }
  
  public static void h(String paramString, Bitmap paramBitmap)
  {
    AppMethodBeat.i(150527);
    if ((paramString == null) || (paramString.length() == 0))
    {
      ad.e("MicroMsg.CdnImageService", "push fail, key is null");
      AppMethodBeat.o(150527);
      return;
    }
    g.a.b("local_cdn_img_cache", paramString, paramBitmap);
    AppMethodBeat.o(150527);
  }
  
  public static Bitmap pT(String paramString)
  {
    AppMethodBeat.i(150528);
    if ((paramString == null) || (paramString.length() == 0))
    {
      ad.e("MicroMsg.CdnImageService", "get fail, key is null");
      AppMethodBeat.o(150528);
      return null;
    }
    paramString = (Bitmap)g.a.S("local_cdn_img_cache", paramString);
    AppMethodBeat.o(150528);
    return paramString;
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
    Bitmap localBitmap = pT(paramString);
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
      if (!this.hfW.containsKey(paramString)) {
        break;
      }
      ad.w("MicroMsg.CdnImageService", "contains url[%s]", new Object[] { paramString });
      AppMethodBeat.o(150530);
      return;
    }
    this.hfW.put(paramString, paramc);
    b.c(new b(paramString, this.hfW), "CdnImageService_download");
    AppMethodBeat.o(150530);
  }
  
  protected final void finalize()
  {
    AppMethodBeat.i(150526);
    super.finalize();
    AppMethodBeat.o(150526);
  }
  
  public final void xX(String paramString)
  {
    AppMethodBeat.i(150529);
    if (bt.isNullOrNil(paramString))
    {
      ad.w("MicroMsg.CdnImageService", "stop load fail, url is empty");
      AppMethodBeat.o(150529);
      return;
    }
    this.hfW.remove(paramString);
    AppMethodBeat.o(150529);
  }
  
  static final class a
    implements Runnable
  {
    private byte[] data;
    private HashMap<String, c.c> hfW;
    private Bitmap hfX;
    private String url;
    
    public a(String paramString, Bitmap paramBitmap, HashMap<String, c.c> paramHashMap, byte[] paramArrayOfByte)
    {
      this.url = paramString;
      this.hfX = paramBitmap;
      this.hfW = paramHashMap;
      this.data = paramArrayOfByte;
    }
    
    public final void run()
    {
      AppMethodBeat.i(150523);
      o.ayE();
      c.h(this.url, this.hfX);
      if (this.hfW != null)
      {
        localObject = (c.c)this.hfW.remove(this.url);
        if (localObject != null) {
          ((c.c)localObject).a(this.hfX, this.data);
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
    private HashMap<String, c.c> hfW;
    private String url;
    
    b(String paramString, HashMap<String, c.c> paramHashMap)
    {
      this.url = paramString;
      this.hfW = paramHashMap;
    }
    
    public final void run()
    {
      AppMethodBeat.i(150524);
      byte[] arrayOfByte = bt.aGl(this.url);
      if (arrayOfByte == null)
      {
        ad.w("MicroMsg.CdnImageService", "download fail: url[%s] data is null", new Object[] { this.url });
        AppMethodBeat.o(150524);
        return;
      }
      try
      {
        Bitmap localBitmap = f.cl(arrayOfByte);
        ad.i("MicroMsg.CdnImageService", "download finish, url[%s], do post job", new Object[] { this.url });
        aq.f(new c.a(this.url, localBitmap, this.hfW, arrayOfByte));
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
 * Qualified Name:     com.tencent.mm.aw.c
 * JD-Core Version:    0.7.0.1
 */