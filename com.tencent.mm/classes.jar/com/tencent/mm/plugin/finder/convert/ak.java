package com.tencent.mm.plugin.finder.convert;

import android.support.v7.widget.RecyclerView;
import com.tencent.mm.plugin.finder.model.a;
import com.tencent.mm.view.recyclerview.b;
import com.tencent.mm.view.recyclerview.e;
import d.g.b.p;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/convert/FinderMsgConvert;", "T", "Lcom/tencent/mm/plugin/finder/model/BaseFinderMsg;", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "layoutResId", "", "scene", "(II)V", "convertMsg", "", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "item", "position", "(Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;Lcom/tencent/mm/plugin/finder/model/BaseFinderMsg;I)V", "getLayoutId", "onBindViewHolder", "type", "isHotPatch", "", "payloads", "", "", "(Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;Lcom/tencent/mm/plugin/finder/model/BaseFinderMsg;IIZLjava/util/List;)V", "onCreateViewHolder", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "plugin-finder_release"})
public abstract class ak<T extends a>
  extends b<T>
{
  private final int rOh;
  private final int scene;
  
  public ak(int paramInt1, int paramInt2)
  {
    this.rOh = paramInt1;
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
    return this.rOh;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.convert.ak
 * JD-Core Version:    0.7.0.1
 */