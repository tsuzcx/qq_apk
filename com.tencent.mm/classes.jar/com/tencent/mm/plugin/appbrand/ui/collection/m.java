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
import com.tencent.mm.modelappbrand.a.b.h;
import com.tencent.mm.modelappbrand.a.g;
import com.tencent.mm.plugin.appbrand.appcache.e;
import com.tencent.mm.plugin.appbrand.appusage.LocalUsageInfo;
import com.tencent.mm.plugin.appbrand.launching.e.f;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.ui.base.n.e;
import com.tencent.mm.ui.widget.a.e.b;
import d.g.b.p;
import d.n.n;
import java.util.regex.Pattern;

@d.l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/appbrand/ui/collection/CollectionVerticalListViewHolder;", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "Landroid/view/View$OnClickListener;", "Landroid/view/View$OnLongClickListener;", "itemView", "Landroid/view/View;", "listener", "Lcom/tencent/mm/plugin/appbrand/ui/collection/CollectionVerticalListViewHolder$IEnterWxaListener;", "(Landroid/view/View;Lcom/tencent/mm/plugin/appbrand/ui/collection/CollectionVerticalListViewHolder$IEnterWxaListener;)V", "bottomLine", "getBottomLine", "()Landroid/view/View;", "canShowLongClickTestMenu", "", "getCanShowLongClickTestMenu", "()Z", "imageIcon", "Landroid/widget/ImageView;", "getImageIcon", "()Landroid/widget/ImageView;", "itemInfo", "Lcom/tencent/mm/plugin/appbrand/appusage/LocalUsageInfo;", "mListener", "getMListener", "()Lcom/tencent/mm/plugin/appbrand/ui/collection/CollectionVerticalListViewHolder$IEnterWxaListener;", "textName", "Landroid/widget/TextView;", "getTextName", "()Landroid/widget/TextView;", "textType", "getTextType", "fillContent", "", "dataItem", "fillDiffs", "newItem", "diffs", "Landroid/os/Bundle;", "fillIconURL", "fillNickname", "onClick", "v", "onLongClick", "startWeApp", "path", "", "IEnterWxaListener", "plugin-appbrand-integration_release"})
public class m
  extends RecyclerView.w
  implements View.OnClickListener, View.OnLongClickListener
{
  private final boolean mOc;
  private final a mOd;
  private final TextView mOe;
  private final TextView mOf;
  final ImageView mOg;
  final View mOh;
  LocalUsageInfo mOi;
  
  public m(View paramView, a parama)
  {
    super(paramView);
    AppMethodBeat.i(51284);
    this.mOd = parama;
    this.mOc = true;
    paramView.setOnClickListener((View.OnClickListener)this);
    if ((bBl()) && (a.bBf())) {
      paramView.setOnLongClickListener((View.OnLongClickListener)this);
    }
    parama = paramView.findViewById(2131303405);
    p.g(parama, "itemView.findViewById(R.id.primary_text)");
    this.mOe = ((TextView)parama);
    parama = paramView.findViewById(2131305633);
    p.g(parama, "itemView.findViewById(R.id.tag_text)");
    this.mOf = ((TextView)parama);
    parama = paramView.findViewById(2131300874);
    p.g(parama, "itemView.findViewById(R.id.icon)");
    this.mOg = ((ImageView)parama);
    paramView = paramView.findViewById(2131299154);
    p.g(paramView, "itemView.findViewById(R.id.divider)");
    this.mOh = paramView;
    AppMethodBeat.o(51284);
  }
  
  private final void b(View paramView, String paramString)
  {
    AppMethodBeat.i(175230);
    Object localObject = this.mOi;
    if (localObject != null)
    {
      f localf = f.lSd;
      if (paramView == null) {
        p.gkB();
      }
      paramView = paramView.getContext();
      String str1 = ((LocalUsageInfo)localObject).username;
      String str2 = ((LocalUsageInfo)localObject).appId;
      int i = ((LocalUsageInfo)localObject).hSZ;
      localObject = new AppBrandStatObject();
      ((AppBrandStatObject)localObject).scene = 1103;
      localf.a(paramView, str1, str2, paramString, i, 0, (AppBrandStatObject)localObject, null, null);
      paramView = this.mOd;
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
  
  public boolean bBl()
  {
    return this.mOc;
  }
  
  final void bBn()
  {
    AppMethodBeat.i(51282);
    com.tencent.mm.modelappbrand.a.b localb = com.tencent.mm.modelappbrand.a.b.aEl();
    ImageView localImageView = this.mOg;
    LocalUsageInfo localLocalUsageInfo = this.mOi;
    if (localLocalUsageInfo == null) {
      p.gkB();
    }
    localb.a(localImageView, localLocalUsageInfo.jTr, com.tencent.mm.modelappbrand.a.a.aEk(), (b.h)g.hOv);
    AppMethodBeat.o(51282);
  }
  
  final void bBo()
  {
    AppMethodBeat.i(51283);
    Object localObject1 = this.mOi;
    if (localObject1 == null) {
      p.gkB();
    }
    localObject1 = ((LocalUsageInfo)localObject1).nickname;
    TextView localTextView = this.mOe;
    Object localObject2 = (CharSequence)localObject1;
    int i;
    if ((localObject2 == null) || (((CharSequence)localObject2).length() == 0))
    {
      i = 1;
      if (i == 0) {
        break label119;
      }
      localObject1 = this.mOi;
      if (localObject1 == null) {
        p.gkB();
      }
      localObject1 = ((LocalUsageInfo)localObject1).username;
      p.g(localObject1, "itemInfo!!.username");
      localObject2 = Pattern.quote("@app");
      p.g(localObject2, "Pattern.quote(ConstantsStorage.TAG_APPBRAND)");
    }
    label119:
    for (localObject1 = (CharSequence)n.bq((String)localObject1, (String)localObject2, "");; localObject1 = (CharSequence)localObject1)
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
    p.h(paramLocalUsageInfo, "dataItem");
    this.mOi = paramLocalUsageInfo;
    paramLocalUsageInfo = e.rS(paramLocalUsageInfo.hSZ);
    CharSequence localCharSequence = (CharSequence)paramLocalUsageInfo;
    int i;
    if ((localCharSequence == null) || (localCharSequence.length() == 0))
    {
      i = 1;
      if (i == 0) {
        break label79;
      }
      this.mOf.setVisibility(8);
    }
    for (;;)
    {
      bBo();
      bBn();
      AppMethodBeat.o(51281);
      return;
      i = 0;
      break;
      label79:
      this.mOf.setVisibility(0);
      this.mOf.setText((CharSequence)paramLocalUsageInfo);
    }
  }
  
  public void onClick(View paramView)
  {
    AppMethodBeat.i(51280);
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.bd(paramView);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/appbrand/ui/collection/CollectionVerticalListViewHolder", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
    b(paramView, null);
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/appbrand/ui/collection/CollectionVerticalListViewHolder", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(51280);
  }
  
  public boolean onLongClick(final View paramView)
  {
    AppMethodBeat.i(175231);
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.bd(paramView);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/appbrand/ui/collection/CollectionVerticalListViewHolder", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, localb.ahF());
    if (a.bBf())
    {
      if (paramView == null) {
        p.gkB();
      }
      new com.tencent.mm.ui.tools.l(paramView.getContext()).a(paramView, (View.OnCreateContextMenuListener)new m.b("?wechat_appbrand_test=1"), (n.e)new c(this, paramView, "?wechat_appbrand_test=1"), (e.b)m.d.mOk);
    }
    for (boolean bool = true;; bool = false)
    {
      com.tencent.mm.hellhoundlib.a.a.a(bool, this, "com/tencent/mm/plugin/appbrand/ui/collection/CollectionVerticalListViewHolder", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
      AppMethodBeat.o(175231);
      return bool;
    }
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/appbrand/ui/collection/CollectionVerticalListViewHolder$IEnterWxaListener;", "", "onEnter", "", "plugin-appbrand-integration_release"})
  public static abstract interface a
  {
    public abstract void onEnter();
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "<anonymous parameter 0>", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "index", "", "onMMMenuItemSelected"})
  static final class c
    implements n.e
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
        m.a(this.mOj, paramView, this.kyt);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.collection.m
 * JD-Core Version:    0.7.0.1
 */