package com.tencent.mm.al;

import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ah;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.s;
import com.tencent.mm.storage.z;

public final class c
  extends ah
{
  public final String getTag()
  {
    return "MicroMsg.BizTimeLineDataTransfer";
  }
  
  public final boolean hJ(int paramInt)
  {
    return (paramInt != 0) && (paramInt < 637929471);
  }
  
  public final void transfer(int paramInt)
  {
    y.d("MicroMsg.BizTimeLineDataTransfer", "the previous version is %d", new Object[] { Integer.valueOf(paramInt) });
    if ((paramInt != 0) && (paramInt < 637929471)) {
      if ((((Integer)g.DP().Dz().get(ac.a.uzq, Integer.valueOf(0))).intValue() & 0x2) <= 0) {
        break label84;
      }
    }
    label84:
    for (boolean bool = true;; bool = false)
    {
      if (bool) {
        s.mA(true);
      }
      y.i("MicroMsg.BizTimeLineDataTransfer", "transfer end %b", new Object[] { Boolean.valueOf(bool) });
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.al.c
 * JD-Core Version:    0.7.0.1
 */