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
  private static ArtistCacheManager lvE;
  public static HashMap<String, a> lvF;
  private static HashSet<com.tencent.mm.e.a> lvG;
  public String lvH;
  
  static
  {
    AppMethodBeat.i(9186);
    lvF = new HashMap();
    lvG = new HashSet();
    AppMethodBeat.o(9186);
  }
  
  public static ArtistCacheManager aLv()
  {
    AppMethodBeat.i(9181);
    if (lvE == null) {
      lvE = new ArtistCacheManager();
    }
    ArtistCacheManager localArtistCacheManager = lvE;
    AppMethodBeat.o(9181);
    return localArtistCacheManager;
  }
  
  public final void CK(String paramString)
  {
    AppMethodBeat.i(232030);
    this.lvH = paramString;
    if (!lvF.containsKey(paramString)) {
      lvF.put(paramString, new a());
    }
    AppMethodBeat.o(232030);
  }
  
  public final void CL(String paramString)
  {
    AppMethodBeat.i(232032);
    this.lvH = null;
    if (lvF.containsKey(paramString))
    {
      ((a)lvF.get(paramString)).clearAll();
      lvF.remove(paramString);
    }
    ThreadPool.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(9176);
        com.tencent.mm.cl.a.bDN(com.tencent.mm.loader.i.b.bmI());
        AppMethodBeat.o(9176);
      }
    }, "MicroMsg.ArtistCacheManager[clearAllCache]");
    AppMethodBeat.o(232032);
  }
  
  public final <T extends f> T a(com.tencent.mm.e.a parama)
  {
    AppMethodBeat.i(9182);
    if (lvF.containsKey(this.lvH))
    {
      parama = ((a)lvF.get(this.lvH)).c(parama);
      AppMethodBeat.o(9182);
      return parama;
    }
    Log.e("MicroMsg.ArtistCacheManager", "[getArtistCache] id is not contains! %s", new Object[] { this.lvH });
    AppMethodBeat.o(9182);
    return null;
  }
  
  public final void aLw()
  {
    AppMethodBeat.i(9185);
    Log.i("MicroMsg.ArtistCacheManager", "[clearAllCache]");
    Iterator localIterator = lvF.entrySet().iterator();
    while (localIterator.hasNext()) {
      ((a)((Map.Entry)localIterator.next()).getValue()).clearAll();
    }
    lvG.clear();
    lvE = null;
    ThreadPool.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(9177);
        com.tencent.mm.cl.a.bDN(com.tencent.mm.loader.i.b.bmI());
        AppMethodBeat.o(9177);
      }
    }, "MicroMsg.ArtistCacheManager[clearAllCache]");
    c.aLA().map.clear();
    AppMethodBeat.o(9185);
  }
  
  public final boolean b(com.tencent.mm.e.a parama)
  {
    AppMethodBeat.i(9183);
    if ((lvF.containsKey(this.lvH)) && (((a)lvF.get(this.lvH)).lvK.containsKey(parama)))
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
      aLw();
    }
    AppMethodBeat.o(9184);
  }
  
  public final class a
  {
    HashMap<com.tencent.mm.e.a, f> lvK;
    
    a()
    {
      AppMethodBeat.i(9179);
      this.lvK = new HashMap();
      AppMethodBeat.o(9179);
    }
    
    private static f d(com.tencent.mm.e.a parama)
    {
      AppMethodBeat.i(232026);
      Object localObject = null;
      switch (ArtistCacheManager.3.lvJ[parama.ordinal()])
      {
      default: 
        parama = localObject;
      }
      for (;;)
      {
        if (parama != null) {
          parama.onCreate();
        }
        AppMethodBeat.o(232026);
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
      AppMethodBeat.i(232028);
      if (!this.lvK.containsKey(parama))
      {
        f localf = d(parama);
        if ((localf != null) && (!this.lvK.containsKey(parama))) {
          this.lvK.put(parama, localf);
        }
      }
      parama = (f)this.lvK.get(parama);
      AppMethodBeat.o(232028);
      return parama;
    }
    
    public final void clearAll()
    {
      AppMethodBeat.i(9180);
      Iterator localIterator = this.lvK.entrySet().iterator();
      while (localIterator.hasNext()) {
        ((f)((Map.Entry)localIterator.next()).getValue()).onDestroy();
      }
      AppMethodBeat.o(9180);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.cache.ArtistCacheManager
 * JD-Core Version:    0.7.0.1
 */