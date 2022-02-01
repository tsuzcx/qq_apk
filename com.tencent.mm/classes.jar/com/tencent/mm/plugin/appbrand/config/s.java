package com.tencent.mm.plugin.appbrand.config;

import android.content.Context;
import com.tencent.luggage.a.e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ac.p.a;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import kotlin.l;
import kotlin.n.n;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/config/MiniProgramUserAgentUtils;", "", "()V", "make", "", "context", "Landroid/content/Context;", "originalUserAgent", "luggage-wechat-full-sdk_release"})
public final class s
{
  public static final s oag;
  
  static
  {
    AppMethodBeat.i(244427);
    oag = new s();
    AppMethodBeat.o(244427);
  }
  
  public static final String Y(Context paramContext, String paramString)
  {
    AppMethodBeat.i(244426);
    Context localContext = paramContext;
    if (paramContext == null) {
      localContext = MMApplicationContext.getContext();
    }
    paramContext = paramString;
    if (paramString == null) {
      paramContext = "";
    }
    paramString = com.tencent.mm.plugin.appbrand.ac.p.a(localContext, paramContext, (p.a)e.K(p.a.class));
    kotlin.g.b.p.j(paramString, "ua");
    paramContext = paramString;
    if (!n.a((CharSequence)paramString, (CharSequence)"MiniProgramEnv/android", false)) {
      paramContext = paramString + " MiniProgramEnv/android";
    }
    kotlin.g.b.p.j(paramContext, "ua");
    AppMethodBeat.o(244426);
    return paramContext;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.config.s
 * JD-Core Version:    0.7.0.1
 */