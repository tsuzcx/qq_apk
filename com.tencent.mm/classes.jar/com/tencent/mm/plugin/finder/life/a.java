package com.tencent.mm.plugin.finder.life;

import androidx.lifecycle.j;
import androidx.lifecycle.p;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMFragmentActivity;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/life/SupportLifecycle;", "", "()V", "activateSet", "", "Lcom/tencent/mm/plugin/finder/life/SupportLifecycle$STATUS;", "[Lcom/tencent/mm/plugin/finder/life/SupportLifecycle$STATUS;", "observer", "Lcom/tencent/mm/plugin/finder/life/UILifecycleObserver;", "status", "isActivity", "", "isOnAny", "isOnCreate", "isOnDestroy", "isOnPause", "isOnResume", "isOnStart", "isOnStop", "life", "", "activity", "Lcom/tencent/mm/ui/MMFragmentActivity;", "callback", "reLifeObserver", "Landroidx/appcompat/app/AppCompatActivity;", "removeObserver", "STATUS", "plugin-finder-base_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract class a
{
  public a Bvn = a.Bvw;
  public final a[] Bvo = { a.Bvq, a.Bvr, a.Bvs, a.Bvw };
  b Bvp;
  
  public final void a(MMFragmentActivity paramMMFragmentActivity, b paramb)
  {
    s.u(paramMMFragmentActivity, "activity");
    Log.i("Finder.EventObserver", "life " + paramMMFragmentActivity + ' ' + this);
    this.Bvp = ((b)new SupportLifecycle.life.1(this, paramb, paramMMFragmentActivity));
    paramb = this.Bvp;
    if (paramb != null) {
      paramMMFragmentActivity.getLifecycle().addObserver((p)paramb);
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/life/SupportLifecycle$STATUS;", "", "(Ljava/lang/String;I)V", "ON_CREATE", "ON_START", "ON_RESUME", "ON_PAUSE", "ON_STOP", "ON_DESTROY", "ON_ANY", "plugin-finder-base_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static enum a
  {
    static
    {
      AppMethodBeat.i(166289);
      Bvq = new a("ON_CREATE", 0);
      Bvr = new a("ON_START", 1);
      Bvs = new a("ON_RESUME", 2);
      Bvt = new a("ON_PAUSE", 3);
      Bvu = new a("ON_STOP", 4);
      Bvv = new a("ON_DESTROY", 5);
      Bvw = new a("ON_ANY", 6);
      Bvx = new a[] { Bvq, Bvr, Bvs, Bvt, Bvu, Bvv, Bvw };
      AppMethodBeat.o(166289);
    }
    
    private a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.life.a
 * JD-Core Version:    0.7.0.1
 */