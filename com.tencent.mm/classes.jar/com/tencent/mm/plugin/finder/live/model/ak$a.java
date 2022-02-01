package com.tencent.mm.plugin.finder.live.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/model/FinderLiveShowFollowBtnLogic$ShowBtnContext;", "", "triggerScene", "Lcom/tencent/mm/plugin/finder/live/model/FinderLiveShowFollowBtnLogic$TriggerActionScene;", "sessionId", "", "(Lcom/tencent/mm/plugin/finder/live/model/FinderLiveShowFollowBtnLogic$TriggerActionScene;Ljava/lang/String;)V", "getSessionId", "()Ljava/lang/String;", "getTriggerScene", "()Lcom/tencent/mm/plugin/finder/live/model/FinderLiveShowFollowBtnLogic$TriggerActionScene;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
final class ak$a
{
  final ak.b CHK;
  final String sessionId;
  
  public ak$a(ak.b paramb, String paramString)
  {
    AppMethodBeat.i(359549);
    this.CHK = paramb;
    this.sessionId = paramString;
    AppMethodBeat.o(359549);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(359563);
    if (this == paramObject)
    {
      AppMethodBeat.o(359563);
      return true;
    }
    if (!(paramObject instanceof a))
    {
      AppMethodBeat.o(359563);
      return false;
    }
    paramObject = (a)paramObject;
    if (this.CHK != paramObject.CHK)
    {
      AppMethodBeat.o(359563);
      return false;
    }
    if (!s.p(this.sessionId, paramObject.sessionId))
    {
      AppMethodBeat.o(359563);
      return false;
    }
    AppMethodBeat.o(359563);
    return true;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(359559);
    int i = this.CHK.hashCode();
    int j = this.sessionId.hashCode();
    AppMethodBeat.o(359559);
    return i * 31 + j;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(359553);
    String str = "ShowBtnContext(triggerScene=" + this.CHK + ", sessionId=" + this.sessionId + ')';
    AppMethodBeat.o(359553);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.model.ak.a
 * JD-Core Version:    0.7.0.1
 */