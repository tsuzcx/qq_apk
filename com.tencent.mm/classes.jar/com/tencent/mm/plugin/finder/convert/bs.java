package com.tencent.mm.plugin.finder.convert;

import androidx.recyclerview.widget.RecyclerView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.e.f;
import com.tencent.mm.plugin.finder.feed.au;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.view.recyclerview.f;
import com.tencent.mm.view.recyclerview.j;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/convert/FinderNearbyLiveFollowAllDividerConvert;", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "Lcom/tencent/mm/plugin/finder/feed/FinderStreamCardFeed;", "isForceNightMode", "", "(Z)V", "()Z", "adapteLiveFlagColor", "", "view", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "adapteTextViewColor", "Landroid/widget/TextView;", "adapteViewBackGroundColor", "Landroid/view/View;", "getLayoutId", "", "onBindViewHolder", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "item", "position", "type", "isHotPatch", "payloads", "", "", "onCreateViewHolder", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "setTips", "Companion", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class bs
  extends f<au>
{
  public static final a ALo;
  private final boolean ALp;
  
  static
  {
    AppMethodBeat.i(350313);
    ALo = new a((byte)0);
    AppMethodBeat.o(350313);
  }
  
  public bs(boolean paramBoolean)
  {
    AppMethodBeat.i(350306);
    this.ALp = paramBoolean;
    Log.i("FinderNearbyLiveFollowAllDividerConvert", "#init");
    AppMethodBeat.o(350306);
  }
  
  public final void a(RecyclerView paramRecyclerView, j paramj, int paramInt)
  {
    AppMethodBeat.i(350327);
    s.u(paramRecyclerView, "recyclerView");
    s.u(paramj, "holder");
    AppMethodBeat.o(350327);
  }
  
  public final int getLayoutId()
  {
    return e.f.finder_nearby_live_follow_all_divider_layout;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/convert/FinderNearbyLiveFollowAllDividerConvert$Companion;", "", "()V", "TAG", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.convert.bs
 * JD-Core Version:    0.7.0.1
 */