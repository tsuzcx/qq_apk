package com.tencent.mm.plugin.appbrand.openmaterial;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.mmdata.rpt.ty;
import com.tencent.mm.autogen.mmdata.rpt.ux;
import com.tencent.mm.modelappbrand.a.b.h;
import com.tencent.mm.modelappbrand.a.b.k;
import com.tencent.mm.plugin.appbrand.ba.e;
import com.tencent.mm.plugin.appbrand.ba.h;
import com.tencent.mm.plugin.appbrand.ba.i;
import com.tencent.mm.plugin.appbrand.openmaterial.a.b.a;
import com.tencent.mm.plugin.appbrand.openmaterial.model.AppBrandOpenMaterialCollection;
import com.tencent.mm.plugin.appbrand.openmaterial.model.AppBrandOpenMaterialModel;
import com.tencent.mm.plugin.appbrand.openmaterial.model.BaseAppBrandOpenMaterialModel;
import com.tencent.mm.plugin.appbrand.openmaterial.model.MaterialModel;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.aw;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.u;
import kotlin.j;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/openmaterial/GridBottomSheetEnhanceLogic;", "Lcom/tencent/mm/plugin/appbrand/openmaterial/BottomSheetEnhanceLogic;", "openMaterialScene", "Lcom/tencent/mm/plugin/appbrand/openmaterial/model/AppBrandOpenMaterialScene;", "context", "Landroid/content/Context;", "bottomSheet", "Lcom/tencent/mm/ui/widget/dialog/MMBottomSheet;", "openMaterialCollection", "Lcom/tencent/mm/plugin/appbrand/openmaterial/model/AppBrandOpenMaterialCollection;", "openMaterialBottomSheet", "Lcom/tencent/mm/plugin/appbrand/openmaterial/IAppBrandOpenMaterialBottomSheet;", "launchAppBrandExecutor", "Lcom/tencent/mm/plugin/appbrand/openmaterial/ILaunchAppBrandExecutor;", "(Lcom/tencent/mm/plugin/appbrand/openmaterial/model/AppBrandOpenMaterialScene;Landroid/content/Context;Lcom/tencent/mm/ui/widget/dialog/MMBottomSheet;Lcom/tencent/mm/plugin/appbrand/openmaterial/model/AppBrandOpenMaterialCollection;Lcom/tencent/mm/plugin/appbrand/openmaterial/IAppBrandOpenMaterialBottomSheet;Lcom/tencent/mm/plugin/appbrand/openmaterial/ILaunchAppBrandExecutor;)V", "curEnhanceState", "Lcom/tencent/mm/plugin/appbrand/openmaterial/GridBottomSheetEnhanceLogic$EnhanceState;", "enhancedMenu", "Lcom/tencent/mm/ui/base/MMMenu;", "itemClickAction", "Lkotlin/Function1;", "Lcom/tencent/mm/plugin/appbrand/openmaterial/model/AppBrandOpenMaterialModel;", "", "getItemClickAction", "()Lkotlin/jvm/functions/Function1;", "itemClickAction$delegate", "Lkotlin/Lazy;", "convertOpenMaterialCollection2Menu", "convertOpenMaterialModel2MenuItem", "Lcom/tencent/mm/ui/base/MMMenuItem;", "index", "", "openMaterialModel", "enhance", "newEnhanceType", "Lcom/tencent/mm/plugin/appbrand/openmaterial/IEnhanceBottomSheetController$EnhanceType;", "enable", "", "enhanceInner", "enhanceQuick", "isViewExposure", "view", "Landroid/view/View;", "revokeEnhance", "wrapIconWithPadding", "Landroid/graphics/Bitmap;", "icon", "Companion", "EnhanceState", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class e
  extends c
{
  public static final a tri;
  private e.b trj;
  private com.tencent.mm.ui.base.s trk;
  private final j trl;
  
  static
  {
    AppMethodBeat.i(323719);
    tri = new a((byte)0);
    AppMethodBeat.o(323719);
  }
  
  public e(com.tencent.mm.plugin.appbrand.openmaterial.model.b paramb, final Context paramContext, com.tencent.mm.ui.widget.a.f paramf, final AppBrandOpenMaterialCollection paramAppBrandOpenMaterialCollection, g paramg, final k paramk)
  {
    super(paramb, paramContext, paramf, paramAppBrandOpenMaterialCollection, paramg, paramk);
    AppMethodBeat.i(323561);
    this.trj = new e.b(i.a.trx, true);
    this.trl = kotlin.k.cm((kotlin.g.a.a)new e(paramf, paramk, paramContext, paramAppBrandOpenMaterialCollection));
    AppMethodBeat.o(323561);
  }
  
  private final com.tencent.mm.ui.base.t a(int paramInt, AppBrandOpenMaterialModel paramAppBrandOpenMaterialModel)
  {
    AppMethodBeat.i(323620);
    Log.d("MicroMsg.AppBrand.GridBottomSheetEnhanceLogic", "convertOpenMaterialModel2MenuItem, index: " + paramInt + ", openMaterialModel: " + paramAppBrandOpenMaterialModel);
    com.tencent.mm.ui.base.t localt = new com.tencent.mm.ui.base.t(getContext(), paramInt, 0);
    Object localObject1 = f.a(paramAppBrandOpenMaterialModel);
    Log.i("MicroMsg.AppBrand.GridBottomSheetEnhanceLogic", "convertOpenMaterialModel2MenuItem, functionName: " + paramAppBrandOpenMaterialModel.trR + ", rawFunctionName2Show: " + localObject1);
    localt.adSb = ((ContextMenu.ContextMenuInfo)localObject1);
    localObject1 = paramAppBrandOpenMaterialModel.iconUrl;
    Object localObject2 = com.tencent.mm.modelappbrand.a.a.bEX();
    if ((localObject2 instanceof androidx.core.graphics.drawable.b))
    {
      localObject2 = ((androidx.core.graphics.drawable.b)localObject2).mBitmap;
      if (localObject2 != null) {
        localt.f((Drawable)new BitmapDrawable(ab((Bitmap)localObject2)), 0);
      }
    }
    if (localObject1 != null) {
      com.tencent.mm.modelappbrand.a.b.bEY().a((b.k)new e.d(localt, this), (String)localObject1, (b.h)com.tencent.mm.modelappbrand.a.g.org, null);
    }
    localt.setOnMenuItemClickListener(new e..ExternalSyntheticLambda0(this, paramAppBrandOpenMaterialModel));
    localt.adSe = new e..ExternalSyntheticLambda6(this, paramAppBrandOpenMaterialModel);
    AppMethodBeat.o(323620);
    return localt;
  }
  
  private static final void a(ImageView paramImageView, MenuItem paramMenuItem)
  {
    AppMethodBeat.i(323652);
    Log.d("MicroMsg.AppBrand.GridBottomSheetEnhanceLogic", "onAttach#iconBadgeCreator");
    paramImageView.setBackgroundResource(ba.e.app_brand_open_material_badge_bg);
    paramImageView.setImageResource(ba.h.app_brand_open_material_badge_icon);
    AppMethodBeat.o(323652);
  }
  
  private static final void a(ImageView paramImageView1, ImageView paramImageView2, MenuItem paramMenuItem)
  {
    AppMethodBeat.i(323682);
    Log.d("MicroMsg.AppBrand.GridBottomSheetEnhanceLogic", "onAttach#iconCreator");
    if (aw.isDarkMode()) {}
    for (int i = ba.h.app_brand_open_material_filled_more_night;; i = ba.h.app_brand_open_material_filled_more_normal)
    {
      paramImageView1.setImageResource(i);
      AppMethodBeat.o(323682);
      return;
    }
  }
  
  private static final void a(TextView paramTextView, MenuItem paramMenuItem)
  {
    AppMethodBeat.i(323666);
    Log.d("MicroMsg.AppBrand.GridBottomSheetEnhanceLogic", kotlin.g.b.s.X("onAttach, menuItem: ", paramMenuItem));
    paramMenuItem = paramMenuItem.getMenuInfo();
    if ((paramMenuItem instanceof m)) {}
    for (paramMenuItem = (m)paramMenuItem; paramMenuItem == null; paramMenuItem = null)
    {
      Log.w("MicroMsg.AppBrand.GridBottomSheetEnhanceLogic", "onAttach, menuInfo is not RawFunctionName2Show");
      AppMethodBeat.o(323666);
      return;
    }
    kotlin.g.b.s.s(paramTextView, "textView");
    f.a(paramTextView, paramMenuItem);
    AppMethodBeat.o(323666);
  }
  
  private static final void a(e parame)
  {
    AppMethodBeat.i(323671);
    kotlin.g.b.s.u(parame, "this$0");
    Log.i("MicroMsg.AppBrand.GridBottomSheetEnhanceLogic", "onClick");
    if (i.a.trv != parame.trj.trm)
    {
      AppMethodBeat.o(323671);
      return;
    }
    parame.cDi().cyW();
    parame.cDl().show();
    AppMethodBeat.o(323671);
  }
  
  private static final void a(e parame, MenuItem paramMenuItem, View paramView)
  {
    AppMethodBeat.i(323684);
    kotlin.g.b.s.u(parame, "this$0");
    kotlin.g.b.s.s(paramView, "menuView");
    if (dy(paramView)) {
      parame.cDk().cDs();
    }
    AppMethodBeat.o(323684);
  }
  
  private static final void a(e parame, AppBrandOpenMaterialModel paramAppBrandOpenMaterialModel, MenuItem paramMenuItem, View paramView)
  {
    AppMethodBeat.i(323705);
    kotlin.g.b.s.u(parame, "this$0");
    kotlin.g.b.s.u(paramAppBrandOpenMaterialModel, "$openMaterialModel");
    kotlin.g.b.s.s(paramView, "menuView");
    if (dy(paramView))
    {
      paramView = parame.cDk();
      kotlin.g.b.s.u(paramAppBrandOpenMaterialModel, "openMaterialModel");
      Log.i(paramView.djQ, "onBottomSheetAppBrandExposure");
      if (!paramView.tsl.contains(paramAppBrandOpenMaterialModel))
      {
        parame = paramView.cDw().Az(paramView.ilK);
        parame.jIh = 1L;
        ux localux = parame.AA(paramAppBrandOpenMaterialModel.appId);
        paramMenuItem = paramAppBrandOpenMaterialModel.appName;
        parame = paramMenuItem;
        if (paramMenuItem == null) {
          parame = "";
        }
        localux.AB(parame).bMH();
        paramView.tsl.add(paramAppBrandOpenMaterialModel);
      }
    }
    AppMethodBeat.o(323705);
  }
  
  private static final boolean a(e parame, AppBrandOpenMaterialModel paramAppBrandOpenMaterialModel, MenuItem paramMenuItem)
  {
    AppMethodBeat.i(323696);
    kotlin.g.b.s.u(parame, "this$0");
    kotlin.g.b.s.u(paramAppBrandOpenMaterialModel, "$openMaterialModel");
    if (i.a.trv != parame.trj.trm)
    {
      AppMethodBeat.o(323696);
      return false;
    }
    paramMenuItem = parame.cDk();
    kotlin.g.b.s.u(paramAppBrandOpenMaterialModel, "openMaterialModel");
    Log.i(paramMenuItem.djQ, "onBottomSheetAppBrandClick");
    long l = paramMenuItem.tsf.trO.indexOf(paramAppBrandOpenMaterialModel) + 1;
    Log.d(paramMenuItem.djQ, kotlin.g.b.s.X("onBottomSheetAppBrandClick, index: ", Long.valueOf(l)));
    ty localty = paramMenuItem.cDv().Aa(paramMenuItem.ilK);
    localty.ime = 6L;
    localty.jFj = com.tencent.mm.plugin.appbrand.openmaterial.b.a.d(paramMenuItem.tse);
    localty.jFk = paramMenuItem.cDx();
    localty.jFl = l;
    localty.jFm = localty.F("weapp_id", paramAppBrandOpenMaterialModel.appId, true);
    String str = paramAppBrandOpenMaterialModel.appName;
    paramMenuItem = str;
    if (str == null) {
      paramMenuItem = "";
    }
    localty.jFn = localty.F("weapp_name", paramMenuItem, true);
    localty.bMH();
    ((kotlin.g.a.b)parame.trl.getValue()).invoke(paramAppBrandOpenMaterialModel);
    AppMethodBeat.o(323696);
    return true;
  }
  
  private static Bitmap ab(Bitmap paramBitmap)
  {
    AppMethodBeat.i(323627);
    int i = paramBitmap.getWidth();
    int j = i / 14;
    int k = j * 2 + i;
    Log.i("MicroMsg.AppBrand.GridBottomSheetEnhanceLogic", "wrapIconWithPadding, sideLen: " + i + ", padding: " + j + ", newSideLen: " + k);
    Bitmap localBitmap = Bitmap.createBitmap(k, k, paramBitmap.getConfig());
    new Canvas(localBitmap).drawBitmap(paramBitmap, j, j, null);
    kotlin.g.b.s.s(localBitmap, "newIcon");
    AppMethodBeat.o(323627);
    return localBitmap;
  }
  
  private static final void b(MenuItem paramMenuItem, int paramInt)
  {
    AppMethodBeat.i(323660);
    Log.d("MicroMsg.AppBrand.GridBottomSheetEnhanceLogic", "onMMMenuItemSelected, menuItem: " + paramMenuItem + ", i: " + paramInt);
    if ((paramMenuItem instanceof com.tencent.mm.ui.base.t))
    {
      ((com.tencent.mm.ui.base.t)paramMenuItem).performClick();
      AppMethodBeat.o(323660);
      return;
    }
    Log.w("MicroMsg.AppBrand.GridBottomSheetEnhanceLogic", "onMMMenuItemSelected, menuItem is not MMMenuItem");
    AppMethodBeat.o(323660);
  }
  
  private final com.tencent.mm.ui.base.s cDm()
  {
    AppMethodBeat.i(323606);
    Log.d("MicroMsg.AppBrand.GridBottomSheetEnhanceLogic", "convertOpenMaterialCollection2Menu");
    com.tencent.mm.ui.base.s locals = new com.tencent.mm.ui.base.s(getContext());
    List localList = cDj().trO;
    kotlin.g.b.s.s(localList, "openMaterialCollection.appBrandOpenMaterialModels");
    int k = kotlin.k.k.qv(localList.size(), 2147483647);
    if (k > 0) {}
    int j;
    for (int i = 0;; i = j)
    {
      j = i + 1;
      Object localObject = localList.get(i);
      kotlin.g.b.s.s(localObject, "myOpenMaterialModels[i]");
      locals.j((MenuItem)a(i, (AppBrandOpenMaterialModel)localObject));
      if (j >= k)
      {
        this.trk = locals;
        AppMethodBeat.o(323606);
        return locals;
      }
    }
  }
  
  private static final void cDn() {}
  
  private static boolean dy(View paramView)
  {
    AppMethodBeat.i(323641);
    if (!paramView.isShown())
    {
      Log.w("MicroMsg.AppBrand.GridBottomSheetEnhanceLogic", "isViewExposure view is not shown");
      AppMethodBeat.o(323641);
      return false;
    }
    Rect localRect = new Rect();
    paramView.getGlobalVisibleRect(localRect);
    if (localRect.width() < paramView.getMeasuredWidth())
    {
      Log.i("MicroMsg.AppBrand.GridBottomSheetEnhanceLogic", "isViewExposure, view is visible but not exposure");
      AppMethodBeat.o(323641);
      return false;
    }
    AppMethodBeat.o(323641);
    return true;
  }
  
  private final void ki(boolean paramBoolean)
  {
    AppMethodBeat.i(323569);
    Log.d("MicroMsg.AppBrand.GridBottomSheetEnhanceLogic", kotlin.g.b.s.X("enhance, enable: ", Boolean.valueOf(paramBoolean)));
    if (this.trj.trn)
    {
      kj(paramBoolean);
      if (!paramBoolean) {
        break label72;
      }
    }
    label72:
    for (i.a locala = i.a.trv;; locala = i.a.trw)
    {
      this.trj = new e.b(locala, false);
      AppMethodBeat.o(323569);
      return;
      kk(paramBoolean);
      break;
    }
  }
  
  private final void kj(boolean paramBoolean)
  {
    AppMethodBeat.i(323582);
    Log.d("MicroMsg.AppBrand.GridBottomSheetEnhanceLogic", kotlin.g.b.s.X("enhance, enable: ", Boolean.valueOf(paramBoolean)));
    e..ExternalSyntheticLambda1 localExternalSyntheticLambda1 = e..ExternalSyntheticLambda1.INSTANCE;
    cDi().a(cDm(), e..ExternalSyntheticLambda4.INSTANCE, e..ExternalSyntheticLambda3.INSTANCE);
    cDi().agev = localExternalSyntheticLambda1;
    List localList = cDj().trP;
    kotlin.g.b.s.s(localList, "openMaterialCollection.a…dOpenMaterialDetailModels");
    if (!((Collection)localList).isEmpty()) {}
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        cDi().a(new e..ExternalSyntheticLambda7(this), getContext().getString(ba.i.app_brand_open_material_more_2), e..ExternalSyntheticLambda2.INSTANCE, localExternalSyntheticLambda1, new e..ExternalSyntheticLambda5(this));
      }
      kk(paramBoolean);
      AppMethodBeat.o(323582);
      return;
    }
  }
  
  private final void kk(boolean paramBoolean)
  {
    AppMethodBeat.i(323592);
    Object localObject = this.trk;
    if (localObject != null)
    {
      localObject = ((com.tencent.mm.ui.base.s)localObject).adRW;
      if (localObject != null)
      {
        Iterator localIterator = ((Iterable)localObject).iterator();
        if (localIterator.hasNext())
        {
          localObject = (MenuItem)localIterator.next();
          if ((localObject instanceof com.tencent.mm.ui.base.t))
          {
            localObject = (com.tencent.mm.ui.base.t)localObject;
            label68:
            if (localObject == null) {
              break label89;
            }
            if (paramBoolean) {
              break label91;
            }
          }
          label89:
          label91:
          for (boolean bool = true;; bool = false)
          {
            ((com.tencent.mm.ui.base.t)localObject).disable = bool;
            break;
            localObject = null;
            break label68;
            break;
          }
        }
      }
    }
    cDi().agfg = paramBoolean;
    AppMethodBeat.o(323592);
  }
  
  public final void a(i.a parama)
  {
    AppMethodBeat.i(323793);
    kotlin.g.b.s.u(parama, "newEnhanceType");
    Log.i("MicroMsg.AppBrand.GridBottomSheetEnhanceLogic", "enhance, newEnhanceType: " + parama + ", curEnhanceState: " + this.trj);
    if (this.trj.trm == parama)
    {
      AppMethodBeat.o(323793);
      return;
    }
    switch (c.$EnumSwitchMapping$0[parama.ordinal()])
    {
    }
    for (;;)
    {
      if (cDi().isShowing()) {
        d.a(cDi(), getContext());
      }
      AppMethodBeat.o(323793);
      return;
      ki(true);
      continue;
      ki(false);
      continue;
      Log.d("MicroMsg.AppBrand.GridBottomSheetEnhanceLogic", "revokeEnhance");
      cDi().a(new com.tencent.mm.ui.base.s(getContext()), null, null);
      cDi().agev = null;
      parama = cDi();
      e..ExternalSyntheticLambda8 localExternalSyntheticLambda8 = e..ExternalSyntheticLambda8.INSTANCE;
      parama.ageK = false;
      parama.ager = localExternalSyntheticLambda8;
      cDi().agfg = false;
      this.trj = new e.b(i.a.trx, true);
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/openmaterial/GridBottomSheetEnhanceLogic$Companion;", "", "()V", "canEnhance", "", "openMaterialCollection", "Lcom/tencent/mm/plugin/appbrand/openmaterial/model/AppBrandOpenMaterialCollection;", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
  {
    public static boolean b(AppBrandOpenMaterialCollection paramAppBrandOpenMaterialCollection)
    {
      AppMethodBeat.i(323647);
      kotlin.g.b.s.u(paramAppBrandOpenMaterialCollection, "openMaterialCollection");
      List localList = paramAppBrandOpenMaterialCollection.trO;
      kotlin.g.b.s.s(localList, "openMaterialCollection.appBrandOpenMaterialModels");
      if (!((Collection)localList).isEmpty())
      {
        i = 1;
        if (i == 0)
        {
          paramAppBrandOpenMaterialCollection = paramAppBrandOpenMaterialCollection.trP;
          kotlin.g.b.s.s(paramAppBrandOpenMaterialCollection, "openMaterialCollection.a…dOpenMaterialDetailModels");
          if (((Collection)paramAppBrandOpenMaterialCollection).isEmpty()) {
            break label81;
          }
        }
      }
      label81:
      for (int i = 1;; i = 0)
      {
        if (i == 0) {
          break label86;
        }
        AppMethodBeat.o(323647);
        return true;
        i = 0;
        break;
      }
      label86:
      AppMethodBeat.o(323647);
      return false;
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lkotlin/Function1;", "Lcom/tencent/mm/plugin/appbrand/openmaterial/model/BaseAppBrandOpenMaterialModel;", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class e
    extends u
    implements kotlin.g.a.a<kotlin.g.a.b<? super BaseAppBrandOpenMaterialModel, ? extends ah>>
  {
    e(com.tencent.mm.ui.widget.a.f paramf, k paramk, Context paramContext, AppBrandOpenMaterialCollection paramAppBrandOpenMaterialCollection)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.openmaterial.e
 * JD-Core Version:    0.7.0.1
 */