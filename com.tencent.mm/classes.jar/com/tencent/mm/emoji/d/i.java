package com.tencent.mm.emoji.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.g.a.a;
import com.tencent.mm.loader.g.a.g;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.bj;
import com.tencent.mm.storage.emotion.EmojiInfo;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/emoji/upload/EmojiUploadManager;", "", "()V", "emojiCaptureUploadQueue", "Lcom/tencent/mm/loader/loader/LoaderCore;", "Lcom/tencent/mm/emoji/upload/EmojiCaptureUploadTask;", "uploadCallback", "com/tencent/mm/emoji/upload/EmojiUploadManager$uploadCallback$1", "Lcom/tencent/mm/emoji/upload/EmojiUploadManager$uploadCallback$1;", "addUploadTask", "", "emojiInfo", "Lcom/tencent/mm/storage/emotion/EmojiInfo;", "timeEnter", "", "plugin-emojisdk_release"})
public final class i
{
  private static final com.tencent.mm.loader.g.d<c> hdM;
  private static final a hdN;
  public static final i hdO;
  
  static
  {
    AppMethodBeat.i(105782);
    hdO = new i();
    hdM = new com.tencent.mm.loader.g.d((com.tencent.mm.loader.g.a.d)new com.tencent.mm.loader.g.a.f((com.tencent.mm.loader.g.a.c)new a(20), new g(1, (byte)0), 1, "EmojiUpload"));
    hdN = new a();
    hdM.a((com.tencent.mm.loader.g.f)hdN);
    AppMethodBeat.o(105782);
  }
  
  public static void o(EmojiInfo paramEmojiInfo)
  {
    AppMethodBeat.i(105780);
    p.h(paramEmojiInfo, "emojiInfo");
    Log.i(j.auD(), "addUploadTask: " + paramEmojiInfo.getMd5());
    hdM.c((com.tencent.mm.loader.g.c)new c(paramEmojiInfo));
    AppMethodBeat.o(105780);
  }
  
  public static void zm(long paramLong)
  {
    AppMethodBeat.i(105781);
    Log.i(j.auD(), "addUploadTask: ".concat(String.valueOf(paramLong)));
    Object localObject = bj.gCJ();
    p.g(localObject, "EmojiStorageMgr.getInstance()");
    EmojiInfo localEmojiInfo = ((bj)localObject).cgN().Nl(paramLong);
    String str = j.auD();
    StringBuilder localStringBuilder = new StringBuilder("addUploadTask: ");
    if (localEmojiInfo != null) {}
    for (localObject = localEmojiInfo.getMd5();; localObject = null)
    {
      Log.i(str, (String)localObject);
      if (localEmojiInfo == null) {
        break;
      }
      o(localEmojiInfo);
      AppMethodBeat.o(105781);
      return;
    }
    AppMethodBeat.o(105781);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/emoji/upload/EmojiUploadManager$uploadCallback$1", "Lcom/tencent/mm/loader/loader/LoaderCoreCallback;", "Lcom/tencent/mm/emoji/upload/EmojiCaptureUploadTask;", "onLoaderFin", "", "task", "status", "Lcom/tencent/mm/loader/loader/WorkStatus;", "plugin-emojisdk_release"})
  public static final class a
    implements com.tencent.mm.loader.g.f<c>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.emoji.d.i
 * JD-Core Version:    0.7.0.1
 */