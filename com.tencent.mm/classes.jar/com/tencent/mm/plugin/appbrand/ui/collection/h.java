package com.tencent.mm.plugin.appbrand.ui.collection;

import android.support.v7.widget.RecyclerView.v;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnCreateContextMenuListener;
import android.view.View.OnLongClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelappbrand.a.b.h;
import com.tencent.mm.modelappbrand.a.g;
import com.tencent.mm.plugin.appbrand.appcache.e;
import com.tencent.mm.plugin.appbrand.appusage.LocalUsageInfo;
import com.tencent.mm.plugin.appbrand.config.WxaExposedParams.a;
import com.tencent.mm.plugin.appbrand.launching.e.f;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.ui.AppBrandProfileUI;
import com.tencent.mm.ui.base.o.g;
import com.tencent.mm.ui.widget.a.e.b;
import java.util.regex.Pattern;
import kotlin.g.b.p;
import kotlin.n.n;

@kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/ui/collection/CollectionVerticalListViewHolder;", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "Landroid/view/View$OnClickListener;", "Landroid/view/View$OnLongClickListener;", "itemView", "Landroid/view/View;", "listener", "Lcom/tencent/mm/plugin/appbrand/ui/collection/CollectionVerticalListViewHolder$IEnterWxaListener;", "(Landroid/view/View;Lcom/tencent/mm/plugin/appbrand/ui/collection/CollectionVerticalListViewHolder$IEnterWxaListener;)V", "bottomLine", "getBottomLine", "()Landroid/view/View;", "canShowLongClickTestMenu", "", "getCanShowLongClickTestMenu", "()Z", "imageIcon", "Landroid/widget/ImageView;", "getImageIcon", "()Landroid/widget/ImageView;", "itemInfo", "Lcom/tencent/mm/plugin/appbrand/appusage/LocalUsageInfo;", "mListener", "getMListener", "()Lcom/tencent/mm/plugin/appbrand/ui/collection/CollectionVerticalListViewHolder$IEnterWxaListener;", "textName", "Landroid/widget/TextView;", "getTextName", "()Landroid/widget/TextView;", "textType", "getTextType", "fillContent", "", "dataItem", "fillDiffs", "newItem", "diffs", "Landroid/os/Bundle;", "fillIconURL", "fillNickname", "onClick", "v", "onLongClick", "startWeApp", "path", "", "IEnterWxaListener", "plugin-appbrand-integration_release"})
public class h
  extends RecyclerView.v
  implements View.OnClickListener, View.OnLongClickListener
{
  private final boolean obd;
  private final a obe;
  private final TextView obf;
  private final TextView obg;
  final ImageView obh;
  final View obi;
  LocalUsageInfo obk;
  
  public h(View paramView, a parama)
  {
    super(paramView);
    AppMethodBeat.i(51284);
    this.obe = parama;
    this.obd = true;
    paramView.setOnClickListener((View.OnClickListener)this);
    if ((bYl()) && (a.bYj())) {
      paramView.setOnLongClickListener((View.OnLongClickListener)this);
    }
    parama = paramView.findViewById(2131306126);
    p.g(parama, "itemView.findViewById(R.id.primary_text)");
    this.obf = ((TextView)parama);
    parama = paramView.findViewById(2131308875);
    p.g(parama, "itemView.findViewById(R.id.tag_text)");
    this.obg = ((TextView)parama);
    parama = paramView.findViewById(2131302468);
    p.g(parama, "itemView.findViewById(R.id.icon)");
    this.obh = ((ImageView)parama);
    paramView = paramView.findViewById(2131299682);
    p.g(paramView, "itemView.findViewById(R.id.divider)");
    this.obi = paramView;
    AppMethodBeat.o(51284);
  }
  
  private final void b(View paramView, String paramString)
  {
    AppMethodBeat.i(175230);
    Object localObject = this.obk;
    if (localObject != null)
    {
      f localf = f.mZp;
      if (paramView == null) {
        p.hyc();
      }
      paramView = paramView.getContext();
      String str1 = ((LocalUsageInfo)localObject).username;
      String str2 = ((LocalUsageInfo)localObject).appId;
      int i = ((LocalUsageInfo)localObject).iOo;
      localObject = new AppBrandStatObject();
      ((AppBrandStatObject)localObject).scene = 1103;
      localf.a(paramView, str1, str2, paramString, i, 0, (AppBrandStatObject)localObject, null, null);
      paramView = this.obe;
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
  
  public boolean bYl()
  {
    return this.obd;
  }
  
  final void bYn()
  {
    AppMethodBeat.i(51282);
    com.tencent.mm.modelappbrand.a.b localb = com.tencent.mm.modelappbrand.a.b.aXY();
    ImageView localImageView = this.obh;
    LocalUsageInfo localLocalUsageInfo = this.obk;
    if (localLocalUsageInfo == null) {
      p.hyc();
    }
    localb.a(localImageView, localLocalUsageInfo.kVZ, com.tencent.mm.modelappbrand.a.a.aXX(), (b.h)g.iJB);
    AppMethodBeat.o(51282);
  }
  
  final void bYo()
  {
    AppMethodBeat.i(51283);
    Object localObject1 = this.obk;
    if (localObject1 == null) {
      p.hyc();
    }
    localObject1 = ((LocalUsageInfo)localObject1).nickname;
    TextView localTextView = this.obf;
    Object localObject2 = (CharSequence)localObject1;
    int i;
    if ((localObject2 == null) || (((CharSequence)localObject2).length() == 0))
    {
      i = 1;
      if (i == 0) {
        break label119;
      }
      localObject1 = this.obk;
      if (localObject1 == null) {
        p.hyc();
      }
      localObject1 = ((LocalUsageInfo)localObject1).username;
      p.g(localObject1, "itemInfo!!.username");
      localObject2 = Pattern.quote("@app");
      p.g(localObject2, "Pattern.quote(ConstantsStorage.TAG_APPBRAND)");
    }
    label119:
    for (localObject1 = (CharSequence)n.by((String)localObject1, (String)localObject2, "");; localObject1 = (CharSequence)localObject1)
    {
      localTextView.setText((CharSequence)localObject1);
      AppMethodBeat.o(51283);
      return;
      i = 0;
      break;
    }
  }
  
  public final void f(LocalUsageInfo paramLocalUsageInfo)
  {
    AppMethodBeat.i(51281);
    p.h(paramLocalUsageInfo, "dataItem");
    this.obk = paramLocalUsageInfo;
    paramLocalUsageInfo = e.vO(paramLocalUsageInfo.iOo);
    CharSequence localCharSequence = (CharSequence)paramLocalUsageInfo;
    int i;
    if ((localCharSequence == null) || (localCharSequence.length() == 0))
    {
      i = 1;
      if (i == 0) {
        break label79;
      }
      this.obg.setVisibility(8);
    }
    for (;;)
    {
      bYo();
      bYn();
      AppMethodBeat.o(51281);
      return;
      i = 0;
      break;
      label79:
      this.obg.setVisibility(0);
      this.obg.setText((CharSequence)paramLocalUsageInfo);
    }
  }
  
  public void onClick(View paramView)
  {
    AppMethodBeat.i(51280);
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.bm(paramView);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/appbrand/ui/collection/CollectionVerticalListViewHolder", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
    b(paramView, null);
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/appbrand/ui/collection/CollectionVerticalListViewHolder", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(51280);
  }
  
  public boolean onLongClick(final View paramView)
  {
    AppMethodBeat.i(175231);
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.bm(paramView);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/appbrand/ui/collection/CollectionVerticalListViewHolder", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, localb.axR());
    if (a.bYj())
    {
      if (paramView == null) {
        p.hyc();
      }
      new com.tencent.mm.ui.tools.l(paramView.getContext()).a(paramView, (View.OnCreateContextMenuListener)new h.b("?wechat_appbrand_test=1"), (o.g)new c(this, paramView, "?wechat_appbrand_test=1"), (e.b)h.d.obm);
    }
    for (boolean bool = true;; bool = false)
    {
      com.tencent.mm.hellhoundlib.a.a.a(bool, this, "com/tencent/mm/plugin/appbrand/ui/collection/CollectionVerticalListViewHolder", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
      AppMethodBeat.o(175231);
      return bool;
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/ui/collection/CollectionVerticalListViewHolder$IEnterWxaListener;", "", "onEnter", "", "plugin-appbrand-integration_release"})
  public static abstract interface a
  {
    public abstract void onEnter();
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "<anonymous parameter 0>", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "index", "", "onMMMenuItemSelected"})
  static final class c
    implements o.g
  {
    c(h paramh, View paramView, String paramString) {}
    
    public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
    {
      AppMethodBeat.i(175228);
      switch (paramInt)
      {
      }
      do
      {
        AppMethodBeat.o(175228);
        return;
        h.a(this.obl, paramView, this.lCM);
        AppMethodBeat.o(175228);
        return;
        paramMenuItem = h.a(this.obl);
      } while (paramMenuItem == null);
      View localView = paramView;
      if (localView == null) {
        p.hyc();
      }
      AppBrandProfileUI.a(localView.getContext(), paramMenuItem.username, 3, "", new WxaExposedParams.a().XN(paramMenuItem.appId).wh(3).bAv(), null, null);
      AppMethodBeat.o(175228);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.collection.h
 * JD-Core Version:    0.7.0.1
 */