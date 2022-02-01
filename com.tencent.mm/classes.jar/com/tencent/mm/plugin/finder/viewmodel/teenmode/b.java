package com.tencent.mm.plugin.finder.viewmodel.teenmode;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.br.c;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.api.f;
import com.tencent.mm.plugin.finder.feed.ui.FinderTeenModeLimitUI;
import com.tencent.mm.plugin.finder.ui.FinderHomeAffinityUI;
import com.tencent.mm.plugin.findersdk.a.bx;
import com.tencent.mm.plugin.findersdk.e.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.mm.ui.component.k;
import com.tencent.mm.ui.component.k.b;
import java.util.HashSet;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/viewmodel/teenmode/FinderTeenModeFloatPageUIC;", "Lcom/tencent/mm/ui/component/UIComponent;", "Lcom/tencent/mm/plugin/findersdk/api/IFinderTeenModeFloatPageUIC;", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "(Landroidx/appcompat/app/AppCompatActivity;)V", "limitListener", "com/tencent/mm/plugin/finder/viewmodel/teenmode/FinderTeenModeFloatPageUIC$limitListener$1", "Lcom/tencent/mm/plugin/finder/viewmodel/teenmode/FinderTeenModeFloatPageUIC$limitListener$1;", "backToFindPage", "", "disableMiniWid", "isFinish", "", "onActivityResult", "requestCode", "", "resultCode", "data", "Landroid/content/Intent;", "onStart", "onStop", "showTeenModeFloatPage", "isCurfew", "Companion", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
  extends UIComponent
  implements bx
{
  public static final b.a GWD;
  private final b GWE;
  
  static
  {
    AppMethodBeat.i(337395);
    GWD = new b.a((byte)0);
    AppMethodBeat.o(337395);
  }
  
  public b(AppCompatActivity paramAppCompatActivity)
  {
    super(paramAppCompatActivity);
    AppMethodBeat.i(337364);
    this.GWE = new b(paramAppCompatActivity, this);
    AppMethodBeat.o(337364);
  }
  
  private static final void a(b paramb)
  {
    AppMethodBeat.i(337376);
    s.u(paramb, "this$0");
    ((com.tencent.d.a.a.a.b)h.az(com.tencent.d.a.a.a.b.class)).pauseVisitorLive();
    ((com.tencent.d.a.a.a.b)h.az(com.tencent.d.a.a.a.b.class)).controlLiveMiniWindowVisibility(false, (Context)paramb.getActivity());
    AppMethodBeat.o(337376);
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(337444);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    Log.i("FinderTeenModeFloatPageUIC", "requestCode: " + paramInt1 + ", " + paramInt2);
    if (paramInt1 == 11111) {
      switch (paramInt2)
      {
      }
    }
    for (;;)
    {
      AppMethodBeat.o(337444);
      return;
      if (getActivity().getIntent().getIntExtra("FROM_SCENE_KEY", 2) == 6) {}
      for (paramInt1 = 1;; paramInt1 = 0)
      {
        paramIntent = a.HdV;
        if ((!a.ay((Activity)getActivity())) && (paramInt1 == 0))
        {
          paramIntent = new Intent();
          paramIntent.addFlags(67108864);
          paramIntent.addFlags(268435456);
          paramIntent.putExtra("preferred_tab", 2);
          c.g((Context)getActivity(), ".ui.LauncherUI", paramIntent);
        }
        if ((getActivity().isFinishing() | getActivity().isDestroyed())) {
          break;
        }
        if (!(getActivity() instanceof FinderHomeAffinityUI)) {
          break label212;
        }
        getActivity().finishAndRemoveTask();
        AppMethodBeat.o(337444);
        return;
      }
      label212:
      getActivity().finish();
      AppMethodBeat.o(337444);
      return;
      paramIntent = a.HdV;
      if (a.ay((Activity)getActivity())) {
        ((com.tencent.d.a.a.a.b)h.az(com.tencent.d.a.a.a.b.class)).resumeVisitorLive();
      }
    }
  }
  
  public final void onStart()
  {
    AppMethodBeat.i(337413);
    super.onStart();
    ??? = k.aeZF;
    d locald = (d)k.cn(PluginFinder.class).q(d.class);
    f localf = (f)this.GWE;
    s.u(localf, "listener");
    synchronized (locald.GWJ)
    {
      locald.GWJ.add(localf);
      AppMethodBeat.o(337413);
      return;
    }
  }
  
  public final void onStop()
  {
    AppMethodBeat.i(337427);
    super.onStop();
    ??? = k.aeZF;
    d locald = (d)k.cn(PluginFinder.class).q(d.class);
    f localf = (f)this.GWE;
    s.u(localf, "listener");
    synchronized (locald.GWJ)
    {
      locald.GWJ.remove(localf);
      AppMethodBeat.o(337427);
      return;
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/viewmodel/teenmode/FinderTeenModeFloatPageUIC$limitListener$1", "Lcom/tencent/mm/plugin/finder/api/IEnjoyFinderOverLimit;", "onEnjoyFinderOverLimit", "", "isCurfew", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
    implements f
  {
    b(AppCompatActivity paramAppCompatActivity, b paramb) {}
    
    public final void pG(boolean paramBoolean)
    {
      AppMethodBeat.i(337312);
      Object localObject = a.HdV;
      if (a.ay((Activity)this.Awh)) {
        b.b(jdField_this);
      }
      localObject = jdField_this;
      Intent localIntent = new Intent();
      localIntent.putExtra("key_is_curfew", paramBoolean);
      localIntent.setClass((Context)((b)localObject).getActivity(), FinderTeenModeLimitUI.class);
      ((b)localObject).getActivity().startActivityForResult(localIntent, 11111);
      AppMethodBeat.o(337312);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.viewmodel.teenmode.b
 * JD-Core Version:    0.7.0.1
 */