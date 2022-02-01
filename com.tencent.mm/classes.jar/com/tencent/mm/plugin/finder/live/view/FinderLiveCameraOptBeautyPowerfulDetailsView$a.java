package com.tencent.mm.plugin.finder.live.view;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import java.util.List;
import kotlin.Metadata;
import kotlin.a.p;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/view/FinderLiveCameraOptBeautyPowerfulDetailsView$BeautyAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/tencent/mm/plugin/finder/live/view/FinderLiveCameraOptBeautyPowerfulDetailsView$CameraOptBeautyViewHolder;", "(Lcom/tencent/mm/plugin/finder/live/view/FinderLiveCameraOptBeautyPowerfulDetailsView;)V", "getItemCount", "", "onBindViewHolder", "", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "type", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
final class FinderLiveCameraOptBeautyPowerfulDetailsView$a
  extends RecyclerView.a<FinderLiveCameraOptBeautyPowerfulDetailsView.b>
{
  public FinderLiveCameraOptBeautyPowerfulDetailsView$a()
  {
    AppMethodBeat.i(357550);
    AppMethodBeat.o(357550);
  }
  
  private static final void a(FinderLiveCameraOptBeautyPowerfulDetailsView paramFinderLiveCameraOptBeautyPowerfulDetailsView, int paramInt, View paramView)
  {
    AppMethodBeat.i(357559);
    Object localObject = new Object();
    b localb = new b();
    localb.cH(paramFinderLiveCameraOptBeautyPowerfulDetailsView);
    localb.sc(paramInt);
    localb.cH(paramView);
    a.c("com/tencent/mm/plugin/finder/live/view/FinderLiveCameraOptBeautyPowerfulDetailsView$BeautyAdapter", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramFinderLiveCameraOptBeautyPowerfulDetailsView, "this$0");
    paramFinderLiveCameraOptBeautyPowerfulDetailsView.setSelectedEffect((FinderLiveCameraOptBeautyPowerfulDetailsView.d)p.ae(paramFinderLiveCameraOptBeautyPowerfulDetailsView.getEffectItems(), paramInt));
    a.a(new Object(), "com/tencent/mm/plugin/finder/live/view/FinderLiveCameraOptBeautyPowerfulDetailsView$BeautyAdapter", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(357559);
  }
  
  public final int getItemCount()
  {
    AppMethodBeat.i(357578);
    int i = this.DLB.getEffectItems().size();
    AppMethodBeat.o(357578);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.view.FinderLiveCameraOptBeautyPowerfulDetailsView.a
 * JD-Core Version:    0.7.0.1
 */