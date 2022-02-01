package com.tencent.mm.cache;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ac;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

public class ArtistCacheManager
  extends BroadcastReceiver
{
  private static ArtistCacheManager fpQ;
  private static HashMap<String, a> fpR;
  private static HashSet<com.tencent.mm.e.a> fpS;
  private String fpT;
  
  static
  {
    AppMethodBeat.i(9186);
    fpR = new HashMap();
    fpS = new HashSet();
    AppMethodBeat.o(9186);
  }
  
  public static ArtistCacheManager Vm()
  {
    AppMethodBeat.i(9181);
    if (fpQ == null) {
      fpQ = new ArtistCacheManager();
    }
    ArtistCacheManager localArtistCacheManager = fpQ;
    AppMethodBeat.o(9181);
    return localArtistCacheManager;
  }
  
  public static <T extends f> T a(String paramString, com.tencent.mm.e.a parama)
  {
    AppMethodBeat.i(199927);
    if (fpR.containsKey(paramString))
    {
      paramString = ((a)fpR.get(paramString)).c(parama);
      AppMethodBeat.o(199927);
      return paramString;
    }
    ac.e("MicroMsg.ArtistCacheManager", "[getArtistCache] id is not contains! %s", new Object[] { paramString });
    AppMethodBeat.o(199927);
    return null;
  }
  
  public final void Vn()
  {
    AppMethodBeat.i(9185);
    ac.i("MicroMsg.ArtistCacheManager", "[clearAllCache]");
    Iterator localIterator = fpR.entrySet().iterator();
    while (localIterator.hasNext()) {
      ((a)((Map.Entry)localIterator.next()).getValue()).clearAll();
    }
    fpS.clear();
    fpQ = null;
    com.tencent.mm.sdk.g.b.c(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(9177);
        com.tencent.mm.cm.a.aRY(com.tencent.mm.loader.j.b.app());
        AppMethodBeat.o(9177);
      }
    }, "MicroMsg.ArtistCacheManager[clearAllCache]");
    c.Vr().csJ.clear();
    AppMethodBeat.o(9185);
  }
  
  public final <T extends f> T a(com.tencent.mm.e.a parama)
  {
    AppMethodBeat.i(9182);
    if (fpR.containsKey(this.fpT))
    {
      parama = ((a)fpR.get(this.fpT)).c(parama);
      AppMethodBeat.o(9182);
      return parama;
    }
    ac.e("MicroMsg.ArtistCacheManager", "[getArtistCache] id is not contains! %s", new Object[] { this.fpT });
    AppMethodBeat.o(9182);
    return null;
  }
  
  public final boolean b(com.tencent.mm.e.a parama)
  {
    AppMethodBeat.i(9183);
    if ((fpR.containsKey(this.fpT)) && (((a)fpR.get(this.fpT)).fpW.containsKey(parama)))
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
    ac.i("MicroMsg.ArtistCacheManager", "[onReceive]");
    if ((paramIntent != null) && (paramIntent.getAction().equals("com.tencent.mm.plugin.photoedit.action.clear"))) {
      Vn();
    }
    AppMethodBeat.o(9184);
  }
  
  public final void rP(String paramString)
  {
    AppMethodBeat.i(199925);
    this.fpT = paramString;
    if (!fpR.containsKey(paramString)) {
      fpR.put(paramString, new a());
    }
    AppMethodBeat.o(199925);
  }
  
  public final void rQ(String paramString)
  {
    AppMethodBeat.i(199926);
    this.fpT = null;
    if (fpR.containsKey(paramString))
    {
      ((a)fpR.get(paramString)).clearAll();
      fpR.remove(paramString);
    }
    com.tencent.mm.sdk.g.b.c(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(9176);
        com.tencent.mm.cm.a.aRY(com.tencent.mm.loader.j.b.app());
        AppMethodBeat.o(9176);
      }
    }, "MicroMsg.ArtistCacheManager[clearAllCache]");
    AppMethodBeat.o(199926);
  }
  
  final class a
  {
    HashMap<com.tencent.mm.e.a, f> fpW;
    
    a()
    {
      AppMethodBeat.i(9179);
      this.fpW = new HashMap();
      AppMethodBeat.o(9179);
    }
    
    private static f d(com.tencent.mm.e.a parama)
    {
      AppMethodBeat.i(199924);
      Object localObject = null;
      switch (ArtistCacheManager.3.fpV[parama.ordinal()])
      {
      default: 
        parama = localObject;
      }
      for (;;)
      {
        if (parama != null) {
          parama.onCreate();
        }
        AppMethodBeat.o(199924);
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
      AppMethodBeat.i(199923);
      if (!this.fpW.containsKey(parama))
      {
        f localf = d(parama);
        if ((localf != null) && (!this.fpW.containsKey(parama))) {
          this.fpW.put(parama, localf);
        }
      }
      parama = (f)this.fpW.get(parama);
      AppMethodBeat.o(199923);
      return parama;
    }
    
    public final void clearAll()
    {
      AppMethodBeat.i(9180);
      Iterator localIterator = this.fpW.entrySet().iterator();
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