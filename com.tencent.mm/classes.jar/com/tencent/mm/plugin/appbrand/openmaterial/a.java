package com.tencent.mm.plugin.appbrand.openmaterial;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Build.VERSION;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ba.e;
import com.tencent.mm.plugin.appbrand.ba.f;
import com.tencent.mm.plugin.appbrand.ba.g;
import com.tencent.mm.plugin.appbrand.ba.i;
import com.tencent.mm.plugin.appbrand.openmaterial.a.b.a;
import com.tencent.mm.plugin.appbrand.openmaterial.model.AppBrandOpenMaterialCollection;
import com.tencent.mm.plugin.appbrand.openmaterial.model.AppBrandOpenMaterialDetailModel;
import com.tencent.mm.plugin.appbrand.openmaterial.model.AppBrandOpenMaterialModel;
import com.tencent.mm.plugin.appbrand.openmaterial.model.MaterialModel;
import com.tencent.mm.plugin.appbrand.openmaterial.ui.hybrid.OpenMaterialJsBridge;
import com.tencent.mm.plugin.appbrand.openmaterial.ui.hybrid.OpenMaterialWebView;
import com.tencent.mm.plugin.appbrand.openmaterial.ui.hybrid.c;
import com.tencent.mm.plugin.appbrand.service.t;
import com.tencent.mm.plugin.websearch.api.aj;
import com.tencent.mm.plugin.websearch.api.au;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMFragmentActivity;
import com.tencent.mm.ui.aw;
import com.tencent.mm.ui.tools.o;
import com.tencent.mm.ui.widget.a.f;
import com.tencent.mm.vfs.y;
import java.util.Collection;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.q;
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/openmaterial/AppBrandOpenMaterialBottomSheet;", "Lcom/tencent/mm/plugin/appbrand/openmaterial/IAppBrandOpenMaterialBottomSheet;", "context", "Landroid/content/Context;", "bottomSheet4Config", "Lcom/tencent/mm/ui/widget/dialog/MMBottomSheet;", "openMaterialCollection", "Lcom/tencent/mm/plugin/appbrand/openmaterial/model/AppBrandOpenMaterialCollection;", "launchAppBrandExecutor", "Lcom/tencent/mm/plugin/appbrand/openmaterial/ILaunchAppBrandExecutor;", "openMaterialReporter", "Lcom/tencent/mm/plugin/appbrand/openmaterial/IAppBrandOpenMaterialReporter;", "(Landroid/content/Context;Lcom/tencent/mm/ui/widget/dialog/MMBottomSheet;Lcom/tencent/mm/plugin/appbrand/openmaterial/model/AppBrandOpenMaterialCollection;Lcom/tencent/mm/plugin/appbrand/openmaterial/ILaunchAppBrandExecutor;Lcom/tencent/mm/plugin/appbrand/openmaterial/IAppBrandOpenMaterialReporter;)V", "bottomSheet", "Lcom/tencent/mm/plugin/appbrand/openmaterial/ui/IOpenMaterialBottomSheet;", "jsBridge", "Lcom/tencent/mm/plugin/appbrand/openmaterial/ui/hybrid/OpenMaterialJsBridge;", "listener", "Lcom/tencent/mm/plugin/appbrand/openmaterial/IAppBrandOpenMaterialBottomSheet$IListener;", "buildHybridBottomSheet", "buildTitleView", "Landroid/view/View;", "dead", "", "hide", "requireBottomSheet", "setListener", "show", "showDirectly", "showInner", "tryLaunchAppBrand", "appId", "", "versionType", "", "enterPath", "configDialog", "Landroid/app/Dialog;", "loadDataAsync", "Lcom/tencent/mm/plugin/appbrand/openmaterial/ui/hybrid/OpenMaterialWebView;", "Companion", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
  implements g
{
  public static final a tqT;
  private static com.tencent.mm.plugin.appbrand.openmaterial.model.b trb;
  private final Context context;
  private final f tqU;
  private final AppBrandOpenMaterialCollection tqV;
  private final k tqW;
  private final h tqX;
  private com.tencent.mm.plugin.appbrand.openmaterial.ui.a tqY;
  private OpenMaterialJsBridge tqZ;
  private g.b tra;
  
  static
  {
    AppMethodBeat.i(323735);
    tqT = new a((byte)0);
    AppMethodBeat.o(323735);
  }
  
  public a(Context paramContext, f paramf, AppBrandOpenMaterialCollection paramAppBrandOpenMaterialCollection, k paramk, h paramh)
  {
    AppMethodBeat.i(323565);
    this.context = paramContext;
    this.tqU = paramf;
    this.tqV = paramAppBrandOpenMaterialCollection;
    this.tqW = paramk;
    this.tqX = paramh;
    if ((this.context instanceof MMFragmentActivity))
    {
      ((MMFragmentActivity)this.context).keep((com.tencent.mm.vending.e.a)this);
      AppMethodBeat.o(323565);
      return;
    }
    Log.e("MicroMsg.AppBrand.AppBrandOpenMaterialBottomSheet", "<init>, context is not lifecycle keeper");
    AppMethodBeat.o(323565);
  }
  
  private static final void a(a parama, DialogInterface paramDialogInterface)
  {
    AppMethodBeat.i(323624);
    s.u(parama, "this$0");
    Log.i("MicroMsg.AppBrand.AppBrandOpenMaterialBottomSheet", "onDismiss");
    paramDialogInterface = parama.tra;
    if (paramDialogInterface != null) {
      paramDialogInterface.onHidden();
    }
    parama.tqX.cDp();
    AppMethodBeat.o(323624);
  }
  
  private static final void a(a parama, View paramView)
  {
    AppMethodBeat.i(323649);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(parama);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/appbrand/openmaterial/AppBrandOpenMaterialBottomSheet", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(parama, "this$0");
    Log.i("MicroMsg.AppBrand.AppBrandOpenMaterialBottomSheet", "iv_close#onClick");
    parama.hide();
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/appbrand/openmaterial/AppBrandOpenMaterialBottomSheet", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(323649);
  }
  
  private static final void a(OpenMaterialJsBridge paramOpenMaterialJsBridge, a parama, OpenMaterialWebView paramOpenMaterialWebView)
  {
    int i = 0;
    AppMethodBeat.i(323668);
    s.u(paramOpenMaterialJsBridge, "$jsBridge");
    s.u(parama, "this$0");
    s.u(paramOpenMaterialWebView, "$this_loadDataAsync");
    Object localObject = aj.asW(7);
    if (localObject == null)
    {
      Log.w("MicroMsg.AppBrand.AppBrandOpenMaterialBottomSheet", "loadDataAsync, openMaterialTemplate is null");
      AppMethodBeat.o(323668);
      return;
    }
    String str = ((au)localObject).iqp() + '/' + "app.html";
    Log.d("MicroMsg.AppBrand.AppBrandOpenMaterialBottomSheet", s.X("loadDataAsync, htmlPath: ", str));
    localObject = y.bi(str, 0, -1);
    if (localObject != null)
    {
      if (localObject.length == 0) {
        i = 1;
      }
      if (i == 0) {}
    }
    else
    {
      Log.w("MicroMsg.AppBrand.AppBrandOpenMaterialBottomSheet", "loadDataAsync, rawHtmlContent is empty");
      AppMethodBeat.o(323668);
      return;
    }
    str = s.X("file://", str);
    Log.d("MicroMsg.AppBrand.AppBrandOpenMaterialBottomSheet", s.X("loadDataAsync, baseUrl: ", str));
    com.tencent.mm.plugin.appbrand.openmaterial.model.b localb = parama.tqX.cDo();
    s.s(localb, "openMaterialReporter.openMaterialScene");
    parama = parama.tqV.trP;
    s.s(parama, "openMaterialCollection.a…dOpenMaterialDetailModels");
    paramOpenMaterialJsBridge = paramOpenMaterialJsBridge.attachMyOpenMaterials2Template((byte[])localObject, localb, parama);
    com.tencent.threadpool.h.ahAA.bk(new a..ExternalSyntheticLambda3(paramOpenMaterialWebView, str, paramOpenMaterialJsBridge));
    AppMethodBeat.o(323668);
  }
  
  private static final void a(OpenMaterialWebView paramOpenMaterialWebView, String paramString, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(323658);
    s.u(paramOpenMaterialWebView, "$this_loadDataAsync");
    s.u(paramString, "$baseUrl");
    s.u(paramArrayOfByte, "$htmlContent");
    paramOpenMaterialWebView.loadDataWithBaseURL(paramString, new String(paramArrayOfByte, kotlin.n.d.UTF_8), "text/html", "utf-8", null);
    AppMethodBeat.o(323658);
  }
  
  private static final void a(t paramt, a parama, String paramString1, int paramInt, String paramString2)
  {
    AppMethodBeat.i(323638);
    s.u(parama, "this$0");
    s.u(paramString1, "$appId");
    s.u(paramString2, "$enterPath");
    Log.i("MicroMsg.AppBrand.AppBrandOpenMaterialBottomSheet", "tryLaunchAppBrand, launch appBrand");
    Context localContext = parama.context;
    com.tencent.mm.plugin.appbrand.api.g localg = new com.tencent.mm.plugin.appbrand.api.g();
    localg.appId = paramString1;
    localg.euz = paramInt;
    localg.qAF = paramString2;
    localg.scene = 1173;
    paramString1 = parama.tqV.trN.mimeType;
    s.s(paramString1, "openMaterialCollection.materialModel.mimeType");
    paramString2 = parama.tqV.trN.trT;
    s.s(paramString2, "openMaterialCollection.materialModel.materialPath");
    localg.qAG = ((com.tencent.mm.plugin.appbrand.api.d)new com.tencent.mm.plugin.appbrand.openmaterial.model.a(paramString1, paramString2));
    paramString1 = ah.aiuX;
    paramt.a(localContext, localg);
    paramt = com.tencent.mm.plugin.appbrand.openmaterial.a.b.trG;
    paramt = b.a.cDt();
    parama = parama.tqV.trN;
    s.s(parama, "openMaterialCollection.materialModel");
    paramt.c(parama);
    AppMethodBeat.o(323638);
  }
  
  private final void b(Dialog paramDialog)
  {
    Object localObject2 = null;
    Object localObject3 = null;
    int j = 1;
    AppMethodBeat.i(323619);
    if (Build.VERSION.SDK_INT >= 21)
    {
      localObject1 = paramDialog.getWindow();
      if (localObject1 != null) {
        ((Window)localObject1).addFlags(-2147483648);
      }
    }
    Object localObject1 = this.tqU;
    int i;
    if ((localObject1 != null) && (true == ((f)localObject1).GwR))
    {
      i = 1;
      if ((i != 0) && (Build.VERSION.SDK_INT >= 23))
      {
        localObject1 = paramDialog.getWindow();
        if (localObject1 != null) {
          break label263;
        }
        localObject1 = null;
        label89:
        if (localObject1 != null) {
          ((View)localObject1).setSystemUiVisibility(9216);
        }
        localObject1 = paramDialog.getWindow();
        if (localObject1 != null) {
          ((Window)localObject1).setStatusBarColor(0);
        }
      }
      localObject1 = this.tqU;
      if ((localObject1 == null) || (true != ((f)localObject1).sRy)) {
        break label273;
      }
      i = 1;
      label141:
      if (i != 0)
      {
        localObject1 = paramDialog.getWindow();
        if (localObject1 != null) {
          ((Window)localObject1).addFlags(1024);
        }
      }
      localObject1 = this.tqU;
      if ((localObject1 == null) || (true != ((f)localObject1).sRz)) {
        break label278;
      }
      i = j;
      label186:
      if (i == 0) {
        break label291;
      }
      localObject1 = paramDialog.getWindow();
      if (localObject1 != null) {
        ((Window)localObject1).setFlags(8, 8);
      }
      localObject1 = paramDialog.getWindow();
      if (localObject1 != null) {
        ((Window)localObject1).addFlags(131200);
      }
      paramDialog = paramDialog.getWindow();
      if (paramDialog != null) {
        break label283;
      }
    }
    label263:
    label273:
    label278:
    label283:
    for (paramDialog = localObject3;; paramDialog = paramDialog.getDecorView())
    {
      if (paramDialog == null) {
        break label368;
      }
      paramDialog.setSystemUiVisibility(6);
      AppMethodBeat.o(323619);
      return;
      i = 0;
      break;
      localObject1 = ((Window)localObject1).getDecorView();
      break label89;
      i = 0;
      break label141;
      i = 0;
      break label186;
    }
    label291:
    localObject1 = paramDialog.getWindow();
    if (localObject1 != null) {
      ((Window)localObject1).clearFlags(8);
    }
    localObject1 = paramDialog.getWindow();
    if (localObject1 != null) {
      ((Window)localObject1).clearFlags(131072);
    }
    localObject1 = paramDialog.getWindow();
    if (localObject1 != null) {
      ((Window)localObject1).clearFlags(128);
    }
    paramDialog = paramDialog.getWindow();
    if (paramDialog == null) {}
    for (paramDialog = localObject2;; paramDialog = paramDialog.getDecorView())
    {
      if (paramDialog != null) {
        paramDialog.setSystemUiVisibility(0);
      }
      label368:
      AppMethodBeat.o(323619);
      return;
    }
  }
  
  private final void cDc()
  {
    AppMethodBeat.i(323573);
    com.tencent.mm.plugin.appbrand.openmaterial.ui.a locala = cDd();
    b(locala.getDialog());
    locala.show();
    AppMethodBeat.o(323573);
  }
  
  private final com.tencent.mm.plugin.appbrand.openmaterial.ui.a cDd()
  {
    AppMethodBeat.i(323581);
    com.tencent.mm.plugin.appbrand.openmaterial.ui.a locala2 = this.tqY;
    com.tencent.mm.plugin.appbrand.openmaterial.ui.a locala1 = locala2;
    if (locala2 == null)
    {
      locala1 = cDe();
      locala1.setTitleView(cDf());
      locala1.getDialog().setOnDismissListener(new a..ExternalSyntheticLambda0(this));
      this.tqY = locala1;
    }
    AppMethodBeat.o(323581);
    return locala1;
  }
  
  private final com.tencent.mm.plugin.appbrand.openmaterial.ui.a cDe()
  {
    AppMethodBeat.i(323589);
    Object localObject = new com.tencent.mm.plugin.appbrand.openmaterial.ui.hybrid.a(this.context, (kotlin.g.a.b)new b(this));
    ((com.tencent.mm.plugin.appbrand.openmaterial.ui.hybrid.a)localObject).a((com.tencent.mm.plugin.appbrand.openmaterial.ui.a.a)new c(this));
    localObject = (com.tencent.mm.plugin.appbrand.openmaterial.ui.a)localObject;
    AppMethodBeat.o(323589);
    return localObject;
  }
  
  private final View cDf()
  {
    AppMethodBeat.i(323605);
    View localView = LayoutInflater.from(this.context).inflate(ba.g.open_material_bottom_sheet_title, null);
    Object localObject = (ImageView)localView.findViewById(ba.f.iv_close);
    if (localObject != null) {
      if (!aw.isDarkMode()) {
        break label110;
      }
    }
    label110:
    for (int i = ba.e.actionbar_icon_light_close;; i = ba.e.actionbar_icon_dark_close)
    {
      ((ImageView)localObject).setImageResource(i);
      ((ImageView)localObject).setOnClickListener(new a..ExternalSyntheticLambda1(this));
      o.F((View)localObject, 0.7F);
      localObject = (TextView)localView.findViewById(ba.f.tv_title);
      if (localObject != null) {
        ((TextView)localObject).setText(ba.i.app_brand_open_material_more);
      }
      s.s(localView, "titleView");
      AppMethodBeat.o(323605);
      return localView;
    }
  }
  
  public final void a(g.b paramb)
  {
    this.tra = paramb;
  }
  
  public final void cDb()
  {
    AppMethodBeat.i(323789);
    Log.i("MicroMsg.AppBrand.AppBrandOpenMaterialBottomSheet", "showDirectly");
    this.tqX.cDr();
    cDc();
    AppMethodBeat.o(323789);
  }
  
  public final void dead()
  {
    AppMethodBeat.i(323810);
    com.tencent.mm.plugin.appbrand.openmaterial.ui.a locala = this.tqY;
    if (locala != null) {
      locala.dead();
    }
    AppMethodBeat.o(323810);
  }
  
  public final void hide()
  {
    AppMethodBeat.i(323797);
    com.tencent.mm.plugin.appbrand.openmaterial.ui.a locala = this.tqY;
    if (locala != null) {
      locala.hide();
    }
    AppMethodBeat.o(323797);
  }
  
  public final void show()
  {
    AppMethodBeat.i(323784);
    Log.i("MicroMsg.AppBrand.AppBrandOpenMaterialBottomSheet", "show");
    this.tqX.cDq();
    cDc();
    AppMethodBeat.o(323784);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/openmaterial/AppBrandOpenMaterialBottomSheet$Companion;", "Lcom/tencent/mm/plugin/appbrand/openmaterial/IAppBrandOpenMaterialBottomSheet$IFactory;", "()V", "scene", "Lcom/tencent/mm/plugin/appbrand/openmaterial/model/AppBrandOpenMaterialScene;", "canCreate", "", "openMaterialCollection", "Lcom/tencent/mm/plugin/appbrand/openmaterial/model/AppBrandOpenMaterialCollection;", "create", "Lcom/tencent/mm/plugin/appbrand/openmaterial/IAppBrandOpenMaterialBottomSheet;", "context", "Landroid/content/Context;", "bottomSheet4Config", "Lcom/tencent/mm/ui/widget/dialog/MMBottomSheet;", "launchAppBrandExecutor", "Lcom/tencent/mm/plugin/appbrand/openmaterial/ILaunchAppBrandExecutor;", "openMaterialReporter", "Lcom/tencent/mm/plugin/appbrand/openmaterial/IAppBrandOpenMaterialReporter;", "setScene", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
    implements g.a
  {
    public final g a(Context paramContext, f paramf, AppBrandOpenMaterialCollection paramAppBrandOpenMaterialCollection, k paramk, h paramh)
    {
      AppMethodBeat.i(323610);
      s.u(paramContext, "context");
      s.u(paramAppBrandOpenMaterialCollection, "openMaterialCollection");
      Log.d("MicroMsg.AppBrand.AppBrandOpenMaterialBottomSheet", "create");
      if (!a(paramAppBrandOpenMaterialCollection))
      {
        Log.i("MicroMsg.AppBrand.AppBrandOpenMaterialBottomSheet", "create, can not create, use dummy");
        paramContext = g.trt;
        s.s(paramContext, "{\n                Log.i(…Sheet.DUMMY\n            }");
        AppMethodBeat.o(323610);
        return paramContext;
      }
      if (d.eZ(paramContext))
      {
        if (paramk == null)
        {
          paramk = k.trz;
          s.s(paramk, "launchAppBrandExecutor ?…hAppBrandExecutor.DEFAULT");
          if (paramh != null) {
            break label138;
          }
          paramh = a.cDg();
          s.checkNotNull(paramh);
          paramh = (h)new com.tencent.mm.plugin.appbrand.openmaterial.b.a(paramh, paramAppBrandOpenMaterialCollection);
        }
        label138:
        for (;;)
        {
          paramContext = (g)new a(paramContext, paramf, paramAppBrandOpenMaterialCollection, paramk, paramh);
          AppMethodBeat.o(323610);
          return paramContext;
          break;
        }
      }
      Log.i("MicroMsg.AppBrand.AppBrandOpenMaterialBottomSheet", "create, context is invalid, use dummy");
      paramContext = g.trt;
      s.s(paramContext, "{\n                Log.i(…Sheet.DUMMY\n            }");
      AppMethodBeat.o(323610);
      return paramContext;
    }
    
    public final boolean a(AppBrandOpenMaterialCollection paramAppBrandOpenMaterialCollection)
    {
      AppMethodBeat.i(323578);
      s.u(paramAppBrandOpenMaterialCollection, "openMaterialCollection");
      paramAppBrandOpenMaterialCollection = paramAppBrandOpenMaterialCollection.trP;
      s.s(paramAppBrandOpenMaterialCollection, "openMaterialCollection.a…dOpenMaterialDetailModels");
      if (!((Collection)paramAppBrandOpenMaterialCollection).isEmpty())
      {
        AppMethodBeat.o(323578);
        return true;
      }
      AppMethodBeat.o(323578);
      return false;
    }
    
    public final g.a b(com.tencent.mm.plugin.appbrand.openmaterial.model.b paramb)
    {
      AppMethodBeat.i(323593);
      s.u(paramb, "scene");
      Log.d("MicroMsg.AppBrand.AppBrandOpenMaterialBottomSheet", s.X("setScene, scene: ", paramb));
      a.a(paramb);
      paramb = (g.a)this;
      AppMethodBeat.o(323593);
      return paramb;
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "Lcom/tencent/mm/plugin/appbrand/openmaterial/ui/hybrid/OpenMaterialWebView;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements kotlin.g.a.b<OpenMaterialWebView, ah>
  {
    b(a parama)
    {
      super();
    }
    
    @Metadata(d1={""}, d2={"com/tencent/mm/plugin/appbrand/openmaterial/AppBrandOpenMaterialBottomSheet$buildHybridBottomSheet$1$jsBridge$1$1", "Lcom/tencent/mm/plugin/appbrand/openmaterial/ui/hybrid/ILaunchWeAppDelegate;", "launch", "", "appId", "", "versionType", "", "enterPath", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
    public static final class a
      implements c
    {
      a(a parama, q<? super String, ? super Integer, ? super String, ? extends AppBrandOpenMaterialDetailModel> paramq) {}
      
      private static final void a(a parama, q paramq, String paramString1, int paramInt, String paramString2)
      {
        AppMethodBeat.i(323542);
        s.u(parama, "this$0");
        s.u(paramq, "$findOpenMaterialModel");
        s.u(paramString1, "$appId");
        s.u(paramString2, "$enterPath");
        com.tencent.mm.plugin.appbrand.openmaterial.ui.a locala = a.b(parama);
        if (locala != null) {
          locala.hide();
        }
        paramq = (AppBrandOpenMaterialDetailModel)paramq.invoke(paramString1, Integer.valueOf(paramInt), paramString2);
        if (paramq == null) {
          Log.w("MicroMsg.AppBrand.AppBrandOpenMaterialBottomSheet", "launch#buildHybridBottomSheet, openMaterialModel is null");
        }
        for (;;)
        {
          a.a(parama, paramString1, paramInt, paramString2);
          AppMethodBeat.o(323542);
          return;
          a.c(parama).b((AppBrandOpenMaterialModel)paramq);
        }
      }
      
      public final void E(String paramString1, int paramInt, String paramString2)
      {
        AppMethodBeat.i(323553);
        s.u(paramString1, "appId");
        s.u(paramString2, "enterPath");
        com.tencent.threadpool.h.ahAA.bk(new a.b.a..ExternalSyntheticLambda0(this.trc, this.trd, paramString1, paramInt, paramString2));
        AppMethodBeat.o(323553);
      }
    }
    
    @Metadata(d1={""}, d2={"com/tencent/mm/plugin/appbrand/openmaterial/AppBrandOpenMaterialBottomSheet$buildHybridBottomSheet$1$jsBridge$1$2", "Lcom/tencent/mm/plugin/appbrand/openmaterial/ui/hybrid/IWeAppExposureDelegate;", "onWeAppExposure", "", "appId", "", "versionType", "", "enterPath", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
    public static final class b
      implements com.tencent.mm.plugin.appbrand.openmaterial.ui.hybrid.d
    {
      b(q<? super String, ? super Integer, ? super String, ? extends AppBrandOpenMaterialDetailModel> paramq, a parama) {}
      
      public final void F(String paramString1, int paramInt, String paramString2)
      {
        AppMethodBeat.i(323543);
        s.u(paramString1, "appId");
        s.u(paramString2, "enterPath");
        paramString1 = (AppBrandOpenMaterialDetailModel)this.trd.invoke(paramString1, Integer.valueOf(paramInt), paramString2);
        if (paramString1 == null)
        {
          Log.w("MicroMsg.AppBrand.AppBrandOpenMaterialBottomSheet", "onWeAppExposure#buildHybridBottomSheet, openMaterialModel is null");
          AppMethodBeat.o(323543);
          return;
        }
        a.c(this.trc).c((AppBrandOpenMaterialModel)paramString1);
        AppMethodBeat.o(323543);
      }
    }
    
    @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/plugin/appbrand/openmaterial/model/AppBrandOpenMaterialDetailModel;", "appId", "", "versionType", "", "enterPath"}, k=3, mv={1, 5, 1}, xi=48)
    static final class c
      extends u
      implements q<String, Integer, String, AppBrandOpenMaterialDetailModel>
    {
      c(a parama)
      {
        super();
      }
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/appbrand/openmaterial/AppBrandOpenMaterialBottomSheet$buildHybridBottomSheet$2$1", "Lcom/tencent/mm/plugin/appbrand/openmaterial/ui/IOpenMaterialBottomSheet$IListener;", "onContentVisibleHeightChange", "", "height", "", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class c
    implements com.tencent.mm.plugin.appbrand.openmaterial.ui.a.a
  {
    c(a parama) {}
    
    public final void CB(int paramInt)
    {
      AppMethodBeat.i(323557);
      OpenMaterialJsBridge localOpenMaterialJsBridge = a.d(this.trc);
      if (localOpenMaterialJsBridge != null) {
        localOpenMaterialJsBridge.onWindowHeightChange(com.tencent.mm.plugin.appbrand.af.i.DB(paramInt));
      }
      AppMethodBeat.o(323557);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.openmaterial.a
 * JD-Core Version:    0.7.0.1
 */