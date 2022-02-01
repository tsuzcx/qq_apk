package com.tencent.mm.plugin.finder.view;

import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.e.e;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/view/TestPreloadPreview$TestHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Landroid/view/View;)V", "mediaIdTv", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "getMediaIdTv", "()Landroid/widget/TextView;", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class TestPreloadPreview$d
  extends RecyclerView.v
{
  final TextView GFQ;
  
  public TestPreloadPreview$d(View paramView)
  {
    super(paramView);
    AppMethodBeat.i(344221);
    this.GFQ = ((TextView)paramView.findViewById(e.e.media_id_tv));
    AppMethodBeat.o(344221);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.view.TestPreloadPreview.d
 * JD-Core Version:    0.7.0.1
 */