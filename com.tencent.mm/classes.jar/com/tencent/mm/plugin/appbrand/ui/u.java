package com.tencent.mm.plugin.appbrand.ui;

import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.luggage.sdk.e.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.task.q;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.ui.component.UIComponent;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/ui/AppBrandUIBackPressedInterceptorComponent;", "Lcom/tencent/mm/ui/component/UIComponent;", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "(Landroidx/appcompat/app/AppCompatActivity;)V", "H", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "mEatBackPressed", "", "mResetRunner", "Ljava/lang/Runnable;", "mWaitForEnterAnimationComplete", "enableBackPressNow", "", "onBackPressed", "onBroughtToFront", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onEnterAnimationComplete", "onNewIntent", "intent", "Landroid/content/Intent;", "onStart", "onStop", "Companion", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class u
  extends UIComponent
{
  private static final u.a ufc;
  private final MMHandler sVR;
  private boolean ufd;
  private boolean ufe;
  private final Runnable uff;
  
  static
  {
    AppMethodBeat.i(322198);
    ufc = new u.a((byte)0);
    AppMethodBeat.o(322198);
  }
  
  public u(AppCompatActivity paramAppCompatActivity)
  {
    super(paramAppCompatActivity);
    AppMethodBeat.i(322183);
    this.sVR = new MMHandler(Looper.getMainLooper());
    this.uff = new u..ExternalSyntheticLambda0(this);
    AppMethodBeat.o(322183);
  }
  
  private static final void a(u paramu)
  {
    AppMethodBeat.i(322194);
    s.u(paramu, "this$0");
    if (com.tencent.mm.sdk.platformtools.Log.getLogLevel() <= 1) {
      com.tencent.mm.sdk.platformtools.Log.d("MicroMsg.AppBrandUIBackPressedInterceptorComponent", s.X("assign mEatBackPressed=false, stack:", android.util.Log.getStackTraceString(new Throwable())));
    }
    paramu.ufe = false;
    AppMethodBeat.o(322194);
  }
  
  private final void cLz()
  {
    AppMethodBeat.i(322187);
    if ((getActivity().isDestroyed()) || (getActivity().isFinishing()))
    {
      AppMethodBeat.o(322187);
      return;
    }
    this.ufd = true;
    this.sVR.postDelayed(this.uff, 433L);
    AppMethodBeat.o(322187);
  }
  
  public final void cLy()
  {
    AppMethodBeat.i(322208);
    this.sVR.removeCallbacks(this.uff);
    this.uff.run();
    AppMethodBeat.o(322208);
  }
  
  public final boolean onBackPressed()
  {
    AppMethodBeat.i(322215);
    Object localObject = q.tWE;
    q.b((AppBrandUI)getActivity(), "onBackPressed(mEatBackPressed:" + this.ufe + ')');
    if (this.ufe)
    {
      AppMethodBeat.o(322215);
      return true;
    }
    localObject = ((AppBrandUI)getActivity()).mRuntimeContainer;
    if ((localObject instanceof b)) {}
    for (localObject = (b)localObject; localObject != null; localObject = null)
    {
      ((b)localObject).onBackPressed();
      AppMethodBeat.o(322215);
      return true;
    }
    AppMethodBeat.o(322215);
    return false;
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(322218);
    super.onCreate(paramBundle);
    cLz();
    AppMethodBeat.o(322218);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(322236);
    super.onDestroy();
    this.sVR.removeCallbacksAndMessages(null);
    AppMethodBeat.o(322236);
  }
  
  public final void onNewIntent(Intent paramIntent)
  {
    AppMethodBeat.i(322223);
    super.onNewIntent(paramIntent);
    cLz();
    AppMethodBeat.o(322223);
  }
  
  public final void onStart()
  {
    AppMethodBeat.i(322228);
    super.onStart();
    if (!this.ufd) {
      cLy();
    }
    AppMethodBeat.o(322228);
  }
  
  public final void onStop()
  {
    AppMethodBeat.i(322231);
    super.onStop();
    this.sVR.removeCallbacks(this.uff);
    this.ufe = true;
    this.ufd = false;
    AppMethodBeat.o(322231);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.u
 * JD-Core Version:    0.7.0.1
 */