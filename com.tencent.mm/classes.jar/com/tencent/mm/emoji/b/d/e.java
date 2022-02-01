package com.tencent.mm.emoji.b.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.storage.emotion.EmojiInfo;
import kotlin.Metadata;
import kotlin.ah;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/emoji/loader/request/EmojiFileRequest;", "Lcom/tencent/mm/emoji/loader/request/Request;", "", "emojiInfo", "Lcom/tencent/mm/storage/emotion/EmojiInfo;", "callback", "Lcom/tencent/mm/emoji/loader/request/Request$Callback;", "(Lcom/tencent/mm/storage/emotion/EmojiInfo;Lcom/tencent/mm/emoji/loader/request/Request$Callback;)V", "onLoad", "success", "", "plugin-emojisdk_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class e
  extends h<ah>
{
  private final h.a mha;
  
  public e(EmojiInfo paramEmojiInfo, h.a parama)
  {
    super(paramEmojiInfo);
    AppMethodBeat.i(105464);
    this.mha = parama;
    AppMethodBeat.o(105464);
  }
  
  public final void fc(boolean paramBoolean)
  {
    AppMethodBeat.i(105463);
    h.a locala = this.mha;
    if (locala != null) {
      locala.onResult(paramBoolean);
    }
    AppMethodBeat.o(105463);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.emoji.b.d.e
 * JD-Core Version:    0.7.0.1
 */