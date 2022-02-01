package com.tencent.mm.plugin.extqlauncher;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;

final class SubCoreExtQLauncher$2
  implements Runnable
{
  SubCoreExtQLauncher$2(SubCoreExtQLauncher paramSubCoreExtQLauncher) {}
  
  public final void run()
  {
    AppMethodBeat.i(24550);
    try
    {
      SubCoreExtQLauncher.a(this.zQT, System.currentTimeMillis());
      Log.e("MicroMsg.SubCoreExtQLauncher", "getInstalledApplications return null");
      SubCoreExtQLauncher.c(this.zQT);
      AppMethodBeat.o(24550);
      return;
    }
    catch (Exception localException)
    {
      Log.e("MicroMsg.SubCoreExtQLauncher", "exception in getApplicationInfo, %s", new Object[] { localException.getMessage() });
      SubCoreExtQLauncher.c(this.zQT);
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
 * Qualified Name:     com.tencent.mm.plugin.extqlauncher.SubCoreExtQLauncher.2
 * JD-Core Version:    0.7.0.1
 */