package com.tencent.mm.plugin.appbrand.ui.privacy.use_record;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ba.f;
import com.tencent.mm.plugin.appbrand.ba.g;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/ui/privacy/use_record/PrivacyUseRecordViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "parent", "Landroid/view/ViewGroup;", "(Landroid/view/ViewGroup;)V", "bottomDividerView", "Landroid/view/View;", "getBottomDividerView", "()Landroid/view/View;", "pluginUseView", "Landroid/widget/TextView;", "getPluginUseView", "()Landroid/widget/TextView;", "scopeNameView", "getScopeNameView", "timeView", "getTimeView", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
final class d
  extends RecyclerView.v
{
  final TextView ulc;
  final TextView uld;
  final TextView ule;
  final View ulf;
  
  public d(ViewGroup paramViewGroup)
  {
    super(LayoutInflater.from(paramViewGroup.getContext()).inflate(ba.g.app_brand_privacy_use_record_item, paramViewGroup, false));
    AppMethodBeat.i(322754);
    this.ulc = ((TextView)this.caK.findViewById(ba.f.scope_name_view));
    this.uld = ((TextView)this.caK.findViewById(ba.f.plugin_use_view));
    this.ule = ((TextView)this.caK.findViewById(ba.f.time_view));
    this.ulf = this.caK.findViewById(ba.f.bottom_divider_view);
    AppMethodBeat.o(322754);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.privacy.use_record.d
 * JD-Core Version:    0.7.0.1
 */