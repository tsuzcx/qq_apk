package com.tencent.mm.network;

import com.tencent.mars.smc.SmcLogic;

final class x$1
  implements Runnable
{
  x$1(x paramx, boolean paramBoolean1, long paramLong, String paramString, boolean paramBoolean2) {}
  
  public final void run()
  {
    if (this.eOz)
    {
      SmcLogic.writeImportKvData(this.eOA, this.eOB, this.eOC, false);
      return;
    }
    SmcLogic.writeKvData(this.eOA, this.eOB, this.eOC, false);
  }
  
  public final String toString()
  {
    return super.toString() + "|reportKV";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.network.x.1
 * JD-Core Version:    0.7.0.1
 */