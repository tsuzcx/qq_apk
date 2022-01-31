package com.tencent.mm.plugin.backup.bakoldlogic.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.qy;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.al.a;
import com.tencent.mm.vfs.e;

final class b$2$1
  implements al.a
{
  b$2$1(b.2 param2) {}
  
  public final boolean acS()
  {
    AppMethodBeat.i(18007);
    ab.i("MicroMsg.BakOldTempDbModel", "bakoldRecoverFromTempDb doInBackground start");
    ab.dsI();
    b.aVx();
    e.O(com.tencent.mm.plugin.backup.bakoldlogic.a.a.aUR(), true);
    a locala = this.jIW.jIT.aVt();
    locala.handler.post(new a.2(locala));
    ab.i("MicroMsg.BakOldTempDbModel", "bakoldRecoverFromTempDb doInBackground end");
    ab.dsI();
    AppMethodBeat.o(18007);
    return true;
  }
  
  public final boolean acT()
  {
    AppMethodBeat.i(18006);
    ab.i("MicroMsg.BakOldTempDbModel", "bakoldRecoverFromTempDb onPostExecute");
    this.jIW.jIV.run();
    com.tencent.mm.sdk.b.a.ymk.l(new qy());
    AppMethodBeat.o(18006);
    return false;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(18008);
    String str = super.toString() + "|bakoldRecoverFromTempDb";
    AppMethodBeat.o(18008);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.bakoldlogic.d.b.2.1
 * JD-Core Version:    0.7.0.1
 */