package com.tencent.mm.am;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ai;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.s;
import com.tencent.mm.storage.z;

public final class c
  extends ai
{
  public final String getTag()
  {
    return "MicroMsg.BizTimeLineDataTransfer";
  }
  
  public final boolean kv(int paramInt)
  {
    return (paramInt != 0) && (paramInt < 637929471);
  }
  
  public final void transfer(int paramInt)
  {
    AppMethodBeat.i(16431);
    ab.d("MicroMsg.BizTimeLineDataTransfer", "the previous version is %d", new Object[] { Integer.valueOf(paramInt) });
    if ((paramInt != 0) && (paramInt < 637929471)) {
      if ((((Integer)g.RL().Ru().get(ac.a.yKe, Integer.valueOf(0))).intValue() & 0x2) <= 0) {
        break label96;
      }
    }
    label96:
    for (boolean bool = true;; bool = false)
    {
      if (bool) {
        s.pR(true);
      }
      ab.i("MicroMsg.BizTimeLineDataTransfer", "transfer end %b", new Object[] { Boolean.valueOf(bool) });
      AppMethodBeat.o(16431);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.am.c
 * JD-Core Version:    0.7.0.1
 */