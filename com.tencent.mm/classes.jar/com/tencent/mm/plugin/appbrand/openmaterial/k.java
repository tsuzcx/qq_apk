package com.tencent.mm.plugin.appbrand.openmaterial;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.openmaterial.model.AppBrandOpenMaterialCollection;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.ar;
import com.tencent.mm.ui.widget.a.e;
import java.util.Collection;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/openmaterial/ListBottomSheetEnhanceLogic;", "Lcom/tencent/mm/plugin/appbrand/openmaterial/BottomSheetEnhanceLogic;", "openMaterialScene", "Lcom/tencent/mm/plugin/appbrand/openmaterial/model/AppBrandOpenMaterialScene;", "context", "Landroid/content/Context;", "bottomSheet", "Lcom/tencent/mm/ui/widget/dialog/MMBottomSheet;", "openMaterialCollection", "Lcom/tencent/mm/plugin/appbrand/openmaterial/model/AppBrandOpenMaterialCollection;", "openMaterialBottomSheet", "Lcom/tencent/mm/plugin/appbrand/openmaterial/IAppBrandOpenMaterialBottomSheet;", "launchAppBrandExecutor", "Lcom/tencent/mm/plugin/appbrand/openmaterial/ILaunchAppBrandExecutor;", "(Lcom/tencent/mm/plugin/appbrand/openmaterial/model/AppBrandOpenMaterialScene;Landroid/content/Context;Lcom/tencent/mm/ui/widget/dialog/MMBottomSheet;Lcom/tencent/mm/plugin/appbrand/openmaterial/model/AppBrandOpenMaterialCollection;Lcom/tencent/mm/plugin/appbrand/openmaterial/IAppBrandOpenMaterialBottomSheet;Lcom/tencent/mm/plugin/appbrand/openmaterial/ILaunchAppBrandExecutor;)V", "buildMoreOpenWaysView", "Landroid/view/View;", "enhance", "", "plugin-appbrand-integration_release"})
public final class k
  extends c
{
  public k(com.tencent.mm.plugin.appbrand.openmaterial.model.b paramb, Context paramContext, e parame, AppBrandOpenMaterialCollection paramAppBrandOpenMaterialCollection, g paramg, j paramj)
  {
    super(paramb, paramContext, parame, paramAppBrandOpenMaterialCollection, paramg, paramj);
    AppMethodBeat.i(229128);
    AppMethodBeat.o(229128);
  }
  
  public final void bQc()
  {
    AppMethodBeat.i(229127);
    Log.d("MicroMsg.AppBrand.ListBottomSheetEnhanceLogic", "enhance");
    Object localObject1 = this.nkx.nlF;
    p.g(localObject1, "openMaterialCollection.a…dOpenMaterialDetailModels");
    if (!((Collection)localObject1).isEmpty()) {}
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        localObject1 = this.hOv;
        View localView = LayoutInflater.from(this.context).inflate(2131493014, null);
        i = this.context.getResources().getColor(2131100904);
        Object localObject2 = (ImageView)localView.findViewById(2131304894);
        if (localObject2 != null) {
          ((ImageView)localObject2).setImageDrawable(ar.m(this.context, 2131690605, i));
        }
        localObject2 = (TextView)localView.findViewById(2131304895);
        if (localObject2 != null) {
          ((TextView)localObject2).setTextColor(i);
        }
        localView.setOnClickListener((View.OnClickListener)new a(this));
        p.g(localView, "moreOpenWaysView");
        ((e)localObject1).setFooterView(localView);
        d.a(this.hOv, this.context);
      }
      AppMethodBeat.o(229127);
      return;
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class a
    implements View.OnClickListener
  {
    a(k paramk) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(229126);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bm(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/appbrand/openmaterial/ListBottomSheetEnhanceLogic$buildMoreOpenWaysView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
      Log.i("MicroMsg.AppBrand.ListBottomSheetEnhanceLogic", "buildMoreOpenWaysView#onClick");
      this.nlk.hOv.bMo();
      this.nlk.bQb().show();
      this.nlk.nkz.bQl();
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/appbrand/openmaterial/ListBottomSheetEnhanceLogic$buildMoreOpenWaysView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(229126);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.openmaterial.k
 * JD-Core Version:    0.7.0.1
 */