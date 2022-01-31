package com.tencent.mm.emoji.loader.e;

import a.f.b.j;
import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.emoji.loader.c.g;
import com.tencent.mm.storage.emotion.EmojiInfo;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/emoji/loader/task/EmojiLoadTask;", "Lcom/tencent/mm/emoji/loader/task/IEmojiLoadTask;", "emojiInfo", "Lcom/tencent/mm/storage/emotion/EmojiInfo;", "(Lcom/tencent/mm/storage/emotion/EmojiInfo;)V", "TAG", "", "getTAG", "()Ljava/lang/String;", "checkCache", "", "getTaskKey", "run", "", "plugin-emojisdk_release"})
public final class b
  extends c
{
  final String TAG;
  
  public b(EmojiInfo paramEmojiInfo)
  {
    super(paramEmojiInfo);
    AppMethodBeat.i(63224);
    this.TAG = "MicroMsg.EmojiLoadTask";
    AppMethodBeat.o(63224);
  }
  
  public final String Ox()
  {
    AppMethodBeat.i(63222);
    String str = this.evH.Al();
    j.p(str, "emojiInfo.md5");
    AppMethodBeat.o(63222);
    return str;
  }
  
  public final void run()
  {
    AppMethodBeat.i(63223);
    super.run();
    if (this.evH.dzn())
    {
      cd(true);
      AppMethodBeat.o(63223);
      return;
    }
    g localg = g.evO;
    g.a(this.evH, (a.f.a.b)new b.a(this));
    AppMethodBeat.o(63223);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.emoji.loader.e.b
 * JD-Core Version:    0.7.0.1
 */