package com.tencent.mm.emoji.loader.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.storage.emotion.EmojiInfo;
import kotlin.g.a.b;
import kotlin.g.a.m;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/emoji/loader/fetcher/FetcherFactory;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "fetch", "", "emojiInfo", "Lcom/tencent/mm/storage/emotion/EmojiInfo;", "callback", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "success", "plugin-emojisdk_release"})
public final class h
{
  private static final String TAG = "MicroMsg.EmojiLoader.FetcherFactory";
  public static final h gWs;
  
  static
  {
    AppMethodBeat.i(105443);
    gWs = new h();
    TAG = "MicroMsg.EmojiLoader.FetcherFactory";
    AppMethodBeat.o(105443);
  }
  
  public static void d(EmojiInfo paramEmojiInfo, final b<? super Boolean, x> paramb)
  {
    AppMethodBeat.i(105442);
    p.h(paramEmojiInfo, "emojiInfo");
    new f(paramEmojiInfo, (m)new a(paramEmojiInfo, paramb));
    AppMethodBeat.o(105442);
  }
  
  public static String getTAG()
  {
    return TAG;
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "success", "", "config", "Lcom/tencent/mm/emoji/loader/fetcher/EmojiFetcherConfig;", "invoke"})
  static final class a
    extends q
    implements m<Boolean, e, x>
  {
    a(EmojiInfo paramEmojiInfo, b paramb)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.emoji.loader.c.h
 * JD-Core Version:    0.7.0.1
 */