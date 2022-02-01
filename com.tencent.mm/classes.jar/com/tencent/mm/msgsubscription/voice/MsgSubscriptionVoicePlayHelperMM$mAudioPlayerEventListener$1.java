package com.tencent.mm.msgsubscription.voice;

import androidx.lifecycle.q;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.c;
import com.tencent.mm.app.f;
import com.tencent.mm.autogen.a.ac;
import com.tencent.mm.autogen.a.ac.a;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import kotlin.Metadata;
import kotlin.a.p;
import kotlin.ah;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"com/tencent/mm/msgsubscription/voice/MsgSubscriptionVoicePlayHelperMM$mAudioPlayerEventListener$1", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/AudioPlayerEvent;", "callback", "", "event", "wxbiz-msgsubscription-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class MsgSubscriptionVoicePlayHelperMM$mAudioPlayerEventListener$1
  extends IListener<ac>
{
  MsgSubscriptionVoicePlayHelperMM$mAudioPlayerEventListener$1(f paramf)
  {
    super((q)paramf);
    AppMethodBeat.i(236460);
    AppMethodBeat.o(236460);
  }
  
  private static boolean m(ac paramac)
  {
    AppMethodBeat.i(236475);
    s.u(paramac, "event");
    switch (paramac.hzX.action)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(236475);
      return false;
      synchronized (b.bQv())
      {
        Object localObject = (Long)b.bQw().get(paramac.hzX.hqQ);
        c.Lp(paramac.hzX.hqQ);
        if (localObject != null) {
          b.bQx().remove(localObject);
        }
        Log.i("MicroMsg.MsgSubscriptionVoicePlayer", "[player event] action[" + paramac.hzX.action + "]  id[" + localObject + ']');
        if (b.bQx().entrySet().size() > 0)
        {
          Log.i("MicroMsg.MsgSubscriptionVoicePlayer", "[player event] play next audio, waiting to play size[" + b.bQx().size() + ']');
          paramac = b.bQx().entrySet();
          s.s(paramac, "urlsToPlay.entries");
          paramac = p.e((Iterable)paramac);
          s.s(paramac, "urlsToPlay.entries.first()");
          paramac = (Map.Entry)paramac;
          localObject = b.pmZ;
          localObject = paramac.getValue();
          s.s(localObject, "first.value");
          localObject = (String)localObject;
          paramac = paramac.getKey();
          s.s(paramac, "first.key");
          b.M((String)localObject, ((Number)paramac).longValue());
          paramac = ah.aiuX;
          continue;
        }
        paramac = b.pmZ;
        b.bQy();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.msgsubscription.voice.MsgSubscriptionVoicePlayHelperMM.mAudioPlayerEventListener.1
 * JD-Core Version:    0.7.0.1
 */