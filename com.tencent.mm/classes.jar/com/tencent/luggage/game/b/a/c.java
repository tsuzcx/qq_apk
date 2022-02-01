package com.tencent.luggage.game.b.a;

import com.github.henryye.nativeiv.ImageDecodeConfig.ReferrerPolicy;
import com.github.henryye.nativeiv.b.b;
import com.tencent.mm.plugin.appbrand.appstorage.q;
import com.tencent.mm.sdk.platformtools.Log;

public abstract class c<T extends a>
  implements b
{
  c(T paramT)
  {
    Log.i("MicroMsg.BaseImageStreamFetcherWxa", "hy: construct fetcher with config %s env %s", new Object[] { paramT.getClass().getSimpleName(), paramT.LR() });
  }
  
  public static abstract interface a
  {
    public abstract String LR();
  }
  
  public static abstract interface b
    extends c.a
  {
    public abstract q getFileSystem();
  }
  
  public static abstract interface c
    extends c.a
  {
    public abstract int LS();
    
    public abstract int LU();
    
    public abstract String a(ImageDecodeConfig.ReferrerPolicy paramReferrerPolicy);
    
    public abstract String getUserAgentString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.luggage.game.b.a.c
 * JD-Core Version:    0.7.0.1
 */