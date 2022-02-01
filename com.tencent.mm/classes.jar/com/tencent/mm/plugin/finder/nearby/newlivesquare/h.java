package com.tencent.mm.plugin.finder.nearby.newlivesquare;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.model.cc;
import com.tencent.mm.protocal.protobuf.bmz;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/nearby/newlivesquare/OutsideEventCallListener;", "", "()V", "listeners", "", "Lcom/tencent/mm/plugin/finder/nearby/newlivesquare/OutsideEventCallListener$Caller;", "getListeners", "()Ljava/util/List;", "callAllAppend", "", "containerId", "", "cards", "", "Lcom/tencent/mm/protocal/protobuf/FinderLiveStreamCard;", "callAllListenerToCheckVideo", "whichContainer", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "callAllListenerToScroll", "liveId", "", "Caller", "plugin-finder-nearby_release"}, k=1, mv={1, 5, 1}, xi=48)
public class h
{
  public final List<a> listeners;
  
  public h()
  {
    AppMethodBeat.i(340254);
    this.listeners = ((List)new ArrayList());
    AppMethodBeat.o(340254);
  }
  
  public final void e(cc paramcc)
  {
    AppMethodBeat.i(340261);
    s.u(paramcc, "whichContainer");
    Iterator localIterator = ((Iterable)this.listeners).iterator();
    while (localIterator.hasNext()) {
      ((a)localIterator.next()).f(paramcc);
    }
    AppMethodBeat.o(340261);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/nearby/newlivesquare/OutsideEventCallListener$Caller;", "", "append", "", "containerId", "", "cards", "", "Lcom/tencent/mm/protocal/protobuf/FinderLiveStreamCard;", "checkPlayer", "whichContainer", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "scrollToLiveIdPosition", "liveId", "", "SampleCaller", "plugin-finder-nearby_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static abstract interface a
  {
    public abstract void E(int paramInt, List<? extends bmz> paramList);
    
    public abstract void bz(int paramInt, long paramLong);
    
    public abstract void f(cc paramcc);
    
    @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/nearby/newlivesquare/OutsideEventCallListener$Caller$SampleCaller;", "Lcom/tencent/mm/plugin/finder/nearby/newlivesquare/OutsideEventCallListener$Caller;", "()V", "append", "", "containerId", "", "cards", "", "Lcom/tencent/mm/protocal/protobuf/FinderLiveStreamCard;", "checkPlayer", "whichContainer", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "scrollToLiveIdPosition", "liveId", "", "plugin-finder-nearby_release"}, k=1, mv={1, 5, 1}, xi=48)
    public static class a
      implements h.a
    {
      public void E(int paramInt, List<? extends bmz> paramList)
      {
        AppMethodBeat.i(340265);
        s.u(paramList, "cards");
        AppMethodBeat.o(340265);
      }
      
      public void bz(int paramInt, long paramLong) {}
      
      public void f(cc paramcc)
      {
        AppMethodBeat.i(340257);
        s.u(paramcc, "whichContainer");
        AppMethodBeat.o(340257);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.nearby.newlivesquare.h
 * JD-Core Version:    0.7.0.1
 */