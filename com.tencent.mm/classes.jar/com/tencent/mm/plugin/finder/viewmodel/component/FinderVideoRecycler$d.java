package com.tencent.mm.plugin.finder.viewmodel.component;

import android.content.Context;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.video.o;
import com.tencent.mm.sdk.platformtools.ae;
import d.g.a.b;
import d.g.b.p;
import d.l;
import java.util.HashMap;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/finder/viewmodel/component/FinderVideoRecycler$getOrCreate$3$1$1", "Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderVideoRecycler$IRecycledCallback;", "onRecycledCompleted", "", "videoView", "Lcom/tencent/mm/plugin/finder/video/IFinderVideoView;", "plugin-finder_release", "com/tencent/mm/plugin/finder/viewmodel/component/FinderVideoRecycler$$special$$inlined$let$lambda$1"})
public final class FinderVideoRecycler$d
  implements FinderVideoRecycler.b
{
  FinderVideoRecycler$d(int paramInt, FinderVideoRecycler paramFinderVideoRecycler, Class paramClass, ViewGroup paramViewGroup, String paramString, b paramb, Context paramContext, boolean paramBoolean) {}
  
  public final boolean a(o paramo)
  {
    AppMethodBeat.i(206363);
    p.h(paramo, "videoView");
    if (p.i((String)FinderVideoRecycler.k(this.toA).get(Integer.valueOf(this.toz)), this.ssr))
    {
      ae.i("Finder.VideoRecycler", "[getOrCreate] wait for callback successfully. mediaId=" + this.ssr + " parent=" + this.toz);
      this.toD.invoke(paramo);
      AppMethodBeat.o(206363);
      return true;
    }
    ae.i("Finder.VideoRecycler", "wait for callback, but it(" + this.ssr + ") has been replace(" + (String)FinderVideoRecycler.k(this.toA).get(Integer.valueOf(this.toz)) + "). key=" + this.toz);
    AppMethodBeat.o(206363);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.viewmodel.component.FinderVideoRecycler.d
 * JD-Core Version:    0.7.0.1
 */