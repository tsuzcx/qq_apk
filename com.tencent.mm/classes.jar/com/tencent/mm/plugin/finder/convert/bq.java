package com.tencent.mm.plugin.finder.convert;

import com.tencent.mm.plugin.finder.e.f;
import com.tencent.mm.plugin.finder.model.bk;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/convert/FinderMsgNotifyConvert;", "Lcom/tencent/mm/plugin/finder/convert/FinderMsgConvert;", "Lcom/tencent/mm/plugin/finder/model/FinderMsgNotify;", "scene", "", "(I)V", "getScene", "()I", "checkAndReportTopicMsg", "", "context", "Landroid/content/Context;", "notify", "Lcom/tencent/mm/protocal/protobuf/FinderNotification;", "fieldId", "", "convertMsg", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "item", "position", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class bq
  extends bf<bk>
{
  private final int scene;
  
  public bq(int paramInt)
  {
    super(e.f.finder_msg_item_of_notify, paramInt);
    this.scene = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.convert.bq
 * JD-Core Version:    0.7.0.1
 */