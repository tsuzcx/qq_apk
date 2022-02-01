package com.tencent.mm.plugin.appbrand.openmaterial;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ba.c;
import com.tencent.mm.plugin.appbrand.ba.f;
import com.tencent.mm.plugin.appbrand.ba.g;
import com.tencent.mm.plugin.appbrand.ba.h;
import com.tencent.mm.plugin.appbrand.openmaterial.model.AppBrandOpenMaterialCollection;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.bb;
import com.tencent.mm.ui.widget.a.f;
import java.util.Collection;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/openmaterial/ListBottomSheetEnhanceLogic;", "Lcom/tencent/mm/plugin/appbrand/openmaterial/BottomSheetEnhanceLogic;", "openMaterialScene", "Lcom/tencent/mm/plugin/appbrand/openmaterial/model/AppBrandOpenMaterialScene;", "context", "Landroid/content/Context;", "bottomSheet", "Lcom/tencent/mm/ui/widget/dialog/MMBottomSheet;", "openMaterialCollection", "Lcom/tencent/mm/plugin/appbrand/openmaterial/model/AppBrandOpenMaterialCollection;", "openMaterialBottomSheet", "Lcom/tencent/mm/plugin/appbrand/openmaterial/IAppBrandOpenMaterialBottomSheet;", "launchAppBrandExecutor", "Lcom/tencent/mm/plugin/appbrand/openmaterial/ILaunchAppBrandExecutor;", "(Lcom/tencent/mm/plugin/appbrand/openmaterial/model/AppBrandOpenMaterialScene;Landroid/content/Context;Lcom/tencent/mm/ui/widget/dialog/MMBottomSheet;Lcom/tencent/mm/plugin/appbrand/openmaterial/model/AppBrandOpenMaterialCollection;Lcom/tencent/mm/plugin/appbrand/openmaterial/IAppBrandOpenMaterialBottomSheet;Lcom/tencent/mm/plugin/appbrand/openmaterial/ILaunchAppBrandExecutor;)V", "buildMoreOpenWaysView", "Landroid/view/View;", "enhance", "", "type", "Lcom/tencent/mm/plugin/appbrand/openmaterial/IEnhanceBottomSheetController$EnhanceType;", "Companion", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class l
  extends c
{
  public static final a trA;
  
  static
  {
    AppMethodBeat.i(323521);
    trA = new a((byte)0);
    AppMethodBeat.o(323521);
  }
  
  public l(com.tencent.mm.plugin.appbrand.openmaterial.model.b paramb, Context paramContext, f paramf, AppBrandOpenMaterialCollection paramAppBrandOpenMaterialCollection, g paramg, k paramk)
  {
    super(paramb, paramContext, paramf, paramAppBrandOpenMaterialCollection, paramg, paramk);
    AppMethodBeat.i(323512);
    AppMethodBeat.o(323512);
  }
  
  private static final void a(l paraml, View paramView)
  {
    AppMethodBeat.i(323515);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paraml);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/appbrand/openmaterial/ListBottomSheetEnhanceLogic", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paraml, "this$0");
    Log.i("MicroMsg.AppBrand.ListBottomSheetEnhanceLogic", "buildMoreOpenWaysView#onClick");
    paraml.cDi().cyW();
    paraml.cDl().show();
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/appbrand/openmaterial/ListBottomSheetEnhanceLogic", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(323515);
  }
  
  public final void a(i.a parama)
  {
    AppMethodBeat.i(323538);
    s.u(parama, "type");
    Log.d("MicroMsg.AppBrand.ListBottomSheetEnhanceLogic", s.X("enhance, type: ", parama));
    parama = cDj().trP;
    s.s(parama, "openMaterialCollection.a…dOpenMaterialDetailModels");
    if (!((Collection)parama).isEmpty()) {}
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        parama = cDi();
        View localView = LayoutInflater.from(getContext()).inflate(ba.g.app_brand_bottom_sheet_footer_more_open_ways, null);
        i = getContext().getResources().getColor(ba.c.normal_text_color);
        Object localObject = (ImageView)localView.findViewById(ba.f.more_open_ways_iv);
        if (localObject != null) {
          ((ImageView)localObject).setImageDrawable(bb.m(getContext(), ba.h.icons_filled_mini_program, i));
        }
        localObject = (TextView)localView.findViewById(ba.f.more_open_ways_tv);
        if (localObject != null) {
          ((TextView)localObject).setTextColor(i);
        }
        localView.setOnClickListener(new l..ExternalSyntheticLambda0(this));
        s.s(localView, "moreOpenWaysView");
        parama.setFooterView(localView);
        cDk().cDs();
        if (cDi().isShowing()) {
          d.a(cDi(), getContext());
        }
      }
      AppMethodBeat.o(323538);
      return;
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/openmaterial/ListBottomSheetEnhanceLogic$Companion;", "", "()V", "canEnhance", "", "openMaterialCollection", "Lcom/tencent/mm/plugin/appbrand/openmaterial/model/AppBrandOpenMaterialCollection;", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
  {
    public static boolean b(AppBrandOpenMaterialCollection paramAppBrandOpenMaterialCollection)
    {
      AppMethodBeat.i(323516);
      s.u(paramAppBrandOpenMaterialCollection, "openMaterialCollection");
      paramAppBrandOpenMaterialCollection = paramAppBrandOpenMaterialCollection.trP;
      s.s(paramAppBrandOpenMaterialCollection, "openMaterialCollection.a…dOpenMaterialDetailModels");
      if (!((Collection)paramAppBrandOpenMaterialCollection).isEmpty())
      {
        AppMethodBeat.o(323516);
        return true;
      }
      AppMethodBeat.o(323516);
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.openmaterial.l
 * JD-Core Version:    0.7.0.1
 */