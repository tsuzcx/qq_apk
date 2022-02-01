package com.tencent.mm.cache;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ae;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

public class ArtistCacheManager
  extends BroadcastReceiver
{
  private static ArtistCacheManager fKb;
  private static HashMap<String, a> fKc;
  private static HashSet<com.tencent.mm.e.a> fKd;
  private String fKe;
  
  static
  {
    AppMethodBeat.i(9186);
    fKc = new HashMap();
    fKd = new HashSet();
    AppMethodBeat.o(9186);
  }
  
  public static ArtistCacheManager XN()
  {
    AppMethodBeat.i(9181);
    if (fKb == null) {
      fKb = new ArtistCacheManager();
    }
    ArtistCacheManager localArtistCacheManager = fKb;
    AppMethodBeat.o(9181);
    return localArtistCacheManager;
  }
  
  public static <T extends f> T a(String paramString, com.tencent.mm.e.a parama)
  {
    AppMethodBeat.i(195424);
    if (fKc.containsKey(paramString))
    {
      paramString = ((a)fKc.get(paramString)).c(parama);
      AppMethodBeat.o(195424);
      return paramString;
    }
    ae.e("MicroMsg.ArtistCacheManager", "[getArtistCache] id is not contains! %s", new Object[] { paramString });
    AppMethodBeat.o(195424);
    return null;
  }
  
  public final void XO()
  {
    AppMethodBeat.i(9185);
    ae.i("MicroMsg.ArtistCacheManager", "[clearAllCache]");
    Iterator localIterator = fKc.entrySet().iterator();
    while (localIterator.hasNext()) {
      ((a)((Map.Entry)localIterator.next()).getValue()).clearAll();
    }
    fKd.clear();
    fKb = null;
    com.tencent.mm.sdk.g.b.c(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(9177);
        com.tencent.mm.cl.a.aZz(com.tencent.mm.loader.j.b.ass());
        AppMethodBeat.o(9177);
      }
    }, "MicroMsg.ArtistCacheManager[clearAllCache]");
    c.XS().cEm.clear();
    AppMethodBeat.o(9185);
  }
  
  public final <T extends f> T a(com.tencent.mm.e.a parama)
  {
    AppMethodBeat.i(9182);
    if (fKc.containsKey(this.fKe))
    {
      parama = ((a)fKc.get(this.fKe)).c(parama);
      AppMethodBeat.o(9182);
      return parama;
    }
    ae.e("MicroMsg.ArtistCacheManager", "[getArtistCache] id is not contains! %s", new Object[] { this.fKe });
    AppMethodBeat.o(9182);
    return null;
  }
  
  public final boolean b(com.tencent.mm.e.a parama)
  {
    AppMethodBeat.i(9183);
    if ((fKc.containsKey(this.fKe)) && (((a)fKc.get(this.fKe)).fKh.containsKey(parama)))
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
    ae.i("MicroMsg.ArtistCacheManager", "[onReceive]");
    if ((paramIntent != null) && (paramIntent.getAction().equals("com.tencent.mm.plugin.photoedit.action.clear"))) {
      XO();
    }
    AppMethodBeat.o(9184);
  }
  
  public final void uX(String paramString)
  {
    AppMethodBeat.i(195422);
    this.fKe = paramString;
    if (!fKc.containsKey(paramString)) {
      fKc.put(paramString, new a());
    }
    AppMethodBeat.o(195422);
  }
  
  public final void uY(String paramString)
  {
    AppMethodBeat.i(195423);
    this.fKe = null;
    if (fKc.containsKey(paramString))
    {
      ((a)fKc.get(paramString)).clearAll();
      fKc.remove(paramString);
    }
    com.tencent.mm.sdk.g.b.c(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(9176);
        com.tencent.mm.cl.a.aZz(com.tencent.mm.loader.j.b.ass());
        AppMethodBeat.o(9176);
      }
    }, "MicroMsg.ArtistCacheManager[clearAllCache]");
    AppMethodBeat.o(195423);
  }
  
  final class a
  {
    HashMap<com.tencent.mm.e.a, f> fKh;
    
    a()
    {
      AppMethodBeat.i(9179);
      this.fKh = new HashMap();
      AppMethodBeat.o(9179);
    }
    
    private static f d(com.tencent.mm.e.a parama)
    {
      AppMethodBeat.i(195421);
      Object localObject = null;
      switch (ArtistCacheManager.3.fKg[parama.ordinal()])
      {
      default: 
        parama = localObject;
      }
      for (;;)
      {
        if (parama != null) {
          parama.onCreate();
        }
        AppMethodBeat.o(195421);
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
      AppMethodBeat.i(195420);
      if (!this.fKh.containsKey(parama))
      {
        f localf = d(parama);
        if ((localf != null) && (!this.fKh.containsKey(parama))) {
          this.fKh.put(parama, localf);
        }
      }
      parama = (f)this.fKh.get(parama);
      AppMethodBeat.o(195420);
      return parama;
    }
    
    public final void clearAll()
    {
      AppMethodBeat.i(9180);
      Iterator localIterator = this.fKh.entrySet().iterator();
      while (localIterator.hasNext()) {
        ((f)((Map.Entry)localIterator.next()).getValue()).onDestroy();
      }
      AppMethodBeat.o(9180);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.cache.ArtistCacheManager
 * JD-Core Version:    0.7.0.1
 */