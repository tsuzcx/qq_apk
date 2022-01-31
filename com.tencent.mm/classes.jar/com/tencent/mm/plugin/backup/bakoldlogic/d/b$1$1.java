package com.tencent.mm.plugin.backup.bakoldlogic.d;

import com.tencent.mm.pointers.PLong;
import com.tencent.mm.sdk.platformtools.ai.a;
import com.tencent.mm.sdk.platformtools.y;

final class b$1$1
  implements ai.a
{
  b$1$1(b.1 param1) {}
  
  public final boolean JS()
  {
    b.avT();
    PLong localPLong1 = new PLong();
    PLong localPLong2 = new PLong();
    PLong localPLong3 = new PLong();
    b.a(this.hPs.hPr, localPLong1, localPLong2, localPLong3, this.hPs.hPq, this.hPs.hMj);
    return true;
  }
  
  public final boolean JT()
  {
    y.i("MicroMsg.BakOldTempDbModel", "initTempDB onPostExecute");
    this.hPs.hPq.run();
    b.uD();
    return false;
  }
  
  public final String toString()
  {
    return super.toString() + "|initTempDB";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.bakoldlogic.d.b.1.1
 * JD-Core Version:    0.7.0.1
 */