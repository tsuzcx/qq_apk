package com.tencent.mm.emoji.d;

import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.emoji.a.g;
import com.tencent.mm.emoji.a.g.b;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.emotion.EmojiInfo;
import java.util.List;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/emoji/upload/EmojiCaptureUploadTask;", "Lcom/tencent/mm/loader/loader/IWorkTask;", "emojiInfo", "Lcom/tencent/mm/storage/emotion/EmojiInfo;", "(Lcom/tencent/mm/storage/emotion/EmojiInfo;)V", "TAG", "", "getEmojiInfo", "()Lcom/tencent/mm/storage/emotion/EmojiInfo;", "isWxam", "", "()Z", "timeEnter", "", "getTimeEnter", "()J", "uploadCost", "getUploadCost", "setUploadCost", "(J)V", "call", "", "handleFail", "errorCode", "", "handleSuccess", "gifMd5", "uniqueId", "plugin-emojisdk_release"})
public final class c
  extends com.tencent.mm.loader.g.c
{
  final String TAG;
  final EmojiInfo evH;
  final long eyh;
  long eyi;
  final boolean eyj;
  
  public c(EmojiInfo paramEmojiInfo)
  {
    AppMethodBeat.i(63299);
    this.evH = paramEmojiInfo;
    this.TAG = "MicroMsg.EmojiCaptureUploadTask";
    this.eyh = this.evH.field_captureEnterTime;
    this.eyj = this.evH.dzt();
    AppMethodBeat.o(63299);
  }
  
  public final String Oy()
  {
    AppMethodBeat.i(63298);
    long l = this.eyh;
    AppMethodBeat.o(63298);
    return String.valueOf(l);
  }
  
  public final void call()
  {
    AppMethodBeat.i(63297);
    long l = bo.aoy();
    new g(this.evH, (List)this.evH.dzB(), this.evH.field_imitateMd5, (g.b)new c.a(this, l));
    AppMethodBeat.o(63297);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.emoji.d.c
 * JD-Core Version:    0.7.0.1
 */