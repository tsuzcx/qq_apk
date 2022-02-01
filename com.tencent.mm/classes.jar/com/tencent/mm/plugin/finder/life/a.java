package com.tencent.mm.plugin.finder.life;

import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.LifecycleObserver;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.ui.MMActivity;
import d.g.b.k;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/life/SupportLifecycle;", "", "()V", "activateSet", "", "Lcom/tencent/mm/plugin/finder/life/SupportLifecycle$STATUS;", "[Lcom/tencent/mm/plugin/finder/life/SupportLifecycle$STATUS;", "observer", "Lcom/tencent/mm/plugin/finder/life/UILifecycleObserver;", "status", "isActivity", "", "isOnAny", "isOnCreate", "isOnDestroy", "isOnPause", "isOnResume", "isOnStart", "isOnStop", "life", "", "activity", "Lcom/tencent/mm/ui/MMActivity;", "callback", "STATUS", "plugin-finder_release"})
public abstract class a
{
  public a qBP = a.qBY;
  public final a[] qBQ = { a.qBS, a.qBT, a.qBU, a.qBY };
  UILifecycleObserver qBR;
  
  public final void a(MMActivity paramMMActivity, UILifecycleObserver paramUILifecycleObserver)
  {
    k.h(paramMMActivity, "activity");
    ad.i("Finder.EventObserver", "life " + paramMMActivity + ' ' + this);
    this.qBR = ((UILifecycleObserver)new SupportLifecycle.life.1(this, paramUILifecycleObserver, paramMMActivity));
    paramUILifecycleObserver = this.qBR;
    if (paramUILifecycleObserver != null) {
      paramMMActivity.getLifecycle().addObserver((LifecycleObserver)paramUILifecycleObserver);
    }
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/life/SupportLifecycle$STATUS;", "", "(Ljava/lang/String;I)V", "ON_CREATE", "ON_START", "ON_RESUME", "ON_PAUSE", "ON_STOP", "ON_DESTROY", "ON_ANY", "plugin-finder_release"})
  public static enum a
  {
    static
    {
      AppMethodBeat.i(166289);
      a locala1 = new a("ON_CREATE", 0);
      qBS = locala1;
      a locala2 = new a("ON_START", 1);
      qBT = locala2;
      a locala3 = new a("ON_RESUME", 2);
      qBU = locala3;
      a locala4 = new a("ON_PAUSE", 3);
      qBV = locala4;
      a locala5 = new a("ON_STOP", 4);
      qBW = locala5;
      a locala6 = new a("ON_DESTROY", 5);
      qBX = locala6;
      a locala7 = new a("ON_ANY", 6);
      qBY = locala7;
      qBZ = new a[] { locala1, locala2, locala3, locala4, locala5, locala6, locala7 };
      AppMethodBeat.o(166289);
    }
    
    private a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.life.a
 * JD-Core Version:    0.7.0.1
 */