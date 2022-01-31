package com.tencent.mars.mm;

import com.tencent.mm.network.ab;
import com.tencent.mm.network.z;
import com.tencent.mm.sdk.platformtools.bo;

final class MMLogic$3
  implements Runnable
{
  MMLogic$3(String paramString) {}
  
  public final void run()
  {
    z localz = ab.anH();
    if (bo.isNullOrNil(this.val$_info)) {}
    for (byte[] arrayOfByte = null;; arrayOfByte = this.val$_info.getBytes())
    {
      localz.onPush(268369923, arrayOfByte);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mars.mm.MMLogic.3
 * JD-Core Version:    0.7.0.1
 */