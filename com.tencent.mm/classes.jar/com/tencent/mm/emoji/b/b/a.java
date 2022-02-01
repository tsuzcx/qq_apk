package com.tencent.mm.emoji.b.b;

import com.tencent.mm.storage.emotion.EmojiGroupInfo;
import java.util.LinkedList;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/emoji/model/panel/AbsPanelItemGroup;", "Lcom/tencent/mm/emoji/model/panel/IPanelItemGroup;", "groupInfo", "Lcom/tencent/mm/storage/emotion/EmojiGroupInfo;", "(Lcom/tencent/mm/storage/emotion/EmojiGroupInfo;)V", "contentList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/emoji/model/panel/PanelItem;", "getContentList", "()Ljava/util/LinkedList;", "groupItem", "Lcom/tencent/mm/emoji/model/panel/GroupTitleItem;", "getGroupItem", "()Lcom/tencent/mm/emoji/model/panel/GroupTitleItem;", "equals", "", "other", "", "getGroupInfo", "getItemList", "", "plugin-emojisdk_release"})
public abstract class a
  implements y
{
  private final w jIV;
  protected final LinkedList<ae> jIW;
  
  public a(EmojiGroupInfo paramEmojiGroupInfo)
  {
    this.jIV = new w(paramEmojiGroupInfo);
    this.jIW = new LinkedList();
  }
  
  public final w aCh()
  {
    return this.jIV;
  }
  
  public final EmojiGroupInfo aCi()
  {
    return this.jIV.jGw;
  }
  
  public final List<ae> aCj()
  {
    return (List)this.jIW;
  }
  
  public boolean equals(Object paramObject)
  {
    return ((paramObject instanceof a)) && (p.h(((a)paramObject).jIV.jGw.hBl(), this.jIV.jGw.hBl()));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.emoji.b.b.a
 * JD-Core Version:    0.7.0.1
 */