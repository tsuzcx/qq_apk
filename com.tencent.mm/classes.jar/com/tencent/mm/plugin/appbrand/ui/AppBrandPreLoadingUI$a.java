package com.tencent.mm.plugin.appbrand.ui;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.i.b;
import kotlin.l;
import kotlin.l.n;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"kotlin/properties/Delegates$observable$1", "Lkotlin/properties/ObservableProperty;", "afterChange", "", "property", "Lkotlin/reflect/KProperty;", "oldValue", "newValue", "(Lkotlin/reflect/KProperty;Ljava/lang/Object;Ljava/lang/Object;)V", "kotlin-stdlib"})
public final class AppBrandPreLoadingUI$a
  extends b<Boolean>
{
  public AppBrandPreLoadingUI$a(Object paramObject1, Object paramObject2, AppBrandPreLoadingUI paramAppBrandPreLoadingUI)
  {
    super(paramObject2);
  }
  
  public final void a(n<?> paramn, Boolean paramBoolean1, Boolean paramBoolean2)
  {
    AppMethodBeat.i(51117);
    p.k(paramn, "property");
    boolean bool1 = ((Boolean)paramBoolean2).booleanValue();
    boolean bool2 = ((Boolean)paramBoolean1).booleanValue();
    if ((bool1) && (!bool2) && (AppBrandPreLoadingUI.f(this.qWh) != null))
    {
      paramn = this.qWh;
      paramBoolean1 = AppBrandPreLoadingUI.f(this.qWh);
      paramBoolean1 = new com.tencent.mm.hellhoundlib.b.a().bm(paramBoolean1);
      com.tencent.mm.hellhoundlib.a.a.b(paramn, paramBoolean1.aFh(), "com/tencent/mm/plugin/appbrand/ui/AppBrandPreLoadingUI$$special$$inlined$observable$1", "afterChange", "(Lkotlin/reflect/KProperty;Ljava/lang/Object;Ljava/lang/Object;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramn.startActivity((Intent)paramBoolean1.sf(0));
      com.tencent.mm.hellhoundlib.a.a.c(paramn, "com/tencent/mm/plugin/appbrand/ui/AppBrandPreLoadingUI$$special$$inlined$observable$1", "afterChange", "(Lkotlin/reflect/KProperty;Ljava/lang/Object;Ljava/lang/Object;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppBrandPreLoadingUI.a(this.qWh, null);
    }
    AppMethodBeat.o(51117);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.AppBrandPreLoadingUI.a
 * JD-Core Version:    0.7.0.1
 */