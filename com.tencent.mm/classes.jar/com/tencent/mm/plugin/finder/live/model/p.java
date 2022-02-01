package com.tencent.mm.plugin.finder.live.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.a;
import com.tencent.mm.bx.b;
import com.tencent.mm.protocal.protobuf.bdm;
import com.tencent.mm.protocal.protobuf.bef;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/model/FinderLiveGameLivePurchaseTeamUp;", "Lcom/tencent/mm/plugin/finder/live/model/FinderLiveBaseMsg;", "msg", "Lcom/tencent/mm/protocal/protobuf/FinderLiveAppMsg;", "(Lcom/tencent/mm/protocal/protobuf/FinderLiveAppMsg;)V", "getPayLoadContent", "", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class p
  extends h
{
  public p(bdm parambdm)
  {
    super(parambdm);
    AppMethodBeat.i(359358);
    AppMethodBeat.o(359358);
  }
  
  public final Object ekF()
  {
    byte[] arrayOfByte = null;
    AppMethodBeat.i(359367);
    if (this.CER.msg_type == 20047)
    {
      bef localbef = new bef();
      a locala = (a)localbef;
      b localb = this.CER.ZNY;
      if (localb == null) {}
      try
      {
        for (;;)
        {
          locala.parseFrom(arrayOfByte);
          AppMethodBeat.o(359367);
          return localbef;
          arrayOfByte = localb.toByteArray();
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          Log.printDebugStack("safeParser", "", new Object[] { localException });
        }
      }
    }
    AppMethodBeat.o(359367);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.model.p
 * JD-Core Version:    0.7.0.1
 */