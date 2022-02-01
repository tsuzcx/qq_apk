package com.tencent.mm.plugin.finder.convert;

import com.tencent.mm.plugin.finder.b.g;
import com.tencent.mm.plugin.finder.model.ax;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/convert/FinderMsgCommentConvert;", "Lcom/tencent/mm/plugin/finder/convert/FinderMsgConvert;", "Lcom/tencent/mm/plugin/finder/model/FinderMsgComment;", "scene", "", "(I)V", "TAG", "", "getTAG", "()Ljava/lang/String;", "getScene", "()I", "convertMsg", "", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "item", "position", "plugin-finder_release"})
public final class bh
  extends bj<ax>
{
  private final String TAG;
  private final int scene;
  
  public bh(int paramInt)
  {
    super(b.g.finder_msg_item_of_comment, paramInt);
    this.scene = paramInt;
    this.TAG = "Finder.FinderMsgCommentConvert";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.convert.bh
 * JD-Core Version:    0.7.0.1
 */