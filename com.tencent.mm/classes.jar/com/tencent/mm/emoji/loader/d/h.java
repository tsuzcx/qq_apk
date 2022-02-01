package com.tencent.mm.emoji.loader.d;

import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.emoji.sync.EmojiUpdateReceiver;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.storage.emotion.EmojiInfo;
import d.l;
import d.z;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/emoji/loader/request/ProcessRequest;", "Lcom/tencent/mm/emoji/loader/request/Request;", "", "emojiInfo", "Lcom/tencent/mm/storage/emotion/EmojiInfo;", "(Lcom/tencent/mm/storage/emotion/EmojiInfo;)V", "onLoad", "success", "", "plugin-emojisdk_release"})
public final class h
  extends i<z>
{
  public h(EmojiInfo paramEmojiInfo)
  {
    super(paramEmojiInfo);
    AppMethodBeat.i(105472);
    AppMethodBeat.o(105472);
  }
  
  public final void dh(boolean paramBoolean)
  {
    AppMethodBeat.i(105471);
    Intent localIntent = new Intent();
    localIntent.setAction(EmojiUpdateReceiver.ACTION);
    localIntent.putExtra(EmojiUpdateReceiver.gsc, EmojiUpdateReceiver.gsi);
    localIntent.putExtra("md5", this.glt.Lj());
    localIntent.putExtra("result", paramBoolean);
    ak.getContext().sendBroadcast(localIntent);
    AppMethodBeat.o(105471);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.emoji.loader.d.h
 * JD-Core Version:    0.7.0.1
 */