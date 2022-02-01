package com.tencent.mm.plugin.appbrand.appusage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.al;
import com.tencent.mm.platformtools.r.a;
import com.tencent.mm.plugin.appbrand.app.j;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.ae.a;
import java.util.Locale;

public final class s
  extends al
{
  public final String getTag()
  {
    return "MicroMsg.AppBrandPluginCodeTransfer";
  }
  
  public final boolean nb(int paramInt)
  {
    AppMethodBeat.i(44548);
    boolean bool = g.afB().afk().getBoolean(ae.a.FlF, false);
    ad.d("MicroMsg.AppBrandPluginCodeTransfer", "needTransfer doneIssue %b", new Object[] { Boolean.valueOf(bool) });
    if (!bool)
    {
      AppMethodBeat.o(44548);
      return true;
    }
    AppMethodBeat.o(44548);
    return false;
  }
  
  public final void transfer(int paramInt)
  {
    AppMethodBeat.i(44547);
    try
    {
      String str = String.format(Locale.US, "where %s like '%%$%s' or %s like '%%$%s'", new Object[] { "appId", "__WITHOUT_CODELIB__", "appId", "__CODELIB__" });
      str = String.format(Locale.US, "delete from %s %s", new Object[] { "AppBrandWxaPkgManifestRecord", str });
      j.aOz().aOA().execSQL("AppBrandWxaPkgManifestRecord", str);
      g.afB().afk().set(ae.a.FlF, Boolean.TRUE);
      AppMethodBeat.o(44547);
      return;
    }
    catch (Exception localException)
    {
      ad.printErrStackTrace("MicroMsg.AppBrandPluginCodeTransfer", localException, "transfer failed", new Object[0]);
      AppMethodBeat.o(44547);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appusage.s
 * JD-Core Version:    0.7.0.1
 */