package com.tencent.mm.plugin.finder.video;

import android.content.Context;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.AppForegroundDelegate;
import com.tencent.mm.app.o;
import com.tencent.mm.plugin.finder.live.n;
import com.tencent.mm.plugin.finder.music.FinderImgFeedMusicTag;
import com.tencent.mm.plugin.finder.music.a;
import com.tencent.mm.plugin.finder.viewmodel.component.au;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import kotlin.g.b.p;

@kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/video/FinderVideoCore$onInitialize$2", "Lcom/tencent/mm/plugin/finder/life/UILifecycleObserver;", "onCreate", "", "var1", "Landroidx/lifecycle/LifecycleOwner;", "onDestroy", "onPause", "onResume", "onStart", "onStop", "plugin-finder_release"})
public final class FinderVideoCore$onInitialize$2
  implements com.tencent.mm.plugin.finder.life.b
{
  FinderVideoCore$onInitialize$2(AppCompatActivity paramAppCompatActivity) {}
  
  public final void onCreate(androidx.lifecycle.l paraml)
  {
    AppMethodBeat.i(257590);
    p.k(paraml, "var1");
    AppMethodBeat.o(257590);
  }
  
  public final void onDestroy(androidx.lifecycle.l paraml)
  {
    AppMethodBeat.i(257597);
    p.k(paraml, "var1");
    AppForegroundDelegate.fby.b((o)this.ANG);
    this.ANG.ehm().clear();
    AppMethodBeat.o(257597);
  }
  
  public final void onPause(androidx.lifecycle.l paraml)
  {
    AppMethodBeat.i(257595);
    p.k(paraml, "var1");
    this.ANG.ehl().gb((Context)this.zQu);
    paraml = ((Map)this.ANG.ehm().zBX).entrySet().iterator();
    while (paraml.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)paraml.next();
      if (((FinderImgFeedMusicTag)localEntry.getKey()).zBZ)
      {
        ((FinderImgFeedMusicTag)localEntry.getKey()).setShouldMusicResume(((a)localEntry.getValue()).isPlaying());
        ((FinderImgFeedMusicTag)localEntry.getKey()).bnt();
      }
    }
    this.ANG.ehn().MX(this.ANG.fEH);
    AppMethodBeat.o(257595);
  }
  
  public final void onResume(androidx.lifecycle.l paraml)
  {
    AppMethodBeat.i(257594);
    p.k(paraml, "var1");
    this.ANG.ehl().gc((Context)this.zQu);
    paraml = ((Map)this.ANG.ehm().zBX).entrySet().iterator();
    while (paraml.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)paraml.next();
      if ((((FinderImgFeedMusicTag)localEntry.getKey()).zBZ) && (((FinderImgFeedMusicTag)localEntry.getKey()).getShouldMusicResume())) {
        ((a)localEntry.getValue()).play();
      }
    }
    this.ANG.ehn().MW(this.ANG.fEH);
    AppMethodBeat.o(257594);
  }
  
  public final void onStart(androidx.lifecycle.l paraml)
  {
    AppMethodBeat.i(257591);
    p.k(paraml, "var1");
    AppMethodBeat.o(257591);
  }
  
  public final void onStop(androidx.lifecycle.l paraml)
  {
    AppMethodBeat.i(257596);
    p.k(paraml, "var1");
    AppMethodBeat.o(257596);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.video.FinderVideoCore.onInitialize.2
 * JD-Core Version:    0.7.0.1
 */