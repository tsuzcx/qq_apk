package com.tencent.mm.emoji.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.g.a.c;
import com.tencent.mm.storage.emotion.EmojiGroupInfo;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/emoji/loader/EmojiGroupData;", "Lcom/tencent/mm/loader/model/data/ILoaderData;", "groupInfo", "Lcom/tencent/mm/storage/emotion/EmojiGroupInfo;", "(Lcom/tencent/mm/storage/emotion/EmojiGroupInfo;)V", "getGroupInfo", "()Lcom/tencent/mm/storage/emotion/EmojiGroupInfo;", "isLegal", "", "uniqueValue", "", "plugin-emojisdk_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
  implements c
{
  final EmojiGroupInfo mgd;
  
  public a(EmojiGroupInfo paramEmojiGroupInfo)
  {
    AppMethodBeat.i(105380);
    this.mgd = paramEmojiGroupInfo;
    AppMethodBeat.o(105380);
  }
  
  public final String aUt()
  {
    AppMethodBeat.i(105379);
    String str = this.mgd.field_productID;
    s.s(str, "groupInfo.productID");
    AppMethodBeat.o(105379);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.emoji.b.a
 * JD-Core Version:    0.7.0.1
 */