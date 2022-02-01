package com.tencent.mm.cache;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

public class ArtistCacheManager
  extends BroadcastReceiver
{
  private static ArtistCacheManager fmv;
  private static HashMap<String, a> fmw;
  private static HashSet<com.tencent.mm.e.a> fmx;
  private String fmy;
  
  static
  {
    AppMethodBeat.i(9186);
    fmw = new HashMap();
    fmx = new HashSet();
    AppMethodBeat.o(9186);
  }
  
  public static ArtistCacheManager Ur()
  {
    AppMethodBeat.i(9181);
    if (fmv == null) {
      fmv = new ArtistCacheManager();
    }
    ArtistCacheManager localArtistCacheManager = fmv;
    AppMethodBeat.o(9181);
    return localArtistCacheManager;
  }
  
  public static <T extends f> T a(String paramString, com.tencent.mm.e.a parama)
  {
    AppMethodBeat.i(205055);
    if (fmw.containsKey(paramString))
    {
      paramString = ((a)fmw.get(paramString)).c(parama);
      AppMethodBeat.o(205055);
      return paramString;
    }
    ad.e("MicroMsg.ArtistCacheManager", "[getArtistCache] id is not contains! %s", new Object[] { paramString });
    AppMethodBeat.o(205055);
    return null;
  }
  
  public final void Us()
  {
    AppMethodBeat.i(9185);
    ad.i("MicroMsg.ArtistCacheManager", "[clearAllCache]");
    Iterator localIterator = fmw.entrySet().iterator();
    while (localIterator.hasNext()) {
      ((a)((Map.Entry)localIterator.next()).getValue()).clearAll();
    }
    fmx.clear();
    fmv = null;
    com.tencent.mm.sdk.g.b.c(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(9177);
        com.tencent.mm.cn.a.aMw(com.tencent.mm.loader.j.b.aip());
        AppMethodBeat.o(9177);
      }
    }, "MicroMsg.ArtistCacheManager[clearAllCache]");
    c.Uw().cvB.clear();
    AppMethodBeat.o(9185);
  }
  
  public final <T extends f> T a(com.tencent.mm.e.a parama)
  {
    AppMethodBeat.i(9182);
    if (fmw.containsKey(this.fmy))
    {
      parama = ((a)fmw.get(this.fmy)).c(parama);
      AppMethodBeat.o(9182);
      return parama;
    }
    ad.e("MicroMsg.ArtistCacheManager", "[getArtistCache] id is not contains! %s", new Object[] { this.fmy });
    AppMethodBeat.o(9182);
    return null;
  }
  
  public final void aTR(String paramString)
  {
    AppMethodBeat.i(205053);
    this.fmy = paramString;
    if (!fmw.containsKey(paramString)) {
      fmw.put(paramString, new a());
    }
    AppMethodBeat.o(205053);
  }
  
  public final void aTS(String paramString)
  {
    AppMethodBeat.i(205054);
    this.fmy = null;
    if (fmw.containsKey(paramString))
    {
      ((a)fmw.get(paramString)).clearAll();
      fmw.remove(paramString);
    }
    com.tencent.mm.sdk.g.b.c(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(9176);
        com.tencent.mm.cn.a.aMw(com.tencent.mm.loader.j.b.aip());
        AppMethodBeat.o(9176);
      }
    }, "MicroMsg.ArtistCacheManager[clearAllCache]");
    AppMethodBeat.o(205054);
  }
  
  public final boolean b(com.tencent.mm.e.a parama)
  {
    AppMethodBeat.i(9183);
    if ((fmw.containsKey(this.fmy)) && (((a)fmw.get(this.fmy)).fmB.containsKey(parama)))
    {
      AppMethodBeat.o(9183);
      return true;
    }
    AppMethodBeat.o(9183);
    return false;
  }
  
  @Deprecated
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(9184);
    ad.i("MicroMsg.ArtistCacheManager", "[onReceive]");
    if ((paramIntent != null) && (paramIntent.getAction().equals("com.tencent.mm.plugin.photoedit.action.clear"))) {
      Us();
    }
    AppMethodBeat.o(9184);
  }
  
  final class a
  {
    HashMap<com.tencent.mm.e.a, f> fmB;
    
    a()
    {
      AppMethodBeat.i(9179);
      this.fmB = new HashMap();
      AppMethodBeat.o(9179);
    }
    
    private static f d(com.tencent.mm.e.a parama)
    {
      AppMethodBeat.i(205052);
      Object localObject = null;
      switch (ArtistCacheManager.3.fmA[parama.ordinal()])
      {
      default: 
        parama = localObject;
      }
      for (;;)
      {
        if (parama != null) {
          parama.onCreate();
        }
        AppMethodBeat.o(205052);
        return parama;
        parama = new b();
        continue;
        parama = new d();
        continue;
        parama = new i();
        continue;
        parama = new a();
        continue;
        parama = new e();
      }
    }
    
    public final f c(com.tencent.mm.e.a parama)
    {
      AppMethodBeat.i(205051);
      if (!this.fmB.containsKey(parama))
      {
        f localf = d(parama);
        if ((localf != null) && (!this.fmB.containsKey(parama))) {
          this.fmB.put(parama, localf);
        }
      }
      parama = (f)this.fmB.get(parama);
      AppMethodBeat.o(205051);
      return parama;
    }
    
    public final void clearAll()
    {
      AppMethodBeat.i(9180);
      Iterator localIterator = this.fmB.entrySet().iterator();
      while (localIterator.hasNext()) {
        ((f)((Map.Entry)localIterator.next()).getValue()).onDestroy();
      }
      AppMethodBeat.o(9180);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.cache.ArtistCacheManager
 * JD-Core Version:    0.7.0.1
 */