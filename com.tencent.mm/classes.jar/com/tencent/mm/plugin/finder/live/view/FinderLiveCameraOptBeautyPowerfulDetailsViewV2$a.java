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

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/view/FinderLiveCameraOptBeautyPowerfulDetailsViewV2$BeautyAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/tencent/mm/plugin/finder/live/view/FinderLiveCameraOptBeautyPowerfulDetailsViewV2$CameraOptBeautyViewHolder;", "(Lcom/tencent/mm/plugin/finder/live/view/FinderLiveCameraOptBeautyPowerfulDetailsViewV2;)V", "getItemCount", "", "onBindViewHolder", "", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "type", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
final class FinderLiveCameraOptBeautyPowerfulDetailsViewV2$a
  extends RecyclerView.a<FinderLiveCameraOptBeautyPowerfulDetailsViewV2.b>
{
  public FinderLiveCameraOptBeautyPowerfulDetailsViewV2$a()
  {
    AppMethodBeat.i(357773);
    AppMethodBeat.o(357773);
  }
  
  private static final void a(FinderLiveCameraOptBeautyPowerfulDetailsViewV2 paramFinderLiveCameraOptBeautyPowerfulDetailsViewV2, int paramInt, View paramView)
  {
    AppMethodBeat.i(357781);
    Object localObject = new Object();
    b localb = new b();
    localb.cH(paramFinderLiveCameraOptBeautyPowerfulDetailsViewV2);
    localb.sc(paramInt);
    localb.cH(paramView);
    a.c("com/tencent/mm/plugin/finder/live/view/FinderLiveCameraOptBeautyPowerfulDetailsViewV2$BeautyAdapter", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramFinderLiveCameraOptBeautyPowerfulDetailsViewV2, "this$0");
    paramFinderLiveCameraOptBeautyPowerfulDetailsViewV2.setSelectedEffect((FinderLiveCameraOptBeautyPowerfulDetailsViewV2.d)p.ae(paramFinderLiveCameraOptBeautyPowerfulDetailsViewV2.getEffectItems(), paramInt));
    a.a(new Object(), "com/tencent/mm/plugin/finder/live/view/FinderLiveCameraOptBeautyPowerfulDetailsViewV2$BeautyAdapter", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(357781);
  }
  
  public final int getItemCount()
  {
    AppMethodBeat.i(357793);
    int i = this.DLM.getEffectItems().size();
    AppMethodBeat.o(357793);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.view.FinderLiveCameraOptBeautyPowerfulDetailsViewV2.a
 * JD-Core Version:    0.7.0.1
 */