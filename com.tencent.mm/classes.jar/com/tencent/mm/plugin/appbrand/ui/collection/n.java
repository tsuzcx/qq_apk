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

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/appbrand/ui/collection/CollectionViewHolder;", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "Landroid/view/View$OnClickListener;", "itemView", "Landroid/view/View;", "(Landroid/view/View;)V", "imageIcon", "Landroid/widget/ImageView;", "getImageIcon", "()Landroid/widget/ImageView;", "itemInfo", "Lcom/tencent/mm/plugin/appbrand/appusage/LocalUsageInfo;", "getItemInfo$plugin_appbrand_integration_release", "()Lcom/tencent/mm/plugin/appbrand/appusage/LocalUsageInfo;", "setItemInfo$plugin_appbrand_integration_release", "(Lcom/tencent/mm/plugin/appbrand/appusage/LocalUsageInfo;)V", "textName", "Landroid/widget/TextView;", "getTextName", "()Landroid/widget/TextView;", "textType", "getTextType", "fillContent", "", "dataItem", "onClick", "v", "plugin-appbrand-integration_release"})
public final class n
  extends RecyclerView.w
  implements View.OnClickListener
{
  final TextView mOe;
  private final TextView mOf;
  final ImageView mOg;
  LocalUsageInfo mOi;
  
  public n(View paramView)
  {
    super(paramView);
    AppMethodBeat.i(51287);
    paramView.setOnClickListener((View.OnClickListener)this);
    View localView = paramView.findViewById(2131302654);
    p.g(localView, "itemView.findViewById(R.id.name)");
    this.mOe = ((TextView)localView);
    localView = paramView.findViewById(2131305633);
    p.g(localView, "itemView.findViewById(R.id.tag_text)");
    this.mOf = ((TextView)localView);
    paramView = paramView.findViewById(2131300874);
    p.g(paramView, "itemView.findViewById(R.id.icon)");
    this.mOg = ((ImageView)paramView);
    AppMethodBeat.o(51287);
  }
  
  public final void g(LocalUsageInfo paramLocalUsageInfo)
  {
    AppMethodBeat.i(51286);
    p.h(paramLocalUsageInfo, "dataItem");
    this.mOi = paramLocalUsageInfo;
    this.mOe.setText((CharSequence)paramLocalUsageInfo.nickname);
    String str = e.rS(paramLocalUsageInfo.hSZ);
    CharSequence localCharSequence = (CharSequence)str;
    int i;
    if ((localCharSequence == null) || (localCharSequence.length() == 0))
    {
      i = 1;
      if (i == 0) {
        break label109;
      }
      this.mOf.setVisibility(8);
    }
    for (;;)
    {
      com.tencent.mm.modelappbrand.a.b.aEl().a(this.mOg, paramLocalUsageInfo.jTr, com.tencent.mm.modelappbrand.a.a.aEk(), (b.h)g.hOv);
      AppMethodBeat.o(51286);
      return;
      i = 0;
      break;
      label109:
      this.mOf.setVisibility(0);
      this.mOf.setText((CharSequence)str);
    }
  }
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(51285);
    Object localObject1 = new com.tencent.mm.hellhoundlib.b.b();
    ((com.tencent.mm.hellhoundlib.b.b)localObject1).bd(paramView);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/appbrand/ui/collection/CollectionViewHolder", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject1).ahF());
    Object localObject2 = this.mOi;
    if (localObject2 != null)
    {
      localObject1 = f.lSd;
      if (paramView == null) {
        p.gkB();
      }
      paramView = paramView.getContext();
      String str1 = ((LocalUsageInfo)localObject2).username;
      String str2 = ((LocalUsageInfo)localObject2).appId;
      int i = ((LocalUsageInfo)localObject2).hSZ;
      localObject2 = new AppBrandStatObject();
      ((AppBrandStatObject)localObject2).scene = 1103;
      ((f)localObject1).a(paramView, str1, str2, null, i, 0, (AppBrandStatObject)localObject2, null, null);
    }
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/appbrand/ui/collection/CollectionViewHolder", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(51285);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.collection.n
 * JD-Core Version:    0.7.0.1
 */