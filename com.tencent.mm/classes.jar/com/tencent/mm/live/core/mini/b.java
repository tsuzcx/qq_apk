package com.tencent.mm.live.core.mini;

import android.content.Context;
import android.content.Intent;
import android.graphics.Point;
import android.os.PowerManager;
import android.os.PowerManager.WakeLock;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewOutlineProvider;
import android.widget.FrameLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/live/core/mini/LiveMiniManager;", "", "()V", "intent", "Landroid/content/Intent;", "isReported", "", "mWakeLock", "Landroid/os/PowerManager$WakeLock;", "Landroid/os/PowerManager;", "miniLayout", "Lcom/tencent/mm/live/core/mini/AbsLiveMiniView;", "getMiniLayout", "()Lcom/tencent/mm/live/core/mini/AbsLiveMiniView;", "setMiniLayout", "(Lcom/tencent/mm/live/core/mini/AbsLiveMiniView;)V", "miniLayoutVideoContainer", "Landroid/widget/FrameLayout;", "getMiniLayoutVideoContainer", "()Landroid/widget/FrameLayout;", "setMiniLayoutVideoContainer", "(Landroid/widget/FrameLayout;)V", "renderView", "Landroid/view/View;", "resumeActivityName", "", "addRenderView", "", "view", "addViewToWindow", "size", "Landroid/graphics/Point;", "liveId", "", "isAnchor", "generateType", "", "opType", "applyState", "getRenderView", "hideMiniWindow", "release", "releaseState", "removeViewFromWindow", "resumeMiniWindow", "setState", "newState", "setup", "activityName", "setupMiniView", "miniView", "Companion", "plugin-core_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
{
  public static final b.a mUI;
  public Intent intent;
  private boolean lwK;
  public final PowerManager.WakeLock mUJ;
  AbsLiveMiniView mUK;
  public FrameLayout mUL;
  public String mUM;
  public View mUN;
  
  static
  {
    AppMethodBeat.i(247646);
    mUI = new b.a((byte)0);
    AppMethodBeat.o(247646);
  }
  
  public b()
  {
    AppMethodBeat.i(247626);
    this.intent = new Intent();
    this.mUL = new FrameLayout(MMApplicationContext.getContext());
    this.mUM = "";
    Log.printInfoStack("MicroMsg.LiveCoreMini", "dl: LiveMiniManager acquire wake lock", new Object[0]);
    Object localObject = MMApplicationContext.getContext().getSystemService("power");
    if (localObject == null)
    {
      localObject = new NullPointerException("null cannot be cast to non-null type android.os.PowerManager");
      AppMethodBeat.o(247626);
      throw ((Throwable)localObject);
    }
    localObject = ((PowerManager)localObject).newWakeLock(536870922, "MicroMsg.LiveCoreMini");
    s.s(localObject, "pm.newWakeLock(PowerMana…er.ON_AFTER_RELEASE, TAG)");
    this.mUJ = ((PowerManager.WakeLock)localObject);
    if (!this.mUJ.isHeld())
    {
      Log.i("MicroMsg.LiveCoreMini", "alvinluo acquire wakeLock");
      localObject = this.mUJ;
      com.tencent.mm.hellhoundlib.a.a.b(localObject, "com/tencent/mm/live/core/mini/LiveMiniManager", "<init>", "()V", "android/os/PowerManager$WakeLock_EXEC_", "acquire", "()V");
      ((PowerManager.WakeLock)localObject).acquire();
      com.tencent.mm.hellhoundlib.a.a.c(localObject, "com/tencent/mm/live/core/mini/LiveMiniManager", "<init>", "()V", "android/os/PowerManager$WakeLock_EXEC_", "acquire", "()V");
    }
    AppMethodBeat.o(247626);
  }
  
  public static void bfR()
  {
    AppMethodBeat.i(247631);
    ((com.tencent.mm.plugin.ball.c.b)h.ax(com.tencent.mm.plugin.ball.c.b.class)).mq(true);
    Object localObject = a.mUD;
    localObject = a.b.mUF;
    a.b.bfP().mi(false);
    AppMethodBeat.o(247631);
  }
  
  public static void bfS()
  {
    AppMethodBeat.i(247637);
    ((com.tencent.mm.plugin.ball.c.b)h.ax(com.tencent.mm.plugin.ball.c.b.class)).mq(false);
    Object localObject = a.mUD;
    localObject = a.b.mUF;
    a.b.bfP().mj(false);
    AppMethodBeat.o(247637);
  }
  
  public final void a(Point paramPoint, long paramLong, boolean paramBoolean, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(247663);
    s.u(paramPoint, "size");
    boolean bool = this.lwK;
    Object localObject1 = this.mUK;
    if (localObject1 == null) {}
    for (int i = 0;; i = ((AbsLiveMiniView)localObject1).bfN())
    {
      localObject1 = new e(bool, paramLong, paramBoolean, paramInt1, i, paramInt2);
      Object localObject2 = a.mUD;
      localObject2 = a.b.mUF;
      a.b.bfP().a((View)this.mUK, (e)localObject1, paramPoint);
      this.lwK = true;
      AppMethodBeat.o(247663);
      return;
    }
  }
  
  public final void b(AbsLiveMiniView paramAbsLiveMiniView)
  {
    AppMethodBeat.i(247657);
    d locald = new d(com.tencent.mm.cd.a.fromDPToPix(MMApplicationContext.getContext(), 8));
    this.mUK = paramAbsLiveMiniView;
    paramAbsLiveMiniView = this.mUK;
    if (paramAbsLiveMiniView != null) {
      paramAbsLiveMiniView.setClipToOutline(true);
    }
    paramAbsLiveMiniView = this.mUK;
    if (paramAbsLiveMiniView != null) {
      paramAbsLiveMiniView.setOutlineProvider((ViewOutlineProvider)locald);
    }
    this.mUL.setBackgroundColor(-16777216);
    this.mUL.setClipToOutline(true);
    this.mUL.setOutlineProvider((ViewOutlineProvider)locald);
    if ((this.mUL.getParent() != null) && ((this.mUL.getParent() instanceof ViewGroup)))
    {
      paramAbsLiveMiniView = this.mUL.getParent();
      if (paramAbsLiveMiniView == null)
      {
        paramAbsLiveMiniView = new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup");
        AppMethodBeat.o(247657);
        throw paramAbsLiveMiniView;
      }
      ((ViewGroup)paramAbsLiveMiniView).removeView((View)this.mUL);
    }
    paramAbsLiveMiniView = this.mUK;
    if (paramAbsLiveMiniView != null) {
      paramAbsLiveMiniView.addView((View)this.mUL, 0);
    }
    AppMethodBeat.o(247657);
  }
  
  public final void bfQ()
  {
    AppMethodBeat.i(247673);
    Object localObject = c.mUS;
    c.bfT();
    localObject = a.mUD;
    localObject = a.b.mUF;
    a.b.bfP().b((FrameLayout)this.mUK);
    AppMethodBeat.o(247673);
  }
  
  public final void dc(View paramView)
  {
    AppMethodBeat.i(247684);
    s.u(paramView, "view");
    this.mUN = paramView;
    paramView.setClipToOutline(true);
    paramView.setOutlineProvider((ViewOutlineProvider)new d(com.tencent.mm.cd.a.fromDPToPix(MMApplicationContext.getContext(), 8)));
    this.mUL.removeAllViews();
    this.mUL.addView(paramView, (ViewGroup.LayoutParams)new RelativeLayout.LayoutParams(-1, -1));
    AppMethodBeat.o(247684);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.live.core.mini.b
 * JD-Core Version:    0.7.0.1
 */