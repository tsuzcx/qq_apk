package com.tencent.mm.cache;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

public class ArtistCacheManager
  extends BroadcastReceiver
{
  private static ArtistCacheManager ecj;
  public static HashMap<String, ArtistCacheManager.a> eck;
  private static HashSet<com.tencent.mm.e.a> ecl;
  public String ecm;
  
  static
  {
    AppMethodBeat.i(116214);
    eck = new HashMap();
    ecl = new HashSet();
    AppMethodBeat.o(116214);
  }
  
  public static ArtistCacheManager Jb()
  {
    AppMethodBeat.i(116210);
    if (ecj == null) {
      ecj = new ArtistCacheManager();
    }
    ArtistCacheManager localArtistCacheManager = ecj;
    AppMethodBeat.o(116210);
    return localArtistCacheManager;
  }
  
  public final void Jc()
  {
    AppMethodBeat.i(116213);
    ab.i("MicroMsg.ArtistCacheManager", "[clearAllCache]");
    Iterator localIterator = eck.entrySet().iterator();
    while (localIterator.hasNext()) {
      ((ArtistCacheManager.a)((Map.Entry)localIterator.next()).getValue()).clearAll();
    }
    ecl.clear();
    ecj = null;
    com.tencent.mm.sdk.g.d.post(new ArtistCacheManager.2(this), "MicroMsg.ArtistCacheManager[clearAllCache]");
    c.Jg().bSA.clear();
    AppMethodBeat.o(116213);
  }
  
  public final <T extends e> T a(com.tencent.mm.e.a parama)
  {
    Object localObject = null;
    AppMethodBeat.i(116211);
    if (eck.containsKey(this.ecm))
    {
      ArtistCacheManager.a locala = (ArtistCacheManager.a)eck.get(this.ecm);
      if (!locala.ecp.containsKey(parama)) {
        switch (3.eco[parama.ordinal()])
        {
        }
      }
      for (;;)
      {
        if (localObject != null) {
          ((e)localObject).onCreate();
        }
        if ((localObject != null) && (!locala.ecp.containsKey(parama))) {
          locala.ecp.put(parama, localObject);
        }
        parama = (e)locala.ecp.get(parama);
        AppMethodBeat.o(116211);
        return parama;
        localObject = new b();
        continue;
        localObject = new d();
        continue;
        localObject = new h();
        continue;
        localObject = new a();
      }
    }
    ab.e("MicroMsg.ArtistCacheManager", "[getArtistCache] id is not contains! %s", new Object[] { this.ecm });
    AppMethodBeat.o(116211);
    return null;
  }
  
  public final boolean b(com.tencent.mm.e.a parama)
  {
    AppMethodBeat.i(146033);
    if ((eck.containsKey(this.ecm)) && (((ArtistCacheManager.a)eck.get(this.ecm)).ecp.containsKey(parama)))
    {
      AppMethodBeat.o(146033);
      return true;
    }
    AppMethodBeat.o(146033);
    return false;
  }
  
  @Deprecated
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(116212);
    ab.i("MicroMsg.ArtistCacheManager", "[onReceive]");
    if ((paramIntent != null) && (paramIntent.getAction().equals("com.tencent.mm.plugin.photoedit.action.clear"))) {
      Jc();
    }
    AppMethodBeat.o(116212);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.cache.ArtistCacheManager
 * JD-Core Version:    0.7.0.1
 */