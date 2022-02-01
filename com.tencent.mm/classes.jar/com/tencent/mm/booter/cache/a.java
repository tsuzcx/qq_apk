package com.tencent.mm.booter.cache;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.f;
import com.tencent.mm.cache.MCacheItem;
import com.tencent.mm.cache.h.a;
import com.tencent.mm.memory.a.b;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.sdk.platformtools.v;
import java.util.Map;

public final class a
  extends h.a
{
  public static a fnW;
  private final f<String, Bitmap> fnX;
  
  private a()
  {
    AppMethodBeat.i(19918);
    Context localContext = ai.getContext();
    if (com.tencent.mm.platformtools.a.a.values == null) {}
    try
    {
      com.tencent.mm.platformtools.a.a.values = v.aKI(bs.convertStreamToString(localContext.getAssets().open("profile.ini")));
      if (com.tencent.mm.platformtools.a.a.values == null)
      {
        localContext = null;
        this.fnX = new b(bs.getInt(localContext, 2000), getClass());
        AppMethodBeat.o(19918);
        return;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ac.e("MicroMsg.ProfileUtil", "exception:%s", new Object[] { bs.m(localException) });
        continue;
        String str = (String)com.tencent.mm.platformtools.a.a.values.get("BACKGROUND_BITMAP_CACHE_LIMIT");
      }
    }
  }
  
  public static void destroy()
  {
    AppMethodBeat.i(19920);
    if (fnW == null)
    {
      AppMethodBeat.o(19920);
      return;
    }
    fnW.fnX.clear();
    AppMethodBeat.o(19920);
  }
  
  public static void prepare()
  {
    AppMethodBeat.i(19919);
    if (fnW == null) {
      fnW = new a();
    }
    AppMethodBeat.o(19919);
  }
  
  public final void b(String paramString, Bitmap paramBitmap)
  {
    AppMethodBeat.i(19923);
    ac.v("MicroMsg.MMCacheImpl", "setting bitmap: %s", new Object[] { paramString });
    this.fnX.o(paramString, paramBitmap);
    AppMethodBeat.o(19923);
  }
  
  public final Bitmap getBitmap(String paramString)
  {
    AppMethodBeat.i(19921);
    ac.v("MicroMsg.MMCacheImpl", "getting bitmap: %s", new Object[] { paramString });
    paramString = (Bitmap)this.fnX.get(paramString);
    AppMethodBeat.o(19921);
    return paramString;
  }
  
  public final MCacheItem ry(String paramString)
  {
    AppMethodBeat.i(19922);
    ac.v("MicroMsg.MMCacheImpl", "getting cache item: %s", new Object[] { paramString });
    AppMethodBeat.o(19922);
    return null;
  }
  
  public final void rz(String paramString)
  {
    AppMethodBeat.i(19924);
    ac.v("MicroMsg.MMCacheImpl", "setting cache item: %s", new Object[] { paramString });
    AppMethodBeat.o(19924);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.booter.cache.a
 * JD-Core Version:    0.7.0.1
 */