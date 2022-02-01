package com.tencent.mm.emoji.sync;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.storage.emotion.EmojiInfo;
import d.g.a.b;
import d.g.b.k;
import d.y;

@d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/emoji/sync/EmojiDownLoadTask;", "Lcom/tencent/mm/loader/loader/IWorkTask;", "emojiInfo", "Lcom/tencent/mm/storage/emotion/EmojiInfo;", "(Lcom/tencent/mm/storage/emotion/EmojiInfo;)V", "getEmojiInfo", "()Lcom/tencent/mm/storage/emotion/EmojiInfo;", "call", "", "checkUpdate", "uniqueId", "", "Companion", "plugin-emojisdk_release"})
public final class c
  extends com.tencent.mm.loader.g.c
{
  private static final String TAG = "MicroMsg.EmojiDownLoadTask";
  public static final a fRx;
  final EmojiInfo fLP;
  
  static
  {
    AppMethodBeat.i(105734);
    fRx = new a((byte)0);
    TAG = "MicroMsg.EmojiDownLoadTask";
    AppMethodBeat.o(105734);
  }
  
  public c(EmojiInfo paramEmojiInfo)
  {
    AppMethodBeat.i(105733);
    this.fLP = paramEmojiInfo;
    AppMethodBeat.o(105733);
  }
  
  public final String abi()
  {
    AppMethodBeat.i(105732);
    String str = this.fLP.JS();
    k.g(str, "emojiInfo.md5");
    AppMethodBeat.o(105732);
    return str;
  }
  
  public final void call()
  {
    AppMethodBeat.i(105731);
    new com.tencent.mm.emoji.loader.c.c().a(this.fLP, (b)new b(this));
    AppMethodBeat.o(105731);
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/emoji/sync/EmojiDownLoadTask$Companion;", "", "()V", "TAG", "", "plugin-emojisdk_release"})
  public static final class a {}
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "it", "", "invoke"})
  static final class b
    extends d.g.b.l
    implements b<Boolean, y>
  {
    b(c paramc)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.emoji.sync.c
 * JD-Core Version:    0.7.0.1
 */