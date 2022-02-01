package com.tencent.mm.plugin.finder.live.olympic.data;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.feed.model.internal.k;
import com.tencent.mm.plugin.finder.model.cc;
import com.tencent.mm.protocal.protobuf.bo;
import com.tencent.mm.protocal.protobuf.bp;
import com.tencent.mm.protocal.protobuf.dii;
import com.tencent.mm.protocal.protobuf.fgz;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/olympic/data/RunnerPannelFeed;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "feed", "Lcom/tencent/mm/protocal/protobuf/ActivityBoardItem;", "type", "", "config", "Lcom/tencent/mm/protocal/protobuf/ActivityBoardConfig;", "activity", "Lcom/tencent/mm/protocal/protobuf/SportActivity;", "selfBlured", "", "(Lcom/tencent/mm/protocal/protobuf/ActivityBoardItem;ILcom/tencent/mm/protocal/protobuf/ActivityBoardConfig;Lcom/tencent/mm/protocal/protobuf/SportActivity;Z)V", "getActivity", "()Lcom/tencent/mm/protocal/protobuf/SportActivity;", "getConfig", "()Lcom/tencent/mm/protocal/protobuf/ActivityBoardConfig;", "getFeed", "()Lcom/tencent/mm/protocal/protobuf/ActivityBoardItem;", "getSelfBlured", "()Z", "getType", "()I", "compare", "obj", "Lcom/tencent/mm/plugin/finder/feed/model/internal/ILoaderData;", "getItemId", "", "getItemType", "Companion", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
  implements cc
{
  public static final a CRy;
  public final fgz CNI;
  public final bo CRA;
  public final boolean CRB;
  public final bp CRz;
  public final int type;
  
  static
  {
    AppMethodBeat.i(360832);
    CRy = new a((byte)0);
    AppMethodBeat.o(360832);
  }
  
  private b(bp parambp, int paramInt, bo parambo, fgz paramfgz, boolean paramBoolean)
  {
    AppMethodBeat.i(360819);
    this.CRz = parambp;
    this.type = paramInt;
    this.CRA = parambo;
    this.CNI = paramfgz;
    this.CRB = paramBoolean;
    AppMethodBeat.o(360819);
  }
  
  public final int a(k paramk)
  {
    Object localObject2 = null;
    AppMethodBeat.i(360848);
    s.u(paramk, "obj");
    Object localObject1;
    label43:
    dii localdii;
    if ((paramk instanceof b))
    {
      paramk = (b)paramk;
      if (paramk == null) {
        break label111;
      }
      localObject1 = paramk.CRz.YDj;
      if (localObject1 != null) {
        break label94;
      }
      localObject1 = null;
      localdii = this.CRz.YDj;
      if (localdii != null) {
        break label102;
      }
    }
    for (;;)
    {
      if ((!s.p(localObject1, localObject2)) || (paramk.CRz.YDk != this.CRz.YDk)) {
        break label111;
      }
      AppMethodBeat.o(360848);
      return 0;
      paramk = null;
      break;
      label94:
      localObject1 = ((dii)localObject1).aanS;
      break label43;
      label102:
      localObject2 = localdii.aanS;
    }
    label111:
    AppMethodBeat.o(360848);
    return -1;
  }
  
  public final long bZA()
  {
    AppMethodBeat.i(360837);
    long l = hashCode();
    AppMethodBeat.o(360837);
    return l;
  }
  
  public final int bZB()
  {
    return this.type;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/olympic/data/RunnerPannelFeed$Companion;", "", "()V", "TYPE_BOTTOM", "", "TYPE_HEAD", "TYPE_NORMAL", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.olympic.data.b
 * JD-Core Version:    0.7.0.1
 */