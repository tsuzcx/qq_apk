package com.tencent.mm.plugin.appbrand.ui.collection;

import android.support.v7.widget.RecyclerView.w;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnCreateContextMenuListener;
import android.view.View.OnLongClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelappbrand.a.b;
import com.tencent.mm.modelappbrand.a.b.h;
import com.tencent.mm.modelappbrand.a.g;
import com.tencent.mm.plugin.appbrand.appcache.e;
import com.tencent.mm.plugin.appbrand.appusage.LocalUsageInfo;
import com.tencent.mm.plugin.appbrand.launching.e.f;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.widget.a.e.b;
import d.g.b.k;
import d.n.n;
import java.util.regex.Pattern;

@d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/appbrand/ui/collection/CollectionVerticalListViewHolder;", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "Landroid/view/View$OnClickListener;", "Landroid/view/View$OnLongClickListener;", "itemView", "Landroid/view/View;", "listener", "Lcom/tencent/mm/plugin/appbrand/ui/collection/CollectionVerticalListViewHolder$IEnterWxaListener;", "(Landroid/view/View;Lcom/tencent/mm/plugin/appbrand/ui/collection/CollectionVerticalListViewHolder$IEnterWxaListener;)V", "bottomLine", "getBottomLine", "()Landroid/view/View;", "canShowLongClickTestMenu", "", "getCanShowLongClickTestMenu", "()Z", "imageIcon", "Landroid/widget/ImageView;", "getImageIcon", "()Landroid/widget/ImageView;", "itemInfo", "Lcom/tencent/mm/plugin/appbrand/appusage/LocalUsageInfo;", "mListener", "getMListener", "()Lcom/tencent/mm/plugin/appbrand/ui/collection/CollectionVerticalListViewHolder$IEnterWxaListener;", "textName", "Landroid/widget/TextView;", "getTextName", "()Landroid/widget/TextView;", "textType", "getTextType", "fillContent", "", "dataItem", "fillDiffs", "newItem", "diffs", "Landroid/os/Bundle;", "fillIconURL", "fillNickname", "onClick", "v", "onLongClick", "startWeApp", "path", "", "IEnterWxaListener", "plugin-appbrand-integration_release"})
public class m
  extends RecyclerView.w
  implements View.OnClickListener, View.OnLongClickListener
{
  private final a miA;
  private final TextView miB;
  private final TextView miC;
  final ImageView miD;
  final View miE;
  LocalUsageInfo miF;
  private final boolean miz;
  
  public m(View paramView, a parama)
  {
    super(paramView);
    AppMethodBeat.i(51284);
    this.miA = parama;
    this.miz = true;
    paramView.setOnClickListener((View.OnClickListener)this);
    if ((bwk()) && (a.bwe())) {
      paramView.setOnLongClickListener((View.OnLongClickListener)this);
    }
    parama = paramView.findViewById(2131303405);
    k.g(parama, "itemView.findViewById(R.id.primary_text)");
    this.miB = ((TextView)parama);
    parama = paramView.findViewById(2131305633);
    k.g(parama, "itemView.findViewById(R.id.tag_text)");
    this.miC = ((TextView)parama);
    parama = paramView.findViewById(2131300874);
    k.g(parama, "itemView.findViewById(R.id.icon)");
    this.miD = ((ImageView)parama);
    paramView = paramView.findViewById(2131299154);
    k.g(paramView, "itemView.findViewById(R.id.divider)");
    this.miE = paramView;
    AppMethodBeat.o(51284);
  }
  
  private final void b(View paramView, String paramString)
  {
    AppMethodBeat.i(175230);
    Object localObject = this.miF;
    if (localObject != null)
    {
      f localf = f.lqh;
      if (paramView == null) {
        k.fOy();
      }
      paramView = paramView.getContext();
      String str1 = ((LocalUsageInfo)localObject).username;
      String str2 = ((LocalUsageInfo)localObject).appId;
      int i = ((LocalUsageInfo)localObject).hxM;
      localObject = new AppBrandStatObject();
      ((AppBrandStatObject)localObject).scene = 1103;
      localf.a(paramView, str1, str2, paramString, i, 0, (AppBrandStatObject)localObject, null, null);
      paramView = this.miA;
      if (paramView != null)
      {
        paramView.onEnter();
        AppMethodBeat.o(175230);
        return;
      }
      AppMethodBeat.o(175230);
      return;
    }
    AppMethodBeat.o(175230);
  }
  
  public boolean bwk()
  {
    return this.miz;
  }
  
  final void bwm()
  {
    AppMethodBeat.i(51282);
    b localb = b.aAS();
    ImageView localImageView = this.miD;
    LocalUsageInfo localLocalUsageInfo = this.miF;
    if (localLocalUsageInfo == null) {
      k.fOy();
    }
    localb.a(localImageView, localLocalUsageInfo.jwf, com.tencent.mm.modelappbrand.a.a.aAR(), (b.h)g.htk);
    AppMethodBeat.o(51282);
  }
  
  final void bwn()
  {
    AppMethodBeat.i(51283);
    Object localObject1 = this.miF;
    if (localObject1 == null) {
      k.fOy();
    }
    localObject1 = ((LocalUsageInfo)localObject1).nickname;
    TextView localTextView = this.miB;
    Object localObject2 = (CharSequence)localObject1;
    int i;
    if ((localObject2 == null) || (((CharSequence)localObject2).length() == 0))
    {
      i = 1;
      if (i == 0) {
        break label119;
      }
      localObject1 = this.miF;
      if (localObject1 == null) {
        k.fOy();
      }
      localObject1 = ((LocalUsageInfo)localObject1).username;
      k.g(localObject1, "itemInfo!!.username");
      localObject2 = Pattern.quote("@app");
      k.g(localObject2, "Pattern.quote(ConstantsStorage.TAG_APPBRAND)");
    }
    label119:
    for (localObject1 = (CharSequence)n.bg((String)localObject1, (String)localObject2, "");; localObject1 = (CharSequence)localObject1)
    {
      localTextView.setText((CharSequence)localObject1);
      AppMethodBeat.o(51283);
      return;
      i = 0;
      break;
    }
  }
  
  public final void g(LocalUsageInfo paramLocalUsageInfo)
  {
    AppMethodBeat.i(51281);
    k.h(paramLocalUsageInfo, "dataItem");
    this.miF = paramLocalUsageInfo;
    paramLocalUsageInfo = e.rp(paramLocalUsageInfo.hxM);
    CharSequence localCharSequence = (CharSequence)paramLocalUsageInfo;
    int i;
    if ((localCharSequence == null) || (localCharSequence.length() == 0))
    {
      i = 1;
      if (i == 0) {
        break label79;
      }
      this.miC.setVisibility(8);
    }
    for (;;)
    {
      bwn();
      bwm();
      AppMethodBeat.o(51281);
      return;
      i = 0;
      break;
      label79:
      this.miC.setVisibility(0);
      this.miC.setText((CharSequence)paramLocalUsageInfo);
    }
  }
  
  public void onClick(View paramView)
  {
    AppMethodBeat.i(51280);
    b(paramView, null);
    AppMethodBeat.o(51280);
  }
  
  public boolean onLongClick(final View paramView)
  {
    AppMethodBeat.i(175231);
    if (a.bwe())
    {
      if (paramView == null) {
        k.fOy();
      }
      new com.tencent.mm.ui.tools.l(paramView.getContext()).a(paramView, (View.OnCreateContextMenuListener)new m.b("?wechat_appbrand_test=1"), (n.d)new c(this, paramView, "?wechat_appbrand_test=1"), (e.b)m.d.miH);
      AppMethodBeat.o(175231);
      return true;
    }
    AppMethodBeat.o(175231);
    return false;
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/appbrand/ui/collection/CollectionVerticalListViewHolder$IEnterWxaListener;", "", "onEnter", "", "plugin-appbrand-integration_release"})
  public static abstract interface a
  {
    public abstract void onEnter();
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "<anonymous parameter 0>", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "index", "", "onMMMenuItemSelected"})
  static final class c
    implements n.d
  {
    c(m paramm, View paramView, String paramString) {}
    
    public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
    {
      AppMethodBeat.i(175228);
      switch (paramInt)
      {
      }
      for (;;)
      {
        AppMethodBeat.o(175228);
        return;
        m.a(this.miG, paramView, this.kaI);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.collection.m
 * JD-Core Version:    0.7.0.1
 */