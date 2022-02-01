package com.tencent.mm.plugin.appbrand.appusage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.am;
import com.tencent.mm.platformtools.r.a;
import com.tencent.mm.plugin.appbrand.app.j;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.al.a;
import java.util.Locale;

public final class s
  extends am
{
  public final String getTag()
  {
    return "MicroMsg.AppBrandPluginCodeTransfer";
  }
  
  public final boolean op(int paramInt)
  {
    AppMethodBeat.i(44548);
    boolean bool = g.ajC().ajl().getBoolean(al.a.IvM, false);
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
      j.aYM().aYN().execSQL("AppBrandWxaPkgManifestRecord", str);
      g.ajC().ajl().set(al.a.IvM, Boolean.TRUE);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appusage.s
 * JD-Core Version:    0.7.0.1
 */