package com.tencent.mm.emoji.b.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.emoji.b.c.g;
import com.tencent.mm.emoji.b.e;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.emotion.EmojiInfo;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/emoji/loader/task/EmojiLoadTask;", "Lcom/tencent/mm/emoji/loader/task/IEmojiLoadTask;", "emojiInfo", "Lcom/tencent/mm/storage/emotion/EmojiInfo;", "(Lcom/tencent/mm/storage/emotion/EmojiInfo;)V", "TAG", "", "getTAG", "()Ljava/lang/String;", "checkCache", "", "getTaskKey", "run", "", "plugin-emojisdk_release"}, k=1, mv={1, 5, 1}, xi=48)
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
  
  public final String aUD()
  {
    AppMethodBeat.i(105478);
    String str = this.mgK.getMd5();
    s.s(str, "emojiInfo.md5");
    AppMethodBeat.o(105478);
    return str;
  }
  
  public final void run()
  {
    AppMethodBeat.i(105479);
    super.run();
    if (this.mgK.kLZ())
    {
      onResult(true);
      AppMethodBeat.o(105479);
      return;
    }
    Object localObject = e.mgl;
    if (e.aUu())
    {
      Log.w(this.TAG, s.X(this.mgK.getMd5(), ": mock download fail"));
      onResult(false);
      AppMethodBeat.o(105479);
      return;
    }
    localObject = g.mgQ;
    g.c(this.mgK, (kotlin.g.a.b)new a(this));
    AppMethodBeat.o(105479);
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "it", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends u
    implements kotlin.g.a.b<Boolean, ah>
  {
    a(b paramb)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.emoji.b.e.b
 * JD-Core Version:    0.7.0.1
 */