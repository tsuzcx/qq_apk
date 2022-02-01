package com.tencent.mm.emoji.loader.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.emoji.loader.c.h;
import com.tencent.mm.emoji.loader.e;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.storage.emotion.EmojiInfo;
import d.g.b.k;
import d.y;

@d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/emoji/loader/task/EmojiLoadTask;", "Lcom/tencent/mm/emoji/loader/task/IEmojiLoadTask;", "emojiInfo", "Lcom/tencent/mm/storage/emotion/EmojiInfo;", "(Lcom/tencent/mm/storage/emotion/EmojiInfo;)V", "TAG", "", "getTAG", "()Ljava/lang/String;", "checkCache", "", "getTaskKey", "run", "", "plugin-emojisdk_release"})
public final class b
  extends c
{
  final String TAG;
  
  public b(EmojiInfo paramEmojiInfo)
  {
    super(paramEmojiInfo);
    AppMethodBeat.i(105480);
    this.TAG = "MicroMsg.EmojiLoadTask";
    AppMethodBeat.o(105480);
  }
  
  public final String acf()
  {
    AppMethodBeat.i(105478);
    String str = this.fPB.JC();
    k.g(str, "emojiInfo.md5");
    AppMethodBeat.o(105478);
    return str;
  }
  
  public final void run()
  {
    AppMethodBeat.i(105479);
    super.run();
    if (this.fPB.fdp())
    {
      de(true);
      AppMethodBeat.o(105479);
      return;
    }
    Object localObject = e.fOZ;
    if (e.abX())
    {
      ac.w(this.TAG, this.fPB.JC() + ": mock download fail");
      de(false);
      AppMethodBeat.o(105479);
      return;
    }
    localObject = h.fPI;
    h.d(this.fPB, (d.g.a.b)new a(this));
    AppMethodBeat.o(105479);
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "it", "", "invoke"})
  static final class a
    extends d.g.b.l
    implements d.g.a.b<Boolean, y>
  {
    a(b paramb)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.emoji.loader.e.b
 * JD-Core Version:    0.7.0.1
 */