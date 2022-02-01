package com.tencent.mm.plugin.appbrand.openmaterial;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.au.c;
import com.tencent.mm.plugin.appbrand.au.f;
import com.tencent.mm.plugin.appbrand.au.g;
import com.tencent.mm.plugin.appbrand.au.h;
import com.tencent.mm.plugin.appbrand.openmaterial.model.AppBrandOpenMaterialCollection;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.au;
import com.tencent.mm.ui.widget.a.e;
import java.util.Collection;
import kotlin.g.b.p;

@kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/openmaterial/ListBottomSheetEnhanceLogic;", "Lcom/tencent/mm/plugin/appbrand/openmaterial/BottomSheetEnhanceLogic;", "openMaterialScene", "Lcom/tencent/mm/plugin/appbrand/openmaterial/model/AppBrandOpenMaterialScene;", "context", "Landroid/content/Context;", "bottomSheet", "Lcom/tencent/mm/ui/widget/dialog/MMBottomSheet;", "openMaterialCollection", "Lcom/tencent/mm/plugin/appbrand/openmaterial/model/AppBrandOpenMaterialCollection;", "openMaterialBottomSheet", "Lcom/tencent/mm/plugin/appbrand/openmaterial/IAppBrandOpenMaterialBottomSheet;", "launchAppBrandExecutor", "Lcom/tencent/mm/plugin/appbrand/openmaterial/ILaunchAppBrandExecutor;", "(Lcom/tencent/mm/plugin/appbrand/openmaterial/model/AppBrandOpenMaterialScene;Landroid/content/Context;Lcom/tencent/mm/ui/widget/dialog/MMBottomSheet;Lcom/tencent/mm/plugin/appbrand/openmaterial/model/AppBrandOpenMaterialCollection;Lcom/tencent/mm/plugin/appbrand/openmaterial/IAppBrandOpenMaterialBottomSheet;Lcom/tencent/mm/plugin/appbrand/openmaterial/ILaunchAppBrandExecutor;)V", "buildMoreOpenWaysView", "Landroid/view/View;", "enhance", "", "type", "Lcom/tencent/mm/plugin/appbrand/openmaterial/IEnhanceBottomSheetController$EnhanceType;", "Companion", "plugin-appbrand-integration_release"})
public final class m
  extends c
{
  public static final a qmR;
  
  static
  {
    AppMethodBeat.i(273483);
    qmR = new a((byte)0);
    AppMethodBeat.o(273483);
  }
  
  public m(com.tencent.mm.plugin.appbrand.openmaterial.model.b paramb, Context paramContext, e parame, AppBrandOpenMaterialCollection paramAppBrandOpenMaterialCollection, h paramh, l paraml)
  {
    super(paramb, paramContext, parame, paramAppBrandOpenMaterialCollection, paramh, paraml);
    AppMethodBeat.i(273482);
    AppMethodBeat.o(273482);
  }
  
  public final void a(j.a parama)
  {
    AppMethodBeat.i(273481);
    p.k(parama, "type");
    Log.d("MicroMsg.AppBrand.ListBottomSheetEnhanceLogic", "enhance, type: ".concat(String.valueOf(parama)));
    parama = ccN().qni;
    p.j(parama, "openMaterialCollection.a…dOpenMaterialDetailModels");
    if (!((Collection)parama).isEmpty()) {}
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        parama = this.kCR;
        View localView = LayoutInflater.from(getContext()).inflate(au.g.app_brand_bottom_sheet_footer_more_open_ways, null);
        i = getContext().getResources().getColor(au.c.normal_text_color);
        Object localObject = (ImageView)localView.findViewById(au.f.more_open_ways_iv);
        if (localObject != null) {
          ((ImageView)localObject).setImageDrawable(au.o(getContext(), au.h.icons_filled_mini_program, i));
        }
        localObject = (TextView)localView.findViewById(au.f.more_open_ways_tv);
        if (localObject != null) {
          ((TextView)localObject).setTextColor(i);
        }
        localView.setOnClickListener((View.OnClickListener)new b(this));
        p.j(localView, "moreOpenWaysView");
        parama.setFooterView(localView);
        this.qml.ccU();
        if (this.kCR.isShowing()) {
          d.a(this.kCR, getContext());
        }
      }
      AppMethodBeat.o(273481);
      return;
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/openmaterial/ListBottomSheetEnhanceLogic$Companion;", "", "()V", "canEnhance", "", "openMaterialCollection", "Lcom/tencent/mm/plugin/appbrand/openmaterial/model/AppBrandOpenMaterialCollection;", "plugin-appbrand-integration_release"})
  public static final class a
  {
    public static boolean b(AppBrandOpenMaterialCollection paramAppBrandOpenMaterialCollection)
    {
      AppMethodBeat.i(274777);
      p.k(paramAppBrandOpenMaterialCollection, "openMaterialCollection");
      paramAppBrandOpenMaterialCollection = paramAppBrandOpenMaterialCollection.qni;
      p.j(paramAppBrandOpenMaterialCollection, "openMaterialCollection.a…dOpenMaterialDetailModels");
      if (!((Collection)paramAppBrandOpenMaterialCollection).isEmpty())
      {
        AppMethodBeat.o(274777);
        return true;
      }
      AppMethodBeat.o(274777);
      return false;
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class b
    implements View.OnClickListener
  {
    b(m paramm) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(273704);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/appbrand/openmaterial/ListBottomSheetEnhanceLogic$buildMoreOpenWaysView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
      Log.i("MicroMsg.AppBrand.ListBottomSheetEnhanceLogic", "buildMoreOpenWaysView#onClick");
      this.qmS.kCR.bYF();
      this.qmS.ccM().show();
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/appbrand/openmaterial/ListBottomSheetEnhanceLogic$buildMoreOpenWaysView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(273704);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.openmaterial.m
 * JD-Core Version:    0.7.0.1
 */