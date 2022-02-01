package com.tencent.mm.msgsubscription.voice;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.c;
import com.tencent.mm.f.a.z;
import com.tencent.mm.f.a.z.a;
import com.tencent.mm.plugin.music.b.h;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/msgsubscription/voice/MsgSubscriptionVoicePlayHelperMM;", "", "()V", "GUARD", "", "audioIdMapToID", "", "", "", "mAudioPlayerEventListener", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/AudioPlayerEvent;", "urlsToPlay", "Ljava/util/LinkedHashMap;", "Lkotlin/collections/LinkedHashMap;", "innerPlay", "", "url", "id", "play", "stop", "wxbiz-msgsubscription-sdk_release"})
public final class b
{
  private static final LinkedHashMap<Long, String> mtH;
  private static final Map<String, Long> mtI;
  private static final byte[] mtJ;
  private static final IListener<z> mtK;
  public static final b mtL;
  
  static
  {
    AppMethodBeat.i(263534);
    mtL = new b();
    mtH = new LinkedHashMap();
    mtI = (Map)new LinkedHashMap();
    mtJ = new byte[0];
    mtK = (IListener)new a();
    EventCenter.instance.add(mtK);
    AppMethodBeat.o(263534);
  }
  
  public static void G(String paramString, long paramLong)
  {
    AppMethodBeat.i(263529);
    p.k(paramString, "url");
    synchronized (mtJ)
    {
      Log.i("MicroMsg.MsgSubscriptionVoicePlayer", "[play] id[" + paramLong + "]  url[" + paramString + ']');
      if (mtH.isEmpty())
      {
        ((Map)mtH).put(Long.valueOf(paramLong), paramString);
        H(paramString, paramLong);
        paramString = x.aazN;
        AppMethodBeat.o(263529);
        return;
      }
      ((Map)mtH).put(Long.valueOf(paramLong), paramString);
    }
  }
  
  public static void GY(long paramLong)
  {
    AppMethodBeat.i(263531);
    for (;;)
    {
      synchronized (mtJ)
      {
        mtH.remove(Long.valueOf(paramLong));
        Object localObject1 = mtI.entrySet().iterator();
        if (((Iterator)localObject1).hasNext())
        {
          Object localObject4 = (Map.Entry)((Iterator)localObject1).next();
          if (((Number)((Map.Entry)localObject4).getValue()).longValue() != paramLong) {
            continue;
          }
          localObject1 = (String)((Map.Entry)localObject4).getKey();
          localObject4 = (CharSequence)localObject1;
          if (localObject4 == null) {
            break label159;
          }
          if (((CharSequence)localObject4).length() == 0)
          {
            break label159;
            if (i == 0)
            {
              c.Tm((String)localObject1);
              c.Tn((String)localObject1);
            }
            localObject1 = x.aazN;
            AppMethodBeat.o(263531);
            return;
          }
          i = 0;
        }
      }
      Object localObject3 = null;
      continue;
      label159:
      int i = 1;
    }
  }
  
  private static void H(String paramString, long paramLong)
  {
    AppMethodBeat.i(263533);
    Log.i("MicroMsg.MsgSubscriptionVoicePlayer", "[innerPlay] id[" + paramLong + "]  url[" + paramString + ']');
    com.tencent.mm.al.b localb = new com.tencent.mm.al.b();
    String str = c.be(mtL.hashCode(), h.fcQ());
    Map localMap = mtI;
    p.j(str, "it");
    localMap.put(str, Long.valueOf(paramLong));
    localb.fmF = str;
    localb.fnV = paramString;
    localb.lzI = true;
    c.l(localb);
    AppMethodBeat.o(263533);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/msgsubscription/voice/MsgSubscriptionVoicePlayHelperMM$mAudioPlayerEventListener$1", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/AudioPlayerEvent;", "callback", "", "event", "wxbiz-msgsubscription-sdk_release"})
  public static final class a
    extends IListener<z>
  {
    private static boolean m(z paramz)
    {
      AppMethodBeat.i(263593);
      if (paramz == null)
      {
        AppMethodBeat.o(263593);
        return false;
      }
      switch (paramz.fvC.action)
      {
      }
      for (;;)
      {
        AppMethodBeat.o(263593);
        return false;
        ??? = b.mtL;
        synchronized (b.bsN())
        {
          Object localObject2 = b.mtL;
          localObject2 = (Long)b.bsO().get(paramz.fvC.fmF);
          c.Tn(paramz.fvC.fmF);
          if (localObject2 != null)
          {
            b localb = b.mtL;
            b.bsP().remove(localObject2);
          }
          Log.i("MicroMsg.MsgSubscriptionVoicePlayer", "[player event] action[" + paramz.fvC.action + "]  id[" + localObject2 + ']');
          paramz = b.mtL;
          if (b.bsP().entrySet().size() > 0)
          {
            paramz = new StringBuilder("[player event] play next audio, waiting to play size[");
            localObject2 = b.mtL;
            Log.i("MicroMsg.MsgSubscriptionVoicePlayer", b.bsP().size() + ']');
            paramz = b.mtL;
            paramz = b.bsP().entrySet();
            p.j(paramz, "urlsToPlay.entries");
            paramz = j.e((Iterable)paramz);
            p.j(paramz, "urlsToPlay.entries.first()");
            paramz = (Map.Entry)paramz;
            localObject2 = b.mtL;
            localObject2 = paramz.getValue();
            p.j(localObject2, "first.value");
            localObject2 = (String)localObject2;
            paramz = paramz.getKey();
            p.j(paramz, "first.key");
            b.I((String)localObject2, ((Number)paramz).longValue());
          }
          paramz = x.aazN;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.msgsubscription.voice.b
 * JD-Core Version:    0.7.0.1
 */