package com.tencent.mm.plugin.finder.live.model;

import com.tencent.mm.bx.a;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/model/FinderLivePollingService$PollingEventCallback;", "R", "Lcom/tencent/mm/protobuf/BaseProtoBuf;", "", "resultClass", "Ljava/lang/Class;", "(Ljava/lang/Class;)V", "getResultClass", "()Ljava/lang/Class;", "callbackWith", "", "result", "Lcom/tencent/mm/protobuf/ByteString;", "callbackWith$plugin_finder_live_release", "onPollingFail", "ret", "", "errMsg", "", "onPollingSuccess", "(Lcom/tencent/mm/protobuf/BaseProtoBuf;)V", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract class af$c<R extends a>
{
  final Class<R> CGL;
  
  public af$c(Class<R> paramClass)
  {
    this.CGL = paramClass;
  }
  
  public abstract void g(R paramR);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.model.af.c
 * JD-Core Version:    0.7.0.1
 */