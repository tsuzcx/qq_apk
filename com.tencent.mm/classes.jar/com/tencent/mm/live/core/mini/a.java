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
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import d.g.b.p;
import d.l;
import d.v;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/live/core/mini/LiveMiniManager;", "", "()V", "intent", "Landroid/content/Intent;", "mWakeLock", "Landroid/os/PowerManager$WakeLock;", "Landroid/os/PowerManager;", "miniLayout", "Lcom/tencent/mm/live/core/mini/LiveMiniView;", "resumeActivityName", "", "addRenderView", "", "view", "Landroid/view/View;", "addViewToWindow", "size", "Landroid/graphics/Point;", "release", "removeViewFromWindow", "setup", "activityName", "clickListener", "Landroid/view/View$OnClickListener;", "updateState", "state", "Companion", "plugin-core_release"})
public final class a
{
  public static final a.a gKv;
  public final PowerManager.WakeLock gKs;
  public final LiveMiniView gKt;
  public String gKu;
  public Intent intent;
  
  static
  {
    AppMethodBeat.i(216912);
    gKv = new a.a((byte)0);
    AppMethodBeat.o(216912);
  }
  
  public a()
  {
    AppMethodBeat.i(216911);
    this.intent = new Intent();
    Object localObject = aj.getContext();
    p.g(localObject, "MMApplicationContext.getContext()");
    this.gKt = new LiveMiniView((Context)localObject, null, 2);
    this.gKu = "";
    localObject = aj.getContext().getSystemService("power");
    if (localObject == null)
    {
      localObject = new v("null cannot be cast to non-null type android.os.PowerManager");
      AppMethodBeat.o(216911);
      throw ((Throwable)localObject);
    }
    localObject = ((PowerManager)localObject).newWakeLock(536870922, "MicroMsg.LiveCoreMini");
    p.g(localObject, "pm.newWakeLock(PowerMana…er.ON_AFTER_RELEASE, TAG)");
    this.gKs = ((PowerManager.WakeLock)localObject);
    if (!this.gKs.isHeld())
    {
      ad.i("MicroMsg.LiveCoreMini", "alvinluo acquire wakeLock");
      this.gKs.acquire();
    }
    AppMethodBeat.o(216911);
  }
  
  public static void xA(String paramString)
  {
    AppMethodBeat.i(216910);
    p.h(paramString, "state");
    AppMethodBeat.o(216910);
  }
  
  public final void amj()
  {
    AppMethodBeat.i(216908);
    Object localObject = b.gKw;
    b.amk();
    localObject = aj.getContext().getSystemService("window");
    if (localObject == null)
    {
      localObject = new v("null cannot be cast to non-null type android.view.WindowManager");
      AppMethodBeat.o(216908);
      throw ((Throwable)localObject);
    }
    localObject = (WindowManager)localObject;
    try
    {
      ((WindowManager)localObject).removeView((View)this.gKt);
      AppMethodBeat.o(216908);
      return;
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      ad.e("MicroMsg.LiveCoreMini", "remove failed", new Object[] { localIllegalArgumentException });
      AppMethodBeat.o(216908);
    }
  }
  
  public final void cx(View paramView)
  {
    AppMethodBeat.i(216909);
    p.h(paramView, "view");
    this.gKt.removeAllViews();
    this.gKt.addView(paramView, (ViewGroup.LayoutParams)new RelativeLayout.LayoutParams(-1, -1));
    AppMethodBeat.o(216909);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.live.core.mini.a
 * JD-Core Version:    0.7.0.1
 */