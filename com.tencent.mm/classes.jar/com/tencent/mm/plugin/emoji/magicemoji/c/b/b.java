package com.tencent.mm.plugin.emoji.magicemoji.c.b;

import com.tencent.luggage.l.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ad.i;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/emoji/magicemoji/jsapi/event/MagicEmojiJsEventUnity;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandJsApiEvent;", "event", "Lcom/tencent/mm/plugin/emoji/magicemoji/jsapi/event/MagicEmojiJsEventUnity$IUnityEvent;", "(Lcom/tencent/mm/plugin/emoji/magicemoji/jsapi/event/MagicEmojiJsEventUnity$IUnityEvent;)V", "getEvent", "()Lcom/tencent/mm/plugin/emoji/magicemoji/jsapi/event/MagicEmojiJsEventUnity$IUnityEvent;", "publish", "", "component", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponent;", "toData", "", "Companion", "IUnityEvent", "UnityEventClear", "UnityEventOnDarkModeChange", "UnityEventOnEasterEggForceStop", "UnityEventOnEasterEggGiftClick", "UnityEventOnEasterEggPlayAnimation", "plugin-magic-emoji_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
  extends com.tencent.mm.plugin.appbrand.jsapi.s
{
  public static final int CTRL_INDEX = -2;
  public static final String NAME = "UnityEvent";
  public static final b.a xJq;
  private static final HashMap<String, Object> xJs;
  private final b xJr;
  
  static
  {
    AppMethodBeat.i(270213);
    xJq = new b.a((byte)0);
    xJs = new HashMap();
    AppMethodBeat.o(270213);
  }
  
  public b(b paramb)
  {
    AppMethodBeat.i(270199);
    this.xJr = paramb;
    AppMethodBeat.o(270199);
  }
  
  public final String dyV()
  {
    AppMethodBeat.i(270224);
    Object localObject = new HashMap();
    ((HashMap)localObject).put("event", this.xJr.getName());
    ((HashMap)localObject).put("param", this.xJr.dyX());
    d.k((Map)localObject);
    localObject = new i((Map)localObject).toString();
    kotlin.g.b.s.s(localObject, "JSONObject(map).toString()");
    AppMethodBeat.o(270224);
    return localObject;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/emoji/magicemoji/jsapi/event/MagicEmojiJsEventUnity$IUnityEvent;", "", "generateParams", "", "", "getName", "plugin-magic-emoji_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static abstract interface b
  {
    public abstract Map<String, Object> dyX();
    
    public abstract String getName();
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/emoji/magicemoji/jsapi/event/MagicEmojiJsEventUnity$UnityEventClear;", "Lcom/tencent/mm/plugin/emoji/magicemoji/jsapi/event/MagicEmojiJsEventUnity$IUnityEvent;", "()V", "generateParams", "Ljava/util/HashMap;", "", "", "Lkotlin/collections/HashMap;", "getName", "plugin-magic-emoji_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class c
    implements b.b
  {
    public final String getName()
    {
      return "clearAllVFX";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.magicemoji.c.b.b
 * JD-Core Version:    0.7.0.1
 */