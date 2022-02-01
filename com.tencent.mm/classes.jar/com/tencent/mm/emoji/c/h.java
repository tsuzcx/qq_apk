package com.tencent.mm.emoji.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.storage.emotion.EmojiInfo;
import d.g.b.k;

@d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/emoji/upload/EmojiUploadFactory;", "", "()V", "useCdn", "", "getUpload", "Lcom/tencent/mm/emoji/upload/EmojiUpload;", "emojiInfo", "Lcom/tencent/mm/storage/emotion/EmojiInfo;", "isSelfie", "callback", "Lcom/tencent/mm/emoji/upload/EmojiUpload$Callback;", "plugin-emojisdk_release"})
public final class h
{
  public static final h fSH;
  
  static
  {
    AppMethodBeat.i(105778);
    fSH = new h();
    AppMethodBeat.o(105778);
  }
  
  public static d a(EmojiInfo paramEmojiInfo, boolean paramBoolean, d.a parama)
  {
    AppMethodBeat.i(105777);
    k.h(paramEmojiInfo, "emojiInfo");
    k.h(parama, "callback");
    if (com.tencent.mm.emoji.a.l.abG())
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.emoji.c.h
 * JD-Core Version:    0.7.0.1
 */