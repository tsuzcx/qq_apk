package com.tencent.mm.plugin.appbrand.ui.collection;

import a.f.b.j;
import a.l;
import android.support.v7.widget.RecyclerView.v;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelappbrand.a.b.f;
import com.tencent.mm.plugin.appbrand.appusage.LocalUsageInfo;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/appbrand/ui/collection/CollectionViewHolder;", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "Landroid/view/View$OnClickListener;", "itemView", "Landroid/view/View;", "(Landroid/view/View;)V", "imageIcon", "Landroid/widget/ImageView;", "getImageIcon", "()Landroid/widget/ImageView;", "itemInfo", "Lcom/tencent/mm/plugin/appbrand/appusage/LocalUsageInfo;", "getItemInfo$plugin_appbrand_integration_release", "()Lcom/tencent/mm/plugin/appbrand/appusage/LocalUsageInfo;", "setItemInfo$plugin_appbrand_integration_release", "(Lcom/tencent/mm/plugin/appbrand/appusage/LocalUsageInfo;)V", "textName", "Landroid/widget/TextView;", "getTextName", "()Landroid/widget/TextView;", "textType", "getTextType", "fillContent", "", "dataItem", "onClick", "v", "plugin-appbrand-integration_release"})
public final class m
  extends RecyclerView.v
  implements View.OnClickListener
{
  final TextView iSf;
  private final TextView iSg;
  final ImageView iSh;
  LocalUsageInfo iSj;
  
  public m(View paramView)
  {
    super(paramView);
    AppMethodBeat.i(135122);
    paramView.setOnClickListener((View.OnClickListener)this);
    View localView = paramView.findViewById(2131820737);
    j.p(localView, "itemView.findViewById(R.id.name)");
    this.iSf = ((TextView)localView);
    localView = paramView.findViewById(2131821171);
    j.p(localView, "itemView.findViewById(R.id.tag_text)");
    this.iSg = ((TextView)localView);
    paramView = paramView.findViewById(2131820929);
    j.p(paramView, "itemView.findViewById(R.id.icon)");
    this.iSh = ((ImageView)paramView);
    AppMethodBeat.o(135122);
  }
  
  public final void f(LocalUsageInfo paramLocalUsageInfo)
  {
    AppMethodBeat.i(135121);
    j.q(paramLocalUsageInfo, "dataItem");
    this.iSj = paramLocalUsageInfo;
    this.iSf.setText((CharSequence)paramLocalUsageInfo.nickname);
    String str = com.tencent.mm.plugin.appbrand.appcache.b.nj(paramLocalUsageInfo.hcr);
    CharSequence localCharSequence = (CharSequence)str;
    int i;
    if ((localCharSequence == null) || (localCharSequence.length() == 0))
    {
      i = 1;
      if (i == 0) {
        break label109;
      }
      this.iSg.setVisibility(8);
    }
    for (;;)
    {
      com.tencent.mm.modelappbrand.a.b.acD().a(this.iSh, paramLocalUsageInfo.hcN, com.tencent.mm.modelappbrand.a.a.acC(), (b.f)com.tencent.mm.modelappbrand.a.f.fqU);
      AppMethodBeat.o(135121);
      return;
      i = 0;
      break;
      label109:
      this.iSg.setVisibility(0);
      this.iSg.setText((CharSequence)str);
    }
  }
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(135120);
    Object localObject = this.iSj;
    if (localObject != null)
    {
      com.tencent.luggage.sdk.customize.a locala = com.tencent.mm.plugin.appbrand.launching.precondition.f.ioc;
      if (paramView == null) {
        j.ebi();
      }
      paramView = paramView.getContext();
      String str1 = ((LocalUsageInfo)localObject).username;
      String str2 = ((LocalUsageInfo)localObject).appId;
      int i = ((LocalUsageInfo)localObject).hcr;
      localObject = new AppBrandStatObject();
      ((AppBrandStatObject)localObject).scene = 1103;
      locala.a(paramView, str1, str2, null, i, 0, (AppBrandStatObject)localObject, null, null);
      AppMethodBeat.o(135120);
      return;
    }
    AppMethodBeat.o(135120);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.collection.m
 * JD-Core Version:    0.7.0.1
 */