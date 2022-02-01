package com.tencent.mm.plugin.finder.live.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;
import com.tencent.mm.protocal.protobuf.bdm;
import com.tencent.mm.protocal.protobuf.beu;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/model/FinderLiveLuckyMoneySendMsg;", "Lcom/tencent/mm/plugin/finder/live/model/FinderLiveBaseMsg;", "msg", "Lcom/tencent/mm/protocal/protobuf/FinderLiveAppMsg;", "(Lcom/tencent/mm/protocal/protobuf/FinderLiveAppMsg;)V", "getPayLoadContent", "", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class z
  extends h
{
  public z(bdm parambdm)
  {
    super(parambdm);
    AppMethodBeat.i(359471);
    AppMethodBeat.o(359471);
  }
  
  public final Object ekF()
  {
    byte[] arrayOfByte = null;
    AppMethodBeat.i(359477);
    if (this.CER.msg_type == 20019)
    {
      beu localbeu = new beu();
      b localb = this.CER.ZNY;
      if (localb == null) {}
      for (;;)
      {
        localbeu.parseFrom(arrayOfByte);
        AppMethodBeat.o(359477);
        return localbeu;
        arrayOfByte = localb.toByteArray();
      }
    }
    AppMethodBeat.o(359477);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.model.z
 * JD-Core Version:    0.7.0.1
 */