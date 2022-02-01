package com.tencent.mm.plugin.extqlauncher;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;

final class b$2
  implements Runnable
{
  b$2(b paramb) {}
  
  public final void run()
  {
    AppMethodBeat.i(24550);
    try
    {
      this.sOX.sOR = System.currentTimeMillis();
      Log.e("MicroMsg.SubCoreExtQLauncher", "getInstalledApplications return null");
      this.sOX.sOQ = false;
      AppMethodBeat.o(24550);
      return;
    }
    catch (Exception localException)
    {
      Log.e("MicroMsg.SubCoreExtQLauncher", "exception in getApplicationInfo, %s", new Object[] { localException.getMessage() });
      this.sOX.sOQ = false;
      AppMethodBeat.o(24550);
    }
  }
  
  public final String toString()
  {
    AppMethodBeat.i(24551);
    String str = super.toString() + "|isPluginInstall";
    AppMethodBeat.o(24551);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.extqlauncher.b.2
 * JD-Core Version:    0.7.0.1
 */