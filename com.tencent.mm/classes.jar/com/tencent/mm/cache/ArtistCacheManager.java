package com.tencent.mm.cache;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.mm.sdk.platformtools.y;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

public class ArtistCacheManager
  extends BroadcastReceiver
{
  private static ArtistCacheManager dkP;
  public static HashMap<String, ArtistCacheManager.a> dkQ = new HashMap();
  private static HashSet<com.tencent.mm.e.a> dkR = new HashSet();
  public String dkS;
  
  public static ArtistCacheManager wL()
  {
    if (dkP == null) {
      dkP = new ArtistCacheManager();
    }
    return dkP;
  }
  
  public final <T extends d> T a(com.tencent.mm.e.a parama)
  {
    Object localObject = null;
    if (dkQ.containsKey(this.dkS))
    {
      ArtistCacheManager.a locala = (ArtistCacheManager.a)dkQ.get(this.dkS);
      if (!locala.dkV.containsKey(parama)) {
        switch (ArtistCacheManager.3.dkU[parama.ordinal()])
        {
        }
      }
      for (;;)
      {
        if (localObject != null) {
          ((d)localObject).onCreate();
        }
        if ((localObject != null) && (!locala.dkV.containsKey(parama))) {
          locala.dkV.put(parama, localObject);
        }
        return (d)locala.dkV.get(parama);
        localObject = new b();
        continue;
        localObject = new c();
        continue;
        localObject = new g();
        continue;
        localObject = new a();
      }
    }
    y.e("MicroMsg.ArtistCacheManager", "[getArtistCache] id is not contains! %s", new Object[] { this.dkS });
    return null;
  }
  
  @Deprecated
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    y.i("MicroMsg.ArtistCacheManager", "[onReceive]");
    if ((paramIntent != null) && (paramIntent.getAction().equals("com.tencent.mm.plugin.photoedit.action.clear"))) {
      wM();
    }
  }
  
  public final void wM()
  {
    y.i("MicroMsg.ArtistCacheManager", "[clearAllCache]");
    Iterator localIterator = dkQ.entrySet().iterator();
    while (localIterator.hasNext()) {
      ((ArtistCacheManager.a)((Map.Entry)localIterator.next()).getValue()).clearAll();
    }
    dkR.clear();
    dkP = null;
    com.tencent.mm.sdk.f.e.csu();
    com.tencent.mm.sdk.f.e.post(new ArtistCacheManager.2(this), "MicroMsg.ArtistCacheManager[clearAllCache]");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.cache.ArtistCacheManager
 * JD-Core Version:    0.7.0.1
 */