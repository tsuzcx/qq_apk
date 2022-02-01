package com.tencent.luggage.game.b.a;

import com.github.henryye.nativeiv.ImageDecodeConfig.ReferrerPolicy;
import com.github.henryye.nativeiv.b.b;
import com.tencent.mm.plugin.appbrand.appstorage.w;
import com.tencent.mm.plugin.appbrand.n.k;
import com.tencent.mm.sdk.platformtools.Log;

public abstract class d<T extends a>
  implements b
{
  d(T paramT)
  {
    Log.i("MicroMsg.BaseImageStreamFetcherWxa", "hy: construct fetcher with config %s env %s", new Object[] { paramT.getClass().getSimpleName(), paramT.aoQ() });
  }
  
  public static abstract interface a
  {
    public abstract String aoQ();
  }
  
  public static abstract interface b
    extends d.a
  {
    public abstract w getFileSystem();
  }
  
  public static abstract interface c
    extends d.a
  {
    public abstract String a(ImageDecodeConfig.ReferrerPolicy paramReferrerPolicy);
    
    public abstract int aoR();
    
    public abstract int aoT();
    
    public abstract String getUserAgentString();
  }
  
  public static abstract interface d
    extends d.a
  {
    public abstract k aoU();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.luggage.game.b.a.d
 * JD-Core Version:    0.7.0.1
 */