package com.tencent.mm.plugin.appbrand.ui.collection;

import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelappbrand.a.b.h;
import com.tencent.mm.modelappbrand.a.g;
import com.tencent.mm.plugin.appbrand.appcache.e;
import com.tencent.mm.plugin.appbrand.appusage.LocalUsageInfo;
import com.tencent.mm.plugin.appbrand.ba.f;
import com.tencent.mm.plugin.appbrand.ba.i;
import com.tencent.mm.plugin.appbrand.config.WxaExposedParams.a;
import com.tencent.mm.plugin.appbrand.launching.precondition.f;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.ui.AppBrandProfileUI;
import com.tencent.mm.ui.tools.l;
import java.util.regex.Pattern;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;
import kotlin.n.n;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/ui/collection/CollectionVerticalListViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Landroid/view/View$OnClickListener;", "Landroid/view/View$OnLongClickListener;", "itemView", "Landroid/view/View;", "listener", "Lcom/tencent/mm/plugin/appbrand/ui/collection/CollectionVerticalListViewHolder$IEnterWxaListener;", "(Landroid/view/View;Lcom/tencent/mm/plugin/appbrand/ui/collection/CollectionVerticalListViewHolder$IEnterWxaListener;)V", "bottomLine", "getBottomLine", "()Landroid/view/View;", "canShowLongClickTestMenu", "", "getCanShowLongClickTestMenu", "()Z", "imageIcon", "Landroid/widget/ImageView;", "getImageIcon", "()Landroid/widget/ImageView;", "itemInfo", "Lcom/tencent/mm/plugin/appbrand/appusage/LocalUsageInfo;", "mListener", "getMListener", "()Lcom/tencent/mm/plugin/appbrand/ui/collection/CollectionVerticalListViewHolder$IEnterWxaListener;", "textName", "Landroid/widget/TextView;", "getTextName", "()Landroid/widget/TextView;", "textType", "getTextType", "fillContent", "", "dataItem", "fillDiffs", "newItem", "diffs", "Landroid/os/Bundle;", "fillIconURL", "fillNickname", "onClick", "v", "onLongClick", "startWeApp", "path", "", "IEnterWxaListener", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
public class h
  extends RecyclerView.v
  implements View.OnClickListener, View.OnLongClickListener
{
  private final boolean uis;
  private final a uit;
  private final TextView uiu;
  private final TextView uiv;
  private final ImageView uiw;
  final View uix;
  LocalUsageInfo uiy;
  
  public h(View paramView, a parama)
  {
    super(paramView);
    AppMethodBeat.i(51284);
    this.uit = parama;
    this.uis = true;
    paramView.setOnClickListener((View.OnClickListener)this);
    if ((cMl()) && (a.cMj())) {
      paramView.setOnLongClickListener((View.OnLongClickListener)this);
    }
    parama = paramView.findViewById(ba.f.primary_text);
    s.s(parama, "itemView.findViewById(R.id.primary_text)");
    this.uiu = ((TextView)parama);
    parama = paramView.findViewById(ba.f.tag_text);
    s.s(parama, "itemView.findViewById(R.id.tag_text)");
    this.uiv = ((TextView)parama);
    parama = paramView.findViewById(ba.f.icon);
    s.s(parama, "itemView.findViewById(R.id.icon)");
    this.uiw = ((ImageView)parama);
    paramView = paramView.findViewById(ba.f.divider);
    s.s(paramView, "itemView.findViewById(R.id.divider)");
    this.uix = paramView;
    AppMethodBeat.o(51284);
  }
  
  private static final void a(h paramh, View paramView, String paramString, MenuItem paramMenuItem, int paramInt)
  {
    AppMethodBeat.i(322664);
    s.u(paramh, "this$0");
    s.u(paramString, "$path");
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(322664);
      return;
      paramh.d(paramView, paramString);
      AppMethodBeat.o(322664);
      return;
      paramh = paramh.uiy;
      if (paramh != null)
      {
        s.checkNotNull(paramView);
        paramView = paramView.getContext();
        paramString = paramh.username;
        paramMenuItem = new WxaExposedParams.a();
        paramMenuItem.appId = paramh.appId;
        paramMenuItem.from = 3;
        AppBrandProfileUI.a(paramView, paramString, 3, "", true, paramMenuItem.cll(), null, null);
      }
    }
  }
  
  private static final void a(String paramString, ContextMenu paramContextMenu, View paramView, ContextMenu.ContextMenuInfo paramContextMenuInfo)
  {
    AppMethodBeat.i(322657);
    s.u(paramString, "$path");
    paramContextMenu.add(0, 0, 0, (CharSequence)s.X("打开小程序且path=", paramString));
    paramContextMenu.add(0, 1, 0, ba.i.app_brand_usage_view_profile);
    AppMethodBeat.o(322657);
  }
  
  private static final void cMq() {}
  
  private final void d(View paramView, String paramString)
  {
    AppMethodBeat.i(175230);
    Object localObject = this.uiy;
    if (localObject != null)
    {
      f localf = f.teH;
      s.checkNotNull(paramView);
      paramView = paramView.getContext();
      String str1 = ((LocalUsageInfo)localObject).username;
      String str2 = ((LocalUsageInfo)localObject).appId;
      int i = ((LocalUsageInfo)localObject).euz;
      localObject = new AppBrandStatObject();
      ((AppBrandStatObject)localObject).scene = 1103;
      ah localah = ah.aiuX;
      localf.a(paramView, str1, str2, paramString, i, 0, (AppBrandStatObject)localObject, null, null);
      paramView = this.uit;
      if (paramView != null) {
        paramView.onEnter();
      }
    }
    AppMethodBeat.o(175230);
  }
  
  public boolean cMl()
  {
    return this.uis;
  }
  
  public final ImageView cMn()
  {
    return this.uiw;
  }
  
  final void cMo()
  {
    AppMethodBeat.i(51282);
    com.tencent.mm.modelappbrand.a.b localb = com.tencent.mm.modelappbrand.a.b.bEY();
    ImageView localImageView = this.uiw;
    LocalUsageInfo localLocalUsageInfo = this.uiy;
    s.checkNotNull(localLocalUsageInfo);
    localb.a(localImageView, localLocalUsageInfo.qQb, com.tencent.mm.modelappbrand.a.a.bEX(), (b.h)g.org);
    AppMethodBeat.o(51282);
  }
  
  final void cMp()
  {
    AppMethodBeat.i(51283);
    Object localObject1 = this.uiy;
    s.checkNotNull(localObject1);
    localObject1 = ((LocalUsageInfo)localObject1).nickname;
    TextView localTextView = this.uiu;
    Object localObject2 = (CharSequence)localObject1;
    int i;
    if ((localObject2 == null) || (((CharSequence)localObject2).length() == 0))
    {
      i = 1;
      if (i == 0) {
        break label118;
      }
      localObject1 = this.uiy;
      s.checkNotNull(localObject1);
      localObject1 = ((LocalUsageInfo)localObject1).username;
      s.s(localObject1, "itemInfo!!.username");
      localObject2 = Pattern.quote("@app");
      s.s(localObject2, "quote(ConstantsStorage.TAG_APPBRAND)");
    }
    label118:
    for (localObject1 = (CharSequence)n.bW((String)localObject1, (String)localObject2, "");; localObject1 = (CharSequence)localObject1)
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
    s.u(paramLocalUsageInfo, "dataItem");
    this.uiy = paramLocalUsageInfo;
    paramLocalUsageInfo = e.zm(paramLocalUsageInfo.euz);
    CharSequence localCharSequence = (CharSequence)paramLocalUsageInfo;
    int i;
    if ((localCharSequence == null) || (localCharSequence.length() == 0))
    {
      i = 1;
      if (i == 0) {
        break label79;
      }
      this.uiv.setVisibility(8);
    }
    for (;;)
    {
      cMp();
      cMo();
      AppMethodBeat.o(51281);
      return;
      i = 0;
      break;
      label79:
      this.uiv.setVisibility(0);
      this.uiv.setText((CharSequence)paramLocalUsageInfo);
    }
  }
  
  public void onClick(View paramView)
  {
    AppMethodBeat.i(51280);
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/appbrand/ui/collection/CollectionVerticalListViewHolder", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
    d(paramView, null);
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/appbrand/ui/collection/CollectionVerticalListViewHolder", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(51280);
  }
  
  public boolean onLongClick(View paramView)
  {
    AppMethodBeat.i(175231);
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/appbrand/ui/collection/CollectionVerticalListViewHolder", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, localb.aYj());
    if (a.cMj())
    {
      s.checkNotNull(paramView);
      new l(paramView.getContext()).a(paramView, new h..ExternalSyntheticLambda0("?wechat_appbrand_test=1"), new h..ExternalSyntheticLambda1(this, paramView, "?wechat_appbrand_test=1"), h..ExternalSyntheticLambda2.INSTANCE);
    }
    for (boolean bool = true;; bool = false)
    {
      com.tencent.mm.hellhoundlib.a.a.a(bool, this, "com/tencent/mm/plugin/appbrand/ui/collection/CollectionVerticalListViewHolder", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
      AppMethodBeat.o(175231);
      return bool;
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/ui/collection/CollectionVerticalListViewHolder$IEnterWxaListener;", "", "onEnter", "", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static abstract interface a
  {
    public abstract void onEnter();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.collection.h
 * JD-Core Version:    0.7.0.1
 */