package com.tencent.mm.emoji.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.f.a.a;
import com.tencent.mm.loader.f.a.g;
import com.tencent.mm.loader.f.e;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.bl;
import com.tencent.mm.storage.emotion.EmojiInfo;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/emoji/upload/EmojiUploadManager;", "", "()V", "emojiCaptureUploadQueue", "Lcom/tencent/mm/loader/loader/LoaderCore;", "Lcom/tencent/mm/emoji/upload/EmojiCaptureUploadTask;", "uploadCallback", "com/tencent/mm/emoji/upload/EmojiUploadManager$uploadCallback$1", "Lcom/tencent/mm/emoji/upload/EmojiUploadManager$uploadCallback$1;", "addUploadTask", "", "emojiInfo", "Lcom/tencent/mm/storage/emotion/EmojiInfo;", "timeEnter", "", "plugin-emojisdk_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class h
{
  public static final h mol;
  private static final com.tencent.mm.loader.f.d<c> mom;
  private static final a mon;
  
  static
  {
    AppMethodBeat.i(105782);
    mol = new h();
    mom = new com.tencent.mm.loader.f.d((com.tencent.mm.loader.f.a.d)new com.tencent.mm.loader.f.a.f((com.tencent.mm.loader.f.a.c)new a(20), new g(1, (byte)0), 1, "EmojiUpload"));
    mon = new a();
    mom.a((e)mon);
    AppMethodBeat.o(105782);
  }
  
  public static void hw(long paramLong)
  {
    AppMethodBeat.i(105781);
    Log.i(i.aUw(), s.X("addUploadTask: ", Long.valueOf(paramLong)));
    EmojiInfo localEmojiInfo = bl.jba().adju.zf(paramLong);
    String str = i.aUw();
    if (localEmojiInfo == null) {}
    for (Object localObject = null;; localObject = localEmojiInfo.getMd5())
    {
      Log.i(str, s.X("addUploadTask: ", localObject));
      if (localEmojiInfo != null) {
        m(localEmojiInfo);
      }
      AppMethodBeat.o(105781);
      return;
    }
  }
  
  public static void m(EmojiInfo paramEmojiInfo)
  {
    AppMethodBeat.i(105780);
    s.u(paramEmojiInfo, "emojiInfo");
    Log.i(i.aUw(), s.X("addUploadTask: ", paramEmojiInfo.getMd5()));
    mom.c((com.tencent.mm.loader.f.c)new c(paramEmojiInfo));
    AppMethodBeat.o(105780);
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/emoji/upload/EmojiUploadManager$uploadCallback$1", "Lcom/tencent/mm/loader/loader/LoaderCoreCallback;", "Lcom/tencent/mm/emoji/upload/EmojiCaptureUploadTask;", "onLoaderFin", "", "task", "status", "Lcom/tencent/mm/loader/loader/WorkStatus;", "plugin-emojisdk_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
    implements e<c>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.emoji.e.h
 * JD-Core Version:    0.7.0.1
 */