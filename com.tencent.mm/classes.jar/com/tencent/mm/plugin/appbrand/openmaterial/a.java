package com.tencent.mm.plugin.appbrand.openmaterial;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.os.Build.VERSION;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.au.e;
import com.tencent.mm.plugin.appbrand.au.f;
import com.tencent.mm.plugin.appbrand.au.g;
import com.tencent.mm.plugin.appbrand.au.i;
import com.tencent.mm.plugin.appbrand.openmaterial.a.b.a;
import com.tencent.mm.plugin.appbrand.openmaterial.model.AppBrandOpenMaterialCollection;
import com.tencent.mm.plugin.appbrand.openmaterial.model.AppBrandOpenMaterialDetailModel;
import com.tencent.mm.plugin.appbrand.openmaterial.model.AppBrandOpenMaterialModel;
import com.tencent.mm.plugin.appbrand.openmaterial.model.MaterialModel;
import com.tencent.mm.plugin.appbrand.openmaterial.ui.hybrid.OpenMaterialJsBridge;
import com.tencent.mm.plugin.appbrand.openmaterial.ui.hybrid.OpenMaterialWebView;
import com.tencent.mm.plugin.appbrand.openmaterial.ui.hybrid.c;
import com.tencent.mm.plugin.appbrand.service.r;
import com.tencent.mm.plugin.websearch.api.ai;
import com.tencent.mm.plugin.websearch.api.at;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMFragmentActivity;
import com.tencent.mm.ui.ar;
import com.tencent.mm.ui.widget.a.e;
import com.tencent.mm.vfs.u;
import java.util.Collection;
import java.util.List;
import kotlin.x;

@kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/openmaterial/AppBrandOpenMaterialBottomSheet;", "Lcom/tencent/mm/plugin/appbrand/openmaterial/IAppBrandOpenMaterialBottomSheet;", "context", "Landroid/content/Context;", "bottomSheet4Config", "Lcom/tencent/mm/ui/widget/dialog/MMBottomSheet;", "openMaterialCollection", "Lcom/tencent/mm/plugin/appbrand/openmaterial/model/AppBrandOpenMaterialCollection;", "launchAppBrandExecutor", "Lcom/tencent/mm/plugin/appbrand/openmaterial/ILaunchAppBrandExecutor;", "openMaterialReporter", "Lcom/tencent/mm/plugin/appbrand/openmaterial/IAppBrandOpenMaterialReporter;", "(Landroid/content/Context;Lcom/tencent/mm/ui/widget/dialog/MMBottomSheet;Lcom/tencent/mm/plugin/appbrand/openmaterial/model/AppBrandOpenMaterialCollection;Lcom/tencent/mm/plugin/appbrand/openmaterial/ILaunchAppBrandExecutor;Lcom/tencent/mm/plugin/appbrand/openmaterial/IAppBrandOpenMaterialReporter;)V", "bottomSheet", "Lcom/tencent/mm/plugin/appbrand/openmaterial/ui/IOpenMaterialBottomSheet;", "jsBridge", "Lcom/tencent/mm/plugin/appbrand/openmaterial/ui/hybrid/OpenMaterialJsBridge;", "listener", "Lcom/tencent/mm/plugin/appbrand/openmaterial/IAppBrandOpenMaterialBottomSheet$IListener;", "buildHybridBottomSheet", "buildTitleView", "Landroid/view/View;", "dead", "", "hide", "requireBottomSheet", "setListener", "show", "showDirectly", "showInner", "tryLaunchAppBrand", "appId", "", "versionType", "", "enterPath", "configDialog", "Landroid/app/Dialog;", "loadDataAsync", "Lcom/tencent/mm/plugin/appbrand/openmaterial/ui/hybrid/OpenMaterialWebView;", "Companion", "plugin-appbrand-integration_release"})
public final class a
  implements h
{
  private static com.tencent.mm.plugin.appbrand.openmaterial.model.b qlY;
  public static final a qlZ;
  private final Context context;
  private com.tencent.mm.plugin.appbrand.openmaterial.ui.a qlR;
  private OpenMaterialJsBridge qlS;
  private h.b qlT;
  private final e qlU;
  private final AppBrandOpenMaterialCollection qlV;
  private final l qlW;
  private final i qlX;
  
  static
  {
    AppMethodBeat.i(282343);
    qlZ = new a((byte)0);
    AppMethodBeat.o(282343);
  }
  
  public a(Context paramContext, e parame, AppBrandOpenMaterialCollection paramAppBrandOpenMaterialCollection, l paraml, i parami)
  {
    AppMethodBeat.i(282342);
    this.context = paramContext;
    this.qlU = parame;
    this.qlV = paramAppBrandOpenMaterialCollection;
    this.qlW = paraml;
    this.qlX = parami;
    if ((this.context instanceof MMFragmentActivity))
    {
      ((MMFragmentActivity)this.context).keep((com.tencent.mm.vending.e.a)this);
      AppMethodBeat.o(282342);
      return;
    }
    Log.e("MicroMsg.AppBrand.AppBrandOpenMaterialBottomSheet", "<init>, context is not lifecycle keeper");
    AppMethodBeat.o(282342);
  }
  
  private final void b(Dialog paramDialog)
  {
    AppMethodBeat.i(282341);
    if (Build.VERSION.SDK_INT >= 21)
    {
      localObject = paramDialog.getWindow();
      if (localObject != null) {
        ((Window)localObject).addFlags(-2147483648);
      }
    }
    Object localObject = this.qlU;
    if ((localObject != null) && (true == ((e)localObject).icw()) && (Build.VERSION.SDK_INT >= 23))
    {
      localObject = paramDialog.getWindow();
      if (localObject != null)
      {
        localObject = ((Window)localObject).getDecorView();
        if (localObject != null) {
          ((View)localObject).setSystemUiVisibility(9216);
        }
      }
      localObject = paramDialog.getWindow();
      if (localObject != null) {
        ((Window)localObject).setStatusBarColor(0);
      }
    }
    localObject = this.qlU;
    if ((localObject != null) && (true == ((e)localObject).isHideStatusBar()))
    {
      localObject = paramDialog.getWindow();
      if (localObject != null) {
        ((Window)localObject).addFlags(1024);
      }
    }
    localObject = this.qlU;
    if ((localObject != null) && (true == ((e)localObject).icx()))
    {
      localObject = paramDialog.getWindow();
      if (localObject != null) {
        ((Window)localObject).setFlags(8, 8);
      }
      localObject = paramDialog.getWindow();
      if (localObject != null) {
        ((Window)localObject).addFlags(131200);
      }
      paramDialog = paramDialog.getWindow();
      if (paramDialog != null)
      {
        paramDialog = paramDialog.getDecorView();
        if (paramDialog != null)
        {
          paramDialog.setSystemUiVisibility(6);
          AppMethodBeat.o(282341);
          return;
        }
      }
      AppMethodBeat.o(282341);
      return;
    }
    localObject = paramDialog.getWindow();
    if (localObject != null) {
      ((Window)localObject).clearFlags(8);
    }
    localObject = paramDialog.getWindow();
    if (localObject != null) {
      ((Window)localObject).clearFlags(131072);
    }
    localObject = paramDialog.getWindow();
    if (localObject != null) {
      ((Window)localObject).clearFlags(128);
    }
    paramDialog = paramDialog.getWindow();
    if (paramDialog != null)
    {
      paramDialog = paramDialog.getDecorView();
      if (paramDialog != null)
      {
        paramDialog.setSystemUiVisibility(0);
        AppMethodBeat.o(282341);
        return;
      }
    }
    AppMethodBeat.o(282341);
  }
  
  private final void ccG()
  {
    AppMethodBeat.i(282334);
    com.tencent.mm.plugin.appbrand.openmaterial.ui.a locala = ccH();
    b(locala.getDialog());
    locala.show();
    AppMethodBeat.o(282334);
  }
  
  private final com.tencent.mm.plugin.appbrand.openmaterial.ui.a ccH()
  {
    AppMethodBeat.i(282336);
    com.tencent.mm.plugin.appbrand.openmaterial.ui.a locala2 = this.qlR;
    com.tencent.mm.plugin.appbrand.openmaterial.ui.a locala1 = locala2;
    if (locala2 == null)
    {
      locala1 = ccI();
      locala1.setTitleView(ccJ());
      locala1.getDialog().setOnDismissListener((DialogInterface.OnDismissListener)new f(this));
      this.qlR = locala1;
    }
    AppMethodBeat.o(282336);
    return locala1;
  }
  
  private final com.tencent.mm.plugin.appbrand.openmaterial.ui.a ccI()
  {
    AppMethodBeat.i(282338);
    Object localObject = new com.tencent.mm.plugin.appbrand.openmaterial.ui.hybrid.a(this.context, (kotlin.g.a.b)new c(this));
    ((com.tencent.mm.plugin.appbrand.openmaterial.ui.hybrid.a)localObject).a((com.tencent.mm.plugin.appbrand.openmaterial.ui.a.a)new b(this));
    localObject = (com.tencent.mm.plugin.appbrand.openmaterial.ui.a)localObject;
    AppMethodBeat.o(282338);
    return localObject;
  }
  
  private final View ccJ()
  {
    AppMethodBeat.i(282340);
    View localView = LayoutInflater.from(this.context).inflate(au.g.open_material_bottom_sheet_title, null);
    Object localObject = (ImageView)localView.findViewById(au.f.iv_close);
    if (localObject != null) {
      if (!ar.isDarkMode()) {
        break label110;
      }
    }
    label110:
    for (int i = au.e.actionbar_icon_light_close;; i = au.e.actionbar_icon_dark_close)
    {
      ((ImageView)localObject).setImageResource(i);
      ((ImageView)localObject).setOnClickListener((View.OnClickListener)new d(this));
      com.tencent.mm.ui.tools.p.iF((View)localObject);
      localObject = (TextView)localView.findViewById(au.f.tv_title);
      if (localObject != null) {
        ((TextView)localObject).setText(au.i.app_brand_open_material_more);
      }
      kotlin.g.b.p.j(localView, "titleView");
      AppMethodBeat.o(282340);
      return localView;
    }
  }
  
  public final void a(h.b paramb)
  {
    this.qlT = paramb;
  }
  
  public final void ccF()
  {
    AppMethodBeat.i(282329);
    Log.i("MicroMsg.AppBrand.AppBrandOpenMaterialBottomSheet", "showDirectly");
    this.qlX.ccT();
    ccG();
    AppMethodBeat.o(282329);
  }
  
  public final void dead()
  {
    AppMethodBeat.i(282333);
    com.tencent.mm.plugin.appbrand.openmaterial.ui.a locala = this.qlR;
    if (locala != null)
    {
      locala.dead();
      AppMethodBeat.o(282333);
      return;
    }
    AppMethodBeat.o(282333);
  }
  
  public final void hide()
  {
    AppMethodBeat.i(282331);
    com.tencent.mm.plugin.appbrand.openmaterial.ui.a locala = this.qlR;
    if (locala != null)
    {
      locala.hide();
      AppMethodBeat.o(282331);
      return;
    }
    AppMethodBeat.o(282331);
  }
  
  public final void show()
  {
    AppMethodBeat.i(282328);
    Log.i("MicroMsg.AppBrand.AppBrandOpenMaterialBottomSheet", "show");
    this.qlX.ccS();
    ccG();
    AppMethodBeat.o(282328);
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/openmaterial/AppBrandOpenMaterialBottomSheet$Companion;", "Lcom/tencent/mm/plugin/appbrand/openmaterial/IAppBrandOpenMaterialBottomSheet$IFactory;", "()V", "scene", "Lcom/tencent/mm/plugin/appbrand/openmaterial/model/AppBrandOpenMaterialScene;", "canCreate", "", "openMaterialCollection", "Lcom/tencent/mm/plugin/appbrand/openmaterial/model/AppBrandOpenMaterialCollection;", "create", "Lcom/tencent/mm/plugin/appbrand/openmaterial/IAppBrandOpenMaterialBottomSheet;", "context", "Landroid/content/Context;", "bottomSheet4Config", "Lcom/tencent/mm/ui/widget/dialog/MMBottomSheet;", "launchAppBrandExecutor", "Lcom/tencent/mm/plugin/appbrand/openmaterial/ILaunchAppBrandExecutor;", "openMaterialReporter", "Lcom/tencent/mm/plugin/appbrand/openmaterial/IAppBrandOpenMaterialReporter;", "setScene", "plugin-appbrand-integration_release"})
  public static final class a
    implements h.a
  {
    public final h a(Context paramContext, e parame, AppBrandOpenMaterialCollection paramAppBrandOpenMaterialCollection, l paraml, i parami)
    {
      AppMethodBeat.i(279111);
      kotlin.g.b.p.k(paramContext, "context");
      kotlin.g.b.p.k(paramAppBrandOpenMaterialCollection, "openMaterialCollection");
      Log.d("MicroMsg.AppBrand.AppBrandOpenMaterialBottomSheet", "create");
      if (!((a)this).a(paramAppBrandOpenMaterialCollection))
      {
        Log.i("MicroMsg.AppBrand.AppBrandOpenMaterialBottomSheet", "create, can not create, use dummy");
        paramContext = h.qmK;
        kotlin.g.b.p.j(paramContext, "IAppBrandOpenMaterialBottomSheet.DUMMY");
        AppMethodBeat.o(279111);
        return paramContext;
      }
      if (d.ef(paramContext))
      {
        if (paraml != null) {
          break label164;
        }
        paraml = l.qmQ;
        kotlin.g.b.p.j(paraml, "ILaunchAppBrandExecutor.DEFAULT");
      }
      label164:
      for (;;)
      {
        if (parami == null)
        {
          parami = a.ccK();
          if (parami == null) {
            kotlin.g.b.p.iCn();
          }
          parami = (i)new com.tencent.mm.plugin.appbrand.openmaterial.b.a(parami, paramAppBrandOpenMaterialCollection);
        }
        for (;;)
        {
          for (paramContext = (h)new a(paramContext, parame, paramAppBrandOpenMaterialCollection, paraml, parami);; paramContext = h.qmK)
          {
            kotlin.g.b.p.j(paramContext, "if (context.isValid())\n …Sheet.DUMMY\n            }");
            AppMethodBeat.o(279111);
            return paramContext;
            Log.i("MicroMsg.AppBrand.AppBrandOpenMaterialBottomSheet", "create, context is invalid, use dummy");
          }
        }
      }
    }
    
    public final boolean a(AppBrandOpenMaterialCollection paramAppBrandOpenMaterialCollection)
    {
      AppMethodBeat.i(279108);
      kotlin.g.b.p.k(paramAppBrandOpenMaterialCollection, "openMaterialCollection");
      paramAppBrandOpenMaterialCollection = paramAppBrandOpenMaterialCollection.qni;
      kotlin.g.b.p.j(paramAppBrandOpenMaterialCollection, "openMaterialCollection.a…dOpenMaterialDetailModels");
      if (!((Collection)paramAppBrandOpenMaterialCollection).isEmpty())
      {
        AppMethodBeat.o(279108);
        return true;
      }
      AppMethodBeat.o(279108);
      return false;
    }
    
    public final h.a b(com.tencent.mm.plugin.appbrand.openmaterial.model.b paramb)
    {
      AppMethodBeat.i(279109);
      kotlin.g.b.p.k(paramb, "scene");
      Log.d("MicroMsg.AppBrand.AppBrandOpenMaterialBottomSheet", "setScene, scene: ".concat(String.valueOf(paramb)));
      a.a(paramb);
      paramb = (h.a)this;
      AppMethodBeat.o(279109);
      return paramb;
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/appbrand/openmaterial/AppBrandOpenMaterialBottomSheet$buildHybridBottomSheet$2$1", "Lcom/tencent/mm/plugin/appbrand/openmaterial/ui/IOpenMaterialBottomSheet$IListener;", "onContentVisibleHeightChange", "", "height", "", "plugin-appbrand-integration_release"})
  public static final class b
    implements com.tencent.mm.plugin.appbrand.openmaterial.ui.a.a
  {
    b(a parama) {}
    
    public final void Cm(int paramInt)
    {
      AppMethodBeat.i(281156);
      OpenMaterialJsBridge localOpenMaterialJsBridge = a.e(this.qma);
      if (localOpenMaterialJsBridge != null)
      {
        localOpenMaterialJsBridge.onWindowHeightChange(com.tencent.mm.plugin.appbrand.ac.g.Dh(paramInt));
        AppMethodBeat.o(281156);
        return;
      }
      AppMethodBeat.o(281156);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "Lcom/tencent/mm/plugin/appbrand/openmaterial/ui/hybrid/OpenMaterialWebView;", "invoke"})
  static final class c
    extends kotlin.g.b.q
    implements kotlin.g.a.b<OpenMaterialWebView, x>
  {
    c(a parama)
    {
      super();
    }
    
    @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Lcom/tencent/mm/plugin/appbrand/openmaterial/model/AppBrandOpenMaterialDetailModel;", "appId", "", "versionType", "", "enterPath", "invoke", "com/tencent/mm/plugin/appbrand/openmaterial/AppBrandOpenMaterialBottomSheet$buildHybridBottomSheet$1$jsBridge$1$findOpenMaterialModel$1"})
    static final class a
      extends kotlin.g.b.q
      implements kotlin.g.a.q<String, Integer, String, AppBrandOpenMaterialDetailModel>
    {
      a(a.c paramc)
      {
        super();
      }
    }
    
    @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/appbrand/openmaterial/AppBrandOpenMaterialBottomSheet$buildHybridBottomSheet$1$jsBridge$1$1", "Lcom/tencent/mm/plugin/appbrand/openmaterial/ui/hybrid/ILaunchWeAppDelegate;", "launch", "", "appId", "", "versionType", "", "enterPath", "plugin-appbrand-integration_release"})
    public static final class b
      implements c
    {
      b(kotlin.g.a.q paramq, a.c paramc) {}
      
      public final void C(final String paramString1, final int paramInt, final String paramString2)
      {
        AppMethodBeat.i(278357);
        kotlin.g.b.p.k(paramString1, "appId");
        kotlin.g.b.p.k(paramString2, "enterPath");
        com.tencent.e.h.ZvG.bc((Runnable)new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(274581);
            Object localObject = a.d(this.qmd.qmb.qma);
            if (localObject != null) {
              ((com.tencent.mm.plugin.appbrand.openmaterial.ui.a)localObject).hide();
            }
            localObject = (AppBrandOpenMaterialDetailModel)this.qmd.qmc.c(paramString1, Integer.valueOf(paramInt), paramString2);
            if (localObject == null) {
              Log.w("MicroMsg.AppBrand.AppBrandOpenMaterialBottomSheet", "launch#buildHybridBottomSheet, openMaterialModel is null");
            }
            for (;;)
            {
              a.a(this.qmd.qmb.qma, paramString1, paramInt, paramString2);
              AppMethodBeat.o(274581);
              return;
              a.b(this.qmd.qmb.qma).a((AppBrandOpenMaterialModel)localObject);
            }
          }
        });
        AppMethodBeat.o(278357);
      }
    }
    
    @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/appbrand/openmaterial/AppBrandOpenMaterialBottomSheet$buildHybridBottomSheet$1$jsBridge$1$2", "Lcom/tencent/mm/plugin/appbrand/openmaterial/ui/hybrid/IWeAppExposureDelegate;", "onWeAppExposure", "", "appId", "", "versionType", "", "enterPath", "plugin-appbrand-integration_release"})
    public static final class c
      implements com.tencent.mm.plugin.appbrand.openmaterial.ui.hybrid.d
    {
      c(kotlin.g.a.q paramq, a.c paramc) {}
      
      public final void D(String paramString1, int paramInt, String paramString2)
      {
        AppMethodBeat.i(280373);
        kotlin.g.b.p.k(paramString1, "appId");
        kotlin.g.b.p.k(paramString2, "enterPath");
        paramString1 = (AppBrandOpenMaterialDetailModel)this.qmc.c(paramString1, Integer.valueOf(paramInt), paramString2);
        if (paramString1 == null)
        {
          Log.w("MicroMsg.AppBrand.AppBrandOpenMaterialBottomSheet", "onWeAppExposure#buildHybridBottomSheet, openMaterialModel is null");
          AppMethodBeat.o(280373);
          return;
        }
        a.b(this.qmb.qma).b((AppBrandOpenMaterialModel)paramString1);
        AppMethodBeat.o(280373);
      }
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/mm/plugin/appbrand/openmaterial/AppBrandOpenMaterialBottomSheet$buildTitleView$1$1"})
  static final class d
    implements View.OnClickListener
  {
    d(a parama) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(277514);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/appbrand/openmaterial/AppBrandOpenMaterialBottomSheet$buildTitleView$$inlined$apply$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
      Log.i("MicroMsg.AppBrand.AppBrandOpenMaterialBottomSheet", "iv_close#onClick");
      this.qma.hide();
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/appbrand/openmaterial/AppBrandOpenMaterialBottomSheet$buildTitleView$$inlined$apply$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(277514);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class e
    implements Runnable
  {
    e(a parama, OpenMaterialWebView paramOpenMaterialWebView, OpenMaterialJsBridge paramOpenMaterialJsBridge) {}
    
    public final void run()
    {
      int i = 0;
      AppMethodBeat.i(279144);
      Object localObject = ai.anf(7);
      if (localObject == null)
      {
        Log.w("MicroMsg.AppBrand.AppBrandOpenMaterialBottomSheet", "loadDataAsync, openMaterialTemplate is null");
        AppMethodBeat.o(279144);
        return;
      }
      final String str = ((at)localObject).gRd() + '/' + at.gRj();
      Log.d("MicroMsg.AppBrand.AppBrandOpenMaterialBottomSheet", "loadDataAsync, htmlPath: ".concat(String.valueOf(str)));
      localObject = u.aY(str, 0, -1);
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
        AppMethodBeat.o(279144);
        return;
      }
      str = "file://".concat(String.valueOf(str));
      Log.d("MicroMsg.AppBrand.AppBrandOpenMaterialBottomSheet", "loadDataAsync, baseUrl: ".concat(String.valueOf(str)));
      OpenMaterialJsBridge localOpenMaterialJsBridge = this.qmf;
      com.tencent.mm.plugin.appbrand.openmaterial.model.b localb = a.b(this.qma).ccQ();
      kotlin.g.b.p.j(localb, "openMaterialReporter.openMaterialScene");
      List localList = a.c(this.qma).qni;
      kotlin.g.b.p.j(localList, "openMaterialCollection.a…dOpenMaterialDetailModels");
      localObject = localOpenMaterialJsBridge.attachMyOpenMaterials2Template((byte[])localObject, localb, localList);
      com.tencent.e.h.ZvG.bc((Runnable)new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(270617);
          this.qmg.qme.loadDataWithBaseURL(str, new String(this.qmi, kotlin.n.d.UTF_8), "text/html", "utf-8", null);
          AppMethodBeat.o(270617);
        }
      });
      AppMethodBeat.o(279144);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "onDismiss", "com/tencent/mm/plugin/appbrand/openmaterial/AppBrandOpenMaterialBottomSheet$requireBottomSheet$1$1"})
  static final class f
    implements DialogInterface.OnDismissListener
  {
    f(a parama) {}
    
    public final void onDismiss(DialogInterface paramDialogInterface)
    {
      AppMethodBeat.i(274559);
      Log.i("MicroMsg.AppBrand.AppBrandOpenMaterialBottomSheet", "onDismiss");
      paramDialogInterface = a.a(this.qma);
      if (paramDialogInterface != null) {
        paramDialogInterface.ccP();
      }
      a.b(this.qma).ccR();
      AppMethodBeat.o(274559);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class g
    implements Runnable
  {
    g(a parama, r paramr, String paramString1, int paramInt, String paramString2) {}
    
    public final void run()
    {
      AppMethodBeat.i(266993);
      Log.i("MicroMsg.AppBrand.AppBrandOpenMaterialBottomSheet", "tryLaunchAppBrand, launch appBrand");
      Object localObject1 = this.qmj;
      Object localObject2 = a.f(this.qma);
      com.tencent.mm.plugin.appbrand.api.g localg = new com.tencent.mm.plugin.appbrand.api.g();
      localg.appId = this.cBD;
      localg.cBU = this.nKm;
      localg.nBq = this.pYx;
      localg.scene = 1173;
      String str1 = a.c(this.qma).qng.mimeType;
      kotlin.g.b.p.j(str1, "openMaterialCollection.materialModel.mimeType");
      String str2 = a.c(this.qma).qng.qnl;
      kotlin.g.b.p.j(str2, "openMaterialCollection.materialModel.materialPath");
      localg.nBr = ((com.tencent.mm.plugin.appbrand.api.d)new com.tencent.mm.plugin.appbrand.openmaterial.model.a(str1, str2));
      ((r)localObject1).a((Context)localObject2, localg);
      localObject1 = com.tencent.mm.plugin.appbrand.openmaterial.a.b.qna;
      localObject1 = b.a.ccV();
      localObject2 = a.c(this.qma).qng;
      kotlin.g.b.p.j(localObject2, "openMaterialCollection.materialModel");
      ((com.tencent.mm.plugin.appbrand.openmaterial.a.b)localObject1).c((MaterialModel)localObject2);
      AppMethodBeat.o(266993);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.openmaterial.a
 * JD-Core Version:    0.7.0.1
 */