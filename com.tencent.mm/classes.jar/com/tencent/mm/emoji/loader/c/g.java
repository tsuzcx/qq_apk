package com.tencent.mm.emoji.loader.c;

import a.f.a.b;
import a.f.a.m;
import a.f.b.j;
import a.l;
import a.y;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.storage.emotion.EmojiInfo;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/emoji/loader/fetcher/FetcherFactory;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "fetch", "", "emojiInfo", "Lcom/tencent/mm/storage/emotion/EmojiInfo;", "callback", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "success", "plugin-emojisdk_release"})
public final class g
{
  private static final String TAG = "MicroMsg.EmojiLoader.FetcherFactory";
  public static final g evO;
  
  static
  {
    AppMethodBeat.i(63193);
    evO = new g();
    TAG = "MicroMsg.EmojiLoader.FetcherFactory";
    AppMethodBeat.o(63193);
  }
  
  public static void a(EmojiInfo paramEmojiInfo, b<? super Boolean, y> paramb)
  {
    AppMethodBeat.i(63192);
    j.q(paramEmojiInfo, "emojiInfo");
    new e(paramEmojiInfo, (m)new g.a(paramEmojiInfo, paramb));
    AppMethodBeat.o(63192);
  }
  
  public static String getTAG()
  {
    return TAG;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.emoji.loader.c.g
 * JD-Core Version:    0.7.0.1
 */