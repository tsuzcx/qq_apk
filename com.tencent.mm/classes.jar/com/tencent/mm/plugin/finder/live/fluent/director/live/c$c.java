package com.tencent.mm.plugin.finder.live.fluent.director.live;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.live.core.view.LiveVideoView;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.rtmp.ITXLivePlayListener;
import kotlin.Metadata;
import kotlin.ah;

@Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/live/fluent/director/live/SwitchOutLiveDirector$switchInLiveRoom$1", "Lcom/tencent/rtmp/ITXLivePlayListener;", "onNetStatus", "", "p0", "Landroid/os/Bundle;", "onPlayEvent", "event", "", "params", "plugin-finder-base_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class c$c
  implements ITXLivePlayListener
{
  c$c(c paramc, LiveVideoView paramLiveVideoView, kotlin.g.a.a<ah> parama) {}
  
  public final void onNetStatus(Bundle paramBundle) {}
  
  public final void onPlayEvent(int paramInt, Bundle paramBundle)
  {
    AppMethodBeat.i(352248);
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(352248);
      return;
      Log.i(this.CDl.TAG, "switchInLiveRoom switch view success. #1");
      c.b(this.CDl, this.CDm, this.CDd);
      AppMethodBeat.o(352248);
      return;
      Log.i(this.CDl.TAG, "switchInLiveRoom onPlayEvent PLAY_EVT_CHANGE_RESOLUTION");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.fluent.director.live.c.c
 * JD-Core Version:    0.7.0.1
 */