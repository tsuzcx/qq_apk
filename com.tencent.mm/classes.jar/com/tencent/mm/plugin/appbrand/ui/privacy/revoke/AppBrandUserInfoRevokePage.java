package com.tencent.mm.plugin.appbrand.ui.privacy.revoke;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.q;
import androidx.lifecycle.r;
import androidx.lifecycle.y;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.appbrand.ba.c;
import com.tencent.mm.plugin.appbrand.ba.f;
import com.tencent.mm.plugin.appbrand.ba.g;
import com.tencent.mm.plugin.appbrand.ba.i;
import com.tencent.mm.plugin.appbrand.ui.privacy.d;
import com.tencent.mm.plugin.appbrand.widget.a.c;
import com.tencent.mm.plugin.appbrand.widget.a.c.a;
import com.tencent.mm.protocal.protobuf.gnd;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMFragment;
import kotlin.Metadata;
import kotlin.g.a.m;
import kotlin.g.b.s;
import kotlin.k;
import kotlin.o;
import kotlinx.coroutines.aq;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/ui/privacy/revoke/AppBrandUserInfoRevokePage;", "Lcom/tencent/mm/ui/MMFragment;", "()V", "curActionBarType", "Lcom/tencent/mm/plugin/appbrand/ui/privacy/revoke/ActionBarType;", "viewModel", "Lcom/tencent/mm/plugin/appbrand/ui/privacy/revoke/UserInfoRevokeViewModel;", "getViewModel$plugin_appbrand_integration_release$annotations", "getViewModel$plugin_appbrand_integration_release", "()Lcom/tencent/mm/plugin/appbrand/ui/privacy/revoke/UserInfoRevokeViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "checkContextOnCreateEarly", "", "getLayoutId", "", "initActivityBarArea", "", "initContentArea", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "view", "Landroid/view/View;", "showActionBar", "actionBarType", "showActionbarDefault", "showActionbarWithTitle", "Companion", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class AppBrandUserInfoRevokePage
  extends MMFragment
{
  public static final AppBrandUserInfoRevokePage.a ujG;
  private final kotlin.j ujH;
  private a ujI;
  
  static
  {
    AppMethodBeat.i(322838);
    ujG = new AppBrandUserInfoRevokePage.a((byte)0);
    AppMethodBeat.o(322838);
  }
  
  public AppBrandUserInfoRevokePage()
  {
    super(true);
    AppMethodBeat.i(322786);
    this.ujH = k.a(o.aiuH, (kotlin.g.a.a)new AppBrandUserInfoRevokePage.e(this));
    AppMethodBeat.o(322786);
  }
  
  public static final void a(AppCompatActivity paramAppCompatActivity, String paramString, Class<? extends MMActivity> paramClass)
  {
    AppMethodBeat.i(322828);
    s.u(paramAppCompatActivity, "srcActivity");
    s.u(paramClass, "dstActivityClass");
    Log.i("MicroMsg.AppBrandUserInfoRevokePage", s.X("start, appId: ", paramString));
    if (paramString != null)
    {
      kotlinx.coroutines.j.a((aq)r.g((q)paramAppCompatActivity), null, null, (m)new AppBrandUserInfoRevokePage.a.a(paramString, null), 3);
      paramClass = new Intent((Context)paramAppCompatActivity, paramClass);
      d.a(paramClass, AppBrandUserInfoRevokePage.class);
      paramClass.putExtra("appId", paramString);
      paramString = new com.tencent.mm.hellhoundlib.b.a().cG(paramClass);
      com.tencent.mm.hellhoundlib.a.a.b(paramAppCompatActivity, paramString.aYi(), "com/tencent/mm/plugin/appbrand/ui/privacy/revoke/AppBrandUserInfoRevokePage$Companion", "start", "(Landroidx/appcompat/app/AppCompatActivity;Ljava/lang/String;Ljava/lang/Class;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramAppCompatActivity.startActivity((Intent)paramString.sb(0));
      com.tencent.mm.hellhoundlib.a.a.c(paramAppCompatActivity, "com/tencent/mm/plugin/appbrand/ui/privacy/revoke/AppBrandUserInfoRevokePage$Companion", "start", "(Landroidx/appcompat/app/AppCompatActivity;Ljava/lang/String;Ljava/lang/Class;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    }
    AppMethodBeat.o(322828);
  }
  
  private static final void a(RecyclerView paramRecyclerView, AppBrandUserInfoRevokePage paramAppBrandUserInfoRevokePage, final int paramInt)
  {
    AppMethodBeat.i(322816);
    s.u(paramAppBrandUserInfoRevokePage, "this$0");
    paramRecyclerView.a((RecyclerView.l)new d(paramAppBrandUserInfoRevokePage, paramInt));
    AppMethodBeat.o(322816);
  }
  
  private final void a(a parama)
  {
    AppMethodBeat.i(322791);
    if (this.ujI == parama)
    {
      AppMethodBeat.o(322791);
      return;
    }
    switch (b.$EnumSwitchMapping$0[parama.ordinal()])
    {
    }
    for (;;)
    {
      this.ujI = parama;
      AppMethodBeat.o(322791);
      return;
      cMt();
      continue;
      cMu();
    }
  }
  
  private static final boolean a(AppBrandUserInfoRevokePage paramAppBrandUserInfoRevokePage, MenuItem paramMenuItem)
  {
    AppMethodBeat.i(322812);
    s.u(paramAppBrandUserInfoRevokePage, "this$0");
    paramAppBrandUserInfoRevokePage.finish();
    AppMethodBeat.o(322812);
    return true;
  }
  
  private final void cMt()
  {
    AppMethodBeat.i(322799);
    Log.i("MicroMsg.AppBrandUserInfoRevokePage", "showActionbarDefault");
    setMMTitle("");
    d.c((MMFragment)this);
    d.b((MMFragment)this, androidx.core.content.a.w(d.b((MMFragment)this), ba.c.BG_2));
    AppMethodBeat.o(322799);
  }
  
  private final void cMu()
  {
    AppMethodBeat.i(322805);
    Log.i("MicroMsg.AppBrandUserInfoRevokePage", "showActionbarWithTitle");
    setMMTitle(ba.i.appbrand_authorize_user_info);
    d.d((MMFragment)this);
    d.b((MMFragment)this, androidx.core.content.a.w(d.b((MMFragment)this), ba.c.BG_0));
    AppMethodBeat.o(322805);
  }
  
  public final l cMx()
  {
    AppMethodBeat.i(322856);
    l locall = (l)this.ujH.getValue();
    AppMethodBeat.o(322856);
    return locall;
  }
  
  public final int getLayoutId()
  {
    return ba.g.app_brand_user_info_revoke_layout;
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(322868);
    super.onCreate(paramBundle);
    paramBundle = (CharSequence)getStringExtra("appId");
    if ((paramBundle == null) || (paramBundle.length() == 0))
    {
      i = 1;
      if (i == 0) {
        break label70;
      }
      Log.w("MicroMsg.AppBrandUserInfoRevokePage", "checkContextOnCreateEarly, appId is empty");
      finish();
    }
    label70:
    for (int i = 0;; i = 1)
    {
      if (i != 0) {
        break label75;
      }
      AppMethodBeat.o(322868);
      return;
      i = 0;
      break;
    }
    label75:
    AppMethodBeat.o(322868);
  }
  
  public final void onViewCreated(View paramView, final Bundle paramBundle)
  {
    AppMethodBeat.i(322880);
    s.u(paramView, "view");
    super.onViewCreated(paramView, paramBundle);
    setBackBtn(new AppBrandUserInfoRevokePage..ExternalSyntheticLambda0(this));
    a(a.ujD);
    d.a((MMFragment)this, androidx.core.content.a.w(d.b((MMFragment)this), ba.c.BG_2));
    paramView = findViewById(ba.f.user_info_content_area);
    if ((paramView instanceof RecyclerView)) {}
    for (paramView = (RecyclerView)paramView; paramView == null; paramView = null)
    {
      Log.w("MicroMsg.AppBrandUserInfoRevokePage", "initContentArea, findViewById return null");
      finish();
      AppMethodBeat.o(322880);
      return;
    }
    paramView.getContext();
    paramBundle = new LinearLayoutManager();
    final g localg = new g(this, new AppBrandUserInfoRevokePage..ExternalSyntheticLambda1(paramView, this));
    paramView.setLayoutManager((RecyclerView.LayoutManager)paramBundle);
    paramView.setAdapter((RecyclerView.a)localg);
    c.a locala = c.uyi;
    c.a.a((View)paramView, null, null, true, null, null, null, 8182);
    cMx().ukA.a(getViewLifecycleOwner(), (y)new c(paramView, this, localg, paramBundle));
    AppMethodBeat.o(322880);
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/appbrand/ui/privacy/revoke/AppBrandUserInfoRevokePage$initContentArea$1$1", "Landroidx/lifecycle/Observer;", "Lcom/tencent/mm/protocal/protobuf/WxaUseUserInfo;", "onChanged", "", "rawUsageInfo", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class c
    implements y<gnd>
  {
    c(RecyclerView paramRecyclerView, AppBrandUserInfoRevokePage paramAppBrandUserInfoRevokePage, g paramg, LinearLayoutManager paramLinearLayoutManager) {}
    
    private static final void a(g paramg, LinearLayoutManager paramLinearLayoutManager)
    {
      AppMethodBeat.i(322891);
      s.u(paramg, "$myAdapter");
      s.u(paramLinearLayoutManager, "$myLayoutManager");
      if (paramLinearLayoutManager.Jx() >= paramg.getItemCount() - 1) {}
      for (boolean bool = true;; bool = false)
      {
        Log.i("MicroMsg.AppBrandUserInfoRevokePage", s.X("configManageArea, fixAtScreenBottom: ", Boolean.valueOf(bool)));
        paramLinearLayoutManager = paramg.ujV;
        if (paramLinearLayoutManager != null) {
          break;
        }
        Log.i("MicroMsg.AppBrandUserInfoRevokePage", "configManageArea, curUsageInfo is null");
        AppMethodBeat.o(322891);
        return;
      }
      paramg.ujX = Boolean.valueOf(bool);
      paramg.fV(paramLinearLayoutManager.size - 1);
      AppMethodBeat.o(322891);
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/appbrand/ui/privacy/revoke/AppBrandUserInfoRevokePage$initContentArea$1$myAdapter$1$1", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "totalScrollY", "", "onScrolled", "", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "dx", "dy", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class d
    extends RecyclerView.l
  {
    private int uiX;
    
    d(AppBrandUserInfoRevokePage paramAppBrandUserInfoRevokePage, int paramInt) {}
    
    public final void onScrollStateChanged(RecyclerView paramRecyclerView, int paramInt)
    {
      AppMethodBeat.i(322910);
      b localb = new b();
      localb.cH(paramRecyclerView);
      localb.sc(paramInt);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/appbrand/ui/privacy/revoke/AppBrandUserInfoRevokePage$initContentArea$1$myAdapter$1$1", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroidx/recyclerview/widget/RecyclerView;I)V", this, localb.aYj());
      super.onScrollStateChanged(paramRecyclerView, paramInt);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/appbrand/ui/privacy/revoke/AppBrandUserInfoRevokePage$initContentArea$1$myAdapter$1$1", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroidx/recyclerview/widget/RecyclerView;I)V");
      AppMethodBeat.o(322910);
    }
    
    public final void onScrolled(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(322900);
      Object localObject = new b();
      ((b)localObject).cH(paramRecyclerView);
      ((b)localObject).sc(paramInt1);
      ((b)localObject).sc(paramInt2);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/appbrand/ui/privacy/revoke/AppBrandUserInfoRevokePage$initContentArea$1$myAdapter$1$1", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroidx/recyclerview/widget/RecyclerView;II)V", this, ((b)localObject).aYj());
      s.u(paramRecyclerView, "recyclerView");
      super.onScrolled(paramRecyclerView, paramInt1, paramInt2);
      this.uiX += paramInt2;
      localObject = this.ujK;
      if (this.uiX <= paramInt) {}
      for (paramRecyclerView = a.ujD;; paramRecyclerView = a.ujE)
      {
        AppBrandUserInfoRevokePage.a((AppBrandUserInfoRevokePage)localObject, paramRecyclerView);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/appbrand/ui/privacy/revoke/AppBrandUserInfoRevokePage$initContentArea$1$myAdapter$1$1", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroidx/recyclerview/widget/RecyclerView;II)V");
        AppMethodBeat.o(322900);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.privacy.revoke.AppBrandUserInfoRevokePage
 * JD-Core Version:    0.7.0.1
 */