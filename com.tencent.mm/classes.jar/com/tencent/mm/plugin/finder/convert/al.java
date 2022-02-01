package com.tencent.mm.plugin.finder.convert;

import android.support.v7.widget.RecyclerView;
import com.tencent.mm.plugin.finder.model.a;
import com.tencent.mm.view.recyclerview.b;
import com.tencent.mm.view.recyclerview.e;
import d.g.b.p;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/convert/FinderMsgConvert;", "T", "Lcom/tencent/mm/plugin/finder/model/BaseFinderMsg;", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "layoutResId", "", "scene", "(II)V", "convertMsg", "", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "item", "position", "(Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;Lcom/tencent/mm/plugin/finder/model/BaseFinderMsg;I)V", "getLayoutId", "onBindViewHolder", "type", "isHotPatch", "", "payloads", "", "", "(Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;Lcom/tencent/mm/plugin/finder/model/BaseFinderMsg;IIZLjava/util/List;)V", "onCreateViewHolder", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "plugin-finder_release"})
public abstract class al<T extends a>
  extends b<T>
{
  private final int rWE;
  private final int scene;
  
  public al(int paramInt1, int paramInt2)
  {
    this.rWE = paramInt1;
    this.scene = paramInt2;
  }
  
  public final void a(RecyclerView paramRecyclerView, e parame, int paramInt)
  {
    p.h(paramRecyclerView, "recyclerView");
    p.h(parame, "holder");
  }
  
  public abstract void a(e parame, T paramT);
  
  public final int getLayoutId()
  {
    return this.rWE;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.convert.al
 * JD-Core Version:    0.7.0.1
 */