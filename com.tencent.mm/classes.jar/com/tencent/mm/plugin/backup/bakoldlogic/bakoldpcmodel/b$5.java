package com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel;

import android.os.Looper;
import com.tencent.mm.sdk.platformtools.ah;

final class b$5
  implements Runnable
{
  b$5(b paramb) {}
  
  public final void run()
  {
    Looper.prepare();
    b.a(this.hNG, new ah());
    Looper.loop();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.b.5
 * JD-Core Version:    0.7.0.1
 */