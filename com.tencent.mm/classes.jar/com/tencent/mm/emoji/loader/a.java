package com.tencent.mm.emoji.loader;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.h.a.c;
import com.tencent.mm.storage.emotion.EmojiGroupInfo;
import d.g.b.p;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/emoji/loader/EmojiGroupData;", "Lcom/tencent/mm/loader/model/data/ILoaderData;", "groupInfo", "Lcom/tencent/mm/storage/emotion/EmojiGroupInfo;", "(Lcom/tencent/mm/storage/emotion/EmojiGroupInfo;)V", "getGroupInfo", "()Lcom/tencent/mm/storage/emotion/EmojiGroupInfo;", "isLegal", "", "uniqueValue", "", "plugin-emojisdk_release"})
public final class a
  implements c
{
  final EmojiGroupInfo gin;
  
  public a(EmojiGroupInfo paramEmojiGroupInfo)
  {
    AppMethodBeat.i(105380);
    this.gin = paramEmojiGroupInfo;
    AppMethodBeat.o(105380);
  }
  
  public final String aeA()
  {
    AppMethodBeat.i(105379);
    String str = this.gin.fxi();
    p.g(str, "groupInfo.productID");
    AppMethodBeat.o(105379);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.emoji.loader.a
 * JD-Core Version:    0.7.0.1
 */