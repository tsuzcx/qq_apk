package com.tencent.mm.emoji.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.g.a.a;
import com.tencent.mm.loader.g.a.g;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.storage.be;
import com.tencent.mm.storage.emotion.EmojiInfo;
import d.g.b.p;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/emoji/upload/EmojiUploadManager;", "", "()V", "emojiCaptureUploadQueue", "Lcom/tencent/mm/loader/loader/LoaderCore;", "Lcom/tencent/mm/emoji/upload/EmojiCaptureUploadTask;", "uploadCallback", "com/tencent/mm/emoji/upload/EmojiUploadManager$uploadCallback$1", "Lcom/tencent/mm/emoji/upload/EmojiUploadManager$uploadCallback$1;", "addUploadTask", "", "emojiInfo", "Lcom/tencent/mm/storage/emotion/EmojiInfo;", "timeEnter", "", "plugin-emojisdk_release"})
public final class i
{
  private static final com.tencent.mm.loader.g.d<c> gsB;
  private static final a gsC;
  public static final i gsD;
  
  static
  {
    AppMethodBeat.i(105782);
    gsD = new i();
    gsB = new com.tencent.mm.loader.g.d((com.tencent.mm.loader.g.a.d)new com.tencent.mm.loader.g.a.f((com.tencent.mm.loader.g.a.c)new a(20), new g(1, (byte)0), 1, "EmojiUpload"));
    gsC = new a();
    gsB.a((com.tencent.mm.loader.g.f)gsC);
    AppMethodBeat.o(105782);
  }
  
  public static void o(EmojiInfo paramEmojiInfo)
  {
    AppMethodBeat.i(105780);
    p.h(paramEmojiInfo, "emojiInfo");
    ae.i(j.aeP(), "addUploadTask: " + paramEmojiInfo.Lj());
    gsB.b((com.tencent.mm.loader.g.c)new c(paramEmojiInfo));
    AppMethodBeat.o(105780);
  }
  
  public static void rj(long paramLong)
  {
    AppMethodBeat.i(105781);
    ae.i(j.aeP(), "addUploadTask: ".concat(String.valueOf(paramLong)));
    Object localObject = be.fvc();
    p.g(localObject, "EmojiStorageMgr.getInstance()");
    EmojiInfo localEmojiInfo = ((be)localObject).bJU().Eh(paramLong);
    String str = j.aeP();
    StringBuilder localStringBuilder = new StringBuilder("addUploadTask: ");
    if (localEmojiInfo != null) {}
    for (localObject = localEmojiInfo.Lj();; localObject = null)
    {
      ae.i(str, (String)localObject);
      if (localEmojiInfo == null) {
        break;
      }
      o(localEmojiInfo);
      AppMethodBeat.o(105781);
      return;
    }
    AppMethodBeat.o(105781);
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/emoji/upload/EmojiUploadManager$uploadCallback$1", "Lcom/tencent/mm/loader/loader/LoaderCoreCallback;", "Lcom/tencent/mm/emoji/upload/EmojiCaptureUploadTask;", "onLoaderFin", "", "task", "status", "Lcom/tencent/mm/loader/loader/WorkStatus;", "plugin-emojisdk_release"})
  public static final class a
    implements com.tencent.mm.loader.g.f<c>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.emoji.c.i
 * JD-Core Version:    0.7.0.1
 */