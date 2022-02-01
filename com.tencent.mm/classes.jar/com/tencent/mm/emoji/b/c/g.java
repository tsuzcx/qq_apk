package com.tencent.mm.emoji.b.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.storage.emotion.EmojiInfo;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.b;
import kotlin.g.a.m;
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/emoji/loader/fetcher/FetcherFactory;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "fetch", "", "emojiInfo", "Lcom/tencent/mm/storage/emotion/EmojiInfo;", "callback", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "success", "plugin-emojisdk_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class g
{
  private static final String TAG;
  public static final g mgQ;
  
  static
  {
    AppMethodBeat.i(105443);
    mgQ = new g();
    TAG = "MicroMsg.EmojiLoader.FetcherFactory";
    AppMethodBeat.o(105443);
  }
  
  public static void c(EmojiInfo paramEmojiInfo, final b<? super Boolean, ah> paramb)
  {
    AppMethodBeat.i(105442);
    s.u(paramEmojiInfo, "emojiInfo");
    new f(paramEmojiInfo, (m)new a(paramEmojiInfo, paramb));
    AppMethodBeat.o(105442);
  }
  
  public static String getTAG()
  {
    return TAG;
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "success", "", "config", "Lcom/tencent/mm/emoji/loader/fetcher/EmojiFetcherConfig;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends u
    implements m<Boolean, e, ah>
  {
    a(EmojiInfo paramEmojiInfo, b<? super Boolean, ah> paramb)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.emoji.b.c.g
 * JD-Core Version:    0.7.0.1
 */