package com.tencent.mm.plugin.appbrand.ui.privacy.manage;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import androidx.lifecycle.q;
import androidx.lifecycle.r;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ba.c;
import com.tencent.mm.plugin.appbrand.ba.d;
import com.tencent.mm.plugin.appbrand.ba.f;
import com.tencent.mm.plugin.appbrand.ba.g;
import com.tencent.mm.plugin.appbrand.ba.i;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.plugin.appbrand.ui.AppBrandAuthorizeUI;
import com.tencent.mm.plugin.appbrand.widget.a.c.a;
import com.tencent.mm.plugin.appbrand.widget.recyclerview.LoadMoreRecyclerView;
import com.tencent.mm.protocal.protobuf.gng;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMFragment;
import com.tencent.mm.ui.base.w;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.a.p;
import kotlin.ah;
import kotlin.g.a.m;
import kotlin.g.b.ah.f;
import kotlin.g.b.s;
import kotlin.g.b.u;
import kotlinx.coroutines.aq;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/ui/privacy/manage/AppBrandPrivacyManagePage;", "Lcom/tencent/mm/ui/MMFragment;", "()V", "curActionBarType", "Lcom/tencent/mm/plugin/appbrand/ui/privacy/manage/ActionBarType;", "userAuthScopeList4Show", "", "Lcom/tencent/mm/plugin/appbrand/ui/privacy/manage/WxaAppAuthorizeScopeListWithAttrs;", "Lcom/tencent/mm/plugin/appbrand/ui/privacy/manage/WxaAppUserAuthorizeScopeListWithAttrs;", "getUserAuthScopeList4Show", "(Lcom/tencent/mm/plugin/appbrand/ui/privacy/manage/WxaAppUserAuthorizeScopeListWithAttrs;)Ljava/util/List;", "getLayoutId", "", "initActivityBarArea", "", "initContentArea", "onViewCreated", "view", "Landroid/view/View;", "savedInstanceState", "Landroid/os/Bundle;", "openSetting", "username", "", "showActionBar", "actionBarType", "showActionbarDefault", "showActionbarWithTitle", "filterDuplicateBackgroundScope", "filterNotNeedShowScopes", "Lcom/tencent/mm/plugin/appbrand/ui/privacy/manage/WxaAppAuthorizeScopeInfo;", "allShownScopeList", "merge", "appAuthScopeInfo", "Companion", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class AppBrandPrivacyManagePage
  extends MMFragment
{
  public static final AppBrandPrivacyManagePage.a uiV;
  private a uiW;
  
  static
  {
    AppMethodBeat.i(323064);
    uiV = new AppBrandPrivacyManagePage.a((byte)0);
    AppMethodBeat.o(323064);
  }
  
  public AppBrandPrivacyManagePage()
  {
    super(true);
  }
  
  private static j a(j paramj)
  {
    AppMethodBeat.i(322978);
    Object localObject2 = ((Iterable)paramj.uju).iterator();
    do
    {
      if (!((Iterator)localObject2).hasNext()) {
        break;
      }
      localObject1 = ((Iterator)localObject2).next();
    } while (!s.p("scope.userLocationBackground", ((gng)localObject1).scope));
    for (;;)
    {
      localObject2 = (gng)localObject1;
      if (localObject2 != null) {
        break;
      }
      AppMethodBeat.o(322978);
      return paramj;
      localObject1 = null;
    }
    Object localObject3 = ((Iterable)paramj.uju).iterator();
    while (((Iterator)localObject3).hasNext())
    {
      localObject1 = ((Iterator)localObject3).next();
      if (s.p("scope.userLocation", ((gng)localObject1).scope)) {
        if (localObject1 == null) {
          break label139;
        }
      }
    }
    label139:
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        break label144;
      }
      AppMethodBeat.o(322978);
      return paramj;
      localObject1 = null;
      break;
    }
    label144:
    Log.i("MicroMsg.AppBrandPrivacyManagePage", s.X("filterDuplicateBackgroundScope, both background and backgroundLocation are authorized for ", paramj.ujt.field_username));
    Object localObject1 = paramj.ujt;
    localObject3 = new ArrayList((Collection)paramj.uju);
    ((ArrayList)localObject3).remove(localObject2);
    localObject2 = ah.aiuX;
    paramj = new j((WxaAttributes)localObject1, (List)localObject3, paramj.hdp);
    AppMethodBeat.o(322978);
    return paramj;
  }
  
  private static List<j> a(l paraml)
  {
    AppMethodBeat.i(322983);
    Object localObject = (Iterable)paraml.ujB;
    paraml = (Collection)new ArrayList(p.a((Iterable)localObject, 10));
    localObject = ((Iterable)localObject).iterator();
    while (((Iterator)localObject).hasNext()) {
      paraml.add(a((j)((Iterator)localObject).next()));
    }
    paraml = (List)paraml;
    AppMethodBeat.o(322983);
    return paraml;
  }
  
  private static final void a(ViewGroup paramViewGroup, AppBrandPrivacyManagePage paramAppBrandPrivacyManagePage, LoadMoreRecyclerView paramLoadMoreRecyclerView)
  {
    AppMethodBeat.i(322996);
    s.u(paramAppBrandPrivacyManagePage, "this$0");
    paramLoadMoreRecyclerView.a((RecyclerView.l)new c(paramAppBrandPrivacyManagePage, paramViewGroup.getMeasuredHeight() - com.tencent.mm.cd.a.bs((Context)paramAppBrandPrivacyManagePage.getContext(), ba.d.Edge_6A)));
    AppMethodBeat.o(322996);
  }
  
  private static final void a(final com.tencent.mm.plugin.appbrand.ui.privacy.c paramc, final AppBrandPrivacyManagePage paramAppBrandPrivacyManagePage, ah.f paramf, final h paramh, LoadMoreRecyclerView paramLoadMoreRecyclerView, RecyclerView.a parama)
  {
    AppMethodBeat.i(323028);
    s.u(paramc, "$footerViewController");
    s.u(paramAppBrandPrivacyManagePage, "this$0");
    s.u(paramf, "$fetchToken");
    s.u(paramh, "$adapter");
    if (!paramc.isLoading)
    {
      Log.i("MicroMsg.AppBrandPrivacyManagePage", "onLoadMore, loading is not shown");
      AppMethodBeat.o(323028);
      return;
    }
    kotlinx.coroutines.j.a((aq)r.g((q)paramAppBrandPrivacyManagePage), null, null, (m)new d(paramf, paramc, paramh, paramAppBrandPrivacyManagePage, null), 3);
    AppMethodBeat.o(323028);
  }
  
  private final void a(a parama)
  {
    AppMethodBeat.i(322957);
    if (this.uiW == parama)
    {
      AppMethodBeat.o(322957);
      return;
    }
    switch (b.$EnumSwitchMapping$0[parama.ordinal()])
    {
    }
    for (;;)
    {
      this.uiW = parama;
      AppMethodBeat.o(322957);
      return;
      cMt();
      continue;
      cMu();
    }
  }
  
  private static final void a(h paramh, AppBrandPrivacyManagePage paramAppBrandPrivacyManagePage, RecyclerView paramRecyclerView, View paramView, int paramInt, long paramLong)
  {
    AppMethodBeat.i(323007);
    s.u(paramh, "$adapter");
    s.u(paramAppBrandPrivacyManagePage, "this$0");
    paramh = (j)p.ae((List)paramh.ujq, paramInt);
    if (paramh == null)
    {
      paramh = null;
      paramRecyclerView = (CharSequence)paramh;
      if ((paramRecyclerView != null) && (paramRecyclerView.length() != 0)) {
        break label126;
      }
    }
    label126:
    for (int i = 1;; i = 0)
    {
      if (i == 0) {
        break label132;
      }
      Log.w("MicroMsg.AppBrandPrivacyManagePage", "onItemClick, position: " + paramInt + ", username is empty");
      AppMethodBeat.o(323007);
      return;
      paramh = paramh.ujt;
      if (paramh == null)
      {
        paramh = null;
        break;
      }
      paramh = paramh.field_username;
      break;
    }
    label132:
    Log.i("MicroMsg.AppBrandPrivacyManagePage", s.X("openSetting, username: ", paramh));
    paramRecyclerView = new Intent(com.tencent.mm.plugin.appbrand.ui.privacy.d.b((MMFragment)paramAppBrandPrivacyManagePage), AppBrandAuthorizeUI.class);
    paramRecyclerView.putExtra("key_username", paramh);
    paramRecyclerView.putExtra("key_app_authorize_jsapi", false);
    paramh = new com.tencent.mm.hellhoundlib.b.a().cG(paramRecyclerView);
    com.tencent.mm.hellhoundlib.a.a.b(paramAppBrandPrivacyManagePage, paramh.aYi(), "com/tencent/mm/plugin/appbrand/ui/privacy/manage/AppBrandPrivacyManagePage", "openSetting", "(Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramAppBrandPrivacyManagePage.startActivity((Intent)paramh.sb(0));
    com.tencent.mm.hellhoundlib.a.a.c(paramAppBrandPrivacyManagePage, "com/tencent/mm/plugin/appbrand/ui/privacy/manage/AppBrandPrivacyManagePage", "openSetting", "(Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(323007);
  }
  
  private static final void a(LoadMoreRecyclerView paramLoadMoreRecyclerView)
  {
    AppMethodBeat.i(323018);
    paramLoadMoreRecyclerView.showLoading(true);
    AppMethodBeat.o(323018);
  }
  
  private static final void a(w paramw)
  {
    AppMethodBeat.i(323032);
    paramw.dismiss();
    AppMethodBeat.o(323032);
  }
  
  private static final boolean a(AppBrandPrivacyManagePage paramAppBrandPrivacyManagePage, MenuItem paramMenuItem)
  {
    AppMethodBeat.i(322988);
    s.u(paramAppBrandPrivacyManagePage, "this$0");
    paramAppBrandPrivacyManagePage.finish();
    AppMethodBeat.o(322988);
    return true;
  }
  
  private final void cMt()
  {
    AppMethodBeat.i(322962);
    Log.i("MicroMsg.AppBrandPrivacyManagePage", "showActionbarDefault");
    setMMTitle("");
    com.tencent.mm.plugin.appbrand.ui.privacy.d.c((MMFragment)this);
    com.tencent.mm.plugin.appbrand.ui.privacy.d.b((MMFragment)this, androidx.core.content.a.w(com.tencent.mm.plugin.appbrand.ui.privacy.d.b((MMFragment)this), ba.c.BG_2));
    AppMethodBeat.o(322962);
  }
  
  private final void cMu()
  {
    AppMethodBeat.i(322970);
    Log.i("MicroMsg.AppBrandPrivacyManagePage", "showActionbarWithTitle");
    setMMTitle(ba.i.appbrand_privacy_manage_title);
    com.tencent.mm.plugin.appbrand.ui.privacy.d.d((MMFragment)this);
    com.tencent.mm.plugin.appbrand.ui.privacy.d.b((MMFragment)this, androidx.core.content.a.w(com.tencent.mm.plugin.appbrand.ui.privacy.d.b((MMFragment)this), ba.c.BG_0));
    AppMethodBeat.o(322970);
  }
  
  public final int getLayoutId()
  {
    return ba.g.app_brand_privacy_manage_layout;
  }
  
  public final void onViewCreated(final View paramView, final Bundle paramBundle)
  {
    AppMethodBeat.i(323091);
    s.u(paramView, "view");
    super.onViewCreated(paramView, paramBundle);
    setBackBtn(new AppBrandPrivacyManagePage..ExternalSyntheticLambda0(this));
    a(a.uiH);
    com.tencent.mm.plugin.appbrand.ui.privacy.d.a((MMFragment)this, androidx.core.content.a.w(com.tencent.mm.plugin.appbrand.ui.privacy.d.b((MMFragment)this), ba.c.BG_2));
    paramView = findViewById(ba.f.content_area);
    if ((paramView instanceof LoadMoreRecyclerView)) {}
    for (paramView = (LoadMoreRecyclerView)paramView; paramView == null; paramView = null)
    {
      Log.w("MicroMsg.AppBrandPrivacyManagePage", "initContentArea, authInfoContentArea is null");
      finish();
      AppMethodBeat.o(323091);
      return;
    }
    int i = com.tencent.mm.cd.a.bs(com.tencent.mm.plugin.appbrand.ui.privacy.d.b((MMFragment)this), ba.d.Edge_3A);
    paramView.setPadding(i, 0, i, 0);
    paramBundle = getLayoutInflater().inflate(ba.g.app_brand_privacy_manage_header_item, (ViewGroup)paramView, false);
    if ((paramBundle instanceof ViewGroup)) {}
    for (paramBundle = (ViewGroup)paramBundle; paramBundle == null; paramBundle = null)
    {
      Log.w("MicroMsg.AppBrandPrivacyManagePage", "initContentArea, headerView is null");
      finish();
      AppMethodBeat.o(323091);
      return;
    }
    paramBundle.post(new AppBrandPrivacyManagePage..ExternalSyntheticLambda4(paramBundle, this, paramView));
    paramView.ev((View)paramBundle);
    final com.tencent.mm.plugin.appbrand.ui.privacy.c localc = new com.tencent.mm.plugin.appbrand.ui.privacy.c((ViewGroup)paramView, ba.i.appbrand_privacy_manage_footer);
    paramView.setLoadingView(localc.uiF);
    paramView.showLoading(false);
    Object localObject = com.tencent.mm.plugin.appbrand.widget.a.c.uyi;
    c.a.a((View)paramView, null, null, true, null, null, null, 8182);
    localObject = new h();
    paramView.setAdapter((RecyclerView.a)localObject);
    paramView.setOnItemClickListener(new AppBrandPrivacyManagePage..ExternalSyntheticLambda2((h)localObject, this));
    final ah.f localf = new ah.f();
    paramView.setOnLoadingStateChangedListener(new AppBrandPrivacyManagePage..ExternalSyntheticLambda1(localc, this, localf, (h)localObject));
    w localw = com.tencent.mm.ui.base.k.a(com.tencent.mm.plugin.appbrand.ui.privacy.d.b((MMFragment)this), null, false, null);
    MMActivity localMMActivity = com.tencent.mm.plugin.appbrand.ui.privacy.d.a((MMFragment)this);
    if (localMMActivity != null) {
      localMMActivity.keep(new AppBrandPrivacyManagePage..ExternalSyntheticLambda3(localw));
    }
    kotlinx.coroutines.j.a((aq)r.g((q)this), null, null, (m)new e(localw, paramBundle, localc, localf, (h)localObject, this, paramView, null), 3);
    AppMethodBeat.o(323091);
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/appbrand/ui/privacy/manage/AppBrandPrivacyManagePage$initContentArea$1$1", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "totalScrollY", "", "onScrolled", "", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "dx", "dy", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class c
    extends RecyclerView.l
  {
    private int uiX;
    
    c(AppBrandPrivacyManagePage paramAppBrandPrivacyManagePage, int paramInt) {}
    
    public final void onScrollStateChanged(RecyclerView paramRecyclerView, int paramInt)
    {
      AppMethodBeat.i(322952);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.cH(paramRecyclerView);
      localb.sc(paramInt);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/appbrand/ui/privacy/manage/AppBrandPrivacyManagePage$initContentArea$1$1", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroidx/recyclerview/widget/RecyclerView;I)V", this, localb.aYj());
      super.onScrollStateChanged(paramRecyclerView, paramInt);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/appbrand/ui/privacy/manage/AppBrandPrivacyManagePage$initContentArea$1$1", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroidx/recyclerview/widget/RecyclerView;I)V");
      AppMethodBeat.o(322952);
    }
    
    public final void onScrolled(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(322947);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).cH(paramRecyclerView);
      ((com.tencent.mm.hellhoundlib.b.b)localObject).sc(paramInt1);
      ((com.tencent.mm.hellhoundlib.b.b)localObject).sc(paramInt2);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/appbrand/ui/privacy/manage/AppBrandPrivacyManagePage$initContentArea$1$1", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroidx/recyclerview/widget/RecyclerView;II)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aYj());
      s.u(paramRecyclerView, "recyclerView");
      super.onScrolled(paramRecyclerView, paramInt1, paramInt2);
      this.uiX += paramInt2;
      localObject = this.uiY;
      if (this.uiX <= this.uiZ) {}
      for (paramRecyclerView = a.uiH;; paramRecyclerView = a.uiI)
      {
        AppBrandPrivacyManagePage.a((AppBrandPrivacyManagePage)localObject, paramRecyclerView);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/appbrand/ui/privacy/manage/AppBrandPrivacyManagePage$initContentArea$1$1", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroidx/recyclerview/widget/RecyclerView;II)V");
        AppMethodBeat.o(322947);
        return;
      }
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class d
    extends kotlin.d.b.a.k
    implements m<aq, kotlin.d.d<? super ah>, Object>
  {
    Object L$0;
    Object Uf;
    Object VC;
    Object VD;
    int label;
    
    d(ah.f<Integer> paramf, com.tencent.mm.plugin.appbrand.ui.privacy.c paramc, h paramh, AppBrandPrivacyManagePage paramAppBrandPrivacyManagePage, kotlin.d.d<? super d> paramd)
    {
      super(paramd);
    }
    
    public final kotlin.d.d<ah> create(Object paramObject, kotlin.d.d<?> paramd)
    {
      AppMethodBeat.i(322955);
      paramObject = (kotlin.d.d)new d(this.uja, paramc, paramh, paramAppBrandPrivacyManagePage, paramd);
      AppMethodBeat.o(322955);
      return paramObject;
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(322949);
      kotlin.d.a.a locala = kotlin.d.a.a.aiwj;
      com.tencent.mm.plugin.appbrand.ui.privacy.c localc;
      ah.f localf;
      h localh;
      switch (this.label)
      {
      default: 
        paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(322949);
        throw paramObject;
      case 0: 
        ResultKt.throwOnFailure(paramObject);
        Object localObject2 = (Integer)this.uja.aqH;
        if (localObject2 == null)
        {
          Log.i("MicroMsg.AppBrandPrivacyManagePage", "onLoadMore, fetchToken is null, not need");
          paramObject = ah.aiuX;
          AppMethodBeat.o(322949);
          return paramObject;
        }
        localc = paramc;
        localf = this.uja;
        localh = paramh;
        paramObject = paramAppBrandPrivacyManagePage;
        Object localObject1 = k.ujv;
        int i = ((Integer)localObject2).intValue();
        localObject2 = (kotlin.d.d)this;
        this.L$0 = localc;
        this.Uf = localf;
        this.VC = localh;
        this.VD = paramObject;
        this.label = 1;
        localObject1 = ((k)localObject1).e(i, (kotlin.d.d)localObject2);
        paramObject = localObject1;
        if (localObject1 == locala)
        {
          AppMethodBeat.o(322949);
          return locala;
        }
        break;
      case 1: 
        localh = (h)this.VC;
        localf = (ah.f)this.Uf;
        localc = (com.tencent.mm.plugin.appbrand.ui.privacy.c)this.L$0;
        ResultKt.throwOnFailure(paramObject);
      }
      AppBrandPrivacyManagePage.a(localc, localf, localh, (l)paramObject);
      paramObject = ah.aiuX;
      AppMethodBeat.o(322949);
      return paramObject;
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class e
    extends kotlin.d.b.a.k
    implements m<aq, kotlin.d.d<? super ah>, Object>
  {
    Object L$0;
    Object Uf;
    Object VC;
    Object VD;
    Object Ze;
    Object aqc;
    int label;
    
    e(w paramw, ViewGroup paramViewGroup, com.tencent.mm.plugin.appbrand.ui.privacy.c paramc, ah.f<Integer> paramf, h paramh, AppBrandPrivacyManagePage paramAppBrandPrivacyManagePage, LoadMoreRecyclerView paramLoadMoreRecyclerView, kotlin.d.d<? super e> paramd)
    {
      super(paramd);
    }
    
    public final kotlin.d.d<ah> create(Object paramObject, kotlin.d.d<?> paramd)
    {
      AppMethodBeat.i(322960);
      paramObject = (kotlin.d.d)new e(this.ujd, paramBundle, localc, localf, this.ujc, jdField_this, paramView, paramd);
      AppMethodBeat.o(322960);
      return paramObject;
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(322954);
      Object localObject2 = kotlin.d.a.a.aiwj;
      com.tencent.mm.plugin.appbrand.ui.privacy.c localc;
      ah.f localf;
      h localh;
      AppBrandPrivacyManagePage localAppBrandPrivacyManagePage;
      LoadMoreRecyclerView localLoadMoreRecyclerView;
      Object localObject1;
      switch (this.label)
      {
      default: 
        paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(322954);
        throw paramObject;
      case 0: 
        ResultKt.throwOnFailure(paramObject);
        paramObject = paramBundle;
        localc = localc;
        localf = localf;
        localh = this.ujc;
        localAppBrandPrivacyManagePage = jdField_this;
        localLoadMoreRecyclerView = paramView;
        localObject1 = k.ujv;
        kotlin.d.d locald = (kotlin.d.d)this;
        this.L$0 = paramObject;
        this.Uf = localc;
        this.VC = localf;
        this.VD = localh;
        this.Ze = localAppBrandPrivacyManagePage;
        this.aqc = localLoadMoreRecyclerView;
        this.label = 1;
        localObject1 = k.a((k)localObject1, locald);
        if (localObject1 == localObject2)
        {
          AppMethodBeat.o(322954);
          return localObject2;
        }
        break;
      case 1: 
        localLoadMoreRecyclerView = (LoadMoreRecyclerView)this.aqc;
        localAppBrandPrivacyManagePage = (AppBrandPrivacyManagePage)this.Ze;
        localh = (h)this.VD;
        localf = (ah.f)this.VC;
        localc = (com.tencent.mm.plugin.appbrand.ui.privacy.c)this.Uf;
        localObject2 = (ViewGroup)this.L$0;
        ResultKt.throwOnFailure(paramObject);
        localObject1 = paramObject;
        paramObject = localObject2;
      }
      for (;;)
      {
        AppBrandPrivacyManagePage.a(paramObject, localc, localf, localh, localAppBrandPrivacyManagePage, localLoadMoreRecyclerView, (l)localObject1);
        this.ujd.dismiss();
        paramObject = ah.aiuX;
        AppMethodBeat.o(322954);
        return paramObject;
      }
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "appAuthScopeInfo", "Lcom/tencent/mm/plugin/appbrand/ui/privacy/manage/WxaAppAuthorizeScopeInfo;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class f
    extends u
    implements kotlin.g.a.b<i, ah>
  {
    f(h paramh, AppBrandPrivacyManagePage paramAppBrandPrivacyManagePage, l paraml)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.privacy.manage.AppBrandPrivacyManagePage
 * JD-Core Version:    0.7.0.1
 */