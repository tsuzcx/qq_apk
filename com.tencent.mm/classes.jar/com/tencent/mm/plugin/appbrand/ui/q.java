package com.tencent.mm.plugin.appbrand.ui;

import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.luggage.sdk.e.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ak;
import com.tencent.mm.plugin.appbrand.task.r;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.ui.component.UIComponent;
import kotlin.l;
import kotlin.t;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/ui/AppBrandUIBackPressedInterceptorComponent;", "Lcom/tencent/mm/ui/component/UIComponent;", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "(Landroidx/appcompat/app/AppCompatActivity;)V", "H", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "mEatBackPressed", "", "mResetRunner", "Ljava/lang/Runnable;", "mWaitForEnterAnimationComplete", "enableBackPressNow", "", "onBackPressed", "onBroughtToFront", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onEnterAnimationComplete", "onNewIntent", "intent", "Landroid/content/Intent;", "onStart", "onStop", "Companion", "plugin-appbrand-integration_release"})
public final class q
  extends UIComponent
{
  @Deprecated
  public static final q.a qZe;
  private final MMHandler pRi;
  private boolean qZb;
  private boolean qZc;
  private final Runnable qZd;
  
  static
  {
    AppMethodBeat.i(277988);
    qZe = new q.a((byte)0);
    AppMethodBeat.o(277988);
  }
  
  public q(AppCompatActivity paramAppCompatActivity)
  {
    super(paramAppCompatActivity);
    AppMethodBeat.i(277987);
    this.pRi = new MMHandler(Looper.getMainLooper());
    this.qZd = ((Runnable)new b(this));
    AppMethodBeat.o(277987);
  }
  
  private final void ckl()
  {
    AppMethodBeat.i(277983);
    if ((getActivity().isDestroyed()) || (getActivity().isFinishing()))
    {
      AppMethodBeat.o(277983);
      return;
    }
    this.qZb = true;
    this.pRi.postDelayed(this.qZd, 433L);
    AppMethodBeat.o(277983);
  }
  
  public final void ckk()
  {
    AppMethodBeat.i(277978);
    this.pRi.removeCallbacks(this.qZd);
    this.qZd.run();
    AppMethodBeat.o(277978);
  }
  
  public final boolean onBackPressed()
  {
    AppMethodBeat.i(277979);
    Object localObject = r.qRZ;
    localObject = getActivity();
    if (localObject == null)
    {
      localObject = new t("null cannot be cast to non-null type com.tencent.mm.plugin.appbrand.ui.AppBrandUI");
      AppMethodBeat.o(277979);
      throw ((Throwable)localObject);
    }
    r.b((AppBrandUI)localObject, "onBackPressed(mEatBackPressed:" + this.qZc + ')');
    if (this.qZc)
    {
      AppMethodBeat.o(277979);
      return true;
    }
    localObject = getActivity();
    if (localObject == null)
    {
      localObject = new t("null cannot be cast to non-null type com.tencent.mm.plugin.appbrand.ui.AppBrandUI");
      AppMethodBeat.o(277979);
      throw ((Throwable)localObject);
    }
    ak localak = ((AppBrandUI)localObject).bBY();
    localObject = localak;
    if (!(localak instanceof b)) {
      localObject = null;
    }
    localObject = (b)localObject;
    if (localObject != null)
    {
      ((b)localObject).onBackPressed();
      AppMethodBeat.o(277979);
      return true;
    }
    AppMethodBeat.o(277979);
    return false;
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(277981);
    super.onCreate(paramBundle);
    ckl();
    AppMethodBeat.o(277981);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(277986);
    super.onDestroy();
    this.pRi.removeCallbacksAndMessages(null);
    AppMethodBeat.o(277986);
  }
  
  public final void onNewIntent(Intent paramIntent)
  {
    AppMethodBeat.i(277982);
    super.onNewIntent(paramIntent);
    ckl();
    AppMethodBeat.o(277982);
  }
  
  public final void onStart()
  {
    AppMethodBeat.i(277984);
    super.onStart();
    if (!this.qZb) {
      ckk();
    }
    AppMethodBeat.o(277984);
  }
  
  public final void onStop()
  {
    AppMethodBeat.i(277985);
    super.onStop();
    this.pRi.removeCallbacks(this.qZd);
    this.qZc = true;
    this.qZb = false;
    AppMethodBeat.o(277985);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class b
    implements Runnable
  {
    b(q paramq) {}
    
    public final void run()
    {
      AppMethodBeat.i(276081);
      if (com.tencent.mm.sdk.platformtools.Log.getLogLevel() <= 1)
      {
        q.ckm();
        com.tencent.mm.sdk.platformtools.Log.d("MicroMsg.AppBrandUIBackPressedInterceptorComponent", "assign mEatBackPressed=false, stack:" + android.util.Log.getStackTraceString(new Throwable()));
      }
      q.a(this.qZf);
      AppMethodBeat.o(276081);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.q
 * JD-Core Version:    0.7.0.1
 */