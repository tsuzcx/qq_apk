package com.tencent.mm.plugin.hld.ui;

import android.content.Context;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.Window;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.gif.MMAnimateView;
import com.tencent.mm.plugin.hld.a.d;
import com.tencent.mm.plugin.hld.a.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.vfs.y;
import com.tencent.threadpool.h;
import com.tencent.threadpool.i;
import kotlin.Metadata;
import kotlin.g.b.s;
import kotlin.g.b.u;
import kotlin.j;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/hld/ui/HldGuideActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "enterTimestamp", "", "guideView", "Lcom/tencent/mm/plugin/gif/MMAnimateView;", "getGuideView", "()Lcom/tencent/mm/plugin/gif/MMAnimateView;", "guideView$delegate", "Lkotlin/Lazy;", "dispatchTouchEvent", "", "ev", "Landroid/view/MotionEvent;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "Companion", "plugin-hld_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class HldGuideActivity
  extends AppCompatActivity
{
  public static final HldGuideActivity.a Jxr;
  private final long AxK;
  private final j Jxs;
  
  static
  {
    AppMethodBeat.i(312503);
    Jxr = new HldGuideActivity.a((byte)0);
    AppMethodBeat.o(312503);
  }
  
  public HldGuideActivity()
  {
    AppMethodBeat.i(312444);
    this.Jxs = kotlin.k.cm((kotlin.g.a.a)new b(this));
    this.AxK = System.currentTimeMillis();
    AppMethodBeat.o(312444);
  }
  
  private static final void a(HldGuideActivity paramHldGuideActivity)
  {
    AppMethodBeat.i(312477);
    s.u(paramHldGuideActivity, "this$0");
    Log.i("WxIme.HldGuideActivity", "time finish guide");
    paramHldGuideActivity.finish();
    paramHldGuideActivity.overridePendingTransition(0, 0);
    AppMethodBeat.o(312477);
  }
  
  private static final void b(HldGuideActivity paramHldGuideActivity)
  {
    AppMethodBeat.i(312490);
    s.u(paramHldGuideActivity, "this$0");
    paramHldGuideActivity.getWindow().addFlags(262160);
    AppMethodBeat.o(312490);
  }
  
  private final MMAnimateView fNr()
  {
    AppMethodBeat.i(312458);
    Object localObject = this.Jxs.getValue();
    s.s(localObject, "<get-guideView>(...)");
    localObject = (MMAnimateView)localObject;
    AppMethodBeat.o(312458);
    return localObject;
  }
  
  public final boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(312563);
    Log.i("WxIme.HldGuideActivity", "touch finish guide");
    if (System.currentTimeMillis() - this.AxK < 500L)
    {
      Log.d("WxIme.HldGuideActivity", "consume this touch");
      AppMethodBeat.o(312563);
      return true;
    }
    finish();
    overridePendingTransition(0, 0);
    AppMethodBeat.o(312563);
    return false;
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(312551);
    super.onCreate(paramBundle);
    getWindow().setStatusBarColor(0);
    getWindow().setNavigationBarColor(0);
    setContentView(a.h.ime_active_guide_view);
    paramBundle = com.tencent.mm.plugin.hld.f.k.JyF;
    double d = com.tencent.mm.plugin.hld.f.k.getScreenWidth((Context)this) - com.tencent.mm.cd.a.bs((Context)this, a.d.Edge_2A) * 2;
    fNr().getLayoutParams().height = ((int)(d * 0.5760869565217391D));
    fNr().setBoundaryCheckInvalid(true);
    paramBundle = y.bi("assets:///hld_guide_animation.gif", 0, -1);
    fNr().g(paramBundle, "");
    fNr().start();
    h.ahAA.o(new HldGuideActivity..ExternalSyntheticLambda1(this), 9000L);
    h.ahAA.o(new HldGuideActivity..ExternalSyntheticLambda0(this), 500L);
    AppMethodBeat.o(312551);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/plugin/gif/MMAnimateView;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements kotlin.g.a.a<MMAnimateView>
  {
    b(HldGuideActivity paramHldGuideActivity)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.hld.ui.HldGuideActivity
 * JD-Core Version:    0.7.0.1
 */