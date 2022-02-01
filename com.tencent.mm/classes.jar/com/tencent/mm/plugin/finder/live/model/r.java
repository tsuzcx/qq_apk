package com.tencent.mm.plugin.finder.live.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;
import com.tencent.mm.plugin.finder.live.utils.a;
import com.tencent.mm.protocal.protobuf.bdm;
import com.tencent.mm.protocal.protobuf.beh;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/model/FinderLiveGlobalLevelUpgradeMsg;", "Lcom/tencent/mm/plugin/finder/live/model/FinderLiveBaseMsg;", "msg", "Lcom/tencent/mm/protocal/protobuf/FinderLiveAppMsg;", "(Lcom/tencent/mm/protocal/protobuf/FinderLiveAppMsg;)V", "getPayLoadContent", "", "toString", "", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class r
  extends h
{
  public r(bdm parambdm)
  {
    super(parambdm);
    AppMethodBeat.i(359373);
    AppMethodBeat.o(359373);
  }
  
  public final Object ekF()
  {
    AppMethodBeat.i(359382);
    if (this.CER.msg_type == 20031)
    {
      beh localbeh = new beh();
      Object localObject = this.CER.ZNY;
      if (localObject == null) {}
      for (localObject = null;; localObject = ((b)localObject).toByteArray())
      {
        localbeh.parseFrom((byte[])localObject);
        localObject = a.DJT;
        a.hQ("FinderLiveGlobalLevelUpgradeMsg", s.X("userlevelTest,", localbeh));
        if (localbeh.type != 1) {
          break;
        }
        AppMethodBeat.o(359382);
        return localbeh;
      }
      AppMethodBeat.o(359382);
      return null;
    }
    AppMethodBeat.o(359382);
    return null;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(359391);
    Object localObject = ekF();
    if ((localObject instanceof beh))
    {
      localObject = "nickNake:" + ekt() + '-' + ekx() + ",type:" + ((beh)localObject).type + ",level:" + ((beh)localObject).ZON + '-' + ((beh)localObject).ZOO;
      AppMethodBeat.o(359391);
      return localObject;
    }
    localObject = super.toString();
    AppMethodBeat.o(359391);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.model.r
 * JD-Core Version:    0.7.0.1
 */