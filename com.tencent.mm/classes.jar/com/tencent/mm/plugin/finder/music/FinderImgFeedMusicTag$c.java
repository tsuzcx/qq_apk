package com.tencent.mm.plugin.finder.music;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.findersdk.receiver.HeadsetReceiver.b;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;
import kotlin.g.a.a;

@Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/music/FinderImgFeedMusicTag$onHeadsetStateChangeListener$1", "Lcom/tencent/mm/plugin/findersdk/receiver/HeadsetReceiver$OnHeadsetStateChangeListener;", "onHeadsetStateChange", "", "on", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class FinderImgFeedMusicTag$c
  implements HeadsetReceiver.b
{
  FinderImgFeedMusicTag$c(FinderImgFeedMusicTag paramFinderImgFeedMusicTag) {}
  
  public final void sO(boolean paramBoolean)
  {
    AppMethodBeat.i(330788);
    Log.i("FinderImgFeedMusicTag", "onHeadsetStateChange on:" + paramBoolean + " isPlaying:" + this.EEX.isPlaying());
    if ((!paramBoolean) && (this.EEX.isPlaying())) {
      this.EEX.getOnHeadsetStateChangePauseMusicTag().invoke();
    }
    AppMethodBeat.o(330788);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.music.FinderImgFeedMusicTag.c
 * JD-Core Version:    0.7.0.1
 */