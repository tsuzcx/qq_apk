package com.tencent.mm.plugin.emoji.magicemoji.c.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/emoji/magicemoji/jsapi/event/MagicEmojiJsEventUnity$UnityEventOnEasterEggForceStop;", "Lcom/tencent/mm/plugin/emoji/magicemoji/jsapi/event/MagicEmojiJsEventUnity$IUnityEvent;", "eggKey", "", "eggId", "sceneId", "stopReason", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)V", "generateParams", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "getName", "plugin-magic-emoji_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b$d
  implements b.b
{
  private final String xIa;
  private final String xIb;
  private final String xIc;
  private final int xJt;
  
  public b$d(String paramString1, String paramString2, String paramString3, int paramInt)
  {
    AppMethodBeat.i(270197);
    this.xIa = paramString1;
    this.xIb = paramString2;
    this.xIc = paramString3;
    this.xJt = paramInt;
    AppMethodBeat.o(270197);
  }
  
  public final String getName()
  {
    return "onEasterEggForceStop";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.magicemoji.c.b.b.d
 * JD-Core Version:    0.7.0.1
 */