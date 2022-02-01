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
  private static HashSet<com.tencent.mm.e.a> iTA;
  private static ArtistCacheManager iTy;
  public static HashMap<String, a> iTz;
  public String iTB;
  
  static
  {
    AppMethodBeat.i(9186);
    iTz = new HashMap();
    iTA = new HashSet();
    AppMethodBeat.o(9186);
  }
  
  public static ArtistCacheManager arz()
  {
    AppMethodBeat.i(9181);
    if (iTy == null) {
      iTy = new ArtistCacheManager();
    }
    ArtistCacheManager localArtistCacheManager = iTy;
    AppMethodBeat.o(9181);
    return localArtistCacheManager;
  }
  
  public final void Ke(String paramString)
  {
    AppMethodBeat.i(259890);
    this.iTB = paramString;
    if (!iTz.containsKey(paramString)) {
      iTz.put(paramString, new a());
    }
    AppMethodBeat.o(259890);
  }
  
  public final void Kf(String paramString)
  {
    AppMethodBeat.i(259891);
    this.iTB = null;
    if (iTz.containsKey(paramString))
    {
      ((a)iTz.get(paramString)).clearAll();
      iTz.remove(paramString);
    }
    ThreadPool.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(9176);
        com.tencent.mm.cs.a.bBt(com.tencent.mm.loader.j.b.aSU());
        AppMethodBeat.o(9176);
      }
    }, "MicroMsg.ArtistCacheManager[clearAllCache]");
    AppMethodBeat.o(259891);
  }
  
  public final <T extends f> T a(com.tencent.mm.e.a parama)
  {
    AppMethodBeat.i(9182);
    if (iTz.containsKey(this.iTB))
    {
      parama = ((a)iTz.get(this.iTB)).c(parama);
      AppMethodBeat.o(9182);
      return parama;
    }
    Log.e("MicroMsg.ArtistCacheManager", "[getArtistCache] id is not contains! %s", new Object[] { this.iTB });
    AppMethodBeat.o(9182);
    return null;
  }
  
  public final void arA()
  {
    AppMethodBeat.i(9185);
    Log.i("MicroMsg.ArtistCacheManager", "[clearAllCache]");
    Iterator localIterator = iTz.entrySet().iterator();
    while (localIterator.hasNext()) {
      ((a)((Map.Entry)localIterator.next()).getValue()).clearAll();
    }
    iTA.clear();
    iTy = null;
    ThreadPool.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(9177);
        com.tencent.mm.cs.a.bBt(com.tencent.mm.loader.j.b.aSU());
        AppMethodBeat.o(9177);
      }
    }, "MicroMsg.ArtistCacheManager[clearAllCache]");
    c.arE().map.clear();
    AppMethodBeat.o(9185);
  }
  
  public final boolean b(com.tencent.mm.e.a parama)
  {
    AppMethodBeat.i(9183);
    if ((iTz.containsKey(this.iTB)) && (((a)iTz.get(this.iTB)).iTE.containsKey(parama)))
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
      arA();
    }
    AppMethodBeat.o(9184);
  }
  
  public final class a
  {
    HashMap<com.tencent.mm.e.a, f> iTE;
    
    a()
    {
      AppMethodBeat.i(9179);
      this.iTE = new HashMap();
      AppMethodBeat.o(9179);
    }
    
    private static f d(com.tencent.mm.e.a parama)
    {
      AppMethodBeat.i(260325);
      Object localObject = null;
      switch (ArtistCacheManager.3.iTD[parama.ordinal()])
      {
      default: 
        parama = localObject;
      }
      for (;;)
      {
        if (parama != null) {
          parama.onCreate();
        }
        AppMethodBeat.o(260325);
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
      AppMethodBeat.i(260322);
      if (!this.iTE.containsKey(parama))
      {
        f localf = d(parama);
        if ((localf != null) && (!this.iTE.containsKey(parama))) {
          this.iTE.put(parama, localf);
        }
      }
      parama = (f)this.iTE.get(parama);
      AppMethodBeat.o(260322);
      return parama;
    }
    
    public final void clearAll()
    {
      AppMethodBeat.i(9180);
      Iterator localIterator = this.iTE.entrySet().iterator();
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