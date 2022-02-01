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

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/live/core/mini/LiveMiniManager;", "", "()V", "intent", "Landroid/content/Intent;", "isReported", "", "mWakeLock", "Landroid/os/PowerManager$WakeLock;", "Landroid/os/PowerManager;", "miniLayout", "Lcom/tencent/mm/live/core/mini/AbsLiveMiniView;", "miniLayoutVideoContainer", "Landroid/widget/FrameLayout;", "resumeActivityName", "", "addRenderView", "", "view", "Landroid/view/View;", "addViewToWindow", "size", "Landroid/graphics/Point;", "liveId", "", "isAnchor", "generateType", "", "opType", "applyState", "release", "releaseState", "removeViewFromWindow", "setState", "newState", "setup", "activityName", "setupMiniView", "miniView", "Companion", "plugin-core_release"})
public final class b
{
  public static final a kqS;
  public boolean iUF;
  public Intent intent;
  public final PowerManager.WakeLock kqO;
  public AbsLiveMiniView kqP;
  public FrameLayout kqQ;
  public String kqR;
  
  static
  {
    AppMethodBeat.i(199856);
    kqS = new a((byte)0);
    AppMethodBeat.o(199856);
  }
  
  public b()
  {
    AppMethodBeat.i(199854);
    this.intent = new Intent();
    this.kqQ = new FrameLayout(MMApplicationContext.getContext());
    this.kqR = "";
    Log.printInfoStack("MicroMsg.LiveCoreMini", "dl: LiveMiniManager acquire wake lock", new Object[0]);
    Object localObject = MMApplicationContext.getContext().getSystemService("power");
    if (localObject == null)
    {
      localObject = new t("null cannot be cast to non-null type android.os.PowerManager");
      AppMethodBeat.o(199854);
      throw ((Throwable)localObject);
    }
    localObject = ((PowerManager)localObject).newWakeLock(536870922, "MicroMsg.LiveCoreMini");
    p.j(localObject, "pm.newWakeLock(PowerMana…er.ON_AFTER_RELEASE, TAG)");
    this.kqO = ((PowerManager.WakeLock)localObject);
    if (!this.kqO.isHeld())
    {
      Log.i("MicroMsg.LiveCoreMini", "alvinluo acquire wakeLock");
      localObject = this.kqO;
      com.tencent.mm.hellhoundlib.a.a.b(localObject, "com/tencent/mm/live/core/mini/LiveMiniManager", "<init>", "()V", "android/os/PowerManager$WakeLock_EXEC_", "acquire", "()V");
      ((PowerManager.WakeLock)localObject).acquire();
      com.tencent.mm.hellhoundlib.a.a.c(localObject, "com/tencent/mm/live/core/mini/LiveMiniManager", "<init>", "()V", "android/os/PowerManager$WakeLock_EXEC_", "acquire", "()V");
    }
    AppMethodBeat.o(199854);
  }
  
  public final void aMq()
  {
    AppMethodBeat.i(199844);
    Object localObject = c.kqX;
    c.aMr();
    localObject = a.kqF;
    localObject = a.b.kqH;
    a.b.aMp().b((FrameLayout)this.kqP);
    AppMethodBeat.o(199844);
  }
  
  public final void cH(View paramView)
  {
    AppMethodBeat.i(199847);
    p.k(paramView, "view");
    paramView.setClipToOutline(true);
    paramView.setOutlineProvider((ViewOutlineProvider)new d(com.tencent.mm.ci.a.fromDPToPix(MMApplicationContext.getContext(), 8)));
    this.kqQ.removeAllViews();
    this.kqQ.addView(paramView, (ViewGroup.LayoutParams)new RelativeLayout.LayoutParams(-1, -1));
    AppMethodBeat.o(199847);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/live/core/mini/LiveMiniManager$Companion;", "", "()V", "ROUTE_TO_MAXIMIZE", "", "TAG", "plugin-core_release"})
  public static final class a {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  public static final class b
    extends q
    implements kotlin.g.a.a<x>
  {
    public b(b paramb, int paramInt)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  public static final class c
    extends q
    implements kotlin.g.a.a<x>
  {
    public c(b paramb, int paramInt)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  public static final class d
    extends q
    implements kotlin.g.a.a<x>
  {
    public d(b paramb, int paramInt)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.live.core.mini.b
 * JD-Core Version:    0.7.0.1
 */