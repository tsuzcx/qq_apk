package com.tencent.mm.plugin.finder.video;

import android.arch.lifecycle.LifecycleOwner;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ac.d;
import com.tencent.mm.app.AppForegroundDelegate;
import com.tencent.mm.app.o;
import com.tencent.mm.plugin.finder.life.UILifecycleObserver;
import com.tencent.mm.plugin.finder.music.FinderImgFeedMusicPlayerManager;
import com.tencent.mm.plugin.finder.music.FinderImgFeedMusicTag;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderVideoRecycler;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderVideoRecycler.r;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/video/FinderVideoCore$onInitialize$2", "Lcom/tencent/mm/plugin/finder/life/UILifecycleObserver;", "onCreate", "", "var1", "Landroid/arch/lifecycle/LifecycleOwner;", "onDestroy", "onPause", "onResume", "onStart", "onStop", "plugin-finder_release"})
public final class FinderVideoCore$onInitialize$2
  implements UILifecycleObserver
{
  FinderVideoCore$onInitialize$2(AppCompatActivity paramAppCompatActivity) {}
  
  public final void onCreate(LifecycleOwner paramLifecycleOwner)
  {
    AppMethodBeat.i(168030);
    p.h(paramLifecycleOwner, "var1");
    AppMethodBeat.o(168030);
  }
  
  public final void onDestroy(LifecycleOwner paramLifecycleOwner)
  {
    AppMethodBeat.i(168035);
    p.h(paramLifecycleOwner, "var1");
    AppForegroundDelegate.djR.b((o)this.weX);
    this.weX.dFy().clear();
    AppMethodBeat.o(168035);
  }
  
  public final void onPause(LifecycleOwner paramLifecycleOwner)
  {
    AppMethodBeat.i(168033);
    p.h(paramLifecycleOwner, "var1");
    this.weX.dFx().fJ((Context)this.vao);
    paramLifecycleOwner = ((Map)this.weX.dFy().uPC).entrySet().iterator();
    while (paramLifecycleOwner.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)paramLifecycleOwner.next();
      if (((FinderImgFeedMusicTag)localEntry.getKey()).uPE)
      {
        ((FinderImgFeedMusicTag)localEntry.getKey()).setShouldMusicResume(((com.tencent.mm.plugin.finder.music.a)localEntry.getValue()).isPlaying());
        ((FinderImgFeedMusicTag)localEntry.getKey()).bdY();
      }
    }
    AppMethodBeat.o(168033);
  }
  
  public final void onResume(LifecycleOwner paramLifecycleOwner)
  {
    AppMethodBeat.i(168032);
    p.h(paramLifecycleOwner, "var1");
    d.h((kotlin.g.a.a)new FinderVideoRecycler.r(this.weX.dFx(), (Context)this.vao));
    paramLifecycleOwner = ((Map)this.weX.dFy().uPC).entrySet().iterator();
    while (paramLifecycleOwner.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)paramLifecycleOwner.next();
      if ((((FinderImgFeedMusicTag)localEntry.getKey()).uPE) && (((FinderImgFeedMusicTag)localEntry.getKey()).getShouldMusicResume())) {
        ((com.tencent.mm.plugin.finder.music.a)localEntry.getValue()).play();
      }
    }
    AppMethodBeat.o(168032);
  }
  
  public final void onStart(LifecycleOwner paramLifecycleOwner)
  {
    AppMethodBeat.i(168031);
    p.h(paramLifecycleOwner, "var1");
    AppMethodBeat.o(168031);
  }
  
  public final void onStop(LifecycleOwner paramLifecycleOwner)
  {
    AppMethodBeat.i(168034);
    p.h(paramLifecycleOwner, "var1");
    AppMethodBeat.o(168034);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.video.FinderVideoCore.onInitialize.2
 * JD-Core Version:    0.7.0.1
 */