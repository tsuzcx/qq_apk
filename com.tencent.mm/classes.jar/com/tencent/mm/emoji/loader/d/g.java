package com.tencent.mm.emoji.loader.d;

import a.l;
import a.y;
import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.emoji.sync.EmojiUpdateReceiver;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.storage.emotion.EmojiInfo;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/emoji/loader/request/ProcessRequest;", "Lcom/tencent/mm/emoji/loader/request/Request;", "", "emojiInfo", "Lcom/tencent/mm/storage/emotion/EmojiInfo;", "(Lcom/tencent/mm/storage/emotion/EmojiInfo;)V", "onLoad", "success", "", "plugin-emojisdk_release"})
public final class g
  extends h<y>
{
  public g(EmojiInfo paramEmojiInfo)
  {
    super(paramEmojiInfo);
    AppMethodBeat.i(63216);
    AppMethodBeat.o(63216);
  }
  
  public final void cf(boolean paramBoolean)
  {
    AppMethodBeat.i(63215);
    Intent localIntent = new Intent();
    localIntent.setAction(EmojiUpdateReceiver.ACTION);
    localIntent.putExtra(EmojiUpdateReceiver.exU, EmojiUpdateReceiver.eya);
    localIntent.putExtra("md5", this.evH.Al());
    localIntent.putExtra("result", paramBoolean);
    ah.getContext().sendBroadcast(localIntent);
    AppMethodBeat.o(63215);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.emoji.loader.d.g
 * JD-Core Version:    0.7.0.1
 */