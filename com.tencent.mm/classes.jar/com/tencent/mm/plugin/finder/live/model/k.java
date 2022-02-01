package com.tencent.mm.plugin.finder.live.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;
import com.tencent.mm.protocal.protobuf.aut;
import com.tencent.mm.protocal.protobuf.avc;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/live/model/FinderLiveRewardRankingMsg;", "Lcom/tencent/mm/plugin/finder/live/model/FinderLiveBaseMsg;", "msg", "Lcom/tencent/mm/protocal/protobuf/FinderLiveAppMsg;", "(Lcom/tencent/mm/protocal/protobuf/FinderLiveAppMsg;)V", "getPayLoadContent", "", "plugin-finder_release"})
public final class k
  extends c
{
  public k(aut paramaut)
  {
    super(paramaut);
    AppMethodBeat.i(246176);
    AppMethodBeat.o(246176);
  }
  
  public final Object dft()
  {
    byte[] arrayOfByte = null;
    AppMethodBeat.i(246175);
    switch (this.uio.ybm)
    {
    default: 
      AppMethodBeat.o(246175);
      return null;
    }
    avc localavc = new avc();
    b localb = this.uio.LFB;
    if (localb != null) {
      arrayOfByte = localb.toByteArray();
    }
    localavc.parseFrom(arrayOfByte);
    AppMethodBeat.o(246175);
    return localavc;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.model.k
 * JD-Core Version:    0.7.0.1
 */