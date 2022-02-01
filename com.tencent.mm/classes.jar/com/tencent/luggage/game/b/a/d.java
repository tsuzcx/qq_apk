package com.tencent.luggage.game.b.a;

import com.github.henryye.nativeiv.ImageDecodeConfig.ReferrerPolicy;
import com.github.henryye.nativeiv.b.b;
import com.tencent.mm.plugin.appbrand.appstorage.r;
import com.tencent.mm.plugin.appbrand.m.k;
import com.tencent.mm.sdk.platformtools.Log;

public abstract class d<T extends a>
  implements b
{
  d(T paramT)
  {
    Log.i("MicroMsg.BaseImageStreamFetcherWxa", "hy: construct fetcher with config %s env %s", new Object[] { paramT.getClass().getSimpleName(), paramT.OI() });
  }
  
  public static abstract interface a
  {
    public abstract String OI();
  }
  
  public static abstract interface b
    extends d.a
  {
    public abstract r getFileSystem();
  }
  
  public static abstract interface c
    extends d.a
  {
    public abstract int OJ();
    
    public abstract int OL();
    
    public abstract String a(ImageDecodeConfig.ReferrerPolicy paramReferrerPolicy);
    
    public abstract String getUserAgentString();
  }
  
  public static abstract interface d
    extends d.a
  {
    public abstract k OM();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.luggage.game.b.a.d
 * JD-Core Version:    0.7.0.1
 */