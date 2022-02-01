package com.tencent.mm.plugin.livelist;

import com.tencent.mm.view.recyclerview.a;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/livelist/IMMLiveListItem;", "Lcom/tencent/mm/view/recyclerview/ConvertData;", "", "clone", "getChangeObject", "Lcom/tencent/mm/plugin/livelist/MMLiveItemChangeObj;", "T", "old", "getUniqueId", "", "isSameContent", "", "other", "isSameItem", "plugin-livelist_release"})
public abstract interface b
  extends a, Comparable<b>
{
  public abstract <T extends b> c<T> a(b paramb);
  
  public abstract boolean b(b paramb);
  
  public abstract boolean c(b paramb);
  
  public abstract b eLO();
  
  public abstract String eLP();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.livelist.b
 * JD-Core Version:    0.7.0.1
 */