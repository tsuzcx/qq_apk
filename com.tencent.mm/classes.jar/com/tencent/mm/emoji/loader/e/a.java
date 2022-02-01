package com.tencent.mm.emoji.loader.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.emoji.loader.d.i;
import com.tencent.mm.storage.emotion.EmojiInfo;
import kotlin.g.a.b;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/emoji/loader/task/EmojiCoverTask;", "Lcom/tencent/mm/emoji/loader/task/IEmojiLoadTask;", "Ljava/lang/Runnable;", "emojiInfo", "Lcom/tencent/mm/storage/emotion/EmojiInfo;", "(Lcom/tencent/mm/storage/emotion/EmojiInfo;)V", "dependRequest", "Lcom/tencent/mm/emoji/loader/request/Request;", "taskKey", "", "getTaskKey", "onResult", "", "success", "", "run", "plugin-emojisdk_release"})
public final class a
  extends c
  implements Runnable
{
  private final String gWK;
  private i<?> gWL;
  
  public a(EmojiInfo paramEmojiInfo)
  {
    super(paramEmojiInfo);
    AppMethodBeat.i(105476);
    this.gWK = (paramEmojiInfo.getMd5() + "_cover");
    AppMethodBeat.o(105476);
  }
  
  public final String auJ()
  {
    return this.gWK;
  }
  
  public final void dQ(boolean paramBoolean)
  {
    AppMethodBeat.i(105475);
    i locali = this.gWL;
    if (locali != null) {
      locali.cancel();
    }
    super.dQ(paramBoolean);
    AppMethodBeat.o(105475);
  }
  
  public final void run()
  {
    AppMethodBeat.i(105474);
    super.run();
    this.gWL = new com.tencent.mm.emoji.loader.c.c().a(this.gWm, (b)new a(this));
    AppMethodBeat.o(105474);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "", "invoke"})
  static final class a
    extends q
    implements b<Boolean, x>
  {
    a(a parama)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.emoji.loader.e.a
 * JD-Core Version:    0.7.0.1
 */