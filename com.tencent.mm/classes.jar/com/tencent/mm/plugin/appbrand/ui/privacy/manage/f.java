package com.tencent.mm.plugin.appbrand.ui.privacy.manage;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ba.f;
import com.tencent.mm.plugin.appbrand.ba.g;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/ui/privacy/manage/AuthorizeScopeListViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "parent", "Landroid/view/ViewGroup;", "(Landroid/view/ViewGroup;)V", "appAuthInfoView", "Landroid/widget/TextView;", "getAppAuthInfoView", "()Landroid/widget/TextView;", "appIconView", "Landroid/widget/ImageView;", "getAppIconView", "()Landroid/widget/ImageView;", "appNameView", "getAppNameView", "dividerView", "Landroid/view/View;", "getDividerView", "()Landroid/view/View;", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
final class f
  extends RecyclerView.v
{
  final View rpv;
  final ImageView ujj;
  final TextView ujk;
  final TextView ujl;
  
  public f(ViewGroup paramViewGroup)
  {
    super(LayoutInflater.from(paramViewGroup.getContext()).inflate(ba.g.app_brand_privacy_manage_auth_info_item, paramViewGroup, false));
    AppMethodBeat.i(322984);
    this.ujj = ((ImageView)this.caK.findViewById(ba.f.app_icon_view));
    this.ujk = ((TextView)this.caK.findViewById(ba.f.app_name_view));
    this.ujl = ((TextView)this.caK.findViewById(ba.f.app_auth_info_view));
    this.rpv = this.caK.findViewById(ba.f.divider_view);
    AppMethodBeat.o(322984);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.privacy.manage.f
 * JD-Core Version:    0.7.0.1
 */