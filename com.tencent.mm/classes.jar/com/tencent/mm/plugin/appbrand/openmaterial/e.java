package com.tencent.mm.plugin.appbrand.openmaterial;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.ng;
import com.tencent.mm.g.b.a.nz;
import com.tencent.mm.modelappbrand.a.b.h;
import com.tencent.mm.modelappbrand.a.b.k;
import com.tencent.mm.plugin.appbrand.openmaterial.a.b.a;
import com.tencent.mm.plugin.appbrand.openmaterial.model.AppBrandOpenMaterialCollection;
import com.tencent.mm.plugin.appbrand.openmaterial.model.AppBrandOpenMaterialModel;
import com.tencent.mm.plugin.appbrand.openmaterial.model.BaseAppBrandOpenMaterialModel;
import com.tencent.mm.plugin.appbrand.openmaterial.model.MaterialModel;
import com.tencent.mm.plugin.appbrand.service.r;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.base.m;
import com.tencent.mm.ui.base.o.a;
import com.tencent.mm.ui.base.o.b;
import com.tencent.mm.ui.base.o.c;
import com.tencent.mm.ui.base.o.g;
import com.tencent.mm.ui.base.o.h;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import kotlin.f;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.t;
import kotlin.x;

@kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/openmaterial/GridBottomSheetEnhanceLogic;", "Lcom/tencent/mm/plugin/appbrand/openmaterial/BottomSheetEnhanceLogic;", "openMaterialScene", "Lcom/tencent/mm/plugin/appbrand/openmaterial/model/AppBrandOpenMaterialScene;", "context", "Landroid/content/Context;", "bottomSheet", "Lcom/tencent/mm/ui/widget/dialog/MMBottomSheet;", "openMaterialCollection", "Lcom/tencent/mm/plugin/appbrand/openmaterial/model/AppBrandOpenMaterialCollection;", "openMaterialBottomSheet", "Lcom/tencent/mm/plugin/appbrand/openmaterial/IAppBrandOpenMaterialBottomSheet;", "launchAppBrandExecutor", "Lcom/tencent/mm/plugin/appbrand/openmaterial/ILaunchAppBrandExecutor;", "(Lcom/tencent/mm/plugin/appbrand/openmaterial/model/AppBrandOpenMaterialScene;Landroid/content/Context;Lcom/tencent/mm/ui/widget/dialog/MMBottomSheet;Lcom/tencent/mm/plugin/appbrand/openmaterial/model/AppBrandOpenMaterialCollection;Lcom/tencent/mm/plugin/appbrand/openmaterial/IAppBrandOpenMaterialBottomSheet;Lcom/tencent/mm/plugin/appbrand/openmaterial/ILaunchAppBrandExecutor;)V", "enhancedMenu", "Lcom/tencent/mm/ui/base/MMMenu;", "itemClickAction", "Lkotlin/Function1;", "Lcom/tencent/mm/plugin/appbrand/openmaterial/model/AppBrandOpenMaterialModel;", "", "getItemClickAction", "()Lkotlin/jvm/functions/Function1;", "itemClickAction$delegate", "Lkotlin/Lazy;", "convertOpenMaterialCollection2Menu", "convertOpenMaterialModel2MenuItem", "Lcom/tencent/mm/ui/base/MMMenuItem;", "index", "", "openMaterialModel", "enableEnhanceInteraction", "enable", "", "enableEnhanceInteractionInternal", "enhance", "isViewExposure", "view", "Landroid/view/View;", "wrapIconWithPadding", "Landroid/graphics/Bitmap;", "icon", "plugin-appbrand-integration_release"})
public final class e
  extends c
{
  private m nkQ;
  private final f nkR;
  
  public e(com.tencent.mm.plugin.appbrand.openmaterial.model.b paramb, final Context paramContext, com.tencent.mm.ui.widget.a.e parame, final AppBrandOpenMaterialCollection paramAppBrandOpenMaterialCollection, g paramg, final j paramj)
  {
    super(paramb, paramContext, parame, paramAppBrandOpenMaterialCollection, paramg, paramj);
    AppMethodBeat.i(229121);
    this.nkR = kotlin.g.ah((kotlin.g.a.a)new j(parame, paramj, paramContext, paramAppBrandOpenMaterialCollection));
    AppMethodBeat.o(229121);
  }
  
  private static Bitmap V(Bitmap paramBitmap)
  {
    AppMethodBeat.i(229119);
    int i = paramBitmap.getWidth();
    int j = i / 14;
    int k = j * 2 + i;
    Log.i("MicroMsg.AppBrand.GridBottomSheetEnhanceLogic", "wrapIconWithPadding, sideLen: " + i + ", padding: " + j + ", newSideLen: " + k);
    Bitmap localBitmap = Bitmap.createBitmap(k, k, paramBitmap.getConfig());
    new Canvas(localBitmap).drawBitmap(paramBitmap, j, j, null);
    p.g(localBitmap, "newIcon");
    AppMethodBeat.o(229119);
    return localBitmap;
  }
  
  private final void ie(boolean paramBoolean)
  {
    AppMethodBeat.i(229120);
    Object localObject = this.nkQ;
    if (localObject != null)
    {
      localObject = ((m)localObject).avn();
      if (localObject != null)
      {
        Iterator localIterator = ((Iterable)localObject).iterator();
        while (localIterator.hasNext())
        {
          MenuItem localMenuItem = (MenuItem)localIterator.next();
          localObject = localMenuItem;
          if (!(localMenuItem instanceof com.tencent.mm.ui.base.n)) {
            localObject = null;
          }
          localObject = (com.tencent.mm.ui.base.n)localObject;
          if (localObject != null)
          {
            if (!paramBoolean) {}
            for (boolean bool = true;; bool = false)
            {
              ((com.tencent.mm.ui.base.n)localObject).Bw(bool);
              break;
            }
          }
        }
      }
    }
    this.hOv.Dn(paramBoolean);
    d.a(this.hOv, this.context);
    AppMethodBeat.o(229120);
  }
  
  public final void bQc()
  {
    AppMethodBeat.i(229118);
    Log.d("MicroMsg.AppBrand.GridBottomSheetEnhanceLogic", "enhance");
    o.a locala = (o.a)e.i.nkY;
    com.tencent.mm.ui.widget.a.e locale = this.hOv;
    Log.d("MicroMsg.AppBrand.GridBottomSheetEnhanceLogic", "convertOpenMaterialCollection2Menu");
    m localm = new m(this.context);
    List localList = this.nkx.nlE;
    p.g(localList, "openMaterialCollection.appBrandOpenMaterialModels");
    int k = kotlin.k.j.na(localList.size(), 2147483647);
    int i = 0;
    if (i < k)
    {
      localObject1 = localList.get(i);
      p.g(localObject1, "myOpenMaterialModels[i]");
      final AppBrandOpenMaterialModel localAppBrandOpenMaterialModel = (AppBrandOpenMaterialModel)localObject1;
      Log.d("MicroMsg.AppBrand.GridBottomSheetEnhanceLogic", "convertOpenMaterialModel2MenuItem, index: " + i + ", openMaterialModel: " + localAppBrandOpenMaterialModel);
      final com.tencent.mm.ui.base.n localn = new com.tencent.mm.ui.base.n(this.context, i, 0);
      localObject1 = localAppBrandOpenMaterialModel.appName;
      Object localObject2 = (CharSequence)localObject1;
      int j;
      if ((localObject2 == null) || (((CharSequence)localObject2).length() == 0))
      {
        j = 1;
        label191:
        if (j == 0) {
          break label430;
        }
        localObject1 = localAppBrandOpenMaterialModel.nlH;
        p.g(localObject1, "functionName");
        localObject1 = new l((String)localObject1, null, 6);
      }
      for (;;)
      {
        Log.i("MicroMsg.AppBrand.GridBottomSheetEnhanceLogic", "convertOpenMaterialModel2MenuItem, functionName: " + localAppBrandOpenMaterialModel.nlH + ", rawFunctionName2Show: " + localObject1);
        localn.a((ContextMenu.ContextMenuInfo)localObject1);
        localObject1 = localAppBrandOpenMaterialModel.iconUrl;
        localObject2 = com.tencent.mm.modelappbrand.a.a.aXX();
        if ((localObject2 instanceof android.support.v4.graphics.drawable.b))
        {
          localObject2 = ((android.support.v4.graphics.drawable.b)localObject2).getBitmap();
          if (localObject2 != null)
          {
            p.g(localObject2, "it");
            localn.f((Drawable)new BitmapDrawable(V((Bitmap)localObject2)), 0);
          }
        }
        if (localObject1 != null) {
          com.tencent.mm.modelappbrand.a.b.aXY().a((b.k)new a(this, localn), (String)localObject1, (b.h)com.tencent.mm.modelappbrand.a.g.iJB, null);
        }
        localn.setOnMenuItemClickListener((MenuItem.OnMenuItemClickListener)new b(this, localAppBrandOpenMaterialModel));
        localn.a((o.h)new c(this, localAppBrandOpenMaterialModel));
        localm.g((MenuItem)localn);
        i += 1;
        break;
        j = 0;
        break label191;
        label430:
        localObject2 = localAppBrandOpenMaterialModel.nlH;
        p.g(localObject2, "functionName");
        j = kotlin.n.n.a((CharSequence)localObject2, (String)localObject1, 0, false, 6);
        if (-1 == j)
        {
          localObject1 = localAppBrandOpenMaterialModel.nlH;
          p.g(localObject1, "functionName");
          localObject1 = new l((String)localObject1, null, 6);
        }
        else
        {
          int m = ((String)localObject1).length() + j;
          if (m == localAppBrandOpenMaterialModel.nlH.length())
          {
            if (j != 0)
            {
              localObject2 = localAppBrandOpenMaterialModel.nlH;
              p.g(localObject2, "functionName");
              if (localObject2 == null)
              {
                localObject1 = new t("null cannot be cast to non-null type java.lang.String");
                AppMethodBeat.o(229118);
                throw ((Throwable)localObject1);
              }
              localObject2 = ((String)localObject2).substring(0, j);
              p.g(localObject2, "(this as java.lang.Strin…ing(startIndex, endIndex)");
              localObject1 = new l((String)localObject2, (String)localObject1, 4);
            }
          }
          else
          {
            localObject1 = localAppBrandOpenMaterialModel.nlH;
            p.g(localObject1, "functionName");
            if (localObject1 == null)
            {
              localObject1 = new t("null cannot be cast to non-null type java.lang.String");
              AppMethodBeat.o(229118);
              throw ((Throwable)localObject1);
            }
            localObject1 = ((String)localObject1).substring(0, m);
            p.g(localObject1, "(this as java.lang.Strin…ing(startIndex, endIndex)");
            localObject2 = localAppBrandOpenMaterialModel.nlH;
            p.g(localObject2, "functionName");
            if (localObject2 == null)
            {
              localObject1 = new t("null cannot be cast to non-null type java.lang.String");
              AppMethodBeat.o(229118);
              throw ((Throwable)localObject1);
            }
            localObject2 = ((String)localObject2).substring(m);
            p.g(localObject2, "(this as java.lang.String).substring(startIndex)");
            localObject1 = new l((String)localObject1, (String)localObject2, true);
            continue;
          }
          localObject1 = localAppBrandOpenMaterialModel.nlH;
          p.g(localObject1, "functionName");
          localObject1 = new l((String)localObject1, null, 6);
        }
      }
    }
    this.nkQ = localm;
    locale.a(localm, (o.g)e.d.nkV, (o.c)e.e.nkW);
    this.hOv.a(locala);
    Object localObject1 = this.nkx.nlF;
    p.g(localObject1, "openMaterialCollection.a…dOpenMaterialDetailModels");
    if (!((Collection)localObject1).isEmpty()) {}
    for (i = 1;; i = 0)
    {
      if (i != 0) {
        this.hOv.a((com.tencent.mm.ui.widget.a.e.e)new f(this), this.context.getString(2131755575), (o.b)e.g.nkX, locala, (o.h)new h(this));
      }
      ie(this.nkN);
      d.a(this.hOv, this.context);
      AppMethodBeat.o(229118);
      return;
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/appbrand/openmaterial/GridBottomSheetEnhanceLogic$convertOpenMaterialModel2MenuItem$2", "Lcom/tencent/mm/modelappbrand/image/AppBrandSimpleImageLoader$ILoadTarget;", "beforeLoadBitmap", "", "key", "", "kotlin.jvm.PlatformType", "onBitmapLoaded", "bitmap", "Landroid/graphics/Bitmap;", "onLoadFailed", "plugin-appbrand-integration_release"})
  public static final class a
    implements b.k
  {
    a(com.tencent.mm.ui.base.n paramn) {}
    
    public final void I(Bitmap paramBitmap)
    {
      AppMethodBeat.i(229101);
      Log.d("MicroMsg.AppBrand.GridBottomSheetEnhanceLogic", "onBitmapLoaded");
      if (paramBitmap == null)
      {
        Log.w("MicroMsg.AppBrand.GridBottomSheetEnhanceLogic", "onBitmapLoaded, bitmap is null");
        AppMethodBeat.o(229101);
        return;
      }
      localn.f((Drawable)new BitmapDrawable(e.W(paramBitmap)), 0);
      AppMethodBeat.o(229101);
    }
    
    public final String Lb()
    {
      AppMethodBeat.i(229099);
      String str = com.tencent.mm.plugin.appbrand.ac.n.cO(this);
      AppMethodBeat.o(229099);
      return str;
    }
    
    public final void aYg()
    {
      AppMethodBeat.i(229102);
      Log.d("MicroMsg.AppBrand.GridBottomSheetEnhanceLogic", "beforeLoadBitmap");
      AppMethodBeat.o(229102);
    }
    
    public final void oD()
    {
      AppMethodBeat.i(229100);
      Log.d("MicroMsg.AppBrand.GridBottomSheetEnhanceLogic", "onLoadFailed");
      AppMethodBeat.o(229100);
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
  static final class b
    implements MenuItem.OnMenuItemClickListener
  {
    b(e parame, AppBrandOpenMaterialModel paramAppBrandOpenMaterialModel) {}
    
    public final boolean onMenuItemClick(MenuItem paramMenuItem)
    {
      AppMethodBeat.i(229103);
      if (!this.nkS.nkN)
      {
        AppMethodBeat.o(229103);
        return false;
      }
      Object localObject = this.nkS.nkz;
      paramMenuItem = localAppBrandOpenMaterialModel;
      p.h(paramMenuItem, "openMaterialModel");
      Log.i(((com.tencent.mm.plugin.appbrand.openmaterial.b.a)localObject).bQh(), "onBottomSheetAppBrandClick");
      long l = ((com.tencent.mm.plugin.appbrand.openmaterial.b.a)localObject).nkx.nlE.indexOf(paramMenuItem) + 1;
      Log.d(((com.tencent.mm.plugin.appbrand.openmaterial.b.a)localObject).bQh(), "onBottomSheetAppBrandClick, index: ".concat(String.valueOf(l)));
      ng localng = ((com.tencent.mm.plugin.appbrand.openmaterial.b.a)localObject).bQi().xE(6L).xF(com.tencent.mm.plugin.appbrand.openmaterial.b.a.d(((com.tencent.mm.plugin.appbrand.openmaterial.b.a)localObject).nkA)).xG(((com.tencent.mm.plugin.appbrand.openmaterial.b.a)localObject).bQk()).xH(l).Ar(paramMenuItem.appId);
      localObject = paramMenuItem.appName;
      paramMenuItem = (MenuItem)localObject;
      if (localObject == null) {
        paramMenuItem = "";
      }
      localng.As(paramMenuItem).bfK();
      e.a(this.nkS).invoke(localAppBrandOpenMaterialModel);
      AppMethodBeat.o(229103);
      return true;
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "<anonymous parameter 0>", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "menuView", "Landroid/view/View;", "onMMMenuItemVisible"})
  static final class c
    implements o.h
  {
    c(e parame, AppBrandOpenMaterialModel paramAppBrandOpenMaterialModel) {}
    
    public final void cy(View paramView)
    {
      AppMethodBeat.i(229104);
      p.g(paramView, "menuView");
      if (e.cx(paramView))
      {
        com.tencent.mm.plugin.appbrand.openmaterial.b.a locala = this.nkS.nkz;
        AppBrandOpenMaterialModel localAppBrandOpenMaterialModel = localAppBrandOpenMaterialModel;
        p.h(localAppBrandOpenMaterialModel, "openMaterialModel");
        Log.i(locala.bQh(), "onBottomSheetAppBrandExposure");
        if (!locala.nlZ.contains(localAppBrandOpenMaterialModel))
        {
          nz localnz = locala.bQj().yv(1L).Bi(localAppBrandOpenMaterialModel.appId);
          String str = localAppBrandOpenMaterialModel.appName;
          paramView = str;
          if (str == null) {
            paramView = "";
          }
          localnz.Bj(paramView).bfK();
          locala.nlZ.add(localAppBrandOpenMaterialModel);
        }
      }
      AppMethodBeat.o(229104);
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "onClick"})
  static final class f
    implements com.tencent.mm.ui.widget.a.e.e
  {
    f(e parame) {}
    
    public final void onClick()
    {
      AppMethodBeat.i(229109);
      Log.i("MicroMsg.AppBrand.GridBottomSheetEnhanceLogic", "onClick");
      if (!this.nkS.nkN)
      {
        AppMethodBeat.o(229109);
        return;
      }
      this.nkS.nkz.bQl();
      this.nkS.hOv.bMo();
      this.nkS.bQb().show();
      AppMethodBeat.o(229109);
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "<anonymous parameter 0>", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "menuView", "Landroid/view/View;", "onMMMenuItemVisible"})
  static final class h
    implements o.h
  {
    h(e parame) {}
    
    public final void cy(View paramView)
    {
      AppMethodBeat.i(229112);
      p.g(paramView, "menuView");
      if (e.cx(paramView))
      {
        paramView = this.nkS.nkz;
        Log.i(paramView.bQh(), "onBottomSheetListPageEntranceExposure");
        if (!paramView.nmb)
        {
          paramView.bQi().xE(2L).xF(com.tencent.mm.plugin.appbrand.openmaterial.b.a.d(paramView.nkA)).xG(paramView.bQk()).xH(0L).bfK();
          paramView.nmb = true;
        }
      }
      AppMethodBeat.o(229112);
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "Lkotlin/Function1;", "Lcom/tencent/mm/plugin/appbrand/openmaterial/model/BaseAppBrandOpenMaterialModel;", "", "invoke"})
  static final class j
    extends q
    implements kotlin.g.a.a<kotlin.g.a.b<? super BaseAppBrandOpenMaterialModel, ? extends x>>
  {
    j(com.tencent.mm.ui.widget.a.e parame, j paramj, Context paramContext, AppBrandOpenMaterialCollection paramAppBrandOpenMaterialCollection)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.openmaterial.e
 * JD-Core Version:    0.7.0.1
 */