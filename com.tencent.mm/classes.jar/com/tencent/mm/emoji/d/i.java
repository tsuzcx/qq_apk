package com.tencent.mm.emoji.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.g.a.a;
import com.tencent.mm.loader.g.a.g;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.bj;
import com.tencent.mm.storage.emotion.EmojiInfo;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/emoji/upload/EmojiUploadManager;", "", "()V", "emojiCaptureUploadQueue", "Lcom/tencent/mm/loader/loader/LoaderCore;", "Lcom/tencent/mm/emoji/upload/EmojiCaptureUploadTask;", "uploadCallback", "com/tencent/mm/emoji/upload/EmojiUploadManager$uploadCallback$1", "Lcom/tencent/mm/emoji/upload/EmojiUploadManager$uploadCallback$1;", "addUploadTask", "", "emojiInfo", "Lcom/tencent/mm/storage/emotion/EmojiInfo;", "timeEnter", "", "plugin-emojisdk_release"})
public final class i
{
  private static final com.tencent.mm.loader.g.d<c> jPs;
  private static final a jPt;
  public static final i jPu;
  
  static
  {
    AppMethodBeat.i(105782);
    jPu = new i();
    jPs = new com.tencent.mm.loader.g.d((com.tencent.mm.loader.g.a.d)new com.tencent.mm.loader.g.a.f((com.tencent.mm.loader.g.a.c)new a(20), new g(1, (byte)0), 1, "EmojiUpload"));
    jPt = new a();
    jPs.a((com.tencent.mm.loader.g.f)jPt);
    AppMethodBeat.o(105782);
  }
  
  public static void Fo(long paramLong)
  {
    AppMethodBeat.i(105781);
    Log.i(j.aBy(), "addUploadTask: ".concat(String.valueOf(paramLong)));
    Object localObject = bj.hyV();
    p.j(localObject, "EmojiStorageMgr.getInstance()");
    EmojiInfo localEmojiInfo = ((bj)localObject).ctY().UX(paramLong);
    String str = j.aBy();
    StringBuilder localStringBuilder = new StringBuilder("addUploadTask: ");
    if (localEmojiInfo != null) {}
    for (localObject = localEmojiInfo.getMd5();; localObject = null)
    {
      Log.i(str, (String)localObject);
      if (localEmojiInfo == null) {
        break;
      }
      n(localEmojiInfo);
      AppMethodBeat.o(105781);
      return;
    }
    AppMethodBeat.o(105781);
  }
  
  public static void n(EmojiInfo paramEmojiInfo)
  {
    AppMethodBeat.i(105780);
    p.k(paramEmojiInfo, "emojiInfo");
    Log.i(j.aBy(), "addUploadTask: " + paramEmojiInfo.getMd5());
    jPs.b((com.tencent.mm.loader.g.c)new c(paramEmojiInfo));
    AppMethodBeat.o(105780);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/emoji/upload/EmojiUploadManager$uploadCallback$1", "Lcom/tencent/mm/loader/loader/LoaderCoreCallback;", "Lcom/tencent/mm/emoji/upload/EmojiCaptureUploadTask;", "onLoaderFin", "", "task", "status", "Lcom/tencent/mm/loader/loader/WorkStatus;", "plugin-emojisdk_release"})
  public static final class a
    implements com.tencent.mm.loader.g.f<c>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.emoji.d.i
 * JD-Core Version:    0.7.0.1
 */