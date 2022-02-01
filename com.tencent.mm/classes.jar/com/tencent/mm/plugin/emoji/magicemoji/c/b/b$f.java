package com.tencent.mm.plugin.emoji.magicemoji.c.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/emoji/magicemoji/jsapi/event/MagicEmojiJsEventUnity$UnityEventOnEasterEggPlayAnimation;", "Lcom/tencent/mm/plugin/emoji/magicemoji/jsapi/event/MagicEmojiJsEventUnity$IUnityEvent;", "eggKey", "", "eggId", "sceneId", "clickable", "", "keyword", "messageLocalId", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;J)V", "generateParams", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "getName", "plugin-magic-emoji_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b$f
  implements b.b
{
  private final String hAB;
  private final boolean sdN;
  private final long xHX;
  private final String xIa;
  private final String xIb;
  private final String xIc;
  
  public b$f(String paramString1, String paramString2, String paramString3, boolean paramBoolean, String paramString4, long paramLong)
  {
    AppMethodBeat.i(270231);
    this.xIa = paramString1;
    this.xIb = paramString2;
    this.xIc = paramString3;
    this.sdN = paramBoolean;
    this.hAB = paramString4;
    this.xHX = paramLong;
    AppMethodBeat.o(270231);
  }
  
  public final String getName()
  {
    return "onEasterEggPlayAnimation";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.magicemoji.c.b.b.f
 * JD-Core Version:    0.7.0.1
 */