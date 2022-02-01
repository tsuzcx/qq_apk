package com.tencent.mm.plugin.fts.ui.widget;

import com.tencent.mm.protocal.protobuf.efk;
import com.tencent.mm.view.recyclerview.a;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/fts/ui/widget/KeyboardSugItem;", "Lcom/tencent/mm/view/recyclerview/ConvertData;", "id", "", "type", "", "sugItem", "Lcom/tencent/mm/protocal/protobuf/SugItem;", "(JILcom/tencent/mm/protocal/protobuf/SugItem;)V", "getId", "()J", "getSugItem", "()Lcom/tencent/mm/protocal/protobuf/SugItem;", "setSugItem", "(Lcom/tencent/mm/protocal/protobuf/SugItem;)V", "getType", "()I", "getItemId", "getItemType", "ui-fts_release"})
public final class g
  implements a
{
  final long id;
  private final int type;
  efk xfN;
  
  public g(long paramLong, int paramInt, efk paramefk)
  {
    this.id = paramLong;
    this.type = paramInt;
    this.xfN = paramefk;
  }
  
  public final int cxn()
  {
    return this.type;
  }
  
  public final long lT()
  {
    return this.id;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.widget.g
 * JD-Core Version:    0.7.0.1
 */