package com.tencent.mm.plugin.appbrand.widget.c;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.a.n;
import com.tencent.mm.plugin.appbrand.config.HalfScreenConfig;
import com.tencent.mm.plugin.appbrand.config.HalfScreenConfig.CloseWhenClickEmptyAreaConfig;
import com.tencent.mm.plugin.appbrand.config.HalfScreenConfig.a;
import com.tencent.mm.plugin.appbrand.t;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IEvent;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
final class a$b
  implements View.OnClickListener
{
  a$b(a parama, HalfScreenConfig paramHalfScreenConfig) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(267118);
    Object localObject1 = new com.tencent.mm.hellhoundlib.b.b();
    ((com.tencent.mm.hellhoundlib.b.b)localObject1).bn(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/appbrand/widget/halfscreen/AppBrandHalfScreenLayoutManager$applyWindowConfig$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject1).aFi());
    paramView = a.a(this.rsS).getContext();
    if (paramView != null)
    {
      localObject1 = this.rsT;
      p.j(paramView, "it");
      Object localObject2 = (kotlin.g.a.b)a.rsU;
      p.k(paramView, "activity");
      p.k(localObject2, "toAnimationRes");
      if (!p.h(((HalfScreenConfig)localObject1).nZC, HalfScreenConfig.CloseWhenClickEmptyAreaConfig.oaa))
      {
        EventCenter localEventCenter = EventCenter.instance;
        n localn = new n();
        localn.fuQ.fuR = paramView.hashCode();
        localn.fuQ.fuT = 0;
        localn.fuQ.fuS = ((Number)((kotlin.g.a.b)localObject2).invoke(((HalfScreenConfig)localObject1).nZC.nZZ)).intValue();
        localEventCenter.publish((IEvent)localn);
        localObject2 = new Intent();
        ((Intent)localObject2).putExtra("extra_start_by_half_screen_empty_area_click_scene", true);
        ((Intent)localObject2).addFlags(603979776);
        ((Intent)localObject2).setClass((Context)paramView, Class.forName(((HalfScreenConfig)localObject1).nZC.nZY));
        localObject1 = new com.tencent.mm.hellhoundlib.b.a().bm(localObject2);
        com.tencent.mm.hellhoundlib.a.a.b(paramView, ((com.tencent.mm.hellhoundlib.b.a)localObject1).aFh(), "com/tencent/mm/plugin/appbrand/config/HalfScreenConfig", "performCloseHalfScreen", "(Landroid/app/Activity;Lkotlin/jvm/functions/Function1;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        paramView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject1).sf(0));
        com.tencent.mm.hellhoundlib.a.a.c(paramView, "com/tencent/mm/plugin/appbrand/config/HalfScreenConfig", "performCloseHalfScreen", "(Landroid/app/Activity;Lkotlin/jvm/functions/Function1;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      }
    }
    if (a.a(this.rsS).bCj()) {
      a.a(this.rsS).close();
    }
    for (;;)
    {
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/appbrand/widget/halfscreen/AppBrandHalfScreenLayoutManager$applyWindowConfig$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(267118);
      return;
      a.a(this.rsS).finish();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "style", "Lcom/tencent/mm/plugin/appbrand/config/HalfScreenConfig$ActivityAnimationStyle;", "invoke"})
  static final class a
    extends q
    implements kotlin.g.a.b<HalfScreenConfig.a, Integer>
  {
    public static final a rsU;
    
    static
    {
      AppMethodBeat.i(246599);
      rsU = new a();
      AppMethodBeat.o(246599);
    }
    
    a()
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.c.a.b
 * JD-Core Version:    0.7.0.1
 */