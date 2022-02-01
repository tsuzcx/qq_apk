package com.tencent.mm.plugin.finder.nearby.live.play;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/nearby/live/play/MediaSource;", "", "url", "", "(Ljava/lang/String;)V", "getUrl", "()Ljava/lang/String;", "toString", "plugin-finder-nearby_release"})
public class b
{
  final String url;
  
  public b(String paramString)
  {
    AppMethodBeat.i(201840);
    this.url = paramString;
    AppMethodBeat.o(201840);
  }
  
  public String toString()
  {
    AppMethodBeat.i(201836);
    String str = "url:" + this.url;
    AppMethodBeat.o(201836);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.nearby.live.play.b
 * JD-Core Version:    0.7.0.1
 */