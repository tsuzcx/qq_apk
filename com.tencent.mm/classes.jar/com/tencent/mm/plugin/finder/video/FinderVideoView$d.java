package com.tencent.mm.plugin.finder.video;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.d.a;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/video/FinderVideoView$requestAudioFocus$1", "Lcom/tencent/mm/model/AudioHelperTool$AudioRespond;", "gain", "", "loss", "lossTransient", "lossTransientCanDuck", "unKown", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class FinderVideoView$d
  implements d.a
{
  public final void bAi()
  {
    AppMethodBeat.i(168176);
    Log.i("Finder.VideoView", "[audioHelperTool] gain");
    AppMethodBeat.o(168176);
  }
  
  public final void bAj()
  {
    AppMethodBeat.i(168178);
    Log.i("Finder.VideoView", "[audioHelperTool] loss");
    AppMethodBeat.o(168178);
  }
  
  public final void bAk()
  {
    AppMethodBeat.i(168177);
    Log.i("Finder.VideoView", "[audioHelperTool] lossTransient");
    AppMethodBeat.o(168177);
  }
  
  public final void bAl()
  {
    AppMethodBeat.i(168179);
    Log.i("Finder.VideoView", "[audioHelperTool] lossTransientCanDuck");
    AppMethodBeat.o(168179);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.video.FinderVideoView.d
 * JD-Core Version:    0.7.0.1
 */