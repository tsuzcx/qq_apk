package com.tencent.mm.plugin.finder.feed.jumper;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.FinderJumpInfo;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/feed/jumper/FinderShopCacheHandler;", "Lcom/tencent/mm/plugin/finder/feed/jumper/JumperCacheHandler;", "()V", "onGenerate", "Lcom/tencent/mm/plugin/finder/feed/jumper/FinderJumpInfoCache;", "info", "Lcom/tencent/mm/protocal/protobuf/FinderJumpInfo;", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class m
  implements q
{
  public final j a(FinderJumpInfo paramFinderJumpInfo)
  {
    AppMethodBeat.i(364176);
    s.u(paramFinderJumpInfo, "info");
    Object localObject2 = paramFinderJumpInfo.icon_url;
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = "";
    }
    String str = paramFinderJumpInfo.wording;
    localObject2 = str;
    if (str == null) {
      localObject2 = "";
    }
    str = paramFinderJumpInfo.recommend_reason;
    paramFinderJumpInfo = str;
    if (str == null) {
      paramFinderJumpInfo = "";
    }
    paramFinderJumpInfo = (j)new n((String)localObject1, (String)localObject2, paramFinderJumpInfo);
    AppMethodBeat.o(364176);
    return paramFinderJumpInfo;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.jumper.m
 * JD-Core Version:    0.7.0.1
 */