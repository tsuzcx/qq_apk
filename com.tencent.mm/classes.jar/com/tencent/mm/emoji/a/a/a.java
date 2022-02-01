package com.tencent.mm.emoji.a.a;

import com.tencent.mm.storage.emotion.EmojiGroupInfo;
import d.g.b.k;
import d.l;
import java.util.LinkedList;
import java.util.List;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/emoji/model/panel/AbsPanelItemGroup;", "Lcom/tencent/mm/emoji/model/panel/IPanelItemGroup;", "groupInfo", "Lcom/tencent/mm/storage/emotion/EmojiGroupInfo;", "(Lcom/tencent/mm/storage/emotion/EmojiGroupInfo;)V", "contentList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/emoji/model/panel/PanelItem;", "getContentList", "()Ljava/util/LinkedList;", "groupItem", "Lcom/tencent/mm/emoji/model/panel/GroupTitleItem;", "getGroupItem", "()Lcom/tencent/mm/emoji/model/panel/GroupTitleItem;", "equals", "", "other", "", "getGroupInfo", "getItemList", "", "plugin-emojisdk_release"})
public abstract class a
  implements s
{
  final q fNx;
  final LinkedList<y> fNy;
  
  public a(EmojiGroupInfo paramEmojiGroupInfo)
  {
    this.fNx = new q(paramEmojiGroupInfo);
    this.fNy = new LinkedList();
  }
  
  public final EmojiGroupInfo abH()
  {
    return this.fNx.fLb;
  }
  
  public boolean equals(Object paramObject)
  {
    return ((paramObject instanceof a)) && (k.g(((a)paramObject).fNx.fLb.fZJ(), this.fNx.fLb.fZJ()));
  }
  
  public final List<y> getItemList()
  {
    return (List)this.fNy;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.emoji.a.a.a
 * JD-Core Version:    0.7.0.1
 */