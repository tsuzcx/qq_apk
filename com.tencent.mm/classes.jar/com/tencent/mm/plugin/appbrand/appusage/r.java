package com.tencent.mm.plugin.appbrand.appusage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.f;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.au;
import com.tencent.mm.platformtools.o.a;
import com.tencent.mm.plugin.appbrand.app.n;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import java.util.Locale;

public final class r
  extends au
{
  public final String getTag()
  {
    return "MicroMsg.AppBrandPluginCodeTransfer";
  }
  
  public final void vb(int paramInt)
  {
    AppMethodBeat.i(44547);
    try
    {
      String str = String.format(Locale.US, "where %s like '%%$%s' or %s like '%%$%s'", new Object[] { "appId", "__WITHOUT_CODELIB__", "appId", "__CODELIB__" });
      str = String.format(Locale.US, "delete from %s %s", new Object[] { "AppBrandWxaPkgManifestRecord", str });
      n.ceZ().cfa().execSQL("AppBrandWxaPkgManifestRecord", str);
      h.baE().ban().set(at.a.acNG, Boolean.TRUE);
      AppMethodBeat.o(44547);
      return;
    }
    catch (Exception localException)
    {
      Log.printErrStackTrace("MicroMsg.AppBrandPluginCodeTransfer", localException, "transfer failed", new Object[0]);
      AppMethodBeat.o(44547);
    }
  }
  
  public final boolean vc(int paramInt)
  {
    AppMethodBeat.i(44548);
    boolean bool = h.baE().ban().getBoolean(at.a.acNG, false);
    Log.d("MicroMsg.AppBrandPluginCodeTransfer", "needTransfer doneIssue %b", new Object[] { Boolean.valueOf(bool) });
    if (!bool)
    {
      AppMethodBeat.o(44548);
      return true;
    }
    AppMethodBeat.o(44548);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appusage.r
 * JD-Core Version:    0.7.0.1
 */