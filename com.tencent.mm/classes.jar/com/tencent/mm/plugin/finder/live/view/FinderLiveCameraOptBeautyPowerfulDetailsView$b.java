package com.tencent.mm.plugin.finder.live.view;

import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.live.p.e;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/view/FinderLiveCameraOptBeautyPowerfulDetailsView$CameraOptBeautyViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Landroid/view/View;)V", "title", "Landroid/widget/TextView;", "getTitle", "()Landroid/widget/TextView;", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
final class FinderLiveCameraOptBeautyPowerfulDetailsView$b
  extends RecyclerView.v
{
  final TextView mll;
  
  public FinderLiveCameraOptBeautyPowerfulDetailsView$b(View paramView)
  {
    super(paramView);
    AppMethodBeat.i(357554);
    paramView = paramView.findViewById(p.e.BIe);
    s.s(paramView, "itemView.findViewById(R.…ra_opt_beauty_item_title)");
    this.mll = ((TextView)paramView);
    AppMethodBeat.o(357554);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.view.FinderLiveCameraOptBeautyPowerfulDetailsView.b
 * JD-Core Version:    0.7.0.1
 */