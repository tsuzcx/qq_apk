package com.tencent.mm.plugin.finder.live.view.convert;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.feed.model.internal.k;
import com.tencent.mm.plugin.finder.model.bu;
import com.tencent.mm.protocal.protobuf.bnw;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/view/convert/GameSelectItem;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "gameInfo", "Lcom/tencent/mm/protocal/protobuf/GameUserInfo;", "(Lcom/tencent/mm/protocal/protobuf/GameUserInfo;)V", "getGameInfo", "()Lcom/tencent/mm/protocal/protobuf/GameUserInfo;", "selected", "", "getSelected", "()Z", "setSelected", "(Z)V", "compare", "", "obj", "Lcom/tencent/mm/plugin/finder/feed/model/internal/ILoaderData;", "getItemId", "", "getItemType", "Companion", "plugin-finder-base_release"})
public final class d
  implements bu
{
  public static final a zaH;
  public boolean xUg;
  public final bnw zaG;
  
  static
  {
    AppMethodBeat.i(260741);
    zaH = new a((byte)0);
    AppMethodBeat.o(260741);
  }
  
  public d(bnw parambnw)
  {
    AppMethodBeat.i(260739);
    this.zaG = parambnw;
    AppMethodBeat.o(260739);
  }
  
  public final int a(k paramk)
  {
    AppMethodBeat.i(260737);
    p.k(paramk, "obj");
    AppMethodBeat.o(260737);
    return 0;
  }
  
  public final int bAQ()
  {
    AppMethodBeat.i(260735);
    int i = d.class.hashCode();
    AppMethodBeat.o(260735);
    return i;
  }
  
  public final long mf()
  {
    return 0L;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/view/convert/GameSelectItem$Companion;", "", "()V", "toLocal", "Lcom/tencent/mm/plugin/finder/live/view/convert/GameSelectItem;", "Lcom/tencent/mm/protocal/protobuf/GameUserInfo;", "plugin-finder-base_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.view.convert.d
 * JD-Core Version:    0.7.0.1
 */