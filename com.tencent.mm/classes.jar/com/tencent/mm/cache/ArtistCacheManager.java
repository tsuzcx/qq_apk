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
  private static ArtistCacheManager fHX;
  private static HashMap<String, a> fHY;
  private static HashSet<com.tencent.mm.e.a> fHZ;
  private String fIa;
  
  static
  {
    AppMethodBeat.i(9186);
    fHY = new HashMap();
    fHZ = new HashSet();
    AppMethodBeat.o(9186);
  }
  
  public static ArtistCacheManager XD()
  {
    AppMethodBeat.i(9181);
    if (fHX == null) {
      fHX = new ArtistCacheManager();
    }
    ArtistCacheManager localArtistCacheManager = fHX;
    AppMethodBeat.o(9181);
    return localArtistCacheManager;
  }
  
  public static <T extends f> T a(String paramString, com.tencent.mm.e.a parama)
  {
    AppMethodBeat.i(221098);
    if (fHY.containsKey(paramString))
    {
      paramString = ((a)fHY.get(paramString)).c(parama);
      AppMethodBeat.o(221098);
      return paramString;
    }
    ad.e("MicroMsg.ArtistCacheManager", "[getArtistCache] id is not contains! %s", new Object[] { paramString });
    AppMethodBeat.o(221098);
    return null;
  }
  
  public final void XE()
  {
    AppMethodBeat.i(9185);
    ad.i("MicroMsg.ArtistCacheManager", "[clearAllCache]");
    Iterator localIterator = fHY.entrySet().iterator();
    while (localIterator.hasNext()) {
      ((a)((Map.Entry)localIterator.next()).getValue()).clearAll();
    }
    fHZ.clear();
    fHX = null;
    com.tencent.mm.sdk.g.b.c(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(9177);
        com.tencent.mm.cm.a.aXX(com.tencent.mm.loader.j.b.asd());
        AppMethodBeat.o(9177);
      }
    }, "MicroMsg.ArtistCacheManager[clearAllCache]");
    c.XI().cDF.clear();
    AppMethodBeat.o(9185);
  }
  
  public final <T extends f> T a(com.tencent.mm.e.a parama)
  {
    AppMethodBeat.i(9182);
    if (fHY.containsKey(this.fIa))
    {
      parama = ((a)fHY.get(this.fIa)).c(parama);
      AppMethodBeat.o(9182);
      return parama;
    }
    ad.e("MicroMsg.ArtistCacheManager", "[getArtistCache] id is not contains! %s", new Object[] { this.fIa });
    AppMethodBeat.o(9182);
    return null;
  }
  
  public final boolean b(com.tencent.mm.e.a parama)
  {
    AppMethodBeat.i(9183);
    if ((fHY.containsKey(this.fIa)) && (((a)fHY.get(this.fIa)).fId.containsKey(parama)))
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
      XE();
    }
    AppMethodBeat.o(9184);
  }
  
  public final void uC(String paramString)
  {
    AppMethodBeat.i(221096);
    this.fIa = paramString;
    if (!fHY.containsKey(paramString)) {
      fHY.put(paramString, new a());
    }
    AppMethodBeat.o(221096);
  }
  
  public final void uD(String paramString)
  {
    AppMethodBeat.i(221097);
    this.fIa = null;
    if (fHY.containsKey(paramString))
    {
      ((a)fHY.get(paramString)).clearAll();
      fHY.remove(paramString);
    }
    com.tencent.mm.sdk.g.b.c(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(9176);
        com.tencent.mm.cm.a.aXX(com.tencent.mm.loader.j.b.asd());
        AppMethodBeat.o(9176);
      }
    }, "MicroMsg.ArtistCacheManager[clearAllCache]");
    AppMethodBeat.o(221097);
  }
  
  final class a
  {
    HashMap<com.tencent.mm.e.a, f> fId;
    
    a()
    {
      AppMethodBeat.i(9179);
      this.fId = new HashMap();
      AppMethodBeat.o(9179);
    }
    
    private static f d(com.tencent.mm.e.a parama)
    {
      AppMethodBeat.i(221095);
      Object localObject = null;
      switch (ArtistCacheManager.3.fIc[parama.ordinal()])
      {
      default: 
        parama = localObject;
      }
      for (;;)
      {
        if (parama != null) {
          parama.onCreate();
        }
        AppMethodBeat.o(221095);
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
      AppMethodBeat.i(221094);
      if (!this.fId.containsKey(parama))
      {
        f localf = d(parama);
        if ((localf != null) && (!this.fId.containsKey(parama))) {
          this.fId.put(parama, localf);
        }
      }
      parama = (f)this.fId.get(parama);
      AppMethodBeat.o(221094);
      return parama;
    }
    
    public final void clearAll()
    {
      AppMethodBeat.i(9180);
      Iterator localIterator = this.fId.entrySet().iterator();
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