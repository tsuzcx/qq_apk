package com.tencent.mm.emoji.loader.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.emoji.loader.c.h;
import com.tencent.mm.emoji.loader.e;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.storage.emotion.EmojiInfo;
import d.g.b.p;
import d.g.b.q;
import d.l;
import d.z;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/emoji/loader/task/EmojiLoadTask;", "Lcom/tencent/mm/emoji/loader/task/IEmojiLoadTask;", "emojiInfo", "Lcom/tencent/mm/storage/emotion/EmojiInfo;", "(Lcom/tencent/mm/storage/emotion/EmojiInfo;)V", "TAG", "", "getTAG", "()Ljava/lang/String;", "checkCache", "", "getTaskKey", "run", "", "plugin-emojisdk_release"})
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
  
  public final String aeV()
  {
    AppMethodBeat.i(105478);
    String str = this.glt.Lj();
    p.g(str, "emojiInfo.md5");
    AppMethodBeat.o(105478);
    return str;
  }
  
  public final void run()
  {
    AppMethodBeat.i(105479);
    super.run();
    if (this.glt.fxn())
    {
      dg(true);
      AppMethodBeat.o(105479);
      return;
    }
    Object localObject = e.gkR;
    if (e.aeN())
    {
      ae.w(this.TAG, this.glt.Lj() + ": mock download fail");
      dg(false);
      AppMethodBeat.o(105479);
      return;
    }
    localObject = h.glA;
    h.d(this.glt, (d.g.a.b)new a(this));
    AppMethodBeat.o(105479);
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "", "invoke"})
  static final class a
    extends q
    implements d.g.a.b<Boolean, z>
  {
    a(b paramb)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.emoji.loader.e.b
 * JD-Core Version:    0.7.0.1
 */