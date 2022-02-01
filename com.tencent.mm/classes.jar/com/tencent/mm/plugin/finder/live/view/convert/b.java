package com.tencent.mm.plugin.finder.live.view.convert;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.feed.model.internal.k;
import com.tencent.mm.plugin.finder.model.bu;
import com.tencent.mm.protocal.protobuf.bnu;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/view/convert/GameSearchItem;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "gameInfo", "Lcom/tencent/mm/protocal/protobuf/GameSearchUserInfo;", "(Lcom/tencent/mm/protocal/protobuf/GameSearchUserInfo;)V", "getGameInfo", "()Lcom/tencent/mm/protocal/protobuf/GameSearchUserInfo;", "compare", "", "obj", "Lcom/tencent/mm/plugin/finder/feed/model/internal/ILoaderData;", "getItemId", "", "getItemType", "Companion", "plugin-finder-base_release"})
public final class b
  implements bu
{
  public static final a zaF;
  public final bnu zaE;
  
  static
  {
    AppMethodBeat.i(259834);
    zaF = new a((byte)0);
    AppMethodBeat.o(259834);
  }
  
  public b(bnu parambnu)
  {
    AppMethodBeat.i(259833);
    this.zaE = parambnu;
    AppMethodBeat.o(259833);
  }
  
  public final int a(k paramk)
  {
    AppMethodBeat.i(259832);
    p.k(paramk, "obj");
    AppMethodBeat.o(259832);
    return 0;
  }
  
  public final int bAQ()
  {
    AppMethodBeat.i(259831);
    int i = b.class.hashCode();
    AppMethodBeat.o(259831);
    return i;
  }
  
  public final long mf()
  {
    return 0L;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/view/convert/GameSearchItem$Companion;", "", "()V", "toLocal", "Lcom/tencent/mm/plugin/finder/live/view/convert/GameSearchItem;", "Lcom/tencent/mm/protocal/protobuf/GameSearchUserInfo;", "plugin-finder-base_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.view.convert.b
 * JD-Core Version:    0.7.0.1
 */