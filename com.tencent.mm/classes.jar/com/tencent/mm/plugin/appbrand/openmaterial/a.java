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
import com.tencent.mm.g.b.a.ng;
import com.tencent.mm.plugin.appbrand.openmaterial.a.b.a;
import com.tencent.mm.plugin.appbrand.openmaterial.model.AppBrandOpenMaterialCollection;
import com.tencent.mm.plugin.appbrand.openmaterial.model.MaterialModel;
import com.tencent.mm.plugin.appbrand.openmaterial.ui.hybrid.OpenMaterialJsBridge;
import com.tencent.mm.plugin.appbrand.service.r;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMFragmentActivity;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.tools.o;
import com.tencent.mm.ui.widget.a.e;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/openmaterial/AppBrandOpenMaterialBottomSheet;", "Lcom/tencent/mm/plugin/appbrand/openmaterial/IAppBrandOpenMaterialBottomSheet;", "context", "Landroid/content/Context;", "bottomSheet4Config", "Lcom/tencent/mm/ui/widget/dialog/MMBottomSheet;", "openMaterialCollection", "Lcom/tencent/mm/plugin/appbrand/openmaterial/model/AppBrandOpenMaterialCollection;", "launchAppBrandExecutor", "Lcom/tencent/mm/plugin/appbrand/openmaterial/ILaunchAppBrandExecutor;", "openMaterialReporter", "Lcom/tencent/mm/plugin/appbrand/openmaterial/report/AppBrandOpenMaterialReporter;", "(Landroid/content/Context;Lcom/tencent/mm/ui/widget/dialog/MMBottomSheet;Lcom/tencent/mm/plugin/appbrand/openmaterial/model/AppBrandOpenMaterialCollection;Lcom/tencent/mm/plugin/appbrand/openmaterial/ILaunchAppBrandExecutor;Lcom/tencent/mm/plugin/appbrand/openmaterial/report/AppBrandOpenMaterialReporter;)V", "bottomSheet", "Lcom/tencent/mm/plugin/appbrand/openmaterial/ui/IOpenMaterialBottomSheet;", "jsBridge", "Lcom/tencent/mm/plugin/appbrand/openmaterial/ui/hybrid/OpenMaterialJsBridge;", "listener", "Lcom/tencent/mm/plugin/appbrand/openmaterial/IAppBrandOpenMaterialBottomSheet$IListener;", "buildHybridBottomSheet", "buildTitleView", "Landroid/view/View;", "dead", "", "hide", "requireBottomSheet", "setListener", "show", "showDirectly", "tryLaunchAppBrand", "appId", "", "versionType", "", "enterPath", "configDialog", "Landroid/app/Dialog;", "loadDataAsync", "Lcom/tencent/mm/plugin/appbrand/openmaterial/ui/hybrid/OpenMaterialWebView;", "Companion", "plugin-appbrand-integration_release"})
public final class a
  implements g
{
  private static com.tencent.mm.plugin.appbrand.openmaterial.model.b nkA;
  public static final a nkB;
  private final Context context;
  private com.tencent.mm.plugin.appbrand.openmaterial.ui.a nkt;
  private OpenMaterialJsBridge nku;
  private g.b nkv;
  private final e nkw;
  private final AppBrandOpenMaterialCollection nkx;
  private final j nky;
  private final com.tencent.mm.plugin.appbrand.openmaterial.b.a nkz;
  
  static
  {
    AppMethodBeat.i(229086);
    nkB = new a((byte)0);
    AppMethodBeat.o(229086);
  }
  
  public a(Context paramContext, e parame, AppBrandOpenMaterialCollection paramAppBrandOpenMaterialCollection, j paramj, com.tencent.mm.plugin.appbrand.openmaterial.b.a parama)
  {
    AppMethodBeat.i(229085);
    this.context = paramContext;
    this.nkw = parame;
    this.nkx = paramAppBrandOpenMaterialCollection;
    this.nky = paramj;
    this.nkz = parama;
    if ((this.context instanceof MMFragmentActivity))
    {
      ((MMFragmentActivity)this.context).keep((com.tencent.mm.vending.e.a)this);
      AppMethodBeat.o(229085);
      return;
    }
    Log.e("MicroMsg.AppBrand.AppBrandOpenMaterialBottomSheet", "<init>, context is not lifecycle keeper");
    AppMethodBeat.o(229085);
  }
  
  public final void a(g.b paramb)
  {
    this.nkv = paramb;
  }
  
  public final void bPY()
  {
    AppMethodBeat.i(229082);
    Log.i("MicroMsg.AppBrand.AppBrandOpenMaterialBottomSheet", "showDirectly");
    show();
    com.tencent.mm.plugin.appbrand.openmaterial.b.a locala = this.nkz;
    Log.i(locala.bQh(), "onLaunchListPageDirectly");
    locala.bQi().xE(4L).xF(com.tencent.mm.plugin.appbrand.openmaterial.b.a.d(locala.nkA)).xG(locala.bQk()).xH(0L).bfK();
    AppMethodBeat.o(229082);
  }
  
  public final void dead()
  {
    AppMethodBeat.i(229084);
    com.tencent.mm.plugin.appbrand.openmaterial.ui.a locala = this.nkt;
    if (locala != null)
    {
      locala.dead();
      AppMethodBeat.o(229084);
      return;
    }
    AppMethodBeat.o(229084);
  }
  
  public final void hide()
  {
    AppMethodBeat.i(229083);
    com.tencent.mm.plugin.appbrand.openmaterial.ui.a locala = this.nkt;
    if (locala != null)
    {
      locala.hide();
      AppMethodBeat.o(229083);
      return;
    }
    AppMethodBeat.o(229083);
  }
  
  public final void show()
  {
    AppMethodBeat.i(229081);
    Object localObject2 = this.nkt;
    Object localObject1 = localObject2;
    Object localObject3;
    int i;
    if (localObject2 == null)
    {
      localObject1 = new com.tencent.mm.plugin.appbrand.openmaterial.ui.hybrid.a(this.context, (kotlin.g.a.b)new a.c(this));
      localObject2 = (com.tencent.mm.plugin.appbrand.openmaterial.ui.a.a)new b(this);
      ((com.tencent.mm.plugin.appbrand.openmaterial.ui.hybrid.a)localObject1).nmf.nme = ((com.tencent.mm.plugin.appbrand.openmaterial.ui.a.a)localObject2);
      ((com.tencent.mm.plugin.appbrand.openmaterial.ui.hybrid.a)localObject1).nme = ((com.tencent.mm.plugin.appbrand.openmaterial.ui.a.a)localObject2);
      localObject1 = (com.tencent.mm.plugin.appbrand.openmaterial.ui.a)localObject1;
      localObject2 = LayoutInflater.from(this.context).inflate(2131495888, null);
      localObject3 = (ImageView)((View)localObject2).findViewById(2131302885);
      if (localObject3 != null)
      {
        if (ao.isDarkMode())
        {
          i = 2131230864;
          ((ImageView)localObject3).setImageResource(i);
          ((ImageView)localObject3).setOnClickListener((View.OnClickListener)new a.d(this));
          o.hp((View)localObject3);
        }
      }
      else
      {
        localObject3 = (TextView)((View)localObject2).findViewById(2131309539);
        if (localObject3 != null) {
          ((TextView)localObject3).setText(2131755574);
        }
        p.g(localObject2, "titleView");
        ((com.tencent.mm.plugin.appbrand.openmaterial.ui.a)localObject1).setTitleView((View)localObject2);
        ((com.tencent.mm.plugin.appbrand.openmaterial.ui.a)localObject1).getDialog().setOnDismissListener((DialogInterface.OnDismissListener)new f(this));
        this.nkt = ((com.tencent.mm.plugin.appbrand.openmaterial.ui.a)localObject1);
      }
    }
    else
    {
      localObject2 = ((com.tencent.mm.plugin.appbrand.openmaterial.ui.a)localObject1).getDialog();
      if (Build.VERSION.SDK_INT >= 21)
      {
        localObject3 = ((Dialog)localObject2).getWindow();
        if (localObject3 != null) {
          ((Window)localObject3).addFlags(-2147483648);
        }
      }
      localObject3 = this.nkw;
      if ((localObject3 != null) && (true == ((e)localObject3).hbp()) && (Build.VERSION.SDK_INT >= 23))
      {
        localObject3 = ((Dialog)localObject2).getWindow();
        if (localObject3 != null)
        {
          localObject3 = ((Window)localObject3).getDecorView();
          if (localObject3 != null) {
            ((View)localObject3).setSystemUiVisibility(9216);
          }
        }
        localObject3 = ((Dialog)localObject2).getWindow();
        if (localObject3 != null) {
          ((Window)localObject3).setStatusBarColor(0);
        }
      }
      localObject3 = this.nkw;
      if ((localObject3 != null) && (true == ((e)localObject3).isHideStatusBar()))
      {
        localObject3 = ((Dialog)localObject2).getWindow();
        if (localObject3 != null) {
          ((Window)localObject3).addFlags(1024);
        }
      }
      localObject3 = this.nkw;
      if ((localObject3 == null) || (true != ((e)localObject3).hbq())) {
        break label458;
      }
      localObject3 = ((Dialog)localObject2).getWindow();
      if (localObject3 != null) {
        ((Window)localObject3).setFlags(8, 8);
      }
      localObject3 = ((Dialog)localObject2).getWindow();
      if (localObject3 != null) {
        ((Window)localObject3).addFlags(131200);
      }
      localObject2 = ((Dialog)localObject2).getWindow();
      if (localObject2 != null)
      {
        localObject2 = ((Window)localObject2).getDecorView();
        if (localObject2 != null) {
          ((View)localObject2).setSystemUiVisibility(6);
        }
      }
    }
    for (;;)
    {
      ((com.tencent.mm.plugin.appbrand.openmaterial.ui.a)localObject1).show();
      AppMethodBeat.o(229081);
      return;
      i = 2131230857;
      break;
      label458:
      localObject3 = ((Dialog)localObject2).getWindow();
      if (localObject3 != null) {
        ((Window)localObject3).clearFlags(8);
      }
      localObject3 = ((Dialog)localObject2).getWindow();
      if (localObject3 != null) {
        ((Window)localObject3).clearFlags(131072);
      }
      localObject3 = ((Dialog)localObject2).getWindow();
      if (localObject3 != null) {
        ((Window)localObject3).clearFlags(128);
      }
      localObject2 = ((Dialog)localObject2).getWindow();
      if (localObject2 != null)
      {
        localObject2 = ((Window)localObject2).getDecorView();
        if (localObject2 != null) {
          ((View)localObject2).setSystemUiVisibility(0);
        }
      }
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/openmaterial/AppBrandOpenMaterialBottomSheet$Companion;", "Lcom/tencent/mm/plugin/appbrand/openmaterial/IAppBrandOpenMaterialBottomSheet$IFactory;", "()V", "scene", "Lcom/tencent/mm/plugin/appbrand/openmaterial/model/AppBrandOpenMaterialScene;", "create", "Lcom/tencent/mm/plugin/appbrand/openmaterial/IAppBrandOpenMaterialBottomSheet;", "context", "Landroid/content/Context;", "bottomSheet4Config", "Lcom/tencent/mm/ui/widget/dialog/MMBottomSheet;", "openMaterialCollection", "Lcom/tencent/mm/plugin/appbrand/openmaterial/model/AppBrandOpenMaterialCollection;", "launchAppBrandExecutor", "Lcom/tencent/mm/plugin/appbrand/openmaterial/ILaunchAppBrandExecutor;", "openMaterialReporter", "Lcom/tencent/mm/plugin/appbrand/openmaterial/report/AppBrandOpenMaterialReporter;", "setScene", "plugin-appbrand-integration_release"})
  public static final class a
    implements g.a
  {
    public static g a(Context paramContext, e parame, AppBrandOpenMaterialCollection paramAppBrandOpenMaterialCollection, j paramj, com.tencent.mm.plugin.appbrand.openmaterial.b.a parama)
    {
      AppMethodBeat.i(229069);
      p.h(paramContext, "context");
      p.h(paramAppBrandOpenMaterialCollection, "openMaterialCollection");
      Log.d("MicroMsg.AppBrand.AppBrandOpenMaterialBottomSheet", "create");
      if (d.eg(paramContext))
      {
        if (paramj != null) {
          break label126;
        }
        paramj = j.nlj;
        p.g(paramj, "ILaunchAppBrandExecutor.DEFAULT");
      }
      label126:
      for (;;)
      {
        if (parama == null)
        {
          parama = a.bPZ();
          if (parama == null) {
            p.hyc();
          }
          parama = new com.tencent.mm.plugin.appbrand.openmaterial.b.a(parama, paramAppBrandOpenMaterialCollection);
        }
        for (;;)
        {
          paramContext = (g)new a(paramContext, parame, paramAppBrandOpenMaterialCollection, paramj, parama);
          AppMethodBeat.o(229069);
          return paramContext;
          Log.i("MicroMsg.AppBrand.AppBrandOpenMaterialBottomSheet", "create, context is invalid, use dummy");
          paramContext = g.nlh;
          p.g(paramContext, "IAppBrandOpenMaterialBottomSheet.DUMMY");
          AppMethodBeat.o(229069);
          return paramContext;
        }
      }
    }
    
    public final g a(Context paramContext, e parame, AppBrandOpenMaterialCollection paramAppBrandOpenMaterialCollection)
    {
      AppMethodBeat.i(229068);
      p.h(paramContext, "context");
      p.h(paramAppBrandOpenMaterialCollection, "openMaterialCollection");
      paramContext = a(paramContext, parame, paramAppBrandOpenMaterialCollection, null, null);
      AppMethodBeat.o(229068);
      return paramContext;
    }
    
    public final g.a b(com.tencent.mm.plugin.appbrand.openmaterial.model.b paramb)
    {
      AppMethodBeat.i(229067);
      p.h(paramb, "scene");
      Log.d("MicroMsg.AppBrand.AppBrandOpenMaterialBottomSheet", "setScene, scene: ".concat(String.valueOf(paramb)));
      a.a(paramb);
      paramb = (g.a)this;
      AppMethodBeat.o(229067);
      return paramb;
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/appbrand/openmaterial/AppBrandOpenMaterialBottomSheet$buildHybridBottomSheet$2$1", "Lcom/tencent/mm/plugin/appbrand/openmaterial/ui/IOpenMaterialBottomSheet$IListener;", "onContentVisibleHeightChange", "", "height", "", "plugin-appbrand-integration_release"})
  public static final class b
    implements com.tencent.mm.plugin.appbrand.openmaterial.ui.a.a
  {
    b(a parama) {}
    
    public final void yH(int paramInt)
    {
      AppMethodBeat.i(229070);
      OpenMaterialJsBridge localOpenMaterialJsBridge = a.e(this.nkC);
      if (localOpenMaterialJsBridge != null)
      {
        localOpenMaterialJsBridge.onWindowHeightChange(com.tencent.mm.plugin.appbrand.ac.g.zC(paramInt));
        AppMethodBeat.o(229070);
        return;
      }
      AppMethodBeat.o(229070);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "onDismiss", "com/tencent/mm/plugin/appbrand/openmaterial/AppBrandOpenMaterialBottomSheet$requireBottomSheet$1$1"})
  static final class f
    implements DialogInterface.OnDismissListener
  {
    f(a parama) {}
    
    public final void onDismiss(DialogInterface paramDialogInterface)
    {
      AppMethodBeat.i(229079);
      Log.i("MicroMsg.AppBrand.AppBrandOpenMaterialBottomSheet", "onDismiss");
      paramDialogInterface = a.a(this.nkC);
      if (paramDialogInterface != null)
      {
        paramDialogInterface.bQd();
        AppMethodBeat.o(229079);
        return;
      }
      AppMethodBeat.o(229079);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
  static final class g
    implements Runnable
  {
    g(a parama, r paramr, String paramString1, int paramInt, String paramString2) {}
    
    public final void run()
    {
      AppMethodBeat.i(229080);
      Log.i("MicroMsg.AppBrand.AppBrandOpenMaterialBottomSheet", "tryLaunchAppBrand, launch appBrand");
      Object localObject1 = this.nkL;
      Object localObject2 = a.f(this.nkC);
      com.tencent.mm.plugin.appbrand.api.g localg = new com.tencent.mm.plugin.appbrand.api.g();
      localg.appId = this.kPQ;
      localg.iOo = this.kQh;
      localg.kHw = this.mXY;
      localg.scene = 1173;
      String str1 = a.b(this.nkC).nlD.mimeType;
      p.g(str1, "openMaterialCollection.materialModel.mimeType");
      String str2 = a.b(this.nkC).nlD.nlI;
      p.g(str2, "openMaterialCollection.materialModel.materialPath");
      localg.kHx = ((com.tencent.mm.plugin.appbrand.api.d)new com.tencent.mm.plugin.appbrand.openmaterial.model.a(str1, str2));
      ((r)localObject1).a((Context)localObject2, localg);
      localObject1 = com.tencent.mm.plugin.appbrand.openmaterial.a.b.nlq;
      localObject1 = b.a.bQe();
      localObject2 = a.b(this.nkC).nlD;
      p.g(localObject2, "openMaterialCollection.materialModel");
      ((com.tencent.mm.plugin.appbrand.openmaterial.a.b)localObject1).c((MaterialModel)localObject2);
      AppMethodBeat.o(229080);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.openmaterial.a
 * JD-Core Version:    0.7.0.1
 */