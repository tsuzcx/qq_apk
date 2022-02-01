package com.tencent.mm.plugin.finder.convert;

import androidx.recyclerview.widget.RecyclerView;
import com.tencent.mm.plugin.finder.model.a;
import com.tencent.mm.view.recyclerview.e;
import com.tencent.mm.view.recyclerview.i;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/convert/FinderMsgConvert;", "T", "Lcom/tencent/mm/plugin/finder/model/BaseFinderMsg;", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "layoutResId", "", "scene", "(II)V", "convertMsg", "", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "item", "position", "(Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;Lcom/tencent/mm/plugin/finder/model/BaseFinderMsg;I)V", "getLayoutId", "onBindViewHolder", "type", "isHotPatch", "", "payloads", "", "", "(Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;Lcom/tencent/mm/plugin/finder/model/BaseFinderMsg;IIZLjava/util/List;)V", "onCreateViewHolder", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "showFinderMentionDialog", "context", "Landroid/content/Context;", "finderMention", "Lcom/tencent/mm/plugin/finder/storage/LocalFinderMention;", "plugin-finder_release"})
public abstract class bj<T extends a>
  extends e<T>
{
  private final int scene;
  private final int xmc;
  
  public bj(int paramInt1, int paramInt2)
  {
    this.xmc = paramInt1;
    this.scene = paramInt2;
  }
  
  public final void a(RecyclerView paramRecyclerView, i parami, int paramInt)
  {
    p.k(paramRecyclerView, "recyclerView");
    p.k(parami, "holder");
  }
  
  public abstract void a(i parami, T paramT);
  
  public final int getLayoutId()
  {
    return this.xmc;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.convert.bj
 * JD-Core Version:    0.7.0.1
 */