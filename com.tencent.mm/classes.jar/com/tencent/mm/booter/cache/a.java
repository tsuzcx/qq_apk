package com.tencent.mm.booter.cache;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.f;
import com.tencent.mm.cache.MCacheItem;
import com.tencent.mm.cache.h.a;
import com.tencent.mm.memory.a.b;
import com.tencent.mm.sdk.platformtools.IniParser;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Map;

public final class a
  extends h.a
{
  public static a ltB;
  private final f<String, Bitmap> ltC;
  
  private a()
  {
    AppMethodBeat.i(19918);
    Context localContext = MMApplicationContext.getContext();
    if (com.tencent.mm.platformtools.a.a.values == null) {}
    try
    {
      com.tencent.mm.platformtools.a.a.values = IniParser.parse(Util.convertStreamToString(localContext.getAssets().open("profile.ini")));
      if (com.tencent.mm.platformtools.a.a.values == null)
      {
        localContext = null;
        this.ltC = new b(Util.getInt(localContext, 2000), getClass());
        AppMethodBeat.o(19918);
        return;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Log.e("MicroMsg.ProfileUtil", "exception:%s", new Object[] { Util.stackTraceToString(localException) });
        continue;
        String str = (String)com.tencent.mm.platformtools.a.a.values.get("BACKGROUND_BITMAP_CACHE_LIMIT");
      }
    }
  }
  
  public static void destroy()
  {
    AppMethodBeat.i(19920);
    if (ltB == null)
    {
      AppMethodBeat.o(19920);
      return;
    }
    ltB.ltC.clear();
    AppMethodBeat.o(19920);
  }
  
  public static void prepare()
  {
    AppMethodBeat.i(19919);
    if (ltB == null) {
      ltB = new a();
    }
    AppMethodBeat.o(19919);
  }
  
  public final Bitmap Cr(String paramString)
  {
    AppMethodBeat.i(19921);
    Log.v("MicroMsg.MMCacheImpl", "getting bitmap: %s", new Object[] { paramString });
    paramString = (Bitmap)this.ltC.get(paramString);
    AppMethodBeat.o(19921);
    return paramString;
  }
  
  public final MCacheItem Cs(String paramString)
  {
    AppMethodBeat.i(19922);
    Log.v("MicroMsg.MMCacheImpl", "getting cache item: %s", new Object[] { paramString });
    AppMethodBeat.o(19922);
    return null;
  }
  
  public final void Ct(String paramString)
  {
    AppMethodBeat.i(19924);
    Log.v("MicroMsg.MMCacheImpl", "setting cache item: %s", new Object[] { paramString });
    AppMethodBeat.o(19924);
  }
  
  public final void b(String paramString, Bitmap paramBitmap)
  {
    AppMethodBeat.i(19923);
    Log.v("MicroMsg.MMCacheImpl", "setting bitmap: %s", new Object[] { paramString });
    this.ltC.B(paramString, paramBitmap);
    AppMethodBeat.o(19923);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.booter.cache.a
 * JD-Core Version:    0.7.0.1
 */