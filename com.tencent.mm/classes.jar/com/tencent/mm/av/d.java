package com.tencent.mm.av;

import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cache.g.a;
import com.tencent.mm.sdk.g.b;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.sdk.platformtools.h;
import java.util.HashMap;

public final class d
{
  private HashMap<String, c> icb;
  
  public d()
  {
    AppMethodBeat.i(150525);
    this.icb = new HashMap();
    AppMethodBeat.o(150525);
  }
  
  public static void g(String paramString, Bitmap paramBitmap)
  {
    AppMethodBeat.i(150527);
    if ((paramString == null) || (paramString.length() == 0))
    {
      ae.e("MicroMsg.CdnImageService", "push fail, key is null");
      AppMethodBeat.o(150527);
      return;
    }
    g.a.a("local_cdn_img_cache", paramString, paramBitmap);
    AppMethodBeat.o(150527);
  }
  
  public static Bitmap wA(String paramString)
  {
    AppMethodBeat.i(150528);
    if ((paramString == null) || (paramString.length() == 0))
    {
      ae.e("MicroMsg.CdnImageService", "get fail, key is null");
      AppMethodBeat.o(150528);
      return null;
    }
    paramString = (Bitmap)g.a.U("local_cdn_img_cache", paramString);
    AppMethodBeat.o(150528);
    return paramString;
  }
  
  public final void FD(String paramString)
  {
    AppMethodBeat.i(150529);
    if (bu.isNullOrNil(paramString))
    {
      ae.w("MicroMsg.CdnImageService", "stop load fail, url is empty");
      AppMethodBeat.o(150529);
      return;
    }
    this.icb.remove(paramString);
    AppMethodBeat.o(150529);
  }
  
  public final void a(String paramString, c paramc)
  {
    AppMethodBeat.i(150530);
    if (bu.isNullOrNil(paramString))
    {
      ae.w("MicroMsg.CdnImageService", "do load fail, url is empty");
      AppMethodBeat.o(150530);
      return;
    }
    Bitmap localBitmap = wA(paramString);
    if ((localBitmap != null) && (!localBitmap.isRecycled()))
    {
      ae.i("MicroMsg.CdnImageService", "do load ok, url[%s], bitmap exists", new Object[] { paramString });
      if (paramc != null) {
        paramc.a(localBitmap, null);
      }
      AppMethodBeat.o(150530);
      return;
    }
    if (localBitmap == null) {}
    for (boolean bool = true;; bool = false)
    {
      ae.w("MicroMsg.CdnImageService", "try to download: url[%s], src bitmap is null[%B]", new Object[] { paramString, Boolean.valueOf(bool) });
      if (!this.icb.containsKey(paramString)) {
        break;
      }
      ae.w("MicroMsg.CdnImageService", "contains url[%s]", new Object[] { paramString });
      AppMethodBeat.o(150530);
      return;
    }
    this.icb.put(paramString, paramc);
    b.c(new b(paramString, this.icb), "CdnImageService_download");
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
    private HashMap<String, d.c> icb;
    private Bitmap icc;
    private String url;
    
    public a(String paramString, Bitmap paramBitmap, HashMap<String, d.c> paramHashMap, byte[] paramArrayOfByte)
    {
      this.url = paramString;
      this.icc = paramBitmap;
      this.icb = paramHashMap;
      this.data = paramArrayOfByte;
    }
    
    public final void run()
    {
      AppMethodBeat.i(150523);
      q.aIW();
      d.g(this.url, this.icc);
      if (this.icb != null)
      {
        localObject = (d.c)this.icb.remove(this.url);
        if (localObject != null) {
          ((d.c)localObject).a(this.icc, this.data);
        }
      }
      if (this.url == null) {}
      for (Object localObject = "null";; localObject = this.url)
      {
        ae.i("MicroMsg.CdnImageService", "finish download post job, url[%s]", new Object[] { localObject });
        AppMethodBeat.o(150523);
        return;
      }
    }
  }
  
  static final class b
    implements Runnable
  {
    private HashMap<String, d.c> icb;
    private String url;
    
    b(String paramString, HashMap<String, d.c> paramHashMap)
    {
      this.url = paramString;
      this.icb = paramHashMap;
    }
    
    public final void run()
    {
      AppMethodBeat.i(150524);
      byte[] arrayOfByte = bu.aSF(this.url);
      if (arrayOfByte == null)
      {
        ae.w("MicroMsg.CdnImageService", "download fail: url[%s] data is null", new Object[] { this.url });
        AppMethodBeat.o(150524);
        return;
      }
      try
      {
        Bitmap localBitmap = h.cu(arrayOfByte);
        ae.i("MicroMsg.CdnImageService", "download finish, url[%s], do post job", new Object[] { this.url });
        ar.f(new d.a(this.url, localBitmap, this.icb, arrayOfByte));
        AppMethodBeat.o(150524);
        return;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          ae.w("MicroMsg.CdnImageService", "download fail: url[%s] decode bitmap error[%s]", new Object[] { this.url, localException.getLocalizedMessage() });
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
 * Qualified Name:     com.tencent.mm.av.d
 * JD-Core Version:    0.7.0.1
 */