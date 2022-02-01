package com.tencent.mm.plugin.finder.life;

import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.LifecycleObserver;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.ui.MMActivity;
import d.g.b.k;
import d.l;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/life/SupportLifecycle;", "", "()V", "activateSet", "", "Lcom/tencent/mm/plugin/finder/life/SupportLifecycle$STATUS;", "[Lcom/tencent/mm/plugin/finder/life/SupportLifecycle$STATUS;", "observer", "Lcom/tencent/mm/plugin/finder/life/UILifecycleObserver;", "status", "isActivity", "", "isOnAny", "isOnCreate", "isOnDestroy", "isOnPause", "isOnResume", "isOnStart", "isOnStop", "life", "", "activity", "Lcom/tencent/mm/ui/MMActivity;", "callback", "STATUS", "plugin-finder_release"})
public abstract class a
{
  public a rsR = a.rta;
  public final a[] rsS = { a.rsU, a.rsV, a.rsW, a.rta };
  UILifecycleObserver rsT;
  
  public final void a(MMActivity paramMMActivity, UILifecycleObserver paramUILifecycleObserver)
  {
    k.h(paramMMActivity, "activity");
    ac.i("Finder.EventObserver", "life " + paramMMActivity + ' ' + this);
    this.rsT = ((UILifecycleObserver)new SupportLifecycle.life.1(this, paramUILifecycleObserver, paramMMActivity));
    paramUILifecycleObserver = this.rsT;
    if (paramUILifecycleObserver != null) {
      paramMMActivity.getLifecycle().addObserver((LifecycleObserver)paramUILifecycleObserver);
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/life/SupportLifecycle$STATUS;", "", "(Ljava/lang/String;I)V", "ON_CREATE", "ON_START", "ON_RESUME", "ON_PAUSE", "ON_STOP", "ON_DESTROY", "ON_ANY", "plugin-finder_release"})
  public static enum a
  {
    static
    {
      AppMethodBeat.i(166289);
      a locala1 = new a("ON_CREATE", 0);
      rsU = locala1;
      a locala2 = new a("ON_START", 1);
      rsV = locala2;
      a locala3 = new a("ON_RESUME", 2);
      rsW = locala3;
      a locala4 = new a("ON_PAUSE", 3);
      rsX = locala4;
      a locala5 = new a("ON_STOP", 4);
      rsY = locala5;
      a locala6 = new a("ON_DESTROY", 5);
      rsZ = locala6;
      a locala7 = new a("ON_ANY", 6);
      rta = locala7;
      rtb = new a[] { locala1, locala2, locala3, locala4, locala5, locala6, locala7 };
      AppMethodBeat.o(166289);
    }
    
    private a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.life.a
 * JD-Core Version:    0.7.0.1
 */