package com.tencent.mm.emoji.loader.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.emoji.loader.d.i;
import com.tencent.mm.storage.emotion.EmojiInfo;
import d.g.a.b;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/emoji/loader/task/EmojiCoverTask;", "Lcom/tencent/mm/emoji/loader/task/IEmojiLoadTask;", "Ljava/lang/Runnable;", "emojiInfo", "Lcom/tencent/mm/storage/emotion/EmojiInfo;", "(Lcom/tencent/mm/storage/emotion/EmojiInfo;)V", "dependRequest", "Lcom/tencent/mm/emoji/loader/request/Request;", "taskKey", "", "getTaskKey", "onResult", "", "success", "", "run", "plugin-emojisdk_release"})
public final class a
  extends c
  implements Runnable
{
  private final String gjB;
  private i<?> gjC;
  
  public a(EmojiInfo paramEmojiInfo)
  {
    super(paramEmojiInfo);
    AppMethodBeat.i(105476);
    this.gjB = (paramEmojiInfo.Lb() + "_cover");
    AppMethodBeat.o(105476);
  }
  
  public final String aeJ()
  {
    return this.gjB;
  }
  
  public final void dg(boolean paramBoolean)
  {
    AppMethodBeat.i(105475);
    i locali = this.gjC;
    if (locali != null) {
      locali.cancel();
    }
    super.dg(paramBoolean);
    AppMethodBeat.o(105475);
  }
  
  public final void run()
  {
    AppMethodBeat.i(105474);
    super.run();
    this.gjC = new com.tencent.mm.emoji.loader.c.c().a(this.gjb, (b)new a.a(this));
    AppMethodBeat.o(105474);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.emoji.loader.e.a
 * JD-Core Version:    0.7.0.1
 */