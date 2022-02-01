package com.tencent.mm.msgsubscription.voice;

import android.content.Context;
import android.media.AudioManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.c;
import com.tencent.mm.app.f;
import com.tencent.mm.autogen.a.ac;
import com.tencent.mm.plugin.music.b.h;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/msgsubscription/voice/MsgSubscriptionVoicePlayHelperMM;", "", "()V", "GUARD", "", "audioIdMapToID", "", "", "", "audioManager", "Landroid/media/AudioManager;", "mAudioPlayerEventListener", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/AudioPlayerEvent;", "urlsToPlay", "Ljava/util/LinkedHashMap;", "Lkotlin/collections/LinkedHashMap;", "volumeToRestore", "", "adjustVolume", "", "innerPlay", "url", "id", "play", "restoreVolume", "stop", "wxbiz-msgsubscription-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
{
  private static final AudioManager audioManager;
  public static final b pmZ;
  private static final LinkedHashMap<Long, String> pna;
  private static final Map<String, Long> pnb;
  private static final byte[] pnc;
  private static int pnd;
  private static final IListener<ac> pne;
  
  static
  {
    AppMethodBeat.i(236549);
    pmZ = new b();
    pna = new LinkedHashMap();
    pnb = (Map)new LinkedHashMap();
    pnc = new byte[0];
    pnd = -1;
    Object localObject = MMApplicationContext.getContext().getSystemService("audio");
    if (localObject == null)
    {
      localObject = new NullPointerException("null cannot be cast to non-null type android.media.AudioManager");
      AppMethodBeat.o(236549);
      throw ((Throwable)localObject);
    }
    audioManager = (AudioManager)localObject;
    localObject = (IListener)new MsgSubscriptionVoicePlayHelperMM.mAudioPlayerEventListener.1(f.hfK);
    pne = (IListener)localObject;
    ((IListener)localObject).alive();
    AppMethodBeat.o(236549);
  }
  
  public static void K(String paramString, long paramLong)
  {
    AppMethodBeat.i(236485);
    s.u(paramString, "url");
    synchronized (pnc)
    {
      Log.i("MicroMsg.MsgSubscriptionVoicePlayer", "[play] id[" + paramLong + "]  url[" + paramString + ']');
      if (pna.isEmpty())
      {
        ((Map)pna).put(Long.valueOf(paramLong), paramString);
        L(paramString, paramLong);
        paramString = ah.aiuX;
        AppMethodBeat.o(236485);
        return;
      }
      ((Map)pna).put(Long.valueOf(paramLong), paramString);
    }
  }
  
  private static void L(String paramString, long paramLong)
  {
    AppMethodBeat.i(236499);
    Log.i("MicroMsg.MsgSubscriptionVoicePlayer", "[innerPlay] id[" + paramLong + "]  url[" + paramString + ']');
    com.tencent.mm.al.b localb = new com.tencent.mm.al.b();
    String str = c.bo(s.X("", Integer.valueOf(pmZ.hashCode())), h.glT());
    Object localObject = pnb;
    s.s(str, "it");
    ((Map)localObject).put(str, Long.valueOf(paramLong));
    localObject = ah.aiuX;
    localb.hqQ = str;
    localb.hsg = paramString;
    localb.orj = true;
    bQu();
    c.l(localb);
    AppMethodBeat.o(236499);
  }
  
  private static void bQu()
  {
    AppMethodBeat.i(236507);
    int i = audioManager.getStreamMaxVolume(3);
    int j = audioManager.getStreamVolume(3);
    if (j * 1.0F / i < 0.4D)
    {
      if (pnd == -1) {
        pnd = j;
      }
      audioManager.setStreamVolume(3, (int)(i * 0.4D), 5);
    }
    AppMethodBeat.o(236507);
  }
  
  public static void jj(long paramLong)
  {
    AppMethodBeat.i(236492);
    for (;;)
    {
      synchronized (pnc)
      {
        pna.remove(Long.valueOf(paramLong));
        Object localObject1 = pnb.entrySet().iterator();
        if (((Iterator)localObject1).hasNext())
        {
          Object localObject4 = (Map.Entry)((Iterator)localObject1).next();
          if (((Number)((Map.Entry)localObject4).getValue()).longValue() != paramLong) {
            continue;
          }
          localObject1 = (String)((Map.Entry)localObject4).getKey();
          localObject4 = (CharSequence)localObject1;
          if (localObject4 == null) {
            break label162;
          }
          if (((CharSequence)localObject4).length() == 0)
          {
            break label162;
            if (i == 0)
            {
              c.Lo((String)localObject1);
              c.Lp((String)localObject1);
            }
            localObject1 = ah.aiuX;
            AppMethodBeat.o(236492);
            return;
          }
          i = 0;
        }
      }
      Object localObject3 = null;
      continue;
      label162:
      int i = 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.msgsubscription.voice.b
 * JD-Core Version:    0.7.0.1
 */