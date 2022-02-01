package com.tencent.mm.emoji.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.g.a.a;
import com.tencent.mm.loader.g.a.g;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.storage.az;
import com.tencent.mm.storage.emotion.EmojiInfo;
import d.g.b.k;
import d.l;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/emoji/upload/EmojiUploadManager;", "", "()V", "emojiCaptureUploadQueue", "Lcom/tencent/mm/loader/loader/LoaderCore;", "Lcom/tencent/mm/emoji/upload/EmojiCaptureUploadTask;", "uploadCallback", "com/tencent/mm/emoji/upload/EmojiUploadManager$uploadCallback$1", "Lcom/tencent/mm/emoji/upload/EmojiUploadManager$uploadCallback$1;", "addUploadTask", "", "emojiInfo", "Lcom/tencent/mm/storage/emotion/EmojiInfo;", "timeEnter", "", "plugin-emojisdk_release"})
public final class i
{
  private static final com.tencent.mm.loader.g.d<c> fWD;
  private static final a fWE;
  public static final i fWF;
  
  static
  {
    AppMethodBeat.i(105782);
    fWF = new i();
    fWD = new com.tencent.mm.loader.g.d((com.tencent.mm.loader.g.a.d)new com.tencent.mm.loader.g.a.f((com.tencent.mm.loader.g.a.c)new a(20), new g(1, (byte)0), 1, "EmojiUpload"));
    fWE = new a();
    fWD.a((com.tencent.mm.loader.g.f)fWE);
    AppMethodBeat.o(105782);
  }
  
  public static void o(EmojiInfo paramEmojiInfo)
  {
    AppMethodBeat.i(105780);
    k.h(paramEmojiInfo, "emojiInfo");
    ac.i(j.abZ(), "addUploadTask: " + paramEmojiInfo.JC());
    fWD.b((com.tencent.mm.loader.g.c)new c(paramEmojiInfo));
    AppMethodBeat.o(105780);
  }
  
  public static void oW(long paramLong)
  {
    AppMethodBeat.i(105781);
    ac.i(j.abZ(), "addUploadTask: ".concat(String.valueOf(paramLong)));
    Object localObject = az.faZ();
    k.g(localObject, "EmojiStorageMgr.getInstance()");
    EmojiInfo localEmojiInfo = ((az)localObject).bEN().AS(paramLong);
    String str = j.abZ();
    StringBuilder localStringBuilder = new StringBuilder("addUploadTask: ");
    if (localEmojiInfo != null) {}
    for (localObject = localEmojiInfo.JC();; localObject = null)
    {
      ac.i(str, (String)localObject);
      if (localEmojiInfo == null) {
        break;
      }
      o(localEmojiInfo);
      AppMethodBeat.o(105781);
      return;
    }
    AppMethodBeat.o(105781);
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/emoji/upload/EmojiUploadManager$uploadCallback$1", "Lcom/tencent/mm/loader/loader/LoaderCoreCallback;", "Lcom/tencent/mm/emoji/upload/EmojiCaptureUploadTask;", "onLoaderFin", "", "task", "status", "Lcom/tencent/mm/loader/loader/WorkStatus;", "plugin-emojisdk_release"})
  public static final class a
    implements com.tencent.mm.loader.g.f<c>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.emoji.c.i
 * JD-Core Version:    0.7.0.1
 */