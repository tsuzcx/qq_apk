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
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import d.g.b.k;
import d.l;
import d.v;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/live/core/mini/LiveMiniManager;", "", "()V", "intent", "Landroid/content/Intent;", "mWakeLock", "Landroid/os/PowerManager$WakeLock;", "Landroid/os/PowerManager;", "miniLayout", "Lcom/tencent/mm/live/core/mini/LiveMiniView;", "resumeActivityName", "", "addRenderView", "", "view", "Landroid/view/View;", "addViewToWindow", "size", "Landroid/graphics/Point;", "release", "removeViewFromWindow", "setup", "activityName", "clickListener", "Landroid/view/View$OnClickListener;", "updateState", "state", "Companion", "plugin-core_release"})
public final class a
{
  public static final a.a gqL;
  public final PowerManager.WakeLock gqI;
  public final LiveMiniView gqJ;
  public String gqK;
  public Intent intent;
  
  static
  {
    AppMethodBeat.i(209254);
    gqL = new a.a((byte)0);
    AppMethodBeat.o(209254);
  }
  
  public a()
  {
    AppMethodBeat.i(209253);
    this.intent = new Intent();
    Object localObject = ai.getContext();
    k.g(localObject, "MMApplicationContext.getContext()");
    this.gqJ = new LiveMiniView((Context)localObject, null, 2);
    this.gqK = "";
    localObject = ai.getContext().getSystemService("power");
    if (localObject == null)
    {
      localObject = new v("null cannot be cast to non-null type android.os.PowerManager");
      AppMethodBeat.o(209253);
      throw ((Throwable)localObject);
    }
    localObject = ((PowerManager)localObject).newWakeLock(536870922, "MicroMsg.LiveCoreMini");
    k.g(localObject, "pm.newWakeLock(PowerMana…er.ON_AFTER_RELEASE, TAG)");
    this.gqI = ((PowerManager.WakeLock)localObject);
    if (!this.gqI.isHeld())
    {
      ac.i("MicroMsg.LiveCoreMini", "alvinluo acquire wakeLock");
      this.gqI.acquire();
    }
    AppMethodBeat.o(209253);
  }
  
  public static void uJ(String paramString)
  {
    AppMethodBeat.i(209252);
    k.h(paramString, "state");
    AppMethodBeat.o(209252);
  }
  
  public final void ajx()
  {
    AppMethodBeat.i(209250);
    Object localObject = b.gqM;
    b.ajy();
    localObject = ai.getContext().getSystemService("window");
    if (localObject == null)
    {
      localObject = new v("null cannot be cast to non-null type android.view.WindowManager");
      AppMethodBeat.o(209250);
      throw ((Throwable)localObject);
    }
    localObject = (WindowManager)localObject;
    try
    {
      ((WindowManager)localObject).removeView((View)this.gqJ);
      AppMethodBeat.o(209250);
      return;
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      ac.e("MicroMsg.LiveCoreMini", "remove failed", new Object[] { localIllegalArgumentException });
      AppMethodBeat.o(209250);
    }
  }
  
  public final void cw(View paramView)
  {
    AppMethodBeat.i(209251);
    k.h(paramView, "view");
    this.gqJ.removeAllViews();
    this.gqJ.addView(paramView, (ViewGroup.LayoutParams)new RelativeLayout.LayoutParams(-1, -1));
    AppMethodBeat.o(209251);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.live.core.mini.a
 * JD-Core Version:    0.7.0.1
 */