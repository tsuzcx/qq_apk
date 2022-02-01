package com.tencent.mm.plugin.finder.search;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/search/FinderExposeItem;", "", "()V", "clickTimes", "", "getClickTimes", "()I", "setClickTimes", "(I)V", "exposeTimes", "getExposeTimes", "setExposeTimes", "id", "", "getId", "()Ljava/lang/String;", "setId", "(Ljava/lang/String;)V", "isReport", "", "()Z", "setReport", "(Z)V", "position", "getPosition", "setPosition", "timeStamp", "", "getTimeStamp", "()J", "setTimeStamp", "(J)V", "type", "getType", "setType", "username", "getUsername", "setUsername", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
{
  public String id = "";
  public boolean lAr;
  public int position = -1;
  public long timeStamp;
  public int type;
  private String username = "";
  
  public final void setId(String paramString)
  {
    AppMethodBeat.i(166746);
    s.u(paramString, "<set-?>");
    this.id = paramString;
    AppMethodBeat.o(166746);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.search.a
 * JD-Core Version:    0.7.0.1
 */