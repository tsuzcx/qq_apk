package com.tencent.mm.cache;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.thread.ThreadPool;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

public class ArtistCacheManager
  extends BroadcastReceiver
{
  private static ArtistCacheManager gpq;
  public static HashMap<String, a> gpr;
  private static HashSet<com.tencent.mm.e.a> gps;
  public String gpt;
  
  static
  {
    AppMethodBeat.i(9186);
    gpr = new HashMap();
    gps = new HashSet();
    AppMethodBeat.o(9186);
  }
  
  public static ArtistCacheManager alA()
  {
    AppMethodBeat.i(9181);
    if (gpq == null) {
      gpq = new ArtistCacheManager();
    }
    ArtistCacheManager localArtistCacheManager = gpq;
    AppMethodBeat.o(9181);
    return localArtistCacheManager;
  }
  
  public final void Dn(String paramString)
  {
    AppMethodBeat.i(204745);
    this.gpt = paramString;
    if (!gpr.containsKey(paramString)) {
      gpr.put(paramString, new a());
    }
    AppMethodBeat.o(204745);
  }
  
  public final void Do(String paramString)
  {
    AppMethodBeat.i(204746);
    this.gpt = null;
    if (gpr.containsKey(paramString))
    {
      ((a)gpr.get(paramString)).clearAll();
      gpr.remove(paramString);
    }
    ThreadPool.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(9176);
        com.tencent.mm.cl.a.boE(com.tencent.mm.loader.j.b.aKS());
        AppMethodBeat.o(9176);
      }
    }, "MicroMsg.ArtistCacheManager[clearAllCache]");
    AppMethodBeat.o(204746);
  }
  
  public final <T extends f> T a(com.tencent.mm.e.a parama)
  {
    AppMethodBeat.i(9182);
    if (gpr.containsKey(this.gpt))
    {
      parama = ((a)gpr.get(this.gpt)).c(parama);
      AppMethodBeat.o(9182);
      return parama;
    }
    Log.e("MicroMsg.ArtistCacheManager", "[getArtistCache] id is not contains! %s", new Object[] { this.gpt });
    AppMethodBeat.o(9182);
    return null;
  }
  
  public final void alB()
  {
    AppMethodBeat.i(9185);
    Log.i("MicroMsg.ArtistCacheManager", "[clearAllCache]");
    Iterator localIterator = gpr.entrySet().iterator();
    while (localIterator.hasNext()) {
      ((a)((Map.Entry)localIterator.next()).getValue()).clearAll();
    }
    gps.clear();
    gpq = null;
    ThreadPool.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(9177);
        com.tencent.mm.cl.a.boE(com.tencent.mm.loader.j.b.aKS());
        AppMethodBeat.o(9177);
      }
    }, "MicroMsg.ArtistCacheManager[clearAllCache]");
    c.alF().map.clear();
    AppMethodBeat.o(9185);
  }
  
  public final boolean b(com.tencent.mm.e.a parama)
  {
    AppMethodBeat.i(9183);
    if ((gpr.containsKey(this.gpt)) && (((a)gpr.get(this.gpt)).gpw.containsKey(parama)))
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
    Log.i("MicroMsg.ArtistCacheManager", "[onReceive]");
    if ((paramIntent != null) && (paramIntent.getAction().equals("com.tencent.mm.plugin.photoedit.action.clear"))) {
      alB();
    }
    AppMethodBeat.o(9184);
  }
  
  public final class a
  {
    HashMap<com.tencent.mm.e.a, f> gpw;
    
    a()
    {
      AppMethodBeat.i(9179);
      this.gpw = new HashMap();
      AppMethodBeat.o(9179);
    }
    
    private static f d(com.tencent.mm.e.a parama)
    {
      AppMethodBeat.i(204744);
      Object localObject = null;
      switch (ArtistCacheManager.3.gpv[parama.ordinal()])
      {
      default: 
        parama = localObject;
      }
      for (;;)
      {
        if (parama != null) {
          parama.onCreate();
        }
        AppMethodBeat.o(204744);
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
      AppMethodBeat.i(204743);
      if (!this.gpw.containsKey(parama))
      {
        f localf = d(parama);
        if ((localf != null) && (!this.gpw.containsKey(parama))) {
          this.gpw.put(parama, localf);
        }
      }
      parama = (f)this.gpw.get(parama);
      AppMethodBeat.o(204743);
      return parama;
    }
    
    public final void clearAll()
    {
      AppMethodBeat.i(9180);
      Iterator localIterator = this.gpw.entrySet().iterator();
      while (localIterator.hasNext()) {
        ((f)((Map.Entry)localIterator.next()).getValue()).onDestroy();
      }
      AppMethodBeat.o(9180);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.cache.ArtistCacheManager
 * JD-Core Version:    0.7.0.1
 */