package com.tencent.j;

import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.videocomposition.n;
import java.util.HashMap;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/video_editor_videocomposition/VideoCompositionPluginData;", "", "()V", "composition", "Lcom/tencent/mm/videocomposition/VideoComposition;", "getComposition", "()Lcom/tencent/mm/videocomposition/VideoComposition;", "id", "", "getId", "()J", "setId", "(J)V", "value", "Ljava/util/HashMap;", "", "Landroid/util/Pair;", "", "Lkotlin/collections/HashMap;", "trackLabelMap", "getTrackLabelMap", "()Ljava/util/HashMap;", "setTrackLabelMap", "(Ljava/util/HashMap;)V", "trackMap", "Lcom/tencent/mm/videocomposition/CompositionTrack;", "getTrackMap", "video_editor_videocomposition_release"})
public final class d
{
  final n Gez;
  final HashMap<Long, com.tencent.mm.videocomposition.d> StC;
  HashMap<String, Pair<Integer, Long>> Sue;
  long id;
  
  public d()
  {
    AppMethodBeat.i(199372);
    this.Gez = new n();
    this.StC = new HashMap();
    this.Sue = new HashMap();
    AppMethodBeat.o(199372);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.j.d
 * JD-Core Version:    0.7.0.1
 */