package com.tencent.mm.emoji.loader.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.emoji.loader.c.h;
import com.tencent.mm.emoji.loader.e;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.emotion.EmojiInfo;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/emoji/loader/task/EmojiLoadTask;", "Lcom/tencent/mm/emoji/loader/task/IEmojiLoadTask;", "emojiInfo", "Lcom/tencent/mm/storage/emotion/EmojiInfo;", "(Lcom/tencent/mm/storage/emotion/EmojiInfo;)V", "TAG", "", "getTAG", "()Ljava/lang/String;", "checkCache", "", "getTaskKey", "run", "", "plugin-emojisdk_release"})
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
  
  public final String auJ()
  {
    AppMethodBeat.i(105478);
    String str = this.gWm.getMd5();
    p.g(str, "emojiInfo.md5");
    AppMethodBeat.o(105478);
    return str;
  }
  
  public final void run()
  {
    AppMethodBeat.i(105479);
    super.run();
    if (this.gWm.hRx())
    {
      dQ(true);
      AppMethodBeat.o(105479);
      return;
    }
    Object localObject = e.gVM;
    if (e.auB())
    {
      Log.w(this.TAG, this.gWm.getMd5() + ": mock download fail");
      dQ(false);
      AppMethodBeat.o(105479);
      return;
    }
    localObject = h.gWs;
    h.d(this.gWm, (kotlin.g.a.b)new a(this));
    AppMethodBeat.o(105479);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "", "invoke"})
  static final class a
    extends q
    implements kotlin.g.a.b<Boolean, x>
  {
    a(b paramb)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.emoji.loader.e.b
 * JD-Core Version:    0.7.0.1
 */