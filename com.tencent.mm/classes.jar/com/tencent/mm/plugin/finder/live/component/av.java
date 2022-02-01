package com.tencent.mm.plugin.finder.live.component;

import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.live.p.e;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/component/LotteryViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Landroid/view/View;)V", "chooseDesc", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "getChooseDesc", "()Landroid/widget/TextView;", "setChooseDesc", "(Landroid/widget/TextView;)V", "chooseResult", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "getChooseResult", "()Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "setChooseResult", "(Lcom/tencent/mm/ui/widget/imageview/WeImageView;)V", "chooseTitle", "getChooseTitle", "setChooseTitle", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class av
  extends RecyclerView.v
{
  TextView CBf;
  TextView CBg;
  WeImageView CBh;
  
  public av(View paramView)
  {
    super(paramView);
    AppMethodBeat.i(352723);
    this.CBf = ((TextView)paramView.findViewById(p.e.BXr));
    this.CBg = ((TextView)paramView.findViewById(p.e.BXp));
    this.CBh = ((WeImageView)paramView.findViewById(p.e.BXq));
    AppMethodBeat.o(352723);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.component.av
 * JD-Core Version:    0.7.0.1
 */