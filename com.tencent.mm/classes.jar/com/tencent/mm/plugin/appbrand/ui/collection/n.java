package com.tencent.mm.plugin.appbrand.ui.collection;

import android.support.v7.widget.RecyclerView.v;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelappbrand.a.a;
import com.tencent.mm.modelappbrand.a.b;
import com.tencent.mm.modelappbrand.a.b.h;
import com.tencent.mm.modelappbrand.a.g;
import com.tencent.mm.plugin.appbrand.appcache.e;
import com.tencent.mm.plugin.appbrand.appusage.LocalUsageInfo;
import com.tencent.mm.plugin.appbrand.launching.e.f;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import d.g.b.k;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/appbrand/ui/collection/CollectionViewHolder;", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "Landroid/view/View$OnClickListener;", "itemView", "Landroid/view/View;", "(Landroid/view/View;)V", "imageIcon", "Landroid/widget/ImageView;", "getImageIcon", "()Landroid/widget/ImageView;", "itemInfo", "Lcom/tencent/mm/plugin/appbrand/appusage/LocalUsageInfo;", "getItemInfo$plugin_appbrand_integration_release", "()Lcom/tencent/mm/plugin/appbrand/appusage/LocalUsageInfo;", "setItemInfo$plugin_appbrand_integration_release", "(Lcom/tencent/mm/plugin/appbrand/appusage/LocalUsageInfo;)V", "textName", "Landroid/widget/TextView;", "getTextName", "()Landroid/widget/TextView;", "textType", "getTextType", "fillContent", "", "dataItem", "onClick", "v", "plugin-appbrand-integration_release"})
public final class n
  extends RecyclerView.v
  implements View.OnClickListener
{
  final TextView lGG;
  private final TextView lGH;
  final ImageView lGI;
  LocalUsageInfo lGK;
  
  public n(View paramView)
  {
    super(paramView);
    AppMethodBeat.i(51287);
    paramView.setOnClickListener((View.OnClickListener)this);
    View localView = paramView.findViewById(2131302654);
    k.g(localView, "itemView.findViewById(R.id.name)");
    this.lGG = ((TextView)localView);
    localView = paramView.findViewById(2131305633);
    k.g(localView, "itemView.findViewById(R.id.tag_text)");
    this.lGH = ((TextView)localView);
    paramView = paramView.findViewById(2131300874);
    k.g(paramView, "itemView.findViewById(R.id.icon)");
    this.lGI = ((ImageView)paramView);
    AppMethodBeat.o(51287);
  }
  
  public final void g(LocalUsageInfo paramLocalUsageInfo)
  {
    AppMethodBeat.i(51286);
    k.h(paramLocalUsageInfo, "dataItem");
    this.lGK = paramLocalUsageInfo;
    this.lGG.setText((CharSequence)paramLocalUsageInfo.nickname);
    String str = e.qC(paramLocalUsageInfo.gXn);
    CharSequence localCharSequence = (CharSequence)str;
    int i;
    if ((localCharSequence == null) || (localCharSequence.length() == 0))
    {
      i = 1;
      if (i == 0) {
        break label109;
      }
      this.lGH.setVisibility(8);
    }
    for (;;)
    {
      b.aub().a(this.lGI, paramLocalUsageInfo.iVP, a.aua(), (b.h)g.gSK);
      AppMethodBeat.o(51286);
      return;
      i = 0;
      break;
      label109:
      this.lGH.setVisibility(0);
      this.lGH.setText((CharSequence)str);
    }
  }
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(51285);
    Object localObject = this.lGK;
    if (localObject != null)
    {
      f localf = f.kOI;
      if (paramView == null) {
        k.fvU();
      }
      paramView = paramView.getContext();
      String str1 = ((LocalUsageInfo)localObject).username;
      String str2 = ((LocalUsageInfo)localObject).appId;
      int i = ((LocalUsageInfo)localObject).gXn;
      localObject = new AppBrandStatObject();
      ((AppBrandStatObject)localObject).scene = 1103;
      localf.a(paramView, str1, str2, null, i, 0, (AppBrandStatObject)localObject, null, null);
      AppMethodBeat.o(51285);
      return;
    }
    AppMethodBeat.o(51285);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.collection.n
 * JD-Core Version:    0.7.0.1
 */