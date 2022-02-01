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
import d.g.b.k;
import d.l;
import d.v;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/live/core/mini/LiveMiniManager;", "", "()V", "intent", "Landroid/content/Intent;", "mWakeLock", "Landroid/os/PowerManager$WakeLock;", "Landroid/os/PowerManager;", "miniLayout", "Lcom/tencent/mm/live/core/mini/LiveMiniView;", "resumeActivityName", "", "addRenderView", "", "view", "Landroid/view/View;", "addViewToWindow", "size", "Landroid/graphics/Point;", "release", "removeViewFromWindow", "setup", "activityName", "clickListener", "Landroid/view/View$OnClickListener;", "updateState", "state", "Companion", "plugin-core_release"})
public final class a
{
  public static final a qPb;
  public Intent intent;
  public final LiveMiniView qOQ;
  public String qOR;
  public final PowerManager.WakeLock zqF;
  
  static
  {
    AppMethodBeat.i(205718);
    qPb = new a((byte)0);
    AppMethodBeat.o(205718);
  }
  
  public a()
  {
    AppMethodBeat.i(205717);
    this.intent = new Intent();
    Object localObject = aj.getContext();
    k.g(localObject, "MMApplicationContext.getContext()");
    this.qOQ = new LiveMiniView((Context)localObject, null, 2);
    this.qOR = "";
    localObject = aj.getContext().getSystemService("power");
    if (localObject == null)
    {
      localObject = new v("null cannot be cast to non-null type android.os.PowerManager");
      AppMethodBeat.o(205717);
      throw ((Throwable)localObject);
    }
    localObject = ((PowerManager)localObject).newWakeLock(536870922, "MicroMsg.LiveCoreMini");
    k.g(localObject, "pm.newWakeLock(PowerMana…er.ON_AFTER_RELEASE, TAG)");
    this.zqF = ((PowerManager.WakeLock)localObject);
    if (!this.zqF.isHeld())
    {
      ad.i("MicroMsg.LiveCoreMini", "alvinluo acquire wakeLock");
      this.zqF.acquire();
    }
    AppMethodBeat.o(205717);
  }
  
  public static void aUf(String paramString)
  {
    AppMethodBeat.i(205716);
    k.h(paramString, "state");
    AppMethodBeat.o(205716);
  }
  
  public final void cV(View paramView)
  {
    AppMethodBeat.i(205715);
    k.h(paramView, "view");
    this.qOQ.removeAllViews();
    this.qOQ.addView(paramView, (ViewGroup.LayoutParams)new RelativeLayout.LayoutParams(-1, -1));
    AppMethodBeat.o(205715);
  }
  
  public final void csy()
  {
    AppMethodBeat.i(205714);
    Object localObject = b.qPc;
    b.csA();
    localObject = aj.getContext().getSystemService("window");
    if (localObject == null)
    {
      localObject = new v("null cannot be cast to non-null type android.view.WindowManager");
      AppMethodBeat.o(205714);
      throw ((Throwable)localObject);
    }
    localObject = (WindowManager)localObject;
    try
    {
      ((WindowManager)localObject).removeView((View)this.qOQ);
      AppMethodBeat.o(205714);
      return;
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      ad.e("MicroMsg.LiveCoreMini", "remove failed", new Object[] { localIllegalArgumentException });
      AppMethodBeat.o(205714);
    }
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/live/core/mini/LiveMiniManager$Companion;", "", "()V", "ROUTE_TO_MAXIMIZE", "", "TAG", "plugin-core_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.live.core.mini.a
 * JD-Core Version:    0.7.0.1
 */