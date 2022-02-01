package com.tencent.mm.plugin.appbrand.ui.privacy.revoke;

import android.app.Dialog;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.x;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.appbrand.ba.h;
import com.tencent.mm.plugin.appbrand.ba.i;
import com.tencent.mm.plugin.appbrand.ui.privacy.d;
import com.tencent.mm.protocal.protobuf.gnd;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMFragment;
import com.tencent.mm.ui.base.aa;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.u;
import kotlin.p;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/ui/privacy/revoke/UserInfoManageAreaAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/tencent/mm/plugin/appbrand/ui/privacy/revoke/ViewHolder;", "host", "Lcom/tencent/mm/plugin/appbrand/ui/privacy/revoke/AppBrandUserInfoRevokePage;", "titleHeightMeasureListener", "Lcom/tencent/mm/plugin/appbrand/ui/privacy/revoke/ITitleHeightMeasureListener;", "(Lcom/tencent/mm/plugin/appbrand/ui/privacy/revoke/AppBrandUserInfoRevokePage;Lcom/tencent/mm/plugin/appbrand/ui/privacy/revoke/ITitleHeightMeasureListener;)V", "fixManageAreaAtScreenBottom", "", "Ljava/lang/Boolean;", "isManageAreaConfigDone", "onTitleHeightMeasuredOnce", "com/tencent/mm/plugin/appbrand/ui/privacy/revoke/UserInfoManageAreaAdapter$onTitleHeightMeasuredOnce$1", "Lcom/tencent/mm/plugin/appbrand/ui/privacy/revoke/UserInfoManageAreaAdapter$onTitleHeightMeasuredOnce$1;", "showingDialog", "Landroid/app/Dialog;", "usageInfo", "Lcom/tencent/mm/plugin/appbrand/ui/privacy/revoke/FlattenedUsageInfo;", "configManageArea", "", "fixAtScreenBottom", "createRevokeMenu", "menu", "Landroid/view/ContextMenu;", "dismissDialogIfNeed", "getItemCount", "", "getItemViewType", "position", "onBindViewHolder", "holder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "onRevokeMenuClick", "menuItem", "Landroid/view/MenuItem;", "onRevokeTrigger", "Lkotlin/Function0;", "showRevokeFailureToast", "showRevokeSuccessToast", "showRevokingDialog", "bindLongClickRevokeMenu", "Landroid/view/View;", "doRevokeDoubleCheck", "Lcom/tencent/mm/plugin/appbrand/ui/privacy/revoke/UserInfoUsageInfoItem;", "unBindLongClickRevokeMenu", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
final class g
  extends RecyclerView.a<n>
{
  private final AppBrandUserInfoRevokePage ujU;
  e ujV;
  private final g ujW;
  Boolean ujX;
  private boolean ujY;
  private Dialog ujZ;
  
  public g(AppBrandUserInfoRevokePage paramAppBrandUserInfoRevokePage, f paramf)
  {
    AppMethodBeat.i(322878);
    this.ujU = paramAppBrandUserInfoRevokePage;
    this.ujW = new g(paramf);
    this.ujU.cMx().ukA.a(this.ujU.getViewLifecycleOwner(), new g..ExternalSyntheticLambda5(this));
    this.ujU.cMx().ukC.a(this.ujU.getViewLifecycleOwner(), new g..ExternalSyntheticLambda3(this));
    this.ujU.cMx().ukE.a(this.ujU.getViewLifecycleOwner(), new g..ExternalSyntheticLambda4(this));
    AppMethodBeat.o(322878);
  }
  
  private final void a(ContextMenu paramContextMenu)
  {
    AppMethodBeat.i(322886);
    if (paramContextMenu != null) {
      paramContextMenu.add(0, 0, 0, (CharSequence)this.ujU.getString(ba.i.appbrand_user_info_revoke_hint));
    }
    AppMethodBeat.o(322886);
  }
  
  private static void a(MenuItem paramMenuItem, kotlin.g.a.a<ah> parama)
  {
    AppMethodBeat.i(322893);
    if ((paramMenuItem != null) && (paramMenuItem.getGroupId() == 0)) {}
    for (int i = 1; (i != 0) && (paramMenuItem.getItemId() == 0); i = 0)
    {
      parama.invoke();
      AppMethodBeat.o(322893);
      return;
    }
    Log.w("MicroMsg.AppBrandUserInfoRevokePage", "onRevokeMenuClick, not revoke menu");
    AppMethodBeat.o(322893);
  }
  
  private static final void a(g paramg, ContextMenu paramContextMenu, View paramView, ContextMenu.ContextMenuInfo paramContextMenuInfo)
  {
    AppMethodBeat.i(322965);
    kotlin.g.b.s.u(paramg, "this$0");
    paramg.a(paramContextMenu);
    AppMethodBeat.o(322965);
  }
  
  private static final void a(g paramg, View paramView)
  {
    AppMethodBeat.i(322950);
    Object localObject = new Object();
    b localb = new b();
    localb.cH(paramg);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/appbrand/ui/privacy/revoke/UserInfoManageAreaAdapter", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    kotlin.g.b.s.u(paramg, "this$0");
    localObject = paramg.ujU.cMx();
    Log.i("MicroMsg.AppBrand.UserInfoRevokeViewModel", "onManageBtnClick");
    paramView = (i)((l)localObject).ukB.getValue();
    paramg = paramView;
    if (paramView == null) {
      paramg = i.uko;
    }
    kotlin.g.b.s.s(paramg, "_pageModeObservable.valu…InfoRevokePageMode.NORMAL");
    paramView = ((l)localObject).ukB;
    if (i.uko == paramg) {}
    for (paramg = i.ukp;; paramg = i.uko)
    {
      paramView.setValue(paramg);
      com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/appbrand/ui/privacy/revoke/UserInfoManageAreaAdapter", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(322950);
      return;
    }
  }
  
  private static final void a(g paramg, i parami)
  {
    AppMethodBeat.i(322916);
    kotlin.g.b.s.u(paramg, "this$0");
    Log.i("MicroMsg.AppBrandUserInfoRevokePage", kotlin.g.b.s.X("onChanged#pageModeObservable, pageMode: ", parami));
    if (parami == null)
    {
      Log.w("MicroMsg.AppBrandUserInfoRevokePage", "onChanged#pageModeObservable, pageMode is null");
      AppMethodBeat.o(322916);
      return;
    }
    paramg.bZE.notifyChanged();
    AppMethodBeat.o(322916);
  }
  
  private static final void a(g paramg, k paramk)
  {
    AppMethodBeat.i(322923);
    kotlin.g.b.s.u(paramg, "this$0");
    Log.i("MicroMsg.AppBrandUserInfoRevokePage", kotlin.g.b.s.X("onChanged#revokeStateObservable, revokeState: ", paramk));
    if (paramk == null)
    {
      Log.i("MicroMsg.AppBrandUserInfoRevokePage", "onChanged#revokeStateObservable, revokeState is null");
      AppMethodBeat.o(322923);
      return;
    }
    switch (g.a.$EnumSwitchMapping$0[paramk.ordinal()])
    {
    }
    for (;;)
    {
      AppMethodBeat.o(322923);
      return;
      Log.i("MicroMsg.AppBrandUserInfoRevokePage", "showRevokingDialog");
      paramg.cMy();
      paramg.ujZ = ((Dialog)com.tencent.mm.ui.base.k.a(d.b((MMFragment)paramg.ujU), null, false, null));
      AppMethodBeat.o(322923);
      return;
      Log.i("MicroMsg.AppBrandUserInfoRevokePage", "showRevokeSuccessToast");
      paramg.cMy();
      aa.y(d.b((MMFragment)paramg.ujU), paramg.ujU.getString(ba.i.appbrand_user_info_revoke_success_hint), ba.h.icons_filled_done);
      AppMethodBeat.o(322923);
      return;
      Log.i("MicroMsg.AppBrandUserInfoRevokePage", "showRevokeFailureToast");
      paramg.cMy();
      aa.y(d.b((MMFragment)paramg.ujU), paramg.ujU.getString(ba.i.appbrand_user_info_revoke_fail_hint), ba.h.icons_filled_error);
    }
  }
  
  private static final void a(g paramg, m paramm, MenuItem paramMenuItem, int paramInt)
  {
    AppMethodBeat.i(322981);
    kotlin.g.b.s.u(paramg, "this$0");
    kotlin.g.b.s.u(paramm, "$this_doRevokeDoubleCheck");
    a(paramMenuItem, (kotlin.g.a.a)new g.c(paramg, paramm));
    AppMethodBeat.o(322981);
  }
  
  private static final void a(g paramg, n paramn)
  {
    AppMethodBeat.i(322935);
    kotlin.g.b.s.u(paramg, "this$0");
    kotlin.g.b.s.u(paramn, "$holder");
    paramg = paramg.ujW;
    paramn = (kotlin.g.a.a)new d(paramn);
    kotlin.g.b.s.u(paramn, "measuredHeightResolver");
    if (!paramg.ukf)
    {
      paramg.ukg.onTitleHeightMeasured(((Number)paramn.invoke()).intValue());
      paramg.ukf = true;
    }
    AppMethodBeat.o(322935);
  }
  
  private static final void a(g paramg, gnd paramgnd)
  {
    AppMethodBeat.i(322908);
    kotlin.g.b.s.u(paramg, "this$0");
    Log.i("MicroMsg.AppBrandUserInfoRevokePage", "onChanged#usageInfoObservable");
    j localj = j.ukr;
    if (!j.a(paramgnd))
    {
      Log.w("MicroMsg.AppBrandUserInfoRevokePage", "onChanged#usageInfoObservable, rawUsageInfo is null or invalid");
      AppMethodBeat.o(322908);
      return;
    }
    kotlin.g.b.s.s(paramgnd, "rawUsageInfo");
    paramg.ujV = new e(paramgnd);
    paramg.bZE.notifyChanged();
    AppMethodBeat.o(322908);
  }
  
  private static final void a(g paramg, com.tencent.mm.ui.base.s params)
  {
    AppMethodBeat.i(322975);
    kotlin.g.b.s.u(paramg, "this$0");
    paramg.a((ContextMenu)params);
    AppMethodBeat.o(322975);
  }
  
  private static final void a(g paramg, kotlin.g.a.a parama, MenuItem paramMenuItem, int paramInt)
  {
    AppMethodBeat.i(322971);
    kotlin.g.b.s.u(paramg, "this$0");
    kotlin.g.b.s.u(parama, "$onRevokeTrigger");
    a(paramMenuItem, parama);
    AppMethodBeat.o(322971);
  }
  
  private static final void a(n paramn)
  {
    AppMethodBeat.i(322931);
    kotlin.g.b.s.u(paramn, "$holder");
    LinearLayout localLinearLayout = ((n.a)paramn).ukL;
    if (localLinearLayout != null) {
      if (1 >= ((n.a)paramn).ujk.getLineCount()) {
        break label54;
      }
    }
    label54:
    for (int i = 48;; i = 16)
    {
      localLinearLayout.setGravity(i);
      AppMethodBeat.o(322931);
      return;
    }
  }
  
  private static final void a(n paramn, g paramg)
  {
    AppMethodBeat.i(322958);
    kotlin.g.b.s.u(paramn, "$holder");
    kotlin.g.b.s.u(paramg, "this$0");
    Object localObject = ((n.b)paramn).ukN;
    if (localObject != null) {
      ((Button)localObject).setVisibility(0);
    }
    int i = paramg.ujU.getWindow().getDecorView().getHeight();
    localObject = paramn.caK;
    kotlin.g.b.s.s(localObject, "holder.itemView");
    int j = com.tencent.mm.ae.d.da(localObject)[1];
    int k = paramn.caK.getMeasuredHeight();
    Log.i("MicroMsg.AppBrandUserInfoRevokePage", "fixManageAreaAtScreenBottom, windowHeight: " + i + ", manageAreaY: " + j + ", manageAreaHeight: " + k);
    i -= j + k;
    if (i > 0) {
      paramn.caK.setPadding(0, i, 0, 0);
    }
    paramg.ujY = true;
    AppMethodBeat.o(322958);
  }
  
  private static final void b(kotlin.g.a.a parama, View paramView)
  {
    AppMethodBeat.i(322942);
    Object localObject = new Object();
    b localb = new b();
    localb.cH(parama);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/appbrand/ui/privacy/revoke/UserInfoManageAreaAdapter", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    kotlin.g.b.s.u(parama, "$onRevokeBtnClick");
    parama.invoke();
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/appbrand/ui/privacy/revoke/UserInfoManageAreaAdapter", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(322942);
  }
  
  private final void cMy()
  {
    AppMethodBeat.i(322899);
    Dialog localDialog = this.ujZ;
    if (localDialog != null) {
      localDialog.dismiss();
    }
    this.ujZ = null;
    AppMethodBeat.o(322899);
  }
  
  public final int getItemCount()
  {
    e locale = this.ujV;
    if (locale == null) {
      return 0;
    }
    return locale.size;
  }
  
  public final int getItemViewType(int paramInt)
  {
    AppMethodBeat.i(323062);
    for (;;)
    {
      try
      {
        localObject = this.ujV;
        if (localObject == null)
        {
          Log.w("MicroMsg.AppBrandUserInfoRevokePage", "getItemViewType, curUsageInfo is null");
          int i = super.getItemViewType(paramInt);
          AppMethodBeat.o(323062);
          return i;
        }
        localObject = ((e)localObject).Dr(paramInt);
        boolean bool = localObject instanceof d.a;
        if (!bool) {
          continue;
        }
        paramInt = 0;
      }
      catch (Exception localException)
      {
        Object localObject;
        Log.w("MicroMsg.AppBrandUserInfoRevokePage", "getItemViewType, position: " + paramInt + " fail since " + localException);
        paramInt = super.getItemViewType(paramInt);
        continue;
      }
      AppMethodBeat.o(323062);
      return paramInt;
      if ((localObject instanceof d.d))
      {
        paramInt = 1;
      }
      else if ((localObject instanceof d.c))
      {
        paramInt = 2;
      }
      else
      {
        if (!(localObject instanceof d.b)) {
          continue;
        }
        paramInt = 3;
      }
    }
    localObject = new p();
    AppMethodBeat.o(323062);
    throw ((Throwable)localObject);
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class d
    extends u
    implements kotlin.g.a.a<Integer>
  {
    d(n paramn)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/appbrand/ui/privacy/revoke/UserInfoManageAreaAdapter$onTitleHeightMeasuredOnce$1", "", "hasMeasured", "", "resolveMeasuredHeightAndCallbackIfNeed", "", "measuredHeightResolver", "Lkotlin/Function0;", "", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class g
  {
    boolean ukf;
    
    g(f paramf) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.privacy.revoke.g
 * JD-Core Version:    0.7.0.1
 */