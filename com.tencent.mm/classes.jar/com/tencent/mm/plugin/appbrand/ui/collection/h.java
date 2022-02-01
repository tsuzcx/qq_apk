package com.tencent.mm.plugin.appbrand.ui.collection;

import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnCreateContextMenuListener;
import android.view.View.OnLongClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelappbrand.a.b.h;
import com.tencent.mm.modelappbrand.a.g;
import com.tencent.mm.plugin.appbrand.appcache.e;
import com.tencent.mm.plugin.appbrand.appusage.LocalUsageInfo;
import com.tencent.mm.plugin.appbrand.au.f;
import com.tencent.mm.plugin.appbrand.config.WxaExposedParams.a;
import com.tencent.mm.plugin.appbrand.launching.e.f;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.ui.AppBrandProfileUI;
import com.tencent.mm.ui.base.q.g;
import com.tencent.mm.ui.tools.m;
import com.tencent.mm.ui.widget.a.e.b;
import java.util.regex.Pattern;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.n.n;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/ui/collection/CollectionVerticalListViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Landroid/view/View$OnClickListener;", "Landroid/view/View$OnLongClickListener;", "itemView", "Landroid/view/View;", "listener", "Lcom/tencent/mm/plugin/appbrand/ui/collection/CollectionVerticalListViewHolder$IEnterWxaListener;", "(Landroid/view/View;Lcom/tencent/mm/plugin/appbrand/ui/collection/CollectionVerticalListViewHolder$IEnterWxaListener;)V", "bottomLine", "getBottomLine", "()Landroid/view/View;", "canShowLongClickTestMenu", "", "getCanShowLongClickTestMenu", "()Z", "imageIcon", "Landroid/widget/ImageView;", "getImageIcon", "()Landroid/widget/ImageView;", "itemInfo", "Lcom/tencent/mm/plugin/appbrand/appusage/LocalUsageInfo;", "mListener", "getMListener", "()Lcom/tencent/mm/plugin/appbrand/ui/collection/CollectionVerticalListViewHolder$IEnterWxaListener;", "textName", "Landroid/widget/TextView;", "getTextName", "()Landroid/widget/TextView;", "textType", "getTextType", "fillContent", "", "dataItem", "fillDiffs", "newItem", "diffs", "Landroid/os/Bundle;", "fillIconURL", "fillNickname", "onClick", "v", "onLongClick", "startWeApp", "path", "", "IEnterWxaListener", "plugin-appbrand-integration_release"})
public class h
  extends RecyclerView.v
  implements View.OnClickListener, View.OnLongClickListener
{
  private final boolean rcI;
  private final a rcJ;
  private final TextView rcK;
  private final TextView rcL;
  private final ImageView rcM;
  final View rcN;
  LocalUsageInfo rcO;
  
  public h(View paramView, a parama)
  {
    super(paramView);
    AppMethodBeat.i(51284);
    this.rcJ = parama;
    this.rcI = true;
    paramView.setOnClickListener((View.OnClickListener)this);
    if ((ckW()) && (a.ckU())) {
      paramView.setOnLongClickListener((View.OnLongClickListener)this);
    }
    parama = paramView.findViewById(au.f.primary_text);
    p.j(parama, "itemView.findViewById(R.id.primary_text)");
    this.rcK = ((TextView)parama);
    parama = paramView.findViewById(au.f.tag_text);
    p.j(parama, "itemView.findViewById(R.id.tag_text)");
    this.rcL = ((TextView)parama);
    parama = paramView.findViewById(au.f.icon);
    p.j(parama, "itemView.findViewById(R.id.icon)");
    this.rcM = ((ImageView)parama);
    paramView = paramView.findViewById(au.f.divider);
    p.j(paramView, "itemView.findViewById(R.id.divider)");
    this.rcN = paramView;
    AppMethodBeat.o(51284);
  }
  
  private final void d(View paramView, String paramString)
  {
    AppMethodBeat.i(175230);
    Object localObject = this.rcO;
    if (localObject != null)
    {
      f localf = f.pZN;
      if (paramView == null) {
        p.iCn();
      }
      paramView = paramView.getContext();
      String str1 = ((LocalUsageInfo)localObject).username;
      String str2 = ((LocalUsageInfo)localObject).appId;
      int i = ((LocalUsageInfo)localObject).cBU;
      localObject = new AppBrandStatObject();
      ((AppBrandStatObject)localObject).scene = 1103;
      localf.a(paramView, str1, str2, paramString, i, 0, (AppBrandStatObject)localObject, null, null);
      paramView = this.rcJ;
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
  
  public boolean ckW()
  {
    return this.rcI;
  }
  
  public final ImageView ckY()
  {
    return this.rcM;
  }
  
  final void ckZ()
  {
    AppMethodBeat.i(51282);
    com.tencent.mm.modelappbrand.a.b localb = com.tencent.mm.modelappbrand.a.b.bhh();
    ImageView localImageView = this.rcM;
    LocalUsageInfo localLocalUsageInfo = this.rcO;
    if (localLocalUsageInfo == null) {
      p.iCn();
    }
    localb.a(localImageView, localLocalUsageInfo.nQm, com.tencent.mm.modelappbrand.a.a.bhg(), (b.h)g.lzF);
    AppMethodBeat.o(51282);
  }
  
  final void cla()
  {
    AppMethodBeat.i(51283);
    Object localObject1 = this.rcO;
    if (localObject1 == null) {
      p.iCn();
    }
    localObject1 = ((LocalUsageInfo)localObject1).nickname;
    TextView localTextView = this.rcK;
    Object localObject2 = (CharSequence)localObject1;
    int i;
    if ((localObject2 == null) || (((CharSequence)localObject2).length() == 0))
    {
      i = 1;
      if (i == 0) {
        break label122;
      }
      localObject1 = this.rcO;
      if (localObject1 == null) {
        p.iCn();
      }
      localObject1 = ((LocalUsageInfo)localObject1).username;
      p.j(localObject1, "itemInfo!!.username");
      localObject2 = Pattern.quote("@app");
      p.j(localObject2, "Pattern.quote(ConstantsStorage.TAG_APPBRAND)");
    }
    label122:
    for (localObject1 = (CharSequence)n.bx((String)localObject1, (String)localObject2, "");; localObject1 = (CharSequence)localObject1)
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
    p.k(paramLocalUsageInfo, "dataItem");
    this.rcO = paramLocalUsageInfo;
    paramLocalUsageInfo = e.yZ(paramLocalUsageInfo.cBU);
    CharSequence localCharSequence = (CharSequence)paramLocalUsageInfo;
    int i;
    if ((localCharSequence == null) || (localCharSequence.length() == 0))
    {
      i = 1;
      if (i == 0) {
        break label79;
      }
      this.rcL.setVisibility(8);
    }
    for (;;)
    {
      cla();
      ckZ();
      AppMethodBeat.o(51281);
      return;
      i = 0;
      break;
      label79:
      this.rcL.setVisibility(0);
      this.rcL.setText((CharSequence)paramLocalUsageInfo);
    }
  }
  
  public void onClick(View paramView)
  {
    AppMethodBeat.i(51280);
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.bn(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/appbrand/ui/collection/CollectionVerticalListViewHolder", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
    d(paramView, null);
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/appbrand/ui/collection/CollectionVerticalListViewHolder", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(51280);
  }
  
  public boolean onLongClick(final View paramView)
  {
    AppMethodBeat.i(175231);
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.bn(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/appbrand/ui/collection/CollectionVerticalListViewHolder", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, localb.aFi());
    if (a.ckU())
    {
      if (paramView == null) {
        p.iCn();
      }
      new m(paramView.getContext()).a(paramView, (View.OnCreateContextMenuListener)new h.b("?wechat_appbrand_test=1"), (q.g)new c(this, paramView, "?wechat_appbrand_test=1"), (e.b)h.d.rcQ);
    }
    for (boolean bool = true;; bool = false)
    {
      com.tencent.mm.hellhoundlib.a.a.a(bool, this, "com/tencent/mm/plugin/appbrand/ui/collection/CollectionVerticalListViewHolder", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
      AppMethodBeat.o(175231);
      return bool;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/ui/collection/CollectionVerticalListViewHolder$IEnterWxaListener;", "", "onEnter", "", "plugin-appbrand-integration_release"})
  public static abstract interface a
  {
    public abstract void onEnter();
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "<anonymous parameter 0>", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "index", "", "onMMMenuItemSelected"})
  static final class c
    implements q.g
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
        h.a(this.rcP, paramView, this.oyo);
        AppMethodBeat.o(175228);
        return;
        paramMenuItem = h.a(this.rcP);
      } while (paramMenuItem == null);
      View localView = paramView;
      if (localView == null) {
        p.iCn();
      }
      AppBrandProfileUI.a(localView.getContext(), paramMenuItem.username, 3, "", new WxaExposedParams.a().afz(paramMenuItem.appId).zu(3).bLN(), null, null);
      AppMethodBeat.o(175228);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.collection.h
 * JD-Core Version:    0.7.0.1
 */