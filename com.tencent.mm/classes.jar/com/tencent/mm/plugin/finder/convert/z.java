package com.tencent.mm.plugin.finder.convert;

import android.support.v7.widget.RecyclerView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.view.recyclerview.e;
import com.tencent.mm.view.recyclerview.h;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/convert/FinderFeedLiveListItemConvert;", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "Lcom/tencent/mm/plugin/finder/model/FinderFeedLiveListItem;", "fragmentTabType", "", "(I)V", "MAX_NAME_COUNT", "getMAX_NAME_COUNT", "()I", "TAG", "", "getTAG", "()Ljava/lang/String;", "bindConfig", "", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "item", "bindFriendConfig", "bindLbsConfig", "getLayoutId", "onBindViewHolder", "position", "type", "isHotPatch", "", "payloads", "", "", "onCreateViewHolder", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "refreshMask", "plugin-finder_release"})
public final class z
  extends e<com.tencent.mm.plugin.finder.model.y>
{
  private final String TAG;
  private final int tDo;
  private final int tDx;
  
  public z(int paramInt)
  {
    this.tDo = paramInt;
    this.TAG = "FinderFeedLiveListItemConvert";
    this.tDx = 5;
  }
  
  public final void a(RecyclerView paramRecyclerView, h paramh, int paramInt)
  {
    AppMethodBeat.i(243072);
    p.h(paramRecyclerView, "recyclerView");
    p.h(paramh, "holder");
    AppMethodBeat.o(243072);
  }
  
  public final int getLayoutId()
  {
    AppMethodBeat.i(243071);
    if (com.tencent.mm.plugin.finder.utils.y.a(com.tencent.mm.plugin.finder.utils.y.vXH, this.tDo, 0, 2))
    {
      AppMethodBeat.o(243071);
      return 2131494291;
    }
    AppMethodBeat.o(243071);
    return 2131494292;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.convert.z
 * JD-Core Version:    0.7.0.1
 */