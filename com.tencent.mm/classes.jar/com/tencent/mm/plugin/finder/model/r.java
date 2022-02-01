package com.tencent.mm.plugin.finder.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.feed.model.internal.k;
import com.tencent.mm.protocal.protobuf.cjb;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/model/FinderEmojiData;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "emojiInfo", "Lcom/tencent/mm/protocal/protobuf/EmotionSummary;", "(Lcom/tencent/mm/protocal/protobuf/EmotionSummary;)V", "getEmojiInfo", "()Lcom/tencent/mm/protocal/protobuf/EmotionSummary;", "compare", "", "obj", "Lcom/tencent/mm/plugin/finder/feed/model/internal/ILoaderData;", "getItemId", "", "getItemType", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class r
  implements cc
{
  public final cjb ECr;
  
  public r(cjb paramcjb)
  {
    AppMethodBeat.i(332213);
    this.ECr = paramcjb;
    AppMethodBeat.o(332213);
  }
  
  public final int a(k paramk)
  {
    AppMethodBeat.i(332238);
    s.u(paramk, "obj");
    AppMethodBeat.o(332238);
    return -1;
  }
  
  public final long bZA()
  {
    AppMethodBeat.i(332222);
    long l = hashCode();
    AppMethodBeat.o(332222);
    return l;
  }
  
  public final int bZB()
  {
    AppMethodBeat.i(332228);
    int i = r.class.getName().hashCode();
    AppMethodBeat.o(332228);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.model.r
 * JD-Core Version:    0.7.0.1
 */