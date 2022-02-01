package com.tencent.mm.plugin.finder.replay.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/replay/model/LiveMsgOffsetProcessConfig;", "", "scene", "", "(I)V", "getScene", "()I", "setScene", "component1", "copy", "equals", "", "other", "hashCode", "toString", "", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class f
{
  public int scene;
  
  public f(int paramInt)
  {
    this.scene = paramInt;
  }
  
  public final boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if (!(paramObject instanceof f)) {
        return false;
      }
      paramObject = (f)paramObject;
    } while (this.scene == paramObject.scene);
    return false;
  }
  
  public final int hashCode()
  {
    return this.scene;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(332811);
    String str = s.X("LiveMsgOffsetProcessConfig,scene:", Integer.valueOf(this.scene));
    AppMethodBeat.o(332811);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.replay.model.f
 * JD-Core Version:    0.7.0.1
 */