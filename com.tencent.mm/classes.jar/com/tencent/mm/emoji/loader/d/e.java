package com.tencent.mm.emoji.loader.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.storage.emotion.EmojiInfo;
import kotlin.l;
import kotlin.x;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/emoji/loader/request/EmojiFileRequest;", "Lcom/tencent/mm/emoji/loader/request/Request;", "", "emojiInfo", "Lcom/tencent/mm/storage/emotion/EmojiInfo;", "callback", "Lcom/tencent/mm/emoji/loader/request/Request$Callback;", "(Lcom/tencent/mm/storage/emotion/EmojiInfo;Lcom/tencent/mm/emoji/loader/request/Request$Callback;)V", "onLoad", "success", "", "plugin-emojisdk_release"})
public final class e
  extends i<x>
{
  private final i.a gWA;
  
  public e(EmojiInfo paramEmojiInfo, i.a parama)
  {
    super(paramEmojiInfo);
    AppMethodBeat.i(105464);
    this.gWA = parama;
    AppMethodBeat.o(105464);
  }
  
  public final void dR(boolean paramBoolean)
  {
    AppMethodBeat.i(105463);
    i.a locala = this.gWA;
    if (locala != null)
    {
      locala.dQ(paramBoolean);
      AppMethodBeat.o(105463);
      return;
    }
    AppMethodBeat.o(105463);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.emoji.loader.d.e
 * JD-Core Version:    0.7.0.1
 */