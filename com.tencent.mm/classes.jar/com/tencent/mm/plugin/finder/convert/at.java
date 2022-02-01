package com.tencent.mm.plugin.finder.convert;

import android.graphics.Paint;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.live.p.e;
import com.tencent.mm.plugin.finder.live.p.f;
import com.tencent.mm.plugin.finder.model.as;
import com.tencent.mm.ui.aw;
import com.tencent.mm.view.recyclerview.f;
import com.tencent.mm.view.recyclerview.j;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/convert/FinderLiveWeCoinHotConvert;", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "Lcom/tencent/mm/plugin/finder/model/FinderLiveWeCoinData;", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "getLayoutId", "", "onBindViewHolder", "", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "item", "position", "type", "isHotPatch", "", "payloads", "", "", "onCreateViewHolder", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "setRankTv", "rankTv", "Landroid/widget/TextView;", "contact", "Lcom/tencent/mm/protocal/protobuf/FinderLiveContact;", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class at
  extends f<as>
{
  private final String TAG = "FinderLiveWeCoinHotConvert";
  
  public final void a(RecyclerView paramRecyclerView, j paramj, int paramInt)
  {
    AppMethodBeat.i(350196);
    s.u(paramRecyclerView, "recyclerView");
    s.u(paramj, "holder");
    paramRecyclerView = (TextView)paramj.UH(p.e.BUh);
    if (paramRecyclerView == null) {}
    for (paramRecyclerView = null;; paramRecyclerView = paramRecyclerView.getPaint())
    {
      aw.a((Paint)paramRecyclerView, 0.8F);
      AppMethodBeat.o(350196);
      return;
    }
  }
  
  public final int getLayoutId()
  {
    return p.f.Cgh;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.convert.at
 * JD-Core Version:    0.7.0.1
 */