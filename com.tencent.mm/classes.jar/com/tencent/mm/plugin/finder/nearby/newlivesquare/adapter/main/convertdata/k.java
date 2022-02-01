package com.tencent.mm.plugin.finder.nearby.newlivesquare.adapter.main.convertdata;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.model.cc;
import com.tencent.mm.protocal.protobuf.bkk;
import com.tencent.mm.protocal.protobuf.bna;
import com.tencent.mm.protocal.protobuf.bnc;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/nearby/newlivesquare/adapter/main/convertdata/NoticeConvertData;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "notice", "Lcom/tencent/mm/protocal/protobuf/FinderLiveStreamNoticeCard;", "container", "Lcom/tencent/mm/protocal/protobuf/FinderLiveStreamContainer;", "(Lcom/tencent/mm/protocal/protobuf/FinderLiveStreamNoticeCard;Lcom/tencent/mm/protocal/protobuf/FinderLiveStreamContainer;)V", "getContainer", "()Lcom/tencent/mm/protocal/protobuf/FinderLiveStreamContainer;", "getNotice", "()Lcom/tencent/mm/protocal/protobuf/FinderLiveStreamNoticeCard;", "compare", "", "obj", "Lcom/tencent/mm/plugin/finder/feed/model/internal/ILoaderData;", "getItemId", "", "getItemType", "plugin-finder-nearby_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class k
  implements cc
{
  public final bna ENs;
  public final bnc ENv;
  
  public k(bnc parambnc, bna parambna)
  {
    AppMethodBeat.i(340352);
    this.ENv = parambnc;
    this.ENs = parambna;
    AppMethodBeat.o(340352);
  }
  
  public final int a(com.tencent.mm.plugin.finder.feed.model.internal.k paramk)
  {
    Object localObject = null;
    AppMethodBeat.i(340377);
    s.u(paramk, "obj");
    if ((paramk instanceof k))
    {
      paramk = ((k)paramk).ENv.ZFA;
      bkk localbkk;
      if (paramk == null)
      {
        paramk = null;
        localbkk = this.ENv.ZFA;
        if (localbkk != null) {
          break label72;
        }
      }
      for (;;)
      {
        if (!s.p(paramk, localObject)) {
          break label80;
        }
        AppMethodBeat.o(340377);
        return 0;
        paramk = paramk.hAR;
        break;
        label72:
        localObject = localbkk.hAR;
      }
    }
    label80:
    AppMethodBeat.o(340377);
    return -1;
  }
  
  public final long bZA()
  {
    AppMethodBeat.i(340360);
    long l = hashCode();
    AppMethodBeat.o(340360);
    return l;
  }
  
  public final int bZB()
  {
    return 5;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.nearby.newlivesquare.adapter.main.convertdata.k
 * JD-Core Version:    0.7.0.1
 */