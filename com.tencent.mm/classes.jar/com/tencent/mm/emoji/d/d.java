package com.tencent.mm.emoji.d;

import a.f.b.j;
import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.g.a.a;
import com.tencent.mm.loader.g.a.g;
import com.tencent.mm.loader.g.a.h;
import com.tencent.mm.loader.g.f;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.storage.at;
import com.tencent.mm.storage.emotion.EmojiInfo;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/emoji/upload/EmojiUploadManager;", "", "()V", "emojiCaptureUploadQueue", "Lcom/tencent/mm/loader/loader/LoaderCore;", "Lcom/tencent/mm/emoji/upload/EmojiCaptureUploadTask;", "uploadCallback", "com/tencent/mm/emoji/upload/EmojiUploadManager$uploadCallback$1", "Lcom/tencent/mm/emoji/upload/EmojiUploadManager$uploadCallback$1;", "addUploadTask", "", "emojiInfo", "Lcom/tencent/mm/storage/emotion/EmojiInfo;", "timeEnter", "", "plugin-emojisdk_release"})
public final class d
{
  private static final com.tencent.mm.loader.g.d<c> eyn;
  private static final d.a eyo;
  public static final d eyp;
  
  static
  {
    AppMethodBeat.i(63303);
    eyp = new d();
    eyn = new com.tencent.mm.loader.g.d((com.tencent.mm.loader.g.a.d)new g((com.tencent.mm.loader.g.a.c)new a(20), new h(1, (byte)0), 1, "EmojiUpload"));
    eyo = new d.a();
    eyn.a((f)eyo);
    AppMethodBeat.o(63303);
  }
  
  public static void ge(long paramLong)
  {
    AppMethodBeat.i(63302);
    ab.i(e.Ot(), "addUploadTask: ".concat(String.valueOf(paramLong)));
    Object localObject = at.dxt();
    j.p(localObject, "EmojiStorageMgr.getInstance()");
    EmojiInfo localEmojiInfo = ((at)localObject).aUI().or(paramLong);
    String str = e.Ot();
    StringBuilder localStringBuilder = new StringBuilder("addUploadTask: ");
    if (localEmojiInfo != null) {}
    for (localObject = localEmojiInfo.Al();; localObject = null)
    {
      ab.i(str, (String)localObject);
      if (localEmojiInfo == null) {
        break;
      }
      k(localEmojiInfo);
      AppMethodBeat.o(63302);
      return;
    }
    AppMethodBeat.o(63302);
  }
  
  public static void k(EmojiInfo paramEmojiInfo)
  {
    AppMethodBeat.i(63301);
    j.q(paramEmojiInfo, "emojiInfo");
    ab.i(e.Ot(), "addUploadTask: " + paramEmojiInfo.Al());
    eyn.b((com.tencent.mm.loader.g.c)new c(paramEmojiInfo));
    AppMethodBeat.o(63301);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.emoji.d.d
 * JD-Core Version:    0.7.0.1
 */