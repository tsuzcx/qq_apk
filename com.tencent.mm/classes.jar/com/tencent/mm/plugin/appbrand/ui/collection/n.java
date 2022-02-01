package com.tencent.mm.plugin.appbrand.ui.collection;

import android.support.v7.widget.RecyclerView.w;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelappbrand.a.b.h;
import com.tencent.mm.modelappbrand.a.g;
import com.tencent.mm.plugin.appbrand.appcache.e;
import com.tencent.mm.plugin.appbrand.appusage.LocalUsageInfo;
import com.tencent.mm.plugin.appbrand.launching.e.f;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import d.g.b.p;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/appbrand/ui/collection/CollectionViewHolder;", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "Landroid/view/View$OnClickListener;", "itemView", "Landroid/view/View;", "(Landroid/view/View;)V", "imageIcon", "Landroid/widget/ImageView;", "getImageIcon", "()Landroid/widget/ImageView;", "itemInfo", "Lcom/tencent/mm/plugin/appbrand/appusage/LocalUsageInfo;", "getItemInfo$plugin_appbrand_integration_release", "()Lcom/tencent/mm/plugin/appbrand/appusage/LocalUsageInfo;", "setItemInfo$plugin_appbrand_integration_release", "(Lcom/tencent/mm/plugin/appbrand/appusage/LocalUsageInfo;)V", "textName", "Landroid/widget/TextView;", "getTextName", "()Landroid/widget/TextView;", "textType", "getTextType", "fillContent", "", "dataItem", "onClick", "v", "plugin-appbrand-integration_release"})
public final class n
  extends RecyclerView.w
  implements View.OnClickListener
{
  final TextView mJc;
  private final TextView mJd;
  final ImageView mJe;
  LocalUsageInfo mJg;
  
  public n(View paramView)
  {
    super(paramView);
    AppMethodBeat.i(51287);
    paramView.setOnClickListener((View.OnClickListener)this);
    View localView = paramView.findViewById(2131302654);
    p.g(localView, "itemView.findViewById(R.id.name)");
    this.mJc = ((TextView)localView);
    localView = paramView.findViewById(2131305633);
    p.g(localView, "itemView.findViewById(R.id.tag_text)");
    this.mJd = ((TextView)localView);
    paramView = paramView.findViewById(2131300874);
    p.g(paramView, "itemView.findViewById(R.id.icon)");
    this.mJe = ((ImageView)paramView);
    AppMethodBeat.o(51287);
  }
  
  public final void g(LocalUsageInfo paramLocalUsageInfo)
  {
    AppMethodBeat.i(51286);
    p.h(paramLocalUsageInfo, "dataItem");
    this.mJg = paramLocalUsageInfo;
    this.mJc.setText((CharSequence)paramLocalUsageInfo.nickname);
    String str = e.rP(paramLocalUsageInfo.hQh);
    CharSequence localCharSequence = (CharSequence)str;
    int i;
    if ((localCharSequence == null) || (localCharSequence.length() == 0))
    {
      i = 1;
      if (i == 0) {
        break label109;
      }
      this.mJd.setVisibility(8);
    }
    for (;;)
    {
      com.tencent.mm.modelappbrand.a.b.aDV().a(this.mJe, paramLocalUsageInfo.jPZ, com.tencent.mm.modelappbrand.a.a.aDU(), (b.h)g.hLC);
      AppMethodBeat.o(51286);
      return;
      i = 0;
      break;
      label109:
      this.mJd.setVisibility(0);
      this.mJd.setText((CharSequence)str);
    }
  }
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(51285);
    Object localObject1 = new com.tencent.mm.hellhoundlib.b.b();
    ((com.tencent.mm.hellhoundlib.b.b)localObject1).bd(paramView);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/appbrand/ui/collection/CollectionViewHolder", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject1).ahq());
    Object localObject2 = this.mJg;
    if (localObject2 != null)
    {
      localObject1 = f.lNC;
      if (paramView == null) {
        p.gfZ();
      }
      paramView = paramView.getContext();
      String str1 = ((LocalUsageInfo)localObject2).username;
      String str2 = ((LocalUsageInfo)localObject2).appId;
      int i = ((LocalUsageInfo)localObject2).hQh;
      localObject2 = new AppBrandStatObject();
      ((AppBrandStatObject)localObject2).scene = 1103;
      ((f)localObject1).a(paramView, str1, str2, null, i, 0, (AppBrandStatObject)localObject2, null, null);
    }
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/appbrand/ui/collection/CollectionViewHolder", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(51285);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.collection.n
 * JD-Core Version:    0.7.0.1
 */