package com.tencent.mm.plugin.appbrand.jsapi.auth;

import android.app.Activity;
import android.app.Instrumentation.ActivityResult;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Parcelable;
import android.text.TextUtils;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.mmdata.rpt.ra;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.aw;
import com.tencent.mm.plugin.appbrand.b.c.a;
import com.tencent.mm.plugin.appbrand.ba.c;
import com.tencent.mm.plugin.appbrand.ba.i;
import com.tencent.mm.plugin.appbrand.config.n;
import com.tencent.mm.plugin.appbrand.jsapi.aj;
import com.tencent.mm.plugin.appbrand.jsapi.i.c;
import com.tencent.mm.plugin.appbrand.page.ad;
import com.tencent.mm.plugin.appbrand.permission.a.b.b;
import com.tencent.mm.plugin.appbrand.permission.a.b.d;
import com.tencent.mm.plugin.appbrand.platform.window.a.o;
import com.tencent.mm.plugin.appbrand.widget.dialog.k.a;
import com.tencent.mm.plugin.appbrand.widget.dialog.n.a;
import com.tencent.mm.plugin.car_license_plate.a.e;
import com.tencent.mm.plugin.car_license_plate.api.entity.MMCarLicensePlateInfo;
import com.tencent.mm.plugin.car_license_plate.ui.CarLicensePlateListUI;
import com.tencent.mm.plugin.car_license_plate.ui.CarLicensePlateListViewContract.ViewModel;
import com.tencent.mm.plugin.car_license_plate.ui.CarLicensePlateListViewContract.a;
import com.tencent.mm.plugin.car_license_plate.ui.CarLicensePlateListViewContract.b;
import com.tencent.mm.plugin.car_license_plate.ui.CarLicensePlateListViewContract.b.a;
import com.tencent.mm.protocal.protobuf.eq;
import com.tencent.mm.protocal.protobuf.fvl;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.system.AndroidContextUtil;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentSkipListSet;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.a.ab;
import kotlin.ah;
import kotlin.d.b.a.k;
import kotlin.g.a.m;
import kotlin.g.b.s;
import kotlin.g.b.u;
import kotlinx.coroutines.aq;
import kotlinx.coroutines.ar;
import org.apache.commons.c.i;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/jsapi/auth/WxaCarLicensePlateChooserViewController;", "Lcom/tencent/mm/plugin/car_license_plate/ui/CarLicensePlateListViewContract$ViewCallback;", "Lcom/tencent/mm/plugin/appbrand/OnRuntimeInitConfigUpdatedListener;", "env", "Lcom/tencent/mm/plugin/appbrand/AppBrandComponentWxaShared;", "viewCallback", "Lcom/tencent/mm/plugin/appbrand/jsapi/auth/WxaCarLicensePlateChooserViewController$ChooserViewCallback;", "(Lcom/tencent/mm/plugin/appbrand/AppBrandComponentWxaShared;Lcom/tencent/mm/plugin/appbrand/jsapi/auth/WxaCarLicensePlateChooserViewController$ChooserViewCallback;)V", "contextOnDestroyListenerAdapter", "com/tencent/mm/plugin/appbrand/jsapi/auth/WxaCarLicensePlateChooserViewController$contextOnDestroyListenerAdapter$1", "Lcom/tencent/mm/plugin/appbrand/jsapi/auth/WxaCarLicensePlateChooserViewController$contextOnDestroyListenerAdapter$1;", "dismissed", "Ljava/util/concurrent/atomic/AtomicBoolean;", "displayMode", "Lcom/tencent/mm/plugin/appbrand/jsapi/auth/WxaCarLicensePlateChooserViewController$DisplayMode;", "listHalfScreenDialog", "Lcom/tencent/mm/plugin/appbrand/permission/jsauth/IJsAuthorizePromptPresenterView;", "loadingProcessDialog", "Landroid/content/DialogInterface;", "mainScope", "Lkotlinx/coroutines/CoroutineScope;", "report", "Lcom/tencent/mm/autogen/mmdata/rpt/WACarLicensePlateAuthLogStruct;", "com/tencent/mm/plugin/appbrand/jsapi/auth/WxaCarLicensePlateChooserViewController$viewCallback$1", "Lcom/tencent/mm/plugin/appbrand/jsapi/auth/WxaCarLicensePlateChooserViewController$viewCallback$1;", "viewModel", "Lcom/tencent/mm/plugin/car_license_plate/ui/CarLicensePlateListViewContract$ViewModel;", "getViewModel", "()Lcom/tencent/mm/plugin/car_license_plate/ui/CarLicensePlateListViewContract$ViewModel;", "viewPresenter", "Lcom/tencent/mm/plugin/car_license_plate/ui/CarLicensePlateListViewContract$Presenter;", "dismiss", "", "userInteractive", "", "getActivityForResult", "Landroid/app/Activity;", "getCoroutineScope", "initHalfScreenDialog", "onRenderData", "data", "Lcom/tencent/mm/plugin/car_license_plate/api/entity/MMCarLicensePlateInfo;", "onRenderError", "exception", "Lcom/tencent/mm/plugin/car_license_plate/cgi/CgiException;", "onRenderLoading", "request", "Lcom/tencent/mm/plugin/car_license_plate/ui/CarLicensePlateListViewContract$ViewCallback$Request;", "onRuntimeInitConfigUpdated", "rt", "Lcom/tencent/mm/plugin/appbrand/AppBrandRuntime;", "initConfig", "Lcom/tencent/mm/plugin/appbrand/config/AppBrandInitConfig;", "showChooserView", "startListUI", "activityResultCallback", "Lkotlin/Function1;", "Landroid/app/Instrumentation$ActivityResult;", "startListUIForHalfPage", "ChooserViewCallback", "Companion", "DisplayMode", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class p
  implements aw, CarLicensePlateListViewContract.b
{
  public static final b rGy;
  private final aq mainScope;
  private c rGA;
  CarLicensePlateListViewContract.a rGB;
  private com.tencent.mm.plugin.appbrand.permission.a.b rGC;
  private DialogInterface rGD;
  private AtomicBoolean rGE;
  final ra rGF;
  private final j rGG;
  final e rGH;
  com.tencent.mm.plugin.appbrand.g rGz;
  
  static
  {
    AppMethodBeat.i(327008);
    rGy = new b((byte)0);
    AppMethodBeat.o(327008);
  }
  
  public p(com.tencent.mm.plugin.appbrand.g paramg, a parama)
  {
    AppMethodBeat.i(326921);
    this.rGz = paramg;
    this.mainScope = ar.kBZ();
    this.rGE = new AtomicBoolean(false);
    this.rGF = new ra();
    this.rGG = new j(parama, this);
    this.rGH = new e(this);
    AppMethodBeat.o(326921);
  }
  
  private static final n.a a(AppBrandRuntime paramAppBrandRuntime, Context paramContext)
  {
    AppMethodBeat.i(326980);
    s.u(paramAppBrandRuntime, "$runtime");
    paramAppBrandRuntime = new com.tencent.mm.plugin.appbrand.widget.dialog.j(paramAppBrandRuntime.mContext);
    paramAppBrandRuntime.setMessage((CharSequence)MMApplicationContext.getString(ba.i.app_loading));
    paramAppBrandRuntime = (n.a)paramAppBrandRuntime;
    AppMethodBeat.o(326980);
    return paramAppBrandRuntime;
  }
  
  private static final void a(p paramp, View paramView)
  {
    AppMethodBeat.i(326968);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramp);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/appbrand/jsapi/auth/WxaCarLicensePlateChooserViewController", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramp, "this$0");
    paramp.rGF.juB = 2L;
    paramp.a(paramp.cqq(), (kotlin.g.a.b)new i(paramp));
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/appbrand/jsapi/auth/WxaCarLicensePlateChooserViewController", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(326968);
  }
  
  private static final void a(com.tencent.mm.plugin.appbrand.permission.a.b paramb, com.tencent.mm.plugin.appbrand.g paramg, eq parameq, View paramView)
  {
    AppMethodBeat.i(326960);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramb);
    localb.cH(paramg);
    localb.cH(parameq);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/appbrand/jsapi/auth/WxaCarLicensePlateChooserViewController", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramb, "$this_apply");
    s.u(paramg, "$env");
    s.u(parameq, "$it");
    paramb.a(paramg, parameq.YGI, (aj)paramg.T(aj.class)).h(paramg);
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/appbrand/jsapi/auth/WxaCarLicensePlateChooserViewController", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(326960);
  }
  
  private void a(final CarLicensePlateListViewContract.ViewModel paramViewModel, final kotlin.g.a.b<? super Instrumentation.ActivityResult, ah> paramb)
  {
    AppMethodBeat.i(326948);
    Activity localActivity = cqr();
    if (localActivity == null)
    {
      com.tencent.mm.sdk.platformtools.Log.e("MicroMsg.WxaCarLicensePlateChooserViewController", "startListUI get NULL activity");
      paramb.invoke(new Instrumentation.ActivityResult(0, null));
      AppMethodBeat.o(326948);
      return;
    }
    kotlinx.coroutines.j.a(this.mainScope, null, null, (m)new h(localActivity, paramViewModel, paramb, null), 3);
    AppMethodBeat.o(326948);
  }
  
  private final CarLicensePlateListViewContract.ViewModel cqq()
  {
    AppMethodBeat.i(326932);
    CarLicensePlateListViewContract.a locala = this.rGB;
    Object localObject = locala;
    if (locala == null)
    {
      s.bIx("viewPresenter");
      localObject = null;
    }
    localObject = ((CarLicensePlateListViewContract.a)localObject).cqq();
    AppMethodBeat.o(326932);
    return localObject;
  }
  
  public final void I(AppBrandRuntime paramAppBrandRuntime)
  {
    AppMethodBeat.i(327034);
    aw localaw = (aw)this;
    paramAppBrandRuntime.qsx.remove(localaw);
    jb(false);
    AppMethodBeat.o(327034);
  }
  
  public final void a(com.tencent.mm.plugin.car_license_plate.a.d paramd)
  {
    AppMethodBeat.i(327089);
    s.u(paramd, "exception");
    com.tencent.mm.sdk.platformtools.Log.e("MicroMsg.WxaCarLicensePlateChooserViewController", "onRenderError(" + paramd + ')');
    com.tencent.mm.plugin.car_license_plate.b.a.b(paramd);
    if (((paramd.wbX instanceof e)) && (this.rGA == null)) {
      this.rGG.bSt();
    }
    AppMethodBeat.o(327089);
  }
  
  public final void a(MMCarLicensePlateInfo paramMMCarLicensePlateInfo)
  {
    com.tencent.mm.plugin.appbrand.permission.a.b localb = null;
    Object localObject2 = null;
    AppMethodBeat.i(327085);
    if (this.rGE.get())
    {
      AppMethodBeat.o(327085);
      return;
    }
    Object localObject1 = this.rGD;
    if (localObject1 != null) {
      ((DialogInterface)localObject1).dismiss();
    }
    this.rGD = null;
    int i;
    boolean bool;
    if (paramMMCarLicensePlateInfo != null)
    {
      localObject1 = paramMMCarLicensePlateInfo.wbK;
      if (localObject1 != null) {
        if (!((Collection)localObject1).isEmpty())
        {
          i = 1;
          if (i != 1) {
            break label779;
          }
          bool = true;
          label89:
          label105:
          Object localObject3;
          if (this.rGA == null)
          {
            if (!bool) {
              break label784;
            }
            localObject1 = c.rGI;
            this.rGA = ((c)localObject1);
            localObject3 = this.rGA;
            localObject1 = localObject3;
            if (localObject3 == null)
            {
              s.bIx("displayMode");
              localObject1 = null;
            }
          }
          switch (d.$EnumSwitchMapping$0[localObject1.ordinal()])
          {
          default: 
            label168:
            Object localObject4 = new StringBuilder("onRenderData, isNotEmpty:").append(bool).append(", settled displayMode:");
            localObject3 = this.rGA;
            localObject1 = localObject3;
            if (localObject3 == null)
            {
              s.bIx("displayMode");
              localObject1 = null;
            }
            com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.WxaCarLicensePlateChooserViewController", localObject1);
            localObject4 = c.rGI;
            localObject3 = this.rGA;
            localObject1 = localObject3;
            if (localObject3 == null)
            {
              s.bIx("displayMode");
              localObject1 = null;
            }
            if (localObject4 != localObject1)
            {
              localObject4 = c.rGJ;
              localObject3 = this.rGA;
              localObject1 = localObject3;
              if (localObject3 == null)
              {
                s.bIx("displayMode");
                localObject1 = null;
              }
              if ((localObject4 != localObject1) || (!bool)) {
                break label867;
              }
            }
            cqq().wdn = false;
            if (2L == this.rGF.juB) {
              this.rGF.juB = 3L;
            }
            if (!bool) {
              break label853;
            }
            if (this.rGC == null)
            {
              localObject1 = this.rGz;
              s.checkNotNull(localObject1);
              localb = b.b.a((com.tencent.mm.plugin.appbrand.g)localObject1, (b.d)new f(this, (com.tencent.mm.plugin.appbrand.g)localObject1), null);
              this.rGC = localb;
              localb.setAppBrandName(((com.tencent.mm.plugin.appbrand.g)localObject1).getRuntime().asG().hEy);
              localb.setIconUrl(((com.tencent.mm.plugin.appbrand.g)localObject1).getRuntime().asG().phA);
              localb.setApplyWording(MMApplicationContext.getString(ba.i.car_license_plate_choose_apply_wording));
              localb.setRequestDesc(MMApplicationContext.getString(ba.i.car_license_plate_choose_description));
              localObject3 = com.tencent.mm.plugin.car_license_plate.api.entity.a.wbN;
              localb.setSimpleDetailDesc((String)com.tencent.mm.plugin.car_license_plate.api.entity.a.wbO.a(localObject3, com.tencent.mm.plugin.car_license_plate.api.entity.a.aYe[0]));
              localObject3 = com.tencent.mm.plugin.car_license_plate.api.entity.a.wbN;
              localObject3 = (eq)com.tencent.mm.plugin.car_license_plate.api.entity.a.wbP.a(localObject3, com.tencent.mm.plugin.car_license_plate.api.entity.a.aYe[1]);
              if (!((eq)localObject3).YGH) {
                break label829;
              }
              localObject4 = (CharSequence)((eq)localObject3).YGI;
              if ((localObject4 == null) || (((CharSequence)localObject4).length() == 0))
              {
                i = 1;
                label535:
                if (i != 0) {
                  break label829;
                }
                localb.kb(true);
                localb.setExplainOnClickListener(new p..ExternalSyntheticLambda1(localb, (com.tencent.mm.plugin.appbrand.g)localObject1, (eq)localObject3));
                label567:
                localb.setFunctionButtonText(MMApplicationContext.getString(ba.i.car_license_plate_entrance));
                localb.setFunctionButtonTextColor(MMApplicationContext.getColor(ba.c.link_color));
                localb.setFunctionButtonOnClickListener(new p..ExternalSyntheticLambda0(this));
                localb.setPositiveButtonText(MMApplicationContext.getString(ba.i.login_accept_button));
                localb.setNegativeButtonText(MMApplicationContext.getString(ba.i.login_reject_button));
                localObject3 = com.tencent.mm.plugin.car_license_plate.api.entity.a.wbN;
                localObject3 = com.tencent.mm.plugin.car_license_plate.api.entity.a.diN();
                if ((localObject3 != null) && (((fvl)localObject3).rHj) && (!TextUtils.isEmpty((CharSequence)((fvl)localObject3).wording)))
                {
                  localObject3 = ((fvl)localObject3).wording;
                  s.s(localObject3, "userPrivacyProtectInfo.wording");
                  localb.setUserAgreementCheckBoxWording((String)localObject3);
                  localb.setIExternalToolsHelper((aj)((com.tencent.mm.plugin.appbrand.g)localObject1).T(aj.class));
                }
                localb.h((com.tencent.mm.plugin.appbrand.g)localObject1);
              }
            }
            else
            {
              localObject1 = this.rGC;
              if (localObject1 != null) {
                break label840;
              }
              s.bIx("listHalfScreenDialog");
              localObject1 = localObject2;
              label743:
              if (!bool) {
                break label843;
              }
              s.checkNotNull(paramMMCarLicensePlateInfo);
            }
            break;
          }
        }
      }
    }
    label779:
    label784:
    label829:
    label840:
    label843:
    for (paramMMCarLicensePlateInfo = b.a("webapi_userplateinfo", paramMMCarLicensePlateInfo);; paramMMCarLicensePlateInfo = (List)ab.aivy)
    {
      ((com.tencent.mm.plugin.appbrand.permission.a.b)localObject1).setSelectListItem(paramMMCarLicensePlateInfo);
      AppMethodBeat.o(327085);
      return;
      i = 0;
      break;
      bool = false;
      break label89;
      localObject1 = c.rGJ;
      break label105;
      this.rGF.juz = 1L;
      this.rGF.juB = 1L;
      break label168;
      this.rGF.juz = 2L;
      break label168;
      i = 0;
      break label535;
      localb.kb(false);
      break label567;
      break label743;
    }
    label853:
    this.rGG.bSt();
    AppMethodBeat.o(327085);
    return;
    label867:
    localObject1 = c.rGJ;
    paramMMCarLicensePlateInfo = this.rGA;
    if (paramMMCarLicensePlateInfo == null)
    {
      s.bIx("displayMode");
      paramMMCarLicensePlateInfo = localb;
    }
    for (;;)
    {
      if ((localObject1 == paramMMCarLicensePlateInfo) && (!bool))
      {
        cqq().wdn = true;
        a(cqq(), (kotlin.g.a.b)new g(this));
      }
      AppMethodBeat.o(327085);
      return;
    }
  }
  
  public final void a(CarLicensePlateListViewContract.b.a parama)
  {
    AppMethodBeat.i(327072);
    s.u(parama, "request");
    if (CarLicensePlateListViewContract.b.a.wdh == parama)
    {
      parama = this.rGz;
      if (parama == null) {}
      for (parama = null; parama == null; parama = parama.getRuntime())
      {
        AppMethodBeat.o(327072);
        return;
      }
      com.tencent.mm.plugin.appbrand.q.c localc = new com.tencent.mm.plugin.appbrand.q.c();
      localc.tmg = new p..ExternalSyntheticLambda2(parama);
      localc.ap(parama);
      parama = ah.aiuX;
      this.rGD = ((DialogInterface)localc);
    }
    AppMethodBeat.o(327072);
  }
  
  public final Activity cqr()
  {
    AppMethodBeat.i(327066);
    Object localObject = this.rGz;
    if (localObject == null)
    {
      localObject = null;
      if (!(localObject instanceof o)) {
        break label49;
      }
    }
    label49:
    for (localObject = (o)localObject;; localObject = null)
    {
      if (localObject != null) {
        break label54;
      }
      AppMethodBeat.o(327066);
      return null;
      localObject = ((com.tencent.mm.plugin.appbrand.g)localObject).getWindowAndroid();
      break;
    }
    label54:
    localObject = AndroidContextUtil.castActivityOrNull(((o)localObject).mContext);
    AppMethodBeat.o(327066);
    return localObject;
  }
  
  public final void jb(boolean paramBoolean)
  {
    AppMethodBeat.i(327051);
    if (this.rGE.getAndSet(true))
    {
      AppMethodBeat.o(327051);
      return;
    }
    com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.WxaCarLicensePlateChooserViewController", s.X("dismiss stack:", android.util.Log.getStackTraceString(new Throwable())));
    Object localObject1 = this.rGz;
    if ((localObject1 instanceof ad)) {}
    for (localObject1 = (ad)localObject1;; localObject1 = null)
    {
      if (localObject1 != null) {
        ((ad)localObject1).b((i.c)this.rGH);
      }
      localObject1 = this.rGz;
      if (localObject1 != null)
      {
        localObject1 = ((com.tencent.mm.plugin.appbrand.g)localObject1).getRuntime();
        if (localObject1 != null)
        {
          localObject1 = ((AppBrandRuntime)localObject1).qsB;
          if (localObject1 != null) {
            ((com.tencent.mm.plugin.appbrand.b.c)localObject1).b((c.a)this.rGH);
          }
        }
      }
      this.rGE.set(true);
      ar.a(this.mainScope, null);
      if (this.rGC != null)
      {
        Object localObject2 = this.rGC;
        localObject1 = localObject2;
        if (localObject2 == null)
        {
          s.bIx("listHalfScreenDialog");
          localObject1 = null;
        }
        localObject2 = this.rGz;
        s.checkNotNull(localObject2);
        ((com.tencent.mm.plugin.appbrand.permission.a.b)localObject1).i((com.tencent.mm.plugin.appbrand.g)localObject2);
      }
      localObject1 = this.rGD;
      if (localObject1 != null) {
        ((DialogInterface)localObject1).dismiss();
      }
      this.rGD = null;
      this.rGz = null;
      if (paramBoolean) {
        this.rGF.bMH();
      }
      AppMethodBeat.o(327051);
      return;
    }
  }
  
  public final aq wd()
  {
    return this.mainScope;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/jsapi/auth/WxaCarLicensePlateChooserViewController$ChooserViewCallback;", "", "onPlateNoChosen", "", "plateNo", "", "onUserCancel", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static abstract interface a
  {
    public abstract void ZZ(String paramString);
    
    public abstract void bSt();
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/jsapi/auth/WxaCarLicensePlateChooserViewController$Companion;", "", "()V", "TAG", "", "convertToDialogItem", "", "Lcom/tencent/mm/plugin/appbrand/widget/dialog/AuthorizeOptionalListAdapter$Item;", "scope", "data", "Lcom/tencent/mm/plugin/car_license_plate/api/entity/MMCarLicensePlateInfo;", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
  {
    public static List<k.a> a(String paramString, MMCarLicensePlateInfo paramMMCarLicensePlateInfo)
    {
      AppMethodBeat.i(326873);
      s.u(paramString, "scope");
      s.u(paramMMCarLicensePlateInfo, "data");
      ArrayList localArrayList = new ArrayList();
      Object localObject1 = (Iterable)paramMMCarLicensePlateInfo.wbK;
      int i = 0;
      localObject1 = ((Iterable)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        Object localObject2 = ((Iterator)localObject1).next();
        if (i < 0) {
          kotlin.a.p.kkW();
        }
        localObject2 = (String)localObject2;
        localArrayList.add(new k.a(1, i.bD((String)localObject2, 0, 2) + '·' + i.bD((String)localObject2, 2, ((String)localObject2).length()), "", paramString, null, s.p(paramMMCarLicensePlateInfo.wbL, localObject2), "", i));
        i += 1;
      }
      paramString = (List)localArrayList;
      AppMethodBeat.o(326873);
      return paramString;
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/jsapi/auth/WxaCarLicensePlateChooserViewController$DisplayMode;", "", "(Ljava/lang/String;I)V", "HALF_SCREEN_DIALOG", "ACTIVITY", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static enum c
  {
    static
    {
      AppMethodBeat.i(326868);
      rGI = new c("HALF_SCREEN_DIALOG", 0);
      rGJ = new c("ACTIVITY", 1);
      rGK = new c[] { rGI, rGJ };
      AppMethodBeat.o(326868);
    }
    
    private c() {}
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/appbrand/jsapi/auth/WxaCarLicensePlateChooserViewController$contextOnDestroyListenerAdapter$1", "Lcom/tencent/mm/plugin/appbrand/appstate/AppRunningStateController$OnRunningStateChangedListener;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponentViewLifecycleStore$OnDestroyListener;", "onDestroy", "", "onRunningStateChanged", "appId", "", "state", "Lcom/tencent/mm/plugin/appbrand/appstate/AppRunningState;", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class e
    implements c.a, i.c
  {
    e(p paramp) {}
    
    public final void onDestroy()
    {
      AppMethodBeat.i(326788);
      p.a(this.rGL);
      AppMethodBeat.o(326788);
    }
    
    public final void onRunningStateChanged(String paramString, com.tencent.mm.plugin.appbrand.b.b paramb)
    {
      AppMethodBeat.i(326781);
      if (com.tencent.mm.plugin.appbrand.b.b.qKz == paramb) {
        p.a(this.rGL);
      }
      AppMethodBeat.o(326781);
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/appbrand/jsapi/auth/WxaCarLicensePlateChooserViewController$initHalfScreenDialog$1", "Lcom/tencent/mm/plugin/appbrand/permission/jsauth/IJsAuthorizePromptPresenterView$Listener;", "onMsg", "", "resultCode", "", "resultData", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "avatarId", "userAgreementChecked", "", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class f
    implements b.d
  {
    f(p paramp, com.tencent.mm.plugin.appbrand.g paramg) {}
    
    public final void a(int paramInt1, ArrayList<String> paramArrayList, int paramInt2, boolean paramBoolean)
    {
      AppMethodBeat.i(326776);
      s.u(paramArrayList, "resultData");
      com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.WxaCarLicensePlateChooserViewController", "prompt onMsg, resultCode:" + paramInt1 + ", id:" + paramInt2 + "  userAgreementChecked:" + paramBoolean);
      if (1 == paramInt1)
      {
        paramArrayList = p.b(this.rGL).wdm;
        if (paramArrayList == null)
        {
          paramArrayList = null;
          CharSequence localCharSequence = (CharSequence)paramArrayList;
          if ((localCharSequence != null) && (localCharSequence.length() != 0)) {
            break label187;
          }
        }
        label187:
        for (paramInt1 = 1;; paramInt1 = 0)
        {
          if (paramInt1 != 0) {
            break label192;
          }
          kotlinx.coroutines.j.a(ar.kBZ(), null, null, (m)new p.f.a(paramArrayList, this.rCg, paramBoolean, null), 3);
          p.c(this.rGL).juA = 3L;
          p.d(this.rGL).ZZ(paramArrayList);
          AppMethodBeat.o(326776);
          return;
          paramArrayList = paramArrayList.wbK;
          if (paramArrayList == null)
          {
            paramArrayList = null;
            break;
          }
          paramArrayList = (String)kotlin.a.p.ae((List)paramArrayList, paramInt2);
          break;
        }
        label192:
        com.tencent.mm.sdk.platformtools.Log.e("MicroMsg.WxaCarLicensePlateChooserViewController", s.X("prompt onMsg, invalid avatarId(index):", Integer.valueOf(paramInt2)));
        AppMethodBeat.o(326776);
        return;
      }
      p.c(this.rGL).juA = 4L;
      p.d(this.rGL).bSt();
      AppMethodBeat.o(326776);
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "it", "Landroid/app/Instrumentation$ActivityResult;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class g
    extends u
    implements kotlin.g.a.b<Instrumentation.ActivityResult, ah>
  {
    g(p paramp)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class h
    extends k
    implements m<aq, kotlin.d.d<? super ah>, Object>
  {
    int label;
    
    h(Activity paramActivity, CarLicensePlateListViewContract.ViewModel paramViewModel, kotlin.g.a.b<? super Instrumentation.ActivityResult, ah> paramb, kotlin.d.d<? super h> paramd)
    {
      super(paramd);
    }
    
    public final kotlin.d.d<ah> create(Object paramObject, kotlin.d.d<?> paramd)
    {
      AppMethodBeat.i(326775);
      paramObject = (kotlin.d.d)new h(this.rxb, paramViewModel, paramb, paramd);
      AppMethodBeat.o(326775);
      return paramObject;
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(326771);
      kotlin.d.a.a locala = kotlin.d.a.a.aiwj;
      switch (this.label)
      {
      default: 
        paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(326771);
        throw paramObject;
      case 0: 
        ResultKt.throwOnFailure(paramObject);
        paramObject = this.rxb;
        Object localObject1 = new Intent((Context)this.rxb, CarLicensePlateListUI.class);
        Object localObject2 = paramViewModel;
        if (localObject2 != null) {
          ((Intent)localObject1).putExtra("INTENT_KEY_VIEW_MODEL", (Parcelable)localObject2);
        }
        localObject2 = ah.aiuX;
        localObject2 = (kotlin.d.d)this;
        this.label = 1;
        localObject1 = com.tencent.mm.plugin.car_license_plate.b.a.a(paramObject, (Intent)localObject1, (kotlin.d.d)localObject2);
        paramObject = localObject1;
        if (localObject1 == locala)
        {
          AppMethodBeat.o(326771);
          return locala;
        }
      case 1: 
        ResultKt.throwOnFailure(paramObject);
        paramObject = (kotlin.g.a.a)new p.h.a(paramb, (Instrumentation.ActivityResult)paramObject);
        this.label = 2;
        if (com.tencent.mm.plugin.car_license_plate.b.a.a(paramObject, this) != locala) {
          break label192;
        }
        AppMethodBeat.o(326771);
        return locala;
      }
      ResultKt.throwOnFailure(paramObject);
      label192:
      paramObject = ah.aiuX;
      AppMethodBeat.o(326771);
      return paramObject;
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "it", "Landroid/app/Instrumentation$ActivityResult;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class i
    extends u
    implements kotlin.g.a.b<Instrumentation.ActivityResult, ah>
  {
    i(p paramp)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/appbrand/jsapi/auth/WxaCarLicensePlateChooserViewController$viewCallback$1", "Lcom/tencent/mm/plugin/appbrand/jsapi/auth/WxaCarLicensePlateChooserViewController$ChooserViewCallback;", "onPlateNoChosen", "", "plateNo", "", "onUserCancel", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class j
    implements p.a
  {
    j(p.a parama, p paramp) {}
    
    public final void ZZ(String paramString)
    {
      AppMethodBeat.i(326774);
      s.u(paramString, "plateNo");
      p.a locala = this.rGR;
      if (locala != null) {
        locala.ZZ(paramString);
      }
      jdField_this.jb(true);
      AppMethodBeat.o(326774);
    }
    
    public final void bSt()
    {
      AppMethodBeat.i(326782);
      p.a locala = this.rGR;
      if (locala != null) {
        locala.bSt();
      }
      jdField_this.jb(true);
      AppMethodBeat.o(326782);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.auth.p
 * JD-Core Version:    0.7.0.1
 */