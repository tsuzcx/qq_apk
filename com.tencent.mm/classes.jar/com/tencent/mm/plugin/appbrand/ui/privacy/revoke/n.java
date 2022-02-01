package com.tencent.mm.plugin.appbrand.ui.privacy.revoke;

import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ba.f;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/ui/privacy/revoke/ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "view", "Landroid/view/View;", "(Landroid/view/View;)V", "Header", "Manage", "PluginTitle", "UserInfo", "Lcom/tencent/mm/plugin/appbrand/ui/privacy/revoke/ViewHolder$Header;", "Lcom/tencent/mm/plugin/appbrand/ui/privacy/revoke/ViewHolder$UserInfo;", "Lcom/tencent/mm/plugin/appbrand/ui/privacy/revoke/ViewHolder$PluginTitle;", "Lcom/tencent/mm/plugin/appbrand/ui/privacy/revoke/ViewHolder$Manage;", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
abstract class n
  extends RecyclerView.v
{
  private n(View paramView)
  {
    super(paramView);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/ui/privacy/revoke/ViewHolder$Header;", "Lcom/tencent/mm/plugin/appbrand/ui/privacy/revoke/ViewHolder;", "parent", "Landroid/view/ViewGroup;", "(Landroid/view/ViewGroup;)V", "appIconView", "Landroid/widget/ImageView;", "getAppIconView", "()Landroid/widget/ImageView;", "appInfoArea", "Landroid/widget/LinearLayout;", "getAppInfoArea", "()Landroid/widget/LinearLayout;", "appNameView", "Landroid/widget/TextView;", "getAppNameView", "()Landroid/widget/TextView;", "useHintView", "getUseHintView", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
    extends n
  {
    final ImageView ujj;
    final TextView ujk;
    final LinearLayout ukL;
    final TextView ukM;
    
    public a(ViewGroup paramViewGroup)
    {
      super((byte)0);
      AppMethodBeat.i(322924);
      this.ukL = ((LinearLayout)this.caK.findViewById(ba.f.app_info_area));
      this.ujj = ((ImageView)this.caK.findViewById(ba.f.app_icon_view));
      this.ujk = ((TextView)this.caK.findViewById(ba.f.app_name_view));
      this.ukM = ((TextView)this.caK.findViewById(ba.f.use_hint_view));
      AppMethodBeat.o(322924);
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/ui/privacy/revoke/ViewHolder$Manage;", "Lcom/tencent/mm/plugin/appbrand/ui/privacy/revoke/ViewHolder;", "parent", "Landroid/view/ViewGroup;", "(Landroid/view/ViewGroup;)V", "manageBtn", "Landroid/widget/Button;", "getManageBtn", "()Landroid/widget/Button;", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
    extends n
  {
    final Button ukN;
    
    public b(ViewGroup paramViewGroup)
    {
      super((byte)0);
      AppMethodBeat.i(322925);
      this.ukN = ((Button)this.caK.findViewById(ba.f.manage_btn));
      AppMethodBeat.o(322925);
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/ui/privacy/revoke/ViewHolder$PluginTitle;", "Lcom/tencent/mm/plugin/appbrand/ui/privacy/revoke/ViewHolder;", "parent", "Landroid/view/ViewGroup;", "(Landroid/view/ViewGroup;)V", "titleView", "Landroid/widget/TextView;", "getTitleView", "()Landroid/widget/TextView;", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class c
    extends n
  {
    final TextView titleView;
    
    public c(ViewGroup paramViewGroup)
    {
      super((byte)0);
      AppMethodBeat.i(322927);
      this.titleView = ((TextView)this.caK.findViewById(ba.f.plugin_title_view));
      AppMethodBeat.o(322927);
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/ui/privacy/revoke/ViewHolder$UserInfo;", "Lcom/tencent/mm/plugin/appbrand/ui/privacy/revoke/ViewHolder;", "parent", "Landroid/view/ViewGroup;", "(Landroid/view/ViewGroup;)V", "iconView", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "getIconView", "()Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "nameView", "Landroid/widget/TextView;", "getNameView", "()Landroid/widget/TextView;", "revokeHintView", "getRevokeHintView", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class d
    extends n
  {
    final WeImageView ukO;
    final TextView ukP;
    final TextView ukQ;
    
    public d(ViewGroup paramViewGroup)
    {
      super((byte)0);
      AppMethodBeat.i(322922);
      this.ukO = ((WeImageView)this.caK.findViewById(ba.f.user_info_icon_view));
      this.ukP = ((TextView)this.caK.findViewById(ba.f.user_info_name_view));
      this.ukQ = ((TextView)this.caK.findViewById(ba.f.user_info_revoke_hint_view));
      AppMethodBeat.o(322922);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.privacy.revoke.n
 * JD-Core Version:    0.7.0.1
 */