package com.tencent.mm.plugin.finder.live.view.convert;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.feed.model.internal.k;
import com.tencent.mm.plugin.finder.model.cc;
import com.tencent.mm.protocal.protobuf.ccb;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/view/convert/GameSelectItem;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "gameInfo", "Lcom/tencent/mm/protocal/protobuf/GameUserInfo;", "(Lcom/tencent/mm/protocal/protobuf/GameUserInfo;)V", "getGameInfo", "()Lcom/tencent/mm/protocal/protobuf/GameUserInfo;", "selected", "", "getSelected", "()Z", "setSelected", "(Z)V", "compare", "", "obj", "Lcom/tencent/mm/plugin/finder/feed/model/internal/ILoaderData;", "getItemId", "", "getItemType", "Companion", "plugin-finder-base_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class d
  implements cc
{
  public static final a DUF;
  public boolean Bvd;
  public final ccb DUG;
  
  static
  {
    AppMethodBeat.i(358204);
    DUF = new a((byte)0);
    AppMethodBeat.o(358204);
  }
  
  public d(ccb paramccb)
  {
    AppMethodBeat.i(358201);
    this.DUG = paramccb;
    AppMethodBeat.o(358201);
  }
  
  public final int a(k paramk)
  {
    AppMethodBeat.i(358218);
    s.u(paramk, "obj");
    AppMethodBeat.o(358218);
    return 0;
  }
  
  public final long bZA()
  {
    return 0L;
  }
  
  public final int bZB()
  {
    AppMethodBeat.i(358213);
    int i = d.class.hashCode();
    AppMethodBeat.o(358213);
    return i;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/view/convert/GameSelectItem$Companion;", "", "()V", "toLocal", "Lcom/tencent/mm/plugin/finder/live/view/convert/GameSelectItem;", "Lcom/tencent/mm/protocal/protobuf/GameUserInfo;", "plugin-finder-base_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.view.convert.d
 * JD-Core Version:    0.7.0.1
 */