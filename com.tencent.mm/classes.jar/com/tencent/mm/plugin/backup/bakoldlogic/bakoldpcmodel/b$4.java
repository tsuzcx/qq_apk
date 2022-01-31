package com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import java.io.DataOutputStream;

final class b$4
  implements Runnable
{
  b$4(b paramb, byte[] paramArrayOfByte) {}
  
  public final void run()
  {
    AppMethodBeat.i(17810);
    try
    {
      synchronized (b.a(this.jHi))
      {
        b.b(this.jHi).write(this.bZW);
        b.b(this.jHi).flush();
        AppMethodBeat.o(17810);
        return;
      }
      return;
    }
    catch (Exception localException)
    {
      ab.e("MicroMsg.BakOldJavaEngine", "send_error %s", new Object[] { localException });
      b.c(this.jHi);
      b.a(this.jHi, 10008, "send_error ".concat(String.valueOf(localException)).getBytes());
      AppMethodBeat.o(17810);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.b.4
 * JD-Core Version:    0.7.0.1
 */