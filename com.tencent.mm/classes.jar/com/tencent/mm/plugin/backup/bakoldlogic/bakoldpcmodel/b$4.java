package com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel;

import com.tencent.mm.sdk.platformtools.y;
import java.io.DataOutputStream;

final class b$4
  implements Runnable
{
  b$4(b paramb, byte[] paramArrayOfByte) {}
  
  public final void run()
  {
    try
    {
      synchronized (b.a(this.hNG))
      {
        b.b(this.hNG).write(this.bxU);
        b.b(this.hNG).flush();
        return;
      }
      return;
    }
    catch (Exception localException)
    {
      y.e("MicroMsg.BakOldJavaEngine", "send_error %s", new Object[] { localException });
      b.c(this.hNG);
      b.a(this.hNG, 10008, ("send_error " + localException).getBytes());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.b.4
 * JD-Core Version:    0.7.0.1
 */