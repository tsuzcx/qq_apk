package com.tencent.mm.emoji.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.storage.emotion.EmojiInfo;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/emoji/upload/EmojiUploadFactory;", "", "()V", "useCdn", "", "getUpload", "Lcom/tencent/mm/emoji/upload/EmojiUpload;", "emojiInfo", "Lcom/tencent/mm/storage/emotion/EmojiInfo;", "isSelfie", "callback", "Lcom/tencent/mm/emoji/upload/EmojiUpload$Callback;", "plugin-emojisdk_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class g
{
  public static final g mok;
  
  static
  {
    AppMethodBeat.i(105778);
    mok = new g();
    AppMethodBeat.o(105778);
  }
  
  public static d a(EmojiInfo paramEmojiInfo, boolean paramBoolean, d.a parama)
  {
    AppMethodBeat.i(105777);
    s.u(paramEmojiInfo, "emojiInfo");
    s.u(parama, "callback");
    paramEmojiInfo = (d)new e(paramEmojiInfo, paramBoolean, parama);
    AppMethodBeat.o(105777);
    return paramEmojiInfo;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.emoji.e.g
 * JD-Core Version:    0.7.0.1
 */