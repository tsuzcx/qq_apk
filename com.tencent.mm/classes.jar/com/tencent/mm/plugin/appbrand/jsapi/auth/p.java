package com.tencent.mm.plugin.appbrand.jsapi.auth;

import android.app.Activity;
import android.app.Instrumentation.ActivityResult;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Parcelable;
import android.view.View;
import android.view.View.OnClickListener;
import androidx.recyclerview.widget.s;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.b.a.ni;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.au.c;
import com.tencent.mm.plugin.appbrand.au.i;
import com.tencent.mm.plugin.appbrand.jsapi.h.c;
import com.tencent.mm.plugin.appbrand.p.c;
import com.tencent.mm.plugin.appbrand.permission.a.b.b;
import com.tencent.mm.plugin.appbrand.permission.a.b.d;
import com.tencent.mm.plugin.appbrand.platform.window.a.o;
import com.tencent.mm.plugin.appbrand.widget.dialog.j.a;
import com.tencent.mm.plugin.car_license_plate.api.entity.MMCarLicensePlateInfo;
import com.tencent.mm.plugin.car_license_plate.ui.CarLicensePlateListUI;
import com.tencent.mm.plugin.car_license_plate.ui.CarLicensePlateListViewContract.ViewModel;
import com.tencent.mm.plugin.car_license_plate.ui.CarLicensePlateListViewContract.a;
import com.tencent.mm.plugin.car_license_plate.ui.CarLicensePlateListViewContract.b;
import com.tencent.mm.plugin.car_license_plate.ui.CarLicensePlateListViewContract.b.a;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.ResultKt;
import kotlin.a.v;
import kotlin.g.a.m;
import kotlin.g.b.aa.a;
import kotlin.g.b.q;
import kotlin.x;
import kotlinx.coroutines.ak;
import kotlinx.coroutines.al;

@kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/jsapi/auth/WxaCarLicensePlateChooserViewController;", "Lcom/tencent/mm/plugin/car_license_plate/ui/CarLicensePlateListViewContract$ViewCallback;", "env", "Lcom/tencent/mm/plugin/appbrand/AppBrandComponentWxaShared;", "viewCallback", "Lcom/tencent/mm/plugin/appbrand/jsapi/auth/WxaCarLicensePlateChooserViewController$ChooserViewCallback;", "(Lcom/tencent/mm/plugin/appbrand/AppBrandComponentWxaShared;Lcom/tencent/mm/plugin/appbrand/jsapi/auth/WxaCarLicensePlateChooserViewController$ChooserViewCallback;)V", "dismissed", "Ljava/util/concurrent/atomic/AtomicBoolean;", "displayMode", "Lcom/tencent/mm/plugin/appbrand/jsapi/auth/WxaCarLicensePlateChooserViewController$DisplayMode;", "listHalfScreenDialog", "Lcom/tencent/mm/plugin/appbrand/permission/jsauth/IJsAuthorizePromptPresenterView;", "loadingProcessDialog", "Landroid/content/DialogInterface;", "mainScope", "Lkotlinx/coroutines/CoroutineScope;", "report", "Lcom/tencent/mm/autogen/mmdata/rpt/WACarLicensePlateAuthLogStruct;", "com/tencent/mm/plugin/appbrand/jsapi/auth/WxaCarLicensePlateChooserViewController$viewCallback$1", "Lcom/tencent/mm/plugin/appbrand/jsapi/auth/WxaCarLicensePlateChooserViewController$viewCallback$1;", "viewModel", "Lcom/tencent/mm/plugin/car_license_plate/ui/CarLicensePlateListViewContract$ViewModel;", "getViewModel", "()Lcom/tencent/mm/plugin/car_license_plate/ui/CarLicensePlateListViewContract$ViewModel;", "viewPresenter", "Lcom/tencent/mm/plugin/car_license_plate/ui/CarLicensePlateListViewContract$Presenter;", "dismiss", "", "userInteractive", "", "getActivityForResult", "Landroid/app/Activity;", "getCoroutineScope", "initHalfScreenDialog", "onRenderData", "data", "Lcom/tencent/mm/plugin/car_license_plate/api/entity/MMCarLicensePlateInfo;", "onRenderError", "exception", "Lcom/tencent/mm/plugin/car_license_plate/cgi/CgiException;", "onRenderLoading", "request", "Lcom/tencent/mm/plugin/car_license_plate/ui/CarLicensePlateListViewContract$ViewCallback$Request;", "showChooserView", "startListUI", "activityResultCallback", "Lkotlin/Function1;", "Landroid/app/Instrumentation$ActivityResult;", "startListUIForHalfPage", "ChooserViewCallback", "Companion", "DisplayMode", "plugin-appbrand-integration_release"})
public final class p
  implements CarLicensePlateListViewContract.b
{
  public static final p.b oDr;
  private final ak oDi;
  private c oDj;
  CarLicensePlateListViewContract.a oDk;
  private com.tencent.mm.plugin.appbrand.permission.a.b oDl;
  private DialogInterface oDm;
  private AtomicBoolean oDn;
  final ni oDo;
  private final l oDp;
  com.tencent.mm.plugin.appbrand.g oDq;
  
  static
  {
    AppMethodBeat.i(273048);
    oDr = new p.b((byte)0);
    AppMethodBeat.o(273048);
  }
  
  public p(com.tencent.mm.plugin.appbrand.g paramg, final a parama)
  {
    AppMethodBeat.i(273047);
    this.oDq = paramg;
    this.oDi = al.iRe();
    this.oDn = new AtomicBoolean(false);
    this.oDo = new ni();
    this.oDp = new l(this, parama);
    AppMethodBeat.o(273047);
  }
  
  private void a(final CarLicensePlateListViewContract.ViewModel paramViewModel, final kotlin.g.a.b<? super Instrumentation.ActivityResult, x> paramb)
  {
    AppMethodBeat.i(273046);
    Activity localActivity = ((p)this).bQv();
    if (localActivity == null)
    {
      com.tencent.mm.sdk.platformtools.Log.e("MicroMsg.WxaCarLicensePlateChooserViewController", "startListUI get NULL activity");
      paramb.invoke(new Instrumentation.ActivityResult(0, null));
      AppMethodBeat.o(273046);
      return;
    }
    kotlinx.coroutines.g.b(this.oDi, null, (m)new j(localActivity, paramViewModel, paramb, null), 3);
    AppMethodBeat.o(273046);
  }
  
  private final CarLicensePlateListViewContract.ViewModel bQt()
  {
    AppMethodBeat.i(273039);
    Object localObject = this.oDk;
    if (localObject == null) {
      kotlin.g.b.p.bGy("viewPresenter");
    }
    localObject = ((CarLicensePlateListViewContract.a)localObject).bQt();
    AppMethodBeat.o(273039);
    return localObject;
  }
  
  public final void a(com.tencent.mm.plugin.car_license_plate.a.d paramd)
  {
    AppMethodBeat.i(273045);
    kotlin.g.b.p.k(paramd, "exception");
    com.tencent.mm.sdk.platformtools.Log.e("MicroMsg.WxaCarLicensePlateChooserViewController", "onRenderError(" + paramd + ')');
    com.tencent.mm.plugin.car_license_plate.b.a.b(paramd);
    if (((paramd.sXC instanceof com.tencent.mm.plugin.car_license_plate.a.e)) && (((p)this).oDj == null)) {
      this.oDp.bQm();
    }
    AppMethodBeat.o(273045);
  }
  
  public final void a(MMCarLicensePlateInfo paramMMCarLicensePlateInfo)
  {
    AppMethodBeat.i(273044);
    if (this.oDn.get())
    {
      AppMethodBeat.o(273044);
      return;
    }
    Object localObject1 = this.oDm;
    if (localObject1 != null) {
      ((DialogInterface)localObject1).dismiss();
    }
    this.oDm = null;
    int i;
    boolean bool;
    label83:
    label102:
    Object localObject2;
    if (paramMMCarLicensePlateInfo != null)
    {
      localObject1 = paramMMCarLicensePlateInfo.sXr;
      if (localObject1 != null) {
        if (!((Collection)localObject1).isEmpty())
        {
          i = 1;
          if (i != 1) {
            break label272;
          }
          bool = true;
          if (((p)this).oDj == null)
          {
            if (!bool) {
              break label277;
            }
            localObject1 = c.oDs;
            this.oDj = ((c)localObject1);
            localObject1 = this.oDj;
            if (localObject1 == null) {
              kotlin.g.b.p.bGy("displayMode");
            }
          }
          switch (q.$EnumSwitchMapping$0[localObject1.ordinal()])
          {
          default: 
            label156:
            localObject1 = new StringBuilder("onRenderData, isNotEmpty:").append(bool).append(", settled displayMode:");
            localObject2 = this.oDj;
            if (localObject2 == null) {
              kotlin.g.b.p.bGy("displayMode");
            }
            com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.WxaCarLicensePlateChooserViewController", localObject2);
            localObject1 = this.oDj;
            if (localObject1 == null) {
              kotlin.g.b.p.bGy("displayMode");
            }
            switch (q.jLJ[localObject1.ordinal()])
            {
            }
            break;
          }
        }
      }
    }
    for (;;)
    {
      AppMethodBeat.o(273044);
      return;
      i = 0;
      break;
      label272:
      bool = false;
      break label83;
      label277:
      localObject1 = c.oDt;
      break label102;
      this.oDo.zw(1L);
      this.oDo.zy(1L);
      break label156;
      this.oDo.zw(2L);
      break label156;
      bQt().sYY = false;
      if (2L == this.oDo.anY()) {
        this.oDo.zy(3L);
      }
      if (bool)
      {
        if (((p)this).oDl == null)
        {
          localObject1 = this.oDq;
          if (localObject1 == null) {
            kotlin.g.b.p.iCn();
          }
          localObject2 = b.b.a((com.tencent.mm.plugin.appbrand.g)localObject1, (b.d)new e(this, (com.tencent.mm.plugin.appbrand.g)localObject1));
          this.oDl = ((com.tencent.mm.plugin.appbrand.permission.a.b)localObject2);
          AppBrandRuntime localAppBrandRuntime = ((com.tencent.mm.plugin.appbrand.g)localObject1).getRuntime();
          kotlin.g.b.p.j(localAppBrandRuntime, "env.runtime");
          ((com.tencent.mm.plugin.appbrand.permission.a.b)localObject2).setAppBrandName(localAppBrandRuntime.Sp().fzM);
          localAppBrandRuntime = ((com.tencent.mm.plugin.appbrand.g)localObject1).getRuntime();
          kotlin.g.b.p.j(localAppBrandRuntime, "env.runtime");
          ((com.tencent.mm.plugin.appbrand.permission.a.b)localObject2).setIconUrl(localAppBrandRuntime.Sp().mnM);
          ((com.tencent.mm.plugin.appbrand.permission.a.b)localObject2).setApplyWording(MMApplicationContext.getString(au.i.car_license_plate_choose_apply_wording));
          ((com.tencent.mm.plugin.appbrand.permission.a.b)localObject2).setRequestDesc(MMApplicationContext.getString(au.i.car_license_plate_choose_description));
          ((com.tencent.mm.plugin.appbrand.permission.a.b)localObject2).setFunctionButtonText(MMApplicationContext.getString(au.i.car_license_plate_entrance));
          ((com.tencent.mm.plugin.appbrand.permission.a.b)localObject2).setFunctionButtonTextColor(MMApplicationContext.getColor(au.c.link_color));
          ((com.tencent.mm.plugin.appbrand.permission.a.b)localObject2).setFunctionButtonOnClickListener((View.OnClickListener)new d(this, (com.tencent.mm.plugin.appbrand.g)localObject1));
          ((com.tencent.mm.plugin.appbrand.permission.a.b)localObject2).setPositiveButtonText(MMApplicationContext.getString(au.i.login_accept_button));
          ((com.tencent.mm.plugin.appbrand.permission.a.b)localObject2).setNegativeButtonText(MMApplicationContext.getString(au.i.login_reject_button));
          ((com.tencent.mm.plugin.appbrand.permission.a.b)localObject2).i((com.tencent.mm.plugin.appbrand.g)localObject1);
        }
        localObject1 = this.oDl;
        if (localObject1 == null) {
          kotlin.g.b.p.bGy("listHalfScreenDialog");
        }
        if (bool) {
          if (paramMMCarLicensePlateInfo == null) {
            kotlin.g.b.p.iCn();
          }
        }
        for (paramMMCarLicensePlateInfo = p.b.a("webapi_userplateinfo", paramMMCarLicensePlateInfo);; paramMMCarLicensePlateInfo = (List)v.aaAd)
        {
          ((com.tencent.mm.plugin.appbrand.permission.a.b)localObject1).setSelectListItem(paramMMCarLicensePlateInfo);
          AppMethodBeat.o(273044);
          return;
        }
      }
      this.oDp.bQm();
      AppMethodBeat.o(273044);
      return;
      if (!bool)
      {
        bQt().sYY = true;
        a(bQt(), (kotlin.g.a.b)new f(this));
      }
    }
  }
  
  public final void a(CarLicensePlateListViewContract.b.a parama)
  {
    AppMethodBeat.i(273043);
    kotlin.g.b.p.k(parama, "request");
    if (CarLicensePlateListViewContract.b.a.sYT == parama)
    {
      parama = this.oDq;
      if (parama != null)
      {
        parama = parama.getRuntime();
        if (parama != null) {}
      }
      else
      {
        AppMethodBeat.o(273043);
        return;
      }
      c localc = new c();
      localc.b((androidx.a.a.c.a)new g(parama));
      localc.ab(parama);
      this.oDm = ((DialogInterface)localc);
    }
    AppMethodBeat.o(273043);
  }
  
  public final ak bQu()
  {
    return this.oDi;
  }
  
  public final Activity bQv()
  {
    AppMethodBeat.i(273042);
    Object localObject1 = this.oDq;
    if (localObject1 != null) {}
    for (localObject1 = ((com.tencent.mm.plugin.appbrand.g)localObject1).getWindowAndroid();; localObject1 = null)
    {
      Object localObject2 = localObject1;
      if (!(localObject1 instanceof o)) {
        localObject2 = null;
      }
      localObject1 = (o)localObject2;
      if (localObject1 == null) {
        break;
      }
      localObject1 = ((o)localObject1).getActivity();
      AppMethodBeat.o(273042);
      return localObject1;
    }
    AppMethodBeat.o(273042);
    return null;
  }
  
  public final void ic(boolean paramBoolean)
  {
    AppMethodBeat.i(273040);
    com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.WxaCarLicensePlateChooserViewController", "dismiss stack:" + android.util.Log.getStackTraceString(new Throwable()));
    this.oDn.set(true);
    al.a(this.oDi, null);
    if (((p)this).oDl != null)
    {
      localObject = this.oDl;
      if (localObject == null) {
        kotlin.g.b.p.bGy("listHalfScreenDialog");
      }
      com.tencent.mm.plugin.appbrand.g localg = this.oDq;
      if (localg == null) {
        kotlin.g.b.p.iCn();
      }
      ((com.tencent.mm.plugin.appbrand.permission.a.b)localObject).j(localg);
    }
    Object localObject = this.oDm;
    if (localObject != null) {
      ((DialogInterface)localObject).dismiss();
    }
    this.oDm = null;
    this.oDq = null;
    if (paramBoolean) {
      this.oDo.bpa();
    }
    AppMethodBeat.o(273040);
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/jsapi/auth/WxaCarLicensePlateChooserViewController$ChooserViewCallback;", "", "onPlateNoChosen", "", "plateNo", "", "onUserCancel", "plugin-appbrand-integration_release"})
  public static abstract interface a
  {
    public abstract void ahc(String paramString);
    
    public abstract void bQm();
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/jsapi/auth/WxaCarLicensePlateChooserViewController$DisplayMode;", "", "(Ljava/lang/String;I)V", "HALF_SCREEN_DIALOG", "ACTIVITY", "plugin-appbrand-integration_release"})
  public static enum c
  {
    static
    {
      AppMethodBeat.i(252428);
      c localc1 = new c("HALF_SCREEN_DIALOG", 0);
      oDs = localc1;
      c localc2 = new c("ACTIVITY", 1);
      oDt = localc2;
      oDu = new c[] { localc1, localc2 };
      AppMethodBeat.o(252428);
    }
    
    private c() {}
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/mm/plugin/appbrand/jsapi/auth/WxaCarLicensePlateChooserViewController$initHalfScreenDialog$2$1"})
  static final class d
    implements View.OnClickListener
  {
    d(p paramp, com.tencent.mm.plugin.appbrand.g paramg) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(278906);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/appbrand/jsapi/auth/WxaCarLicensePlateChooserViewController$initHalfScreenDialog$$inlined$apply$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
      p.e(this.oDv);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/appbrand/jsapi/auth/WxaCarLicensePlateChooserViewController$initHalfScreenDialog$$inlined$apply$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(278906);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/appbrand/jsapi/auth/WxaCarLicensePlateChooserViewController$initHalfScreenDialog$1", "Lcom/tencent/mm/plugin/appbrand/permission/jsauth/IJsAuthorizePromptPresenterView$Listener;", "onMsg", "", "resultCode", "", "resultData", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "avatarId", "plugin-appbrand-integration_release"})
  public static final class e
    implements b.d
  {
    e(com.tencent.mm.plugin.appbrand.g paramg) {}
    
    public final void a(int paramInt1, ArrayList<String> paramArrayList, int paramInt2)
    {
      AppMethodBeat.i(277677);
      kotlin.g.b.p.k(paramArrayList, "resultData");
      com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.WxaCarLicensePlateChooserViewController", "prompt onMsg, resultCode:" + paramInt1 + ", id:" + paramInt2);
      if (1 == paramInt1)
      {
        paramArrayList = p.b(this.oDv).sYX;
        if (paramArrayList != null)
        {
          paramArrayList = paramArrayList.sXr;
          if (paramArrayList != null)
          {
            paramArrayList = (String)kotlin.a.j.M((List)paramArrayList, paramInt2);
            CharSequence localCharSequence = (CharSequence)paramArrayList;
            if ((localCharSequence != null) && (localCharSequence.length() != 0)) {
              break label167;
            }
          }
        }
        label167:
        for (paramInt1 = 1;; paramInt1 = 0)
        {
          if (paramInt1 != 0) {
            break label172;
          }
          kotlinx.coroutines.g.b(al.iRe(), null, (m)new p.e.a(this, paramArrayList, null), 3);
          p.c(this.oDv).zx(3L);
          p.d(this.oDv).ahc(paramArrayList);
          AppMethodBeat.o(277677);
          return;
          paramArrayList = null;
          break;
        }
        label172:
        com.tencent.mm.sdk.platformtools.Log.e("MicroMsg.WxaCarLicensePlateChooserViewController", "prompt onMsg, invalid avatarId(index):".concat(String.valueOf(paramInt2)));
        AppMethodBeat.o(277677);
        return;
      }
      p.c(this.oDv).zx(4L);
      p.d(this.oDv).bQm();
      AppMethodBeat.o(277677);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/app/Instrumentation$ActivityResult;", "invoke"})
  static final class f
    extends q
    implements kotlin.g.a.b<Instrumentation.ActivityResult, x>
  {
    f(p paramp)
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Lcom/tencent/mm/plugin/appbrand/widget/dialog/AppBrandProgressDialog;", "it", "Landroid/content/Context;", "kotlin.jvm.PlatformType", "apply", "com/tencent/mm/plugin/appbrand/jsapi/auth/WxaCarLicensePlateChooserViewController$onRenderLoading$1$1"})
  static final class g<I, O>
    implements androidx.a.a.c.a<Context, j.a>
  {
    g(AppBrandRuntime paramAppBrandRuntime) {}
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "Lcom/tencent/luggage/sdk/wxa_ktx/RuntimeLifecycleListenerBuilder;", "invoke", "com/tencent/mm/plugin/appbrand/jsapi/auth/WxaCarLicensePlateChooserViewController$showChooserView$1$2"})
  static final class h
    extends q
    implements kotlin.g.a.b<com.tencent.luggage.sdk.h.e, x>
  {
    h(p paramp)
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "onDestroy", "com/tencent/mm/plugin/appbrand/jsapi/auth/WxaCarLicensePlateChooserViewController$showChooserView$1$3"})
  static final class i
    implements h.c
  {
    i(p paramp) {}
    
    public final void onDestroy()
    {
      AppMethodBeat.i(278471);
      p.a(this.oDv);
      AppMethodBeat.o(278471);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"})
  static final class j
    extends kotlin.d.b.a.j
    implements m<ak, kotlin.d.d<? super x>, Object>
  {
    Object L$0;
    int label;
    Object oDA;
    private ak p$;
    
    j(Activity paramActivity, CarLicensePlateListViewContract.ViewModel paramViewModel, kotlin.g.a.b paramb, kotlin.d.d paramd)
    {
      super(paramd);
    }
    
    public final kotlin.d.d<x> create(Object paramObject, kotlin.d.d<?> paramd)
    {
      AppMethodBeat.i(282295);
      kotlin.g.b.p.k(paramd, "completion");
      paramd = new j(this.otc, paramViewModel, paramb, paramd);
      paramd.p$ = ((ak)paramObject);
      AppMethodBeat.o(282295);
      return paramd;
    }
    
    public final Object invoke(Object paramObject1, Object paramObject2)
    {
      AppMethodBeat.i(282296);
      paramObject1 = ((j)create(paramObject1, (kotlin.d.d)paramObject2)).invokeSuspend(x.aazN);
      AppMethodBeat.o(282296);
      return paramObject1;
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(282293);
      kotlin.d.a.a locala = kotlin.d.a.a.aaAA;
      Object localObject1;
      Object localObject2;
      switch (this.label)
      {
      default: 
        paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(282293);
        throw paramObject;
      case 0: 
        ResultKt.throwOnFailure(paramObject);
        paramObject = this.p$;
        localObject1 = this.otc;
        localObject2 = new Intent((Context)this.otc, CarLicensePlateListUI.class);
        if (paramViewModel != null) {
          ((Intent)localObject2).putExtra("INTENT_KEY_VIEW_MODEL", (Parcelable)paramViewModel);
        }
        this.L$0 = paramObject;
        this.label = 1;
        localObject2 = com.tencent.mm.plugin.car_license_plate.b.a.a((Activity)localObject1, (Intent)localObject2, this);
        localObject1 = localObject2;
        if (localObject2 == locala)
        {
          AppMethodBeat.o(282293);
          return locala;
        }
      case 1: 
        localObject2 = (ak)this.L$0;
        ResultKt.throwOnFailure(paramObject);
        localObject1 = paramObject;
        paramObject = localObject2;
        localObject1 = (Instrumentation.ActivityResult)localObject1;
        localObject2 = (kotlin.g.a.a)new a((Instrumentation.ActivityResult)localObject1, this);
        this.L$0 = paramObject;
        this.oDA = localObject1;
        this.label = 2;
        if (com.tencent.mm.plugin.car_license_plate.b.a.a((kotlin.g.a.a)localObject2, this) != locala) {
          break label213;
        }
        AppMethodBeat.o(282293);
        return locala;
      }
      ResultKt.throwOnFailure(paramObject);
      label213:
      paramObject = x.aazN;
      AppMethodBeat.o(282293);
      return paramObject;
    }
    
    @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke", "com/tencent/mm/plugin/appbrand/jsapi/auth/WxaCarLicensePlateChooserViewController$startListUI$1$2$1"})
    static final class a
      extends q
      implements kotlin.g.a.a<x>
    {
      a(Instrumentation.ActivityResult paramActivityResult, p.j paramj)
      {
        super();
      }
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/app/Instrumentation$ActivityResult;", "invoke"})
  static final class k
    extends q
    implements kotlin.g.a.b<Instrumentation.ActivityResult, x>
  {
    k(p paramp)
    {
      super();
    }
    
    @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/appbrand/jsapi/auth/WxaCarLicensePlateChooserViewController$startListUIForHalfPage$1$1$1", "Landroidx/recyclerview/widget/ListUpdateCallback;", "onChanged", "", "position", "", "count", "payload", "", "onInserted", "onMoved", "fromPosition", "toPosition", "onRemoved", "plugin-appbrand-integration_release"})
    public static final class a
      implements s
    {
      a(aa.a parama) {}
      
      public final void W(int paramInt1, int paramInt2)
      {
        this.oDF.aaBx = true;
      }
      
      public final void ac(int paramInt1, int paramInt2)
      {
        this.oDF.aaBx = true;
      }
      
      public final void ad(int paramInt1, int paramInt2)
      {
        this.oDF.aaBx = true;
      }
      
      public final void c(int paramInt1, int paramInt2, Object paramObject)
      {
        this.oDF.aaBx = true;
      }
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/appbrand/jsapi/auth/WxaCarLicensePlateChooserViewController$viewCallback$1", "Lcom/tencent/mm/plugin/appbrand/jsapi/auth/WxaCarLicensePlateChooserViewController$ChooserViewCallback;", "onPlateNoChosen", "", "plateNo", "", "onUserCancel", "plugin-appbrand-integration_release"})
  public static final class l
    implements p.a
  {
    l(p.a parama) {}
    
    public final void ahc(String paramString)
    {
      AppMethodBeat.i(274711);
      kotlin.g.b.p.k(paramString, "plateNo");
      p.a locala = parama;
      if (locala != null) {
        locala.ahc(paramString);
      }
      this.oDv.ic(true);
      AppMethodBeat.o(274711);
    }
    
    public final void bQm()
    {
      AppMethodBeat.i(274712);
      p.a locala = parama;
      if (locala != null) {
        locala.bQm();
      }
      this.oDv.ic(true);
      AppMethodBeat.o(274712);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.auth.p
 * JD-Core Version:    0.7.0.1
 */