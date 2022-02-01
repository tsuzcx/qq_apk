package com.tencent.mm.plugin.finder.convert;

import com.tencent.mm.plugin.finder.e.f;
import com.tencent.mm.plugin.finder.model.bi;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/convert/FinderMsgMentionedConvert;", "Lcom/tencent/mm/plugin/finder/convert/FinderMsgConvert;", "Lcom/tencent/mm/plugin/finder/model/FinderMsgMentioned;", "scene", "", "(I)V", "AT_PREFFIX", "", "getAT_PREFFIX", "()Ljava/lang/String;", "TAG", "getTAG", "getScene", "()I", "convertMsg", "", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "item", "position", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class bn
  extends bf<bi>
{
  private final String ALn;
  private final String TAG;
  private final int scene;
  
  public bn(int paramInt)
  {
    super(e.f.finder_msg_item_of_mentioned, paramInt);
    this.scene = paramInt;
    this.TAG = "Finder.FinderMsgMentionedConvert";
    this.ALn = "@";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.convert.bn
 * JD-Core Version:    0.7.0.1
 */