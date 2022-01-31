package com.tencent.mm.as;

import android.graphics.Bitmap;
import com.tencent.mm.cache.e.a;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.util.HashMap;

public final class c
{
  private HashMap<String, c.c> enb = new HashMap();
  
  public static void g(String paramString, Bitmap paramBitmap)
  {
    if ((paramString == null) || (paramString.length() == 0))
    {
      y.e("MicroMsg.CdnImageService", "push fail, key is null");
      return;
    }
    e.a.a("local_cdn_img_cache", paramString, paramBitmap);
  }
  
  public static Bitmap jK(String paramString)
  {
    if ((paramString == null) || (paramString.length() == 0))
    {
      y.e("MicroMsg.CdnImageService", "get fail, key is null");
      return null;
    }
    return (Bitmap)e.a.A("local_cdn_img_cache", paramString);
  }
  
  public final void a(String paramString, c.c paramc)
  {
    if (bk.bl(paramString)) {
      y.w("MicroMsg.CdnImageService", "do load fail, url is empty");
    }
    Bitmap localBitmap;
    do
    {
      return;
      localBitmap = jK(paramString);
      if ((localBitmap == null) || (localBitmap.isRecycled())) {
        break;
      }
      y.i("MicroMsg.CdnImageService", "do load ok, url[%s], bitmap exists", new Object[] { paramString });
    } while (paramc == null);
    paramc.t(localBitmap);
    return;
    if (localBitmap == null) {}
    for (boolean bool = true;; bool = false)
    {
      y.w("MicroMsg.CdnImageService", "try to download: url[%s], src bitmap is null[%B]", new Object[] { paramString, Boolean.valueOf(bool) });
      if (!this.enb.containsKey(paramString)) {
        break;
      }
      y.w("MicroMsg.CdnImageService", "contains url[%s]", new Object[] { paramString });
      return;
    }
    this.enb.put(paramString, paramc);
    e.post(new c.b(paramString, this.enb), "CdnImageService_download");
  }
  
  protected final void finalize()
  {
    super.finalize();
  }
  
  public final void lV(String paramString)
  {
    if (bk.bl(paramString))
    {
      y.w("MicroMsg.CdnImageService", "stop load fail, url is empty");
      return;
    }
    this.enb.remove(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.as.c
 * JD-Core Version:    0.7.0.1
 */