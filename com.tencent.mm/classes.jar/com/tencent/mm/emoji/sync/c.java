package com.tencent.mm.emoji.sync;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.storage.emotion.EmojiInfo;
import d.g.a.b;
import d.g.b.p;
import d.g.b.q;
import d.l;
import d.z;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/emoji/sync/EmojiDownLoadTask;", "Lcom/tencent/mm/loader/loader/IWorkTask;", "emojiInfo", "Lcom/tencent/mm/storage/emotion/EmojiInfo;", "(Lcom/tencent/mm/storage/emotion/EmojiInfo;)V", "getEmojiInfo", "()Lcom/tencent/mm/storage/emotion/EmojiInfo;", "call", "", "checkUpdate", "uniqueId", "", "Companion", "plugin-emojisdk_release"})
public final class c
  extends com.tencent.mm.loader.g.c
{
  private static final String TAG = "MicroMsg.EmojiDownLoadTask";
  public static final c.a goV;
  final EmojiInfo gjb;
  
  static
  {
    AppMethodBeat.i(105734);
    goV = new c.a((byte)0);
    TAG = "MicroMsg.EmojiDownLoadTask";
    AppMethodBeat.o(105734);
  }
  
  public c(EmojiInfo paramEmojiInfo)
  {
    AppMethodBeat.i(105733);
    this.gjb = paramEmojiInfo;
    AppMethodBeat.o(105733);
  }
  
  public final String aeK()
  {
    AppMethodBeat.i(105732);
    String str = this.gjb.Lb();
    p.g(str, "emojiInfo.md5");
    AppMethodBeat.o(105732);
    return str;
  }
  
  public final void call()
  {
    AppMethodBeat.i(105731);
    new com.tencent.mm.emoji.loader.c.c().a(this.gjb, (b)new b(this));
    AppMethodBeat.o(105731);
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "", "invoke"})
  static final class b
    extends q
    implements b<Boolean, z>
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