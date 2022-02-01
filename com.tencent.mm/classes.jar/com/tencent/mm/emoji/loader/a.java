package com.tencent.mm.emoji.loader;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.h.a.c;
import com.tencent.mm.storage.emotion.EmojiGroupInfo;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/emoji/loader/EmojiGroupData;", "Lcom/tencent/mm/loader/model/data/ILoaderData;", "groupInfo", "Lcom/tencent/mm/storage/emotion/EmojiGroupInfo;", "(Lcom/tencent/mm/storage/emotion/EmojiGroupInfo;)V", "getGroupInfo", "()Lcom/tencent/mm/storage/emotion/EmojiGroupInfo;", "isLegal", "", "uniqueValue", "", "plugin-emojisdk_release"})
public final class a
  implements c
{
  final EmojiGroupInfo jGw;
  
  public a(EmojiGroupInfo paramEmojiGroupInfo)
  {
    AppMethodBeat.i(105380);
    this.jGw = paramEmojiGroupInfo;
    AppMethodBeat.o(105380);
  }
  
  public final String aBv()
  {
    AppMethodBeat.i(105379);
    String str = this.jGw.hBl();
    p.j(str, "groupInfo.productID");
    AppMethodBeat.o(105379);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.emoji.loader.a
 * JD-Core Version:    0.7.0.1
 */