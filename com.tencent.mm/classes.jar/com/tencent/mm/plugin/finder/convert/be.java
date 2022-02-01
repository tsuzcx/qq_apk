package com.tencent.mm.plugin.finder.convert;

import com.tencent.mm.plugin.finder.e.f;
import com.tencent.mm.plugin.finder.model.bb;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/convert/FinderMsgCommentNewConvert;", "Lcom/tencent/mm/plugin/finder/convert/FinderMsgConvert;", "Lcom/tencent/mm/plugin/finder/model/FinderMsgComment;", "scene", "", "(I)V", "TAG", "", "getTAG", "()Ljava/lang/String;", "getScene", "()I", "convertMsg", "", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "item", "position", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class be
  extends bf<bb>
{
  private final String TAG;
  private final int scene;
  
  public be(int paramInt)
  {
    super(e.f.finder_msg_item_of_comment_new, paramInt);
    this.scene = paramInt;
    this.TAG = "Finder.FinderMsgCommentConvert";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.convert.be
 * JD-Core Version:    0.7.0.1
 */