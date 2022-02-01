package com.tencent.mm.emoji.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.emoji.b.n;
import com.tencent.mm.storage.emotion.EmojiInfo;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/emoji/upload/EmojiUploadFactory;", "", "()V", "useCdn", "", "getUpload", "Lcom/tencent/mm/emoji/upload/EmojiUpload;", "emojiInfo", "Lcom/tencent/mm/storage/emotion/EmojiInfo;", "isSelfie", "callback", "Lcom/tencent/mm/emoji/upload/EmojiUpload$Callback;", "plugin-emojisdk_release"})
public final class h
{
  public static final h hdL;
  
  static
  {
    AppMethodBeat.i(105778);
    hdL = new h();
    AppMethodBeat.o(105778);
  }
  
  public static d a(EmojiInfo paramEmojiInfo, boolean paramBoolean, d.a parama)
  {
    AppMethodBeat.i(105777);
    p.h(paramEmojiInfo, "emojiInfo");
    p.h(parama, "callback");
    if (n.avl())
    {
      paramEmojiInfo = (d)new e(paramEmojiInfo, paramBoolean, parama);
      AppMethodBeat.o(105777);
      return paramEmojiInfo;
    }
    paramEmojiInfo = (d)new g(paramEmojiInfo, paramBoolean, parama);
    AppMethodBeat.o(105777);
    return paramEmojiInfo;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.emoji.d.h
 * JD-Core Version:    0.7.0.1
 */