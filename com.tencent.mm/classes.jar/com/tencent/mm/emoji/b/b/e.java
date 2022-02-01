package com.tencent.mm.emoji.b.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.emoji.b.j;
import com.tencent.mm.storage.emotion.EmojiGroupInfo;
import com.tencent.mm.storage.emotion.EmojiInfo;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.a.v;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/emoji/model/panel/CustomItemGroup;", "Lcom/tencent/mm/emoji/model/panel/AbsPanelItemGroup;", "hasEntrance", "", "hasSystem", "(ZZ)V", "emojiList", "", "Lcom/tencent/mm/storage/emotion/EmojiInfo;", "kotlin.jvm.PlatformType", "reportCount", "", "getReportCount", "plugin-emojisdk_release"})
public final class e
  extends a
{
  private final List<EmojiInfo> gXX;
  private int gXY;
  
  public e(boolean paramBoolean1, boolean paramBoolean2)
  {
    super(ad.avG());
    AppMethodBeat.i(105531);
    Object localObject = j.auL().dT(true);
    if (localObject != null) {}
    for (localObject = (List)localObject;; localObject = (List)v.SXr)
    {
      this.gXX = ((List)localObject);
      this.gXY = this.gXX.size();
      this.gXW.add(this.gXV);
      if (paramBoolean1) {
        this.gXW.add(new m(0));
      }
      localObject = this.gXX.iterator();
      while (((Iterator)localObject).hasNext())
      {
        EmojiInfo localEmojiInfo = (EmojiInfo)((Iterator)localObject).next();
        if ((paramBoolean2) || (localEmojiInfo.field_catalog != EmojiGroupInfo.Uun))
        {
          LinkedList localLinkedList = this.gXW;
          p.g(localEmojiInfo, "info");
          localLinkedList.add(new h(localEmojiInfo, 0));
        }
      }
    }
    AppMethodBeat.o(105531);
  }
  
  public final int avo()
  {
    return this.gXY;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.emoji.b.b.e
 * JD-Core Version:    0.7.0.1
 */