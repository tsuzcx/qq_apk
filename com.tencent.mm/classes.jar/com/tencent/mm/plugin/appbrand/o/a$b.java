package com.tencent.mm.plugin.appbrand.o;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.config.HalfScreenConfig;
import com.tencent.mm.plugin.appbrand.config.HalfScreenConfig.CloseWhenClickEmptyAreaConfig;
import com.tencent.mm.plugin.appbrand.config.HalfScreenConfig.a;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
final class a$b
  implements View.OnClickListener
{
  a$b(a parama, HalfScreenConfig paramHalfScreenConfig) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(228800);
    Object localObject1 = new com.tencent.mm.hellhoundlib.b.b();
    ((com.tencent.mm.hellhoundlib.b.b)localObject1).bm(paramView);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/appbrand/layout/AppBrandHalfWindowLayoutManager$applyWindowConfig$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject1).axR());
    paramView = a.a(this.mZH).getContext();
    if (paramView != null)
    {
      localObject1 = this.mZI;
      p.g(paramView, "it");
      kotlin.g.a.b localb = (kotlin.g.a.b)a.mZJ;
      p.h(paramView, "activity");
      p.h(localb, "toAnimationRes");
      if (!p.j(((HalfScreenConfig)localObject1).lfq, HalfScreenConfig.CloseWhenClickEmptyAreaConfig.lfE))
      {
        Object localObject2 = new Intent();
        ((Intent)localObject2).putExtra("extra_start_by_half_screen_empty_area_click_scene", true);
        ((Intent)localObject2).addFlags(603979776);
        ((Intent)localObject2).setClass((Context)paramView, Class.forName(((HalfScreenConfig)localObject1).lfq.lfC));
        localObject2 = new com.tencent.mm.hellhoundlib.b.a().bl(localObject2);
        com.tencent.mm.hellhoundlib.a.a.a(paramView, ((com.tencent.mm.hellhoundlib.b.a)localObject2).axQ(), "com/tencent/mm/plugin/appbrand/config/HalfScreenConfig", "performCloseHalfScreen", "(Landroid/app/Activity;Lkotlin/jvm/functions/Function1;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        paramView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject2).pG(0));
        com.tencent.mm.hellhoundlib.a.a.a(paramView, "com/tencent/mm/plugin/appbrand/config/HalfScreenConfig", "performCloseHalfScreen", "(Landroid/app/Activity;Lkotlin/jvm/functions/Function1;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        paramView.overridePendingTransition(0, ((Number)localb.invoke(((HalfScreenConfig)localObject1).lfq.lfD)).intValue());
      }
    }
    a.a(this.mZH).close();
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/appbrand/layout/AppBrandHalfWindowLayoutManager$applyWindowConfig$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(228800);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "style", "Lcom/tencent/mm/plugin/appbrand/config/HalfScreenConfig$ActivityAnimationStyle;", "invoke"})
  static final class a
    extends kotlin.g.b.q
    implements kotlin.g.a.b<HalfScreenConfig.a, Integer>
  {
    public static final a mZJ;
    
    static
    {
      AppMethodBeat.i(228799);
      mZJ = new a();
      AppMethodBeat.o(228799);
    }
    
    a()
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.o.a.b
 * JD-Core Version:    0.7.0.1
 */