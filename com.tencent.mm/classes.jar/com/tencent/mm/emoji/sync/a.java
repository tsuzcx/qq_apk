package com.tencent.mm.emoji.sync;

import a.f.b.j;
import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.emoji.decode.MMGIFJNIFactory;
import com.tencent.mm.emoji.decode.MMGIFJNIFactory.Companion;
import com.tencent.mm.emoji.loader.c.g;
import com.tencent.mm.loader.g.c;
import com.tencent.mm.loader.g.h;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.storage.at;
import com.tencent.mm.storage.emotion.EmojiInfo;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/emoji/sync/EmojiDownLoadTask;", "Lcom/tencent/mm/loader/loader/IWorkTask;", "emojiInfo", "Lcom/tencent/mm/storage/emotion/EmojiInfo;", "(Lcom/tencent/mm/storage/emotion/EmojiInfo;)V", "getEmojiInfo", "()Lcom/tencent/mm/storage/emotion/EmojiInfo;", "call", "", "checkUpdate", "uniqueId", "", "Companion", "plugin-emojisdk_release"})
public final class a
  extends c
{
  private static final String TAG = "MicroMsg.EmojiDownLoadTask";
  public static final a.a exu;
  final EmojiInfo evH;
  
  static
  {
    AppMethodBeat.i(63257);
    exu = new a.a((byte)0);
    TAG = "MicroMsg.EmojiDownLoadTask";
    AppMethodBeat.o(63257);
  }
  
  public a(EmojiInfo paramEmojiInfo)
  {
    AppMethodBeat.i(63256);
    this.evH = paramEmojiInfo;
    AppMethodBeat.o(63256);
  }
  
  private final void Pc()
  {
    AppMethodBeat.i(63254);
    int i = 0;
    Object localObject1 = at.dxt();
    j.p(localObject1, "EmojiStorageMgr.getInstance()");
    localObject1 = ((at)localObject1).aUI().asP(this.evH.Al());
    if (localObject1 == null)
    {
      AppMethodBeat.o(63254);
      return;
    }
    if (((EmojiInfo)localObject1).getState() != EmojiInfo.yPu)
    {
      ((EmojiInfo)localObject1).setState(EmojiInfo.yPu);
      i = 1;
    }
    int j;
    Object localObject2;
    if (((EmojiInfo)localObject1).field_width > 0)
    {
      j = i;
      if (((EmojiInfo)localObject1).field_width > 0) {}
    }
    else
    {
      localObject2 = MMGIFJNIFactory.Companion.getDecoder((EmojiInfo)localObject1);
      if (MMGIFJNIFactory.Companion.isValid((com.tencent.mm.emoji.decode.b)localObject2))
      {
        ((EmojiInfo)localObject1).field_width = ((com.tencent.mm.emoji.decode.b)localObject2).Oq();
        ((EmojiInfo)localObject1).field_height = ((com.tencent.mm.emoji.decode.b)localObject2).Or();
        i = 1;
      }
      ((com.tencent.mm.emoji.decode.b)localObject2).destroy();
      j = i;
    }
    if (j != 0)
    {
      localObject2 = at.dxt();
      j.p(localObject2, "EmojiStorageMgr.getInstance()");
      ((at)localObject2).aUI().J((EmojiInfo)localObject1);
      if (j.e(this.evH.avS(), "capture")) {
        com.tencent.mm.emoji.a.d.Oz().cm(true);
      }
    }
    AppMethodBeat.o(63254);
  }
  
  public final String Oy()
  {
    AppMethodBeat.i(63255);
    String str = this.evH.Al();
    j.p(str, "emojiInfo.md5");
    AppMethodBeat.o(63255);
    return str;
  }
  
  public final void call()
  {
    AppMethodBeat.i(63253);
    if (this.evH.dzn())
    {
      ab.i(TAG, this + ' ' + this.evH.Al() + ": already load");
      Pc();
      a(h.ePv);
      AppMethodBeat.o(63253);
      return;
    }
    g localg = g.evO;
    g.a(this.evH, (a.f.a.b)new a.b(this));
    AppMethodBeat.o(63253);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.emoji.sync.a
 * JD-Core Version:    0.7.0.1
 */