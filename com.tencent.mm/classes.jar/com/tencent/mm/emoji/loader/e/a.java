package com.tencent.mm.emoji.loader.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.emoji.loader.d.i;
import com.tencent.mm.storage.emotion.EmojiInfo;
import d.g.a.b;
import d.l;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/emoji/loader/task/EmojiCoverTask;", "Lcom/tencent/mm/emoji/loader/task/IEmojiLoadTask;", "Ljava/lang/Runnable;", "emojiInfo", "Lcom/tencent/mm/storage/emotion/EmojiInfo;", "(Lcom/tencent/mm/storage/emotion/EmojiInfo;)V", "dependRequest", "Lcom/tencent/mm/emoji/loader/request/Request;", "taskKey", "", "getTaskKey", "onResult", "", "success", "", "run", "plugin-emojisdk_release"})
public final class a
  extends c
  implements Runnable
{
  private final String fQb;
  private i<?> fQc;
  
  public a(EmojiInfo paramEmojiInfo)
  {
    super(paramEmojiInfo);
    AppMethodBeat.i(105476);
    this.fQb = (paramEmojiInfo.JC() + "_cover");
    AppMethodBeat.o(105476);
  }
  
  public final String acf()
  {
    return this.fQb;
  }
  
  public final void de(boolean paramBoolean)
  {
    AppMethodBeat.i(105475);
    i locali = this.fQc;
    if (locali != null) {
      locali.cancel();
    }
    super.de(paramBoolean);
    AppMethodBeat.o(105475);
  }
  
  public final void run()
  {
    AppMethodBeat.i(105474);
    super.run();
    this.fQc = new com.tencent.mm.emoji.loader.c.c().a(this.fPB, (b)new a.a(this));
    AppMethodBeat.o(105474);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.emoji.loader.e.a
 * JD-Core Version:    0.7.0.1
 */