package com.tencent.mm.plugin.finder.event.base;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;

@d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/event/base/TwoFeedFlowScrollEvent;", "Lcom/tencent/mm/plugin/finder/event/base/Event;", "type", "", "(I)V", "acrossFeedList", "", "Lcom/tencent/mm/plugin/finder/event/base/FlowScrollEventFeedData;", "getAcrossFeedList", "()Ljava/util/List;", "setAcrossFeedList", "(Ljava/util/List;)V", "firstVisibleItemPosition", "getFirstVisibleItemPosition", "()I", "setFirstVisibleItemPosition", "lastFirstVisibleItemPosition", "getLastFirstVisibleItemPosition", "setLastFirstVisibleItemPosition", "lastLastVisibleItemPosition", "getLastLastVisibleItemPosition", "setLastLastVisibleItemPosition", "lastVisibleItemPosition", "getLastVisibleItemPosition", "setLastVisibleItemPosition", "getType", "visibleFeedList", "getVisibleFeedList", "setVisibleFeedList", "Companion", "plugin-finder_release"})
public final class l
  extends b
{
  public static final l.a rdS;
  public int nAG;
  public int nAH;
  public int rdH;
  public int rdJ;
  public List<g> rdP;
  public List<g> rdQ;
  private final int type;
  
  static
  {
    AppMethodBeat.i(201431);
    rdS = new l.a((byte)0);
    AppMethodBeat.o(201431);
  }
  
  public l(int paramInt)
  {
    this.type = paramInt;
    this.nAG = -1;
    this.nAH = -1;
    this.rdH = -1;
    this.rdJ = -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.event.base.l
 * JD-Core Version:    0.7.0.1
 */