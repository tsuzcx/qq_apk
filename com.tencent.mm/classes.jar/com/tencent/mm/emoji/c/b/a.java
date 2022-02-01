package com.tencent.mm.emoji.c.b;

import com.tencent.mm.storage.emotion.EmojiGroupInfo;
import java.util.LinkedList;
import java.util.List;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/emoji/model/panel/AbsPanelItemGroup;", "Lcom/tencent/mm/emoji/model/panel/IPanelItemGroup;", "groupInfo", "Lcom/tencent/mm/storage/emotion/EmojiGroupInfo;", "(Lcom/tencent/mm/storage/emotion/EmojiGroupInfo;)V", "contentList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/emoji/model/panel/PanelItem;", "getContentList", "()Ljava/util/LinkedList;", "groupItem", "Lcom/tencent/mm/emoji/model/panel/GroupTitleItem;", "getGroupItem", "()Lcom/tencent/mm/emoji/model/panel/GroupTitleItem;", "equals", "", "other", "", "getGroupInfo", "getItemList", "", "plugin-emojisdk_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract class a
  implements y
{
  private final w mim;
  protected final LinkedList<ae> mio;
  
  public a(EmojiGroupInfo paramEmojiGroupInfo)
  {
    this.mim = new w(paramEmojiGroupInfo);
    this.mio = new LinkedList();
  }
  
  public final w aVd()
  {
    return this.mim;
  }
  
  public final EmojiGroupInfo aVe()
  {
    return this.mim.mgd;
  }
  
  public final List<ae> aVf()
  {
    return (List)this.mio;
  }
  
  public boolean equals(Object paramObject)
  {
    return ((paramObject instanceof a)) && (s.p(((a)paramObject).mim.mgd.field_productID, this.mim.mgd.field_productID));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.emoji.c.b.a
 * JD-Core Version:    0.7.0.1
 */