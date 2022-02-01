package com.tencent.mm.plugin.finder.convert;

import android.graphics.Point;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.e.e;
import com.tencent.mm.plugin.finder.e.f;
import com.tencent.mm.plugin.finder.model.ap;
import com.tencent.mm.plugin.finder.utils.aw;
import com.tencent.mm.view.recyclerview.f;
import kotlin.Metadata;
import kotlin.g.a.a;
import kotlin.g.b.s;
import kotlin.k;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/convert/FinderProfileReplayLiveConvert;", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "Lcom/tencent/mm/plugin/finder/model/FinderLiveReplayFeed;", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "screenPoint", "Landroid/graphics/Point;", "kotlin.jvm.PlatformType", "getScreenPoint", "()Landroid/graphics/Point;", "screenPoint$delegate", "Lkotlin/Lazy;", "getLayoutId", "", "onBindViewHolder", "", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "item", "position", "type", "isHotPatch", "", "payloads", "", "", "onCreateViewHolder", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class ce
  extends f<ap>
{
  private final kotlin.j AMa;
  private final String TAG;
  
  public ce()
  {
    AppMethodBeat.i(349729);
    this.TAG = "FinderProfileReplayLiveConvert";
    this.AMa = k.cm((a)ce.a.AMh);
    AppMethodBeat.o(349729);
  }
  
  private final Point dXX()
  {
    AppMethodBeat.i(349734);
    Point localPoint = (Point)this.AMa.getValue();
    AppMethodBeat.o(349734);
    return localPoint;
  }
  
  public final void a(RecyclerView paramRecyclerView, com.tencent.mm.view.recyclerview.j paramj, int paramInt)
  {
    AppMethodBeat.i(349745);
    s.u(paramRecyclerView, "recyclerView");
    s.u(paramj, "holder");
    paramRecyclerView = aw.Gjk;
    paramRecyclerView = paramj.UH(e.e.replay_selling_price);
    s.s(paramRecyclerView, "holder.getView<TextView>….id.replay_selling_price)");
    aw.f((TextView)paramRecyclerView, false);
    AppMethodBeat.o(349745);
  }
  
  public final int getLayoutId()
  {
    return e.f.finder_profile_replay_live_item;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.convert.ce
 * JD-Core Version:    0.7.0.1
 */