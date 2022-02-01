package com.tencent.mm.emoji.a.a;

import com.tencent.mm.storage.emotion.EmojiGroupInfo;
import d.g.b.p;
import d.l;
import java.util.LinkedList;
import java.util.List;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/emoji/model/panel/AbsPanelItemGroup;", "Lcom/tencent/mm/emoji/model/panel/IPanelItemGroup;", "groupInfo", "Lcom/tencent/mm/storage/emotion/EmojiGroupInfo;", "(Lcom/tencent/mm/storage/emotion/EmojiGroupInfo;)V", "contentList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/emoji/model/panel/PanelItem;", "getContentList", "()Ljava/util/LinkedList;", "groupItem", "Lcom/tencent/mm/emoji/model/panel/GroupTitleItem;", "getGroupItem", "()Lcom/tencent/mm/emoji/model/panel/GroupTitleItem;", "equals", "", "other", "", "getGroupInfo", "getItemList", "", "plugin-emojisdk_release"})
public abstract class a
  implements w
{
  final u gkI;
  protected final LinkedList<ac> gkJ;
  
  public a(EmojiGroupInfo paramEmojiGroupInfo)
  {
    this.gkI = new u(paramEmojiGroupInfo);
    this.gkJ = new LinkedList();
  }
  
  public final EmojiGroupInfo afk()
  {
    return this.gkI.gin;
  }
  
  public final List<ac> afl()
  {
    return (List)this.gkJ;
  }
  
  public boolean equals(Object paramObject)
  {
    return ((paramObject instanceof a)) && (p.i(((a)paramObject).gkI.gin.fxi(), this.gkI.gin.fxi()));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.emoji.a.a.a
 * JD-Core Version:    0.7.0.1
 */