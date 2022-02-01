package com.tencent.mm.plugin.fts.ui.widget;

import com.tencent.mm.protocal.protobuf.fkk;
import com.tencent.mm.view.recyclerview.a;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/fts/ui/widget/KeyboardSugItem;", "Lcom/tencent/mm/view/recyclerview/ConvertData;", "id", "", "type", "", "sugItem", "Lcom/tencent/mm/protocal/protobuf/SugItem;", "(JILcom/tencent/mm/protocal/protobuf/SugItem;)V", "getId", "()J", "getSugItem", "()Lcom/tencent/mm/protocal/protobuf/SugItem;", "setSugItem", "(Lcom/tencent/mm/protocal/protobuf/SugItem;)V", "getType", "()I", "getItemId", "getItemType", "ui-fts_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class i
  implements a
{
  fkk HDG;
  final long id;
  private final int type;
  
  public i(long paramLong, int paramInt, fkk paramfkk)
  {
    this.id = paramLong;
    this.type = paramInt;
    this.HDG = paramfkk;
  }
  
  public final long bZA()
  {
    return this.id;
  }
  
  public final int bZB()
  {
    return this.type;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.widget.i
 * JD-Core Version:    0.7.0.1
 */