package com.tencent.mm.plugin.finder.convert;

import com.tencent.mm.plugin.finder.b.g;
import com.tencent.mm.plugin.finder.model.be;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/convert/FinderMsgMentionedConvert;", "Lcom/tencent/mm/plugin/finder/convert/FinderMsgConvert;", "Lcom/tencent/mm/plugin/finder/model/FinderMsgMentioned;", "scene", "", "(I)V", "AT_PREFFIX", "", "getAT_PREFFIX", "()Ljava/lang/String;", "TAG", "getTAG", "getScene", "()I", "convertMsg", "", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "item", "position", "plugin-finder_release"})
public final class bt
  extends bj<be>
{
  private final String TAG;
  private final int scene;
  private final String xnJ;
  
  public bt(int paramInt)
  {
    super(b.g.finder_msg_item_of_mentioned, paramInt);
    this.scene = paramInt;
    this.TAG = "Finder.FinderMsgMentionedConvert";
    this.xnJ = "@";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.convert.bt
 * JD-Core Version:    0.7.0.1
 */