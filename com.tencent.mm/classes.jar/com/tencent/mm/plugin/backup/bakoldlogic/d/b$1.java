package com.tencent.mm.plugin.backup.bakoldlogic.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.aw;
import com.tencent.mm.pointers.PLong;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.al.a;
import com.tencent.mm.sdk.platformtools.bo;

final class b$1
  implements Runnable
{
  b$1(b paramb, long paramLong, b.a parama) {}
  
  public final void run()
  {
    AppMethodBeat.i(18005);
    g.RJ().QQ();
    ab.i("MicroMsg.BakOldTempDbModel", "initTempDB, initTempDBCount:%d  timediff:%d ", new Object[] { Integer.valueOf(b.access$000()), Long.valueOf(bo.hl(this.dZo)) });
    b.EU();
    aw.RO().a(new al.a()
    {
      public final boolean acS()
      {
        AppMethodBeat.i(18003);
        b.aVw();
        PLong localPLong1 = new PLong();
        PLong localPLong2 = new PLong();
        PLong localPLong3 = new PLong();
        b.a(b.1.this.jIT, localPLong1, localPLong2, localPLong3, b.1.this.jIS, b.1.this.jFL);
        AppMethodBeat.o(18003);
        return true;
      }
      
      public final boolean acT()
      {
        AppMethodBeat.i(18002);
        ab.i("MicroMsg.BakOldTempDbModel", "initTempDB onPostExecute");
        b.1.this.jIS.run();
        b.EV();
        AppMethodBeat.o(18002);
        return false;
      }
      
      public final String toString()
      {
        AppMethodBeat.i(18004);
        String str = super.toString() + "|initTempDB";
        AppMethodBeat.o(18004);
        return str;
      }
    });
    AppMethodBeat.o(18005);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.bakoldlogic.d.b.1
 * JD-Core Version:    0.7.0.1
 */