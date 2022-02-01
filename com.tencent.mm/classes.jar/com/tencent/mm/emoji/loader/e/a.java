package com.tencent.mm.emoji.loader.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.emoji.loader.d.i;
import com.tencent.mm.storage.emotion.EmojiInfo;
import d.g.a.b;
import d.y;

@d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/emoji/loader/task/EmojiCoverTask;", "Lcom/tencent/mm/emoji/loader/task/IEmojiLoadTask;", "Ljava/lang/Runnable;", "emojiInfo", "Lcom/tencent/mm/storage/emotion/EmojiInfo;", "(Lcom/tencent/mm/storage/emotion/EmojiInfo;)V", "dependRequest", "Lcom/tencent/mm/emoji/loader/request/Request;", "taskKey", "", "getTaskKey", "onResult", "", "success", "", "run", "plugin-emojisdk_release"})
public final class a
  extends c
  implements Runnable
{
  private final String fMp;
  private i<?> fMq;
  
  public a(EmojiInfo paramEmojiInfo)
  {
    super(paramEmojiInfo);
    AppMethodBeat.i(105476);
    this.fMp = (paramEmojiInfo.JS() + "_cover");
    AppMethodBeat.o(105476);
  }
  
  public final String abh()
  {
    return this.fMp;
  }
  
  public final void df(boolean paramBoolean)
  {
    AppMethodBeat.i(105475);
    i locali = this.fMq;
    if (locali != null) {
      locali.cancel();
    }
    super.df(paramBoolean);
    AppMethodBeat.o(105475);
  }
  
  public final void run()
  {
    AppMethodBeat.i(105474);
    super.run();
    this.fMq = new com.tencent.mm.emoji.loader.c.c().a(this.fLP, (b)new a(this));
    AppMethodBeat.o(105474);
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "it", "", "invoke"})
  static final class a
    extends d.g.b.l
    implements b<Boolean, y>
  {
    a(a parama)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.emoji.loader.e.a
 * JD-Core Version:    0.7.0.1
 */