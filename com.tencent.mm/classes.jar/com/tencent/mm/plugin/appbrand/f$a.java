package com.tencent.mm.plugin.appbrand;

import a.f.a.a;
import a.f.b.k;
import a.l;
import a.y;
import android.content.SharedPreferences.Editor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.as;
import com.tencent.xweb.WebView;
import org.xwalk.core.XWalkCoreWrapper;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"checkSaveXWebInstallState", "", "invoke"})
final class f$a
  extends k
  implements a<y>
{
  public static final a gPq;
  
  static
  {
    AppMethodBeat.i(143707);
    gPq = new a();
    AppMethodBeat.o(143707);
  }
  
  f$a()
  {
    super(0);
  }
  
  public static void ate()
  {
    AppMethodBeat.i(143706);
    if (WebView.isXWalk()) {
      as.eu("MicroMsg.AppBrandPersistentRuntimeConfig", 2).putBoolean("KEY_XWEB_INSTALLED", XWalkCoreWrapper.getInstance().hasFeature(2003)).commit();
    }
    AppMethodBeat.o(143706);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.f.a
 * JD-Core Version:    0.7.0.1
 */