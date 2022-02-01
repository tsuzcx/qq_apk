package com.tencent.mm.plugin.finder.live.report;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.model.cc;
import com.tencent.mm.plugin.finder.model.z;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.bip;
import com.tencent.mm.vending.j.a;
import com.tencent.mm.vending.j.d;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/report/HellLiveFeed$Companion;", "", "()V", "getLiveId", "Lcom/tencent/mm/vending/tuple/Tuple3;", "", "", "", "rvFeed", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "getNickName", "", "plugin-finder-base_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class g$a
{
  public static d<Long, Integer, Boolean> a(cc paramcc)
  {
    long l = 0L;
    int i = 0;
    AppMethodBeat.i(351763);
    s.u(paramcc, "rvFeed");
    bip localbip;
    label58:
    boolean bool;
    if ((paramcc instanceof BaseFinderFeed))
    {
      localbip = ((BaseFinderFeed)paramcc).feedObject.getLiveInfo();
      if (localbip == null)
      {
        l = 0L;
        paramcc = ((BaseFinderFeed)paramcc).feedObject.getLiveInfo();
        if (paramcc != null) {
          break label100;
        }
        i = 0;
        bool = false;
      }
    }
    for (;;)
    {
      paramcc = a.g(Long.valueOf(l), Integer.valueOf(i), Boolean.valueOf(bool));
      s.s(paramcc, "make(liveId, onlineCnt, isSingleLiveAvatar)");
      AppMethodBeat.o(351763);
      return paramcc;
      l = localbip.liveId;
      break;
      label100:
      i = paramcc.DSe;
      break label58;
      if ((paramcc instanceof z))
      {
        localbip = ((z)paramcc).ECN.liveInfo;
        if (localbip == null)
        {
          label132:
          paramcc = ((z)paramcc).ECN.liveInfo;
          if (paramcc != null) {
            break label162;
          }
        }
        for (;;)
        {
          bool = true;
          break;
          l = localbip.liveId;
          break label132;
          label162:
          i = paramcc.DSe;
        }
      }
      bool = false;
      i = -1;
      l = 0L;
    }
  }
  
  public static String b(cc paramcc)
  {
    AppMethodBeat.i(351771);
    s.u(paramcc, "rvFeed");
    Object localObject = "";
    if ((paramcc instanceof BaseFinderFeed)) {
      localObject = ((BaseFinderFeed)paramcc).feedObject.getNickName();
    }
    for (;;)
    {
      AppMethodBeat.o(351771);
      return localObject;
      if ((paramcc instanceof z))
      {
        paramcc = ((z)paramcc).ECN.nickname;
        localObject = paramcc;
        if (paramcc == null) {
          localObject = "";
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.report.g.a
 * JD-Core Version:    0.7.0.1
 */