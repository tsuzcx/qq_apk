package com.tencent.mm.plugin.finder.video;

import android.content.Context;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.AppForegroundDelegate;
import com.tencent.mm.plugin.finder.music.FinderImgFeedMusicTag;
import com.tencent.mm.plugin.finder.music.a;
import com.tencent.mm.plugin.finder.viewmodel.component.bi;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMFragmentActivity;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/video/FinderVideoCore$onInitialize$2", "Lcom/tencent/mm/plugin/finder/life/UILifecycleObserver;", "hasBlockPauseAction", "", "onCreate", "", "var1", "Landroidx/lifecycle/LifecycleOwner;", "onDestroy", "onPause", "onResume", "onStart", "onStop", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class FinderVideoCore$onInitialize$2
  implements com.tencent.mm.plugin.finder.life.b
{
  private boolean Gqd;
  
  FinderVideoCore$onInitialize$2(l paraml, AppCompatActivity paramAppCompatActivity) {}
  
  public final void onCreate(androidx.lifecycle.q paramq)
  {
    AppMethodBeat.i(335792);
    s.u(paramq, "var1");
    AppMethodBeat.o(335792);
  }
  
  public final void onDestroy(androidx.lifecycle.q paramq)
  {
    AppMethodBeat.i(335821);
    s.u(paramq, "var1");
    AppForegroundDelegate.heY.b((com.tencent.mm.app.q)this.Gqe);
    this.Gqe.fjq().clearAll();
    AppMethodBeat.o(335821);
  }
  
  public final void onPause(androidx.lifecycle.q paramq)
  {
    AppMethodBeat.i(335811);
    s.u(paramq, "var1");
    if (l.b((MMFragmentActivity)this.AIx))
    {
      Log.i("FinderVideoCore", "onPause return for isBlockOnPauseAction true");
      this.Gqd = true;
      AppMethodBeat.o(335811);
      return;
    }
    this.Gqd = false;
    this.Gqe.fjp().hw((Context)this.AIx);
    this.Gqe.fjq().eDQ();
    AppMethodBeat.o(335811);
  }
  
  public final void onResume(androidx.lifecycle.q paramq)
  {
    AppMethodBeat.i(335805);
    s.u(paramq, "var1");
    this.Gqd = false;
    this.Gqe.fjp().hx((Context)this.AIx);
    paramq = ((Map)this.Gqe.fjq().EEK).entrySet().iterator();
    while (paramq.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)paramq.next();
      if ((((FinderImgFeedMusicTag)localEntry.getKey()).EEN) && (((FinderImgFeedMusicTag)localEntry.getKey()).getShouldMusicResume())) {
        ((a)localEntry.getValue()).play();
      }
    }
    AppMethodBeat.o(335805);
  }
  
  public final void onStart(androidx.lifecycle.q paramq)
  {
    AppMethodBeat.i(335796);
    s.u(paramq, "var1");
    AppMethodBeat.o(335796);
  }
  
  public final void onStop(androidx.lifecycle.q paramq)
  {
    AppMethodBeat.i(335817);
    s.u(paramq, "var1");
    if (this.Gqd)
    {
      Log.i("FinderVideoCore", "onStop hasBlockPauseAction true, pause focus video again");
      this.Gqe.fjp().hw((Context)this.AIx);
      this.Gqe.fjq().eDQ();
    }
    AppMethodBeat.o(335817);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.video.FinderVideoCore.onInitialize.2
 * JD-Core Version:    0.7.0.1
 */