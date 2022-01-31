package com.tencent.mm.plugin.appbrand.ui.collection;

import a.f.b.j;
import a.l.m;
import android.support.v7.widget.RecyclerView.v;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelappbrand.a.b.f;
import com.tencent.mm.plugin.appbrand.appusage.LocalUsageInfo;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import java.util.regex.Pattern;

@a.l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/appbrand/ui/collection/CollectionVerticalListViewHolder;", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "Landroid/view/View$OnClickListener;", "itemView", "Landroid/view/View;", "listener", "Lcom/tencent/mm/plugin/appbrand/ui/collection/CollectionVerticalListViewHolder$IEnterWxaListener;", "(Landroid/view/View;Lcom/tencent/mm/plugin/appbrand/ui/collection/CollectionVerticalListViewHolder$IEnterWxaListener;)V", "bottomLine", "getBottomLine", "()Landroid/view/View;", "imageIcon", "Landroid/widget/ImageView;", "getImageIcon", "()Landroid/widget/ImageView;", "itemInfo", "Lcom/tencent/mm/plugin/appbrand/appusage/LocalUsageInfo;", "mListener", "getMListener", "()Lcom/tencent/mm/plugin/appbrand/ui/collection/CollectionVerticalListViewHolder$IEnterWxaListener;", "textName", "Landroid/widget/TextView;", "getTextName", "()Landroid/widget/TextView;", "textType", "getTextType", "fillContent", "", "dataItem", "fillDiffs", "newItem", "diffs", "Landroid/os/Bundle;", "fillIconURL", "fillNickname", "onClick", "v", "IEnterWxaListener", "plugin-appbrand-integration_release"})
public class l
  extends RecyclerView.v
  implements View.OnClickListener
{
  private final l.a iSe;
  private final TextView iSf;
  private final TextView iSg;
  final ImageView iSh;
  final View iSi;
  LocalUsageInfo iSj;
  
  public l(View paramView, l.a parama)
  {
    super(paramView);
    AppMethodBeat.i(135119);
    this.iSe = parama;
    paramView.setOnClickListener((View.OnClickListener)this);
    parama = paramView.findViewById(2131820650);
    j.p(parama, "itemView.findViewById(R.id.primary_text)");
    this.iSf = ((TextView)parama);
    parama = paramView.findViewById(2131821171);
    j.p(parama, "itemView.findViewById(R.id.tag_text)");
    this.iSg = ((TextView)parama);
    parama = paramView.findViewById(2131820929);
    j.p(parama, "itemView.findViewById(R.id.icon)");
    this.iSh = ((ImageView)parama);
    paramView = paramView.findViewById(2131821148);
    j.p(paramView, "itemView.findViewById(R.id.divider)");
    this.iSi = paramView;
    AppMethodBeat.o(135119);
  }
  
  final void aNa()
  {
    AppMethodBeat.i(135117);
    com.tencent.mm.modelappbrand.a.b localb = com.tencent.mm.modelappbrand.a.b.acD();
    ImageView localImageView = this.iSh;
    LocalUsageInfo localLocalUsageInfo = this.iSj;
    if (localLocalUsageInfo == null) {
      j.ebi();
    }
    localb.a(localImageView, localLocalUsageInfo.hcN, com.tencent.mm.modelappbrand.a.a.acC(), (b.f)com.tencent.mm.modelappbrand.a.f.fqU);
    AppMethodBeat.o(135117);
  }
  
  final void aNb()
  {
    AppMethodBeat.i(135118);
    Object localObject1 = this.iSj;
    if (localObject1 == null) {
      j.ebi();
    }
    localObject1 = ((LocalUsageInfo)localObject1).nickname;
    TextView localTextView = this.iSf;
    Object localObject2 = (CharSequence)localObject1;
    int i;
    if ((localObject2 == null) || (((CharSequence)localObject2).length() == 0))
    {
      i = 1;
      if (i == 0) {
        break label119;
      }
      localObject1 = this.iSj;
      if (localObject1 == null) {
        j.ebi();
      }
      localObject1 = ((LocalUsageInfo)localObject1).username;
      j.p(localObject1, "itemInfo!!.username");
      localObject2 = Pattern.quote("@app");
      j.p(localObject2, "Pattern.quote(ConstantsStorage.TAG_APPBRAND)");
    }
    label119:
    for (localObject1 = (CharSequence)m.aL((String)localObject1, (String)localObject2, "");; localObject1 = (CharSequence)localObject1)
    {
      localTextView.setText((CharSequence)localObject1);
      AppMethodBeat.o(135118);
      return;
      i = 0;
      break;
    }
  }
  
  public final void f(LocalUsageInfo paramLocalUsageInfo)
  {
    AppMethodBeat.i(135116);
    j.q(paramLocalUsageInfo, "dataItem");
    this.iSj = paramLocalUsageInfo;
    paramLocalUsageInfo = com.tencent.mm.plugin.appbrand.appcache.b.nj(paramLocalUsageInfo.hcr);
    CharSequence localCharSequence = (CharSequence)paramLocalUsageInfo;
    int i;
    if ((localCharSequence == null) || (localCharSequence.length() == 0))
    {
      i = 1;
      if (i == 0) {
        break label76;
      }
      this.iSg.setVisibility(8);
    }
    for (;;)
    {
      aNb();
      aNa();
      AppMethodBeat.o(135116);
      return;
      i = 0;
      break;
      label76:
      this.iSg.setVisibility(0);
      this.iSg.setText((CharSequence)paramLocalUsageInfo);
    }
  }
  
  public void onClick(View paramView)
  {
    AppMethodBeat.i(135115);
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
      paramView = this.iSe;
      if (paramView != null)
      {
        paramView.onEnter();
        AppMethodBeat.o(135115);
        return;
      }
      AppMethodBeat.o(135115);
      return;
    }
    AppMethodBeat.o(135115);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.collection.l
 * JD-Core Version:    0.7.0.1
 */