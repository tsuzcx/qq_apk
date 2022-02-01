package com.tencent.mm.emoji.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.emoji.a.i;
import com.tencent.mm.storage.emotion.EmojiGroupInfo;
import com.tencent.mm.storage.emotion.EmojiInfo;
import d.a.v;
import d.g.b.k;
import d.l;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/emoji/model/panel/CustomItemGroup;", "Lcom/tencent/mm/emoji/model/panel/AbsPanelItemGroup;", "hasEntrance", "", "hasSystem", "(ZZ)V", "emojiList", "", "Lcom/tencent/mm/storage/emotion/EmojiInfo;", "kotlin.jvm.PlatformType", "reportCount", "", "getReportCount", "plugin-emojisdk_release"})
public final class e
  extends a
{
  private final List<EmojiInfo> fRk;
  private int fRl;
  
  public e(boolean paramBoolean1, boolean paramBoolean2)
  {
    super(z.acX());
    AppMethodBeat.i(105531);
    Object localObject = i.ach().dh(true);
    if (localObject != null) {}
    for (localObject = (List)localObject;; localObject = (List)v.KTF)
    {
      this.fRk = ((List)localObject);
      this.fRl = this.fRk.size();
      this.fRj.add(this.fRi);
      if (paramBoolean1) {
        this.fRj.add(new m(0));
      }
      localObject = this.fRk.iterator();
      while (((Iterator)localObject).hasNext())
      {
        EmojiInfo localEmojiInfo = (EmojiInfo)((Iterator)localObject).next();
        if ((paramBoolean2) || (localEmojiInfo.field_catalog != EmojiGroupInfo.Jsq))
        {
          LinkedList localLinkedList = this.fRj;
          k.g(localEmojiInfo, "info");
          localLinkedList.add(new h(localEmojiInfo, 0));
        }
      }
    }
    AppMethodBeat.o(105531);
  }
  
  public final int acI()
  {
    return this.fRl;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.emoji.a.a.e
 * JD-Core Version:    0.7.0.1
 */