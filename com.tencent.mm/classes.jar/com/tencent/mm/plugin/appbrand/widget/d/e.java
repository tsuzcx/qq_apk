package com.tencent.mm.plugin.appbrand.widget.d;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Rect;
import android.view.MotionEvent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.a.p;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.ap;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.config.HalfScreenConfig;
import com.tencent.mm.plugin.appbrand.config.HalfScreenConfig.CloseWhenClickEmptyAreaConfig;
import com.tencent.mm.plugin.appbrand.config.HalfScreenConfig.a;
import com.tencent.mm.plugin.appbrand.config.HalfScreenConfig.g;
import com.tencent.mm.plugin.appbrand.w;
import com.tencent.mm.plugin.appbrand.widget.k;
import com.tencent.mm.plugin.appbrand.widget.l;
import com.tencent.mm.sdk.system.AndroidContextUtil;
import kotlin.Metadata;
import kotlin.g.a.b;
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/widget/halfscreen/WxaHalfScreenEmptyAreaClickHandler;", "Lcom/tencent/mm/plugin/appbrand/widget/IWxaHalfScreenEmptyAreaClickHandler;", "rt", "Lcom/tencent/mm/plugin/appbrand/AppBrandRuntimeWC;", "(Lcom/tencent/mm/plugin/appbrand/AppBrandRuntimeWC;)V", "onHalfScreenEmptyAreaClick", "", "ev", "Landroid/view/MotionEvent;", "wantInterceptClick", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class e
  implements k
{
  private final w qxY;
  
  public e(w paramw)
  {
    AppMethodBeat.i(324281);
    this.qxY = paramw;
    AppMethodBeat.o(324281);
  }
  
  public final boolean I(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(324290);
    s.u(paramMotionEvent, "ev");
    paramMotionEvent = this.qxY.getInitConfig().qAT;
    s.s(paramMotionEvent, "rt.initConfig.halfScreenConfig");
    if ((paramMotionEvent.isEnable()) && (paramMotionEvent.qZK))
    {
      paramMotionEvent = this.qxY.qvN.uDE;
      if (paramMotionEvent != null) {
        paramMotionEvent.a(null);
      }
      paramMotionEvent = AndroidContextUtil.castActivityOrNull(this.qxY.mContext);
      if (paramMotionEvent != null)
      {
        Object localObject1 = this.qxY.getInitConfig().qAT;
        Object localObject2 = (b)a.uDM;
        s.u(paramMotionEvent, "activity");
        s.u(localObject2, "toAnimationRes");
        if (!s.p(((HalfScreenConfig)localObject1).qZM, HalfScreenConfig.CloseWhenClickEmptyAreaConfig.rau))
        {
          p localp = new p();
          localp.hzk.hzl = paramMotionEvent.hashCode();
          localp.hzk.hzn = 0;
          localp.hzk.hzm = ((Number)((b)localObject2).invoke(((HalfScreenConfig)localObject1).qZM.rat)).intValue();
          localp.publish();
          localObject2 = new Intent();
          ((Intent)localObject2).putExtra("extra_start_by_half_screen_empty_area_click_scene", true);
          ((Intent)localObject2).addFlags(603979776);
          ((Intent)localObject2).setClass((Context)paramMotionEvent, Class.forName(((HalfScreenConfig)localObject1).qZM.ras));
          localObject1 = new com.tencent.mm.hellhoundlib.b.a().cG(localObject2);
          com.tencent.mm.hellhoundlib.a.a.b(paramMotionEvent, ((com.tencent.mm.hellhoundlib.b.a)localObject1).aYi(), "com/tencent/mm/plugin/appbrand/config/HalfScreenConfig", "performCloseHalfScreen", "(Landroid/app/Activity;Lkotlin/jvm/functions/Function1;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          paramMotionEvent.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject1).sb(0));
          com.tencent.mm.hellhoundlib.a.a.c(paramMotionEvent, "com/tencent/mm/plugin/appbrand/config/HalfScreenConfig", "performCloseHalfScreen", "(Landroid/app/Activity;Lkotlin/jvm/functions/Function1;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        }
      }
      if (!this.qxY.mInitialized) {
        break label311;
      }
      this.qxY.close();
    }
    for (;;)
    {
      AppMethodBeat.o(324290);
      return true;
      label311:
      this.qxY.finish();
    }
  }
  
  public final boolean J(MotionEvent paramMotionEvent)
  {
    Object localObject4 = null;
    AppMethodBeat.i(324297);
    s.u(paramMotionEvent, "ev");
    Object localObject1 = this.qxY.getInitConfig().qAT;
    s.s(localObject1, "rt.initConfig.halfScreenConfig");
    if ((((HalfScreenConfig)localObject1).isEnable()) && (((HalfScreenConfig)localObject1).rac == HalfScreenConfig.g.raA)) {
      for (;;)
      {
        try
        {
          localObject1 = this.qxY.qsc;
          if (localObject1 != null) {
            continue;
          }
          localObject1 = null;
        }
        finally
        {
          Rect localRect;
          Object localObject3 = null;
          continue;
          continue;
        }
        if (localObject1 == null) {
          break label155;
        }
        localObject1 = ((AppBrandRuntime)localObject1).qsp;
        localRect = new Rect();
        localObject1 = ((com.tencent.mm.plugin.appbrand.page.capsulebar.e)localObject1).tCd;
        if (localObject1 != null) {
          continue;
        }
        s.bIx("capsuleBarView");
        localObject1 = localObject4;
        ((com.tencent.mm.plugin.appbrand.page.capsulebar.d)localObject1).getHitRect(localRect);
        if (!localRect.contains((int)paramMotionEvent.getX(), (int)paramMotionEvent.getY())) {
          break label155;
        }
        AppMethodBeat.o(324297);
        return false;
        localObject1 = ((ap)localObject1).y((AppBrandRuntime)this.qxY);
      }
    }
    label155:
    AppMethodBeat.o(324297);
    return true;
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "style", "Lcom/tencent/mm/plugin/appbrand/config/HalfScreenConfig$ActivityAnimationStyle;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends u
    implements b<HalfScreenConfig.a, Integer>
  {
    public static final a uDM;
    
    static
    {
      AppMethodBeat.i(324323);
      uDM = new a();
      AppMethodBeat.o(324323);
    }
    
    a()
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.d.e
 * JD-Core Version:    0.7.0.1
 */