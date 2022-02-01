package com.tencent.mm.plugin.finder.viewmodel;

import androidx.compose.a.q.a..ExternalSyntheticBackport0;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.Serializable;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/viewmodel/Finder18054CacheVM$Item;", "Ljava/io/Serializable;", "scene", "", "feedId", "", "(IJ)V", "count", "getCount", "()I", "setCount", "(I)V", "getFeedId", "()J", "getScene", "time", "getTime", "setTime", "(J)V", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "toString", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a$b
  implements Serializable
{
  public int count;
  private final long feedId;
  final int scene;
  public long time;
  
  public a$b(int paramInt, long paramLong)
  {
    this.scene = paramInt;
    this.feedId = paramLong;
  }
  
  public final boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if (!(paramObject instanceof b)) {
        return false;
      }
      paramObject = (b)paramObject;
      if (this.scene != paramObject.scene) {
        return false;
      }
    } while (this.feedId == paramObject.feedId);
    return false;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(337080);
    int i = this.scene;
    int j = q.a..ExternalSyntheticBackport0.m(this.feedId);
    AppMethodBeat.o(337080);
    return i * 31 + j;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(337069);
    String str = "Item(scene=" + this.scene + ", feedId=" + this.feedId + ')';
    AppMethodBeat.o(337069);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.viewmodel.a.b
 * JD-Core Version:    0.7.0.1
 */