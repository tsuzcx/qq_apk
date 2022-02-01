package com.tencent.mm.plugin.emoji.magicemoji.c.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.emoji.magicemoji.core.d;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.a;
import kotlin.g.b.u;
import org.json.JSONObject;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/emoji/magicemoji/jsapi/api/MagicEmojiAsyncJsApiStubBase;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandAsyncJsApi;", "Lcom/tencent/mm/plugin/emoji/magicemoji/core/MagicEmojiService;", "()V", "type", "", "getType", "()I", "invoke", "", "env", "data", "Lorg/json/JSONObject;", "callbackId", "Companion", "plugin-magic-emoji_release"}, k=1, mv={1, 5, 1}, xi=48)
public class m
  extends c<d>
{
  public static final a xJl;
  private final int type;
  
  static
  {
    AppMethodBeat.i(270247);
    xJl = new a((byte)0);
    AppMethodBeat.o(270247);
  }
  
  public int getType()
  {
    return this.type;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/emoji/magicemoji/jsapi/api/MagicEmojiAsyncJsApiStubBase$Companion;", "", "()V", "TAG", "", "plugin-magic-emoji_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements a<ah>
  {
    b(long paramLong, m paramm, JSONObject paramJSONObject, d paramd, int paramInt)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.magicemoji.c.a.m
 * JD-Core Version:    0.7.0.1
 */