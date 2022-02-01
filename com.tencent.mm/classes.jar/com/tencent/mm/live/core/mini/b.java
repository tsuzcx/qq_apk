package com.tencent.mm.live.core.mini;

import android.content.Context;
import android.content.Intent;
import android.os.PowerManager;
import android.os.PowerManager.WakeLock;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewOutlineProvider;
import android.widget.FrameLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.t;
import kotlin.x;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/live/core/mini/LiveMiniManager;", "", "()V", "intent", "Landroid/content/Intent;", "isReported", "", "mWakeLock", "Landroid/os/PowerManager$WakeLock;", "Landroid/os/PowerManager;", "miniLayout", "Lcom/tencent/mm/live/core/mini/AbsLiveMiniView;", "miniLayoutVideoContainer", "Landroid/widget/FrameLayout;", "resumeActivityName", "", "addRenderView", "", "view", "Landroid/view/View;", "addViewToWindow", "size", "Landroid/graphics/Point;", "liveId", "", "isAnchor", "generateType", "", "opType", "release", "removeViewFromWindow", "setup", "activityName", "setupMiniView", "miniView", "updateState", "state", "Lcom/tencent/mm/live/core/mini/LiveMiniState;", "Companion", "plugin-core_release"})
public final class b
{
  public static final a hCR;
  public boolean gqx;
  public final PowerManager.WakeLock hCN;
  public AbsLiveMiniView hCO;
  public FrameLayout hCP;
  public String hCQ;
  public Intent intent;
  
  static
  {
    AppMethodBeat.i(196588);
    hCR = new a((byte)0);
    AppMethodBeat.o(196588);
  }
  
  public b()
  {
    AppMethodBeat.i(196587);
    this.intent = new Intent();
    this.hCP = new FrameLayout(MMApplicationContext.getContext());
    this.hCQ = "";
    Object localObject = MMApplicationContext.getContext().getSystemService("power");
    if (localObject == null)
    {
      localObject = new t("null cannot be cast to non-null type android.os.PowerManager");
      AppMethodBeat.o(196587);
      throw ((Throwable)localObject);
    }
    localObject = ((PowerManager)localObject).newWakeLock(536870922, "MicroMsg.LiveCoreMini");
    p.g(localObject, "pm.newWakeLock(PowerMana…er.ON_AFTER_RELEASE, TAG)");
    this.hCN = ((PowerManager.WakeLock)localObject);
    if (!this.hCN.isHeld())
    {
      Log.i("MicroMsg.LiveCoreMini", "alvinluo acquire wakeLock");
      this.hCN.acquire();
    }
    AppMethodBeat.o(196587);
  }
  
  public final void aEj()
  {
    AppMethodBeat.i(196585);
    Object localObject = c.hCU;
    c.aEk();
    localObject = a.hCD;
    localObject = a.b.hCF;
    a.b.aEi().b((FrameLayout)this.hCO);
    AppMethodBeat.o(196585);
  }
  
  public final void co(View paramView)
  {
    AppMethodBeat.i(196586);
    p.h(paramView, "view");
    paramView.setClipToOutline(true);
    paramView.setOutlineProvider((ViewOutlineProvider)new e(com.tencent.mm.cb.a.fromDPToPix(MMApplicationContext.getContext(), 8)));
    this.hCP.removeAllViews();
    this.hCP.addView(paramView, (ViewGroup.LayoutParams)new RelativeLayout.LayoutParams(-1, -1));
    AppMethodBeat.o(196586);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/live/core/mini/LiveMiniManager$Companion;", "", "()V", "ROUTE_TO_MAXIMIZE", "", "TAG", "plugin-core_release"})
  public static final class a {}
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  public static final class b
    extends q
    implements kotlin.g.a.a<x>
  {
    public b(b paramb, d paramd)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.live.core.mini.b
 * JD-Core Version:    0.7.0.1
 */