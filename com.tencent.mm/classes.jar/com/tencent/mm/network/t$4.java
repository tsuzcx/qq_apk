package com.tencent.mm.network;

import com.tencent.mars.mm.MMLogic;
import com.tencent.mm.sdk.platformtools.bf;

final class t$4
  extends bf<Object>
{
  t$4(t paramt, String[] paramArrayOfString1, String[] paramArrayOfString2, int[] paramArrayOfInt)
  {
    super(1000L, null, (byte)0);
  }
  
  protected final Object run()
  {
    MMLogic.setHostInfo(this.eNW, this.eNX, this.eNY);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.network.t.4
 * JD-Core Version:    0.7.0.1
 */