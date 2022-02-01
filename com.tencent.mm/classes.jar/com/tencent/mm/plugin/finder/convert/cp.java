package com.tencent.mm.plugin.finder.convert;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.a;
import com.tencent.mm.plugin.finder.e.c;
import com.tencent.mm.plugin.finder.e.f;
import com.tencent.mm.plugin.finder.model.z;
import com.tencent.mm.view.recyclerview.f;
import com.tencent.mm.view.recyclerview.j;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/convert/FinderSnsLiveListItemConvert;", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "Lcom/tencent/mm/plugin/finder/model/FinderFeedLiveListItem;", "()V", "MAX_NAME_COUNT", "", "getMAX_NAME_COUNT", "()I", "TAG", "", "getTAG", "()Ljava/lang/String;", "getLayoutId", "onBindViewHolder", "", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "item", "position", "type", "isHotPatch", "", "payloads", "", "", "onCreateViewHolder", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "refreshMask", "setItemSize", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class cp
  extends f<z>
{
  private final int AKn = 5;
  private final String TAG = "FinderFeedLiveListItemConvert";
  
  public final void a(RecyclerView paramRecyclerView, j paramj, int paramInt)
  {
    AppMethodBeat.i(349925);
    s.u(paramRecyclerView, "recyclerView");
    s.u(paramj, "holder");
    paramInt = paramj.context.getResources().getDisplayMetrics().widthPixels;
    float f2 = (Math.min(paramj.context.getResources().getDisplayMetrics().heightPixels, paramInt) - a.fromDPToPix(paramj.context, 16)) / 3.5F;
    float f1 = f2;
    if (f2 <= 0.0F) {
      f1 = paramj.context.getResources().getDimension(e.c.Edge_14A);
    }
    f2 = 4.0F * f1 / 3.0F;
    paramRecyclerView = paramj.caK.getLayoutParams();
    paramRecyclerView.width = ((int)f1);
    paramRecyclerView.height = ((int)f2);
    paramj.caK.setLayoutParams(paramRecyclerView);
    AppMethodBeat.o(349925);
  }
  
  public final int getLayoutId()
  {
    return e.f.finder_sns_live_list_square_item;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.convert.cp
 * JD-Core Version:    0.7.0.1
 */