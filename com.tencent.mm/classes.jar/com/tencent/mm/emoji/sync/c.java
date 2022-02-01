package com.tencent.mm.emoji.sync;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.storage.emotion.EmojiInfo;
import d.g.a.b;
import d.g.b.k;
import d.y;

@d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/emoji/sync/EmojiDownLoadTask;", "Lcom/tencent/mm/loader/loader/IWorkTask;", "emojiInfo", "Lcom/tencent/mm/storage/emotion/EmojiInfo;", "(Lcom/tencent/mm/storage/emotion/EmojiInfo;)V", "getEmojiInfo", "()Lcom/tencent/mm/storage/emotion/EmojiInfo;", "call", "", "checkUpdate", "uniqueId", "", "Companion", "plugin-emojisdk_release"})
public final class c
  extends com.tencent.mm.loader.g.c
{
  private static final String TAG = "MicroMsg.EmojiDownLoadTask";
  public static final c.a fVs;
  final EmojiInfo fPB;
  
  static
  {
    AppMethodBeat.i(105734);
    fVs = new c.a((byte)0);
    TAG = "MicroMsg.EmojiDownLoadTask";
    AppMethodBeat.o(105734);
  }
  
  public c(EmojiInfo paramEmojiInfo)
  {
    AppMethodBeat.i(105733);
    this.fPB = paramEmojiInfo;
    AppMethodBeat.o(105733);
  }
  
  public final String acg()
  {
    AppMethodBeat.i(105732);
    String str = this.fPB.JC();
    k.g(str, "emojiInfo.md5");
    AppMethodBeat.o(105732);
    return str;
  }
  
  public final void call()
  {
    AppMethodBeat.i(105731);
    new com.tencent.mm.emoji.loader.c.c().a(this.fPB, (b)new b(this));
    AppMethodBeat.o(105731);
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "it", "", "invoke"})
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.emoji.sync.c
 * JD-Core Version:    0.7.0.1
 */