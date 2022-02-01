package com.tencent.mm.plugin.finder.convert;

import android.support.v7.widget.RecyclerView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.model.al;
import com.tencent.mm.protocal.protobuf.axk;
import com.tencent.mm.view.recyclerview.e;
import com.tencent.mm.view.recyclerview.h;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/convert/FinderLiveSubTagConvert;", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "Lcom/tencent/mm/plugin/finder/model/FinderLiveTagData;", "selectedTagInfo", "Lcom/tencent/mm/protocal/protobuf/FinderLiveTagInfo;", "(Lcom/tencent/mm/protocal/protobuf/FinderLiveTagInfo;)V", "getSelectedTagInfo", "()Lcom/tencent/mm/protocal/protobuf/FinderLiveTagInfo;", "setSelectedTagInfo", "getLayoutId", "", "onBindViewHolder", "", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "item", "position", "type", "isHotPatch", "", "payloads", "", "", "onCreateViewHolder", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "plugin-finder_release"})
public final class at
  extends e<al>
{
  public axk tEC;
  
  public at(axk paramaxk)
  {
    this.tEC = paramaxk;
  }
  
  public final void a(RecyclerView paramRecyclerView, h paramh, int paramInt)
  {
    AppMethodBeat.i(243155);
    p.h(paramRecyclerView, "recyclerView");
    p.h(paramh, "holder");
    AppMethodBeat.o(243155);
  }
  
  public final int getLayoutId()
  {
    return 2131494460;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.convert.at
 * JD-Core Version:    0.7.0.1
 */