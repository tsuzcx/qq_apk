package com.tencent.mm.emoji.b.b;

import com.tencent.mm.storage.emotion.EmojiGroupInfo;
import java.util.LinkedList;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/emoji/model/panel/AbsPanelItemGroup;", "Lcom/tencent/mm/emoji/model/panel/IPanelItemGroup;", "groupInfo", "Lcom/tencent/mm/storage/emotion/EmojiGroupInfo;", "(Lcom/tencent/mm/storage/emotion/EmojiGroupInfo;)V", "contentList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/emoji/model/panel/PanelItem;", "getContentList", "()Ljava/util/LinkedList;", "groupItem", "Lcom/tencent/mm/emoji/model/panel/GroupTitleItem;", "getGroupItem", "()Lcom/tencent/mm/emoji/model/panel/GroupTitleItem;", "equals", "", "other", "", "getGroupInfo", "getItemList", "", "plugin-emojisdk_release"})
public abstract class a
  implements w
{
  final u gXV;
  protected final LinkedList<ac> gXW;
  
  public a(EmojiGroupInfo paramEmojiGroupInfo)
  {
    this.gXV = new u(paramEmojiGroupInfo);
    this.gXW = new LinkedList();
  }
  
  public final EmojiGroupInfo avm()
  {
    return this.gXV.gVA;
  }
  
  public final List<ac> avn()
  {
    return (List)this.gXW;
  }
  
  public boolean equals(Object paramObject)
  {
    return ((paramObject instanceof a)) && (p.j(((a)paramObject).gXV.gVA.hRu(), this.gXV.gVA.hRu()));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.emoji.b.b.a
 * JD-Core Version:    0.7.0.1
 */