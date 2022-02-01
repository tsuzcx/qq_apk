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
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.b.a.qf;
import com.tencent.mm.f.b.a.ra;
import com.tencent.mm.modelappbrand.a.b.h;
import com.tencent.mm.modelappbrand.a.b.k;
import com.tencent.mm.plugin.appbrand.au.e;
import com.tencent.mm.plugin.appbrand.au.h;
import com.tencent.mm.plugin.appbrand.au.i;
import com.tencent.mm.plugin.appbrand.openmaterial.model.AppBrandOpenMaterialCollection;
import com.tencent.mm.plugin.appbrand.openmaterial.model.AppBrandOpenMaterialModel;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.ar;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.base.q.a;
import com.tencent.mm.ui.base.q.b;
import com.tencent.mm.ui.base.q.c;
import com.tencent.mm.ui.base.q.g;
import com.tencent.mm.ui.base.q.h;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import kotlin.f;
import kotlin.k.i;
import kotlin.t;

@kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/openmaterial/GridBottomSheetEnhanceLogic;", "Lcom/tencent/mm/plugin/appbrand/openmaterial/BottomSheetEnhanceLogic;", "openMaterialScene", "Lcom/tencent/mm/plugin/appbrand/openmaterial/model/AppBrandOpenMaterialScene;", "context", "Landroid/content/Context;", "bottomSheet", "Lcom/tencent/mm/ui/widget/dialog/MMBottomSheet;", "openMaterialCollection", "Lcom/tencent/mm/plugin/appbrand/openmaterial/model/AppBrandOpenMaterialCollection;", "openMaterialBottomSheet", "Lcom/tencent/mm/plugin/appbrand/openmaterial/IAppBrandOpenMaterialBottomSheet;", "launchAppBrandExecutor", "Lcom/tencent/mm/plugin/appbrand/openmaterial/ILaunchAppBrandExecutor;", "(Lcom/tencent/mm/plugin/appbrand/openmaterial/model/AppBrandOpenMaterialScene;Landroid/content/Context;Lcom/tencent/mm/ui/widget/dialog/MMBottomSheet;Lcom/tencent/mm/plugin/appbrand/openmaterial/model/AppBrandOpenMaterialCollection;Lcom/tencent/mm/plugin/appbrand/openmaterial/IAppBrandOpenMaterialBottomSheet;Lcom/tencent/mm/plugin/appbrand/openmaterial/ILaunchAppBrandExecutor;)V", "curEnhanceState", "Lcom/tencent/mm/plugin/appbrand/openmaterial/GridBottomSheetEnhanceLogic$EnhanceState;", "enhancedMenu", "Lcom/tencent/mm/ui/base/MMMenu;", "itemClickAction", "Lkotlin/Function1;", "Lcom/tencent/mm/plugin/appbrand/openmaterial/model/AppBrandOpenMaterialModel;", "", "getItemClickAction", "()Lkotlin/jvm/functions/Function1;", "itemClickAction$delegate", "Lkotlin/Lazy;", "convertOpenMaterialCollection2Menu", "convertOpenMaterialModel2MenuItem", "Lcom/tencent/mm/ui/base/MMMenuItem;", "index", "", "openMaterialModel", "enhance", "newEnhanceType", "Lcom/tencent/mm/plugin/appbrand/openmaterial/IEnhanceBottomSheetController$EnhanceType;", "enable", "", "enhanceInner", "enhanceQuick", "isViewExposure", "view", "Landroid/view/View;", "revokeEnhance", "wrapIconWithPadding", "Landroid/graphics/Bitmap;", "icon", "Companion", "EnhanceState", "plugin-appbrand-integration_release"})
public final class e
  extends c
{
  public static final e.a qmr;
  private e.b qmo;
  private o qmp;
  private final f qmq;
  
  static
  {
    AppMethodBeat.i(245561);
    qmr = new e.a((byte)0);
    AppMethodBeat.o(245561);
  }
  
  public e(com.tencent.mm.plugin.appbrand.openmaterial.model.b paramb, Context paramContext, com.tencent.mm.ui.widget.a.e parame, AppBrandOpenMaterialCollection paramAppBrandOpenMaterialCollection, h paramh, l paraml)
  {
    super(paramb, paramContext, parame, paramAppBrandOpenMaterialCollection, paramh, paraml);
    AppMethodBeat.i(245559);
    this.qmo = new e.b(j.a.qmO, true);
    this.qmq = kotlin.g.ar((kotlin.g.a.a)new e.l(parame, paraml, paramContext, paramAppBrandOpenMaterialCollection));
    AppMethodBeat.o(245559);
  }
  
  private static Bitmap T(Bitmap paramBitmap)
  {
    AppMethodBeat.i(245556);
    int i = paramBitmap.getWidth();
    int j = i / 14;
    int k = j * 2 + i;
    Log.i("MicroMsg.AppBrand.GridBottomSheetEnhanceLogic", "wrapIconWithPadding, sideLen: " + i + ", padding: " + j + ", newSideLen: " + k);
    Bitmap localBitmap = Bitmap.createBitmap(k, k, paramBitmap.getConfig());
    new Canvas(localBitmap).drawBitmap(paramBitmap, j, j, null);
    kotlin.g.b.p.j(localBitmap, "newIcon");
    AppMethodBeat.o(245556);
    return localBitmap;
  }
  
  private final o ccO()
  {
    AppMethodBeat.i(245554);
    Log.d("MicroMsg.AppBrand.GridBottomSheetEnhanceLogic", "convertOpenMaterialCollection2Menu");
    o localo = new o(getContext());
    List localList = ccN().qnh;
    kotlin.g.b.p.j(localList, "openMaterialCollection.appBrandOpenMaterialModels");
    int k = i.ow(localList.size(), 2147483647);
    int i = 0;
    if (i < k)
    {
      Object localObject1 = localList.get(i);
      kotlin.g.b.p.j(localObject1, "myOpenMaterialModels[i]");
      final AppBrandOpenMaterialModel localAppBrandOpenMaterialModel = (AppBrandOpenMaterialModel)localObject1;
      Log.d("MicroMsg.AppBrand.GridBottomSheetEnhanceLogic", "convertOpenMaterialModel2MenuItem, index: " + i + ", openMaterialModel: " + localAppBrandOpenMaterialModel);
      final com.tencent.mm.ui.base.p localp = new com.tencent.mm.ui.base.p(getContext(), i, 0);
      localObject1 = localAppBrandOpenMaterialModel.appName;
      Object localObject2 = (CharSequence)localObject1;
      int j;
      if ((localObject2 == null) || (((CharSequence)localObject2).length() == 0))
      {
        j = 1;
        label168:
        if (j == 0) {
          break label407;
        }
        localObject1 = localAppBrandOpenMaterialModel.qnk;
        kotlin.g.b.p.j(localObject1, "functionName");
        localObject1 = new n((String)localObject1, null, 6);
      }
      for (;;)
      {
        Log.i("MicroMsg.AppBrand.GridBottomSheetEnhanceLogic", "convertOpenMaterialModel2MenuItem, functionName: " + localAppBrandOpenMaterialModel.qnk + ", rawFunctionName2Show: " + localObject1);
        localp.a((ContextMenu.ContextMenuInfo)localObject1);
        localObject1 = localAppBrandOpenMaterialModel.iconUrl;
        localObject2 = com.tencent.mm.modelappbrand.a.a.bhg();
        if ((localObject2 instanceof androidx.core.graphics.drawable.b))
        {
          localObject2 = ((androidx.core.graphics.drawable.b)localObject2).getBitmap();
          if (localObject2 != null)
          {
            kotlin.g.b.p.j(localObject2, "it");
            localp.f((Drawable)new BitmapDrawable(T((Bitmap)localObject2)), 0);
          }
        }
        if (localObject1 != null) {
          com.tencent.mm.modelappbrand.a.b.bhh().a((b.k)new c(this, localp), (String)localObject1, (b.h)com.tencent.mm.modelappbrand.a.g.lzF, null);
        }
        localp.setOnMenuItemClickListener((MenuItem.OnMenuItemClickListener)new d(this, localAppBrandOpenMaterialModel));
        localp.a((q.h)new e(this, localAppBrandOpenMaterialModel));
        localo.h((MenuItem)localp);
        i += 1;
        break;
        j = 0;
        break label168;
        label407:
        localObject2 = localAppBrandOpenMaterialModel.qnk;
        kotlin.g.b.p.j(localObject2, "functionName");
        j = kotlin.n.n.a((CharSequence)localObject2, (String)localObject1, 0, false, 6);
        if (-1 == j)
        {
          localObject1 = localAppBrandOpenMaterialModel.qnk;
          kotlin.g.b.p.j(localObject1, "functionName");
          localObject1 = new n((String)localObject1, null, 6);
        }
        else
        {
          int m = ((String)localObject1).length() + j;
          if (m == localAppBrandOpenMaterialModel.qnk.length())
          {
            if (j != 0)
            {
              localObject2 = localAppBrandOpenMaterialModel.qnk;
              kotlin.g.b.p.j(localObject2, "functionName");
              if (localObject2 == null)
              {
                localObject1 = new t("null cannot be cast to non-null type java.lang.String");
                AppMethodBeat.o(245554);
                throw ((Throwable)localObject1);
              }
              localObject2 = ((String)localObject2).substring(0, j);
              kotlin.g.b.p.j(localObject2, "(this as java.lang.Strin…ing(startIndex, endIndex)");
              localObject1 = new n((String)localObject2, (String)localObject1, 4);
            }
          }
          else
          {
            localObject1 = localAppBrandOpenMaterialModel.qnk;
            kotlin.g.b.p.j(localObject1, "functionName");
            if (localObject1 == null)
            {
              localObject1 = new t("null cannot be cast to non-null type java.lang.String");
              AppMethodBeat.o(245554);
              throw ((Throwable)localObject1);
            }
            localObject1 = ((String)localObject1).substring(0, m);
            kotlin.g.b.p.j(localObject1, "(this as java.lang.Strin…ing(startIndex, endIndex)");
            localObject2 = localAppBrandOpenMaterialModel.qnk;
            kotlin.g.b.p.j(localObject2, "functionName");
            if (localObject2 == null)
            {
              localObject1 = new t("null cannot be cast to non-null type java.lang.String");
              AppMethodBeat.o(245554);
              throw ((Throwable)localObject1);
            }
            localObject2 = ((String)localObject2).substring(m);
            kotlin.g.b.p.j(localObject2, "(this as java.lang.String).substring(startIndex)");
            localObject1 = new n((String)localObject1, (String)localObject2, true);
            continue;
          }
          localObject1 = localAppBrandOpenMaterialModel.qnk;
          kotlin.g.b.p.j(localObject1, "functionName");
          localObject1 = new n((String)localObject1, null, 6);
        }
      }
    }
    this.qmp = localo;
    AppMethodBeat.o(245554);
    return localo;
  }
  
  private final void iZ(boolean paramBoolean)
  {
    AppMethodBeat.i(245544);
    Log.d("MicroMsg.AppBrand.GridBottomSheetEnhanceLogic", "enhance, enable: ".concat(String.valueOf(paramBoolean)));
    if (this.qmo.qmt)
    {
      ja(paramBoolean);
      if (!paramBoolean) {
        break label72;
      }
    }
    label72:
    for (j.a locala = j.a.qmM;; locala = j.a.qmN)
    {
      this.qmo = new e.b(locala, false);
      AppMethodBeat.o(245544);
      return;
      jb(paramBoolean);
      break;
    }
  }
  
  private final void ja(boolean paramBoolean)
  {
    AppMethodBeat.i(245546);
    Log.d("MicroMsg.AppBrand.GridBottomSheetEnhanceLogic", "enhance, enable: ".concat(String.valueOf(paramBoolean)));
    q.a locala = (q.a)k.qmA;
    this.kCR.a(ccO(), (q.g)e.f.qmx, (q.c)e.g.qmy);
    this.kCR.a(locala);
    List localList = ccN().qni;
    kotlin.g.b.p.j(localList, "openMaterialCollection.a…dOpenMaterialDetailModels");
    if (!((Collection)localList).isEmpty()) {}
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        this.kCR.a((com.tencent.mm.ui.widget.a.e.e)new h(this), getContext().getString(au.i.app_brand_open_material_more_2), (q.b)i.qmz, locala, (q.h)new j(this));
      }
      jb(paramBoolean);
      AppMethodBeat.o(245546);
      return;
    }
  }
  
  private final void jb(boolean paramBoolean)
  {
    AppMethodBeat.i(245549);
    Object localObject = this.qmp;
    if (localObject != null)
    {
      localObject = ((o)localObject).aCj();
      if (localObject != null)
      {
        Iterator localIterator = ((Iterable)localObject).iterator();
        while (localIterator.hasNext())
        {
          MenuItem localMenuItem = (MenuItem)localIterator.next();
          localObject = localMenuItem;
          if (!(localMenuItem instanceof com.tencent.mm.ui.base.p)) {
            localObject = null;
          }
          localObject = (com.tencent.mm.ui.base.p)localObject;
          if (localObject != null)
          {
            if (!paramBoolean) {}
            for (boolean bool = true;; bool = false)
            {
              ((com.tencent.mm.ui.base.p)localObject).FO(bool);
              break;
            }
          }
        }
      }
    }
    this.kCR.HI(paramBoolean);
    AppMethodBeat.o(245549);
  }
  
  public final void a(j.a parama)
  {
    AppMethodBeat.i(245542);
    kotlin.g.b.p.k(parama, "newEnhanceType");
    Log.i("MicroMsg.AppBrand.GridBottomSheetEnhanceLogic", "enhance, newEnhanceType: " + parama + ", curEnhanceState: " + this.qmo);
    if (this.qmo.qms == parama)
    {
      AppMethodBeat.o(245542);
      return;
    }
    switch (f.$EnumSwitchMapping$0[parama.ordinal()])
    {
    }
    for (;;)
    {
      if (this.kCR.isShowing()) {
        d.a(this.kCR, getContext());
      }
      AppMethodBeat.o(245542);
      return;
      iZ(true);
      continue;
      iZ(false);
      continue;
      Log.d("MicroMsg.AppBrand.GridBottomSheetEnhanceLogic", "revokeEnhance");
      this.kCR.a(new o(getContext()), null, null);
      this.kCR.a(null);
      this.kCR.a((com.tencent.mm.ui.widget.a.e.e)e.m.qmH);
      this.kCR.HI(false);
      this.qmo = new e.b(j.a.qmO, true);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/appbrand/openmaterial/GridBottomSheetEnhanceLogic$convertOpenMaterialModel2MenuItem$2", "Lcom/tencent/mm/modelappbrand/image/AppBrandSimpleImageLoader$ILoadTarget;", "beforeLoadBitmap", "", "key", "", "kotlin.jvm.PlatformType", "onBitmapLoaded", "bitmap", "Landroid/graphics/Bitmap;", "onLoadFailed", "plugin-appbrand-integration_release"})
  public static final class c
    implements b.k
  {
    c(com.tencent.mm.ui.base.p paramp) {}
    
    public final void G(Bitmap paramBitmap)
    {
      AppMethodBeat.i(266911);
      Log.d("MicroMsg.AppBrand.GridBottomSheetEnhanceLogic", "onBitmapLoaded");
      if (paramBitmap == null)
      {
        Log.w("MicroMsg.AppBrand.GridBottomSheetEnhanceLogic", "onBitmapLoaded, bitmap is null");
        AppMethodBeat.o(266911);
        return;
      }
      localp.f((Drawable)new BitmapDrawable(e.U(paramBitmap)), 0);
      AppMethodBeat.o(266911);
    }
    
    public final void bhq()
    {
      AppMethodBeat.i(266912);
      Log.d("MicroMsg.AppBrand.GridBottomSheetEnhanceLogic", "beforeLoadBitmap");
      AppMethodBeat.o(266912);
    }
    
    public final void bhr()
    {
      AppMethodBeat.i(266910);
      Log.d("MicroMsg.AppBrand.GridBottomSheetEnhanceLogic", "onLoadFailed");
      AppMethodBeat.o(266910);
    }
    
    public final String key()
    {
      AppMethodBeat.i(266908);
      String str = com.tencent.mm.plugin.appbrand.ac.n.cP(this);
      AppMethodBeat.o(266908);
      return str;
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
  static final class d
    implements MenuItem.OnMenuItemClickListener
  {
    d(e parame, AppBrandOpenMaterialModel paramAppBrandOpenMaterialModel) {}
    
    public final boolean onMenuItemClick(MenuItem paramMenuItem)
    {
      AppMethodBeat.i(270745);
      if (j.a.qmM != e.a(this.qmu).qms)
      {
        AppMethodBeat.o(270745);
        return false;
      }
      Object localObject = this.qmu.qml;
      paramMenuItem = localAppBrandOpenMaterialModel;
      kotlin.g.b.p.k(paramMenuItem, "openMaterialModel");
      Log.i(((com.tencent.mm.plugin.appbrand.openmaterial.b.a)localObject).bqj, "onBottomSheetAppBrandClick");
      long l = ((com.tencent.mm.plugin.appbrand.openmaterial.b.a)localObject).qnG.qnh.indexOf(paramMenuItem) + 1;
      Log.d(((com.tencent.mm.plugin.appbrand.openmaterial.b.a)localObject).bqj, "onBottomSheetAppBrandClick, index: ".concat(String.valueOf(l)));
      qf localqf = ((com.tencent.mm.plugin.appbrand.openmaterial.b.a)localObject).ccX().Hb(((com.tencent.mm.plugin.appbrand.openmaterial.b.a)localObject).gfl).DE(6L).DF(com.tencent.mm.plugin.appbrand.openmaterial.b.a.d(((com.tencent.mm.plugin.appbrand.openmaterial.b.a)localObject).qnF)).DG(((com.tencent.mm.plugin.appbrand.openmaterial.b.a)localObject).ccZ()).DH(l).Hc(paramMenuItem.appId);
      localObject = paramMenuItem.appName;
      paramMenuItem = (MenuItem)localObject;
      if (localObject == null) {
        paramMenuItem = "";
      }
      localqf.Hd(paramMenuItem).bpa();
      e.b(this.qmu).invoke(localAppBrandOpenMaterialModel);
      AppMethodBeat.o(270745);
      return true;
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "<anonymous parameter 0>", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "menuView", "Landroid/view/View;", "onMMMenuItemVisible"})
  static final class e
    implements q.h
  {
    e(e parame, AppBrandOpenMaterialModel paramAppBrandOpenMaterialModel) {}
    
    public final void cR(View paramView)
    {
      AppMethodBeat.i(275054);
      kotlin.g.b.p.j(paramView, "menuView");
      if (e.cQ(paramView))
      {
        com.tencent.mm.plugin.appbrand.openmaterial.b.a locala = this.qmu.qml;
        AppBrandOpenMaterialModel localAppBrandOpenMaterialModel = localAppBrandOpenMaterialModel;
        kotlin.g.b.p.k(localAppBrandOpenMaterialModel, "openMaterialModel");
        Log.i(locala.bqj, "onBottomSheetAppBrandExposure");
        if (!locala.qnC.contains(localAppBrandOpenMaterialModel))
        {
          ra localra = locala.ccY().HU(locala.gfl).Ew(1L).HV(localAppBrandOpenMaterialModel.appId);
          String str = localAppBrandOpenMaterialModel.appName;
          paramView = str;
          if (str == null) {
            paramView = "";
          }
          localra.HW(paramView).bpa();
          locala.qnC.add(localAppBrandOpenMaterialModel);
        }
      }
      AppMethodBeat.o(275054);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "onClick"})
  static final class h
    implements com.tencent.mm.ui.widget.a.e.e
  {
    h(e parame) {}
    
    public final void onClick()
    {
      AppMethodBeat.i(271721);
      Log.i("MicroMsg.AppBrand.GridBottomSheetEnhanceLogic", "onClick");
      if (j.a.qmM != e.a(this.qmu).qms)
      {
        AppMethodBeat.o(271721);
        return;
      }
      this.qmu.kCR.bYF();
      this.qmu.ccM().show();
      AppMethodBeat.o(271721);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "imageView", "Landroid/widget/ImageView;", "kotlin.jvm.PlatformType", "<anonymous parameter 1>", "Landroid/view/MenuItem;", "onAttach"})
  static final class i
    implements q.b
  {
    public static final i qmz;
    
    static
    {
      AppMethodBeat.i(257961);
      qmz = new i();
      AppMethodBeat.o(257961);
    }
    
    public final void a(ImageView paramImageView, MenuItem paramMenuItem)
    {
      AppMethodBeat.i(257960);
      Log.d("MicroMsg.AppBrand.GridBottomSheetEnhanceLogic", "onAttach#iconCreator");
      if (ar.isDarkMode()) {}
      for (int i = au.h.app_brand_open_material_filled_more_night;; i = au.h.app_brand_open_material_filled_more_normal)
      {
        paramImageView.setImageResource(i);
        AppMethodBeat.o(257960);
        return;
      }
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "<anonymous parameter 0>", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "menuView", "Landroid/view/View;", "onMMMenuItemVisible"})
  static final class j
    implements q.h
  {
    j(e parame) {}
    
    public final void cR(View paramView)
    {
      AppMethodBeat.i(271331);
      kotlin.g.b.p.j(paramView, "menuView");
      if (e.cQ(paramView)) {
        this.qmu.qml.ccU();
      }
      AppMethodBeat.o(271331);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "imageView", "Landroid/widget/ImageView;", "kotlin.jvm.PlatformType", "<anonymous parameter 1>", "Landroid/view/MenuItem;", "onAttach"})
  static final class k
    implements q.a
  {
    public static final k qmA;
    
    static
    {
      AppMethodBeat.i(279887);
      qmA = new k();
      AppMethodBeat.o(279887);
    }
    
    public final void e(ImageView paramImageView)
    {
      AppMethodBeat.i(279886);
      Log.d("MicroMsg.AppBrand.GridBottomSheetEnhanceLogic", "onAttach#iconBadgeCreator");
      paramImageView.setBackgroundResource(au.e.app_brand_open_material_badge_bg);
      paramImageView.setImageResource(au.h.app_brand_open_material_badge_icon);
      AppMethodBeat.o(279886);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.openmaterial.e
 * JD-Core Version:    0.7.0.1
 */