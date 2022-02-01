package com.tencent.mm.live.core.mini;

import android.content.Context;
import android.content.Intent;
import android.os.PowerManager;
import android.os.PowerManager.WakeLock;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.WindowManager;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import d.g.b.p;
import d.l;
import d.v;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/live/core/mini/LiveMiniManager;", "", "()V", "intent", "Landroid/content/Intent;", "mWakeLock", "Landroid/os/PowerManager$WakeLock;", "Landroid/os/PowerManager;", "miniLayout", "Lcom/tencent/mm/live/core/mini/LiveMiniView;", "resumeActivityName", "", "addRenderView", "", "view", "Landroid/view/View;", "addViewToWindow", "size", "Landroid/graphics/Point;", "release", "removeViewFromWindow", "setup", "activityName", "clickListener", "Landroid/view/View$OnClickListener;", "updateState", "state", "Companion", "plugin-core_release"})
public final class a
{
  public static final a.a gNe;
  public final PowerManager.WakeLock gNb;
  public final LiveMiniView gNc;
  public String gNd;
  public Intent intent;
  
  static
  {
    AppMethodBeat.i(196924);
    gNe = new a.a((byte)0);
    AppMethodBeat.o(196924);
  }
  
  public a()
  {
    AppMethodBeat.i(196923);
    this.intent = new Intent();
    Object localObject = ak.getContext();
    p.g(localObject, "MMApplicationContext.getContext()");
    this.gNc = new LiveMiniView((Context)localObject, null, 2);
    this.gNd = "";
    localObject = ak.getContext().getSystemService("power");
    if (localObject == null)
    {
      localObject = new v("null cannot be cast to non-null type android.os.PowerManager");
      AppMethodBeat.o(196923);
      throw ((Throwable)localObject);
    }
    localObject = ((PowerManager)localObject).newWakeLock(536870922, "MicroMsg.LiveCoreMini");
    p.g(localObject, "pm.newWakeLock(PowerMana…er.ON_AFTER_RELEASE, TAG)");
    this.gNb = ((PowerManager.WakeLock)localObject);
    if (!this.gNb.isHeld())
    {
      ae.i("MicroMsg.LiveCoreMini", "alvinluo acquire wakeLock");
      this.gNb.acquire();
    }
    AppMethodBeat.o(196923);
  }
  
  public static void yj(String paramString)
  {
    AppMethodBeat.i(196922);
    p.h(paramString, "state");
    AppMethodBeat.o(196922);
  }
  
  public final void amy()
  {
    AppMethodBeat.i(196920);
    Object localObject = b.gNf;
    b.amz();
    localObject = ak.getContext().getSystemService("window");
    if (localObject == null)
    {
      localObject = new v("null cannot be cast to non-null type android.view.WindowManager");
      AppMethodBeat.o(196920);
      throw ((Throwable)localObject);
    }
    localObject = (WindowManager)localObject;
    try
    {
      ((WindowManager)localObject).removeView((View)this.gNc);
      AppMethodBeat.o(196920);
      return;
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      ae.e("MicroMsg.LiveCoreMini", "remove failed", new Object[] { localIllegalArgumentException });
      AppMethodBeat.o(196920);
    }
  }
  
  public final void cx(View paramView)
  {
    AppMethodBeat.i(196921);
    p.h(paramView, "view");
    this.gNc.removeAllViews();
    this.gNc.addView(paramView, (ViewGroup.LayoutParams)new RelativeLayout.LayoutParams(-1, -1));
    AppMethodBeat.o(196921);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.live.core.mini.a
 * JD-Core Version:    0.7.0.1
 */