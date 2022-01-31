package com.tencent.mm.emoji.loader.d;

import a.l;
import a.y;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.storage.emotion.EmojiInfo;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/emoji/loader/request/EmojiFileRequest;", "Lcom/tencent/mm/emoji/loader/request/Request;", "", "emojiInfo", "Lcom/tencent/mm/storage/emotion/EmojiInfo;", "callback", "Lcom/tencent/mm/emoji/loader/request/Request$Callback;", "(Lcom/tencent/mm/storage/emotion/EmojiInfo;Lcom/tencent/mm/emoji/loader/request/Request$Callback;)V", "onLoad", "success", "", "plugin-emojisdk_release"})
public final class d
  extends h<y>
{
  private final h.a evW;
  
  public d(EmojiInfo paramEmojiInfo, h.a parama)
  {
    super(paramEmojiInfo);
    AppMethodBeat.i(63209);
    this.evW = parama;
    AppMethodBeat.o(63209);
  }
  
  public final void cf(boolean paramBoolean)
  {
    AppMethodBeat.i(63208);
    h.a locala = this.evW;
    if (locala != null)
    {
      locala.cd(paramBoolean);
      AppMethodBeat.o(63208);
      return;
    }
    AppMethodBeat.o(63208);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.emoji.loader.d.d
 * JD-Core Version:    0.7.0.1
 */