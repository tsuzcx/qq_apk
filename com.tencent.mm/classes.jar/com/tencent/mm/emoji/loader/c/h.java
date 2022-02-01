package com.tencent.mm.emoji.loader.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.storage.emotion.EmojiInfo;
import d.g.a.b;
import d.g.a.m;
import d.g.b.k;
import d.y;

@d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/emoji/loader/fetcher/FetcherFactory;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "fetch", "", "emojiInfo", "Lcom/tencent/mm/storage/emotion/EmojiInfo;", "callback", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "success", "plugin-emojisdk_release"})
public final class h
{
  private static final String TAG = "MicroMsg.EmojiLoader.FetcherFactory";
  public static final h fLW;
  
  static
  {
    AppMethodBeat.i(105443);
    fLW = new h();
    TAG = "MicroMsg.EmojiLoader.FetcherFactory";
    AppMethodBeat.o(105443);
  }
  
  public static void d(EmojiInfo paramEmojiInfo, final b<? super Boolean, y> paramb)
  {
    AppMethodBeat.i(105442);
    k.h(paramEmojiInfo, "emojiInfo");
    new f(paramEmojiInfo, (m)new a(paramEmojiInfo, paramb));
    AppMethodBeat.o(105442);
  }
  
  public static String getTAG()
  {
    return TAG;
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "success", "", "config", "Lcom/tencent/mm/emoji/loader/fetcher/EmojiFetcherConfig;", "invoke"})
  static final class a
    extends d.g.b.l
    implements m<Boolean, e, y>
  {
    a(EmojiInfo paramEmojiInfo, b paramb)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.emoji.loader.c.h
 * JD-Core Version:    0.7.0.1
 */