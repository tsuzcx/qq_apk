package com.tencent.mm.plugin.finder.viewmodel.component;

import android.content.Context;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.h;
import androidx.lifecycle.h.a;
import androidx.lifecycle.k;
import androidx.lifecycle.t;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.HashSet;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/viewmodel/component/FinderVideoRecycler$make$1", "Landroidx/lifecycle/LifecycleObserver;", "onDestroy", "", "plugin-finder_release"})
public final class FinderVideoRecycler$make$1
  implements k
{
  FinderVideoRecycler$make$1(AppCompatActivity paramAppCompatActivity, String paramString) {}
  
  @t(jl=h.a.ON_DESTROY)
  public final void onDestroy()
  {
    AppMethodBeat.i(268734);
    Log.i("Finder.VideoRecycler", "onDestroy activityCount:" + as.b(this.Bpm));
    as localas = this.Bpm;
    as.a(localas, as.b(localas) - 1);
    if (as.b(this.Bpm) == 0) {
      as.c(this.Bpm);
    }
    for (;;)
    {
      as.d(this.Bpm).remove(this.$key);
      this.wYZ.getLifecycle().b((k)this);
      AppMethodBeat.o(268734);
      return;
      this.Bpm.ga((Context)this.wYZ);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.viewmodel.component.FinderVideoRecycler.make.1
 * JD-Core Version:    0.7.0.1
 */