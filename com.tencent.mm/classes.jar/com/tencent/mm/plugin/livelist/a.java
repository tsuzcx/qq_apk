package com.tencent.mm.plugin.livelist;

import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/livelist/BaseMMLiveListItem;", "Lcom/tencent/mm/plugin/livelist/IMMLiveListItem;", "()V", "clone", "getChangeObject", "Lcom/tencent/mm/plugin/livelist/MMLiveItemChangeObj;", "T", "old", "getItemId", "", "isSameItem", "", "other", "plugin-livelist_release"})
public abstract class a
  implements b
{
  public final <T extends b> c<T> a(b paramb)
  {
    p.k(paramb, "old");
    return new c(paramb);
  }
  
  public final boolean b(b paramb)
  {
    p.k(paramb, "other");
    return p.h(eLP(), paramb.eLP());
  }
  
  public b eLO()
  {
    return (b)this;
  }
  
  public final long mf()
  {
    return eLP().hashCode();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.livelist.a
 * JD-Core Version:    0.7.0.1
 */