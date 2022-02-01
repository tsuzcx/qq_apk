package com.tencent.mm.plugin.finder.convert;

import android.graphics.Paint;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.e.e;
import com.tencent.mm.plugin.finder.e.f;
import com.tencent.mm.plugin.finder.model.ap;
import com.tencent.mm.ui.aw;
import com.tencent.mm.view.recyclerview.f;
import com.tencent.mm.view.recyclerview.j;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/convert/FinderLivePurchaseListConvert;", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "Lcom/tencent/mm/plugin/finder/model/FinderLiveReplayFeed;", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "getLayoutId", "", "onBindViewHolder", "", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "item", "position", "type", "isHotPatch", "", "payloads", "", "", "onCreateViewHolder", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "setAuthIcon", "feed", "authIcon", "Landroid/widget/ImageView;", "setReplayStatus", "replayStatusTv", "Landroid/widget/TextView;", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class aq
  extends f<ap>
{
  private final String TAG = "FinderLivePurchaseListConvert";
  
  public final void a(RecyclerView paramRecyclerView, j paramj, int paramInt)
  {
    AppMethodBeat.i(350189);
    s.u(paramRecyclerView, "recyclerView");
    s.u(paramj, "holder");
    aw.a((Paint)((TextView)paramj.UH(e.e.replay_user_nickname)).getPaint(), 0.8F);
    AppMethodBeat.o(350189);
  }
  
  public final int getLayoutId()
  {
    return e.f.finder_live_purchase_list_item;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.convert.aq
 * JD-Core Version:    0.7.0.1
 */