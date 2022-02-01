package com.tencent.mm.plugin.finder.life;

import androidx.lifecycle.h;
import androidx.lifecycle.k;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMFragmentActivity;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/life/SupportLifecycle;", "", "()V", "activateSet", "", "Lcom/tencent/mm/plugin/finder/life/SupportLifecycle$STATUS;", "[Lcom/tencent/mm/plugin/finder/life/SupportLifecycle$STATUS;", "observer", "Lcom/tencent/mm/plugin/finder/life/UILifecycleObserver;", "status", "isActivity", "", "isOnAny", "isOnCreate", "isOnDestroy", "isOnPause", "isOnResume", "isOnStart", "isOnStop", "life", "", "activity", "Lcom/tencent/mm/ui/MMFragmentActivity;", "callback", "reLifeObserver", "Landroidx/appcompat/app/AppCompatActivity;", "removeObserver", "STATUS", "plugin-finder-base_release"})
public abstract class a
{
  public a xUo = a.xUx;
  public final a[] xUp = { a.xUr, a.xUs, a.xUt, a.xUx };
  b xUq;
  
  public final void a(MMFragmentActivity paramMMFragmentActivity, b paramb)
  {
    p.k(paramMMFragmentActivity, "activity");
    Log.i("Finder.EventObserver", "life " + paramMMFragmentActivity + ' ' + this);
    this.xUq = ((b)new SupportLifecycle.life.1(this, paramb, paramMMFragmentActivity));
    paramb = this.xUq;
    if (paramb != null) {
      paramMMFragmentActivity.getLifecycle().a((k)paramb);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/life/SupportLifecycle$STATUS;", "", "(Ljava/lang/String;I)V", "ON_CREATE", "ON_START", "ON_RESUME", "ON_PAUSE", "ON_STOP", "ON_DESTROY", "ON_ANY", "plugin-finder-base_release"})
  public static enum a
  {
    static
    {
      AppMethodBeat.i(166289);
      a locala1 = new a("ON_CREATE", 0);
      xUr = locala1;
      a locala2 = new a("ON_START", 1);
      xUs = locala2;
      a locala3 = new a("ON_RESUME", 2);
      xUt = locala3;
      a locala4 = new a("ON_PAUSE", 3);
      xUu = locala4;
      a locala5 = new a("ON_STOP", 4);
      xUv = locala5;
      a locala6 = new a("ON_DESTROY", 5);
      xUw = locala6;
      a locala7 = new a("ON_ANY", 6);
      xUx = locala7;
      xUy = new a[] { locala1, locala2, locala3, locala4, locala5, locala6, locala7 };
      AppMethodBeat.o(166289);
    }
    
    private a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.life.a
 * JD-Core Version:    0.7.0.1
 */