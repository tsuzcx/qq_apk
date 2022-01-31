package com.tencent.mm.booter.cache;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import com.tencent.mm.a.f;
import com.tencent.mm.cache.MCacheItem;
import com.tencent.mm.cache.f.a;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.r;
import com.tencent.mm.sdk.platformtools.y;
import java.util.Map;

public final class a
  extends f.a
{
  public static a diV;
  private final f<String, Bitmap> diW;
  
  private a()
  {
    Context localContext = ae.getContext();
    if (com.tencent.mm.platformtools.a.a.values == null) {}
    try
    {
      com.tencent.mm.platformtools.a.a.values = r.Zf(bk.convertStreamToString(localContext.getAssets().open("profile.ini")));
      if (com.tencent.mm.platformtools.a.a.values == null)
      {
        localContext = null;
        this.diW = new f(bk.getInt(localContext, 2000));
        return;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        y.e("MicroMsg.ProfileUtil", "exception:%s", new Object[] { bk.j(localException) });
        continue;
        String str = (String)com.tencent.mm.platformtools.a.a.values.get("BACKGROUND_BITMAP_CACHE_LIMIT");
      }
    }
  }
  
  public static void destroy()
  {
    if (diV == null) {
      return;
    }
    diV.diW.clear();
  }
  
  public static void prepare()
  {
    if (diV == null) {
      diV = new a();
    }
  }
  
  public final void b(String paramString, Bitmap paramBitmap)
  {
    y.v("MicroMsg.MMCacheImpl", "setting bitmap: %s", new Object[] { paramString });
    this.diW.f(paramString, paramBitmap);
  }
  
  public final MCacheItem eu(String paramString)
  {
    y.v("MicroMsg.MMCacheImpl", "getting cache item: %s", new Object[] { paramString });
    return null;
  }
  
  public final void ev(String paramString)
  {
    y.v("MicroMsg.MMCacheImpl", "setting cache item: %s", new Object[] { paramString });
  }
  
  public final Bitmap getBitmap(String paramString)
  {
    y.v("MicroMsg.MMCacheImpl", "getting bitmap: %s", new Object[] { paramString });
    return (Bitmap)this.diW.get(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.booter.cache.a
 * JD-Core Version:    0.7.0.1
 */