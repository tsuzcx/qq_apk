package com.tencent.mm.emoji.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.emoji.a.i;
import com.tencent.mm.storage.emotion.EmojiGroupInfo;
import com.tencent.mm.storage.emotion.EmojiInfo;
import d.a.v;
import d.g.b.p;
import d.l;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/emoji/model/panel/CustomItemGroup;", "Lcom/tencent/mm/emoji/model/panel/AbsPanelItemGroup;", "hasEntrance", "", "hasSystem", "(ZZ)V", "emojiList", "", "Lcom/tencent/mm/storage/emotion/EmojiInfo;", "kotlin.jvm.PlatformType", "reportCount", "", "getReportCount", "plugin-emojisdk_release"})
public final class e
  extends a
{
  private final List<EmojiInfo> gkK;
  private int gkL;
  
  public e(boolean paramBoolean1, boolean paramBoolean2)
  {
    super(ad.afE());
    AppMethodBeat.i(105531);
    Object localObject = i.aeL().dj(true);
    if (localObject != null) {}
    for (localObject = (List)localObject;; localObject = (List)v.MKE)
    {
      this.gkK = ((List)localObject);
      this.gkL = this.gkK.size();
      this.gkJ.add(this.gkI);
      if (paramBoolean1) {
        this.gkJ.add(new m(0));
      }
      localObject = this.gkK.iterator();
      while (((Iterator)localObject).hasNext())
      {
        EmojiInfo localEmojiInfo = (EmojiInfo)((Iterator)localObject).next();
        if ((paramBoolean2) || (localEmojiInfo.field_catalog != EmojiGroupInfo.OeL))
        {
          LinkedList localLinkedList = this.gkJ;
          p.g(localEmojiInfo, "info");
          localLinkedList.add(new h(localEmojiInfo, 0));
        }
      }
    }
    AppMethodBeat.o(105531);
  }
  
  public final int afm()
  {
    return this.gkL;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.emoji.a.a.e
 * JD-Core Version:    0.7.0.1
 */