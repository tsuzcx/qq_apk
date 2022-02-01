package com.tencent.mm.emoji.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.storage.emotion.EmojiGroupInfo;
import com.tencent.mm.storage.emotion.EmojiInfo;
import d.a.v;
import d.g.b.k;
import d.l;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/emoji/model/panel/CustomItemGroup;", "Lcom/tencent/mm/emoji/model/panel/AbsPanelItemGroup;", "hasEntrance", "", "hasSystem", "(ZZ)V", "emojiList", "", "Lcom/tencent/mm/storage/emotion/EmojiInfo;", "kotlin.jvm.PlatformType", "reportCount", "", "getReportCount", "plugin-emojisdk_release"})
public final class e
  extends a
{
  private int fNA;
  private final List<EmojiInfo> fNz;
  
  public e(boolean paramBoolean1, boolean paramBoolean2)
  {
    super(z.abX());
    AppMethodBeat.i(105531);
    Object localObject = com.tencent.mm.emoji.a.h.abj().di(true);
    if (localObject != null) {}
    for (localObject = (List)localObject;; localObject = (List)v.Jgl)
    {
      this.fNz = ((List)localObject);
      this.fNA = this.fNz.size();
      this.fNy.add(this.fNx);
      if (paramBoolean1) {
        this.fNy.add(new m(0));
      }
      localObject = this.fNz.iterator();
      while (((Iterator)localObject).hasNext())
      {
        EmojiInfo localEmojiInfo = (EmojiInfo)((Iterator)localObject).next();
        if ((paramBoolean2) || (localEmojiInfo.field_catalog != EmojiGroupInfo.LBO))
        {
          LinkedList localLinkedList = this.fNy;
          k.g(localEmojiInfo, "info");
          localLinkedList.add(new h(localEmojiInfo, 0));
        }
      }
    }
    AppMethodBeat.o(105531);
  }
  
  public final int abI()
  {
    return this.fNA;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.emoji.a.a.e
 * JD-Core Version:    0.7.0.1
 */