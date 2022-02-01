package com.tencent.mm.plugin.appbrand.openmaterial;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/mm/plugin/appbrand/openmaterial/AppBrandOpenMaterialBottomSheet$buildTitleView$1$1"})
final class a$d
  implements View.OnClickListener
{
  a$d(a parama) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(229076);
    b localb = new b();
    localb.bm(paramView);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/appbrand/openmaterial/AppBrandOpenMaterialBottomSheet$buildTitleView$$inlined$apply$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
    Log.i("MicroMsg.AppBrand.AppBrandOpenMaterialBottomSheet", "iv_close#onClick");
    this.nkC.hide();
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/appbrand/openmaterial/AppBrandOpenMaterialBottomSheet$buildTitleView$$inlined$apply$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(229076);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.openmaterial.a.d
 * JD-Core Version:    0.7.0.1
 */