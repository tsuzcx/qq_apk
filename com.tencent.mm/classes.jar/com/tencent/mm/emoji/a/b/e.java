package com.tencent.mm.emoji.a.b;

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

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/emoji/model/panel/CustomItemGroup;", "Lcom/tencent/mm/emoji/model/panel/AbsPanelItemGroup;", "hasEntrance", "", "hasSystem", "(ZZ)V", "emojiList", "", "Lcom/tencent/mm/storage/emotion/EmojiInfo;", "kotlin.jvm.PlatformType", "reportCount", "", "getReportCount", "plugin-emojisdk_release"})
public final class e
  extends a
{
  private final List<EmojiInfo> gnf;
  private int gng;
  
  public e(boolean paramBoolean1, boolean paramBoolean2)
  {
    super(ad.afS());
    AppMethodBeat.i(105531);
    Object localObject = i.aeX().dj(true);
    if (localObject != null) {}
    for (localObject = (List)localObject;; localObject = (List)v.NhH)
    {
      this.gnf = ((List)localObject);
      this.gng = this.gnf.size();
      this.gne.add(this.gnd);
      if (paramBoolean1) {
        this.gne.add(new m(0));
      }
      localObject = this.gnf.iterator();
      while (((Iterator)localObject).hasNext())
      {
        EmojiInfo localEmojiInfo = (EmojiInfo)((Iterator)localObject).next();
        if ((paramBoolean2) || (localEmojiInfo.field_catalog != EmojiGroupInfo.OzS))
        {
          LinkedList localLinkedList = this.gne;
          p.g(localEmojiInfo, "info");
          localLinkedList.add(new h(localEmojiInfo, 0));
        }
      }
    }
    AppMethodBeat.o(105531);
  }
  
  public final int afA()
  {
    return this.gng;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.emoji.a.b.e
 * JD-Core Version:    0.7.0.1
 */