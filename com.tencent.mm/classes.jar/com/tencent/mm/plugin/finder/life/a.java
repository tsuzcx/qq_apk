package com.tencent.mm.plugin.finder.life;

import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.LifecycleObserver;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMFragmentActivity;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/life/SupportLifecycle;", "", "()V", "activateSet", "", "Lcom/tencent/mm/plugin/finder/life/SupportLifecycle$STATUS;", "[Lcom/tencent/mm/plugin/finder/life/SupportLifecycle$STATUS;", "observer", "Lcom/tencent/mm/plugin/finder/life/UILifecycleObserver;", "status", "isActivity", "", "isOnAny", "isOnCreate", "isOnDestroy", "isOnPause", "isOnResume", "isOnStart", "isOnStop", "life", "", "activity", "Lcom/tencent/mm/ui/MMFragmentActivity;", "callback", "reLifeObserver", "Landroid/support/v7/app/AppCompatActivity;", "removeObserver", "STATUS", "plugin-finder_release"})
public abstract class a
{
  public a ueU = a.ufd;
  public final a[] ueV = { a.ueX, a.ueY, a.ueZ, a.ufd };
  UILifecycleObserver ueW;
  
  public final void a(MMFragmentActivity paramMMFragmentActivity, UILifecycleObserver paramUILifecycleObserver)
  {
    p.h(paramMMFragmentActivity, "activity");
    Log.i("Finder.EventObserver", "life " + paramMMFragmentActivity + ' ' + this);
    this.ueW = ((UILifecycleObserver)new SupportLifecycle.life.1(this, paramUILifecycleObserver, paramMMFragmentActivity));
    paramUILifecycleObserver = this.ueW;
    if (paramUILifecycleObserver != null) {
      paramMMFragmentActivity.getLifecycle().addObserver((LifecycleObserver)paramUILifecycleObserver);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/life/SupportLifecycle$STATUS;", "", "(Ljava/lang/String;I)V", "ON_CREATE", "ON_START", "ON_RESUME", "ON_PAUSE", "ON_STOP", "ON_DESTROY", "ON_ANY", "plugin-finder_release"})
  public static enum a
  {
    static
    {
      AppMethodBeat.i(166289);
      a locala1 = new a("ON_CREATE", 0);
      ueX = locala1;
      a locala2 = new a("ON_START", 1);
      ueY = locala2;
      a locala3 = new a("ON_RESUME", 2);
      ueZ = locala3;
      a locala4 = new a("ON_PAUSE", 3);
      ufa = locala4;
      a locala5 = new a("ON_STOP", 4);
      ufb = locala5;
      a locala6 = new a("ON_DESTROY", 5);
      ufc = locala6;
      a locala7 = new a("ON_ANY", 6);
      ufd = locala7;
      ufe = new a[] { locala1, locala2, locala3, locala4, locala5, locala6, locala7 };
      AppMethodBeat.o(166289);
    }
    
    private a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.life.a
 * JD-Core Version:    0.7.0.1
 */