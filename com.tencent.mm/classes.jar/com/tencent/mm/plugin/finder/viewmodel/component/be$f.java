package com.tencent.mm.plugin.finder.viewmodel.component;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.video.t;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.b;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/viewmodel/component/FinderVideoRecycler$getOrCreate$3$1$1", "Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderVideoRecycler$IRecycledCallback;", "onRecycledCompleted", "", "videoView", "Lcom/tencent/mm/plugin/finder/video/IFinderVideoView;", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class be$f
  implements be.b
{
  be$f(be parambe, int paramInt, String paramString, b<? super t, ah> paramb) {}
  
  public final boolean b(t paramt)
  {
    AppMethodBeat.i(338755);
    s.u(paramt, "videoView");
    if (s.p(be.f(this.GWa).get(Integer.valueOf(this.GWb)), this.mrQ))
    {
      Log.i("Finder.VideoRecycler", "getOrCreate hit cache for wait recycled for mediaId:" + this.mrQ + ' ' + this.GWb);
      this.GWc.invoke(paramt);
      AppMethodBeat.o(338755);
      return true;
    }
    Log.i("Finder.VideoRecycler", "getOrCreate wait for callback, but it(" + this.mrQ + ") has been replace(" + be.f(this.GWa).get(Integer.valueOf(this.GWb)) + "). key=" + this.GWb);
    AppMethodBeat.o(338755);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.viewmodel.component.be.f
 * JD-Core Version:    0.7.0.1
 */