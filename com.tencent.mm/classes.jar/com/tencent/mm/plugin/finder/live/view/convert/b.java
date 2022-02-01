package com.tencent.mm.plugin.finder.live.view.convert;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.feed.model.internal.k;
import com.tencent.mm.plugin.finder.model.cc;
import com.tencent.mm.protocal.protobuf.cby;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/view/convert/GameSearchItem;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "gameInfo", "Lcom/tencent/mm/protocal/protobuf/GameSearchUserInfo;", "(Lcom/tencent/mm/protocal/protobuf/GameSearchUserInfo;)V", "getGameInfo", "()Lcom/tencent/mm/protocal/protobuf/GameSearchUserInfo;", "compare", "", "obj", "Lcom/tencent/mm/plugin/finder/feed/model/internal/ILoaderData;", "getItemId", "", "getItemType", "Companion", "plugin-finder-base_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
  implements cc
{
  public static final a DUD;
  public final cby DUE;
  
  static
  {
    AppMethodBeat.i(358212);
    DUD = new a((byte)0);
    AppMethodBeat.o(358212);
  }
  
  public b(cby paramcby)
  {
    AppMethodBeat.i(358208);
    this.DUE = paramcby;
    AppMethodBeat.o(358208);
  }
  
  public final int a(k paramk)
  {
    AppMethodBeat.i(358226);
    s.u(paramk, "obj");
    AppMethodBeat.o(358226);
    return 0;
  }
  
  public final long bZA()
  {
    return 0L;
  }
  
  public final int bZB()
  {
    AppMethodBeat.i(358223);
    int i = b.class.hashCode();
    AppMethodBeat.o(358223);
    return i;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/view/convert/GameSearchItem$Companion;", "", "()V", "toLocal", "Lcom/tencent/mm/plugin/finder/live/view/convert/GameSearchItem;", "Lcom/tencent/mm/protocal/protobuf/GameSearchUserInfo;", "plugin-finder-base_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.view.convert.b
 * JD-Core Version:    0.7.0.1
 */