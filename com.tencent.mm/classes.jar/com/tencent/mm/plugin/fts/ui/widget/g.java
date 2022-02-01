package com.tencent.mm.plugin.fts.ui.widget;

import com.tencent.mm.protocal.protobuf.epl;
import com.tencent.mm.view.recyclerview.a;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/fts/ui/widget/KeyboardSugItem;", "Lcom/tencent/mm/view/recyclerview/ConvertData;", "id", "", "type", "", "sugItem", "Lcom/tencent/mm/protocal/protobuf/SugItem;", "(JILcom/tencent/mm/protocal/protobuf/SugItem;)V", "getId", "()J", "getSugItem", "()Lcom/tencent/mm/protocal/protobuf/SugItem;", "setSugItem", "(Lcom/tencent/mm/protocal/protobuf/SugItem;)V", "getType", "()I", "getItemId", "getItemType", "ui-fts_release"})
public final class g
  implements a
{
  epl BRY;
  final long id;
  private final int type;
  
  public g(long paramLong, int paramInt, epl paramepl)
  {
    this.id = paramLong;
    this.type = paramInt;
    this.BRY = paramepl;
  }
  
  public final int bAQ()
  {
    return this.type;
  }
  
  public final long mf()
  {
    return this.id;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.widget.g
 * JD-Core Version:    0.7.0.1
 */