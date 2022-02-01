package com.tencent.mm.plugin.finder.search;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.k;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/search/FinderExposeItem;", "", "()V", "clickTimes", "", "getClickTimes", "()I", "setClickTimes", "(I)V", "exposeTimes", "getExposeTimes", "setExposeTimes", "id", "", "getId", "()Ljava/lang/String;", "setId", "(Ljava/lang/String;)V", "isReport", "", "()Z", "setReport", "(Z)V", "position", "getPosition", "setPosition", "timeStamp", "", "getTimeStamp", "()J", "setTimeStamp", "(J)V", "type", "getType", "setType", "username", "getUsername", "setUsername", "plugin-finder_release"})
public final class a
{
  public String id = "";
  public int position = -1;
  public boolean qHI;
  public long timeStamp;
  public int type;
  private String username = "";
  
  public final void Zm(String paramString)
  {
    AppMethodBeat.i(166746);
    k.h(paramString, "<set-?>");
    this.id = paramString;
    AppMethodBeat.o(166746);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.search.a
 * JD-Core Version:    0.7.0.1
 */