package com.tencent.mm.plugin.appbrand.ui.privacy;

import com.tencent.luggage.l.g;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.b.aa;
import kotlin.g.b.ai;
import kotlin.g.b.z;
import kotlin.l.o;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/ui/privacy/AppBrandPrivacyDebugConfig;", "", "()V", "DEBUG", "", "getDEBUG$annotations", "getDEBUG", "()Z", "<set-?>", "enableMock", "getEnableMock", "setEnableMock", "(Z)V", "enableMock$delegate", "Lcom/tencent/luggage/util/LuggageMMKVProperty;", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
{
  private static final boolean DEBUG = false;
  public static final b uiA;
  public static final g uiB;
  
  static
  {
    AppMethodBeat.i(322737);
    aYe = new o[] { (o)ai.a((z)new aa(b.class, "enableMock", "getEnableMock()Z", 0)) };
    uiA = new b();
    uiB = new g(Boolean.FALSE);
    AppMethodBeat.o(322737);
  }
  
  public static boolean getDEBUG()
  {
    return DEBUG;
  }
  
  public final boolean cMs()
  {
    AppMethodBeat.i(322744);
    boolean bool = ((Boolean)uiB.a(this, aYe[0])).booleanValue();
    AppMethodBeat.o(322744);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.privacy.b
 * JD-Core Version:    0.7.0.1
 */