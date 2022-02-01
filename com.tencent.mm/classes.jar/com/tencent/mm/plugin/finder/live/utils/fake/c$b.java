package com.tencent.mm.plugin.finder.live.utils.fake;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/utils/fake/FinderLiveGiftMockUtil$GiftInfo;", "", "giftId", "", "name", "(Ljava/lang/String;Ljava/lang/String;)V", "getGiftId", "()Ljava/lang/String;", "getName", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class c$b
{
  final String DbF;
  final String name;
  
  public c$b(String paramString1, String paramString2)
  {
    AppMethodBeat.i(351068);
    this.DbF = paramString1;
    this.name = paramString2;
    AppMethodBeat.o(351068);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(351091);
    if (this == paramObject)
    {
      AppMethodBeat.o(351091);
      return true;
    }
    if (!(paramObject instanceof b))
    {
      AppMethodBeat.o(351091);
      return false;
    }
    paramObject = (b)paramObject;
    if (!s.p(this.DbF, paramObject.DbF))
    {
      AppMethodBeat.o(351091);
      return false;
    }
    if (!s.p(this.name, paramObject.name))
    {
      AppMethodBeat.o(351091);
      return false;
    }
    AppMethodBeat.o(351091);
    return true;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(351082);
    int i = this.DbF.hashCode();
    int j = this.name.hashCode();
    AppMethodBeat.o(351082);
    return i * 31 + j;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(351074);
    String str = "GiftInfo(giftId=" + this.DbF + ", name=" + this.name + ')';
    AppMethodBeat.o(351074);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.utils.fake.c.b
 * JD-Core Version:    0.7.0.1
 */