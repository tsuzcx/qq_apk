package com.tencent.mm.plugin.hld.ui;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.Window;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.e.h;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.gif.MMAnimateView;
import com.tencent.mm.plugin.hld.a.d;
import com.tencent.mm.plugin.hld.a.h;
import com.tencent.mm.plugin.hld.f.k;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.vfs.u;
import kotlin.f;
import kotlin.g;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/hld/ui/HldGuideActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "enterTimestamp", "", "guideView", "Lcom/tencent/mm/plugin/gif/MMAnimateView;", "getGuideView", "()Lcom/tencent/mm/plugin/gif/MMAnimateView;", "guideView$delegate", "Lkotlin/Lazy;", "dispatchTouchEvent", "", "ev", "Landroid/view/MotionEvent;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "Companion", "plugin-hld_release"})
public final class HldGuideActivity
  extends AppCompatActivity
{
  public static final a DFP;
  private final f DFO;
  private final long zUF;
  
  static
  {
    AppMethodBeat.i(214866);
    DFP = new a((byte)0);
    AppMethodBeat.o(214866);
  }
  
  public HldGuideActivity()
  {
    AppMethodBeat.i(214864);
    this.DFO = g.ar((kotlin.g.a.a)new b(this));
    this.zUF = System.currentTimeMillis();
    AppMethodBeat.o(214864);
  }
  
  private final MMAnimateView eFy()
  {
    AppMethodBeat.i(214852);
    MMAnimateView localMMAnimateView = (MMAnimateView)this.DFO.getValue();
    AppMethodBeat.o(214852);
    return localMMAnimateView;
  }
  
  public final boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(214860);
    Log.i("WxIme.HldGuideActivity", "touch finish guide");
    if (System.currentTimeMillis() - this.zUF < 500L)
    {
      Log.d("WxIme.HldGuideActivity", "consume this touch");
      AppMethodBeat.o(214860);
      return true;
    }
    finish();
    overridePendingTransition(0, 0);
    AppMethodBeat.o(214860);
    return false;
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(214857);
    super.onCreate(paramBundle);
    paramBundle = getWindow();
    p.j(paramBundle, "window");
    paramBundle.setStatusBarColor(0);
    paramBundle = getWindow();
    p.j(paramBundle, "window");
    paramBundle.setNavigationBarColor(0);
    setContentView(a.h.ime_active_guide_view);
    paramBundle = k.DHH;
    double d = k.getScreenWidth((Context)this) - com.tencent.mm.ci.a.aZ((Context)this, a.d.Edge_2A) * 2;
    eFy().getLayoutParams().height = ((int)(d * 0.5760869565217391D));
    eFy().setBoundaryCheckInvalid(true);
    paramBundle = u.aY("assets:///hld_guide_animation.gif", 0, -1);
    eFy().g(paramBundle, "");
    eFy().start();
    h.ZvG.n((Runnable)new c(this), 9000L);
    h.ZvG.n((Runnable)new d(this), 500L);
    AppMethodBeat.o(214857);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/hld/ui/HldGuideActivity$Companion;", "", "()V", "TAG", "", "plugin-hld_release"})
  public static final class a {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Lcom/tencent/mm/plugin/gif/MMAnimateView;", "kotlin.jvm.PlatformType", "invoke"})
  static final class b
    extends q
    implements kotlin.g.a.a<MMAnimateView>
  {
    b(HldGuideActivity paramHldGuideActivity)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class c
    implements Runnable
  {
    c(HldGuideActivity paramHldGuideActivity) {}
    
    public final void run()
    {
      AppMethodBeat.i(216973);
      Log.i("WxIme.HldGuideActivity", "time finish guide");
      this.DFQ.finish();
      this.DFQ.overridePendingTransition(0, 0);
      AppMethodBeat.o(216973);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class d
    implements Runnable
  {
    d(HldGuideActivity paramHldGuideActivity) {}
    
    public final void run()
    {
      AppMethodBeat.i(217641);
      this.DFQ.getWindow().addFlags(262160);
      AppMethodBeat.o(217641);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.hld.ui.HldGuideActivity
 * JD-Core Version:    0.7.0.1
 */