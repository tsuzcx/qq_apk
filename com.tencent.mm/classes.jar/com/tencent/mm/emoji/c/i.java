package com.tencent.mm.emoji.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.g.a.a;
import com.tencent.mm.loader.g.a.g;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.storage.bd;
import com.tencent.mm.storage.emotion.EmojiInfo;
import d.g.b.p;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/emoji/upload/EmojiUploadManager;", "", "()V", "emojiCaptureUploadQueue", "Lcom/tencent/mm/loader/loader/LoaderCore;", "Lcom/tencent/mm/emoji/upload/EmojiCaptureUploadTask;", "uploadCallback", "com/tencent/mm/emoji/upload/EmojiUploadManager$uploadCallback$1", "Lcom/tencent/mm/emoji/upload/EmojiUploadManager$uploadCallback$1;", "addUploadTask", "", "emojiInfo", "Lcom/tencent/mm/storage/emotion/EmojiInfo;", "timeEnter", "", "plugin-emojisdk_release"})
public final class i
{
  private static final com.tencent.mm.loader.g.d<c> gqg;
  private static final a gqh;
  public static final i gqi;
  
  static
  {
    AppMethodBeat.i(105782);
    gqi = new i();
    gqg = new com.tencent.mm.loader.g.d((com.tencent.mm.loader.g.a.d)new com.tencent.mm.loader.g.a.f((com.tencent.mm.loader.g.a.c)new a(20), new g(1, (byte)0), 1, "EmojiUpload"));
    gqh = new a();
    gqg.a((com.tencent.mm.loader.g.f)gqh);
    AppMethodBeat.o(105782);
  }
  
  public static void o(EmojiInfo paramEmojiInfo)
  {
    AppMethodBeat.i(105780);
    p.h(paramEmojiInfo, "emojiInfo");
    ad.i(j.aeD(), "addUploadTask: " + paramEmojiInfo.Lb());
    gqg.b((com.tencent.mm.loader.g.c)new c(paramEmojiInfo));
    AppMethodBeat.o(105780);
  }
  
  public static void qW(long paramLong)
  {
    AppMethodBeat.i(105781);
    ad.i(j.aeD(), "addUploadTask: ".concat(String.valueOf(paramLong)));
    Object localObject = bd.frc();
    p.g(localObject, "EmojiStorageMgr.getInstance()");
    EmojiInfo localEmojiInfo = ((bd)localObject).bIW().DI(paramLong);
    String str = j.aeD();
    StringBuilder localStringBuilder = new StringBuilder("addUploadTask: ");
    if (localEmojiInfo != null) {}
    for (localObject = localEmojiInfo.Lb();; localObject = null)
    {
      ad.i(str, (String)localObject);
      if (localEmojiInfo == null) {
        break;
      }
      o(localEmojiInfo);
      AppMethodBeat.o(105781);
      return;
    }
    AppMethodBeat.o(105781);
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/emoji/upload/EmojiUploadManager$uploadCallback$1", "Lcom/tencent/mm/loader/loader/LoaderCoreCallback;", "Lcom/tencent/mm/emoji/upload/EmojiCaptureUploadTask;", "onLoaderFin", "", "task", "status", "Lcom/tencent/mm/loader/loader/WorkStatus;", "plugin-emojisdk_release"})
  public static final class a
    implements com.tencent.mm.loader.g.f<c>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.emoji.c.i
 * JD-Core Version:    0.7.0.1
 */