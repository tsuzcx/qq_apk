package com.tencent.mm.emoji.a.a;

import com.tencent.mm.storage.emotion.EmojiGroupInfo;
import d.g.b.k;
import d.l;
import java.util.LinkedList;
import java.util.List;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/emoji/model/panel/AbsPanelItemGroup;", "Lcom/tencent/mm/emoji/model/panel/IPanelItemGroup;", "groupInfo", "Lcom/tencent/mm/storage/emotion/EmojiGroupInfo;", "(Lcom/tencent/mm/storage/emotion/EmojiGroupInfo;)V", "contentList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/emoji/model/panel/PanelItem;", "getContentList", "()Ljava/util/LinkedList;", "groupItem", "Lcom/tencent/mm/emoji/model/panel/GroupTitleItem;", "getGroupItem", "()Lcom/tencent/mm/emoji/model/panel/GroupTitleItem;", "equals", "", "other", "", "getGroupInfo", "getItemList", "", "plugin-emojisdk_release"})
public abstract class a
  implements s
{
  final q fRi;
  final LinkedList<y> fRj;
  
  public a(EmojiGroupInfo paramEmojiGroupInfo)
  {
    this.fRi = new q(paramEmojiGroupInfo);
    this.fRj = new LinkedList();
  }
  
  public final EmojiGroupInfo acG()
  {
    return this.fRi.fON;
  }
  
  public final List<y> acH()
  {
    return (List)this.fRj;
  }
  
  public boolean equals(Object paramObject)
  {
    return ((paramObject instanceof a)) && (k.g(((a)paramObject).fRi.fON.fdm(), this.fRi.fON.fdm()));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.emoji.a.a.a
 * JD-Core Version:    0.7.0.1
 */