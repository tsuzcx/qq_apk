package com.tencent.mm.plugin.finder.nearby.live.play;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/nearby/live/play/MediaSource;", "", "url", "", "(Ljava/lang/String;)V", "getUrl", "()Ljava/lang/String;", "toString", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public class d
{
  final String url;
  
  public d(String paramString)
  {
    AppMethodBeat.i(340977);
    this.url = paramString;
    AppMethodBeat.o(340977);
  }
  
  public String toString()
  {
    AppMethodBeat.i(340982);
    String str = s.X("url:", this.url);
    AppMethodBeat.o(340982);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.nearby.live.play.d
 * JD-Core Version:    0.7.0.1
 */