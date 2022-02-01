package com.tencent.mm.plugin.finder.ui.at;

import androidx.compose.a.q.a..ExternalSyntheticBackport0;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/ui/at/RecentAtBean;", "", "name", "", "time", "", "(Ljava/lang/String;J)V", "getName", "()Ljava/lang/String;", "getTime", "()J", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "Companion", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class j
{
  public static final a FWF;
  final String name;
  final long time;
  
  static
  {
    AppMethodBeat.i(347924);
    FWF = new a((byte)0);
    AppMethodBeat.o(347924);
  }
  
  public j(String paramString, long paramLong)
  {
    AppMethodBeat.i(347913);
    this.name = paramString;
    this.time = paramLong;
    AppMethodBeat.o(347913);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(347949);
    if (this == paramObject)
    {
      AppMethodBeat.o(347949);
      return true;
    }
    if (!(paramObject instanceof j))
    {
      AppMethodBeat.o(347949);
      return false;
    }
    paramObject = (j)paramObject;
    if (!s.p(this.name, paramObject.name))
    {
      AppMethodBeat.o(347949);
      return false;
    }
    if (this.time != paramObject.time)
    {
      AppMethodBeat.o(347949);
      return false;
    }
    AppMethodBeat.o(347949);
    return true;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(347938);
    int i = this.name.hashCode();
    int j = q.a..ExternalSyntheticBackport0.m(this.time);
    AppMethodBeat.o(347938);
    return i * 31 + j;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(347933);
    String str = "RecentAtBean(name='" + this.name + "', time=" + this.time + ')';
    AppMethodBeat.o(347933);
    return str;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/ui/at/RecentAtBean$Companion;", "", "()V", "KEY_NAME", "", "KEY_TIME", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.ui.at.j
 * JD-Core Version:    0.7.0.1
 */