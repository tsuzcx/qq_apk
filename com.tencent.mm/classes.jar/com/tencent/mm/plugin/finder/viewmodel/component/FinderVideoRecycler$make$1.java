package com.tencent.mm.plugin.finder.viewmodel.component;

import android.content.Context;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.j;
import androidx.lifecycle.j.a;
import androidx.lifecycle.p;
import androidx.lifecycle.z;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.HashSet;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/viewmodel/component/FinderVideoRecycler$make$1", "Landroidx/lifecycle/LifecycleObserver;", "onDestroy", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class FinderVideoRecycler$make$1
  implements p
{
  FinderVideoRecycler$make$1(be parambe, AppCompatActivity paramAppCompatActivity, String paramString) {}
  
  @z(Ho=j.a.ON_DESTROY)
  public final void onDestroy()
  {
    AppMethodBeat.i(338781);
    Log.i("Finder.VideoRecycler", s.X("onDestroy activityCount:", Integer.valueOf(be.c(this.GVS))));
    be localbe = this.GVS;
    be.a(localbe, be.c(localbe) - 1);
    if (be.c(this.GVS) == 0) {
      be.d(this.GVS);
    }
    for (;;)
    {
      be.e(this.GVS).remove(this.$key);
      this.Awh.getLifecycle().removeObserver((p)this);
      AppMethodBeat.o(338781);
      return;
      be.a(this.GVS, (Context)this.Awh);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.viewmodel.component.FinderVideoRecycler.make.1
 * JD-Core Version:    0.7.0.1
 */