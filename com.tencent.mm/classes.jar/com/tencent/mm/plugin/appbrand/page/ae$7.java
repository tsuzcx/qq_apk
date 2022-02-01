package com.tencent.mm.plugin.appbrand.page;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.appbrand.ap.a;
import com.tencent.mm.plugin.appbrand.jsapi.p;
import com.tencent.mm.plugin.appbrand.o;
import java.util.HashMap;
import java.util.Map;

final class ae$7
  implements View.OnClickListener
{
  ae$7(ae paramae) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(188694);
    Object localObject = new b();
    ((b)localObject).bd(paramView);
    a.b("com/tencent/mm/plugin/appbrand/page/AppBrandPageViewWC$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).ahq());
    paramView = ae.h(this.mcH);
    localObject = this.mcH.lYf;
    ap.a locala = new ap.a();
    HashMap localHashMap = new HashMap(1);
    localHashMap.put("currentPath", localObject);
    locala.A(localHashMap).g(paramView.aXe()).bir();
    a.a(this, "com/tencent/mm/plugin/appbrand/page/AppBrandPageViewWC$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(188694);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.ae.7
 * JD-Core Version:    0.7.0.1
 */