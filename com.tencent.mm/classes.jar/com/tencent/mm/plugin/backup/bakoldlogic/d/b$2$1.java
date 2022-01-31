package com.tencent.mm.plugin.backup.bakoldlogic.d;

import com.tencent.mm.h.a.pr;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ai.a;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.vfs.e;

final class b$2$1
  implements ai.a
{
  b$2$1(b.2 param2) {}
  
  public final boolean JS()
  {
    y.i("MicroMsg.BakOldTempDbModel", "bakoldRecoverFromTempDb doInBackground start");
    y.cqL();
    b.avU();
    e.K(com.tencent.mm.plugin.backup.bakoldlogic.a.a.avo(), true);
    a locala = this.hPu.hPr.avQ();
    locala.handler.post(new a.2(locala));
    y.i("MicroMsg.BakOldTempDbModel", "bakoldRecoverFromTempDb doInBackground end");
    y.cqL();
    return true;
  }
  
  public final boolean JT()
  {
    y.i("MicroMsg.BakOldTempDbModel", "bakoldRecoverFromTempDb onPostExecute");
    this.hPu.hPt.run();
    com.tencent.mm.sdk.b.a.udP.m(new pr());
    return false;
  }
  
  public final String toString()
  {
    return super.toString() + "|bakoldRecoverFromTempDb";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.bakoldlogic.d.b.2.1
 * JD-Core Version:    0.7.0.1
 */