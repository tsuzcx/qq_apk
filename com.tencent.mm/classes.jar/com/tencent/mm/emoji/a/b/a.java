package com.tencent.mm.emoji.a.b;

import com.tencent.mm.storage.emotion.EmojiGroupInfo;
import d.g.b.p;
import d.l;
import java.util.LinkedList;
import java.util.List;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/emoji/model/panel/AbsPanelItemGroup;", "Lcom/tencent/mm/emoji/model/panel/IPanelItemGroup;", "groupInfo", "Lcom/tencent/mm/storage/emotion/EmojiGroupInfo;", "(Lcom/tencent/mm/storage/emotion/EmojiGroupInfo;)V", "contentList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/emoji/model/panel/PanelItem;", "getContentList", "()Ljava/util/LinkedList;", "groupItem", "Lcom/tencent/mm/emoji/model/panel/GroupTitleItem;", "getGroupItem", "()Lcom/tencent/mm/emoji/model/panel/GroupTitleItem;", "equals", "", "other", "", "getGroupInfo", "getItemList", "", "plugin-emojisdk_release"})
public abstract class a
  implements w
{
  final u gnd;
  protected final LinkedList<ac> gne;
  
  public a(EmojiGroupInfo paramEmojiGroupInfo)
  {
    this.gnd = new u(paramEmojiGroupInfo);
    this.gne = new LinkedList();
  }
  
  public final EmojiGroupInfo afy()
  {
    return this.gnd.gkF;
  }
  
  public final List<ac> afz()
  {
    return (List)this.gne;
  }
  
  public boolean equals(Object paramObject)
  {
    return ((paramObject instanceof a)) && (p.i(((a)paramObject).gnd.gkF.fxk(), this.gnd.gkF.fxk()));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.emoji.a.b.a
 * JD-Core Version:    0.7.0.1
 */