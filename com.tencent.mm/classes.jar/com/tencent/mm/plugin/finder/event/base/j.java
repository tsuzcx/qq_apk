package com.tencent.mm.plugin.finder.event.base;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/event/base/SelectEvent;", "Lcom/tencent/mm/plugin/finder/event/base/Event;", "type", "", "(I)V", "feedId", "", "getFeedId", "()J", "setFeedId", "(J)V", "pos", "getPos", "()I", "setPos", "getType", "setType", "Companion", "plugin-finder-base_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class j
  extends b
{
  public static final a AOz;
  public long feedId;
  public int pos = -1;
  public int type = 1;
  
  static
  {
    AppMethodBeat.i(330322);
    AOz = new a((byte)0);
    AppMethodBeat.o(330322);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/event/base/SelectEvent$Companion;", "", "()V", "SELECT_STATE_ON_SELECTED", "", "plugin-finder-base_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.event.base.j
 * JD-Core Version:    0.7.0.1
 */